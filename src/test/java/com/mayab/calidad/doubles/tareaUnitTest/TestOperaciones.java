package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import static org.mockito.Matchers.*;


public class TestOperaciones {

	private Database dao;
	
	@Before
	public void setupMock() {
		dao = mock(Database.class);
	}
	

	

	@Test
	public void testOperaciones() {
		AlertListenerBanco alertas = new AlertListenerBanco();
		Account cuenta = new Account("Andres", 500, alertas, 3);

		when(dao.cargar(cuenta, 1000)).then(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				Account cuenta = (Account) invocation.getArguments()[0];
				Integer cantidad = (Integer) invocation.getArguments()[1];
				
				cuenta.balance += cantidad;
				cuenta.historial.add(cantidad);
				return -1;
			}
		});
		
		
		when(dao.calcularComision(cuenta)).then(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				Account cuenta = (Account) invocation.getArguments()[0];
				int total = 0;
				for(int transaccion : cuenta.historial) {
					total += (transaccion * cuenta.comision);
				}
				
				return total;
			}
		});

		dao.cargar(cuenta, 1000);
		dao.cargar(cuenta, 1000);
		
		int comisionesTotales = dao.calcularComision(cuenta);
		int expected = 60;
		
		assertEquals(Integer.valueOf(cuenta.historial.get(0)), Integer.valueOf(1000));
		assertEquals(comisionesTotales, 60);
	}
}
