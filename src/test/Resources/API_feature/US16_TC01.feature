#/api/profile/addressDetails endpoint'ine gecerli authorization bilgileri ve address id iceren bir GET request body
# gönderildiginde dönen status code'in 200 ve message bilgisinin "success" oldugu dogrulanmali.
@US16
  Feature: US_16API Verify status code and message information
    Scenario: Verify status code and message information

      Given Istenilen "api,profile,addressDetails" endpoint adrsine gidilir
      And   US_onalti_TC_sifirbir icin request body olusturulur
      Then  Response kaydedilir
      Then  Status Code 200 ve message "success" bilgileri assert edilir