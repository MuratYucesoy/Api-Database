#/api/profile/addressDetails endpoint'ine gecerli authorization bilgileri ve address id iceren bir
# GET request body  gönderildiginde dönen response body icindeki addresses verileri dogrulanmali.
@TC02
  Feature: API_US36_TC02
    Scenario: Adres bilgileri dogrulanmali

      Given Istenilen "api,profile,addressDetails" endpoint adrsine gidilir
      Then  US_onalti_TC_sifiriki icin request body olusturulur
      Then  US_onalti_TC_sifiriki icin expected body olustur
      Then  US_onalti_TC_sifiriki icin response kaydedilir
      And   US_onalti_TC_sifiriki icin assertion islemi yapilir
