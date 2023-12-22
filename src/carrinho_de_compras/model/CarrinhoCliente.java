package carrinho_de_compras.model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCliente extends Carrinho {

    private List<String> produtosNoCarrinho;

    public CarrinhoCliente(String nome) {
        super(nome);
        this.produtosNoCarrinho = new ArrayList<>();
    }

    public List<String> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    public void adicionarProdutoNoCarrinho(String produto) {
        produtosNoCarrinho.add(produto);
    }

    public void removerProdutoDoCarrinho(String produto) {
        produtosNoCarrinho.remove(produto);
    }

    @Override
    public void visualizar() {
        super.visualizar();

        if (!produtosNoCarrinho.isEmpty()) {
            System.out.println("Produtos no Carrinho do Cliente:");
            for (String produto : produtosNoCarrinho) {
                System.out.println("- " + produto);
            }
        } else {
            System.out.println("Carrinho do cliente vazio.");
        }
    }
}
