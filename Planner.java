package HW1;

/**
* The <code>Planner</code> class stores an ordered list of 
* <code>Course</code> objects
* 
*
* @author Minqi Shi
* email: minqi.shi@stonybrook.edu
* Stony Brook ID: 111548035
**/

public class Planner
{
    // The maxium number of courses in a Planner.
    public static final int MAX_COURSES = 50; 
    private Course[] courseArray; // An array containing the courses.
    // The count of course(s) in the Planner.
    private int itemsCurrentlyInList; 

    /**
    * Returns an instance of <code>Planner</code>. 
    *
    * <dt>Postcondition:
    *    <dd><code>courseArray</code> must be an empty array.
    * 
    **/
    public Planner()
    {
    	this.courseArray = new Course[MAX_COURSES];
        itemsCurrentlyInList = 0;
    } 

    /**
    * Determines the number of courses currently in the list.
    *
    * <dt>Preconditions:
    *    <dd>This <code>Planner</code> has been instantiated.
    *
    * @return
    *    The number of Courses in this Planner.
    **/
    public int size()
    {
        return itemsCurrentlyInList;
    }
    
    /**
    * Set the number of courses currently in the list.
    *
    * <dt>Preconditions:
    *    <dd>This <code>Planner</code> has been instantiated.
    *
    **/
    public void setSize(int size)
    {
        this.itemsCurrentlyInList = size;
    }
    
    
    /**
    * Add a new Course in the Planner.
    *
    * @param newCourse
    *    the new course to add to the list.
    * 
    * @param position
    *    the position (preference) of this course on the list.
    * 
    * <dt>Preconditions:
    *   <dd>This Course object has been instantiated and 
    *   1 ≤ position ≤ items_currently_in_list + 1. 
    *   The number of Course objects in this Planner 
    *   is less than MAX_COURSES.
    *
    * <dt>Postconditions:
    *   <dd>The new Course is now listed in the correct preference 
    *   on the list. All Courses that were originally greater than 
    *   or equal to position are moved back one position. 
    *
    * @exception IllegalArgumentException
    *    Indicates that position is not within the valid range.
    *
    * @exception FullPlannerException
    *    Indicates that there is no more room in the Planner 
    *    to record an additional Course.
    **/
    public void addCourse(Course newCourse, int position)
    {
    	try
    	{
            if (this.size() == MAX_COURSES)
                throw new FullPlannerException();
            if (position < 1 || position > this.size()+1)
                throw new IllegalArgumentException();
            // The message storing the information to print later
            String message = newCourse.getDepartment() + " " + 
                  newCourse.getCode() + ".0" + newCourse.getSection()
                  + " successfully added to planner.";
            if (position == this.size()+1)
            {
                courseArray[position-1] = newCourse.clone();
            }   
            else if (position < this.size()+1)
            {
    	        // A Course object temp to store the course to be replaced.
                Course temp = courseArray[position-1].clone(); 
                courseArray[position-1] = newCourse.clone();
                position++;
                while (position-1 < this.size())
                {
                    newCourse = courseArray[position-1].clone();
                    courseArray[position-1] = temp.clone();
                    temp = newCourse.clone();
                    position++;
                }
                courseArray[position-1] = temp.clone();
            }
            this.setSize(this.size()+1);
            System.out.println();
            System.out.println(message);
    	}
    	catch(IllegalArgumentException iae)
    	{
            System.out.println("Position is not within the valid range!");
    	}
    	catch(FullPlannerException fpe)
    	{
            System.out.println("there is no more room in the Planner to "
              +"record an additional Course.");
    	}
    }


    /**
    * Add a new Course in the Planner to the end of the list.
    *
    * @param newCourse
    *    The new course to add to the list.
    * 
    * <dt>Preconditions:
    *   <dd>This Course object has been instantiated and 
    *   1 ≤ position ≤ items_currently_in_list + 1. 
    *   The number of Course objects in this Planner 
    *   is less than MAX_COURSES.
    * 
    * <dt>Postconditions:
    *   <dd>The new Course is now listed in the correct preference 
    *   on the list. All Courses that were originally greater than 
    *   or equal to position are moved back one position. 
    *
    * @exception IllegalArgumentException
    *    Indicates that position is not within the valid range.
    * 
    * @exception FullPlannerExpcetion
    *    Indicates that there is no more room in the Planner 
    *    to record an additional Course.
    **/
    public void addCourse(Course newCourse)
    {
        this.addCourse(newCourse, this.size()+1);
    }

