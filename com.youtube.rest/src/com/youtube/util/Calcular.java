package com.youtube.util;

import java.util.Scanner;

public class Calcular {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Double numero, xx;
        do{
            System.out.print("Introduce numero mayor: ");
            numero = sc.nextDouble();
        }while(numero<=1);
        //System.out.println("Los " + numero + " primeros términos de la serie de Fibonacci son:");
        System.out.println("ingreso el numero : "+numero);
        
        
        xx = CalcY(numero);
        CalcX(xx);
        
        
        String p = "PRUEBA";
        String resultado="";
        String resultado2="";
        int i;
        for(i= p.length(); i>=1; i-- ){
        	
        	int inicio, fin;
        	
        	inicio = i;
        	fin = i-1;
        	
        	resultado = p.substring(fin,inicio);
        	resultado2= resultado2 + resultado;
        	resultado="";
        	//System.out.println(resultado2);
        }
        
        System.out.println("resultado: "+resultado2);
        
        
        
        
	}
	
	public static Double CalcY (Double numero){
		Double y;
		
		y = numero /4;
		
		System.out.println("El valor de Y es :"+ y);
		return y;
	}

	public static void CalcX (Double y){
		Double X;
		
		X = y * 3;
		
		System.out.println("El valor de x es :"+ X);
	}

	
}
