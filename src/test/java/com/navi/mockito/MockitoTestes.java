package com.navi.mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith({MockitoExtension.class})
public class MockitoTestes {

    @Mock
    List<Integer> idades;

    @Test
    public void primeiroTesteMockito() {
        List<String> nomes = Mockito.mock(ArrayList.class);
        Mockito.when(nomes.size()).thenReturn(20);

        Integer size = nomes.size();

        Assertions.assertThat(size).isEqualTo(20);
    }

    @Test
    public void verificaQuantasIdadesTem() {
        Mockito.when(idades.size()).thenReturn(50);
        Integer size = idades.size();

        Assertions.assertThat(size).isEqualTo(50);
    }



}
