package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSks;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzShiharaiDenpyouDateShutoku;
import yuyu.common.biz.kaikei.BzSinkeiyakuDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHandkarikanjyouBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 新契約共通 返金
 */
public class Henkin {

    private String denpyouNo = "";

    private int edaNo = 0;

    private String fBSkSikibetuKey = "";

    private BizDate fstpRyosyuYmd;

    private String denGyoumuCd = "";

    private final List<HT_SkDenpyoData> skDenpyoDataList = new ArrayList<>();

    private final List<HT_SkFBSoukinData> skFBSoukinDataList = new ArrayList<>();

    private final List<HT_SkGaikaFBSoukinData> skGaikaFBSoukinDataList = new ArrayList<>();

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    public Henkin() {
        super();
    }

    public HenkinOutBean exec(MosnaiCheckParam pMP, C_HnknhouKbn pHnknhouKbn,
        HT_KouzaJyouhou pKouzaJyouhou, BizCurrency pHenkingaku, C_Tuukasyu pTuukasyu) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 返金処理 開始");
            logger.debug("｜ ▽ パラメータ");
            logger.debug("｜ ｜ 返金方法区分    [" + pHnknhouKbn + "]");
            if (pKouzaJyouhou != null) {
                logger.debug("｜ ｜ ▽ 口座情報TBL");
                logger.debug("｜ ｜ ｜ " +"mosno [" + pKouzaJyouhou.getMosno() + "]");
                logger.debug("｜ ｜ ｜ " +"kzmeiginmkn [" + pKouzaJyouhou.getKzmeiginmkn() + "]");
                logger.debug("｜ ｜ ｜ " +"kzkykdoukbn [" + pKouzaJyouhou.getKzkykdoukbn() + "]");
                logger.debug("｜ ｜ ｜ " +"bankcd [" + pKouzaJyouhou.getBankcd() + "]");
                logger.debug("｜ ｜ ｜ " +"sitencd [" + pKouzaJyouhou.getSitencd() + "]");
                logger.debug("｜ ｜ ｜ " +"yokinkbn [" + pKouzaJyouhou.getYokinkbn() + "]");
                logger.debug("｜ ｜ ｜ " +"kouzano [" + pKouzaJyouhou.getKouzano() + "]");
                logger.debug("｜ ｜ ｜ " +"sinkeizkkbn [" + pKouzaJyouhou.getSinkeizkkbn() + "]");
                logger.debug("｜ ｜ ｜ " +"hbcmnt [" + pKouzaJyouhou.getHbcmnt() + "]");
                logger.debug("｜ ｜ ｜ " +"syuudaikocd [" + pKouzaJyouhou.getSyuudaikocd() + "]");
                logger.debug("｜ ｜ ｜ " +"gyoumuKousinsyaId [" + pKouzaJyouhou.getGyoumuKousinsyaId() + "]");
                logger.debug("｜ ｜ ｜ " +"gyoumuKousinTime [" + pKouzaJyouhou.getGyoumuKousinTime() + "]");
                logger.debug("｜ ｜ △");
            }
            else {
                logger.debug("｜ ｜ 口座情報TBL [null]");
            }
            logger.debug("｜ ｜ 返金額     [" + pHenkingaku + "]");
            logger.debug("｜ ｜ 通貨種類     [" + pTuukasyu + "]");
            logger.debug("｜  △");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        boolean syoriFlg = false;
        fstpRyosyuYmd = syoriCTL.getRyosyuymd();

        if (!BizUtil.isZero(pHenkingaku)) {

            String hhknNmkn = null;

            if (C_HnknhouKbn.TOUKYK_KOUZA.eq(pHnknhouKbn)
                || C_HnknhouKbn.DANTAIHNKN_KOUZA.eq(pHnknhouKbn)
                || C_HnknhouKbn.KOUZASITEI.eq(pHnknhouKbn)
                || C_HnknhouKbn.PHURIKZ.eq(pHnknhouKbn)) {

                if (pKouzaJyouhou != null) {

                    C_KzkykdouKbn kzkykdouKbn = pKouzaJyouhou.getKzkykdoukbn();

                    if (C_KzkykdouKbn.DOUITU.eq(kzkykdouKbn)) {

                        C_KykKbn kykKbn = mosKihon.getKykkbn();

                        if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {

                            hhknNmkn = mosKihon.getHhknnmkn();
                        }
                        else {

                            hhknNmkn = mosKihon.getKyknmkn();
                        }
                    }
                    else {

                        hhknNmkn = pKouzaJyouhou.getKzmeiginmkn();
                    }
                }
                else {

                    throw new CommonBizAppException("口座情報が取得できません。");
                }

                syoriFlg = true;
            }
            else if (C_HnknhouKbn.KARIUKE.eq(pHnknhouKbn)) {

            }
            else {

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 返金処理 終了");
                }

                HenkinOutBean henkinOutBean = SWAKInjector.getInstance(HenkinOutBean.class);
                henkinOutBean.setSkDenpyoDataList(skDenpyoDataList);
                henkinOutBean.setSkFBSoukinDataList(skFBSoukinDataList);
                henkinOutBean.setSkGaikaFBSoukinDataList(skGaikaFBSoukinDataList);

                return henkinOutBean;
            }

            GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);

            getRsgakukei.getHenkinsumiRsgaku(syoriCTL, pTuukasyu);

            BizCurrency nyuukinHnkn = getRsgakukei.getRsgakukei();

            if (BizUtil.isZero(nyuukinHnkn.subtract(pHenkingaku))) {

                syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);

                Integer zenHnknRenno = sinkeiyakuDomManager.getHenkinMaxZenhnknrenno(syoriCTL.getMosno()) + 1;

                List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.SUMI);

                if (nyuukinLst.size() > 0) {

                    for (HT_Nyuukin nyuukin : nyuukinLst) {

                        nyuukin.setZenhnknkbn(C_ZenhnknKbn.SUMI);
                        nyuukin.setZenhnknrenno(zenHnknRenno);
                        nyuukin.setGyoumuKousinsyaId(pMP.getKosID());
                        nyuukin.setGyoumuKousinTime(pMP.getKosTime());
                    }
                }

                List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByZenhnknrennos(0);

                for (HT_Henkin henkin : henkinLst) {

                    henkin.setZenhnknrenno(zenHnknRenno);
                    henkin.setGyoumuKousinsyaId(pMP.getKosID());
                    henkin.setGyoumuKousinTime(pMP.getKosTime());
                }
            }

            List<HT_Henkin> henkinList = syoriCTL.getHenkinsByHnkntuukasyuHnknsyoriymd(pTuukasyu, null);

            String henkinNkNo = uniqueKeyGenerator.generateUniqueKey();

            C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;
            String bankCd = "";
            String sitenCd = "";
            C_YokinKbn yokinKbn = C_YokinKbn.BLNK;
            String kouzaNo = "";
            String kzmeigiNmkn = "";

            if (syoriFlg) {

                bankCd = pKouzaJyouhou.getBankcd();
                sitenCd = pKouzaJyouhou.getSitencd();
                yokinKbn = pKouzaJyouhou.getYokinkbn();
                kouzaNo = pKouzaJyouhou.getKouzano();
                kzmeigiNmkn = hhknNmkn;

                if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

                    shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
                }
                else {

                    shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
                }
            }
            else {

                shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI;
            }

            BzShiharaiDenpyouDateShutoku bzShiharaiDenpyouDateShutoku =
                SWAKInjector.getInstance(BzShiharaiDenpyouDateShutoku.class);
            BizDate hnknYmd = bzShiharaiDenpyouDateShutoku.exec(pMP.getSysDate(), shrhousiteiKbn, pTuukasyu, bankCd);

            for (HT_Henkin henkin : henkinList) {

                if (syoriFlg) {

                    editDenpyouByHurikae(pMP,
                        henkin.getHnkngk(),
                        pTuukasyu,
                        henkin.getHnknriyuukbn(),
                        shrhousiteiKbn,
                        pKouzaJyouhou,
                        hhknNmkn,
                        hnknYmd);

                }
                else {

                    editDenpyouByKariuke(pMP, henkin.getHnkngk(), pTuukasyu, henkin.getHnknriyuukbn());
                }

                henkin.setHnkninputrenno(henkinNkNo);
                henkin.setHnknsyoriymd(pMP.getSysDate());
                henkin.setHenkinsyoritime(pMP.getKosTime());
                henkin.setHnknhoukbn(pHnknhouKbn);
                henkin.setHnknymd(hnknYmd);
                henkin.setBankcd(bankCd);
                henkin.setSitencd(sitenCd);
                henkin.setYokinkbn(yokinKbn);
                henkin.setKouzano(kouzaNo);
                henkin.setKzmeiginmkn(kzmeigiNmkn);
                henkin.setDenrenno(denpyouNo);
                henkin.setEdano(edaNo);
                henkin.setFbsoukindatasikibetukey(fBSkSikibetuKey);
                henkin.setGyoumuKousinsyaId(pMP.getKosID());
                henkin.setGyoumuKousinTime(pMP.getKosTime());

                BizPropertyInitializer.initialize(henkin);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 返金処理 終了");
        }

        HenkinOutBean henkinOutBean = SWAKInjector.getInstance(HenkinOutBean.class);

        henkinOutBean.setSkDenpyoDataList(skDenpyoDataList);
        henkinOutBean.setSkFBSoukinDataList(skFBSoukinDataList);
        henkinOutBean.setSkGaikaFBSoukinDataList(skGaikaFBSoukinDataList);

        return henkinOutBean;
    }

    public HenkinOutBean execPkakin(MosnaiCheckParam pMP, BizCurrency pHenkingaku, C_Tuukasyu pTuukasyu,
        C_HenkinriyuuKbn pHenkinriyuuKbn) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 返金処理 開始");
            logger.debug("｜ ▽ パラメータ");
            logger.debug("｜ ｜ 返金額     [" + pHenkingaku + "]");
            logger.debug("｜ ｜ 通貨種類     [" + pTuukasyu + "]");
            logger.debug("｜ ｜ 返金理由区分     [" + pHenkinriyuuKbn + "]");
            logger.debug("｜ △");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosno = syoriCTL.getMosno();
        C_SeirituKbn seirituKbn = syoriCTL.getSeiritukbn();
        int renNo = 1;
        BizCurrency hnknGk = BizCurrency.valueOf(0);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.BLNK;
        C_UmuKbn seiritugoHnknUmu = C_UmuKbn.NONE;
        fstpRyosyuYmd = syoriCTL.getRyosyuymd();

        if (C_HenkinriyuuKbn.MIAWASEENKI.eq(pHenkinriyuuKbn)
            || C_HenkinriyuuKbn.MOS_TORIKESI.eq(pHenkinriyuuKbn)
            || C_HenkinriyuuKbn.YUUKOUKKNKKA.eq(pHenkinriyuuKbn)) {

            GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
            getRsgakukei.getPkakinsumiRsgaku(syoriCTL);
            hnknGk = getRsgakukei.getRsgakukei();
            tuukaSyu = getRsgakukei.getTuukasyu();
        }
        else {

            hnknGk = pHenkingaku;
            tuukaSyu = pTuukasyu;
        }

        if (!BizUtil.isZero(hnknGk)) {

            editDenpyouByPkakin(pMP, hnknGk, tuukaSyu, pHenkinriyuuKbn);

            Integer maxRenno = sinkeiyakuDomManager.getHenkinMaxRennoByMosno(mosno);
            if (maxRenno != null) {

                renNo = maxRenno + 1;
            }
            else {

                renNo = 1;
            }

            if (C_HenkinriyuuKbn.HENKINKIBOU.eq(pHenkinriyuuKbn) && C_SeirituKbn.SEIRITU.eq(seirituKbn)) {

                seiritugoHnknUmu = C_UmuKbn.ARI;
            }
            else {

                seiritugoHnknUmu = C_UmuKbn.NONE;
            }

            HT_Henkin henkin = syoriCTL.createHenkin();

            henkin.setRenno(renNo);
            henkin.setHnkngk(hnknGk);
            henkin.setHnkntuukasyu(tuukaSyu);
            henkin.setPkakinsyoriymd(pMP.getSysDate());
            henkin.setHnknriyuukbn(pHenkinriyuuKbn);
            henkin.setSrgohnknumu(seiritugoHnknUmu);
            henkin.setPkakindenrenno(denpyouNo);
            henkin.setPkakindenedano(edaNo);
            henkin.setGyoumuKousinsyaId(pMP.getKosID());
            henkin.setGyoumuKousinTime(pMP.getKosTime());

            BizPropertyInitializer.initialize(henkin);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 返金処理 終了");
        }

        HenkinOutBean henkinOutBean = SWAKInjector.getInstance(HenkinOutBean.class);

        henkinOutBean.setSkDenpyoDataList(skDenpyoDataList);
        henkinOutBean.setSkFBSoukinDataList(skFBSoukinDataList);
        henkinOutBean.setSkGaikaFBSoukinDataList(skGaikaFBSoukinDataList);

        return henkinOutBean;
    }

    private void editDenpyouByHurikae(MosnaiCheckParam pMP, BizCurrency pHenkingaku, C_Tuukasyu pTuukasyu,
        C_HenkinriyuuKbn pHenkinriyuuKbn, C_ShrhousiteiKbn pShrhousiteiKbn,
        HT_KouzaJyouhou pKouzaJyouhou, String pHenkinsakiMeiginin, BizDate pHenkinYmd) {

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        String mosno = syoriCTL.getMosno();
        C_Segcd seg1cd = C_Segcd.BLNK;
        C_Segcd seg2cd = C_Segcd.BLNK;
        List<BzSiwakeMeisaiBean> siwakeMeisaiLst = new ArrayList<>();
        List<BzSiwakeMeisaiBean> fbSiwakeMeisaiLst = new ArrayList<>();
        C_Kanjyoukmkcd[] kanjyouKmkCds = {C_Kanjyoukmkcd.BLNK, C_Kanjyoukmkcd.BLNK};
        C_Kanjyoukmkcd[] fbKanjyouKmkCds = {C_Kanjyoukmkcd.BLNK, C_Kanjyoukmkcd.BLNK};
        C_Tuukasyu kykTuukaSyu = mosKihon.getKyktuukasyu();
        C_Tuukasyu fbSkKykTuukaSyu = C_Tuukasyu.BLNK;
        BizCurrency motoGk = BizCurrency.valueOf(0);
        BizNumber soukinKwsrate = BizNumber.valueOf(0);
        BizDate denYmd = pMP.getSysDate().addBusinessDays(1);
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmnetBean = null;
        HT_MosSyouhn mosSyouhn = null;

        List<HT_MosSyouhn> mosSyouhnList = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnList != null && mosSyouhnList.size() != 0) {

            mosSyouhn = mosSyouhnList.get(0);
        }

        if (mosSyouhn != null) {

            syouhinbetuSegmnetBean = bzSegmentCdSyutoku.exec(mosSyouhn.getSyouhncd(), mosKihon.getKyktuukasyu());
        }

        if (syouhinbetuSegmnetBean != null && C_ErrorKbn.OK.eq(syouhinbetuSegmnetBean.getErrorKbn())) {

            seg1cd = syouhinbetuSegmnetBean.getSegcd1();
            seg2cd = syouhinbetuSegmnetBean.getSegcd2();
        }
        else {

            seg1cd = C_Segcd.BLNK;
            seg2cd = C_Segcd.BLNK;
        }

        if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

            kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN;
            kanjyouKmkCds[1] = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SINKEIYAKUFB;
            fbKanjyouKmkCds[0] = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SINKEIYAKUFB;
            fbKanjyouKmkCds[1] = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN;
        }
        else {

            if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY;
                fbKanjyouKmkCds[0] = C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY;
                fbKanjyouKmkCds[1] = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN;
            }

            else if (C_Tuukasyu.USD.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_USD;
                fbKanjyouKmkCds[0] = C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_USD;
                fbKanjyouKmkCds[1] = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN;
            }

            else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD;
                fbKanjyouKmkCds[0] = C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD;
                fbKanjyouKmkCds[1] = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN;
            }
        }

        if (!pTuukasyu.eq(kykTuukaSyu)) {

            soukinKwsrate = getKawaseRateForCalc(kykTuukaSyu, pTuukasyu, mosKihon.getHrkkaisuu(),
                mosKihon.getZennoumousideumu(), mosKihon.getIkkatubaraikbn());

            KeisanGaikakanzan keisanGaikakanzan  = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            fbSkKykTuukaSyu = kykTuukaSyu;

            motoGk = keisanGaikakanzan.execDivide(kykTuukaSyu, pHenkingaku, soukinKwsrate, C_HasuusyoriKbn.SUTE);
        }

        editSiwakeMeisaiList(siwakeMeisaiLst,
            C_TaisyakuKbn.KARIKATA,
            kanjyouKmkCds[0],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pHenkingaku,
            seg1cd,
            seg2cd,
            pTuukasyu,
            kykTuukaSyu,
            soukinKwsrate);

        editSiwakeMeisaiList(siwakeMeisaiLst,
            C_TaisyakuKbn.KASIKATA,
            kanjyouKmkCds[1],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pHenkingaku,
            seg1cd,
            seg2cd,
            pTuukasyu,
            kykTuukaSyu,
            soukinKwsrate);

        editSiwakeMeisaiList(fbSiwakeMeisaiLst,
            C_TaisyakuKbn.KARIKATA,
            fbKanjyouKmkCds[0],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pHenkingaku,
            seg1cd,
            seg2cd,
            pTuukasyu,
            kykTuukaSyu,
            soukinKwsrate);

        editSiwakeMeisaiList(fbSiwakeMeisaiLst,
            C_TaisyakuKbn.KASIKATA,
            fbKanjyouKmkCds[1],
            YuyuBizConfig.getInstance().getSikinkoubaibukacd(),
            pHenkingaku,
            seg1cd,
            seg2cd,
            pTuukasyu,
            kykTuukaSyu,
            soukinKwsrate);

        denpyouNo = editDenpyou(pMP, pTuukasyu, pHenkinriyuuKbn, C_DensyoriKbn.FP_HNKN, denYmd, pShrhousiteiKbn, siwakeMeisaiLst);

        String fbSkDenpyouDataRenbon =
            editDenpyou(pMP, pTuukasyu, pHenkinriyuuKbn, C_DensyoriKbn.FP_HNKN, pHenkinYmd, pShrhousiteiKbn, fbSiwakeMeisaiLst);

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);

            bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(fbSkDenpyouDataRenbon);
            bzFbSoukinDataSksBean.setEdaNo(edaNo);
            bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
            bzFbSoukinDataSksBean.setSyoriCd(kinou.getSyoricd());
            bzFbSoukinDataSksBean.setSyoriSosikiCd(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
            bzFbSoukinDataSksBean.setSyoriYmd(pMP.getSysDate());
            bzFbSoukinDataSksBean.setDenYmd(pHenkinYmd);
            bzFbSoukinDataSksBean.setSyoNo(mosno);
            bzFbSoukinDataSksBean.setShrHouSiteiKbn(pShrhousiteiKbn);
            bzFbSoukinDataSksBean.setBankCd(pKouzaJyouhou.getBankcd());
            bzFbSoukinDataSksBean.setSitenCd(pKouzaJyouhou.getSitencd());
            bzFbSoukinDataSksBean.setYokinKbn(pKouzaJyouhou.getYokinkbn());
            bzFbSoukinDataSksBean.setKouzaNo(pKouzaJyouhou.getKouzano());
            bzFbSoukinDataSksBean.setKzMeigiNmKn(pHenkinsakiMeiginin);
            bzFbSoukinDataSksBean.setSouKingk(pHenkingaku);
            bzFbSoukinDataSksBean.setKykTuukasyu(kykTuukaSyu);
            bzFbSoukinDataSksBean.setGaikaTaikagk(motoGk);
            bzFbSoukinDataSksBean.setSoukinKwsRate(soukinKwsrate);
            bzFbSoukinDataSksBean.setKinouId(pMP.getKinouID());
            bzFbSoukinDataSksBean.setUserId(pMP.getKosID());
            bzFbSoukinDataSksBean.setDengyoumuCd(denGyoumuCd);

            BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
            HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

            fBSkSikibetuKey = skFBSoukinData.getFbsoukindatasikibetukey();

            skFBSoukinDataList.add(skFBSoukinData);
        }
        else {

            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(
                pKouzaJyouhou.getBankcd(), pKouzaJyouhou.getSitencd(), null);

            if (C_BankmasterUmuKbn.NONE.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {

                throw new CommonBizAppException("銀行情報が取得できません。");
            }

            BzGkfbSoukinDataSksBean bzGkfbSoukinDataSksBean =  SWAKInjector.getInstance(BzGkfbSoukinDataSksBean.class);

            bzGkfbSoukinDataSksBean.setDenRenno(fbSkDenpyouDataRenbon);
            bzGkfbSoukinDataSksBean.setEdaNo(edaNo);
            bzGkfbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
            bzGkfbSoukinDataSksBean.setSyoriCd(kinou.getSyoricd());
            bzGkfbSoukinDataSksBean.setSyoriSosikiCd(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
            bzGkfbSoukinDataSksBean.setSyoriYmd(pMP.getSysDate());
            bzGkfbSoukinDataSksBean.setDenYmd(pHenkinYmd);
            bzGkfbSoukinDataSksBean.setSyono(mosno);
            bzGkfbSoukinDataSksBean.setShrHouSiteiKbn(pShrhousiteiKbn);
            bzGkfbSoukinDataSksBean.setBankCd(pKouzaJyouhou.getBankcd());
            bzGkfbSoukinDataSksBean.setBankNmEj(bzGetBankDataBean.getBankNmEj());
            bzGkfbSoukinDataSksBean.setSitenCd(pKouzaJyouhou.getSitencd());
            bzGkfbSoukinDataSksBean.setSitenNmEj(bzGetBankDataBean.getSitenNmEj());
            bzGkfbSoukinDataSksBean.setKouzaNo(pKouzaJyouhou.getKouzano());
            bzGkfbSoukinDataSksBean.setKzMeigiNmEi(pHenkinsakiMeiginin);
            bzGkfbSoukinDataSksBean.setShrTuukaSyu(pTuukasyu);
            bzGkfbSoukinDataSksBean.setGaikaShrgk(pHenkingaku);
            bzGkfbSoukinDataSksBean.setKykTuukaSyu(fbSkKykTuukaSyu);
            bzGkfbSoukinDataSksBean.setCrossRateShrgk(motoGk);
            bzGkfbSoukinDataSksBean.setSoukinKwsRate(soukinKwsrate);
            bzGkfbSoukinDataSksBean.setKinouId(pMP.getKinouID());
            bzGkfbSoukinDataSksBean.setUserId(pMP.getKosID());
            bzGkfbSoukinDataSksBean.setDengyoumuCd(denGyoumuCd);

            BzGkfbSoukinDataSks bzGkfbSoukinDataSks = SWAKInjector.getInstance(BzGkfbSoukinDataSks.class);
            HT_SkGaikaFBSoukinData skGaikaFBSoukinData = bzGkfbSoukinDataSks.execSk(bzGkfbSoukinDataSksBean);

            fBSkSikibetuKey = skGaikaFBSoukinData.getFbsoukindatasikibetukey();

            skGaikaFBSoukinDataList.add(skGaikaFBSoukinData);
        }
    }

    private void editDenpyouByKariuke(MosnaiCheckParam pMP, BizCurrency pHenkingaku,
        C_Tuukasyu pTuukasyu, C_HenkinriyuuKbn pHenkinriyuuKbn) {

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        String mosno = syoriCTL.getMosno();
        int handKarikanjoNo = (int)SaibanBiz.getHandKarikanjoNo();
        C_Segcd seg1cd = C_Segcd.BLNK;
        C_Segcd seg2cd = C_Segcd.BLNK;
        List<BzSiwakeMeisaiBean> siwakeMeisaiLst = new ArrayList<>();
        C_Kanjyoukmkcd[] kanjyouKmkCds = {C_Kanjyoukmkcd.BLNK, C_Kanjyoukmkcd.BLNK};
        BizDate denYmd = pMP.getSysDate().addBusinessDays(1);
        C_Tuukasyu kykTuukaSyu = mosKihon.getKyktuukasyu();
        BizNumber motoGkKwsrate = BizNumber.valueOf(0);
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmnetBean = null;
        HT_MosSyouhn mosSyouhn = null;

        List<HT_MosSyouhn> mosSyouhnList = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnList != null && mosSyouhnList.size() != 0) {

            mosSyouhn = mosSyouhnList.get(0);

        }

        if (mosSyouhn != null) {

            syouhinbetuSegmnetBean = bzSegmentCdSyutoku.exec(mosSyouhn.getSyouhncd(), mosKihon.getKyktuukasyu());
        }

        if (syouhinbetuSegmnetBean != null && C_ErrorKbn.OK.eq(syouhinbetuSegmnetBean.getErrorKbn())) {

            seg1cd = syouhinbetuSegmnetBean.getSegcd1();
            seg2cd = syouhinbetuSegmnetBean.getSegcd2();
        }
        else {

            seg1cd = C_Segcd.BLNK;
            seg2cd = C_Segcd.BLNK;
        }

        if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

            kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN;
            kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETUP;
        }
        else {

            if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_JPY;
            }
            else if (C_Tuukasyu.USD.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_USD;
            }
            else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_AUD;
            }
        }

        if (!pTuukasyu.eq(kykTuukaSyu)) {

            motoGkKwsrate = getKawaseRateForCalc(kykTuukaSyu, pTuukasyu, mosKihon.getHrkkaisuu(),
                mosKihon.getZennoumousideumu(), mosKihon.getIkkatubaraikbn());
        }

        editSiwakeMeisaiList(siwakeMeisaiLst,
            C_TaisyakuKbn.KARIKATA,
            kanjyouKmkCds[0],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pHenkingaku,
            seg1cd,
            seg2cd,
            pTuukasyu,
            kykTuukaSyu,
            motoGkKwsrate);

        editSiwakeMeisaiList(siwakeMeisaiLst,
            C_TaisyakuKbn.KASIKATA,
            kanjyouKmkCds[1],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pHenkingaku,
            seg1cd,
            seg2cd,
            pTuukasyu,
            kykTuukaSyu,
            motoGkKwsrate);

        denpyouNo = editDenpyou(pMP, pTuukasyu, pHenkinriyuuKbn, C_DensyoriKbn.FP_HNKN, denYmd, C_ShrhousiteiKbn.BLNK, siwakeMeisaiLst);

        printHandKariKanjyou(denpyouNo,
            edaNo,
            mosno,
            pHenkingaku,
            pTuukasyu,
            mosKihon.getKyktuukasyu(),
            kanjyouKmkCds[1],
            handKarikanjoNo,
            pMP.getKinouID(),
            baseUserInfo.getUserNm(),
            pMP.getCategoryID(),
            pMP.getSysDate(),
            denYmd,
            syoriCTL.getSkeijimukbn());
    }

    private void printHandKariKanjyou(String pDenpyouNo, int pEdano, String pMosno,
        BizCurrency pDengk, C_Tuukasyu pTuukasyu, C_Tuukasyu pKyktuukasyu,  C_Kanjyoukmkcd pKanjyouKmkCd,
        int pHandKarikanjoNo, String pKinouNm, String pSousasyaNm,
        String pCategoryID, BizDate pSystemYmd, BizDate pDenYmd, C_SkeijimuKbn pSkeijimuKbn) {

        String systemYmd = DateFormatUtil.dateKANJI(pSystemYmd);
        String denpyoDate = DateFormatUtil.dateKANJI(pDenYmd);
        String kanjyouKmkNm = pKanjyouKmkCd.getContent();
        String denKwsrateTkyYmd = "";

        if (!C_Tuukasyu.JPY.eq(pTuukasyu)) {

            denKwsrateTkyYmd = DateFormatUtil.dateKANJI(fstpRyosyuYmd);
        }

        String dengkHrktuuka = ViewReport.editCommaTuuka(pDengk, BizUtil.ZERO_FILL);
        String dengkYenkansan = "";

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            dengkYenkansan = dengkHrktuuka;
        }
        else {
            if (BizDateUtil.compareYmd(fstpRyosyuYmd, pSystemYmd) == BizDateUtil.COMPARE_LESSER) {

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                C_ErrorKbn kekkaKbn = getKawaseRate.exec(fstpRyosyuYmd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    pTuukasyu, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                if (!C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                    BizNumber kawaseRate  = getKawaseRate.getKawaserate();

                    denKwsrateTkyYmd = DateFormatUtil.dateKANJI(getKawaseRate.getKwsrateKjYmd());

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                    BizCurrency kansanGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pDengk, kawaseRate, C_HasuusyoriKbn.SUTE);

                    dengkYenkansan = ViewReport.editCommaTuuka(kansanGk, BizUtil.ZERO_FILL);

                }
            }
        }

        SkHandkarikanjyouBean skHandkarikanjyouBean = SWAKInjector.getInstance(SkHandkarikanjyouBean.class);

        skHandkarikanjyouBean.setIrMosno(pMosno);
        skHandkarikanjyouBean.setIrTyouhyousakuseiymd(systemYmd);
        skHandkarikanjyouBean.setIrDenrenno(pDenpyouNo);
        skHandkarikanjyouBean.setIrEdano(pEdano);
        skHandkarikanjyouBean.setIrDenkihyouymd(systemYmd);
        skHandkarikanjyouBean.setIrDenymd(denpyoDate);
        skHandkarikanjyouBean.setIrTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skHandkarikanjyouBean.setIrKanjyoukmknm(kanjyouKmkNm);
        skHandkarikanjyouBean.setIrDengkhrktuuka(dengkHrktuuka);
        skHandkarikanjyouBean.setIrDengkyenkansan(dengkYenkansan);
        skHandkarikanjyouBean.setIrDenkwsratetekiymd(denKwsrateTkyYmd);
        skHandkarikanjyouBean.setIrHndkarikanjyono(pHandKarikanjoNo);
        skHandkarikanjyouBean.setIrKinounm("返金入力");
        skHandkarikanjyouBean.setIrSousasyanm(pSousasyaNm);

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.BLNK;

        ReportServicesBean reportServicesBean;

        if (!C_Tuukasyu.JPY.eq(pKyktuukasyu)) {

            syoruiCd = C_SyoruiCdKbn.SK_HANDKARIKANJYOU;
            skHandkarikanjyouBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HANDKARIKANJYOU);
            reportServicesBean = null;
        }
        else {

            syoruiCd = C_SyoruiCdKbn.SK_HANDKARIKANJYOU_YENDT;
            skHandkarikanjyouBean.setIrSyoruicd(C_SyoruiCdKbn.SK_HANDKARIKANJYOU_YENDT);
            reportServicesBean = null;
        }

        reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            pCategoryID,
            pKinouNm,
            syoruiCd);

        reportServicesBean.setKensakuKeys(pSkeijimuKbn.getValue(), pMosno);
        reportServicesBean.addParamObjects(skHandkarikanjyouBean);
        createReport.execNoCommit(reportServicesBean);

    }

    private void editDenpyouByPkakin(MosnaiCheckParam pMP, BizCurrency pHenkingaku,
        C_Tuukasyu pTuukasyu, C_HenkinriyuuKbn pHenkinRiyuuKbn) {

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_DensyoriKbn denSyoriKbn = C_DensyoriKbn.BLNK;
        BizCurrency nyuukinnGK = BizCurrency.valueOf(0);
        C_Segcd seg1cd = C_Segcd.BLNK;
        C_Segcd seg2cd = C_Segcd.BLNK;
        List<BzSiwakeMeisaiBean> siwakeMeisaiLst = new ArrayList<>();
        C_Kanjyoukmkcd[] kanjyouKmkCds = {C_Kanjyoukmkcd.BLNK, C_Kanjyoukmkcd.BLNK};
        BizDate denYmd = pMP.getSysDate().addBusinessDays(1);
        C_Tuukasyu kykTuukaSyu = mosKihon.getKyktuukasyu();
        BizNumber motoGkKwsrate = BizNumber.valueOf(0);
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmnetBean = null;
        HT_MosSyouhn mosSyouhn = null;

        if (C_HenkinriyuuKbn.HENKINKIBOU.eq(pHenkinRiyuuKbn)) {

            GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
            getRsgakukei.getPkakinsumiRsgaku(syoriCTL, pTuukasyu);

            denSyoriKbn = C_DensyoriKbn.FP_HNKNKB;
            nyuukinnGK = getRsgakukei.getRsgakukei();
        }
        else {

            denSyoriKbn = C_DensyoriKbn.FP_KKN;
            nyuukinnGK = pHenkingaku;
        }

        List<HT_MosSyouhn> mosSyouhnList = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnList != null && mosSyouhnList.size() != 0) {

            mosSyouhn = mosSyouhnList.get(0);
        }

        if (mosSyouhn != null) {

            syouhinbetuSegmnetBean = bzSegmentCdSyutoku.exec(mosSyouhn.getSyouhncd(), mosKihon.getKyktuukasyu());
        }

        if (syouhinbetuSegmnetBean != null && C_ErrorKbn.OK.eq(syouhinbetuSegmnetBean.getErrorKbn())) {

            seg1cd = syouhinbetuSegmnetBean.getSegcd1();
            seg2cd = syouhinbetuSegmnetBean.getSegcd2();
        }
        else {

            seg1cd = C_Segcd.BLNK;
            seg2cd = C_Segcd.BLNK;
        }

        if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

            kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI;
            kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN;
        }
        else {


            if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY;
            }
            else if (C_Tuukasyu.USD.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD;
            }
            else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {

                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD;
            }
        }

        if (!pTuukasyu.eq(kykTuukaSyu)) {

            motoGkKwsrate = getKawaseRateForCalc(kykTuukaSyu, pTuukasyu, mosKihon.getHrkkaisuu(),
                mosKihon.getZennoumousideumu(), mosKihon.getIkkatubaraikbn());
        }

        if (C_HenkinriyuuKbn.HENKINKIBOU.eq(pHenkinRiyuuKbn)) {

            BizCurrency henkinSagaku = nyuukinnGK.subtract(pHenkingaku);

            editSiwakeMeisaiList(siwakeMeisaiLst,
                C_TaisyakuKbn.KARIKATA,
                kanjyouKmkCds[0],
                YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
                nyuukinnGK,
                seg1cd,
                seg2cd,
                pTuukasyu,
                kykTuukaSyu,
                motoGkKwsrate);

            editSiwakeMeisaiList(siwakeMeisaiLst,
                C_TaisyakuKbn.KASIKATA,
                kanjyouKmkCds[1],
                YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
                pHenkingaku,
                seg1cd,
                seg2cd,
                pTuukasyu,
                kykTuukaSyu,
                motoGkKwsrate);

            if (!BizUtil.isZero(henkinSagaku)) {

                editSiwakeMeisaiList(siwakeMeisaiLst,
                    C_TaisyakuKbn.KASIKATA,
                    kanjyouKmkCds[0],
                    YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
                    henkinSagaku,
                    seg1cd,
                    seg2cd,
                    pTuukasyu,
                    kykTuukaSyu,
                    motoGkKwsrate);
            }
        }
        else {

            editSiwakeMeisaiList(siwakeMeisaiLst,
                C_TaisyakuKbn.KARIKATA,
                kanjyouKmkCds[0],
                YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
                nyuukinnGK,
                seg1cd,
                seg2cd,
                pTuukasyu,
                kykTuukaSyu,
                motoGkKwsrate);

            editSiwakeMeisaiList(siwakeMeisaiLst,
                C_TaisyakuKbn.KASIKATA,
                kanjyouKmkCds[1],
                YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
                pHenkingaku,
                seg1cd,
                seg2cd,
                pTuukasyu,
                kykTuukaSyu,
                motoGkKwsrate);
        }

        denpyouNo = editDenpyou(pMP, pTuukasyu, pHenkinRiyuuKbn, denSyoriKbn, denYmd, C_ShrhousiteiKbn.BLNK, siwakeMeisaiLst);
    }

    private void editSiwakeMeisaiList(List<BzSiwakeMeisaiBean> pSiwakeMeisaiLst,
        C_TaisyakuKbn pTaisyakuKbn, C_Kanjyoukmkcd pKanjyouKmkCd, String pSuitouBumonCd,
        BizCurrency pDengk, C_Segcd pSeg1cd, C_Segcd pSeg2cd, C_Tuukasyu pTuukasyu,
        C_Tuukasyu pKykTuukaSyu, BizNumber pKykTuukaGkKwsrate) {

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
        BizCurrency dengkGaika = BizCurrency.valueOf(0);
        BizCurrency dengkYen = BizCurrency.valueOf(0);
        BizCurrency kykTuukaGk = null;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            dengkYen = pDengk;
        }
        else {

            dengkGaika = pDengk;
        }

        if (!pTuukasyu.eq(pKykTuukaSyu)) {

            KeisanGaikakanzan keisanGaikakanzan  = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            kykTuukaGk = keisanGaikakanzan.execDivide(pKykTuukaSyu, pDengk, pKykTuukaGkKwsrate, C_HasuusyoriKbn.SUTE);
        }
        else {

            kykTuukaGk = pDengk;
        }

        bzSiwakeMeisaiBean.setIbTaisyakukbn(pTaisyakuKbn);
        bzSiwakeMeisaiBean.setIbKanjyoukmkcd(pKanjyouKmkCd);
        bzSiwakeMeisaiBean.setIbSuitoubumoncd(pSuitouBumonCd);
        bzSiwakeMeisaiBean.setIbDengaikagk(dengkGaika);
        bzSiwakeMeisaiBean.setIbDenyenkagk(dengkYen);
        bzSiwakeMeisaiBean.setIbSeg1cd(pSeg1cd);
        bzSiwakeMeisaiBean.setIbSeg2cd(pSeg2cd);
        bzSiwakeMeisaiBean.setIbDenkarikanjyono("");
        bzSiwakeMeisaiBean.setIbKeiyakutuukagk(kykTuukaGk);

        pSiwakeMeisaiLst.add(bzSiwakeMeisaiBean);

    }

    private String editDenpyou(MosnaiCheckParam pMP, C_Tuukasyu pTuukasyu, C_HenkinriyuuKbn pHenkinRiyuuKbn,
        C_DensyoriKbn pDensyoriKbn, BizDate pDenYmd, C_ShrhousiteiKbn pShrhousiteiKbn, List<BzSiwakeMeisaiBean> pSiwakeMeisaiLst) {

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        String mosno = syoriCTL.getMosno();
        BizDate sysSyoriYmd = pMP.getSysDate();
        String syouhnCd = null;
        Integer syouhnSdno = null;
        String ryourituSdno = null;
        boolean kakorateSiteiFlg = false;
        BizDate kakorateSiteiYmd = null;
        String aatsukaishaSoshikiCd = null;
        String aatkisyaDaibosyuuCd = null;
        String aatkisyaBosyuuCd = null;

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnLst != null && mosSyouhnLst.size() != 0) {

            syouhnCd = mosSyouhnLst.get(0).getSyouhncd();
            syouhnSdno = mosSyouhnLst.get(0).getSyouhnsdno();
            ryourituSdno = mosSyouhnLst.get(0).getRyouritusdno();
        }

        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);

        if (mosDairiten != null) {

            aatsukaishaSoshikiCd = mosDairiten.getDrtenkanrisosikicd();
            aatkisyaDaibosyuuCd = mosDairiten.getDaibosyuucd();
            aatkisyaBosyuuCd = mosDairiten.getBosyuucd();
        }

        BizDate ryosyuYmd = fstpRyosyuYmd;

        if (BizDateUtil.compareYmd(ryosyuYmd, sysSyoriYmd) == BizDateUtil.COMPARE_LESSER) {

            kakorateSiteiFlg = true;
            kakorateSiteiYmd = ryosyuYmd;
        }

        BzSinkeiyakuDenpyouDataTourokuBean bzSinkeiyakuDenpyouDataTourokuBean = SWAKInjector.getInstance(
            BzSinkeiyakuDenpyouDataTourokuBean.class);

        bzSinkeiyakuDenpyouDataTourokuBean.setIbMosno(mosno);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbHuridenatesakicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbTantocd(C_TantouCdKbn.DAIRITENJIMUKANRI);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbDenymd(pDenYmd);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbTuukasyu(pTuukasyu);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbSyoriymd(sysSyoriYmd);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbSyoricd(kinou.getSyoricd());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbSyorisosikicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbDensyorikbn(pDensyoriKbn);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbAatsukaishasuitososhikicd(
            YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbKykymd(mosKihon.getKykymd());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbBosyuuym(mosKihon.getBosyuuym());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbAatsukaishasoshikicd(aatsukaishaSoshikiCd);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbAatkisyadaibosyuucd(aatkisyaDaibosyuuCd);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbSyusyouhncd(syouhnCd);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbSdpdkbn(mosKihon.getSdpdkbn());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbHrkkaisuu(mosKihon.getHrkkaisuu());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbHrkkeiro(mosKihon.getHrkkeiro());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbSknnkaisiymd(mosKihon.getSknnkaisiymd());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbMosymd(mosKihon.getMosymd());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbHnknriyuukbn(pHenkinRiyuuKbn);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbFstpryosyuymd(ryosyuYmd);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbAatkisyabosyuucd(aatkisyaBosyuuCd);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbRyouritusdno(ryourituSdno);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(pMP.getKosID());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(kakorateSiteiFlg);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(kakorateSiteiYmd);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbKyktuukasyu(mosKihon.getKyktuukasyu());
        bzSinkeiyakuDenpyouDataTourokuBean.setIbShrhousiteiKbn(pShrhousiteiKbn);
        bzSinkeiyakuDenpyouDataTourokuBean.setIbSyouhnsdno(syouhnSdno);
        bzSinkeiyakuDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(pSiwakeMeisaiLst);

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        List<HT_SkDenpyoData> skDenpyoDataLst = bzDenpyouDataSks.execSk(bzSinkeiyakuDenpyouDataTourokuBean);
        edaNo = 2;
        denGyoumuCd = skDenpyoDataLst.get(0).getDengyoumucd();
        skDenpyoDataList.addAll(skDenpyoDataLst);

        return skDenpyoDataLst.get(0).getDenrenno();
    }

    private BizNumber getKawaseRateForCalc(C_Tuukasyu pKykTuukaSyu, C_Tuukasyu pHrkTuukaSyu, C_Hrkkaisuu pHrkKaisuu,
        C_UmuKbn pZennoumousideumu, C_IkkatubaraiKbn pIkkatubaraikbn) {

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        C_ErrorKbn kekkaKbn = getKawaseRate.execFstPNyuukin(fstpRyosyuYmd, pKykTuukaSyu, pHrkTuukaSyu,
            C_YouhiKbn.HUYOU, pHrkKaisuu, C_SysKbn.SKEI, pZennoumousideumu, pIkkatubaraikbn);

        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
            throw new CommonBizAppException("為替レートが取得できません。");
        }

        return getKawaseRate.getKawaserate();
    }
}