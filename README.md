# Build-in-authentication-using-Facebook-APIs

How to create an authentication in an Android application using Facebook API.
Technologies used for implementation are Facebook APIs and Android Studio. The code languages used in Android Studio are Java and XML (Extensible Markup Language).
First step on working for this project was to create an account on Meta for Developers, which is a platform where Facebook users can connect and create their own application using the provided products. After login on Meta for Developers with my personal Facebook account, I created an app called DSE App, named after the master’s study subject.

![image](https://github.com/user-attachments/assets/401f9b4c-9e87-43f0-b998-b9778caf1d21)


Using the documentation available on the Meta’s platform I research about their APIs and what development possibilities they can offer for my application. 
The next step was to add the necessary products to my app, which meant Facebook Login.



![image](https://github.com/user-attachments/assets/4b85985e-92b6-4a96-ab28-8c1ee1b8eda0)




On Android Studio I create a new project from an empty sheet and follow the steps from Quickstart than are found on the Facebook Login product.

![image](https://github.com/user-attachments/assets/d185ddc5-ff33-4ab4-b7dd-ac37cb915a6f)


![image](https://github.com/user-attachments/assets/2cb1481d-835a-4adb-b405-86fe1136d063)





To use Facebook for Android, developers need to download and install Facebook SDK so it can help be build the app with Facebook’s functionality or can use Maven, which is what I chose to do to save space not downloading all the archives  file that comes with Facebook SDK. 
Maven lets user to chose with archive to download, so for this case the Facebook login. In the build,grandle file from my app I use mavenCenral() which is a repository by the Maven community that has a collection of filles, so I went online and search the repository I needed.

![image](https://github.com/user-attachments/assets/363f2f6b-1f34-4b74-894b-2c9144aa7130)







Using Facebook API requires a key hash which is a 28 characters strings that Facebook uses to authentication the interactions between developers’ apps and Facebook. There are two keys: one for development and one for release. Since I do not need to release the app, I follows the steps to only get the key hash for development.

![image](https://github.com/user-attachments/assets/bb67a0f3-bede-47cc-912e-0d6fa0bfe24a)

I added Java to Window Path and download the openssl to use their cryptographic functions. It is mandatory to use a Java key, which is a data base that stores local and private key. Next step to get the generated key was to add the path where I save the openssl archive. After the key was generated ,I added it on Key Hashes section.

![image](https://github.com/user-attachments/assets/d9f10033-7337-4d28-84fb-195470621172)



I enabled Single Sign On feature to my app, that will help user to not type email and password every time they log in to the application.

![image](https://github.com/user-attachments/assets/066736dc-4a51-408d-aae1-20d745027f9c)




On the side of implementation on Android Studio, the next step were to create a login button on my application using the code provided by Facebook which wrappers the functionality of LoginManager. This makes the process of Log in and Log out possible and at the same time let developers to set permission to retrieve information.


![image](https://github.com/user-attachments/assets/175c7b03-1c6c-4972-bcd3-075e09304e8e)




Linked the Login button to the app.
![image](https://github.com/user-attachments/assets/78ea7150-75ac-4b35-9fba-305d236e883b)

The permission added to this login button are for user birthday, user photos, gender. It is important to mention that what is added as a permission won’t show if they are not set to retrieve from the Facebook API Graph.
![image](https://github.com/user-attachments/assets/96c7d3c1-2975-4da3-8516-fa8463f60e96)











In the Figure 12 is shown how the Graph API Tool witch which the developers grant permission to request the information they want from the user, as in seen below there are permission for : birthday, location, photos, gender and id.

![image](https://github.com/user-attachments/assets/67f6704c-48bc-4975-991e-1ac9ba5f9310)
![image](https://github.com/user-attachments/assets/003ffe46-f7f8-4212-b687-98fe3fefcca1)












To check if a user log out,  I used an Access Token Tracker. Whenever the access token changes, this method is called automatically. What I check in this method is if the access token has change because if the answers is no that means the user has log out.

![image](https://github.com/user-attachments/assets/b860b206-fed1-4289-946a-9fb4a3cc979c)




To view if the application run correctly and to see the results, I use the Android Studio feature that let to create an emulator that simulation how the application look on the chosen device. For my emulator I chose a mobile phone, Nexus 3 LX.
When the application is run for the first time, a login to the Facebook account is required.

![image](https://github.com/user-attachments/assets/867766e6-a04a-4fed-a809-e4cee2b0c7a3)


![image](https://github.com/user-attachments/assets/290ad646-a7c1-417c-87f0-3bea4262028d)























This is how the final design of the app will look when it ask the user to log in the application using their Facebook account. The representation in the Figure  it is just a mockup for presentation and beside is the actual stage.

![image](https://github.com/user-attachments/assets/28dad550-1cb2-4cc1-a166-03a20fc387e3)

![image](https://github.com/user-attachments/assets/754477cc-e763-4d3c-9692-f662c12dd45f)



Bibliography

[1] 	Frank Müller, Frank Thiesing, "Social networking APIs for companies "[google scholar] Available: https://ieeexplore.ieee.org/abstract/document/6085929/
[2] 	 Patrice-Anne Rutledge, "The Truth about Profiting from Social Networking" [google scholar]. Available: https://books.google.ro/books?id=eGnpsd6Aq7kC&dq=social+networking&source=gbs_navlinks_s 
[3] 	Alan Mislove, Massimiliano Marcon, " Measurement and analysis of online social networks".[ google scholar] Available: https://dl.acm.org/doi/abs/10.1145/1298306.1298311
[4] 	Meta for Developers - Documentation, Graph API [Online] https://developers.facebook.com/docs/
[5] 	"Google APIs," [Online]. Available: https://en.wikipedia.org/wiki/Google_APIs
[6] 	Brenda Jin, Saurabh Sahni, Amir Shevat, " Designing Web APIs: Building APIs That Developers Love," [google scholar] Available:https://books.google.ro/books?id=Dg1rDwAAQBAJ&dq=facebook+apis+vs
+google+apis&lr=&source=gbs_navlinks_s
[7] 	" Benefits of APIs," [Online]. Available: https://digital.gov/2013/03/12/benefits-of-apis/




























