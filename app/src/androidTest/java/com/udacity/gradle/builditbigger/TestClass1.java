package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by ravikiranpathade on 12/4/17.
 */
@RunWith(AndroidJUnit4.class)
public class TestClass1 {
    @Test
    public void testAsyncTask(){

        String n = null;

        try{
            Log.d("String Check",String.valueOf(n));
            n = new EndPointAsyncTask(InstrumentationRegistry.getTargetContext()).execute().get();

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("String Check",String.valueOf(n));
        assertNotNull(n);
    }
}
