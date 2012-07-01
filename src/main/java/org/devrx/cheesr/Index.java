/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.joda.money.Money;

/**
 * @author Francis Devereux
 */
public class Index extends CheesrPage
{
    public Index()
    {
        add(new ListView<Cheese>("cheeses", getCheeses()) {

            @Override
            protected void populateItem(ListItem<Cheese> item)
            {
                Cheese cheese = item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("description", cheese.getDescription()));
                item.add(new Label("price", new Model<Money>(cheese.getPrice())));
                item.add(new Link<Cheese>("add", item.getModel())
                {
                    @Override
                    public void onClick()
                    {
                        Cheese selected = getModelObject();
                        getCart().add(selected);
                    }
                });
            }
        });

        add(new ListView<Cheese>("cart",
                                 new PropertyModel<List<Cheese>>(this, "cart.cheeses"))
        {
            @Override
            protected void populateItem(ListItem<Cheese> item) {
                Cheese cheese = item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("price", new Model<Money>(cheese.getPrice())));
                item.add(new Link<Cheese>("remove", item.getModel())
                {
                    @Override
                    public void onClick()
                    {
                        Cheese selected = getModelObject();
                        getCart().remove(selected);
                    }
                });
            }
        });

        add(new Label("total", new PropertyModel<Money>(this, "cart.total")));

        add(new Link("checkout")
        {
            @Override
            public void onClick()
            {
                setResponsePage(new CheckOut());
            }
        });
    }
}
