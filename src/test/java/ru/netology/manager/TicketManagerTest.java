package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.TicketRepository;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 100, "airport1", "airport2", 120);
    private Ticket ticket2 = new Ticket(2, 200, "airport3", "airport4", 90);
    private Ticket ticket3 = new Ticket(3, 300, "airport1", "airport2", 120);
    private Ticket ticket4 = new Ticket(4, 400, "airport3", "airport4", 90);
    private Ticket ticket5 = new Ticket(5, 500, "airport5", "airport6", 180);


    @BeforeEach
    void setUp(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldFindTicketsIfExist(){
        Ticket[] expected = {ticket2, ticket4};
        Ticket[] actual = manager.findAll("airport3", "airport4");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTicketsIfNotExist(){
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("airport7", "airport8");

        assertArrayEquals(expected, actual);
    }

}

