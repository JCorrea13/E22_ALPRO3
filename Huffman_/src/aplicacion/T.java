/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.BitSet;

/**
 *
 * @author 16171024
 */
public class T {

    public static void main(String[] args) {

	// Set two bits in a BitSet.
	BitSet b = new BitSet();
	b.set(10);
	b.set(100);

	// Get values of these bit positions.
	boolean bit1 = b.get(5);
	boolean bit2 = b.get(10);
	boolean bit3 = b.get(100);

	System.out.println(bit1);
	System.out.println(bit2);
	System.out.println(bit3);
    }

}
