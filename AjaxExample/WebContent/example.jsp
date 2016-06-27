<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AjaxでHTTP通信を行う</title>
<link href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js" type="text/javascript" ></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js" type="text/javascript"></script>
 
<!-- スクリプト部分 -->
<script type="text/javascript">
    $( function() {
        $( '#ajax-button' ) .click(
            function() {
                $.ajax( {
                    url: 'sample_list.json',
                    dataType : 'json',
                    success: function( data ) {
                        var message = jsonParser(data);
                        $( '#sample-result' ).html( message );
                    },
                    error: function( data ) {
                        $( '#sample-result' ).html( '<font color="red">読み込みNG(ChromeではNG)</font>' );
                    }
                } );
            }
        );
    } );
  
    /*
    * JSONデータ（リスト）をパースする関数です。
    */
    function jsonParser(data) {
        var message = "";
        var dataArray = data.error;
        for(var count in dataArray){
            message = message + dataArray[count].errorCode;
            message = message + ' ： ';
            message = message + dataArray[count].errorMessage;
            message = message + '<br/>';
        }
        return message;
    }
</script>
  
</head>
  
  
<!-- HTML部分 -->
<body>
  
<h1>AjaxでJSONファイル（リスト）を読み込みパースします。</h1>
<p><input type="button" id="ajax-button" value="gooo" /> <br />
</p>
<div id="sample-result"></div>
  
  
</body>
</html>