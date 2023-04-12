@us01-1
Feature: US01
  Scenario:api/register endpoint'ine gecerli datalardan olusan bir POST body gönderildiginde dönen status code'un 201
           oldugu ve response message bilgisinin "Successfully registered" oldugu dogrulanabilmeli.

    Given Istenilen "api,register" endpoint adrsine gidilir
    Then  US_sifir sifir_bir icin request body olusturulur
    And   US_sifir_bir sifir_bir icin response kaydeder
    And   Status Code 409 ve message "invalid Credintials" bilgileri assert edilir