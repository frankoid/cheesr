/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.util.Locale;

import org.apache.wicket.util.convert.IConverter;
import org.joda.money.Money;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;

/**
 * <p>Wicket Converter for joda-money Money objects.</p>
 *
 * <p>Totally UK-centric at the moment, only suitable for use in en_GB / GBP-only applications.</p>
 *
 * @author Francis Devereux
 */
public class MoneyConverter implements IConverter<Money>
{
    private final MoneyFormatter moneyFormatter = new MoneyFormatterBuilder().
        appendCurrencySymbolLocalized().
        appendAmountLocalized().
        toFormatter(CheesrApplication.LOCALE);

    @Override
    public Money convertToObject(String value, Locale locale)
    {
        // Money.parse is very strict about what it accepts. We could improve this method by being more lenient in what
        // we accept, for example we could accept "£12.34" as well as "GBP 12.34". However, the app doesn't allow users
        // to enter money amounts yet so there's no need at the moment.
        return Money.parse(value);
    }

    @Override
    public String convertToString(Money value, Locale locale)
    {
        return moneyFormatter.print(value);
    }
}
