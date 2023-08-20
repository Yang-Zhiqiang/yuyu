package yuyu.def.suuri.configuration;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * suuriパッケージ用 システム情報格納部品です。<br />
 * yuyu-suuri-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuSuuriConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class YuyuSuuriConfig extends GenYuyuSuuriConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuSuuriConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-suuri-config.xml";

    private static final YuyuSuuriConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuSuuriConfig.class
    );

    @Deprecated
    public YuyuSuuriConfig() {
    }

    public static YuyuSuuriConfig getInstance() {
        return instance;
    }

}
