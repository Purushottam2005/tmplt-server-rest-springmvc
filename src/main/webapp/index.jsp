<html>
<head>

</head>
<body>
<h1>Spring REST Server</h1>
Supports:
<ul>
    <li>JSON and XML.</li>
    <li>HTTP header "Accept:".</li>
    <li>?mediaType=json/xml query parameter.</li>
</ul>

Try the service
<ul>
    <li><a href="./rest/hello?mediaType=json&name=Bruno">/rest/hello?mediaType=json&name=Bruno</a></li>
    <li><a href="./rest/hello?mediaType=xml&name=Bruno">/rest/hello?mediaType=xml&name=Bruno</a></li>
    <li><a href="./rest/ouch?mediaType=json">/rest/ouch?mediaType=json</a></li>
    <li><a href="./rest/ouch?mediaType=xml">/rest/ouch?mediaType=xml</a></li>
</ul>
</body>
</html>