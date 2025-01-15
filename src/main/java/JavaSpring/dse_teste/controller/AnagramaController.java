package JavaSpring.dse_teste.controller;

import JavaSpring.dse_teste.model.AnagramaResponse;
import JavaSpring.dse_teste.service.AnagramaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/anagramas")
@RequiredArgsConstructor // Lombok cria um construtor com todos os atributos obrigatórios
public class AnagramaController {

    private final AnagramaService anagramaService;

    @GetMapping
    public AnagramaResponse getAnagramas(@RequestParam String input) {
        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Input contém caracteres inválidos, A entrada deve conter apenas letras.");
        }
        List<String> anagramas = anagramaService.gerarAnagramas(input);
        return new AnagramaResponse(input, anagramas);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
