/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;

/**
 * @author Francis Devereux
 */
public class CheesrApplication extends WebApplication
{
    // The locale of the application. We only support the UK for now. This means, for example, that all prices are in GBP.
    private static final Locale LOCALE = Locale.UK;
    public static final CurrencyUnit CURRENCY = CurrencyUnit.getInstance(LOCALE);

    private List<Cheese> cheeses = Arrays.asList(
        new Cheese("Mature cheddar", "Flinty and strong", Money.parse("GBP 3.50")),
        new Cheese("Blue stilton", "Yummy mould", Money.parse("GBP 4.23")),
        new Cheese("Roquefort", "Yummy French mould", Money.parse("GBP 4.23")),
        new Cheese("Gouda", "Gouda is a yellowish Dutch cheese named after the city of Gouda. The cheese is made from cow's milk that is cultured and heated until the curd is separate from the whey. About ten percent of the mixture is curds which are pressed into circular moulds for several hours.", Money.parse("GBP 3.57")),
        new Cheese("Edam", "Edam (Dutch Edammer) is a Dutch cheese that is traditionally sold as spheres with pale yellow interior and a coat of paraffin. Its Spanish name is queso de bola, literally 'ball cheese'. It is named after the town of Edam in the province of North Holland[1], where the cheese is coated for export and for tourist high season. Edam which has aged for at least 17 weeks is coated with black wax, rather than the usual red or yellow.", Money.parse("GBP 3.21")),
        new Cheese("Old Amsterdam", "Old Amsterdam is a Dutch gourmet cheese that is ripened to perfection and regularly checked for flavor. It is a gourmet cheese of exceptionally high and consistent quality, with a buttery mature aged Gouda flavor that cuts with ease.", Money.parse("GBP 5.78")));

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

    private MoneyFormatter moneyFormatter = new MoneyFormatterBuilder().appendCurrencySymbolLocalized().appendAmountLocalized().toFormatter(LOCALE);
    public String formatPrice(Money price)
    {
        return moneyFormatter.print(price);
    }

    public List<Cheese> getCheeses()
    {
        return Collections.unmodifiableList(cheeses);
    }
}
