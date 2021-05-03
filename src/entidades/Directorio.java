package entidades;
/*
Un directorio telefónico posee una lista de Clientes de los que interesa conocer su dni,
nombre, apellido, ciudad y dirección.
El directorio telefónico posee además las siguientes funcionalidades:
● agregarCliente() que permite registrar un nuevo cliente con su respectivo nro de
teléfono. Siendo el nro del teléfono la clave del mismo.
● buscarCliente() que en base al nro de teléfono retorna el Cliente asociado al
mismo.
● buscarTeléfono() que en base a un apellido nos devuelve una lista con los nros de
teléfono asociados a dicho apellido.
● buscarClientes() que en base a una ciudad nos devuelve una lista con los Clientes
asociados a dicha ciudad.
● borrarCliente() que en base a un dni elimina el cliente del directorio.
Importante: Armar el modelo UML representado las clases necesarias. Implementar en java.
*/
import java.util.*;

public class Directorio {
    private TreeMap<Long,Cliente> directorio = new TreeMap<>();
    
    
    
    public Cliente agregarCliente(long tel, Cliente c){    
        return directorio.put(tel,c);
    }
    
    public Cliente buscarCliente(long tel){
        return directorio.get(tel);
    }
    
    public Set<Long> buscarTelefono(String apellido) {
        Set<Long> aux = new HashSet<>();
        directorio.keySet().forEach(a -> {
            if (directorio.get(a).getApellido().equals(apellido)) {
                aux.add(a);
            }
        });

        return aux;
    }
    
    public List<Cliente> buscarClientes(String ciudad){
        List<Cliente> aux= new ArrayList<>();
        directorio.values().forEach(a-> {
            if (a.getCiudad().equals(ciudad)){
                aux.add(a);
            }
        });
        
        return aux;
    }
    
    public Cliente borrarCliente(long dni){
        Cliente aux=null;
        for (Long a:directorio.keySet()){
            if (directorio.get(a).getDni()==dni){
                return directorio.remove(a);
            }
        }
        
        return aux;
    }

    public TreeMap<Long, Cliente> getDirectorio() {
        return directorio;
    }
}