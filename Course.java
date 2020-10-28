package HW1;

/**
* The <code>Course</code> class contains the Course name (String), 
* department (String), code (int), section (byte), and instructor (String).
*
*
* @author Minqi Shi
* email: minqi.shi@stonybrook.edu
* Stony Brook ID: 111548035
**/

public class Course
{
    private String name; // The name of the Course.
    private String department; // The department of the Course.
    private String instructor; // The instructor of the Course.
    private int code; // The code of the Course.
    private byte section; // The section of the Course.
    
    /**
    * Returns an instance of <code>Course</code>. 
    *
    * @param name
    *    The name of the Course.
    * 
    * @param department 
    *    The department of the Course.
    * 
    * @param instructor
    *    The instructor of the Course.
    * 
    * @param code
    *    The code of the Course.
    * 
    * @param section
    * 	 The section of the Course. 
    *
    * <dt>Precondition:
    *    <dd><code>code</code> and <code>section</code> must be
    *    greater than or equal to 0.
    *
    * @exception IllegalArgumentException
    *    Indicates that <code>code</code> or <code>section</code>
    *    is or are less than zero.
    **/
    public Course(String name, String department, String instructor,
      int code, byte section)
    {
        try
        {
            if (code < 0 || section <0)
                throw new IllegalArgumentException();
            this.name = name;
            this.department = department;
            this.instructor = instructor;
            this.code = code;
            this.section = section;
        }
        catch(IllegalArgumentException iae)
        {
            System.out.println("The code or section is or are invalid!");
        }

    }
    
    /**
    * Returns the current name of the Course.
    *
    * @return 
    *    Returns the name of the Course.
    **/
    public String getName()
    {
        return name;
    }
    
    /**
    * Returns the current department of the Course.
    *
    * @return 
    *    Returns the department of the Course.
    **/
    public String getDepartment()
    {
        return department;
    }
   
    /**
    * Returns the current instructor of the Course.
    *
    * @return 
    *    Returns the instructor of the Course.
    **/
    public String getInstructor()
    {
        return instructor;
    }
    
    /**
    * Returns the current code of the Course.
    *
    * @return 
    *    Returns the code of the Course.
    **/
    public int getCode()
    {
        return code;
    }

    /**
    * Returns the current section of the Course.
    *
    * @return 
    *    Returns the section of the Course.
    **/
    public byte getSection()
    {
        return section;
    }
	
    /**
    * Sets a new name for the Course.
    *
    * @param newName
    *    The new name for the Course.
    *
    **/
    public void setName(String newName)
    {
        this.name = newName;
    }
    
    /**
    * Sets a new department for the Course.
    *
    * @param newDepartment
    *    The new Department for the Course.
    *
    **/
    public void setDepartment(String newDepartment)
    {
        this.department = newDepartment;
    }
    
    /**
    * Sets a new instructor for the Course.
    *
    * @param newInstructor
    *    The new instructor for the Course.
    *
    **/
    public void setInstrutor(String newInstructor)
    {
        this.instructor = newInstructor;
    }
    
    /**	
    * Sets a new code for the Course.
    *
    * @param newCode
    *    The new code for the Course.
    *
    * <dt>Precondition:
    *    <dd><code>newCode</code> must be greater than or equal to 0.
    * 
    * @exception IllegalArgumentException
    *    Indicates that <code>newCode</code> is less than zero.
    **/
    public void setCode(int newCode)
    {
        try
        {
            if (newCode < 0)
                throw new IllegalArgumentException();
            this.code = newCode;
        }
        catch(IllegalArgumentException iae)
        {
            System.out.println("The new code is invalid!");
        }
        
    }
    
    /**
    * Sets a new section for the Course.
    *
    * @param newSection
    *    The new Section for the Course.
    *
    * <dt>Precondition:
    *    <dd><code>newSection</code> must be greater than or equal to 0.
    * 
    * @exception IllegalArgumentException
    *    Indicates that <code>newSection</code> is less than zero.
    **/
    public void setSection(byte newSection)
    {
        try
        {
            if (newSection <0)
                throw new IllegalArgumentException(); 
            this.section = newSection;
        }
        catch(IllegalArgumentException iae)
        {
            System.out.println("The new section is invalid!");
        }
       
    }
    
    /**
    * Returns a instance of the <code>Course</code>,
    * which is a copy of this <code>Course</code>.
    *
    * @return
    *    Returns a copy of the this <code>Course</code>.
    **/
    public Course clone()
    {
        return new Course(this.getName(), this.getDepartment(),
          this.getInstructor(), this.getCode(),this.getSection());
    }
    
    /**
    * Indicates whether that object refers to a <code>Course</code> object 
    * with the same attributes as this <code>Course</code>.
    *
    * @param obj
    *    The object needs to be compared with this <code>Course</code>
    *
    * @return 
    *    True if that object refers to a Course object 
    *    with the same attributes
    *    as this Course, false if otherwise.
    **/
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Course))
            return false;
        Course course = (Course) obj;// Cast the obj to a Course object.
        return this.getName().equals(course.getName())
          && this.getDepartment().equals(course.getDepartment())
          && this.getInstructor().equals(course.getInstructor())
          && this.getCode() == course.getCode()
          && this.getSection() == course.getSection();
    }
}