package yuyu.common.workflowcore.iwfcommon.pga;

import java.io.IOException;
import java.util.Properties;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;

/**
 * 設定を保持するクラスです。</br>
 * {@code WebServiceProvide#init(String)}後、{@code WebServiceProvide#getProperty(String)}メソッドで設定値を読むことができます。</br>
 * 設定ファイル（GkWSConfig.properties）をアプリケーションのルートフォルダに配置してください。</br>
 * </br>
 */
public class AutoReceiveConfig {

    private static Properties oProp__                      = null;

    private static final String sPROP_FILE                 = "AutoReceiveConfig.properties";

    static {
        try {
            init(sPROP_FILE);
        } catch (IOException e) {
            LoggerFactory.getLogger(AutoReceiveConfig.class).error(sPROP_FILE + "の読取に失敗しました。");
        }
    }
    private AutoReceiveConfig(){}

    public static void init (String psCurrentPath) throws IOException{

        if (oProp__ == null){
            synchronized (AutoReceiveConfig.class){
                if (oProp__ == null){
                    try{
                        oProp__ = new Properties();

                        oProp__.load(AutoReceiveConfig.class.getClassLoader().getResourceAsStream(psCurrentPath));

                    } catch (IOException eE) {
                        eE.printStackTrace();
                        throw eE;
                    }
                }
            }
        }
    }

    public static String getProperty(String psKey, String...sDefault){
        String sProp = oProp__.getProperty(psKey);
        if(StringUtils.isEmpty(sProp)){
            if(sDefault == null || StringUtils.isEmpty(sDefault[0])){
                return "";
            }
            return sDefault[0];
        }
        return sProp;
    }
}
