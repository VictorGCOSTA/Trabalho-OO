import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        String nomeEstacionamento;
        ArrayList<Estacionamento> estacionamentos = new ArrayList<Estacionamento>();
        Estacionamento es = new Estacionamento("teste", 2, 3, "", "", 1, 1, 1, 1, 1, 1);
        estacionamentos.add(es);

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar estacionamento");
            System.out.println("2 - Incluir veiculo");
            System.out.println("3 - Ler registros");
            System.out.println("4 - Atualizar registro");
            System.out.println("5 - Deletar registro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do estacionamento");
                    nomeEstacionamento = scanner.next();
                    System.out.println("Digite a quantidade de vagas totais:");
                    int vagasTotais = scanner.nextInt();
                    System.out.println("Digite a porcentagem do contratante:");
                    double porcentagemContratante = scanner.nextDouble();
                    System.out.println("Digite o horario de funcionamento:");
                    String horarioFuncionamento = scanner.next();
                    System.out.println("Digite o horario de periodo noturno: ");
                    String horarioPeriodoNoturno = scanner.next();
                    System.out.println("Digite o valor da fracao:");
                    double valorFracao = scanner.nextDouble();
                    System.out.println("Digite o valor por hora:");
                    double valorHora = scanner.nextDouble();
                    System.out.println("Digite o valor da diurna:");
                    double valorDiurna = scanner.nextDouble();
                    System.out.println("Digite o valor da noturna:");
                    double valorNoturna = scanner.nextDouble();
                    System.out.println("Digite o valor mensalista:");
                    double valorMensalista = scanner.nextDouble();
                    System.out.println("Digite o valor evento:");
                    double valorEvento = scanner.nextDouble();

                    Estacionamento estaci = new Estacionamento(nomeEstacionamento, vagasTotais,
                            porcentagemContratante, horarioFuncionamento, horarioPeriodoNoturno,
                            valorFracao, valorHora, valorDiurna, valorNoturna, valorMensalista, valorEvento);
                    estacionamentos.add(estaci);
                    System.out.println("Estacionamento criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome do estacionamento em que deseja incluir");
                    nomeEstacionamento = scanner.next();
                    Estacionamento estacionamentoEncontrado = null;
                    for (Estacionamento estacionamento : estacionamentos) {
                        if (estacionamento.getNome().equals(nomeEstacionamento)) {
                            estacionamentoEncontrado = estacionamento;
                            break;
                        }
                    }
                    if (estacionamentoEncontrado != null) {
                        System.out.println("Digite a placa do veículo");
                        String placa = scanner.next();
                        System.out.println("Digite o horario de entrada");
                        String horarioEntrada = scanner.next();
                        System.out.println("Digite a data de entrada");
                        String dataEntrada = scanner.next();
                        System.out.println("O veículo está em um evento?");
                        System.out.println("Digite 's' para sim e 'n' para não");
                        boolean evento = scanner.next().equals("s");
                        boolean veiculoIncluido = estacionamentoEncontrado.incluirVeiculo(placa, horarioEntrada,
                                dataEntrada, evento);
                        if (veiculoIncluido) {
                            System.out.println("Veículo incluído com sucesso!");
                        } else {
                            System.out.println("Não foi possível incluir o veículo.");
                        }
                        estacionamentoEncontrado.verVeiculos();
                    } else {
                        System.out.println("Estacionamento não encontrado.");
                    }
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

}
