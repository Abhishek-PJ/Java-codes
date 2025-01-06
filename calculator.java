import java.util.Scanner;

class calculator1{
    private int num1;
    private int num2;

    public calculator1(int num1, int num2){
    this.num1=num1;
    this.num2=num2;
    
}

public int addition(int num1,int num2){
return this.num1 + this.num2;   
}


public int subtract(int num1,int num2){
    return this.num1 - this.num2;   
    }
    
public int multiply(int num1,int num2){
    return this.num1 * this.num2;   
    }
    
public int divide(int num1,int num2){
    return this.num1 / this.num2;   
    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter  your choice");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            int num1,num2;
            int choice=in.nextInt();
            if(choice==5){
                System.out.println("Exiting from calculator");
                break;
            }


            System.out.println("Enter the first number");
            num1=in.nextInt();
            System.out.println("Enter the second number");
            num2=in.nextInt();
            calculator1 cal= new calculator1(num1,num2);

            switch (choice) {
                case 1:
            System.out.println("Result is:" +cal.addition(num1,num2));
                    break;
                    case 2:
            System.out.println("Result is:" +cal.subtract(num1,num2));
                    break;
                    case 3:
            System.out.println("Result is:" +cal.multiply(num1,num2));
                    break;
                    case 4:
            System.out.println("Result is:" +cal.divide(num1,num2));
                    break;
                    default:
            System.out.println("Enter correct inputs");
                    break;
            
                
            }
            System.out.println(" ");
        
    
        }
        in.close();
    }

}
