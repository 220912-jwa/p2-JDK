var cart= [];
var cardRow;
var buyNowCart = [];
var totalPrice = 0.0;
async function getAllBooks()
{
    let requestURL = "http://localhost:8080/get/book/all"
    console.log("All Books")
    let response = await fetch
    (
        requestURL,
        {
            method: "GET",
            header: {"Content-Type": "application/json"}
        }
    );
    // if fetch response = 200, navigate to landing.html
    if(response.status === 200)
    {
        let bookList = await response.json();
        console.log(bookList)
        deleteCardTable();
        bookList.forEach(element => {createCardTable(element)}); 
        cart = JSON.parse(sessionStorage.cart)
        cart.forEach(element => {configureCart(element)});
    }
    // else if fetch response = 401, Send retry alert
    else if (response.status === 404)
    {
        alert("SQL Query Error");
s
    }
    //else console log something went wrong
    else
    {
        alert("You did something odd, please try to be even next time.");
    }
   
}

async function getAllBooksByAuthor()
{

    let selector = document.getElementById("select 1");
    let author = selector.selectedOptions[0].value;
    let requestURL = "http://localhost:8080/get/book/author/" + author;
    console.log(author);
    let response = await fetch
    (
        requestURL,
        {
            method: "GET",
            header: {"Content-Type": "application/json"},
        }
    );
    // if fetch response = 200, navigate to landing.html
    if(response.status === 200)
    {
        let bookList = await response.json();
        console.log(bookList)
        deleteCardTable();
        bookList.forEach(element => {createCardTable(element)});
            

    }
    // else if fetch response = 401, Send retry alert
    else if (response.status === 404)
    {
        alert("SQL Query Error");

    }
    //else console log something went wrong
    else
    {
        alert("You did something odd, please try to be even next time.");
    }

}

async function getAllBooksByAudience()
{

    let selector = document.getElementById("select 2");
    let audience = selector.selectedOptions[0].value;
    let requestURL = "http://localhost:8080/get/book/audience/" + audience;
    console.log(audience);
    let response = await fetch
    (
        requestURL,
        {
            method: "GET",
            header: {"Content-Type": "application/json"},
        }
    );
    // if fetch response = 200, navigate to landing.html
    if(response.status === 200)
    {
        let bookList = await response.json();
        console.log(bookList)
        deleteCardTable();
        bookList.forEach(element => {createCardTable(element)});


    }
    // else if fetch response = 401, Send retry alert
    else if (response.status === 404)
    {
        alert("SQL Query Error");

    }
    //else console log something went wrong
    else
    {
        alert("You did something odd, please try to be even next time.");
    }

}

async function getAllBooksByGenre()
{

    let selector = document.getElementById("select 3");
    let genre = selector.selectedOptions[0].value;
    let requestURL = "http://localhost:8080/get/book/genre/" + genre;
    console.log(genre);
    let response = await fetch
    (
        requestURL,
        {
            method: "GET",
            header: {"Content-Type": "application/json"},
        }
    );
    // if fetch response = 200, navigate to landing.html
    if(response.status === 200)
    {
        let bookList = await response.json();
        console.log(bookList)
        deleteCardTable();
        bookList.forEach(element => {createCardTable(element)});


    }
    // else if fetch response = 401, Send retry alert
    else if (response.status === 404)
    {
        alert("SQL Query Error");

    }
    //else console log something went wrong
    else
    {
        alert("You did something odd, please try to be even next time.");
    }

}

async function getBookById()
{

    let bookId = document.getElementById("input 1").value;
    let requestURL = "http://localhost:8080/get/book/" + bookId;
    console.log(bookId);
    let response = await fetch
    (
        requestURL,
        {
            method: "GET",
            header: {"Content-Type": "application/json"},
        }
    );
    // if fetch response = 200, navigate to landing.html
    if(response.status === 200)
    {
        let bookList = await response.json();
        console.log(bookList)
        deleteCardTable();
        createCardTable(bookList);


    }
    // else if fetch response = 401, Send retry alert
    else if (response.status === 404)
    {
        alert("SQL Query Error");

    }
    //else console log something went wrong
    else
    {
        alert("You did something odd, please try to be even next time.");
    }

}

