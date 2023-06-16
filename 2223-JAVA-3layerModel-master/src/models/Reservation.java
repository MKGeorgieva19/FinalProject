package models;

import java.util.Date;

public class Reservation {
    private int id;
    private int bookId;
    private int userId;
    private Date reservationDate;

    public Reservation() {
    }

    public Reservation(int reservationId, int bookId, int memberId, Date reservationDate) {
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
