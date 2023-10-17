package yuyu.app.siharai.sisatei.sisindansyoryousiharai;

import static yuyu.app.siharai.sisatei.sisindansyoryousiharai.GenSiSindansyoryouSiharaiConstants.*;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.TtzkRrkListDataSourceBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzHanteiAgUtil;
import yuyu.common.biz.kaikei.BzShiharaiDenpyouDateShutoku;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.siharai.chksk.CheckSdsSkNaiyouKekkaBean;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.chksk.ChkSubShskInfo;
import yuyu.common.siharai.chksk.ChkSubSksInfo;
import yuyu.common.siharai.chksk.ChkSubhassoKbn;
import yuyu.common.siharai.chksk.SiSKNaiyouChkkekkaSettei;
import yuyu.common.siharai.edittbl.EditRrk;
import yuyu.common.siharai.edittbl.EditRrkTblBean;
import yuyu.common.siharai.edittbl.EditSateiRrkTbl;
import yuyu.common.siharai.edittbl.EditSateiRrkTblBean;
import yuyu.common.siharai.edittbl.EditSiharaiRirekiTbl;
import yuyu.common.siharai.edittbl.EditSiharaiRirekiTblBean;
import yuyu.common.siharai.edittbl.EditSkTbl;
import yuyu.common.siharai.edittbl.EditSkTblBean;
import yuyu.common.siharai.edittbl.SiEditFb;
import yuyu.common.siharai.edittbl.SiEditFbInBean;
import yuyu.common.siharai.edittbl.SiEditFbOutBean;
import yuyu.common.siharai.edittbl.SkTblSetBean;
import yuyu.common.siharai.koutei.SiProcessForward;
import yuyu.common.siharai.koutei.SiRuleBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.DouituSyonoStyChk;
import yuyu.common.siharai.sicommon.SetteiShrhousiteiKbn;
import yuyu.common.siharai.sicommon.SiCommonSiwake;
import yuyu.common.siharai.sicommon.SiCommonSiwakeBean;
import yuyu.common.siharai.sicommon.SiCommonSiwakeKekkaBean;
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.common.siharai.sicommon.SiharaigakuBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.siharai.siedittyouhyou.EditSiharaimeisaisyoSindansyo;
import yuyu.common.siharai.siedittyouhyou.EditSiharaimeisaisyoSindansyoBean;
import yuyu.common.siharai.siedittyouhyou.SeikyuusyaInfoBean;
import yuyu.common.siharai.siedittyouhyou.SiTyouhyouHensyuuCommonBean;
import yuyu.common.siharai.siedittyouhyou.ToiawaseInfoBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdBean;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 診断書料支払 のビジネスロジックです。
 */
public class SiSindansyoryouSiharaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiSindansyoryouSiharaiUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    void init() {
    }

    void clear() {
    }

    String pushKetteiBL() {

        uiBean.setYouhiKbn(C_YouhiKbn.HUYOU);

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);

        siKinouModeSettei.exec();

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.DEFAULT.getValue())) {
            throw new BizLogicException(MessageId.EBS0003);
        }

        uiBean.setPatternSyorikekkaKbn(C_SyorikekkaKbn.PATTERN_SISINDANSYOINPUT);

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSeikyuusyakbn(C_SeikyuusyaKbn.HHKN);
        uiBean.setKidougmKbn(C_KidougmKbn.INPUTKEY);

        douituSyonoStyChk();

        keiyakuInfoSyutoku();

        uiBean.setSkno(SaibanBiz.getSeikyuBangou());

        List<UsersByKinouIdKinouModeIdUserIdBean> userLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId(kinou.getKinouId(),
            kinouMode.getKinouMode(), baseUserInfo.getUserId());

        mrfkzTratkiChk(uiBean.getSiKykKihon().getDrtencd());

        uiBean.setSiharaituukakbn(C_SiharaiTuukaKbn.YENSIHARAI);

        SiSetUiBean.setHihokensya(uiBean, uiBean.getSiKykKihon());

        SiSetUiBean.setSiteidairinin(uiBean, uiBean.getSiKykKihon());

        SiSetUiBean.setSouhusaki(uiBean, uiBean.getSiKykKihon());

        setTennousakisousasyacd(userLst);

        uiBean.setViewSoukinsakiInputDispFlg(true);

        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(true);

        return FORWARDNAME_INPUTCONTENTSINPUT;
    }

    String pushKakuninBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();

        if (!uiBean.isKinouModeTenkenSeigyo()) {

            if(C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn()) && !BizUtil.isBlank(uiBean.getKzmeiginmkn())){

                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_VIEWSOUKINSAKIINFO_KZMEIGINMKN.getErrorResourceKey()));
            }

            uiBean.setSeikyuusyanmkn("");

            if (C_SeikyuusyaKbn.HHKN.eq(uiBean.getSeikyuusyakbn())) {

                uiBean.setSeikyuusyanmkn(uiBean.getSiKykKihon().getHhknnmkn());
                uiBean.setSeikyuusyanmkj(uiBean.getSiKykKihon().getHhknnmkj());
            }

            else if (C_SeikyuusyaKbn.SBUKT.eq(uiBean.getSeikyuusyakbn())) {

                for (JT_SiUkt siUkt : uiBean.getSiKykKihon().getSiUkts()) {

                    if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu()) ||
                        C_Hkuktsyu.SBKYFKUKT.eq(siUkt.getHkuktsyu())){

                        if (!BizUtil.isBlank(siUkt.getUktnmkn())) {

                            uiBean.setSeikyuusyanmkn(siUkt.getUktnmkn());
                            uiBean.setSeikyuusyanmkj(siUkt.getUktnmkj());

                            break;
                        }
                    }
                }
            }

            else if (C_SeikyuusyaKbn.STDR.eq(uiBean.getSeikyuusyakbn())) {

                uiBean.setSeikyuusyanmkn(uiBean.getSiKykKihon().getSiteidruktnmkn());
                uiBean.setSeikyuusyanmkj(uiBean.getSiKykKihon().getSiteidruktnmkj());
            }
        }

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {

            chkSubSksyaInfo(uiBean.getSeikyuusyakbn(), uiBean.getSeikyuusyanmkj(), uiBean.getSiKykKihon());

            List<ChkKekkaBean> chkKekkaBeanLst = Lists.newArrayList();

            ChkSubShskInfo chkSubShskInfo = SWAKInjector.getInstance(ChkSubShskInfo.class);
            chkSubShskInfo.exec(uiBean.getSouhusakikbn(), uiBean.getTsinyno(), uiBean.getTsinadr1kj(),
                uiBean.getTsinadr2kj(), uiBean.getTsinadr3kj(), "", uiBean.getSiKykKihon(), chkKekkaBeanLst);

            ChkSubSksInfo chkSubSksInfo = SWAKInjector.getInstance(ChkSubSksInfo.class);
            chkSubSksInfo.exec(uiBean.getInputshrhousiteikbn(), uiBean.getBankcd(), uiBean.getSitencd(),
                uiBean.getYokinkbn(), uiBean.getKouzano(), uiBean.getKzdoukbn(), uiBean.getKzmeiginmkn(),
                C_Tuukasyu.JPY, uiBean.getSeikyuusyanmkn(), uiBean.getSeikyuusyakbn(), chkKekkaBeanLst);

            if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn()) &&
                C_SeikyuusyaKbn.SONOTA.eq(uiBean.getSeikyuusyakbn())) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KZDOUKBN_SKSYAKBN_SKCHK);
                chkKekkaBean.setMsgHikisuu1(uiBean.getSeikyuusyakbn().getContent());

                chkKekkaBeanLst.add(chkKekkaBean);
            }

            ChkSubhassoKbn chkSubhassoKbn = SWAKInjector.getInstance(ChkSubhassoKbn.class);
            chkSubhassoKbn.exec(C_SaisateiKbn.BLNK,"","","",C_Tkhukaumu.BLNK, uiBean.getShrdtlsyooutkbn(), uiBean.getHassoukbn(),
                uiBean.getInputshrhousiteikbn(),uiBean.getSiKykKihon(), chkKekkaBeanLst);

            if (chkKekkaBeanLst.size() != 0) {

                CheckSdsSkNaiyouKekkaBean checkSdsSkNaiyouKekkaBean = SWAKInjector.getInstance(CheckSdsSkNaiyouKekkaBean.class);

                SiSKNaiyouChkkekkaSettei siSKNaiyouChkkekkaSettei = SWAKInjector.getInstance(SiSKNaiyouChkkekkaSettei.class);
                siSKNaiyouChkkekkaSettei.exec(
                    C_SeikyuuSyubetu.SDSSHR, kinou.getKinouId(),
                    C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()),
                    null, null, null, checkSdsSkNaiyouKekkaBean, chkKekkaBeanLst);

                if (checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().getMessages().size() != 0) {

                    throw new BizLogicException(checkSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError());
                }
            }

            if (uiBean.getSindansyomaisuu() == null || uiBean.getSindansyomaisuu() == 0) {

                throw new BizLogicException(MessageId.EBA0027,
                    MessageUtil.getMessage(DDID_SINDANSYORYOUSHR_SINDANSYOMAISUU.getErrorResourceKey()));
            }
        }

        if (C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())) {

            if (BizUtil.isBlank(uiBean.getTennousakisousasyacd())) {

                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_KEKKAINPUT_TENNOUSAKISOUSASYACD.getErrorResourceKey()));
            }
        }

        if (!BizUtil.isBlank(uiBean.getTennousakisousasyacd())) {

            if (!C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())) {

                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_KEKKAINPUT_TENNOUSAKISOUSASYACD.getErrorResourceKey()));
            }
        }

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd(), null);

        SetteiShrhousiteiKbn setteiShrhousiteiKbn = SWAKInjector.getInstance(SetteiShrhousiteiKbn.class);
        BzShiharaiDenpyouDateShutoku bzShiharaiDenpyouDateShutoku = SWAKInjector.getInstance(BzShiharaiDenpyouDateShutoku.class);

        C_ShrhousiteiKbn shrhousiteiKbn = setteiShrhousiteiKbn.exec(uiBean.getInputshrhousiteikbn(), C_Tuukasyu.JPY);

        BizDate siharaiDenpyouYmd = bzShiharaiDenpyouDateShutoku.exec(BizDate.getSysDate(), shrhousiteiKbn, C_Tuukasyu.JPY,uiBean.getBankcd());

        YuyuSiharaiConfig yuyuSiharaiConfig = YuyuSiharaiConfig.getInstance();

        uiBean.setBanknmkj(bzGetBankDataBean.getBankNmKj());
        uiBean.setSitennmkj(bzGetBankDataBean.getSitenNmKj());

        if (uiBean.getSindansyomaisuu() != null && uiBean.getSindansyomaisuu() != 0) {

            uiBean.setShrgkkei(yuyuSiharaiConfig.getSdsRyou().multiply(uiBean.getSindansyomaisuu()));
        }
        else {
            uiBean.setShrgkkei(BizCurrency.optional());
        }

        uiBean.setTyakkinymd(siharaiDenpyouYmd);
        uiBean.setViewSoukinsakiInputDispFlg(false);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);

        if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) {
            SiSetUiBean.setSouhusakiKykAdr(uiBean, uiBean.getSiKykKihon());
        }

        if (!uiBean.isKinouModeTenkenSeigyo() && C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
            uiBean.setKzmeiginmkn(uiBean.getSeikyuusyanmkn());
        }

        int yenkaKouzaKetasuu = YuyuBizConfig.getInstance().getYenkaKouzaKetasuu();
        if (!BizUtil.isBlank(uiBean.getKouzano()) && uiBean.getKouzano().length() < yenkaKouzaKetasuu) {
            uiBean.setKouzano(Strings.padStart(uiBean.getKouzano(),yenkaKouzaKetasuu, '0'));
        }

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;
    }

    String pushFunctionNameBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();

        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    String pushModoruBtnByInputContentsBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();

        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    void pushTojiruBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }

    @Transactional
    String pushKakuteiBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();

        BizDate sysDate = BizDate.getSysDate();

        if (!uiBean.isKidougmKbnWorkListSeigyo()) {

            douituSyonoStyChk();
        }

        Integer seikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(uiBean.getSkno(), uiBean.getSyono());

        if (seikyuurirekino != null) {

            seikyuurirekino = seikyuurirekino + 1;
        } else {

            seikyuurirekino = 1;
        }

        if (uiBean.isKidougmKbnWorkListSeigyo()) {

            setSkKihon(uiBean.getSkKihon());

            siharaiDomManager.update(uiBean.getSkKihon());
        } else {

            JT_SkKihon skKihon = SWAKInjector.getInstance(JT_SkKihon.class);

            setSkKihon(skKihon);

            BizPropertyInitializer.initialize(skKihon);

            siharaiDomManager.insert(skKihon);

            uiBean.setSkKihon(skKihon);
        }

        uiBean.setSiharaituukakbn(C_SiharaiTuukaKbn.BLNK);
        uiBean.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.SDSSHRYH);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);
        EditSkTbl editSkTbl = SWAKInjector.getInstance(EditSkTbl.class);
        SkTblSetBean skTblSetBean = SWAKInjector.getInstance(SkTblSetBean.class);

        skTblSetBean.setShrgk(uiBean.getShrgkkei());
        editSkTblBean.setSkNo(uiBean.getSkno());
        editSkTblBean.setSyoNo(uiBean.getSyono());
        editSkTblBean.setSeikyuuRirekiNo(seikyuurirekino);
        editSkTblBean.setUketukeNo(1);
        editSkTblBean.setSkTblSetBean(skTblSetBean);

        editSkTblBean = editSkTbl.setEditKyhSkTbl(uiBean, editSkTblBean);

        JT_Sk sk = uiBean.getSkKihon().createSk();

        BeanUtil.copyProperties(sk, editSkTblBean.getSk());

        BizPropertyInitializer.initialize(sk);

        String siharaiSikibetuKey = "";

        if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            siharaiSikibetuKey = SaibanBiz.getShrSikibetukey(uiBean.getSyono());
        }

        String sateSyouninSikibetukey = SaibanBiz.getSateSyouninSikibetukey(uiBean.getSyono());

        EditRrkTblBean editRrkTblBean = SWAKInjector.getInstance(EditRrkTblBean.class);
        EditRrk editRrk = SWAKInjector.getInstance(EditRrk.class);

        editRrkTblBean.setSeiNo(uiBean.getSkno());
        editRrkTblBean.setSyoNo(uiBean.getSyono());
        editRrkTblBean.setSyoriYmd(sysDate);

        if (C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.KOUZAKAKUNIN.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())) {

            editRrkTblBean.setJimKakuteiUmuKbn(C_JimukakuteiKbn.MIKAKUTEI);
        } else {

            editRrkTblBean.setJimKakuteiUmuKbn(C_JimukakuteiKbn.KAKUTEI);
        }

        editRrkTblBean.setSeiRrkNo(seikyuurirekino);
        editRrkTblBean.setShrSkbtKey(siharaiSikibetuKey);
        editRrkTblBean.setSateiSkbtKey(sateSyouninSikibetukey);

        editRrk.makeTtdkRrk(uiBean, editRrkTblBean);

        JT_TtdkRireki ttdkRireki = uiBean.getSkKihon().createTtdkRireki();

        BeanUtil.copyProperties(ttdkRireki, editRrkTblBean.getTtdkRireki());

        BizPropertyInitializer.initialize(ttdkRireki);

        EditSateiRrkTblBean editSateiRrkTblBean = SWAKInjector.getInstance(EditSateiRrkTblBean.class);
        EditSateiRrkTbl editSateiRrkTbl = SWAKInjector.getInstance(EditSateiRrkTbl.class);

        editSateiRrkTblBean.setSkno(uiBean.getSkno());
        editSateiRrkTblBean.setSyono(uiBean.getSyono());
        editSateiRrkTblBean.setSeikyuurirekino(seikyuurirekino);
        editSateiRrkTblBean.setSateisyouninskbtkey(sateSyouninSikibetukey);

        editSateiRrkTbl.exec(uiBean, editSateiRrkTblBean);

        JT_SateiSyouninRireki sateiSyouninRireki = uiBean.getSkKihon().createSateiSyouninRireki();

        BeanUtil.copyProperties(sateiSyouninRireki, editSateiRrkTblBean.getSateiSyouninRireki());

        BizPropertyInitializer.initialize(sateiSyouninRireki);

        String kouteiKanriId = "";

        BzProcessCreateOutBean bzProcessCreateOutBean = SWAKInjector.getInstance(BzProcessCreateOutBean.class);

        if (!uiBean.isKidougmKbnWorkListSeigyo()) {

            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);

            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setSkNo(uiBean.getSkno());
            bzProcessCreateInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU);

            bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            if (!C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {

                throw new BizLogicException(MessageId.EBS0008);
            }

            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

            bzCommonLockProcess.lockProcess(bzProcessCreateOutBean.getKouteiKanriId(), TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU);
            kouteiKanriId = bzProcessCreateOutBean.getKouteiKanriId();

        }else {
            BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);
            kouteiKanriId = bzWorkflowInfo.getKouteiKanriId();
        }

        if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

            String sosikiCd = baseUserInfo.getTmSosikiCd();

            BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(sosikiCd);

            if (C_KanryotuutioutKbn.PDF.eq(uiBean.getShrdtlsyooutkbn())) {

                EditSiharaimeisaisyoSindansyoBean editSiharaimeisaisyoSindansyoBean = SWAKInjector.getInstance(EditSiharaimeisaisyoSindansyoBean.class);
                SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
                SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
                ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
                EditSiharaimeisaisyoSindansyo editSiharaimeisaisyoSindansyo = SWAKInjector.getInstance(EditSiharaimeisaisyoSindansyo.class);
                CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

                siTyouhyouHensyuuCommonBean.setSyoriYmd(sysDate);
                siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);

                seikyuusyaInfoBean.setSeikyuusyanmKj(uiBean.getSeikyuusyanmkj());
                seikyuusyaInfoBean.setTsinyno(uiBean.getTsinyno());
                seikyuusyaInfoBean.setTsinadr1kj(uiBean.getTsinadr1kj());
                seikyuusyaInfoBean.setTsinadr2kj(uiBean.getTsinadr2kj());
                seikyuusyaInfoBean.setTsinadr3kj(uiBean.getTsinadr3kj());

                toiawaseInfoBean.setSosikiNm(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                toiawaseInfoBean.setTsinyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                toiawaseInfoBean.setTsinadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                toiawaseInfoBean.setTsinadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                toiawaseInfoBean.setTsinadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
                toiawaseInfoBean.setTsintelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
                toiawaseInfoBean.setTelUktkKanouTime("");
                toiawaseInfoBean.setTelUktkkanouTimeHigou("");

                editSiharaimeisaisyoSindansyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                editSiharaimeisaisyoSindansyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
                editSiharaimeisaisyoSindansyoBean.setToiawaseInfoBean(toiawaseInfoBean);
                editSiharaimeisaisyoSindansyoBean.setSyoNo(uiBean.getSyono());
                editSiharaimeisaisyoSindansyoBean.setTyakkinYmd(uiBean.getTyakkinymd());
                editSiharaimeisaisyoSindansyoBean.setKyuuhuNameReport(SiSindansyoryouSiharaiConstants.KYUUHUMEI_TYOUHYOU);
                editSiharaimeisaisyoSindansyoBean.setSindansyomaisuu(uiBean.getSindansyomaisuu());
                editSiharaimeisaisyoSindansyoBean.setSindansyo(uiBean.getShrgkkei());
                editSiharaimeisaisyoSindansyoBean.setBanknmKj(uiBean.getBanknmkj());
                String sitenmei = "";
                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd(), null);
                if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
                    sitenmei = bzGetBankDataBean.getReportSitenNm();
                }
                editSiharaimeisaisyoSindansyoBean.setSitennmKj(sitenmei);
                editSiharaimeisaisyoSindansyoBean.setYokinKbn(uiBean.getYokinkbn());
                String kouzano = "";
                if(IGkCommonKoumoku.BANKCD_YTGINKOU.equals(uiBean.getBankcd())){
                    kouzano = uiBean.getKouzano() + "1";
                } else {
                    kouzano = uiBean.getKouzano();
                }
                editSiharaimeisaisyoSindansyoBean.setKouzaNo(BizUtil.editMask(kouzano, 3, '*'));
                editSiharaimeisaisyoSindansyoBean.setKzmeiginmKn(uiBean.getKzmeiginmkn());

                ReportServicesBean reportServicesBean = editSiharaimeisaisyoSindansyo.exec(editSiharaimeisaisyoSindansyoBean);

                String TyouhyouKey = createReport.execNoCommit(reportServicesBean);

                uiBean.setTyouhyoukey(TyouhyouKey);
            }

            EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = SWAKInjector.getInstance(EditSiharaiRirekiTblBean.class);
            EditSiharaiRirekiTbl editSiharaiRirekiTbl = SWAKInjector.getInstance(EditSiharaiRirekiTbl.class);

            editSiharaiRirekiTblBean.setSkno(uiBean.getSkno());
            editSiharaiRirekiTblBean.setSyono(uiBean.getSyono());
            editSiharaiRirekiTblBean.setShrsikibetukey(siharaiSikibetuKey);
            editSiharaiRirekiTblBean.setSeikyuurirekino(seikyuurirekino);
            editSiharaiRirekiTblBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
            editSiharaiRirekiTblBean.setShrsyoriymd(sysDate);
            editSiharaiRirekiTblBean.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
            editSiharaiRirekiTblBean.setTorikesiflg(C_UmuKbn.NONE);

            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);

            JT_SiRireki siRireki = uiBean.getSkKihon().createSiRireki();

            BeanUtil.copyProperties(siRireki, editSiharaiRirekiTblBean.getSirireki());

            BizPropertyInitializer.initialize(siRireki);

            SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
            SiCommonSiwake siCommonSiwake = SWAKInjector.getInstance(SiCommonSiwake.class);

            siCommonSiwakeBean.setSyoNo(uiBean.getSyono());
            siCommonSiwakeBean.setDenYmd(uiBean.getTyakkinymd());
            siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
            siCommonSiwakeBean.setKeiyakuTuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu());
            siCommonSiwakeBean.setInputShrhousiteiKbn(uiBean.getInputshrhousiteikbn());
            siCommonSiwakeBean.setSyoriYmd(sysDate);
            siCommonSiwakeBean.setSyoriCd(kinou.getSyoricd());
            siCommonSiwakeBean.setSyoriSosikiCd(baseUserInfo.getTmSosikiCd());
            siCommonSiwakeBean.setKakoKawaserateShiteiFlg(false);
            siCommonSiwakeBean.setSyouhnCd(uiBean.getSiKykSyouhn().getSyouhncd());
            siCommonSiwakeBean.setSyouhnsdNo(uiBean.getSiKykSyouhn().getSyouhnsdno());
            siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
            siCommonSiwakeBean.setSindansyo(uiBean.getShrgkkei());

            List<SiharaigakuBean>  beanLst = Lists.newArrayList();
            siCommonSiwakeBean.setSiharaigakuBeanList(beanLst);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType type = henkanTuuka.henkanTuukaKbnToType(uiBean.getSiKykSyouhn().getKyktuukasyu());

            siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(0,type));

            SetteiShrhousiteiKbn setteiShrhousiteiKbn = SWAKInjector.getInstance(SetteiShrhousiteiKbn.class);
            C_ShrhousiteiKbn shrhousiteiKbn = setteiShrhousiteiKbn.exec(uiBean.getInputshrhousiteikbn(), C_Tuukasyu.JPY);

            siCommonSiwakeBean.setShrhousiteiKbn(shrhousiteiKbn);


            SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = siCommonSiwake.exec(siCommonSiwakeBean);


            if (siCommonSiwakeKekkaBean.getSiDenpyoDataLst().size() != 0) {

                List<JT_SiDenpyoData> siDenpyoDataLst = Lists.newArrayList();

                for (JT_SiDenpyoData siDenpyoData : siCommonSiwakeKekkaBean.getSiDenpyoDataLst()) {

                    JT_SiDenpyoData insSiDenpyoData = SWAKInjector.getInstance(JT_SiDenpyoData.class);

                    BeanUtil.copyProperties(insSiDenpyoData, siDenpyoData);

                    BizPropertyInitializer.initialize(insSiDenpyoData);

                    siDenpyoDataLst.add(insSiDenpyoData);
                }

                siharaiDomManager.insert(siDenpyoDataLst);
            }else{
                throw new BizLogicException(MessageId.EBS1003,"sidenpyodata",null);
            }


            if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {

                SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
                SiEditFb siEditFb = SWAKInjector.getInstance(SiEditFb.class);

                siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
                siEditFbInBean.setBankCd(uiBean.getBankcd());
                siEditFbInBean.setSitenCd(uiBean.getSitencd());
                siEditFbInBean.setYokinKbn(uiBean.getYokinkbn());
                siEditFbInBean.setKouzaNo(uiBean.getKouzano());
                siEditFbInBean.setKzMeiginmKn(uiBean.getKzmeiginmkn());
                siEditFbInBean.setSoukinGk(uiBean.getShrgkkei());
                siEditFbInBean.setKykTuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu());
                siEditFbInBean.setGaikaTaikaGk(BizCurrency.valueOf(0));
                siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(0));
                siEditFbInBean.setFbSokinEdaBangou(siCommonSiwakeKekkaBean.getFbSoukinEdaNo());
                siEditFbInBean.setSiDenpyoDataLst(siCommonSiwakeKekkaBean.getSiDenpyoDataLst());

                SiEditFbOutBean siEditFbOutBean = siEditFb.exec(siEditFbInBean);

                if (siEditFbOutBean.getSiFBSoukinDataLst().size() != 0) {

                    List<JT_SiFBSoukinData> siFBSoukinDataLst = Lists.newArrayList();

                    for (JT_SiFBSoukinData siFBSoukinData : siEditFbOutBean.getSiFBSoukinDataLst()) {

                        JT_SiFBSoukinData insSiFBSoukinData = new JT_SiFBSoukinData();

                        BeanUtil.copyProperties(insSiFBSoukinData, siFBSoukinData);

                        BizPropertyInitializer.initialize(insSiFBSoukinData);

                        siFBSoukinDataLst.add(insSiFBSoukinData);
                    }

                    siharaiDomManager.insert(siFBSoukinDataLst);
                }else{
                    throw new BizLogicException(MessageId.EBS1003,"siFBsoukindata",null);
                }
            }
        }

        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);

        siRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());

        siProcessForward.exec(kouteiKanriId, TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU,
            bzCommonLockProcess.getKouteiLockKey(), uiBean.getSyanaicomment(), siRuleBean, uiBean.getTennousakisousasyacd());

        bzCommonLockProcess.unlockProcess();

        siharaiDomManager.update(uiBean.getSkKihon());

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }

    String pushModoruBtnByConfirmBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        if (!C_SeikyuusyaKbn.SONOTA.eq(uiBean.getSeikyuusyakbn())) {

            uiBean.setSeikyuusyanmkj("");
        }

        if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) {

            uiBean.setTsinyno("");
            uiBean.setTsinadr1kj("");
            uiBean.setTsinadr2kj("");
            uiBean.setTsinadr3kj("");
        }

        if(C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())){
            uiBean.setKzmeiginmkn("");
        }
        if (uiBean.isKinouModeTenkenSeigyo()) {

            uiBean.setViewSoukinsakiInputDispFlg(false);
            uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);

            return FORWARDNAME_INPUTCONTENTSTENKEN;
        }

        uiBean.setViewSoukinsakiInputDispFlg(true);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(true);

        return FORWARDNAME_INPUTCONTENTSINPUT;
    }

    String pushSyokigamenheBL() {

        if (uiBean.isKidougmKbnWorkListSeigyo()) {

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    @Transactional
    String pushFromSiharaiWorkListBL() {

        uiBean.setYouhiKbn(C_YouhiKbn.HUYOU);

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        if (C_SikinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())) {

            uiBean.setPatternSyorikekkaKbn(C_SyorikekkaKbn.PATTERN_SISINDANSYOINPUT);
        }

        else if (C_SikinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {

            uiBean.setPatternSyorikekkaKbn(C_SyorikekkaKbn.PATTERN_SISINDANSYOTENKEN);
        }

        else {

            throw new BizAppException(MessageId.EBS1003, AS_KinouMode.KINOUMODEID,
                C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()).getContent());
        }

        BizPropertyInitializer.initialize(uiBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());
        uiBean.setSkno(gyoumuKouteiInfo.getSkno());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU,
            kinouMode.getKinouMode(), bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {

            throw new BizLogicException(MessageId.EBA0111);
        }

        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {

            throw new BizLogicException(MessageId.EBA0112);
        }

        keiyakuInfoSyutoku();

        Integer maxSeikyuurirekiNo = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(uiBean.getSkno(), uiBean.getSyono());

        if (maxSeikyuurirekiNo == null) {

            throw new BizAppException(MessageId.EBS1003, JT_Sk.SEIKYUURIREKINO, "null");
        }

        uiBean.setSeiRrkNo(maxSeikyuurirekiNo.toString());

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(uiBean.getSkno(), uiBean.getSyono());

        if (skKihon == null) {

            throw new BizAppException(MessageId.EBS0005, JT_SkKihon.TABLE_NAME, JT_SkKihon.SKNO, uiBean.getSkno(),
                JT_SkKihon.SYONO, uiBean.getSyono());
        }

        uiBean.setSkKihon(skKihon);

        JT_Sk sk = skKihon.getSkBySeikyuurirekino(Integer.valueOf(uiBean.getSeiRrkNo()));

        if (sk == null) {

            throw new BizAppException(MessageId.EBS0004, JT_Sk.TABLE_NAME, JT_Sk.SEIKYUURIREKINO, uiBean.getSeiRrkNo());
        }

        uiBean.setSk(sk);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

        List<UsersByKinouIdKinouModeIdUserIdBean> userLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId(
            kinou.getKinouId(),
            kinouMode.getKinouMode(),
            baseUserInfo.getUserId());

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        mrfkzTratkiChk(uiBean.getSiKykKihon().getDrtencd());

        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);

        uiBean.setSyono(uiBean.getSiKykKihon().getSyono());
        uiBean.setSiharaituukakbn(C_SiharaiTuukaKbn.YENSIHARAI);

        SiSetUiBean.setHihokensya(uiBean, uiBean.getSiKykKihon());

        SiSetUiBean.setSiteidairinin(uiBean, uiBean.getSiKykKihon());

        SiSetUiBean.setSouhusaki(uiBean, uiBean.getSiKykKihon());

        siSetUiBean.setSk(uiBean, uiBean.getSk());

        if (uiBean.isKinouModeTenkenSeigyo() &&
            C_Kzdou.DOUITU.eq(uiBean.getSk().getKzdoukbn())) {
            uiBean.setKzmeiginmkn(uiBean.getSk().getKzmeiginmkn());
        }

        setTennousakisousasyacd(userLst);

        uiBean.setKidougmKbn(C_KidougmKbn.WORKLIST);

        if (uiBean.isKinouModeTenkenSeigyo()) {

            uiBean.setViewSoukinsakiInputDispFlg(false);
            uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);

            return FORWARDNAME_INPUTCONTENTSTENKEN;
        }

        uiBean.setViewSoukinsakiInputDispFlg(true);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(true);

        return FORWARDNAME_INPUTCONTENTSINPUT;
    }

    String pushFromSiSindansyoryouSiharaiBL() {

        BizPropertyInitializer.initialize(uiBean);

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno(),
            uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());

        if (skKihon == null) {

            throw new BizAppException(MessageId.EBS0005,
                JT_SkKihon.TABLE_NAME, JT_SkKihon.SKNO,uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno(),
                JT_SkKihon.SYONO, uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());
        }

        List<TtzkRrkListDataSourceBean> dataSourceBeanLst = uiBean.getSiTtzkRirekiSyoukaiUiBean().getTtzkRrkListDataSource().getAllData();
        TtzkRrkListDataSourceBean ttzkRrkListDataSourceBean = SWAKInjector.getInstance(TtzkRrkListDataSourceBean.class);
        int sntkgyouno = uiBean.getSiTtzkRirekiSyoukaiUiBean().getSntkgyouno();
        for (int i = 0 ; i < dataSourceBeanLst.size(); i++ ) {
            if (i == sntkgyouno) {
                ttzkRrkListDataSourceBean = dataSourceBeanLst.get(sntkgyouno);
                break;
            }
        }

        JT_Sk sk = skKihon.getSkBySeikyuurirekino(ttzkRrkListDataSourceBean.getSeiRrkNo());

        if (sk == null) {

            throw new BizAppException(MessageId.EBS0004, JT_Sk.TABLE_NAME, JT_Sk.SEIKYUURIREKINO,
                String.valueOf(ttzkRrkListDataSourceBean.getSeiRrkNo()));
        }

        JT_TtdkRireki ttdkRireki = skKihon.getTtdkRirekByTtdkrrkskbtkey(ttzkRrkListDataSourceBean.getDispttdkrrkskbtkey());

        if (ttdkRireki == null) {

            throw new BizAppException(MessageId.EBS0004, JT_TtdkRireki.TABLE_NAME, JT_TtdkRireki.TTDKRRKSKBTKEY,
                ttzkRrkListDataSourceBean.getDispttdkrrkskbtkey());
        }

        JT_SateiSyouninRireki sateiSyouninRireki =
            skKihon.getSateiSyouninRirekiBySateisyouninskbtkey(ttdkRireki.getSateisyouninskbtkey());

        if (sateiSyouninRireki == null) {

            throw new BizAppException(MessageId.EBS0004, JT_SateiSyouninRireki.TABLE_NAME,
                JT_SateiSyouninRireki.SATEISYOUNINSKBTKEY, ttdkRireki.getSateisyouninskbtkey());
        }

        uiBean.setSyono(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());
        uiBean.setYouhiKbn(C_YouhiKbn.YOU);
        uiBean.setViewSoukinsakiInputDispFlg(false);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);

        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);

        siSetUiBean.setSk(uiBean, sk);

        String wkTensousakiId = sateiSyouninRireki.getTennousakisousasyacd();
        if(!BizUtil.isBlank(wkTensousakiId)){
            String wkTensousakiNm = "";
            AM_User userInfo = baseDomManager.getUser(wkTensousakiId);
            if (userInfo != null) {
                wkTensousakiNm = userInfo.getUserNm();
            }
            UsersByKinouIdKinouModeIdUserIdBean usersByKinouIdKinouModeIdUserIdBean =
                new UsersByKinouIdKinouModeIdUserIdBean(wkTensousakiId, wkTensousakiNm);
            List<UsersByKinouIdKinouModeIdUserIdBean> userLst = Arrays.asList(usersByKinouIdKinouModeIdUserIdBean);
            setTennousakisousasyacd(userLst);
        }
        SiSetUiBean.setSateiSyouninRireki(uiBean, sateiSyouninRireki, ttdkRireki);

        if (C_Kzdou.DOUITU.eq(sk.getKzdoukbn())) {

            uiBean.setKzmeiginmkn(sk.getKzmeiginmkn());
        }

        AS_Kinou kinous = baseDomManager.getKinou(TeisuuSiharai.SITTZKRIREKISYOUKAI);

        String sKinouNm = kinous.getKinouNm();

        uiBean.setKinouNm(sKinouNm);

        return FORWARDNAME_CONFIRM;
    }

    void pushUnlockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }

    void printOut() {

        String tyouhyoukey = uiBean.getTyouhyoukey();
        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        outputReport.outputPDFByJoinKey(tyouhyoukey);
    }


    private void keiyakuInfoSyutoku() {

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonLst.get(0)== null) {

            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
        }

        uiBean.setSiKykKihon(siKykKihonLst.get(0));
        uiBean.setSiKykSyouhn(siKykKihonLst.get(0).getSiKykSyouhns().get(0));
    }

    private void douituSyonoStyChk() {

        DouituSyonoStyChk douituSyonoStyChk = SWAKInjector.getInstance(DouituSyonoStyChk.class);

        C_Kouteikanristatus[] kouteikanristatus = {C_Kouteikanristatus.SYORITYUU};

        boolean douituSyonoStyChkResult = douituSyonoStyChk.exec(uiBean.getSyono(),
            TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU, kouteikanristatus);

        if (!douituSyonoStyChkResult) {

            throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1029));
        }
    }

    private void chkSubSksyaInfo(C_SeikyuusyaKbn pSeikyuusyaKbn, String pSeikyuusyanmkj, JT_SiKykKihon pSiKykKihon) {

        if (C_SeikyuusyaKbn.SONOTA.eq(pSeikyuusyaKbn) &&
            BizUtil.isBlank(pSeikyuusyanmkj)) {

            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(MessageId.IJW1028));
        }

        if (C_SeikyuusyaKbn.STDR.eq(pSeikyuusyaKbn) &&
            BizUtil.isBlank(pSiKykKihon.getSiteidruktnmkj())) {

            throw new BizLogicException(MessageId.EJA1031,
                MessageUtil.getMessage(DDID_SKJYOUHOU_SEIKYUUSYAKBN.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_SKJYOUHOU_SEIKYUUSYAKBN.getErrorResourceKey()));
        }

        if (C_SeikyuusyaKbn.SBUKT.eq(pSeikyuusyaKbn)) {

            String sbUktnmkn = "";
            int sbUktninsuu = 0;

            for (JT_SiUkt siUkt : uiBean.getSiKykKihon().getSiUkts()) {

                if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu()) ||
                    C_Hkuktsyu.SBKYFKUKT.eq(siUkt.getHkuktsyu())) {

                    if (!BizUtil.isBlank(siUkt.getUktnmkn())) {

                        sbUktnmkn = siUkt.getUktnmkn();
                        sbUktninsuu = sbUktninsuu + 1;
                    }
                }
            }
            if (BizUtil.isBlank(sbUktnmkn)) {

                throw new BizLogicException(MessageId.EJA1031,
                    MessageUtil.getMessage(DDID_SKJYOUHOU_SEIKYUUSYAKBN.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SKJYOUHOU_SEIKYUUSYAKBN.getErrorResourceKey()));
            }

            if (sbUktninsuu > 1) {

                throw new BizLogicException(MessageId.EJA1029, C_SeikyuusyaKbn.SONOTA.getContent());
            }

        }
    }

    private void setSkKihon(JT_SkKihon pSkKihon) {

        String sysDateTime = BizDate.getSysDateTimeMilli();

        pSkKihon.setSkno(uiBean.getSkno());
        pSkKihon.setSyono(uiBean.getSyono());
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SDSSHR);
        pSkKihon.setKyknmkj(uiBean.getSiKykKihon().getKyknmkj());
        pSkKihon.setKyknmkn(uiBean.getSiKykKihon().getKyknmkn());
        pSkKihon.setKykseiymd(uiBean.getSiKykKihon().getKykseiymd());
        pSkKihon.setKyksei(uiBean.getSiKykKihon().getKyksei());
        pSkKihon.setHhknnmkj(uiBean.getHhknnmkj());
        pSkKihon.setHhknnmkn(uiBean.getHhknnmkn());
        pSkKihon.setHhknseiymd(uiBean.getHhknseiymd());
        pSkKihon.setHhknsei(uiBean.getHhknsei());
        pSkKihon.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.SYORITYUU);
        if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
            pSkKihon.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        } else {
            pSkKihon.setShrkekkakbn(C_ShrKekkaKbn.BLNK);
        }
        if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) && C_KanryotuutioutKbn.GAIBU.eq(uiBean.getShrdtlsyooutkbn())) {
            pSkKihon.setGaibuinsatuoutymd(BizDate.getSysDate());
        }else{
            pSkKihon.setGaibuinsatuoutymd(null);
        }
        pSkKihon.setKossyoricd(kinou.getKinouId());
        pSkKihon.setKossyorisscd(kinouMode.getKinouMode());
        pSkKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pSkKihon.setGyoumuKousinTime(sysDateTime);
    }

    private void setTennousakisousasyacd(List<UsersByKinouIdKinouModeIdUserIdBean> pUserLst) {

        UserDefsList userDefsList = new UserDefsList();
        LabelValuePair labelValuePair = new LabelValuePair();

        labelValuePair.setLabel("");
        labelValuePair.setValue("");

        userDefsList.add(labelValuePair);

        if(pUserLst != null){
            for (UsersByKinouIdKinouModeIdUserIdBean user : pUserLst) {

                labelValuePair = new LabelValuePair();

                if(user.getSosikiNm() != null){
                    labelValuePair.setLabel(user.getSosikiNm().concat(
                        SiSindansyoryouSiharaiConstants.FULL_SPACE.concat(user.getUserNm())));
                    labelValuePair.setValue(user.getUserId());
                }
                else {
                    labelValuePair.setLabel(user.getUserNm());
                    labelValuePair.setValue(user.getUserId());
                }

                userDefsList.add(labelValuePair);
            }
        }
        uiBean.setTennousakisousasyacdOptionBeanList(userDefsList);
    }

    private void mrfkzTratkiChk(String pDrtencd) {

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        String pOyadrtencd = "";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(pDrtencd);

        if (bzGetAgInfoBeanList.size() != 0) {
            pOyadrtencd = bzGetAgInfoBeanList.get(0).getOyadrtenCd();
        }

        Boolean mrfkzTratkiChkResult = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(pOyadrtencd);

        if (mrfkzTratkiChkResult) {
            messageManager.addConversationMessageId(SiSindansyoryouSiharaiConstants.GROUP_WARNING_MESSAGE,
                MessageId.WBA1007);
        }
    }

}
