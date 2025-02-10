package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas
{
    private List<Integer> listaEnteros;
    private List<String> listaCadenas;

    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    public List<Integer> getCopiaEnteros( )
    {
        List<Integer> copia = new ArrayList<>(listaEnteros.size());
        for (Integer entero : listaEnteros) {
            copia.add( Integer.valueOf(entero));
        }
        return copia;
    }

    public List<String> getCopiaCadenas( )
    {
        List<String> copia = new ArrayList<>(listaCadenas.size());
        for (String cadena : listaCadenas) {
            copia.add(new String(cadena));
        }
        return copia;
    }

    public int[] getEnterosComoArreglo( )
    {
        int[] arreglo = new int[listaEnteros.size()];
        for (int i = 0; i < listaEnteros.size(); i++) {
            arreglo[i] = listaEnteros.get(i);
        }
        return arreglo;
    }

    public int getCantidadEnteros( )
    {
        return listaEnteros.size();
    }

    public int getCantidadCadenas( )
    {
        return listaCadenas.size();
    }

    public void agregarEntero( int entero )
    {
        listaEnteros.add(entero);
    }

    public void agregarCadena( String cadena )
    {
        listaCadenas.add(cadena);
    }

    public void eliminarEntero( int valor )
    {
        listaEnteros.removeIf(entero -> entero.equals(valor));
    }

    public void eliminarCadena( String cadena )
    {
        listaCadenas.removeIf(c -> c.equals(cadena));
    }

    public void insertarEntero( int entero, int posicion )
    {
        if (posicion < 0) {
            listaEnteros.add(0, entero);
        } else if (posicion >= listaEnteros.size()) {
            listaEnteros.add(entero);
        } else {
            listaEnteros.add(posicion, entero);
        }
    }

    public void eliminarEnteroPorPosicion( int posicion )
    {
        if (posicion >= 0 && posicion < listaEnteros.size()) {
            listaEnteros.remove(posicion);
        }
    }

    public void reiniciarArregloEnteros( double[] valores )
    {
        listaEnteros.clear();
        for (double valor : valores) {
            listaEnteros.add((int) valor);
        }
    }

    public void reiniciarArregloCadenas( List<Object> objetos )
    {
        listaCadenas.clear();
        for (Object obj : objetos) {
            listaCadenas.add(obj.toString());
        }
    }

    public void volverPositivos( )
    {
        for (int i = 0; i < listaEnteros.size(); i++) {
            listaEnteros.set(i, Math.abs(listaEnteros.get(i)));
        }
    }

    public void organizarEnteros( )
    {
        listaEnteros.sort((a, b) -> b - a); // Ordenar de mayor a menor
    }

    public void organizarCadenas( )
    {
        listaCadenas.sort(String::compareTo);
    }

    public int contarApariciones( int valor )
    {
        int count = 0;
        for (Integer entero : listaEnteros) {
            if (entero.equals(valor)) {
                count++;
            }
        }
        return count;
    }

    public int contarApariciones( String cadena )
    {
        int count = 0;
        for (String c : listaCadenas) {
            if (c.equalsIgnoreCase(cadena)) {
                count++;
            }
        }
        return count;
    }

    public int contarEnterosRepetidos( )
    {
        List<Integer> contados = new ArrayList<>();
        int count = 0;
        for (Integer entero : listaEnteros) {
            if (contados.contains(entero)) {
                continue;
            }
            if (contarApariciones(entero) > 1) {
                count++;
                contados.add(entero);
            }
        }
        return count;
    }

    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (otroArreglo.length != listaEnteros.size()) {
            return false;
        }
        for (int i = 0; i < otroArreglo.length; i++) {
            if (!listaEnteros.get(i).equals(otroArreglo[i])) {
                return false;
            }
        }
        return true;
    }

    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        listaEnteros.clear();
        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
            listaEnteros.add(numeroAleatorio);
        }
    }
}
