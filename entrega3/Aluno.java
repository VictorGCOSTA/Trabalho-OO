public class Aluno {
    private String nomeCompleto;
    private String curso;
    private String matricula;
    private String email;

    public Aluno(String nomeCompleto, String curso, String matricula, String email) {
        this.nomeCompleto = nomeCompleto;
        this.curso = curso;
        this.matricula = matricula;
        this.email = email;
    }

    // Getters e setters

    public Aluno() {
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}