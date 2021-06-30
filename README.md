# Test example

## To run tests in Chrome and generate Allure report:

* run `mvn clean test`

In Firefox:

* run `mvn test -Dselenide.browser=firefox`

In headless Chrome:

* run `mvn test -Dselenide.browser=chrome -Dselenide.headless=true`

In Chrome with different browser size (default browser size is 1920x1080):

* run `mvn test -Dselenide.browser=chrome -Dselenide.browserSize=1400x920`

In Chrome with different timeout (default timeout is 4 seconds):

* run `mvn test -Dselenide.browser=chrome -Dselenide.timeout=8000`


## To see a report:

* run `mvn allure:serve`
