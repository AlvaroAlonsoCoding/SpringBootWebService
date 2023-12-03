package com.varocode.springbootws;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author aap
 * Tests for API query validation. Price, Dates, Brand and ProductId fields are checked
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SpringbootwsApplication.class)
@AutoConfigureMockMvc
class ProductPriceControllerTests {

    @Autowired
    MockMvc mvc;

    @Test
    void firstQueryTest() throws Exception {
        genericDemoTest("2020-06-14T10:00:00",
                35455, "ZARA",
                "2020-06-14T00:00:00",
                "2020-12-31T23:59:59",
                35.50d);
    }

    @Test
    void secondQueryTest() throws Exception {
        genericDemoTest("2020-06-14T16:00:00",
                35455, "ZARA",
                "2020-06-14T15:00:00",
                "2020-06-14T18:30:00",
                25.45d);
    }

    @Test
    void thirdQueryTest() throws Exception {
        genericDemoTest("2020-06-14T21:00:00",
                35455, "ZARA",
                "2020-06-14T00:00:00",
                "2020-12-31T23:59:59",
                35.50d);
    }

    @Test
    void fourthQueryTest() throws Exception {
        genericDemoTest("2020-06-15T10:00:00",
                35455, "ZARA",
                "2020-06-15T00:00:00",
                "2020-06-15T11:00:00",
                30.50d);
    }

    @Test
    void fifthQueryTest() throws Exception {
        genericDemoTest("2020-06-16T21:00:00",
                35455, "ZARA",
                "2020-06-15T16:00:00",
                "2020-12-31T23:59:59",
                38.95d);
    }

    private void genericDemoTest(String date, int productId, String brandName, String expectedStartDate, String expectedEndDate, double expectedPrice) throws Exception {
        mvc.perform(get("/productPriceFinder?productId=" + productId + "&brand=" + brandName + "&date=" + date)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(9)))
                .andExpect(jsonPath("$.productId", is(productId)))
                .andExpect(jsonPath("$.brand.name", is(brandName)))
                .andExpect(jsonPath("$.startDate", is(expectedStartDate)))
                .andExpect(jsonPath("$.endDate", is(expectedEndDate)))
                .andExpect(jsonPath("$.price", is(expectedPrice)));
    }

}
