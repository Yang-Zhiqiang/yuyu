package yuyu.common.biz.kaikei;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt.BzHijynbrSikinIdouDataTysytDao;
import yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt.GengkZengoPTysytBean;
import yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt.KhDenrennoBean;
import yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt.PZenhnjiSikinIdougkTysytBean;
import yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt.SiDenrennoBean;
import yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt.SikinIdougkTysytBean;
import yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt.SkDataTysytBean;
import yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt.SkDenrennoBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.def.classification.C_GkhnkzidourtKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HijynbrsikinidouyouKbn;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.db.entity.BT_DenpyoData;

/**
 * 業務共通 経理・会計 平準払資金移動データ抽出
 */
public class BzHijynbrSikinIdouDataTysyt {

    public static final String GENGAKU = "RB10";

    public static final String SBSISATEI = "RC05";

    public static final String IT_KYKKIHON = "IT_KykKihon";

    public static final String HRKP = "hrkp";

    private BizDate syoriYmd;

    private HashMap<String, Boolean> denrennoMap;

    @Inject
    private static Logger logger;

    @Inject
    private BzHijynbrSikinIdouDataTysytDao bzHijynbrSikinIdouDataTysytDao;

    public BzHijynbrSikinIdouDataTysyt() {
        super();
    }

    public void init (BizDate pSyoriYmd) {

        logger.debug("▽ 平準払資金移動データ抽出 初期化処理 開始");

        syoriYmd = pSyoriYmd;
        denrennoMap = new HashMap<String, Boolean>();

        logger.debug("△ 平準払資金移動データ抽出 初期化処理 終了");
    }

    public void getSkDenrenno() {

        logger.debug("▽ 平準払資金移動データ抽出 新契約伝票データ連番取得 開始");

        try (ExDBResults<SkDenrennoBean> skDenrennoBeanLst =
            bzHijynbrSikinIdouDataTysytDao.getSkDenrennoBeans(syoriYmd)) {

            for (SkDenrennoBean skDenrennoBean : skDenrennoBeanLst) {

                denrennoMap.put(skDenrennoBean.getDenRenno(), false);
            }
        }

        logger.debug("△ 平準払資金移動データ抽出 新契約伝票データ連番取得 終了");
    }

    public void getKhDenrenno() {

        logger.debug("▽ 平準払資金移動データ抽出 契約保全伝票データ連番取得 開始");

        try (ExDBResults<KhDenrennoBean> khDenrennoBeanLst =
            bzHijynbrSikinIdouDataTysytDao.getKhDenrennoBeans(syoriYmd)) {

            for (KhDenrennoBean khDenrennoBean : khDenrennoBeanLst) {

                denrennoMap.put(khDenrennoBean.getDenRenno(), false);
            }
        }

        logger.debug("△ 平準払資金移動データ抽出 契約保全伝票データ連番取得 終了");
    }

    public void getSiDenrenno() {

        logger.debug("▽ 平準払資金移動データ抽出 支払伝票データ連番取得 開始");

        try (ExDBResults<SiDenrennoBean> siDenrennoBeanLst =
            bzHijynbrSikinIdouDataTysytDao.getSiDenrennoBeans(syoriYmd)) {

            for (SiDenrennoBean siDenrennoBean : siDenrennoBeanLst) {

                denrennoMap.put(siDenrennoBean.getDenRenno(), false);
            }
        }

        logger.debug("△ 平準払資金移動データ抽出 支払伝票データ連番取得 終了");
    }

