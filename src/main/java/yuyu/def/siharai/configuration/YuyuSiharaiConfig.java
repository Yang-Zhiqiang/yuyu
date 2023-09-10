package yuyu.def.siharai.configuration;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * siharaiパッケージ用 システム情報格納部品です。<br />
 * yuyu-siharai-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuSiharaiConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class YuyuSiharaiConfig extends GenYuyuSiharaiConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuSiharaiConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-siharai-config.xml";

    private static final YuyuSiharaiConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuSiharaiConfig.class
    );

    @Deprecated
    public YuyuSiharaiConfig() {
    }

    public static YuyuSiharaiConfig getInstance() {
        return instance;
    }

}
