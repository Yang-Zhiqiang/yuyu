package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.dba4ansyuucommonsiwake.AnsyuuCommonSiwakeDao;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 契約保全共通 案内収納用仕訳共通処理
 */
public class AnsyuuCommonSiwake {

    private C_Segcd segcd1;

    private C_Segcd segcd2;

    private String busitucd;

    private C_Tuukasyu tuukasyu;

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private AnsyuuCommonSiwakeDao ansyuuCommonSiwakeDao;

    private final String SYORICD_NYUUKINSYORI = "RDHU";

    private final String SYORICD_ONLINENYUKIN = "RD34";

    private final String SYORICD_HARAIKATAHENKOU = "RD12";

    private final String SYORICD_NYUUKINTORIKESI = "RD35";

    private final String SYORICD_KAIUKETEISEI = "RD36";

    public AnsyuuCommonSiwake() {
        super();
    }

    public CommonSiwakeOutBean exec(AnsyuuCommonSiwakeInBean pAnsyuuCommonSiwakeInBean) {

        logger.debug("▽ 案内収納用仕訳共通処理 開始");

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        JtKaisukeisan jtKaisuKeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

        BizDate kessanNensibi = setKessanNensibi.exec(pAnsyuuCommonSiwakeInBean.getDenYmd());

        int denymdY = kessanNensibi.getYear();

        CurrencyType taisyouGkType = BizCurrencyTypes.YEN;

        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanList = pAnsyuuCommonSiwakeInBean.getAnsyuuTaisyouGkBeanLst();

        if (ansyuuTaisyouGkBeanList.size() > 0) {
            taisyouGkType = ansyuuTaisyouGkBeanList.get(0).getTaisyouGk().getType();
        }


        BizCurrency taisyouGkZero = BizCurrency.valueOf(0, taisyouGkType);

        BizCurrency seisanpGoukei = BizCurrency.valueOf(0, taisyouGkType);
        BizCurrency keijyoupGoukei = BizCurrency.valueOf(0, taisyouGkType);
        BizCurrency sonotaHenreikin = BizCurrency.valueOf(0, taisyouGkType);
        BizCurrency syonendoSyokaip = BizCurrency.valueOf(0, taisyouGkType);
        BizCurrency syonendo2KaimeIkoup = BizCurrency.valueOf(0, taisyouGkType);
        BizCurrency jinendoIkoup = BizCurrency.valueOf(0, taisyouGkType);

        for (AnsyuuTaisyouGkBean ansyuuTaisyouGkBean : ansyuuTaisyouGkBeanList) {

            if (ansyuuTaisyouGkBean.getTaisyouGk().compareTo(taisyouGkZero) <= 0) {

                continue;
            }

            if (C_KhDengkSyuruiKbn.KEIJYOUP.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn()) ||
                C_KhDengkSyuruiKbn.SEISANK_KIHRKMP.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

            }
            else {

                continue;
            }



            jtKaisuKeisan.exec(ansyuuTaisyouGkBean.getJyutouKaisuuY(),
                ansyuuTaisyouGkBean.getJyutouKaisuuM(),
                ansyuuTaisyouGkBean.getHrkkaisuu());

            int jyutouKaisuu = jtKaisuKeisan.getJyutoukaisuu();

            if (jtKaisuKeisan.getHasuutuki() > 0) {

                jyutouKaisuu++;
            }

            int nykDenYmdnJigyouNendo = 0;

            if (C_KhDengkSyuruiKbn.SEISANK_KIHRKMP.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

                BizDate kessannenSibi = setKessanNensibi.exec(ansyuuTaisyouGkBean.getNykdenYmd());

                nykDenYmdnJigyouNendo = kessannenSibi.getYear();
            }


            BizDateYM jyutouStartYm = ansyuuTaisyouGkBean.getJyutouStartYm();
            int ksSonotaHenreikin = 0;
            int ksSyounendoSyokaip = 0;
            int ksNendo2KaimeIkoup = 0;
            int ksJinendoIkoup = 0;

            for (int m = 0; m < jyutouKaisuu; m++) {

                if (C_KhDengkSyuruiKbn.SEISANK_KIHRKMP
                    .eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn()) &&
                    nykDenYmdnJigyouNendo < denymdY) {

                    ksSonotaHenreikin++;
                }
                else {
                    if (BizDateUtil.compareYm(jyutouStartYm, pAnsyuuCommonSiwakeInBean.getKykYmd().getBizDateYM())
                        == BizDateUtil.COMPARE_EQUAL) {

                        ksSyounendoSyokaip = 1;
                    }
                    else if (BizDateUtil.compareYm(jyutouStartYm, pAnsyuuCommonSiwakeInBean.
                        getKykYmd().addYears(1).getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {

                        ksNendo2KaimeIkoup++;
                    }
                    else {

                        ksJinendoIkoup++;
                    }
                }

                jyutouStartYm = jyutouStartYm
                    .addMonths(Integer.parseInt(ansyuuTaisyouGkBean.getHrkkaisuu().getValue()));
            }

            BizCurrency sonotaHenreikinKk = ansyuuTaisyouGkBean.getTaisyouGk().multiply(ksSonotaHenreikin)
                .divide(jyutouKaisuu, 0, RoundingMode.DOWN);
            BizCurrency syonendoSyokaipKk = ansyuuTaisyouGkBean.getTaisyouGk().multiply(ksSyounendoSyokaip)
                .divide(jyutouKaisuu, 0, RoundingMode.DOWN);
            BizCurrency syonendo2KaimeIkoupKk = ansyuuTaisyouGkBean.getTaisyouGk().multiply(ksNendo2KaimeIkoup)
                .divide(jyutouKaisuu, 0, RoundingMode.DOWN);
            BizCurrency jinendoIkoupKk = ansyuuTaisyouGkBean.getTaisyouGk().multiply(ksJinendoIkoup)
                .divide(jyutouKaisuu, 0, RoundingMode.DOWN);

            BizCurrency hasuu = ansyuuTaisyouGkBean.getTaisyouGk().subtract(sonotaHenreikinKk)
                .subtract(syonendoSyokaipKk).subtract(syonendo2KaimeIkoupKk).subtract(jinendoIkoupKk);

            if (jinendoIkoupKk.compareTo(taisyouGkZero) != 0) {

                jinendoIkoupKk = jinendoIkoupKk.add(hasuu);
            }
            else if (syonendo2KaimeIkoupKk.compareTo(taisyouGkZero) != 0) {

                syonendo2KaimeIkoupKk = syonendo2KaimeIkoupKk.add(hasuu);
            }
            else if (syonendoSyokaipKk.compareTo(taisyouGkZero) != 0) {

                syonendoSyokaipKk = syonendoSyokaipKk.add(hasuu);
            }
            else if (sonotaHenreikinKk.compareTo(taisyouGkZero) != 0) {

                sonotaHenreikinKk = sonotaHenreikinKk.add(hasuu);
            }
            else {
                if (ksSyounendoSyokaip != 0) {

                    syonendoSyokaipKk = hasuu;
                }
                else if (ksNendo2KaimeIkoup != 0) {

                    syonendo2KaimeIkoupKk = hasuu;
                }
                else if (ksJinendoIkoup != 0) {

                    jinendoIkoupKk = hasuu;
                }
                else if (ksSonotaHenreikin != 0) {

                    sonotaHenreikinKk = hasuu;
                }
            }

            if (C_KhDengkSyuruiKbn.SEISANK_KIHRKMP.
                eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

                seisanpGoukei = seisanpGoukei.add(ansyuuTaisyouGkBean.getTaisyouGk());
            }
            else if (C_KhDengkSyuruiKbn.KEIJYOUP.
                eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

                keijyoupGoukei = keijyoupGoukei.add(ansyuuTaisyouGkBean.getTaisyouGk());
            }

            sonotaHenreikin = sonotaHenreikin.add(sonotaHenreikinKk);
            syonendoSyokaip = syonendoSyokaip.add(syonendoSyokaipKk);
            syonendo2KaimeIkoup = syonendo2KaimeIkoup.add(syonendo2KaimeIkoupKk);
            jinendoIkoup = jinendoIkoup.add(jinendoIkoupKk);
        }

        CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);

