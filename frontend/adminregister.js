let form=document.forms[0]
console.log(form)

form.addEventListener("submit",(e)=>{
    e.preventDefault()

    let inputs =document.querySelectorAll("input")
    let firstname=inputs[0].value
    let lastname=inputs[1].value
     let email=inputs[2].value
    let number=inputs[3].value
    let address=inputs[4].value
    let password=inputs[5].value

    console.log(firstname,lastname,number,email,address,password)

    let student={
        firstName: firstname,
        lastName: lastname,
        email: email,
        password: password,
        address: address,
        mobileNumber : number
    }

    let x=fetch("http://localhost:8080/saveadmin",{
        method :"POST",
        headers :{
            "Content-Type" : "application/json"
        },
        body :JSON.stringify(student)
    })
    console.log(x);
    if(x.ok){
        let result=x.json();
        console.log(result)
    }
    // else{
    //     console.log("unable to get details")
    // }
    // window.open("./index.html")
})
let click=document.getElementById("click")

click.addEventListener("click",(e)=>{
    e.preventDefault
    click.style.cssText="width:190px;height:35px;"
})