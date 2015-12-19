package springxmlanotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Kirill on 12.12.2015.
 */
public class App {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        ContactServiceImp contactServiceImp = applicationContext.getBean(ContactServiceImp.class);
        ContactFactory contactFactory = applicationContext.getBean(ContactFactory.class);

        contactServiceImp.setContactDao(applicationContext.getBean(ContactDao.class));


        Contact contact1 = contactFactory.getObject();
        contactServiceImp.addContact(contact1);

        Contact contact2 = contactFactory.getObject();
        contactServiceImp.addContact(contact2);

        Contact contact3 = contactFactory.getObject();
        contactServiceImp.addContact(contact3);

        System.out.println(contactServiceImp.getAllContacts().toString());

        contactServiceImp.addContact(new Contact("contact4", "+4444444444", "contact4@email"));
        System.out.println(contactServiceImp.getAllContacts().toString());

        contactServiceImp.delleteContact(contact2);
        System.out.println(contactServiceImp.getAllContacts().toString());

        contactServiceImp.addContact(contact2);
        System.out.println(contactServiceImp.getAllContacts().toString());
    }
}