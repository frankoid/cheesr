/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;
import org.joda.money.Money;

/**
 * @author Francis Devereux
 */
public class Index extends CheesrPage
{
    private ShoppingCartPanel shoppingCartPanel;
    private final Link checkoutLink;

    public Index()
    {
        PageableListView<Cheese> cheeses = new PageableListView<Cheese>("cheeses", getCheeses(), 5)
        {

            @Override
            protected void populateItem(ListItem<Cheese> item)
            {
                Cheese cheese = item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("description", cheese.getDescription()));
                item.add(new Label("price", new Model<Money>(cheese.getPrice())));
                item.add(new AjaxFallbackLink<Cheese>("add", item.getModel())
                {
                    @Override
                    public void onClick(AjaxRequestTarget target)
                    {
                        Cheese selected = getModelObject();
                        getCart().add(selected);
                        if (target != null)
                        {
                            target.add(shoppingCartPanel);
                            target.add(checkoutLink);
                        }
                    }
                });
            }
        };
        add(cheeses);
        add(new PagingNavigator("navigator", cheeses));

        shoppingCartPanel = new ShoppingCartPanel("shoppingcart", getCart());
        shoppingCartPanel.setOutputMarkupId(true);
        add(shoppingCartPanel);

        checkoutLink = new Link("checkout")
        {
            @Override
            public void onClick()
            {
                setResponsePage(new CheckOut());
            }

            @Override
            public boolean isVisible()
            {
                return !getCart().isEmpty();
            }
        };
        checkoutLink.setOutputMarkupPlaceholderTag(true);
        add(checkoutLink);
    }
}
