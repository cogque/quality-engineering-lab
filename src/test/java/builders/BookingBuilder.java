package builders;

import models.Booking;
import models.BookingDates;

public class BookingBuilder {

    private String firstname = "Raul";
    private String lastname = "Flores";
    private int totalprice = 1000;
    private boolean depositpaid = true;
    private String checkin = "2026-10-23";
    private String checkout = "2026-10-30";
    private String additionalneeds = "Breakfast";

    public BookingBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public BookingBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public BookingBuilder withTotalPrice(int totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BookingBuilder withAdditionalNeeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
        return this;
    }
    public BookingBuilder withCheckin(String checkin) {
    this.checkin = checkin;
    return this;
}

public BookingBuilder withCheckout(String checkout) {
    this.checkout = checkout;
    return this;
}

public BookingBuilder withDepositPaid(boolean depositpaid) {
    this.depositpaid = depositpaid;
    return this;
}


    public Booking build() {

        BookingDates dates = new BookingDates();
        dates.setCheckin(checkin);
        dates.setCheckout(checkout);

        Booking booking = new Booking();
        booking.setFirstname(firstname);
        booking.setLastname(lastname);
        booking.setTotalprice(totalprice);
        booking.setDepositpaid(depositpaid);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds(additionalneeds);

        return booking;
    }
}
