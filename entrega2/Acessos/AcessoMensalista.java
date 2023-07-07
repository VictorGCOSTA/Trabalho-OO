package Acessos;

public class AcessoMensalista extends Acesso {

    @Override
    public float pagar(){
        System.out.println("Acesso do tipo mensalista");
        return 0;
    };
}
