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
            fail("The Child should not be added");
        } catch (UnderAgeException u) {
            assertTrue(market.getPeople().isEmpty());
            assertEquals(0, market.getPeople().size()); // ANOTHER IMPLEMENTATION WAY
        } catch (DateException d) {
            fail("DateException isn't expected here");
        }
    }

    @Test
    public void testAddPerson2() {
        setupScenary2();
        String dateRender = (market.oddState(market.getDay())) ? "OOD DIGIT" : "PAIR DIGIT";
        String idRender = (market.oddState(market.getPenultimate(p.getId()))) ? "PAIR" : "ODD";
        try {
            market.addPersonToMarket(p.getDt(), p.getId());
            assertTrue(p.getId() == market.getPeople().get(0).getId());
            assertTrue(p.getDt() == market.getPeople().get(0).getDt());
            if (dateRender.equals(idRender)) {
                fail("The Person should not be added(DateException Expected)");
            }
        } catch (UnderAgeException u) {
            fail("UnderAgeException isn't expected here");
        } catch (DateException d) {
            assertTrue(market.getPeople().isEmpty());
            assertEquals(0, market.getPeople().size(), "Great the person could not enter"); // ANOTHER IMPLEMENTATION
                                                                                            // WAY
            // ADITIONAL MESSAGE assertEquals(dateRender, idRender);
        }
    }

    @Test
    public void testAddPerson3() {
        setupScenary3();
        String dateRender = (market.oddState(market.getDay())) ? "OOD DIGIT" : "PAIR DIGIT";
        String idRender = (market.oddState(market.getPenultimate(p.getId()))) ? "PAIR" : "ODD";
        try {
            market.addPersonToMarket(p.getDt(), p.getId());
            assertTrue(p.getId() == market.getPeople().get(0).getId());
            assertTrue(p.getDt() == market.getPeople().get(0).getDt());
            if (dateRender.equals(idRender)) {
                fail("The Person should not be added(DateException Expected)");
            }
        } catch (UnderAgeException u) {
            fail("UnderAgeException isn't expected here");
        } catch (DateException d) {
            assertTrue(market.getPeople().isEmpty(), "Great the person could not enter");
            assertEquals(0, market.getPeople().size()); // ANOTHER IMPLEMENTATION
                                                        // WAY
            // ADITIONAL MESSAGE assertEquals(dateRender, idRender);
        }
    }
}
