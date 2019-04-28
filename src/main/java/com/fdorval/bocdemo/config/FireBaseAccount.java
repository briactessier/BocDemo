package com.fdorval.bocdemo.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fdorval.bocdemo.util.exception.TechnicalException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Configuration

public class FireBaseAccount {

	Logger LOG = LoggerFactory.getLogger(FireBaseAccount.class);

	@Bean
	public DatabaseReference firebaseDatabase() {
		DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
		return firebase;
	}

	@PostConstruct
	void init() throws TechnicalException {

		try {

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(
							GoogleCredentials.fromStream(new ClassPathResource("cle_firebase.json").getInputStream()))
					.setDatabaseUrl("https://bocdemofb.firebaseio.com").build();

			FirebaseApp.initializeApp(options);

		} catch (FileNotFoundException e) {

			TechnicalException.throwTechnicalException("key file not found", e);
		} catch (IOException e) {
			TechnicalException.throwTechnicalException("io exception", e);

		}
	}

}
