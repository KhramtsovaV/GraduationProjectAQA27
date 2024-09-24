package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import utils.ProjectDirector;
import utils.UserDirector;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DeleteProjectTest extends BaseTest {

    @Test
    public void deleteTest() {
        loginStep
                .successfulLogin(UserDirector.getAdmin())
                        .createNewProject();

        projectStep
                .addProject(ProjectDirector.getProject())
                .clickManageProjectsButton()
                .getDeleteButton()
                .click();

        $("div.dialog__header__content__title[data-target='title']")
                .shouldHave(text("Delete project"))
                .shouldBe(visible);

        $("label[data-target='confirmationLabel']")
                .click();

        $("button.ui.negative.button[data-action='click->doDelete'][data-target='deleteButton']")
                .shouldBe(visible)
                .shouldNotBe(disabled)
                .click();
    }

}