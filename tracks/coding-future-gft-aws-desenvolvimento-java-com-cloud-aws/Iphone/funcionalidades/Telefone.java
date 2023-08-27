package Iphone.funcionalidades;

public class Telefone {

    public String[] contatos;

    public void ligar() {
        System.out.println("Ligando para contato...");
    }

    public void atender() {
        System.out.println("Atender Ligação");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando Correio de Voz...");
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        Telefone telefone = new Telefone();

        // Exemplo de utilização dos métodos
        telefone.ligar();
        telefone.atender();
        telefone.iniciarCorreioVoz();
    }
}
