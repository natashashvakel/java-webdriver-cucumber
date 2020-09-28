package definitions;

import cucumber.api.java.en.Given;
import pages.CareersHome;
import pages.QuoteForm;
import pages.UspsHome;

public class CommonStepDefs {


    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                //QuoteForm form = new QuoteForm();
                //form.open();
                new QuoteForm().open();
                break;
            case "usps":
                new UspsHome().open();
                break;
            case "careers":
                new CareersHome().open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }

    }
}
