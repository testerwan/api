package com.demo.douban;

import com.demo.common.runner.BaseRunner;
import com.demo.common.utils.ProxyUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestMovieApi extends BaseRunner {

    private MovieApi movieApi = ProxyUtils.create(MovieApi.class);

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }



    /**
     *
     */
    @Test
    public void testTop250() throws Exception {
        response = movieApi.top250(0, 1);
        response.then().body("subjects[0].title", equalTo("肖申克的救赎"));

        response = movieApi.top250(0, 2);
        response.then().body("subjects[1].title", equalTo("霸王别姬"));
    }
}
