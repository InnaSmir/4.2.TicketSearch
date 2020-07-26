package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.TicketRepository;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket ticket1 = new Ticket(1, 100, "airport1", "airport2", 120);
    private Ticket ticket2 = new Ticket(2, 200, "airport3", "airport4", 90);
    private Ticket ticket3 = new Ticket(3, 300, "airport1", "airport2", 120);
    private Ticket ticket4 = new Ticket(4, 400, "airport3", "airport4", 90);
    private Ticket ticket5 = new Ticket(5, 500, "airport5", "airport6", 180);


    @BeforeEach
    void setUp() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
    }


    @Test
    void shouldFindAllTickets() {
        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfExist() {
        int idToFind = 3;
        Ticket actual = repository.findById(idToFind);

        assertEquals(ticket3, actual);
    }

    @Test
    void shouldNotFindByIdIfNotExist() {
        int idToFind = 9;
        Ticket actual = repository.findById(idToFind);

        assertNull(actual);
    }

}
