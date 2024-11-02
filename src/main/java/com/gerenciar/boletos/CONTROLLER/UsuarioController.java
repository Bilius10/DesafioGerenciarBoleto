package com.gerenciar.boletos.CONTROLLER;

import com.gerenciar.boletos.DAO.UsuarioDAO;
import com.gerenciar.boletos.ENTITY.Usuario;
import com.gerenciar.boletos.SERVICE.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findByid(@PathVariable Long id){
        Optional<Usuario> usuarioById = usuarioService.findById(id);

        if(usuarioById.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioById);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody @Valid UsuarioDAO usuarioDAO){
        Usuario usuario = new Usuario();

        BeanUtils.copyProperties(usuarioDAO, usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.createUsuario(usuario));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        Optional<Usuario> usuarioById = usuarioService.deleteById(id);

        if(usuarioById.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioById);
    }
}
