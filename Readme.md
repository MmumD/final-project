# Онлайн магазин

## Описание
> Система для покупок в онлайн-магазинах, позволяющая пользователям регистрироваться для управления своими платежами и заказами.
> 
> **USER ROLES:** _ROLE_USER_; _ROLE_ADMIN_
> 
> **CARD TYPES:** 
> _**Visa**_ _(Starts with 4)_, 
> _**MasterCard**_ _(Starts with 5)_,
> _**Maestro**_ _(Starts with 6)_
> 
> **GENDERS(For products):**
> _MALE,
> FEMALE,
> UNISEX_
> 
> **PRODUCT TYPES:**
> _SNEAKERS,
> LOAFERS,
> BOOTS,
> SANDALS,
> SHOES_

### **Security:** _Basic auth_

### Связи
>1. **ManyToOne -> Card to User:**
    Пользователь может иметь несколько карт
>2. **ManyToOne -> Order to User:**
  Пользователь может иметь несколько заказов
>3. **ManyToMany -> Order to Products:**
   Один заказ может содержать множество различных продуктов, а один и тот же продукт может входить в состав различных заказов.

### REQUESTS
> 1. Register (Authorization: Not Required): http://localhost:8080/users/register
>
> 
>   {
>
>   "username": "User",
>
>  "password": "12345678",
>
>   "rePassword": "12345678"
>
>   }

> 2. Update password (Authorization: Required): http://localhost:8080/users/update
>
>
>{
>
>"oldPassword":"12345678",
>
>"password":"1234567890",
>
>"rePassword":"1234567890"
>
>}

> 3. Change role to Admin (Authorization: Required): http://localhost:8080/users/update/role
> 
> На тот случай если невозможно будет получить ROLE_ADMIN через DB

> 4. Get Users (Authorization: Required; Role: ROLE_ADMIN): http://localhost:8080/admin/get/all
> 

> 5. Get User by ID (Authorization: Required; Role: ROLE_ADMIN): http://localhost:8080/admin/get/by/id/?id=1
>

> 6. Adding Card (Authorization: Required): http://localhost:8080/card/register
>
>{
>
>"number":"4444 1111 2222 3333",
>
>"expirationMonth":"12",
>
>"expirationYear":"25",
>
>"cvv":"123"
>
>}

> 7. Get user cards (Authorization: Required): http://localhost:8080/card/get-card
>

> 8. Add new Product (Authorization: Required; Role: ROLE_ADMIN): http://localhost:8080/products/add
> 
> {
>
>"name":"Zara",
>
>"type":"SNEAKERS",
>
>"gender":"MALE",
>
>"price":"23000"
>
>}

> 9. Update a product by id (Authorization: Required; Role: ROLE_ADMIN): http://localhost:8080/products/update?id=1
> 
> {
> 
> "name":"Nike",
> 
> "type":"SNEAKERS",
> 
> "gender":"FEMALE",
>
> "price":"19000"
> 
> }

> 10. Get product by id (Authorization: Required): http://localhost:8080/products/get/by/id?id=1
> 

> 11. Get All products (Authorization: Required): http://localhost:8080/products/get/all
> 

> 12. Make an order (Authorization: Required): http://localhost:8080/order/add
> 
>{
>
>"productIds": [1]
> 
>}

> 13. Get all orders (Authorization: Required): http://localhost:8080/order/get