    public void keisanHijynbrSikinIdougk(BT_DenpyoData pDenpyoData) {

        logger.debug("▽ 平準払資金移動データ抽出 平準払資金移動金額算出処理 開始");

        C_HijynbrsikinidouyouKbn hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.BLNK;
        BizCurrency hijynbrsikinidouGk = BizCurrency.valueOf(0, getCurrencyType(pDenpyoData.getKyktuukasyu()));
        C_Segcd segcd = C_Segcd.BLNK;
        C_HijynnykzndkkouzaKbn hijynNykzndkKouzaKbn = C_HijynnykzndkkouzaKbn.BLNK;
        C_GkhnkzidourtKbn fstpGkhnkzidourt = C_GkhnkzidourtKbn.BLNK;
        C_GkhnkzidourtKbn zenkizennouGkhnkzidourt = C_GkhnkzidourtKbn.BLNK;
        C_TaisyakuKbn taisyakuKbn = pDenpyoData.getTaisyakukbn();
        C_Kanjyoukmkcd kanjyoukmkcd = pDenpyoData.getKanjyoukmkcd();

        if (!denrennoMap.containsKey(pDenpyoData.getDenrenno())) {

            hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.HI;
        }

        else {

            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            BzSikinIdouHanteiInfoSyutoku bzSikinIdouHanteiInfoSyutoku =
                SWAKInjector.getInstance(BzSikinIdouHanteiInfoSyutoku.class);

            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                pDenpyoData.getSyusyouhncd(),
                pDenpyoData.getKyktuukasyu());

            segcd = syouhinbetuSegmentBean.getSegcd1();

            SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoBean =
                bzSikinIdouHanteiInfoSyutoku.getSikinIdouHanteiInfoDataBean(segcd);

            hijynNykzndkKouzaKbn = sikinIdouHanteiInfoBean.getHijynnykZndkkouzaKbn();
            fstpGkhnkzidourt = sikinIdouHanteiInfoBean.getFstpGkhnkzidouRt();
            zenkizennouGkhnkzidourt = sikinIdouHanteiInfoBean.getZenkiZennouGkhnkzidouRt();

            if (C_TaisyakuKbn.KARIKATA.eq(taisyakuKbn) &&
                (C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD.eq(kanjyoukmkcd))) {

                if (C_HijynnykzndkkouzaKbn.YENHONKZ.eq(hijynNykzndkKouzaKbn)) {
                    HijynbrSikinIdoukmBean hijynbrSikinIdoukmBean = keisanPkamokuSikinIdougk(pDenpyoData);
                    hijynbrsikinidouyouKbn = hijynbrSikinIdoukmBean.getHijynbrsikinidouyouKbn();
                    hijynbrsikinidouGk = hijynbrSikinIdoukmBean.getHijynbrsikinidougk();
                }

                if (C_HijynnykzndkkouzaKbn.GKHONKZ.eq(hijynNykzndkKouzaKbn)) {
                    if (BizUtil.isZero(pDenpyoData.getKeiyakutuukagk())) {
                        hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.HI;
                    }
                    else {
                        hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.YOU;
                        hijynbrsikinidouGk = pDenpyoData.getKeiyakutuukagk();
                    }
                }
            }

            else if (C_TaisyakuKbn.KARIKATA.eq(taisyakuKbn) &&
                (C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD.eq(kanjyoukmkcd))) {

                if (C_HijynnykzndkkouzaKbn.YENHONKZ.eq(hijynNykzndkKouzaKbn)) {
                    HijynbrSikinIdoukmBean hijynbrSikinIdoukmBean = keisanSonotahrSikinIdougk(pDenpyoData);
                    hijynbrsikinidouyouKbn = hijynbrSikinIdoukmBean.getHijynbrsikinidouyouKbn();
                    hijynbrsikinidouGk = hijynbrSikinIdoukmBean.getHijynbrsikinidougk();
                }

                if (C_HijynnykzndkkouzaKbn.GKHONKZ.eq(hijynNykzndkKouzaKbn)) {
                    if (BizUtil.isZero(pDenpyoData.getKeiyakutuukagk())) {
                        hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.HI;
                    }
                    else {
                        hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.YOU;
                        hijynbrsikinidouGk = pDenpyoData.getKeiyakutuukagk();
                    }
                }
            }

            else if (C_TaisyakuKbn.KARIKATA.eq(taisyakuKbn) &&
                (C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_AUD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_AUD.eq(kanjyoukmkcd))) {

                hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.YOU;
                hijynbrsikinidouGk = pDenpyoData.getKeiyakutuukagk();

                SkDataTysytBean skDataTysytBean = bzHijynbrSikinIdouDataTysytDao.getSkDataTysytBeans(pDenpyoData.getKeirisyono());
                BizCurrency misyuup = skDataTysytBean.getMisyuup();

                if (!BizUtil.isZero(misyuup)) {

                    hijynbrsikinidouGk = hijynbrsikinidouGk.subtract(misyuup);
                }
            }

            else if (C_TaisyakuKbn.KARIKATA.eq(taisyakuKbn) &&
                (C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_AUD.eq(kanjyoukmkcd))) {

                hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.YOU;
                hijynbrsikinidouGk = pDenpyoData.getKeiyakutuukagk();
            }

            else if (C_TaisyakuKbn.KARIKATA.eq(taisyakuKbn) &&
                (C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD.eq(kanjyoukmkcd))) {

                if (BizUtil.isZero(pDenpyoData.getKeiyakutuukagk())) {

                    hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.HI;
                }
                else {

                    hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.YOU;
                    hijynbrsikinidouGk = pDenpyoData.getKeiyakutuukagk();
                }
            }

            else if (C_TaisyakuKbn.KARIKATA.eq(taisyakuKbn) &&
                (C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_USD.eq(kanjyoukmkcd) ||
                    C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD.eq(kanjyoukmkcd))) {

                if (C_GkhnkzidourtKbn.GKKZDIRECT.eq(fstpGkhnkzidourt) &&
                    C_GkhnkzidourtKbn.GKKZDIRECT.eq(zenkizennouGkhnkzidourt)) {

                    hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.YOU;
                    hijynbrsikinidouGk = pDenpyoData.getKeiyakutuukagk();
                }
                else {
                    hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.HI;
                }
            }
            else {

                hijynbrsikinidouyouKbn = C_HijynbrsikinidouyouKbn.HI;
            }
        }

