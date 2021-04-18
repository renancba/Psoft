package System;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        exibirMenu();
    }

    public static void exibirMenu() {
        SUSVac susvac = new SUSVac();

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("\nBem vindx ao Sistema de Vacinação SUSVac - Aqui sua vacinação está garantida xD ! \n"
                    + "\n(C)adastrar Pessoa\n"
                    + "(E)xibir dados de uma Pessoa\n"
                    + "(L)istar Pessoas\n"
                    + "(A)lterar dados de uma Pessoa\n"
                    + "(V)acinar uma Pessoa(alterar o estado de vacinação de uma Pessoa)\n"
                    + "(M)ostrar Status de  Vacinação\n"
                    + "(S)air\n"
                    + "Opção> ");
            String escolha = sc.nextLine().toUpperCase();

            switch (escolha) {

                case "C":
                    System.out.print("\nDigite o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("\nDigite o CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("\nDigite o telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("\nDigite o endereço: ");
                    String endereco = sc.nextLine();

                    System.out.print("\nDigite o email: ");
                    String email = sc.nextLine();

                    System.out.print("\nDigite o numero do cartão do SUS: ");
                    int numeroSus = sc.nextInt();
                    sc.nextLine();

                    System.out.print("\nDigite a profissão: ");
                    String profissao = sc.nextLine();

                    System.out.print("\nDigite as comorbidades(separadas por vírgula): ");
                    String comorbidades = sc.nextLine();

                    System.out.print("\nDigite o dia de nascimento(em número): ");
                    int diaNascimento = sc.nextInt();

                    System.out.print("\nDigite o mês de nascimento(em número): ");
                    int mesNascimento = sc.nextInt();

                    System.out.print("\nDigite o ano de nascimento(em número): ");
                    int anoNascimento = sc.nextInt();
                    sc.nextLine();

                    List<String> comorbidadesFormat = Arrays.asList(comorbidades.split(", "));
                    susvac.cadastraPessoa(nome, cpf, endereco, numeroSus, email, telefone, profissao, comorbidadesFormat, diaNascimento, mesNascimento, anoNascimento);
                    break;

                case "L":
                    System.out.println(susvac.listarPessoas());
                    break;

                case "E":
                    System.out.print("\nDigite o CPF: ");
                    String cpfPessoa = sc.nextLine();
                    System.out.println(susvac.exibirPessoa(cpfPessoa));
                    break;

                case "A":
                    System.out.print("\nDigite o CPF: ");
                    String cpfPessoa2 = sc.nextLine();
                    System.out.print("\nDigite uma das opções para alterar: \n"
                                        + "(N)ome\n"
                                        + "(E)ndereço\n"
                                        + "(S)Número SUS\n"
                                        + "(M)E-Mail\n"
                                        + "(T)elefone\n"
                                        + "(P)rofissão\n"
                                        + "(C)omorbidades\n"
                                        + "(D)ata de Nascimento\n"
                                        + "(F)echar\n"
                                        + "Opção> ");
                    String escolhaAlterar = sc.nextLine().toUpperCase();
                    switch (escolhaAlterar) {
                        case "N":
                            System.out.print("\nDigite o novo Nome: ");
                            String nomeNovo = sc.nextLine();
                            susvac.alterarNomePessoa(cpfPessoa2, nomeNovo);
                            break;
                        case "E":
                            System.out.print("\nDigite o novo Endereço: ");
                            String enderecoNovo = sc.nextLine();
                            susvac.alterarEndereco(cpfPessoa2, enderecoNovo);
                            break;
                        case "S":
                            System.out.print("\nDigite o novo Número do SUS: ");
                            int susNovo = sc.nextInt();
                            sc.nextLine();
                            susvac.alterarNumSUS(cpfPessoa2, susNovo);
                            break;
                        case "M":
                            System.out.print("\nDigite o novo E-Mail: ");
                            String emailNovo = sc.nextLine();
                            susvac.alterarEmail(cpfPessoa2, emailNovo);
                            break;
                        case "T":
                            System.out.print("\nDigite o novo Telefone: ");
                            String telefoneNovo = sc.nextLine();
                            susvac.alterarTelefone(cpfPessoa2, telefoneNovo);
                            break;
                        case "P":
                            System.out.print("\nDigite a nova Profissão: ");
                            String profissaoNova = sc.nextLine();
                            susvac.alterarProfissao(cpfPessoa2, profissaoNova);
                            break;
                        case "C":
                            System.out.print("\nDigite as novas Comorbidades(separadas por vírgulas): ");
                            String comorbidadesNovas = sc.nextLine();
                            List<String> comorbidadesNovasFormat = Arrays.asList(comorbidadesNovas.split(", "));
                            susvac.alterarComorbidades(cpfPessoa2, comorbidadesNovasFormat);
                            break;
                        case "D":
                            System.out.print("\nDigite o novo dia de nascimento(em número): ");
                            int diaNascimentoNovo = sc.nextInt();
                            System.out.print("\nDigite o novo mês de nascimento(em número): ");
                            int mesNascimentoNovo = sc.nextInt();
                            System.out.print("\nDigite o novo ano de nascimento(em número): ");
                            int anoNascimentoNovo = sc.nextInt();
                            LocalDateTime novaData = LocalDateTime.of(diaNascimentoNovo, mesNascimentoNovo, anoNascimentoNovo, 0, 0);
                            susvac.alterarNascimento(cpfPessoa2, novaData);
                            break;
                        case "F":
                            System.out.print("\n Alteração de dados cancelada! ");
                            break;
                        default:
                            System.out.print("\nCampo não preenchido Corretamente. Tente outra Opção!");
                            break;
                    }
                    break;

                case "V":
                    System.out.print("\nDigite o CPF: ");
                    String cpfVacina = sc.nextLine();
                    susvac.vacinar(cpfVacina);
                    break;

                case "M":
                    System.out.print("\nDigite o CPF: ");
                    String cpfStatus = sc.nextLine();
                    System.out.println(susvac.exibirEstado(cpfStatus));
                    break;

                case "S":
                    flag = false;
                    System.out.println("\nAplicação encerrada! Obrigadx por utilizar nossa ferramenta ;) !");
                    break;

                default:
                    System.out.println("\nCampo não preenchido Corretamente. Tente outra Opção!");
                    break;

            }
        }

    }
}