async function getAllBooksBySearchKeywords()
{

    let searchKeywords = document.getElementById("input 2").value;
    let requestURL = "http://localhost:8080/get/book/searchKeywords/" + searchKeywords;
    console.log(searchKeywords);
    let response = await fetch
    (
        requestURL,
        {
            method: "GET",
            header: {"Content-Type": "application/json"},
        }
    );
    // if fetch response = 200, navigate to landing.html
    if(response.status === 200)
    {
        let bookList = await response.json();
        console.log(bookList)
        deleteCardTable();
        bookList.forEach(element => {createCardTable(element)});


    }
    // else if fetch response = 401, Send retry alert
    else if (response.status === 404)
    {
        alert("SQL Query Error");

    }
    //else console log something went wrong
    else
    {
        alert("You did something odd, please try to be even next time.");
    }

}


async function getAllBooksByBestSeller()
{
    let requestURL = "http://localhost:8080/get/book/all/bestSeller";
    console.log("bestSeller");
    let response = await fetch
    (
        requestURL,
        {
            method: "GET",
            header: {"Content-Type": "application/json"}
        }
    );
    // if fetch response = 200, navigate to landing.html
    if(response.status === 200)
    {
        let bookList = await response.json();
        console.log(bookList)
        deleteCardTable();
        bookList.forEach(element => {createCardTable(element)});


    }
    // else if fetch response = 401, Send retry alert
    else if (response.status === 404)
    {
        alert("SQL Query Error");

    }
    //else console log something went wrong
    else
    {
        alert("You did something odd, please try to be even next time.");
    }
}

function createCardTable(element)
{
    const cardTable = document.getElementById("book shelf");
    {
        if(cardTable.childElementCount === 0)
        {   
            cardRow = document.createElement("tr");
            cardTable.appendChild(cardRow);
            
        
        }
        let cardElement = document.createElement("td");
        cardRow.append(cardElement);
        let cardDiv = document.createElement("div");
        cardDiv.class = "bg-dark"
        cardElement.append(cardDiv)
        let card = document.createElement("div");
        card.class = "card";
        card.style = "width: 18rem";
        //card.id = element.bookId
        cardDiv.append(card);
        let cardImage = document.createElement("img");
        cardImage.class = "card-img-top";
        cardImage.src = element.imagePath;
        cardImage.alt = element.title;
        cardImage.style = "width: 18rem; height: 200px"
        card.append(cardImage);
        let cardBody = document.createElement("div");
        cardBody.class = "card-body";
        card.append(cardBody);
        let cardTitle =  document.createElement("h5");
        cardTitle.class = "card-title";
        cardTitle.innerHTML = element.title;
        cardTitle.id = element.title
        cardBody.append(cardTitle)
        let cardSubTitle1 = document.createElement("h6");
        cardSubTitle1.class = "card-subtitle";
        cardSubTitle1.id = "Bram";
        cardSubTitle1.innerHTML = element.author;
        cardBody.append(cardSubTitle1);
        let cardSubTitle2 = document.createElement("h7");
        cardSubTitle2.class = "card-subtitle";
        cardSubTitle2.innerHTML = "$"+element.price;
        cardBody.append(cardSubTitle2);
        let cardText = document.createElement("p");
        cardText.class = "card-text";
        cardText.innerHTML = element.genre;
        cardText.id = element.genre
        cardBody.append(cardText);
        let cardButton1 = document.createElement("a");
        cardButton1.id = element.bookId;
        cardButton1.className = "btn btn-primary";
        cardButton1.innerHTML = "Buy Now";
        cardButton1.addEventListener("click", function(){buyNow2(EventTarget)})
        cardBody.append(cardButton1)
        let cardButton2 = document.createElement("a");
        cardButton2.href = "#";
        cardButton2.id = element.bookId;
        let id = cardButton2.id;
        cardButton2.className = "btn btn-primary float-end";
        cardButton2.name= element.bookId;
        cardButton2.innerHTML = "Add to Cart";
        cardButton2.addEventListener("click", function(){addToCart(EventTarget)})
        cardBody.append(cardButton2)
   
        

        if(cardRow.childElementCount === 4)
        {
        cardRow = document.createElement("tr");
        cardTable.append(cardRow);
        }

    }
}

