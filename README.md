# MediaOceanShoppingExample
## Ways to start

- to maven clean install
- run BillcalculatorApplication in com.mediaocean.billcalculator
- go to link http://localhost:8080/swagger-ui.html
- get product details using curl -X GET --header 'Accept: application/json' 'http://localhost:8080/product'
- post requrired items to generate bill using

curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "items": [ \ 
     { \ 
       "productId": 1001, \ 
       "quantity": 1 \ 
      \ 
     }, \ 
     { \ 
       "productId": 1002, \ 
       "quantity": 1 \ 
      \ 
     } \ 
  \ 
   ] \ 
 }' 'http://localhost:8080/bill'
 
 ## Way to access DB
 
 - http://localhost:8080/h2
 - use jdbc url = jdbc:h2:mem:testdb
 - user name =sa
 - password = {empty}
