package Iphone.funcionalidades;

public class Navegador {

    public void exibirPagina() {
        System.out.println("Processo de exibir a página...");
    }

    public void adicionarNovaAba() {
        System.out.println("Nova aba adicionada");
    }

    public void atualizarPagina() {
        System.out.println("Recarregando... Página Recarregada!!");
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        Navegador navegador = new Navegador();

        // Exemplo de utilização dos métodos
        navegador.adicionarNovaAba();
        navegador.exibirPagina();
        navegador.atualizarPagina();
    }
}
