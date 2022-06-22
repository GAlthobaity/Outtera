
package suplift;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Ghaid + Raneen
 */
public class Cutomer implements Serializable{
    private String Name;
    private String Email;
    private String phone;
    private String gen;
    private String Activity;
    private String time;
    private int NoTicket;
    private LocalDate Date;

    public Cutomer(String Name, String Email, String phone, String gen, String Activity,String time,
    int NoTicket, LocalDate Date) {
        this.Name = Name;
        this.Email = Email;
        this.phone = phone;
        this.gen = gen;
        this.Activity = Activity;
        this.time = time;
        this.NoTicket = NoTicket;
        this.Date = Date;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGen() {
        return gen;
    }

    public String getActivity() {
        return Activity;
    }

    public int getNoTicket() {
        return NoTicket;
    }

    public LocalDate getDate() {
        return Date;
    }

    public String getTime() {
        return time;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public void setActivity(String Activity) {
        this.Activity = Activity;
    }

    public void setNoTicket(int NoTicket) {
        this.NoTicket = NoTicket;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "---------------------------------------------------\n"
                +"                 TICKET INFO                    \n"
                +"---------------------------------------------------\n"
                + "Name: " + Name + 
                "\nEmail: " + Email + 
                "\nphone: " + phone + 
                "\nGender: " + gen + 
                "\nActivity: " + Activity +
                "\nTime: "+time+
                "\nNo. of Tickets: " + NoTicket +
                "\nDate: " + Date 
                +"\n---------------------------------------------------\n"
                +"                   HAVE FUN :D                     \n"
                +"---------------------------------------------------\n";
    }
    
    
    
}
