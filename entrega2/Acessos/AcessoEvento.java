package Acessos;

import java.util.Scanner;

public class AcessoEvento extends Acesso{

    @Override
    public float pagar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor do evento");
        return sc.nextFloat();
    }
    
}
