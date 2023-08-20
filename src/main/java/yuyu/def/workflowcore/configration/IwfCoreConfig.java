package yuyu.def.workflowcore.configration;

import java.io.File;

import javax.inject.Singleton;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;

import org.slf4j.Logger;

import com.google.common.base.Strings;

/**
 * パッケージ用 システム情報格納部品です。<br />
 * iwf-core-config.xml の設定が反映されます。使用する際は<br />
 * &nbsp;&nbsp; String appDefData = IwfCoreConfig.{@link #getInstance()}.getAppDefData();<br />
 * のように、{@link #getInstance()} メソッドで唯一のインスタンスを取得し、そのプロパティーを参照して下さい。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Singleton
public class IwfCoreConfig extends GenIwfCoreConfig {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(IwfCoreConfig.class);

    public static final String configFileName = "iwf-core-config.xml";

    private static final String SEPARATOR_SLASH     = "/";

    private static final IwfCoreConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream(configFileName), IwfCoreConfig.class
        );

    static {
        logger.debug("◇ IwfCoreConfig ({})", instance);
        logger.trace("├ accountKanriMode = {}", instance.getAccountKanriMode());
        logger.trace("├ lockYouhi = {}", instance.isLockYouhi());
        logger.trace("├ lockValidTime = {}", Integer.valueOf(instance.getLockValidTime()));
        logger.trace("├ ruleFileDir = {}", instance.getRuleFileDir());
        logger.trace("├ ruleLogDir = {}", instance.getRuleLogDir());
        logger.trace("├ MaxKouteiRirekiKensu = {}", instance.getMaxKouteiRirekiKensu());
        logger.trace("├ MaxImageKensu = {}", instance.getMaxImageKensu());
        logger.trace("△");
    }

    @Deprecated
    public IwfCoreConfig() {
    }

    public static IwfCoreConfig getInstance() {
        return instance;
    }

    private Integer accountKanriMode;

    private boolean lockYouhi;

    private int lockValidTime;

    private String ruleFileDir;

    private String ruleLogDir;

    private int maxKouteiRirekiKensu;

    private int maxImageKensu;

    public boolean isLockYouhi() {
        return lockYouhi;
    }

    @Deprecated
    public void setLockYouhi(boolean pLockYouhi) {
        lockYouhi = pLockYouhi;
    }

    @Override
    public Integer getAccountKanriMode() {
        return accountKanriMode;
    }

    @Override
    public void setAccountKanriMode(Integer pAccountKanriMode) {
        accountKanriMode = pAccountKanriMode;
    }

    public int getLockValidTime() {
        return lockValidTime;
    }

    @Deprecated
    public void setLockValidTime(int pLockValidTime) {
        lockValidTime = pLockValidTime;
    }

    public String getRuleFileDir() {
        return ruleFileDir;
    }

    @Deprecated
    public void setRuleFileDir(String pRuleFileDir) {
        ruleFileDir = pathFormatter(pRuleFileDir);
    }

    public String getRuleLogDir() {
        return ruleLogDir;
    }

    @Deprecated
    public void setRuleLogDir(String pRuleLogDir) {
        ruleLogDir = pathFormatter(pRuleLogDir);
    }

    public int getMaxKouteiRirekiKensu() {
        return maxKouteiRirekiKensu;
    }

    @Deprecated
    public void setMaxKouteiRirekiKensu(int pMaxKouteiRirekiKensu) {
        maxKouteiRirekiKensu = pMaxKouteiRirekiKensu;
    }

    public int getMaxImageKensu() {
        return maxImageKensu;
    }

    @Deprecated
    public void setMaxImageKensu(int pMaxImageKensu) {
        maxImageKensu = pMaxImageKensu;
    }

    private static String pathFormatter(String pPath){

        if(Strings.isNullOrEmpty(pPath)){
            return null;
        }

        String fmtPath = new String();

        if (pPath.charAt(pPath.length() - 1) != SEPARATOR_SLASH.charAt(0)) {
            fmtPath = pPath + SEPARATOR_SLASH;
        }
        File f = new File(fmtPath);
        if(!f.isAbsolute()){

            String rootPath = SWAK.getApplicationRootPath();

            if (rootPath.charAt(rootPath.length() - 1) != SEPARATOR_SLASH.charAt(0) && pPath.charAt(0) != SEPARATOR_SLASH.charAt(0)) {
                fmtPath = SEPARATOR_SLASH + fmtPath;
            }
            fmtPath = rootPath + fmtPath;
        }
        return fmtPath;
    }

}
