package carrinho_de_compras.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Carrinho {

    private String nome;
    private List<String> produtos;

    public Carrinho(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarProduto(String produto) {
        produtos.add(produto);
    }

    public void visualizar() {
        System.out.println("\n\n***********************************************************");
        System.out.println("Dados do Carrinho:");
        System.out.println("***********************************************************");
        System.out.println("Nome: " + this.nome);

        if (!produtos.isEmpty()) {
            System.out.println("Produtos no Carrinho:");
            for (String produto : produtos) {
                System.out.println("- " + produto);
            }
        } else {
            System.out.println("Carrinho vazio.");
        }
    }
}