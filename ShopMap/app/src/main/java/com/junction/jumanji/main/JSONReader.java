package com.junction.jumanji.main;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

/**
 * Created by Jorge on 11/26/2016.
 */
public class JSONReader {
    public String readJSONFeed(String URL) {
        StringBuilder stringBuilder = new StringBuilder();
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(URL);
//        try {
//            HttpResponse response = httpClient.execute(httpGet);
//            StatusLine statusLine = response.getStatusLine();
//            int statusCode = statusLine.getStatusCode();
//            if (statusCode == 200) {
//                HttpEntity entity = response.getEntity();
//                InputStream inputStream = entity.getContent();
//                BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(inputStream));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    stringBuilder.append(line);
//                }
//                inputStream.close();
//            } else {
//                Log.d("JSON", "Failed to download file");
//            }
//        } catch (Exception e) {
//            Log.d("readJSONFeed", e.getLocalizedMessage());
//        }
        return stringBuilder.toString();
    }

    private class ReadWeatherJSONFeedTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeed(urls[0]);
        }

        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONObject weatherObservationItems =
                        new JSONObject(jsonObject.getString("weatherObservation"));

//                Toast.makeText(getBaseContext(),
//                        weatherObservationItems.getString("NAME") +
//                                " - " + weatherObservationItems.getString("PRICE"),
//                        Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Log.d("ReadWeatherJSONFeedTask", e.getLocalizedMessage());
            }
        }
    }
}
