package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.base.format.BizDateFormatUtil;
import yuyu.common.base.format.BizDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzChkAgYuukou;
import yuyu.common.biz.bzdairiten.BzChkBsYuukou;
import yuyu.common.biz.bzdairiten.BzChkBsYuukouHengaku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfoJimusyo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoKinyuuKikan;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBstrkno;
import yuyu.common.biz.bzdairiten.BzGetBsInfoKouin;
import yuyu.common.biz.bzdairiten.BzGetBuntanInfo;
import yuyu.common.biz.bzdairiten.BzGetDairitenItakuSyouhn;
import yuyu.common.biz.bzdairiten.BzGetDairitenItakuSyouhnBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcd;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhou;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhouBean;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_BsKahiKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HanbaiJyoukyouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkhjnKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 申込内容チェック 申込代理店TBLチェック
 */
public class CheckTblMosDairiten {

    private final String seirekiUp2 = "20";

    private final String drtplannmkbnXX = "XX";

    private final String drtplannmkbnCascadeSisuu = "01";

    private final String drtplannmkbnCascadeTeiritu = "02";

    private final String drtplannmkbnTnsmG2Sisuu_20 = "01";

    private final String drtplannmkbnTnsmG2Teiritu_20 = "02";

    private final String drtplannmkbnTnsmG2Teiki_20 = "03";

    private final String drtplannmkbnFrhntF2usddt = "01";

    private final String drtplannmkbnFrhntF2endt = "02";

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public CheckTblMosDairiten() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 申込代理店テーブルチェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        C_TkhjnKbn tkhjnKbn = syoriCTL.getTkhjnkbn();
        BizDate kktYmd = syoriCTL.getKktymd();
        BizDate ryoSyuYmd = syoriCTL.getRyosyuymd();
        C_MosUketukeKbn mosUketukeKbn = syoriCTL.getMosuketukekbn();
        ConvertChannelcd convertChannelcd = SWAKInjector.getInstance(ConvertChannelcd.class);

        if (!C_SeihowebsousasyaKbn.DIRTNBSYNN.eq(pMP.getSekmossakuseiSousasyaKbn())) {

            syoriCTL.setSkeijimukbn(C_SkeijimuKbn.BLNK);
            if (C_BosyuusysctrlKbn.SMBC.eq(pMP.getBosyuuSysCtrlKbn())) {
                syoriCTL.setSkeijimukbn(C_SkeijimuKbn.SMBC);
            }
            else if (C_BosyuusysctrlKbn.TIGIN.eq(pMP.getBosyuuSysCtrlKbn())
                || C_BosyuusysctrlKbn.SINKIN.eq(pMP.getBosyuuSysCtrlKbn())
                || C_BosyuusysctrlKbn.GAISANTIGIN.eq(pMP.getBosyuuSysCtrlKbn())
                || C_BosyuusysctrlKbn.GAISANSINKIN.eq(pMP.getBosyuuSysCtrlKbn())) {
                syoriCTL.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
            }
            else if (C_BosyuusysctrlKbn.SMTB.eq(pMP.getBosyuuSysCtrlKbn())) {
                syoriCTL.setSkeijimukbn(C_SkeijimuKbn.SMTB);
            }
            else if (C_BosyuusysctrlKbn.SHOPMDHN.eq(pMP.getBosyuuSysCtrlKbn())) {
                syoriCTL.setSkeijimukbn(C_SkeijimuKbn.SHOP);
            }
            else if (C_BosyuusysctrlKbn.MIZUHO.eq(pMP.getBosyuuSysCtrlKbn())) {
                syoriCTL.setSkeijimukbn(C_SkeijimuKbn.MIZUHO);
            }
            else if (C_BosyuusysctrlKbn.YUUSEIGINKOU.eq(pMP.getBosyuuSysCtrlKbn())) {
                syoriCTL.setSkeijimukbn(C_SkeijimuKbn.YUUTYO);
            }
            else if (C_BosyuusysctrlKbn.YUUSEIKAISYA.eq(pMP.getBosyuuSysCtrlKbn())) {
                syoriCTL.setSkeijimukbn(C_SkeijimuKbn.NIHONYUUBIN);
            }
            else if (C_BosyuusysctrlKbn.YUUSEIKANPO.eq(pMP.getBosyuuSysCtrlKbn())) {
                syoriCTL.setSkeijimukbn(C_SkeijimuKbn.KANPOSEIMEI);
            }

            pMP.setKiteiCheckChannelCd(convertChannelcd.exec(null, pMP.getSekmossakuseiOyaAgCd()));

            SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

            C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
                pMP,
                pMP.getSyuSyouhnZokusei().getSyouhncd(),
                "",
                "",
                syoriCTL.getSkeijimukbn(),
                C_BoskyuusiRiyuuKbn.OTHER);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

                    logger.debug("△ 申込代理店テーブルチェック 終了");

