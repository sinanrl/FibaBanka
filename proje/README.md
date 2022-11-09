# Proje

## API Kullanımı

#### Tüm kategorileri getir

```http
  GET http://localhost:8080/commerce/inventory/categories
```

##### Response

```javascript
[
    {
        "categoryId": 1,
        "categoryName": "Hediye"
    },
    {
        "categoryId": 2,
        "categoryName": "Cicek"
    },
    {
        "categoryId": 3,
        "categoryName": "Yenilebilir Cicek"
    }
]
```

#### Kategori id'sine göre tüm ürünleri getir

```http
  GET http://localhost:8080/commerce/inventory/products/{categoryId}
```

##### Response

```javascript
[
    {
        "productId": 1,
        "productName": "Papatya",
        "salesPrice": 15.0,
        "categoryId": 1
    },
    {
        "productId": 4,
        "productName": "Araba",
        "salesPrice": 13.0,
        "categoryId": 1
    }
]
```
#### Id'sine göre ürün getir

```http
  GET http://localhost:8080/commerce/inventory/product/{productId}
```

##### Response

```javascript
{
  "productId": 1,
  "productName": "Papatya",
  "salesPrice": 15.0,
  "categoryId": 1
}
```

#### Sepet oluştur

```http
  GET http://localhost:8080/commerce/shopping/cart/create
```

##### Response

```javascript
  cartId
```

#### Sepete ürün ekle

```http
  POST http://localhost:8080/commerce/shopping/cart/add
```

##### Request

```javascript
{
    "cartProductId" : 0,
    "cartId": 1,
    "productId": 1,
    "salesQuantity": 1,
    "salesPrice": 10,
    "lineAmount": 1
}
```

#### Sepetten ürün sil

```http
  DELETE http://localhost:8080/commerce/shopping/cart/{cartId}/remove/{productId}
```

#### Sepet durumunu değiştir

```http
  GET http://localhost:8080/commerce/shopping/checkout/{cartId}
```

#### Sepeti getir

```http
  GET http://localhost:8080/commerce/shopping/cart
```

##### query
| Parametre     | Tip      | Açıklama       |
|:--------------|:---------| :------------  |
| `cartId`      | `long`   | **required**   |

##### Request

```http
  GET http://localhost:8080/commerce/shopping/cart/find?cartId=1
```

##### Response

```javascript
{
    "cartId": 1,
    "customerName": "sinan6.718557997733301",
    "totalAmount": 20.0,
    "cartStatus": true,
    "cartProducts": [
        {
            "cartProductId": 2,
            "cartId": 1,
            "productId": 1,
            "salesQuantity": 1,
            "salesPrice": 10.0,
            "lineAmount": 1,
            "productName": "Papatya"
        },
        {
            "cartProductId": 1,
            "cartId": 1,
            "productId": 2,
            "salesQuantity": 13,
            "salesPrice": 10.0,
            "lineAmount": 1,
            "productName": "Çiçek"
        }
    ]
}
```