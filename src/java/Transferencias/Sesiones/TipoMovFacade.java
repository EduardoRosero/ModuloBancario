/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transferencias.Sesiones;

import Transferencias.Entidades.TipoMov;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eduardo
 */
@Stateless
public class TipoMovFacade extends AbstractFacade<TipoMov> {
    @PersistenceContext(unitName = "TransferenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMovFacade() {
        super(TipoMov.class);
    }
    
}
