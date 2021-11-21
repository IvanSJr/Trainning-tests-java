package com.navi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PrimeiroTeste {

    Calculadora calculadora;
    Integer n1 = 10, n2 = 1;

    @BeforeEach
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2NumerosInteiros() {
        // execução
        Integer result = calculadora.somar(n1, n2);

        // verificações
        // Assert.assertEquals(15, result);
        Assertions.assertThat(result).isEqualTo(11);
    }

    @Test()//expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos() {
        // Cenário
        Integer n1 = -2, n2 = 3;

        // Execução
        org.junit.jupiter.api.Assertions
                .assertThrows(RuntimeException.class, ()->calculadora.somar(n1, n2));
    }

    @Test
    public void deveSubtrair2Numeros() {
        // Execução
        Integer result = calculadora.subtrair(n1, n2);

        // Verificações
        Assertions.assertThat(result).isEqualTo(9);
    }

    @Test
    public void deveMultiplicar2Numeros() {
        // Execução
        Integer result = calculadora.multiplicar(n1, n2);

        // Verificações
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    public void deveDividir2Numeros() {
        // Execução
        Integer result = calculadora.dividir(n1, n2);

        // Verificações
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test()
    public void naoDeveDividirPor0() {
        Integer n1 = 0, n2 = 1;

        // Execução
        org.junit.jupiter.api.Assertions
                .assertThrows(ArithmeticException.class, ()->calculadora.dividir(n1, n2));
    }

}

class Calculadora {
    int somar(int a, int b) {
        if (a < 0 || b < 0) {
            throw new RuntimeException("Não é permitido somar números negativos!");
        }
        return a + b;
    }

    int subtrair(int a, int b) {
        return a - b;
    }

    int multiplicar(int a, int b) {
        return a * b;
    }

    int dividir(int a, int b){
        if (a == 0 || b == 0){
            throw new ArithmeticException("Não é possível diviidir por 0");
        }
        return a / b;
    }

}
