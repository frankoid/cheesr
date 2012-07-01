/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.io.Serializable;

/**
 * @author Francis Devereux
 */
public class Address implements Serializable
{
    private String name;
    private String street;
    // TODO either change zipcode to a UK-style postcode (and change validation), or change £s to $s elsewhere for consistency
    private Integer zipcode;
    private String city;

    @SuppressWarnings("unused") // accessed via PropertyModel
    public String getName()
    {
        return name;
    }

    @SuppressWarnings("unused") // accessed via PropertyModel
    public void setName(String name)
    {
        this.name = name;
    }

    @SuppressWarnings("unused") // accessed via PropertyModel
    public String getStreet()
    {
        return street;
    }

    @SuppressWarnings("unused") // accessed via PropertyModel
    public void setStreet(String street)
    {
        this.street = street;
    }

    @SuppressWarnings("unused") // accessed via PropertyModel
    public Integer getZipcode()
    {
        return zipcode;
    }

    @SuppressWarnings("unused") // accessed via PropertyModel
    public void setZipcode(Integer zipcode)
    {
        this.zipcode = zipcode;
    }

    @SuppressWarnings("unused") // accessed via PropertyModel
    public String getCity()
    {
        return city;
    }

    @SuppressWarnings("unused") // accessed via PropertyModel
    public void setCity(String city)
    {
        this.city = city;
    }
}
