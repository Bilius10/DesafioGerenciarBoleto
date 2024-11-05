package com.gerenciar.boletos.CONTROLLER;

import com.gerenciar.boletos.DAO.BoletoDAO;
import com.gerenciar.boletos.ENTITY.Boleto;
import com.gerenciar.boletos.EXCEPTION.RegraNegocioException;
import com.gerenciar.boletos.SERVICE.BoletoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/boleto")
@RestController
public class BoletoController {

    @Autowired
    private BoletoService boletoService;

    @GetMapping
    public ResponseEntity<List<Boleto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(boletoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findByid(@PathVariable Long id){
        Optional<Boleto> boletoById = boletoService.findById(id);

        if(boletoById.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(boletoById);
    }

    @PostMapping
    public ResponseEntity<Object> createBoleto(@RequestBody @Valid BoletoDAO boletoDAO) throws RegraNegocioException {
        Boleto boleto = new Boleto();

        BeanUtils.copyProperties(boletoDAO, boleto);
        boleto.setAtivo(boletoDAO.ativo() == 1);

        try {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(boletoService.createBoleto(boleto, boletoDAO.idUsuario()));
        }catch (RegraNegocioException r){
            return ResponseEntity.status(HttpStatus.OK).body(r.getMessage());
        }

    }

    @PutMapping("{valor}/{id}")
    public ResponseEntity<Object> pagarBoleto(@PathVariable double valor, @PathVariable Long id) throws RegraNegocioException {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(boletoService.pagarBoleto(valor, id));

        }catch (RegraNegocioException r){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(r.getMessage());

        }
    }



}
