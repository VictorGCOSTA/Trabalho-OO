package Acessos;

import java.util.Scanner;

public class AcessoFracao extends Acesso{
     @Override
    public float pagar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor da fracao");
        int fr = sc.nextInt();
        System.out.println("Digite a quantidade de fracoes que o carro ficou no estacionamento");
        return sc.nextFloat() *fr;
    }
    
}
