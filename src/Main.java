/**
 * Programa que obtém um valor em binário e sua quantidade de bits, e retorna seu valor em decimal sem sinal, decimal em com7plemento de 2 e, caso tenha 8 bits ou menos, o caractere que representa no UTF-8
 *
 * @author Suzan Stockey Pereira, Bruno Rosa Duarte e Carolina Brose
 * @version 14102022
 */

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(System.in);

        String continuar = "S";

        while (!"N".equalsIgnoreCase(continuar)) {
            while (!"S".equalsIgnoreCase(continuar)) {
                System.out.println("Deseja continuar?(S/N)");
                continuar = in.next();
                if ("N".equalsIgnoreCase(continuar)) {
                    return;
                }
            }
            System.out.println("Informe o valor em binário: ");
            Binary binario = new Binary();
            binario.setValue(in.next());
            System.out.println("Informe o número de bits: ");
            binario.setBits(in.nextInt());

            if (binario.getValue().length() > binario.getBits()) {
                System.out.println("O binário excede o número de bits informado.");
            } else if (binario.isBinary()) {
                System.out.printf("Valor em decimal sem sinal: %s\n", binario.valueDecimalNoSignal());
                System.out.printf("Valor em complemento de 2: %s\n", binario.valueDecimal2Complement());
                if (binario.getBits() < 9) {
                    System.out.printf("Caractere representado: %s\n", binario.character());
                }
            } else {
                System.out.println("O valor informado não é um binário.");
            }
            System.out.println("Deseja continuar?(S/N)");
            continuar = in.next();
        }
    }
}
