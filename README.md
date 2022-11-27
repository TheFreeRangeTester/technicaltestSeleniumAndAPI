# Framework to Automate E2E with Selenium (UI), Rest Assured (API) and Cucumber (BDD).

## Index

Technologies
Setup
Page Object Model
Features and Cucumber
Base Page
Running the tests
Reports
Technologies

## This project was created with:

- Selenium WebDriver: To interact with WebElements on the Webpage.
- Java: As the programming language.
- Cucumber: To write test scenarios as Behaviour Driven Development features and collaborate with Business Analysts.
- Cucumber Reports: To generate HTML reports.
- Gradle: as building tool.

## Setup

1- Install JDK (latest stable version).
2- Download the WebDrivers you will use in your project.
3- If using Windows, specify the path to the driver in BasePage.java like
´´´
System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
´´´
4- If you are on MacOS:
- Open up Terminal
- Run sudo nano /etc/paths
- Enter your password
- Go to the bottom of the file and enter the path you wish to add (My PATH looks like: /Users/myname/Documents/WebDriver)
- Control-x to quit
- Y to save
- Press enter to confirm
- To double check, quit Terminal and relaunch it. Run echo $PATH. You should see your newly added path in the stream of other paths already there.
5- Install the Cucumber plugin on your IDE of choice.
6- Build the project to download the dependencies specified on Gradle.build.

## Page Object Model This Framework uses the Page Object Model, with a BasePage taking care of creating the instance of the Driver and inheriting methods to interact with the WebElements on the classes within the Pages directory.

Features and Cucumber

The features with the scenarios containing the actual tests should act as a Live Documentation. Avoid using the scenarios to describe vaguely what they are trying to achieve. Crosscheck or get a peer to review the scenario, preferably a Business Analyst (even better if they can write the scenarios and provide them to you, the Test Engineer)

Base Page

The BasePage.java is the class where the driver and the methods to interact with the webpages live. The wait is set once in here and used smart, proceeding with the actions in case the element is found and waiting until the treshold set in this class. You can change this to fit your needs.

## Running the tests To run the tests, you have two options:

Running from a Runner.java , specifying which tag to run (you set the tags in the Scenarios).
Running from the command line and using:
´´´
gradle test -Dcucumber.options="--tags @CucumberTag"
´´´
Observe that the "test" task is created in the Gradle.Build file.

Reports

Once executed, you will get a url in the terminal with the generated report (it self destructs in 24 hs :D). 
