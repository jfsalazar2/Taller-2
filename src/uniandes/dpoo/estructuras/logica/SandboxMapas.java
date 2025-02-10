package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    private Map<String, String> mapaCadenas;

    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    public List<String> getValoresComoLista( )
    {
        return new ArrayList<>(mapaCadenas.values()).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getLlavesComoListaInvertida( )
    {
        return new ArrayList<>(mapaCadenas.keySet()).stream()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
    }

    public String getPrimera( )
    {
        return mapaCadenas.isEmpty() ? null : mapaCadenas.keySet().stream().sorted().findFirst().orElse(null);
    }

    public String getUltima( )
    {
        return mapaCadenas.isEmpty() ? null : mapaCadenas.values().stream().sorted().reduce((first, second) -> second).orElse(null);
    }

    public Collection<String> getLlaves( )
    {
        return mapaCadenas.keySet().stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public int getCantidadCadenasDiferentes( )
    {
        return (int) mapaCadenas.values().stream().distinct().count();
    }

    public void agregarCadena( String cadena )
    {
        String llave = new StringBuilder(cadena).reverse().toString();
        mapaCadenas.putIfAbsent(llave, cadena);
    }

    public void eliminarCadenaConLLave( String llave )
    {
        mapaCadenas.remove(llave);
    }

    public void eliminarCadenaConValor( String valor )
    {
        mapaCadenas.values().removeIf(v -> v.equals(valor));
    }

    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();
        for (Object obj : objetos) {
            String cadena = obj.toString();
            String llave = new StringBuilder(cadena).reverse().toString();
            mapaCadenas.put(llave, cadena);
        }
    }

    public void volverMayusculas( )
    {
        Map<String, String> nuevoMapa = new HashMap<>();
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
            nuevoMapa.put(entry.getKey().toUpperCase(), entry.getValue());
        }
        mapaCadenas = nuevoMapa;
    }

    public boolean compararValores( String[] otroArreglo )
    {
        List<String> valores = new ArrayList<>(mapaCadenas.values());
        for (String valor : otroArreglo) {
            if (!valores.contains(valor)) {
                return false;
            }
        }
        return true;
    }
}