
package service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import model.Nave;

public class NaveService {
    private static final List<Nave> naves = new ArrayList<>();
    private static int proximoId = 1;

    public NaveService() {
    }

    public static void adicionarNave(String nome, String tipo, double capacidade) {
        Nave nave = new Nave(nome, tipo, capacidade);
        nave.setId(proximoId++);
        naves.add(nave);
        System.out.println("Nave adicionada!");
    }

    public static void listarNaves() {
        System.out.println("\n--- Lista de Naves ---");
        if (naves.isEmpty()) {
            System.out.println("Nenhuma nave cadastrada.");
        } else {
            for(Nave n : naves) {
                PrintStream var10000 = System.out;
                int var10001 = n.getId();
                var10000.println("ID: " + var10001 + " | Nome: " + n.getNome() + " | Tipo: " + n.getTipo() + " | Capacidade: " + n.getCapacidade());
            }

        }
    }

    public static Nave buscarNave(int id) {
        for(Nave n : naves) {
            if (n.getId() == id) {
                return n;
            }
        }

        return null;
    }
}
