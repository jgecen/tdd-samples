package org.tddsamples.extenso;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer from 0 to 9,999,999  return it's textual description in
 * pt-BR.
 *
 * @author ivandeaguirre
 *
 */
public class ExtensoTest {

	@Test
	public void test() {
		// This sequence doesn't lead me to the right result
		Assert.assertEquals("zero", Extenso.parse(BigDecimal.ZERO));
		Assert.assertEquals("um", Extenso.parse(BigDecimal.ONE));
		Assert.assertEquals("dez", Extenso.parse(BigDecimal.TEN));
		Assert.assertEquals("onze", Extenso.parse(new BigDecimal(11)));
		Assert.assertEquals("doze", Extenso.parse(new BigDecimal(12)));
		Assert.assertEquals("vinte", Extenso.parse(new BigDecimal(20)));
		Assert.assertEquals("vinte e um", Extenso.parse(new BigDecimal(21)));
		Assert.assertEquals("vinte e dois", Extenso.parse(new BigDecimal(22)));
		Assert.assertEquals("cem", Extenso.parse(new BigDecimal(100)));
		Assert.assertEquals("cento e um", Extenso.parse(new BigDecimal(101)));
		Assert.assertEquals("cento e vinte e um", Extenso.parse(new BigDecimal(121)));
		Assert.assertEquals("cento e vinte e dois", Extenso.parse(new BigDecimal(122)));
		Assert.assertEquals("cento e vinte", Extenso.parse(new BigDecimal(120)));
		Assert.assertEquals("duzentos e trinta", Extenso.parse(new BigDecimal(230)));
		Assert.assertEquals("um mil", Extenso.parse(new BigDecimal(1000)));
		Assert.assertEquals("um mil e um", Extenso.parse(new BigDecimal(1001)));
		Assert.assertEquals("um mil e cem", Extenso.parse(new BigDecimal(1100)));
		Assert.assertEquals("um mil cento e um", Extenso.parse(new BigDecimal(1101)));
		Assert.assertEquals("um mil cento e vinte", Extenso.parse(new BigDecimal(1120)));
		Assert.assertEquals("um mil cento e vinte e um", Extenso.parse(new BigDecimal(1121)));
		Assert.assertEquals("dois mil", Extenso.parse(new BigDecimal(2000)));
		Assert.assertEquals("dois mil e dois", Extenso.parse(new BigDecimal(2002)));
		Assert.assertEquals("dois mil e doze", Extenso.parse(new BigDecimal(2012)));
		Assert.assertEquals("dois mil e trinta", Extenso.parse(new BigDecimal(2030)));
		Assert.assertEquals("dois mil e trinta e dois", Extenso.parse(new BigDecimal(2032)));
		Assert.assertEquals("dois mil cento e trinta e dois", Extenso.parse(new BigDecimal(2132)));
		Assert.assertEquals("dez mil", Extenso.parse(new BigDecimal(10000)));
		Assert.assertEquals("dez mil e um", Extenso.parse(new BigDecimal(10001)));
		Assert.assertEquals("vinte mil", Extenso.parse(new BigDecimal(20000)));
		Assert.assertEquals("vinte e tres mil cento e trinta e dois", Extenso.parse(new BigDecimal(23132)));
		Assert.assertEquals("cento e vinte e tres mil cento e trinta e dois", Extenso.parse(new BigDecimal(123132)));
		Assert.assertEquals("duzentos e vinte e tres mil cento e trinta e dois", Extenso.parse(new BigDecimal(223132)));
		Assert.assertEquals("cem mil", Extenso.parse(new BigDecimal(100000)));
		Assert.assertEquals("cem mil e cem", Extenso.parse(new BigDecimal(100100)));
		Assert.assertEquals("um milhao", Extenso.parse(new BigDecimal(1000000)));
		// TODO next Assert.assertEquals("um milhao duzentos e vinte e tres mil cento e trinta e dois", Extenso.parse(new BigDecimal(1_223_132)));
	}
}

