/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core_logics;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author DecentCode
 */

@Named("registrationForm")
@RequestScoped
public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateofBirth;
    private String phoneNumber;
    private String carName;
    private String password;
    private String confirmPassword;
    private String finalPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFinalPassword() {
        return finalPassword;
    }

    public void setFinalPassword(String finalPassword) {
        this.finalPassword = finalPassword;
    }
 
    public void validateFinalPass(FacesContext fc, 
            UIComponent c, Object value)
            throws ValidatorException
    {
        setFinalPassword((String) value);
    }
    
    public void validateName(
        FacesContext fc, UIComponent c, Object value)
    {
        if  (((String)value).contains("!")||
            ((String)value).contains("@")||
            ((String)value).contains("#")||
            ((String)value).contains("$")||
            ((String)value).contains("%")||
            ((String)value).contains("&")||
            ((String)value).contains("*"))
            throw new ValidatorException(
            new FacesMessage("Name cannot contain "
                    + "special characters"));
    }

    public void validateCPassword(FacesContext fc, 
            UIComponent c, Object value)throws ValidatorException
    {
        String cPassword = (String)value;
//            RegistrationForm rf=new RegistrationForm();
//            System.out.println(getFinalPassword());
        if (cPassword.compareTo(getFinalPassword())!=0 )
         {
           FacesMessage message = new FacesMessage();
           message.setSummary("Password does not match");
           throw new ValidatorException(message);
//           throw new ValidatorException(
//            new FacesMessage("Name cannot contain "
//                    + "special characters"));
    }
}

      

}
