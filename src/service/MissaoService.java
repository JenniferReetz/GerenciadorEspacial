package service;

import model.Astronauta;
import model.Missao;
import model.MissaoExploracao;
import model.MissaoResgate;
import model.Nave;
import model.StatusMissao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MissaoService {
    private static final List<Missao> missoes = new ArrayList<>();
    private static int proximoId = 1;

    public static void adicionarMissao(String tipo, String nome, String objetivo, LocalDate data, StatusMissao status) {

//        Missao m = new Missao(proximoId++, nome, objetivo, data, status);
        Missao m = switch (tipo.toLowerCase()) {
            case "exploracao" -> new MissaoExploracao(proximoId++, nome, objetivo, data, status);
            case "resgate" -> new MissaoResgate(proximoId++, nome, objetivo, data, status);
            default -> new Missao(proximoId++, nome, objetivo, data, status);
        };

        missoes.add(m);
        System.out.println("Missão adicionada!");
    }

    public static void listarMissoes() {
        System.out.println("\n--- Lista de Missões ---");
        if (missoes.isEmpty()) {
            System.out.println("Nenhuma missão cadastrada no sistema.");
            return;
        }
        for (Missao m : missoes) {
            String nave = (m.getNave() != null) ? m.getNave().getNome() : "N/A";
            List<Astronauta> lista = m.getAstronautas();
            String astronautas = (lista == null || lista.isEmpty()) ? "N/A" :
                    lista.stream().map(Astronauta::getNome).reduce((a,b) -> a + ", " + b).orElse("N/A");

            System.out.println("ID: " + m.getId() + " | Nome: " + m.getNome() +
                    " | Tipo: " + m.getTipo() +
                    " | Status: " + m.getStatus() + " | Nave: " + nave +
                    " | Astronautas: " + astronautas);
            System.out.println("-----------------------------------");
        }
    }

    public static Missao buscarMissao(int id) {
        for (Missao m : missoes) {
            if (m.getId() == id) return m;
        }
        MensagensErro.entidadeNaoEncontrada("Missão", id);
        return null;
    }

    public static void associarNaveAMissao(int idMissao, int idNave) {
        Missao m = buscarMissao(idMissao);
        Nave n = NaveService.buscarNave(idNave);
        if (m != null && n != null) {
            m.setNave(n);
            System.out.println("Nave associada com sucesso!");
        } else {
            System.out.println("Não foi possível associar: dados inválidos.");
        }
    }

    public static void associarAstronautaAMissao(int idMissao, int idAstronauta) {
        Missao m = buscarMissao(idMissao);
        Astronauta a = AstronautaService.buscarAstronauta(idAstronauta);
        if (m != null && a != null) {
            m.getAstronautas().add(a);
            System.out.println("Astronauta associado com sucesso!");
        } else {
            System.out.println("Não foi possível associar astronauta.");
        }
    }

    public static void atualizarStatusMissao(int idMissao, StatusMissao novoStatus) {
        Missao m = buscarMissao(idMissao);
        if (m != null) {
            m.setStatus(novoStatus);
            System.out.println("Status atualizado com sucesso para: " + novoStatus);
        }
    }

    public static void removerMissao(int id) {
        boolean removido = missoes.removeIf(m -> m.getId() == id);
        if (removido) {
            System.out.println("Missão com ID " + id + " removida com sucesso!");
        } else {
            System.out.println("Missão não encontrada.");
        }
    }
    public static void buscarMissoesPorStatus(StatusMissao status) {
        System.out.println("\n--- Missões com status: " + status + " ---");
        boolean encontrou = false;
        for (Missao m : missoes) {
            if (m.getStatus() == status) {
                System.out.println(m);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma missão encontrada com este status.");
        }
    }

    public static void executarTeste1() {
        // Implementação será feita posteriormente conforme orientação do professor
        System.out.println("[Teste 1] Método executado com sucesso!");
    }
}