function deleteCardTable()
{
    const cardTable = document.getElementById("book shelf");
    cardTable.replaceChildren();
}


function addToCart(EventTarget)
{
    let id = event.target.id
    console.log(event.target.id)
    cart.push({bookId: event.target.id})
    sessionStorage.setItem("cart",JSON.stringify(cart));
    console.log(sessionStorage.cart);
    let cartJSON = JSON.parse(sessionStorage.cart);
    console.log(cartJSON);
    let cardButton2 = event.target;
    cardButton2.className = "btn btn-success float-end"
    cardButton2.innerHTML = "Success"
    cardButton2.replaceWith(cardButton2.cloneNode(true))
    cardButton2 = document.getElementsByName(event.target.id);
    setCartCount();

    console.log(cartJSON[0].bookId)
}

function buyNow(EventTarget)
{
    console.log(event.target.id)
    buyNowCart.push({bookId: event.target.id})
    sessionStorage.setItem("buyNowCart",JSON.stringify(buyNowCart))  
    console.log(sessionStorage.buyNowCart);
    buyNowCartJSON = JSON.parse(sessionStorage.buyNowCart);
    console.log(buyNowCartJSON);
}

function doNothing()
{
    console.log("I did nothing");
}

async function getBooksById(bookId, index)
{
    let requestURL = "http://localhost:8080/get/book/" + bookId;
    console.log(bookId);
    let response = await fetch
    (
        requestURL,
        {
            method: "GET",
            header: {"Content-Type": "application/json"},
        }
    );
    // if fetch response = 200, navigate to landing.html
    if(response.status === 200)
    {
        let bookList = await response.json();
        console.log(bookList)
        createCartTable(bookList, index);


    }
    // else if fetch response = 401, Send retry alert
    else if (response.status === 404)
    {
        alert("SQL Query Error");

    }
    //else console log something went wrong
    else
    {
        alert("You did something odd, please try to be even next time.");
    }
}

function loadCart()
{
    let cartJSON = JSON.parse(sessionStorage.cart);
    cartJSON.forEach((element, index) => {getBooksById(element.bookId, index)});
    cart = JSON.parse(sessionStorage.cart);
    setCartCount();

}

function createCartTable(element, index)
{
    totalPrice += element.price
    let totalPriceDisplay = document.getElementById("total price")
    totalPriceDisplay.innerHTML = "$"+totalPrice.toFixed(2)
    const cardTable = document.getElementById("book shelf");
    {
        if(cardTable.childElementCount === 0)
        {   
            cardRow = document.createElement("tr");
            cardTable.appendChild(cardRow);
        
        }
        let cardElement = document.createElement("td");
        cardElement.id = index
        console.log(cardElement.id)
        cardRow.append(cardElement);
        let cardDiv = document.createElement("div");
        cardElement.append(cardDiv)
        let card = document.createElement("div");
        card.class = "card";
        card.style = "width: 18rem";
      //  card.id = element.bookId
        cardDiv.append(card);
        let cardImage = document.createElement("img");
        cardImage.class = "card-img-top";
        cardImage.src = element.imagePath;
        cardImage.alt = element.title;
        cardImage.style = "width: 18rem; height: 200px"
        card.append(cardImage);
        let cardBody = document.createElement("div");
        cardBody.class = "card-body";
        card.append(cardBody);
        let cardTitle =  document.createElement("h5");
        cardTitle.class = "card-title";
        cardTitle.innerHTML = element.title;
        cardBody.append(cardTitle)
        let cardSubTitle1 = document.createElement("h6");
        cardSubTitle1.class = "card-subtitle";
        cardSubTitle1.innerHTML = element.author;
        cardBody.append(cardSubTitle1);
        let cardSubTitle2 = document.createElement("h7");
        cardSubTitle2.class = "card-subtitle";
        cardSubTitle2.innerHTML = "$"+element.price;
        cardBody.append(cardSubTitle2);
        let cardText = document.createElement("p");
        cardText.class = "card-text";
        cardText.innerHTML = element.genre;
        cardBody.append(cardText);
        let cardButton1 = document.createElement("a");
        cardButton1.id = element.bookId;
        cardButton1.className = "btn btn-primary";
        cardButton1.innerHTML = "Buy Now";
        cardButton1.addEventListener("click", function(){buyNow2(EventTarget)})
        cardBody.append(cardButton1)
        let cardButton2 = document.createElement("a");
        cardButton2.href = "#";
        cardButton2.id = element.bookId;
        let id = cardButton2.id;
        cardButton2.className = "btn btn-danger float-end";
        cardButton2.name= element.bookId;
        cardButton2.innerHTML = "Remove From Cart";
        cardButton2.addEventListener("click", function(){removeFromCart(EventTarget)});
        cardBody.append(cardButton2);
   
        

        if(cardRow.childElementCount === 4)
        {
        cardRow = document.createElement("tr");
        cardTable.append(cardRow);
        }

    }
}

