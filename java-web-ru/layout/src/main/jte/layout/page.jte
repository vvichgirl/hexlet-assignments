@import gg.jte.Content
@param Content content
<!doctype html>
<html lang="ru">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
    <title></title>
    </head>
    <body>
    <header class="text-bg-light p-3">
        <nav>
            <ul class="nav justify-content-center">
              <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/users">Список пользователей</a>
              </li>
            </ul>
        </nav>
    </header>
    <div class="col-lg-8 mx-auto p-4 py-md-5">
        <main>
        ${content}
        </main>
    </div>
    <footer class="text-bg-light p-3">
        <div class="text-center">2025</div>
    </footer>
    </body>
</html>