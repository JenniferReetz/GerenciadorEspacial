package service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import model.StatusMissao;

public class ConversorService {
    public ConversorService() {
    }

    public static StatusMissao converterStatus(String input) {
        if (input == null) {
            return null;
        } else {
            switch (input.trim().toLowerCase()) {
                case "planejada":
                    return StatusMissao.PLANEJADA;
                case "em andamento":
                    return StatusMissao.EM_ANDAMENTO;
                case "concluida":
                    return StatusMissao.CONCLUIDA;
                case "cancelada":
                    return StatusMissao.CANCELADA;
                default:
                    try {
                        return StatusMissao.valueOf(input.toUpperCase().replace(" ", "_"));
                    } catch (IllegalArgumentException var4) {
                        return null;
                    }
            }
        }
    }
    public static String converterTipoMissao(String input) {
        if (input == null) return null;

        switch (input.trim().toLowerCase()) {
            case "padrao":
            case "padrão":
                return "padrao";

            case "exploracao":
            case "exploração":
                return "exploracao";

            case "resgate":
                return "resgate";

            default:
                System.out.println("Use: padrao, exploracao ou resgate.");
                return null;
        }
    }
    public static LocalDate converterData(String input) {
        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException var2) {
            System.out.println("Data inválida! Use o formato AAAA-MM-DD.");
            return null;
        }
    }
}
