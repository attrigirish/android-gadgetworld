package attri.girish.gadgetworldapp.helper;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<URL,Void,String>
{
    OnDownloadTaskCompletedListener completedListener;

    public DownloadTask(OnDownloadTaskCompletedListener completedListener) {
        this.completedListener = completedListener;
    }

    @Override
    protected String doInBackground(URL... urls) {
        try
        {
            HttpURLConnection con = (HttpURLConnection)urls[0].openConnection();
            con.setReadTimeout(30000);
            con.setConnectTimeout(30000);

            InputStream stream = con.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);

            String output="";
            String line=buffer.readLine();
            while(line!=null)
            {
                output+=line;
                line=buffer.readLine();
            }

            return output;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s)
    {
        completedListener.onDownloadTaskCompleted(s);
    }
}
