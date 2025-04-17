let coursesContainer =document.getElementById("coursesContainer")
let x=fetch("http://localhost:8080/fetchallcourses");
console.log(x)
x.then(response=>{
    return (response.json());
}).then(res=>{
    console.log(res.data);
    res.data.map((obj)=>{
        coursesContainer.innerHTML+=`
        <div class="course">
            <h2><span>${obj.cid}</span>.${obj.courseName}</h2>
            <p>${obj.duration}</p>
             <p>Cost : <b>${obj.cost}</b>Rs/- </p>
             <button onclick="fetchCourses(${obj.cid} )">ADD</button>
        </div>
        `
    })
})

function fetchCourses(cid){
    let sid=localStorage.getItem("id");
    console.log(sid);
    let x=fetch(`http://localhost:8080/fetchcourse/${sid}`);
    console.log(x);
    x.then(response=>{
        return (response.json());
    })
    .then(res=>{
        console.log(res.data);
        let x=res.data.some(obj=>{
            return obj.cid===cid
        })
        console.log(x);
        if(x){
            alert("already present");
        }
        else{
            addCourse(cid);
        }
    })
}
fetchCourses();

function addCourse(cid){
    // 
    console.log(cid);
    let sid=localStorage.getItem("id");
    let x=fetch(`http://localhost:8080/addcourses/${sid}/${cid}`,{
        method:"PUT"
    })
    console.log(x);
    x.then(response=>{
        return (response.json())
    }).then(res=>{
        alert(res.msg)
    })
    
}