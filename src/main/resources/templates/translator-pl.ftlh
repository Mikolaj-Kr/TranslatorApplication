<#include "solidElements/head.ftlh">

<main authorities="main" class="inner cover">
    <h1 class="alert-danger"> Translator w fazie testów. Polskie znaki nie są obsługiwane </h1>

    <h1 class="cover-heading"> Wybierz język </h1>
    <form id="translationForm" action="/translator-main?language=${siteLanguage}" method="post">
        z <select name="from">

            <option><#if from??> ${from} <#else> Wybierz </#if></option>
            <option> Recognize</option>
            <#list languages as language>
                <option>${language.name}</option>
            </#list>
        </select>

        na <select name="to">
            <option><#if to??> ${to} <#else> Wybierz </#if></option>
            <#list languages as language>
                <option>${language.name}</option>
            </#list>
        </select>
        <div class="form-control">
        <h1 class="cover-heading">Wprowadź tekst</h1>
        <label for="inputText" class="sr-only">text to translate</label>
        <input id="inputText" name="inputText" type="text" class="form-control" placeholder=<#if textToTranslate??> ${textToTranslate} <#else> Choose </#if> "Wprowadź tekst">
        <button class="alert-dark" type="submit">Translate </button>
        </div>
    </form>

    <#if translatedText??>
    <table class="table table-light text-black-50 text-left" >
        <tr>
            <th scope="col">
            </th>
            <th scope="col" >
               <h3> ${translatedText} </h3>
            </th>
        </tr>
    </table>

    </#if>
</main>
<#include "solidElements/footer.ftlh">