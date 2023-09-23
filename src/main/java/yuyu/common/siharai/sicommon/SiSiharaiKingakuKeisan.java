package yuyu.common.siharai.sicommon;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikin;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanTienrisoku;
import yuyu.common.biz.bzcommon.KeisanTienrisokuBean;
import yuyu.common.biz.kaikei.BzShiharaiDenpyouDateShutoku;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.haitou.KeisanDCommonSibou;
import yuyu.common.hozen.khcommon.KeisanMsyMkeiP;
import yuyu.common.hozen.khcommon.MiKeikaPBean;
import yuyu.common.hozen.khcommon.MisyuuPBean;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.chksk.CheckKdSkNaiyouKekkaBean;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouKekkaBean;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmd;
import yuyu.common.siharai.chksk.SiSKNaiyouChkkekkaSettei;
import yuyu.common.siharai.edittbl.SiNenkinInfoBean;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HasuukasanUmuKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HushrSyousaiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.manager.SiharaiDomManager;

import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払金額計算
 */
public class SiSiharaiKingakuKeisan {

    private static final BizNumber MAX_BNWARI = BizNumber.valueOf(100.00);

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private List<SiSiDetailParamBean> siSiDetailParamBean;

    private SiNenkinInfoBean siNenkinInfoBean;

    private SiHkkingakuSisanParamBean siHkkingakuSisanParamBean;

    private List<SiDetailMisyuupBean> siDetailMisyuupBeanLst;

    private List<SiDetailMikeikapBean> siDetailMikeikapBeanLst;

    private EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean;

    private C_SKNaiyouChkkekkaKbn sKNaiyouChkkekkaKbn;

    private List<String> warnMsg;

    private ErrorMessageCollector errMsg;

    private static final String KEY_SITEITUUKA = "SITEITUUKA";

    private static final String KWY_ENKA = "ENKA";

    public SiSiharaiKingakuKeisan() {
        siHkkingakuSisanParamBean = SWAKInjector.getInstance(SiHkkingakuSisanParamBean.class);
        sKNaiyouChkkekkaKbn = C_SKNaiyouChkkekkaKbn.SEIJYOU;
        warnMsg = new ArrayList<>();
        errMsg = new ErrorMessageCollector();
        siDetailMisyuupBeanLst = new ArrayList<>();
        siDetailMikeikapBeanLst = new ArrayList<>();
    }

    public List<SiSiDetailParamBean> getSiSiDetailParamBean() {
        return siSiDetailParamBean;
    }

    public SiNenkinInfoBean getSiNenkinInfoBean() {
        return siNenkinInfoBean;
    }

    public SiHkkingakuSisanParamBean getSiHkkingakuSisanParamBean() {
        return siHkkingakuSisanParamBean;
    }

    public C_SKNaiyouChkkekkaKbn getCSKNaiyouChkkekkaKbn() {
        return sKNaiyouChkkekkaKbn;
    }

    public List<String> getWarnMsg() {
        return warnMsg;
    }

    public ErrorMessageCollector getErrMsg() {
        return errMsg;
    }

    public List<SiDetailMisyuupBean> getSiDetailMisyuupBeans() {
        return siDetailMisyuupBeanLst;
    }

    public List<SiDetailMikeikapBean> getDetailMikeikapBeans() {
        return siDetailMikeikapBeanLst;
    }

    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {
        return editDshrTukiDKoumokuBean;
    }

    public C_ErrorKbn exec(SiSiharaiKingakuKeisanBean pSiSiharaiKingakuKeisanBean) {
        logger.debug("▽ 支払金額計算 開始");


        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        SiHkkingakuSisanParamBean tempSiHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        SiNenkinInfoBean tempSiNenkinInfoBean = SWAKInjector.getInstance(SiNenkinInfoBean.class);


        if (pSiSiharaiKingakuKeisanBean.getInputShrhouSiteiKbn() == null
            || C_InputShrhousiteiKbn.BLNK.eq(pSiSiharaiKingakuKeisanBean.getInputShrhouSiteiKbn())) {
            logger.debug("△ 支払金額計算 終了");
            return errorKbn;
        }


        errorKbn = chkInput(pSiSiharaiKingakuKeisanBean);
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            logger.debug("△ 支払金額計算 終了");
            return errorKbn;
        }

        List<JT_SiKykSyouhn> siKykSyouhnList = pSiSiharaiKingakuKeisanBean.getSiKykKihon().getSiKykSyouhns();
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.BLNK;
        C_Tuukasyu siharaTuukasyu = C_Tuukasyu.BLNK;
        BizDate kykYmd = null;
        BizCurrency hokenryouKgk = BizCurrency.valueOf(0);
        JT_SiKykSyouhn siKykSyouhnSyu = null;
        BizDate seisanCalcKijyunYmd = null;

        for (JT_SiKykSyouhn tempSiKykSyouhn : siKykSyouhnList) {
            if (C_SyutkKbn.SYU.eq(tempSiKykSyouhn.getSyutkkbn())) {
                keiyakuTuukasyu = tempSiKykSyouhn.getKyktuukasyu();
                siharaTuukasyu = tempSiKykSyouhn.getKyktuukasyu();
                kykYmd = tempSiKykSyouhn.getKykymd();
                hokenryouKgk = tempSiKykSyouhn.getHokenryou();
                siKykSyouhnSyu = tempSiKykSyouhn;
                break;
            }
        }

        if (C_SiharaiTuukaKbn.YENSIHARAI.eq(pSiSiharaiKingakuKeisanBean.getSiharaiTuukaKbn())) {
            siharaTuukasyu = C_Tuukasyu.JPY;
        }

        if (pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd().compareTo(kykYmd) < 0) {
            seisanCalcKijyunYmd = kykYmd;
        } else {
            seisanCalcKijyunYmd = pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd();
        }


        BizNumber kawaseRate = BizNumber.valueOf(0);
        BizNumber gaikaknsnKwsrate = BizNumber.valueOf(0);
        BizDate knsnKijyunYmd = null;
        C_UktKyksyaTdk uktKyksyaTdk = C_UktKyksyaTdk.BLNK;
        BizDate zeimukwsratekjnymd = null;
        BizNumber zeimukwsrate = BizNumber.valueOf(0);
        BizNumber misyuuptekikawaserate = BizNumber.valueOf(0);

        if (!pSiSiharaiKingakuKeisanBean.getKawaseRate().isOptional()) {
            kawaseRate = pSiSiharaiKingakuKeisanBean.getKawaseRate();
            gaikaknsnKwsrate = pSiSiharaiKingakuKeisanBean.getGaikaknsnKwsrate();
        }
        else {
            if (!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                if (pSiSiharaiKingakuKeisanBean.getKnsnKijyunYmd() != null) {
                    knsnKijyunYmd = pSiSiharaiKingakuKeisanBean.getKnsnKijyunYmd();
                }
                else {
                    if (pSiSiharaiKingakuKeisanBean.getHubiKanryouYmd() != null) {
                        knsnKijyunYmd = pSiSiharaiKingakuKeisanBean.getHubiKanryouYmd();
                    }
                    else {
                        knsnKijyunYmd = pSiSiharaiKingakuKeisanBean.getSyoruiUkeYmd();
                    }
                }

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                errorKbn = getKawaseRate.exec(knsnKijyunYmd, C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    keiyakuTuukasyu, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    errMsg.addMessage(MessageId.EJA1008, String.valueOf(knsnKijyunYmd));
                    logger.debug("△ 支払金額計算 終了");
                    return errorKbn;
                }
                else if (C_ErrorKbn.OK.eq(errorKbn)) {
                    kawaseRate = getKawaseRate.getKawaserate();
                    knsnKijyunYmd = getKawaseRate.getKwsrateKjYmd();
                }

                errorKbn = getKawaseRate.exec(knsnKijyunYmd, C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    keiyakuTuukasyu, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    errMsg.addMessage(MessageId.EJA1008, String.valueOf(knsnKijyunYmd));
                    logger.debug("△ 支払金額計算 終了");
                    return errorKbn;
                }
                else if (C_ErrorKbn.OK.eq(errorKbn)) {
                    gaikaknsnKwsrate = getKawaseRate.getKawaserate();
                }
            }
        }

