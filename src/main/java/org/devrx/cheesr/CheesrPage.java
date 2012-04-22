/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;

/**
 * @author Francis Devereux
 */
public class CheesrPage extends WebPage
{
    @Override
    public CheesrSession getSession()
    {
        return (CheesrSession) super.getSession();
    }

    public Cart getCart()
    {
        return getSession().getCart();
    }

    public List<Cheese> getCheeses()
    {
        return CheesrApplication.get().getCheeses();
    }
}
