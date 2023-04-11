#/api/profile/allCountries endpoint'ine gecerli authorization bilgileri iceren bir GET request body  gönderildiginde
# dönen status code'in 200 ve message bilgisinin "success" oldugu dogrulanmali
@US16
  Feature: API AllCountries Get Request Status kodu ve mesaj bilgisi dogrulama
    Scenario: Status kodu ve mesaj bilgisi dogrulama

      Given Istenilen "api,profile,allCountries" endpoint adrsine gidilir
      Then US_onalti_TC_sifirdort icin response kaydeder
      And  Status Code 200 ve message "success" bilgileri assert edilir