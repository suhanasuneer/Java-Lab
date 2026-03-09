import java.util.Scanner;

class Overload {
  	  void area(float x) {
          System.out.println("The area of the square is " + Math.pow(x, 2) + " sq units");
  	  }
  	  void area(float x, float y) {
          System.out.println("The area of the rectangle is " + (x * y) + " sq units");
  	  }
  	  void area(double x) {
         double z = 3.14 * x * x;
          System.out.println("The area of the circle is " + z + " sq units");
    }
}

class Over_Load {
    	public static void main(String[] args) {

        Overload ob = new Overload();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter your Choice");
            System.out.println("\n1. Area of Square");
            System.out.println("\n2. Area of Rectangle");
            System.out.println("\n3. Area of Circle");
            System.out.println("\n4. Exit");

            int choice;
            float a, b;
            double x;

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the length of the square:");
                    a = sc.nextFloat();
                    ob.area(a);
                    break;

                case 2:
                    System.out.println("Enter the length of rectangle:");
                    a = sc.nextFloat();
                    System.out.println("Enter the breadth of rectangle:");
                    b = sc.nextFloat();
                    ob.area(a, b);
                    break;

                case 3:
                    System.out.println("Enter the radius of the circle:");
                    x = sc.nextDouble();
                    ob.area(x);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}

	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
