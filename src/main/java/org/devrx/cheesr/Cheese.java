/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.io.Serializable;

/**
 * @author Francis Devereux
 */
public class Cheese implements Serializable
{
    private String name;
    private String description;
    private double price;

    public Cheese(String name, String description, double price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
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

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
