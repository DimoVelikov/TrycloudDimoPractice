package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilePage {

    public FilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//th[@id='headerSelection'])[1]")
    public WebElement selectAllCheckBox;

    @FindBy(xpath = "//tbody[@id='fileList']//input[@type='checkbox']")
    public List<WebElement> allCheckBox;

    @FindBy(xpath = "(//a[@class='action action-menu permanent'])[1]")
    public WebElement actionIcon;


}
