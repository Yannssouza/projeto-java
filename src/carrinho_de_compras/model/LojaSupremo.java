package carrinho_de_compras.model;

public class LojaSupremo extends Loja {

    public LojaSupremo() {
        super();
        adicionarProdutosIniciais();
    }

    private void adicionarProdutosIniciais() {
        adicionarProdutoDisponivel("Camisa");
        adicionarProdutoDisponivel("Calça");
        adicionarProdutoDisponivel("Sapato");
    }
}
