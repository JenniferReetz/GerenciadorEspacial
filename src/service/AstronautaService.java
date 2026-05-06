package service;

import model.Astronauta;
import java.util.ArrayList;
import java.util.List;

public class AstronautaService {
    private static final List<Astronauta> astronautas = new ArrayList<>();
    private static int proximoId = 1;

    public static void adicionarAstronauta(String nome, String especialidade) {
        Astronauta a = new Astronauta(nome, especialidade);
        a.setId(proximoId++);
        astronautas.add(a);
        System.out.println("Astronauta adicionado!");
    }

    public static void listarAstronautas() {
        System.out.println("\n--- Lista de Astronautas ---");
        if (astronautas.isEmpty()) {
            System.out.println("Nenhum astronauta cadastrado.");
            return;
        }
        for (Astronauta a : astronautas) {
            System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() +
                    " | Especialidade: " + a.getEspecialidade());
        }
    }

    public static Astronauta buscarAstronauta(int id) {
        for (Astronauta a : astronautas) {
            if (a.getId() == id) return a;
        }
        return null;
    }
}