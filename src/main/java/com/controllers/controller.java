


package com.controllers;

import Entities.student;
import configuration.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.studentService;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ahmed on 5/22/2017.
 */
@Controller
public class controller {

    // -------------------- database autowired syudent service ----------------------------
    @Autowired(required = true)
    studentService studentService;

    //
    public service.studentService getStudentService() {
        return studentService;
    }

    public void setStudentService(service.studentService studentService) {
        this.studentService = studentService;
    }
    /*
   * -------------------------- using path variable as string -------------------------------
   *
   * @RequestMapping("/welcome/{username}") protected ModelAndView
   * GEtHelloWorld(@PathVariable("username") String username) throws Exception {
   *
   * ModelAndView modelAndView = new ModelAndView("hello"); modelAndView.addObject("message",
   * "First Spring app   : " + username);
   *
   * return modelAndView; }
   */

  /*
   * -------------------------------- using path variable as map variable
   *
   * @RequestMapping("/welcome/{username}/{address}") protected ModelAndView
   * GEtHelloWorld(@PathVariable Map<String, String> map) throws Exception {
   *
   * String username = map.get("username"); String address = map.get("address");
   *
   * ModelAndView modelAndView = new ModelAndView("hello"); modelAndView.addObject("message",
   * "First Spring app   : " + username + "    :   " + address);
   *
   * return modelAndView; }
   */
    //
    // @RequestMapping("/welcome")
    // protected ModelAndView GEtHelloWorld() throws Exception {
    //
    // ModelAndView modelAndView = new ModelAndView("hello");
    // modelAndView.addObject("message", "First Spring app  : ");
    //
    // return modelAndView;
    // }

 /*
 *    @InitBinder
    public void initBind(WebDataBinder webDataBinder) {

        // webDataBinder.setDisallowedFields(new String[] { "address" });

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy***mm***dd");
        webDataBinder.registerCustomEditor(java.util.Date.class, "date", new CustomDateEditor(
                simpleDateFormat, false));
        webDataBinder.registerCustomEditor(String.class, "username", new studentNameEditor());

    }
 *
 * */


    // -------------------- to init binder with java class Ex:(format)------------------------
    @InitBinder
    public void initBind(WebDataBinder webDataBinder) {
// ------------- disallaw field ..........
//        studentService.
        webDataBinder.setDisallowedFields(new String[]{"repeat_password"});
        // ----------- date formate -------------------------
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy***mm***dd");
        webDataBinder.registerCustomEditor(java.util.Date.class, "birthDate", new CustomDateEditor(
                simpleDateFormat, false));

        webDataBinder.registerCustomEditor(String.class, "username", new studentNameEditor());


    }

    // this instead of creating model object in two methode inside the same class
    @ModelAttribute
    public void AllModel(Model model) {
        model.addAttribute("message", "First Spring app Form ..... : ");

    }
    // -------------------- welcome Jsp  Page -------------------------------

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView GetView() throws IOException {
//--------------------------------------------- Exception Handler  -------------------------

        String message = "ss";
        if (message.equalsIgnoreCase("nullpointer")) {

            throw new NullPointerException("NUll ");

        } else if (message.equalsIgnoreCase("IoException")) {

            throw new IOException("IoException");

        } else if (message.equalsIgnoreCase("ArthimaticException")) {

            throw new ArithmeticException("ArthimaticException");

        }

//        // ------------------------- Hibernate Operation -------------------------
        List<student> students = studentService.GetAllStudents();
        for (student student : students) {

            System.out.println(student.getUsername() + "\t" + student.getAddress());

        }
        // ---------------------------------------------------------
        ModelAndView modelAndView = new ModelAndView("hello");

        return modelAndView;

    }

    //------------------------ login page  ----------------------------
    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public ModelAndView LoginHtml(@Valid @ModelAttribute("student") student student, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {

            ModelAndView modelAndView = new ModelAndView("hello");

            return modelAndView;
        }

        if (student.getUsername().equalsIgnoreCase("admin") || student.getPassword().equalsIgnoreCase("admin")) {
            ModelAndView modelAndView = new ModelAndView("hello");
            modelAndView.addObject("admin", "Canot Sign As Admin");

            return modelAndView;

        }
        if (student.getUsername().equalsIgnoreCase("ahmed") && student.getPassword().equalsIgnoreCase("123")) {


            ModelAndView modelAndView = new ModelAndView("done");
            modelAndView.addObject("student", student);

            return modelAndView;
        }


        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("signup", "signUp First Ya Man ");

        return modelAndView;

    }

    @RequestMapping(value = "/sign.html", method = RequestMethod.GET)
    public ModelAndView sign() {

        ModelAndView modelAndView = new ModelAndView("signup");

        return modelAndView;
    }

    @RequestMapping(value = "/sigup.html", method = RequestMethod.POST)
    public ModelAndView SignUpAction(@Valid @ModelAttribute("student") student student, BindingResult bindingResult) {

        System.out.println(student.getUsername() + "   --------------- ********************* ---------------------  ");
        if (bindingResult.hasErrors()) {

            ModelAndView modelAndView = new ModelAndView("signup");

            return modelAndView;
        }


        ModelAndView modelAndView = new ModelAndView("doneSign");
        modelAndView.addObject("student", student);


        return modelAndView;

    }


}
