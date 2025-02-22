package com.currencycloud.client;

import com.currencycloud.client.model.Beneficiaries;
import com.currencycloud.client.model.Beneficiary;
import com.currencycloud.client.model.BeneficiaryAccountVerification;
import com.currencycloud.client.model.BeneficiaryAccountVerificationRequest;
import com.currencycloud.client.model.Pagination;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class BeneficiariesTest extends TestSupport {

    private CurrencyCloudClient client;

    @Before
    public void prepareClient() {
        client = prepareTestClient(null, null, "6f5f99d1b860fc47e8a186e3dce0d3f9");
    }

    @Before
    @After
    public void methodName() { log.debug("------------------------- " + name.getMethodName() + " -------------------------"); }

    @Test
    public void testCanCreateBeneficiary() {
        Beneficiary beneficiary = Beneficiary.create("Test User", "GB", "GBP", "Test User");
        beneficiary.setEmail("development@currencycloud.com");
        ArrayList<String> beneficiaryAddress = new ArrayList<>();
        beneficiaryAddress.add("12 Steward St, London E1 6FQ");
        beneficiary.setBeneficiaryAddress(beneficiaryAddress);
        beneficiary.setBeneficiaryCountry("GB");
        beneficiary.setAccountNumber("13071472");
        beneficiary.setRoutingCodeType1("sort_code");
        beneficiary.setRoutingCodeValue1("200605");
        beneficiary.setBicSwift("BARCGB22");
        beneficiary.setIban("GB06 BARC 2006 0513 0714 72");
        ArrayList<String> bankAddress = new ArrayList<>();
        bankAddress.add("1 Churchill Place, London, E14 5HP");
        beneficiary.setBankAddress(bankAddress);
        beneficiary.setBankName("Barclays Bank plc");
        beneficiary.setBankAccountType("checking");
        beneficiary.setBeneficiaryEntityType("individual");
        beneficiary.setBeneficiaryCompanyName("Private");
        beneficiary.setBeneficiaryFirstName("Test");
        beneficiary.setBeneficiaryLastName("User");
        beneficiary.setBeneficiaryCity("London");
        beneficiary.setBeneficiaryPostcode("E1 6FQ");
        beneficiary.setBeneficiaryStateOrProvince("London");
        beneficiary.setBeneficiaryDateOfBirth(parseDate("1986-12-12"));
        beneficiary.setBeneficiaryIdentificationType("passport");
        beneficiary.setBeneficiaryIdentificationValue("AE02315508BF");
        beneficiary.setBeneficiaryExternalReference("External Reference One");
        beneficiary.setPaymentTypes(Collections.singletonList("regular"));
        beneficiary = client.createBeneficiary(beneficiary);

        assertThat(beneficiary, is(notNullValue()));
        assertThat(beneficiary.getId(), equalTo("081596c9-02de-483e-9f2a-4cf55dcdf98c"));
        assertThat(beneficiary.getBankAccountHolderName(), equalTo("Test User"));
        assertThat(beneficiary.getBankCountry(), equalTo("GB"));
        assertThat(beneficiary.getCurrency(), equalTo("GBP"));
        assertThat(beneficiary.getName(), equalTo("Test User"));
        assertThat(beneficiary.getEmail(), equalTo("development@currencycloud.com"));
        assertThat(beneficiary.getBeneficiaryAddress(), hasItem("12 Steward St, London E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryCountry(), equalTo("GB"));
        assertThat(beneficiary.getAccountNumber(), equalTo("13071472"));
        assertThat(beneficiary.getRoutingCodeType1(), equalTo("sort_code"));
        assertThat(beneficiary.getRoutingCodeValue1(), equalTo("200605"));
        assertThat(beneficiary.getBicSwift(), equalTo("BARCGB22"));
        assertThat(beneficiary.getIban(), equalTo("GB06 BARC 2006 0513 0714 72"));
        assertThat(beneficiary.getBankAddress(), hasItem("1 Churchill Place"));
        assertThat(beneficiary.getBankName(), equalTo("Barclays Bank plc"));
        assertThat(beneficiary.getBankAccountType(), equalTo("checking"));
        assertThat(beneficiary.getBeneficiaryEntityType(), equalTo("individual"));
        assertThat(beneficiary.getBeneficiaryCompanyName(), equalTo("Private"));
        assertThat(beneficiary.getBeneficiaryFirstName(), equalTo("Test"));
        assertThat(beneficiary.getBeneficiaryLastName(), equalTo("User"));
        assertThat(beneficiary.getBeneficiaryCity(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryPostcode(), equalTo("E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryStateOrProvince(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryDateOfBirth(), equalTo(parseDate("1986-12-12")));
        assertThat(beneficiary.getPaymentTypes(), hasItem("regular"));
        assertThat(beneficiary.getBeneficiaryIdentificationType(), equalTo("passport"));
        assertThat(beneficiary.getBeneficiaryIdentificationValue(), equalTo("AE02315508BF"));
        assertThat(beneficiary.getBeneficiaryExternalReference(), equalTo("External Reference One"));
        assertThat(beneficiary.getCreatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
        assertThat(beneficiary.getUpdatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
    }

    @Test
    public void testCanCreateBeneficiaryBusinessNature() {
        Beneficiary beneficiary = Beneficiary.create("Test User", "GB", "GBP", "Test User");
        beneficiary.setEmail("development@currencycloud.com");
        ArrayList<String> beneficiaryAddress = new ArrayList<>();
        beneficiaryAddress.add("12 Steward St, London E1 6FQ");
        beneficiary.setBeneficiaryAddress(beneficiaryAddress);
        beneficiary.setBeneficiaryCountry("GB");
        beneficiary.setAccountNumber("13071472");
        beneficiary.setRoutingCodeType1("sort_code");
        beneficiary.setRoutingCodeValue1("200605");
        beneficiary.setBicSwift("BARCGB22");
        beneficiary.setIban("GB06 BARC 2006 0513 0714 72");
        ArrayList<String> bankAddress = new ArrayList<>();
        bankAddress.add("1 Churchill Place, London, E14 5HP");
        beneficiary.setBankAddress(bankAddress);
        beneficiary.setBankName("Barclays Bank plc");
        beneficiary.setBankAccountType("checking");
        beneficiary.setBeneficiaryEntityType("individual");
        beneficiary.setBeneficiaryCompanyName("Private");
        beneficiary.setBeneficiaryFirstName("Test");
        beneficiary.setBeneficiaryLastName("User");
        beneficiary.setBeneficiaryCity("London");
        beneficiary.setBeneficiaryPostcode("E1 6FQ");
        beneficiary.setBeneficiaryStateOrProvince("London");
        beneficiary.setBeneficiaryDateOfBirth(parseDate("1986-12-12"));
        beneficiary.setBeneficiaryIdentificationType("passport");
        beneficiary.setBeneficiaryIdentificationValue("AE02315508BF");
        beneficiary.setBeneficiaryExternalReference("External Reference One");
        beneficiary.setPaymentTypes(Collections.singletonList("regular"));
        beneficiary.setBusinessNature("law");
        beneficiary.setCompanyWebsite("test.com");
        beneficiary = client.createBeneficiary(beneficiary);

        assertThat(beneficiary, is(notNullValue()));
        assertThat(beneficiary.getId(), equalTo("081596c9-02de-483e-9f2a-4cf55dcdf98c"));
        assertThat(beneficiary.getBankAccountHolderName(), equalTo("Test User"));
        assertThat(beneficiary.getBankCountry(), equalTo("GB"));
        assertThat(beneficiary.getCurrency(), equalTo("GBP"));
        assertThat(beneficiary.getName(), equalTo("Test User"));
        assertThat(beneficiary.getEmail(), equalTo("development@currencycloud.com"));
        assertThat(beneficiary.getBeneficiaryAddress(), hasItem("12 Steward St, London E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryCountry(), equalTo("GB"));
        assertThat(beneficiary.getAccountNumber(), equalTo("13071472"));
        assertThat(beneficiary.getRoutingCodeType1(), equalTo("sort_code"));
        assertThat(beneficiary.getRoutingCodeValue1(), equalTo("200605"));
        assertThat(beneficiary.getBicSwift(), equalTo("BARCGB22"));
        assertThat(beneficiary.getIban(), equalTo("GB06 BARC 2006 0513 0714 72"));
        assertThat(beneficiary.getBankAddress(), hasItem("1 Churchill Place"));
        assertThat(beneficiary.getBankName(), equalTo("Barclays Bank plc"));
        assertThat(beneficiary.getBankAccountType(), equalTo("checking"));
        assertThat(beneficiary.getBeneficiaryEntityType(), equalTo("individual"));
        assertThat(beneficiary.getBeneficiaryCompanyName(), equalTo("Private"));
        assertThat(beneficiary.getBeneficiaryFirstName(), equalTo("Test"));
        assertThat(beneficiary.getBeneficiaryLastName(), equalTo("User"));
        assertThat(beneficiary.getBeneficiaryCity(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryPostcode(), equalTo("E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryStateOrProvince(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryDateOfBirth(), equalTo(parseDate("1986-12-12")));
        assertThat(beneficiary.getPaymentTypes(), hasItem("regular"));
        assertThat(beneficiary.getBeneficiaryIdentificationType(), equalTo("passport"));
        assertThat(beneficiary.getBeneficiaryIdentificationValue(), equalTo("AE02315508BF"));
        assertThat(beneficiary.getBeneficiaryExternalReference(), equalTo("External Reference One"));
        assertThat(beneficiary.getBusinessNature(), equalTo("law"));
        assertThat(beneficiary.getCompanyWebsite(), equalTo("test.com"));
        assertThat(beneficiary.getCreatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
        assertThat(beneficiary.getUpdatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
    }

    @Test
    public void testCanRetrieveBeneficiary() {
        Beneficiary beneficiary = client.retrieveBeneficiary("081596c9-02de-483e-9f2a-4cf55dcdf98c");

        assertThat(beneficiary, is(notNullValue()));
        assertThat(beneficiary.getId(), equalTo("081596c9-02de-483e-9f2a-4cf55dcdf98c"));
        assertThat(beneficiary.getBankAccountHolderName(), equalTo("Test User"));
        assertThat(beneficiary.getBankCountry(), equalTo("GB"));
        assertThat(beneficiary.getCurrency(), equalTo("GBP"));
        assertThat(beneficiary.getName(), equalTo("Test User"));
        assertThat(beneficiary.getEmail(), equalTo("development@currencycloud.com"));
        assertThat(beneficiary.getBeneficiaryAddress(), hasItem("12 Steward St, London E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryCountry(), equalTo("GB"));
        assertThat(beneficiary.getAccountNumber(), equalTo("13071472"));
        assertThat(beneficiary.getRoutingCodeType1(), equalTo("sort_code"));
        assertThat(beneficiary.getRoutingCodeValue1(), equalTo("200605"));
        assertThat(beneficiary.getBicSwift(), equalTo("BARCGB22"));
        assertThat(beneficiary.getIban(), equalTo("GB06 BARC 2006 0513 0714 72"));
        assertThat(beneficiary.getBankAddress(), hasItem("1 Churchill Place"));
        assertThat(beneficiary.getBankName(), equalTo("Barclays Bank plc"));
        assertThat(beneficiary.getBankAccountType(), equalTo("checking"));
        assertThat(beneficiary.getBeneficiaryEntityType(), equalTo("individual"));
        assertThat(beneficiary.getBeneficiaryCompanyName(), equalTo("Private"));
        assertThat(beneficiary.getBeneficiaryFirstName(), equalTo("Test"));
        assertThat(beneficiary.getBeneficiaryLastName(), equalTo("User"));
        assertThat(beneficiary.getBeneficiaryCity(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryPostcode(), equalTo("E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryStateOrProvince(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryDateOfBirth(), equalTo(parseDate("1986-12-12")));
        assertThat(beneficiary.getPaymentTypes(), hasItem("regular"));
        assertThat(beneficiary.getBeneficiaryIdentificationType(), equalTo("passport"));
        assertThat(beneficiary.getBeneficiaryIdentificationValue(), equalTo("AE02315508BF"));
        assertThat(beneficiary.getCreatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
        assertThat(beneficiary.getUpdatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
    }

    @Test
    public void testCanFindBeneficiary() {
        Beneficiary beneficiaryCondition = Beneficiary.create();
        beneficiaryCondition.setBankAccountHolderName("Test User");
        beneficiaryCondition.setBankCountry("GB");
        beneficiaryCondition.setCurrency("GBP");
        Pagination paginationCondition = new Pagination();
        paginationCondition.setPerPage(10);
        paginationCondition.setOrder("created_at");
        paginationCondition.setOrderAscDesc(Pagination.SortOrder.asc);
        Beneficiaries beneficiariesData = client.findBeneficiaries(beneficiaryCondition, paginationCondition);
        List<Beneficiary> beneficiaries = beneficiariesData.getBeneficiaries();
        Pagination pagination = beneficiariesData.getPagination();

        assertThat(beneficiaries, not(empty()));
        assertThat(beneficiaries.size(), is(2));
        assertThat(pagination.getTotalEntries(), equalTo(2));
        assertThat(pagination.getTotalPages(), equalTo(1));
        assertThat(pagination.getCurrentPage(), equalTo(1));
        assertThat(pagination.getPerPage(), equalTo(10));
        assertThat(pagination.getPreviousPage(), equalTo(-1));
        assertThat(pagination.getNextPage(), equalTo(-1));
        assertThat(pagination.getOrder(), equalTo("created_at"));
        assertThat(pagination.getOrderAscDesc(), equalTo(Pagination.SortOrder.asc));
    }

    @Test
    public void testCanUpdateBeneficiary() {
        Beneficiary beneficiary = Beneficiary.create();
        beneficiary.setId("081596c9-02de-483e-9f2a-4cf55dcdf98c");
        beneficiary.setBankAccountHolderName("Test User 2");
        beneficiary.setBeneficiaryDateOfBirth(parseDate("1968-03-23"));
        beneficiary.setBeneficiaryExternalReference("External Reference Two");
        beneficiary = client.updateBeneficiary(beneficiary);

        assertThat(beneficiary, is(notNullValue()));
        assertThat(beneficiary.getId(), equalTo("081596c9-02de-483e-9f2a-4cf55dcdf98c"));
        assertThat(beneficiary.getBankAccountHolderName(), equalTo("Test User 2"));
        assertThat(beneficiary.getBankCountry(), equalTo("GB"));
        assertThat(beneficiary.getCurrency(), equalTo("GBP"));
        assertThat(beneficiary.getName(), equalTo("Test User"));
        assertThat(beneficiary.getEmail(), equalTo("development@currencycloud.com"));
        assertThat(beneficiary.getBeneficiaryAddress(), hasItem("12 Steward St, London E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryCountry(), equalTo("GB"));
        assertThat(beneficiary.getAccountNumber(), equalTo("13071472"));
        assertThat(beneficiary.getRoutingCodeType1(), equalTo("sort_code"));
        assertThat(beneficiary.getRoutingCodeValue1(), equalTo("200605"));
        assertThat(beneficiary.getBicSwift(), equalTo("BARCGB22"));
        assertThat(beneficiary.getIban(), equalTo("GB06 BARC 2006 0513 0714 72"));
        assertThat(beneficiary.getBankAddress(), hasItem("1 Churchill Place"));
        assertThat(beneficiary.getBankName(), equalTo("Barclays Bank plc"));
        assertThat(beneficiary.getBankAccountType(), equalTo("checking"));
        assertThat(beneficiary.getBeneficiaryEntityType(), equalTo("individual"));
        assertThat(beneficiary.getBeneficiaryCompanyName(), equalTo("Private"));
        assertThat(beneficiary.getBeneficiaryFirstName(), equalTo("Test"));
        assertThat(beneficiary.getBeneficiaryLastName(), equalTo("User"));
        assertThat(beneficiary.getBeneficiaryCity(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryPostcode(), equalTo("E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryStateOrProvince(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryDateOfBirth(), equalTo(parseDate("1968-03-23")));
        assertThat(beneficiary.getPaymentTypes(), hasItem("regular"));
        assertThat(beneficiary.getBeneficiaryIdentificationType(), equalTo("passport"));
        assertThat(beneficiary.getBeneficiaryIdentificationValue(), equalTo("AE02315508BF"));
        assertThat(beneficiary.getBeneficiaryExternalReference(), equalTo("External Reference Two"));
        assertThat(beneficiary.getCreatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
        assertThat(beneficiary.getUpdatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
    }


    @Test
    public void testCanUpdateBeneficiaryWebsite() {
        Beneficiary beneficiary = Beneficiary.create();
        beneficiary.setId("081596c9-02de-483e-9f2a-4cf55dcdf98c");
        beneficiary.setBankAccountHolderName("Test User 2");
        beneficiary.setBeneficiaryDateOfBirth(parseDate("1968-03-23"));
        beneficiary.setBeneficiaryExternalReference("External Reference Two");
        beneficiary.setCompanyWebsite("test2.com");
        beneficiary.setBusinessNature("laws");
        beneficiary = client.updateBeneficiary(beneficiary);

        assertThat(beneficiary, is(notNullValue()));
        assertThat(beneficiary.getId(), equalTo("081596c9-02de-483e-9f2a-4cf55dcdf98c"));
        assertThat(beneficiary.getBankAccountHolderName(), equalTo("Test User 2"));
        assertThat(beneficiary.getBankCountry(), equalTo("GB"));
        assertThat(beneficiary.getCurrency(), equalTo("GBP"));
        assertThat(beneficiary.getName(), equalTo("Test User"));
        assertThat(beneficiary.getEmail(), equalTo("development@currencycloud.com"));
        assertThat(beneficiary.getBeneficiaryAddress(), hasItem("12 Steward St, London E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryCountry(), equalTo("GB"));
        assertThat(beneficiary.getAccountNumber(), equalTo("13071472"));
        assertThat(beneficiary.getRoutingCodeType1(), equalTo("sort_code"));
        assertThat(beneficiary.getRoutingCodeValue1(), equalTo("200605"));
        assertThat(beneficiary.getBicSwift(), equalTo("BARCGB22"));
        assertThat(beneficiary.getIban(), equalTo("GB06 BARC 2006 0513 0714 72"));
        assertThat(beneficiary.getBankAddress(), hasItem("1 Churchill Place"));
        assertThat(beneficiary.getBankName(), equalTo("Barclays Bank plc"));
        assertThat(beneficiary.getBankAccountType(), equalTo("checking"));
        assertThat(beneficiary.getBeneficiaryEntityType(), equalTo("individual"));
        assertThat(beneficiary.getBeneficiaryCompanyName(), equalTo("Private"));
        assertThat(beneficiary.getBeneficiaryFirstName(), equalTo("Test"));
        assertThat(beneficiary.getBeneficiaryLastName(), equalTo("User"));
        assertThat(beneficiary.getBeneficiaryCity(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryPostcode(), equalTo("E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryStateOrProvince(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryDateOfBirth(), equalTo(parseDate("1968-03-23")));
        assertThat(beneficiary.getPaymentTypes(), hasItem("regular"));
        assertThat(beneficiary.getBeneficiaryIdentificationType(), equalTo("passport"));
        assertThat(beneficiary.getBeneficiaryIdentificationValue(), equalTo("AE02315508BF"));
        assertThat(beneficiary.getBeneficiaryExternalReference(), equalTo("External Reference Two"));
        assertThat(beneficiary.getCreatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
        assertThat(beneficiary.getUpdatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
    }

    @Test
    public void testCanDeleteBeneficiary() {
        Beneficiary beneficiary = client.deleteBeneficiary("081596c9-02de-483e-9f2a-4cf55dcdf98c");

        assertThat(beneficiary, is(notNullValue()));
        assertThat(beneficiary.getId(), equalTo("081596c9-02de-483e-9f2a-4cf55dcdf98c"));
        assertThat(beneficiary.getBankAccountHolderName(), equalTo("Test User 2"));
        assertThat(beneficiary.getBankCountry(), equalTo("GB"));
        assertThat(beneficiary.getCurrency(), equalTo("GBP"));
        assertThat(beneficiary.getName(), equalTo("Test User"));
        assertThat(beneficiary.getEmail(), equalTo("development@currencycloud.com"));
        assertThat(beneficiary.getBeneficiaryAddress(), hasItem("12 Steward St, London E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryCountry(), equalTo("GB"));
        assertThat(beneficiary.getAccountNumber(), equalTo("13071472"));
        assertThat(beneficiary.getRoutingCodeType1(), equalTo("sort_code"));
        assertThat(beneficiary.getRoutingCodeValue1(), equalTo("200605"));
        assertThat(beneficiary.getBicSwift(), equalTo("BARCGB22"));
        assertThat(beneficiary.getIban(), equalTo("GB06 BARC 2006 0513 0714 72"));
        assertThat(beneficiary.getBankAddress(), hasItem("1 Churchill Place"));
        assertThat(beneficiary.getBankName(), equalTo("Barclays Bank plc"));
        assertThat(beneficiary.getBankAccountType(), equalTo("checking"));
        assertThat(beneficiary.getBeneficiaryEntityType(), equalTo("individual"));
        assertThat(beneficiary.getBeneficiaryCompanyName(), equalTo("Private"));
        assertThat(beneficiary.getBeneficiaryFirstName(), equalTo("Test"));
        assertThat(beneficiary.getBeneficiaryLastName(), equalTo("User"));
        assertThat(beneficiary.getBeneficiaryCity(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryPostcode(), equalTo("E1 6FQ"));
        assertThat(beneficiary.getBeneficiaryStateOrProvince(), equalTo("London"));
        assertThat(beneficiary.getBeneficiaryDateOfBirth(), equalTo(parseDate("1968-03-23")));
        assertThat(beneficiary.getPaymentTypes(), hasItem("regular"));
        assertThat(beneficiary.getBeneficiaryIdentificationType(), equalTo("passport"));
        assertThat(beneficiary.getBeneficiaryIdentificationValue(), equalTo("AE02315508BF"));
        assertThat(beneficiary.getCreatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
        assertThat(beneficiary.getUpdatedAt(), equalTo(parseDateTime("2018-01-01T12:34:56+00:00")));
    }

    @Test
    public void testCanValidateBeneficiaries() {
        client.setAuthToken("4df5b3e5882a412f148dcd08fa4e5b73");
        Beneficiary beneficiary = Beneficiary.create();
        beneficiary.setBankCountry("GB");
        beneficiary.setCurrency("GBP");
        beneficiary.setBeneficiaryCountry("GB");
        beneficiary.setAccountNumber("1234567890");
        beneficiary.setRoutingCodeType1("sort_code");
        beneficiary.setRoutingCodeValue1("123456");
        beneficiary.setPaymentTypes(Collections.singletonList("regular"));
        beneficiary.setBeneficiaryDateOfBirth(parseDate("1986-12-12"));
        beneficiary = client.validateBeneficiary(beneficiary);

        List<String> paymentTypes = Collections.singletonList("regular");
        assertThat(beneficiary, is(notNullValue()));
        assertThat(beneficiary.getPaymentTypes(), Matchers.equalTo(paymentTypes));
        assertThat(beneficiary.getBankCountry(), equalTo("GB"));
        assertThat(beneficiary.getBankName(), equalTo("Sample bank name"));
        assertThat(beneficiary.getCurrency(), equalTo("GBP"));
        assertThat(beneficiary.getAccountNumber(), equalTo("1234567890"));
        assertThat(beneficiary.getRoutingCodeType1(), equalTo("sort_code"));
        assertThat(beneficiary.getBankAccountType(), equalTo("checking"));
        assertThat(beneficiary.getBeneficiaryAddress(), empty());
        assertThat(beneficiary.getBeneficiaryCountry(), equalTo("GB"));
        assertThat(beneficiary.getBeneficiaryEntityType(), equalTo("company"));
        assertThat(beneficiary.getBeneficiaryCompanyName(), equalTo("Sample Company Name"));
        assertThat(beneficiary.getBeneficiaryFirstName(), is(not(nullValue())));
        assertThat(beneficiary.getBeneficiaryLastName(), not(nullValue()));
        assertThat(beneficiary.getBeneficiaryCity(), is(emptyOrNullString()));
        assertThat(beneficiary.getBeneficiaryPostcode(), is(emptyString()));
        assertThat(beneficiary.getBeneficiaryStateOrProvince(), equalTo(""));
        assertThat(beneficiary.getBeneficiaryDateOfBirth(), equalTo(parseDate("1986-12-12")));
        assertThat(beneficiary.getBeneficiaryIdentificationType(), equalTo("none"));
        assertThat(beneficiary.getBeneficiaryIdentificationValue(), equalTo(""));
        assertThat(beneficiary.getRoutingCodeValue1(), equalTo("123456"));
        assertThat(beneficiary.getRoutingCodeType2(), is(not(nullValue())));
        assertThat(beneficiary.getRoutingCodeValue2(), not(nullValue()));
        assertThat(beneficiary.getBicSwift(), is(emptyOrNullString()));
        assertThat(beneficiary.getIban(), is(emptyString()));
        assertThat(beneficiary.getBankAddress(), hasItem("Sample bank address"));
    }

    @Test
    public void testCanVerifyAccount() {
        client.setAuthToken("4df5b3e5882a412f148dcd08fa4e5b73");
        BeneficiaryAccountVerificationRequest beneficiary = BeneficiaryAccountVerificationRequest.create();
        beneficiary.setBankCountry("GB");
        beneficiary.setAccountNumber("1234567890");
        beneficiary.setRoutingCodeValue1("123456");
        beneficiary.setBeneficiaryEntityType("individual");
        beneficiary.setBeneficiaryFirstName("Test");
        beneficiary.setBeneficiaryLastName("User");

        BeneficiaryAccountVerification beneficiaryAccountVerification = client.verifyAccount(beneficiary);

        assertThat(beneficiaryAccountVerification, is(notNullValue()));
        assertThat(beneficiaryAccountVerification.getAnswer(), equalTo("confirmed"));
        assertThat(beneficiaryAccountVerification.getActualName(), equalTo("Test User"));
        assertThat(beneficiaryAccountVerification.getReasonCode(), equalTo("FMCH"));
        assertThat(beneficiaryAccountVerification.getReason(), equalTo("Full match"));
    }
}
