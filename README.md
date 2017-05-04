Clone the repository into a directory of your choosing by using ($ indicates cmd/terminal/preffered prompt):
```
$ git clone https://github.com/Tarabadi/CI346.git
```
Following this `cd` into the directory and run
```
$ npm install
```
to download the required npm packages. After all packages have downloaded, run
```
$ npm run-script watch
```
and run the `main` method in Ci346Application.java

Once the application is up and running, connect to `localhost:8080` in your preferred web browser. To view the rota without the privalleges for editing the rota, log in with
```
User: user
Password: pass
```
Otherwise to log in to the rota with the required privalleges to edit, log in with
```
User: admin
Password: pass
```

####3rd Party Code
The 5-part blog series "React.js and Spring Data REST" by Greg Turnquist was used to familiarise myself with both react.js and Spring, and is accessable at https://github.com/spring-guides/tut-react-and-spring-data-rest