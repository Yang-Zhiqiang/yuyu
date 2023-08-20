package yuyu.def.workflow.configuration;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

/**
 * workflowパッケージ用 システム情報格納部品です。<br />
 * yuyu-workflow-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = YuyuWorkflowConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 */
@Singleton
public class YuyuWorkflowConfig extends GenYuyuWorkflowConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(YuyuWorkflowConfig.class);

    private static final String CONFIG_FILE_NAME = "yuyu-workflow-config.xml";

    private static final YuyuWorkflowConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(CONFIG_FILE_NAME), YuyuWorkflowConfig.class
    );

    @Deprecated
    public YuyuWorkflowConfig() {
    }

    public static YuyuWorkflowConfig getInstance() {
        return instance;
    }

}
