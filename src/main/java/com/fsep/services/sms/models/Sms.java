package com.fsep.services.sms.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * 13.01.16
 * Sms
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "aero_id")
    private String aeroId;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "receiver_number")
    private String receiverNumber;

    private String state;

    private String text;

    public Sms(String aeroId, Date date, String receiverNumber, String state, String text) {
        this.aeroId = aeroId;
        this.date = date;
        this.receiverNumber = receiverNumber;
        this.state = state;
        this.text = text;
    }

    protected Sms() {
    }

    public String getAeroId() {
        return aeroId;
    }

    public void setAeroId(String aeroId) {
        this.aeroId = aeroId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sms that = (Sms) o;

        return Objects.equal(this.id, that.id) &&
                Objects.equal(this.aeroId, that.aeroId) &&
                Objects.equal(this.date, that.date) &&
                Objects.equal(this.receiverNumber, that.receiverNumber) &&
                Objects.equal(this.state, that.state) &&
                Objects.equal(this.text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, aeroId, date, receiverNumber, state, text);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("aeroId", aeroId)
                .add("date", date)
                .add("receiverNumber", receiverNumber)
                .add("state", state)
                .add("text", text)
                .toString();
    }
}
