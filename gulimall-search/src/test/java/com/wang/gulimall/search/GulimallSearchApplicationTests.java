package com.wang.gulimall.search;

import com.alibaba.fastjson.JSON;
import com.wang.gulimall.search.config.GulimallElasticSearchConfig;
import lombok.Data;
import lombok.ToString;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GulimallSearchApplicationTests {

    @Autowired
    RestHighLevelClient esClient;

    @Test
    public void contextLoads() {
        System.out.println(esClient);
    }

    @Data
    class User {
        private int age;
        private String name;
        private String gender;
    }

    @ToString(callSuper = true)
    @Data
    static class Account {

        private int account_number;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;


    }

    @Test
    public void index() throws IOException {
        //创建索引
        User user = new User();
        user.setName("wsz");
        user.setAge(18);
        ;
        user.setGender("男");
        IndexRequest indexRequest = new IndexRequest("users");
        String s = JSON.toJSONString(user);
        indexRequest.source(s, XContentType.JSON);
        IndexResponse index = esClient.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);


    }

    @Test
    public void searchData() throws IOException {
        //查询数据
        SearchRequest searchRequest = new SearchRequest("bank");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("address", "mill"));
        searchSourceBuilder.aggregation(AggregationBuilders.terms("ageAgg").field("age").size(10));
        searchSourceBuilder.aggregation(AggregationBuilders.avg("balanceAvg").field("balance"));
        System.out.println(searchSourceBuilder);


        SearchRequest source = searchRequest.source(searchSourceBuilder);
        SearchResponse search = esClient.search(source, GulimallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(search);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit hit : hits) {
            Account account = JSON.parseObject(hit.getSourceAsString(), Account.class);
            System.out.println(account);
        }

        Aggregations aggregations = search.getAggregations();
        Terms ageAgg1 = aggregations.get("ageAgg");
        List<? extends Terms.Bucket> buckets = ageAgg1.getBuckets();
        for (Terms.Bucket bucket : buckets) {

            System.out.println("年龄" + bucket.getKeyAsString());
            System.out.println("个数" + bucket.getDocCount());
        }
        Avg a = aggregations.get("balanceAvg");
        System.out.println("平均薪资" + a.getValue());


    }
}
