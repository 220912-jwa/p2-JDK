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
    createCardTable(bookList);
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

function createCardTable(bookList)
{
    const cardTable = document.getElementById("book shelf");
    bookList.foreach(element)
    {
        if(cardTable.children.length === 0)
        {   
            let cardRow = document.createElement("tr");
            cardTable.appendChild(cardRow);
        
        }

        if(cardRow.children.length === 4)
        {
        let cardRow = document.createElement("tr");
        cardTable.appendChild(cardRow);
        }
        else
        {   
            let cardElement = document.createElement("td");
            let card = document.createElement("div");
            card.class = "card";
            card.style = "width: 18rem";
            card.id = element.id
            cardElement.appendChild(card);
            let cardImage = document.createElement("img");
            cardImage.class = "card-img-top";
            cardImage.src = element.imagePath;
            cardImage.alt = element.title;
            card.appendChild(cardImage);
            let cardBody = document.createElement("div");
            cardBody.class = "card-body";
            card.appendChild(cardImage);
            let cardTitle =  document.createElement("h5");
            cardTitle.class = "card-title";
            cardTitle.innerHTML = element.title;
            cardBody.appendChild(cardTitle)
            let cardSubTitle1 = document.createElement("h6");
            cardSubTitle1.class = "card-subtitle";
            cardSubTitle1.innerHTML = element.author;
            cardBody.appendChild(cardSubTitle1);
            let cardSubTitle2 = document.createElement("h7");
            cardSubTitle2.class = "card-subtitle";
            cardSubTitle2.innerHTML = element.price;
            cardBody.appendChild(cardSubTitle2);
            let cardText = document.createElement("p");
            cardText.class = "card-text";
            cardText.innerHTML = element.genre;
            cardBody.appendChild(cardText);
            let cardButton1 = document.createElement("a");
            cardButton1.href = "#";
            cardButton1.class = "btn btn-primary";
            cardButton1.innerHTML = "Buy Now";
            cardBody.appendChild(cardButton1)
            let cardButton2 = document.createElement("a");
            cardButton2.href = "#";
            cardButton2.class = "btn btn-primary";
            cardButton2.innerHTML = "Buy Now";
            cardBody.appendChild(cardButton2)
            cardRow.appendChild(cardElement);
        }
    }
}

