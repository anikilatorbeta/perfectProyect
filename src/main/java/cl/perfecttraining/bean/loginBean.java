/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.perfecttraining.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Freddy Jimenez
 */
import java.io.IOException;
import java.io.Serializable;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@ManagedBean
@SessionScoped 
public class loginBean implements Serializable{
 
    private String username;
    private String password;
 
    public loginBean() {
    }
 
    public String doLogin() throws IOException, ServletException {
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
 
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_check?j_username=" + username
                                + "&j_password=" + password);
 
        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());
 
        FacesContext.getCurrentInstance().responseComplete();
        // It's OK to return null here because Faces is just going to exit.
        return null;
    }
    public String doLogout() throws IOException, ServletException{
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
 
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_logout");
 
        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());
 
        FacesContext.getCurrentInstance().responseComplete();
        // It's OK to return null here because Faces is just going to exit.
        return null;
    }
 
    public String getPassword() {
        return password;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
}
