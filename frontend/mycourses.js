let mycoursesContainer=document.getElementById("mycoursesContainer");
let sid=localStorage.getItem("id");
console.log(sid);


(async()=>{
    try{
        let x=await fetch(`http://localhost:8080/fetchcourse/${sid}`);
       console.log(x);
        x.then(response=>{
        return response.json()
        }).then(res=>{
        console.log(res.data);
        res.data.map((obj)=>{
        mycoursesContainer.innerHTML+=`
        <div class="course">
        <div class="card-top">  <img  src="" alt="" id="pic"> </div>
        <h2>${obj.courseName}</h2>
        <p>Duration - ${obj.duration}</p>
        <p>Cost : <b>${obj.cost}</b>Rs/- </p>
        <button onclick="deleteCourse(${obj.cid} )">Delete</button>
        </div>
        `
    })
   })
    }
    catch(err){
        console.log(err);
        
    }

})()


function deleteCourse(cid){
    console.log(cid);
    console.log(sid)
    let x=fetch(`http://localhost:8080/deletecourse/${sid}/${cid}`,{
        method:"DELETE"
    });
    console.log(x);
    x.then(response=>{
        return (response.json());
    }).then(res=>{
        alert(res.msg);
        location.reload();
    })
}