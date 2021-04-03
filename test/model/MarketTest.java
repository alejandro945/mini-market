import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.*;
import model.*;

class MarketTest {
    private MiniMarket market;
    private Person p;

    public void setupScenary1() {
        market = new MiniMarket();
        p = new Person(1006, DocumentType.TI);
    }

    public void setupScenary2() {
        market = new MiniMarket();
        p = new Person(29663, DocumentType.CC);
    }

    public void setupScenary3() {
        market = new MiniMarket();
        p = new Person(94298, DocumentType.PP);
    }

    @Test
    public void testAddPerson1() {
        setupScenary1();
        try {
            market.addPersonToMarket(p.getDt(), p.getId());
        } catch (UnderAgeException u) {
            assertEquals("Adult Type", p.getDt(), "The Child should not be added");
        } catch (DateException d) {
            fail("DateException isn't expected here");
        }
    }

    @Test
    public void testAddPerson2() {
        setupScenary2();
        String dateRender = (market.oddState(market.getDay())) ? "DIGITO IMPAR" : "DIGITO PAR";
        String idRender = (market.oddState(market.getPenultimate(p.getId()))) ? "PAR" : "IMPAR";
        try {
            market.addPersonToMarket(p.getDt(), p.getId());
        } catch (UnderAgeException u) {
            fail("UnderAgeException isn't expected here");
        } catch (DateException d) {
            assertEquals(dateRender, idRender, "The Person should not be added");
        }
    }

    @Test
    public void testAddPerson3() {
        setupScenary3();
        String dateRender = (market.oddState(market.getDay())) ? "DIGITO IMPAR" : "DIGITO PAR";
        String idRender = (market.oddState(market.getPenultimate(p.getId()))) ? "PAR" : "IMPAR";
        try {
            market.addPersonToMarket(p.getDt(), p.getId());
        } catch (UnderAgeException u) {
            fail("UnderAgeException isn't expected here");
        } catch (DateException d) {
            assertEquals(dateRender, idRender, "The Person should not be added");
        }
    }
}
