package yuyu.def.bosyuu.configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * bosyuuパッケージ用 システム情報格納部品です。<br />
 * yuyu-bosyuu-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuBosyuuConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class YuyuBosyuuConfig extends GenYuyuBosyuuConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuBosyuuConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-bosyuu-config.xml";

    private static final YuyuBosyuuConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuBosyuuConfig.class
    );

    @Deprecated
    public YuyuBosyuuConfig() {
    }

    public static YuyuBosyuuConfig getInstance() {
        return instance;
    }

    private final Map<String, String> syanaiuserTokusyudrtenMap = new LinkedHashMap<>();

    public Map<String,String> getSyanaiuserTokusyudrtenMap(){
        if(syanaiuserTokusyudrtenMap.size() == 0){
            for(HbSyanaiuserTokusyudrtenBean entry : getHbSyanaiuserTokusyudrtenBeanList()){
                this.syanaiuserTokusyudrtenMap.put(entry.getSyanaiuserdrtencd(),entry.getOyadrtencd());
            }
        }

        return syanaiuserTokusyudrtenMap;
    }

}
