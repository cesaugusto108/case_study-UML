package ces.augusto108.uml_casestudy;

import ces.augusto108.uml_casestudy.domain.entities.*;
import ces.augusto108.uml_casestudy.domain.enums.ClientType;
import ces.augusto108.uml_casestudy.domain.enums.PaymentStatus;
import ces.augusto108.uml_casestudy.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class UmlCaseStudyApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(UmlCaseStudyApplication.class, args);
    }

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Computers");
        Category category2 = new Category(null, "Office");
        Category category3 = new Category(null, "Clothes");

        Product product1 = new Product(null, "Notebook IdeaPad 3", "Lenovo", 3250.00);
        Product product2 = new Product(null, "Printer MFC8912DW", "Brother", 2290.00);
        Product product3 = new Product(null, "Mouse M90", "Logitech", 65.90);

        category1.getProducts().addAll(Arrays.asList(product1, product2, product3));
        category2.getProducts().add(product2);

        product1.getCategories().add(category1);
        product2.getCategories().addAll(Arrays.asList(category1, category2));
        product3.getCategories().add(category1);

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3));

        //

        State state1 = new State(null, "São Paulo");
        State state2 = new State(null, "Minas Gerais");

        City city1 = new City(null, "São Paulo", state1);
        City city2 = new City(null, "Santos", state1);
        City city3 = new City(null, "Uberlândia", state2);

        state1.getCities().addAll(Arrays.asList(city1, city2));
        state2.getCities().add(city3);

        stateRepository.saveAll(Arrays.asList(state1, state2));
        cityRepository.saveAll(Arrays.asList(city1, city2, city3));

        //

        Client client1 = new Client(
                null,
                "Maria Silva",
                "maria@email.com",
                "982.998.008-29",
                ClientType.INDIVIDUAL
        );

        Address address1 = new Address(
                null,
                "Rua Principal",
                "2823",
                "Centro",
                "98988-989",
                null,
                city1
        );

        Address address2 = new Address(
                null,
                "Avenida Secundária",
                "928",
                "Limoeiro",
                "98874-000",
                "Casa A",
                city2
        );

        client1.getAddresses().addAll(Arrays.asList(address1, address2));
        client1.getTelephones().addAll(Arrays.asList("11999890928", "1132980928"));

        address1.getClients().add(client1);
        address2.getClients().add(client1);

        clientRepository.save(client1);
        addressRepository.saveAll(Arrays.asList(address1, address2));

        //

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Date date1 = simpleDateFormat.parse("18/11/2022 10:22");
        Purchase purchase1 = new Purchase(null, date1, client1, address1);

        Date date2 = simpleDateFormat.parse("20/11/2022 12:20");
        Purchase purchase2 = new Purchase(null, date2, client1, address2);

        Payment payment1 = new CreditCardPayment(null, PaymentStatus.CONFIRMED, purchase1, 1);
        purchase1.setPayment(payment1);

        Date date3 = simpleDateFormat.parse("05/12/2022 00:00");
        Payment payment2 = new TicketPayment(null, PaymentStatus.PENDING, purchase2, date3, null);
        purchase2.setPayment(payment2);

        client1.getPurchases().addAll(Arrays.asList(purchase1, purchase2));

        purchaseRepository.saveAll(Arrays.asList(purchase1, purchase2));
        paymentRepository.saveAll(Arrays.asList(payment1, payment2));
    }
}
