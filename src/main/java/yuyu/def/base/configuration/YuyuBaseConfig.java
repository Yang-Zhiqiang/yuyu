package yuyu.def.base.configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * baseパッケージ用 システム情報格納部品です。<br />
 * yuyu-base-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuBaseConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 */
@Singleton
public class YuyuBaseConfig extends GenYuyuBaseConfig{

    private static final Logger logger = LoggerFactory.getLogger(YuyuBaseConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-base-config.xml";

    private static final YuyuBaseConfig instance = XMLResourceUtil.getXMLResource(
            ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuBaseConfig.class
            );

    static {
        logger.debug("◇ YuyuBaseConfig ({})",instance);
        logger.trace("├ tokusyuKinous (size={})", Integer.valueOf(instance.getTokusyuKinouList().size()));
        for(TokusyuKinou tk : instance.getTokusyuKinouList()){
            logger.trace("│ {}",tk);
        }
        logger.trace("├ maxShutokuKensu = {}", instance.getMaxShutokuKensu());
        logger.trace("△");
    }

    @Deprecated
    public YuyuBaseConfig() {
    }

    public static YuyuBaseConfig getInstance() {
        return instance;
    }

    private final BatchLogMessageCode batchLogMessageCode=new BatchLogMessageCode();

    @SuppressWarnings("deprecation")
    public BatchLogMessageCode getBatchLogMessageCode(){
        if(batchLogMessageCode.getBeginMessage() == null) batchLogMessageCode.setBeginMessage(getBatchLogBeginMessage());
        if(batchLogMessageCode.getEndMessage() == null) batchLogMessageCode.setEndMessage(getBatchLogEndMessage());

        return batchLogMessageCode;
    }

    private final Map<String, String> messageIconResources = new LinkedHashMap<>();

    public Map<String,String> getMessageIconResources(){
        if(messageIconResources.size() == 0){
            for(MessageIconEntry entry : getMessageIconEntryList()){
                this.messageIconResources.put(entry.getKey(),entry.getValue());
            }
        }

        return messageIconResources;
    }

}
