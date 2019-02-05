package Main.Chapter5;

import javax.swing.*;

public class sumAndProduct
{
    public static void main(String[] args)
    {
        String numStr1, numStr2, result;
        int num1, num2,sum, product, again;

        do
        {
          numStr1 = JOptionPane.showInputDialog("Enter an integer: ");
          num1 = Integer.parseInt(numStr1);

          numStr2 = JOptionPane.showInputDialog("Enter another integer");
          num2 = Integer.parseInt(numStr2);

          sum = num1 + num2;
          product = num1 * num2;

          result = "The sum is " + sum + ".\nThe product is " + product + ".";
          JOptionPane.showMessageDialog(null, result);

          again = JOptionPane.showConfirmDialog(null, "Do Another?");
        }
        while(again == JOptionPane.YES_OPTION);
    }
}
