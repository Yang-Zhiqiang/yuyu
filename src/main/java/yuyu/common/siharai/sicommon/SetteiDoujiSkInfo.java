package yuyu.common.siharai.sicommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.siview.SiSetUiBeanSetSkKihonKanriUiBeanParam;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;

/**
 * 保険金給付金支払 保険金給付金支払共通 同時請求情報設定
 */
public class SetteiDoujiSkInfo {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public SetteiDoujiSkInfo() {
        super();
    }

    public boolean exec(String pSkno, String pSyono,
        SiSetUiBeanSetSkKihonKanriUiBeanParam pYobidasiMotoUiBean) {

        logger.debug("▽ 同時請求情報設定 開始");
        if (BizUtil.isBlank(pSkno)) {
            logger.debug("△ 同時請求情報設定 終了");
            return false;
        }
        if (BizUtil.isBlank(pSyono)) {
            logger.debug("△ 同時請求情報設定 終了");
            return false;
        }
        if (pYobidasiMotoUiBean == null) {
            logger.debug("△ 同時請求情報設定 終了");
            return false;
        }
        List<DoujiSeikyuuInfosBySknoSyonoNeBean> list = siharaiDomManager.getDoujiSeikyuuInfosBySknoSyonoNe(pSkno,
            pSyono);
        if (list.size() == 0) {
            logger.debug("△ 同時請求情報設定 終了");
            return false;
        }
        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
        boolean result = siSetUiBean.setSkKihonKanri(pYobidasiMotoUiBean, list);
        if (!result) {
            logger.debug("△ 同時請求情報設定 終了");
            return false;
        }
        logger.debug("△ 同時請求情報設定 終了");
        return true;
    }

}