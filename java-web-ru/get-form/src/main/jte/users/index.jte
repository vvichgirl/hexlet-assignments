@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
          <div class="mb-3">
            <label for="term" class="form-label">Имя пользователя:</label>
            <input type="search" class="form-control" id="term" name="term" value="${page.getTerm()}" required>
          </div>
          <button type="submit" class="btn btn-primary">Поиск</button>
        </form>
        <h1>Результаты поиска</h1>
        @if(!page.getUsers().isEmpty())
            <ol>
            @for(var user : page.getUsers())
                <li>${user.getFirstName()} ${user.getLastName()}</li>
            @endfor
            </ol>
        @endif
    `
)