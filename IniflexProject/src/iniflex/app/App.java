package iniflex.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import iniflex.model.Funcionario;

public class App {
        public void addFuncionario(List<Funcionario> funcionarios, String nome, LocalDate dataNascimento,
                        BigDecimal salario, String funcao) {
                funcionarios.add(new Funcionario(nome, dataNascimento, salario, funcao));
        }

        public void removeFuncionario(List<Funcionario> funcionarios, String nome) {
                funcionarios.removeIf(f -> f.getNome().equals(nome));
        }

        public void imprimirFuncionarios(List<Funcionario> funcionarios) {
                funcionarios.forEach(f -> System.out.println(
                                f.getNome() + " - " + f.getDataFormatada() + " - " + f.getSalarioFormatado() + " - "
                                                + f.getFuncao()));
        }

        public void aumentarSalario(List<Funcionario> funcionarios, BigDecimal percentual) {
                funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(percentual)));
        }

        public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
                return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        }

        public void imprimirAgrupadosPorFuncao(Map<String, List<Funcionario>> agrupadosPorFuncao) {
                agrupadosPorFuncao.forEach((funcao, funcs) -> {
                        System.out.println("Função: " + funcao);
                        funcs.forEach(f -> System.out.println(" - " + f.getNome()));
                });
        }

        public static void main(String[] args) {
                List<Funcionario> funcionarios = new ArrayList<>();

                App appInstance = new App();

                appInstance.addFuncionario(funcionarios, "Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"),
                                "Operador");
                appInstance.addFuncionario(funcionarios, "João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"),
                                "Operador");
                appInstance.addFuncionario(funcionarios, "Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"),
                                "Coordenador");
                appInstance.addFuncionario(funcionarios, "Miguel", LocalDate.of(1988, 10, 14),
                                new BigDecimal("19119.88"),
                                "Diretor");
                appInstance.addFuncionario(funcionarios, "Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"),
                                "Recepcionista");
                appInstance.addFuncionario(funcionarios, "Heitor", LocalDate.of(1999, 11, 19),
                                new BigDecimal("1582.72"),
                                "Operador");
                appInstance.addFuncionario(funcionarios, "Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"),
                                "Contador");
                appInstance.addFuncionario(funcionarios, "Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"),
                                "Gerente");
                appInstance.addFuncionario(funcionarios, "Heloísa", LocalDate.of(2003, 5, 24),
                                new BigDecimal("1606.85"),
                                "Eletricista");
                appInstance.addFuncionario(funcionarios, "Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"),
                                "Gerente");

                appInstance.removeFuncionario(funcionarios, "João");

                appInstance.imprimirFuncionarios(funcionarios);

                appInstance.aumentarSalario(funcionarios, new BigDecimal("1.1"));

                Map<String, List<Funcionario>> agrupadosPorFuncao = funcionarios.stream()
                                .collect(Collectors.groupingBy(Funcionario::getFuncao));

                appInstance.imprimirAgrupadosPorFuncao(agrupadosPorFuncao);
        }
}