package Acessos;

import java.util.Scanner;

public class AcessoHora extends Acesso {
    @Override
    public float pagar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor da hora");
        int hr = sc.nextInt();
        System.out.println("Digite quantas horas o carro ficou no estacionamento");
        return sc.nextFloat() *hr;
    }
    
}
