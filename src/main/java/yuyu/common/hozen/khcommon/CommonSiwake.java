package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;

/**
 * 契約保全 契約保全共通 仕訳共通処理
 */
public class CommonSiwake {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    private final String FBSOUKIN = "fbsoukin";

    private final String KRKKEIJYO = "kariuke";

    public CommonSiwake() {
        super();
    }

    public CommonSiwakeOutBean exec(CommonSiwakeInBean pCommonSiwakeInBean) {

        logger.debug("▽ 仕訳共通処理 開始");

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);
        String shrhou = "";
        int tyakkinY = 0;
        int kykY = 0;
        C_KawasetekiyoKbn kawasetekiyokbn;

        if (!IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_GENGAKU.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_KHYENDTHNKHRSHR.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_DSHR.equals(pCommonSiwakeInBean.getKinouId()) &&
            !IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(pCommonSiwakeInBean.getKinouId())) {

            throw new CommonBizAppException("仕訳共通処理エラー　対象外の機能ＩＤです。" + "機能ＩＤ＝" +
                pCommonSiwakeInBean.getKinouId());
        }

        if (C_Tuukasyu.BLNK.eq(pCommonSiwakeInBean.getTuukasyu())) {

            throw new CommonBizAppException("仕訳共通処理エラー　対象外の通貨種類です。" + "通貨種類＝"
                + pCommonSiwakeInBean.getTuukasyu().getContent());
        }

        commonSiwakeOutBean.setTuukasyu(pCommonSiwakeInBean.getTuukasyu());

        commonSiwakeOutBean.setDenYmd(pCommonSiwakeInBean.getDenYmd());

        commonSiwakeOutBean.setSyoriYmd(pCommonSiwakeInBean.getSyoriYmd());

        commonSiwakeOutBean.setSyoriCd(kinou.getSyoricd());

        commonSiwakeOutBean.setKyktuukaSyu(pCommonSiwakeInBean.getKyktuukaSyu());

