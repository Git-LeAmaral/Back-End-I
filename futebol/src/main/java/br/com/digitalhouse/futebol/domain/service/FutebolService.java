package br.com.digitalhouse.futebol.domain.service;

import br.com.digitalhouse.futebol.domain.entity.Futebol;
import br.com.digitalhouse.futebol.domain.repository.FutebolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FutebolService {

    private final FutebolRepository futebolRepository;

    @Autowired
    public FutebolService(FutebolRepository futebolRepository) {
        this.futebolRepository = futebolRepository;
    }


    public List<Futebol> buscarFutebolPorData(LocalDate data) {
        return futebolRepository.findByDataEventoIs(data);
    }

    public void criarFutebol(Futebol futebol) {
        futebolRepository.save(futebol);
    }

    public List<Futebol> buscandoComPrefixo(String prefixo) {
        return futebolRepository.findByNomeStartingWith(prefixo);
    }
}
