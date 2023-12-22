package carrinho_de_compras;

import carrinho_de_compras.model.CarrinhoCliente;
import carrinho_de_compras.model.LojaSupremo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static CarrinhoCliente carrinhoCliente;

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        int opcao;

        new LojaSupremo();
        carrinhoCliente = null;

        while (true) {

            exibirMenu();

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            switch (opcao) {
                case 1 -> criarCarrinho(leia);
                case 2 -> listarItensDoCarrinho();
                case 3 -> listarItensDaLoja();
                case 4 -> adicionarItensAoCarrinho(leia);
                case 5 -> removerItensDoCarrinho(leia);
                case 6 -> apagarCarrinho();
                case 7 -> encerrarPrograma();
                default -> {
                    System.out.println("Opção Inválida\n\n");
                    keyPress();
                }
            }
        }
    }

    private static void exibirMenu() {
        System.out.println(
                "*****************************************************");
        System.out.println("                                                     ");
        System.out.println("                       Supremo                       ");
        System.out.println("                                                     ");
        System.out.println("*****************************************************");
        System.out.println("                                                     ");
        System.out.println("            1 - Criar Carrinho                       ");
        System.out.println("            2 - Listar Itens do Carrinho             ");
        System.out.println("            3 - Listar Itens da Loja                 ");
        System.out.println("            4 - Adicionar Itens ao Carrinho          ");
        System.out.println("            5 - Remover Itens do Carrinho            ");
        System.out.println("            6 - Apagar Carrinho                      ");
        System.out.println("            7 - Sair                                 ");
        System.out.println("                                                     ");
        System.out.println("*****************************************************");
        System.out.println("Entre com a opção desejada:                          ");
        System.out.println("                                                     ");
    }

    private static void criarCarrinho(Scanner leia) {
        System.out.println("Criar Carrinho\n\n");

        System.out.println("Digite o seu Nome: ");
        leia.skip("\\R?");
        String nome = leia.nextLine();

        carrinhoCliente = new CarrinhoCliente(nome);
        System.out.println("Carrinho criado para " + nome);
        keyPress();
    }

    private static void listarItensDoCarrinho() {
        System.out.println("Listar Itens do Carrinho\n\n");

        if (carrinhoCliente != null) {
            carrinhoCliente.visualizar();
        } else {
            System.out.println("Carrinho ainda não foi criado.");
        }

        keyPress();
    }

    private static void listarItensDaLoja() {
        System.out.println("Listar Itens da Loja\n\n");

        LojaSupremo.visualizarProdutosDisponiveis();

        keyPress();
    }

    private static void adicionarItensAoCarrinho(Scanner leia) {
        System.out.println("Adicionar Itens ao Carrinho\n\n");

        if (carrinhoCliente != null) {
            System.out.println("Digite o nome do produto a ser adicionado:");
            String produto = leia.next();
            carrinhoCliente.adicionarProdutoNoCarrinho(produto);
            System.out.println("Produto adicionado ao carrinho.");
        } else {
            System.out.println("Carrinho ainda não foi criado.");
        }

        keyPress();
    }

    private static void removerItensDoCarrinho(Scanner leia) {
        System.out.println("Remover Itens ao Carrinho\n\n");

        if (carrinhoCliente != null && !carrinhoCliente.getProdutosNoCarrinho().isEmpty()) {
            System.out.println("Digite o nome do produto a ser removido:");
            String produto = leia.next();
            carrinhoCliente.removerProdutoDoCarrinho(produto);
            System.out.println("Produto removido do carrinho.");
        } else {
            System.out.println("Carrinho está vazio ou ainda não foi criado.");
        }

        keyPress();
    }

    private static void apagarCarrinho() {
        System.out.println("Apagar Carrinho\n\n");

        carrinhoCliente = null;
        System.out.println("Carrinho apagado.");
        keyPress();
    }

    private static void encerrarPrograma() {
        System.out.println("\nLoja Supremo");
        sobre();
        System.exit(0);
    }

    private static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Yann");
        System.out.println("github.com/Yannssouza");
        System.out.println("*********************************************************");
    }

    private static void keyPress() {
        try {
            System.out.println("\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
