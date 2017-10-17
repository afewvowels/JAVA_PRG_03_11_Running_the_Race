/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_prg_03_11_running_the_race;

import javax.swing.JOptionPane;
/**
 *
 * @author bluebackdev
 * Write a program that asks for the names of three runners and the times, in
 * minutes, it took each of them to finish a race. The program should display
 * the names of the runners in the order that they finished.
 */
public class JAVA_PRG_03_11_Running_the_Race {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare strings to hold user inputs and runner's names
        // And final output string to format values
        String strTime01;
        String strTime02;
        String strTime03;
        String strName01;
        String strName02;
        String strName03;
        String strFormattedOutputMsg;
        
        // Declare floats to hold runner values for comparison
        float fltTime01;
        float fltTime02;
        float fltTime03;
        
        // Get user inputs on names and times for the three runners
        strName01 = JOptionPane.showInputDialog("Please enter the name of"
                + "\nthe first runner.");
        strTime01 = JOptionPane.showInputDialog("Please enter the amount of " +
                "time\nit took " + strName01 + " to run the race.");
        
        strName02 = JOptionPane.showInputDialog("Please enter the name of"
                + "\nthe second runner.");
        strTime02 = JOptionPane.showInputDialog("Please enter the amount of " +
                "time\nit took " + strName02 + " to run the race.");
        
        strName03 = JOptionPane.showInputDialog("Please enter the name of"
                + "\nthe third runner.");
        strTime03 = JOptionPane.showInputDialog("Please enter the amount of " +
                "time\nit took " + strName03 + " to run the race.");
        
        // Convert string times to floats for comparison
        fltTime01 = Float.parseFloat(strTime01);
        fltTime02 = Float.parseFloat(strTime02);
        fltTime03 = Float.parseFloat(strTime03);
        
        // Declare temp float and string for swapping values to
        // reorder the list so that 1, 2, and 3 are in order
        // for a single output string instead of nesting different
        // output messages in the if/else statement
        String strTemp;
        float fltTemp;
        
        // Compare floats to determine race order for output
        // This order of if statements accounts for the worst
        // case scenario of reverse order in three swaps:
        // Initial      1       2       3
        // C            B       B       A
        // B            C       A       B
        // A            A       C       C
        // 1. Check if first is greater than second, if so, swap.
        if(fltTime01 > fltTime02)
        {
            strTemp = strName01;
            fltTemp = fltTime01;
            
            strName01 = strName02;
            fltTime01 = fltTime02;
            
            strName02 = strTemp;
            fltTime02 = fltTemp;
        }
        // 2. Check if second is greater than third, if so swap.
        if(fltTime02 > fltTime03)
        {
            strTemp = strName02;
            fltTemp = fltTime02;

            strName02 = strName03;
            fltTime02 = fltTime03;

            strName03 = strTemp;
            fltTime03 = fltTemp;

        }
        // 3. Check if first is now greater than second, if so swap.
        if(fltTime01 > fltTime02)
        {
            strTemp = strName01;
            fltTemp = fltTime01;

            strName01 = strName02;
            fltTime01 = fltTime02;

            strName02 = strTemp;
            fltTime02 = fltTemp;
        }
        
        // Format message for output, place runner's names and their times
        // on three separate lines for output in next step
        strFormattedOutputMsg = String.format("Runner " + strName01 + "\'s " +
                "time of %.2f put him or her first.\nRunner " + strName02 +
                "\'s time of %.2f put him or her second.\nRunner " + strName03 +
                "\'s time of %.2f put him or her third.", fltTime01, fltTime02,
                fltTime03);
        
        // Output formatted message to console
        JOptionPane.showMessageDialog(null, strFormattedOutputMsg);
        
        // For JOptionPane
        System.exit(0);
    }
    
}
