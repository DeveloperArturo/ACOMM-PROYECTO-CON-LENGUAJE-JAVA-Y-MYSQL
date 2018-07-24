package Array;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Clases.claseCliente;


public class ArrayCliente {

	ArrayList<claseCliente> c=new ArrayList<claseCliente>();

	public ArrayCliente() {
		
	}
	

	public int tamaño() {
		return c.size();
	}
	public claseCliente obtener(int i){
		return c.get(i);
	}
	public void eliminarTodo(){
		c.clear();
	}
	public void agregar(claseCliente a){
		c.add(a);
	}
	public int generar(){
		int codigo=1001;
		if(tamaño()==0){
			codigo=1001;
		}else{
			codigo=(obtener(c.size()-1).getIDcliente()+1);
		
	
		}
			return codigo;
	}
	
	
	public void modificar(int p,claseCliente  u){
		c.set(p,u);
		
		
	}
	
	public void remover(int r){
		c.remove(r);
	}
	
	

	




}
