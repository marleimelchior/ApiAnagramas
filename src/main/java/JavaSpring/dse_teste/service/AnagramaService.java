package JavaSpring.dse_teste.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AnagramaService {

    // Método principal para gerar anagramas a partir de uma string de entrada
    public List<String> gerarAnagramas(String input) {

        if( input == null || input.isEmpty() ) {
            log.info("Input vazio ou nulo");
            throw new IllegalArgumentException("A entrada não pode estar vazia.");
        }

        if(!input.chars().allMatch(Character::isLetter)) {
            log.info("Input contém caracteres inválidos");
            throw new IllegalArgumentException("A entrada deve conter apenas letras.");
        }

        if (input.length() == 1) {
            log.info("Input contém apenas uma letra");
            throw new IllegalArgumentException("Insira mais de uma letra, por favor.");
        }

        List<String> result = new ArrayList<>();
        // Converte a string de entrada em um array de caracteres
        gerarPermutacoes(input.toCharArray(), 0, result);
        return result;
    }

    // Método recursivo para gerar permutações dos caracteres
    private void gerarPermutacoes(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            log.info("Adicionando anagrama: " + new String(chars));
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            gerarPermutacoes(chars, index + 1, result);
            swap(chars, index, i);
        }
    }


    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
