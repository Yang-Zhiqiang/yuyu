package yuyu.def.hozen.configuration;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * hozenパッケージ用 システム情報格納部品です。<br />
 * yuyu-hozen-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuHozenConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class YuyuHozenConfig extends GenYuyuHozenConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuHozenConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-hozen-config.xml";

    private static final YuyuHozenConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuHozenConfig.class
    );

    @Deprecated
    public YuyuHozenConfig() {
    }

    public static YuyuHozenConfig getInstance() {
        return instance;
    }

}
