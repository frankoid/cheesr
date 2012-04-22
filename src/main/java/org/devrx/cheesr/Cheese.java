/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.io.Serializable;
import java.util.Iterator;

import org.joda.money.Money;

/**
 * @author Francis Devereux
 */
public class Cheese implements Serializable
{
    private String name;
    private String description;
    private Money price;

    public Cheese(String name, String description, Money price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Create and return an iterator that iterates over the prices of a collection of cheeses
     */
    public static Iterable<Money> pricesIterator(final Iterable<Cheese> cheeses)
    {
        return new Iterable<Money>()
        {
            private Iterator<Cheese> cheeseIterator = cheeses.iterator();

            @Override
            public Iterator<Money> iterator()
            {
                return new Iterator<Money>()
                {
                    @Override
                    public Money next()
                    {
                        return cheeseIterator.next().getPrice();
                    }

                    @Override
                    public boolean hasNext()
                    {
                        return cheeseIterator.hasNext();
                    }

                    @Override
                    public void remove()
                    {
                        cheeseIterator.remove();
                    }
                };
            }
        };
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Money getPrice()
    {
        return price;
    }

    public void setPrice(Money price)
    {
        this.price = price;
    }
}
