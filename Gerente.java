package modelo;

public class Gerente extends Funcionario implements Bonus {
    private String departamento;

    public Gerente(String nome, double salarioBase, String departamento) {
        super(nome, salarioBase);
        this.departamento = departamento;
    }

    @Override
    public double calcularBonus() {
        return salarioBase * 0.20;
    }

    @Override
    public double calcularSalarioFinal() {
        return salarioBase + calcularBonus();
    }

    public String getDepartamento() {
        return departamento;
    }
}
