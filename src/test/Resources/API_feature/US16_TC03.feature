#api/profile/addressDetails endpoint'ine gecerli authorization bilgileri ve yanlis address id'si iceren bir
# GET request body  gönderildiginde dönen dönen status code'in 404 ve message bilgisinin
# "address not found" oldugu dogrulanmali.
@US16
  Feature: API AddressDetails Get Request
    Scenario: Status kodu ve mesaj bilgisi dogrulama

      Given Istenilen "api,profile,addressDetails" endpoint adrsine gidilir
      Then  US_onalti_TC_sifiruc icin request body olusturur
      Then  US_onalti_TC_sifiruc icin response kaydeder
      Then  Status Code 404 ve message "address not found" bilgileri assert edilir