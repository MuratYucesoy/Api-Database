package DbStepdefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pojos.MyDemo;
import runners.DbRunner;
import utilities.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static utilities.DBUtils.getColumnData;

public class DbStepdefinition {

    // Bir JDBC projesine baslamadan önce ilk is olarak Database sistem yöneticisinden
    // Database Access Information bilgilerini almaliyiz.


    /*
    Database Access Information

	Database_type: mysql
	Database_name: trendlifebuy_trainingtrendlife
	Database_host/id_number: 194.140.198.209
	Database_port_number: 3306

	User_name: trendlifebuy_trainingtrendlifeuser
	Password: rRBMdEbSfj

     */
    List<Object> discountType;

      String url="jdbc:mysql://194.140.198.209:3306/trendlifebuy_trainingtrendlife";
      String username="trendlifebuy_trainingtrendlifeuser";
      String password="rRBMdEbSfj";


        Connection con;

        Statement st;

        ResultSet rs;

    String row;

    String query;

    Integer id;
    String name;
    String lastName;

    List<Object> emailList = new ArrayList<>();

    @Given("Database ile baglanti kurulur.")
    public void database_ile_baglanti_kurulur() throws SQLException {

         con = DBUtils.getConnection();
         st = DBUtils.getStatement();

        // yaptigimiz islemler ile önce connection create ettik sonra create ettigimiz connection ile
        //bir statement create ettik ve data base baglantisini gerceklestirmis olduk.

    }
    @Given("Query olusturulur.")
    public void query_olusturulur() {

        query="select  from trendlifebuy_trainingtrendlife.users";
    }
    @Given("OLusturulan query statement araciligi ile database gonderilir.")
    public void o_lusturulan_query_statement_araciligi_ile_database_gonderilir() throws SQLException {
        rs = st.executeQuery(query);
    }
    @Given("Statement ile donen veriler dogrulanir.")
    public void statement_ile_donen_veriler_dogrulanir() throws SQLException {

        rs.first();
        System.out.println(rs.getString("email"));
        String actualEmail= rs.getString("email");
        String expectedEmail= "info@trendlifebuy.com";

        rs.next();
        System.out.println(rs.getString("email"));

        rs.next();
        System.out.println(rs.getString("first_name"));

        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");

//        rs.absolute(11);
//        while(rs.next()){
//            System.out.println(rs.getString("first_name"));
//        }


      //  assertEquals(expectedEmail,actualEmail);

        emailList = getColumnData(query,"first_name");

        System.out.println(emailList);

    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() throws SQLException {

        rs.close();
        st.close();
        con.close();
    }


    @Given("Database icin baglanti kurulur")
    public void database_icin_baglanti_kurulur() {
        con=DBUtils.getConnection();
        st=DBUtils.getStatement();

    }
    @Then("Ussifirbir icin querry olusturulur")
    public void ussifirbir_icin_querry_olusturulur() {
       //query="select * from trendlifebuy_trainingtrendlife.users";

    }
    @Then("Ussifirbir icin querry yollanir")
    public void ussifirbir_icin_querry_yollanir() throws SQLException {
        //rs=st.executeQuery(query);

    }
    @Then("Statement ile donen sifirbir verileri dogrulanir")
    public void statement_ile_donen_sifirbir_verileri_dogrulanir() throws SQLException {

        //rs.absolute(2);
        //String actualName=rs.getString("first_name");
        //System.out.println(actualName);
        //String expectedName="Admin";
        //Assert.assertEquals(expectedName,actualName);
        //String actualLastname=rs.getString("last_name");
        //String expectedLastname="User";
        //Assert.assertEquals(expectedLastname,actualLastname);

        query="Select * from trendlifebuy_trainingtrendlife.users where first_name='Admin' and last_name='User'";
        rs=st.executeQuery(query);
        rs.next();
        Assert.assertEquals(rs.getString("username"),"tlbadmin");
        Assert.assertEquals(rs.getString("email"),"admin@gmail.com");

    }

    @And("Database baglantisi basariyla kapatilir")
    public void databaseBaglantisibasariylaKapatilir() throws SQLException {
        DBUtils.closeConnection();

    }

    @Then("USsifiriki icin query hazirlanir")
    public void u_ssifiriki_icin_query_hazirlanir() {
        query= "select * from trendlifebuy_trainingtrendlife.seller_products where discount_type=1";
    }
    @Then("Hazirlanan querry statement araciligiyla yollanir")
    public void hazirlanan_querry_statement_araciligiyla_yollanir() {
        discountType=getColumnData(query, "discount_type");



    }

    @Then("Statement ile donen sifiriki verileri dogrulanir")
    public void statementIleDonenSifirikiVerileriDogrulanir() {

        for (Object each:discountType
        ) {
            assertEquals("1", each);
        }
    }

    @Then("usonalti icin querry olusturulur")
    public void usonalti_icin_querry_olusturulur() {
       query="Select * from trendlifebuy_trainingtrendlife.users where last_name LIKE 'a%'";
    }
    @Then("usonalti icin statement ile querry yollanir")
    public void usonalti_icin_statement_ile_querry_yollanir() throws SQLException {
        rs=st.executeQuery(query);
    }
    @Then("statement ile donen onalti sorgusu dogrulanir")
    public void statement_ile_donen_onalti_sorgusu_dogrulanir() throws SQLException {

        //rs.absolute(0);
        while(rs.next()){
            System.out.println(rs.getString("last_name"));
            Assert.assertTrue(rs.getString("last_name").substring(0,1).equalsIgnoreCase("a"));
        }
    }
    @Then("US_OnBes {int},{string},{string},{int},{string} icin querry hazirlanir")
    public void us_on_bes_icin_querry_hazirlanir(Integer id, String name, String lastName, Integer roleId, String password) throws SQLException {

        query="INSERT INTO trendlifebuy_trainingtrendlife.users (id,first_name,last_name,role_id,password) " +
                "VALUES ("+id+",'"+name+"','"+lastName+"',"+roleId+",'"+password+"')";

    }
    @Then("Us_onbes icin querry hazirlanir")
    public void us_onbes_icin_querry_hazirlanir() throws SQLException {

    }
    @Then("Assertion islemi yapilir")
    public void assertion_islemi_yapilir() throws SQLException {



    }



    @Then("Hazirlanan querryi statement araciligiyla yollar")
    public void hazirlanan_querryi_statement_araciligiyla_yollar() throws SQLException {

        int rowCount =st.executeUpdate(query);
        assert rowCount == 4;

    }


    @Given("Database testi yapar")
    public void databaseTestiYapar() throws SQLException {
        con=DBUtils.getConnection();
        st=DBUtils.getStatement();

        List<MyDemo> records = new ArrayList<>();
        records.add(new MyDemo(12, "Ali", "Cansin",2,"12Akjnjnkjnkj.j"));
        records.add(new MyDemo(13, "Thiago", "Motta", 3,"HBH23jnjnm.n"));
        records.add(new MyDemo(14, "Ramon", "Sandro", 4,"13Akjnjnkjnkj.j"));

        int r = 0;
        for(MyDemo w : records) {

            String q3 = "INSERT INTO trendlifebuy_trainingtrendlife.users (id,first_name,last_name,role_id,password) VALUES(" + w.getId() + ",'" + w.getFirst_name() + "','" + w.getLast_name() + "'," + w.getRole_id() + ",'" + w.getPassword() + "')";
            r = r + st.executeUpdate(q3);

        }
        System.out.println(r + " rows inserted");
        Assert.assertEquals(r,3);
    }

    @Then("Us_onbes icin {int} yeni insert info querry hazirlanir")
    public void us_onbesIcinYeniInsertInfoQuerryHazirlanir(int insert) throws SQLException {

        Faker faker=new Faker();
        int r = 0;

        for (int i = 0; i <insert ; i++) {
            row = "INSERT INTO trendlifebuy_trainingtrendlife.users (id,first_name,last_name,role_id,password) VALUES(" + faker.number().numberBetween(2000,10000) + ",'" + faker.name().name() + "','" + faker.name().lastName() + "'," +faker.number().numberBetween(1,5) + ",'" +faker.internet().password(6,10,true,true,true) + "')";
            r = r + st.executeUpdate(row);
        }

        System.out.println(r + " rows inserted");
        Assert.assertEquals(r,insert);

    }

    @Then("Creates query for US_three")
    public void createsQueryForUS_three() {

        query="select * from trendlifebuy_trainingtrendlife.languages where\n" +
                "    id =10 ";
    }

    @And("The assertion operation is performed for US_three")
    public void theAssertionOperationIsPerformedForUS_three() throws SQLException {
        rs=st.executeQuery(query);
        while (rs.next()) {
            Assert.assertEquals(rs.getString("native"),"Bosanski");
        }

    }
}

