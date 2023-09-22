package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約  申込内容チェック 指定契約日チェック
 */
public class CheckShiteiKeiyakubi {

    @Inject
    private static Logger log;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckShiteiKeiyakubi() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (log.isDebugEnabled()) {
            log.debug("▽ 指定契約日チェック 開始");
        }

        HT_SyoriCTL syoriControl = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriControl.getMosKihon();
        BizDate stKykYmd = mosKihon.getSkykymd();
        C_FstphrkkeiroKbn fstPHrkKeiro = mosKihon.getFstphrkkeirokbn();
        C_Hrkkeiro hrkKeiro = mosKihon.getHrkkeiro();
        C_SknnkaisikitkhukaKbn snKskiTkHkKbn = mosKihon.getSknnkaisikitkhukakbn();

        if (stKykYmd != null) {
            boolean dairitenSMBC = false;

            if (!C_SkeijimuKbn.SHOP.eq(syoriControl.getSkeijimukbn())) {
                dairitenSMBC = true;
            }

            if (!(((C_FstphrkkeiroKbn.HURIKOMI.eq(fstPHrkKeiro) ||
                    C_FstphrkkeiroKbn.CONVENIENCE.eq(fstPHrkKeiro)) &&
                    C_Hrkkeiro.KOUHURI.eq(hrkKeiro)) ||
                    (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro) &&
                            C_Hrkkeiro.CREDIT.eq(hrkKeiro)) ||
                            (dairitenSMBC && C_FstphrkkeiroKbn.HURIKOMI.eq(fstPHrkKeiro) &&
                                    C_Hrkkeiro.CREDIT.eq(hrkKeiro)) ||
                                    (C_SknnkaisikitkhukaKbn.HUKA.eq(snKskiTkHkKbn) &&
                                            C_FstphrkkeiroKbn.KOUHURI.eq(fstPHrkKeiro) &&
                                            C_Hrkkeiro.KOUHURI.eq(hrkKeiro)))) {

                if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MessageId.EHC0108 + " " +
                            MessageUtil.getMessage(MessageId.EHC0108), pMP);
                } else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MessageId.EHC0210 + " " +
                            MessageUtil.getMessage(MessageId.EHC0210), pMP);
                }
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("△ 指定契約日チェック 終了");
        }
    }

}
