public class Veiculo {
    private String placa;
    private String horarioEntrada;
    private String horarioSaida;
    private String dataSaida;
    private String dataEntrada;
    private boolean evento;
    private double valorPago;



    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHorarioEntrada() {
        return this.horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return this.horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getDataSaida() {
        return this.dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataEntrada() {
        return this.dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public boolean isEvento() {
        return this.evento;
    }

    public boolean getEvento() {
        return this.evento;
    }

    public void setEvento(boolean evento) {
        this.evento = evento;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}