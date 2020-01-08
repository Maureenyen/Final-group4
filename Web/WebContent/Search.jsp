<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript"
 src="http://www.schillmania.com/projects/snowstorm/snowstorm.js"></script>
<meta charset="UTF-8">
<title>GoogleSearch</title>
</head>
<body style="background-color: rgb(255, 230, 153);">
<hr size="10px" color = black align="center" width="100%">
 <P Align=top>
  <img alt="POOGLE"
   style="top: 160px; right: 380px; position: absolute;"
   src="Pooggle.gif" width=540 height=180> <img alt="GIF"
   style="top: 160px; right: 900px; position: absolute;" src="GIF.gif"
   width=70 height=137>

 </p>

 <form action='./TestProject' method='get'>


  <input type='text' name='keyword'
   placeholder='Input something about your pet....' size='45'
   style="border-width: 4px; border-style: dashed; border-color: black; padding: 5px; background: rgba(0, 0, 0, 0);" />
  <style>
input {
 text-align: left;
 padding: 5px 15px;
 border: 0 none;
 cursor: auto;
 position: absolute;
 font-weight: bold;
 top: 350px;
 right: 520px;
 -webkit-border-radius: 5px;
 border-radius: 5px;
}

.lds-hourglass {
 display: inline-block;
 position: relative;
 width: 80px;
 height: 80px;
}

.lds-hourglass:after {
 content: " ";
 display: block;
 border-radius: 50%;
 width: 0;
 height: 0;
 margin: 8px;
 box-sizing: border-box;
 border: 32px solid #cef;
 border-color: #cef transparent #cef transparent;
 animation: lds-hourglass 1.2s infinite;
}
}
</style>
  <input type='submit' value='➤'
   style="width: 100px; height: 100px; font-size: 60px; font-color: rgba(0, 0, 0, 0): onclick=" showDiv()" />
  <style>
input[type="submit"] {
 padding: 5px 15px;
 background: rgba(0, 0, 0, 0);
 border: 0 none;
 cursor: pointer;
 position: absolute;
 font-weight: bold;
 top: 310px;
 right: 420px;
 -webkit-border-radius: 5px;
 border-radius: 5px; @ keyframes lds-hourglass { 0% { transform :
 rotate( 0);
 animation-timing-function: cubic-bezier(0.55, 0.055, 0.675, 0.19);
}
50%
{
transform








:




 




rotate








(900
deg






);
animation-timing-function : cubic-bezier(0.215
,
0
.61
,
0
.355
,
1);
}
100%
{
transform








:




 




rotate








(1800
deg






);
}