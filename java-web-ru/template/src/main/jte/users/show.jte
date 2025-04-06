@import exercise.dto.users.UserPage
@param UserPage page
<!doctype html>
<html lang="ru">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</title>
    </head>
    <body>
    <div class="col-lg-8 mx-auto p-4 py-md-5">
        <main>
        <h1 class="text-body-emphasis">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
        <p><b>ID:</b> ${page.getUser().getId()}</p>
        <p><b>Имя:</b> ${page.getUser().getFirstName()}</p>
        <p><b>Фамилия:</b> ${page.getUser().getLastName()}</p>
        <p><b>Email:</b> ${page.getUser().getEmail()}</p>
        </main>
    </div>
    </body>
</html>