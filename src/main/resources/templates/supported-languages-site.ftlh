<#include "solidElements/head.ftlh">

<main authorities="main" class="inner cover">
    <h1 class="cover-heading">Languages:</h1>
    <table class="table table-dark">
        <thead>
        <tr>
            <th> Language</th>
            <th> nativeName</th>
        </tr>
        </thead>
        <tbody>

        <#list languages>
            <#items as language>
                <tr>
                    <th scope="row">${language.name}</th>
                    <th scope="row">${language.nativeName}</th>
                </tr>
            </#items>
        </#list>
        </tbody>
    </table>

</main>
<#include "solidElements/footer.ftlh">