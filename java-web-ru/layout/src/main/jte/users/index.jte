@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1 class="text-body-emphasis">Список пользователей</h1>
        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            <ol>
            @for(var user : page.getUsers())
                <li><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></li>
            @endfor
            </ol>
        @endif
    `
)