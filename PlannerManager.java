package HW1;
import java.util.Scanner;

/**
* The <code>PlannerManager</code> class contains the main method
* that handles the Planner class.
*
*
* @author Minqi Shi
* email: minqi.shi@stonybrook.edu
* Stony Brook ID: 111548035
**/

public class PlannerManager
{
    /**
    * The main method runs a menu driven application which first creates 
    * an empty Planner object. The program prompts the user for a command 
    * to execute an operation. Once a command has been chosen, the program 
    * may ask the user for additional information if necessary, 
    * and performs the operation.
    **/
    public static void main(String[] args)
    {
        Planner planner = new Planner();
        Planner plannerBackup = new Planner();
        System.out.println("(A) Add Course");
        System.out.println("(G) Get Course");
        System.out.println("(R) Remove Course");
        System.out.println("(P) Print Courses in Planner");
        System.out.println("(F) Filter by Department Code");
        System.out.println("(L) Look For Course");
        System.out.println("(S) Size");
        System.out.println("(B) Backup");
        System.out.println("(PB) Print Courses in Backup");
        System.out.println("(RB) Revert to Backup");
        System.out.println("(Q) Quit");
        System.out.println();
        // Create a Scanner stdin.
        Scanner stdin = new Scanner(System.in);
        String data = "";
        while (!data.equals("Q"))
        {
            try
            {
            System.out.print("Enter a selection: ");
            data = stdin.nextLine();
            System.out.println();
            if (data.equals("A"))
            {
                System.out.print("Enter course name: "); 
                String name = stdin.nextLine();
                System.out.print("Enter department: "); 
                String department = stdin.nextLine();
                try
                {
                    System.out.print("Enter course code: "); 
                    int code = Integer.parseInt(stdin.nextLine());
                    if(code<0)
                        throw new IllegalArgumentException();
                    System.out.print("Enter course section: "); 
                    byte section = (byte) Integer.parseInt(stdin.nextLine());
                    if(section<0)
                        throw new IllegalArgumentException();
                    System.out.print("Enter instructor: "); 
                    String instructor = stdin.nextLine();
                    System.out.print("Enter position: ");
                    int position = Integer.parseInt(stdin.nextLine());
                    Course course = new Course(name, department, instructor,
                      code, section);
                    planner.addCourse(course,position);
                }
                catch(IllegalArgumentException iae)
                {
                    System.out.println("The input is invalid!");
                }
            }
            else if(data.equals("G"))
            {
                try
                {
                System.out.print("Enter position: ");
                int position = Integer.parseInt(stdin.nextLine());
                if (position<1||position>planner.size())
                    throw new IllegalArgumentException();
                System.out.println();
                System.out.print("Planner:\n"
                  +"No. Course Name               "
                  +"Department Code Section Instructor\n"
                  +"-------------------------------------------"
                  +"------------------------------------\n");
                System.out.printf("%3d %-26s%-12s%-8d %02d %s\n",
                  position, planner.getCourse(position).getName(), 
                  planner.getCourse(position).getDepartment(), 
                  planner.getCourse(position).getCode(),
                  planner.getCourse(position).getSection(), 
                  planner.getCourse(position).getInstructor());
                }
                catch(IllegalArgumentException iae)
                {
                    System.out.println("The position is invalid!");
                }
            }
            else if(data.equals("R"))
            {
                try
                {
                System.out.print("Enter position: ");
                int position = Integer.parseInt(stdin.nextLine());
                if (position<1||position>planner.size())
                    throw new IllegalArgumentException();
                String message = planner.getCourse(position).getDepartment()
                  + " " + planner.getCourse(position).getCode() + ".0" 
                  + planner.getCourse(position).getSection()
                  + " has been successfully removed from the planner.";                
                planner.removeCourse(position);
                System.out.println();
                System.out.println(message);
                }
                catch(IllegalArgumentException iae)
                {
                    System.out.println("The position is invalid!");
                }
            }
            else if(data.equals("P"))
            {
                System.out.println("Planner:");
                planner.printAllCourses();
            }
            else if(data.equals("F"))
            {
                System.out.print("Enter department code: ");
                String department = stdin.nextLine();
                System.out.println();
                Planner.filter(planner,department);
            }
            else if(data.equals("L"))
            {
                System.out.print("Enter course name: ");
                String name = stdin.nextLine();
                System.out.print("Enter department: "); 
                String department = stdin.nextLine();
                System.out.print("Enter course code: "); 
                int code = Integer.parseInt(stdin.nextLine());
                System.out.print("Enter course section: "); 
                byte section = (byte) Integer.parseInt(stdin.nextLine());
                System.out.print("Enter instructor: "); 
                String instructor = stdin.nextLine();
                Course course = new Course(name, department, instructor, 
                  code, section);
                System.out.println();
                if(planner.exists(course))
                {
                    int position = 0;
                    for (int i = 1;i <= planner.size(); i++)
                    {
                        if(course.equals(planner.getCourse(i)))
                            position = i;
                    }
                    System.out.println(department + " " + code + ".0" 
                      + section + " is found in the planner at position "
                      + position + ".");
                }
                else
                    System.out.println(department + " " + code + ".0" 
                      + section + " is not found in the planner.");
            }
            else if(data.equals("S"))
            {
                System.out.println("There are "+ planner.size() 
                  +" courses in the planner.");
            }
            else if(data.equals("B"))
            {
                plannerBackup = (Planner)planner.clone();
                System.out.println("Created a backup of the current planner.");
            }
            else if(data.equals("PB"))
            {
                System.out.println("Planner (Backup):");
                plannerBackup.printAllCourses();
            }
            else if(data.equals("RB"))
            {
                planner = (Planner)plannerBackup.clone();
                System.out.println("Planner successfully reverted to "
                  + "the backup copy.");
            }
            else if(data.equals("Q"))
                break;
            else
            {
                System.out.println("Invalid selection!");
            }
            System.out.println();
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Invalid input!");
                System.out.println();
            }
        }
        System.out.println("Program terminating successfully...");
    }
}