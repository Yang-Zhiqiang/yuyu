package yuyu.def.biz.configuration;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * bizパッケージ用 システム情報格納部品です。<br />
 * yuyu-biz-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuBizConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class YuyuBizConfig extends GenYuyuBizConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuBizConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-biz-config.xml";

    private static final YuyuBizConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuBizConfig.class
    );

    @Deprecated
    public YuyuBizConfig() {
    }

    public static YuyuBizConfig getInstance() {
        return instance;
    }

}
