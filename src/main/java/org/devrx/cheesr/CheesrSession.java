/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * @author Francis Devereux
 */
public class CheesrSession extends WebSession
{
    private Cart cart = new Cart();

    public CheesrSession(Request request)
    {
        super(request);
    }

    public Cart getCart()
    {
        return cart;
    }
}
