<#include "solidElements/head.ftlh">

  <main authorities="main" class="inner cover">
    <form id="translationForm" action="/translator-main" method="post" >
      <h1 class="cover-heading">Enter text to translate</h1>
      <label for="inputText" class="sr-only">text to translate</label>
      <input id="inputText" name="inputText" type="text" class="form-control" placeholder="enter text">
    </form>
    <#if translatedText??>Translated text: ${translatedText} </#if>

  </main>
<#include "solidElements/footer.ftlh">