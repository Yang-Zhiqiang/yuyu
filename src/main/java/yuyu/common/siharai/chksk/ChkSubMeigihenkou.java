package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;

/**
 * 保険金給付金支払 請求内容チェック 名義変更チェック
 */
public class ChkSubMeigihenkou {

    @Inject
    private static Logger logger;

    public ChkSubMeigihenkou() {
        super();
    }

    public void exec(BizDate pHanteiKijyunYmd, C_SeikyuuSyubetu pSeikyuuSyubetu, C_YouhiKbn pSateiKakMeigiHnkKbn,
        JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 名義変更チェック 開始");

        if (C_SeikyuuSyubetu.SB.eq(pSeikyuuSyubetu)) {

            if (pSiKykKihon.getLastsbukthenymd() != null
                && (BizDateUtil.compareYmd(pSiKykKihon.getLastsbukthenymd(), pHanteiKijyunYmd) == BizDateUtil.COMPARE_LESSER
                || BizDateUtil.compareYmd(pSiKykKihon.getLastsbukthenymd(), pHanteiKijyunYmd) == BizDateUtil.COMPARE_EQUAL)) {
                BizDate syoriYmd = pSiKykKihon.getLastsbukthenymd()
                    .addMonths(YuyuSiharaiConfig.getInstance().getSoukiMhGoGessuu()).getRekijyou();
                if (BizDateUtil.compareYmd(syoriYmd, pHanteiKijyunYmd) == BizDateUtil.COMPARE_GREATER
                    || BizDateUtil.compareYmd(syoriYmd, pHanteiKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }

            if (C_YouhiKbn.YOU.eq(pSateiKakMeigiHnkKbn)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI);
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 名義変更チェック 終了");
                return;
            }

            if (pSiKykKihon.getLastsbukthenymd() != null
                && BizDateUtil.compareYmd(pSiKykKihon.getLastsbukthenymd(), pHanteiKijyunYmd) ==
                BizDateUtil.COMPARE_GREATER) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_SIBOUGO);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }
        else if (C_SeikyuuSyubetu.KOUSG.eq(pSeikyuuSyubetu) &&
            pSiKykKihon.getLastmeihenymd() != null) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KD);
            BizDate meigHnkYmd = pSiKykKihon.getLastmeihenymd();
            String warekiMeigiHenkoubi = DateFormatUtil.dateDOTWareki(meigHnkYmd);
            String meigiHnk = MessageUtil.getMessage(MessageId.IJW1007);
            chkKekkaBean.setMsgHikisuu1(meigiHnk + "（" + warekiMeigiHenkoubi + "）");
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 名義変更チェック 終了");
    }
}
