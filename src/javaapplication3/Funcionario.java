/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author User
 */

public class Funcionario {
    private String nome;
    private String cargo;
    private double salarioBase;
    private double valeAlimentacao;
    private double valeTransporte;
    private double horasExtras;
    private int faltas;

    // Construtor
    public Funcionario(String nome, String cargo, double salarioBase, double valeAlimentacao, 
                       double valeTransporte, double horasExtras, int faltas) {
        this.nome = nome;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.valeAlimentacao = valeAlimentacao;
        this.valeTransporte = valeTransporte;
        this.horasExtras = horasExtras;
        this.faltas = faltas;
    }

    // Método para calcular o salário bruto
    public double calcularSalarioBruto() {
        return salarioBase + (horasExtras * (salarioBase / 160));
    }

    // Método para calcular o salário líquido
    public double calcularSalarioLiquido() {
        double salarioBruto = calcularSalarioBruto();

        // Cálculo do desconto do INSS
        double inss = 0;
        if (salarioBruto <= 1412.00) {
            inss = salarioBruto * 0.075;
        } else if (salarioBruto <= 2666.68) {
            inss = salarioBruto * 0.09;
        } else if (salarioBruto <= 4000.03) {
            inss = salarioBruto * 0.12;
        } else {
            inss = salarioBruto * 0.14;
        }

        // Desconto de vale transporte (6% do salário base)
        double descontoVT = (valeTransporte > 0) ? salarioBase * 0.06 : 0;

        // Desconto de faltas
        double descontoFaltas = (salarioBase / 30) * faltas;

        // Cálculo do salário líquido
        return salarioBruto - inss - descontoVT - descontoFaltas;
    }

    // Métodos Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    public double getValeAlimentacao() { return valeAlimentacao; }
    public void setValeAlimentacao(double valeAlimentacao) { this.valeAlimentacao = valeAlimentacao; }

    public double getValeTransporte() { return valeTransporte; }
    public void setValeTransporte(double valeTransporte) { this.valeTransporte = valeTransporte; }

    public double getHorasExtras() { return horasExtras; }
    public void setHorasExtras(double horasExtras) { this.horasExtras = horasExtras; }

    public int getFaltas() { return faltas; }
    public void setFaltas(int faltas) { this.faltas = faltas; }
}
