/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.joda.money.Money;

/**
 * Panel for displaying the contents of a shopping cart.
 * The cart shows the entries and the total value of the cart.
 * Each item can be removed by the user.
 *
 * @author Francis Devereux
 */
public class ShoppingCartPanel extends Panel
{
    private Cart cart;

    public ShoppingCartPanel(String id, Cart cart)
    {
        super(id);
        this.cart = cart;

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
    }

    private Cart getCart()
    {
        return cart;
    }
}
