
//access db and execute

ArrayList <NameValuePair> gameList = new ArrayList <NameValuePair>();

HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost("http://gshelf.epyon-tech.net/register.php");
HttpResponse response = httpclient.execute(httppost);


//get data
HttpEntity entity = response.getEntity();
InputStream input = entity.getContent();

//build data here
    try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,"iso-8859-1"),8);
        sbuilder = new StringBuilder();

        String line = null;

        while((line = reader.readLine()) != null){
            sbuilder.append(line + "\n");
            System.out.println(line);
        }
        input.close();
        result = sbuilder.toString();
    }
    catch(Exception e){
        Log.e("log_tag", "Error Reading Buffer: "+e.toString());
		}
		
		
//json parser
    int id;
    String name;
    try{
        JSONArray jArray = new JSONArray(result);
        JSONObject json_data = null;
        for(int i=0;i<jArray.length();i++){
            json_data = jArray.getJSONObject(i);
            fd_title = json_data.getInt("title");
            fd_vendor = json_data.getString("vendor");
            outputStream.append(title +" " + vendor + "\n");
			}
		}
	catch(Exception e){
        Log.e("log_tag", "JSON converter Error: "+e.toString());
		}
