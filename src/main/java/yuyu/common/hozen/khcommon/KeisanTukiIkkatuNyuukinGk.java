package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.GetHrkKawaseRateKijyun;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsn;
import yuyu.common.hozen.ascommon.KeisanRsgakuConstants;
import yuyu.common.hozen.khcommon.dba4keisantukiikkatunyuukingk.KeisanTukiIkkatuNyuukinGkDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 契約保全共通 月払一括入金額計算
 */
public class KeisanTukiIkkatuNyuukinGk {

    private C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn errorRiyuuKbn;

    private BizCurrency iktnyknkgk;

    private BizCurrency iktwaribikikgk;

    private BizDate ryosyuKwsRateKjYmd;

    private BizNumber ryosyuKwsRate;

    private BizCurrency wrbktkyokknp;

    private Integer wrbktkyokkntksu;

    private BizCurrency wrbktkyukkngip;

    private Integer wrbktkyukkngitksu;

    private BizCurrency countinscost;

    private List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList;

    @Inject
    private static Logger logger;

    @Inject
    private KeisanTukiIkkatuNyuukinGkDao keisanTukiIkkatuNyuukinGkDao;

    public KeisanTukiIkkatuNyuukinGk() {
        super();
    }

    public C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn getErrorRiyuuKbn() {
        return errorRiyuuKbn;
    }

    public BizCurrency getIktnyknkgk() {
        return iktnyknkgk;
    }

    public BizCurrency getIktwaribikikgk() {
        return iktwaribikikgk;
    }

    public BizDate getRyosyuKwsRateKjYmd() {
        return ryosyuKwsRateKjYmd;
    }

    public BizNumber getRyosyuKwsRate() {
        return ryosyuKwsRate;
    }

    public BizCurrency getWrbktkyokknp() {
        return wrbktkyokknp;
    }

    public Integer getWrbktkyokkntksu() {
        return wrbktkyokkntksu;
    }

    public BizCurrency getWrbktkyukkngip() {
        return wrbktkyukkngip;
    }

    public Integer getWrbktkyukkngitksu() {
        return wrbktkyukkngitksu;
    }

    public List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> getKeisanIkkatuNyuukinGkUtiwakeBeanList() {
        return keisanIkkatuNyuukinGkUtiwakeBeanList;
    }

    public C_ErrorKbn exec (KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, boolean pIktwaribikiFuyouFlg) {

        logger.debug("▽ 一括入金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        clear();

        if (!checkJutotksuhni(pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu())) {

            logger.info("一括入金額計算エラー。充当月数指定範囲外です。");

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuuKbn = C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR;

            return errorKbn;
        }

        C_YouhiKbn youhiKbn = checkIkkatuwaribiki(pIktwaribikiFuyouFlg,
            pKeisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(),
            pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst());

        if (C_YouhiKbn.YOU.eq(youhiKbn)) {

            wrbktkyokkntksu = pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu();

            if (!keisanIkkatuwaribikigop(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(),
                wrbktkyokkntksu, pKeisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(),
                pKeisanIkkatuNyuukinGkBean.getRstuukasyu(), pKeisanIkkatuNyuukinGkBean.getSyokaiprsYmd(),
                pKeisanIkkatuNyuukinGkBean.getJyutoustartYm(), pKeisanIkkatuNyuukinGkBean.getNyknaiyoukbn(),
                pKeisanIkkatuNyuukinGkBean.getNykkeiro())) {

                errorKbn = C_ErrorKbn.ERROR;

                return errorKbn;
            }

            wrbktkyokknp = countinscost;
        }
        else {

            wrbktkyukkngitksu = pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu();

            if (!syuukeip(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(), wrbktkyukkngitksu,
                pKeisanIkkatuNyuukinGkBean.getRstuukasyu(), pKeisanIkkatuNyuukinGkBean.getSyokaiprsYmd(),
                pKeisanIkkatuNyuukinGkBean.getJyutoustartYm(), pKeisanIkkatuNyuukinGkBean.getNyknaiyoukbn(),
                pKeisanIkkatuNyuukinGkBean.getNykkeiro())) {
                errorKbn = C_ErrorKbn.ERROR;

                return errorKbn;
            }

            wrbktkyukkngip = countinscost;
        }

        iktnyknkgk = countinscost;

        logger.debug("△ 一括入金額計算 終了");

        return errorKbn;
    }

    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, BizDate pRyosyuYmd,
        BizDateYM pJyuutouYm) {

        logger.debug("▽ 一括入金額計算（割引期間調整あり） 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        clear();

        if (!checkJutotksuhni(pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu())) {

            logger.info("一括入金額計算エラー。充当月数指定範囲外です。");

            errorRiyuuKbn = C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR;

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        C_YouhiKbn youhiKbn = checkIkkatuwaribiki(false, C_TkiktbrisyuruiKbn.NONE,
            pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst());

        if (C_YouhiKbn.YOU.eq(youhiKbn)) {

            setWaribikikikan(pRyosyuYmd, pJyuutouYm, pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu());

            if (wrbktkyukkngitksu != 0) {
                if (!syuukeip(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(), wrbktkyukkngitksu,
                    pKeisanIkkatuNyuukinGkBean.getRstuukasyu(), pRyosyuYmd, pJyuutouYm,
                    pKeisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), pKeisanIkkatuNyuukinGkBean.getNykkeiro())) {
                    errorKbn = C_ErrorKbn.ERROR;

                    return errorKbn;
                }

                wrbktkyokknp = countinscost;
            }

            if (wrbktkyokkntksu != 0) {

                if (!keisanIkkatuwaribikigop(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(),
                    wrbktkyokkntksu, C_TkiktbrisyuruiKbn.NONE, pKeisanIkkatuNyuukinGkBean.getRstuukasyu(),
                    pRyosyuYmd, pJyuutouYm.addMonths(wrbktkyukkngitksu),
                    pKeisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), pKeisanIkkatuNyuukinGkBean.getNykkeiro())) {

                    errorKbn = C_ErrorKbn.ERROR;

                    return errorKbn;
                }

                wrbktkyokknp = countinscost;
            }
        }
        else {

            wrbktkyukkngitksu = pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu();

            if (!syuukeip(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(), wrbktkyukkngitksu,
                pKeisanIkkatuNyuukinGkBean.getRstuukasyu(), pRyosyuYmd, pJyuutouYm,
                pKeisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), pKeisanIkkatuNyuukinGkBean.getNykkeiro())) {
                errorKbn = C_ErrorKbn.ERROR;

                return errorKbn;
            }

            wrbktkyukkngip = countinscost;
        }

