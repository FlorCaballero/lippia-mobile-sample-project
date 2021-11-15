Feature: A user want to interact with the mobile clockify  application
#//Exercise 1:  Login success

 Scenario Outline: The user starts the application and log in to the app.
    Given The user logs in the application with: <email>, <password>
    Then  Time entries screen page is displayed

#//Exercise 2: Swicth the offline mode option

   When the user access the Setting page
   And  the user switches to forced offline mode
   Then the user improve if the offline mode is displayed properly
   And  the user switches to online mode again

#//Exercise 3: Time Entry tracker

   When  the user go to Time tracker page
   Then  the user click add entry

   When the user set Start with  <startHour> : <startMinutes>
   And  the user set End   with   <endHour>  : <endMinutes>
   And  the user click save

   When the user set project
   And  the user set a <description>
   And  the user click save
   Then the user improve if the time entry is saved <description>

   @Demo
    Examples:
      |email                   | password |startHour|startMinutes|endHour|endMinutes|description      |
      | fcaballero.ar@gmail.com| 123456   |09       |  00        |18     |00        |Learn about selenium |





