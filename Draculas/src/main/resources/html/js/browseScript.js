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