        iktnyknkgk = wrbktkyokknp.add(wrbktkyukkngip);

        logger.debug("△ 一括入金額計算（割引期間調整あり） 終了");

        return errorKbn;
    }

    private void clear() {

        errorRiyuuKbn = C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK;

        iktnyknkgk = BizCurrency.valueOf(0);

        iktwaribikikgk = BizCurrency.valueOf(0);

        ryosyuKwsRateKjYmd = null;

        ryosyuKwsRate = BizNumber.ZERO;

        wrbktkyokknp = BizCurrency.valueOf(0);

        wrbktkyukkngip = BizCurrency.valueOf(0);

        wrbktkyokkntksu = 0;

        wrbktkyukkngitksu = 0;

        countinscost = BizCurrency.valueOf(0);

        keisanIkkatuNyuukinGkUtiwakeBeanList = new ArrayList<>();
    }

    private boolean checkJutotksuhni(Integer pJyuutouM) {

        if (pJyuutouM > 0 && pJyuutouM < 13) {

            return true;
        }

        return false;
    }

    private C_YouhiKbn checkIkkatuwaribiki(boolean pIktwaribikiFuyouFlg, C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn,
        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList) {

        if (pIktwaribikiFuyouFlg) {

            return C_YouhiKbn.HUYOU;
        }

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pTkiktbrisyuruiKbn) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pTkiktbrisyuruiKbn)) {

            return C_YouhiKbn.YOU;
        }

        for (int n = 0; n < pKeisanIkkatuNyuukinGkSyouhnBeanList.size(); n++) {

            KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean =
                pKeisanIkkatuNyuukinGkSyouhnBeanList.get(n);

            Long count = keisanTukiIkkatuNyuukinGkDao.getSyouhnZokuseiCountByIkkatuUmu(
                keisanIkkatuNyuukinGkSyouhnBean.getSyouhnCd(),
                keisanIkkatuNyuukinGkSyouhnBean.getSyouhnsdNo());

            if (count != 0) {

                return C_YouhiKbn.YOU;
            }
        }

        return C_YouhiKbn.HUYOU;
    }

    private void setWaribikikikan(BizDate pRyosyuYmd, BizDateYM pJyuutouYm, Integer pJyuutouM) {

        KeisanIkkatuWaribikiKikan keisanIkkatuWaribikiKikan = SWAKInjector.getInstance(KeisanIkkatuWaribikiKikan.class);
        keisanIkkatuWaribikiKikan.exec(pRyosyuYmd, pJyuutouYm, pJyuutouM);

        wrbktkyokkntksu =  keisanIkkatuWaribikiKikan.getWrbkTekikknTksu();

        wrbktkyukkngitksu = keisanIkkatuWaribikiKikan.getWrbkTekikkngaiTksu();
    }

    private boolean keisanIkkatuwaribikigop(List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList,
        Integer pSiteiKknTukisuu, C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn, C_Tuukasyu pRstuukasyu, BizDate pSyokaiprsYmd,
        BizDateYM pJyutoustartYm, C_NyknaiyouKbn pNyknaiyouKbn, C_Nykkeiro pNykkeiro) {

        boolean sumresult = true;

        countinscost = BizCurrency.valueOf(0);
        BizDate wkRyosyuKwsRateKjYmd = null;
        BizNumber wkRyosyuKwsRate = BizNumber.ZERO;

        for (int m = 0; m < pKeisanIkkatuNyuukinGkSyouhnBeanList.size(); m++) {

            KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean =
                pKeisanIkkatuNyuukinGkSyouhnBeanList.get(m);

            BizCurrency sumhokenryou = BizCurrency.valueOf(0);

            BizCurrency discountm = BizCurrency.valueOf(0);

            BizCurrency hokenryou = keisanIkkatuNyuukinGkSyouhnBean.getHokenryou();

            BizCurrency mhokenryou = hokenryou.multiply(pSiteiKknTukisuu);

            Long count = keisanTukiIkkatuNyuukinGkDao.getSyouhnZokuseiCountByIkkatuUmu(
                keisanIkkatuNyuukinGkSyouhnBean.getSyouhnCd(), keisanIkkatuNyuukinGkSyouhnBean.getSyouhnsdNo());

            if (count == 0 &&
                (C_TkiktbrisyuruiKbn.BLNK.eq(pTkiktbrisyuruiKbn) ||
                    C_TkiktbrisyuruiKbn.NONE.eq(pTkiktbrisyuruiKbn))) {

                sumhokenryou = mhokenryou;
            }
            else {

                KeisanIkkatuWaribikiP keisanIkkatuWaribikiP = SWAKInjector.getInstance(KeisanIkkatuWaribikiP.class);

                if (C_ErrorKbn.OK.eq(keisanIkkatuWaribikiP.exec(
                    keisanIkkatuNyuukinGkSyouhnBean.getSyouhnCd(),
                    keisanIkkatuNyuukinGkSyouhnBean.getRyouritusdNo(),
                    keisanIkkatuNyuukinGkSyouhnBean.getYoteiRiritu(), pSiteiKknTukisuu,
                    hokenryou))) {

                    sumhokenryou = keisanIkkatuWaribikiP.getP();

                    discountm = keisanIkkatuWaribikiP.getIktwaribikikgk();
                }
                else {

                    sumresult = false;

                    errorRiyuuKbn = C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.MASTER_DATA_SYUTOKU_ERROR;

                    return sumresult;
                }

                if (sumhokenryou.compareTo(mhokenryou) > 0) {

                    sumhokenryou = mhokenryou;

                    discountm = BizCurrency.valueOf(0);
                }
            }

            TuukaKnsnKekkaPBean tuukaKnsnKekkaPBean = keisanTuukaKnsnP(
                keisanIkkatuNyuukinGkSyouhnBean.getHokenryou(),
                pRstuukasyu, pSyokaiprsYmd, pJyutoustartYm, pSiteiKknTukisuu, pNyknaiyouKbn, pNykkeiro);

            if (tuukaKnsnKekkaPBean == null) {
                return false;
            }

            wkRyosyuKwsRateKjYmd = tuukaKnsnKekkaPBean.getRyosyuKwsRateKjYmd();
            wkRyosyuKwsRate = tuukaKnsnKekkaPBean.getRyosyuKwsRate();

            countinscost = countinscost.add(sumhokenryou);

            iktwaribikikgk = iktwaribikikgk.add(discountm);
        }

        ryosyuKwsRateKjYmd = wkRyosyuKwsRateKjYmd;
        ryosyuKwsRate = wkRyosyuKwsRate;

        if (pJyutoustartYm != null) {
            KeisanTukiIkkatuNyuukinGkUtiwakeBean keisanTukiIkkatuNyuukinGkUtiwakeBean =
                SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGkUtiwakeBean.class);
            keisanTukiIkkatuNyuukinGkUtiwakeBean.setNyknaiyouKbn(pNyknaiyouKbn);
            keisanTukiIkkatuNyuukinGkUtiwakeBean.setJyutoustartYm(pJyutoustartYm);
            keisanTukiIkkatuNyuukinGkUtiwakeBean.setJyuutoutuKisuu(pSiteiKknTukisuu);
            keisanTukiIkkatuNyuukinGkUtiwakeBean.setRskingaku(countinscost);
            keisanTukiIkkatuNyuukinGkUtiwakeBean.setRyosyuKwsRateKjYmd(wkRyosyuKwsRateKjYmd);
            keisanTukiIkkatuNyuukinGkUtiwakeBean.setRyosyuKwsRate(wkRyosyuKwsRate);
            keisanTukiIkkatuNyuukinGkUtiwakeBean.setIktnyuukinnUmu(C_UmuKbn.ARI);
            keisanTukiIkkatuNyuukinGkUtiwakeBean.setIktwaribikikgk(iktwaribikikgk);
            keisanIkkatuNyuukinGkUtiwakeBeanList.add(keisanTukiIkkatuNyuukinGkUtiwakeBean);
        }

        return sumresult;
    }

    private boolean syuukeip(List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList,
        Integer pSiteiKknTukisuu, C_Tuukasyu pRstuukasyu, BizDate pSyokaiprsYmd,
        BizDateYM pJyutoustartYm, C_NyknaiyouKbn pNyknaiyouKbn, C_Nykkeiro pNykkeiro) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType rstuuCurrencyType = henkanTuuka.henkanTuukaKbnToType(pRstuukasyu);

        countinscost = BizCurrency.valueOf(0, rstuuCurrencyType);
        BizDateYM jyutoustartYm = pJyutoustartYm;

        for (int i = 0; i < pSiteiKknTukisuu; i++) {
            BizCurrency tkbriphuri = BizCurrency.valueOf(0, rstuuCurrencyType);
            BizDate wkRyosyuKwsRateKjYmd = null;
            BizNumber wkRyosyuKwsRate = BizNumber.ZERO;

            for (int k = 0; k < pKeisanIkkatuNyuukinGkSyouhnBeanList.size(); k++) {

                TuukaKnsnKekkaPBean tuukaKnsnKekkaPBean = keisanTuukaKnsnP(
                    pKeisanIkkatuNyuukinGkSyouhnBeanList.get(k).getHokenryou(),
                    pRstuukasyu, pSyokaiprsYmd, pJyutoustartYm, pSiteiKknTukisuu, pNyknaiyouKbn, pNykkeiro);

                if (tuukaKnsnKekkaPBean == null) {
                    return false;
                }

                tkbriphuri = tkbriphuri.add(tuukaKnsnKekkaPBean.getRskingaku());
                wkRyosyuKwsRateKjYmd = tuukaKnsnKekkaPBean.getRyosyuKwsRateKjYmd();
                wkRyosyuKwsRate = tuukaKnsnKekkaPBean.getRyosyuKwsRate();
            }

            countinscost = countinscost.add(tkbriphuri);

            ryosyuKwsRateKjYmd = wkRyosyuKwsRateKjYmd;
            ryosyuKwsRate = wkRyosyuKwsRate;

            if (pJyutoustartYm != null) {
                KeisanTukiIkkatuNyuukinGkUtiwakeBean keisanTukiIkkatuNyuukinGkUtiwakeBean =
                    SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGkUtiwakeBean.class);
                keisanTukiIkkatuNyuukinGkUtiwakeBean.setNyknaiyouKbn(pNyknaiyouKbn);
                keisanTukiIkkatuNyuukinGkUtiwakeBean.setJyutoustartYm(jyutoustartYm);
                keisanTukiIkkatuNyuukinGkUtiwakeBean.setJyuutoutuKisuu(1);
                keisanTukiIkkatuNyuukinGkUtiwakeBean.setRskingaku(tkbriphuri);
                keisanTukiIkkatuNyuukinGkUtiwakeBean.setRyosyuKwsRateKjYmd(wkRyosyuKwsRateKjYmd);
                keisanTukiIkkatuNyuukinGkUtiwakeBean.setRyosyuKwsRate(wkRyosyuKwsRate);
                keisanTukiIkkatuNyuukinGkUtiwakeBean.setIktnyuukinnUmu(C_UmuKbn.NONE);
                keisanTukiIkkatuNyuukinGkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(0));
                keisanIkkatuNyuukinGkUtiwakeBeanList.add(keisanTukiIkkatuNyuukinGkUtiwakeBean);

                jyutoustartYm = jyutoustartYm.addMonths(1);
            }
        }

        return true;

    }

    private TuukaKnsnKekkaPBean keisanTuukaKnsnP(BizCurrency pHokenryou, C_Tuukasyu pRstuukasyu,
        BizDate pRyosyuYmd, BizDateYM pJyutoustartYm, Integer pJyuutoutuKisuu,
        C_NyknaiyouKbn pNyknaiyouKbn, C_Nykkeiro pNykkeiro) {

        TuukaKnsnKekkaPBean tuukaKnsnKekkaPBean = SWAKInjector.getInstance(TuukaKnsnKekkaPBean.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu hokenryouTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pHokenryou.getType());
        if (hokenryouTuukasyu.eq(pRstuukasyu)) {

            tuukaKnsnKekkaPBean.setRskingaku(pHokenryou);
            tuukaKnsnKekkaPBean.setRyosyuKwsRateKjYmd(null);
            tuukaKnsnKekkaPBean.setRyosyuKwsRate(BizNumber.ZERO);

            return tuukaKnsnKekkaPBean;
        }

        C_Nykkeiro nykkeiro = pNykkeiro;
        if (C_NyknaiyouKbn.KEIZOKUP.eq(pNyknaiyouKbn) && C_Nykkeiro.SKEI.eq(pNykkeiro)) {
            nykkeiro = C_Nykkeiro.BANK;
        }

        GetHrkKawaseRateKijyun getHrkKawaseRateKijyun = SWAKInjector.getInstance(GetHrkKawaseRateKijyun.class);

        C_ErrorKbn errorKbn = getHrkKawaseRateKijyun.exec(pNyknaiyouKbn,
            nykkeiro, pRyosyuYmd, pJyutoustartYm, 0,
            pJyuutoutuKisuu, C_Hrkkaisuu.TUKI);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            List<String> errorCd = getHrkKawaseRateKijyun.getErrorCd();

            if (errorCd.contains(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR) ||
                errorCd.contains(KeisanRsgakuConstants.ERRCD_NYKKEIRO_CHKERROR) ||
                errorCd.contains(KeisanRsgakuConstants.ERRCD_HRKKAISUU_CHKERROR) ||
                errorCd.contains(KeisanRsgakuConstants.ERRCD_NYKNAIYOUKBN_CHKERROR)) {

                errorRiyuuKbn = C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR;
            }
            else {
                throw new CommonBizAppException("一括入金額計算エラー。払込用為替レート基準日取得で想定外のエラーが発生しました。エラー理由："
                    + getHrkKawaseRateKijyun.getErrorRiyuu());
            }

            logger.info("一括入金額計算エラー。払込用為替レート基準日取得エラー：" +
                getHrkKawaseRateKijyun.getErrorRiyuu());

            return null;
        }

        KeisanPRsTuukaKnsn keisanPRsTuukaKnsn = SWAKInjector.getInstance(KeisanPRsTuukaKnsn.class);

        errorKbn = keisanPRsTuukaKnsn.exec(
            getHrkKawaseRateKijyun.getKawaseRateKijyun(), pHokenryou, hokenryouTuukasyu, pRstuukasyu);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            List<String> keisanPRsTuukaKnsnErrorCd = keisanPRsTuukaKnsn.getErrorCd();

            if (keisanPRsTuukaKnsnErrorCd.contains(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR)) {
                errorRiyuuKbn = C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR;
            }
            else if (keisanPRsTuukaKnsnErrorCd.contains(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR)) {
                errorRiyuuKbn = C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.KAWASERATE_SYUTOKU_ERROR;
            }
            else {
                throw new CommonBizAppException("一括入金額計算エラー。保険料領収通貨換算計算で想定外のエラーが発生しました。エラー理由："
                    + keisanPRsTuukaKnsn.getErrorRiyuu());
            }

            logger.info("一括入金額計算エラー。保険料領収通貨換算計算エラー：" +
                keisanPRsTuukaKnsn.getErrorRiyuu());

            return null;
        }

        tuukaKnsnKekkaPBean.setRskingaku(keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsngop());
        tuukaKnsnKekkaPBean.setRyosyuKwsRateKjYmd(keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsnkwsratekjnymd());
        tuukaKnsnKekkaPBean.setRyosyuKwsRate(keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsnkwsrate());

        return tuukaKnsnKekkaPBean;
    }
}
