/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tall.inc;

import java.util.Random;

/**
 *
 * @author timme
 */
public class Varudeklaration {

    public Varudeklaration() {
        skapaVaruDek();
        randomVaruDek();

    }

    public static String skapaVaruDek() {
        String varuKod = "ZXY11123";
        return varuKod;

    }

    public static String randomVaruDek() {
        Random rnd = new Random();
        int nummer = rnd.nextInt(99999999);
        return String.format("%08d", nummer);
    }
}
