# NAVE Resident Interaction Automation 
###### By using this automation tool, you have completed resident interactions with all residents you have noted within the file to your best ability and with accurate information to your knowledge. 

###### *Note*: I'm a Mac user, so there are some discrepancies for Windows and Linux, but feel free to reach out. I'm not good at code, so if something is broken well oop. 
## Getting Started 
**Software Requirements**
- [Java SE](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)
- [ChromeDriver - WebDriver for Chrome](https://chromedriver.chromium.org/)
  - MAC users: Don't get the above. 
    1. Open Terminal application
    2. Copy into Terminal `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"` and press ENTER
    3. Copy into Terminal `brew cask install chromedriver` and press ENTER
  - Window users: You will need to add the location of wherever you stored your ChromeDriver to your Env Vars (aka message me if you need help)
- [Selenium Java](https://www.selenium.dev/downloads/)
- [IntelliJ IDEA - Free for Students ](https://www.jetbrains.com/idea/download/#section=mac)

**Setting the Automation Up**
1. Open Terminal application
2. Find somewhere you want to keep this project (Documents is a good place)
3. Copy into Terminal `git clone https://github.com/bitleighvu/NAVEInteractionAutomation.git` and press ENTER 
4. Open IntelliJ application
5. At the top most bar, press `File > Open...` and find where you placed this project
6. Select the folder named `NAVEInteractionAutomation`
7. Navigate to `File > Project Structure`
8. On left hand bar in the pop-up, select `Modules`
9. On the top bar underneath the name property, select `Dependencies`
10. Press the `+` button at the bottom of the box. Here we will add the Selenium files we downloaded earlier. 
  - Upon pressing `+`, you will press `JARs or Directories` and navigate to where you have downloaded Selenium initially. (If you can't find it, just search your device)
  - Select and add the `client-combined-3.141.59.jar`
  - Press the `x` again and now go to `libs` folder and select ALL .jar files (You can add more than one at a time)
  - Check every Export checkbox
  - Press `Apply` then `Okay`
11. Almost done! 

**File Structure**
1. Open the folder named `NAVEInteractionAutomation` in IntelliJ
2. On the left hand bar, select `src > main > java > StudentEngagementAuto.java`
3. Search the file for `CHANGE`
  - You will change `CHANGE FILEPATH` with the location of residents.txt on your local computer. You can find this by easily dragging-and-dropping the .txt file into the Terminal application. Copy-and-paste that back into the program.
  - Change `CHANGE BUILDING` with either number depending on building "12" for NAS or "13" for NAE
  - Change `CHANGE NAME` with personal number code found in RAs.txt
  -If you would like to receive emails, uncomment the line of code above `CHANGE EMAIL` and the same line (delete the //). Replace `CHANGE EMAIL` with your email.
4. The only file you will really touch after all this initial set-up is `residents.txt`

**Adding & Editing Residents**
1. Open the folder named `NAVEInteractionAutomation` in IntelliJ
2. On the left hand bar, select `src > main > java > residents.txt`
  - `residents.txt` will be the only file you're inputting resident name and info
  - Your file will *ONLY* be avaliable to you on your own computer. 
3. Use guide and example below to complete `residents.txt` to meet your needs

**Guide for residents.txt**
### Schema: Name*, Building*, Room*, Resident Interaction, Themes, Actions, Notes
*Mandatory
*If no numbers are added, defaults are:
Resident Interaction - Text/Messaging
Theme - Social/Get-to-know
Actions - None
Notes - None*

Resident Interaction:
1 - In person
2 - Text/Messaging
3 - Video call
4 - In your residence hall
5 - Phone Call
6 - Around Campus

Themes:
- 1 - Social/Get-to-know
- 2 - Current Topics & Events
- 3 - Academic Issues & Successes
- 4 - Crisis & Mental Health Concern
- 5 - Campus Involvement/Engagement
- 6 - Guided Resident Conversation
- 7 - Roommate & Community Dynamics

Actions:
- 1 - Refer Resident to a Campus Resource
- 2 - Follow up later by RA
- 3 - Refer Resident to the Hall Director
- 4 - Other

Example:
George Burdell, NAS,9000D
 - George Burdell NAS 900Dm RA interacted Text/Messaging, No Action, No notes
George Burdell, NAS, 900D, 123, 1, 0,
- George Burdell NAS 900D, RA interacted In person and Text/Messaging and Academic Issues & Successes, No Action, No Notes
George Burdell, NAS, 9000D, 12, 1, 0, Said Hello
  - George Burdell NAS 900D, RA interacted In person and Text/Messaging, No Action, Said Hello

###### First-time Running: Only have one resident listed first in your resident.txt file.
**Running the Automation**
1. Open the folder named `NAVEInteractionAutomation` in IntelliJ
2. On the left hand bar, select `src > main > java > StudentEngagementAuto.java`
3. On line 17, press the little green play button 
4. Press, the first option ('Run StudentEngagment...main()')
5. This will execute the script with all residents listed in your `resident.txt` file.
