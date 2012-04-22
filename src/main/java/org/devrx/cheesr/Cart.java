/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Francis Devereux
 */
public class Cart implements Serializable
{
    private List<Cheese> cheeses = new ArrayList<Cheese>();
    private List<Cheese> unmodifiableCheeses = Collections.unmodifiableList(cheeses);
    private Address billingAddress = new Address();

    public double getTotal()
    {
        double total = 0;
        for (Cheese cheese : cheeses)
        {
            total += cheese.getPrice();
        }
        return total;
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

    public Address getBillingAddress()
    {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress)
    {
        this.billingAddress = billingAddress;
    }
}