function removeFromCart(EventTarget)
{

    let removeButton = event.target;
    let cardBody = removeButton.parentElement;
    let card = cardBody.parentElement;
    let cardDiv = card.parentElement;
    let cardElement =  cardDiv.parentElement;
    let removedIndex = cardElement.id;
    cart.splice(removedIndex, 1)
    sessionStorage.setItem("cart",JSON.stringify(cart));
    console.log(sessionStorage.cart);
    deleteCardTable();
    totalPrice = 0.0;
    loadCart();
}

function configureCart(element)
{
    let cardButton2 = document.getElementById(element.bookId);
    cardButton2.className = "btn btn-success float-end";
    cardButton2.innerHTML = "Success";
    cardButton2.replaceWith(cardButton2.cloneNode(true));
    setCartCount();
}

function setCartCount()
{
    let cartCount = document.getElementById("pick me");
    cart = JSON.parse(sessionStorage.cart);
    cartItems = cart.length;
    cartCount.innerHTML = "Cart ("+cartItems+")";

}

async function proceedpayment()
{
                let baseUrl="http://localhost:8080";
                 const bookids=[];
                 for(var i=0;i<cart.length;i++){
                 var a=cart[i].bookId;
                 bookids.push(parseInt(a));
                 }
                 orderdetails = {
                    bookid:bookids
                }
                ordersJSON = JSON.stringify(orderdetails);

                let res = await fetch(`${baseUrl}/createorder`,
                    {
                        method: "POST",
                        headers: {"Content-Type": "application/json"},
                        body: ordersJSON
                    }
                )
                if (res.status === 200) {
                    let resJson = await res.json();
                    document.location.assign("./payment.html");
                    sessionStorage.setItem('orderid', resJson.orderid);
                    console.log("order succeeded");
                } else {
                    console.log("order failed");
                }
}
async function buyNow2(EventTarget)
{
    console.log(event.target.id)
    buyNowCart.push({bookId: event.target.id})
    sessionStorage.setItem("buyNowCart",JSON.stringify(buyNowCart))
    console.log(sessionStorage.buyNowCart);
    buyNowCartJSON = JSON.parse(sessionStorage.buyNowCart);
    console.log(buyNowCartJSON);
    let baseUrl="http://localhost:8080";
                 const bookids=[];
                 bookids.push(parseInt(buyNowCart[0].bookId));
                 orderdetails = {
                    bookid:bookids
                }
                ordersJSON = JSON.stringify(orderdetails);

                let res = await fetch(`${baseUrl}/createorder`,
                    {
                        method: "POST",
                        headers: {"Content-Type": "application/json"},
                        body: ordersJSON
                    }
                )
                if (res.status === 200) {
                    let resJson = await res.json();
                    document.location.assign("./payment.html");
                    sessionStorage.setItem('orderid', resJson.orderid);
                    console.log("order succeeded");
                } else {
                    console.log("order failed");
                }
}
