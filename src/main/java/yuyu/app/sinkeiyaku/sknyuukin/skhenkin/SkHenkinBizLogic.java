package yuyu.app.sinkeiyaku.sknyuukin.skhenkin;

import static yuyu.app.sinkeiyaku.sknyuukin.skhenkin.GenSkHenkinConstants.*;
import static yuyu.app.sinkeiyaku.sknyuukin.skhenkin.SkHenkinConstants.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.exception.LockProcessException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzContinueLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHenkinNyuuryoku;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.sinkeiyaku.skcommon.Henkin;
import yuyu.common.sinkeiyaku.skcommon.HenkinOutBean;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 返金入力 のビジネスロジックです。
 */
public class SkHenkinBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkHenkinUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private Henkin henkin;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    private BzLockProcess bzLockProcess;

    @Inject
    private BzContinueLockProcess bzContinueLockProcess;

    @Inject
    private BzUnlockProcess bzUnlockProcess;

    void init() {

        clear();

        uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue());
    }

    void initHenkinkibou() {

        clear();

        uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.HENKINKIBOU.getValue());
    }

    void iwfOpenBL() {


        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.setMosno(bzGetProcessSummaryOutBeanLst.get(0).getMosNo());
        uiBean.setHenkinKouteiUmu(C_UmuKbn.ARI);
        uiBean.setHenkinKouteiKaisiUmu(C_UmuKbn.ARI);


        BzGetProcessSummaryInBean mainProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary mainProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        mainProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        mainProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        mainProcessSummaryInBean.setMosNo(uiBean.getMosno());

        List<BzGetProcessSummaryOutBean> mainProcessSummaryOutBeanLst =
            mainProcessSummary.exec(mainProcessSummaryInBean);

        if (mainProcessSummaryOutBeanLst.size() != 0) {

            uiBean.setMainKouteiUmu(C_UmuKbn.ARI);

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = mainProcessSummaryOutBeanLst.get(0);

            uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            uiBean.getBzWorkflowInfo().setOyaKouteiJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        }

        openInputBL(C_SkkinouModeIdKbn.HENKINNYUURYOKU, false);
    }

    void clear() {
    }

    @Transactional
    void openInputBL(C_SkkinouModeIdKbn pSkkinouModeIdKbn, boolean pWorkflowJyouhouSetYh) {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.getKinouMode().setKinouMode(pSkkinouModeIdKbn.getValue());
        HT_SyoriCTL syoriCtl = checkTSyoriCTL();


        C_Tuukasyu tuukaSyu;
        if (C_SkkinouModeIdKbn.HENKINKIBOU.eq(pSkkinouModeIdKbn)) {
            tuukaSyu = checkTNyuukin(syoriCtl);
        }
        else {
            tuukaSyu = checkTHenkin(syoriCtl);
        }


        if (pWorkflowJyouhouSetYh) {
            if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.eq(pSkkinouModeIdKbn)) {

                BzGetProcessSummaryInBean henkinProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                BzGetProcessSummary henkinProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                henkinProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
                henkinProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                henkinProcessSummaryInBean.setMosNo(uiBean.getMosno());

                List<BzGetProcessSummaryOutBean> henkinProcessSummaryOutBeanLst =
                    henkinProcessSummary.exec(henkinProcessSummaryInBean);

                BzGetProcessSummaryInBean mainProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                BzGetProcessSummary mainProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                mainProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                mainProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                mainProcessSummaryInBean.setMosNo(uiBean.getMosno());

                List<BzGetProcessSummaryOutBean> mainProcessSummaryOutBeanLst =
                    mainProcessSummary.exec(mainProcessSummaryInBean);

                uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
                uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_HENKINNYUURYOKU);

                if (mainProcessSummaryOutBeanLst.size() != 0) {

                    uiBean.setMainKouteiUmu(C_UmuKbn.ARI);

                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = mainProcessSummaryOutBeanLst.get(0);

                    uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                    uiBean.getBzWorkflowInfo().setOyaKouteiJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                }

                if (henkinProcessSummaryOutBeanLst.size() != 0) {

                    uiBean.setHenkinKouteiUmu(C_UmuKbn.ARI);

                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = henkinProcessSummaryOutBeanLst.get(0);

                    uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

                    if (ISkCommonKoumoku.NODEID_HENKINNYUURYOKU.equals(bzGetProcessSummaryOutBean.getNowNodoId())) {
                        uiBean.setHenkinKouteiKaisiUmu(C_UmuKbn.ARI);
                    }
                }
                else {
                    if (mainProcessSummaryOutBeanLst.size() != 0) {
                        uiBean.getBzWorkflowInfo().setKouteiKanriId(mainProcessSummaryOutBeanLst.get(0).getKouteiKanriId());
                    }
                }
            }
            else {

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

                uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
                uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_HENKINKIBOU);
            }
        }

        lockProcess(uiBean.getMosno());


        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCtl);
        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);
        String[] strings = selKykNmKjFromTMosKihon(syoriCtl);
        String kykNmkj = strings[0];
        setWarningMsg(syoriCtl.getMosnrkumu(), strings[1]);
        setUiBeanForInput(syoriCtl, kykNmkj, tuukaSyu, pSkkinouModeIdKbn);


        if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.eq(pSkkinouModeIdKbn)
            && C_UmuKbn.ARI.eq(uiBean.getHenkinKouteiUmu())
            && C_UmuKbn.ARI.eq(uiBean.getHenkinKouteiKaisiUmu())) {

            C_TskStartKekkaKbn tskStartKekkaKbn = startTask(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId());

            if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0111);
            }
            else if(C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)){
                throw new BizLogicException(MessageId.EBA0112);
            }
        }
    }

    void pushKakuninBL() {

        checkRequired();


        checkZero();


        String bankCd = null;
        String sitenCd = null;
        C_YokinKbn yokinKbn = C_YokinKbn.BLNK;
        String kouzaNo = null;
        String kzmeigiNm = null;
        String mosNo = uiBean.getMosno();
        C_HnknhouKbn hnknhouKbn = uiBean.getHnknhoukbn();
        C_Tuukasyu tuukaSyu = uiBean.getTuukaSyu();
        BizCurrency hnkngk = uiBean.getHnkngk();
        BizCurrency hnknKibougk = uiBean.getHnknkibougk();
        C_SkkinouModeIdKbn skkinouModeIdKbn = C_SkkinouModeIdKbn.valueOf(uiBean.getKinouMode().getKinouMode());
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();


        if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.eq(skkinouModeIdKbn)) {
            if (C_HnknhouKbn.PHURIKZ.eq(hnknhouKbn)) {
                checkHnknKouzaInf(ARI_CHECK, tuukaSyu);
                if (C_UmuKbn.NONE.eq(syoriCTL.getKznrkumu())) {
                    throw new BizLogicException(MessageId.EHA0091);
                }
                HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
                if (kouzaJyouhou == null) {
                    throw new BizLogicException(MessageId.EHA0091);
                }
                if (C_KzkykdouKbn.DOUITU.eq(kouzaJyouhou.getKzkykdoukbn())) {
                    kzmeigiNm = getKzmeigNmKnFromMosKihon(mosNo);
                }
                else {
                    kzmeigiNm = kouzaJyouhou.getKzmeiginmkn();
                }
                bankCd = kouzaJyouhou.getBankcd();
                sitenCd = kouzaJyouhou.getSitencd();
                yokinKbn = kouzaJyouhou.getYokinkbn();
                kouzaNo = kouzaJyouhou.getKouzano();
            }
            else if (C_HnknhouKbn.KOUZASITEI.eq(hnknhouKbn)) {
                checkHnknKouzaInf(NASI_CHECK, tuukaSyu);

                bankCd = uiBean.getBankcd();
                sitenCd = uiBean.getSitencd();
                yokinKbn = uiBean.getYokinkbn();
                kouzaNo = uiBean.getKouzano();
                kzmeigiNm = uiBean.getKzmeiginmkn();
            }
            else if (C_HnknhouKbn.KARIUKE.eq(hnknhouKbn)) {
                checkHnknKouzaInf(ARI_CHECK, tuukaSyu);
            }


            if (C_Tuukasyu.JPY.eq(tuukaSyu) && IGkCommonKoumoku.BANKCD_YTGINKOU.equals(bankCd)
                && !C_YokinKbn.HUTUU.eq(yokinKbn)) {
                throw new BizLogicException(MessageId.EBC1011, yokinKbn.getContent());
            }


            if (!BizUtil.isBlank(kouzaNo)) {
                CheckKouzaNo checkKouzaNo = SWAKInjector.getInstance(CheckKouzaNo.class);
                if (!checkKouzaNo.isCheckOK(kouzaNo, tuukaSyu)) {
                    throw new BizLogicException(MessageId.EBC0046,
                        MessageUtil.getMessage(DDID_BANKINFO_KOUZANO.getErrorResourceKey()));
                }
                if (!checkKouzaNo.isKyoyouKeta(kouzaNo, tuukaSyu)) {
                    throw new BizLogicException(MessageId.EBC1012,
                        MessageUtil.getMessage(DDID_BANKINFO_KOUZANO.getErrorResourceKey()));
                }
            }


            if (!BizUtil.isBlank(kzmeigiNm)) {
                int nmKyoyou = YuyuBizConfig.getInstance().getKzmeigiKanaNmKyoyou();
                if (!CheckMeigininNmKana.isCheckOK_Tuuka(kzmeigiNm, tuukaSyu)) {
                    throw new BizLogicException(MessageId.EBC0046,
                        MessageUtil.getMessage(DDID_BANKINFO_KZMEIGINMKN.getErrorResourceKey()));
                }
                if (!CheckKana.isKyoyouKetaHankaku(kzmeigiNm, nmKyoyou)) {
                    throw new BizLogicException(MessageId.EBC1012,
                        MessageUtil.getMessage(DDID_BANKINFO_KZMEIGINMKN.getErrorResourceKey()));
                }
            }


            checkHnKnGk(syoriCTL, hnkngk, tuukaSyu);


            if (!C_HnknhouKbn.KARIUKE.eq(hnknhouKbn)) {
                BzGetBankDataBean bzGetBankDataBean = getGinkouInf(bankCd, sitenCd, tuukaSyu);
                if (C_HnknhouKbn.PHURIKZ.eq(hnknhouKbn)) {
                    sitenCd = bzGetBankDataBean.getSitenCd();
                }
                uiBean.setBankcd(bankCd);
                uiBean.setBanknmkj(bzGetBankDataBean.getBankNmKj());
                uiBean.setSitencd(sitenCd);
                uiBean.setSitennmkj(bzGetBankDataBean.getSitenNmKj());
                uiBean.setYokinkbn(yokinKbn);
                uiBean.setKouzano(kouzaNo);
                uiBean.setKzmeiginmkn(kzmeigiNm);
            }
            else {
                uiBean.setBanknmkj("");
                uiBean.setSitennmkj("");
            }

            if (C_Tuukasyu.JPY.eq(tuukaSyu) && !BizUtil.isBlank(uiBean.getKouzano())) {
                int yenkaKouzaKetasuu = YuyuBizConfig.getInstance().getYenkaKouzaKetasuu();

                if (uiBean.getKouzano().length() < yenkaKouzaKetasuu) {
                    uiBean.setKouzano(Strings.padStart(uiBean.getKouzano(), yenkaKouzaKetasuu, '0'));
                }
            }
        }
        else {
            checkHnknKibouGk(syoriCTL, hnknKibougk, tuukaSyu);
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);


        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QAC0008,
            MessageUtil.getMessage(MessageId.QAC0008));
    }

    @Transactional
    void pushKakuteiBL() {

        doUpdateTables();
    }

    void pushModoruBtnByConfirmBL() {

        if (C_HnknhouKbn.PHURIKZ.eq(uiBean.getHnknhoukbn())) {
            initGotoInputCntents();
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        addConversationMessage();
    }

    String pushModoruBtnByInputContentsBL() {

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
        String seniSaki = getSenisaki();
        return seniSaki;
    }

    String getSenisaki(){

        String seniSaki = "";
        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                seniSaki = FORWARDNAME_INIT;
            }
            else {
                seniSaki = FORWARDNAME_INIT_KIBOU;
            }
        }
        else {
            seniSaki = FORWARDNAME_BACKTOWORKLIST;
        }
        return seniSaki;
    }

    void printHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void continueLockProcess() {

        if (!BizUtil.isBlank(bzCommonLockProcess.getKouteiLockKey())) {
            bzCommonLockProcess.continueLockProcess();
        }


        if (!BizUtil.isBlank(uiBean.getKouteiLockKey())) {
            C_KouteiLockKekkaKbn kouteiLockKekkaKbn = bzContinueLockProcess.exec(
                uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd(),
                uiBean.getKouteiLockKey());

            if (!C_KouteiLockKekkaKbn.SUCCESS.eq(kouteiLockKekkaKbn)) {
                throw new LockProcessException();
            }
        }
    }

    void unlockProcess() {

        if (!BizUtil.isBlank(bzCommonLockProcess.getKouteiLockKey())) {
            bzCommonLockProcess.unlockProcess();
        }


        if (!BizUtil.isBlank(uiBean.getKouteiLockKey())) {
            bzUnlockProcess.exec(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd(),
                uiBean.getKouteiLockKey());
        }
    }


    private HT_SyoriCTL checkTSyoriCTL() {

        String mosNo = uiBean.getMosno();


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }


        C_UmuKbn umuKbn = syoriCTL.getMosnrkumu();

        if (C_UmuKbn.NONE.eq(umuKbn)) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        return syoriCTL;
    }

    private void lockProcess(String pMosNo) {

        if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            if (C_UmuKbn.ARI.eq(uiBean.getHenkinKouteiUmu())) {
                bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

                if (C_UmuKbn.ARI.eq(uiBean.getMainKouteiUmu())) {
                    BzLockProcessOutBean bzLockProcessOutBean = bzLockProcess.exec(
                        uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                        uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());

                    if (!C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
                        throw new BizLogicException(MessageId.EBA0110);
                    }

                    uiBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
                }
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getMainKouteiUmu())) {
                    bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                        uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());
                }
            }
        }
        else{
            bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        }
    }

    private C_TskStartKekkaKbn startTask(String pKouteiKanriId,String pJimuTetuzukiCd,String pTaskId){

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn skStartKekkaKbn = bzTaskStart.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId,
            bzCommonLockProcess.getKouteiLockKey(),
            baseUserInfo.getUserId());
        return skStartKekkaKbn;
    }

    private C_Tuukasyu checkTHenkin(HT_SyoriCTL pSyoriCTL){

        List<HT_Henkin> henkinLst = pSyoriCTL.getHenkinsByHnknsyoriymdNull();
        if (henkinLst.size() == 0) {
            throw new BizLogicException(MessageId.EHA1038);
        }
        C_Tuukasyu tuukaSyu = henkinLst.get(0).getHnkntuukasyu();
        return tuukaSyu;
    }

    private C_Tuukasyu checkTNyuukin(HT_SyoriCTL pSyoriCTL) {

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.JPY;
        C_SeirituKbn seirituKbn = pSyoriCTL.getSeiritukbn();

        if (C_SeirituKbn.SEIRITU.eq(seirituKbn) || C_SeirituKbn.HUSEIRITU.eq(seirituKbn)) {
            throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
        }

        List<HT_Nyuukin> nyuukinLst = pSyoriCTL.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.SUMI);
        if (nyuukinLst.isEmpty()) {
            throw new BizLogicException(MessageId.EHA0117);
        }

        getRsgakukei.getPkakinsumiRsgaku(pSyoriCTL);
        BizCurrency rsgakukei = getRsgakukei.getRsgakukei();
        tuukaSyu = getRsgakukei.getTuukasyu();


        if (BizCurrency.valueOf(0, rsgakukei.getType()).compareTo(rsgakukei) >= 0) {
            throw new BizLogicException(MessageId.EHA0117);
        }

        return tuukaSyu;
    }

    private String[] selKykNmKjFromTMosKihon(HT_SyoriCTL pSyoriCTL){

        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
        String[] strings = new String[2];
        if (mosKihon != null) {
            if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                strings[0] = mosKihon.getHhknnmkj();
                strings[1] = mosKihon.getAitemosno();
                return strings;
            }
            strings[0] = mosKihon.getKyknmkj();
            strings[1] = mosKihon.getAitemosno();
            return strings;
        }
        strings[0] = "";
        strings[1] = "";
        return strings;
    }

    private void setWarningMsg(C_UmuKbn pUmuKbn, String pAitemosno) {

        int kekkaKbn = getMsgAitemosno.exec(pUmuKbn, pAitemosno);
        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbn) {
            String messageId = BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid());
            List<String> warningIdLst = Lists.newArrayList();
            List<String> warningLst = Lists.newArrayList();
            warningIdLst.add(messageId);
            warningLst.add(getMsgAitemosno.getS_gmmsg());
            uiBean.setGmWarningIdLst(warningIdLst);
            uiBean.setGmWarningLst(warningLst);
            addConversationMessage();
        }
    }

    private void setUiBeanForInput(HT_SyoriCTL pSyoriCTL, String pKyknmkj, C_Tuukasyu pTuukaSyu,
        C_SkkinouModeIdKbn pSkkinouModeIdKbn) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukaSyu);

        uiBean.setKyknmkj(pKyknmkj);
        uiBean.setSyoriCTL(pSyoriCTL);
        uiBean.setHnkngk(BizCurrency.optional(currencyType));
        uiBean.setHnknkibougk(BizCurrency.optional(currencyType));
        uiBean.setTuukaSyu(pTuukaSyu);

        if (C_SkkinouModeIdKbn.HENKINKIBOU.eq(pSkkinouModeIdKbn)) {
            HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
            BizCurrency mosfstpkei = mosKihon.getMosfstpkei();
            C_Tuukasyu hrktuukasyu = mosKihon.getHrktuukasyu();
            C_Tuukasyu kyktuukasyu = mosKihon.getKyktuukasyu();
            BizCurrency rsgaku = getPkakinsumiRsgaku(pSyoriCTL, pTuukaSyu);

            List<HT_MosSyouhn> mosSyouhnList = pSyoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
            BM_SyouhnZokusei syouhnZokusei = null;
            if (mosSyouhnList != null && mosSyouhnList.size() != 0) {
                syouhnZokusei = mosSyouhnList.get(0).getSyouhnZokusei();
            }

            if (syouhnZokusei != null) {
                if (pTuukaSyu.eq(hrktuukasyu)) {
                    if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                        if (hrktuukasyu.eq(kyktuukasyu)) {
                            if (rsgaku.compareTo(mosfstpkei) > 0) {
                                uiBean.setHnknkibougk(rsgaku.subtract(mosfstpkei));
                            }
                        }
                        else {
                            if (C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())) {
                                BizCurrency firstp = keisanGaikakanzan.exec(pTuukaSyu, mosKihon.getMosheijyunp(),
                                    pSyoriCTL.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);
                                BizCurrency zennou = keisanGaikakanzan.exec(pTuukaSyu,
                                    mosKihon.getMosfstpkei().subtract(mosKihon.getMosheijyunp()),
                                    pSyoriCTL.getNyknkwsrate(),
                                    C_HasuusyoriKbn.SUTE);

                                BizCurrency mosfstpkei2 = firstp.add(zennou);

                                if (rsgaku.compareTo(mosfstpkei2) > 0) {
                                    uiBean.setHnknkibougk(rsgaku.subtract(mosfstpkei2));
                                }
                            }
                            else {
                                BizCurrency mosfstpkei2 = keisanGaikakanzan.exec(pTuukaSyu, mosKihon.getMosheijyunp(),
                                    pSyoriCTL.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);

                                if (rsgaku.compareTo(mosfstpkei2) > 0) {
                                    uiBean.setHnknkibougk(rsgaku.subtract(mosfstpkei2));
                                }
                            }
                        }
                    }
                    else {
                        if (rsgaku.compareTo(mosfstpkei) > 0) {

                            uiBean.setHnknkibougk(rsgaku.subtract(mosfstpkei));
                        }
                    }
                }
                else {
                    uiBean.setHnknkibougk(rsgaku);
                }
            }
        }
        else {
            BizCurrency pkakingakuGoukei = getPkakinsumi(pSyoriCTL, currencyType);
            if (pkakingakuGoukei.compareTo(BizCurrency.valueOf(0, pkakingakuGoukei.getType())) > 0) {
                uiBean.setHnkngk(pkakingakuGoukei);

            }
        }

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        if (BizUtil.isBlank(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId())) {
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setSyoNo(pSyoriCTL.getSyono());

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() != 0) {
                uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());
            }
        }

        if (!BizUtil.isBlank(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId())) {
            SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
            setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);
        }
    }

    private void checkHnknKouzaInf(int pCheckKbn, C_Tuukasyu pTuukasyu) {

        if (pCheckKbn == ARI_CHECK) {

            if (!BizUtil.isBlank(uiBean.getBankcd())) {
                throw new BizLogicException(MessageId.EHA0092);
            }
            else if (!BizUtil.isBlank(uiBean.getSitencd())) {
                throw new BizLogicException(MessageId.EHA0092);
            }
            else if (!C_YokinKbn.BLNK.eq(uiBean.getYokinkbn())) {
                throw new BizLogicException(MessageId.EHA0092);
            }
            else if (!BizUtil.isBlank(uiBean.getKouzano())) {
                throw new BizLogicException(MessageId.EHA0092);
            }
            else if (!BizUtil.isBlank(uiBean.getKzmeiginmkn())) {
                throw new BizLogicException(MessageId.EHA0092);
            }
        }
        else if (pCheckKbn == NASI_CHECK) {

            if (BizUtil.isBlank(uiBean.getBankcd())) {
                throw new BizLogicException(MessageId.EHA0095);
            }
            else if (BizUtil.isBlank(uiBean.getSitencd())) {
                throw new BizLogicException(MessageId.EHA0095);
            }
            else if (C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) && C_Tuukasyu.JPY.eq(pTuukasyu)) {
                throw new BizLogicException(MessageId.EHA0095);
            }
            else if (BizUtil.isBlank(uiBean.getKouzano())) {
                throw new BizLogicException(MessageId.EHA0095);
            }
            else if (BizUtil.isBlank(uiBean.getKzmeiginmkn())) {
                throw new BizLogicException(MessageId.EHA0095);
            }
        }
    }

    private String getKzmeigNmKnFromMosKihon(String pMosNo) {

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        if (syoriCTL == null) {
            throw new CommonBizAppException(ERRMSG_MOSNO + pMosNo);
        }
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException(ERRMSG_MOSNO + pMosNo);
        }
        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
            return mosKihon.getHhknnmkn();
        }
        return mosKihon.getKyknmkn();
    }

    private void checkHnKnGk(HT_SyoriCTL pSyoriCTL, BizCurrency pHnkngk, C_Tuukasyu pTuukaSyu) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukaSyu);
        List<BizCurrency> hnkngkLst = pSyoriCTL.getHenkinSumHnkngkByhnknsyoriymdNull();
        BizCurrency kakngk = BizCurrency.valueOf(0, currencyType);
        for (BizCurrency hnkngk : hnkngkLst) {
            if (currencyType.equals(hnkngk.getType())) {
                kakngk = hnkngk;
            }
        }
        if (pHnkngk.compareTo(kakngk) != 0) {
            throw new BizLogicException(MessageId.EHA1039, ViewReport.editCommaTuuka(kakngk, BizUtil.ZERO_FILL));
        }
    }

    private void checkHnknKibouGk(HT_SyoriCTL pSyoriCTL, BizCurrency pHnknkibougk, C_Tuukasyu pTuukaSyu) {

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
        getRsgakukei.getPkakinsumiRsgaku(pSyoriCTL, pTuukaSyu);
        BizCurrency rsgakukei = getRsgakukei.getRsgakukei();
        if (rsgakukei.compareTo(pHnknkibougk) < 0) {
            throw new BizLogicException(MessageId.EHA0098, MessageUtil.getMessage(
                DDID_HENKININFO_HNKNKIBOUGK.getErrorResourceKey()), ViewReport.editCommaTuuka(rsgakukei, BizUtil.ZERO_FILL));
        }
    }

    private BzGetBankDataBean getGinkouInf(String pBankCd, String pSitenCd, C_Tuukasyu pTuukaSyu) {

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pBankCd, pSitenCd, BizDate.getSysDate());


        if (C_BankmasterUmuKbn.NONE.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
            throw new BizLogicException(MessageId.EBC1007);
        }


        if (C_BankYuuksHantKbn.NG.eq(bzGetBankDataBean.getBankYuuksHantKbn())) {
            throw new BizLogicException(MessageId.EBC1008);
        }


        if (C_Tuukasyu.JPY.eq(pTuukaSyu)) {
            if (C_EnkashrKahiKbn.HUKA.eq(bzGetBankDataBean.getEnkashrKahiKbn())) {
                throw new BizLogicException(MessageId.EBC1009);
            }
        }
        else {
            if (C_GaikashrKahiKbn.HUKA.eq(bzGetBankDataBean.getGaikashrKahiKbn())) {
                throw new BizLogicException(MessageId.EBC1010);
            }
        }

        return bzGetBankDataBean;
    }

    private void doUpdateTables() {

        C_SeirituKbn seirituKbn;
        HenkinOutBean henkinOutBean;
        String mosNo = uiBean.getMosno();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        if (syoriCTL != null) {
            seirituKbn = syoriCTL.getSeiritukbn();
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        }
        else {
            throw new CommonBizAppException(ERRMSG_MOSNO + mosNo);
        }

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());
        mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
        mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());


        if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            C_HnknhouKbn hnknhouKbn = uiBean.getHnknhoukbn();
            BizCurrency hnkngk = uiBean.getHnkngk();
            C_Tuukasyu tuukasyu = uiBean.getTuukaSyu();
            HT_KouzaJyouhou kouzaJyouhou = setRecordForKouzaJyouhou(mosNo, hnknhouKbn, syoriCTL);
            henkinOutBean = henkin.exec(mosnaiCheckParam, hnknhouKbn, kouzaJyouhou, hnkngk, tuukasyu);
        }
        else {
            BizCurrency hnknkibougk = uiBean.getHnknkibougk();
            C_Tuukasyu tuukasyu = uiBean.getTuukaSyu();
            henkinOutBean = henkin.execPkakin(mosnaiCheckParam, hnknkibougk, tuukasyu, C_HenkinriyuuKbn.HENKINKIBOU);
        }


        if (C_SeirituKbn.NONE.eq(seirituKbn) || C_SeirituKbn.ITIPMATI.eq(seirituKbn)) {


            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mosNo);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
                bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

            mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
            mosnaiCheckParam.debug("<<<<申込内容チェック実行前>>>>");
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
            syoriCTL.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        }


        sinkeiyakuDomManager.update(syoriCTL);


        if (henkinOutBean.getSkDenpyoDataList().size() > 0) {
            sinkeiyakuDomManager.insert(henkinOutBean.getSkDenpyoDataList());
        }


        if (henkinOutBean.getSkFBSoukinDataList().size() > 0) {
            sinkeiyakuDomManager.insert(henkinOutBean.getSkFBSoukinDataList());
        }


        if (henkinOutBean.getSkGaikaFBSoukinDataList().size() > 0) {
            sinkeiyakuDomManager.insert(henkinOutBean.getSkGaikaFBSoukinDataList());
        }


        SkProcessForwardHenkinNyuuryoku henkinNyuuryoku = SWAKInjector.getInstance(SkProcessForwardHenkinNyuuryoku.class);

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);

        if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            if (C_UmuKbn.ARI.eq(uiBean.getHenkinKouteiUmu()) || C_UmuKbn.ARI.eq(uiBean.getMainKouteiUmu())) {

                String mainKouteiLockkey = null;
                String henkinKouteiLockkey = null;

                if (C_UmuKbn.ARI.eq(uiBean.getHenkinKouteiUmu())) {
                    skProcessForwardInBean.setKouteiLockkey(bzCommonLockProcess.getKouteiLockKey());
                    henkinKouteiLockkey = bzCommonLockProcess.getKouteiLockKey();
                }

                if (C_UmuKbn.ARI.eq(uiBean.getMainKouteiUmu())) {
                    if (C_UmuKbn.ARI.eq(uiBean.getHenkinKouteiUmu())) {
                        henkinNyuuryoku.setKouteiLockkeyMain(uiBean.getKouteiLockKey());
                        mainKouteiLockkey = uiBean.getKouteiLockKey();
                    }
                    else {
                        henkinNyuuryoku.setKouteiLockkeyMain(bzCommonLockProcess.getKouteiLockKey());
                        mainKouteiLockkey = bzCommonLockProcess.getKouteiLockKey();
                    }
                }

                SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

                skProcessUpdate.exec(syoriCTL, mainKouteiLockkey, henkinKouteiLockkey);
            }
        }
        else {
            skProcessForwardInBean.setKouteiLockkey(bzCommonLockProcess.getKouteiLockKey());

            henkinNyuuryoku.setKouteiLockkeyMain(bzCommonLockProcess.getKouteiLockKey());

            SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

            skProcessUpdate.exec(syoriCTL, bzCommonLockProcess.getKouteiLockKey(), null);
        }

        henkinNyuuryoku.exec(skProcessForwardInBean);


        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(
            syoriCTL, uiBean.getSkIdounaiyouBeforeBean());
        if (hanteiKekka) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);
            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                    errorMessageCollector.addMessage(errorMsg);
                }
                throw new BizLogicException(errorMessageCollector);
            }
        }


        if (syoriCTL.getMosKihon() == null) {
            skHubiMsgRenkeiInfo.setHhknnmkj(null);
        }
        else {
            skHubiMsgRenkeiInfo.setHhknnmkj(syoriCTL.getMosKihon().getHhknnmkj());
        }


        ArrayList<String> hubiLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo);
        skHubiMsgRenkeiInfo.setHubimsgData(hubiLst);
        skHubiMsgRenkeiInfo.setMosno(mosNo);
        uiBean.setUniqueId(objStorageManager.save(skHubiMsgRenkeiInfo));

        uiBean.setHubimsgData(hubiLst.toArray(new String[0]));

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);


        List<String> kekkaMsgLst = mosnaiCheckParam.getListKekkaGmnMsg();
        StringBuffer sbMsg = new StringBuffer();
        sbMsg.append(MessageUtil.getMessage(MessageId.IAC0009));

        if (kekkaMsgLst != null && !kekkaMsgLst.isEmpty()) {
            for (Iterator<String> youso = kekkaMsgLst.iterator(); youso.hasNext();) {
                sbMsg.append(MessageUtil.getMessage(MessageId.IAW0006));
                sbMsg.append(youso.next());
            }
        }

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), sbMsg.toString());
    }

    private HT_KouzaJyouhou setRecordForKouzaJyouhou(String pMosNo, C_HnknhouKbn pHnknHouKbn,
        HT_SyoriCTL pSyoriCtrl) {

        HT_KouzaJyouhou initRecord = new HT_KouzaJyouhou();
        initRecord.setMosno(pMosNo);
        initRecord.setKzmeiginmkn(uiBean.getKzmeiginmkn());
        if (C_HnknhouKbn.KOUZASITEI.eq(pHnknHouKbn)) {
            initRecord.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        }
        else if (C_HnknhouKbn.KARIUKE.eq(pHnknHouKbn)) {
            initRecord.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
        }
        initRecord.setBankcd(uiBean.getBankcd());
        initRecord.setSitencd(uiBean.getSitencd());
        initRecord.setYokinkbn(uiBean.getYokinkbn());
        initRecord.setKouzano(uiBean.getKouzano());

        if (C_HnknhouKbn.PHURIKZ.eq(pHnknHouKbn)) {
            HT_KouzaJyouhou kouzaJyouhou = pSyoriCtrl.getKouzaJyouhou();

            if (kouzaJyouhou == null || C_UmuKbn.NONE.eq(pSyoriCtrl.getKznrkumu())) {
                throw new CommonBizAppException(ERRMSG_MOSNO + pMosNo);
            }
            initRecord.setKzkykdoukbn(kouzaJyouhou.getKzkykdoukbn());
        }

        BizPropertyInitializer.initialize(initRecord);
        return initRecord;
    }

    private void addConversationMessage() {

        List<String> gmWarningIdLst = uiBean.getGmWarningIdLst();
        if (gmWarningIdLst != null && gmWarningIdLst.size() > 0) {
            List<String> gmWarningLst = uiBean.getGmWarningLst();
            int index = 0;
            for (String gmWarningId : gmWarningIdLst) {
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, gmWarningId,
                    gmWarningLst.get(index));
                index++;
            }
        }
    }

    private void initGotoInputCntents() {

        uiBean.setBankcd("");
        uiBean.setBanknmkj("");
        uiBean.setSitencd("");
        uiBean.setSitennmkj("");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("");
        uiBean.setKzmeiginmkn("");
    }

    private void checkRequired() {

        if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            if (BizUtil.isBlank(uiBean.getHnkngk().toString())) {
                errorMessageCollector.addMessage(MessageId.EAV0001, new Item[] { DDID_HENKININFO_HNKNGK }, "");
            }
            if (C_HnknhouKbn.BLNK.eq(uiBean.getHnknhoukbn())) {
                errorMessageCollector.addMessage(MessageId.EAV0001, new Item[] { DDID_HENKININFO_HNKNHOUKBN }, "");
            }
        }
        else{
            if (BizUtil.isBlank(uiBean.getHnknkibougk().toString())) {
                errorMessageCollector.addMessage(MessageId.EAV0001, new Item[] { DDID_HENKININFO_HNKNKIBOUGK }, "");
            }
        }
        if (errorMessageCollector.exists()) {
            throw new BizLogicException(errorMessageCollector);
        }
    }

    private void checkZero() {

        String kinouMode = uiBean.getKinouMode().getKinouMode();
        if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(kinouMode)) {
            if (BizUtil.isZero(uiBean.getHnkngk())) {
                errorMessageCollector.addMessage(MessageId.EAV0019, new Item[] { DDID_HENKININFO_HNKNGK }, "");
            }
        }
        else {
            if (BizUtil.isZero(uiBean.getHnknkibougk())) {
                errorMessageCollector.addMessage(MessageId.EAV0019, new Item[] { DDID_HENKININFO_HNKNKIBOUGK }, "");
            }
        }
        if (errorMessageCollector.exists()) {
            throw new BizLogicException(errorMessageCollector);
        }
    }

    private BizCurrency getPkakinsumiRsgaku(HT_SyoriCTL pSyoriCTL, C_Tuukasyu pTuukasyu) {

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);

        getRsgakukei.getPkakinsumiRsgaku(pSyoriCTL, pTuukasyu);
        BizCurrency rsgaku = getRsgakukei.getRsgakukei();

        return rsgaku;
    }

    private BizCurrency getPkakinsumi(HT_SyoriCTL pSyoriCTL, CurrencyType pCurrencyType) {

        List<BizCurrency> henkingakuGoukeiLst = pSyoriCTL.getHenkinSumHnkngkByhnknsyoriymdNull();
        BizCurrency pkakingakuGoukei = BizCurrency.valueOf(0, pCurrencyType);

        for (BizCurrency henkingakuGoukei : henkingakuGoukeiLst) {
            if (pCurrencyType.equals(henkingakuGoukei.getType())) {
                pkakingakuGoukei = henkingakuGoukei;
            }
        }

        return pkakingakuGoukei;
    }




}
