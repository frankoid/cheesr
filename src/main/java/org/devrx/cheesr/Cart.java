/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joda.money.Money;

/**
 * @author Francis Devereux
 */
public class Cart implements Serializable
{
    private List<Cheese> cheeses = new ArrayList<Cheese>();
    private List<Cheese> unmodifiableCheeses = Collections.unmodifiableList(cheeses);
    private Address billingAddress = new Address();

    @SuppressWarnings("unused") // accessed via PropertyModel
    public Money getTotal()
    {
        if (cheeses.isEmpty())
        {
            return Money.zero(CheesrApplication.CURRENCY);
        }
        else
        {
            return Money.total(Cheese.pricesIterator(cheeses));
        }
    }

    @SuppressWarnings("unused") // invoked dynamically by Wicket
    public List<Cheese> getCheeses()
    {
        return unmodifiableCheeses;
    }

    public void add(Cheese selected)
    {
        cheeses.add(selected);
    }

    public void remove(Cheese selected)
    {
        cheeses.remove(selected);
    }

    public boolean isEmpty()
    {
        return cheeses.isEmpty();
    }

    /**
     * Empty the shopping cart.
     */
    public void clear()
    {
        cheeses.clear();
    }

    public Address getBillingAddress()
    {
        return billingAddress;
    }
}
