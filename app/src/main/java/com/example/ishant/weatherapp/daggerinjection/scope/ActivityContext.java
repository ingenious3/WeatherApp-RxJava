package com.example.ishant.weatherapp.daggerinjection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.CLASS)
public @interface ActivityContext {
}