        commonSiwakeOutBean.setDensysKbn(pAnsyuuCommonSiwakeInBean.getDensysKbn());
        commonSiwakeOutBean.setDenYmd(pAnsyuuCommonSiwakeInBean.getDenYmd());

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        commonSiwakeOutBean.setTuukasyu(henkanTuuka.henkanTuukaTypeToKbn(taisyouGkType));
        commonSiwakeOutBean.setSyoriYmd(pAnsyuuCommonSiwakeInBean.getSyoriYmd());

        String syoriCd = kinou.getSyoricd();
        commonSiwakeOutBean.setSyoriCd(syoriCd);

        commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.BLNK);

        commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.BLNK0);
        commonSiwakeOutBean.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.BLNK);

        String syouhinCd = pAnsyuuCommonSiwakeInBean.getSyouhinCd();
        Integer syouhnsdno = pAnsyuuCommonSiwakeInBean.getSyouhnsdno();

        if (SYORICD_NYUUKINSYORI.equals(syoriCd)){

            if (!BizUtil.isBlank(syouhinCd) && syouhnsdno != null) {

                if (hanteiKhDengkSyuruiKbnExist(C_KhDengkSyuruiKbn.SHRGK, ansyuuTaisyouGkBeanList)) {

                    commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.YOHURI);
                    commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);
                    commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.FBSOUKIN);

                }
                else if (hanteiKhDengkSyuruiKbnExist(C_KhDengkSyuruiKbn.CREDITTORIKESIGK, ansyuuTaisyouGkBeanList)) {

                    commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SYUUDANTEIKI);
                    commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);
                    commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.CREDITHENKIN_MINUSURIAGE);

                }
                else {
                    if (C_Nykkeiro.HKNKIN.eq(pAnsyuuCommonSiwakeInBean.getNykkeiro())) {

                        commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SIBOUTETUZUKI);
                        commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);

                    } else if (C_Nykkeiro.KZHRK.eq(pAnsyuuCommonSiwakeInBean.getNykkeiro())) {

                        if (C_Syuudaikocd.SIS.eq(pAnsyuuCommonSiwakeInBean.getSyuudaikoCd())) {

                            commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.YOHURI);
                            commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);
                            commonSiwakeOutBean.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.KZHURIKAE_SIS);
                        }
                        else if (C_Syuudaikocd.CSS.eq(pAnsyuuCommonSiwakeInBean.getSyuudaikoCd())) {

                            commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.YOHURI);
                            commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);
                            commonSiwakeOutBean.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.NET_KOUHURI_CSS);
                        }
                    } else if (C_Nykkeiro.CREDIT.eq(pAnsyuuCommonSiwakeInBean.getNykkeiro())) {

                        commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SYUUDANTEIKI);
                        commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);
                        commonSiwakeOutBean.setDensyorisyousaikbn(C_DenSyorisyousaiKbn.CREDIT);
                    }
                }
            } else {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.BLNK0);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);

            }

        } else if (SYORICD_ONLINENYUKIN.equals(syoriCd)) {

            if (hanteiKhDengkSyuruiKbnExist(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, ansyuuTaisyouGkBeanList)) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SOUKATU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);

            } else if (hanteiKhDengkSyuruiKbnExist(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK, ansyuuTaisyouGkBeanList)) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.BLNK0);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);
            }

        } else if (SYORICD_HARAIKATAHENKOU.equals(syoriCd)) {

            commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SOUKATU);
            commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);

        } else if (SYORICD_NYUUKINTORIKESI.equals(syoriCd)) {

            commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.BLNK0);
            commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);

        } else if (SYORICD_KAIUKETEISEI.equals(syoriCd)) {

            if (hanteiKhDengkSyuruiKbnExist(C_KhDengkSyuruiKbn.SHRGK, ansyuuTaisyouGkBeanList)) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.KAIYAKU);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.ONLINEFB);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.FBSOUKINYOKU);

            }
            else if (hanteiKhDengkSyuruiKbnExist(C_KhDengkSyuruiKbn.CREDITTORIKESIGK, ansyuuTaisyouGkBeanList)) {

                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.SYUUDANTEIKI);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.HONSYARYOUKIN);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.CREDITHENKIN_MINUSURIAGE);

            }
            else {
                commonSiwakeOutBean.setTantoCd(C_TantouCdKbn.BLNK0);
                commonSiwakeOutBean.setHuridensksKbn(C_HuridensksKbn.KOBETU);
                commonSiwakeOutBean.setDenshrhouKbn(C_DenshrhouKbn.KARIUKERSKNASI);
            }
        }

        if (!C_TantouCdKbn.BLNK0.eq(commonSiwakeOutBean.getTantoCd())) {

            BM_TantouCd tantouCd = ansyuuCommonSiwakeDao.getTantouCd(commonSiwakeOutBean.getTantoCd());

            commonSiwakeOutBean.setHuridenatesakiCd(tantouCd.getBusitucd());

        } else {
            commonSiwakeOutBean.setHuridenatesakiCd(C_Tantositucd.SYUUNOUSV.getValue());
        }

        busitucd = commonSiwakeOutBean.getHuridenatesakiCd();

        List<IT_KykSyouhn > kykSyouhnLst = null;
        if (!BizUtil.isBlank(syouhinCd) && syouhnsdno != null) {

            kykSyouhnLst = ansyuuCommonSiwakeDao.getKykSyouhn(pAnsyuuCommonSiwakeInBean.getSyono());

            if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {
                StringBuffer msgPam2 = new StringBuffer();

                msgPam2.append("契約商品テーブルから契約通貨種類が取得できません。  ");
                msgPam2.append("証券番号＝");
                msgPam2.append(pAnsyuuCommonSiwakeInBean.getSyono());
                throw new CommonBizAppException(msgPam2.toString());
            }
            commonSiwakeOutBean.setKyktuukaSyu(kykSyouhnLst.get(0).getKyktuukasyu());

        } else {

            commonSiwakeOutBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        }

        tuukasyu = commonSiwakeOutBean.getTuukasyu();

        segcd1 = C_Segcd.BLNK;
        segcd2 = C_Segcd.BLNK;

        if (!BizUtil.isBlank(syouhinCd) && syouhnsdno != null) {
            BzSegmentCdSyutoku  bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(syouhinCd,
                commonSiwakeOutBean.getKyktuukaSyu());

            if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
                StringBuffer msgPam1 = new StringBuffer();

                msgPam1.append("商品属性マスタからセグメントコードが取得できません。  ");
                msgPam1.append("主契約商品コード＝");
                msgPam1.append(syouhinCd);
                msgPam1.append("契約通貨種類＝");
                msgPam1.append(commonSiwakeOutBean.getKyktuukaSyu().getContent());

                throw new CommonBizAppException(msgPam1.toString());
            }

            segcd1 = syouhinbetuSegmentBean.getSegcd1();
            segcd2 = syouhinbetuSegmentBean.getSegcd2();
        }


        List<BzSiwakeMeisaiBean> karikataMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();
        List<BzSiwakeMeisaiBean> kasikataMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();
        C_TaisyakuKbn ibTaisyakukbn;
        C_Kanjyoukmkcd ibKanjyoukmkcd = C_Kanjyoukmkcd.BLNK;
        BizCurrency ibDenyenkagk;
        BizCurrency ibKeiyakutuukagk;
        String ibDenkarikanjyono;

        if (keijyoupGoukei.compareTo(taisyouGkZero) > 0) {

            if (syonendoSyokaip.compareTo(taisyouGkZero) > 0) {

                //                ibTaisyakukbn = C_TaisyakuKbn.KASIKATA;
                //                ibKanjyoukmkcd = C_Kanjyoukmkcd.P_SYO_SYOP;
                //                ibDenyenkagk = syonendoSyokaip;
                //                ibKeiyakutuukagk = syonendoSyokaip;
                //                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk);
                //
                //                kasikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }

            if (syonendo2KaimeIkoup.compareTo(taisyouGkZero) > 0) {

                ibTaisyakukbn = C_TaisyakuKbn.KASIKATA;
                if (C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU ;
                }
                else if (!C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    if (C_Tuukasyu.JPY.eq(tuukasyu)) {
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY;
                    } else if(C_Tuukasyu.USD.eq(tuukasyu)){
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD;
                    }else if(C_Tuukasyu.AUD.eq(tuukasyu)){
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD;
                    }
                }

                ibDenyenkagk = syonendo2KaimeIkoup;
                ibKeiyakutuukagk = syonendo2KaimeIkoup;
                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                kasikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }

            if (jinendoIkoup.compareTo(taisyouGkZero) > 0) {

                ibTaisyakukbn = C_TaisyakuKbn.KASIKATA;
                if (C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU ;
                }else if (!C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    if (C_Tuukasyu.JPY.eq(tuukasyu)) {
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY;
                    }
                    else if (C_Tuukasyu.USD.eq(tuukasyu)) {
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD;
                    }
                    else if (C_Tuukasyu.AUD.eq(tuukasyu)) {
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD;
                    }

                }
                ibDenyenkagk = jinendoIkoup;
                ibKeiyakutuukagk = jinendoIkoup;
                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                kasikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }

        }

        if (seisanpGoukei.compareTo(taisyouGkZero) > 0) {

            if (syonendoSyokaip.compareTo(taisyouGkZero) > 0) {

                //                ibTaisyakukbn = C_TaisyakuKbn.KARIKATA;
                //                ibKanjyoukmkcd = C_Kanjyoukmkcd.P_SYO_SYOP;
                //                ibDenyenkagk = syonendoSyokaip;
                //                ibKeiyakutuukagk = syonendoSyokaip;
                //                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk);
                //
                //                karikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }

            if (syonendo2KaimeIkoup.compareTo(taisyouGkZero) > 0) {

                ibTaisyakukbn = C_TaisyakuKbn.KARIKATA;
                if (C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU;
                }else if (!C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY;
                }

                ibDenyenkagk = syonendo2KaimeIkoup;
                ibKeiyakutuukagk = syonendo2KaimeIkoup;
                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                karikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }

            if (jinendoIkoup.compareTo(taisyouGkZero) > 0) {

                ibTaisyakukbn = C_TaisyakuKbn.KARIKATA;
                if (C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU ;
                }else if (!C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY ;
                }
                ibDenyenkagk = jinendoIkoup;
                ibKeiyakutuukagk = jinendoIkoup;
                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                karikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }

            if (sonotaHenreikin.compareTo(taisyouGkZero) > 0) {

                ibTaisyakukbn = C_TaisyakuKbn.KARIKATA;
                if (C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU;
                }else if (!C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY;
                }
                ibDenyenkagk = sonotaHenreikin;
                ibKeiyakutuukagk = sonotaHenreikin;
                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                karikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }
        }

        for (AnsyuuTaisyouGkBean ansyuuTaisyouGkBean : ansyuuTaisyouGkBeanList) {

            if (ansyuuTaisyouGkBean.getTaisyouGk().compareTo(taisyouGkZero) <= 0) {

                continue;
            }

            if (C_KhDengkSyuruiKbn.KEIJYOUP.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn()) ||
                C_KhDengkSyuruiKbn.SEISANK_KIHRKMP.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

                continue;
            }

            if (C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

                ibTaisyakukbn = C_TaisyakuKbn.KARIKATA;
                if (C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU;
                }
                else if (!C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                    if (C_Tuukasyu.JPY.eq(tuukasyu)) {
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY;
                    } else if (C_Tuukasyu.USD.eq(tuukasyu)) {
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD;
                    } else if (C_Tuukasyu.AUD.eq(tuukasyu)) {
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD;
                    }
                }
                ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();
                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                karikataMeisaiBeanLst.add(siwakeMeisaiBean);

            }
            else if (C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {
                if (!BizUtil.isBlank(ansyuuTaisyouGkBean.getDenkarikanjyono())) {
                    ibTaisyakukbn = C_TaisyakuKbn.KASIKATA;
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SONOTA;
                    ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                    ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();
                    ibDenkarikanjyono = ansyuuTaisyouGkBean.getDenkarikanjyono();
                    BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk,
                        ibDenkarikanjyono);

                    kasikataMeisaiBeanLst.add(siwakeMeisaiBean);
                }
                else {
                    if (!BizUtil.isBlank(syouhinCd) && syouhnsdno != null){
                        ibTaisyakukbn = C_TaisyakuKbn.KASIKATA;
                        if (C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                            ibKanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU ;
                        }else if (!C_Tuukasyu.JPY.eq(commonSiwakeOutBean.getKyktuukaSyu())) {
                            ibKanjyoukmkcd = C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY ;
                        }
                        ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                        ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();
                    }else{
                        ibTaisyakukbn = C_TaisyakuKbn.KASIKATA;
                        ibKanjyoukmkcd = C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY ;
                        ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                        ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();
                    }

                    BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                    kasikataMeisaiBeanLst.add(siwakeMeisaiBean);
                }
            }
            else if (C_KhDengkSyuruiKbn.SHRTIENRSK.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {
                //
                //                // TODO:コメントアウト
                //                /*
                //                BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                //
                //                siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                //                siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU);
                //                siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                //                siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                //                siwakeMeisaiBean.setIbDenyenkagk(ansyuuTaisyouGkBean.getTaisyouGk());
                //                siwakeMeisaiBean.setIbSeg1cd(pAnsyuuCommonSiwakeInBean.getSegcd1());
                //                siwakeMeisaiBean.setIbSeg2cd(pAnsyuuCommonSiwakeInBean.getSegcd2());
                //                siwakeMeisaiBean.setIbKeiyakutuukagk(ansyuuTaisyouGkBean.getKeiyakutuukaGk());
                //
                //                karikataMeisaiBeanLst.add(siwakeMeisaiBean);*/
            }
            else if (C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

                if (C_Nykkeiro.KZHRK.eq(pAnsyuuCommonSiwakeInBean.getNykkeiro())) {

                    ibTaisyakukbn = C_TaisyakuKbn.KARIKATA;
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU;
                    ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                    ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();
                    BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                    karikataMeisaiBeanLst.add(siwakeMeisaiBean);
                }
                else if (C_Nykkeiro.CREDIT.eq(pAnsyuuCommonSiwakeInBean.getNykkeiro())) {

                    ibTaisyakukbn = C_TaisyakuKbn.KARIKATA;
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE;
                    ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                    ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();

                    BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                    karikataMeisaiBeanLst.add(siwakeMeisaiBean);
                }
                else if (C_Nykkeiro.KYHKIN.eq(pAnsyuuCommonSiwakeInBean.getNykkeiro()) ||
                    C_Nykkeiro.HKNKIN.eq(pAnsyuuCommonSiwakeInBean.getNykkeiro())) {
                    //
                    //                    // TODO:コメントアウト
                    //                    /*
                    //                    BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                    //
                    //                    siwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                    //                    siwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIBARAI_HOKENKEIYAKU_SYUNOSONOTA);
                    //                    siwakeMeisaiBean.setIbSuitoubumoncd(commonSiwakeOutBean.getHuridenatesakiCd());
                    //                    siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
                    //                    siwakeMeisaiBean.setIbDenyenkagk(ansyuuTaisyouGkBean.getTaisyouGk());
                    //                    siwakeMeisaiBean.setIbSeg1cd(C_Segcd.BLNK);
                    //                    siwakeMeisaiBean.setIbSeg2cd(C_Segcd.BLNK);
                    //                    siwakeMeisaiBean.setIbKeiyakutuukagk(ansyuuTaisyouGkBean.getKeiyakutuukaGk());
                    //
                    //                    karikataMeisaiBeanLst.add(siwakeMeisaiBean);*/
                    //
                }
                else if (C_Nykkeiro.BANK.eq(pAnsyuuCommonSiwakeInBean.getNykkeiro())) {

                    ibTaisyakukbn = C_TaisyakuKbn.KARIKATA;
                    ibKanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE;
                    ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                    ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();
                    BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                    karikataMeisaiBeanLst.add(siwakeMeisaiBean);
                }

            }
            else if (C_KhDengkSyuruiKbn.SHRGK.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

                ibTaisyakukbn = C_TaisyakuKbn.KASIKATA;
                ibKanjyoukmkcd = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN;
                ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();
                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                kasikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }
            else if (C_KhDengkSyuruiKbn.CREDITTORIKESIGK.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {

                ibTaisyakukbn = C_TaisyakuKbn.KASIKATA;
                ibKanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE;
                ibDenyenkagk = ansyuuTaisyouGkBean.getTaisyouGk();
                ibKeiyakutuukagk = ansyuuTaisyouGkBean.getKeiyakutuukaGk();
                BzSiwakeMeisaiBean siwakeMeisaiBean = createSiwakeMeisaiBean(ibTaisyakukbn, ibKanjyoukmkcd, ibDenyenkagk, ibKeiyakutuukagk, "");

                kasikataMeisaiBeanLst.add(siwakeMeisaiBean);
            }
        }

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();
        siwakeMeisaiBeanLst.addAll(karikataMeisaiBeanLst);
        siwakeMeisaiBeanLst.addAll(kasikataMeisaiBeanLst);

        commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(siwakeMeisaiBeanLst);

        for(BzSiwakeMeisaiBean siwakeMeisaiBean : siwakeMeisaiBeanLst){
            C_TaisyakuKbn taisyakukbn = siwakeMeisaiBean.getIbTaisyakukbn();
            C_Kanjyoukmkcd kanjyoukmkcd = siwakeMeisaiBean.getIbKanjyoukmkcd();

            if(C_TaisyakuKbn.KASIKATA.eq(taisyakukbn)){
                if(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN.eq(kanjyoukmkcd)){
                    commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.KOUZAHURIKOMI);
                    break;
                }
                else if(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE.eq(kanjyoukmkcd)){
                    commonSiwakeOutBean.setDenhnknhouKbn(C_DenhnknhouKbn.CREDITHENKIN_MINUSURIAGE);
                    break;
                }
            }
        }

        logger.debug("△ 案内収納用仕訳共通処理 終了");
        return commonSiwakeOutBean;
    }

    private BzSiwakeMeisaiBean createSiwakeMeisaiBean(C_TaisyakuKbn pIbTaisyakukbn, C_Kanjyoukmkcd pIbKanjyoukmkcd,
        BizCurrency pIbDenyenkagk, BizCurrency pIbKeiyakutuukagk, String pDenkarikanjyono) {

        BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

        siwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        siwakeMeisaiBean.setIbTaisyakukbn(pIbTaisyakukbn);
        siwakeMeisaiBean.setIbKanjyoukmkcd(pIbKanjyoukmkcd);
        if (C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN.eq(pIbKanjyoukmkcd)) {
            siwakeMeisaiBean.setIbSuitoubumoncd(C_Tantositucd.SIKINKOUBAIKANRI.getValue());
        } else {
            siwakeMeisaiBean.setIbSuitoubumoncd(busitucd);
        }
        if(!C_Tuukasyu.JPY.eq(tuukasyu)) {
            siwakeMeisaiBean.setIbDengaikagk(pIbDenyenkagk);
        }
        if (C_Tuukasyu.JPY.eq(tuukasyu)) {
            siwakeMeisaiBean.setIbDenyenkagk(pIbDenyenkagk);
        }
        siwakeMeisaiBean.setIbSeg1cd(segcd1);
        siwakeMeisaiBean.setIbSeg2cd(segcd2);
        siwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        if(!C_Tuukasyu.JPY.eq(tuukasyu)) {
            siwakeMeisaiBean.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        }
        siwakeMeisaiBean.setIbDenkarikanjyono(pDenkarikanjyono);

        return siwakeMeisaiBean;
    }

    private boolean hanteiKhDengkSyuruiKbnExist(C_KhDengkSyuruiKbn pKhDengkSyuruiKbn, List<AnsyuuTaisyouGkBean> pAnsyuuTaisyouGkBeanList) {

        for (AnsyuuTaisyouGkBean ansyuuTaisyouGkBean : pAnsyuuTaisyouGkBeanList) {
            if (pKhDengkSyuruiKbn.eq(ansyuuTaisyouGkBean.getKhDengkSyuruiKbn())) {
                return true;
            }
        }
        return false;
    }
}