package yuyu.app.sinkeiyaku.sknyuukin.sknyuukin;

import static yuyu.app.sinkeiyaku.sknyuukin.sknyuukin.GenSkNyuukinConstants.*;
import static yuyu.app.sinkeiyaku.sknyuukin.sknyuukin.SkNyuukinConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSinkeiyakuDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardNyuukinNyuuryoku;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_JgyiktKbn;
import yuyu.def.classification.C_JiketteiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_JigyouIkkatuNyuukin;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;

/**
 * 入金入力 のビジネスロジックです。
 */
public class SkNyuukinBizLogic {

    private String kosTime = BizDate.getSysDateTimeMilli();

    private BizDate sysDate = BizDate.getSysDate();

    private List<HT_SkDenpyoData> skDenpyoDataLst = new ArrayList<>();

    private String denrenNo = "";

    private int edaNo = 0;

    @Inject
    private static Logger logger;

    @Inject
    private SkNyuukinUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private ErrorMessageCollector errMessages;

    @Inject
    private SortHT_Nyuukin sortNyuukin;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private ObjStorageManager objStorageManager;

    void init() {
    }

    void clear() {
    }

    void pushTourokuBL() {
        BizPropertyInitializer.initialize(uiBean);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getRstuukasyu());

        uiBean.setRsgaku(BizCurrency.optional(currencyType));

        uiBean.setRyosyuymd(uiBean.getTyakkinymd());

