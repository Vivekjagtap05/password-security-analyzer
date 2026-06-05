function analyzePassword() {

    const password =
        document.getElementById("password").value;

    fetch("/api/password/analyze",{

        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify({
            password:password
        })
    })

    .then(res=>res.json())

    .then(data=>{

        let strengthClass="";

        if(data.strength==="Weak")
            strengthClass="strength-weak";

        if(data.strength==="Medium")
            strengthClass="strength-medium";

        if(data.strength==="Strong")
            strengthClass="strength-strong";

        let html=`

        <h2>Analysis Result</h2>

        <br>

        <p><b>Score:</b> ${data.score}/100</p>

        <p>
        <b>Strength:</b>
        <span class="${strengthClass}">
        ${data.strength}
        </span>
        </p>

        <p>
        <b>Entropy:</b>
        ${data.entropy.toFixed(2)}
        </p>

        <p>
        <b>Message:</b>
        ${data.message}
        </p>

        <br>

        <h3>Suggestions</h3>

        <ul>
        `;

        if(data.suggestions){

            data.suggestions.forEach(item=>{
                html += `<li>${item}</li>`;
            });
        }

        html += "</ul>";

        document.getElementById("result")
                .innerHTML = html;
    });
}

function generatePassword(){

    fetch("/api/password/generate")

    .then(res=>res.text())

    .then(password=>{

        document.getElementById("password")
                .value=password;
    });
}