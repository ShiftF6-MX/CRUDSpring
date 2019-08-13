/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author DiamondDust
 */
public class ValidarPersona implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Persona.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Persona  persona = (Persona)o; 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre","required.Nombre", "El campo Nombre es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Apellido","required.Apellido", "El campo Apellido es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Edad","required.Edad", "El campo Edad es obligatorio");
        
    }
    
}
