//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Astronauta;
import model.Missao;
import model.Nave;
import model.StatusMissao;
import service.AstronautaService;
import service.ConversorService;
import service.MissaoService;
import service.NaveService;

public class GerenciadorExploracaoEspacial {
    private static List<Missao> missoes = new ArrayList();
    private static List<Nave> naves = new ArrayList();
    private static List<Astronauta> astronautas = new ArrayList();
    private static int proximoIdMissao = 1;
    private static int proximoIdNave = 1;
    private static int proximoIdAstronauta = 1;

    public GerenciadorExploracaoEspacial() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MissaoService.adicionarMissao("Missão Marte", "Explorar a superfície de Marte", LocalDate.of(2025, 1, 15), StatusMissao.PLANEJADA);
        NaveService.adicionarNave("Discovery One", "Exploração", (double)5.0F);
        AstronautaService.adicionarAstronauta("Neil Armstrong", "Comandante");
        AstronautaService.adicionarAstronauta("Buzz Aldrin", "Piloto");

        int opcao;
        do {
            System.out.println("\n--- Sistema de Gerenciamento de Exploração Espacial ---");
            System.out.println("1. Adicionar Missão");
            System.out.println("2. Adicionar Nave Espacial");
            System.out.println("3. Adicionar Astronauta");
            System.out.println("4. Listar Missões");
            System.out.println("5. Listar Naves");
            System.out.println("6. Listar Astronautas");
            System.out.println("7. Associar Nave a Missão");
            System.out.println("8. Associar Astronauta a Missão");
            System.out.println("9. Atualizar Status da Missão");
            System.out.println("10. Buscar Missão por Id");
            System.out.println("11. Remover Missão");
            System.out.println("12. Buscar Missões por Status");
            System.out.println("13. Executar Teste1");
            System.out.println("14. Demonstração de Polimorfismo (Extra)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while(!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número.");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                case 1:
                    System.out.print("Nome da Missão: ");
                    String nomeMissao = scanner.nextLine();
                    System.out.print("Objetivo da Missão: ");
                    String objetivoMissao = scanner.nextLine();
                    System.out.print("Data de Lançamento (AAAA-MM-DD): ");
                    LocalDate dataLancamento = ConversorService.converterData(scanner.nextLine());
                    if (dataLancamento == null) {
                        System.out.println("Missão não criada.");
                    } else {
                        System.out.print("Status (Planejada, Em Andamento, Concluída, Cancelada): ");
                        StatusMissao statusMissao = ConversorService.converterStatus(scanner.nextLine());
                        if (statusMissao == null) {
                            System.out.println("Missão não criada devido a status inválido.");
                        } else {
                            MissaoService.adicionarMissao(nomeMissao, objetivoMissao, dataLancamento, statusMissao);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nome da Nave: ");
                    String nomeNave = scanner.nextLine();
                    System.out.print("Tipo da Nave: ");
                    String tipoNave = scanner.nextLine();
                    System.out.print("Capacidade da Nave: ");
                    double capacidadeNave = scanner.nextDouble();
                    scanner.nextLine();
                    NaveService.adicionarNave(nomeNave, tipoNave, capacidadeNave);
                    break;
                case 3:
                    System.out.print("Nome do Astronauta: ");
                    String nomeAstronauta = scanner.nextLine();
                    System.out.print("Especialidade do Astronauta: ");
                    String especialidadeAstronauta = scanner.nextLine();
                    AstronautaService.adicionarAstronauta(nomeAstronauta, especialidadeAstronauta);
                    break;
                case 4:
                    MissaoService.listarMissoes();
                    break;
                case 5:
                    NaveService.listarNaves();
                    break;
                case 6:
                    AstronautaService.listarAstronautas();
                    break;
                case 7:
                    System.out.print("ID da Missão para associar nave: ");
                    int idMissaoAssocNave = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID da Nave para associar: ");
                    int idNaveAssoc = scanner.nextInt();
                    scanner.nextLine();
                    MissaoService.associarNaveAMissao(idMissaoAssocNave, idNaveAssoc);
                    break;
                case 8:
                    System.out.print("ID da Missão para associar astronauta: ");
                    int idMissaoAssocAstronauta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID do Astronauta para associar: ");
                    int idAstronautaAssoc = scanner.nextInt();
                    scanner.nextLine();
                    MissaoService.associarAstronautaAMissao(idMissaoAssocAstronauta, idAstronautaAssoc);
                    break;
                case 9:
                    System.out.print("ID da Missão para atualizar status: ");
                    int idMissaoAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo Status (Planejada, Em Andamento, Concluída, Cancelada): ");
                    StatusMissao novoStatus = ConversorService.converterStatus(scanner.nextLine());
                    if (novoStatus != null) {
                        MissaoService.atualizarStatusMissao(idMissaoAtualizar, novoStatus);
                    } else {
                        System.out.println("Status inválido.");
                    }
                    break;
                case 10:
                    System.out.print("ID da Missão para buscar: ");
                    int idMissaoBuscar = scanner.nextInt();
                    scanner.nextLine();
                    Missao m = MissaoService.buscarMissao(idMissaoBuscar);
                    if (m != null) {
                        System.out.println(m);
                    }
                    break;
                case 11:
                    System.out.print("ID da Missão para remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    MissaoService.removerMissao(idRemover);
                    break;
                case 12:
                    System.out.print("Status para filtrar (Planejada, Em Andamento, Concluída, Cancelada): ");
                    StatusMissao filtroStatus = ConversorService.converterStatus(scanner.nextLine());
                    if (filtroStatus != null) {
                        MissaoService.buscarMissoesPorStatus(filtroStatus);
                    } else {
                        System.out.println("Status inválido.");
                    }
                    break;
                case 13:
                    System.out.println("\n--- Executando Teste 1 ---");
                    MissaoService.executarTeste1();
                    break;
                case 14:
                    MissaoService.demonstrarPolimorfismo();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(opcao != 0);

        scanner.close();
    }
}
