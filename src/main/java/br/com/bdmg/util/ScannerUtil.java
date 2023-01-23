package br.com.bdmg.util;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public final class ScannerUtil {
    private static Scanner scanner = new Scanner(in);

    private ScannerUtil() {
    }

    public static int solicitarNumero(final String mensagem) {
        try {
            out.println("# " + mensagem);
            var numero = scanner.nextInt();
            scanner.nextLine();
            return numero;
        } catch (RuntimeException ex) {
            out.println("Digite apenas números");
            scanner.nextLine();
            return solicitarNumero(mensagem);
        }
    }

    public static double solicitarNumeroDecimal(final String mensagem) {
        try {
            out.println("# " + mensagem);
            var numero = scanner.nextDouble();
            scanner.nextLine();
            return numero;
        } catch (RuntimeException ex) {
            out.println("Digite apenas números");
            scanner.nextLine();
            return solicitarNumeroDecimal(mensagem);
        }
    }

    public static String solicitarTexto(final String mensagem) {
        out.println("# " + mensagem);
        var texto = scanner.nextLine();
        while (texto.trim().length() < 1) {
            out.println("# Parece que voce nao digitou nada, vamos tentar novamente");
            out.println("# " + mensagem);
            texto = scanner.nextLine();
        }

        return texto;
    }

    public static String solicitarDocumento() {
        out.println("# Digite o CPF(11 Digitos) ou CNPJ(14 Digitos): ");
        var documento = scanner.nextLine();
        while (documento.trim().length() != 11 && documento.trim().length() != 14) {
            out.println("# Documento invalido, vamos tentar novamente");
            out.println("# Digite o CPF(11 Digitos) ou CNPJ(14 Digitos): ");
            documento = scanner.nextLine();
        }

        return documento;
    }

    public static String solicitarCnpj() {
        out.println("# Digite o CNPJ(14 Digitos) da empresa: ");
        var documento = scanner.nextLine();
        while (documento.trim().length() != 14) {
            out.println("# Documento invalido, vamos tentar novamente");
            out.println("# Digite o CNPJ(14 Digitos): ");
            documento = scanner.nextLine();
        }

        return documento;
    }
}
