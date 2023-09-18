package yuyu.common.workflowcore.client.rule;

import java.io.IOException;
import java.util.Properties;

import jp.co.slcs.swak.core.logger.LoggerFactory;


/**
 * ルールエンジンの設定を保持します。
 */
public class RuleConfig {

    private static Properties oProp__                      = null;

    static {
        try {
            init("Rule.properties");
        } catch (IOException e) {
        	LoggerFactory.getLogger(thisClass()).error("Rule.propertiesの読取に失敗しました。");
        }
    }
    private RuleConfig(){}

    private static Class<?> thisClass(){
        return RuleConfig.class;
    }

    public static void init (String psCurrentPath) throws IOException{

        if (oProp__ == null){
            synchronized (thisClass()){
                if (oProp__ == null){
                    try{
                        oProp__ = new Properties();

                        oProp__.load(thisClass().getClassLoader().getResourceAsStream(psCurrentPath));

                    } catch (IOException eE) {
                        eE.printStackTrace();
                        throw eE;
                    }
                }
            }
        }
    }

    public static String getProperty(String psKey){
        if(oProp__ == null){
            throw new NullPointerException("ルールプロパティファイルが未設定です。");
        }
        return oProp__.getProperty(psKey);
    }
}
