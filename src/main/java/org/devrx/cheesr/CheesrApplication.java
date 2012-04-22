/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

/**
 * @author Francis Devereux
 */
public class CheesrApplication extends WebApplication
{
    private List<Cheese> cheeses = Arrays.asList(
        new Cheese("Mature cheddar", "Flinty and strong", 3.50D),
        new Cheese("Blue stilton", "Yummy mould", 4.23D),
        new Cheese("Roquefort", "Yummy French mould", 4.23D),
        new Cheese("Gouda", "Gouda is a yellowish Dutch cheese named after the city of Gouda. The cheese is made from cow's milk that is cultured and heated until the curd is separate from the whey. About ten percent of the mixture is curds which are pressed into circular moulds for several hours.", 3.57D),
        new Cheese("Edam", "Edam (Dutch Edammer) is a Dutch cheese that is traditionally sold as spheres with pale yellow interior and a coat of paraffin. Its Spanish name is queso de bola, literally 'ball cheese'. It is named after the town of Edam in the province of North Holland[1], where the cheese is coated for export and for tourist high season. Edam which has aged for at least 17 weeks is coated with black wax, rather than the usual red or yellow.", 3.21D),
        new Cheese("Old Amsterdam", "Old Amsterdam is a Dutch gourmet cheese that is ripened to perfection and regularly checked for flavor. It is a gourmet cheese of exceptionally high and consistent quality, with a buttery mature aged Gouda flavor that cuts with ease.", 5.78D));

    public static CheesrApplication get()
    {
        return (CheesrApplication) Application.get();
    }

    @Override
    protected void init()
    {
        super.init();
    }

    @Override
    public Class<? extends Page> getHomePage()
    {
        return Index.class;
    }

    @Override
    public Session newSession(Request request, Response response)
    {
        return new CheesrSession(request);
    }

    public List<Cheese> getCheeses()
    {
        return Collections.unmodifiableList(cheeses);
    }
}
