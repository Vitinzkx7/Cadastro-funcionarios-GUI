package modelo;

public class Estagiario extends Funcionario {
    private String escola;
    private int mesesEstagio;

    public Estagiario(String nome, double salarioBase, String escola, int mesesEstagio) {
        super(nome, salarioBase);
        this.escola = escola;
        this.mesesEstagio = mesesEstagio;
    }

    @Override
    public double calcularSalarioFinal() {
        return salarioBase; // Estagiário não recebe bônus
    }

    public String getEscola() {
        return escola;
    }

    public int getMesesEstagio() {
        return mesesEstagio;
    }
}
