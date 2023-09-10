package yuyu.def.sinkeiyaku.configuration;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * sinkeiyakuパッケージ用 システム情報格納部品です。<br />
 * yuyu-sinkeiyaku-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuSinkeiyakuConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class YuyuSinkeiyakuConfig extends GenYuyuSinkeiyakuConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuSinkeiyakuConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-sinkeiyaku-config.xml";

    private static final YuyuSinkeiyakuConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuSinkeiyakuConfig.class
    );

    @Deprecated
    public YuyuSinkeiyakuConfig() {
    }

    public static YuyuSinkeiyakuConfig getInstance() {
        return instance;
    }

}
