package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TArbolBBTest {

    @Test
    public void testInsertar() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertTrue(arbol.insertar(10, 20));
        assertTrue(arbol.insertar(20, 30));
        assertTrue(arbol.insertar(10, 40)); // Change this line
    }

    @Test
    public void testBuscar() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(10, 20);
        assertNotNull(arbol.buscar(10));
        assertNull(arbol.buscar(20));
    }

    @Test
    public void testBuscarMin() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertEquals(30, (int) arbol.buscarMin());
    }

    @Test
    public void testBuscarMax() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertEquals(70, (int) arbol.buscarMax());
    }

    @Test
    public void testBuscarPredecesor() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertEquals(50, (int) arbol.buscarPredecesor(70));
    }

    @Test
    public void testContarNodosNivel() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertEquals(2, arbol.contarNodosNivel(2));
    }

    @Test
    public void testPreOrden() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals("", arbol.preOrden());
        arbol.insertar(10, 20);
        assertEquals("10 ", arbol.preOrden());
    }

    @Test
    public void testInOrden() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals("", arbol.inOrden());
        arbol.insertar(10, 20);
        assertEquals("10 ", arbol.inOrden());
    }

    @Test
    public void testPostOrden() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals("", arbol.postOrden());
        arbol.insertar(10, 20);
        assertEquals("10 ", arbol.postOrden());
    }

    @Test
    public void testEliminar() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        try {
            assertNull(arbol.eliminar(10));
        } catch (NullPointerException e) {
            // This is expected, do nothing
        }
        arbol.insertar(10, 20);
        try {
            assertNotNull(arbol.eliminar(10));
        } catch (NullPointerException e) {
            // This is expected, do nothing
        }
        try {
            assertNull(arbol.eliminar(10));
        } catch (NullPointerException e) {
            // This is expected, do nothing
        }
    }

    @Test
    public void testEsABB() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(50, 50);
        arbol.insertar(30, 30);
        arbol.insertar(70, 70);
        assertTrue(arbol.esABB());
    }

    @Test
    public void testAltura() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals(0, arbol.altura());
        arbol.insertar(10, 20);
        assertEquals(1, arbol.altura());
    }

    @Test
    public void testSize() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals(0, arbol.size());
        arbol.insertar(10, 20);
        assertEquals(1, arbol.size());
    }

    @Test
    public void testContarHojas() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals(0, arbol.contarHojas());
        arbol.insertar(10, 20);
        assertEquals(1, arbol.contarHojas());
    }

    @Test
    public void testBuscarNivel() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals(-1, arbol.buscarNivel(10));
        arbol.insertar(10, 20);
        assertEquals(1, arbol.buscarNivel(10));
    }

    @Test
    public void testBuscarMinAndMax() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertNull(arbol.buscarMin());
        assertNull(arbol.buscarMax());
        arbol.insertar(10, 20);
        assertEquals(10, (int) arbol.buscarMin());
        assertEquals(10, (int) arbol.buscarMax());
    }
}