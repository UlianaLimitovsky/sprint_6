package com.example;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class LionTest {

    private Lion lion;
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(4);
        assertEquals(4, lion.getKittens());
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо"));
        assertEquals(List.of("Мясо"), lion.getFood());
    }
    @Test
    public void testDoesHaveMane_Female() throws Exception {
        Lion lionFemale = new Lion("Самка", felineMock);
        assertFalse(lionFemale.doesHaveMane());
    }
    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        new Lion("Некорректный пол", felineMock);
    }

    @Test(expected = Exception.class)
    public void testGetFoodException() throws Exception {
        when(felineMock.getFood("Хищник")).thenThrow(new Exception("Ошибка получения пищи"));
        lion.getFood();
    }


}