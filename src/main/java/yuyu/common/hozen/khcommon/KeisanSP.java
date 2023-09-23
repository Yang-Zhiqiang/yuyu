package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.common.biz.bzcommon.BzGetPrate2;
import yuyu.common.biz.bzcommon.BzGetPrateBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.dba4keisansp.KeisanSPDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RyourituKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_IkkatuKeisuu;

/**
 * 契約保全 契約保全共通 SP計算
 */
public class KeisanSP {

    private static final String MSGID_EIC0001 = MessageId.EIC0001;

    private BizCurrency hknRyou = null;

    private BizCurrency hknKingaku = null;

    private BizNumber pRate = null;

    private BizNumber psRate = null;

    private BizNumber hrbtJyousu = null;

    private String msgId = "";

    @Inject
    private KeisanSPDao keisanSPDao;

    public KeisanSP() {
        super();
    }

    public BizCurrency getP() {
        return hknRyou;
    }

    public BizCurrency getS() {
        return hknKingaku;
    }

    public BizNumber getPRate() {
        return pRate;
    }

    public BizNumber getPSRate() {
        return psRate;
    }

    public BizNumber getHrbtJyousu() {
        return hrbtJyousu;
    }

    public String getMsgid() {
        return msgId;
    }

    public C_ErrorKbn exec(
        String pSyouhnCd,
        String pRyouritusdNo,
        BizNumber pYoteiRiritu,
        C_Hrkkaisuu pHaraikomikaisuu,
        int pHhknNen,
        C_Hhknsei pHhknSei,
        C_HknkknsmnKbn pHknkknsmnKbn,
        int pHknkkn,
        int pHrkkkn,
        C_Sdpd pSdpd,
        BizCurrency pHknKingaku,
        BizCurrency pHknRyou,
        C_Tuukasyu pKeiyakuTuukasyu,
        C_Kykjyoutai pKykjyoutai,
        int pDai1hknkkn,
        C_Hrkkeiro pHrkkeiro) {

        SyouhinUtil syouhinUtil = SWAKInjector.getInstance(SyouhinUtil.class);

        boolean resultYendthnkSyouhn = syouhinUtil.getYendthnkSyouhn(pSyouhnCd);

        if (resultYendthnkSyouhn) {

            hknRyou = BizCurrency.valueOf(0);
            hknKingaku = pHknKingaku;

            return C_ErrorKbn.OK;

        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnCd);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {

            if (C_Sdpd.SD.eq(pSdpd)) {

                hknRyou = pHknKingaku;

            }
            else if (C_Sdpd.PD.eq(pSdpd)) {

                hknKingaku = pHknRyou;

            }

            return C_ErrorKbn.OK;

        }

        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType type = henkanTuuka.henkanTuukaKbnToType(pKeiyakuTuukasyu);

            hknRyou = BizCurrency.valueOf(0, type);
            hknKingaku = BizCurrency.valueOf(0, type);

            return C_ErrorKbn.OK;

        }

