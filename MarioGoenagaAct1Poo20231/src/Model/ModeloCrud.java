package Model;

import java.util.List;

public interface ModeloCrud<Clase> {

    public void agregar(Clase objeto) throws Exception;
    public Clase buscar(String codigo) throws Exception;
    public void editar(Clase objeto) throws Exception;
    public void eliminar(String codigo) throws Exception;
    public List<Clase> listarTodo() throws Exception;
    public int contar() throws Exception;

        
}
