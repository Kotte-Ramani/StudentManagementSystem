let loginbtn=document.getElementById("loginbtn")
let logoutbtn=document.getElementById("logoutbtn")
let mycoursesbtn=document.getElementById("mycoursesbtn")
if(localStorage.getItem("id")==null){
    logoutbtn.style.display="none"
    mycoursesbtn.style.display="none"
}
else{
    loginbtn.style.display="none"
   
}

logoutbtn.addEventListener("click",()=>{
    localStorage.clear();
    window.close()
})

let profilebtn=document.getElementById("profilebtn")
profilebtn.addEventListener("click",()=>{
    let id=localStorage.getItem("id");
    console.log("id is"+id);
    if(id==null){
        alert("please login")
    }
    else{
        window.open("./profile.html")
    }
})



