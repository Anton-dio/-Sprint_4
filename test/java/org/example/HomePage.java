package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

    private WebDriver driver;
    //локатор для верхней кнопки Заказать
    private By higherOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g' and text()='Заказать')]");
    //локатор для нижней кнопки Заказать
    private By lowerOrderButton = By.className("Button_Middle__1CSJM");
    //Локаторы кнопкок вопросов раздела Вопросы о важном
    private By buttonsImpotantQuestionsList_0 = By.id("accordion__heading-0");
    private By buttonsImpotantQuestionsList_1 = By.id("accordion__heading-1");
    private By buttonsImpotantQuestionsList_2 = By.id("accordion__heading-2");
    private By buttonsImpotantQuestionsList_3 = By.id("accordion__heading-3");
    private By buttonsImpotantQuestionsList_4 = By.id("accordion__heading-4");
    private By buttonsImpotantQuestionsList_5 = By.id("accordion__heading-5");
    private By buttonsImpotantQuestionsList_6 = By.id("accordion__heading-6");
    private By buttonsImpotantQuestionsList_7 = By.id("accordion__heading-7");
    //Массив из локаторов кнопок раздела Вопрсоы о важном
    private By[] buttonsImpotantQuestionsArray = {buttonsImpotantQuestionsList_0, buttonsImpotantQuestionsList_1, buttonsImpotantQuestionsList_2, buttonsImpotantQuestionsList_3, buttonsImpotantQuestionsList_4, buttonsImpotantQuestionsList_5, buttonsImpotantQuestionsList_6, buttonsImpotantQuestionsList_7};
    //локаторы к текстовым ответам раздела Вопросы о важном
    private By answersImpotantQuestionsList_0 = By.xpath(".//div[@id='accordion__panel-0']/p");
    private By answersImpotantQuestionsList_1 = By.xpath(".//div[@id='accordion__panel-1']/p");
    private By answersImpotantQuestionsList_2 = By.xpath(".//div[@id='accordion__panel-2']/p");
    private By answersImpotantQuestionsList_3 = By.xpath(".//div[@id='accordion__panel-3']/p");
    private By answersImpotantQuestionsList_4 = By.xpath(".//div[@id='accordion__panel-4']/p");
    private By answersImpotantQuestionsList_5 = By.xpath(".//div[@id='accordion__panel-5']/p");
    private By answersImpotantQuestionsList_6 = By.xpath(".//div[@id='accordion__panel-6']/p");
    private By answersImpotantQuestionsList_7 = By.xpath(".//div[@id='accordion__panel-7']/p");
    //Массив локаторов из текстовых ответов раздела Вопрсоы о важном
    private By[] answersImpotantQuestionsArray = {answersImpotantQuestionsList_0, answersImpotantQuestionsList_1, answersImpotantQuestionsList_2, answersImpotantQuestionsList_3, answersImpotantQuestionsList_4, answersImpotantQuestionsList_5, answersImpotantQuestionsList_6, answersImpotantQuestionsList_7};
    //Массив ожидаемых ответов к вопросам
    private String[] expectedAnswersImpotantQuestions = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    //открыть главную страницу Самоката
    public void openScooterPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //пролистнуть страницу и кликнуть по кнопке в разделе Вопросы о важном (и тут немного ожидания добавил, что визуально понятнее было)
    public void clickButtonsImpotantQuestions(int listIndex) {
        By locator = buttonsImpotantQuestionsArray[listIndex];
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    //кликнуть по верхней кнопке Заказать на главной странице
    public void higherOrderButtonClick() {

        driver.findElement(higherOrderButton).click();

    }

    //кликнуть по нижней кнопке Заказать
    public HomePage lowerOrderButtonClick() {
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(lowerOrderButton).click();
        return this;
    }

    //выбор кнопки Заказать на странице
    public HomePage chooseOrderButtonAndClick(String buttonLocation) {
        if (buttonLocation.equals("up")) {
            higherOrderButtonClick();
            return this;
        } else if (buttonLocation.equals("down")) {
            lowerOrderButtonClick();
            return this;
        }
        return this;
    }

    //метод для получения текста из текстовых ответов раздела Вопрсоы о важном
    public String getAnswersImpotantQuestions(int listIndex) {
        By locator = answersImpotantQuestionsArray[listIndex];
        return driver.findElement(locator).getText();
    }

    //метод для сравнения текстовых ответов с ожидаемыми ответами (немного ожидания добавил, т.к. у меня очень быстро прокликивает и некоторые не успевает проверить)
    public boolean contentIsDisplayed(int listIndex) {
        By locator = answersImpotantQuestionsArray[listIndex];
        String expectedAnswersText = expectedAnswersImpotantQuestions[listIndex];
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).isDisplayed() && getAnswersImpotantQuestions(listIndex).equals(expectedAnswersText);
    }


}

