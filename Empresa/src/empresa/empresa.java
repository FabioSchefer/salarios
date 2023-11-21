package empresa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe para representar o Cargo
abstract class Cargo {
    protected String nome;
    protected double salarioBase;
    protected double beneficioBase;

    public Cargo(String nome, double salarioBase, double beneficioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.beneficioBase = beneficioBase;
    }

    // Método para calcular o salário total
    public abstract double calcularSalarioTotal(int anosServico);

    // Método para calcular os benefícios
    public abstract double calcularBeneficios();

    // Getters
    public String getNome() {
        return nome;
    }
}

// Implementação do Cargo Secretário
class Secretario extends Cargo {
    public Secretario() {
        super("Secretário", 7000.00, 1000.00);
    }

    @Override
    public double calcularSalarioTotal(int anosServico) {
        return salarioBase + (anosServico * beneficioBase) + (0.20 * salarioBase);
    }

    @Override
    public double calcularBeneficios() {
        return 0.20 * salarioBase;
    }
}

// Implementação do Cargo Vendedor
class Vendedor extends Cargo {
    public Vendedor() {
        super("Vendedor", 12000.00, 1800.00);
    }

    @Override
    public double calcularSalarioTotal(int anosServico) {
        return salarioBase + (anosServico * beneficioBase);
    }

    @Override
    public double calcularBeneficios() {
        return 0.30 * salarioBase;
    }
}

// Implementação do Cargo Gerente
class Gerente extends Cargo {
    public Gerente() {
        super("Gerente", 20000.00, 3000.00);
    }

    @Override
    public double calcularSalarioTotal(int anosServico) {
        return salarioBase + (anosServico * beneficioBase);
    }

    @Override
    public double calcularBeneficios() {
        return 0.0; // Gerente não tem benefícios
    }
}

// Classe para representar um Funcionário
class Funcionario {
    protected String nome;
    protected Cargo cargo;
    protected String dataContratacao;

    public Funcionario(String nome, Cargo cargo, String dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    // Método para calcular o salário total do funcionário
    public double calcularSalarioTotal() {
        int anosServico = calcularAnosServico();
        return cargo.calcularSalarioTotal(anosServico);
    }

    // Método para calcular os benefícios do funcionário
    public double calcularBeneficios() {
        return cargo.calcularBeneficios();
    }

    // Método para calcular anos de serviço
    private int calcularAnosServico() {
        // Lógica para calcular os anos de serviço com base na data de contratação
        // (Implementação não fornecida neste exemplo)
        return 0;
    }
}

// Classe para representar o Registro de Vendas
class RegistroVendas {
    private Map<String, Map<String, Double>> vendas;

    public RegistroVendas() {
        this.vendas = new HashMap<>();
    }

    // Método para adicionar vendas de um vendedor em um determinado mês
    public void adicionarVendas(String vendedor, String mes, double valor) {
        vendas.putIfAbsent(vendedor, new HashMap<>());
        vendas.get(vendedor).put(mes, valor);
    }

    // Método para obter o total de vendas de um vendedor em um determinado mês
    public double obterTotalVendas(String vendedor, String mes) {
        return vendas.getOrDefault(vendedor, new HashMap<>()).getOrDefault(mes, 0.0);
    }
}