                    return;
                }
            }

            logger.debug("△ 申込代理店テーブルチェック 終了");

            return;
        }

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
        boolean nyuuryokuUmuB = false;

        if (mosDairitenLst == null || mosDairitenLst.size() == 0) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                C_SpKeisanKahiKbn.SPKEISANKA,
                C_HubisyubetusyousaiKbn.NONE,
                new StringBuffer(MessageId.EHC0009).append(" ").append(
                    MessageUtil.getMessage(MessageId.EHC0009)).toString(), pMP,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);

            pMP.setKiteiCheckChannelCd(convertChannelcd.exec(null, ""));

            return;
        }
        else if(mosDairitenLst.size() == 2) {
            nyuuryokuUmuB = true;
        }


        C_SonotaTokuninKbn sonotaTokuninKbn = C_SonotaTokuninKbn.NONE;
        if(C_SysKbn.SKEI.eq(pMP.getSysKbn())){
            HT_Tokunin tokunin = pMP.getDataSyoriControl().getTokunin();
            if (tokunin != null) {
                sonotaTokuninKbn = tokunin.getSonotatknkbn();
            }
        }


        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BizNumber bunWari = BizNumber.ZERO;
        BizNumber bunWariTotal = BizNumber.ZERO;
        int mosDairitenCount = 0;
        BizDate mosYmd = mosKihon.getMosymd();
        String uktKId = mosKihon.getUktkid();
        C_Hrkkaisuu hrkKaisuu = mosKihon.getHrkkaisuu();

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (syuMosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }

        BM_SyouhnZokusei syouhnZokusei = pMP.getSyuSyouhnZokusei();

        C_UmuKbn hengakuUmu = syouhnZokusei.getHengakuumu();
        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = syouhnZokusei.getDrtsyouhinsikibetukbn();

        BzGetBsInfoKouin bzGetBsInfoKouin = SWAKInjector.getInstance(BzGetBsInfoKouin.class);
        BzGetBsInfoBstrkno bzGetBsInfoBstrkno = SWAKInjector.getInstance(BzGetBsInfoBstrkno.class);
        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
        BzChkBsYuukou bzChkBsYuukou = SWAKInjector.getInstance(BzChkBsYuukou.class);
        BzChkBsYuukouHengaku bzChkBsYuukouHengaku = SWAKInjector.getInstance(BzChkBsYuukouHengaku.class);
        BzChkAgYuukou bzChkAgYuukou = SWAKInjector.getInstance(BzChkAgYuukou.class);
        BzGetAgInfoKinyuuKikan bzGetAgInfoKinyuuKikan = SWAKInjector.getInstance(BzGetAgInfoKinyuuKikan.class);
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        BzGetAgInfoJimusyo bzGetAgInfoJimusyo = SWAKInjector.getInstance(BzGetAgInfoJimusyo.class);
        BzGetBuntanInfo bzGetBuntanInfo = SWAKInjector.getInstance(BzGetBuntanInfo.class);
        BzGetDairitenItakuSyouhn bzGetDairitenItakuSyouhn = SWAKInjector.getInstance(BzGetDairitenItakuSyouhn.class);
        GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);
        String oyaAgCdA = "";
        String tratkiAgCdA = "";
        String bosyuuCdA = "";
        String oyaAgCdB = "";
        String bosyuuCdB = "";

        for (HT_MosDairiten mosDairiten : mosDairitenLst) {
            String kinyuuCd = mosDairiten.getKinyuucd();
            String kinyuuSitenCd = mosDairiten.getKinyuusitencd();
            String tratkikouinnCd = mosDairiten.getTratkikouinncd();
            String inputbosyuuCd = mosDairiten.getInputbosyuucd();

            String bosyuutrkNo = mosDairiten.getBosyuutrkno();
            String jimusyoCd = mosDairiten.getJimusyocd();
            String cifCd = mosDairiten.getCifcd();

            String bosyuuCd = "";
            String tratkiAgCd = "";
            String oyaAgCd = "";
            String kariTratkiAgCd = "";
            String kariOyaAgCd = "";
            C_Channelcd kariAatkiOyadrtenChannelcd = null;
            String bosyuuAgCd = "";
            String daiBosyuuCd = "";
            String drtenKanriSosikiCd = "";
            C_UmuKbn bosyuuInfoUmu = C_UmuKbn.NONE;
            C_UmuKbn drtenInfoUmu = C_UmuKbn.NONE;
            C_Channelcd aatkiOyadrtenChannelcd = null;

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfoKinyuuKikan.exec(kinyuuCd, kinyuuSitenCd);
            if (bzGetAgInfoBeanLst.size() == 0) {

            }
            else {
                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                    if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                        kariTratkiAgCd = bzGetAgInfoBean.getDrtenCd();
                        kariOyaAgCd = bzGetAgInfoBean.getOyadrtenCd();
                    }
                    else if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())
                        && mosDairitenCount == 0) {
                        kariAatkiOyadrtenChannelcd = bzGetAgInfoBean.getChannelCd();
                    }
                }
            }

            if (C_ErrorKbn.ERROR.eq(checkDirInfoPattern(kinyuuCd, kinyuuSitenCd, inputbosyuuCd,
                tratkikouinnCd, jimusyoCd, bosyuutrkNo, mosDairiten.getRenno()))) {

                setHubiMsg.exec(
                    C_KetsrhkosKbn.KETHORYU_HUBI,
                    C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    new StringBuffer(MessageId.EHC0171).append(" ").append(
                        MessageUtil.getMessage(MessageId.EHC0171)).toString(), pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);

                if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                    logger.debug("△ 申込代理店テーブルチェック 終了");
                    return;
                }
            }
            else {
                BzGetBsInfoBean bzGetBsInfoBean =  SWAKInjector.getInstance(BzGetBsInfoBean.class);

                if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                    if (!BizUtil.isBlank(tratkikouinnCd)) {

                        bzGetBsInfoBean = bzGetBsInfoKouin.exec(kinyuuCd, tratkikouinnCd);

                        if (bzGetBsInfoBean == null) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                new StringBuffer(MessageId.EHC0167).append(" ").append(
                                    MessageUtil.getMessage(MessageId.EHC0167, tratkikouinnCd)).toString(), pMP,
                                    C_TknKbn.NONE,
                                    C_MsgKbn.ERROR);
                        }
                        else {
                            bosyuuCd = bzGetBsInfoBean.getBosyuuCd();
                            bosyuuAgCd = bzGetBsInfoBean.getDairiten1Cd();
                            bosyuuInfoUmu = C_UmuKbn.ARI;
                            tratkikouinnCd = bzGetBsInfoBean.getKouinCd();
                        }
                    }
                }

                if (!BizUtil.isBlank(bosyuutrkNo)) {

                    bzGetBsInfoBean = bzGetBsInfoBstrkno.exec(bosyuutrkNo);

                    if (bzGetBsInfoBean == null) {
                        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                new StringBuffer(MessageId.EHC1012).append(" ").append(
                                    MessageUtil.getMessage(MessageId.EHC1012, bosyuutrkNo)).toString(), pMP,
                                    C_TknKbn.NONE,
                                    C_MsgKbn.ERROR);
                        }
                        else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                            setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1006,
                                mosDairiten.getRenno() == 1 ? "Ａ担当者コード" : "Ｂ担当者コード"),
                                C_SekmossakuseiErroutKbn.GAMEN, pMP);
                            logger.debug("△ 申込代理店テーブルチェック 終了");
                            return;
                        }
                    }
                    else {
                        bosyuuCd = bzGetBsInfoBean.getBosyuuCd();
                        bosyuuAgCd = bzGetBsInfoBean.getDairiten1Cd();
                        bosyuuInfoUmu = C_UmuKbn.ARI;
                    }
                }


                if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                    if (!BizUtil.isBlank(inputbosyuuCd)) {

                        bzGetBsInfoBean = bzGetBsInfo.exec(inputbosyuuCd.substring(0, 6));

                        if (bzGetBsInfoBean == null) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                new StringBuffer(MessageId.EHC0122).append(" ").append(
                                    MessageUtil.getMessage(MessageId.EHC0122, inputbosyuuCd)).toString(), pMP,
                                    C_TknKbn.NONE,
                                    C_MsgKbn.ERROR);
                        }
                        else {
                            bosyuuCd = bzGetBsInfoBean.getBosyuuCd();
                            bosyuuAgCd = bzGetBsInfoBean.getDairiten1Cd();
                            bosyuuInfoUmu = C_UmuKbn.ARI;
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(bosyuuInfoUmu) && !BizUtil.isBlank(bosyuuCd)) {
                    if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                        boolean bsYuukouChk = true;

                        if (mosYmd != null) {
                            bsYuukouChk = bzChkBsYuukou.exec(bosyuuCd, mosYmd);
                        }

                        if (bsYuukouChk && kktYmd != null) {
                            bsYuukouChk = bzChkBsYuukou.exec(bosyuuCd, kktYmd);
                        }

                        if (bsYuukouChk && ryoSyuYmd != null) {
                            bsYuukouChk = bzChkBsYuukou.exec(bosyuuCd, ryoSyuYmd);
                        }

                        if (!bsYuukouChk) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                new StringBuffer(MessageId.EHC0123).append(" ").append(
                                    MessageUtil.getMessage(MessageId.EHC0123, bosyuuCd)).toString(),
                                    pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
                        }

                    }
                    else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

                        C_UmuKbn seihoWebErrorUmu = C_UmuKbn.NONE;
                        String seihoWebErrorMsgUp = "";
                        String seihoWebErrorMsgDown = "";
                        C_SekmossakuseiErroutKbn seihoWebErrorShuturyokuKbn = C_SekmossakuseiErroutKbn.GAMEN;
                        C_BsKahiKbn bosyuuKahiKbn = bzGetBsInfoBean.getBosyuuKahiKbn();
                        BizDate bosyuuninTourokuYmd = bzGetBsInfoBean.getBosyuuninTourokuYmd();
                        BizDate bosyuuninGyouhaiYmd = null;
                        if (bzGetBsInfoBean.getBosyuuninGyouhaiYmd() == null) {
                            bosyuuninGyouhaiYmd =  BizDate.MAX_VALUE;
                        }
                        else {
                            bosyuuninGyouhaiYmd = bzGetBsInfoBean.getBosyuuninGyouhaiYmd();
                        }

                        if (bosyuuninTourokuYmd == null || C_BsKahiKbn.BOSYUUHUKA.eq(bosyuuKahiKbn)) {
                            seihoWebErrorUmu = C_UmuKbn.ARI;
                            seihoWebErrorMsgDown = MessageUtil.getMessage(MessageId.EGA1007,
                                mosDairiten.getRenno() == 1 ? "Ａ担当者" : "Ｂ担当者");
                        }

                        if (C_UmuKbn.NONE.eq(seihoWebErrorUmu) && bosyuuninTourokuYmd != null
                            && BizDateUtil.compareYmd(mosYmd, bosyuuninTourokuYmd) == BizDateUtil.COMPARE_LESSER) {
                            seihoWebErrorUmu = C_UmuKbn.ARI;
                            seihoWebErrorMsgDown = MessageUtil.getMessage(MessageId.EGA1008,
                                mosDairiten.getRenno() == 1 ? "Ａ担当者" : "Ｂ担当者", BizDateFormatUtil.toFormatedYmd(
                                    bosyuuninTourokuYmd, BizDateFormatter.seirekiKanjiYMDFormat));
                        }

                        if (C_UmuKbn.NONE.eq(seihoWebErrorUmu)
                            && (BizDateUtil.compareYmd(bosyuuninGyouhaiYmd, mosYmd) == BizDateUtil.COMPARE_LESSER
                            || BizDateUtil.compareYmd(bosyuuninGyouhaiYmd, mosYmd) == BizDateUtil.COMPARE_EQUAL)) {
                            seihoWebErrorUmu = C_UmuKbn.ARI;
                            seihoWebErrorMsgDown = MessageUtil.getMessage(MessageId.EGA1009,
                                mosDairiten.getRenno() == 1 ? "Ａ担当者" : "Ｂ担当者", BizDateFormatUtil.toFormatedYmd(
                                    bosyuuninGyouhaiYmd, BizDateFormatter.seirekiKanjiYMDFormat));
                        }

                        if (C_UmuKbn.ARI.eq(seihoWebErrorUmu)) {
                            setHubiMsg.exec(seihoWebErrorMsgUp, seihoWebErrorMsgDown, seihoWebErrorShuturyokuKbn, pMP);
                            logger.debug("△ 申込代理店テーブルチェック 終了");
                            return;
                        }
                    }

                    boolean bsHengakuYuukouChk = true;

                    if (C_UmuKbn.ARI.eq(hengakuUmu)) {
                        if (mosYmd != null) {
                            bsHengakuYuukouChk = bzChkBsYuukouHengaku.exec(bosyuuCd, mosYmd);
                        }

                        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                            if (bsHengakuYuukouChk && kktYmd != null) {
                                bsHengakuYuukouChk = bzChkBsYuukouHengaku.exec(bosyuuCd, kktYmd);
                            }
                        }

                        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                            if (bsHengakuYuukouChk && ryoSyuYmd != null) {
                                bsHengakuYuukouChk = bzChkBsYuukouHengaku.exec(bosyuuCd, ryoSyuYmd);
                            }
                        }

                        if (!bsHengakuYuukouChk) {
                            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                    C_SpKeisanKahiKbn.SPKEISANKA,
                                    C_HubisyubetusyousaiKbn.NONE,
                                    new StringBuffer(MessageId.EHC1013).append(" ").append(
                                        MessageUtil.getMessage(MessageId.EHC1013)).toString(),
                                        pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
                            }
                            else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1010),
                                    C_SekmossakuseiErroutKbn.GAMEN, pMP);
                                logger.debug("△ 申込代理店テーブルチェック 終了");
                                return;
                            }
                        }
                    }

                    List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(bosyuuAgCd);

                    if (bzGetAgInfoBeanList.size() == 0) {

                        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                new StringBuffer(MessageId.EHC0120).append(" ").append(
                                    MessageUtil.getMessage(MessageId.EHC0120, bosyuuAgCd)).toString(), pMP,
                                    C_TknKbn.NONE,
                                    C_MsgKbn.ERROR);
                        }
                        else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

                            setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1006,
                                mosDairiten.getRenno() == 1 ? "Ａ担当者組織コード" : "Ｂ担当者組織コード"),
                                C_SekmossakuseiErroutKbn.GAMEN, pMP);
                            logger.debug("△ 申込代理店テーブルチェック 終了");
                            return;
                        }
                    }
                    else {
                        for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {
                            if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                oyaAgCd = bzGetAgInfoBean.getOyadrtenCd();
                                tratkiAgCd = bzGetAgInfoBean.getDrtenCd();
                                daiBosyuuCd = bzGetAgInfoBean.getDaiBosyuuCd();
                                drtenKanriSosikiCd = bzGetAgInfoBean.getDrtKanrisosikiCd1();
                            }
                            else if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())
                                && mosDairitenCount == 0) {
                                aatkiOyadrtenChannelcd = bzGetAgInfoBean.getChannelCd();
                            }
                        }
                        drtenInfoUmu = C_UmuKbn.ARI;
                    }

                    if (!BizUtil.isBlank(kinyuuCd) && !BizUtil.isBlank(oyaAgCd)) {
                        bzGetAgInfoBeanList = bzGetAgInfoKinyuuKikan.exec(kinyuuCd, kinyuuSitenCd);

                        if (bzGetAgInfoBeanList.size() == 0) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                new StringBuffer(MessageId.EHC0119).append(" ").append(
                                    MessageUtil.getMessage(MessageId.EHC0119, kinyuuCd, kinyuuSitenCd)).toString(), pMP,
                                    C_TknKbn.NONE,
                                    C_MsgKbn.ERROR);

                            tratkiAgCd = "";
                            daiBosyuuCd = "";
                            drtenKanriSosikiCd = "";
                            drtenInfoUmu = C_UmuKbn.NONE;

                            if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                                logger.debug("△ 申込代理店テーブルチェック 終了");
                                return;
                            }
                        }
                        else {
                            String kinyuuSiteiOyaDrtenCd = "";

                            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {
                                if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                    kinyuuSiteiOyaDrtenCd = bzGetAgInfoBean.getOyadrtenCd();
                                    tratkiAgCd = bzGetAgInfoBean.getDrtenCd();
                                    daiBosyuuCd = bzGetAgInfoBean.getDaiBosyuuCd();
                                    drtenKanriSosikiCd = bzGetAgInfoBean.getDrtKanrisosikiCd1();
                                }
                                else if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())
                                    && mosDairitenCount == 0) {
                                    aatkiOyadrtenChannelcd = bzGetAgInfoBean.getChannelCd();
                                }
                            }

                            if (!oyaAgCd.equals(kinyuuSiteiOyaDrtenCd)) {

                                C_TknKbn tknKbn = C_TknKbn.NONE;

                                if (C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn)){
                                    tknKbn = C_TknKbn.KANOU;
                                    drtenInfoUmu = C_UmuKbn.NONE;
                                }
                                else {
                                    tknKbn = C_TknKbn.SUMI;
                                    drtenInfoUmu = C_UmuKbn.ARI;
                                }

                                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                    C_SpKeisanKahiKbn.SPKEISANKA,
                                    C_HubisyubetusyousaiKbn.NONE,
                                    new StringBuffer(MessageId.EHC1014).append(" ").append(
                                        MessageUtil.getMessage(MessageId.EHC1014, kinyuuCd, oyaAgCd))
                                        .toString(), pMP, tknKbn, C_MsgKbn.ERROR);

                                oyaAgCd = kinyuuSiteiOyaDrtenCd;

                                if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                                    logger.debug("△ 申込代理店テーブルチェック 終了");
                                    return;
                                }
                            } else {
                                drtenInfoUmu = C_UmuKbn.ARI;
                            }
                        }
                    }
                    else if (!BizUtil.isBlank(jimusyoCd) && !BizUtil.isBlank(oyaAgCd)) {
                        bzGetAgInfoBeanList = bzGetAgInfoJimusyo.exec(oyaAgCd, jimusyoCd);

                        if (bzGetAgInfoBeanList.size() == 0) {

                            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                    C_SpKeisanKahiKbn.SPKEISANKA,
                                    C_HubisyubetusyousaiKbn.NONE,
                                    new StringBuffer(MessageId.EHC1060).append(" ").append(
                                        MessageUtil.getMessage(MessageId.EHC1060, jimusyoCd)).toString(), pMP,
                                        C_TknKbn.NONE,
                                        C_MsgKbn.ERROR);

                                tratkiAgCd = "";
                                daiBosyuuCd = "";
                                drtenKanriSosikiCd = "";
                                drtenInfoUmu = C_UmuKbn.NONE;
                            }
                            else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

                                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1006,
                                    mosDairiten.getRenno() == 1 ? "Ａ担当者組織コード" : "Ｂ担当者組織コード"),
                                    C_SekmossakuseiErroutKbn.GAMEN, pMP);
                                logger.debug("△ 申込代理店テーブルチェック 終了");
                                return;
                            }
                        }
                        else {
                            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {
                                if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                    oyaAgCd = bzGetAgInfoBean.getOyadrtenCd();
                                    tratkiAgCd = bzGetAgInfoBean.getDrtenCd();
                                    daiBosyuuCd = bzGetAgInfoBean.getDaiBosyuuCd();
                                    drtenKanriSosikiCd = bzGetAgInfoBean.getDrtKanrisosikiCd1();
                                }
                                else if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())
                                    && mosDairitenCount == 0) {
                                    aatkiOyadrtenChannelcd = bzGetAgInfoBean.getChannelCd();
                                }
                            }
                            drtenInfoUmu = C_UmuKbn.ARI;
                        }
                    }

                    if (C_UmuKbn.ARI.eq(drtenInfoUmu)) {
                        boolean agYuukouChk = true;

                        if (!BizUtil.isBlank(oyaAgCd)) {
                            if (mosYmd != null) {
                                agYuukouChk = bzChkAgYuukou.exec(oyaAgCd, mosYmd);
                            }

                            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                                if (agYuukouChk && kktYmd != null) {
                                    agYuukouChk = bzChkAgYuukou.exec(oyaAgCd, kktYmd);
                                }
                            }

                            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                                if (agYuukouChk && ryoSyuYmd != null) {
                                    agYuukouChk = bzChkAgYuukou.exec(oyaAgCd, ryoSyuYmd);
                                }
                            }

                            if (!agYuukouChk) {
                                C_TknKbn tknKbn = C_TknKbn.NONE;

                                if (C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn)){
                                    tknKbn = C_TknKbn.KANOU;
                                }
                                else {
                                    tknKbn = C_TknKbn.SUMI;
                                }
                                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                    C_SpKeisanKahiKbn.SPKEISANKA,
                                    C_HubisyubetusyousaiKbn.NONE,
                                    new StringBuffer(MessageId.EHC0121).append(" ").append(
                                        MessageUtil.getMessage(MessageId.EHC0121, oyaAgCd)).toString(), pMP,
                                        tknKbn,
                                        C_MsgKbn.ERROR);

                                if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                                    logger.debug("△ 申込代理店テーブルチェック 終了");
                                    return;
                                }
                            }
                        }

                        boolean bosyuuAgChk = true;

                        if (!BizUtil.isBlank(tratkiAgCd)) {
                            if (mosYmd != null) {
                                bosyuuAgChk = bzChkAgYuukou.exec(tratkiAgCd, mosYmd);
                            }

                            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                                if (bosyuuAgChk && kktYmd != null) {
                                    bosyuuAgChk = bzChkAgYuukou.exec(tratkiAgCd, kktYmd);
                                }
                            }

                            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                                if (bosyuuAgChk && ryoSyuYmd != null) {
                                    bosyuuAgChk = bzChkAgYuukou.exec(tratkiAgCd, ryoSyuYmd);
                                }
                            }

                            if (!bosyuuAgChk) {
                                setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                                    new StringBuffer(MessageId.WHC0073).append(" ").append(
                                        MessageUtil.getMessage(MessageId.WHC0073, tratkiAgCd)).toString(),
                                        pMP, C_TknKbn.NONE, C_MsgKbn.WARNING);

                                if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                                    logger.debug("△ 申込代理店テーブルチェック 終了");
                                    return;
                                }
                            }
                        }


                        if (mosDairitenCount == 0) {
                            getSkChannelInfo.exec(aatkiOyadrtenChannelcd, oyaAgCd);

                            syoriCTL.setSkeijimukbn(getSkChannelInfo.getSkeiJimuKbn());

                            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                                if (!C_SkeijimuKbn.NIHONYUUBIN.eq(syoriCTL.getSkeijimukbn())) {
                                    mosKihon.setKoureitaioukbn(C_KoureisyaTaiouKbn.BLNK);
                                }
                            }
                        }



                        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                            if (mosDairitenCount == 0 && !BizUtil.isBlank(tratkiAgCd)) {
                                if (C_SkeijimuKbn.SMBC.eq(syoriCTL.getSkeijimukbn())) {
                                    if (BizUtil.isBlank(uktKId)) {
                                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                            new StringBuffer(MessageId.EHC0175).append(" ").append(
                                                MessageUtil.getMessage(MessageId.EHC0175)).toString(), pMP);
                                    }
                                    else {
                                        String uktKId6 = uktKId.substring(0, 6);
                                        String taikeiChkStr = seirekiUp2 + uktKId6;

                                        if (!BizDate.valueOf(taikeiChkStr).isRekijyou()) {
                                            setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                                                new StringBuffer(MessageId.WHC1005).append(" ").append(
                                                    MessageUtil.getMessage(MessageId.WHC1005)).toString(), pMP);
                                        }

                                        List<HT_MosKihon> mosKihonsList = sinkeiyakuDomManager.getMosKihonsByUktkidMosnoNe(uktKId, mosNo);

                                        if (mosKihonsList != null && mosKihonsList.size() > 0) {

                                            String mosno_dup = mosKihonsList.get(0).getMosno();
                                            int count = mosKihonsList.size() - 1;

                                            if (count == 0) {
                                                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                                    new StringBuffer(MessageId.EHA1066).append(" ").append(
                                                        MessageUtil.getMessage(MessageId.EHA1066, uktKId, mosno_dup)).toString(), pMP);
                                            }
                                            else {
                                                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,


                                                    new StringBuffer(MessageId.EHA1067).append(" ").append(
                                                        MessageUtil.getMessage(MessageId.EHA1067, uktKId, mosno_dup, String.valueOf(count))).toString(), pMP);
                                            }
                                        }
                                    }
                                }
                                else {
                                    if (!BizUtil.isBlank(uktKId)) {
                                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                            new StringBuffer(MessageId.EHC0176).append(" ").append(
                                                MessageUtil.getMessage(MessageId.EHC0176)).toString(), pMP);
                                    }
                                }
                            }
                        }


                        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                            if (mosDairitenCount == 0 && !BizUtil.isBlank(tratkiAgCd)) {

                                C_TknKbn tknKbn = C_TknKbn.NONE;

                                if (C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn)){
                                    tknKbn = C_TknKbn.KANOU;
                                }
                                else {
                                    tknKbn = C_TknKbn.SUMI;
                                }

                                GetDairitenKobetuJyouhou getDairitenKobetuJyouhou = SWAKInjector.getInstance(
                                    GetDairitenKobetuJyouhou.class);

                                GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean =
                                    getDairitenKobetuJyouhou.exec(oyaAgCd, mosUketukeKbn);

                                if (C_ErrorKbn.OK.eq(getDairitenKobetuJyouhouBean.getErrorKbn())
                                    && C_YouhiKbn.YOU.eq(getDairitenKobetuJyouhouBean.getCifCdCheckYouhi())) {
                                    if (BizUtil.isBlank(cifCd)) {
                                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                            new StringBuffer(MessageId.EBC0045).append(" ").append(
                                                MessageUtil.getMessage(MessageId.EBC0045, "ＣＩＦコード")).toString(),
                                                pMP, tknKbn, C_MsgKbn.ERROR);
                                    }
                                    else {
                                        if (cifCd.length() != getDairitenKobetuJyouhouBean.getCifCdSiteiKetasuu()) {
                                            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                                new StringBuffer(MessageId.EBC0046).append(" ").append(
                                                    MessageUtil.getMessage(MessageId.EBC0046, "ＣＩＦコード")).toString(),
                                                    pMP, tknKbn, C_MsgKbn.ERROR);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }


            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                if (mosDairiten.getBunwari() != null && mosDairiten.getBunwari().compareTo(BizNumber.ZERO) != 0) {
                    bunWari = mosDairiten.getBunwari();
                    bunWariTotal = bunWariTotal.add(bunWari);
                }
            }

            String bsyujOyadrtenCd = "";
            if (BizUtil.isBlank(mosDairiten.getBsyujoyadrtencd())) {
                bsyujOyadrtenCd = oyaAgCd;
            }
            else {
                bsyujOyadrtenCd = mosDairiten.getBsyujoyadrtencd();
            }

            mosDairiten.setBsyujoyadrtencd(bsyujOyadrtenCd);
            if (!BizUtil.isBlank(tratkiAgCd)){
                mosDairiten.setTratkiagcd(tratkiAgCd);
            }
            else {
                mosDairiten.setTratkiagcd(kariTratkiAgCd);
            }
            if (!BizUtil.isBlank(oyaAgCd)){
                mosDairiten.setOyadrtencd(oyaAgCd);
            }
            else {
                mosDairiten.setOyadrtencd(kariOyaAgCd);
            }

            mosDairiten.setBosyuucd(bosyuuCd);
            mosDairiten.setTratkikouinncd(tratkikouinnCd);
            mosDairiten.setDaibosyuucd(daiBosyuuCd);
            mosDairiten.setDrtenkanrisosikicd(drtenKanriSosikiCd);
            mosDairiten.setGyoumuKousinsyaId(pMP.getKosID());
            mosDairiten.setGyoumuKousinTime(pMP.getKosTime());

            if (mosDairitenCount == 0) {
                if (!BizUtil.isBlank(tratkiAgCd)){
                    tratkiAgCdA = tratkiAgCd;
                }
                else {
                    tratkiAgCdA = kariTratkiAgCd;
                }
                if (!BizUtil.isBlank(oyaAgCd)){
                    oyaAgCdA = oyaAgCd;
                }
                else {
                    oyaAgCdA = kariOyaAgCd;
                }

                bosyuuCdA = bosyuuCd;
            }
            else {
                if (!BizUtil.isBlank(oyaAgCd)){
                    oyaAgCdB = oyaAgCd;
                }
                else {
                    oyaAgCdB = kariOyaAgCd;
                }

                bosyuuCdB = bosyuuCd;
            }


            if (mosDairitenCount == 0) {
                C_Channelcd channelCd;

                if (aatkiOyadrtenChannelcd != null ) {
                    channelCd = aatkiOyadrtenChannelcd;
                }
                else {
                    channelCd = kariAatkiOyadrtenChannelcd;
                }

                pMP.setKiteiCheckChannelCd(convertChannelcd.exec(channelCd, mosDairiten.getOyadrtencd()));
            }

            mosDairitenCount++;
        }

        if (!BizUtil.isBlank(bosyuuCdA) && !BizUtil.isBlank(bosyuuCdB)) {
            if (bosyuuCdA.equals(bosyuuCdB)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    new StringBuffer(MessageId.EHC0170).append(" ").append(
                        MessageUtil.getMessage(MessageId.EHC0170, bosyuuCdA)).toString(), pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);

                if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                    logger.debug("△ 申込代理店テーブルチェック 終了");
                    return;
                }
            }
        }


        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

            if (!BizUtil.isBlank(oyaAgCdA) &&
                (bunWariTotal.compareTo(BizNumber.valueOf(100)) == 0 ||
                bunWariTotal.compareTo(BizNumber.ZERO) == 0)) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst= bzGetAgInfo.exec(oyaAgCdA);
                C_KydBosyuuDairitenHyouji kydBosyuuDairitenHyouji = C_KydBosyuuDairitenHyouji.BLNK;
                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                    if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                        kydBosyuuDairitenHyouji = bzGetAgInfoBean.getKydBosyuuDairitenHyouji();
                    }
                }

                if (C_KydBosyuuDairitenHyouji.BLNK.eq(kydBosyuuDairitenHyouji)) {

                    if (nyuuryokuUmuB) {
                        setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                            new StringBuffer(MessageId.WHC1007).append(" ").append(
                                MessageUtil.getMessage(MessageId.WHC1007)).toString(), pMP);
                    }
                }

                else {

                    List<BT_BuntanInfo> buntanInfoLst = bzGetBuntanInfo.execBuntanaiteSiteinasi(tratkiAgCdA, pMP.getSysDate()
                        .getBizDateYM(), drtSyouhinSikibetuKbn, hrkKaisuu, C_DiritenplannmKbn.BLNK);

                    List<BT_BuntanInfo> buntanInfoLstu = bzGetBuntanInfo.execBuntanaiteSiteinasi(oyaAgCdA, pMP.getSysDate()
                        .getBizDateYM(), drtSyouhinSikibetuKbn, hrkKaisuu, C_DiritenplannmKbn.BLNK);

                    buntanInfoLst.addAll(buntanInfoLstu);

                    if (!nyuuryokuUmuB) {

                        if (buntanInfoLst.size() > 0) {

                            setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                                new StringBuffer(MessageId.WHC1007).append(" ")
                                .append(MessageUtil.getMessage(MessageId.WHC1007)).toString(), pMP);
                        }

                    }
                    else {

                        if (buntanInfoLst.size() == 0) {

                            setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                                new StringBuffer(MessageId.WHC1007).append(" ").append(
                                    MessageUtil.getMessage(MessageId.WHC1007)).toString(), pMP);
                        }
                        else {
                            for (int i = 0; i < buntanInfoLst.size(); i++) {

                                if (oyaAgCdB.equals(buntanInfoLst.get(i).getTesuuryoubuntandrtencd())) {
                                    break;
                                }

                                if (buntanInfoLst.size() - 1 == i) {

                                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                                        new StringBuffer(MessageId.WHC1008).append(" ").append(
                                            MessageUtil.getMessage(MessageId.WHC1008)).toString(), pMP);
                                }
                            }
                        }
                    }
                }
            }

            if (bunWariTotal.compareTo(BizNumber.valueOf(100)) != 0 && bunWariTotal.compareTo(BizNumber.valueOf(0)) != 0) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    new StringBuffer(MessageId.EHC0048).append(" ").append(
                        MessageUtil.getMessage(MessageId.EHC0048)).toString(), pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }


        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

            //            if (C_TkhjnKbn.BLNK.eq(tkhjnKbn)) {
            //                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
            //                    new StringBuffer(MessageId.EHC0177).append(" ").append(
            //                        MessageUtil.getMessage(MessageId.EHC0177)).toString(), pMP);
            //            }
            if (C_TkhjnKbn.ARI.eq(tkhjnKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                    new StringBuffer(MessageId.WHC1011).append(" ").append(
                        MessageUtil.getMessage(MessageId.WHC1011)).toString(), pMP);
            }
        }


        if(C_SysKbn.SKEI.eq(pMP.getSysKbn())){
            if (!BizUtil.isBlank(oyaAgCdA)) {

                String drtplannmkbn = syouhnZokusei.getDrtplannmkbn();

                if (drtplannmkbnXX.equals(drtplannmkbn)) {

                    int syohinHanteiKbn = SyouhinUtil.hantei(syouhnZokusei.getSyouhncd());

                    if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn) {

                        if (C_TumitatekinHaibunWariKbn.WARIAI100.eq(mosKihon.getTeirituhaibunwarikbn()) &&
                            C_TumitatekinHaibunWariKbn.WARIAI000.eq(mosKihon.getSisuuhaibunwarikbn())) {

                            drtplannmkbn = drtplannmkbnCascadeTeiritu;
                        }
                        else {

                            drtplannmkbn = drtplannmkbnCascadeSisuu;
                        }
                    }
                    else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {

                        if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {

                            drtplannmkbn = drtplannmkbnTnsmG2Teiki_20;
                        }
                        else {

                            if (C_TumitatekinHaibunWariKbn.WARIAI100.eq(mosKihon.getTeirituhaibunwarikbn()) &&
                                C_TumitatekinHaibunWariKbn.WARIAI000.eq(mosKihon.getSisuuhaibunwarikbn())) {

                                drtplannmkbn = drtplannmkbnTnsmG2Teiritu_20;
                            }
                            else {

                                drtplannmkbn = drtplannmkbnTnsmG2Sisuu_20;
                            }
                        }
                    }
                    else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

                        if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                            drtplannmkbn = drtplannmkbnFrhntF2endt;
                        }
                        else {

                            drtplannmkbn = drtplannmkbnFrhntF2usddt;
                        }

                    }
                }

                BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhnBean = bzGetDairitenItakuSyouhn.exec(oyaAgCdA,
                    drtSyouhinSikibetuKbn, syouhnZokusei.getDrthrkhouhoukbn(), drtplannmkbn, mosYmd);

                if (!C_HanbaiJyoukyouKbn.HANBAITYUU.eq(bzGetDairitenItakuSyouhnBean.getHanbaiJyoukyouKbn())) {

                    C_TknKbn tknKbn = C_TknKbn.NONE;

                    if (C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn)) {
                        tknKbn = C_TknKbn.KANOU;
                    }
                    else {
                        tknKbn = C_TknKbn.SUMI;
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        new StringBuffer(MessageId.EHC1119).append(" ").append(
                            MessageUtil.getMessage(MessageId.EHC1119, syouhnZokusei.getSyouhnnm(), oyaAgCdA)).toString(),
                            pMP,
                            tknKbn,
                            C_MsgKbn.ERROR
                        );
                }
            }
        }

        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            pMP,
            syouhnZokusei.getSyouhncd(),
            "",
            "",
            syoriCTL.getSkeijimukbn(),
            C_BoskyuusiRiyuuKbn.OTHER);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

                logger.debug("△ 申込代理店テーブルチェック 終了");

                return;
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 申込代理店テーブルチェック 終了");
        }
    }

    public C_ErrorKbn checkDirInfoPattern(String pKinyuuCd,
        String pKinyuuSitenCd, String pInputbosyuuCd,
        String pTratkikouinnCd, String pJimusyoCd,
        String pBosyuutrkNo,int pRenNo) {

        if (!BizUtil.isBlank(pKinyuuCd)) {
            if (!BizUtil.isBlank(pKinyuuSitenCd)) {
                if (BizUtil.isBlank(pJimusyoCd)) {
                    if (!BizUtil.isBlank(pBosyuutrkNo)) {
                        if (BizUtil.isBlank(pInputbosyuuCd) && BizUtil.isBlank(pTratkikouinnCd)) {
                            return C_ErrorKbn.OK;
                        }

                        return C_ErrorKbn.ERROR;
                    }
                    else if (!BizUtil.isBlank(pInputbosyuuCd)) {
                        if (BizUtil.isBlank(pBosyuutrkNo) && BizUtil.isBlank(pTratkikouinnCd)) {
                            return C_ErrorKbn.OK;
                        }

                        return C_ErrorKbn.ERROR;
                    }
                    else if (!BizUtil.isBlank(pTratkikouinnCd)) {
                        if (BizUtil.isBlank(pBosyuutrkNo) && BizUtil.isBlank(pInputbosyuuCd)) {
                            return C_ErrorKbn.OK;
                        }

                        return C_ErrorKbn.ERROR;
                    }

                    return C_ErrorKbn.ERROR;
                }

                return C_ErrorKbn.ERROR;
            }

            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(pKinyuuCd)) {
            if (BizUtil.isBlank(pKinyuuSitenCd)) {
                if (!BizUtil.isBlank(pJimusyoCd)) {
                    if (!BizUtil.isBlank(pBosyuutrkNo)) {
                        if (BizUtil.isBlank(pInputbosyuuCd) && BizUtil.isBlank(pTratkikouinnCd)) {
                            return C_ErrorKbn.OK;
                        }

                        return C_ErrorKbn.ERROR;
                    }
                    else if (!BizUtil.isBlank(pInputbosyuuCd)) {
                        if (BizUtil.isBlank(pBosyuutrkNo) && BizUtil.isBlank(pTratkikouinnCd)) {
                            return C_ErrorKbn.OK;
                        }

                        return C_ErrorKbn.ERROR;
                    }
                    else if (!BizUtil.isBlank(pTratkikouinnCd)) {
                        return C_ErrorKbn.ERROR;
                    }

                    return C_ErrorKbn.ERROR;
                }
                if (pRenNo == 1) {
                    return C_ErrorKbn.ERROR;
                }
                if (!BizUtil.isBlank(pBosyuutrkNo) && BizUtil.isBlank(pInputbosyuuCd)
                    && BizUtil.isBlank(pTratkikouinnCd)) {
                    return C_ErrorKbn.OK;
                }
                if (BizUtil.isBlank(pBosyuutrkNo) && !BizUtil.isBlank(pInputbosyuuCd)
                    && BizUtil.isBlank(pTratkikouinnCd)) {
                    return C_ErrorKbn.OK;
                }

                return C_ErrorKbn.ERROR;
            }

            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }
}