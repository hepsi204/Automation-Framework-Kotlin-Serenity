# Automation Framework using Kotlin, Serenity, Gradle
The intention of this repo is to demonstrate one way of building a test automation framework from scratch.

Serenity is an open source tool and you can find more details about it here - http://www.thucydides.info/#/

It automates testing of Selenium's test website - https://www.seleniumeasy.com/test/

Notes:
1.  scenario name used as test case name by JUNIT & Serenity runner is truncated if new line is introduced
This could result in duplicate test case names. JUNIT & Serenity runners only record the 
latest test result for any test case considered duplicate test

2. Too many regex blocks in ste definitions could also result in duplicate test case names

3. Scenario outline tests take longer to run than individual scenarios