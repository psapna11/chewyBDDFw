# chewyBDDFw
Java, Cucumber BDD with TestNG

# How to run the test, paste this in the terminal
mvn verify -Dbrowser=ch -Dcucumber.filter.tags="@smoke"
mvn verify -Dbrowser=ch -Dcucumber.filter.tags="@test"