package yuyu.common.bosyuu.hbkeiyakusyoukai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;

import org.slf4j.Logger;

import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.GetKhKykdrInfo;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoBean;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SinsaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TanmatuSiyouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IM_KhHenkouUktksyorikahi;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouUktkBean;
import yuyu.def.hozen.sorter.SortIT_AnsyuRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;

import com.google.common.base.Strings;

/**
 * 保険募集 契約内容照会 生保Ｗｅｂ契約内容照会クラス
 */
public class HbKeiyakuSyoukai {

    private static String[] GYOUMUKOUSINKINOUS = {IKhozenCommonConstants.KINOUID_GENGAKU
        , IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU
        , IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU
        , IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU
        , IKhozenCommonConstants.KINOUID_KANAKANJITEISEI
        , IKhozenCommonConstants.KINOUID_KHKZKTRKKYKDRTKYKHNK
        , IKhozenCommonConstants.KINOUID_MEIGIHENKOU
        , IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK
        , IKhozenCommonConstants.KINOUID_SEINENGAPPISEI
        , IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA};

    private WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean;

    private static final String ERRORMESSAGE1 = "参照権限がありません";

    private static final String ERRORMESSAGE2 =
        "誤った証券番号が入力されています。正しい証券番号を確認のうえ、再度照会ください。";

    private static final String ERRORMESSAGE3 = "選択されたご契約についてはご照会できません。";

    private static final String ERRORMESSAGE4 = "選択されたご契約は、他代理店募集契約につき、ご照会できません。";

    private static final String ERRORMESSAGE5 = "選択されたご契約については手続き中のためご照会できません。";

    private static final String HBWEBKINOUID = "PO99";

    private static final String SBUKTNM_HUKUSUU = "複数";

    private static final int SYOHNNM_MAX_LENGTH = 61;

    private static final String AISYOMEIKBN_CHANNEL_SMBC_1 = "2";

    private static final String AISYOMEIKBN_CHANNEL_SMBC_2 = "7";

    private static final String TEIRITUZOUKAKRIRW_TEIRITUNOMI = "１００";

    private static final String TEIRITUZOUKAKRIRW_SISUUNOMI = "　　０";

    private static final String KEISYOU_SAMA = "　様";

    private static final String SYOKITIHAIFUN = "－";

    private static final String HKNRSNJK_SEIJOUSYUNOCHU = "正常収納中";

    private static final String HKNRSNJK_MISYUARI = "未収あり";

    private static final String SIMNKSTBG_NENMANKI = "年間";

    private static final String SIMNKSTBG_SAIMANKI = "歳まで";

    private static final String NNKNKBN_KAKUTEIDAI1BAIGAKUGATA = "確定年金　第１回倍額";

    private static final String HRIKMH_ITIJIBARAI = "一時払";

    private static final String HRIKMH_DATTAICHU = "お払込停止";

    private static final String HRIKMH_ZENNOUCHU = "前納中";

    private static final String HRIKMH_KOUZAFURIKAEATUKAI = "月払　口座振替扱";

    private static final String HRIKMH_CREDITBARAIATUKAI = "月払　クレジット払扱";

    private static final String HRIKMH_6M_KOUZAFURIKAEATUKAI_IKKATUNYUKINCHU = "６か月一括払　口座振替扱　一括入金中";

    private static final String HRIKMH_6M_CREDITBARAIATUKAI_IKKATUNYUKINCHU = "６か月一括払　クレジット払扱　一括入金中";

    private static final String HRIKMH_12M_KOUZAFURIKAEATUKAI_IKKATUNYUKINCHU = "１２か月一括払　口座振替扱　一括入金中";

    private static final String HRIKMH_12M_CREDITBARAIATUKAI_IKKATUNYUKINCHU = "１２か月一括払　クレジット払扱　一括入金中";

    private static final String HRIKMH_HALFY_KOUZAFURIKAEATUKAI = "年２回払　口座振替扱";

    private static final String HRIKMH_NEN_KOUZAFURIKAEATUKAI = "年１回払　口座振替扱";

    private static final BizDate HANTEIYMD_SLMTAIOUKAISIYMD = BizDate.valueOf("20200401");

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public HbKeiyakuSyoukai() {
        super();
    }

