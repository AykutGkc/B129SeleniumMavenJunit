package NT.day14_FakerClass_FileExist_100423;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_Faker {
    @Test
    public void faker() {
        //1) Faker objesi olustururuz
        Faker faker=new Faker();

        //YADA faker.instance() methodu ile de kullanabiliriz. --> Faker faker=Faker.instance();
        //Faker.instance();
        //Firstname yazdiralim
        System.out.println("Fake firstname: "+faker.name().firstName());
        System.out.println(Faker.instance().name().firstName());

        //Lastname yazdiralim
        System.out.println(faker.name().lastName());

        //Kullanici adi yazdiralim
        System.out.println(faker.name().username());

        //Meslek ismi yazdiralim
        System.out.println(faker.name().title());
        System.out.println(faker.job().position());

        //sehir ismi yazdiralim
        System.out.println(faker.address().city());

        //Ülke ismi yazdiralim
        System.out.println(faker.address().country());

        //adres yazdiralim
        System.out.println(faker.address().fullAddress());

        //telefon numarasi yazdiralim
        System.out.println(faker.phoneNumber().cellPhone());

        //posta kodu
        System.out.println(faker.address().zipCode());

        //rastgele 15 haneli bir numara
        faker.number().digits(15);

        System.out.println(faker.address().buildingNumber());
        System.out.println(faker.animal().name());
        System.out.println(faker.harryPotter().character());

    }
}
