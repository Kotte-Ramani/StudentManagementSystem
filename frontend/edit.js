let id=localStorage.getItem("id")
let firstName=localStorage.getItem("firstName")
let lastName=localStorage.getItem("lastName")
let email=localStorage.getItem("email")
let address=localStorage.getItem("address")
let mobileNumber=localStorage.getItem("mobileNumber")
let password=localStorage.getItem("password")

let firstnameInput=document.getElementById("firstNameInput")
let lastNameInput=document.getElementById("lastNameInput")
let idInput=document.getElementById("idInput")
let  emailInput=document.getElementById("emailInput")
let  addressInput=document.getElementById("addressInput")
let  passwordInput=document.getElementById("passwordInput")
let  mobileNumberInput=document.getElementById("mobileNumberInput")

firstnameInput.value=firstName;
lastNameInput.value=lastName;
idInput.value = id;
emailInput.value=email;
addressInput.value=address;
passwordInput.value=password;
mobileNumberInput.value=mobileNumber;

let updatebtn=document.getElementById("updatebtn");
updatebtn.addEventListener("click",(e)=>{
    e.preventDefault();
    let student ={
        id : idInput.value,
        firstName : firstnameInput.value,
        lastName : lastNameInput.value,
        email : emailInput.value,
        password : passwordInput.value,
        mobileNumber : mobileNumberInput.value,
        address : addressInput.value,
        image:""
    }
    console.log(student);

    let x=fetch("http://localhost:8080/updatestudent",{
        method:"PUT",
        headers :{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(student)
    })
    console.log(x);
    x.then(res=>res.json())
    .then(res=>{
        console.log(res.data)
        localStorage.setItem("id",res.data.id);
        localStorage.setItem("firstName",res.data.firstName);
        localStorage.setItem("lastName",res.data.lastName);
        localStorage.setItem("address",res.data.address);
        localStorage.setItem("email",res.data.email);
        localStorage.setItem("password",res.data.password);
        localStorage.setItem("mobileNumber",res.data.mobileNumber);
        window.open("./profile.html")
    });

})