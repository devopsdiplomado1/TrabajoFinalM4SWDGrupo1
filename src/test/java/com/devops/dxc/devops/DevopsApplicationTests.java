package com.devops.dxc.devops;

import com.devops.dxc.devops.model.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

@SpringBootTest
class DevopsApplicationTests {

	@Test
	void testGetUf(){
		assertNotNull(Util.getUf());
	}

	@Test
	void testDiezxCiento(){
		int uf = Util.getUf();
		assertEquals(uf * 35 - 1, Util.getDxc(uf * 35 - 1));
		assertEquals(uf * 35, Util.getDxc(uf * 35));
		assertEquals(uf * 35, Util.getDxc(uf * 35 + 1));
		assertEquals(uf * 35, Util.getDxc(uf * 35 * 10));
		Assertions.assertEquals((uf * 35 * 10 + 1000000) * 0.1, Util.getDxc(uf * 35 * 10 + 1000000));
		Assertions.assertEquals(uf * 150, Util.getDxc(uf * 150 * 10));
		Assertions.assertEquals(uf * 150, Util.getDxc(uf * 150 * 10 + 1));
	}

	@Test
	void testGetSaldo(){
		int uf = Util.getUf();
		assertTrue(Util.getSaldo(uf * 34, uf * 34) == 0);
		assertTrue(Util.getSaldo(uf * 35, uf * 35) == 0);
		assertTrue(Util.getSaldo(uf * 36, uf * 35) == (uf * 36) - (uf * 35));
	}

	@Test
	void testGetImpuesto(){
		assertEquals(0, Util.getImpuesto(ThreadLocalRandom.current().nextInt(1499999)));
		assertEquals(174531, Util.getImpuesto(ThreadLocalRandom.current().nextInt(1500000, 2499999)));
		assertEquals(364086, Util.getImpuesto(ThreadLocalRandom.current().nextInt(2500000, 2999999)));
		assertEquals(612396, Util.getImpuesto(ThreadLocalRandom.current().nextInt(3000000, 3999999)));
		assertEquals(980357, Util.getImpuesto(ThreadLocalRandom.current().nextInt(4000000, 4999999)));
		assertEquals(1294052, Util.getImpuesto(ThreadLocalRandom.current().nextInt(5000000, 5999999)));
		assertEquals(1491042, Util.getImpuesto(ThreadLocalRandom.current().nextInt(6000000) + 6000000));
	}

}
