package yuyu.common.hozen.ascommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 案内収納共通 マイナス売上日設定
 */
public class SetMinusUriagebi {

    @Inject
    private static Logger logger;

    private BizDate uriageSeikyuuYmd;

    private BizDate denpyouYmd;

    public SetMinusUriagebi() {
        super();
    }

    public void exec(BizDate pSyoriYmd){

        logger.debug("▽ マイナス売上日設定 開始");

        uriageSeikyuuYmd = null;

        denpyouYmd = null;

        uriageSeikyuuYmd = pSyoriYmd.addBusinessDays(2);

        denpyouYmd = pSyoriYmd.addBusinessDays(2);

        logger.debug("△ マイナス売上日設定 終了");
    }

    public BizDate getUriageSeikyuuYmd() {

        return uriageSeikyuuYmd;
    }

    public BizDate getDenpyouYmd() {

        return denpyouYmd;
    }
}
