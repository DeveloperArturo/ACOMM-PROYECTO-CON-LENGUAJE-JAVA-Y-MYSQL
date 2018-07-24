package Array;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Clases.claseBebida;

public class ArrayBebida {
	
		
	
	ArrayList<claseBebida> b=new ArrayList<claseBebida>();
	
	
	
public ArrayBebida() {

	
}


	public int tamaño(){
		return b.size();
	}
	public claseBebida Obtener(int i) {
		return b.get(i);
		
	}
	
	public void eliminarTodo(){
		b.clear();
	}
	public void agregar(claseBebida l){
		b.add(l);
	}
	public void modificar(int p,claseBebida u){
		b.set(p,u);
		
		
	}
	
	public void remover(int r){
		b.remove(r);
	}
	public int generar(){
		int codigo=1001;
		if(tamaño()==0){
			codigo=1001;
		}else{
			codigo=(Obtener(b.size()-1).getIDBebida()+1);
		
	
		}
			return codigo;
	}
	
	
	public claseBebida buscar(int codigo){
		claseBebida x=null;
		for (int i = 0; i < tamaño(); i++) 
			if(Obtener(i).getIDBebida()==codigo){
				x=Obtener(i);
				break;
			}
			return x;
		
		
	}
	public void eliminarfinal(){
		b.remove(tamaño()-1);
	}
	

	
		
	




}