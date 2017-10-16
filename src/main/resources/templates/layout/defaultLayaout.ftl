<#macro defaultLayaout title>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
        <title>${title}</title>
    </head>

    <!-- Navigation panel -->
    <div class="navbar navbar-inverse navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/projects/">Логотип</a>
            </div>
        </div>
    </div>

    <body>
        <div class="container">
            <#nested/>
        <div>
    </body>
</#macro>