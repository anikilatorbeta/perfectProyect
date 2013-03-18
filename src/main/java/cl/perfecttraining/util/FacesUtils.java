/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.perfecttraining.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Freddy Jimenez
 */
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
public class FacesUtils {
 
    public static void addErrorMessage(String msg) {
        addMessage(FacesMessage.SEVERITY_ERROR, msg);
    }
 
    private static void addMessage(FacesMessage.Severity severity, String msg) {
        final FacesMessage facesMsg = new FacesMessage(severity, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
 
    public static void addSuccessMessage(String msg) {
        addMessage(FacesMessage.SEVERITY_INFO, msg);
    }
 
    public static String getBundleKey(String bundleName, String key) {
        return FacesContext
                .getCurrentInstance()
                .getApplication()
                .getResourceBundle(FacesContext.getCurrentInstance(),
                        bundleName).getString(key);
    }
 
}