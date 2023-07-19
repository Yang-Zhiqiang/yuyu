$(function() {

  $(document).keydown(function(objWindow) {

    if (objWindow.ctrlKey && (objWindow.keyCode == 80)) {
         window.alert("該当のキーコマンドは禁止されています");
         objWindow.keyCode = null;
           return false;
    }

    if (objWindow.ctrlKey) {
            switch (objWindow.keyCode)
            {
              case 67:
              case 86:
              case 88:
                objWindow.keyCode = null;
                objWindow.returnValue = false;
                return false;
                break;
            }
    }

    return;

  });

});

