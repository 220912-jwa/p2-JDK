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
