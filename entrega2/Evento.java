public class Evento{
    private String nome;
    private String dataInicio;
    private String dataFim;
    private String HorarioInicio;
    private String HorarioFim;
    private double valor;

    public Evento(String nome, String dataInicio, String dataFim, String HorarioInicio, String HorarioFim, double valor) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.HorarioInicio = HorarioInicio;
        this.HorarioFim = HorarioFim;
        this.valor = valor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHorarioInicio() {
        return this.HorarioInicio;
    }

    public void setHorarioInicio(String HorarioInicio) {
        this.HorarioInicio = HorarioInicio;
    }

    public String getHorarioFim() {
        return this.HorarioFim;
    }

    public void setHorarioFim(String HorarioFim) {
        this.HorarioFim = HorarioFim;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}