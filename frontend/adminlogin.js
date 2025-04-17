let form=document.forms[0]
console.log(form)

form.addEventListener("submit",(e)=>{
    e.preventDefault()

    let inputs=document.querySelectorAll("input")
    let email=inputs[0].value
    let password=inputs[1].value

    console.log(email,password)

    let student={
        email:email,
        password:password
    }
    
    let x=fetch("http://localhost:8080/loginadmin",{
        method :"POST",
        headers :{
            "Content-Type" : "application/json"
        },
        body :JSON.stringify(student)
    })
    x.then(res=>{console.log(res); return  res.json()} )
    .then(res=>{
        if(typeof res.data=="string"){
            alert(res.data)
        }
        else{
            console.log(res.data)
            let {id,firstName,lastName,email,password,address,mobileNumber}=res.data
            localStorage.setItem("id",id)
            localStorage.setItem("firstName",firstName)
            localStorage.setItem("lastName",lastName)
            localStorage.setItem("email",email)
            localStorage.setItem("password",password)
            localStorage.setItem("address",address)
             localStorage.setItem("mobileNumber",mobileNumber)
             localStorage.setItem("role",admin)
             window.open("./index.html")
        }
        
    })
})