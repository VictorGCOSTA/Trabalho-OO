package Excecoes;

public class DescricaoEmBrancoException extends Exception{
    public DescricaoEmBrancoException(){
        super("Descrição em branco");
    }
}