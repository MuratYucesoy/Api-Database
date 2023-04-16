Feature: US02
  Scenario:/api/customerGetUser endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde dönen
           status code'in 200 ve response body'deki message bilgisinin "success" oldugu dogrulanmali.

    Given Istenilen "api,get-users" endpoint adrsine gidilir
    Then  Us_sifirIki_TC_sifirBir icin response'i kaydeder
    And   US_sifirIki_TC_sifir icin body icerisindeki bilgileri assert eder
    And   Status Code 200 ve message "success" bilgileri assert edilir