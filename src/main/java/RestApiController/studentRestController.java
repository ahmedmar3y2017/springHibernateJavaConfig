

package RestApiController;

import Entities.student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;

/**
 * Created by ahmed on 5/23/2017.
 */

//@RestController
@Controller
public class studentRestController {

    // ---------------------------------------- web service rest api  ------------------------------------
//---------------------------------- get method ----------------------------------------------
    //------------------------------------- retrieve all students -------------------------------
    @ResponseBody
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ArrayList<student> GetREst() {
        ArrayList<student> arrayList = new ArrayList<student>();

        student student1 = new student();
        student1.setUsername("ahmed");
        student student2 = new student();
        student2.setUsername("mohamed");
        student student3 = new student();
        student3.setUsername("eslam");


        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);

        return arrayList;

    }

    // ---------------------------------- get specific  Method ------------------------------------
    //- ------------------------- retrieve the specific student ---------------------
    @ResponseBody
    @RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
    public student GetStudent(@PathVariable("name") String name) {

// ----------- fetch data from database first  ----------------------
        student student = new student();
        student.setUsername(name);
        student.setAddress("tanta");


        return student;
    }

    // ----------------------------------------------- put Method --------------------------------------
    // -------------------------------- update specific student body ------------------
    @RequestMapping(value = "/students/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> UpdateStudent(@PathVariable("name") String name, @RequestBody student student) {

        System.out.println("Student Name : " + name);
        System.out.println("Student Name : " + student.getUsername() + " \n Student Address : " + student.getAddress());

// --------- get specific student that match student name parameter from database
        // ----- update student that information get from client and send response to the client

// ----------- header to send to client ---------------------
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("kry1", "val1");
        httpHeaders.add("kry2", "val2");


        return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.OK);

    }

    // ------------------------------------ post method  -----------------------------------
// ---------------------------------- create new student --------------------------------------

    @RequestMapping(value = "/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> InsertStudent(@RequestBody student student) {
        System.out.println("Name is : " + student.getUsername() + "    Address is  : " + student.getAddress());
        // ---- insert student into database

        // ------------ make http heaser to response to client ----
        HttpHeaders httpHeaders = new HttpHeaders();
        // response header to client specific uri name ....
        httpHeaders.add("location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(student.getUsername()).toUri().toString());


        return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.OK);
    }

    // --------------------------- delete method -------------------------------
    // ------------------------------------ delete specific student --------------------------
    @RequestMapping(value = "/students/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> DeleteStudent(@PathVariable("name") String name) {

        System.out.println("Stude name is : " + name);


        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


}