        if (!C_SeikyuusyaKbn.BLNK.eq(pSiSiharaiKingakuKeisanBean.getSeikyuusyaKbn())) {
            uktKyksyaTdk = uktkyksyatdkCheck(
                pSiSiharaiKingakuKeisanBean.getSiKykKihon(), pSiSiharaiKingakuKeisanBean.getSeikyuusyaKbn());
            if (!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                if (C_SiharaiTuukaKbn.YENSIHARAI.eq(pSiSiharaiKingakuKeisanBean.getSiharaiTuukaKbn())) {
                    zeimukwsrate = kawaseRate;
                    zeimukwsratekjnymd = knsnKijyunYmd;
                    misyuuptekikawaserate = kawaseRate;
                }
                else {
                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                    errorKbn = getKawaseRate.exec(pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE, keiyakuTuukasyu, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);
                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        errMsg.addMessage(MessageId.EJA1008,
                            String.valueOf(pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd()));
                        logger.debug("△ 支払金額計算 終了");
                        return errorKbn;
                    } else if (C_ErrorKbn.OK.eq(errorKbn)) {
                        misyuuptekikawaserate = getKawaseRate.getKawaserate();
                    }

                    if (C_UktKyksyaTdk.KYKHNN.eq(uktKyksyaTdk)) {
                        zeimukwsrate = getKawaseRate.getKawaserate();
                        zeimukwsratekjnymd = getKawaseRate.getKwsrateKjYmd();
                    } else {
                        errorKbn = getKawaseRate.exec(pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE, keiyakuTuukasyu, C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTB, C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);
                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            errMsg.addMessage(MessageId.EJA1008,
                                String.valueOf(pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd()));
                            logger.debug("△ 支払金額計算 終了");
                            return errorKbn;
                        } else if (C_ErrorKbn.OK.eq(errorKbn)) {
                            zeimukwsrate = getKawaseRate.getKawaserate();
                            zeimukwsratekjnymd = getKawaseRate.getKwsrateKjYmd();
                        }
                    }
                }
            }
        }

        BM_SyouhnZokusei syouhnZokuseiSyu = bizDomManager.getSyouhnZokusei(siKykSyouhnSyu.getSyouhncd(),
            siKykSyouhnSyu.getSyouhnsdno());
        if (syouhnZokuseiSyu == null) {
            errorKbn = C_ErrorKbn.ERROR;
            errMsg.addMessage(MessageId.EBS0005, "BM_SyouhnZokusei", "syouhncd", siKykSyouhnSyu.getSyouhncd(),
                "syouhnsdno", siKykSyouhnSyu.getSyouhnsdno().toString());
            logger.debug("△ 支払金額計算 終了");
            return errorKbn;
        }

        JM_SiSyouhnZokusei siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(siKykSyouhnSyu
            .getSyouhncd());


        SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(
            pSiSiharaiKingakuKeisanBean.getSyoNo(),
            pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd());

        IT_HokenryouTmttkn hokenryouTmttkn = hozenDomManager.getHokenryouTmttknBySyonoTmttkntaisyouym(
            pSiSiharaiKingakuKeisanBean.getSyoNo(),
            pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd().getBizDateYM());


        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(keiyakuTuukasyu);


        BizCurrency kaiyakuhrGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency sbymdKaiyakuhrGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency tutakngkGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency sbymdTutakngkGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency hokenryoustgkGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency pruikei = BizCurrency.valueOf(0, currencyType);
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        String hokenkinsyurui = "";
        C_HknKknKbn hknkknkbn = C_HknKknKbn.BLNK;
        BizCurrency kihonhokenkngkGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency sbhokenkngkGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency saigaisGoukei = BizCurrency.valueOf(0, currencyType);
        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
        C_NaiteiKakuteiKbn naiteikakuteikbn = C_NaiteiKakuteiKbn.BLNK;
        BizCurrency haitoukin = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaHaitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency sonotaHaitoukin = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaSonotaHaitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency zennouSeisanKgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaZennouSeisanKgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency misyuuP = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaMisyuuP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency mikeikaP = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaMikeikaP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency krkgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaKrkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency zitkAzukariKingkSiteituuka = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenZitkAzukariKingkSttk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency zitkAzukariKingkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gaikaknsnZitkAzukariKingkYen = BizCurrency.valueOf(0, currencyType);
        BizCurrency azukariKingk = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaAzukariKingk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        int misyuupJyuutoukaisuuY = 0;
        int misyuupJyuutoukaisuuM = 0;
        BizDateYM misyuupJyuutouYm = null;
        int mikeikapJyuutoukaisuuY = 0;
        int mikeikapJyuutoukaisuuM = 0;
        BizDateYM mikeikapJyuutouYm = null;
        BizCurrency misyuuSyonendoJikaiikouP = BizCurrency.valueOf(0, currencyType);
        BizCurrency misyuuJinendoikouP = BizCurrency.valueOf(0, currencyType);
        BizCurrency gaikaKnsnTKgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gaikaKnsnKekkaKgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaKnsnTKgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenkaKnsnKekkaKgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        JM_Kyuuhu kyuuhuCheck = makeKyuuhumstCheckEntity();

        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<>();

        for (JT_SiKykSyouhn tempSiKykSyouhn : siKykSyouhnList) {
            List<JM_SiSyouhnZokusei> siSyouhnZokuseiList = siharaiDomManager
                .getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(tempSiKykSyouhn.getSyouhncd(),
                    tempSiKykSyouhn.getKyhgndkatakbn(), tempSiKykSyouhn.getSyouhnsdno());

            if (siSyouhnZokuseiList.size() == 0) {
                errMsg.addMessage(MessageId.EBS0006, "JM_SiSyouhnZokusei", "syouhncd", tempSiKykSyouhn.getSyouhncd(),
                    "kyhgndkatakbn", tempSiKykSyouhn.getKyhgndkatakbn().getValue(), "syouhnsdno",
                    String.valueOf(tempSiKykSyouhn.getSyouhnsdno()));

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 支払金額計算 終了");
                return errorKbn;
            }
            ChkSubSknnKaisiYmd chkSubSknnKaisiYmd = SWAKInjector.getInstance(ChkSubSknnKaisiYmd.class);
            List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();
            chkSubSknnKaisiYmd.exec(pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd(), pSiSiharaiKingakuKeisanBean
                .getSiKykKihon().getHksknnkaisiymd(), tempSiKykSyouhn, chkKekkaBeanList);
            if (chkKekkaBeanList.size() != 0) {
                continue;
            }

            BizCurrency kaiyakuhr = BizCurrency.valueOf(0, currencyType);
            BizCurrency sbymdKaiyakuhr = BizCurrency.valueOf(0, currencyType);
            BizCurrency tutakngk = BizCurrency.valueOf(0, currencyType);
            BizCurrency sbymdTutakngk = BizCurrency.valueOf(0, currencyType);
            BizCurrency hokenryoustgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency kihonhokenkngk = BizCurrency.valueOf(0, currencyType);
            BizCurrency sbhokenkngk = BizCurrency.valueOf(0, currencyType);
            BizCurrency saigais = BizCurrency.valueOf(0, currencyType);
            BizCurrency syouhnbtPruikei = BizCurrency.valueOf(0, currencyType);
            int idx3 = 0;
            for (JM_SiSyouhnZokusei tempJM_SiSyouhnZokusei : siSyouhnZokuseiList) {
                JM_Kyuuhu kyuuhu = tempJM_SiSyouhnZokusei.getKyuuhu();
                if (kyuuhu == null) {
                    continue;
                }
                if (!pSiSiharaiKingakuKeisanBean.getSeikyuuSyubetu().eq(kyuuhu.getSeikyuusyubetu())) {
                    continue;
                }

                setKyuuhumstCheckEntity(kyuuhu, kyuuhuCheck);

                SiSiDetailParamBean tempSiSiDetailParamBean = SWAKInjector.getInstance(SiSiDetailParamBean.class);

                CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
                C_ErrorKbn errorKbnCalcHkShrKngk;
                if (C_UmuKbn.ARI.eq(pSiSiharaiKingakuKeisanBean.getKaiyakusjkkktyouseirirituUmKbn())) {

                    BizDateYM tmttkntaisyouYm = null;
                    BizCurrency teiritutmttKngk = null;
                    BizCurrency sisuurendoutmttKngk = null;
                    BizCurrency pTmttkngk = null;
                    BizCurrency kihrkmPStgk = null;

                    if (sisurendoTmttknInfoBean != null) {
                        tmttkntaisyouYm = sisurendoTmttknInfoBean.getTmttknTaisyouYM();
                        teiritutmttKngk = sisurendoTmttknInfoBean.getTeirituTmttknGK();
                        sisuurendoutmttKngk = sisurendoTmttknInfoBean.getSisuuRendouTmttknGK();
                    }

                    if (hokenryouTmttkn != null) {
                        tmttkntaisyouYm = hokenryouTmttkn.getTmttkntaisyouym();
                        pTmttkngk = hokenryouTmttkn.getPtmttkngk();
                        kihrkmPStgk = hokenryouTmttkn.getKihrkmpstgk();
                    }

                    errorKbnCalcHkShrKngk = calcHkShrKngk.exec(
                        tempSiKykSyouhn.getSyouhncd(),
                        tempSiKykSyouhn.getSyouhnsdno(),
                        tempSiKykSyouhn.getRyouritusdno(),
                        tempSiKykSyouhn.getYoteiriritu(),
                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getHrkkaisuu(),
                        tempSiKykSyouhn.getHknkknsmnkbn(),
                        tempSiKykSyouhn.getHknkkn(),
                        tempSiKykSyouhn.getHrkkkn(),
                        tempSiKykSyouhn.getHhknnen(),
                        tempSiKykSyouhn.getHhknsei(),
                        tempSiKykSyouhn.getKihons(),
                        tempSiKykSyouhn.getKykymd(),
                        pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd(),
                        pSiSiharaiKingakuKeisanBean.getSyoNo(),
                        keiyakuTuukasyu,
                        tempSiKykSyouhn.getDai1hknkkn(),
                        pSiSiharaiKingakuKeisanBean.getSiinKbn(),
                        kyuuhu.getHokenkinsyuruikbn(),
                        tempSiKykSyouhn.getHokenryou(),
                        pSiSiharaiKingakuKeisanBean.getKaiyakusjkkktyouseiriritu(),
                        tempSiKykSyouhn.getKyksjkkktyouseiriritu(),
                        tmttkntaisyouYm,
                        teiritutmttKngk,
                        sisuurendoutmttKngk,
                        tempSiKykSyouhn.getTumitateriritu(),
                        tempSiKykSyouhn.getHrkkknsmnkbn(),
                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getNexthrkym(),
                        pTmttkngk,
                        kihrkmPStgk,
                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getFstpnyknymd(),
                        tempSiKykSyouhn.getYoteirrthendohosyurrt(),
                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getKykjyoutai(),
                        tempSiKykSyouhn.getYendthnkymd(),
                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getSdpdkbn(),
                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getHrkkeiro());
                } else {
                    errorKbnCalcHkShrKngk = calcHkShrKngk.execByKeisanWExt(
                        pSiSiharaiKingakuKeisanBean.getSyoNo(),
                        pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd(),
                        pSiSiharaiKingakuKeisanBean.getSiinKbn(),
                        kyuuhu.getHokenkinsyuruikbn(),
                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getSdpdkbn(),
                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getHrkkeiro());
                }

                if (C_ErrorKbn.ERROR.eq(errorKbnCalcHkShrKngk)) {
                    errorKbn = C_ErrorKbn.ERROR;
                    errMsg.addMessage(MessageId.EBF0129, MessageUtil.getMessage(MessageId.IJW1075));
                    logger.debug("△ 支払金額計算 終了");
                    return errorKbn;
                }

                CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

                BizCurrency hokenKngkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency sitihsyutkyumaeyenhknkngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (calcHkShrKngkBean.getHokenknGk().compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
                    kaiyakuhr = calcHkShrKngkBean.getKaiyakuhenreiknGk();
                    sbymdKaiyakuhr = calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk();
                    tutakngk = calcHkShrKngkBean.getTmttKnGk();
                    sbymdTutakngk = calcHkShrKngkBean.getSbymdTmttKnGk();
                    hokenryoustgk = calcHkShrKngkBean.getHokenryoustGk();
                    hokenkinsyuruikbn = kyuuhu.getHokenkinsyuruikbn();
                    hokenkinsyurui = kyuuhu.getKyuuhunamegamen();
                    hknkknkbn = calcHkShrKngkBean.getHknKknKbn();
                    kihonhokenkngk = calcHkShrKngkBean.getKihons();
                    sbhokenkngk = calcHkShrKngkBean.getSibousGk();
                    saigais = calcHkShrKngkBean.getSaigaisGk();
                    syouhnbtPruikei = calcHkShrKngkBean.getPruikei();

                    if (!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        hokenKngkYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, calcHkShrKngkBean.getHokenknGk(),
                            kawaseRate, C_HasuusyoriKbn.AGE);

                        if (C_UmuKbn.ARI.eq(pSiSiharaiKingakuKeisanBean.getSiKykKihon().
                            getInitsbjiyensitihsytkhukaumu())) {
                            if (C_HknKknKbn.DAI1HKNKKN.eq(calcHkShrKngkBean.getHknKknKbn())) {
                                if (hokenKngkYen.compareTo(pSiSiharaiKingakuKeisanBean.getSiKykKihon()
                                    .getInitsbjiyenkasaiteihsygk()) < 0) {
                                    sitihsyutkyumaeyenhknkngk = hokenKngkYen;
                                    hokenKngkYen =
                                        pSiSiharaiKingakuKeisanBean.getSiKykKihon().getInitsbjiyenkasaiteihsygk();
                                    syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
                                }
                            }
                        }
                    }
                }

                boolean result = simisiParamBeanCreateCheck(kyuuhu, calcHkShrKngkBean);

                if (result) {
                    tempSiSiDetailParamBean.setUketukeno(1);
                    tempSiSiDetailParamBean.setSyutkkbn(tempSiKykSyouhn.getSyutkkbn());
                    tempSiSiDetailParamBean.setSyouhncd(tempSiKykSyouhn.getSyouhncd());
                    tempSiSiDetailParamBean.setKyhgndkatakbn(tempSiKykSyouhn.getKyhgndkatakbn());
                    tempSiSiDetailParamBean.setSyouhnsdno(tempSiKykSyouhn.getSyouhnsdno());
                    tempSiSiDetailParamBean.setKyksyouhnrenno(tempSiKykSyouhn.getKyksyouhnrenno());
                    tempSiSiDetailParamBean.setKyuuhucd(kyuuhu.getKyuuhucd());
                    tempSiSiDetailParamBean.setRenno(++idx3);
                    tempSiSiDetailParamBean.setKyuuhukbn(kyuuhu.getKyuuhukbn());
                    tempSiSiDetailParamBean.setHokenkinsyuruikbn(kyuuhu.getHokenkinsyuruikbn());
                    tempSiSiDetailParamBean.setKanjyoukmkcd(kyuuhu.getKanjyoukmkcd());
                    tempSiSiDetailParamBean.setChecktaisyouumukbn(C_UmuKbn.NONE);
                    tempSiSiDetailParamBean.setNitigakuhokenkngkkbn(tempJM_SiSyouhnZokusei.getNitigakuhokenkngkkbn());
                    tempSiSiDetailParamBean.setNitigakuhokenkngk(calcHkShrKngkBean.getKihons());
                    tempSiSiDetailParamBean.setNissuubairitu(0);
                    tempSiSiDetailParamBean.setKyhkintanikbn(tempJM_SiSyouhnZokusei.getKyhkintanikbn());
                    tempSiSiDetailParamBean.setKyhkg(calcHkShrKngkBean.getHokenknGk());
                    tempSiSiDetailParamBean.setYenkyhgk(hokenKngkYen);
                    tempSiSiDetailParamBean.setHutanponissuu(tempJM_SiSyouhnZokusei.getHutanponissuu());
                    tempSiSiDetailParamBean.setShrriyuugaitouymd(null);
                    tempSiSiDetailParamBean.setHknskgnkkntgtumukbn(C_UmuKbn.NONE);
                    tempSiSiDetailParamBean.setHokenkinshrwariai(BizNumber.valueOf(0));
                    tempSiSiDetailParamBean.setBikoumsg1("");
                    tempSiSiDetailParamBean.setBikoumsg2("");
                    tempSiSiDetailParamBean.setBikoumsg3("");
                    tempSiSiDetailParamBean.setBikoumsg4("");
                    tempSiSiDetailParamBean.setSyouhnnmgm(tempSiKykSyouhn.getSyouhnnmgm());
                    tempSiSiDetailParamBean.setSyouhnnmtyhy(tempSiKykSyouhn.getSyouhnnmtyhy());
                    tempSiSiDetailParamBean.setKyuuhunamegamen(kyuuhu.getKyuuhunamegamen());
                    tempSiSiDetailParamBean.setKyuuhunamereport(kyuuhu.getKyuuhunamereport());
                    tempSiSiDetailParamBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
                    tempSiSiDetailParamBean.setHushrsyousaikbn(C_HushrSyousaiKbn.BLNK);
                    tempSiSiDetailParamBean.setKyhkngkgoukei(BizCurrency.valueOf(0, currencyType));
                    tempSiSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(sitihsyutkyumaeyenhknkngk);
                    tempSiSiDetailParamBean.setUtiwakeparam("");

                    siSiDetailParamBeanList.add(tempSiSiDetailParamBean);
                }
            }

            kaiyakuhrGoukei = kaiyakuhrGoukei.add(kaiyakuhr);
            sbymdKaiyakuhrGoukei = sbymdKaiyakuhrGoukei.add(sbymdKaiyakuhr);
            tutakngkGoukei = tutakngkGoukei.add(tutakngk);
            sbymdTutakngkGoukei = sbymdTutakngkGoukei.add(sbymdTutakngk);
            hokenryoustgkGoukei = hokenryoustgkGoukei.add(hokenryoustgk);
            kihonhokenkngkGoukei = kihonhokenkngkGoukei.add(kihonhokenkngk);
            sbhokenkngkGoukei = sbhokenkngkGoukei.add(sbhokenkngk);
            saigaisGoukei = saigaisGoukei.add(saigais);
            pruikei = pruikei.add(syouhnbtPruikei);
        }


        if (C_HaitouKbn.YUUHAI.eq(syouhnZokuseiSyu.getHaitoukbn()) ||
            C_HaitouKbn.RISAHAI.eq(syouhnZokuseiSyu.getHaitoukbn())) {
            if (C_YuukousyoumetuKbn.YUUKOU.eq(pSiSiharaiKingakuKeisanBean.getSiKykKihon().getYuukousyoumetukbn())) {
                if (!TeisuuSiharai.SIBIKINTYUSYUTU.equals(pSiSiharaiKingakuKeisanBean.getYobidasimotoKinouId())) {
                    KeisanDCommonSibou keisanDCommonSibou = SWAKInjector.getInstance(KeisanDCommonSibou.class);
                    C_ErrorKbn errorKbnCalcDShrgk = keisanDCommonSibou.calcDShrgk(pSiSiharaiKingakuKeisanBean.getSyoNo(),
                        pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd(), pSiSiharaiKingakuKeisanBean.getSyoriYmd());
                    if (C_ErrorKbn.ERROR.eq(errorKbnCalcDShrgk)) {
                        errorKbn = C_ErrorKbn.ERROR;
                        errMsg.addMessage(MessageId.EBF0129, MessageUtil.getMessage(MessageId.IJW1094));
                        logger.debug("△ 支払金額計算 終了");
                        return errorKbn;
                    }

                    if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                        haitoukin = keisanDCommonSibou.getDShrkn();
                        sonotaHaitoukin = keisanDCommonSibou.getTkbtD();
                    }
                    else {
                        yenkaHaitoukin = keisanDCommonSibou.getDShrkn();
                        yenkaSonotaHaitoukin = keisanDCommonSibou.getTkbtD();
                    }

                    if (keisanDCommonSibou.getKhHaitouKanriNaiteiKakuteiKbn() != null) {
                        naiteikakuteikbn = keisanDCommonSibou.getKhHaitouKanriNaiteiKakuteiKbn();
                    } else {
                        naiteikakuteikbn = C_NaiteiKakuteiKbn.BLNK;
                    }

                    editDshrTukiDKoumokuBean = keisanDCommonSibou.getEditDshrTukiDKoumokuBean();
                }
            }
        }


        C_ErrorKbn keisanZennouSeisanGkErrorKbn = C_ErrorKbn.OK;

        KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);
        if (C_UmuKbn.ARI.eq(syouhnZokuseiSyu.getZennouumu())) {
            if (C_Kykjyoutai.ZENNOU.eq(pSiSiharaiKingakuKeisanBean.getSiKykKihon().getKykjyoutai())) {
                keisanZennouSeisanGkErrorKbn = keisanZennouSeisanGk2.exec(seisanCalcKijyunYmd,
                    pSiSiharaiKingakuKeisanBean.getSyoNo());

                if (C_ErrorKbn.OK.eq(keisanZennouSeisanGkErrorKbn)) {
                    if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                        zennouSeisanKgk = keisanZennouSeisanGk2.getZennouSeisanGk();
                    }
                    else {
                        if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                            yenkaZennouSeisanKgk = keisanZennouSeisanGk2.getZennouSeisanGk();
                        }
                        else {
                            zennouSeisanKgk = keisanZennouSeisanGk2.getZennouSeisanGk();
                        }
                    }
                }
            }
        }


        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        if (C_UmuKbn.ARI.eq(syouhnZokuseiSyu.getHeijyunbaraiumu()) && C_ErrorKbn.OK.eq(keisanZennouSeisanGkErrorKbn)) {
            KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
            BizDateYM jkipjytYm = null;
            if (C_Kykjyoutai.ZENNOU.eq(pSiSiharaiKingakuKeisanBean.getSiKykKihon().getKykjyoutai())) {
                BizDate hanteiYMD = BizDate.valueOf(keisanZennouSeisanGk2.getLastPJyuutouYm(), kykYmd.getDay());
                if (!hanteiYMD.isRekijyou()) {
                    hanteiYMD = hanteiYMD.getRekijyou();
                }

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                jkipjytYm = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, kykYmd, C_Hrkkaisuu.NEN, hanteiYMD).getBizDateYM();
            }
            else {
                jkipjytYm = pSiSiharaiKingakuKeisanBean.getSiKykKihon().getNexthrkym();
            }
            keisanMsyMkeiP.exec(pSiSiharaiKingakuKeisanBean.getSyoNo(), seisanCalcKijyunYmd, jkipjytYm, hokenryouKgk,
                C_MisyuptsKbn.TS);

            misyuupJyuutoukaisuuY = keisanMsyMkeiP.getMisyuPJyutouKaisuuY();
            misyuupJyuutoukaisuuM = keisanMsyMkeiP.getMisyuPJyutouKaisuuM();
            misyuupJyuutouYm = keisanMsyMkeiP.getMisyuPJyutouYM();
            mikeikapJyuutoukaisuuY = keisanMsyMkeiP.getMikeikaPJyutouKaisuuY();
            mikeikapJyuutoukaisuuM = keisanMsyMkeiP.getMikeikaPJyutouKaisuuM();
            mikeikapJyuutouYm = keisanMsyMkeiP.getMikeikaPJyutouYM();
            MisyuuPBean[] misyuuPBeans = keisanMsyMkeiP.getMisyuuPBeans();
            MiKeikaPBean[] miKeikaPBeans = keisanMsyMkeiP.getMiKeikaPBeans();

            if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                misyuuP = keisanMsyMkeiP.getMisyuP();
                mikeikaP = keisanMsyMkeiP.getMikeikaP();
            }
            else {
                misyuuP = keisanMsyMkeiP.getMisyuPGaika();
                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                    yenkaMikeikaP = keisanMsyMkeiP.getMikeikaP();
                }
                else {
                    mikeikaP = keisanMsyMkeiP.getMikeikaP();
                }
            }

            List<SiDetailMisyuupBean> siDetailMisyuupBeanLstTemp = new ArrayList<>();
            List<SiDetailMikeikapBean> siDetailMikeikapBeanLstTemp = new ArrayList<>();

            if (misyuuPBeans != null) {
                for (MisyuuPBean misyuuPBean : misyuuPBeans) {
                    BizCurrency dtlmisyuupgaikayenkingk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    if (misyuuPBean.getMisyuuPGaika().compareTo(
                        BizCurrency.valueOf(0, misyuuPBean.getMisyuuPGaika().getType())) > 0) {
                        dtlmisyuupgaikayenkingk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, misyuuPBean.getMisyuuPGaika(),
                            kawaseRate, C_HasuusyoriKbn.AGE);
                    }

                    SiDetailMisyuupBean siDetailMisyuupBean = new SiDetailMisyuupBean();
                    siDetailMisyuupBean.setDtlmisyuup(misyuuPBean.getMisyuuP());
                    siDetailMisyuupBean.setDtlmisyuupgaika(misyuuPBean.getMisyuuPGaika());
                    siDetailMisyuupBean.setDtlmisyuupgaikayenkingk(dtlmisyuupgaikayenkingk);
                    siDetailMisyuupBean.setDtlmisyuupiktnyuukinnumu(misyuuPBean.getMsyPIkkatuNkUmu());
                    siDetailMisyuupBean.setDtlmisyuuphrkkaisuu(misyuuPBean.getMsyPHrkKaisuu());
                    siDetailMisyuupBean.setDtlmisyuupjyutoukaisuuy(misyuuPBean.getMsyPJytKaisuuY());
                    siDetailMisyuupBean.setDtlmisyuupjyutoukaisuum(misyuuPBean.getMsyPJytKaisuuM());
                    siDetailMisyuupBean.setDtlmisyuupjyuutouym(misyuuPBean.getMsyPJytYm());

                    siDetailMisyuupBeanLstTemp.add(siDetailMisyuupBean);
                }
            }

            if (miKeikaPBeans != null) {
                for (MiKeikaPBean miKeikaPBean : miKeikaPBeans) {
                    BizCurrency dtlmikeikap;
                    BizCurrency dtlmikeikapgaika;
                    if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                        dtlmikeikap = miKeikaPBean.getMiKeikaP();
                        dtlmikeikapgaika = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    }
                    else {
                        if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                            dtlmikeikap = miKeikaPBean.getMiKeikaP();
                            dtlmikeikapgaika = keisanGaikakanzan.execDivide(keiyakuTuukasyu,
                                miKeikaPBean.getMiKeikaP(), gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
                        }
                        else {
                            dtlmikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                            dtlmikeikapgaika = miKeikaPBean.getMiKeikaP();
                        }
                    }

                    SiDetailMikeikapBean siDetailMikeikapBean = new SiDetailMikeikapBean();
                    siDetailMikeikapBean.setDtlmikeikap(dtlmikeikap);
                    siDetailMikeikapBean.setDtlmikeikapgaika(dtlmikeikapgaika);
                    siDetailMikeikapBean.setDtlmikeikapnykdenymd(miKeikaPBean.getMkeiPNykDenYmd());
                    siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(miKeikaPBean.getMkeiPHrkKaisuu());
                    siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(miKeikaPBean.getMkeiPJytKaisuuY());
                    siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(miKeikaPBean.getMkeiPJytKaisuuM());
                    siDetailMikeikapBean.setDtlmikeikapjyuutouym(miKeikaPBean.getMkeiPJytYm());

                    siDetailMikeikapBeanLstTemp.add(siDetailMikeikapBean);
                }
            }

            siDetailMisyuupBeanLst = siDetailMisyuupBeanLstTemp;
            siDetailMikeikapBeanLst = siDetailMikeikapBeanLstTemp;


            for (SiDetailMisyuupBean siDetailMisyuupBean : siDetailMisyuupBeanLst) {
                if (BizDateUtil.compareYm(siDetailMisyuupBean.getDtlmisyuupjyuutouym(), kykYmd.getNextYear()
                    .getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
                    if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                        misyuuSyonendoJikaiikouP = misyuuSyonendoJikaiikouP.add(siDetailMisyuupBean.getDtlmisyuup());
                    }
                    else {
                        misyuuSyonendoJikaiikouP = misyuuSyonendoJikaiikouP.add(siDetailMisyuupBean
                            .getDtlmisyuupgaika());
                    }
                }
                else {
                    if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                        misyuuJinendoikouP = misyuuJinendoikouP.add(siDetailMisyuupBean.getDtlmisyuup());
                    }
                    else {
                        misyuuJinendoikouP = misyuuJinendoikouP.add(siDetailMisyuupBean.getDtlmisyuupgaika());
                    }
                }
            }
        }


        KeisanAzukariGanrikin keisanAzukariGanrikin = SWAKInjector.getInstance(KeisanAzukariGanrikin.class);
        keisanAzukariGanrikin.exec(pSiSiharaiKingakuKeisanBean.getSyoNo(),
            pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd(), keiyakuTuukasyu);

        zitkAzukariKingkSiteituuka = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
        zitkAzukariKingkYen = keisanAzukariGanrikin.getAzukariGanrikinYen();



        if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
            krkgk = pSiSiharaiKingakuKeisanBean.getSiKykKihon().getKrkgk();
        }
        else {
            yenkaKrkgk = pSiSiharaiKingakuKeisanBean.getSiKykKihon().getKrkgk();
        }


        BizCurrency hokenKngkGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency hokenKngkYenGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tienrsk = BizCurrency.valueOf(0, currencyType);
        BizDate shiharaiDenpyouDate = null;
        BizCurrency yenKaiyakuhrGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenSbymdKaiyakuhrGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenTutakngkGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenSbymdtutakngkGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenHokenryoustgkGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenNkkknJyutougk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        //        BizCurrency yenNkgns = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        //        BizCurrency yenNknengk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        //        BizCurrency yenBnktnkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenTienrsk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        //        BizCurrency nkhtykeihi = BizCurrency.valueOf(0, currencyType);
        //        BizCurrency yennkhtykeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        CalcHkHtykeihiBean calcHkHtykeihiBean = SWAKInjector.getInstance(CalcHkHtykeihiBean.class);
        calcHkHtykeihiBean.setHtykeihi(BizCurrency.valueOf(0, currencyType));
        calcHkHtykeihiBean.setItjknhtykeihi(BizCurrency.valueOf(0, currencyType));
        calcHkHtykeihiBean.setNkhtykeihi(BizCurrency.valueOf(0, currencyType));

        KeisanTienrisokuBean keisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);
        BizCurrency kihonhokenkngkYenGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency sbhokenkngkYenGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency saigaisYenGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        Boolean siharaizumiKngkSasihikiFlg = false;
        BizCurrency zeimuYenHokenknGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency kyhKngkGoukei = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenKyhKngkGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        for (SiSiDetailParamBean tempSiSiDetailParamBean : siSiDetailParamBeanList) {
            kyhKngkGoukei = kyhKngkGoukei.add(tempSiSiDetailParamBean.getKyhkg());
            yenKyhKngkGoukei = yenKyhKngkGoukei.add(tempSiSiDetailParamBean.getYenkyhgk());
        }

        if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
            hokenKngkGoukei = kyhKngkGoukei.add(haitoukin).add(sonotaHaitoukin).add(zennouSeisanKgk)
                .add(mikeikaP).add(krkgk).subtract(misyuuP);
        }
        else {
            gaikaKnsnTKgk = yenkaHaitoukin
                .add(yenkaSonotaHaitoukin)
                .add(zitkAzukariKingkYen)
                .add(yenkaKrkgk);

            if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                gaikaKnsnTKgk = gaikaKnsnTKgk.add(yenkaZennouSeisanKgk);
            }

            if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                gaikaKnsnTKgk = gaikaKnsnTKgk.add(yenkaMikeikaP);
            }

            if (gaikaKnsnTKgk.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
                keisanGaikakanzan.execDivide(keiyakuTuukasyu, gaikaKnsnTKgk, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
                gaikaKnsnKekkaKgk = keisanGaikakanzan.getKanzanGaku();
            }

            hokenKngkGoukei = kyhKngkGoukei.add(gaikaKnsnKekkaKgk).add(zitkAzukariKingkSiteituuka).subtract(misyuuP);

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                hokenKngkGoukei = hokenKngkGoukei.add(zennouSeisanKgk);
            }

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                hokenKngkGoukei = hokenKngkGoukei.add(mikeikaP);
            }

            if (C_UmuKbn.ARI.eq(syksbyensitihsyutktekiumu)) {
                yenkaKnsnKekkaKgk = yenKyhKngkGoukei;
            } else {

                yenkaKnsnTKgk = kyhKngkGoukei.add(zitkAzukariKingkSiteituuka).subtract(misyuuP);

                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                    yenkaKnsnTKgk = yenkaKnsnTKgk.add(zennouSeisanKgk);
                }

                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                    yenkaKnsnTKgk = yenkaKnsnTKgk.add(mikeikaP);
                }

                if (yenkaKnsnTKgk.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, yenkaKnsnTKgk, kawaseRate, C_HasuusyoriKbn.AGE);
                    yenkaKnsnKekkaKgk = keisanGaikakanzan.getKanzanGaku();
                }
            }

            hokenKngkYenGoukei = yenkaKnsnKekkaKgk
                .add(yenkaHaitoukin)
                .add(yenkaSonotaHaitoukin)
                .add(zitkAzukariKingkYen)
                .add(yenkaKrkgk);

            if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                hokenKngkYenGoukei = hokenKngkYenGoukei.add(yenkaZennouSeisanKgk);
            }

            if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                hokenKngkYenGoukei = hokenKngkYenGoukei.add(yenkaMikeikaP);
            }
        }

        List<JT_Sk> jt_skList = Lists.newArrayList();
        if ((hokenKngkGoukei.compareTo(BizCurrency.valueOf(0, currencyType)) > 0)
            && (C_SaisateiKbn.SAISATEI.eq(pSiSiharaiKingakuKeisanBean.getSaisateiKbn()))) {
            jt_skList = siharaiDomManager.getSksBySyonoItemsSeikyuurirekinoMax(
                pSiSiharaiKingakuKeisanBean.getSyoNo(),
                C_SeikyuuSyubetu.SB,
                C_SaisateiKbn.BLNK,
                C_SyoriJyoutaiKbn.KANRYOU);
            if (jt_skList.size() != 0) {
                if (!C_ShrKekkaKbn.HSHR.eq(jt_skList.get(0).getSkKihon().getShrkekkakbn())) {
                    BizCurrency siharaizumiHokenKngk = jt_skList.get(0).getHokenkngkgoukei();
                    if (hokenKngkGoukei.compareTo(siharaizumiHokenKngk) <= 0) {
                        hokenKngkGoukei = BizCurrency.valueOf(0, currencyType);
                    }
                    else {
                        hokenKngkGoukei = hokenKngkGoukei.subtract(siharaizumiHokenKngk);
                    }
                    siharaizumiKngkSasihikiFlg = true;

                    if ((!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) &&
                        (hokenKngkGoukei.compareTo(BizCurrency.valueOf(0, currencyType)) > 0)) {
                        hokenKngkYenGoukei =
                            keisanGaikakanzan.exec(C_Tuukasyu.JPY, hokenKngkGoukei, kawaseRate, C_HasuusyoriKbn.AGE);
                    }
                    else {
                        hokenKngkYenGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    }
                }
            }
        }

        if (hokenKngkGoukei.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
            if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())
                || C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
                SetteiShrhousiteiKbn setteiShrhousiteiKbn = SWAKInjector.getInstance(SetteiShrhousiteiKbn.class);
                C_ShrhousiteiKbn shrhousiteiKbn = setteiShrhousiteiKbn.exec(
                    pSiSiharaiKingakuKeisanBean.getInputShrhouSiteiKbn(), siharaTuukasyu);

                BzShiharaiDenpyouDateShutoku bzShiharaiDenpyouDateShutoku = SWAKInjector
                    .getInstance(BzShiharaiDenpyouDateShutoku.class);
                shiharaiDenpyouDate = bzShiharaiDenpyouDateShutoku.exec(BizDate.getSysDate(), shrhousiteiKbn,
                    siharaTuukasyu, pSiSiharaiKingakuKeisanBean.getBankCd());

                if (!C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pSiSiharaiKingakuKeisanBean.getInputShrhouSiteiKbn())) {
                    KeisanTienrisoku keisanTienrisoku = SWAKInjector.getInstance(KeisanTienrisoku.class);
                    BizCurrency siharaGoukeiKngk;
                    if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
                        siharaGoukeiKngk = hokenKngkGoukei;
                    }
                    else {
                        siharaGoukeiKngk = hokenKngkGoukei.subtract(pSiSiharaiKingakuKeisanBean.getNkKknJyutouGk());
                    }
                    Integer wkRikoukiTyuutuudanNissuu = 0;
                    if (pSiSiharaiKingakuKeisanBean.getRikoukiTyuutuudanNissuu() != null) {
                        wkRikoukiTyuutuudanNissuu = pSiSiharaiKingakuKeisanBean.getRikoukiTyuutuudanNissuu();
                    }
                    keisanTienrisokuBean = keisanTienrisoku.exec(
                        pSiSiharaiKingakuKeisanBean.getSyoruiUkeYmd(), pSiSiharaiKingakuKeisanBean.getHubiKanryouYmd(),
                        shiharaiDenpyouDate, siharaGoukeiKngk, wkRikoukiTyuutuudanNissuu,
                        pSiSiharaiKingakuKeisanBean.getSinsaGendoKknKbn());
                    tienrsk = keisanTienrisokuBean.getShrtienrsk();
                }
            }
            CalcHkHtykeihi calcHkHtykeihi = SWAKInjector.getInstance(CalcHkHtykeihi.class);
            calcHkHtykeihiBean = calcHkHtykeihi.exec(pSiSiharaiKingakuKeisanBean.getSyoNo(),
                keiyakuTuukasyu, pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn(), hokenKngkGoukei,
                hokenKngkYenGoukei, pSiSiharaiKingakuKeisanBean.getNkKknJyutouGk(), yenNkkknJyutougk,
                misyuuptekikawaserate, misyuuP);
            //            nkhtykeihi = calcHkHtykeihiBean.getNkhtykeihi();
            //            yennkhtykeihi = calcHkHtykeihiBean.getYennkhtykeihi();
        }

        if ((hokenKngkGoukei.compareTo(BizCurrency.valueOf(0, currencyType)) > 0)
            || ((hokenKngkGoukei.compareTo(BizCurrency.valueOf(0, currencyType)) == 0) && (siharaizumiKngkSasihikiFlg))) {
            if (!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                KeisanGaikakanzan yenKeisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                yenKaiyakuhrGoukei = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, kaiyakuhrGoukei,
                    kawaseRate, C_HasuusyoriKbn.AGE);

                yenSbymdKaiyakuhrGoukei = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, sbymdKaiyakuhrGoukei,
                    kawaseRate, C_HasuusyoriKbn.AGE);

                yenTutakngkGoukei = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, tutakngkGoukei,
                    kawaseRate, C_HasuusyoriKbn.AGE);

                yenSbymdtutakngkGoukei = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, sbymdTutakngkGoukei,
                    kawaseRate, C_HasuusyoriKbn.AGE);

                yenHokenryoustgkGoukei = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, hokenryoustgkGoukei,
                    kawaseRate, C_HasuusyoriKbn.AGE);

                yenNkkknJyutougk = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    pSiSiharaiKingakuKeisanBean.getNkKknJyutouGk(),
                    kawaseRate, C_HasuusyoriKbn.AGE);

                kihonhokenkngkYenGoukei = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, kihonhokenkngkGoukei,
                    kawaseRate, C_HasuusyoriKbn.AGE);

                sbhokenkngkYenGoukei = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, sbhokenkngkGoukei,
                    kawaseRate, C_HasuusyoriKbn.AGE);

                saigaisYenGoukei = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, saigaisGoukei,
                    kawaseRate, C_HasuusyoriKbn.AGE);

                if (!C_SeikyuusyaKbn.BLNK.eq(pSiSiharaiKingakuKeisanBean.getSeikyuusyaKbn())) {
                    if (C_SiharaiTuukaKbn.YENSIHARAI.eq(pSiSiharaiKingakuKeisanBean.getSiharaiTuukaKbn())) {
                        zeimuYenHokenknGk = hokenKngkYenGoukei;
                    }
                    else {
                        zeimuYenHokenknGk = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, hokenKngkGoukei,
                            zeimukwsrate, C_HasuusyoriKbn.SUTE);
                    }
                }

                keisanGaikakanzan.exec(C_Tuukasyu.JPY, misyuuP, kawaseRate, C_HasuusyoriKbn.AGE);

                yenkaMisyuuP = keisanGaikakanzan.getKanzanGaku();

                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                    yenkaMikeikaP = yenKeisanGaikakanzan
                        .exec(C_Tuukasyu.JPY, mikeikaP, kawaseRate, C_HasuusyoriKbn.AGE);
                }

                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                    yenkaZennouSeisanKgk = yenKeisanGaikakanzan.exec(C_Tuukasyu.JPY, zennouSeisanKgk, kawaseRate,
                        C_HasuusyoriKbn.AGE);
                }

                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                    keisanGaikakanzan.execDivide(keiyakuTuukasyu, yenkaMikeikaP, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);

                    mikeikaP = keisanGaikakanzan.getKanzanGaku();
                }

                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                    keisanGaikakanzan.execDivide(keiyakuTuukasyu, yenkaZennouSeisanKgk, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);

                    zennouSeisanKgk = keisanGaikakanzan.getKanzanGaku();
                }

                keisanGaikakanzan.execDivide(keiyakuTuukasyu, yenkaHaitoukin, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);

                haitoukin = keisanGaikakanzan.getKanzanGaku();

                keisanGaikakanzan.execDivide(keiyakuTuukasyu, yenkaSonotaHaitoukin, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);

                sonotaHaitoukin = keisanGaikakanzan.getKanzanGaku();

                keisanGaikakanzan.execDivide(keiyakuTuukasyu, yenkaKrkgk, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);

                krkgk = keisanGaikakanzan.getKanzanGaku();

                keisanGaikakanzan.execDivide(keiyakuTuukasyu, zitkAzukariKingkYen, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);

                gaikaknsnZitkAzukariKingkYen = keisanGaikakanzan.getKanzanGaku();
                azukariKingk = zitkAzukariKingkSiteituuka.add(keisanGaikakanzan.getKanzanGaku());

                keisanGaikakanzan.exec(C_Tuukasyu.JPY, zitkAzukariKingkSiteituuka, kawaseRate, C_HasuusyoriKbn.AGE);

                yenZitkAzukariKingkSttk = keisanGaikakanzan.getKanzanGaku();
                yenkaAzukariKingk = zitkAzukariKingkYen.add(keisanGaikakanzan.getKanzanGaku());
            }
        }

        if (hokenKngkYenGoukei.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
            if (!C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pSiSiharaiKingakuKeisanBean.getInputShrhouSiteiKbn())) {
                if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())
                    || C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
                    KeisanTienrisoku keisanTienrisoku = SWAKInjector.getInstance(KeisanTienrisoku.class);
                    BizCurrency siharaGoukeiKngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
                        siharaGoukeiKngk = hokenKngkYenGoukei;
                    }
                    else {
                        siharaGoukeiKngk = hokenKngkYenGoukei.subtract(yenNkkknJyutougk);
                    }

                    Integer wkRikoukiTyuutuudanNissuu = 0;
                    if (pSiSiharaiKingakuKeisanBean.getRikoukiTyuutuudanNissuu() != null) {
                        wkRikoukiTyuutuudanNissuu = pSiSiharaiKingakuKeisanBean.getRikoukiTyuutuudanNissuu();
                    }
                    keisanTienrisokuBean = keisanTienrisoku.exec(
                        pSiSiharaiKingakuKeisanBean.getSyoruiUkeYmd(), pSiSiharaiKingakuKeisanBean.getHubiKanryouYmd(),
                        shiharaiDenpyouDate, siharaGoukeiKngk, wkRikoukiTyuutuudanNissuu,
                        pSiSiharaiKingakuKeisanBean.getSinsaGendoKknKbn());
                    yenTienrsk = keisanTienrisokuBean.getShrtienrsk();

                    if (C_Tuukasyu.JPY.eq(siharaTuukasyu)) {
                        KeisanGaikakanzan kykTuukaKeisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        tienrsk = kykTuukaKeisanGaikakanzan.execDivide(keiyakuTuukasyu, yenTienrsk, kawaseRate,
                            C_HasuusyoriKbn.SSYGNY);
                    }
                }
            }
        }

        BizCurrency shrgkGoukei = hokenKngkGoukei.add(tienrsk);
        BizCurrency yenkaShrgkGoukei = hokenKngkYenGoukei.add(yenTienrsk);

        BizCurrency bunkatugoHokenKngk = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenHokenKngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoHaitoukin = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaHaitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoSonotaHaitoukin = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaSonotaHaitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoMisyuuP = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaMisyuuP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoMikeikaP = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaMikeikaP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoZennouSeisanK = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaZennouSeisanK = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoAzukariKingk = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaAzukariKingk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoKrkgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaKrkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugogoukeigk = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoyenkagoukeigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoZitkazukarikingksiteituuka = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoZitkazukarikingkyen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoGaikaknsntskgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency bunkatugoGaikaknsnkkkgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaknsntskgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency bunkatugoYenkaknsnkkkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (kyhKngkGoukei.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
            bunkatugoHokenKngk = sihknknuktbnwariHanei(kyhKngkGoukei,
                pSiSiharaiKingakuKeisanBean.getUktBnWari(), pSiSiharaiKingakuKeisanBean.getHasuuKasanHyouji());
        }

        if (!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
            if (C_UmuKbn.ARI.eq(syksbyensitihsyutktekiumu)) {
                bunkatugoYenHokenKngk = sihknknuktbnwariHanei(yenKyhKngkGoukei,
                    pSiSiharaiKingakuKeisanBean.getUktBnWari(), pSiSiharaiKingakuKeisanBean.getHasuuKasanHyouji());
            } else {
                if (bunkatugoHokenKngk.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
                    bunkatugoYenHokenKngk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, bunkatugoHokenKngk, kawaseRate,
                        C_HasuusyoriKbn.AGE);
                }
            }
        }

        HashMap<String, BizCurrency> haitoukinMap = bunkatuEnkaKanri(haitoukin, yenkaHaitoukin, keiyakuTuukasyu,
            currencyType, pSiSiharaiKingakuKeisanBean.getUktBnWari(), gaikaknsnKwsrate);
        bunkatugoHaitoukin = haitoukinMap.get(KEY_SITEITUUKA);
        bunkatugoYenkaHaitoukin = haitoukinMap.get(KWY_ENKA);

        HashMap<String, BizCurrency> sonotaHaitoukinMap = bunkatuEnkaKanri(sonotaHaitoukin, yenkaSonotaHaitoukin,
            keiyakuTuukasyu, currencyType, pSiSiharaiKingakuKeisanBean.getUktBnWari(), gaikaknsnKwsrate);
        bunkatugoSonotaHaitoukin = sonotaHaitoukinMap.get(KEY_SITEITUUKA);
        bunkatugoYenkaSonotaHaitoukin = sonotaHaitoukinMap.get(KWY_ENKA);

        if (misyuuP.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
            bunkatugoMisyuuP = sihknknuktbnwariHanei(misyuuP,
                pSiSiharaiKingakuKeisanBean.getUktBnWari(), C_HasuukasanUmuKbn.HASUUKASANNASI);
        }

        if (!C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
            if (bunkatugoMisyuuP.compareTo(BizCurrency.valueOf(0, bunkatugoMisyuuP.getType())) > 0) {
                bunkatugoYenkaMisyuuP = keisanGaikakanzan.exec(C_Tuukasyu.JPY, bunkatugoMisyuuP, kawaseRate,
                    C_HasuusyoriKbn.AGE);
            }
        }

        HashMap<String, BizCurrency> mikeikaPMap = bunkatuTekiyou(mikeikaP, yenkaMikeikaP, keiyakuTuukasyu,
            currencyType, siSyouhnZokusei.getMikeikapknrtuukakbn(), pSiSiharaiKingakuKeisanBean.getUktBnWari(),
            kawaseRate, gaikaknsnKwsrate);
        bunkatugoMikeikaP = mikeikaPMap.get(KEY_SITEITUUKA);
        bunkatugoYenkaMikeikaP = mikeikaPMap.get(KWY_ENKA);

        HashMap<String, BizCurrency> zennouSeisanKgkMap = bunkatuTekiyou(zennouSeisanKgk, yenkaZennouSeisanKgk,
            keiyakuTuukasyu, currencyType, siSyouhnZokusei.getZnnusisnkinknrtuukakbn(),
            pSiSiharaiKingakuKeisanBean.getUktBnWari(), kawaseRate, gaikaknsnKwsrate);
        bunkatugoZennouSeisanK = zennouSeisanKgkMap.get(KEY_SITEITUUKA);
        bunkatugoYenkaZennouSeisanK = zennouSeisanKgkMap.get(KWY_ENKA);

        if (zitkAzukariKingkSiteituuka.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
            bunkatugoZitkazukarikingksiteituuka = sihknknuktbnwariHanei(zitkAzukariKingkSiteituuka,
                pSiSiharaiKingakuKeisanBean.getUktBnWari(), C_HasuukasanUmuKbn.HASUUKASANNASI);
        }

        if (zitkAzukariKingkYen.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
            bunkatugoZitkazukarikingkyen = sihknknuktbnwariHanei(zitkAzukariKingkYen,
                pSiSiharaiKingakuKeisanBean.getUktBnWari(), C_HasuukasanUmuKbn.HASUUKASANNASI);
        }

        if (bunkatugoZitkazukarikingkyen.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
            BizCurrency gaikaGk = keisanGaikakanzan.execDivide(keiyakuTuukasyu, bunkatugoZitkazukarikingkyen,
                gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
            bunkatugoAzukariKingk = bunkatugoZitkazukarikingksiteituuka.add(gaikaGk);
        } else {
            bunkatugoAzukariKingk = bunkatugoZitkazukarikingksiteituuka;
        }

        if (bunkatugoZitkazukarikingksiteituuka.compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
            BizCurrency enkaGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, bunkatugoZitkazukarikingksiteituuka,
                kawaseRate, C_HasuusyoriKbn.AGE);
            bunkatugoYenkaAzukariKingk = bunkatugoZitkazukarikingkyen.add(enkaGk);
        } else {
            bunkatugoYenkaAzukariKingk = bunkatugoZitkazukarikingkyen;
        }

        HashMap<String, BizCurrency> KrkgkMap = bunkatuEnkaKanri(krkgk, yenkaKrkgk, keiyakuTuukasyu, currencyType,
            pSiSiharaiKingakuKeisanBean.getUktBnWari(), gaikaknsnKwsrate);
        bunkatugoKrkgk = KrkgkMap.get(KEY_SITEITUUKA);
        bunkatugoYenkaKrkgk = KrkgkMap.get(KWY_ENKA);

        if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
            bunkatugogoukeigk = bunkatugoHokenKngk
                .add(bunkatugoHaitoukin)
                .add(bunkatugoSonotaHaitoukin)
                .add(bunkatugoZennouSeisanK)
                .add(bunkatugoMikeikaP)
                .add(bunkatugoKrkgk)
                .subtract(bunkatugoMisyuuP);
        } else {
            bunkatugoGaikaknsntskgk = bunkatugoYenkaHaitoukin
                .add(bunkatugoYenkaSonotaHaitoukin)
                .add(bunkatugoZitkazukarikingkyen)
                .add(bunkatugoYenkaKrkgk);

            if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                bunkatugoGaikaknsntskgk = bunkatugoGaikaknsntskgk.add(bunkatugoYenkaZennouSeisanK);
            }

            if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                bunkatugoGaikaknsntskgk = bunkatugoGaikaknsntskgk.add(bunkatugoYenkaMikeikaP);
            }

            if (bunkatugoGaikaknsntskgk.compareTo(BizCurrency.valueOf(0, bunkatugoGaikaknsntskgk.getType())) > 0) {
                bunkatugoGaikaknsnkkkgk = keisanGaikakanzan.execDivide(keiyakuTuukasyu, bunkatugoGaikaknsntskgk, gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
            }

            bunkatugogoukeigk = bunkatugoHokenKngk
                .add(bunkatugoGaikaknsnkkkgk)
                .add(bunkatugoZitkazukarikingksiteituuka)
                .subtract(bunkatugoMisyuuP);

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                bunkatugogoukeigk = bunkatugogoukeigk.add(bunkatugoZennouSeisanK);
            }

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                bunkatugogoukeigk = bunkatugogoukeigk.add(bunkatugoMikeikaP);
            }

        }

        if (C_UmuKbn.ARI.eq(syksbyensitihsyutktekiumu)) {
            bunkatugoYenkaknsnkkkgk = bunkatugoYenHokenKngk;
        } else {
            bunkatugoYenkaknsntskgk = bunkatugoHokenKngk
                .add(bunkatugoZitkazukarikingksiteituuka)
                .subtract(bunkatugoMisyuuP);

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                bunkatugoYenkaknsntskgk = bunkatugoYenkaknsntskgk.add(bunkatugoZennouSeisanK);
            }

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                bunkatugoYenkaknsntskgk = bunkatugoYenkaknsntskgk.add(bunkatugoMikeikaP);
            }

            if (bunkatugoYenkaknsntskgk.compareTo(BizCurrency.valueOf(0, bunkatugoYenkaknsntskgk.getType())) > 0) {
                bunkatugoYenkaknsnkkkgk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, bunkatugoYenkaknsntskgk, kawaseRate,
                    C_HasuusyoriKbn.AGE);
            }
        }
        bunkatugoyenkagoukeigk = bunkatugoYenkaknsnkkkgk
            .add(bunkatugoYenkaHaitoukin)
            .add(bunkatugoYenkaSonotaHaitoukin)
            .add(bunkatugoZitkazukarikingkyen)
            .add(bunkatugoYenkaKrkgk);

        if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
            bunkatugoyenkagoukeigk = bunkatugoyenkagoukeigk.add(bunkatugoYenkaZennouSeisanK);
        }

        if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
            bunkatugoyenkagoukeigk = bunkatugoyenkagoukeigk.add(bunkatugoYenkaMikeikaP);
        }

        //        if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())
        //            || C_SUketoriHouhouKbn.ITIBU_NENKIN
        //            .eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
        //            BizCurrency teinkkikingkgaika = BizCurrency.valueOf(0, currencyType);
        //            BizCurrency teinkkikingken = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        //            if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
        //                teinkkikingkgaika = hokenKngkGoukei;
        //                teinkkikingken = hokenKngkYenGoukei;
        //            }
        //            else if (C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
        //                teinkkikingkgaika = pSiSiharaiKingakuKeisanBean.getNkKknJyutouGk();
        //                teinkkikingken = yenNkkknJyutougk;
        //            }
        //
        //            tempSiNenkinInfoBean.setNkshrtkyknksyukbn(pSiSiharaiKingakuKeisanBean.getNkShrTkykNksyuKbn());
        //            tempSiNenkinInfoBean.setNkshrtkyknksyukkn(pSiSiharaiKingakuKeisanBean.getNkShrTkykNksyuKkn());
        //            tempSiNenkinInfoBean.setBnshrkaisuu(pSiSiharaiKingakuKeisanBean.getBnShrKaisuu());
        //            tempSiNenkinInfoBean.setNkhaitoukinuketorihoukbn(pSiSiharaiKingakuKeisanBean.getNkHaitoukinuketorihouKbn());
        //            tempSiNenkinInfoBean.setTeinkkikingkgaika(teinkkikingkgaika);
        //            tempSiNenkinInfoBean.setTeinkkikingken(teinkkikingken);
        //            tempSiNenkinInfoBean.setHtykeihi(nkhtykeihi);
        //            tempSiNenkinInfoBean.setYenhtykeihi(yennkhtykeihi);
        //        }

        if ((hokenKngkGoukei.compareTo(BizCurrency.valueOf(0, currencyType)) == 0) && (!siharaizumiKngkSasihikiFlg)) {
            tempSiHkkingakuSisanParamBean.setSUketoriHouhouKbn(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn());
            tempSiHkkingakuSisanParamBean.setCalcKijyunYmd(pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd());
            tempSiHkkingakuSisanParamBean.setKnsnKijyunYmd(knsnKijyunYmd);
            tempSiHkkingakuSisanParamBean.setKawaseRate(kawaseRate);
            tempSiHkkingakuSisanParamBean.setUktBnWari(pSiSiharaiKingakuKeisanBean.getUktBnWari());
            tempSiHkkingakuSisanParamBean.setHokenknGk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenHokenknGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setNkKknSetYmd(null);
            tempSiHkkingakuSisanParamBean.setNkShrStartYmd(null);
            tempSiHkkingakuSisanParamBean.setNkShrTkykNksyuKbn(pSiSiharaiKingakuKeisanBean.getNkShrTkykNksyuKbn());
            tempSiHkkingakuSisanParamBean.setNkShrTkykNksyuKkn(pSiSiharaiKingakuKeisanBean.getNkShrTkykNksyuKkn());
            tempSiHkkingakuSisanParamBean.setBnShrKaisuu(pSiSiharaiKingakuKeisanBean.getBnShrKaisuu());
            tempSiHkkingakuSisanParamBean.setNkKknJyutouGk(pSiSiharaiKingakuKeisanBean.getNkKknJyutouGk());
            tempSiHkkingakuSisanParamBean.setYenNkKknJyutouGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setTienRsk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenTienRsk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setNkGns(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenNkGns(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setNkNengk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenNkNengk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBnktnkGk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenBnktnkGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setHtyKeihi(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenHtyKeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setNkHtyKeihi(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenNkhtyKeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setItjknhtyKeihi(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenItjknhtyKeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setShrkykhtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setKaiyakuHr(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenKaiyakuHr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setTutaknGk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenTutaknGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setSbymdTmttKnGk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenSbymdTmttKnGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setHokenryoustGk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenHokenryoustGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setPruikei(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setTienRisokuKisanYmd(null);
            tempSiHkkingakuSisanParamBean.setTienRisokuSyuryouYmd(null);
            tempSiHkkingakuSisanParamBean.setTienRskNissuu(0);
            tempSiHkkingakuSisanParamBean.setShrYmd(null);
            tempSiHkkingakuSisanParamBean.setKykTuukasyu(keiyakuTuukasyu);
            tempSiHkkingakuSisanParamBean.setShrTuukasyu(C_Tuukasyu.BLNK);
            tempSiHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setHokenkinsyuruiKbn(C_HokenkinsyuruiKbn.BLNK);
            tempSiHkkingakuSisanParamBean.setHokenkinsyurui(hokenkinsyurui);
            tempSiHkkingakuSisanParamBean.setHknKknKbn(C_HknKknKbn.BLNK);
            tempSiHkkingakuSisanParamBean.setKihonHokenKngk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenKihonHokenKngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setSbHokenKngk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenSbHokenKngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setSaigaiS(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenSaigaiS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setSykSbYenSitiHsyuTkTekiUmu(C_UmuKbn.NONE);
            tempSiHkkingakuSisanParamBean.setInitSbjiYenkasSiteiHsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setUktKyksyaTdk(C_UktKyksyaTdk.BLNK);
            tempSiHkkingakuSisanParamBean.setZeimukwsratekjnymd(null);
            tempSiHkkingakuSisanParamBean.setZeimukwsrate(BizNumber.valueOf(0));
            tempSiHkkingakuSisanParamBean.setZeimuYenHokenknGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setGaikaknsnkwsrate(gaikaknsnKwsrate);
            tempSiHkkingakuSisanParamBean.setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn.BLNK);
            tempSiHkkingakuSisanParamBean.setHaitoukin(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkahaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setSonotahaitoukin(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkasonotahaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(0);
            tempSiHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(0);
            tempSiHkkingakuSisanParamBean.setMisyuupjyuutouym(null);
            tempSiHkkingakuSisanParamBean.setMisyuup(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkamisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(0);
            tempSiHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(0);
            tempSiHkkingakuSisanParamBean.setMikeikapjyuutouym(null);
            tempSiHkkingakuSisanParamBean.setMikeikap(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkamikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setZennouseisank(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkazennouseisank(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setAzukarikingk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkaazukarikingk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenzitkazukarikingksttk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setZitkazukarikingkyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setGaikaknsnzitkazukarikingkyen(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setSonotaseisangk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkasonotaseisangk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setKrkgk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkakrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setShrgkkei(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkashrgkgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setGaikaknsntskgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setGaikaknsnkkkgk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkaknsntskgk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkaknsnkkkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setMisyuusyonendojikaiikoup(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setMisyuujinendoikoup(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugoazukarikingk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkaazukarikingk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugogoukeigk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkagoukeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        }
        else {
            BizCurrency nkkknJyutougk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenNkkknJyutougkSet = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
                nkkknJyutougk = hokenKngkGoukei;
                yenNkkknJyutougkSet = hokenKngkYenGoukei;
            }
            else {
                nkkknJyutougk = pSiSiharaiKingakuKeisanBean.getNkKknJyutouGk();
                yenNkkknJyutougkSet = yenNkkknJyutougk;
            }
            tempSiHkkingakuSisanParamBean.setSUketoriHouhouKbn(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn());
            tempSiHkkingakuSisanParamBean.setCalcKijyunYmd(pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd());
            tempSiHkkingakuSisanParamBean.setKnsnKijyunYmd(knsnKijyunYmd);
            tempSiHkkingakuSisanParamBean.setKawaseRate(kawaseRate);
            tempSiHkkingakuSisanParamBean.setUktBnWari(pSiSiharaiKingakuKeisanBean.getUktBnWari());
            tempSiHkkingakuSisanParamBean.setHokenknGk(kyhKngkGoukei);
            tempSiHkkingakuSisanParamBean.setYenHokenknGk(yenKyhKngkGoukei);
            tempSiHkkingakuSisanParamBean.setNkKknSetYmd(null);
            tempSiHkkingakuSisanParamBean.setNkShrStartYmd(null);
            tempSiHkkingakuSisanParamBean.setNkShrTkykNksyuKbn(pSiSiharaiKingakuKeisanBean.getNkShrTkykNksyuKbn());
            tempSiHkkingakuSisanParamBean.setNkShrTkykNksyuKkn(pSiSiharaiKingakuKeisanBean.getNkShrTkykNksyuKkn());
            tempSiHkkingakuSisanParamBean.setBnShrKaisuu(pSiSiharaiKingakuKeisanBean.getBnShrKaisuu());
            tempSiHkkingakuSisanParamBean.setNkKknJyutouGk(nkkknJyutougk);
            tempSiHkkingakuSisanParamBean.setYenNkKknJyutouGk(yenNkkknJyutougkSet);
            tempSiHkkingakuSisanParamBean.setTienRsk(tienrsk);
            tempSiHkkingakuSisanParamBean.setYenTienRsk(yenTienrsk);
            tempSiHkkingakuSisanParamBean.setNkGns(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenNkGns(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setNkNengk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenNkNengk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setBnktnkGk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenBnktnkGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setHtyKeihi(calcHkHtykeihiBean.getHtykeihi());
            tempSiHkkingakuSisanParamBean.setYenHtyKeihi(calcHkHtykeihiBean.getYenhtykeihi());
            tempSiHkkingakuSisanParamBean.setNkHtyKeihi(calcHkHtykeihiBean.getNkhtykeihi());
            tempSiHkkingakuSisanParamBean.setYenNkhtyKeihi(calcHkHtykeihiBean.getYennkhtykeihi());
            tempSiHkkingakuSisanParamBean.setItjknhtyKeihi(calcHkHtykeihiBean.getItjknhtykeihi());
            tempSiHkkingakuSisanParamBean.setYenItjknhtyKeihi(calcHkHtykeihiBean.getYenitjknhtykeihi());
            tempSiHkkingakuSisanParamBean.setShrkykhtykeihi(calcHkHtykeihiBean.getShrkykhtykeihi());
            tempSiHkkingakuSisanParamBean.setKaiyakuHr(kaiyakuhrGoukei);
            tempSiHkkingakuSisanParamBean.setYenKaiyakuHr(yenKaiyakuhrGoukei);
            tempSiHkkingakuSisanParamBean.setSbymdKaiyakuhenreiknGk(sbymdKaiyakuhrGoukei);
            tempSiHkkingakuSisanParamBean.setYenSbymdKaiyakuhenreiknGk(yenSbymdKaiyakuhrGoukei);
            tempSiHkkingakuSisanParamBean.setTutaknGk(tutakngkGoukei);
            tempSiHkkingakuSisanParamBean.setYenTutaknGk(yenTutakngkGoukei);
            tempSiHkkingakuSisanParamBean.setSbymdTmttKnGk(sbymdTutakngkGoukei);
            tempSiHkkingakuSisanParamBean.setYenSbymdTmttKnGk(yenSbymdtutakngkGoukei);
            tempSiHkkingakuSisanParamBean.setHokenryoustGk(hokenryoustgkGoukei);
            tempSiHkkingakuSisanParamBean.setYenHokenryoustGk(yenHokenryoustgkGoukei);
            tempSiHkkingakuSisanParamBean.setPruikei(pruikei);
            tempSiHkkingakuSisanParamBean.setTienRisokuKisanYmd(keisanTienrisokuBean.getShrtienrskStartYmd());
            tempSiHkkingakuSisanParamBean.setTienRisokuSyuryouYmd(keisanTienrisokuBean.getShrtienrskEndYmd());
            tempSiHkkingakuSisanParamBean.setTienRskNissuu(keisanTienrisokuBean.getShrtienNissuu());
            tempSiHkkingakuSisanParamBean.setShrYmd(shiharaiDenpyouDate);
            tempSiHkkingakuSisanParamBean.setKykTuukasyu(keiyakuTuukasyu);
            tempSiHkkingakuSisanParamBean.setShrTuukasyu(siharaTuukasyu);
            tempSiHkkingakuSisanParamBean.setBunkatugoHokenKngk(bunkatugoHokenKngk);
            tempSiHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(bunkatugoYenHokenKngk);
            tempSiHkkingakuSisanParamBean.setHokenkinsyuruiKbn(hokenkinsyuruikbn);
            tempSiHkkingakuSisanParamBean.setHokenkinsyurui(hokenkinsyurui);
            tempSiHkkingakuSisanParamBean.setHknKknKbn(hknkknkbn);
            tempSiHkkingakuSisanParamBean.setKihonHokenKngk(kihonhokenkngkGoukei);
            tempSiHkkingakuSisanParamBean.setYenKihonHokenKngk(kihonhokenkngkYenGoukei);
            tempSiHkkingakuSisanParamBean.setSbHokenKngk(sbhokenkngkGoukei);
            tempSiHkkingakuSisanParamBean.setYenSbHokenKngk(sbhokenkngkYenGoukei);
            tempSiHkkingakuSisanParamBean.setSaigaiS(saigaisGoukei);
            tempSiHkkingakuSisanParamBean.setYenSaigaiS(saigaisYenGoukei);
            tempSiHkkingakuSisanParamBean.setSykSbYenSitiHsyuTkTekiUmu(syksbyensitihsyutktekiumu);
            tempSiHkkingakuSisanParamBean.setInitSbjiYenkasSiteiHsygk(pSiSiharaiKingakuKeisanBean.getSiKykKihon()
                .getInitsbjiyenkasaiteihsygk());
            tempSiHkkingakuSisanParamBean.setUktKyksyaTdk(uktKyksyaTdk);
            tempSiHkkingakuSisanParamBean.setZeimukwsratekjnymd(zeimukwsratekjnymd);
            tempSiHkkingakuSisanParamBean.setZeimukwsrate(zeimukwsrate);
            tempSiHkkingakuSisanParamBean.setZeimuYenHokenknGk(zeimuYenHokenknGk);
            tempSiHkkingakuSisanParamBean.setGaikaknsnkwsrate(gaikaknsnKwsrate);
            tempSiHkkingakuSisanParamBean.setVhtnaiteikakuteikbn(naiteikakuteikbn);
            tempSiHkkingakuSisanParamBean.setHaitoukin(haitoukin);
            tempSiHkkingakuSisanParamBean.setYenkahaitoukin(yenkaHaitoukin);
            tempSiHkkingakuSisanParamBean.setSonotahaitoukin(sonotaHaitoukin);
            tempSiHkkingakuSisanParamBean.setYenkasonotahaitoukin(yenkaSonotaHaitoukin);
            tempSiHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(misyuupJyuutoukaisuuY);
            tempSiHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(misyuupJyuutoukaisuuM);
            tempSiHkkingakuSisanParamBean.setMisyuupjyuutouym(misyuupJyuutouYm);
            tempSiHkkingakuSisanParamBean.setMisyuup(misyuuP);
            tempSiHkkingakuSisanParamBean.setYenkamisyuup(yenkaMisyuuP);
            tempSiHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(mikeikapJyuutoukaisuuY);
            tempSiHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(mikeikapJyuutoukaisuuM);
            tempSiHkkingakuSisanParamBean.setMikeikapjyuutouym(mikeikapJyuutouYm);
            tempSiHkkingakuSisanParamBean.setMikeikap(mikeikaP);
            tempSiHkkingakuSisanParamBean.setYenkamikeikap(yenkaMikeikaP);
            tempSiHkkingakuSisanParamBean.setZennouseisank(zennouSeisanKgk);
            tempSiHkkingakuSisanParamBean.setYenkazennouseisank(yenkaZennouSeisanKgk);
            tempSiHkkingakuSisanParamBean.setAzukarikingk(azukariKingk);
            tempSiHkkingakuSisanParamBean.setYenkaazukarikingk(yenkaAzukariKingk);
            tempSiHkkingakuSisanParamBean.setZitkazukarikingksiteituuka(zitkAzukariKingkSiteituuka);
            tempSiHkkingakuSisanParamBean.setYenzitkazukarikingksttk(yenZitkAzukariKingkSttk);
            tempSiHkkingakuSisanParamBean.setZitkazukarikingkyen(zitkAzukariKingkYen);
            tempSiHkkingakuSisanParamBean.setGaikaknsnzitkazukarikingkyen(gaikaknsnZitkAzukariKingkYen);
            tempSiHkkingakuSisanParamBean.setSonotaseisangk(BizCurrency.valueOf(0, currencyType));
            tempSiHkkingakuSisanParamBean.setYenkasonotaseisangk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            tempSiHkkingakuSisanParamBean.setKrkgk(krkgk);
            tempSiHkkingakuSisanParamBean.setYenkakrkgk(yenkaKrkgk);
            tempSiHkkingakuSisanParamBean.setShrgkkei(shrgkGoukei);
            tempSiHkkingakuSisanParamBean.setYenkashrgkgoukei(yenkaShrgkGoukei);
            tempSiHkkingakuSisanParamBean.setGaikaknsntskgk(gaikaKnsnTKgk);
            tempSiHkkingakuSisanParamBean.setGaikaknsnkkkgk(gaikaKnsnKekkaKgk);
            tempSiHkkingakuSisanParamBean.setYenkaknsntskgk(yenkaKnsnTKgk);
            tempSiHkkingakuSisanParamBean.setYenkaknsnkkkgk(yenkaKnsnKekkaKgk);
            tempSiHkkingakuSisanParamBean.setMisyuusyonendojikaiikoup(misyuuSyonendoJikaiikouP);
            tempSiHkkingakuSisanParamBean.setMisyuujinendoikoup(misyuuJinendoikouP);
            tempSiHkkingakuSisanParamBean.setBunkatugohaitoukin(bunkatugoHaitoukin);
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(bunkatugoYenkaHaitoukin);
            tempSiHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(bunkatugoSonotaHaitoukin);
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(bunkatugoYenkaSonotaHaitoukin);
            tempSiHkkingakuSisanParamBean.setBunkatugomisyuup(bunkatugoMisyuuP);
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(bunkatugoYenkaMisyuuP);
            tempSiHkkingakuSisanParamBean.setBunkatugomikeikap(bunkatugoMikeikaP);
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(bunkatugoYenkaMikeikaP);
            tempSiHkkingakuSisanParamBean.setBunkatugozennouseisank(bunkatugoZennouSeisanK);
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(bunkatugoYenkaZennouSeisanK);
            tempSiHkkingakuSisanParamBean.setBunkatugoazukarikingk(bunkatugoAzukariKingk);
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkaazukarikingk(bunkatugoYenkaAzukariKingk);
            tempSiHkkingakuSisanParamBean.setBunkatugokrkgk(bunkatugoKrkgk);
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(bunkatugoYenkaKrkgk);
            tempSiHkkingakuSisanParamBean.setBunkatugogoukeigk(bunkatugogoukeigk);
            tempSiHkkingakuSisanParamBean.setBunkatugoyenkagoukeigk(bunkatugoyenkagoukeigk);
            tempSiHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(bunkatugoZitkazukarikingksiteituuka);
            tempSiHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(bunkatugoZitkazukarikingkyen);
            tempSiHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(bunkatugoGaikaknsntskgk);
            tempSiHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(bunkatugoGaikaknsnkkkgk);
            tempSiHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(bunkatugoYenkaknsntskgk);
            tempSiHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(bunkatugoYenkaknsnkkkgk);
        }


        List<ChkKekkaBean> chkKekkaBeanList = new ArrayList<>();
        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getCalcsyoruiukeymdcheck())) {
            if (tempSiHkkingakuSisanParamBean.getTienRsk().compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
                ChkKekkaBean syoruiukeChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                syoruiukeChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SYORUIUKEYMD_TIENRSKCHK);
                chkKekkaBeanList.add(syoruiukeChkKekkaBean);
            }
        }
        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getCalchonninkakunincheck())) {
            if (C_SiHonninKakninKekkaKbn.KOUZA.eq(pSiSiharaiKingakuKeisanBean.getSiHonninKakninKbn())) {
                BizCurrency hokenKngk = BizCurrency.valueOf(0);

                if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
                    hokenKngk = tempSiHkkingakuSisanParamBean.getHokenknGk();
                }
                else {
                    hokenKngk = tempSiHkkingakuSisanParamBean.getYenHokenknGk();
                }
                if (hokenKngk.compareTo(YuyuSiharaiConfig.getInstance().getSzkSyomeiHuyouSaikouGk()) > 0) {
                    ChkKekkaBean honninChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    honninChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HONNINKAKNIN_HKNGK_CHK);
                    chkKekkaBeanList.add(honninChkKekkaBean);
                }
            }
        }
        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getCalcmnmeigibangoucheck())) {
            if (C_SaisateiKbn.BLNK.eq(pSiSiharaiKingakuKeisanBean.getSaisateiKbn()) &&
                !C_SeikyuusyaKbn.BLNK.eq(pSiSiharaiKingakuKeisanBean.getSeikyuusyaKbn())) {
                if ((!C_Tuukasyu.JPY.eq(keiyakuTuukasyu) &&
                    zeimuYenHokenknGk.compareTo(YuyuBizConfig.getInstance().getShrtysyTsytHuyou()) > 0)
                    || (C_Tuukasyu.JPY.eq(keiyakuTuukasyu) &&
                        hokenKngkGoukei.compareTo(YuyuBizConfig.getInstance().getShrtysyTsytHuyou()) > 0)) {

                    if (C_UktKyksyaTdk.KYKHNN.eq(uktKyksyaTdk)) {
                        if (!BizUtil.isBlank(pSiSiharaiKingakuKeisanBean.getKykMnmeigiBangou())) {
                            ChkKekkaBean mnmeigiChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                            mnmeigiChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.MNNO_KYK_HUYOUCHK);
                            chkKekkaBeanList.add(mnmeigiChkKekkaBean);
                        }
                    }
                    else {
                        if (BizUtil.isBlank(pSiSiharaiKingakuKeisanBean.getKykMnmeigiBangou())) {
                            ChkKekkaBean mnmeigiChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                            mnmeigiChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.MNNO_KYK_MINYUCHK);
                            chkKekkaBeanList.add(mnmeigiChkKekkaBean);
                        }
                    }
                    if (BizUtil.isBlank(pSiSiharaiKingakuKeisanBean.getUktMnmeigiBangou())) {
                        ChkKekkaBean mnmeigiChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                        mnmeigiChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.MNNO_UKT_MINYUCHK);
                        chkKekkaBeanList.add(mnmeigiChkKekkaBean);
                    }
                }
                else {
                    if (!BizUtil.isBlank(pSiSiharaiKingakuKeisanBean.getKykMnmeigiBangou())) {
                        ChkKekkaBean mnmeigiChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                        mnmeigiChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.MNNO_GAI_KYK_HUYOUCHK);
                        chkKekkaBeanList.add(mnmeigiChkKekkaBean);
                    }
                    if (!BizUtil.isBlank(pSiSiharaiKingakuKeisanBean.getUktMnmeigiBangou())) {
                        ChkKekkaBean mnmeigiChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                        mnmeigiChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.MNNO_GAI_UKT_HUYOUCHK);
                        chkKekkaBeanList.add(mnmeigiChkKekkaBean);
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getCalcsyksbyensitihsyucheck())) {
            if (C_UmuKbn.ARI.eq(syksbyensitihsyutktekiumu)) {
                if (C_Tuukasyu.JPY.eq(siharaTuukasyu)) {
                    ChkKekkaBean syksbyensitihsyuChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    syksbyensitihsyuChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SYKSBYENSITIHSYUTKTEKI_CHK);
                    chkKekkaBeanList.add(syksbyensitihsyuChkKekkaBean);

                    if ((C_SaisateiKbn.SAISATEI.eq(pSiSiharaiKingakuKeisanBean.getSaisateiKbn()))) {
                        ChkKekkaBean saisyksbyensitihsyuChkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                        saisyksbyensitihsyuChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAISBYENSITIHSYUTKTEKI_CHK);
                        chkKekkaBeanList.add(saisyksbyensitihsyuChkKekkaBean);
                    }
                }
            } else {
                if ((C_SaisateiKbn.SAISATEI.eq(pSiSiharaiKingakuKeisanBean.getSaisateiKbn())) &&
                    (jt_skList.size() != 0)) {

                    if ((C_Tuukasyu.JPY.eq(jt_skList.get(0).getShrtuukasyu())) &&
                        (!C_ShrKekkaKbn.HSHR.eq(jt_skList.get(0).getSkKihon().getShrkekkakbn()))) {
                        List<JT_SiDetail> jt_siDetail = jt_skList.get(0).getSkJiyuus().get(0).getSiDetails();

                        for (JT_SiDetail tempSumiJt_siDetail : jt_siDetail) {
                            if (tempSumiJt_siDetail.getKyhkg().compareTo(BizCurrency.valueOf(0, currencyType)) > 0) {
                                if (tempSumiJt_siDetail.getSitihsyutkyumaeyenhknkngk().compareTo(
                                    BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {
                                    ChkKekkaBean saisyksbyensitihsyuChkKekkaBean = SWAKInjector
                                        .getInstance(ChkKekkaBean.class);
                                    saisyksbyensitihsyuChkKekkaBean
                                    .setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAISBYENSITIHSYUTKTEKI_CHK);
                                    chkKekkaBeanList.add(saisyksbyensitihsyuChkKekkaBean);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (chkKekkaBeanList.size() != 0) {
            SiSKNaiyouChkkekkaSettei siSKNaiyouChkkekkaSettei = SWAKInjector
                .getInstance(SiSKNaiyouChkkekkaSettei.class);
            if (C_SeikyuuSyubetu.SB.eq(pSiSiharaiKingakuKeisanBean.getSeikyuuSyubetu())) {
                CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = SWAKInjector
                    .getInstance(CheckSbSkNaiyouKekkaBean.class);
                siSKNaiyouChkkekkaSettei.exec(pSiSiharaiKingakuKeisanBean.getSeikyuuSyubetu(),
                    pSiSiharaiKingakuKeisanBean.getYobidasimotoKinouId(),
                    pSiSiharaiKingakuKeisanBean.getSikinouModeIdKbn(), checkSbSkNaiyouKekkaBean, null,
                    null, null, chkKekkaBeanList);
                warnMsg.addAll(checkSbSkNaiyouKekkaBean.getWarningMessageList());
                errMsg.addAll(checkSbSkNaiyouKekkaBean.getErrorMessageCollector());
            }
            else if (C_SeikyuuSyubetu.KOUSG.eq(pSiSiharaiKingakuKeisanBean.getSeikyuuSyubetu())) {
                CheckKdSkNaiyouKekkaBean checkKdSkNaiyouKekkaBean = SWAKInjector
                    .getInstance(CheckKdSkNaiyouKekkaBean.class);
                siSKNaiyouChkkekkaSettei.exec(pSiSiharaiKingakuKeisanBean.getSeikyuuSyubetu(),
                    pSiSiharaiKingakuKeisanBean.getYobidasimotoKinouId(),
                    pSiSiharaiKingakuKeisanBean.getSikinouModeIdKbn(), null, checkKdSkNaiyouKekkaBean,
                    null, null, chkKekkaBeanList);
                warnMsg.addAll(checkKdSkNaiyouKekkaBean.getWarningMessageList());
                errMsg.addAll(checkKdSkNaiyouKekkaBean.getErrorMessageCollector());
            }
        }


        siSiDetailParamBean = siSiDetailParamBeanList;

        if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())
            || C_SUketoriHouhouKbn.ITIBU_NENKIN
            .eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
            siNenkinInfoBean = tempSiNenkinInfoBean;
        }
        else {
            siNenkinInfoBean = null;
        }

        BeanUtil.copyProperties(siHkkingakuSisanParamBean, tempSiHkkingakuSisanParamBean);

        if (errMsg.size() != 0) {
            sKNaiyouChkkekkaKbn = C_SKNaiyouChkkekkaKbn.ERROR;
        }
        else if (warnMsg.size() != 0) {
            sKNaiyouChkkekkaKbn = C_SKNaiyouChkkekkaKbn.WARNING;
        }
        else {
            sKNaiyouChkkekkaKbn = C_SKNaiyouChkkekkaKbn.SEIJYOU;
        }

        logger.debug("△ 支払金額計算 終了");
        return errorKbn;
    }

    private C_ErrorKbn chkInput(SiSiharaiKingakuKeisanBean pSiSiharaiKingakuKeisanBean) {

        C_ErrorKbn checkErrorKbn = C_ErrorKbn.OK;

        if (pSiSiharaiKingakuKeisanBean.getSyoNo() == null) {
            errMsg.addMessage(MessageId.EBA1056, MessageUtil.getMessage(MessageId.IJW1095));
            checkErrorKbn = C_ErrorKbn.ERROR;
        }

        if (C_SeikyuuSyubetu.BLNK.eq(pSiSiharaiKingakuKeisanBean.getSeikyuuSyubetu())) {
            errMsg.addMessage(MessageId.EBA1056, MessageUtil.getMessage(MessageId.IJW1095));
            checkErrorKbn = C_ErrorKbn.ERROR;
        }

        if (pSiSiharaiKingakuKeisanBean.getCalcKijyunYmd() == null) {
            errMsg.addMessage(MessageId.EBA1056, MessageUtil.getMessage(MessageId.IJW1095));
            checkErrorKbn = C_ErrorKbn.ERROR;
        }

        if (C_SUketoriHouhouKbn.BLNK.eq(pSiSiharaiKingakuKeisanBean.getSUketoriHouhouKbn())) {
            errMsg.addMessage(MessageId.EBA1056, MessageUtil.getMessage(MessageId.IJW1095));
            checkErrorKbn = C_ErrorKbn.ERROR;
        }

        if (pSiSiharaiKingakuKeisanBean.getSyoruiUkeYmd() == null) {
            errMsg.addMessage(MessageId.EBA1056, MessageUtil.getMessage(MessageId.IJW1095));
            checkErrorKbn = C_ErrorKbn.ERROR;
        }

        if (pSiSiharaiKingakuKeisanBean.getSiKykKihon() == null) {
            errMsg.addMessage(MessageId.EBA1056, MessageUtil.getMessage(MessageId.IJW1095));
            checkErrorKbn = C_ErrorKbn.ERROR;
        }

        if (pSiSiharaiKingakuKeisanBean.getKeisanKahiKbn() == null ||
            C_KahiKbn.HUKA.eq(pSiSiharaiKingakuKeisanBean.getKeisanKahiKbn())) {
            errMsg.addMessage(MessageId.EBA1056, MessageUtil.getMessage(MessageId.IJW1095));
            checkErrorKbn = C_ErrorKbn.ERROR;
        }

        if (C_SiinKbn.BLNK.eq(pSiSiharaiKingakuKeisanBean.getSiinKbn())) {
            errMsg.addMessage(MessageId.EBA1056, MessageUtil.getMessage(MessageId.IJW1095));
            checkErrorKbn = C_ErrorKbn.ERROR;
        }

        return checkErrorKbn;
    }

    private BizCurrency sihknknuktbnwariHanei(BizCurrency pBunwariTKgk, BizNumber pSihknknUktBnWari,
        C_HasuukasanUmuKbn pHasuuKasanHyouji) {
        BizCurrency bunwariKgk;
        if (pSihknknUktBnWari.compareTo(MAX_BNWARI) >= 0) {
            bunwariKgk = pBunwariTKgk;
        }
        else {
            bunwariKgk = pBunwariTKgk.multiply(pSihknknUktBnWari).divide(100)
                .toValidValue(RoundingMode.DOWN);
            if (C_HasuukasanUmuKbn.HASUUKASANARI.eq(pHasuuKasanHyouji)) {
                CurrencyType currencyType = bunwariKgk.getType();
                BizCurrency hasuuKngk = BizCurrency.valueOf(currencyType.getShiftBackMultiplier(), currencyType);
                bunwariKgk = bunwariKgk.add(hasuuKngk);
            }
        }
        return bunwariKgk;
    }

    private JM_Kyuuhu makeKyuuhumstCheckEntity() {
        JM_Kyuuhu kyuuhuCheck = new JM_Kyuuhu();

        kyuuhuCheck.setCalcsyoruiukeymdcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setCalchonninkakunincheck(C_UmuKbn.NONE);
        kyuuhuCheck.setCalcmnmeigibangoucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setCalcsyksbyensitihsyucheck(C_UmuKbn.NONE);

        return kyuuhuCheck;
    }

    private void setKyuuhumstCheckEntity(JM_Kyuuhu pKyuuhu, JM_Kyuuhu pKyuuhuCheck) {

        if (C_UmuKbn.ARI.eq(pKyuuhu.getCalcsyoruiukeymdcheck())) {
            pKyuuhuCheck.setCalcsyoruiukeymdcheck(C_UmuKbn.ARI);
        }
        if (C_UmuKbn.ARI.eq(pKyuuhu.getCalchonninkakunincheck())) {
            pKyuuhuCheck.setCalchonninkakunincheck(C_UmuKbn.ARI);
        }
        if (C_UmuKbn.ARI.eq(pKyuuhu.getCalcmnmeigibangoucheck())) {
            pKyuuhuCheck.setCalcmnmeigibangoucheck(C_UmuKbn.ARI);
        }
        if (C_UmuKbn.ARI.eq(pKyuuhu.getCalcsyksbyensitihsyucheck())) {
            pKyuuhuCheck.setCalcsyksbyensitihsyucheck(C_UmuKbn.ARI);
        }

    }

    private C_UktKyksyaTdk uktkyksyatdkCheck(JT_SiKykKihon pSiKykKihon, C_SeikyuusyaKbn pSeikyuusyaKbn) {
        C_UktKyksyaTdk uktKyksyaTdk = C_UktKyksyaTdk.BLNK;
        C_UktKbn uktKbn = C_UktKbn.BLNK;

        if (C_SeikyuusyaKbn.UKTHONNIN.eq(pSeikyuusyaKbn) || C_SeikyuusyaKbn.KYKDAIRININ.eq(pSeikyuusyaKbn)) {
            if (pSiKykKihon.getSbuktnin() == 1) {
                for (JT_SiUkt tempSiUkt : pSiKykKihon.getSiUkts()) {
                    if (C_Hkuktsyu.SBHKKUKT.eq(tempSiUkt.getHkuktsyu()) ||
                        C_Hkuktsyu.SBKYFKUKT.eq(tempSiUkt.getHkuktsyu())) {
                        uktKbn = tempSiUkt.getUktkbn();
                        break;
                    }
                }
            }
            if (C_UktKbn.KYK.eq(uktKbn)) {
                uktKyksyaTdk = C_UktKyksyaTdk.KYKHNN;
            }
            else {
                uktKyksyaTdk = C_UktKyksyaTdk.KYKIGAI;
            }
        }
        if (C_SeikyuusyaKbn.UKTDAIHYOU.eq(pSeikyuusyaKbn) || C_SeikyuusyaKbn.SONOTA.eq(pSeikyuusyaKbn)) {
            uktKyksyaTdk = C_UktKyksyaTdk.KYKIGAI;
        }
        return uktKyksyaTdk;
    }

    private Boolean simisiParamBeanCreateCheck(JM_Kyuuhu pKyuuhu, CalcHkShrKngkBean pCalcHkShrKngkBean) {
        Boolean result = true;
        if (C_HknKknKbn.DAI2HKNKKN.eq(pCalcHkShrKngkBean.getHknKknKbn()) &&
            C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(pKyuuhu.getHokenkinsyuruikbn())) {
            result = false;
        }
        if (C_HknKknKbn.DAI3HKNKKN.eq(pCalcHkShrKngkBean.getHknKknKbn()) &&
            C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(pKyuuhu.getHokenkinsyuruikbn())) {
            result = false;
        }

        return result;
    }

    private HashMap<String, BizCurrency> bunkatuEnkaKanri(BizCurrency pSiteituukagk, BizCurrency pEnkagk,
        C_Tuukasyu pKeiyakuTuukasyu, CurrencyType pCurrencyType, BizNumber pSihknknUktBnWari,
        BizNumber pGaikaknsnKwsrate) {
        BizCurrency bunkatugoSiteituukagk = BizCurrency.valueOf(0, pCurrencyType);
        BizCurrency bunkatugoEnkagk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        HashMap<String, BizCurrency> map = new HashMap<String, BizCurrency>();

        if (C_Tuukasyu.JPY.eq(pKeiyakuTuukasyu)) {
            if (pSiteituukagk.compareTo(BizCurrency.valueOf(0, pSiteituukagk.getType())) > 0) {
                bunkatugoSiteituukagk = sihknknuktbnwariHanei(pSiteituukagk, pSihknknUktBnWari,
                    C_HasuukasanUmuKbn.HASUUKASANNASI);
            }
        } else {
            if (pEnkagk.compareTo(BizCurrency.valueOf(0, pEnkagk.getType())) > 0) {
                bunkatugoEnkagk = sihknknuktbnwariHanei(pEnkagk, pSihknknUktBnWari, C_HasuukasanUmuKbn.HASUUKASANNASI);
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                bunkatugoSiteituukagk = keisanGaikakanzan.execDivide(pKeiyakuTuukasyu, bunkatugoEnkagk,
                    pGaikaknsnKwsrate, C_HasuusyoriKbn.AGE);
            }
        }
        map.put(KEY_SITEITUUKA, bunkatugoSiteituukagk);
        map.put(KWY_ENKA, bunkatugoEnkagk);
        return map;
    }

    private HashMap<String, BizCurrency> bunkatuTekiyou(BizCurrency pSiteituukagk, BizCurrency pEnkagk,
        C_Tuukasyu pKeiyakuTuukasyu, CurrencyType pCurrencyType, C_SeisankinKanritukaKbn pSeisankinKanritukaKbn,
        BizNumber pSihknknUktBnWari, BizNumber pKawaseRate, BizNumber pGaikaknsnKwsrate) {

        if (C_Tuukasyu.JPY.eq(pKeiyakuTuukasyu) || C_SeisankinKanritukaKbn.YENKA.eq(pSeisankinKanritukaKbn)) {
            return bunkatuEnkaKanri(pSiteituukagk, pEnkagk, pKeiyakuTuukasyu, pCurrencyType, pSihknknUktBnWari,
                pGaikaknsnKwsrate);
        }

        BizCurrency bunkatugoSiteituukagk = BizCurrency.valueOf(0, pCurrencyType);
        BizCurrency bunkatugoEnkagk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        HashMap<String, BizCurrency> map = new HashMap<String, BizCurrency>();

        if (pSiteituukagk.compareTo(BizCurrency.valueOf(0, pCurrencyType)) > 0) {
            bunkatugoSiteituukagk = sihknknuktbnwariHanei(pSiteituukagk, pSihknknUktBnWari,
                C_HasuukasanUmuKbn.HASUUKASANNASI);

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            bunkatugoEnkagk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, bunkatugoSiteituukagk, pKawaseRate,
                C_HasuusyoriKbn.AGE);
        }

        map.put(KEY_SITEITUUKA, bunkatugoSiteituukagk);
        map.put(KWY_ENKA, bunkatugoEnkagk);

        return map;
    }
}