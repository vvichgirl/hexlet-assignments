@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
    content = @`
        <main>
            <div class="mx-auto p-4 py-md-5">
                @if(page != null)
                    <p>${page.getError()}</p>
                @endif
                <form action="${NamedRoutes.loginPath()}" method="post">
                    <div class="mb-3">
                        <label class="form-label">
                        Имя
                        <input type="text" class="form-control" name="name" />
                        </label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">
                        Пароль
                        <input type="text" class="form-control" name="password" />
                        </label>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Войти" />
                </form>
            </div>
        </main>
    `
)