        pDenpyoData.setHijynbrsikinidouyoukbn(hijynbrsikinidouyouKbn);
        pDenpyoData.setHijynbrsikinidougk(hijynbrsikinidouGk);

        logger.debug("△ 平準払資金移動データ抽出 平準払資金移動金額算出処理 終了");
    }

    private HijynbrSikinIdoukmBean keisanPkamokuSikinIdougk(BT_DenpyoData pDenpyoData) {

        HijynbrSikinIdoukmBean hijynbrSikinIdoukmBean = SWAKInjector.getInstance(HijynbrSikinIdoukmBean.class);
        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.BLNK);
        hijynbrSikinIdoukmBean.setHijynbrsikinidougk(BizCurrency.valueOf(0, getCurrencyType(pDenpyoData.getKyktuukasyu())));

        if (denrennoMap.get(pDenpyoData.getDenrenno())) {

            hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.HI);

            return hijynbrSikinIdoukmBean;
        }

        if (GENGAKU.equals(pDenpyoData.getSyoricd())) {

            hijynbrSikinIdoukmBean = keisanGengkSikinIdougk(pDenpyoData);

            return hijynbrSikinIdoukmBean;
        }

        List<PZenhnjiSikinIdougkTysytBean> pZenhnjiSikinIdougkTysytBeanLst = bzHijynbrSikinIdouDataTysytDao.
            getPZenhnjiSikinIdougkTysytBeans(pDenpyoData.getKeirisyono(), pDenpyoData.getDenrenno());

        if (pZenhnjiSikinIdougkTysytBeanLst.size() > 0) {

            hijynbrSikinIdoukmBean = keisanPzenhnknSikinIdougk(pDenpyoData, pZenhnjiSikinIdougkTysytBeanLst);

            return hijynbrSikinIdoukmBean;
        }

        hijynbrSikinIdoukmBean = keisanSikinIdouzuMikeikap(pDenpyoData);
        return hijynbrSikinIdoukmBean;

    }

    private HijynbrSikinIdoukmBean keisanSonotahrSikinIdougk(BT_DenpyoData pDenpyoData) {

        HijynbrSikinIdoukmBean hijynbrSikinIdoukmBean = SWAKInjector.getInstance(HijynbrSikinIdoukmBean.class);
        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.BLNK);
        hijynbrSikinIdoukmBean.setHijynbrsikinidougk(BizCurrency.valueOf(0, getCurrencyType(pDenpyoData.getKyktuukasyu())));


        if (GENGAKU.equals(pDenpyoData.getSyoricd())) {

            if (denrennoMap.get(pDenpyoData.getDenrenno())) {

                hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.HI);

                return hijynbrSikinIdoukmBean;
            }

            hijynbrSikinIdoukmBean = keisanGengkSikinIdougk(pDenpyoData);
            return hijynbrSikinIdoukmBean;

        }

        List<PZenhnjiSikinIdougkTysytBean> pZenhnjiSikinIdougkTysytBeanLst = bzHijynbrSikinIdouDataTysytDao.
            getPZenhnjiSikinIdougkTysytBeans(pDenpyoData.getKeirisyono(), pDenpyoData.getDenrenno());

        if (pZenhnjiSikinIdougkTysytBeanLst.size() > 0) {
            if (denrennoMap.get(pDenpyoData.getDenrenno())) {

                hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.HI);

                return hijynbrSikinIdoukmBean;
            }

            hijynbrSikinIdoukmBean = keisanPzenhnknSikinIdougk(pDenpyoData, pZenhnjiSikinIdougkTysytBeanLst);

            return hijynbrSikinIdoukmBean;
        }

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.HI);


        String syono = bzHijynbrSikinIdouDataTysytDao.getAzukarikinSyono(pDenpyoData.getKeirisyono());

        if (syono != null) {

            HijynbrSikinIdoukmBean zitkaHijynbrSikinIdoukmBean = keisanZitkazukariknSikinIdougk(pDenpyoData);

            hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(zitkaHijynbrSikinIdoukmBean.getHijynbrsikinidouyouKbn());
            hijynbrSikinIdoukmBean.setHijynbrsikinidougk(hijynbrSikinIdoukmBean.getHijynbrsikinidougk().add(
                zitkaHijynbrSikinIdoukmBean.getHijynbrsikinidougk()));
        }


        BizCurrency tumitateGk = bzHijynbrSikinIdouDataTysytDao.getKhShrRirekiSyuShrgkkei(pDenpyoData.getKeirisyono(),
            pDenpyoData.getDenrenno());

        if (tumitateGk != null) {

            hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.YOU);
            hijynbrSikinIdoukmBean.setHijynbrsikinidougk(hijynbrSikinIdoukmBean.getHijynbrsikinidougk().add(tumitateGk));
        }


        if (SBSISATEI.equals(pDenpyoData.getSyoricd())) {

            syono = bzHijynbrSikinIdouDataTysytDao.getSkSyono(pDenpyoData.getKeirisyono());
        }

        else {

            syono = bzHijynbrSikinIdouDataTysytDao.getKihrkmpSeisanRirekiSyono(pDenpyoData.getKeirisyono(),
                pDenpyoData.getDenrenno());

            if (syono == null) {
                syono = bzHijynbrSikinIdouDataTysytDao.getKhShrRirekiSyono(pDenpyoData.getKeirisyono(),
                    pDenpyoData.getDenrenno());
            }
        }

        if (syono != null) {

            if (!denrennoMap.get(pDenpyoData.getDenrenno())) {

                HijynbrSikinIdoukmBean keikapHijynbrSikinIdoukmBean = keisanSikinIdouzuMikeikap(pDenpyoData);

                if (C_HijynbrsikinidouyouKbn.YOUP.eq(keikapHijynbrSikinIdoukmBean.getHijynbrsikinidouyouKbn())) {

                    hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(keikapHijynbrSikinIdoukmBean.getHijynbrsikinidouyouKbn());
                }

                hijynbrSikinIdoukmBean.setHijynbrsikinidougk(hijynbrSikinIdoukmBean.getHijynbrsikinidougk().
                    add(keikapHijynbrSikinIdoukmBean.getHijynbrsikinidougk()));
            }
        }

        return hijynbrSikinIdoukmBean;
    }

    private HijynbrSikinIdoukmBean keisanPzenhnknSikinIdougk(BT_DenpyoData pDenpyoData,
        List<PZenhnjiSikinIdougkTysytBean> pZenhnjiSikinIdougkTysytBeanLst) {

        HijynbrSikinIdoukmBean hijynbrSikinIdoukmBean = SWAKInjector.getInstance(HijynbrSikinIdoukmBean.class);

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.BLNK);
        hijynbrSikinIdoukmBean.setHijynbrsikinidougk(BizCurrency.valueOf(0, getCurrencyType(pDenpyoData.getKyktuukasyu())));

        BizDateYM nyktrksJkiPJytYM = bzHijynbrSikinIdouDataTysytDao.getNyktrksJkiPJytYM(pDenpyoData.getKeirisyono(), syoriYmd);

        for (PZenhnjiSikinIdougkTysytBean pZenhnjiSikinIdougkTysytBean : pZenhnjiSikinIdougkTysytBeanLst) {

            if (nyktrksJkiPJytYM == null ||
                BizDateUtil.compareYm(nyktrksJkiPJytYM, pZenhnjiSikinIdougkTysytBean.getSikinidoupjytym()) == BizDateUtil.COMPARE_GREATER) {

                hijynbrSikinIdoukmBean.setHijynbrsikinidougk(hijynbrSikinIdoukmBean.getHijynbrsikinidougk().add(
                    pZenhnjiSikinIdougkTysytBean.getSiteituukagk()));
            }
        }

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.YOUP);
        denrennoMap.put(pDenpyoData.getDenrenno(), true);

        return hijynbrSikinIdoukmBean;
    }

    private HijynbrSikinIdoukmBean keisanSikinIdouzuMikeikap(BT_DenpyoData pDenpyoData) {

        HijynbrSikinIdoukmBean hijynbrSikinIdoukmBean = SWAKInjector.getInstance(HijynbrSikinIdoukmBean.class);
        BizDateYM mikeikapZennouJytym = null;

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.BLNK);
        hijynbrSikinIdoukmBean.setHijynbrsikinidougk(BizCurrency.valueOf(0, getCurrencyType(pDenpyoData.getKyktuukasyu())));

        if (SBSISATEI.equals(pDenpyoData.getSyoricd())) {

            SkDataTysytBean skDataTysytBean = bzHijynbrSikinIdouDataTysytDao.getSkDataTysytBeans(pDenpyoData.getKeirisyono());
            mikeikapZennouJytym = skDataTysytBean.getMikeikapjyuutouym();
        }

        else {

            mikeikapZennouJytym = bzHijynbrSikinIdouDataTysytDao.getKihrkmpSeisanRirekiJyuutouym(
                pDenpyoData.getKeirisyono(), pDenpyoData.getDenrenno());
        }

        if (mikeikapZennouJytym == null) {

            BizDate zennouseisankijyunYmd = bzHijynbrSikinIdouDataTysytDao.getZennouZennouSeisanKijyunymd(
                pDenpyoData.getKeirisyono());

            BizDate kykYmd = bzHijynbrSikinIdouDataTysytDao.getKykSyouhnKykymd(pDenpyoData.getKeirisyono());

            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

            BizDate zennouseisanOutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, kykYmd, C_Hrkkaisuu.NEN, zennouseisankijyunYmd);
            mikeikapZennouJytym = zennouseisanOutouYmd.getBizDateYM();
        }

        List<SikinIdougkTysytBean> sikinIdougkTysytBeanLst = bzHijynbrSikinIdouDataTysytDao.getSikinIdougkTysytBeans(pDenpyoData.getKeirisyono(), mikeikapZennouJytym);

        if (sikinIdougkTysytBeanLst.size() == 0) {

            hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.HI);
            denrennoMap.put(pDenpyoData.getDenrenno(), true);
            return hijynbrSikinIdoukmBean;
        }

        GengkZengoPTysytBean gengkZengoPTysytBean = bzHijynbrSikinIdouDataTysytDao.getGengkZengoPTysytBean(
            pDenpyoData.getKeirisyono(), syoriYmd, IKhozenCommonConstants.KINOUID_GENGAKU, IT_KYKKIHON, HRKP);

        boolean toujituGengakuFlg = false;

        BizDateYM gengakuKaisiYm = null;

        BizCurrency newgengakuHokennryou = null;

        if (gengkZengoPTysytBean != null) {

            toujituGengakuFlg = true;

            newgengakuHokennryou = BizCurrency.valueOf(new BigDecimal(gengkZengoPTysytBean.getNewnaiyou()), BizCurrencyTypes.YEN);

            gengakuKaisiYm = bzHijynbrSikinIdouDataTysytDao.getHokenryouTmttknTmttknTaisyouymMax(
                pDenpyoData.getKeirisyono(), IKhozenCommonConstants.KINOUID_GENGAKU);

        }

        BizDateYM nyktrksJkiPJytYM = bzHijynbrSikinIdouDataTysytDao.getNyktrksJkiPJytYM(pDenpyoData.getKeirisyono(), syoriYmd);

        for (SikinIdougkTysytBean sikinIdougkTysytBean : sikinIdougkTysytBeanLst) {

            if (nyktrksJkiPJytYM == null ||
                BizDateUtil.compareYm(nyktrksJkiPJytYM, sikinIdougkTysytBean.getSikinidoupjytym()) == BizDateUtil.COMPARE_GREATER) {

                if (toujituGengakuFlg &&
                    (BizDateUtil.compareYm(sikinIdougkTysytBean.getSikinidoupjytym(), gengakuKaisiYm) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYm(sikinIdougkTysytBean.getSikinidoupjytym(), gengakuKaisiYm) == BizDateUtil.COMPARE_EQUAL)) {

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                    BizCurrency kanzanGaku = keisanGaikakanzan.execDivide(pDenpyoData.getKyktuukasyu(),
                        newgengakuHokennryou,
                        sikinIdougkTysytBean.getSikinidoukawaserate(),
                        C_HasuusyoriKbn.AGE);
                    hijynbrSikinIdoukmBean.setHijynbrsikinidougk(hijynbrSikinIdoukmBean.getHijynbrsikinidougk().add(
                        kanzanGaku));
                }
                else {

                    hijynbrSikinIdoukmBean.setHijynbrsikinidougk(hijynbrSikinIdoukmBean.getHijynbrsikinidougk().add(
                        sikinIdougkTysytBean.getSiteituukagk()));
                }
            }
        }

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.YOUP);
        denrennoMap.put(pDenpyoData.getDenrenno(), true);

        return hijynbrSikinIdoukmBean;
    }

    private HijynbrSikinIdoukmBean keisanGengkSikinIdougk(BT_DenpyoData pDenpyoData) {

        HijynbrSikinIdoukmBean hijynbrSikinIdoukmBean = SWAKInjector.getInstance(HijynbrSikinIdoukmBean.class);

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.BLNK);
        hijynbrSikinIdoukmBean.setHijynbrsikinidougk(BizCurrency.valueOf(0, getCurrencyType(pDenpyoData.getKyktuukasyu())));

        BizDateYM gengakuKaisi = bzHijynbrSikinIdouDataTysytDao.getHokenryouTmttknTmttknTaisyouymMax(
            pDenpyoData.getKeirisyono(), IKhozenCommonConstants.KINOUID_GENGAKU);

        List<SikinIdougkTysytBean> sikinIdougkTysytBeanLst = bzHijynbrSikinIdouDataTysytDao.getSikinIdougkTysytBeans(pDenpyoData.getKeirisyono(), gengakuKaisi);

        if (sikinIdougkTysytBeanLst.size() == 0) {

            hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.HI);
            denrennoMap.put(pDenpyoData.getDenrenno(), true);
            return hijynbrSikinIdoukmBean;
        }

        GengkZengoPTysytBean gengkZengoPTysytBean = bzHijynbrSikinIdouDataTysytDao.getGengkZengoPTysytBean(
            pDenpyoData.getKeirisyono(), syoriYmd, IKhozenCommonConstants.KINOUID_GENGAKU, IT_KYKKIHON, HRKP);

        BizCurrency bfgengakuHokennryou = BizCurrency.valueOf(new BigDecimal(gengkZengoPTysytBean.getBfrnaiyou()), BizCurrencyTypes.YEN);

        BizCurrency newgengakuHokennryou = BizCurrency.valueOf(new BigDecimal(gengkZengoPTysytBean.getNewnaiyou()), BizCurrencyTypes.YEN);

        BizCurrency sabunHokennryou = bfgengakuHokennryou.subtract(newgengakuHokennryou);

        BizDateYM nyktrksJkiPJytYM = bzHijynbrSikinIdouDataTysytDao.getNyktrksJkiPJytYM(pDenpyoData.getKeirisyono(), syoriYmd);

        for (SikinIdougkTysytBean sikinIdougkTysytBean : sikinIdougkTysytBeanLst) {

            if (nyktrksJkiPJytYM == null ||
                BizDateUtil.compareYm(nyktrksJkiPJytYM, sikinIdougkTysytBean.getSikinidoupjytym()) == BizDateUtil.COMPARE_GREATER) {

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                hijynbrSikinIdoukmBean.setHijynbrsikinidougk(hijynbrSikinIdoukmBean.getHijynbrsikinidougk().add(
                    keisanGaikakanzan.execDivide(pDenpyoData.getKyktuukasyu(),
                        sabunHokennryou,
                        sikinIdougkTysytBean.getSikinidoukawaserate(),
                        C_HasuusyoriKbn.AGE)));
            }
        }

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.YOUP);

        denrennoMap.put(pDenpyoData.getDenrenno(), true);

        return hijynbrSikinIdoukmBean;
    }

    private HijynbrSikinIdoukmBean keisanZitkazukariknSikinIdougk(BT_DenpyoData pDenpyoData) {

        HijynbrSikinIdoukmBean hijynbrSikinIdoukmBean = SWAKInjector.getInstance(HijynbrSikinIdoukmBean.class);
        BizCurrency zitkazukarikingkSiteituuka = BizCurrency.valueOf(0);

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.BLNK);
        hijynbrSikinIdoukmBean.setHijynbrsikinidougk(BizCurrency.valueOf(0, getCurrencyType(pDenpyoData.getKyktuukasyu())));

        if (SBSISATEI.equals(pDenpyoData.getSyoricd())) {

            SkDataTysytBean skDataTysytBean = bzHijynbrSikinIdouDataTysytDao.getSkDataTysytBeans(pDenpyoData.getKeirisyono());

            zitkazukarikingkSiteituuka = skDataTysytBean.getZitkazukarikingksiteituuka();
        }

        else {

            zitkazukarikingkSiteituuka = bzHijynbrSikinIdouDataTysytDao.getKhShrRirekiZitkAzukarikingkSiteituuka(
                pDenpyoData.getKeirisyono(), pDenpyoData.getDenrenno());
        }

        hijynbrSikinIdoukmBean.setHijynbrsikinidouyouKbn(C_HijynbrsikinidouyouKbn.YOU);
        hijynbrSikinIdoukmBean.setHijynbrsikinidougk(zitkazukarikingkSiteituuka);

        return hijynbrSikinIdoukmBean;
    }

    private CurrencyType getCurrencyType(C_Tuukasyu pTuukasyu) {
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        return henkanTuuka.henkanTuukaKbnToType(pTuukasyu);
    }

}
