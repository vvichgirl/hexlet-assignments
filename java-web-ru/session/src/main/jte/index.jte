@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            @if(page.getName() != null)
                <form action="${NamedRoutes.logoutPath()}" method="post">
                    <p>${String.valueOf(page.getName())}</p>
                    <input type="submit" class="btn btn-primary" value="Выйти" />
                </form>
            @else
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            @endif
        </div>
    `
)