        if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pCommonSiwakeInBean.getKinouId())) {

            commonSiwakeOutBean.setDensysKbn(C_DensysKbn.SKEI);
        }
        else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(pCommonSiwakeInBean.getKinouId()) ||
            IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId()) ||
            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId()) ||
            IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pCommonSiwakeInBean.getKinouId()) ||
            IKhozenCommonConstants.KINOUID_GENGAKU.equals(pCommonSiwakeInBean.getKinouId()) ||
            IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pCommonSiwakeInBean.getKinouId()) ||
            IKhozenCommonConstants.KINOUID_KHYENDTHNKHRSHR.equals(pCommonSiwakeInBean.getKinouId()) ||
            IKhozenCommonConstants.KINOUID_DSHR.equals(pCommonSiwakeInBean.getKinouId()) ||
            IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(pCommonSiwakeInBean.getKinouId())) {

            commonSiwakeOutBean.setDensysKbn(C_DensysKbn.HOZEN);
        }


        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pCommonSiwakeInBean.getSyouhnCd(),
            pCommonSiwakeInBean.getSyouhnsdNo());

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pCommonSiwakeInBean.getSyouhnCd(), pCommonSiwakeInBean.getKyktuukaSyu());

        if(C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())){

            throw new CommonBizAppException("商品別セグメントマスタからセグメントコードが取得できません。  "
                + "主契約商品コード＝" + pCommonSiwakeInBean.getSyouhnCd()
                + "主契約商品世代番号＝" + String.valueOf(pCommonSiwakeInBean.getSyouhnsdNo()));

        }

        C_Segcd seg1cd = syouhinbetuSegmentBean.getSegcd1();
        C_Segcd seg2cd = syouhinbetuSegmentBean.getSegcd2();
        C_UmuKbn heijyunbaraiumu = syouhnZokusei.getHeijyunbaraiumu();

        if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(pCommonSiwakeInBean.getShrhousiteiKbn()) ||
            C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(pCommonSiwakeInBean.getShrhousiteiKbn()) ||
            C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(pCommonSiwakeInBean.getShrhousiteiKbn()) ||
            C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI.eq(pCommonSiwakeInBean.getShrhousiteiKbn())) {

            shrhou = FBSOUKIN;
            commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.KOUZAHURIKOMI);

            if (IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId())) {
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.DS);
            }
            else if (IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(pCommonSiwakeInBean.getKinouId())) {

                if (C_DseisantetudukimeiKbn.SIBOU.eq(pCommonSiwakeInBean.getHaitoukinTuibaraiHanteiKbn())) {

                    commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SIBOUTETUZUKI);
                }
                else if (C_DseisantetudukimeiKbn.KAIYAKU.eq(pCommonSiwakeInBean.getHaitoukinTuibaraiHanteiKbn())) {

                    commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                }
            }
            else {
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
            }

            if (IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId()) ||
                IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pCommonSiwakeInBean.getKinouId()) ||
                IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(pCommonSiwakeInBean.getKinouId())) {
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HOZENYAKAN);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.FBSOUKIN);
            }
            else {
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.ONLINEFB);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.FBSOUKINYOKU);
            }
        }

        else if (C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pCommonSiwakeInBean.getShrhousiteiKbn()) ||
            C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pCommonSiwakeInBean.getShrhousiteiKbn()) ||
            C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI.eq(pCommonSiwakeInBean.getShrhousiteiKbn())) {

            shrhou = KRKKEIJYO;

            if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId())) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
            }
            else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pCommonSiwakeInBean.getKinouId())) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KEIYAKUHENKOU);
            }
            else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pCommonSiwakeInBean.getKinouId())) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KEIYAKUHENKOU);
            }
            else if (IKhozenCommonConstants.KINOUID_KHYENDTHNKHRSHR.equals(pCommonSiwakeInBean.getKinouId())) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
            }
            else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(pCommonSiwakeInBean.getKinouId())) {

                if (C_SyoriKbn.CLGOFF.eq(pCommonSiwakeInBean.getSyoriKbn()) ||
                    C_SyoriKbn.KYKTORIKESI.eq(pCommonSiwakeInBean.getSyoriKbn()) ||
                    C_SyoriKbn.KAIJO.eq(pCommonSiwakeInBean.getSyoriKbn())) {

                    commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KEIYAKUTORIKESI);
                }
                else if (C_SyoriKbn.SBKAIJO.eq(pCommonSiwakeInBean.getSyoriKbn()) ||
                    C_SyoriKbn.SBMENSEKI.eq(pCommonSiwakeInBean.getSyoriKbn()) ||
                    C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(pCommonSiwakeInBean.getSyoriKbn())) {

                    commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SIBOUTETUZUKI);
                }
            }
            else if (IKhozenCommonConstants.KINOUID_DSHR.equals(pCommonSiwakeInBean.getKinouId())) {
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SOUKATU);
            }
            else if (IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(pCommonSiwakeInBean.getKinouId())) {

                if (C_DseisantetudukimeiKbn.SIBOU.eq(pCommonSiwakeInBean.getHaitoukinTuibaraiHanteiKbn())) {

                    commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SIBOUTETUZUKI);
                }
                else if (C_DseisantetudukimeiKbn.KAIYAKU.eq(pCommonSiwakeInBean.getHaitoukinTuibaraiHanteiKbn())) {

                    commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                }
            }

            commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);
            commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);

            if (C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pCommonSiwakeInBean.getShrhousiteiKbn()) ||
                C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI.eq(pCommonSiwakeInBean.getShrhousiteiKbn())) {

                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.KARIUKERSKARI);
            }
            else {

                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.KARIUKERSKNASI);
            }
        }

        if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pCommonSiwakeInBean.getKinouId())) {

            commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.DAIRITENJIMUKANRI);
            commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.BLNK);
            commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
            commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);
        }

        if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pCommonSiwakeInBean.getKinouId())) {

            if (C_ShrhousiteiKbn.BLNK.eq(pCommonSiwakeInBean.getShrhousiteiKbn())) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KEIYAKUHENKOU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);
                commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.BLNK);
            }
        }

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(commonSiwakeOutBean.getTantoCd());

        commonSiwakeOutBean.setHuridenatesakiCd(tantouCd.getBusitucd());

        BizDate kessanNensibi = setKessanNensibi.exec(pCommonSiwakeInBean.getDenYmd());

        tyakkinY = kessanNensibi.getYear();

        BizDate kessanNensibi1 = setKessanNensibi.exec(pCommonSiwakeInBean.getKykYmd());

        kykY = kessanNensibi1.getYear();

        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {
            kawasetekiyokbn = C_KawasetekiyoKbn.BLNK;
        }
        else {
            kawasetekiyokbn = C_KawasetekiyoKbn.TTM;
        }

        HenkanTuuka HenkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType kyktuukatype = HenkanTuuka.henkanTuukaKbnToType(pCommonSiwakeInBean.getKyktuukaSyu());

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        C_UmuKbn gensengkFlg = C_UmuKbn.NONE;

        for (TaisyouGkBean taisyouGkBeanTmp : pCommonSiwakeInBean.getTaisyouGkBeanLst()) {

            if (taisyouGkBeanTmp.getTaisyouGk().compareTo(
                BizCurrency.valueOf(0, taisyouGkBeanTmp.getTaisyouGk().getType())) > 0) {

                if (C_KhDengkSyuruiKbn.RYOUSYUP_SYOP.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    if (C_UmuKbn.ARI.eq(heijyunbaraiumu)) {

                        BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                        bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu()) ){

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU);
                        }
                        else{
                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD);
                            }
                        }

                        bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());

                        if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        }
                        else {

                            bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));

                        }

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        }
                        else {

                            bzSiwakeMeisaiBeanKs.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }

                        bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                        bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);
                    }
                    else {

                        BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                        BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD);
                        }

                        if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                            bzSiwakeMeisaiBeanKs.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                            bzSiwakeMeisaiBeanKs.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }
                        else {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                            bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                            bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        }

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                        bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                        bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                        bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);
                    }
                }
                else if (C_KhDengkSyuruiKbn.RYOUSYUP_SYONENDO2KAIMEIKOU.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                    bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu()) ){

                        bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU);
                    }
                    else{

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY);
                        }
                    }

                    bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                    }
                    else {

                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                    }

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }
                    else {
                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }

                    bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);
                }
                else if (C_KhDengkSyuruiKbn.RYOUSYUP_JINENDO.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                    bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu()) ){

                        bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU);
                    }
                    else{
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD);
                        }
                    }

                    bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                    }
                    else {

                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                    }

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }
                    else {

                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }

                    bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);
                }
                else if (C_KhDengkSyuruiKbn.RYOUSYUP.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                    bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu()) ){

                        bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI);
                    }
                    else{

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
                        }
                    }

                    bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                    }

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }

                    bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.RYOUSYUP_TUITYOU.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                    bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                    bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu()) ){

                        bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU);
                    }
                    else {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY);
                        }
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.KEIJYOUP.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                    bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                    bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu()) ){

                        bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU);
                    }
                    else {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY);
                        }
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);
                }
                else if (C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                    bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                    bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu()) ){

                        bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU);
                    }
                    else {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY);
                        }
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                        bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_HUTUU);
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_AUD);
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }

                    bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                    bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(true);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SHRTIENRSK.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                    BizCurrency keiyakuTuukaKansanGk = null;
                    if (IKhozenCommonConstants.KINOUID_DSHR.equals(pCommonSiwakeInBean.getKinouId())) {
                        keiyakuTuukaKansanGk = BizCurrency.valueOf(0, kyktuukatype);
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())
                            && !C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {
                            keiyakuTuukaKansanGk = keisanGaikakanzan.execDivide(pCommonSiwakeInBean.getKyktuukaSyu(),
                                taisyouGkBeanTmp.getTaisyouGk(), pCommonSiwakeInBean.getTuukasyuKansanKawaserate(),
                                C_HasuusyoriKbn.SSYGNY);
                        }
                        else {
                            keiyakuTuukaKansanGk = taisyouGkBeanTmp.getTaisyouGk();
                        }
                    }
                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                        bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU);
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD);
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }

                    bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                    bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(keiyakuTuukaKansanGk);
                    bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_KIHRKMP.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    if (kykY < tyakkinY) {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
                        }
                    }
                    else {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD);
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }

                    bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                    bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                        bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU);
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }

                    bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                    bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(true);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_YENDTHNKHR.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                    bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU);
                    bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                    bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    bzSiwakeMeisaiBeanKr.setIbSeg1cd(taisyouGkBeanTmp.getSeg1cd());
                    bzSiwakeMeisaiBeanKr.setIbSeg2cd(taisyouGkBeanTmp.getSeg2cd());
                    bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);
                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);

                }
                else if (C_KhDengkSyuruiKbn.GENSENTYOUSYU.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                    BizCurrency keiyakuTuukaKansanGk = null;

                    if (taisyouGkBeanTmp.getKeiyakutuukaGk().compareTo(
                        BizCurrency.valueOf(0, taisyouGkBeanTmp.getKeiyakutuukaGk().getType())) > 0) {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())
                            && !C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                            keiyakuTuukaKansanGk = keisanGaikakanzan.execDivide(pCommonSiwakeInBean.getKyktuukaSyu(),
                                taisyouGkBeanTmp.getTaisyouGk(), pCommonSiwakeInBean.getTuukasyuKansanKawaserate(),
                                C_HasuusyoriKbn.SSYGNY);
                        }
                        else {

                            keiyakuTuukaKansanGk = taisyouGkBeanTmp.getTaisyouGk();
                        }
                    }
                    else {
                        keiyakuTuukaKansanGk = BizCurrency.valueOf(0, kyktuukatype);
                    }

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {
                        bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN);
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD);
                        }
                    }

                    if (IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId())) {

                        bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(C_Tantositucd.HOZENSIHARAISV.getValue());
                    }
                    else {

                        bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    }

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                    else {

                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }
                    bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                    bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(keiyakuTuukaKansanGk);
                    bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);

                    gensengkFlg = C_UmuKbn.ARI;
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {
                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU);
                        }
                        else {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY);
                        }

                        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                    }
                    else {

                        BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY);
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);

                        bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD);
                        }
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);

                        BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                        bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                        if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD);
                        }
                        bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);

                    }
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_D.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    if (IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(pCommonSiwakeInBean.getKinouId())) {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_HUTUU);
                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD);
                            }
                            else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_AUD);
                            }
                        }

                        if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        }
                        else {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        }

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        }
                        else {

                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }

                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_HUTUU);
                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD);
                            }
                            else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_AUD);
                            }
                        }
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(pCommonSiwakeInBean.getHijynbrKanritukaHantKbn())) {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD);
                        }
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU);
                        }
                        else {

                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD);
                            }
                        }

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        }
                        else {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(pCommonSiwakeInBean.getHijynbrKanritukaHantKbn())) {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD);
                        }
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU);
                        }
                        else {

                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD);
                            }
                        }

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        }
                        else {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(pCommonSiwakeInBean.getHijynbrKanritukaHantKbn())) {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD);
                        }
                        else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD);
                        }
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU);
                        }
                        else {

                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD);
                            }
                        }

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        }
                        else {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(pCommonSiwakeInBean.getHijynbrKanritukaHantKbn())) {

                        if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId()) ||
                            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pCommonSiwakeInBean.getKinouId()) ||
                            IKhozenCommonConstants.KINOUID_GENGAKU.equals(pCommonSiwakeInBean.getKinouId()) ||
                            C_SyoriKbn.KAIJO.eq(pCommonSiwakeInBean.getSyoriKbn()) ||
                            C_SyoriKbn.SBKAIJO.eq(pCommonSiwakeInBean.getSyoriKbn())) {

                            bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD);
                            }
                            else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
                            }

                            bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());

                            if (C_UmuKbn.ARI.eq(pCommonSiwakeInBean.getAzukarikinUmuKbn())) {
                                if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                    bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                                    bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                                }
                                else {

                                    bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                                    bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                                }
                            }
                            else if (C_UmuKbn.NONE.eq(pCommonSiwakeInBean.getAzukarikinUmuKbn())){
                                bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                                bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                            }

                            bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                            bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                            bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                            bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                            bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                            bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                        }
                        else {
                            bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD);
                            }
                            else if (C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {
                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
                            }

                            bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                            if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                                bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                            }
                            else {

                                bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                                bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                            }
                            bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                            bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                            bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(BizCurrency.valueOf(0, kyktuukatype));
                            bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                            bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                            bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);
                        }
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                        bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                        bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                        bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                        bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                        bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                        bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                        bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);


                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU);
                        }
                        else {

                            if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY);
                            }
                            else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                                bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD);
                            }
                        }

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                        }
                        else {

                            bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                            bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SEISANP_HENKAN.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKr = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

                    bzSiwakeMeisaiBeanKr.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                    bzSiwakeMeisaiBeanKr.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    bzSiwakeMeisaiBeanKr.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKr.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKr.setIbKeiyakutuukagk(taisyouGkBeanTmp.getKeiyakutuukaGk());
                    bzSiwakeMeisaiBeanKr.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKr.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKr.setIbTaisyakutyouseiflg(false);

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())) {

                        bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU);
                    }
                    else {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKr.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD);
                        }
                    }

                    if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }
                    else {

                        bzSiwakeMeisaiBeanKr.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKr.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKr);
                }
                else if (C_KhDengkSyuruiKbn.SHRGK.eq(taisyouGkBeanTmp.getKhDengkSyuruiKbn())) {

                    BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKs = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                    BizCurrency kykTuukaKansanShrGk = null;

                    if (taisyouGkBeanTmp.getKeiyakutuukaGk().compareTo(
                        BizCurrency.valueOf(0, taisyouGkBeanTmp.getKeiyakutuukaGk().getType())) > 0) {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())
                            && !C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getKyktuukaSyu())
                            && C_UmuKbn.ARI.eq(gensengkFlg)) {

                            kykTuukaKansanShrGk = keisanGaikakanzan.execDivide(pCommonSiwakeInBean.getKyktuukaSyu(),
                                taisyouGkBeanTmp.getTaisyouGk(), pCommonSiwakeInBean.getTuukasyuKansanKawaserate(),
                                C_HasuusyoriKbn.SSYGNY);
                        }
                        else {
                            kykTuukaKansanShrGk = taisyouGkBeanTmp.getKeiyakutuukaGk();
                        }
                    }
                    else {

                        kykTuukaKansanShrGk = BizCurrency.valueOf(0, kyktuukatype);
                    }

                    if (FBSOUKIN.equals(shrhou)) {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
                        }
                        else if (C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu()) ||
                            C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN);
                        }
                    }
                    else if (KRKKEIJYO.equals(shrhou)) {

                        if (C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu()) ||
                            C_Tuukasyu.USD.eq(pCommonSiwakeInBean.getTuukasyu()) ||
                            C_Tuukasyu.AUD.eq(pCommonSiwakeInBean.getTuukasyu())) {

                            bzSiwakeMeisaiBeanKs.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO);
                        }
                    }

                    if (FBSOUKIN.equals(shrhou)) {

                        bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(YuyuBizConfig.getInstance().getSikinkoubaibukacd());
                    }
                    else if (KRKKEIJYO.equals(shrhou)) {

                        bzSiwakeMeisaiBeanKs.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    }

                    if (!C_Tuukasyu.JPY.eq(pCommonSiwakeInBean.getTuukasyu())) {

                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(taisyouGkBeanTmp.getTaisyouGk());
                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                    else {

                        bzSiwakeMeisaiBeanKs.setIbDengaikagk(BizCurrency.valueOf(0, kyktuukatype));
                        bzSiwakeMeisaiBeanKs.setIbDenyenkagk(taisyouGkBeanTmp.getTaisyouGk());
                    }

                    bzSiwakeMeisaiBeanKs.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
                    bzSiwakeMeisaiBeanKs.setIbSeg1cd(seg1cd);
                    bzSiwakeMeisaiBeanKs.setIbSeg2cd(seg2cd);
                    bzSiwakeMeisaiBeanKs.setIbKeiyakutuukagk(kykTuukaKansanShrGk);
                    bzSiwakeMeisaiBeanKs.setIbKawasetekiyokbn(kawasetekiyokbn);
                    bzSiwakeMeisaiBeanKs.setIbDenkarikanjyono("");
                    bzSiwakeMeisaiBeanKs.setIbTaisyakutyouseiflg(false);

                    bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBeanKs);
                    commonSiwakeOutBean.setGaikataikagk(kykTuukaKansanShrGk);
                }
                else {

                    throw new CommonBizAppException("仕訳共通処理エラー　対象外の金額種類です。" + "金額種類＝"
                        + taisyouGkBeanTmp.getKhDengkSyuruiKbn().getContent());
                }
            }
        }
        commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(bzSiwakeMeisaiBeanLst);

        logger.debug("△ 仕訳共通処理 終了");

        return commonSiwakeOutBean;
    }
}
