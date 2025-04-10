@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h1>Все посты</h1>
                <ol>
                    @for(var post : page.getPosts())
                        <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
                    @endfor
                </ol>
            </main>
            !{var pagePrevious = page.getPageCurrent() - 1;}
            !{var pageNext = page.getPageCurrent() + 1;}
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${pagePrevious}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${pageNext}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    `
)
