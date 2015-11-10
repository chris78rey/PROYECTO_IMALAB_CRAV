package ec.mil.he1.imalab04;

import ec.mil.he1.imalab05.T05DetalleFactura;
import ec.mil.he1.imalab04.util.JsfUtil;
import ec.mil.he1.imalab04.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("t05DetalleFacturaController")
@SessionScoped
public class T05DetalleFacturaController implements Serializable {

    @EJB
    private ec.mil.he1.imalab04.T05DetalleFacturaFacade ejbFacade;
    private List<T05DetalleFactura> items = null;
    private T05DetalleFactura selected;

    public T05DetalleFacturaController() {
    }

    public T05DetalleFactura getSelected() {
        return selected;
    }

    public void setSelected(T05DetalleFactura selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private T05DetalleFacturaFacade getFacade() {
        return ejbFacade;
    }

    public T05DetalleFactura prepareCreate() {
        selected = new T05DetalleFactura();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("T05DetalleFacturaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("T05DetalleFacturaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("T05DetalleFacturaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<T05DetalleFactura> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public T05DetalleFactura getT05DetalleFactura(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<T05DetalleFactura> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<T05DetalleFactura> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = T05DetalleFactura.class)
    public static class T05DetalleFacturaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            T05DetalleFacturaController controller = (T05DetalleFacturaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "t05DetalleFacturaController");
            return controller.getT05DetalleFactura(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof T05DetalleFactura) {
                T05DetalleFactura o = (T05DetalleFactura) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), T05DetalleFactura.class.getName()});
                return null;
            }
        }

    }

}
