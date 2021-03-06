package com.grape.chat.chatapp.config.elasticsearch;

import com.github.vanroy.springdata.jest.JestElasticsearchTemplate;
import io.searchbox.client.JestClient;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext;

/**
 * Jest Elasticsearch configuration for Spring Data.
 *
 * @author Julien Roy
 */
@Configuration
@AutoConfigureAfter(ElasticsearchJestAutoConfiguration.class)
public class ElasticsearchJestDataAutoConfiguration {

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(JestClient client) {
        return new JestElasticsearchTemplate(client);
    }


    @Bean
    public ElasticsearchConverter elasticsearchConverter(SimpleElasticsearchMappingContext mappingContext) {
        return new MappingElasticsearchConverter(mappingContext);
    }

    @Bean
    public SimpleElasticsearchMappingContext mappingContext() {
        return new SimpleElasticsearchMappingContext();
    }

}