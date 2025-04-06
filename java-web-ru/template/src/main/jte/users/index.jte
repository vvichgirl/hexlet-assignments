@import exercise.dto.users.UsersPage
@param UsersPage page
<!doctype html>
<html lang="ru">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Пользователи</title>
    </head>
    <body>
    <div class="col-lg-8 mx-auto p-4 py-md-5">
        <main>
        <h1 class="text-body-emphasis">Список пользователей</h1>
        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            <ol>
            @for(var user : page.getUsers())
                <li><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></li>
            @endfor
            </ol>
        @endif
        </main>
    </div>
    </body>
</html>