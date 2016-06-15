package util;

/**
 * @author Jose Correa
 */
public class ManejadorCadenas {
    
    public static int buscaConcurrencia(String cadena, String cadena_a_buscar, int concurrencia){
        if(concurrencia == 1)
            return cadena.indexOf(cadena_a_buscar);
        
        return buscaConcurrencia(cadena.substring(cadena.indexOf(cadena_a_buscar)+1), cadena_a_buscar, concurrencia-1);
    }
}
