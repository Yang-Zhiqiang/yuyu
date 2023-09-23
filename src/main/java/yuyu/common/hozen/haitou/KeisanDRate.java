package yuyu.common.hozen.haitou;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetDrate2;
import yuyu.common.biz.bzcommon.BzGetDrateBean;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.def.classification.C_DRateGetKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 配当 配当金計算（レート方式）
 */
public class KeisanDRate extends BaseDCommon implements IKeisanD {

    private static final BizDateMD kwsratekjmd = BizDateMD.valueOf("0331");

    private BizCurrency haitoukin;

    private BizCurrency haitoukinShisaDrate;

    private BizCurrency haitoukinRisaDrate;

    private BizCurrency haitoukinHisaDrate;

    private BizCurrency haitoukinDyouVrate;

    private BizCurrency haitoukinKikenSrate;

    private List<KeisanDInfoBean> keisanDInfoBeanList = new ArrayList<>();

    private List<KeisanDInfoBean> keisanDInfoBeanSisaDrateList = null;

    private List<KeisanDInfoBean> keisanDInfoBeanRisaDrateList = null;

    private List<KeisanDInfoBean> keisanDInfoBeanHisaDrateList = null;

    private List<KeisanDInfoBean> keisanDInfoBeanDyouVrateList = null;

    private List<KeisanDInfoBean> keisanDInfoBeanKikenSrateList = null;

    @Inject
    private static Logger logger;

    {
        regErrorInfo("001", "為替レート取得エラー", "");
        regErrorInfo("002", "Ｄレート取得エラー", "");
    }

    public KeisanDRate() {
    }

