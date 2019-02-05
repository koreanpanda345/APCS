package Main.Chapter5.Problem5_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task implements Priority
{
    ArrayList<String> items = new ArrayList();
    int pos;
    String name;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Please enter your first item");
        String i1Name = scan.nextLine();
        System.out.println("Now enter your second item");
        String i2Name = scan.nextLine();
        System.out.println("Finally enter your last item");
        String i3Name = scan.nextLine();
        Task list = new Task();
        list.makeItem(i1Name, 0);
        list.makeItem(i2Name, 1);
        list.makeItem(i3Name, 2);
        System.out.println("What would you like to do?\nCommands:\nMake - lets you make a new item\nGet - lets your get an item by its priority ranking.\nSet - lets you fix the priority ranking.");
        

    }
    public Task()
    {

    }
    public void setPriority(int position,int priority)
    {
        setItem(position, priority);
    }
    public void getPriority(int position)
    {
        grabItem(position);
    }
    public void makeItem(String item, int position)
    {
        items.set(position, item);
    }
    public String grabItem(int position)
    {
        String item = items.get(position);
        return item;
    }
    public void setItem(int posit, int position)
    {
        Collections.swap(items, posit, position);
    }

}
