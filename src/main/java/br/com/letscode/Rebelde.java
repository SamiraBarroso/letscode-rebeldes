package br.com.letscode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Rebelde {
    private String nome;
    private int idade;
    private Raca raca;
}
