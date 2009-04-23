<html>

<head>
</head>

<body>
<#assign seq = ["spring", "wicket", "jwebunit", "hibernate"]>
<#list seq as x>
  ${x_index + 1}. ${x}
  <#if x_has_next>
    <p/>
  </#if>
</#list>


</body>
</html>
