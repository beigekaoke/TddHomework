package com.tdd.barcode.bacodetransfer;

import static org.junit.Assert.*;

import org.junit.Test;


public class BarCodeTransferTest {

	static String notNumberPostCode = "fsdfds";
	static String not5NumberPostCode = "311";
	static String not9NumberPostCode = "2351435";
	static String not10NumberPostCode = "2314343242111111111111";
	static String normal5lengthPostCode = "45056";//
	static String normal9lengthPostCode = "450560191";
	static String normal10lengthPostCode = "45056-0191";
	static String normal5lengthBarCode = "|:||:::|:|:||::::|:|::|::|||:::|";//
	static String normal9lengthBarCode = "|:::|||:|:::::||||::::||:::|:|:||::::|:|::|::|:::|||";
	static String normal10lengthBarCode = "|:::|||:|:::::||||::::||:::|:|:||::::|:|::|::||::|:|";

	@Test
	public void should_false_when_postCode_is_null() {
		assertFalse(BarCodeTransfer.validPostCode(null));
	}

	@Test
	public void should_false_when_postCode_is_not_number() {
		assertFalse(BarCodeTransfer.validPostCode(notNumberPostCode));
	}

	@Test
	public void should_false_when_postCode_length_is_not_5() {
		assertFalse(BarCodeTransfer.validPostCode(not5NumberPostCode));
	}

	@Test
	public void should_false_when_postCode_length_is_not_9() {
		assertFalse(BarCodeTransfer.validPostCode(not9NumberPostCode));
	}

	@Test
	public void should_false_when_postCode_length_is_not_10() {
		assertFalse(BarCodeTransfer.validPostCode(not10NumberPostCode));
	}

	@Test
	public void should_true_when_postCode_is_5_length_nomal() {
		assertTrue(BarCodeTransfer.transferPostCard2BarCode(
				normal5lengthPostCode).equals(
						normal5lengthBarCode));
	}

	@Test
	public void should_true_when_postCode_is_9_length_nomal() {
		// System.out.println(BarCodeTransfer.transferPostCard2BarCode(normal9lengthPostCode));
		assertTrue(BarCodeTransfer.transferPostCard2BarCode(
				normal9lengthPostCode).equals(
						normal9lengthBarCode));
	}

	@Test
	public void should_true_when_postCode_is_10_length_nomal() {
		// System.out.println(BarCodeTransfer.transferPostCard2BarCode(normal10lengthPostCode));
		assertTrue(BarCodeTransfer.transferPostCard2BarCode(
				normal10lengthPostCode).equals(
						normal10lengthBarCode));
	}
	
	@Test
	public void should_true_when_barCode_is_5_length_nomal() {
		assertTrue(BarCodeTransfer.transferBarCard2PostCode(
				normal5lengthBarCode).equals(normal5lengthPostCode));
	}
	
	@Test
	public void should_true_when_barCode_is_9_length_nomal() {
		assertTrue(BarCodeTransfer.transferBarCard2PostCode(
				normal9lengthBarCode).equals(normal10lengthPostCode));
	}
	
	@Test
	public void should_true_when_barCode_is_10_length_nomal() {
		assertTrue(BarCodeTransfer.transferBarCard2PostCode(
				normal10lengthBarCode).equals(normal5lengthPostCode));
	}

}
