import java.util.Scanner;
@SuppressWarnings("all")

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, bem-vindo ao banco!");
        ContaBanco c1 = new ContaBanco();
        int opcao = 0;
        while (opcao != 8) {
            System.out.println("Qual ação você deseja realizar?");
            System.out.println("\n--- MENU DE AÇÕES ---");
            System.out.println("1 - Abrir Conta");
            System.out.println("2 - Fechar Conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Ver Saldo");
            System.out.println("5 - Sacar");
            System.out.println("6 - Pagar Anuidade");
            System.out.println("7 - Ver Status da Conta");
            System.out.println("8 - Sair do Programa");
            System.out.print("Digite a opção desejada: ");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1: c1.abrir_conta(); break;
                case 2: c1.fechar_conta(); break;
                case 3: c1.depositar(); break;
                case 4: c1.ver_saldo(); break;
                case 5: c1.sacar(); break;
                case 6: c1.pagarAnuidade(); break;
                case 7: c1.ver_conta(); break;
                case 8: System.exit(0); break;
                default: System.out.println("Opção Inválida"); break;
            }
        }
    }
}