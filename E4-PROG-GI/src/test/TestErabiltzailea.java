package test;

import java.util.Date;

import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.Assert.*;

public class TestErabiltzailea {
    public static void main(String[] args) {
        // Create a new Erabiltzailea object
        Erabiltzailea erabiltzailea = new Erabiltzailea("user1", "password1", "John", "Doe", new Date(), "English");

        // Test the getters
        System.out.println("Erabiltzailea: " + erabiltzailea.getErabiltzailea());
        System.out.println("Pasahitza: " + erabiltzailea.getPasahitza());
        System.out.println("Izena: " + erabiltzailea.getIzena());
        System.out.println("Abizena: " + erabiltzailea.getAbizena());
        System.out.println("JaiotzeData: " + erabiltzailea.getJaiotzeData());
        System.out.println("Hizkuntza: " + erabiltzailea.getHizkuntza());

        // Test the setters
        erabiltzailea.setErabiltzailea("user2");
        erabiltzailea.setPasahitza("password2");
        erabiltzailea.setIzena("Jane");
        erabiltzailea.setAbizena("Smith");
        erabiltzailea.setJaiotzeData(new Date());
        erabiltzailea.setHizkuntza("Spanish");

        // Test the toString method
        System.out.println("Erabiltzailea: " + erabiltzailea.toString());

        // Test the equals method
        Erabiltzailea erabiltzailea2 = new Erabiltzailea("user2", "password2", "Jane", "Smith", new Date(), "Spanish");
        System.out.println("Equals: " + erabiltzailea.equals(erabiltzailea2));
    }
}