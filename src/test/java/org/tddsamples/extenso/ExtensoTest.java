package org.tddsamples.extenso;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer from 0 to 1 million return it's textual description in
 * pt-BR.
 *
 * @author ivandeaguirre
 *
 */
public class ExtensoTest {

	@Test
	public void test() {
		Assert.assertEquals("zero", Extenso.parse(BigDecimal.ZERO));
		Assert.assertEquals("um", Extenso.parse(BigDecimal.ONE));
		Assert.assertEquals("dez", Extenso.parse(BigDecimal.TEN));
		Assert.assertEquals("onze", Extenso.parse(new BigDecimal(11)));
		Assert.assertEquals("vinte", Extenso.parse(new BigDecimal(20)));
		Assert.assertEquals("vinte e um", Extenso.parse(new BigDecimal(21)));
		Assert.assertEquals("vinte e dois", Extenso.parse(new BigDecimal(22)));
		Assert.assertEquals("cem", Extenso.parse(new BigDecimal(100)));
		Assert.assertEquals("cento e um", Extenso.parse(new BigDecimal(101)));
		Assert.assertEquals("cento e vinte e um", Extenso.parse(new BigDecimal(121)));
		Assert.assertEquals("cento e vinte e dois", Extenso.parse(new BigDecimal(122)));
		Assert.assertEquals("cento e vinte", Extenso.parse(new BigDecimal(120)));
		Assert.assertEquals("duzentos e trinta", Extenso.parse(new BigDecimal(230)));
		Assert.assertEquals("mil", Extenso.parse(new BigDecimal(1000)));
		Assert.assertEquals("mil e um", Extenso.parse(new BigDecimal(1001)));
		Assert.assertEquals("mil e cem", Extenso.parse(new BigDecimal(1100)));
		Assert.assertEquals("mil cento e um", Extenso.parse(new BigDecimal(1101)));
	}
}