    /**
    * Remove a course from the Planner
    * 
    * @param position
    * The position in the Planner where the Course will be removed from.
    *
    * <dt>Preconditions:
    *   <dd>This Planner has been instantiated and 
    *	1 ≤ position ≤ items_currently_in_list.
    * 
    * <dt>Postconditions:
    *   <dd>The Course at the desired position has been removed. 
    *   All Courses that were originally greater than or equal to 	
    *   position are moved backward one position. 
    *
    * @exception IllegalArgumentException
    *     Indicates that position is not within the valid range.
    **/
    public void removeCourse(int position)
    {
        try
    	{
            if (position < 1 | position >this.size())
                throw new IllegalArgumentException();
            while(position < this.size())
    	    {
                courseArray[position-1] = courseArray[position].clone();
                position++;
            }
            this.setSize(this.size()-1);
        }
        catch(IllegalArgumentException iae)
        {
            System.out.println("The position is not within the valid range");
        }
    }

    /**
    * Returns a instance of <code>Course</code> by its position in the list.
    *
    * @param position
    *    The position of the <code>Course</code> to retrieve.
    *
    * <dt>Preconditions:
    *    <dd>The Planner object has been instantiated and 
    *    1 ≤ position ≤ items_currently_in_list. 
    *
    * @return
    *    Returns the Course of the given position.
    *
    * @exception IllegalArgumentException 
    *    Indicates that position is not within the valid range.
    **/
    public Course getCourse(int position)
    {
        try
        {
            if (position < 1 | position >this.size())
            {
                throw new IllegalArgumentException();
            }
            
        }
        catch(IllegalArgumentException iae)
        {
            System.out.println("The position is not within the valid range");
        }
        return courseArray[position-1].clone();
    }

    /**
    * Prints all Courses that are within the specified department.
    *
    * @param planner
    *    The list of courses to search in.
    *
    * @param department
    *    The 3 letter department code for a Course.
    *
    * <dt>Preconditions:
    *    <dd>The Planner object has been instantiated.
    *
    * <dt>Postconditions:
    *   <dd>Displays a neatly formatted table of each course 
    *   filtered from the Planner. Keep the preference numbers the same.
    *
    **/
    public static void filter(Planner planner, String department)
    {
        // The string contains the information to print 
        String string = "No. Course Name               "
          +"Department Code Section Instructor\n"
          +"-------------------------------------------"
          +"------------------------------------\n";
        for (int i = 1; i <= planner.size(); i++)
        {
            if (planner.getCourse(i).getDepartment().equals(department))
            {
                String course = String.format("%3d %-26s%-12s%-8d %02d %s\n", 
                  i, planner.getCourse(i).getName(),
                  planner.getCourse(i).getDepartment(), 
                  planner.getCourse(i).getCode(),
                  planner.getCourse(i).getSection(), 
                  planner.getCourse(i).getInstructor());
                string = string + course;
            }
        }
        System.out.print(string);
    }

    /**
    * Checks whether a certain Course is already in the list.
    *
    * @param course
    *    the Course we are looking for.
    *
    * <dt>Preconditions:
    *    <dd>The Planner object has been instantiated.
    *
    * @return
    *    True if the Planner contains this Course, false otherwise.
    **/
    public boolean exists(Course course)
    {
        for (int i = 1; i <= this.size(); i++)
        {
            if(course.equals(this.getCourse(i)))
                return true;
        }
        return false;
    }

    /**
    * Creates a copy of this Planner. Subsequent changes to the copy 
    * will not affect the original and vice versa.
    *
    * <dt>Preconditions:
    *   <dd>The Planner object has been instantiated.
    *
    * @return
    *    A copy (backup) of this Planner object.
    **/
    public Object clone()
    {
        Planner plannerBackup = new Planner();
        for (int i = 1; i <= this.size(); i++)
        {
            plannerBackup.addCourse(this.getCourse(i));
        }
        return plannerBackup;
    }
    /**
    * Prints a neatly formatted table of each item in the list 
    * with its position number as shown in the sample output.
    *
    * <dt>Preconditions:
    *   <dd>The Planner object has been instantiated.
    * <dt>Postconditions:
    *   <dd>Displays a neatly formatted table of 
    *	each course from the Planner.
    **/
    public void printAllCourses()
    {
        System.out.print(this.toString());
    }
    
    /**
    * Gets the String representation of this Planner object, 
    * which is a neatly formatted table of each Course in the Planner 
    * on its own line with its position number as shown in the sample output.
    *
    * @return
    * The String representation of this Planner object.
    **/
    @Override
    public String toString()
    {
        String string =   "No. Course Name               "
          +"Department Code Section Instructor\n"
          +"-------------------------------------------"
          +"------------------------------------\n";
        for (int i = 1; i <= this.size(); i++)
        {
            String course = String.format("%3d %-26s%-12s%-8d %02d %s\n", i, 
              this.getCourse(i).getName(), this.getCourse(i).getDepartment(), 
              this.getCourse(i).getCode(),this.getCourse(i).getSection(), 
              this.getCourse(i).getInstructor());
            string = string + course;
        }
        return string;
    }
}

class FullPlannerException extends Exception {
    public FullPlannerException() 
    {
        super();
    }
}