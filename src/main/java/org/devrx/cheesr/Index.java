/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

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
                item.add(new Label("price", "£" + cheese.getPrice()));
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
    }
}
