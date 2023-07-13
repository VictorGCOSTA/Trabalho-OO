public class AlunoController {
    private Aluno aluno = new Aluno();

    public AlunoController() {
    }

    public AlunoController(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setNomeCompleto(String nomeCompleto) {
        aluno.setNomeCompleto(nomeCompleto);
    }

    public void setCurso(String curso) {
        aluno.setCurso(curso);
    }

    public void setMatricula(String matricula) {
        aluno.setMatricula(matricula);
    }

    public void setEmail(String email) {
        aluno.setEmail(email);
    }


    public Aluno getAluno(){
        return this.aluno;
    }
}

