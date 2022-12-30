package co.com.sofka.stepdefinitions.practiceform;

import co.com.sofka.exceptions.practiceform.ValidationTextDoNotMatch;
import co.com.sofka.setup.ui.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.practiceform.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.practiceForm.PracticeForm.practiceForm;
import static co.com.sofka.tasks.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.practiceform.BrowseToPracticeForm.browseToPracticeForm;
import static co.com.sofka.tasks.practiceform.FillAllFieldsPracticeForm.fillAllFieldsPracticeForm;
import static co.com.sofka.userinterfaces.practiceform.BrowseToPracticeFormPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PracticeFormStepDefinition extends Setup {

    private static final String ACTOR_NAME = "Mario";

    private DataTable dataTableToValidate;

    @Given("the student is on landing page of Tools QA")
    public void theStudentIsOnLandingPageOfToolsQA() {

        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @When("him browse to registration form")
    public void himBrowseToRegistrationForm() {
        theActorInTheSpotlight().attemptsTo(
                browseToPracticeForm()
        );

    }

    @When("him has filled it and submitted")
    public void himHasFilledItAndSubmitted(DataTable studentDataTable) {
        dataTableToValidate = studentDataTable;
        theActorInTheSpotlight().attemptsTo(
                fillAllFieldsPracticeForm()
                        .usingFirstName(studentDataTable.row(0).get(1))
                        .usingLastName(studentDataTable.row(1).get(1))
                        .usingGender(studentDataTable.row(2).get(1))
                        .andUsingMobile(studentDataTable.row(3).get(1))
        );

    }

    @Then("the student will see a registration information")
    public void theStudentWillSeeARegistrationInformation() {

        theActorInTheSpotlight()
                .should(
                        seeThat(
                            practiceForm()
                                .wasFilledWithFirstName(dataTableToValidate.row(0).get(1))
                                .andWithLastName(dataTableToValidate.row(1).get(1))
                                .andWithGender(dataTableToValidate.row(2).get(1))
                                .andWithMobile(dataTableToValidate.row(3).get(1))
                                .is(), equalTo(true)
                ).orComplainWith(
                        ValidationTextDoNotMatch.class,
                                String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome())
                        )
        );

    }

    private String compareInWithSystemOutcome(){
        return "\n" + "Data for test : System outcome"
                + "\n" + dataTableToValidate.row(0).get(1) + " " + dataTableToValidate.row(1).get(1) + " : " + STUDENT_NAME_VALIDATION.resolveFor(theActorInTheSpotlight()).getText()
                + "\n" + dataTableToValidate.row(2).get(1) + " : " + GENDER_VALIDATION.resolveFor(theActorInTheSpotlight()).getText()
                + "\n" + dataTableToValidate.row(3).get(1) + " : " + MOBILE_VALIDATION.resolveFor(theActorInTheSpotlight()).getText()
                ;
    }
}
