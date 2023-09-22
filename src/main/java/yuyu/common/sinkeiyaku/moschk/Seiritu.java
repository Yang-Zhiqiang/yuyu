package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSinkeiyakuDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.sinkeiyaku.skcommon.SetMossykykyoteiymd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_JiketteiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 申込内容チェック 成立処理
 */
public class Seiritu {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou Kinou;

    private List<HT_SkDenpyoData> skDenpyoDataList = new ArrayList<HT_SkDenpyoData>();

    private String firstKaripDenRenNo = "";

    private String dai1kaipDenRenNo = "";

    public Seiritu() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 成立処理 開始");
        }

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCtl.getMosKihon();
        C_SknnkaisikitkhukaKbn sknnKaisiKitkHukaKbn = mosKihon.getSknnkaisikitkhukakbn();
        C_FstphrkkeiroKbn fstPhrkKeiroKbn = mosKihon.getFstphrkkeirokbn();
        C_UmuKbn nyknnrkUmu = syoriCtl.getNyknnrkumu();

        if (C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisiKitkHukaKbn) ||
            (!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisiKitkHukaKbn) &&
                (C_UmuKbn.ARI.eq(nyknnrkUmu) ||
                    C_FstphrkkeiroKbn.CREDIT.eq(fstPhrkKeiroKbn)))) {

            if (C_FstphrkkeiroKbn.CREDIT.eq(fstPhrkKeiroKbn)) {
                boolean flgNyuKin = false;

                if (!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisiKitkHukaKbn)) {
                    flgNyuKin = true;
                }

                if (flgNyuKin) {

                    BizCurrency rsgaku = mosKihon.getFstphrkgk().multiply(mosKihon.getSkjpjyuutoukaisuu());

                    execByHurikae(syoriCtl, pMp.getKosID(), pMp.getSysDate(), rsgaku);

                    pMp.getListSkDenpyoData().addAll(skDenpyoDataList);

                    List<HT_Nyuukin> nyuukinLst = syoriCtl.getNyuukins();
                    int renNo;
                    if (nyuukinLst.size() > 0) {
                        renNo = nyuukinLst.size() + 1;
                    }
                    else {
                        renNo = 1;
                    }

                    HT_Nyuukin nyuukinIns = syoriCtl.createNyuukin();

                    nyuukinIns.setRenno(renNo);
                    nyuukinIns.setTyakkinymd(syoriCtl.getAuthorikakymd());
                    nyuukinIns.setNyksyoriymd(pMp.getSysDate());
                    nyuukinIns.setNyuukinsyoritime(pMp.getKosTime());
                    nyuukinIns.setNyknsyubetu(C_NyknsyubetuKbn.CREDIT);
                    nyuukinIns.setRsgaku(rsgaku);
                    nyuukinIns.setRstuukasyu(C_Tuukasyu.JPY);
                    nyuukinIns.setRyosyuymd(syoriCtl.getAuthorikakymd());
                    nyuukinIns.setGyoumuKousinsyaId(pMp.getKosID());
                    nyuukinIns.setGyoumuKousinTime(pMp.getKosTime());
                    nyuukinIns.setDenrenno(firstKaripDenRenNo);
                    nyuukinIns.setDenrenno2(dai1kaipDenRenNo);
                    nyuukinIns.setEdano(2);

                    BizPropertyInitializer.initialize(nyuukinIns);

                    syoriCtl.setUriagesousinkbn(C_UriagesousinKbn.SOUSINMATI);
                    syoriCtl.setNyknnrkumu(C_UmuKbn.ARI);
                }
            }
            syoriCtl.setSeiritukbn(C_SeirituKbn.SEIRITU);
            syoriCtl.setSrsyoriymd(pMp.getSysDate());
            syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SYOUMETU);
            SetMossykykyoteiymd setMossykykyoteiymd = SWAKInjector.getInstance(SetMossykykyoteiymd.class);

            HT_MosnoKanri mosnoKanri = setMossykykyoteiymd.setMosskykyoteiymdSeiritu(syoriCtl, pMp.getSysDate(), pMp.getKosID());

            if (mosnoKanri != null) {
                pMp.setMosnoKanri(mosnoKanri);
            }
            else {
                throw new CommonBizAppException("申込番号=" + syoriCtl.getMosno());
            }
            pMp.getListKekkaGmnMsg().add(MessageUtil.getMessage(MessageId.IHC0001));

            String daiMosNo = syoriCtl.getDaimosno();

            if (!BizUtil.isBlank(daiMosNo)) {

                HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu(daiMosNo);
                if (jigyouIkkatu == null) {
                    throw new CommonBizAppException("代表申込番号=" + daiMosNo);
                }

                if(C_JiketteiKbn.KETTEI_SUMI.eq(jigyouIkkatu.getJiketteikbn())) {
                    List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe(
                        daiMosNo, syoriCtl.getMosno());
                    if (syoriCTLLst == null || syoriCTLLst.size() == 0) {

                        jigyouIkkatu.setJgyiktsrkbn(C_SeirituKbn.SEIRITU);
                        jigyouIkkatu.setJgyiktsrymd(pMp.getSysDate());
                        jigyouIkkatu.setGyoumuKousinsyaId(pMp.getKosID());
                        jigyouIkkatu.setGyoumuKousinTime(pMp.getKosTime());

                        sinkeiyakuDomManager.update(jigyouIkkatu);

                        pMp.getListKekkaGmnMsg().add(MessageUtil.getMessage(MessageId.IHC0003));
                    }
                }
            }
        }
        else {
            if (C_FstphrkkeiroKbn.KOUHURI.eq(mosKihon.getFstphrkkeirokbn()) &&
                C_SeirituKbn.NONE.eq(syoriCtl.getSeiritukbn())) {

                syoriCtl.setSeiritukbn(C_SeirituKbn.ITIPMATI);
                pMp.getListKekkaGmnMsg().add(MessageUtil.getMessage(MessageId.IHC0002));
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("　　MP.処理コントロールTBL.成立区分 = "
                + syoriCtl.getSeiritukbn().getContent());
            logger.debug("　　MP.処理コントロールTBL.ＭＦ連動済フラグ = "
                + syoriCtl.getMfrenflg());
            logger.debug("　　MP.処理コントロールTBL.ＭＦ連動日 = "
                + syoriCtl.getMfrenymd());
            logger.debug("　　MP.処理コントロールTBL.成立日 = "
                + syoriCtl.getSrsyoriymd());
            logger.debug("　　MP.結果画面ＭＳＧ = " + pMp.getListKekkaGmnMsg().toString());
            logger.debug("△ 成立処理 終了");
        }
    }

    @Transactional
    private void execByHurikae(HT_SyoriCTL pSyoriCtl, String pUserId, BizDate pSysDate, BizCurrency pRsgaku) {

        HT_SyoriCTL syoriCtl = pSyoriCtl;
        HT_MosKihon mosKihon = syoriCtl.getMosKihon();
        List<HT_MosSyouhn> mosSyouhnList = null;
        C_Segcd segcd1 = C_Segcd.BLNK;
        C_Segcd segcd2 = C_Segcd.BLNK;
        List<BzSiwakeMeisaiBean> siwakeMeisaiLst1 = new ArrayList<BzSiwakeMeisaiBean>();
        List<BzSiwakeMeisaiBean> siwakeMeisaiLst2 = new ArrayList<BzSiwakeMeisaiBean>();
        C_Kanjyoukmkcd[] kanjyouKmkCds1 = {C_Kanjyoukmkcd.BLNK, C_Kanjyoukmkcd.BLNK};
        C_Kanjyoukmkcd[] kanjyouKmkCds2 = {C_Kanjyoukmkcd.BLNK, C_Kanjyoukmkcd.BLNK};
        BizNumber keiyaKutuuKagkKsnKawaserate = BizNumber.valueOf(0);
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmnetBean = null;
        HT_MosSyouhn mosSyouhn = null;

        mosSyouhnList = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnList != null && mosSyouhnList.size() != 0) {
            mosSyouhn = mosSyouhnList.get(0);
        }

        if (mosSyouhn != null) {

            syouhinbetuSegmnetBean = bzSegmentCdSyutoku.exec(mosSyouhn.getSyouhncd(), mosKihon.getKyktuukasyu());
        }

        if (syouhinbetuSegmnetBean != null && C_ErrorKbn.OK.eq(syouhinbetuSegmnetBean.getErrorKbn())) {

            segcd1 = syouhinbetuSegmnetBean.getSegcd1();
            segcd2 = syouhinbetuSegmnetBean.getSegcd2();
        }
        else {

            segcd1 = C_Segcd.BLNK;
            segcd2 = C_Segcd.BLNK;
        }

        kanjyouKmkCds1[0] = C_Kanjyoukmkcd.SONOTAMISYUUKIN;
        kanjyouKmkCds1[1] = C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY;

        kanjyouKmkCds2[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY;
        kanjyouKmkCds2[1] = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY;

        BizCurrency keiyaKutuuKagk;

        if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn resultKbn = getKawaseRate.execFstPNyuukin(syoriCtl.getRyosyuymd(), mosKihon.getKyktuukasyu(),
                C_Tuukasyu.JPY, C_YouhiKbn.HUYOU, mosKihon.getHrkkaisuu(), C_SysKbn.SKEI, mosKihon.getZennoumousideumu(),
                mosKihon.getIkkatubaraikbn());

            if (C_ErrorKbn.ERROR.eq(resultKbn)) {

                throw new BizLogicException(MessageId.EHA1045, "為替レートが取得できないため処理できません。");
            }

            keiyaKutuuKagkKsnKawaserate = getKawaseRate.getKawaserate();
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            keiyaKutuuKagk = keisanGaikakanzan.execDivide(mosKihon.getKyktuukasyu(), pRsgaku,
                keiyaKutuuKagkKsnKawaserate, C_HasuusyoriKbn.SUTE);
        }
        else {

            keiyaKutuuKagk = pRsgaku;
        }

        editSiwakeMeisaiList(siwakeMeisaiLst1,
            C_TaisyakuKbn.KARIKATA,
            kanjyouKmkCds1[0],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pRsgaku,
            segcd1,
            segcd2,
            keiyaKutuuKagk);

        editSiwakeMeisaiList(siwakeMeisaiLst1,
            C_TaisyakuKbn.KASIKATA,
            kanjyouKmkCds1[1],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pRsgaku,
            segcd1,
            segcd2,
            keiyaKutuuKagk);

        editSiwakeMeisaiList(siwakeMeisaiLst2,
            C_TaisyakuKbn.KARIKATA,
            kanjyouKmkCds2[0],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pRsgaku,
            segcd1,
            segcd2,
            keiyaKutuuKagk);

        editSiwakeMeisaiList(siwakeMeisaiLst2,
            C_TaisyakuKbn.KASIKATA,
            kanjyouKmkCds2[1],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            pRsgaku,
            segcd1,
            segcd2,
            keiyaKutuuKagk);

        firstKaripDenRenNo = editDenpyou(syoriCtl,
            siwakeMeisaiLst1,
            mosKihon.getKyktuukasyu(),
            pSysDate,
            C_Tuukasyu.JPY,
            pSysDate,
            pUserId);

        dai1kaipDenRenNo = editDenpyou(syoriCtl,
            siwakeMeisaiLst2,
            mosKihon.getKyktuukasyu(),
            pSysDate.addBusinessDays(1),
            C_Tuukasyu.JPY,
            pSysDate,
            pUserId);
    }

    private void editSiwakeMeisaiList(List<BzSiwakeMeisaiBean> pSiwakeMeisaiLst, C_TaisyakuKbn pKasikata,
        C_Kanjyoukmkcd pKanjyouKmkCd, String pSuitoubumoncd, BizCurrency pDengk, C_Segcd segcd1, C_Segcd segcd2,
        BizCurrency pKeiyaKutuuKagk) {

        BzSiwakeMeisaiBean siwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);

        siwakeMeisaiBean.setIbTaisyakukbn(pKasikata);
        siwakeMeisaiBean.setIbKanjyoukmkcd(pKanjyouKmkCd);
        siwakeMeisaiBean.setIbSuitoubumoncd(pSuitoubumoncd);
        siwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean.setIbDenyenkagk(pDengk);
        siwakeMeisaiBean.setIbSeg1cd(segcd1);
        siwakeMeisaiBean.setIbSeg2cd(segcd2);
        siwakeMeisaiBean.setIbDenkarikanjyono("");
        siwakeMeisaiBean.setIbKeiyakutuukagk(pKeiyaKutuuKagk);
        pSiwakeMeisaiLst.add(siwakeMeisaiBean);

    }

    private String editDenpyou(HT_SyoriCTL pSyoriCtl, List<BzSiwakeMeisaiBean> pSiwakeMeisaiLst, C_Tuukasyu pKyktuuKasyu,
        BizDate pDenYmd, C_Tuukasyu pRsytuukasyu, BizDate pSystemSrsyoriYmd, String pUserId) {

        HT_SyoriCTL syoriCtl = pSyoriCtl;
        HT_MosKihon mosKihon = syoriCtl.getMosKihon();
        List<HT_MosSyouhn> mosSyouhnList = null;
        HT_MosDairiten mosDairiten = null;
        String mosNo = syoriCtl.getMosno();
        BizDate fstPryosyuYmd= null;
        boolean kakoRateShiteiFlg = false;
        BizDate kakoRateShiteiYmd = null;
        BizDate denYmd = pDenYmd;
        C_Tuukasyu rsytuukasyu = pRsytuukasyu;
        String syusyouHncd = "";
        String ryourituSdNo = "";
        Integer syouhnSdno = 0;
        String aAtsukaishaSoshikiCd = "";
        String aAtkisyaDaiBosyuuCd = "";
        String aAtkisyaBosyuuCd = "";

        mosSyouhnList = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnList != null && mosSyouhnList.size() != 0) {

            syusyouHncd = mosSyouhnList.get(0).getSyouhncd();
            ryourituSdNo = mosSyouhnList.get(0).getRyouritusdno();
            syouhnSdno = mosSyouhnList.get(0).getSyouhnsdno();
        }

        mosDairiten = syoriCtl.getMosDairitenByRenno(1);

        if (mosDairiten != null) {

            aAtsukaishaSoshikiCd = mosDairiten.getDrtenkanrisosikicd();
            aAtkisyaDaiBosyuuCd = mosDairiten.getDaibosyuucd();
            aAtkisyaBosyuuCd = mosDairiten.getBosyuucd();
        }

        fstPryosyuYmd = syoriCtl.getRyosyuymd();
        if (fstPryosyuYmd.compareTo(pSystemSrsyoriYmd) < 0) {

            kakoRateShiteiFlg = true;
            kakoRateShiteiYmd = fstPryosyuYmd;
        }

        BzSinkeiyakuDenpyouDataTourokuBean sDataTourokuBean = SWAKInjector.getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);

        sDataTourokuBean.setIbMosno(mosNo);
        sDataTourokuBean.setIbHuridenatesakicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd());
        sDataTourokuBean.setIbTantocd(C_TantouCdKbn.DAIRITENJIMUKANRI);
        sDataTourokuBean.setIbDenymd(denYmd);
        sDataTourokuBean.setIbTuukasyu(rsytuukasyu);
        sDataTourokuBean.setIbSyoriymd(pSystemSrsyoriYmd);
        sDataTourokuBean.setIbSyoricd(Kinou.getSyoricd());
        sDataTourokuBean.setIbSyorisosikicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
        sDataTourokuBean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        sDataTourokuBean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        sDataTourokuBean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        sDataTourokuBean.setIbDensyorikbn(C_DensyoriKbn.FP_CREDITNYKN);
        sDataTourokuBean.setIbAatsukaishasuitososhikicd(
            YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
        sDataTourokuBean.setIbKykymd(mosKihon.getKykymd());
        sDataTourokuBean.setIbBosyuuym(mosKihon.getBosyuuym());
        sDataTourokuBean.setIbAatsukaishasoshikicd(aAtsukaishaSoshikiCd);
        sDataTourokuBean.setIbAatkisyadaibosyuucd(aAtkisyaDaiBosyuuCd);
        sDataTourokuBean.setIbSyusyouhncd(syusyouHncd);
        sDataTourokuBean.setIbSdpdkbn(mosKihon.getSdpdkbn());
        sDataTourokuBean.setIbHrkkaisuu(mosKihon.getHrkkaisuu());
        sDataTourokuBean.setIbHrkkeiro(mosKihon.getHrkkeiro());
        sDataTourokuBean.setIbSknnkaisiymd(mosKihon.getSknnkaisiymd());
        sDataTourokuBean.setIbMosymd(mosKihon.getMosymd());
        sDataTourokuBean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        sDataTourokuBean.setIbFstpryosyuymd(fstPryosyuYmd);
        sDataTourokuBean.setIbAatkisyabosyuucd(aAtkisyaBosyuuCd);
        sDataTourokuBean.setIbRyouritusdno(ryourituSdNo);
        sDataTourokuBean.setIbGyoumuKousinsyaId(pUserId);
        sDataTourokuBean.setIbKakokawaserateshiteiflg(kakoRateShiteiFlg);
        sDataTourokuBean.setIbKakokawaserateshiteiymd(kakoRateShiteiYmd);
        sDataTourokuBean.setIbKyktuukasyu(mosKihon.getKyktuukasyu());
        sDataTourokuBean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        sDataTourokuBean.setIbSyouhnsdno(syouhnSdno);
        sDataTourokuBean.setBzSiwakeMeisaiBeanList(pSiwakeMeisaiLst);

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        List<HT_SkDenpyoData> skDenpyoDataLst = bzDenpyouDataSks.execSk(sDataTourokuBean);
        skDenpyoDataList.addAll(skDenpyoDataLst);

        return skDenpyoDataLst.get(0).getDenrenno();

    }

}