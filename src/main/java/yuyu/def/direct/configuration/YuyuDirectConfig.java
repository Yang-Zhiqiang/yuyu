package yuyu.def.direct.configuration;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * directパッケージ用 システム情報格納部品です。<br />
 * yuyu-direct-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuDirectConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class YuyuDirectConfig extends GenYuyuDirectConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuDirectConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-direct-config.xml";

    private static final YuyuDirectConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuDirectConfig.class
    );

    @Deprecated
    public YuyuDirectConfig() {
    }

    public static YuyuDirectConfig getInstance() {
        return instance;
    }

}
