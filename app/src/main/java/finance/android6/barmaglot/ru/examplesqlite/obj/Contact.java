package finance.android6.barmaglot.ru.examplesqlite.obj;

import com.orm.SugarRecord;


public class Contact extends SugarRecord{

    String name;
    String mail;

    public Contact() {
    }

    public Contact(String mail, String name) {
        this.mail = mail;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
