//import java.nio.file.Path;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.nio.file.*;
import java.io.BufferedReader;
import java.text.Format;
import java.text.SimpleDateFormat;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class StudentEngagementAuto {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://gatech.co1.qualtrics.com/jfe/form/SV_bCaeLN9iWIIqP53");

        // Get today's date
        Format f = new SimpleDateFormat("MM/dd/yy");
        String todayDate = f.format(new Date());

        ArrayList<Resident> residents = readResidents("CHANGE FILE PATH"); // add your file path of your resident info
        Thread.sleep(1000);

        for (Resident resident : residents) {
            // Set Residential Community Location
            Select resCom = new Select(driver.findElement(By.name("QR~QID36")));
            // "12" for NAS and "13" for NAE
            resCom.selectByValue("12");

            // Set RA Name
            Select name = new Select(driver.findElement(By.name("QR~QID45")));
            // "12" for NAS and "13" for NAE
            name.selectByValue("83");

            // Set Email (Not Mandatory)
//        WebElement email = driver.findElement(By.name("QR~QID38~TEXT"));
//        email.sendKeys("georgeburdell@gatech.edu");

            WebElement next = driver.findElement(By.name("NextButton"));
            next.click();
            ;
            Thread.sleep(2000);

            // Set Resident Name
            WebElement email = driver.findElement(By.name("QR~QID2~TEXT"));
            email.sendKeys(resident.getName());

            // Set Resident Building
            WebElement building = driver.findElement(By.name("QR~QID39~TEXT"));
            building.sendKeys(resident.getBuilding());

            // Set Resident Room
            WebElement room = driver.findElement(By.name("QR~QID40~TEXT"));
            room.sendKeys(resident.getRoom());

            // Set Date
            WebElement date = driver.findElement(By.name("QR~QID3~TEXT"));
            date.sendKeys(todayDate);

            // Set interactions and themes
            interactionSelect(driver, resident);
            themeSelect(driver, resident);

            //Thread.sleep(1000);
            WebElement next1 = driver.findElement(By.name("NextButton"));
            next1.click();

            // Set actions
            actionSelect(driver, resident);
            Thread.sleep(500);

            try {
                WebElement next2 = driver.findElement(By.name("NextButton"));
                next2.click();
            } catch (org.openqa.selenium.StaleElementReferenceException stale) {
                WebElement next2 = driver.findElement(By.name("NextButton"));
                next2.click();
            }

            // Set Notes
            Thread.sleep(4000);
            WebElement notes = driver.findElement(By.xpath("//*[@id=\"QR~QID49\"]"));
            notes.sendKeys(resident.getNotes());
            try {
                WebElement next3 = driver.findElement(By.name("NextButton"));
                next3.click();
                Thread.sleep(3000);
            } catch (org.openqa.selenium.StaleElementReferenceException stale) {
                WebElement next3 = driver.findElement(By.name("NextButton"));
                next3.click();
                Thread.sleep(3000);
            }
        }

        driver.quit();
    }

    private static void interactionSelect(WebDriver driver, Resident resident) {
        String interaction = resident.getInteraction();
        if (interaction.contains("1")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'In person')]"));
            button.click();
        }

        if (interaction.contains("2")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Text/Messaging')]"));
            button.click();
        }

        if (interaction.contains("3")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Video call')]"));
            button.click();
        }

        if (interaction.contains("4")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'In your residence hall')]"));
            button.click();        }

        if (interaction.contains("5")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Phone Call')]"));
            button.click();        }

        if (interaction.contains("6")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Around campus')]"));
            button.click();
        }
    }

    private static void themeSelect(WebDriver driver, Resident resident) {
        String theme = resident.getTheme();
        if (theme.contains("1")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Social/Get-to-know')]"));
            button.click();
        }

        if (theme.contains("2")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Current Topics & Events')]"));
            button.click();
        }

        if (theme.contains("3")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Academic Issues & Successes')]"));
            button.click();
        }

        if (theme.contains("4")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Crisis & Mental Health Concern')]"));
            button.click();        }

        if (theme.contains("5")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Campus Involvement/Engagement')]"));
            button.click();        }

        if (theme.contains("6")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Guided Resident Conversation')]"));
            button.click();
        }

        if (theme.contains("7")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Roommate & Community Dynamics')]"));
            button.click();
        }
    }

    private static void actionSelect(WebDriver driver, Resident resident) {
        String action = resident.getAction();
        if (action.contains("1")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Refer Resident to a Campus Resource')]"));
            button.click();
        }

        if (action.contains("2")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Follow up later by RA')]"));
            button.click();
        }

        if (action.contains("3")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Refer Resident to the Hall Director')]"));
            button.click();
        }

        if (action.contains("4")) {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Other')]"));
            button.click();
        }
    }

    private static ArrayList<Resident> readResidents(String fileName) {
        ArrayList<Resident> residents = new ArrayList<Resident>();
        Path filePath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(filePath,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Resident resident = createResident(attributes);
                residents.add(resident);
                line = br.readLine();
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        return residents;
    }

    private static Resident createResident(String[] info) {
        if (info.length == 3) {
            String name = info[0];
            String building = info[1];
            String room = info[2];
            return new Resident(name, building, room);
        } else if (info.length == 5) {
            String name = info[0];
            String building = info[1];
            String room = info[2];
            String interaction = info[3];
            String theme = info[4];
            return new Resident(name, building, room, interaction, theme);
        } else if (info.length == 6) {
            String name = info[0];
            String building = info[1];
            String room = info[2];
            String interaction = info[3];
            String theme = info[4];
            String action = info[5];
            return new Resident(name, building, room, interaction, theme, action);
        } else if (info.length == 7) {
            String name = info[0];
            String building = info[1];
            String room = info[2];
            String interaction = info[3];
            String theme = info[4];
            String action = info[5];
            String notes = info[6];
            return new Resident(name, building, room, interaction, theme, action, notes);
        } else {
            return new Resident(null, null, null);
        }
    }


}
