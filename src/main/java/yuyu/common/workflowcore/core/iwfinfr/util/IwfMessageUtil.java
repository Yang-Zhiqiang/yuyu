package yuyu.common.workflowcore.core.iwfinfr.util;


import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;

/**
 */
public class IwfMessageUtil {

    private static Properties messegeProperties = null;

    static {
        init("workflowcore_messages.properties");
    }

    private IwfMessageUtil() {
    }

    private static void init(String psCurrentPath) {

        if (messegeProperties == null) {
            synchronized (IwfMessageUtil.class) {
                if (messegeProperties == null) {
                    try {

                        messegeProperties = new Properties();


                        messegeProperties.load(new InputStreamReader(IwfMessageUtil.class.getClassLoader()
                            .getResourceAsStream(psCurrentPath), "UTF-8"));

                    } catch (IOException eE) {
                        eE.printStackTrace();
                    }
                }
            }
        }
    }
    public static String getMessage(IwfMessageCd code, String ... args)    {
        String message = messegeProperties.getProperty(code.toString());
        if(args == null){
            return message.replaceAll("\\{\\d\\}", "");
        }
        return MessageFormat.format(message, (Object[])args).replaceAll("\\{\\d\\}", "");
    }

}
