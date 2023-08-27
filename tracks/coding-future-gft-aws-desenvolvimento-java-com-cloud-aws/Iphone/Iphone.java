package Iphone;

import Iphone.funcionalidades.MusicPlayer;
import Iphone.funcionalidades.Navegador;
import Iphone.funcionalidades.Telefone;

public class Iphone {
    public static void main(String[] args) {
        // Exemplo de uso das funcionalidades
        MusicPlayer musicPlayer = new MusicPlayer();
        Navegador navegador = new Navegador();
        Telefone telefone = new Telefone();

        // Chamar métodos das funcionalidades
        musicPlayer.tocar();
        navegador.exibirPagina();
        telefone.ligar();
    }
}