        uiBean.setNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);
    }

    void pushKakuninBL() {
        if (uiBean.getTokusyujmum() == true ) {
            uiBean.setTokusyujmumkbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setTokusyujmumkbn(C_UmuKbn.NONE);
        }

        checkZero();
        checkrskingaku();
        openKakuninBL();
        messageManager.addMessageId(MessageId.QAC0008);
        uiBean.setKakuninmessage(MessageUtil.getMessage(MessageId.QAC0008));
    }

    void pushModoruByConfirmBL() {
        uiBean.setKakuninmessage("");
        uiBean.setWarnmessage("");
    }

    @Transactional
    boolean pushKakuteiBL() {

        doUpdateTable();

        return true;
    }

    void checkRelationInputKey() {

        BizDate  tyakkinYmd;
        BizDate syoriYmd3mae;
        BizDate systemHonbankadouYmd = YuyuSinkeiyakuConfig.getInstance().getSystemHonbankadouYmd();

        tyakkinYmd  = uiBean.getTyakkinymd();
        syoriYmd3mae = BizDate.getSysDate().addMonths(-3);

        if(BizDateUtil.compareYmd(systemHonbankadouYmd, tyakkinYmd) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0063);
        }

        if(BizDateUtil.compareYmd(syoriYmd3mae, tyakkinYmd) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0063);
        }

        if (BizDateUtil.compareYmd(tyakkinYmd, BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0063);
        }
    }

    void pushNaiyouNyuuryokuBL() {

        initParam_AtInputContents();
    }

    void continueLockProcess() {

        bzCommonLockProcess.continueLockProcess();
    }

    void unlockProcess() {
        bzCommonLockProcess.unlockProcess();
    }

    private void openKakuninBL() {
        BizDate tyakkinYmd = null;
        BizDate ryosyuYmd = null;
        C_JgyiktKbn jgyiktKbn = C_JgyiktKbn.BLNK;
        BizDate kwsratekjYmd = null;
        tyakkinYmd = uiBean.getTyakkinymd();
        C_Tuukasyu rsTuuKasyu = uiBean.getRstuukasyu();
        String mosNo = uiBean.getMosno();
        ryosyuYmd = uiBean.getRyosyuymd();

        if (uiBean.getJgyiktKbn() != null) {
            jgyiktKbn = uiBean.getJgyiktKbn();
        }

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        C_SeirituKbn seirituKbn = syoriCTL.getSeiritukbn();
        if (C_SeirituKbn.SEIRITU.eq(seirituKbn) || C_SeirituKbn.HUSEIRITU.eq(seirituKbn)) {
            throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
        }

        C_UmuKbn mosnrkUmu = syoriCTL.getMosnrkumu();
        if (C_UmuKbn.NONE.eq(mosnrkUmu)) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException(ERRORMSG_MOSNO + mosNo);
        }

        if (C_NyknsyubetuKbn.HURIKOMI.eq(uiBean.getNyknsyubetu())) {

            if (C_UmuKbn.NONE.eq(uiBean.getTokusyujmumkbn()) &&
                !C_FstphrkkeiroKbn.HURIKOMI.eq(mosKihon.getFstphrkkeirokbn())) {
                throw new BizLogicException(MessageId.EHA1082);
            }
            else if (C_UmuKbn.ARI.eq(uiBean.getTokusyujmumkbn()) &&
                !C_FstphrkkeiroKbn.CREDIT.eq(mosKihon.getFstphrkkeirokbn())) {
                throw new BizLogicException(MessageId.EHA1083);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTokusyujmumkbn()) &&
                syoriCTL.getAuthorikakymd() == null){
                throw new BizLogicException(MessageId.EHA1100);
            }
        }

        C_Tuukasyu hrkTuukasyu = mosKihon.getHrktuukasyu();
        if (!rsTuuKasyu.eq(hrkTuukasyu)) {
            throw new BizLogicException(MessageId.EHA1010, ERRORMSG_MOSJH);
        }

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
        getRsgakukei.getHenkinsumiRsgaku(syoriCTL);
        BizCurrency rsGakukei = getRsgakukei.getRsgakukei();
        C_Tuukasyu jsiTuuKasyu = getRsgakukei.getTuukasyu();

        if (!BizUtil.isZero(rsGakukei)) {
            if (!jsiTuuKasyu.eq(hrkTuukasyu)) {
                throw new BizLogicException(MessageId.EHA1010, ERRORMSG_TRKNYKJH);
            }
        }
        if (!BizUtil.isZero(rsGakukei)) {
            BizCurrency rsgakuSum = rsGakukei.add(uiBean.getRsgaku());
            if (C_Tuukasyu.JPY.eq(jsiTuuKasyu)) {

                if (RSGAKUKETASUU < rsgakuSum.toString().length()) {
                    throw new BizLogicException(MessageId.EBV0046, ERRORMSG_SDKETAOBA);
                }
            }
            else {
                if (BizCurrency.valueOf(GKNYKNKYOYOUMAXKGK, rsgakuSum.getType()).compareTo(rsgakuSum) <= 0) {
                    throw new BizLogicException(MessageId.EBV0046, ERRORMSG_SDKETAOBA);
                }
            }
        }

        if (BizDateUtil.compareYmd(ryosyuYmd, tyakkinYmd) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0064);
        }

        C_Tuukasyu kykTuukasyu = mosKihon.getKyktuukasyu();
        if (!rsTuuKasyu.eq(kykTuukasyu)) {
            List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinsByZenhnknkbn(C_ZenhnknKbn.BLNK);
            kwsratekjYmd = syoriCTL.getRyosyuymd();

            if (nyuukinLst.size() == 0) {
                kwsratekjYmd = ryosyuYmd;
            }

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(kwsratekjYmd,
                kykTuukasyu,
                rsTuuKasyu,
                C_YouhiKbn.HUYOU,
                mosKihon.getHrkkaisuu(),
                C_SysKbn.SKEI,
                mosKihon.getZennoumousideumu(),
                mosKihon.getIkkatubaraikbn());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizLogicException(MessageId.EHA1045);
            }
        }

        if (C_JgyiktKbn.ARI.eq(jgyiktKbn)) {
            chkTJigyouIkkatu();
        }

        uiBean.setSyoriCTL(syoriCTL);

        lockProcess(mosNo);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);
        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);
    }

    private void doUpdateTable() {
        String      soukinCd   = null;
        BizDate     soukinYmd  = null;
        BizDate     tyakkinYmd = null;
        C_Tuukasyu  rsTuukaSyu = null;
        HT_MosKihon mosKihon   = null;
        HT_SyoriCTL syoriCTL   = null;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        BzSinkeiyakuDenpyouDataTourokuBean skDenpyouDataTourokuBean =
            SWAKInjector.getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);

        soukinCd = uiBean.getSoukinCd();
        soukinYmd = uiBean.getSoukinYmd();
        tyakkinYmd = uiBean.getTyakkinymd();
        rsTuukaSyu = uiBean.getRstuukasyu();

        syoriCTL = uiBean.getSyoriCTL();
        mosKihon = syoriCTL.getMosKihon();
        skDenpyouDataTourokuBean.setIbKykymd(mosKihon.getKykymd());
        skDenpyouDataTourokuBean.setIbBosyuuym(mosKihon.getBosyuuym());
        skDenpyouDataTourokuBean.setIbSdpdkbn(mosKihon.getSdpdkbn());
        skDenpyouDataTourokuBean.setIbHrkkaisuu(mosKihon.getHrkkaisuu());
        skDenpyouDataTourokuBean.setIbHrkkeiro(mosKihon.getHrkkeiro());
        skDenpyouDataTourokuBean.setIbSknnkaisiymd(mosKihon.getSknnkaisiymd());
        skDenpyouDataTourokuBean.setIbMosymd(mosKihon.getMosymd());
        skDenpyouDataTourokuBean.setIbKyktuukasyu(mosKihon.getKyktuukasyu());
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst != null && mosSyouhnLst.size() != 0) {
            skDenpyouDataTourokuBean.setIbSyusyouhncd(mosSyouhnLst.get(0).getSyouhncd());
            skDenpyouDataTourokuBean.setIbSyouhnsdno(mosSyouhnLst.get(0).getSyouhnsdno());
            skDenpyouDataTourokuBean.setIbRyouritusdno(mosSyouhnLst.get(0).getRyouritusdno());
        }
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);
        if (mosDairiten != null) {
            skDenpyouDataTourokuBean.setIbAatsukaishasoshikicd(mosDairiten.getDrtenkanrisosikicd());
            skDenpyouDataTourokuBean.setIbAatkisyadaibosyuucd(mosDairiten.getDaibosyuucd());
            skDenpyouDataTourokuBean.setIbAatkisyabosyuucd(mosDairiten.getBosyuucd());
        }

        String                 mosNo                  = null;
        BizCurrency            rsgaku                 = null;
        BizDate                ryosyuYmd              = null;
        String                 rssyouNo               = null;
        C_NyknsyubetuKbn       nyknSyubetu            = null;
        C_JgyiktKbn            jgyIktKbn              = null;
        Integer                maxRenbanNo            = null;
        HT_Nyuukin             nyuukin                = null;
        C_UmuKbn               srGoNyknUmu;
        Integer                renNo;
        HT_JigyouIkkatu        jigyouIkkatu           = null;
        Integer                maxRenbanIkkatuNyuukin = null;
        HT_JigyouIkkatuNyuukin jigyouIkkatuNyuukin    = null;

        setKoumoku(DEBUGMSG_MOSNO, "");

        mosNo = uiBean.getMosno();
        rsgaku = uiBean.getRsgaku();
        ryosyuYmd = uiBean.getRyosyuymd();
        rssyouNo = uiBean.getRssyouNo();
        nyknSyubetu = uiBean.getNyknsyubetu();
        jgyIktKbn = uiBean.getJgyiktKbn();

        setKoumokuVal(mosNo);

        if(!C_JgyiktKbn.ARI.eq(jgyIktKbn)) {
            srGoNyknUmu = C_UmuKbn.NONE;
            renNo       = 1;

            syoriCTL = uiBean.getSyoriCTL();
            if (syoriCTL == null) {
                throw new CommonBizAppException(ERRORMSG_MOSNO + mosNo);
            }

            if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {
                srGoNyknUmu = C_UmuKbn.ARI;
            }

            List<HT_Nyuukin> nyuukinLst = new ArrayList<>(syoriCTL.getNyuukins());
            nyuukinLst = sortNyuukin.OrderHT_NyuukinByPkDesc(nyuukinLst);
            if (nyuukinLst.size() != 0) {
                maxRenbanNo = nyuukinLst.get(0).getRenno();
            }
            if (maxRenbanNo != null) {
                renNo = maxRenbanNo + 1;
            }

            nyuukin = syoriCTL.createNyuukin();

            nyuukin.setRenno(renNo);
            nyuukin.setSoukinymd(soukinYmd);
            nyuukin.setTyakkinymd(tyakkinYmd);
            nyuukin.setNyksyoriymd(BizDate.getSysDate());
            nyuukin.setNyuukinsyoritime(BizDate.getSysDateTimeMilli());
            nyuukin.setNyknsyubetu(nyknSyubetu);
            nyuukin.setSoukincd(soukinCd);
            nyuukin.setRsgaku(rsgaku);
            nyuukin.setRstuukasyu(rsTuukaSyu);
            nyuukin.setRyosyuymd(ryosyuYmd);
            nyuukin.setRssyouno(rssyouNo);
            nyuukin.setZenhnknkbn(C_ZenhnknKbn.BLNK);
            nyuukin.setSrgonyknumu(srGoNyknUmu);
            nyuukin.setDenrenno("");
            nyuukin.setEdano(0);
            nyuukin.setJyuutouym(null);
            nyuukin.setKrkno(null);
            nyuukin.setDntcd("");
            nyuukin.setNyuukinhenkinsyorikbn(C_NyuukinHenkinSyoriKbn.NYUUKIN);
            nyuukin.setZenhnknrenno(0);
            nyuukin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            nyuukin.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            BizPropertyInitializer.initialize(nyuukin);
        }
        else {

            renNo = 1;

            jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu(mosNo);
            int jigyouIkkatuCnt = 0;

            if (jigyouIkkatu == null) {
                jigyouIkkatu = new HT_JigyouIkkatu();

                jigyouIkkatu.setDaimosno(mosNo);
                jigyouIkkatu.setNyknnrkumu(C_UmuKbn.ARI);
                jigyouIkkatu.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                jigyouIkkatu.setGyoumuKousinTime(kosTime);
            }
            else {
                jigyouIkkatuCnt = 1;

                jigyouIkkatu.setNyknnrkumu(C_UmuKbn.ARI);
                jigyouIkkatu.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                jigyouIkkatu.setGyoumuKousinTime(kosTime);
            }

            maxRenbanIkkatuNyuukin = sinkeiyakuDomManager.getJigyouIkkatuNyuukinMaxRennoByDaimosno(mosNo);
            if(maxRenbanIkkatuNyuukin != null) {
                renNo = maxRenbanIkkatuNyuukin + 1;
            }

            jigyouIkkatuNyuukin = jigyouIkkatu.createJigyouIkkatuNyuukin();

            jigyouIkkatuNyuukin.setRenno(renNo);
            jigyouIkkatuNyuukin.setSoukinymd(soukinYmd);
            jigyouIkkatuNyuukin.setSoukincd(soukinCd);
            jigyouIkkatuNyuukin.setRsgaku(rsgaku);
            jigyouIkkatuNyuukin.setRyosyuymd(ryosyuYmd);
            jigyouIkkatuNyuukin.setRssyouno(rssyouNo);
            jigyouIkkatuNyuukin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            jigyouIkkatuNyuukin.setGyoumuKousinTime(kosTime);
            BizPropertyInitializer.initialize(jigyouIkkatuNyuukin);

            if (jigyouIkkatuCnt == 0) {
                jigyouIkkatu.setJiketteikbn(C_JiketteiKbn.NONE);
                BizPropertyInitializer.initialize(jigyouIkkatu);
                sinkeiyakuDomManager.insert(jigyouIkkatu);
            }
            else {
                sinkeiyakuDomManager.update(jigyouIkkatu);
            }
        }

        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);

        if (C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn()) || C_SeirituKbn.ITIPMATI.eq(syoriCTL.getSeiritukbn())) {
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mosNo);
            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
                bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
            mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setSysDate(sysDate);
            mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
            mosnaiCheckParam.setKosTime(kosTime);

            MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
            mosnaiCheck.exec(mosnaiCheckParam);

            bizDomManager.update(gyoumuKouteiInfo);

            HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
            if (mosnoKanri != null) {
                sinkeiyakuDomManager.update(mosnoKanri);
            }

            if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
                sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
            }
        }
        else {
            syoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            syoriCTL.setGyoumuKousinTime(kosTime);
        }

        execByHurikae(syoriCTL, baseUserInfo.getUserId(), skDenpyouDataTourokuBean);

        if (!C_JgyiktKbn.ARI.eq(jgyIktKbn)) {
            nyuukin.setDenrenno(denrenNo);
            nyuukin.setEdano(edaNo);
        }

        sinkeiyakuDomManager.insert(skDenpyoDataLst);
        sinkeiyakuDomManager.update(syoriCTL);

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo);
        skProcessForwardInBean.setTskNm(KTRRKJH_KINOUNM);
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("");

        SkProcessForwardNyuukinNyuuryoku skProcessForwardNyuukinNyuuryoku =
            SWAKInjector.getInstance(SkProcessForwardNyuukinNyuuryoku.class);
        skProcessForwardNyuukinNyuuryoku.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {

                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                    errMessages.addMessage(errorMsg);
                }
                errMessages.throwBizLogicException();
            }
        }

        mosKihon = syoriCTL.getMosKihon();
        skHubiMsgRenkeiInfo.setHhknnmkj(mosKihon.getHhknnmkj());

        ArrayList<String> hubiLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo);
        skHubiMsgRenkeiInfo.setHubimsgData(hubiLst);
        skHubiMsgRenkeiInfo.setMosno(mosNo);

        String uniqueId = objStorageManager.save(skHubiMsgRenkeiInfo);
        uiBean.setUniqueId(uniqueId);
        uiBean.setHubiMsgDatas(hubiLst.toArray(new String[hubiLst.size()]));

        List<String> kekkaGamenMsgLst = mosnaiCheckParam.getListKekkaGmnMsg();
        StringBuffer sbMsg = new StringBuffer();

        sbMsg.append(MessageUtil.getMessage(MessageId.IAC0009));

        if (kekkaGamenMsgLst != null && !kekkaGamenMsgLst.isEmpty()) {
            for (String kekaGamenMsg : kekkaGamenMsgLst) {
                sbMsg.append(MessageUtil.getMessage(MessageId.IAW0006));
                sbMsg.append(kekaGamenMsg);
            }
        }

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), sbMsg.toString());

        uiBean.setKakuninmessage("");
        uiBean.setWarnmessage("");
    }


    private void chkTJigyouIkkatu() {

        HT_JigyouIkkatu jigyouIkkatu = null;
        String mosNo = uiBean.getMosno();

        jigyouIkkatu   = sinkeiyakuDomManager.getJigyouIkkatu(mosNo);
        if (jigyouIkkatu == null) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        C_UmuKbn mosNrkUmu = jigyouIkkatu.getMosnrkumu();
        C_UmuKbn nyknWariNrkKbn = jigyouIkkatu.getNyknwarinrkumu();

        if (!C_UmuKbn.ARI.eq(mosNrkUmu)) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        if (C_UmuKbn.ARI.eq(nyknWariNrkKbn)) {
            throw new BizLogicException(MessageId.EHA0146);
        }
    }

    private void initParam_AtInputContents() {
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getRstuukasyu());

        uiBean.setMosno("");
        uiBean.setRsgaku(BizCurrency.optional(currencyType));
        uiBean.setRyosyuymd(uiBean.getTyakkinymd());
        uiBean.setRssyouNo("");
        uiBean.setJgyiktKbn(C_JgyiktKbn.BLNK);
        uiBean.setNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);
        uiBean.setTokusyujmum(false);
        uiBean.setTokusyujmumkbn(C_UmuKbn.NONE);
    }

    private void execByHurikae(HT_SyoriCTL pSyoriCTL , String pUserID, BzSinkeiyakuDenpyouDataTourokuBean pSkDenpyouDataTourokuBean ) {

        HT_SyoriCTL syoriCTL = pSyoriCTL;
        BizCurrency rsKingaku = uiBean.getRsgaku();
        C_Tuukasyu tuukaSyu = uiBean.getRstuukasyu();
        C_Segcd segcd1 = C_Segcd.BLNK;
        C_Segcd segcd2 = C_Segcd.BLNK;
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();
        C_Kanjyoukmkcd[] kanjyouKmkCds = {C_Kanjyoukmkcd.BLNK, C_Kanjyoukmkcd.BLNK};
        BizNumber kykTuukagkKawaserate = BizNumber.valueOf(0);
        C_Tuukasyu kykTuukasyu = uiBean.getRstuukasyu();
        BizDate fstpRyosyuymd = null;
        BizDate knsnKijyunymd = null;
        HT_MosSyouhn mosSyouhn = null;

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst != null && mosSyouhnLst.size() != 0) {
            mosSyouhn = mosSyouhnLst.get(0);
        }

        fstpRyosyuymd = pSyoriCTL.getRyosyuymd();

        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
        kykTuukasyu = mosKihon.getKyktuukasyu();

        if (!tuukaSyu.eq(kykTuukasyu)) {
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(fstpRyosyuymd, kykTuukasyu, tuukaSyu,
                C_YouhiKbn.HUYOU, mosKihon.getHrkkaisuu(), C_SysKbn.SKEI, mosKihon.getZennoumousideumu(),
                mosKihon.getIkkatubaraikbn());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                if (fstpRyosyuymd.isHoliday()) {
                    knsnKijyunymd = fstpRyosyuymd.getBusinessDay(CHolidayAdjustingMode.NEXT);
                }
                else {
                    knsnKijyunymd = fstpRyosyuymd;
                }
                throw new BizLogicException (MessageId.EHA1045);
            }

            kykTuukagkKawaserate = getKawaseRate.getKawaserate();
        }

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(mosSyouhn.getSyouhncd(), kykTuukasyu);

        if (C_ErrorKbn.OK.eq(syouhinbetuSegmentBean.getErrorKbn())) {
            segcd1 = syouhinbetuSegmentBean.getSegcd1();
            segcd2 = syouhinbetuSegmentBean.getSegcd2();
        }

        if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {
            kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_DAI1KAI;
            kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI;
        }
        else {
            if (C_Tuukasyu.JPY.eq(tuukaSyu)) {
                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY;
            }
            else if (C_Tuukasyu.USD.eq(tuukaSyu)) {
                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_USD;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD;
            }
            else if (C_Tuukasyu.AUD.eq(tuukaSyu)) {
                kanjyouKmkCds[0] = C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_AUD;
                kanjyouKmkCds[1] = C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD;
            }
        }

        editSiwakeMeisaiList(bzSiwakeMeisaiBeanLst,
            C_TaisyakuKbn.KARIKATA,
            kanjyouKmkCds[0],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            rsKingaku,
            segcd1,
            segcd2,
            tuukaSyu,
            kykTuukasyu,
            kykTuukagkKawaserate);

        editSiwakeMeisaiList(bzSiwakeMeisaiBeanLst,
            C_TaisyakuKbn.KASIKATA,
            kanjyouKmkCds[1],
            YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd(),
            rsKingaku,
            segcd1,
            segcd2,
            tuukaSyu,
            kykTuukasyu,
            kykTuukagkKawaserate);

        editDenpyou(syoriCTL, uiBean.getRyosyuymd(), bzSiwakeMeisaiBeanLst, kykTuukasyu, pSkDenpyouDataTourokuBean);
    }


    private void editSiwakeMeisaiList(List<BzSiwakeMeisaiBean> pSiwakeMeisaiBeanLst,
        C_TaisyakuKbn pTaisyakuKbn,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        String pSuitouBumonCd,
        BizCurrency pDengk,
        C_Segcd pSegcd1,
        C_Segcd pSegcd2,
        C_Tuukasyu pTuukasyu,
        C_Tuukasyu pKykTuukasyu,
        BizNumber pKykTuukagkKawaserate) {

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
        BizCurrency  dengaiKagk = BizCurrency.valueOf(0);
        BizCurrency denyenKagk = BizCurrency.valueOf(0);
        BizCurrency keiyakuTuukagk = null;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
            denyenKagk = pDengk;
        }
        else {
            dengaiKagk  = pDengk;
        }

        if (!pTuukasyu.eq(pKykTuukasyu)) {
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            keiyakuTuukagk = keisanGaikakanzan.execDivide(pKykTuukasyu,
                pDengk,
                pKykTuukagkKawaserate,
                C_HasuusyoriKbn.SUTE);
        }
        else {
            keiyakuTuukagk = pDengk;
        }

        bzSiwakeMeisaiBean.setIbTaisyakukbn(pTaisyakuKbn);
        bzSiwakeMeisaiBean.setIbKanjyoukmkcd(pKanjyoukmkcd);
        bzSiwakeMeisaiBean.setIbSuitoubumoncd(pSuitouBumonCd);
        bzSiwakeMeisaiBean.setIbDengaikagk(dengaiKagk);
        bzSiwakeMeisaiBean.setIbDenyenkagk(denyenKagk);
        bzSiwakeMeisaiBean.setIbSeg1cd(pSegcd1);
        bzSiwakeMeisaiBean.setIbSeg2cd(pSegcd2);
        bzSiwakeMeisaiBean.setIbDenkarikanjyono("");
        bzSiwakeMeisaiBean.setIbKeiyakutuukagk(keiyakuTuukagk);
        pSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean);
    }

    private void editDenpyou(HT_SyoriCTL pSyoriCTL, BizDate pRyosyuYmd, List<BzSiwakeMeisaiBean> pSiwakeMeisaiBeanLst, C_Tuukasyu pTuukasyu ,BzSinkeiyakuDenpyouDataTourokuBean pSkDenpyouDataTourokuBean) {
        HT_SyoriCTL syoriCTL = pSyoriCTL;
        String mosNo = syoriCTL.getMosno();
        BizDate sysSyoriDate = sysDate;
        BizDate fstpRyosyuYmd = null;
        boolean kakoRateFlg = false;
        BizDate kakoRateYmd = null;
        BizDate denYmd = sysSyoriDate.addBusinessDays(1);

        fstpRyosyuYmd = pSyoriCTL.getRyosyuymd();

        if (BizDateUtil.compareYmd(fstpRyosyuYmd, sysSyoriDate) == BizDateUtil.COMPARE_LESSER) {
            kakoRateFlg = true;
            kakoRateYmd = fstpRyosyuYmd;
        }
        BzSinkeiyakuDenpyouDataTourokuBean skDenpyouDataTourokuBean =
            SWAKInjector.getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);

        skDenpyouDataTourokuBean.setIbMosno(mosNo);
        skDenpyouDataTourokuBean.setIbHuridenatesakicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkykbukacd());
        skDenpyouDataTourokuBean.setIbTantocd(C_TantouCdKbn.DAIRITENJIMUKANRI);
        skDenpyouDataTourokuBean.setIbDenymd(denYmd);
        skDenpyouDataTourokuBean.setIbTuukasyu(uiBean.getRstuukasyu());
        skDenpyouDataTourokuBean.setIbSyoriymd(sysSyoriDate);
        skDenpyouDataTourokuBean.setIbSyoricd(kinou.getSyoricd());
        skDenpyouDataTourokuBean.setIbSyorisosikicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
        skDenpyouDataTourokuBean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        skDenpyouDataTourokuBean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skDenpyouDataTourokuBean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        skDenpyouDataTourokuBean.setIbDensyorikbn(C_DensyoriKbn.FP_ONLINENYKN);
        skDenpyouDataTourokuBean.setIbAatsukaishasuitososhikicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
        skDenpyouDataTourokuBean.setIbKykymd(pSkDenpyouDataTourokuBean.getIbKykymd());
        skDenpyouDataTourokuBean.setIbBosyuuym(pSkDenpyouDataTourokuBean.getIbBosyuuym());
        skDenpyouDataTourokuBean.setIbAatsukaishasoshikicd(pSkDenpyouDataTourokuBean.getIbAatsukaishasoshikicd());
        skDenpyouDataTourokuBean.setIbAatkisyadaibosyuucd(pSkDenpyouDataTourokuBean.getIbAatkisyadaibosyuucd());
        skDenpyouDataTourokuBean.setIbSyusyouhncd(pSkDenpyouDataTourokuBean.getIbSyusyouhncd());
        skDenpyouDataTourokuBean.setIbSdpdkbn(pSkDenpyouDataTourokuBean.getIbSdpdkbn());
        skDenpyouDataTourokuBean.setIbHrkkaisuu(pSkDenpyouDataTourokuBean.getIbHrkkaisuu());
        skDenpyouDataTourokuBean.setIbHrkkeiro(pSkDenpyouDataTourokuBean.getIbHrkkeiro());
        skDenpyouDataTourokuBean.setIbSknnkaisiymd(pSkDenpyouDataTourokuBean.getIbSknnkaisiymd());
        skDenpyouDataTourokuBean.setIbMosymd(pSkDenpyouDataTourokuBean.getIbMosymd());
        skDenpyouDataTourokuBean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        skDenpyouDataTourokuBean.setIbFstpryosyuymd(fstpRyosyuYmd);
        skDenpyouDataTourokuBean.setIbAatkisyabosyuucd(pSkDenpyouDataTourokuBean.getIbAatkisyabosyuucd());
        skDenpyouDataTourokuBean.setIbRyouritusdno(pSkDenpyouDataTourokuBean.getIbRyouritusdno());
        skDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(baseUserInfo.getUserId());
        skDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(kakoRateFlg);
        skDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(kakoRateYmd);
        skDenpyouDataTourokuBean.setIbKyktuukasyu(pSkDenpyouDataTourokuBean.getIbKyktuukasyu());
        skDenpyouDataTourokuBean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        skDenpyouDataTourokuBean.setIbSyouhnsdno(pSkDenpyouDataTourokuBean.getIbSyouhnsdno());
        skDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(pSiwakeMeisaiBeanLst);

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        List<HT_SkDenpyoData> skDenpyoDataTblLst = bzDenpyouDataSks.execSk(skDenpyouDataTourokuBean);

        denrenNo = skDenpyoDataTblLst.get(0).getDenrenno();
        edaNo = 2;

        skDenpyoDataLst.addAll(skDenpyoDataTblLst);
    }

    private void setKoumoku(String pKoumokuNm, String pKoumokuVal) {
        if(logger.isDebugEnabled()) {
            logger.debug("▽処理中キー情報サービスを設定します。");
            logger.debug("｜ 項目名：" + pKoumokuNm);
            logger.debug("｜ 項目値：" + pKoumokuVal);
            logger.debug("△");
        }
    }

    private void setKoumokuVal(String pKoumokuVal) {
        if(logger.isDebugEnabled()) {
            logger.debug("▽処理中キー情報サービスを設定します。");
            logger.debug("｜ 項目値：" + pKoumokuVal);
            logger.debug("△");
        }
    }

    private void checkZero() {
        if (BizUtil.isZero(uiBean.getRsgaku())) {
            errMessages.addMessage(MessageId.EAV0019, DDID_KIHONINFO_RSGAKU);
        }

        if (errMessages.exists()) {
            throw new BizLogicException(errMessages);
        }
    }

    private void checkrskingaku() {
        if (C_Tuukasyu.JPY.eq(uiBean.getRstuukasyu())) {
            if (RSGAKUKETASUU < uiBean.getRsgaku().toString().length()) {
                errMessages.addMessage(MessageId.EHV0015, ERRORMSG_RSGAKU, String.valueOf(RSGAKUKETASUU));
            }
        }
        else{
            if (BizCurrency.valueOf(GKNYKNKYOYOUMAXKGK, uiBean.getRsgaku().getType()).compareTo(uiBean.getRsgaku()) <= 0) {
                throw new BizLogicException(MessageId.EBV0046, ERRORMSG_SDKETAOBA);
            }
        }

        if (errMessages.exists()) {
            throw new BizLogicException(errMessages);
        }
    }

    private void lockProcess(String pMosNo) {
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pMosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
    }
}