        BizNumber wkPrate = null;
        BizNumber wkPSrate = null;

        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.BLNK;
        C_RyourituKbn ryourituKbn = C_RyourituKbn.BLNK;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pKykjyoutai)) {

            kykjyoutai = C_Kykjyoutai.ITIJIBARAI;

        }
        else {

            kykjyoutai = C_Kykjyoutai.HRKMTYUU;

        }

        if (C_Hrkkaisuu.NEN.eq(pHaraikomikaisuu) ||
            C_Hrkkaisuu.HALFY.eq(pHaraikomikaisuu) ) {

            ryourituKbn = C_RyourituKbn.KOUHURI;

        }
        else if (C_Hrkkeiro.KOUHURI.eq(pHrkkeiro)) {

            ryourituKbn = C_RyourituKbn.KOUHURI;

        }
        else {

            ryourituKbn = C_RyourituKbn.OTHER;

        }

        BzGetPrate2 bzGetPrate = SWAKInjector.getInstance(BzGetPrate2.class);

        BzGetPrateBean prateGetResultBean = bzGetPrate.exec(
            pSyouhnCd,
            pRyouritusdNo,
            pYoteiRiritu,
            pHaraikomikaisuu,
            pHhknSei,
            pHhknNen,
            pHknkknsmnKbn,
            pHknkkn,
            pHrkkkn,
            kykjyoutai,
            pKeiyakuTuukasyu,
            pDai1hknkkn,
            ryourituKbn);

        if (C_ErrorKbn.ERROR.eq(prateGetResultBean.getErrorKbn())) {

            msgId = MSGID_EIC0001;

            return C_ErrorKbn.ERROR;

        }

        wkPrate = prateGetResultBean.getPrate();

        wkPSrate = prateGetResultBean.getPsRate();

        BizNumber wkHrbtJyousu = BizNumber.valueOf(0);

        if (C_Hrkkaisuu.ITIJI.eq(pHaraikomikaisuu)) {
            if (C_Sdpd.SD.eq(pSdpd)) {

                hknRyou = pHknKingaku.multiply(wkPrate).toValidValue();

            }
            else if (C_Sdpd.PD.eq(pSdpd)) {

                hknKingaku = pHknRyou.multiply(wkPSrate).toValidValue(RoundingMode.UP);

            }
        }
        else {
            if (C_Hrkkaisuu.TUKI.eq(pHaraikomikaisuu)) {

                wkHrbtJyousu = BizNumber.valueOf(1);

            }
            else {

                String ikttekiyoubr = "";
                Integer nen1nen2baraihyouji = 0;
                Integer keikatukisuu = Integer.valueOf(pHaraikomikaisuu.getValue());

                BM_IkkatuKeisuu ikkatuKeisuu = keisanSPDao.getIkkatuKeisuu(
                    pSyouhnCd,
                    pRyouritusdNo,
                    pYoteiRiritu,
                    ikttekiyoubr,
                    ikttekiyoubr,
                    ikttekiyoubr,
                    nen1nen2baraihyouji,
                    keikatukisuu);

                if (ikkatuKeisuu == null) {

                    msgId = MSGID_EIC0001;

                    return C_ErrorKbn.ERROR;

                }

                BizNumber iktkeisuu = ikkatuKeisuu.getIktkeisuu();

                if (C_Hrkkaisuu.NEN.eq(pHaraikomikaisuu)) {

                    wkHrbtJyousu = BizNumber.valueOf(12).subtract(iktkeisuu);

                }
                else if (C_Hrkkaisuu.HALFY.eq(pHaraikomikaisuu)) {

                    wkHrbtJyousu = BizNumber.valueOf(6).subtract(iktkeisuu);

                }
            }

            if (C_Sdpd.SD.eq(pSdpd)) {

                BizCurrency wkhknRyou = pHknKingaku.multiply(wkPrate).toValidValue();
                hknRyou = wkhknRyou.multiply(wkHrbtJyousu).toValidValue();

            }
            else if (C_Sdpd.PD.eq(pSdpd)) {
                if (C_Tuukasyu.JPY.eq(pKeiyakuTuukasyu)) {

                    BizCurrency wkhknRyou = pHknRyou.divide(wkHrbtJyousu, 0, RoundingMode.UP);
                    hknKingaku = wkhknRyou.multiply(wkPSrate, -2, RoundingMode.UP);

                }
                else {

                    BizCurrency wkhknRyou = pHknRyou.divide(wkHrbtJyousu, 0, RoundingMode.UP);
                    hknKingaku = wkhknRyou.multiply(wkPSrate, -2, RoundingMode.UP);

                }
            }
        }

        pRate = wkPrate;
        psRate = wkPSrate;
        hrbtJyousu =  wkHrbtJyousu;

        return C_ErrorKbn.OK;

    }
}