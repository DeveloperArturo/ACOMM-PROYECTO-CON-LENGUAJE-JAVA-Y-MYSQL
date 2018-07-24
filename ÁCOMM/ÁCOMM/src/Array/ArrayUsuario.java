package Array;
import java.util.ArrayList;
import java.util.LinkedList;
import Clases.claseUsuario;
public class ArrayUsuario {
	
		
	ArrayList<claseUsuario> u=new 	ArrayList<claseUsuario>();

	public ArrayUsuario() {
	
	}
	public int tamaño() {
		
	return u.size();
	}
	
	public void eliminarTodo(){
	u.clear();
	}
	public void agregar(claseUsuario a){
	u.add(a);
	
	}
	public void remover(int r){
	u.remove(r);
	}
	
	public claseUsuario recibir(int i){
	return  u.get(i);
						
	}
	public void modificar(int p,claseUsuario us){
	u.set(p, us);
	}
	
	public int generar(){
		if(u.size()==0){
			return 1000;
		}else{
			return recibir(u.size()-1).getcodigo()+1;
		}
	}
	
	
	
	
}