    public WebKykNaiyouSyoukaiInfoBean exec(String pSyono, BizDate pSyoriYmd, C_TanmatuSiyouKbn pTanmatuSiyouKb, String pPersonCd) {

        logger.debug("▽ 生保Ｗｅｂ契約内容照会 開始");

        webKykNaiyouSyoukaiInfoBean = SWAKInjector.getInstance(WebKykNaiyouSyoukaiInfoBean.class);

        String syono = pSyono;

        int errorMsgEditKbn = 0;

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(syono);

        if (itKykKihon == null) {

            errorMsgEditKbn = 2;

            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;
        }

        List<IT_KykDairiten> kykDairitenList = itKykKihon.getKykDairitens();

        if (kykDairitenList.size() == 0) {

            errorMsgEditKbn = 3;

            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;
        }

        if (C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN.eq(pTanmatuSiyouKb)) {

            boolean drtenSyoukaichkContext = false;

            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(pPersonCd);

            if (bzGetBsInfoBean == null) {

                errorMsgEditKbn = 3;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(bzGetBsInfoBean.getDairiten1Cd());

            if (bzGetAgInfoBeanLst == null || bzGetAgInfoBeanLst.size() == 0) {

                errorMsgEditKbn = 3;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }

            String syoukaiPerOyadrtenCd = bzGetAgInfoBeanLst.get(3).getOyadrtenCd();

            for (IT_KykDairiten kykDairiten: kykDairitenList) {

                bzGetAgInfoBeanLst = bzGetAgInfo.exec(kykDairiten.getDrtencd());

                if (bzGetAgInfoBeanLst == null || bzGetAgInfoBeanLst.size() == 0) {

                    errorMsgEditKbn = 3;

                    setSyuuturyokukomoku(errorMsgEditKbn);

                    logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                    return webKykNaiyouSyoukaiInfoBean;
                }

                String kykOyadrtenCd = bzGetAgInfoBeanLst.get(3).getOyadrtenCd();

                if (syoukaiPerOyadrtenCd.equals(kykOyadrtenCd)) {

                    drtenSyoukaichkContext = true;
                }
            }

            if (!drtenSyoukaichkContext) {

                errorMsgEditKbn = 4;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }
        }

        List<IT_KykSyouhn> itKykSyouhnList = itKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSyouhn itKykSyouhn = new IT_KykSyouhn();

        itKykSyouhn = itKykSyouhnList.get(0);

        if (BizDateUtil.compareYmd(pSyoriYmd, itKykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            errorMsgEditKbn = 3;

            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;
        }

        if (C_YuukousyoumetuKbn.SYOUMETU.eq(itKykSyouhn.getYuukousyoumetukbn())) {
            errorMsgEditKbn = 3;

            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;
        }

        C_UktkJyoutaiKbn[] uktkJyoutaiKbns = new C_UktkJyoutaiKbn[]{C_UktkJyoutaiKbn.MISYORI, C_UktkJyoutaiKbn.ERROR};

        List<KhHenkouUktkBean> khHenkouUktkBeanList = hozenDomManager.getKhHenkouUktkBySyonoUktkjyoutaiKbn(
            syono, uktkJyoutaiKbns);

        if (khHenkouUktkBeanList.size() != 0) {
            for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanList) {
                C_UktkSyoriKbn uktkSyoriKbn = khHenkouUktkBean.getUktkSyoriKbn();

                IM_KhHenkouUktksyorikahi khHenkouUktksyorikahi = hozenDomManager.getKhHenkouUktksyorikahi(
                    HBWEBKINOUID, uktkSyoriKbn);

                if (khHenkouUktksyorikahi != null) {
                    C_YuukoujyotaikahiKbn yuukoujyotaikahiKbn = khHenkouUktksyorikahi.getYuukoujyotaikahikbn();

                    if (C_YuukoujyotaikahiKbn.HUKA.eq(yuukoujyotaikahiKbn)) {

                        errorMsgEditKbn = 3;

                        setSyuuturyokukomoku(errorMsgEditKbn);

                        logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                        return webKykNaiyouSyoukaiInfoBean;
                    }
                }
            }
        }

        List<JT_SkKihon> skKihons =
            siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(syono, C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        if (skKihons.size() != 0) {

            skKihons = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetu(syono,C_SeikyuuSyubetu.SB);

            if (skKihons.size() == 0) {

                errorMsgEditKbn = 3;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }
        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        bzGetProcessSummaryInBean.setSyoNo(syono);

        BzGetProcessSummaryComparatorWorkListHyoujijun bzGetProcessSummaryComparatorWorkListHyoujijun = SWAKInjector
            .getInstance(BzGetProcessSummaryComparatorWorkListHyoujijun.class);

        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(bzGetProcessSummaryComparatorWorkListHyoujijun);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        for (BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean : bzGetProcessSummaryOutBeanList) {

            String jimuTetuzukiCd = bzGetProcessSummaryOutBean.getJimuTetuzukiCd();

            String nowNodoId = bzGetProcessSummaryOutBean.getNowNodoId();

            IM_Syorijtkahi syorijtkahi = hozenDomManager.getSyorijtkahi("PO99", jimuTetuzukiCd, nowNodoId);

            if (syorijtkahi != null) {

                C_YuukoujyotaikahiKbn yuukoujyotaikahikbn = syorijtkahi.getYuukoujyotaikahikbn();

                if (C_YuukoujyotaikahiKbn.HUKA.eq(yuukoujyotaikahikbn)) {

                    errorMsgEditKbn = 3;

                    setSyuuturyokukomoku(errorMsgEditKbn);

                    logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                    return webKykNaiyouSyoukaiInfoBean;
                }
            }

        }

        IT_KhTtdkTyuui itKhTtdkTyuui = itKykKihon.getKhTtdkTyuui();

        if (itKhTtdkTyuui != null) {

            if (C_TtdktyuuiKbn.HOZENSONOTA.eq(itKhTtdkTyuui.getTtdktyuuikbn1())) {

                errorMsgEditKbn = 3;
                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }

            if (C_TtdktyuuiKbn.HOZENSONOTA.eq(itKhTtdkTyuui.getTtdktyuuikbn2())) {

                errorMsgEditKbn = 3;
                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }

            if (C_TtdktyuuiKbn.HOZENSONOTA.eq(itKhTtdkTyuui.getTtdktyuuikbn3())) {

                errorMsgEditKbn = 3;
                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }

            if (C_TtdktyuuiKbn.HOZENSONOTA.eq(itKhTtdkTyuui.getTtdktyuuikbn4())) {

                errorMsgEditKbn = 3;
                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }


            if (C_TtdktyuuiKbn.HOZENSONOTA.eq(itKhTtdkTyuui.getTtdktyuuikbn5())) {

                errorMsgEditKbn = 3;
                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(itKykSyouhn.getSyouhncd());
        int henkoukubetuSyohinHanteiKbn = SyouhinUtil.henkouKubetuHantei(itKykSyouhn.getSyouhncd());

        if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR   ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20)&&
            !C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {

            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

            hanteiTmttknJyoutaiBean.setSyono(syono);
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(BizDate.getSysDate());
            hanteiTmttknJyoutaiBean.setKykymd(itKykSyouhn.getKykymd());

            boolean tmttknHanteiKekka = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

            if (!tmttknHanteiKekka) {

                errorMsgEditKbn = 5;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }
        }

        IT_KykSya kykSya = itKykKihon.getKykSya();

        String tsinyno = kykSya.getTsinyno();

        BzGetAdrData bzGetAdrData = SWAKInjector.getInstance(BzGetAdrData.class);

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(tsinyno);

        String AdrKn = "";

        if (C_ErrorKbn.OK.eq(bzGetAdrData.getErrorKbn())) {

            AdrKn = bzGetAdrData.getAdrKanaBlankAri();
        }

        IT_HhknSya itHhknSya = itKykKihon.getHhknSya();

        BM_SyouhnZokusei bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(itKykSyouhn.getSyouhncd(),
            itKykSyouhn.getSyouhnsdno());

        String syouhnnm_yakkan = "";
        C_UmuKbn syuusinhknumu = C_UmuKbn.NONE;
        C_UmuKbn nkhknumu = C_UmuKbn.NONE;
        C_HaitouKbn haitoukbn = C_HaitouKbn.BLNK;

        if (bmSyouhnZokusei != null) {

            syouhnnm_yakkan = bmSyouhnZokusei.getSyouhnnmsyouken();
            syuusinhknumu = bmSyouhnZokusei.getSyuusinhknumu();
            nkhknumu = bmSyouhnZokusei.getNkhknumu();
            haitoukbn = bmSyouhnZokusei.getHaitoukbn();
        }
        else {
            errorMsgEditKbn = 3;
            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;
        }

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(itKykSyouhn.getKykymd());
        hanteiHokenKikanBean.setSyouhnZokusei(bmSyouhnZokusei);
        hanteiHokenKikanBean.setCalcKijyunYmd(pSyoriYmd);
        hanteiHokenKikanBean.setDai1hknkkn(itKykSyouhn.getDai1hknkkn());

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);
        BizDate dai3hknkknYmdFrom = hanteiHokenKikan.getDai3HknkknStartYmd();

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = new ArrayList<>();

        C_ErrorKbn kawaseRateFlag = C_ErrorKbn.OK;

        BizDate hknKhpRyosyuYmd = null;

        BizNumber haraikomiTkRate = BizNumber.ZERO;

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        Integer targetTkMokuhyouti = 0;

        IT_KykSonotaTkyk itKykSonotaTkyk = itKykKihon.getKykSonotaTkyk();

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getTargettkhkumu())) {
            targetTkMokuhyouti = itKykSonotaTkyk.getTargettkmokuhyouti();
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        nyknJissekiRirekiLst = khozenCommonParam.getNyknJissekiRirekiSk(syono);

        if (nyknJissekiRirekiLst == null || nyknJissekiRirekiLst.size() == 0) {

            errorMsgEditKbn = 3;

            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;
        }

        hknKhpRyosyuYmd = nyknJissekiRirekiLst.get(0).getRyosyuymd();

        C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getYennykntkhkumu())){

            tuukasyu = C_Tuukasyu.JPY;
        }
        else if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getGaikanykntkhkumu())){

            tuukasyu = nyknJissekiRirekiLst.get(0).getRstuukasyu();
        }

        if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu()) &&
            (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getYennykntkhkumu()) ||
                C_UmuKbn.ARI.eq(itKykSonotaTkyk.getGaikanykntkhkumu()))) {

            kawaseRateFlag = getKawaseRate.exec(hknKhpRyosyuYmd,
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                itKykSyouhn.getKyktuukasyu(),
                tuukasyu,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.OK.eq(kawaseRateFlag)) {

                haraikomiTkRate = getKawaseRate.getKawaserate();
            }
            else {

                errorMsgEditKbn = 3;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }
        }

        List<IT_KhTtdkRireki> itKhTtdkRirekiListItiji = hozenDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous(syono,
            GYOUMUKOUSINKINOUS);

        List<IT_KhTtdkRireki> itKhTtdkRirekiList = new ArrayList<>();
        String yendthnkKeii = "";
        BizDate yendthnkymd = null;
        BizCurrency toutatugk = BizCurrency.valueOf(0);
        BizCurrency yendthnkhr = BizCurrency.valueOf(0);
        List<IT_KhHenreikin> itKhHenreikinList = new ArrayList<>();
        String hrsiharaijyoutai = "";

        int henkouKeiiKensuu = 0;

        if (itKhTtdkRirekiListItiji.size() != 0) {

            if (itKhTtdkRirekiListItiji.size() < 10) {

                for (int i = 0; i < itKhTtdkRirekiListItiji.size(); i++) {

                    itKhTtdkRirekiList.add(itKhTtdkRirekiListItiji.get(i));

                    henkouKeiiKensuu = i + 1;

                }

            }
            else {

                for (int i = 0; i < 10; i++) {

                    itKhTtdkRirekiList.add(itKhTtdkRirekiListItiji.get(i));

                    henkouKeiiKensuu = i + 1;

                }

            }
            if (itKykSyouhn.getYendthnkymd() != null){
                yendthnkymd = itKykSyouhn.getYendthnkymd();
                int mokuhyouti = 0;
                String mokuhyoutiHenkan = "";

                IT_KykSyouhnHnkmae itKykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(syono);


                if (C_UmuKbn.ARI.eq(itKykSyouhnHnkmae.getTargettkhkumu())){
                    mokuhyouti = itKykSyouhnHnkmae.getTargettkmokuhyouti();
                    mokuhyoutiHenkan = ConvertUtil.toZenAll(String.valueOf(mokuhyouti), 0, 1);
                }

                for (IT_KhTtdkRireki itKhTtdkRireki : itKhTtdkRirekiListItiji) {
                    if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(itKhTtdkRireki.getGyoumuKousinKinou())) {

                        C_UktkSyoriKbn wkUktkSyoriKbn = C_UktkSyoriKbn.BLNK;

                        if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(itKhTtdkRireki.getSyorikbn())){
                            if (C_UmuKbn.ARI.eq(syuusinhknumu)) {
                                yendthnkKeii = "目標到達（目標値：" + mokuhyoutiHenkan + "％）により円建終身保険に変更済";
                            }
                            if (C_UmuKbn.ARI.eq(nkhknumu)){
                                yendthnkKeii = "目標到達（目標値：" + mokuhyoutiHenkan + "％）により円建年金保険に変更済";
                            }
                            wkUktkSyoriKbn = C_UktkSyoriKbn.MKHGKTTTYENDTHNK;
                        }

                        if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(itKhTtdkRireki.getSyorikbn())){
                            if (C_UmuKbn.ARI.eq(syuusinhknumu)) {
                                yendthnkKeii = "請求により円建終身保険に変更済";
                            }
                            if (C_UmuKbn.ARI.eq(nkhknumu)){
                                yendthnkKeii = "請求により円建年金保険に変更済";
                            }
                            wkUktkSyoriKbn = C_UktkSyoriKbn.NINISEIKYUU;
                        }
                        IT_KhHenkouUktk itKhHenkouUktk = hozenDomManager.getKykHozenHenkoUkt(syono
                            , wkUktkSyoriKbn, C_UktkJyoutaiKbn.SYORIZUMI, yendthnkymd);

                        if (itKhHenkouUktk == null){
                            errorMsgEditKbn = 3;

                            setSyuuturyokukomoku(errorMsgEditKbn);

                            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                            return webKykNaiyouSyoukaiInfoBean;
                        }

                        IT_KhHenkouUktkYendtHnk itKhHenkouUktkYendtHnk = itKhHenkouUktk.getKhHenkouUktkYendtHnk();
                        toutatugk = itKhHenkouUktkYendtHnk.getYendthnkkaiyakuhryen();
                        yendthnkhr = itKhHenkouUktkYendtHnk.getYendthnkhr();

                        itKhHenreikinList = itKykKihon.getKhHenreikins();
                        for (IT_KhHenreikin itKhHenreikin : itKhHenreikinList) {
                            if (itKhHenreikin.getHenkousikibetukey().equals(itKhTtdkRireki.getHenkousikibetukey())){
                                if (C_Siharaijyoutaikbn.MBR.eq(itKhHenreikin.getHrsiharaijyoutaikbn())) {
                                    hrsiharaijyoutai = "（未請求）";

                                    break;
                                }
                                else if (C_Siharaijyoutaikbn.SIHARAIZUMI.eq(itKhHenreikin.getHrsiharaijyoutaikbn())){
                                    hrsiharaijyoutai = "（" + itKhHenreikin.getHrsiharaijyoutaikbn().getContent() + "）";

                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        else {

            henkouKeiiKensuu = 0;
        }

        int dairitenNo = 0;
        String kanjiDairitenNm1 = "";
        String kanjiDairitenNm2 = "";

        for (IT_KykDairiten itKykDairiten : kykDairitenList) {

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(itKykDairiten.getDrtencd());

            if (bzGetAgInfoBeanLst == null || bzGetAgInfoBeanLst.size() == 0) {

                errorMsgEditKbn = 3;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }

            if (itKykDairiten.getDrtenrenno().equals(1)) {

                dairitenNo = 1;
                kanjiDairitenNm1 = bzGetAgInfoBeanLst.get(2).getKanjiDairitenNm();
            }

            else if (itKykDairiten.getDrtenrenno().equals(2)) {

                dairitenNo = 2;
                kanjiDairitenNm2 = bzGetAgInfoBeanLst.get(2).getKanjiDairitenNm();
            }
        }

        List<IT_KykUkt> itKykUktSbuktList = itKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_KykUkt> itKykUktNkuktList = new ArrayList<>();
        if (C_UmuKbn.ARI.eq(nkhknumu)) {
            itKykUktNkuktList = itKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT);
        }
        List<IT_KykUkt> itKykUktstdrskList = itKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);
        GetKhKykdrInfoBean getKhKykdrInfoBean =  getKhKykdrInfo.exec(itKykKihon);

        List<IT_TrkKzk> itTrkKzkList = itKykKihon.getTrkKzks();

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);

        IT_DattaiUktk dattaiUktk;
        if (ansyuKihon != null) {
            dattaiUktk = ansyuKihon.getDattaiUktk();
        }
        else {
            errorMsgEditKbn = 3;
            setSyuuturyokukomoku(errorMsgEditKbn);
            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");
            return webKykNaiyouSyoukaiInfoBean;
        }

        BizNumber kawaserate = BizNumber.ZERO;
        BizCurrency siboHknKn = null;
        BizCurrency dai2HknKknSiboHknKn = BizCurrency.optional();
        BizCurrency dai3HknKknSiboHknKn = null;

        if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {
            kawaseRateFlag = getKawaseRate.exec( BizDate.getSysDate(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                itKykSyouhn.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.YOU);

            if (C_ErrorKbn.OK.eq(kawaseRateFlag)) {

                kawaserate = getKawaseRate.getKawaserate();

            }
            else {

                errorMsgEditKbn = 3;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;

            }
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syono
            , BizDate.getSysDate()
            , C_SiinKbn.SP
            , C_HokenkinsyuruiKbn.SBHOKENKIN
            , itKykKihon.getSdpdkbn()
            , itKykKihon.getHrkkeiro());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            errorMsgEditKbn = 3;

            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;

        }

        if (C_ErrorKbn.OK.eq(errorKbn)){

            siboHknKn = calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk();

        }

        if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn)) ||
            syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {
            dai2HknKknSiboHknKn = itKykSyouhn.getKihons();
        }

        if (C_HknkknBunruiKbn.THIRD.eq(bmSyouhnZokusei.getHknkknbunruikbn()) &&
            (C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn) || C_HknKknKbn.DAI2HKNKKN.eq(cHknKknKbn))) {

            errorKbn = calcHkShrKngk.exec(
                itKykSyouhn.getSyouhncd(),
                itKykSyouhn.getSyouhnsdno(),
                itKykSyouhn.getRyouritusdno(),
                itKykSyouhn.getYoteiriritu(),
                itKykKihon.getHrkkaisuu(),
                itKykSyouhn.getHknkknsmnkbn(),
                itKykSyouhn.getHknkkn(),
                itKykSyouhn.getHrkkkn(),
                itKykSyouhn.getHhknnen(),
                itKykSyouhn.getHhknsei(),
                itKykSyouhn.getKihons(),
                itKykSyouhn.getKykymd(),
                dai3hknkknYmdFrom,
                syono,
                itKykSyouhn.getKyktuukasyu(),
                itKykSyouhn.getDai1hknkkn(),
                C_SiinKbn.SP,
                C_HokenkinsyuruiKbn.SBHOKENKIN,
                itKykSyouhn.getHokenryou(),
                BizNumber.ZERO,
                itKykSyouhn.getKyksjkkktyouseiriritu(),
                null,
                BizCurrency.valueOf(0),
                BizCurrency.valueOf(0),
                BizNumber.ZERO,
                null,
                null,
                null,
                null,
                null,
                null,
                itKykSyouhn.getKykjyoutai(),
                itKykSyouhn.getYendthnkymd(),
                itKykKihon.getSdpdkbn(),
                itKykKihon.getHrkkeiro()
                );

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                errorMsgEditKbn = 3;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;

            }

            if (C_ErrorKbn.OK.eq(errorKbn)){
                dai3HknKknSiboHknKn = calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk();
            }

        }

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(
            itKykSyouhn.getKykymd(),
            BizDate.getSysDate(),
            ansyuKihon.getJkipjytym(),
            itKykKihon.getHrkkaisuu(),
            itKykSyouhn.getKykjyoutai(),
            itKykSyouhn.getSyouhncd(),
            itKykSyouhn.getYendthnkymd()
            );

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        errorKbn = keisanWExt.exec(syono, BizDate.getSysDate());

        if (C_ErrorKbn.OK.eq(errorKbn)) {

            keisanWExtBean = keisanWExt.getKeisanWExtBean();

        }
        else {

            errorMsgEditKbn = 3;

            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;

        }

        KeisanW keisanW =SWAKInjector.getInstance(KeisanW.class);
        BizCurrency kaiyakuhr = BizCurrency.optional();
        BizCurrency tmttkngk = BizCurrency.optional();

        errorKbn = keisanW.exec(BizDate.getSysDate(), kaiyakuhrKisnKijyunYM, keisanWExtBean);

        if (C_ErrorKbn.OK.eq(errorKbn)) {

            kaiyakuhr = keisanW.getW();

            if (syohinHanteiKbn != SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN &&
                syohinHanteiKbn != SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                tmttkngk = keisanW.getV();

            }

        }
        else {

            errorMsgEditKbn = 3;

            setSyuuturyokukomoku(errorMsgEditKbn);

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return webKykNaiyouSyoukaiInfoBean;

        }

        BizCurrency hrkpYen = BizCurrency.optional();

        BizNumber yenKawaserate = BizNumber.ZERO;

        if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu()) &&
            C_UmuKbn.NONE.eq(itKykSonotaTkyk.getYennykntkhkumu()) &&
            syohinHanteiKbn != SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            KeisanKijyungk keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

            errorKbn = keisanKijyungk.exec(
                hknKhpRyosyuYmd,
                itKykKihon.getHrkp(),
                itKykKihon.getHrkp(),
                itKykSyouhn.getKyktuukasyu(),
                C_Tkhukaumu.NONE);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                hrkpYen = keisanKijyungk.getKijyungk();

                yenKawaserate = keisanKijyungk.getYenkawaserate();
            }
            else {
                errorMsgEditKbn = 3;

                setSyuuturyokukomoku(errorMsgEditKbn);

                logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

                return webKykNaiyouSyoukaiInfoBean;
            }
        }

        BizCurrency siboHknKnYenka = BizCurrency.valueOf(0);
        BizCurrency dai2HknKknSiboHknKnYenka = BizCurrency.valueOf(0);
        BizCurrency dai3HknKknSiboHknKnYenka = BizCurrency.valueOf(0);
        BizCurrency kaiyakuhrYen = BizCurrency.valueOf(0);
        BizCurrency tmttkngkYen  = BizCurrency.valueOf(0);

        if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            siboHknKnYenka = keisanGaikakanzan.exec(C_Tuukasyu.JPY, siboHknKn,
                kawaserate, C_HasuusyoriKbn.AGE);

            if (siboHknKnYenka.compareTo(itKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                siboHknKnYenka = itKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
            }

            if (!dai2HknKknSiboHknKn.isOptional()) {

                dai2HknKknSiboHknKnYenka = keisanGaikakanzan.exec(C_Tuukasyu.JPY
                    , dai2HknKknSiboHknKn
                    , kawaserate
                    , C_HasuusyoriKbn.AGE);
            }

            if (C_HknkknBunruiKbn.THIRD.eq(bmSyouhnZokusei.getHknkknbunruikbn()) &&
                (C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn) || C_HknKknKbn.DAI2HKNKKN.eq(cHknKknKbn))) {

                dai3HknKknSiboHknKnYenka = keisanGaikakanzan.exec(C_Tuukasyu.JPY
                    , dai3HknKknSiboHknKn
                    , kawaserate
                    , C_HasuusyoriKbn.AGE);
            }

            kaiyakuhrYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kaiyakuhr, kawaserate,
                C_HasuusyoriKbn.AGE);

            if (!tmttkngk.isOptional()) {

                tmttkngkYen = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    tmttkngk,
                    kawaserate,
                    C_HasuusyoriKbn.AGE
                    );
            }
        }


        String siboHknKnStr = "";

        String siboHknKnYenkaStr = "";

        if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {
            siboHknKnStr = BizUtil.comma(String.valueOf(siboHknKn), 0, 2);

            siboHknKnYenkaStr = BizUtil.comma(String.valueOf(siboHknKnYenka));
        }
        else {
            siboHknKnStr = BizUtil.comma(String.valueOf(siboHknKn));
        }

        String dai2HknkknsibousGkStr = "";

        String dai2HknkknsibousYenkaStr = "";

        if (!dai2HknKknSiboHknKn.isOptional()) {

            if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {

                dai2HknkknsibousGkStr = BizUtil.comma(String.valueOf(dai2HknKknSiboHknKn), 0, 2);

                dai2HknkknsibousYenkaStr = BizUtil.comma(String.valueOf(dai2HknKknSiboHknKnYenka));
            }
            else {
                dai2HknkknsibousGkStr = BizUtil.comma(String.valueOf(dai2HknKknSiboHknKn));
            }
        }

        String dai3HknkknsibousGkStr = "";

        String dai3HknkknsibousYenkaStr = "";

        if (C_HknkknBunruiKbn.THIRD.eq(bmSyouhnZokusei.getHknkknbunruikbn()) &&
            (C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn) || C_HknKknKbn.DAI2HKNKKN.eq(cHknKknKbn))) {

            dai3HknkknsibousGkStr = BizUtil.comma(String.valueOf(dai3HknKknSiboHknKn), 0, 2);

            dai3HknkknsibousYenkaStr = BizUtil.comma(String.valueOf(dai3HknKknSiboHknKnYenka));
        }

        String kaiyakuhrString = "";

        String kaiyakuhrYenString = "";
        if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {
            kaiyakuhrString = BizUtil.comma(String.valueOf(kaiyakuhr), 0, 2);

            kaiyakuhrYenString = BizUtil.comma(String.valueOf(kaiyakuhrYen));
        }
        else {
            kaiyakuhrString = BizUtil.comma(String.valueOf(kaiyakuhr));
        }

        String tmttkngkString = "";
        String tmttkngkYenString = "";

        if (!tmttkngk.isOptional()) {

            if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {

                tmttkngkString = BizUtil.comma(String.valueOf(tmttkngk), 0, 2);

                tmttkngkYenString = BizUtil.comma(String.valueOf(tmttkngkYen));
            }
            else {
                tmttkngkString = BizUtil.comma(String.valueOf(tmttkngk));
            }
        }

        String hrkpYenString = "";

        if (!hrkpYen.isOptional()) {
            hrkpYenString = BizUtil.comma(String.valueOf(hrkpYen));
        }

        String rsgakuStr = "";

        if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiLst.get(0).getRstuukasyu())) {
            rsgakuStr = BizUtil.comma(String.valueOf(nyknJissekiRirekiLst.get(0).getRsgaku()));

        } else {
            rsgakuStr = BizUtil.comma(String.valueOf(nyknJissekiRirekiLst.get(0).getRsgaku()), 0, 2);
        }

        String toutatugkStr = "";
        if (toutatugk.compareTo(BizCurrency.valueOf(0)) > 0){
            toutatugkStr = BizUtil.comma(String.valueOf(toutatugk));
        }

        String yendthnkhrStr = "";
        if (yendthnkhr.compareTo(BizCurrency.valueOf(0)) > 0){
            yendthnkhrStr = BizUtil.comma(String.valueOf(yendthnkhr));
        }


        String kykseiYmdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(kykSya.getKykseiymd());

        String hhknseiymdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(itHhknSya.getHhknseiymd());

        String kykYmdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(itKykSyouhn.getKykymd());

        BizDate hknkknmanryouYmdItiji = itKykSyouhn.getHknkknmanryouymd().addDays(-1);

        String hknkknmanryouYmdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(hknkknmanryouYmdItiji);

        String stdrskseiymdHenkan = "";
        IT_KykUkt itKykUktstdrsk = null;

        if (itKykUktstdrskList.size() != 0){
            itKykUktstdrsk = itKykUktstdrskList.get(0);
            if (itKykUktstdrsk.getUktseiymd() != null) {
                stdrskseiymdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(itKykUktstdrsk.getUktseiymd());
            }
        }

        String kykdrnseiymdHenkan = "";
        if (getKhKykdrInfoBean.getkykdrseiymd() != null) {
            kykdrnseiymdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(getKhKykdrInfoBean.getkykdrseiymd());
        }

        String trkkzkseiymd1Henkan = "";
        String trkkzkseiymd2Henkan = "";
        for (IT_TrkKzk itTrkKzk : itTrkKzkList) {
            if (C_TrkKzkKbn.TRKKZK1.eq(itTrkKzk.getTrkkzkkbn())){
                if (itTrkKzk.getTrkkzkseiymd() != null) {
                    trkkzkseiymd1Henkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(itTrkKzk.getTrkkzkseiymd());
                }
            }

            if (C_TrkKzkKbn.TRKKZK2.eq(itTrkKzk.getTrkkzkkbn())){
                if (itTrkKzk.getTrkkzkseiymd() != null) {
                    trkkzkseiymd2Henkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(itTrkKzk.getTrkkzkseiymd());
                }
            }
        }

        String tmttknitenymdHenkan = "";

        if (itKykSyouhn.getTmttknitenymd() != null) {
            tmttknitenymdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(itKykSyouhn.getTmttknitenymd());
        }

        String hknKhpRyosyuymdHenkan = "";

        hknKhpRyosyuymdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(hknKhpRyosyuYmd);

        List<String> keiihenkouYmdListHenkan = new ArrayList<>();

        if (henkouKeiiKensuu > 0) {

            for (int i = 0; i < henkouKeiiKensuu; i++) {

                if (Arrays.binarySearch(GYOUMUKOUSINKINOUS, itKhTtdkRirekiList.get(i).getGyoumuKousinKinou()) >= 0) {

                    keiihenkouYmdListHenkan.add(FixedDateFormatter.formatYMDZenkakuWarekiKanji(itKhTtdkRirekiList.get(i).getSyoriYmd()));

                }
            }

        }

        String nkshrStartYmdHenkan = "";
        if (C_UmuKbn.ARI.eq(nkhknumu)) {
            nkshrStartYmdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(itKykSyouhn.getHknkknmanryouymd());
        }

        String hkrsnjk = SYOKITIHAIFUN;
        if (!C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhn.getKykjyoutai()) && !C_Kykjyoutai.ZENNOU.eq(itKykSyouhn.getKykjyoutai())) {
            List<IT_AnsyuRireki> itAnsyuRirekiList = ansyuKihon.getAnsyuRirekis();

            if (itAnsyuRirekiList.size() != 0) {
                SortIT_AnsyuRireki sortIT_AnsyuRireki = SWAKInjector.getInstance(SortIT_AnsyuRireki.class);

                itAnsyuRirekiList = sortIT_AnsyuRireki.OrderIT_AnsyuRirekiByAnnaisakuseiymdJyuutouymAnnainoDesc(itAnsyuRirekiList);
            }

            if (itAnsyuRirekiList.size() != 0 &&
                C_AnnaijkKbn.MINYUU.eq(itAnsyuRirekiList.get(0).getAnnaijkkbn())){
                hkrsnjk = HKNRSNJK_MISYUARI;
            }
            else {
                hkrsnjk = HKNRSNJK_SEIJOUSYUNOCHU;
            }
        }

        String jikaiHokenryouJyuutouHenkanYm = SYOKITIHAIFUN;
        if (!C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhn.getKykjyoutai())) {
            jikaiHokenryouJyuutouHenkanYm = FixedDateFormatter.formatYMZenkakuWarekiKanji(BizDate.valueOf(ansyuKihon.getJkipjytym(), 1));
        }

        String yendthnkymdHenkan = "";
        if (yendthnkymd != null){
            yendthnkymdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(yendthnkymd);
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        int hhknnen = setNenrei.exec(BizDate.getSysDate(), itHhknSya.getHhknseiymd());

        tsinyno = BizUtil.editYno(kykSya.getTsinyno());

        String nenkinkknStr = "";
        if (itKykSyouhn.getNenkinkkn() < 10) {
            nenkinkknStr = "　" + itKykSyouhn.getNenkinkkn() + "年";
        }
        else {
            nenkinkknStr = itKykSyouhn.getNenkinkkn() + "年";
        }

        String hknkknStr = "";
        if (C_UmuKbn.ARI.eq(nkhknumu)) {
            if (itKykSyouhn.getHknkkn() < 10) {
                hknkknStr = "　" + itKykSyouhn.getHknkkn();
            }
            else {
                hknkknStr = itKykSyouhn.getHknkkn().toString();
            }

            if (C_HknkknsmnKbn.SAIMANKI.eq(itKykSyouhn.getHknkknsmnkbn())) {
                hknkknStr = hknkknStr + SIMNKSTBG_SAIMANKI;
            } else {
                hknkknStr = hknkknStr + SIMNKSTBG_NENMANKI;
            }

        }

        String hrkmkkn = "";
        if (!C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhn.getKykjyoutai()) && C_HrkkknsmnKbn.SAIMANKI.eq(itKykSyouhn.getHrkkknsmnkbn())) {
            if (itKykSyouhn.getHrkkkn() < 10) {
                hrkmkkn = "　" + itKykSyouhn.getHrkkkn() + SIMNKSTBG_SAIMANKI;
            }
            else {
                hrkmkkn = itKykSyouhn.getHrkkkn() + SIMNKSTBG_SAIMANKI;
            }
        }

        String sbuktnmStr = "";
        String sbuktseiymdHenkan = "";

        if (itKykKihon.getSbuktnin() > 1) {
            sbuktnmStr = SBUKTNM_HUKUSUU;
        } else {
            if (itKykKihon.getSbuktnin() == 1) {
                IT_KykUkt itKykUktSbuk = itKykUktSbuktList.get(0);

                if (C_UktKbn.KYK.eq(itKykUktSbuk.getUktkbn())) {
                    sbuktnmStr = C_UktKbn.KYK.getContent() + KEISYOU_SAMA;
                }

                if (C_UktKbn.HHKN.eq(itKykUktSbuk.getUktkbn())) {
                    sbuktnmStr = C_UktKbn.HHKN.getContent() + KEISYOU_SAMA;
                }

                if (C_UktKbn.SOUZOKUNIN.eq(itKykUktSbuk.getUktkbn())) {
                    sbuktnmStr = C_UktKbn.SOUZOKUNIN.getContent() + KEISYOU_SAMA;
                }

                if (C_UktKbn.TOKUTEIMEIGI.eq(itKykUktSbuk.getUktkbn())) {
                    if (C_KjkhukaKbn.KJKHUKA.eq(itKykUktSbuk.getUktnmkjkhukakbn())) {
                        sbuktnmStr = itKykUktSbuk.getUktnmkn() + KEISYOU_SAMA;
                    } else {
                        sbuktnmStr = itKykUktSbuk.getUktnmkj() + KEISYOU_SAMA;
                    }
                    sbuktseiymdHenkan = FixedDateFormatter.formatYMDZenkakuWarekiKanji(itKykUktSbuk.getUktseiymd());
                }
            }
        }

        String nkuktnmStr = "";
        IT_KykUkt itKykUktNkuk;

        if (C_UmuKbn.ARI.eq(nkhknumu)) {
            if (itKykUktNkuktList != null && itKykUktNkuktList.size() > 0 ) {
                itKykUktNkuk = itKykUktNkuktList.get(0);

                if (C_UktKbn.KYK.eq(itKykUktNkuk.getUktkbn())) {
                    nkuktnmStr = C_UktKbn.KYK.getContent() + KEISYOU_SAMA;
                }

                if (C_UktKbn.HHKN.eq(itKykUktNkuk.getUktkbn())) {
                    nkuktnmStr = C_UktKbn.HHKN.getContent() + KEISYOU_SAMA;
                }
            }
        }


        String kykdrnnmStr = "";
        if (C_KjkhukaKbn.KJKHUKA.eq(getKhKykdrInfoBean.getKkdairinmKjkhukaKbn())) {
            kykdrnnmStr = getKhKykdrInfoBean.getKkdairinmKn() + KEISYOU_SAMA;
        }
        else {
            kykdrnnmStr = getKhKykdrInfoBean.getKkdairinmKj() + KEISYOU_SAMA;
        }

        String trkkzknmStr1 = "";
        String trkkzknmStr2 = "";

        for (IT_TrkKzk itTrkKzk : itTrkKzkList) {

            if (C_TrkKzkKbn.TRKKZK1.eq(itTrkKzk.getTrkkzkkbn())){

                if (C_KjkhukaKbn.KJKHUKA.eq(itTrkKzk.getTrkkzknmkjkhukakbn())) {
                    trkkzknmStr1 = itTrkKzk.getTrkkzknmkn() + KEISYOU_SAMA;
                }
                else {
                    trkkzknmStr1 = itTrkKzk.getTrkkzknmkj() + KEISYOU_SAMA;
                }

            }
            if (C_TrkKzkKbn.TRKKZK2.eq(itTrkKzk.getTrkkzkkbn())){

                if (C_KjkhukaKbn.KJKHUKA.eq(itTrkKzk.getTrkkzknmkjkhukakbn())) {
                    trkkzknmStr2 = itTrkKzk.getTrkkzknmkn() + KEISYOU_SAMA;
                }
                else {
                    trkkzknmStr2 = itTrkKzk.getTrkkzknmkj() + KEISYOU_SAMA;
                }
            }
        }

        String stdrsknmStr = "";

        if (itKykUktstdrsk != null){
            if (!C_UktKbn.BLNK.eq(itKykUktstdrsk.getUktkbn()) && !C_UktKbn.NASI.eq(itKykUktstdrsk.getUktkbn())){
                if (C_UktKbn.KYK.eq(itKykUktstdrsk.getUktkbn())) {
                    if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())){
                        stdrsknmStr = kykSya.getKyknmkn() + KEISYOU_SAMA;
                    }
                    else {
                        stdrsknmStr = kykSya.getKyknmkj() + KEISYOU_SAMA;
                    }
                    stdrskseiymdHenkan = kykseiYmdHenkan;
                }

                else if (C_UktKbn.SBUK.eq(itKykUktstdrsk.getUktkbn())){
                    stdrsknmStr = sbuktnmStr;
                    stdrskseiymdHenkan = sbuktseiymdHenkan;
                }

                else if (C_UktKbn.TOUROKUKAZOKU1.eq(itKykUktstdrsk.getUktkbn())){
                    stdrsknmStr =  trkkzknmStr1;
                    stdrskseiymdHenkan = trkkzkseiymd1Henkan;
                }

                else if (C_UktKbn.TOUROKUKAZOKU2.eq(itKykUktstdrsk.getUktkbn())){
                    stdrsknmStr = trkkzknmStr2;
                    stdrskseiymdHenkan = trkkzkseiymd2Henkan;
                }
                else if (C_UktKbn.TOKUTEIMEIGI.eq(itKykUktstdrsk.getUktkbn())){
                    if (C_KjkhukaKbn.KJKHUKA.eq(itKykUktstdrsk.getUktnmkjkhukakbn())) {
                        stdrsknmStr = itKykUktstdrsk.getUktnmkn() + KEISYOU_SAMA;
                    }
                    else {
                        stdrsknmStr = itKykUktstdrsk.getUktnmkj() + KEISYOU_SAMA;
                    }
                }
            }
            else {
                stdrsknmStr = "指定されておりません";
            }
        }


        if (!"".equals(kykdrnnmStr)){
            kykdrnnmStr = Strings.padEnd(kykdrnnmStr, 20,  '　');
            if  (!"".equals(kykdrnseiymdHenkan)){
                kykdrnnmStr = kykdrnnmStr + "　　生年月日　" + kykdrnseiymdHenkan;
            }
        }

        if (!"".equals(trkkzknmStr1)){
            trkkzknmStr1 = Strings.padEnd(trkkzknmStr1, 20, '　');
            if (!"".equals(trkkzkseiymd1Henkan)){
                trkkzknmStr1 = trkkzknmStr1 + "　　生年月日　" + trkkzkseiymd1Henkan;
            }
        }

        if (!"".equals(trkkzknmStr2)){
            trkkzknmStr2 = Strings.padEnd(trkkzknmStr2, 20, '　');
            if (!"".equals(trkkzkseiymd2Henkan)){
                trkkzknmStr2 = trkkzknmStr2 + "　　生年月日　" + trkkzkseiymd2Henkan;
            }
        }

        if (!"".equals(stdrsknmStr)){
            stdrsknmStr = Strings.padEnd(stdrsknmStr, 20, '　');
            if (!"".equals(stdrskseiymdHenkan)){
                stdrsknmStr = stdrsknmStr + "　　生年月日　" + stdrskseiymdHenkan;
            }
        }


        String sioriYakkanKensakucd = "";
        String yakkanJyuryou = "";
        if (!C_YakkanJyuryouKbn.BLNK.eq(itKykKihon.getYakkanjyuryouhoukbn())){
            if (!BizUtil.isBlank(itKykKihon.getYakkanbunsyono())){
                String yakkanbunsyono1_2Henkan = ConvertUtil.toZenAll(itKykKihon.getYakkanbunsyono().substring(0, 2), 0, 1);
                String yakkanbunsyono3_6Henkan = ConvertUtil.toZenAll(itKykKihon.getYakkanbunsyono().substring(2, 6), 0, 1);
                String yakkanbunsyono7_10Henkan = ConvertUtil.toZenAll(itKykKihon.getYakkanbunsyono().substring(6, 10), 0, 1);

                sioriYakkanKensakucd = yakkanbunsyono1_2Henkan + "－" + yakkanbunsyono3_6Henkan + "－" + yakkanbunsyono7_10Henkan;
                yakkanJyuryou = itKykKihon.getYakkanjyuryouhoukbn().getContent(C_YakkanJyuryouKbn.PATTERN_HOZEN);
            }
        }


        String syouhnnm = "";
        String aisyoumeikbn_3keta = itKykKihon.getAisyoumeikbn().getValue().substring(2,3);

        if ((AISYOMEIKBN_CHANNEL_SMBC_1.equals(aisyoumeikbn_3keta)) || (AISYOMEIKBN_CHANNEL_SMBC_2.equals(aisyoumeikbn_3keta))) {
            syouhnnm = itKykKihon.getAisyoumeikbn().getContent();
        } else {
            syouhnnm = syouhnnm_yakkan + "　" + itKykKihon.getAisyoumeikbn().getContent();
        }

        if (syouhnnm.length() > SYOHNNM_MAX_LENGTH) {
            syouhnnm = syouhnnm.substring(0, SYOHNNM_MAX_LENGTH);
        }

        String teirituzoukakrirw = "";
        if (C_UmuKbn.ARI.eq(nkhknumu) && C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhn.getKykjyoutai())) {
            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(itKykSyouhn.getTmttknhaibunjyoutai())) {
                teirituzoukakrirw = TEIRITUZOUKAKRIRW_TEIRITUNOMI;
            } else {
                teirituzoukakrirw = TEIRITUZOUKAKRIRW_SISUUNOMI;
            }
        }

        String hrikmh = "";
        if (C_Hrkkaisuu.ITIJI.eq(itKykKihon.getHrkkaisuu())) {
            hrikmh = HRIKMH_ITIJIBARAI;
        }
        else {
            if (C_Kykjyoutai.ZENNOU.eq(itKykSyouhn.getKykjyoutai())) {

                hrikmh = HRIKMH_ZENNOUCHU;
            }
            else {
                if (dattaiUktk != null) {

                    hrikmh = HRIKMH_DATTAICHU;
                }

                else if (C_Hrkkaisuu.TUKI.eq(itKykKihon.getHrkkaisuu())) {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(itKykKihon.getTikiktbrisyuruikbn())) {
                        if (C_Hrkkeiro.KOUHURI.eq(itKykKihon.getHrkkeiro())){
                            hrikmh = HRIKMH_6M_KOUZAFURIKAEATUKAI_IKKATUNYUKINCHU;
                        }
                        if (C_Hrkkeiro.CREDIT.eq(itKykKihon.getHrkkeiro())){
                            hrikmh = HRIKMH_6M_CREDITBARAIATUKAI_IKKATUNYUKINCHU;
                        }
                    }

                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(itKykKihon.getTikiktbrisyuruikbn())) {
                        if (C_Hrkkeiro.KOUHURI.eq(itKykKihon.getHrkkeiro())){
                            hrikmh = HRIKMH_12M_KOUZAFURIKAEATUKAI_IKKATUNYUKINCHU;
                        }
                        if (C_Hrkkeiro.CREDIT.eq(itKykKihon.getHrkkeiro())){
                            hrikmh = HRIKMH_12M_CREDITBARAIATUKAI_IKKATUNYUKINCHU;
                        }
                    }

                    else {
                        if (C_Hrkkeiro.KOUHURI.eq(itKykKihon.getHrkkeiro())){
                            hrikmh = HRIKMH_KOUZAFURIKAEATUKAI;
                        }
                        if (C_Hrkkeiro.CREDIT.eq(itKykKihon.getHrkkeiro())){
                            hrikmh = HRIKMH_CREDITBARAIATUKAI;
                        }
                    }
                }
                else if (C_Hrkkaisuu.HALFY.eq(itKykKihon.getHrkkaisuu())) {
                    if (C_Hrkkeiro.KOUHURI.eq(itKykKihon.getHrkkeiro())) {

                        hrikmh = HRIKMH_HALFY_KOUZAFURIKAEATUKAI;
                    }
                }
                else if (C_Hrkkaisuu.NEN.eq(itKykKihon.getHrkkaisuu())) {
                    if (C_Hrkkeiro.KOUHURI.eq(itKykKihon.getHrkkeiro())) {

                        hrikmh = HRIKMH_NEN_KOUZAFURIKAEATUKAI;
                    }
                }
            }
        }

        String yendthnkmsg = "";
        if (yendthnkymd != null){
            yendthnkmsg = yendthnkymdHenkan + "　" + yendthnkKeii;
        }

        String tumitateriritu = itKykSyouhn.getTumitateriritu().multiply(100).toString();
        String tmttriritu10nengo = itKykSyouhn.getLoadinghnkgtumitateriritu().multiply(100).toString();
        String tmttknzoukaritujygn = itKykSyouhn.getTmttknzoukaritujygn().multiply(100).toString();
        String tnsmbairitu = itKykSyouhn.getSetteibairitu().toString();
        String rendouritu = itKykSyouhn.getRendouritu().multiply(100).toString();
        String yoteiriritu = String.valueOf(0);

        if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){
            GetYoteiriritu getYoteiRiritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(itKykSyouhn.getSyouhncd());
            getYoteirirituBean.setKijyunymd(pSyoriYmd);
            getYoteirirituBean.setSknnkaisiymd(itKykSyouhn.getSknnkaisiymd());
            getYoteirirituBean.setKykymd(itKykSyouhn.getKykymd());
            getYoteirirituBean.setHknkkn(itKykSyouhn.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(itKykSyouhn.getHknkknsmnkbn());
            getYoteirirituBean.setHhknnen(itKykSyouhn.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(itKykSyouhn.getYoteirrthendohosyurrt());

            C_ErrorKbn errorkbn = getYoteiRiritu.exec(getYoteirirituBean);
            if (C_ErrorKbn.OK.eq(errorkbn)){
                yoteiriritu = getYoteiRiritu.getYoteiriritu().multiply(100).toString();
            }
        }
        else {
            yoteiriritu = itKykSyouhn.getYoteiriritu().multiply(100).toString();
        }

        String kyknmKn = kykSya.getKyknmkn();
        String hhknnmKn = itHhknSya.getHhknnmkn();

        String kyknmKnHenkan = ConvertUtil.toHanAll(kyknmKn, 0, 1);

        String AdrKnHenkan = ConvertUtil.convZenHan(IDataConvert.iCONVERT_Z2H_ALL, AdrKn);

        String hhknnmKnHenkan = ConvertUtil.toHanAll(hhknnmKn, 0, 1);

        String tsinynoHenkan = ConvertUtil.toZenAll(tsinyno, 0, 1);

        String hhknnenHenkan = ConvertUtil.toZenAll(String.valueOf(hhknnen), 0, 1);

        String hhknnenKeiyakujiHenkan = ConvertUtil.toZenAll(String.valueOf(itKykSyouhn.getHhknnen()), 0, 1);

        String dai1hknkknHenkan = ConvertUtil.toZenAll(String.valueOf(itKykSyouhn.getDai1hknkkn()), 0, 1);

        String sibousGkHenkan = ConvertUtil.toZenAll(siboHknKnStr, 0, 1);

        String dai2HknkknsibousGkHenkan = ConvertUtil.toZenAll(dai2HknkknsibousGkStr, 0, 1);

        String dai3HknkknsibousGkHenkan = ConvertUtil.toZenAll(dai3HknkknsibousGkStr, 0, 1);

        String kaiyakuhrHenkan = ConvertUtil.toZenAll(kaiyakuhrString, 0, 1);

        String tmttkngkHenkan = ConvertUtil.toZenAll(tmttkngkString, 0, 1);

        String rsgakuHenkan = ConvertUtil.toZenAll(rsgakuStr, 0, 1);

        String sibousYenHenkan = ConvertUtil.toZenAll(siboHknKnYenkaStr, 0, 1);

        String dai2HknkknsibousYenHenkan = ConvertUtil.toZenAll(dai2HknkknsibousYenkaStr, 0, 1);

        String dai3HknkknsibousYenHenkan = ConvertUtil.toZenAll(dai3HknkknsibousYenkaStr, 0, 1);

        String kaiyakuhrYenHenkan = ConvertUtil.toZenAll(kaiyakuhrYenString, 0, 1);

        String tmttkngkYenHenkan = ConvertUtil.toZenAll(tmttkngkYenString, 0, 1);

        String hrkpYenHenkan = ConvertUtil.toZenAll(hrkpYenString, 0, 1);

        String haraikomiTkRateHenkan = ConvertUtil.toZenAll(String.valueOf(haraikomiTkRate), 0, 1);

        String yenKawaserateHenkan = ConvertUtil.toZenAll(String.valueOf(yenKawaserate), 0, 1);

        String targetTkMokuhyoutiHenkan = ConvertUtil.toZenAll(String.valueOf(targetTkMokuhyouti), 0, 1);

        String nenkinkknHenkan = ConvertUtil.toZenAll(String.valueOf(nenkinkknStr), 0, 1);

        String hknkknHenkan = ConvertUtil.toZenAll(String.valueOf(hknkknStr), 0, 1);

        String hrikmHenkan = ConvertUtil.toZenAll(String.valueOf(hrkmkkn), 0, 1);

        String toutatugkHenkan = ConvertUtil.toZenAll(toutatugkStr, 0, 1);

        String yendthnkhrHenkan = ConvertUtil.toZenAll(yendthnkhrStr, 0, 1);

        String yoteirirituHenkan = ConvertUtil.toZenAll(yoteiriritu, 0, 1);

        String tumitaterirituHenkan = ConvertUtil.toZenAll(tumitateriritu, 0, 1);

        String tmttriritu10nengoHenkan = ConvertUtil.toZenAll(tmttriritu10nengo, 0, 1);

        String tmttknzoukaritujygnHenkan = ConvertUtil.toZenAll(tmttknzoukaritujygn, 0, 1);

        String tnsmbairituHenkan = ConvertUtil.toZenAll(tnsmbairitu, 0, 1);

        String rendourituHenkan = ConvertUtil.toZenAll(rendouritu, 0, 1);

        String tuuka = "";

        tuuka = itKykSyouhn.getKyktuukasyu().getContent();

        String hrkTuuka = "";

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getYennykntkhkumu()) ||
            C_UmuKbn.ARI.eq(itKykSonotaTkyk.getGaikanykntkhkumu())) {

            hrkTuuka = nyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();

        }

        int i = 0;
        int tkNmEditSuu = 0;
        List<String> tkNmList = new ArrayList<>();

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

            tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_JYUUDOKAIGOMAEBARAI);

            tkNmEditSuu ++;
            i ++;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

            tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_INITSBJIYENSHRGKSITIHSYUTK);

            tkNmEditSuu ++;
            i ++;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getYennykntkhkumu())){
            if (C_YennykntksyuruiKbn.PYENHRKM.eq(itKykSonotaTkyk.getYennyknsyuruikbn())){
                if (BizDateUtil.compareYmd(pSyoriYmd,HANTEIYMD_SLMTAIOUKAISIYMD) == BizDateUtil.COMPARE_LESSER){
                    tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM);
                    tkNmEditSuu ++;
                    i ++;
                }
                else {
                    tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM_ITIJI);
                    tkNmEditSuu ++;
                    i ++;
                }
            }
            else if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(itKykSonotaTkyk.getYennyknsyuruikbn())){
                tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM_YENHRKGK);
                tkNmEditSuu ++;
                i ++;
            }
            else if (C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU.eq(itKykSonotaTkyk.getYennyknsyuruikbn())) {

                tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM_YENHENDOU);
                tkNmEditSuu ++;
                i ++;
            }
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getGaikanykntkhkumu())) {

            tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_GAIKANYUUKIN);

            tkNmEditSuu ++;
            i ++;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getTargettkhkumu())) {

            if (C_TargetTkKbn.SYUUSIN.eq(itKykSonotaTkyk.getTargettkkbn())) {
                if (targetTkMokuhyouti != 0){
                    tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENSYSNHENTK + "　" + targetTkMokuhyoutiHenkan + "％");
                }
                else {
                    tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENSYSNHENTK + "　指定なし");
                }

                tkNmEditSuu ++;
                i ++;
            }

            if (C_TargetTkKbn.NENKIN.eq(itKykSonotaTkyk.getTargettkkbn())) {
                if (targetTkMokuhyouti != 0){
                    tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENNKHKNHENTK + "　" + targetTkMokuhyoutiHenkan + "％");
                }
                else {
                    tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENNKHKNHENTK + "　指定なし");
                }

                tkNmEditSuu ++;
                i ++;
            }
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getKykdrtkykhukaumu())) {

            tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENKYKDRTKYK) ;

            tkNmEditSuu ++;
            i ++;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getStdrsktkyhkumu())) {

            if (BizDateUtil.compareYmd(pSyoriYmd,HANTEIYMD_SLMTAIOUKAISIYMD) == BizDateUtil.COMPARE_LESSER){
                tkNmList.add("指定代理請求特約");
            }
            else {
                tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_SITEIDAIRISEIKYUU);
            }

            tkNmEditSuu ++;
            i ++;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

            tkNmList.add(IKhozenCommonConstants.TOKUYAKUNM_ZEISEITEKIKAKU_ZENKAKU);

            tkNmEditSuu ++;
            i ++;
        }

        for (; i < 15; i++) {

            tkNmList.add("");
        }

        int hosyouNaiyouEditSuu = 0;
        List<String> hosyouNaiyouList = new ArrayList<>();
        String kingaku = "";
        int j = 0;


        for (IT_KhTtdkRireki itKhTtdkRireki : itKhTtdkRirekiList) {
            if (itKykSyouhn.getYendthnkymd() != null &&
                IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(itKhTtdkRireki.getGyoumuKousinKinou())){

                if (C_UmuKbn.ARI.eq(syuusinhknumu)) {

                    if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(itKhTtdkRireki.getSyorikbn())){
                        hosyouNaiyouList.add(yendthnkmsg);
                        hosyouNaiyouList.add("　　　　　　　　　　　　到達金額　　　　　" + toutatugkHenkan + "円");
                        j = j + 2;
                        hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
                    }

                    if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(itKhTtdkRireki.getSyorikbn())){
                        hosyouNaiyouList.add(yendthnkmsg);
                        hosyouNaiyouList.add("　　　　　　　　　　　　到達金額　　　　　" + toutatugkHenkan + "円");
                        j = j + 2;
                        hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
                    }
                    if (yendthnkhr.compareTo(BizCurrency.valueOf(0)) > 0 ){
                        for (IT_KhHenreikin itKhHenreikin : itKhHenreikinList) {
                            if (C_HrsyuruiKbn.YENDTHNKHENREI.eq(itKhHenreikin.getHrsyuruikbn())){
                                if (C_Siharaijyoutaikbn.MBR.eq(itKhHenreikin.getHrsiharaijyoutaikbn()) ||
                                    C_Siharaijyoutaikbn.SIHARAIZUMI.eq(itKhHenreikin.getHrsiharaijyoutaikbn())){
                                    hosyouNaiyouList.add("　　　　　　　　　　　　円建変更時返戻金　" + yendthnkhrHenkan + "円　" + hrsiharaijyoutai);
                                    j = j + 1;
                                    hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;

                                    break;
                                }
                            }
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(nkhknumu)){

                    if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(itKhTtdkRireki.getSyorikbn())){
                        hosyouNaiyouList.add(yendthnkmsg);
                        hosyouNaiyouList.add("　　　　　　　　　　　　到達金額　　　　　" + toutatugkHenkan + "円");
                        j = j + 2;
                        hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
                    }

                    if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(itKhTtdkRireki.getSyorikbn())){
                        hosyouNaiyouList.add(yendthnkmsg);
                        hosyouNaiyouList.add("　　　　　　　　　　　　到達金額　　　　　" + toutatugkHenkan + "円");
                        j = j + 2;
                        hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
                    }
                }

                break;
            }
        }

        if (itKykKihon.getSbuktnin() > 0) {
            hosyouNaiyouList.add("死亡時支払金受取人　" + sbuktnmStr);
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if (C_UmuKbn.ARI.eq(nkhknumu)) {
            hosyouNaiyouList.add("年金受取人　　　　　" + nkuktnmStr);
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getKykdrtkykhukaumu())){
            hosyouNaiyouList.add("契約者代理人　　　　" + kykdrnnmStr);
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getStdrsktkyhkumu())){
            if (BizDateUtil.compareYmd(pSyoriYmd,HANTEIYMD_SLMTAIOUKAISIYMD) == BizDateUtil.COMPARE_LESSER){
                hosyouNaiyouList.add("指定代理請求人　　　"+ stdrsknmStr);
            }
            else {
                hosyouNaiyouList.add("被保険者代理人　　　"+ stdrsknmStr);
            }
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if (itTrkKzkList.size() != 0) {
            if (!"".equals(trkkzknmStr1)){
                hosyouNaiyouList.add("登録家族（１人目）　" + trkkzknmStr1);
            }
            else {
                hosyouNaiyouList.add("登録家族（１人目）　" + "登録されておりません");
            }
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;

            if (!"".equals(trkkzknmStr2)){
                hosyouNaiyouList.add("登録家族（２人目）　" + trkkzknmStr2);
            }
            else {
                hosyouNaiyouList.add("登録家族（２人目）　" + "登録されておりません");
            }
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if (!"".equals(yakkanJyuryou)){
            if (!"".equals(sioriYakkanKensakucd)){

                hosyouNaiyouList.add("契約加入時しおり約款検索コード　"+ sioriYakkanKensakucd);
                hosyouNaiyouList.add("約款受領方法　" + yakkanJyuryou);
                j = j + 2;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
            }
        }

        if (C_UmuKbn.ARI.eq(nkhknumu) &&
            C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhn.getKykjyoutai()) &&
            itKykSyouhn.getYendthnkymd() == null) {

            String teirituzoukakrirwStr = "定率増加部分繰り入れ割合　" + teirituzoukakrirw + "％";

            if (itKykSyouhn.getTmttknitenymd() != null &&
                BizDate.getSysDate().compareTo(itKykSyouhn.getTmttknitenymd()) >= 0) {
                teirituzoukakrirwStr += "　積立金移転日　" + tmttknitenymdHenkan;
            }

            hosyouNaiyouList.add(teirituzoukakrirwStr);

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if (itKykSyouhn.getYendthnkymd() == null &&
            C_UmuKbn.NONE.eq(itKykSonotaTkyk.getYennykntkhkumu()) &&
            syohinHanteiKbn != SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            hosyouNaiyouList.add("払込保険料の円換算額　　　　" + hrkpYenHenkan +"円");
            hosyouNaiyouList.add("　保険料領収日時点の円換算為替レート　１" + tuuka + "＝" + yenKawaserateHenkan + "円（" + hknKhpRyosyuymdHenkan + "）");
            j = j + 2;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
        }

        if (henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE ||
            (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN)){

            hosyouNaiyouList.add("予定利率　" + yoteirirituHenkan + "％");
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        else if (henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE){

            hosyouNaiyouList.add("積立利率　契約時点　" + tumitaterirituHenkan + "％　　契約時から１０年経過後　" + tmttriritu10nengoHenkan + "％");
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        else if (henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO){

            hosyouNaiyouList.add("積立利率　" + tumitaterirituHenkan + "％");
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR){
            if (itKykSyouhn.getYendthnkymd() == null){
                if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(itKykSyouhn.getTmttknhaibunjyoutai())){

                    hosyouNaiyouList.add("積立利率　" + tumitaterirituHenkan + "％　　積立金増加率上限　" + tmttknzoukaritujygnHenkan + "％　　たのしみ倍率　" + tnsmbairituHenkan + "倍");

                }
                else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(itKykSyouhn.getTmttknhaibunjyoutai())){

                    hosyouNaiyouList.add("積立利率　" + tumitaterirituHenkan + "％");
                }
            }
            else {

                hosyouNaiyouList.add("積立利率　" + tumitaterirituHenkan + "％");
            }
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20){
            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(itKykSyouhn.getTmttknhaibunjyoutai())){

                hosyouNaiyouList.add("積立利率　" + tumitaterirituHenkan + "％　　連動率　" + rendourituHenkan + "％");
            }
            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(itKykSyouhn.getTmttknhaibunjyoutai())){

                hosyouNaiyouList.add("積立利率　" + tumitaterirituHenkan + "％");
            }
            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if ((henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE) ||
            syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            hosyouNaiyouList.add("死亡時");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if (henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO ){

            hosyouNaiyouList.add("死亡時　　　　　　　　　　　" + sibousGkHenkan + "円");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if (henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO ){

            hosyouNaiyouList.add("死亡時（照会日時点）　　　　" + sibousGkHenkan + "円");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if (itKykSyouhn.getYendthnkymd() == null &&
            C_UmuKbn.NONE.eq(bmSyouhnZokusei.getDai1hknkknsbsyokuseiumu())) {

            hosyouNaiyouList.add("死亡時（照会日時点）　　　　" + sibousGkHenkan + tuuka + "　　（" + sibousYenHenkan + "円）");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if (C_UmuKbn.ARI.eq(nkhknumu) && !C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhn.getKykjyoutai())) {

            hosyouNaiyouList.add("（保険料の払込回数に応じて計算しております。）");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if ((henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE)
            && C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn)) {

            kingaku = sibousGkHenkan + tuuka;

            hosyouNaiyouList.add("　第１保険期間（照会日時点）　　　　　　　　　　　" + kingaku);
            hosyouNaiyouList.add("　　　　　　　　　　　　　　　　　　　　　　　　　（" + sibousYenHenkan + "円）");

            j = j + 2;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;

        }

        if (C_HknkknBunruiKbn.THIRD.eq(bmSyouhnZokusei.getHknkknbunruikbn())
            && C_UmuKbn.ARI.eq(bmSyouhnZokusei.getDai1hknkknsbsyokuseiumu())
            && C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn)) {

            hosyouNaiyouList.add("　第２保険期間（契約日から" + dai1hknkknHenkan + "年経過時点）※");
            hosyouNaiyouList.add("　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。");

            j = j + 2;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;

        }

        if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getDai1hknkknsbsyokuseiumu())
            && C_HknKknKbn.DAI2HKNKKN.eq(cHknKknKbn)) {

            kingaku = sibousGkHenkan + tuuka;

            if (C_HknkknBunruiKbn.THIRD.eq(bmSyouhnZokusei.getHknkknbunruikbn())) {

                hosyouNaiyouList.add("　第２保険期間（照会日時点）　　　　　　　　　　　" + kingaku);
                hosyouNaiyouList.add("　　　　　　　　　　　　　　　　　　　　　　　　　（" + sibousYenHenkan +"円）");

                j = j + 2;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
            }
        }

        if (henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE) {
            if (C_HknKknKbn.DAI2HKNKKN.eq(cHknKknKbn)) {

                kingaku = sibousGkHenkan + tuuka;

                hosyouNaiyouList.add("　第２保険期間（照会日時点）※　　　　　　　　　　" + kingaku);
                hosyouNaiyouList.add("　　　　　　　　　　　　　　　　　　　　　　　　　（" + sibousYenHenkan +"円）");
                hosyouNaiyouList.add("　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。");

                j = j + 3;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 3;
            }

            else if (C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn)) {

                kingaku = dai2HknkknsibousGkHenkan + tuuka;

                hosyouNaiyouList.add("　第２保険期間（契約日から" + dai1hknkknHenkan + "年経過以後）※　　　　" + kingaku);
                hosyouNaiyouList.add("　　　　　　　　　　　　　　　　　　　　　　　　　（" + dai2HknkknsibousYenHenkan +"円）");
                hosyouNaiyouList.add("　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。");

                j = j + 3;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 3;
            }
        }

        if (C_HknkknBunruiKbn.THIRD.eq(bmSyouhnZokusei.getHknkknbunruikbn())
            && C_UmuKbn.ARI.eq(bmSyouhnZokusei.getDai1hknkknsbsyokuseiumu())
            && (C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn)
                || C_HknKknKbn.DAI2HKNKKN.eq(cHknKknKbn))) {

            kingaku = dai3HknkknsibousGkHenkan + tuuka;

            hosyouNaiyouList.add("　第３保険期間（契約日から１５年経過時点）　　　　" + kingaku);
            hosyouNaiyouList.add("　　　　　　　　　　　　　　　　　　　　　　　　　（" + dai3HknkknsibousYenHenkan +"円）");

            j = j + 2;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
        }

        if (C_HknkknBunruiKbn.THIRD.eq(bmSyouhnZokusei.getHknkknbunruikbn())
            && C_UmuKbn.ARI.eq(bmSyouhnZokusei.getDai1hknkknsbsyokuseiumu())
            && C_HknKknKbn.DAI3HKNKKN.eq(cHknKknKbn)) {

            kingaku = sibousGkHenkan + tuuka;

            hosyouNaiyouList.add("第３保険期間（照会日時点）　　　　　　　　　　　" + kingaku);
            hosyouNaiyouList.add("　　　　　　　　　　　　　　　　　　　　　　　　（" + sibousYenHenkan +"円）");

            j = j + 2;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
        }

        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            if (C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn)) {
                if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {

                    kingaku = sibousGkHenkan + tuuka;

                    hosyouNaiyouList.add("　第１保険期間（契約日以後" + dai1hknkknHenkan + "年）（照会日時点）　　" + kingaku);
                    hosyouNaiyouList.add("　　　　　　　　　　　　　　　　　　　　　　　　　（" + sibousYenHenkan +"円）");

                    j = j + 2;
                    hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
                }
                else {

                    kingaku = sibousGkHenkan + "円";

                    hosyouNaiyouList.add("　第１保険期間（契約日以後" + dai1hknkknHenkan + "年）（照会日時点）　　" + kingaku);

                    j = j + 1;
                    hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
                }

                hosyouNaiyouList.add("　　※第１保険期間中の保障額は、照会日時点の既払込保険料相当額です。");

                j = j + 1;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
            }

            if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {

                kingaku = dai2HknkknsibousGkHenkan + tuuka;

                hosyouNaiyouList.add("　第２保険期間（契約日から" + dai1hknkknHenkan + "年経過以後）　　　　　" + kingaku);
                hosyouNaiyouList.add("　　　　　　　　　　　　　　　　　　　　　　　　　（" + dai2HknkknsibousYenHenkan +"円）");

                j = j + 2;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
            }

            else {

                kingaku = dai2HknkknsibousGkHenkan + "円";

                hosyouNaiyouList.add("　第２保険期間（契約日から" + dai1hknkknHenkan + "年経過以後）　　　　　" + kingaku);

                j = j + 1;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
            }
        }

        if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {

            kingaku = kaiyakuhrHenkan + tuuka;

            hosyouNaiyouList.add("解約返戻金額（照会日時点）　" + kingaku + "　　（" + kaiyakuhrYenHenkan + "円）");

            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if (henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE ||
            henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE) {

            kingaku = tmttkngkHenkan + tuuka;

            hosyouNaiyouList.add("積立金額（照会日時点）　" + kingaku + "　　（" + tmttkngkYenHenkan + "円）");

            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if (!C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {

            hosyouNaiyouList.add("上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。");

            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }
        else {
            if(henkoukubetuSyohinHanteiKbn != SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO){

                hosyouNaiyouList.add("解約返戻金額（照会日時点）　" + kaiyakuhrHenkan + "円");

                j ++;
                hosyouNaiyouEditSuu ++;
            }
        }

        if (itKykSyouhn.getYendthnkymd() != null) {

            hosyouNaiyouList.add("積立金額（照会日時点）　" + tmttkngkHenkan + "円");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if(henkoukubetuSyohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO){

            hosyouNaiyouList.add("　※死亡保険金額（照会日時点）、解約返戻金額（照会日時点）も同額になります。");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if (C_UmuKbn.ARI.eq(nkhknumu) && !C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhn.getKykjyoutai())) {

            hosyouNaiyouList.add("年金開始日　　　　　　　　" + nkshrStartYmdHenkan);

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        hosyouNaiyouList.add("保険法対応契約");

        j ++;
        hosyouNaiyouEditSuu ++;

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

            hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_JYUUDOKAIGOMAEBARAI + "あり");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getYennykntkhkumu())){
            if (C_YennykntksyuruiKbn.PYENHRKM.eq(itKykSonotaTkyk.getYennyknsyuruikbn())){
                if (yendthnkymd == null){
                    if (BizDateUtil.compareYmd(pSyoriYmd,HANTEIYMD_SLMTAIOUKAISIYMD) == BizDateUtil.COMPARE_LESSER){

                        hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM + "あり　　　　　加入時保険料入金額　　　" + rsgakuHenkan + "円");
                        hosyouNaiyouList.add("　保険料領収日時点の払込特約レート　１" + tuuka + "＝" + haraikomiTkRateHenkan + "円" + "（" + hknKhpRyosyuymdHenkan + "）");

                        j = j + 2;
                        hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
                    }

                    else {
                        hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM_ITIJI + "あり　　　　　加入時保険料入金額　　　" + rsgakuHenkan + "円");
                        hosyouNaiyouList.add("　保険料領収日時点の払込特約レート　１" + tuuka + "＝" + haraikomiTkRateHenkan + "円" + "（" + hknKhpRyosyuymdHenkan + "）");

                        j = j + 2;
                        hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
                    }
                }
            }
            else if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(itKykSonotaTkyk.getYennyknsyuruikbn())){
                hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM_YENHRKGK + "あり");
                j = j + 1;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
            }
            else if (C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU.eq(itKykSonotaTkyk.getYennyknsyuruikbn())){
                hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM_YENHENDOU + "あり");
                j = j + 1;
                hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
            }
        }

        if (itKykSyouhn.getYendthnkymd() == null &&
            C_UmuKbn.ARI.eq(itKykSonotaTkyk.getGaikanykntkhkumu())) {

            kingaku = rsgakuHenkan + hrkTuuka;

            hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_GAIKANYUUKIN + "あり　　加入時保険料入金額　　" + kingaku);
            hosyouNaiyouList.add("　保険料領収日時点の払込特約レート　１" + tuuka + "＝" + haraikomiTkRateHenkan + hrkTuuka + "（" + hknKhpRyosyuymdHenkan + "）");

            j = j + 2;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 2;
        }


        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

            hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_ZEISEITEKIKAKU_ZENKAKU + "あり");

            j = j + 1;
            hosyouNaiyouEditSuu = hosyouNaiyouEditSuu + 1;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

            hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_INITSBJIYENSHRGKSITIHSYUTK + "あり");

            j ++;
            hosyouNaiyouEditSuu ++;

        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getKykdrtkykhukaumu())) {

            hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENKYKDRTKYK + "あり");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getStdrsktkyhkumu())) {

            if (BizDateUtil.compareYmd(pSyoriYmd,HANTEIYMD_SLMTAIOUKAISIYMD) == BizDateUtil.COMPARE_LESSER){
                hosyouNaiyouList.add("指定代理請求特約あり");
            }
            else {
                hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_SITEIDAIRISEIKYUU + "あり");
            }

            j ++;
            hosyouNaiyouEditSuu ++;

        }


        if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getDai1hknkknsbsyokuseiumu())
            && (C_HknKknKbn.DAI1HKNKKN.eq(cHknKknKbn)
                || C_HknKknKbn.DAI2HKNKKN.eq(cHknKknKbn))) {

            if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getTargettkhkumu()) &&
                C_TargetTkKbn.SYUUSIN.eq(itKykSonotaTkyk.getTargettkkbn()) &&
                itKykSonotaTkyk.getTargettkmokuhyouti() != 0) {

                hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENSYSNHENTK + "あり　　　　　（目標額割合　" + targetTkMokuhyoutiHenkan + "％）");

                j ++;
                hosyouNaiyouEditSuu ++;
            }
            else if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getTargettkhkumu()) &&
                C_TargetTkKbn.SYUUSIN.eq(itKykSonotaTkyk.getTargettkkbn()) &&
                itKykSonotaTkyk.getTargettkmokuhyouti() == 0) {
                hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENSYSNHENTK + "あり　　　　　（目標額割合　指定なし）");

                j ++;
                hosyouNaiyouEditSuu ++;
            }
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getTargettkhkumu()) &&
            C_TargetTkKbn.NENKIN.eq(itKykSonotaTkyk.getTargettkkbn()) &&
            itKykSonotaTkyk.getTargettkmokuhyouti() != 0) {

            hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENNKHKNHENTK + "あり　　　　　（目標額割合　" + targetTkMokuhyoutiHenkan + "％）");

            j ++;
            hosyouNaiyouEditSuu ++;
        }
        else if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getTargettkhkumu()) &&
            C_TargetTkKbn.NENKIN.eq(itKykSonotaTkyk.getTargettkkbn()) &&
            itKykSonotaTkyk.getTargettkmokuhyouti() == 0) {
            hosyouNaiyouList.add(IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENNKHKNHENTK + "あり　　　　　（目標額割合　指定なし）");

            j ++;
            hosyouNaiyouEditSuu ++;
        }

        for (; j < 25; j++) {

            hosyouNaiyouList.add("");
        }

        if (hosyouNaiyouEditSuu > 25) {
            hosyouNaiyouEditSuu = 25;
        }

        List<String> henkouKeiiList = new ArrayList<>();
        int k = 0;

        if (henkouKeiiKensuu == 0) {

            henkouKeiiList.add("＊＊＊＊＊");

            for (int p = 1; p < 10; p++) {

                henkouKeiiList.add("");
            }
            henkouKeiiKensuu = 1;

        }
        else {

            for (int q = 0; q < henkouKeiiKensuu; q++) {

                if (IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　契約内容変更");
                    k ++;
                }

                else if (IKhozenCommonConstants.KINOUID_KHKZKTRKKYKDRTKYKHNK.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　契約内容変更");
                    k ++;
                }

                else if (IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　契約内容変更");
                    k ++;
                }
                else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　契約内容変更");
                    k ++;
                }
                else if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　契約内容変更");
                    k ++;
                }
                else if (IKhozenCommonConstants.KINOUID_MEIGIHENKOU.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　名義変更");
                    k ++;
                }
                else if (IKhozenCommonConstants.KINOUID_KANAKANJITEISEI.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　名義変更");
                    k ++;
                }
                else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　名義変更");
                    k ++;
                }
                else if (IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())) {

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　住所変更");
                    k ++;
                }
                else if (IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(itKhTtdkRirekiList.get(q).
                    getGyoumuKousinKinou())){

                    henkouKeiiList.add(keiihenkouYmdListHenkan.get(q) + "　保険料払方変更");
                    k ++;
                }
            }
        }

        for (; k < 10; k++) {

            henkouKeiiList.add("");
        }

        String hhknsei = "";
        if (C_Hhknsei.MALE.eq(itHhknSya.getHhknsei())) {

            hhknsei = "男性";
        }
        else if (C_Hhknsei.FEMALE.eq(itHhknSya.getHhknsei())) {

            hhknsei = "女性";
        }
        else {

            hhknsei = "性";
        }

        String syurui = "";
        if (C_UmuKbn.ARI.eq(syuusinhknumu)) {

            syurui = "終身保険";
        }
        else {

            if (C_UmuKbn.ARI.eq(nkhknumu) ) {
                syurui = "年金保険";
            }
            else {
                syurui = "";
            }
        }

        String cifCd = "";
        if (BizUtil.isBlank(itKykKihon.getCifcd())) {

            cifCd = "*****";
        }
        else {

            cifCd = itKykKihon.getCifcd();
        }

        String haitouKbnString = "";
        if (!C_HaitouKbn.YUUHAI.eq(haitoukbn)) {

            haitouKbnString = "準有配当";
        }
        else {

            haitouKbnString = "";
        }

        String sinsaKbn = "";
        if (C_SntkhouKbn.KKT.eq(itKykKihon.getSntkhoukbn())
            || C_SntkhouKbn.SYOKUGYOU.eq(itKykKihon.getSntkhoukbn())) {

            sinsaKbn = "告知書扱";
        }
        else if (C_SntkhouKbn.HJY.eq(itKykKihon.getSntkhoukbn())) {

            if (C_SinsaKbn.SYAI_SYOKUTAKUI.eq(itKykKihon.getSinsakbn())) {

                sinsaKbn = "社医扱";
            }

            else if (C_SinsaKbn.NINGENDOKKU.eq(itKykKihon.getSinsakbn()) ||
                C_SinsaKbn.KNKSINDANKEKKATUUTIS.eq(itKykKihon.getSinsakbn()) ||
                C_SinsaKbn.KENKOUKANRISYOUMEISY.eq(itKykKihon.getSinsakbn())) {

                sinsaKbn = "健康証明書扱、準人間ドック扱";
            }
            else {

                sinsaKbn = "";
            }

        }
        else if (C_SntkhouKbn.BLNK.eq(itKykKihon.getSntkhoukbn()) ||
            C_SntkhouKbn.NONE.eq(itKykKihon.getSntkhoukbn())) {

            sinsaKbn = "";
        }

        String hokenMankiDay = "";
        if (C_UmuKbn.ARI.eq(syuusinhknumu)) {

            hokenMankiDay = "終身";
        }
        else {

            hokenMankiDay = hknkknmanryouYmdHenkan;
        }

        String syunm = "";
        if (C_UmuKbn.ARI.eq(syuusinhknumu)) {

            syunm =  "終身保険";
        }
        else {
            if (C_UmuKbn.ARI.eq(nkhknumu) ) {
                syunm = "個人年金";
            }
            else {
                syunm = "";
            }
        }

        BizCurrency syus = BizCurrency.optional();
        if (!C_UmuKbn.ARI.eq(nkhknumu) ) {
            syus = itKykSyouhn.getKihons();
        }

        String syuhknkkn = "";
        if (C_UmuKbn.ARI.eq(syuusinhknumu)) {

            syuhknkkn = "終身";
        }
        else {
            if (C_UmuKbn.ARI.eq(nkhknumu) ) {
                syuhknkkn = hknkknHenkan;
            }
            else {
                syuhknkkn =  "";
            }
        }

        String syuhrkmkkn = "";
        if (!C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhn.getKykjyoutai())){
            if (C_HrkkknsmnKbn.SAIMANKI.eq(itKykSyouhn.getHrkkknsmnkbn())) {

                syuhrkmkkn = hrikmHenkan;
            }
        }

        String nenkinHosyouYear = "";
        if (C_UmuKbn.ARI.eq(nkhknumu) ) {
            if (C_Nenkinsyu.KAKUTEINENKIN.eq(itKykSyouhn.getNksyukbn()) ||
                C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(itKykSyouhn.getNksyukbn())) {
                nenkinHosyouYear = nenkinkknHenkan;
            }
            else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(itKykSyouhn.getNksyukbn())) {
                nenkinHosyouYear = "終身";
            }
        }

        String nenkinKbn = "";
        if (C_UmuKbn.ARI.eq(nkhknumu) ) {
            if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(itKykSyouhn.getNksyukbn())){
                nenkinKbn = NNKNKBN_KAKUTEIDAI1BAIGAKUGATA;
            }
            else {
                nenkinKbn = itKykSyouhn.getNksyukbn().getContent(C_Nenkinsyu.PATTERN_KHSYOUKAI);
            }
        }

        webKykNaiyouSyoukaiInfoBean.setErrorKbn("");
        webKykNaiyouSyoukaiInfoBean.setErrorMsg("");
        webKykNaiyouSyoukaiInfoBean.setKyknmkn(kyknmKnHenkan);
        webKykNaiyouSyoukaiInfoBean.setKyknmkj(kykSya.getKyknmkj() + KEISYOU_SAMA);
        webKykNaiyouSyoukaiInfoBean.setKykseiymd(kykseiYmdHenkan);
        webKykNaiyouSyoukaiInfoBean.setKojinhjnKbn("個人");
        webKykNaiyouSyoukaiInfoBean.setTelno(kykSya.getTsintelno());
        webKykNaiyouSyoukaiInfoBean.setPostalCd(tsinynoHenkan);
        webKykNaiyouSyoukaiInfoBean.setAdr(kykSya.getTsinadr1kj() + kykSya.getTsinadr2kj() + kykSya.getTsinadr3kj());
        webKykNaiyouSyoukaiInfoBean.setAdrkn(AdrKnHenkan);
        webKykNaiyouSyoukaiInfoBean.setHhknnm(itHhknSya.getHhknnmkj() + KEISYOU_SAMA);
        webKykNaiyouSyoukaiInfoBean.setHhknsei(hhknsei);
        webKykNaiyouSyoukaiInfoBean.setHhknseiymd(hhknseiymdHenkan);
        webKykNaiyouSyoukaiInfoBean.setHhknNen(hhknnenHenkan + "歳");
        webKykNaiyouSyoukaiInfoBean.setHhknKykjiNen(hhknnenKeiyakujiHenkan + "歳");
        webKykNaiyouSyoukaiInfoBean.setSyouhnnm(syouhnnm);
        webKykNaiyouSyoukaiInfoBean.setSyurui(syurui);
        webKykNaiyouSyoukaiInfoBean.setSyono(itKykKihon.getSyono());
        webKykNaiyouSyoukaiInfoBean.setCifCd(cifCd);
        webKykNaiyouSyoukaiInfoBean.setKykymd(kykYmdHenkan);
        webKykNaiyouSyoukaiInfoBean.setHrkhou(hrikmh);
        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {
            webKykNaiyouSyoukaiInfoBean.setSibous(itKykSyouhn.getKihons());
        }else{
            webKykNaiyouSyoukaiInfoBean.setSibous(siboHknKn);
        }
        webKykNaiyouSyoukaiInfoBean.setHrkp(itKykKihon.getHrkp());
        webKykNaiyouSyoukaiInfoBean.setNkShrStartYmd(nkshrStartYmdHenkan);
        webKykNaiyouSyoukaiInfoBean.setNenkinHosyouYear(nenkinHosyouYear);
        webKykNaiyouSyoukaiInfoBean.setNenkinKbn(nenkinKbn);
        webKykNaiyouSyoukaiInfoBean.setHaitouKbn(haitouKbnString);
        webKykNaiyouSyoukaiInfoBean.setSinsaKbn(sinsaKbn);
        webKykNaiyouSyoukaiInfoBean.setTksuu(tkNmEditSuu);
        webKykNaiyouSyoukaiInfoBean.setLivingneedsTkhyj("");
        webKykNaiyouSyoukaiInfoBean.setHokenMankiDay(hokenMankiDay);
        webKykNaiyouSyoukaiInfoBean.setSyunm(syunm);
        webKykNaiyouSyoukaiInfoBean.setSyus(syus);
        webKykNaiyouSyoukaiInfoBean.setSyuhknkkn(syuhknkkn);
        webKykNaiyouSyoukaiInfoBean.setSyuhrkkkn(syuhrkmkkn);
        webKykNaiyouSyoukaiInfoBean.setTkNaiyouGyousuu(tkNmEditSuu);
        webKykNaiyouSyoukaiInfoBean.setTknm1(tkNmList.get(0));
        webKykNaiyouSyoukaiInfoBean.setTks1(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan1("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan1("");
        webKykNaiyouSyoukaiInfoBean.setTknm2(tkNmList.get(1));
        webKykNaiyouSyoukaiInfoBean.setTks2(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan2("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan2("");
        webKykNaiyouSyoukaiInfoBean.setTknm3(tkNmList.get(2));
        webKykNaiyouSyoukaiInfoBean.setTks3(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan3("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan3("");
        webKykNaiyouSyoukaiInfoBean.setTknm4(tkNmList.get(3));
        webKykNaiyouSyoukaiInfoBean.setTks4(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan4("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan4("");
        webKykNaiyouSyoukaiInfoBean.setTknm5(tkNmList.get(4));
        webKykNaiyouSyoukaiInfoBean.setTks5(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan5("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan5("");
        webKykNaiyouSyoukaiInfoBean.setTknm6(tkNmList.get(5));
        webKykNaiyouSyoukaiInfoBean.setTks6(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan6("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan6("");
        webKykNaiyouSyoukaiInfoBean.setTknm7(tkNmList.get(6));
        webKykNaiyouSyoukaiInfoBean.setTks7(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan7("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan7("");
        webKykNaiyouSyoukaiInfoBean.setTknm8(tkNmList.get(7));
        webKykNaiyouSyoukaiInfoBean.setTks8(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan8("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan8("");
        webKykNaiyouSyoukaiInfoBean.setTknm9(tkNmList.get(8));
        webKykNaiyouSyoukaiInfoBean.setTks9(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan9("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan9("");
        webKykNaiyouSyoukaiInfoBean.setTknm10(tkNmList.get(9));
        webKykNaiyouSyoukaiInfoBean.setTks10(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan10("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan10("");
        webKykNaiyouSyoukaiInfoBean.setTknm11(tkNmList.get(10));
        webKykNaiyouSyoukaiInfoBean.setTks11(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan11("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan11("");
        webKykNaiyouSyoukaiInfoBean.setTknm12(tkNmList.get(11));
        webKykNaiyouSyoukaiInfoBean.setTks12(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan12("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan12("");
        webKykNaiyouSyoukaiInfoBean.setTknm13(tkNmList.get(12));
        webKykNaiyouSyoukaiInfoBean.setTks13(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan13("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan13("");
        webKykNaiyouSyoukaiInfoBean.setTknm14(tkNmList.get(13));
        webKykNaiyouSyoukaiInfoBean.setTks14(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan14("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan14("");
        webKykNaiyouSyoukaiInfoBean.setTknm15(tkNmList.get(14));
        webKykNaiyouSyoukaiInfoBean.setTks15(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan15("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan15("");
        webKykNaiyouSyoukaiInfoBean.setSyouhnNaiyouGyousuu(1);
        webKykNaiyouSyoukaiInfoBean.setSyouhnNaiyou1("現在の保障内容は下記のとおりです。");
        webKykNaiyouSyoukaiInfoBean.setSyouhnNaiyou2("");
        webKykNaiyouSyoukaiInfoBean.setSyouhnNaiyou3("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyouGyousuu(hosyouNaiyouEditSuu);
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou1(hosyouNaiyouList.get(0));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou2(hosyouNaiyouList.get(1));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou3(hosyouNaiyouList.get(2));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou4(hosyouNaiyouList.get(3));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou5(hosyouNaiyouList.get(4));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou6(hosyouNaiyouList.get(5));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou7(hosyouNaiyouList.get(6));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou8(hosyouNaiyouList.get(7));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou9(hosyouNaiyouList.get(8));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou10(hosyouNaiyouList.get(9));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou11(hosyouNaiyouList.get(10));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou12(hosyouNaiyouList.get(11));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou13(hosyouNaiyouList.get(12));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou14(hosyouNaiyouList.get(13));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou15(hosyouNaiyouList.get(14));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou16(hosyouNaiyouList.get(15));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou17(hosyouNaiyouList.get(16));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou18(hosyouNaiyouList.get(17));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou19(hosyouNaiyouList.get(18));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou20(hosyouNaiyouList.get(19));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou21(hosyouNaiyouList.get(20));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou22(hosyouNaiyouList.get(21));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou23(hosyouNaiyouList.get(22));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou24(hosyouNaiyouList.get(23));
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou25(hosyouNaiyouList.get(24));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeiiGyousuu(henkouKeiiKensuu);
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii1(henkouKeiiList.get(0));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii2(henkouKeiiList.get(1));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii3(henkouKeiiList.get(2));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii4(henkouKeiiList.get(3));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii5(henkouKeiiList.get(4));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii6(henkouKeiiList.get(5));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii7(henkouKeiiList.get(6));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii8(henkouKeiiList.get(7));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii9(henkouKeiiList.get(8));
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii10(henkouKeiiList.get(9));
        webKykNaiyouSyoukaiInfoBean.setBosyuDrtenGyousuu(dairitenNo);
        webKykNaiyouSyoukaiInfoBean.setBosyuDrtenNm1(kanjiDairitenNm1);
        webKykNaiyouSyoukaiInfoBean.setDrtenBnwari1("");
        webKykNaiyouSyoukaiInfoBean.setBosyuDrtenNm2(kanjiDairitenNm2);
        webKykNaiyouSyoukaiInfoBean.setDrtenBnwari2("");
        webKykNaiyouSyoukaiInfoBean.setMsgOutKbn("2");
        webKykNaiyouSyoukaiInfoBean.setHosyouIkkatuMinaokeiyakuHyouji("0");
        webKykNaiyouSyoukaiInfoBean.setHhknnmkn(hhknnmKnHenkan);
        webKykNaiyouSyoukaiInfoBean.setHokenryouSyuunouJyoukyou(hkrsnjk);
        webKykNaiyouSyoukaiInfoBean.setJikaiHokenryouJyuutouYm(jikaiHokenryouJyuutouHenkanYm);
        webKykNaiyouSyoukaiInfoBean.setMdhansybetuKbn("01");

        logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

        return webKykNaiyouSyoukaiInfoBean;

    }

    private void setSyuuturyokukomoku(int errorMsgEditKbn) {

        String errorMsg = "";
        switch (errorMsgEditKbn) {
            case 1: errorMsg = ERRORMESSAGE1; break;
            case 2: errorMsg = ERRORMESSAGE2; break;
            case 3: errorMsg = ERRORMESSAGE3; break;
            case 4: errorMsg = ERRORMESSAGE4; break;
            case 5: errorMsg = ERRORMESSAGE5; break;
            default : break;
        }

        webKykNaiyouSyoukaiInfoBean.setErrorKbn("1");
        webKykNaiyouSyoukaiInfoBean.setErrorMsg(errorMsg);
        webKykNaiyouSyoukaiInfoBean.setKyknmkn("");
        webKykNaiyouSyoukaiInfoBean.setKyknmkj("");
        webKykNaiyouSyoukaiInfoBean.setKykseiymd("");
        webKykNaiyouSyoukaiInfoBean.setKojinhjnKbn("");
        webKykNaiyouSyoukaiInfoBean.setTelno("");
        webKykNaiyouSyoukaiInfoBean.setPostalCd("");
        webKykNaiyouSyoukaiInfoBean.setAdr("");
        webKykNaiyouSyoukaiInfoBean.setAdrkn("");
        webKykNaiyouSyoukaiInfoBean.setHhknnm("");
        webKykNaiyouSyoukaiInfoBean.setHhknsei("");
        webKykNaiyouSyoukaiInfoBean.setHhknseiymd("");
        webKykNaiyouSyoukaiInfoBean.setHhknNen("");
        webKykNaiyouSyoukaiInfoBean.setHhknKykjiNen("");
        webKykNaiyouSyoukaiInfoBean.setSyouhnnm("");
        webKykNaiyouSyoukaiInfoBean.setSyurui("");
        webKykNaiyouSyoukaiInfoBean.setSyono("");
        webKykNaiyouSyoukaiInfoBean.setCifCd("");
        webKykNaiyouSyoukaiInfoBean.setKykymd("");
        webKykNaiyouSyoukaiInfoBean.setHrkhou("");
        webKykNaiyouSyoukaiInfoBean.setSibous(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setHrkp(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setNkShrStartYmd("");
        webKykNaiyouSyoukaiInfoBean.setNenkinHosyouYear("");
        webKykNaiyouSyoukaiInfoBean.setNenkinKbn("");
        webKykNaiyouSyoukaiInfoBean.setHaitouKbn("");
        webKykNaiyouSyoukaiInfoBean.setSinsaKbn("");
        webKykNaiyouSyoukaiInfoBean.setTksuu(0);
        webKykNaiyouSyoukaiInfoBean.setLivingneedsTkhyj("");
        webKykNaiyouSyoukaiInfoBean.setHokenMankiDay("");
        webKykNaiyouSyoukaiInfoBean.setSyunm("");
        webKykNaiyouSyoukaiInfoBean.setSyus(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setSyuhknkkn("");
        webKykNaiyouSyoukaiInfoBean.setSyuhrkkkn("");
        webKykNaiyouSyoukaiInfoBean.setTkNaiyouGyousuu(0);
        webKykNaiyouSyoukaiInfoBean.setTknm1("");
        webKykNaiyouSyoukaiInfoBean.setTks1(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan1("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan1("");
        webKykNaiyouSyoukaiInfoBean.setTknm2("");
        webKykNaiyouSyoukaiInfoBean.setTks2(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan2("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan2("");
        webKykNaiyouSyoukaiInfoBean.setTknm3("");
        webKykNaiyouSyoukaiInfoBean.setTks3(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan3("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan3("");
        webKykNaiyouSyoukaiInfoBean.setTknm4("");
        webKykNaiyouSyoukaiInfoBean.setTks4(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan4("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan4("");
        webKykNaiyouSyoukaiInfoBean.setTknm5("");
        webKykNaiyouSyoukaiInfoBean.setTks5(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan5("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan5("");
        webKykNaiyouSyoukaiInfoBean.setTknm6("");
        webKykNaiyouSyoukaiInfoBean.setTks6(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan6("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan6("");
        webKykNaiyouSyoukaiInfoBean.setTknm7("");
        webKykNaiyouSyoukaiInfoBean.setTks7(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan7("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan7("");
        webKykNaiyouSyoukaiInfoBean.setTknm8("");
        webKykNaiyouSyoukaiInfoBean.setTks8(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan8("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan8("");
        webKykNaiyouSyoukaiInfoBean.setTknm9("");
        webKykNaiyouSyoukaiInfoBean.setTks9(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan9("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan9("");
        webKykNaiyouSyoukaiInfoBean.setTknm10("");
        webKykNaiyouSyoukaiInfoBean.setTks10(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan10("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan10("");
        webKykNaiyouSyoukaiInfoBean.setTknm11("");
        webKykNaiyouSyoukaiInfoBean.setTks11(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan11("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan11("");
        webKykNaiyouSyoukaiInfoBean.setTknm12("");
        webKykNaiyouSyoukaiInfoBean.setTks12(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan12("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan12("");
        webKykNaiyouSyoukaiInfoBean.setTknm13("");
        webKykNaiyouSyoukaiInfoBean.setTks13(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan13("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan13("");
        webKykNaiyouSyoukaiInfoBean.setTknm14("");
        webKykNaiyouSyoukaiInfoBean.setTks14(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan14("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan14("");
        webKykNaiyouSyoukaiInfoBean.setTknm15("");
        webKykNaiyouSyoukaiInfoBean.setTks15(BizCurrency.optional());
        webKykNaiyouSyoukaiInfoBean.setTokuyakuhokenkikan15("");
        webKykNaiyouSyoukaiInfoBean.setTokuyakuharaikomikikan15("");
        webKykNaiyouSyoukaiInfoBean.setSyouhnNaiyouGyousuu(0);
        webKykNaiyouSyoukaiInfoBean.setSyouhnNaiyou1("");
        webKykNaiyouSyoukaiInfoBean.setSyouhnNaiyou2("");
        webKykNaiyouSyoukaiInfoBean.setSyouhnNaiyou3("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyouGyousuu(0);
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou1("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou2("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou3("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou4("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou5("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou6("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou7("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou8("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou9("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou10("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou11("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou12("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou13("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou14("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou15("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou16("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou17("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou18("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou19("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou20("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou21("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou22("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou23("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou24("");
        webKykNaiyouSyoukaiInfoBean.setHosyouNaiyou25("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeiiGyousuu(0);
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii1("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii2("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii3("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii4("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii5("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii6("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii7("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii8("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii9("");
        webKykNaiyouSyoukaiInfoBean.setHenkouKeii10("");
        webKykNaiyouSyoukaiInfoBean.setBosyuDrtenGyousuu(0);
        webKykNaiyouSyoukaiInfoBean.setBosyuDrtenNm1("");
        webKykNaiyouSyoukaiInfoBean.setDrtenBnwari1("");
        webKykNaiyouSyoukaiInfoBean.setBosyuDrtenNm2("");
        webKykNaiyouSyoukaiInfoBean.setDrtenBnwari2("");
        webKykNaiyouSyoukaiInfoBean.setMsgOutKbn("");
        webKykNaiyouSyoukaiInfoBean.setHosyouIkkatuMinaokeiyakuHyouji("");
        webKykNaiyouSyoukaiInfoBean.setHhknnmkn("");
        webKykNaiyouSyoukaiInfoBean.setHokenryouSyuunouJyoukyou("");
        webKykNaiyouSyoukaiInfoBean.setJikaiHokenryouJyuutouYm("");
        webKykNaiyouSyoukaiInfoBean.setMdhansybetuKbn("");

    }

}