    @Override
    public C_ErrorKbn exec(KeisanDBean pKeisanDBean) {

        logger.debug("▽ 配当金計算 開始");

        clear();

        haitoukin = null;
        haitoukinShisaDrate = null;
        haitoukinRisaDrate = null;
        haitoukinHisaDrate = null;
        haitoukinDyouVrate = null;
        haitoukinKikenSrate = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            BizNumber kawaserate = null;
            BizDate kwsratekjymd = null;
            BizDate hoseigoKwsratekjymd = null;
            if (!C_Tuukasyu.JPY.equals(pKeisanDBean.getTuukasyu())) {
                kwsratekjymd = BizDate.valueOf(pKeisanDBean.getDRateSyutokuInfoBean().getDratenendo(), kwsratekjmd);

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                C_ErrorKbn errorKbn = getKawaseRate.exec(
                    kwsratekjymd,
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    pKeisanDBean.getTuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.equals(errorKbn)) {
                    setErrorInfo("001");

                    logger.debug("△ 配当金計算 終了");

                    return C_ErrorKbn.ERROR;
                }

                kawaserate = getKawaseRate.getKawaserate();
                hoseigoKwsratekjymd = getKawaseRate.getKwsrateKjYmd();

            }

            BzGetDrate2 dRateGet2 = SWAKInjector.getInstance(BzGetDrate2.class);
            BzGetDrateBean bzGetDrateBean = SWAKInjector.getInstance(BzGetDrateBean.class);
            bzGetDrateBean = dRateGet2.exec(
                pKeisanDBean.getDRateSyutokuInfoBean().getSyouhncd(),
                pKeisanDBean.getDRateSyutokuInfoBean().getRyouritusdno(),
                pKeisanDBean.getDRateSyutokuInfoBean().getYoteiriritu(),
                pKeisanDBean.getDRateSyutokuInfoBean().getHrkkaisuu(),
                pKeisanDBean.getDRateSyutokuInfoBean().getHhknsei(),
                pKeisanDBean.getDRateSyutokuInfoBean().getHhknnen(),
                pKeisanDBean.getDRateSyutokuInfoBean().getHknkknsmnkbn(),
                pKeisanDBean.getDRateSyutokuInfoBean().getHknkkn(),
                pKeisanDBean.getDRateSyutokuInfoBean().getHrkkkn(),
                pKeisanDBean.getDRateSyutokuInfoBean().getKykjyoutai(),
                pKeisanDBean.getDRateSyutokuInfoBean().getTuukasyu(),
                pKeisanDBean.getDRateSyutokuInfoBean().getDai1hknkkn(),
                pKeisanDBean.getDRateSyutokuInfoBean().getDratenendo().toString(),
                pKeisanDBean.getDRateSyutokuInfoBean().getNaiteikakuteikbn(),
                C_DRateGetKbn.ALL,
                0);

            if (C_ErrorKbn.ERROR.equals(bzGetDrateBean.getErrorKbn())) {
                setErrorInfo("002");

                logger.debug("△ 配当金計算 終了");

                return C_ErrorKbn.ERROR;
            }

            haitoukin = BizCurrency.valueOf(0);
            if (C_UmuKbn.ARI.equals(pKeisanDBean.getKsnSiyouUmu())) {
                haitoukinShisaDrate = BizCurrency.valueOf(0);
                haitoukinRisaDrate = BizCurrency.valueOf(0);
                haitoukinHisaDrate = BizCurrency.valueOf(0);
                haitoukinDyouVrate = BizCurrency.valueOf(0);
                haitoukinKikenSrate = BizCurrency.valueOf(0);
            }

            for (HaitouKaisuuBean haitouKaisuuBean : pKeisanDBean.getHaitouKaisuuBeanList()) {
                BizCurrency tempHaitoukin = null;
                BizCurrency tempHaitoukinShisaDrate = null;
                BizCurrency tempHaitoukinRisaDrate = null;
                BizCurrency tempHaitoukinHisaDrate = null;
                BizCurrency tempHaitoukinDyouVrate = null;
                BizCurrency tempHaitoukinKikenSrate = null;

                int keikaNensuu = haitouKaisuuBean.getHaitoukaisuu() - 1;

                KeisanDInfoBean keisanDInfoBean = calcD(pKeisanDBean.getKihonS(), bzGetDrateBean.getDrate().get(keikaNensuu),
                    kawaserate, haitouKaisuuBean.getKeikamon());
                keisanDInfoBeanList.add(keisanDInfoBean);
                tempHaitoukin = keisanDInfoBean.getHaitoukinYen();
                keisanDInfoBean.setKwsratekjymd(hoseigoKwsratekjymd);
                haitoukin = haitoukin.add(tempHaitoukin);

                if (C_UmuKbn.ARI.equals(pKeisanDBean.getKsnSiyouUmu())) {
                    KeisanDInfoBean keisanDInfoBeanShisaDrate = calcD(pKeisanDBean.getKihonS(),
                        bzGetDrateBean.getShisaDrate().get(keikaNensuu), kawaserate, haitouKaisuuBean.getKeikamon());
                    KeisanDInfoBean keisanDInfoBeanRisaDrate =calcD(pKeisanDBean.getKihonS(),
                        bzGetDrateBean.getRisaDrate().get(keikaNensuu), kawaserate, haitouKaisuuBean.getKeikamon());
                    KeisanDInfoBean keisanDInfoBeanHisaDrate =calcD(pKeisanDBean.getKihonS(),
                        bzGetDrateBean.getHisaDrate().get(keikaNensuu), kawaserate, haitouKaisuuBean.getKeikamon());
                    KeisanDInfoBean keisanDInfoBeanDyouVrate = calcD(pKeisanDBean.getKihonS(),
                        bzGetDrateBean.getDyouVrate().get(keikaNensuu), kawaserate, haitouKaisuuBean.getKeikamon());
                    KeisanDInfoBean keisanDInfoBeanKikenSrate =calcD(pKeisanDBean.getKihonS(),
                        bzGetDrateBean.getKikenSrate().get(keikaNensuu), kawaserate, haitouKaisuuBean.getKeikamon());

                    if(keisanDInfoBeanSisaDrateList == null){
                        keisanDInfoBeanSisaDrateList = new ArrayList<>();
                    }
                    if(keisanDInfoBeanRisaDrateList == null){
                        keisanDInfoBeanRisaDrateList = new ArrayList<>();
                    }
                    if(keisanDInfoBeanHisaDrateList == null){
                        keisanDInfoBeanHisaDrateList = new ArrayList<>();
                    }
                    if (keisanDInfoBeanDyouVrateList == null) {
                        keisanDInfoBeanDyouVrateList = new ArrayList<>();
                    }
                    if(keisanDInfoBeanKikenSrateList == null){
                        keisanDInfoBeanKikenSrateList = new ArrayList<>();
                    }

                    keisanDInfoBeanSisaDrateList.add(keisanDInfoBeanShisaDrate);
                    keisanDInfoBeanRisaDrateList.add(keisanDInfoBeanRisaDrate);
                    keisanDInfoBeanHisaDrateList.add(keisanDInfoBeanHisaDrate);
                    keisanDInfoBeanDyouVrateList.add(keisanDInfoBeanDyouVrate);
                    keisanDInfoBeanKikenSrateList.add(keisanDInfoBeanKikenSrate);

                    tempHaitoukinShisaDrate = keisanDInfoBeanShisaDrate.getHaitoukinYen();
                    tempHaitoukinRisaDrate = keisanDInfoBeanRisaDrate.getHaitoukinYen();
                    tempHaitoukinHisaDrate = keisanDInfoBeanHisaDrate.getHaitoukinYen();
                    tempHaitoukinDyouVrate = keisanDInfoBeanDyouVrate.getHaitoukinYen();
                    tempHaitoukinKikenSrate = keisanDInfoBeanKikenSrate.getHaitoukinYen();

                    haitoukinShisaDrate = haitoukinShisaDrate.add(tempHaitoukinShisaDrate);
                    haitoukinRisaDrate = haitoukinRisaDrate.add(tempHaitoukinRisaDrate);
                    haitoukinHisaDrate = haitoukinHisaDrate.add(tempHaitoukinHisaDrate);
                    haitoukinDyouVrate = haitoukinDyouVrate.add(tempHaitoukinDyouVrate);
                    haitoukinKikenSrate = haitoukinKikenSrate.add(tempHaitoukinKikenSrate);
                }

                if (logger.isDebugEnabled()) {
                    logger.debug("｜ ▽ 配当金計算情報");
                    if (C_Tuukasyu.JPY.equals(pKeisanDBean.getTuukasyu())) {
                        logger.debug("｜ ｜ 為替レート                ＝ ");
                        logger.debug("｜ ｜ 為替レート基準日          ＝ ");
                    } else {

                        logger.debug("｜ ｜ 為替レート                ＝ " + kawaserate);
                        logger.debug("｜ ｜ 為替レート基準日          ＝ " + kwsratekjymd);
                    }
                    logger.debug("｜ ｜ 経過月数                  ＝ " + haitouKaisuuBean.getKeikamon());
                    logger.debug("｜ ｜ Ｄレート                  ＝ " + bzGetDrateBean.getDrate().get(keikaNensuu));
                    logger.debug("｜ ｜ 配当金                    ＝ " + tempHaitoukin);
                    logger.debug("｜ ｜ 死差Ｄレート              ＝ " + bzGetDrateBean.getShisaDrate().get(keikaNensuu));
                    logger.debug("｜ ｜ 配当金（死差Ｄレート使用）＝ " + tempHaitoukinShisaDrate);
                    logger.debug("｜ ｜ 利差Ｄレート              ＝ " + bzGetDrateBean.getRisaDrate().get(keikaNensuu));
                    logger.debug("｜ ｜ 配当金（利差Ｄレート使用）＝ " + tempHaitoukinRisaDrate);
                    logger.debug("｜ ｜ 費差Ｄレート              ＝ " + bzGetDrateBean.getHisaDrate().get(keikaNensuu));
                    logger.debug("｜ ｜ 配当金（費差Ｄレート使用）＝ " + tempHaitoukinHisaDrate);
                    logger.debug("｜ ｜ Ｄ用Ｖレート              ＝ " + bzGetDrateBean.getDyouVrate().get(keikaNensuu));
                    logger.debug("｜ ｜ 配当金（Ｄ用Vレート使用） ＝ " + tempHaitoukinDyouVrate);
                    logger.debug("｜ ｜ 危険Ｓレート              ＝ " + bzGetDrateBean.getKikenSrate().get(keikaNensuu));
                    logger.debug("｜ ｜ 配当金（危険Sレート使用） ＝ " + tempHaitoukinKikenSrate);
                    logger.debug("｜ △");
                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug("｜ ▽ 配当金計算結果");
                logger.debug("｜ ｜ 配当金                    ＝ " + haitoukin);
                logger.debug("｜ ｜ 配当金（死差Ｄレート使用）＝ " + haitoukinShisaDrate);
                logger.debug("｜ ｜ 配当金（利差Ｄレート使用）＝ " + haitoukinRisaDrate);
                logger.debug("｜ ｜ 配当金（費差Ｄレート使用）＝ " + haitoukinHisaDrate);
                logger.debug("｜ ｜ 配当金（Ｄ用Vレート使用） ＝ " + haitoukinDyouVrate);
                logger.debug("｜ ｜ 配当金（危険Sレート使用） ＝ " + haitoukinKikenSrate);
                logger.debug("｜ △");
            }
            return C_ErrorKbn.OK;
        } finally {
            collectEntity(collectEntityFlg);
        }
    }

