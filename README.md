
# JSON Object Parsing

JSON Object Parsing With Volley Library


## Implementation

implementation on your project

#### Step 1 : 

```bash
    dependencies {

        implementation 'com.android.volley:volley:1.2.1'

    }
```


#### Step 2 : [ When You uses Only PHP file Link ]

```bash
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(""+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
```


## OR, 


#### Step 2 : [ When You uses Only JSON object ]

```bash
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String fname = jsonObject.getString("fname");
                    String lname = jsonObject.getString("lname");
                    String email = jsonObject.getString("email");
                    String phn = jsonObject.getString("phn");
                    String id = jsonObject.getString("id");
                    String password = jsonObject.getString("password");
                    textView.setText(""+fname+"\n"+lname+"\n"+email+"\n"+phn+"\n"+id+"\n"+password+"\n");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
```

## Author

- [Prothes Barai](https://prothes-asp.github.io/prothes/)

