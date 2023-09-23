package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.hozen.khcommon.dba4keisanikkatunyuukingk.KeisanIkkatuNyuukinGkDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 契約保全共通 一括入金額計算
 */
public class KeisanIkkatuNyuukinGk {

    private BizCurrency iktnyknkgk;

    private BizCurrency iktwaribikikgk;

    private BizCurrency wrbktkyokknp;

    private Integer wrbktkyokkntksu;

    private BizCurrency wrbktkyukkngip;

    private Integer wrbktkyukkngitksu;

    private BizCurrency countinscost;

    @Inject
    private static Logger logger;

    @Inject
    private KeisanIkkatuNyuukinGkDao keisanIkkatuNyuukinGkDao;

    public KeisanIkkatuNyuukinGk() {
        super();
    }

    public BizCurrency getIktnyknkgk() {
        return iktnyknkgk;
    }

    public BizCurrency getIktwaribikikgk() {
        return iktwaribikikgk;
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

    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, boolean pIktwaribikiFuyouFlg) {

        logger.debug("▽ 一括入金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        clear();

        if (!checkJutotksuhni(pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu())) {

            logger.info("一括入金額計算エラー。充当月数指定範囲外です。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        C_YouhiKbn youhiKbn = checkIkkatuwaribiki(pIktwaribikiFuyouFlg,
            pKeisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(),
            pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst());

        if (C_YouhiKbn.YOU.eq(youhiKbn)) {

            wrbktkyokkntksu = pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu();

            if (!keisanIkkatuwaribikigop(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(),
                wrbktkyokkntksu, pKeisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                return errorKbn;
            }

            wrbktkyokknp = countinscost;
        }
        else {

            wrbktkyukkngitksu = pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu();

            syuukeip(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(), wrbktkyukkngitksu);

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

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        C_YouhiKbn youhiKbn = checkIkkatuwaribiki(false, C_TkiktbrisyuruiKbn.NONE,
            pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst());

        if (C_YouhiKbn.YOU.eq(youhiKbn)) {

            setWaribikikikan(pRyosyuYmd, pJyuutouYm, pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu());

            if (wrbktkyokkntksu != 0) {

                if (!keisanIkkatuwaribikigop(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(),
                    wrbktkyokkntksu, C_TkiktbrisyuruiKbn.NONE)) {

                    errorKbn = C_ErrorKbn.ERROR;

                    return errorKbn;
                }

                wrbktkyokknp = countinscost;
            }

            if (wrbktkyukkngitksu != 0) {

                syuukeip(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(), wrbktkyukkngitksu);

                wrbktkyukkngip = countinscost;
            }
        }
        else {

            wrbktkyukkngitksu = pKeisanIkkatuNyuukinGkBean.getJyuutoutuKisuu();

            syuukeip(pKeisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst(), wrbktkyukkngitksu);

            wrbktkyukkngip = countinscost;
        }

        iktnyknkgk = wrbktkyokknp.add(wrbktkyukkngip);

        logger.debug("△ 一括入金額計算（割引期間調整あり） 終了");

        return errorKbn;
    }

    private void clear() {

        iktnyknkgk = BizCurrency.valueOf(0);

        iktwaribikikgk = BizCurrency.valueOf(0);

        wrbktkyokknp = BizCurrency.valueOf(0);

        wrbktkyukkngip = BizCurrency.valueOf(0);

        wrbktkyokkntksu = 0;

        wrbktkyukkngitksu = 0;

        countinscost = BizCurrency.valueOf(0);
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

            Long count = keisanIkkatuNyuukinGkDao.getSyouhnZokuseiCountByIkkatuUmu(
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
        Integer pSiteiKknTukisuu, C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn) {

        boolean sumresult = true;

        countinscost = BizCurrency.valueOf(0);

        for (int m = 0; m < pKeisanIkkatuNyuukinGkSyouhnBeanList.size(); m++) {

            KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean =
                pKeisanIkkatuNyuukinGkSyouhnBeanList.get(m);

            BizCurrency sumhokenryou = BizCurrency.valueOf(0);

            BizCurrency discountm = BizCurrency.valueOf(0);

            BizCurrency hokenryou = keisanIkkatuNyuukinGkSyouhnBean.getHokenryou();

            BizCurrency mhokenryou = hokenryou.multiply(pSiteiKknTukisuu);

            Long count = keisanIkkatuNyuukinGkDao.getSyouhnZokuseiCountByIkkatuUmu(
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
                    BizNumber.valueOf(0), pSiteiKknTukisuu,
                    hokenryou))) {

                    sumhokenryou = keisanIkkatuWaribikiP.getP();

                    discountm = keisanIkkatuWaribikiP.getIktwaribikikgk();
                }
                else {

                    sumresult = false;

                    return sumresult;
                }

                if (sumhokenryou.compareTo(mhokenryou) > 0) {

                    sumhokenryou = mhokenryou;

                    discountm = BizCurrency.valueOf(0);
                }
            }

            countinscost = countinscost.add(sumhokenryou);

            iktwaribikikgk = iktwaribikikgk.add(discountm);
        }

        return sumresult;
    }

    private void syuukeip(List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList,
        Integer pSiteiKknTukisuu) {

        countinscost = BizCurrency.valueOf(0);

        BizCurrency sumhokenryou = BizCurrency.valueOf(0);

        for (int k = 0; k < pKeisanIkkatuNyuukinGkSyouhnBeanList.size(); k++) {

            sumhokenryou = sumhokenryou.add(pKeisanIkkatuNyuukinGkSyouhnBeanList.get(k).getHokenryou());
        }

        countinscost = sumhokenryou.multiply(pSiteiKknTukisuu);
    }
}
