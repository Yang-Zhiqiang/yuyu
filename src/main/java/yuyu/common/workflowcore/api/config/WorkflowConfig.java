package yuyu.common.workflowcore.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Workflow基盤の設定を保持するクラスです。</br>
 * 設定ファイルをアプリケーションのルートフォルダに配置してください。</br>
 */
public class WorkflowConfig  {

    private static Properties oIdentifierProp__                              = null;

    private WorkflowConfig(){}

    public static void init (String psCurrentPath){

        if (oIdentifierProp__ == null){
            synchronized (WorkflowConfig.class){
                if (oIdentifierProp__ == null){
                    try{
                        oIdentifierProp__ = new Properties();

                        oIdentifierProp__.load(WorkflowConfig.class.getClassLoader().getResourceAsStream(psCurrentPath));

                    } catch (IOException eE) {
                        eE.printStackTrace();
                    }
                }
            }
        }
    }

    private static Properties prop__ = new Properties();
    private static boolean loaded = false;

    public static void load() {

        try {
            InputStream ips = WorkflowConfig.class.getClassLoader().getResourceAsStream("iwfapi.properties");
            prop__.load(ips);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public synchronized static Properties getProperties() {
        if (loaded == false) {
            WorkflowConfig.load();
            loaded = true;
        }
        return prop__;
    }

    public static String getProperty(String psKey){

        return (String)getProperties().get(psKey);
    }
}
