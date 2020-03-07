<!doctype html>
<html <#if siteLanguage = "pl"> lang="pl" <#else> lang = "en" </#if>>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Translator</title>
  <meta name="description" content="Translator">
  <meta name="keywords" content="Translator">
  <meta name="author" content="Mikołaj Krawczak">
  <meta http-equiv="X-Ua-Compatible" content="IE=edge">

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/main-site.css">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext"
        rel="stylesheet">
</head>

<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand"><#if siteLanguage = "pl"> Twój translator <#else> Your Translator </#if></h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link <#if siteLanguage = "en">active</#if>" href="/translator-main?language=en"><#if siteLanguage = "pl"> Angielska wersja <#else> English Version </#if></a>
        <a class="nav-link <#if siteLanguage = "pl">active</#if>" href="/translator-main?language=pl"><#if siteLanguage = "pl"> Polska wersja <#else> Polish Version </#if> </a>
      </nav>
    </div>
  </header>