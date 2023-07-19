$(function() {

  $(document).keydown(function(objWindow) {

      var modifier = 0;

      if (objWindow.shiftKey)
        modifier = 1;
      if (objWindow.ctrlKey)
        modifier = 1;
      if (objWindow.altKey)
        modifier = 1;

      var keycode = objWindow.keyCode;

      if (modifier == 0) {
          switch (keycode)
          {
            case 112:
            case 114:
            case 115:
            case 122:
            case 27:
            case 118:
                objWindow.keyCode = null;
                objWindow.returnValue = false;
                return false;
                break;
          }
       }

      if (objWindow.shiftKey && objWindow.ctrlKey && objWindow.altKey) {
          switch (keycode)
          {
            case 118:
            case 122:
            case 46:
                objWindow.keyCode = null;
                objWindow.returnValue = false;
                return false;
                break;
          }
       }

       if (objWindow.shiftKey && objWindow.ctrlKey) {
           switch (keycode)
           {
             case 118:
             case 122:
             case 46:
             case 68:
             case 72:
             case 73:
             case 74:
             case 121:
                 objWindow.keyCode = null;
                 objWindow.returnValue = false;
                 return false;
                 break;
            }
         }


         if (objWindow.ctrlKey && objWindow.altKey) {
             switch (keycode)
             {
               case 118:
               case 122:
               case 74:
                   objWindow.keyCode = null;
                   objWindow.returnValue = false;
                   return false;
                   break;
             }
         }


          if (objWindow.shiftKey) {
              switch (keycode)
              {
                case 114:
                case 118:
                case 122:
                case 121:
                    objWindow.keyCode = null;
                    objWindow.returnValue = false;
                    return false;
                    break;
              }
           }

           if (objWindow.ctrlKey) {
               switch (keycode)
               {
                case 66:
                case 69:
                case 73:
                case 72:
                case 118:
                case 74:
                case 82:
                case 116:
                case 79:
                case 76:
                case 78:
                case 87:
                case 83:
                case 65:
                case 70:
                case 85:
                    objWindow.keyCode = null;
                    objWindow.returnValue = false;
                    return false;
                    break;
               }
            }

            if (objWindow.altKey) {
                switch (keycode)
                {
                 case 36:
                 case 13:
                 case 67:
                 case 73:
                 case 74:
                 case 76:
                 case 79:
                 case 80:
                 case 83:
                 case 90:
                 case 39:
                 case 37:
                 case 8:
                 case 115:
                     objWindow.keyCode = null;
                     objWindow.returnValue = false;
                     return false;
                     break;
                }
             }

            return;


  });

});

window.onhelp = function() {
  return false;
}


