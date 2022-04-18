package br.com.fernando.moviesbattle.utils;

import java.util.Random;

public class Util {
	public static int geraNumerosRandom(int min, int max) {
		Random aleatorio = new Random();
		return aleatorio.nextInt((max - min) + 1) + min;
	}
}
