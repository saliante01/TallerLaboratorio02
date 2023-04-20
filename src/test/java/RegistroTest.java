import static org.junit.jupiter.api.Assertions.*;



class RegistroTest {
    Registro registro;
    String[][] arrayPrueba = new String[50][3];

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        registro = new Registro();
    }


    @org.junit.jupiter.api.Test
    void obtenerUltimoEspacio() {
        assertEquals(Registro.ultimoIndex(arrayPrueba), 50);
    }

    @org.junit.jupiter.api.Test
    void verificarEspacio() {
        assertTrue(Registro.ultimoIndex(arrayPrueba) != 0);
    }

    @org.junit.jupiter.api.Test
    void ultimoIndex() {
        assertEquals(arrayPrueba.length - Registro.ultimoIndex(arrayPrueba), 0);
    }
}