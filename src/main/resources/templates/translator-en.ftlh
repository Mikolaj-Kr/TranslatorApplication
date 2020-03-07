<#include "solidElements/head.ftlh">

<main authorities="main" class="inner cover">
    <h1 class="alert-danger"> Polish signs doesn't supported yet! </h1>

    <h1 class="cover-heading"> Choose language </h1>
    <form id="translationForm" action="/translator-main?language=${siteLanguage}" method="post">
        from <select name="from">

            <option><#if from??> ${from} <#else> Choose </#if></option>
            <option> Recognize</option>
            <#list languages as language>
                <option>${language.name}</option>
            </#list>
        </select>

        to <select name="to">
            <option><#if to??> ${to} <#else> Choose </#if></option>
            <#list languages as language>
                <option>${language.name}</option>
            </#list>
        </select>
        <div class="form-control">
        <h1 class="cover-heading">Enter text to translate</h1>
        <label for="inputText" class="sr-only">text to translate</label>
        <input id="inputText" name="inputText" type="text" class="form-control" placeholder=<#if textToTranslate??> ${textToTranslate} <#else> Choose </#if> "enter text">
        <br>
            <button class="show" type="submit">Translate </button>
        </div>
    </form>

    <#if translatedText??>
    <table class="table table-light text-black-50 text-left" >
        <tr>
            <th scope="col">
                <h3>  </h3>
            </th>
            <th scope="col" >
               <h3> ${translatedText} </h3>
            </th>
        </tr>
    </table>

    </#if>
</main>
<#include "solidElements/footer.ftlh">