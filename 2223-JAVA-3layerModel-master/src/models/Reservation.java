package models;

import java.util.Date;

public class Reservation {
    private int id;
    private Book bookId;
    private User userId;
    private Date reservationDate;

    public Reservation() {
    }

    public Reservation(int reservationId, Book bookId, User memberId, Date reservationDate) {
        this.id = reservationId;
        this.bookId = bookId;
        this.userId = memberId;
        this.reservationDate = reservationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}
