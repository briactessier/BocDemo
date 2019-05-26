package com.fdorval.bocdemo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdorval.bocdemo.business.BocBusiness;
import com.fdorval.bocdemo.config.FireBaseAccount;
import com.fdorval.bocdemo.dao.mock.FireBaseDaoMock;


@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
@ContextConfiguration(classes = {FireBaseAccount.class})
public class CryptoTest {
	
	Logger LOG = LoggerFactory.getLogger(CryptoTest.class);

	
	@Autowired
	InputStream firebaseKey ;
	
	String key="{" + 
			"  \"type\": \"service_account\"," + 
			"  \"project_id\": \"bocdemofb\"," + 
			"  \"private_key_id\": \"7bcb672bcf7d5de43d5e12c5387529dafbb4cc2a\"," + 
			"  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC19xBynSnwtOMG\\nKbDN9GBCGGhhaj0R0STFqgDUAxZbbNICLHMVAM9WHglMpFuVeKmguIBKWdunVvYj\\nARJNcZ0Y/Qkee+OY81xDrzh7eegqxhTWt4RUaRS6aUxagMkR3/DudDp+izP+rE5/\\nPiH/CZdreIh6zOgLtz0zanpZT7xRBctaVGhCCyJXVTxINOJdflOuMzxbiiEzCzRS\\nZ0pUCoiV0Nwyah/IWHE22Tg8hQ3VYe+YsEgm08uvfnzCnZUOzZ6QBpKXuLcdzwes\\nwhr6QxbLXhBwXMZLkLhq2UhXdQoAt8R6xy2Ic1L/RNqFZF/tBcOkoKrD9yPxBe8V\\niRep8Rr/AgMBAAECggEAPfQ4L+XN1UwpLbx9G6pUKbzYsS40S8ArJneq34SLlKY4\\n3I+YwTJs5XPFk8gz/HDARF39JBNzI4cKt8FSI3cG126zr6Lby4Q0SkE62GOZxhJ6\\nHt8N2ZWLfqqCWiAWFZVrGS0Oi25GzjOJaG5Vsdloqik4QqNIcFC7sClVLdplkin1\\nU5/EWq7RXZgkh1YIP3O3efo0ftTnCn6rhUVANzcrREx0liI6PyeSJvN2eZ1K+L/r\\nvXR/yy8a3AP748SM/NTB9RRJGJ3NL8HybMVsTJMYcwblCcwEF66Y9lA35m4u3Rtq\\niQHmNd0IQQnZyoy5yjCTtkuYb4LfEOVYFpVOZEavCQKBgQDfVoT3+CJBHaGB214j\\nEn82V17JGebpf0ubeM5vlsBvbCw/ZpJwaN/rdYxudSLHAU3kOb4HqqmEaKWlvnor\\nGEW4WMO8PIMIqcr4XfBmo6/Akvb/2M/CY4VpFUbg5wNlwMPVkHp+rq1MG4E3mNGr\\ncwM1DFO8tu1V78IxF77niWOpSQKBgQDQk5lJcqdUNpqy4FGBi86l9LkmnIbgFEjV\\n3oEeAtD/Hp7q4qcZSrfsfpKIXBBEf7sfv4Wv3JEwird0dhZt7xlvZKaWEyw1BgqE\\nVZ5bVl7HfxDZ5JLIGg7Y/hnCMw6tzyMKDKlbv+e4raU8Oc7qnjnD/zPzZtyVXyvP\\nVtT9cGWqBwKBgCTmWpnNuXsgtiqKYAdTawlDbjmzud8iVQ+e6hytv6WpLbZb8B36\\ndeSlS0qEt/ZBVOk8URVbMR7bW2MDEZRFMl++6rgTF2M7Cnn2q12J9ePPZFfpLopj\\nfwtZpJhMEteg/bovYM3FdoR4luTkrt+w5PrCyqMHZjcooeESl0wR+xFhAoGAEILe\\nq5XL8TqxXF+tlBfBMBoDXi8d7jcs3OFUT0/hw5Bk/CsdFz929929M9Y143ZJFeZP\\navCG/dS9WRbQB7vZw5uwJEk4QqpLwtYURx67OgexCc6yX+zQKBVVbK4mB1RSbcU6\\n0uyKJ3B3mCDrZF9KK13Uevw1kg2Kpks1aSqwoZkCgYA12K6EAnok8KJeu098Ute5\\nLrv8K7R5DWEf30nbS0cJJlkjBl5GgGLLhxAnli2S8jgROBXmzAjUEsN7DTBz12Sk\\nZdBhbxSxBijVNDc9Mmygcv1fV72ZHZz+P7GdSxxoOj4lSjZ/nqNOj+LfaXD6fp+Q\\niu5g8GwkhL6QjjmEkkze7w==\\n-----END PRIVATE KEY-----\\n\"," + 
			"  \"client_email\": \"firebase-adminsdk-dtuo6@bocdemofb.iam.gserviceaccount.com\"," + 
			"  \"client_id\": \"114489490721259234790\"," + 
			"  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\"," + 
			"  \"token_uri\": \"https://oauth2.googleapis.com/token\"," + 
			"  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\"," + 
			"  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-dtuo6%40bocdemofb.iam.gserviceaccount.com\"" + 
			"}"  ;
	
	@Test
	public void testKey() {
		try {
			 String encodeToString = Base64.getEncoder().encodeToString(key.getBytes());
					
			LOG.info("encodeToString "+encodeToString);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}

}
