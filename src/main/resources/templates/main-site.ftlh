<#include "solidElements/head.ftlh">

<main authorities="main" class="inner cover">
    <h1 class="alert-danger"> Polish signs doesn't supported yet! </h1>

    <h1 class="cover-heading"> Choose language </h1>

    <form id="translationForm" action="/translator-main" method="post">
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
        <h1 class="cover-heading">Enter text to translate</h1>
        <label for="inputText" class="sr-only">text to translate</label>
        <input id="inputText" name="inputText" type="text" class="form-control" placeholder=<#if textToTranslate??> ${textToTranslate} <#else> Choose </#if> "enter text">
        <button class="alert-dark" type="submit">Translate </button>
    </form>
    <#if translatedText??>
<#--    <table class="table table-light text-black-50">-->
<#--        <tr>-->
<#--            <th>-->
    <h3> Translated text: ${translatedText}
<#--            </th>-->
<#--            <th>-->

<#--            </th>-->
<#--        </tr>-->
<#--    </table>-->
    </#if>
</main>
<#include "solidElements/footer.ftlh">