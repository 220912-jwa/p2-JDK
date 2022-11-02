function loadCart() {
    testFillCart();
    display();
}

function testFillCart(){

    let cart1 = [];
    cart1.push({bookId: 5});
    cart1.push({bookId: 6});
    cart1.push({bookId: 7});
    sessionStorage.setItem("cart",JSON.stringify(cart1));

}

function purchase(){
    console.log(sessionStorage.getItem('cart'));

}

function remove(removeID){

    let bookList = JSON.parse(sessionStorage.cart);

    for(let i = 0; i < bookList.length; i++){
            //bookList[i].bookId;
            if(bookList[i].bookId == removeID){
            //may be weird for duplicates
                delete ar[i];
            }
        }
    sessionStorage.clear();
    sessionStorage.setItem('cart', JSON.stringify(bookList));
    display();
}

function clear(){
    console.log(5);
    /*sessionStorage.clear();
    console.log(sessionStorage.getItem('cart'));
    display();*/
}

async function getBookById(bookId)
{

    //let bookId = document.getElementById("input 1").value;
    let requestURL = "http://localhost:8080/get/book/" + bookId;
    //console.log(bookId);
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
        //console.log(bookList);
        displayRow(bookList);

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

function display(){
    //will step through each item in cart and call getObjectByID
        //getObjectByID will call displayRow
            //displayRow will add a single row to the table corresponding with that book
    document.getElementById('booksBody').innerHTML = '';
    let bookList = JSON.parse(sessionStorage.cart);

    for(let i = 0; i < bookList.length; i++){
        //bookList[i].bookId;
        getBookById(bookList[i].bookId);
    }
    if(bookList.length < 1){
        let table = document.getElementById("books");
        let row = table.insertRow(-1);
        let cell = row.insertCell(0);
        cell.innerHTML = 'Cart is empty';
    }
}

function displayRow(book){

    //let books = sessionStorage.getItem('cart');
    //let book = books.get(0);

    let table = document.getElementById("books");

    let row = table.insertRow(-1);
    let bookid = row.insertCell(0);
    let booktitle = row.insertCell(1);
    let bookauthor = row.insertCell(2);
    let bookcost = row.insertCell(3);

        //let selector = document.getElementById(books[i]);
        //let bookList;

        //todo
    bookid.innerHTML = book.bookId;
    booktitle.innerHTML = book.title;
    bookauthor.innerHTML = book.author;
    bookcost.innerHTML = book.price.toFixed(2);

    console.log(book);
}