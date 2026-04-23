package screenfilmes.screenfilmes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import screenfilmes.screenfilmes.Frase;
import screenfilmes.screenfilmes.dto.FraseDTO;
import screenfilmes.screenfilmes.repository.FraseRepository;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repositorio;

    public FraseDTO obterFraseAleatoria() {
        Frase frase = repositorio.buscarFraseAleatoria();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }
}