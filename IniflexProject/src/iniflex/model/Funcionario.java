package iniflex.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getDataFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getDataNascimento().format(formatter);
    }

    public String getSalarioFormatado() {
        return String.format("%,.2f", salario).replace(',', 'x').replace('.', ',').replace('x', '.');
    }
}