package com.gerenciar.boletos.SERVICE;

import com.gerenciar.boletos.ENTITY.Boleto;
import com.gerenciar.boletos.ENTITY.Usuario;
import com.gerenciar.boletos.EXCEPTION.RegraNegocioException;
import com.gerenciar.boletos.REPOSITORY.BoletoRepository;
import com.gerenciar.boletos.REPOSITORY.UsuarioRepository;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Boleto> findAll(){
        return boletoRepository.findAll();
    }

    public Optional<Boleto> findById(Long id){
        return boletoRepository.findById(id);
    }

    public Boleto createBoleto(Boleto boleto, long idUsuario) throws RegraNegocioException {

        Optional<Usuario> byId = usuarioRepository.findById(idUsuario);

        if(byId.isEmpty()){
            throw new RegraNegocioException("Usuario não existe");
        }
        boleto.setUsuario(byId.get());

        LocalDateTime localDateTime = LocalDateTime.now();
        if(localDateTime.isAfter(boleto.getDataCriacao()) || localDateTime.isAfter(boleto.getDataVencimento())){
            throw new RegraNegocioException("Data da criação ou data do vencimento ja passou");

        }

        return boletoRepository.save(boleto);

    }
}
