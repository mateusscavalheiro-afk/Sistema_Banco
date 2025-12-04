import java.util.Scanner;
import java.util.Random;
@SuppressWarnings("all")

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String proprietario;
    private int saldo;
    private boolean status;

    //métodos construtores
    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }


    //métodos especiais

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    //métodos personalizados

    public void abrir_conta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1 teclada\n");
        if (this.isStatus() == true) {
            System.out.println("Não é possível abrir a conta pois já há uma conta aberta. ");
        } else {
            this.status = false;
            System.out.println("Insira seu nome: ");
            this.setProprietario(scanner.next());
            Random random = new Random();
            final int min_id = 100000000;
            final int max_id = 999999999;
            int range = (max_id - min_id) + 1;
            this.numConta = random.nextInt(range) + min_id;
            System.out.println("Seu número de conta é: " + this.numConta);
            System.out.println("Selecione qual o tipo de conta você deseja abrir:\n");
            System.out.println("1. Abrir uma conta poupança \n2. Abrir uma conta corrente \n");
            scanner.nextLine();
            if (scanner.nextLine().equals("1")) {
                System.out.println("Selecionada conta poupança");
                this.setTipo("Poupança");
            } else if (scanner.nextLine().equals("2")) {
                System.out.println("Selecionada conta corrente");
                this.setTipo("Corrente");
            } else {
                System.out.println("Opção invalida");
            }
            System.out.println("Conta aberta com sucesso!\n");
            this.status = true;
        }
    }

    public void fechar_conta() {
        System.out.println("\n2 teclada\n");
        if  (this.isStatus() == false) {
            System.out.println("Não é possível fechar a conta pois a mesma não existe!\n");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Deseja mesmo fechar sua conta?\n");
            System.out.println("1 - Sim \n2 - Não \n");
            int escolha = scanner.nextInt();
            if (escolha == 1) {
                this.status = false;
                this.setSaldo(0);
                System.out.println("Conta fechada com sucesso!\n");
            } else if (escolha == 2) {
                System.out.println("Operação cancelada!\n");
            } else {
                System.out.println("Opção Invalida!\n");
            }
        }
    }

    public void depositar() {
        System.out.println("\n3 teclada\n");
        if (this.isStatus() == false) {
            System.out.println("Não é possível depositar em uma conta inexistente!\n");
        } else  {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Quanto deseja depositar?");
            System.out.println("R$:");
            int quantia = scanner.nextInt();
            System.out.println("\nDeseja mesmo depositar?\n");
            System.out.println("1 - Sim \n2 - Não \n");
            int escolha = scanner.nextInt();
            if (escolha == 1) {
                this.setSaldo(this.saldo += quantia);
                System.out.println("Depositado com sucesso!\n");
            }  else if (escolha == 2) {
                System.out.println("Operação cancelada!\n");
            }  else {
                System.out.println("Operação Invalida!\n");
            }
        }
    }

    public void ver_saldo() {
        System.out.println("\n4 teclada\n");
        if (this.getSaldo() == 0) {
            System.out.println("Não há saldo\n");
        }  else {
            System.out.println("O saldo atual é de: R$" + this.getSaldo() + "\n");
        }

    }

    public void sacar() {
        System.out.println("\n5 teclada\n");
        if (this.isStatus() == false || this.getSaldo() == 0) {
            System.out.println("Não é possível sacar em uma conta inexistente ou sem saldo!\n");
        } else  {
            System.out.println("Saldo disponível: R$" + this.getSaldo() + "\n");
            System.out.println("Quanto deseja sacar?\n");
            System.out.println("R$:");
            Scanner scanner = new Scanner(System.in);
            int quantia = scanner.nextInt();
            System.out.println("\nDeseja mesmo sacar?\n");
            System.out.println("1 - Sim \n2 - Não \n");
            int escolha = scanner.nextInt();
            if (escolha == 1) {
                this.setSaldo(this.saldo -= quantia);
                System.out.println("Saldo atualizado com sucesso!\n");
            }
        }
    }

    public void pagarAnuidade() {
        System.out.println("\n6 teclada\n");
        if (this.isStatus() == false || this.getSaldo() == 0) {
            System.out.println("Não é possível  pagar em uma conta inexistente ou sem saldo!\n");
        } else   {
            System.out.println("Saldo disponível: R$" + this.getSaldo() + "\n");
            System.out.println("Quanto deseja pagar?\n");
            System.out.println("R$:");
            Scanner scanner = new Scanner(System.in);
            int quantia = scanner.nextInt();
            if (quantia <= this.saldo) {
                System.out.println("\nDeseja mesmo pagar?\n");
                System.out.println("1 - Sim \n2 - Não \n");
                int escolha = scanner.nextInt();
                if (escolha == 1) {
                    this.setSaldo(this.saldo -= quantia);
                    System.out.println("Saldo atualizado com sucesso!\n");
                } else if (escolha == 2) {
                    System.out.println("Operação cancelada!\n");
                }
            } else {
                System.out.println("O saldo é menor do que o valor a ser pago!\n");
            }
        }
    }
}

