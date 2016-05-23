package co.id.jasaraharja.microservices.auth.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"co.id.jasaraharja.microservices.auth.service"})
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
	@Override
    protected List<String> getBootstrapHosts() {
        return Collections.singletonList("sync.expecc.com");
    }

    @Override
    protected String getBucketName() {
        return "mobile-db";
    }

    @Override
    protected String getBucketPassword() {
        return "welcome1";
    }
}
