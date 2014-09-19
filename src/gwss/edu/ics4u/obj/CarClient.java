/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.obj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1GHAHREMANZA
 */
public class CarClient {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        ArrayList<Car> Car = new ArrayList<Car>();
        
        for(int i = 0; i < 5; i++) {
            Car b = new Car();
            System.out.print("Brand: ");
            b.setCarBrand(input.nextLine());
            
            Car.add(b);
        }
        

        
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        
        car1.setCarBrand("Lexus");
        
        
    }
    
}
