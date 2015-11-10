/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.imalab04;

import ec.mil.he1.imalab05.T02Clasificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class T02ClasificacionFacade extends AbstractFacade<T02Clasificacion> {
    @PersistenceContext(unitName = "PU_IMALAB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public T02ClasificacionFacade() {
        super(T02Clasificacion.class);
    }
    
}
