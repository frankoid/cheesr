/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Francis Devereux
 */
public class Cart implements Serializable
{
    private List<Cheese> cheeses = new ArrayList<Cheese>();
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
    public List<Cheese> getCheeses()
    {
        return cheeses;
    }

    public void setCheeses(List<Cheese> cheeses)
    {
        this.cheeses = cheeses;
    }

    public void add(Cheese selected)
    {
        cheeses.add(selected);
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
