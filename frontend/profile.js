let id=localStorage.getItem("id");
let firstName=localStorage.getItem("firstName")
let lastName=localStorage.getItem("lastName")
let email=localStorage.getItem("email")
let address=localStorage.getItem("address")
let mobileNumber=localStorage.getItem("mobileNumber")
let password=localStorage.getItem("password")

let profile=document.getElementById("profile");
profile.innerHTML=`
    <tr>
        <td>id </td>
        <td>:</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>firstName </td>
        <td>:</td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>lastName </td>
        <td>:</td>
        <td>${lastName}</td>
    </tr>
    <tr>
        <td>email </td>
        <td>:</td>
        <td>${email}</td>
    </tr>
    <tr>
        <td>address </td>
        <td>:</td>
        <td>${address}</td>
    </tr>
    <tr>
        <td>mobileNumber </td>
        <td>:</td>
        <td>${mobileNumber}</td>
    </tr>

    <tr>
        <td>password </td>
        <td>:</td>
        <td>${password}</td>
    </tr>
    
    `;

    let deleteBtn=document.getElementById("deleteBtn")
    deleteBtn.addEventListener("click",()=>{
        let x=fetch(`http://localhost:8080/deletestudent/${id}`,{
            method:"DELETE",
            headers:{"Content-Type":"application/json"}
        })
        console.log(x);
        x.then((response)=>{
            console.log(response);
            return response.json();
        })
        .then((result)=>{
            console.log(result);
            alert(result.msg)
        })
        localStorage.clear();
        window.open("./index.html")
    })

    let x=fetch(`http://localhost:8080/fetchimages/${id}`)
    console.log(x)
    x.then(response=>{
        console.log(response)
        return response.blob()
    })
    .then(res=>{
        console.log(res)
        let y=URL.createObjectURL(res);
        console.log(y);
        document.getElementById("pic").src=y;
    })

    let fileInput=document.getElementById("fileInput")
    let upload=document.getElementById("upload")

    upload.addEventListener("click",()=>{
       
        let file=fileInput.files[0]

        let formData=new FormData();
        formData.append("id",id)
        formData.append("file",file)

        let x=fetch(`http://localhost:8080/uploadimages/${id}`,{
            method:"PUT",
            body:formData
        })
        console.log(x)
        x.then((response)=>{
            console.log(response)
            return(response.json())

        }).then(res=>{
            console.log(res.msg)
            alert(res.msg);
            location.reload();
        })
    })
