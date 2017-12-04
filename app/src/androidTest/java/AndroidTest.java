import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.EndPointAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by ravikiranpathade on 12/3/17.
 */


@RunWith(AndroidJUnit4.class)
public class AndroidTest {

    @Test
    public void testAsyncTask(){

        String result = null;

        EndPointAsyncTask endPoint = new EndPointAsyncTask();

        try{

            result = endPoint.get();
        }
        catch(Exception e){}
        assertNotNull(result);

    }
}
