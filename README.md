
NBA Automation :

This project targets to automate NBA portal from Accessibility point of view

Technology Stack :
- Selenium Webdriver
- Java
- TestNG
- Cucumber
- Cucumber Report & Test NG report

Following Features Automated:
- Verify user is able to access NBA Home Page
- Verify teams dropdown loads Team's page
- "Feedback" button will load multiple options and the user will be able to "Buy Ticket"
- The video related content will load video overlay on the same page
- Load More option loads 8 items

Steps to Execute:
- Clone this project.
- Perform mvn clean install->It will call the testng.xml which in turn would call testrunner file or you can directly run the feature file too
- Or you can go to Resources->Features->NBATest.feature and execute all the scenarios. Note- In order to execute a specific scenario then Add "Given I have launched browser" And 
    "Given I am on NBA page" steps to the top before running it  

Result/Report File :
- You can see report in 'target/cucumber-reports/index.html'. Please open this html file in browser.
- You can also view "Surefire-reports" from the target folder. 


Notes:
- This will be executed on chrome browser by default. When we will hook up this framework with CI then we can create profiles in POM file  and pass different browsers from CI tool.

