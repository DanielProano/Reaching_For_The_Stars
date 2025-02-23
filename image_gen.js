/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// Example directly sending a text string:
(async function() {
    const resp = await fetch('https://api.deepai.org/api/text2img', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'api-key': '976a3014-f2d5-4e76-b879-f677ab1f9007'
        },
        body: JSON.stringify({
            text: "create an image of a woman",
        })
    });
    
    const data = await resp.json();
    console.log(data);
})()