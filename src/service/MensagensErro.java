package service;

public class MensagensErro {
    public static void entidadeNaoEncontrada(String entidade, int id) {
        System.out.println(entidade + " com ID " + id + " não encontrada.");
    }

    public static void erroGenerico(String operacao) {
        System.out.println("Erro ao " + operacao + ". Tente novamente.");
    }
}