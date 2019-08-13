/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author DiamondDust
 */
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import static javax.swing.text.StyleConstants.ModelAttribute;
import modelo.Persona;
import modelo.ValidarPersona;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import utilities.ConexionDB;


@Controller
public class Controlador {
    
    ConexionDB con = new ConexionDB();
    JdbcTemplate jdbcTemplete = new JdbcTemplate(con.conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;
    private ValidarPersona validar;
    
    public Controlador(){
        this.validar = new ValidarPersona();
    }
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql = "SELECT * FROM usuario";
        datos = this.jdbcTemplete.queryForList(sql);
        mav.addObject("Lista", datos);
        mav.setViewName("index");
        return  mav;
    }
    
    
    @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
    public ModelAndView agregar(){
        mav.setViewName("agregar");
        mav.addObject(new Persona());
        return mav;
    }
    
    @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
    public ModelAndView agregar(@ModelAttribute("persona") Persona persona,BindingResult result, SessionStatus status){
        
        this.validar.validate(persona, result);
        if (result.hasErrors()) {
            mav = new ModelAndView();
            mav.setViewName("agregar");
            mav.addObject(new Persona());
            System.out.println("Nombre vacio");
            return mav;
            
        }
        else {
        String consulta = "INSERT INTO usuario(Nombre, Apellido, Edad) VALUES (?,?,?)";
        this.jdbcTemplete.update(consulta, persona.getNombre(), persona.getApellido(), persona.getEdad());
        return new ModelAndView("redirect:/index.htm");
        }
    }
    
    @RequestMapping (value = "editar.htm", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String consulta = "SELECT * FROM usuario WHERE id = " + id ;
        datos = this.jdbcTemplete.queryForList(consulta);
        mav.addObject("Lista",datos);
        mav.setViewName("editar");
        return mav;
    }
    
    @RequestMapping(value = "editar.htm", method = RequestMethod.POST)
    public ModelAndView editar(Persona persona){
        String consulta = "UPDATE usuario SET Nombre = ?, Apellido = ?, Edad = ? WHERE id = " + id;  
        this.jdbcTemplete.update(consulta, persona.getNombre(), persona.getApellido(), persona.getEdad());
        return new ModelAndView("redirect:/index.htm");
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView eliminar(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String consulta = "DELETE FROM usuario WHERE id = " + id;
        this.jdbcTemplete.update(consulta);
        return new ModelAndView("redirect:/index.htm");
    }
}
