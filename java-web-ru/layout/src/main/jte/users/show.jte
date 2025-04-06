@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h1 class="text-body-emphasis">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
        <p><b>ID:</b> ${page.getUser().getId()}</p>
        <p><b>Имя:</b> ${page.getUser().getFirstName()}</p>
        <p><b>Фамилия:</b> ${page.getUser().getLastName()}</p>
        <p><b>Email:</b> ${page.getUser().getEmail()}</p>
    `
)