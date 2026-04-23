package screenfilmes.screenfilmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import screenfilmes.screenfilmes.Frase;
import screenfilmes.screenfilmes.dto.FraseDTO;
import screenfilmes.screenfilmes.repository.FraseRepository;
import screenfilmes.screenfilmes.service.FraseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FraseController {

    @Autowired
    private FraseRepository repository;

    @Autowired
    private FraseService servicos;

    @GetMapping("/frases")
    public List<FraseDTO> obterDados(){
        return repository.findAll()
                .stream()
                .map(s -> new FraseDTO(s.getTitulo(),s.getFrase(),s.getPersonagem(),s.getPoster()))
                .collect(Collectors.toList());
    }

    @GetMapping("/series/frases")
    public FraseDTO obterFraseAleatoria(){
        return servicos.obterFraseAleatoria();
    }

}
