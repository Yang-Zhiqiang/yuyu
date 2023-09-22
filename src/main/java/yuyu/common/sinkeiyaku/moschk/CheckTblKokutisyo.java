package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_KzkkijiKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 告知書TBLチェック
 */
public class CheckTblKokutisyo {

    public long ZERO = 0;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckTblKokutisyo() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 告知書テーブルチェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();

        HT_Kokutisyo kokutisyo = syoriCTL.getKokutisyo();

        if (kokutisyo == null) {
            throw new CommonBizAppException();
        }
        HT_Tokunin rokunin = syoriCTL.getTokunin();
        C_KakoymdkyytknKbn kakoymdkyytknKbn = C_KakoymdkyytknKbn.NONE;
        if (rokunin != null) {
            kakoymdkyytknKbn = rokunin.getKakoymdkyytknkbn();
        } else {
            kakoymdkyytknKbn = C_KakoymdkyytknKbn.NONE;
        }

        BizDate syoriymd = null;
        BizDate syoriymdMinus = null;
        Integer minus = null;
        BizDate kktymd = null;

        if (logger.isDebugEnabled()) {
            logger.debug("｜ ▽ 告知日チェック");
        }

        syoriymd = pMP.getSysDate();
        minus = YuyuSinkeiyakuConfig.getInstance().getKktKakoKyoyou();
        syoriymdMinus = syoriymd.addDays(-minus);

        kktymd = kokutisyo.getKktymd();

        if (logger.isDebugEnabled()) {
            logger.debug("｜ ｜ " + syoriymd.toString() + "～"
                    + syoriymdMinus.toString());
        }

        if ((syoriymdMinus.compareTo(kktymd) <= 0) && (kktymd.compareTo(syoriymd) <= 0)) {
        }
        else {
            C_TknKbn tknKbn = null;
            if (C_KakoymdkyytknKbn.NONE.eq(kakoymdkyytknKbn)) {
                tknKbn = C_TknKbn.KANOU;
            }
            else {
                tknKbn = C_TknKbn.SUMI;
            }
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageUtil.getMessage(MessageId.EBC0046, MessageId.EBC0046 + " "
                            + ICommonKoumoku.DISP_S_KKTYMD), pMP, tknKbn);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜ △ 告知日チェック終了");
        }

        C_KituenKbn kituenKbn = kokutisyo.getKituenkbn();
        long kituenhon = kokutisyo.getKituenhon();

        if (logger.isDebugEnabled()) {
            logger.debug("｜ ▽ 喫煙本数チェック");
        }

        if (C_KituenKbn.KITUEN.eq(kituenKbn)) {
            if (kituenhon <= ZERO) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageUtil.getMessage(MessageId.EBC0045, MessageId.EBC0045 + " "
                                + ICommonKoumoku.DISP_N_KITUENHON), pMP);
            }
        }
        else {
            if (kituenhon > ZERO) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageUtil.getMessage(MessageId.EBC0007, MessageId.EBC0007 + " "
                                + ICommonKoumoku.DISP_N_KITUENHON), pMP);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜ △ 喫煙本数チェック終了");
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        if (mosKihon != null) {
            List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsByKatakbns(C_KataKbn.HONNIN_TUMA, C_KataKbn.HONIN_KO, C_KataKbn.HONNIN_SAISI);
            C_KzkkijiKbn sKzkkiji = kokutisyo.getKzkkijikbn();

            if (logger.isDebugEnabled()) {
                logger.debug("｜ ▽ 家族記事区分チェック");
            }

            if (mosSyouhnLst.size() > 0) {
                if (C_KzkkijiKbn.ARI.eq(sKzkkiji) || C_KzkkijiKbn.NONE.eq(sKzkkiji)) {
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            MessageUtil.getMessage(MessageId.EBC0045, MessageId.EBC0045 + " "
                                    + ICommonKoumoku.DISP_N_KZKKIJIKBN), pMP);
                }
            }
            else {
                if (C_KzkkijiKbn.ARI.eq(sKzkkiji) || C_KzkkijiKbn.NONE.eq(sKzkkiji)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            MessageUtil.getMessage(MessageId.EBC0007, MessageId.EBC0007 + " "
                                    + ICommonKoumoku.DISP_N_KZKKIJIKBN), pMP);
                }
            }

            if (logger.isDebugEnabled()) {
                logger.debug("｜ △ 家族記事区分チェック終了");
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 告知書テーブルチェック 終了");
        }

    }

}