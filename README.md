# shareYourThoughts
Source code for blog posting website

REST APIs 

| Title                           	| URL                                           	| Method 	| Response Code                                               	| Params / Data                                                                           	|
|---------------------------------	|-----------------------------------------------	|--------	|---------------------------------------------------------	|-----------------------------------------------------------------------------------------	|
| List all posts for visitor      	| /rest/syt/post                                    	| GET    	| 200 OK <br>404 Not found                                    	|                                                                                         	|
| Search post                     	| /rest/syt/post?searchByTitle={text}                	| GET    	| 200 OK <br>404 Not found                                     	| searchByTitle : all the available blog title would be matched against the provided text 	|
| Register new user               	| /rest/syt/user                                	| POST   	| 201 Created<br>403 Forbidden<br>400 Bad request                 	| {email, Name,password}                                                                  	|
| Sign In                         	| /rest/syt/user                                	| POST   	| 200 OK<br>401 Unauthorized<br>400 Bad request<br>404 Not found      	| {email,password}                                                                        	|
| List all blogs by given user    	| /rest/syt/user/{userid}                       	| GET    	| 200 OK<br>404 Not found                                     	|                                                                                         	|
| Sign Out                        	| /rest/syt/user/{userid}                       	| POST   	| 200 OK<br>404 Unauthorized<br>404 Not found                     	| {action: logout}                                                                        	|
| Post new post                   	| /rest/syt/user/{userid}/post                  	| POST   	| 201 Created<br>400 Bad request<br>401 Unauthorized              	| {Title,content}                                                                         	|
| View post                       	| /rest/syt/user/{userid}/post/{postid}         	| GET    	| 200 O<br>K404 Not found                                     	|                                                                                         	|
| Edit post                       	| /rest/syt/user/{userid}/post/{postid}         	| PUT    	| 200 OK<br>400 Bad Request<br>401 Unauthorized<br>404 Not found      	| {new content}                                                                           	|
| All comments for post           	| /rest/syt/user/{userid}/post/{postid}/comment 	| GET    	| 200 OK<br>404 Not found                                     	|                                                                                         	|
| Post new comment                	| /rest/syt/user/{userid}/post/{postid}/comment 	| POST   	| 201 Created<br>401 Unauthorized<br>400 Bad request<br>404 Not found 	| {commenting_user,comment_text}                                                          	|
| Get rating for post             	| /rest/syt/user/{userid}/post/{postid}/rating  	| GET    	| 200 OK<br>404 Not found                                     	|                                                                                         	|
| Post / Update rating for a post 	| /rest/syt/user/{userid}/post/{postid}/rating  	| POST   	| 201 Created<br>401 Unauthorized<br>400 Bad request<br>404 Not found 	| {rating: <1 .. 5>}                                                                      	|

Note: All the 201 Created reponse are accompanied by new created resource location. 