    private KeisanDInfoBean calcD(BizCurrency pKihonS, BizNumber pDrate, BizNumber pKawaserate, int pKeikaTukisuu) {

        KeisanDInfoBean keisanDInfoBean = new KeisanDInfoBean(pKihonS,pDrate,pKawaserate,pKeikaTukisuu);

        BizCurrency wkHaitoukin = pKihonS.multiply(pDrate).toValidValue();

        if (pKawaserate != null) {

            keisanDInfoBean.setHaitoukinYenKansanMae(wkHaitoukin);

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            wkHaitoukin = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                wkHaitoukin,
                pKawaserate,
                C_HasuusyoriKbn.AGE);
        }

        wkHaitoukin = wkHaitoukin.multiply(pKeikaTukisuu).divide(BizNumber.valueOf(12), RoundingMode.DOWN);
        keisanDInfoBean.setHaitoukinYen(wkHaitoukin);

        return keisanDInfoBean;
    }

    @Override
    public void log() {
    }

    @Override
    public BizCurrency getD() {
        return haitoukin;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanList() {
        return keisanDInfoBeanList;
    }

    @Override
    public BizCurrency getDSisaDrate() {
        return haitoukinShisaDrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanSisaDrateList() {
        return keisanDInfoBeanSisaDrateList;
    }

    @Override
    public BizCurrency getDRisaDrate() {
        return haitoukinRisaDrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanRisaDrateList() {
        return keisanDInfoBeanRisaDrateList;
    }

    @Override
    public BizCurrency getDHisaDrate() {
        return haitoukinHisaDrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanHisaDrateList() {
        return keisanDInfoBeanHisaDrateList;
    }

    @Override
    public BizCurrency getDDyouVrate() {
        return haitoukinDyouVrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanDyouVrateList() {
        return keisanDInfoBeanDyouVrateList;
    }

    @Override
    public BizCurrency getDKikenSrate() {
        return haitoukinKikenSrate;
    }

    @Override
    public List<KeisanDInfoBean> getKeisanDInfoBeanKikenSrateList() {
        return keisanDInfoBeanKikenSrateList;
    }
}