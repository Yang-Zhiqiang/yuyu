package yuyu.common.siharai.renkei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.slf4j.Logger;

import yuyu.def.biz.bean.webservice.IwssnSyanaiSiharaiInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 サブシステム連携 社内Web用保険金契約内容情報取得
 */
public class SiGetSyanaiWebKeiyakuInfo {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private IwssnSyanaiSiharaiInfoOutputBean iwssnSyanaiSiharaiInfoOutputBean;

    private static final String YMD_SYOKITI = "00000000";

    public IwssnSyanaiSiharaiInfoOutputBean getIwssnSyanaiSiharaiInfoOutputBean() {
        return iwssnSyanaiSiharaiInfoOutputBean;
    }

    public C_IwssnKykSyoukaiKekkaKbn exec(String pSyono) {

        try {

            logger.debug("▽ 社内Web用保険金契約内容情報取得 開始");

            iwssnSyanaiSiharaiInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiSiharaiInfoOutputBean.class);
            iwssnSyanaiSiharaiInfoOutputBean.setIwssnSiboushryymd(YMD_SYOKITI);

            List<Object[]> taisyouDataList = siharaiDomManager.getSiRirekiSkKihonSksBySyonoTorikesiflg(pSyono, C_UmuKbn.NONE);

            if (taisyouDataList.size() == 0) {
                logger.debug("△ 社内Web用保険金契約内容情報取得 終了");
                return C_IwssnKykSyoukaiKekkaKbn.NORMAL;
            }

            Object[] siInfo = null;

            for (Object[] ob : taisyouDataList) {
                JT_SkKihon skKihon = (JT_SkKihon) ob[1];

                if (C_SeikyuuSyubetu.SB.eq(skKihon.getSeikyuusyubetu())) {

                    siInfo = ob;
                }
            }

            if (siInfo == null) {
                logger.debug("△ 社内Web用保険金契約内容情報取得 終了");
                return C_IwssnKykSyoukaiKekkaKbn.NORMAL;
            }

            JT_SiRireki siRireki = (JT_SiRireki)siInfo[0];

            if (!C_ShrKekkaKbn.HSHR.eq(siRireki.getShrkekkakbn())) {
                iwssnSyanaiSiharaiInfoOutputBean.setIwssnSiboushryymd(siRireki.getTyakkinymd().toString());
            }

            logger.debug("△ 社内Web用保険金契約内容情報取得 終了");
            return C_IwssnKykSyoukaiKekkaKbn.NORMAL;

        } catch(Exception e) {
            for (StackTraceElement st : e.getStackTrace()) {
                logger.debug(st.toString());
            }
            logger.debug("△ 社内Web用保険金契約内容情報取得 終了");
            return C_IwssnKykSyoukaiKekkaKbn.EXCEPTION;
        }
    }
}
