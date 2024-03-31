FCM
https://developers.google.com/oauthplayground

POST https://fcm.googleapis.com/v1/projects/[project_id]/messages:send  
headers  
Content-Type: application/json  
Authorization: Bearer [access token]  
body  
{  
   "message":{  
      "token":"[token]",  
      "notification":{  
        "title": "title",  
        "body": "body"  
      }  
   }  
}  

HPK  
GET https://oauth-login.cloud.huawei.com/oauth2/v3/token  
headers  
Content-Type: application/x-www-form-urlencoded  
body  
grant_type client_credentials  
client_id [client_id]  
client_secret [client_secret]  
  
https://push-api.cloud.huawei.com/v1/[project_id]/messages:send  
Authorization Bearer [access token]  
Content-Type: application/json  
body  
{  
    "message": {  
        "data": "{'title': 'title', 'body': 'body'}",  
        "token" : ["token"]  
    }  
}  
