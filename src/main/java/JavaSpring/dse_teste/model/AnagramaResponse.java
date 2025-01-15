package JavaSpring.dse_teste.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnagramaResponse {

    private String input;
    private List<String> anagramas;

}
