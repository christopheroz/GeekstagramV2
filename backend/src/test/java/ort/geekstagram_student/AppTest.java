package ort.geekstagram_student;


import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ort.geekstagram_student.controller.UserRestController;
import ort.geekstagram_student.model.User;
import ort.geekstagram_student.service.FauxUserService;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
    public void testAddUser(){
    	UserRestController restController = new UserRestController();
    	User u = new User("test","test@test.fr","test");
    	User u2 = new User("test","test@test.fr","test");
    	restController.add(u);
    	assertEquals(new Long("1"),restController.add(u2));
    }
    
    public void testAddUser2(){
    	FauxUserService fauxUserService = new FauxUserService();
    	User u = new User("test","test@test.fr","test");
    	//u.setId(new Date().getTime());
    	fauxUserService.add(u);
    	
    	User u2 = new User("test","test@test.fr","test");
    	//u2.setId(new Date().getTime());
    	
    	fauxUserService.add(u);
    	assertEquals(false,fauxUserService.add(u2));
    }
    

    /*public void testConnect(){
    	
    	User u = new User("test","test@test.fr","test");
    	//u.setId(new Date().getTime());

    	
    	UserRestController restController = new UserRestController();
restController.add(u);
    	assertEquals("0",restController.connect(u));
    }
    */
    
    
}
