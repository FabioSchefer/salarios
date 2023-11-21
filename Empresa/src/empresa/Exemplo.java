package empresa;

import java.util.List;

public class Exemplo {

    public static void main(String[] args) {
        // Criar instâncias de funcionários
        Funcionario jorge = new Funcionario("Jorge Carvalho", new Secretario(), "01/2018");
        Funcionario maria = new Funcionario("Maria Souza", new Secretario(), "12/2015");
        Funcionario ana = new Funcionario("Ana Silva", new Vendedor(), "12/2021");
        Funcionario joao = new Funcionario("João Mendes", new Vendedor(), "12/2021");
        Funcionario juliana = new Funcionario("Juliana Alves", new Gerente(), "07/2017");
        Funcionario bento = new Funcionario("Bento Albino", new Gerente(), "03/2014");

        // Criar instância do registro de vendas
        RegistroVendas registroVendas = new RegistroVendas();

        // Adicionar vendas ao registro
        registroVendas.adicionarVendas("Ana Silva", "12/2021", 5200.00);
        registroVendas.adicionarVendas("Ana Silva", "01/2022", 4000.00);
        registroVendas.adicionarVendas("Ana Silva", "02/2022", 4200.00);
        registroVendas.adicionarVendas("Ana Silva", "03/2022", 5850.00);
        registroVendas.adicionarVendas("Ana Silva", "04/2022", 7000.00);

        registroVendas.adicionarVendas("João Mendes", "12/2021", 3400.00);
        registroVendas.adicionarVendas("João Mendes", "01/2022", 7700.00);
        registroVendas.adicionarVendas("João Mendes", "02/2022", 5000.00);
        registroVendas.adicionarVendas("João Mendes", "03/2022", 5900.00);
        registroVendas.adicionarVendas("João Mendes", "04/2022", 6500.00);

        // Exibir informações
        exibirInformacoesFuncionario(jorge);
        exibirInformacoesFuncionario(maria);
        exibirInformacoesFuncionario(ana);
        exibirInformacoesFuncionario(joao);
        exibirInformacoesFuncionario(juliana);
        exibirInformacoesFuncionario(bento);
        	
        		
    }

    // Método para exibir informações do funcionário
    private static void exibirInformacoesFuncionario(Funcionario funcionario) {
        System.out.println("Nome: " + funcionario.nome);
        System.out.println("Cargo: " + funcionario.cargo.getNome());
        System.out.println("Salário Total: R$ " + funcionario.calcularSalarioTotal());
        System.out.println("Benefícios: R$ " + funcionario.calcularBeneficios());
        System.out.println();
    }

    public class empresa{

        // ... (código anterior)

        // Método para calcular o valor total pago (salário e benefício) a funcionários no mês
        public static double calcularTotalPago(List<Funcionario> funcionarios, String mes, String ano) {
            double totalPago = 0;
            for (Funcionario funcionario : funcionarios) {
                // Lógica para verificar se o funcionário recebeu pagamento no mês e ano específicos
                // (Implementação não fornecida neste exemplo)
                if (funcionarioRecebePagamentoNoMes(funcionario, mes, ano)) {
                    totalPago += funcionario.calcularSalarioTotal();
                }
            }
            return totalPago;
        }

        // Método para calcular o total pago somente em salários no mês
        public static double calcularTotalSalarios(List<Funcionario> funcionarios, String mes, String ano) {
            double totalSalarios = 0;
            for (Funcionario funcionario : funcionarios) {
                // Lógica para verificar se o funcionário recebeu pagamento no mês e ano específicos
                // (Implementação não fornecida neste exemplo)
                if (funcionarioRecebePagamentoNoMes(funcionario, mes, ano)) {
                    totalSalarios += funcionario.calcularSalarioTotal();
                }
            }
            return totalSalarios;
        }

        // Método para calcular o total pago em benefícios no mês
        public static double calcularTotalBeneficios(List<Funcionario> funcionarios, String mes, String ano) {
            double totalBeneficios = 0;
            for (Funcionario funcionario : funcionarios) {
                // Lógica para verificar se o funcionário recebeu pagamento no mês e ano específicos
                // (Implementação não fornecida neste exemplo)
                if (funcionarioRecebePagamentoNoMes(funcionario, mes, ano)) {
                    totalBeneficios += funcionario.calcularBeneficios();
                }
            }
            return totalBeneficios;
        }

        // Método para encontrar o funcionário que recebeu o valor mais alto no mês
        public static Funcionario encontrarFuncionarioMaiorValor(List<Funcionario> funcionarios, String mes, String ano) {
            Funcionario funcionarioMaiorValor = null;
            double maiorValor = 0;

            for (Funcionario funcionario : funcionarios) {
                // Lógica para verificar se o funcionário recebeu pagamento no mês e ano específicos
                // (Implementação não fornecida neste exemplo)
                if (funcionarioRecebePagamentoNoMes(funcionario, mes, ano)) {
                    double valorTotal = funcionario.calcularSalarioTotal();
                    if (valorTotal > maiorValor) {
                        maiorValor = valorTotal;
                        funcionarioMaiorValor = funcionario;
                    }
                }
            }

            return funcionarioMaiorValor;
        }

        // Método para encontrar o nome do funcionário que recebeu o valor mais alto em benefícios no mês
        public static String encontrarNomeFuncionarioMaiorBeneficio(List<Funcionario> funcionarios, String mes, String ano) {
            Funcionario funcionarioMaiorBeneficio = null;
            double maiorBeneficio = 0;

            for (Funcionario funcionario : funcionarios) {
                // Lógica para verificar se o funcionário recebeu pagamento no mês e ano específicos
                // (Implementação não fornecida neste exemplo)
                if (funcionarioRecebePagamentoNoMes(funcionario, mes, ano)) {
                    double valorBeneficio = funcionario.calcularBeneficios();
                    if (valorBeneficio > maiorBeneficio) {
                        maiorBeneficio = valorBeneficio;
                        funcionarioMaiorBeneficio = funcionario;
                    }
                }
            }

            return (funcionarioMaiorBeneficio != null) ? funcionarioMaiorBeneficio.nome : "Nenhum funcionário";
        }

        // Método para encontrar o vendedor que mais vendeu no mês
        public static Funcionario encontrarVendedorMaiorVenda(List<Funcionario> vendedores, String mes, String ano,
                                                               RegistroVendas registroVendas) {
            Funcionario vendedorMaiorVenda = null;
            double maiorVenda = 0;

            for (Funcionario vendedor : vendedores) {
                // Lógica para verificar se o vendedor recebeu pagamento no mês e ano específicos
                // (Implementação não fornecida neste exemplo)
                if (funcionarioRecebePagamentoNoMes(vendedor, mes, ano)) {
                    double totalVendas = registroVendas.obterTotalVendas(vendedor.nome, mes);
                    if (totalVendas > maiorVenda) {
                        maiorVenda = totalVendas;
                        vendedorMaiorVenda = vendedor;
                    }
                }
            }

            return vendedorMaiorVenda;
        }

        // Método auxiliar para verificar se o funcionário recebeu pagamento no mês e ano específicos
        private static boolean funcionarioRecebePagamentoNoMes(Funcionario funcionario, String mes, String ano) {
            // Lógica para verificar se o funcionário recebeu pagamento no mês e ano específicos
            // (Implementação não fornecida neste exemplo)
            return true;
        }
}
}