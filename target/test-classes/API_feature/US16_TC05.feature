#/api/profile/allCountries endpoint'ine gecerli authorization bilgileri ve address id iceren bir GET request body
#gönderildiginde dönen response body icindeki id'si 223 olan ülkenin "code": "TR", "name": "Turkey" oldugu dogrulanmali.
@US16
  Feature: API AllCountries Get Request Id Verileri Dogrulanir

    Scenario: Id Verileri Dogrulanir

      Given Istenilen "api,profile,allCountries" endpoint adrsine gidilir
      Then  US_onalti_TC_sifirbes icin response kaydeder
      And   US_onlati TC_sifirbes icin id 223, code "TR" ve name "Turkey" Assertion yapar


