<%-- 
    Document   : ai_photo
    Created on : Feb 22, 2025, 9:48:50 PM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>DeepAI Image Generation</title>
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link href="css_page1.css" rel="stylesheet">
</head>
<body>
    <br> <br>
<center> <img id="generatedImage" alt="Generated Image" style="max-width: 512px; max-height: 512px;"> </center> <%-- Image will be displayed here --%>

<script>
(async function() {
    const urlParams = new URLSearchParams(window.location.search);
    const text_prompt = urlParams.get('text_prompt');
    
    
    const resp = await fetch('https://api.deepai.org/api/text2img', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'api-key': '976a3014-f2d5-4e76-b879-f677ab1f9007' // Replace with your actual API key
        },
        body: JSON.stringify({
            text: text_prompt, // Your prompt
        })
    });

    const data = await resp.json();

    if (data.output_url) { // Check if the image URL exists in the response
        const imageUrl = data.output_url;
        const generatedImage = document.getElementById('generatedImage');
        generatedImage.src = imageUrl; // Set the image source
    } else if (data.status === "complete") {
      const imageUrl = data.output_url;
        const generatedImage = document.getElementById('generatedImage');
        generatedImage.src = imageUrl;
    }
     else {
        console.error("Image generation failed:", data); // Handle errors
        alert("Image generation failed. Please try again.");
    }
})().catch(error => {
  console.error("Error fetching image:", error);
  alert("An error occurred. Please try again later.");
});

</script>
<center><a href="textDes.jsp"><button>Read more about the planet</button></a></center>
</body>
</html>
