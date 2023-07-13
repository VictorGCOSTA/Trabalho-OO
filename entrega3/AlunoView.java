import java.util.Scanner;

public class AlunoView {
    private static Scanner scanner = new Scanner(System.in);
    static AlunoController alunoController = new AlunoController();
    public static void main(String[] args) {
        cadastrarAluno();
        int i;
        do{
            System.out.println("\nMenu:");
            System.out.println("0 - Sair");
            System.out.println("1 - Editar Dados do Aluno");
            System.out.println("2 - Exibir Detalhes do Aluno");
            System.out.print("Escolha uma opção: ");
            i = scanner.nextInt();
            switch(i){
                case 1:{
                    editarAluno();
                }
                case 2:{
                    exibirDetalhesAluno(alunoController.getAluno());
                }
            }
        }while(i != 0);
       
    }
    public static void exibirDetalhesAluno(Aluno aluno) {
        System.out.println("Detalhes do Aluno:");
        System.out.println("Nome completo: " + aluno.getNomeCompleto());
        System.out.println("Curso: " + aluno.getCurso());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Email: " + aluno.getEmail());
    }
    public static Aluno cadastrarAluno(){
        System.out.println("Cadastro de Aluno");
        System.out.print("Nome completo: ");
        String nomeCompleto = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Aluno aluno = new Aluno(nomeCompleto, curso, matricula, email);
        alunoController = new AlunoController(aluno);
        return aluno;
    }
    public static Aluno editarAluno(){
        System.out.println("editar de Aluno");
        System.out.print("Nome completo: ");
        String nomeCompleto = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Aluno aluno = new Aluno(nomeCompleto, curso, matricula, email);
        alunoController = new AlunoController(aluno);
        return aluno;
    }
}
