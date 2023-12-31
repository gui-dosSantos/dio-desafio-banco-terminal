import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;

public class ContaTerminal {
    //Solução para a exibição do saldo com apenas 2 casas decimais e com um ponto(".") como separador de casas decimais
    private static final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    private static final DecimalFormat padraoFormatacaoDecimal = new DecimalFormat("0.00", symbols);

    public static void main(String[] args) {
        //Uso da função useDelimiter foi feito para que a leitura do nome do cliente aceitasse o uso de espaços
        //Permitindo assim a inserção de nomes compostos ou nome + sobrenome
        Scanner scanner = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        imprimirInformacaoConta(scanner);
        scanner.close();
    }

    private static void imprimirInformacaoConta(Scanner scanner){
        final int TENTATIVAMAXIMA = 3;
        int tentativa = 0;

        while(tentativa < TENTATIVAMAXIMA){
            try {
                System.out.println("Por favor, digite o número da sua agência:");
                String agencia = scanner.next();

                System.out.println("Por favor, digite o número da sua conta:");
                int conta = scanner.nextInt();

                System.out.println("Por favor, digite o seu nome:");
                String nomeCliente = scanner.next();

                System.out.println("Por favor, digite o seu saldo:");
                double saldo = scanner.nextDouble();

                //Formatação do saldo para exibição de acordo com a exibição padrão de moedas, com 2 casas decimais
                String saldoFormatado = padraoFormatacaoDecimal.format(saldo);

                System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + conta + " e seu saldo $" + saldoFormatado + " já está disponível para saque");
                break;
            } catch (InputMismatchException e) {
                tentativa++;
                System.out.println("Os valores inseridos para a conta e para o saldo devem estar em formato numérico. Tentativas restantes: " + (TENTATIVAMAXIMA - tentativa));
                scanner.nextLine();
            }
        }
        if(tentativa == TENTATIVAMAXIMA){
            System.out.println("Número máximo de tentativas excedido. Entre em contato com o seu gerente.");
        }

    }

}
