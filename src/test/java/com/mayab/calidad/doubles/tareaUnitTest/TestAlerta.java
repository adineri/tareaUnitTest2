package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.Mockito.*;

public class TestAlerta {

	
	@Mock
	AlertListenerBanco alertas;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Test
	public void testAlerta() {
		Account cuenta = new Account("Andres", 200, alertas, 1);
		cuenta.debit(150);
		verify(alertas).sendAlert("Andres, your account balance is below 100");
	}
	
	
	
	
	

}
