package collectionsList.ExercicioProposto1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*Faça um programa que receba a temperatura média dos 6 primeiros meses 
do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<Double>();

        double soma = 0.0;
        for (int i = 1; i <= 6; i++) {
            System.out.print("Qual a temperatura do mês " + i + ": ");
            double temp = scan.nextDouble();
            temperaturas.add(temp);
            soma += temp;
        }
        System.out.println("----------------------------------------------------");
        System.out.println("");
        // exibindo todas as temperaturas:
        System.out.println("Temperaturas : " + temperaturas.toString());
        System.out.println("\n----------------------------------------------------");
        System.out.print("Todas as temperaturas: ");
        temperaturas.forEach(t -> System.out.print(t + " "));

        // calculando a média de 2 jeitos:

        double media = soma / temperaturas.size();
        System.out.println("A média semestral é: " + media);

        System.out.println("\n----------------------------------------------------");
        System.out.println("");
        media = temperaturas.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);
        System.out.printf("\nMédia das temperaturas: %.1f\n", media);

        // exibindo as temperaturas acima da média
        /*
         * System.out.println("Exibindo as temperaturas acima da média = " + media);
         * Iterator<Double> iterator1 = temperaturas.iterator();
         * while (iterator1.hasNext()) {
         * Double next = iterator1.next();
         * if (next > media)
         * System.out.println(next);
         * }
         */
        System.out.println("----------------------------------------------------");
        System.out.println("");

        // exibindo as temperaturas acima da média
        System.out.print("Temperaturas acima da média: ");
        temperaturas.stream()
                .filter(t -> t > media)
                .forEach(t -> System.out.printf("%.1f ", t));

        // exibindo as temperaturas acima da média junto com o mês
        System.out.println("\n----------------------------------------------------");
        System.out.println("Exibindo as temperaturas acima da média junto com o mês");
        Iterator<Double> iterator2 = temperaturas.iterator();
        int count = 0;
        while (iterator2.hasNext()) {
            Double next = iterator2.next();
            if (next > media) {
                switch (count) {
                    case (0):
                        System.out.printf("\n1 - Janeiro: %.1f", next);
                        break;
                    case (1):
                        System.out.printf("\n2 - Fevereiro: %.1f", next);
                        break;
                    case (2):
                        System.out.printf("\n3 - Março: %.1f", next);
                        break;
                    case (3):
                        System.out.printf("\n4 - Abril: %.1f", next);
                        break;
                    case (4):
                        System.out.printf("\n5 - Maio: %.1f", next);
                        break;
                    case (5):
                        System.out.printf("\n6 - Junho: %.1f", next);
                        break;
                    default:
                        System.out.println("\nNão houve temperatura acima da média");

                }
            }
            count++;

        }

        scan.close();

    }

}
