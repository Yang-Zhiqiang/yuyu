package yuyu.def.qrcode.configuration;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * qrcodeパッケージ用 システム情報格納部品です。<br />
 * yuyu-qrcode-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuQrcodeConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class YuyuQrcodeConfig extends GenYuyuQrcodeConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuQrcodeConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-qrcode-config.xml";

    private static final YuyuQrcodeConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuQrcodeConfig.class
    );

    @Deprecated
    public YuyuQrcodeConfig() {
    }

    public static YuyuQrcodeConfig getInstance() {
        return instance;
    }

}
