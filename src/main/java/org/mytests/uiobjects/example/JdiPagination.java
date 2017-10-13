package org.mytests.uiobjects.example;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import org.openqa.selenium.support.FindBy;

public class JdiPagination extends Pagination {
    @FindBy(css = ".uui-pagination .next a")
    public IButton next;

    @FindBy(css = ".uui-pagination .prev a")
    public IButton prev;

    @FindBy(css = ".uui-pagination .first a")
    public IButton first;

    @FindBy(css = ".uui-pagination .last a")
    public IButton last;

    @FindBy(css = ".uui-pagination a")
    private Elements<Button> pages;

    @Override
    public void selectPage(int index) {
        pages.get(String.valueOf(index)).click();
    }
}