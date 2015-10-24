package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for Reservation
 */
@Entity
public class Reservation {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_start", nullable = false)
    private Date dateStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_end", nullable = false)
    private Date dateEnd;

    @OneToOne
    @JoinColumn(name = "borrowerId")
    private User borrower;

    @OneToOne
    @JoinColumn(name = "resourceId")
    private Resource resource;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}

