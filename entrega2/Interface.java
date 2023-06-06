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
                    System.out.println("Digite o nome do estacionament");
                    nomeEstacionamento = scanner.next();
                    System.out.println("Digite a quantidade de vagas totais:");
                    Int vagasTotais = scanner.nextInt();
                    System.out.println("Digite a porcentagem do contrante:");
                    System.out.println("Digite o horario de funcionamento:");
                    System.out.println("Digite o horario de periodo noturno: ");
                    System.out.println("Digite o valor da fracao:");
                    System.out.println("Digite o valor por hora:");
                    System.out.println("Digite o valor da diurna:");
                    System.out.println("Digite o valor da naturna:");
                    System.out.println("Digite o valor mensalista:");
                    System.out.println("Digite o valor evento:");

                case 2:
                    System.out.println("Digite o nome do estacionamento em que deseja incluir");
                    nomeEstacionamento = scanner.next();
                    Estacionamento e;
                    for (Estacionamento estacionamento : estacionamentos) {
                        if (estacionamento.getNome().equals(nomeEstacionamento)) {
                            e = estacionamento;
                            System.out.println("Digite a placa do veículo");
                            String placa = scanner.next();
                            System.out.println("Digite o horario de entrada");
                            String horarioEntrada = scanner.next();
                            System.out.println("Digite a data de entrada");
                            String dataEntrada = scanner.next();
                            System.out.println("O veículo está em um evento?");
                            System.out.println("Digite 's' para sim e 'n' para não");
                            boolean evento = scanner.next().equals("s") ? true : false;
                            e.incluirVeiculo(placa, horarioEntrada, dataEntrada, evento);
                            e.verVeiculos();
                        }
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
