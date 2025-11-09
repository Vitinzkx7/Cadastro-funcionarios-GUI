package modelo;

public class Desenvolvedor extends Funcionario implements Bonus {
    private String nivel;

    public Desenvolvedor(String nome, double salarioBase, String nivel) {
        super(nome, salarioBase);
        this.nivel = nivel;
    }

    @Override
    public double calcularBonus() {
        return switch (nivel.toLowerCase()) {
            case "júnior", "junior" -> salarioBase * 0.05;
            case "pleno" -> salarioBase * 0.10;
            case "sênior", "senior" -> salarioBase * 0.15;
            default -> 0;
        };
    }

    @Override
    public double calcularSalarioFinal() {
        return salarioBase + calcularBonus();
    }

    public String getNivel() {
        return nivel;
    }

}
