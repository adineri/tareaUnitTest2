package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class PruebasParametrizadas {

	
	@Parameters
	public static Iterable data() {
		return Arrays.asList(new Object[][] {
			{1,1,250}, {2,2,1260}, {3,3,1500}
		});
	}
	
	
	private int zona;
	private int comision;
	private int balance;
	
	public PruebasParametrizadas(int zona, int expected, int balance) {
		this.zona = zona;
		this.comision = expected;
		this.balance = balance;
	}
	
	
	@Test
	public void TestCreacionDeCuentas() {
		AlertListener alertas = new AlertListenerBanco();
		Account cuenta = new Account("Andres Abimeri Romero", balance, alertas, zona );
		Assert.assertEquals(cuenta.zona, zona);
		Assert.assertEquals(cuenta.balance, balance);
		Assert.assertEquals(cuenta.comision, comision);
		
	}

}
