async function getAllBooks()
{
    let requestURL = "http://localhost:8080/get/book/all"
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

    let slector = document.getElementById("select 1");
    let author = slector.selectedOptions[0];
    let requestURL = "http://localhost:8080/get/book/all/author"
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

