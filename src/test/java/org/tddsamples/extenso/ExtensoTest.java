package org.tddsamples.extenso;

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
		Assert.assertEquals("zero", Extenso.parse(0));
		Assert.assertEquals("um", Extenso.parse(1));
		Assert.assertEquals("dez", Extenso.parse(10));
		Assert.assertEquals("onze", Extenso.parse(11));
		Assert.assertEquals("vinte", Extenso.parse(20));
		Assert.assertEquals("vinte e um", Extenso.parse(21));
		Assert.assertEquals("cento e vinte e um", Extenso.parse(121));
		Assert.assertEquals("cem", Extenso.parse(100));
		Assert.assertEquals("duzentos e vinte e um", Extenso.parse(221));
		Assert.assertEquals("quinhentos e sessenta", Extenso.parse(560));
		Assert.assertEquals("mil", Extenso.parse(1000));
		Assert.assertEquals("mil duzentos e vinte e um", Extenso.parse(1221));
		Assert.assertEquals("nove mil duzentos e vinte e um", Extenso.parse(9221));
		Assert.assertEquals("vinte mil duzentos e vinte e um", Extenso.parse(20221));
		Assert.assertEquals("cem mil duzentos e vinte e um", Extenso.parse(100221));
		Assert.assertEquals("cento e vinte mil duzentos e vinte e um", Extenso.parse(120221));
		Assert.assertEquals("quinze mil duzentos e vinte", Extenso.parse(15220));
		Assert.assertEquals("vinte e tres mil", Extenso.parse(23000));
		Assert.assertEquals("vinte e tres mil e um", Extenso.parse(23001));
		Assert.assertEquals("trinta e tres mil quinhentos e um", Extenso.parse(33501));
	}
}

