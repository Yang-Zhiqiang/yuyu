package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SknnkaisikitkKbn;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 責任開始期特約付加チェック
 */
public class CheckSekininKaisikiTk {

    private final static BizDate KRKYMD = BizDate.valueOf("20130401");

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckSekininKaisikiTk() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 責任開始期特約付加チェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();

        String mosNo = syoriCTL.getMosno();

        List<HT_MosSyouhn> mosSyouhnList = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnList.size() != 1) {

            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }

        String syouhncd = mosSyouhnList.get(0).getSyouhncd();

        Integer syouhnsdno = mosSyouhnList.get(0).getSyouhnsdno();

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(syouhncd, syouhnsdno);

        C_UmuKbn sknnKaisiKiTkUmu = syouhnZokusei.getSknnkaisikitkumu();

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_SknnkaisikitkhukaKbn sknnKaisiKiTkHukaKbn = mosKihon.getSknnkaisikitkhukakbn();

        C_UmuKbn freeinsuranceUmu = pMP.getFreeinsuranceUmu();

        BizDate mosYmd = mosKihon.getMosymd();
        BizDate krkYmd = KRKYMD;

        if (C_UmuKbn.ARI.eq(sknnKaisiKiTkUmu) && mosYmd.compareTo(krkYmd) >= 0
                && (!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisiKiTkHukaKbn))
                && C_UmuKbn.NONE.eq(freeinsuranceUmu)) {

            String msg = MessageId.EHC0220 + " "
                    + MessageUtil.getMessage(MessageId.EHC0220,
                            C_SknnkaisikitkKbn.SKNNKAISIKITK.getContent());

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, msg, pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }

        if ((!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisiKiTkHukaKbn))
                && C_UmuKbn.ARI.eq(freeinsuranceUmu)) {
            pMP.setFreeinsuranceUmu(C_UmuKbn.NONE);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 責任開始期特約付加チェック 終了");
        }
    }
}
