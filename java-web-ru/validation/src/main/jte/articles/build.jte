@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                @if(page.getErrors() != null)
                    <ul>
                        @for(var validator : page.getErrors().values())
                            @for(var error : validator)
                                <li>${error.getMessage()}</li>
                            @endfor
                        @endfor
                    </ul>
                @endif
                <form action="/articles" method="post">
                    <div class="mb-3">
                        <label for="title" class="form-label">Название:</label>
                        <input type="text" class="form-control" id="title" name="title" value="${page.getTitle()}">
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label">Содержание:</label>
                        <textarea class="form-control" id="content" name="content" rows="9">${page.getContent()}</textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </form>
            </main>
        </div>
    `
)