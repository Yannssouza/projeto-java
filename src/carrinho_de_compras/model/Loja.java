package carrinho_de_compras.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Loja {
    private static List<String> produtosDisponiveis;

    public Loja() {
        produtosDisponiveis = new ArrayList<>();
    }

    public void adicionarProdutoDisponivel(String produto) {
        produtosDisponiveis.add(produto);
    }

    public static void visualizarProdutosDisponiveis() {
        System.out.println("\n\n***********************************************************");
        System.out.println("Produtos Disponíveis na Loja Supremo:");
        System.out.println("***********************************************************");

        if (!produtosDisponiveis.isEmpty()) {
            for (String produto : produtosDisponiveis) {
                System.out.println("- " + produto);
            }
        } else {
            System.out.println("Nenhum produto disponível na loja.");
        }
    }
}