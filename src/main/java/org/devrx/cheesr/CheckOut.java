/*
 * ©2012 Francis Devereux. All Rights Reserved
 */

package org.devrx.cheesr;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

/**
 * @author Francis Devereux
 */
public class CheckOut extends CheesrPage
{
    public CheckOut()
    {
        add(new FeedbackPanel("feedback"));

        Form form = new Form("form");
        add(form);

        Address address = getCart().getBillingAddress();
        form.add(new TextField<String>("name", new PropertyModel<String>(address, "name")).setRequired(true));
        form.add(new TextField<String>("street", new PropertyModel<String>(address, "street")).setRequired(true));
        form.add(new TextField<Integer>("zipcode", new PropertyModel<Integer>(address, "zipcode")).setRequired(true));
        form.add(new TextField<String>("city", new PropertyModel<String>(address, "city")).setRequired(true));

        form.add(new Link("cancel") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });

        form.add(new Button("order") {
            @Override
            public void onSubmit() {
                Cart cart = getCart();
                // charge customers’ credit card
                // ship cheeses to our customer
                // clean out shopping cart
                cart.clear();
                // return to front page
                setResponsePage(Index.class);
            }
        });
    }
}
