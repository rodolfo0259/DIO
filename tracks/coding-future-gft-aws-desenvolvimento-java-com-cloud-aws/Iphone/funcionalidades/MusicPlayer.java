package Iphone.funcionalidades;

public class MusicPlayer {

    public String musicaSelecionada;
    public String[] musicasDisponiveis;

    public void tocar() {
        System.out.println("Tocando música");
    }

    public void pausar() {
        System.out.println("Pausando música");
    }

    public void selecionarMusica() {
        System.out.println("Selecione a música para tocar");
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        // Exemplo de utilização dos métodos
        player.selecionarMusica();
        player.tocar();
        player.pausar();
    }
}
