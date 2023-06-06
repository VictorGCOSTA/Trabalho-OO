import java.util.ArrayList;

public class Estacionamento {
    private String nome;
    private int vagasOcupadas;
    private int vagasTotais;
    private double porcentagemContratante;
    private double lucro;
    private String horarioFuncionamento;
    private String horarioPeriodoNoturno;
    private double valorFracao;
    private double valorHora;
    private double valorDiurna;
    private double valorNoturna;
    private double valorMensalista;
    private double valorEvento;
    private ArrayList<Veiculo> veiculos = new ArrayList<>(); 

    public int calcularValorASerPago(){
        return 0;
    }

    public int verificaVagasDisponiveis(){
        return this.vagasTotais-this.vagasOcupadas;
    }

    public boolean incluirVeiculo(String placa, String horarioEntrada, String dataEntrada, boolean evento){
        Veiculo v = new Veiculo(placa, horarioEntrada, dataEntrada, evento);

        if(this.vagasTotais == this.vagasOcupadas){
            return false;
        }
        for(Veiculo veiculo:veiculos){
            if (veiculo.getPlaca() == v.getPlaca()){
                return false;
            }
        }
        veiculos.add(v);
        return true;
    }

    public void retirarVeiculo(){

    }

    public double calcularRetornoContratante(){
        return this.lucro*this.porcentagemContratante;
    }
    public void verVeiculos(){
        for(Veiculo v : veiculos){
            System.out.println(v);
        }
    }
    public int getVagasTotais() {
        return this.vagasTotais;
    }

    public void setVagasTotais(int vagasTotais) {
        this.vagasTotais = vagasTotais;
    }

    public int getVagasOcupadas() {
        return this.vagasOcupadas;
    }

    public void setVagasOcupadas(int vagasOcupadas) {
        this.vagasOcupadas = vagasOcupadas;
    }

    public double getPorcentagemContratante() {
        return this.porcentagemContratante;
    }

    public void setPorcentagemContratante(double porcentagemContratante) {
        this.porcentagemContratante = porcentagemContratante;
    }

    public double getLucro() {
        return this.lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public String getHorarioFuncionamento() {
        return this.horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getHorarioPeriodoNoturno() {
        return this.horarioPeriodoNoturno;
    }

    public void setHorarioPeriodoNoturno(String horarioPeriodoNoturno) {
        this.horarioPeriodoNoturno = horarioPeriodoNoturno;
    }

    public double getValorFracao() {
        return this.valorFracao;
    }

    public void setValorFracao(double valorFracao) {
        this.valorFracao = valorFracao;
    }

    public double getValorHora() {
        return this.valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getValorDiurna() {
        return this.valorDiurna;
    }

    public void setValorDiurna(double valorDiurna) {
        this.valorDiurna = valorDiurna;
    }

    public double getValorNoturna() {
        return this.valorNoturna;
    }

    public void setValorNoturna(double valorNoturna) {
        this.valorNoturna = valorNoturna;
    }

    public double getValorMensalista() {
        return this.valorMensalista;
    }

    public void setValorMensalista(double valorMensalista) {
        this.valorMensalista = valorMensalista;
    }

    public double getValorEvento() {
        return this.valorEvento;
    }

    public void setValorEvento(double valorEvento) {
        this.valorEvento = valorEvento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public Estacionamento(String nome, int vagasTotais, double porcentagemContratante, String horarioFuncionamento, String horarioPeriodoNoturno, double valorFracao, double valorHora, double valorDiurna, double valorNoturna, double valorMensalista, double valorEvento) {
        this.nome = nome;
        this.vagasTotais = vagasTotais;
        this.porcentagemContratante = porcentagemContratante;
        this.horarioFuncionamento = horarioFuncionamento;
        this.horarioPeriodoNoturno = horarioPeriodoNoturno;
        this.valorFracao = valorFracao;
        this.valorHora = valorHora;
        this.valorDiurna = valorDiurna;
        this.valorNoturna = valorNoturna;
        this.valorMensalista = valorMensalista;
        this.valorEvento = valorEvento;
    }
}