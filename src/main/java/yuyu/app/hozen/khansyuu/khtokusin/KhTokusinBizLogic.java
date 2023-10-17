package yuyu.app.hozen.khansyuu.khtokusin;

import static yuyu.app.hozen.khansyuu.khtokusin.GenKhTokusinConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khtokusin.KhTokusinConstants.E_SyoriKbn;
import yuyu.app.hozen.khansyuu.khtokusin.dba.KhTokusinDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiData;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiDataBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 特伸処理 のビジネスロジックです。
 */
public class KhTokusinBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhTokusinUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KhTokusinDao khTokusinDao;

    @Inject
    private InputContentsCopyBean inputContentsCopyBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    void init() {
    }

    void clear() {
    }

    void pushInputBL() {

        inputOrToRikesiBL(E_SyoriKbn.NYUURYOKU);

        uiBean.setGmsyorikbn(E_SyoriKbn.NYUURYOKU);
    }

    void pushTorikesiBL() {
        inputOrToRikesiBL(E_SyoriKbn.TORIKESI);

        uiBean.setGmsyorikbn(E_SyoriKbn.TORIKESI);

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushKakuninBL() {

        BizUiBeanBackupUtil.backup(uiBean, inputContentsCopyBean);

        String syono = uiBean.getSyono();

        BizDate tokusinendymd = null;
        BizDate sysDate = BizDate.getSysDate();
        BizDate hsgymd = uiBean.getHsgymd();

        BizDateYM jkipjytym = uiBean.getAnsyuKihon().getJkipjytym();

        if (C_TokusinKbn.HISAIGAI.eq(uiBean.getTokusinkbn())) {
            if (hsgymd == null) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_TOKUSINSYORINYUURYOKUINFO_HSGYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(hsgymd, sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBF0124,
                    MessageUtil.getMessage(DDID_TOKUSINSYORINYUURYOKUINFO_HSGYMD.getErrorResourceKey()));
            }

            if (uiBean.getTokusinendym() != null) {

                BzGetSousasyaSyozokuSosikiData bzGetSousasyaSyozokuSosikiData = SWAKInjector.getInstance(
                    BzGetSousasyaSyozokuSosikiData.class);

                BzGetSousasyaSyozokuSosikiDataBean bzGetSousasyaSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData
                    .exec(baseUserInfo.getUserId());

                if (!(C_Tantositucd.SYUUNOUSV.getValue().concat("0000")).equals(
                    bzGetSousasyaSyozokuSosikiDataBean.getSosikicd())) {

                    if (BizDateUtil.compareYm(jkipjytym, hsgymd.getBizDateYM()) == BizDateUtil.COMPARE_GREATER) {

                        if (BizDateUtil.compareYm(uiBean.getTokusinendym(),
                            hsgymd.getBizDateYM().addMonths(6)) == BizDateUtil.COMPARE_GREATER) {

                            throw new BizLogicException(MessageId.EIF3039,
                                MessageUtil.getMessage(DDID_TOKUSINSYORINYUURYOKUINFO_HSGYMD.getErrorResourceKey()),
                                "６ヵ月",
                                MessageUtil.getMessage(DDID_TOKUSINSYORINYUURYOKUINFO_TOKUSINENDYM.getErrorResourceKey()));
                        }
                    }
                    else {
                        if (BizDateUtil.compareYm(
                            uiBean.getTokusinendym(),jkipjytym.addMonths(6)) == BizDateUtil.COMPARE_GREATER) {

                            throw new BizLogicException(MessageId.EIF3039, "次回Ｐ充当年月", "６ヵ月",
                                MessageUtil.getMessage(DDID_TOKUSINSYORINYUURYOKUINFO_TOKUSINENDYM.getErrorResourceKey()));
                        }
                    }
                }

                tokusinendymd = uiBean.getTokusinendym().getLastDay().getBusinessDay(CHolidayAdjustingMode.NEXT);
            }
            else {

                if (BizDateUtil.compareYm(jkipjytym, hsgymd.getBizDateYM()) == BizDateUtil.COMPARE_GREATER) {

                    tokusinendymd = hsgymd.getBizDateYM().addMonths(6).getLastDay().getBusinessDay(CHolidayAdjustingMode.NEXT);
                }
                else {

                    tokusinendymd = jkipjytym.addMonths(6).getLastDay().getBusinessDay(CHolidayAdjustingMode.NEXT);
                }
            }
        }
        else if (C_TokusinKbn.OTHER.eq(uiBean.getTokusinkbn())) {
            if (uiBean.getTokusinendymd() == null) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_TOKUSINSYORINYUURYOKUINFO_TOKUSINENDYMD.getErrorResourceKey()));
            }

            tokusinendymd = uiBean.getTokusinendymd().getBusinessDay(CHolidayAdjustingMode.NEXT);
            BizDate sysDateLastDay = sysDate.getBizDateYM().addMonths(1).getLastDay().getBusinessDay(CHolidayAdjustingMode.NEXT);

            if (BizDateUtil.compareYmd(tokusinendymd, sysDateLastDay) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIF3039, "本日", "翌月末日（休日の場合は翌営業日）",
                    MessageUtil.getMessage(DDID_TOKUSINSYORINYUURYOKUINFO_TOKUSINENDYMD.getErrorResourceKey()));
            }

        }

        SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
        setYuuyokknmanryobi.exec(syono, jkipjytym);

        BizDate yuuyokknMnrybi = setYuuyokknmanryobi.getYuuyokknMnrybi();

        if (BizDateUtil.compareYmd(tokusinendymd, yuuyokknMnrybi) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(tokusinendymd, yuuyokknMnrybi) == BizDateUtil.COMPARE_EQUAL) {
            throw new BizLogicException(MessageId.EIA0094);
        }

        uiBean.setTokusinendymd(tokusinendymd);

        messageManager.addMessageId(MessageId.QBA0001);
    }

    String pushModoruBtnByConfirmBL() {

        String path = "";
        if (E_SyoriKbn.TORIKESI.equals(uiBean.getGmsyorikbn())) {
            messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING1);
            path = FORWARDNAME_INIT;
        }
        else if(E_SyoriKbn.NYUURYOKU.equals(uiBean.getGmsyorikbn())) {
            BizUiBeanBackupUtil.restore(uiBean, inputContentsCopyBean);
            path = FORWARDNAME_INPUTCONTENTS;
        }

        return path;
    }

    @Transactional
    void pushKakuteiBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String syono = uiBean.getSyono();

        String sikibetuKey = khozenCommonParam.getSikibetuKey(syono);

        String sysTime = BizDate.getSysDateTimeMilli();

        BizDate sysDate = BizDate.getSysDate();

        String functionId = khozenCommonParam.getFunctionId();

        String userID = khozenCommonParam.getUserID();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        tableMaintenanceUtil.backUp(syono, sikibetuKey);

        IT_KykKihon kykKion = uiBean.getKykKihon();

        kykKion.setSyhenkouymd(sysDate);
        kykKion.setGyoumuKousinKinou(functionId);
        kykKion.setGyoumuKousinsyaId(userID);
        kykKion.setGyoumuKousinTime(sysTime);

        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        IT_AnsyuKihon ansyuKihon = uiBean.getAnsyuKihon();
        if (E_SyoriKbn.TORIKESI.equals(uiBean.getGmsyorikbn())) {
            khTokusinDao.setTokusin(ansyuKihon,null);

            syoriKbn = C_SyoriKbn.TORIKESI;
        }
        else {
            IT_Tokusin tokusin = khTokusinDao.getTokusin(ansyuKihon);

            if (tokusin == null) {
                tokusin = khTokusinDao.createTokusin(ansyuKihon);
            }

            tokusin.setTokusinkbn(uiBean.getTokusinkbn());
            tokusin.setTokusinsyoriymd(sysDate);
            tokusin.setTokusinendymd(uiBean.getTokusinendymd());
            tokusin.setHsgymd(uiBean.getHsgymd());
            tokusin.setGyoumuKousinKinou(functionId);
            tokusin.setGyoumuKousinsyaId(userID);
            tokusin.setGyoumuKousinTime(sysTime);

            BizPropertyInitializer.initialize(tokusin);

            syoriKbn = C_SyoriKbn.NYUURYOKU;
        }


        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        IT_KhTtdkRireki khTtdkRireki = khTokusinDao.createKhTtdkRireki(uiBean.getKykKihon());
        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(syono);
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
        editTtdkRirekiTblParam.setSysTime(sysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        if (E_SyoriKbn.NYUURYOKU.equals(uiBean.getGmsyorikbn()) &&
            C_TokusinKbn.HISAIGAI.eq(uiBean.getTokusinkbn())) {
            List<IT_YykIdouUktk> yykIdouUktkLst = khTokusinDao.getYykIdouUktks(syono);

            if (yykIdouUktkLst.size() > 0) {

                IT_YykIdouUktk yykIdouUktk = yykIdouUktkLst.get(0);

                List<String> jimuRenrakuhyouList = Lists.newArrayList();

                String kinouNm = khTokusinDao.getKinouNm(yykIdouUktk.getKinouId());

                jimuRenrakuhyouList.add("予約異動受付中の契約です。");
                jimuRenrakuhyouList.add("");
                jimuRenrakuhyouList.add("予約異動名／" + kinouNm);
                jimuRenrakuhyouList.add("");
                jimuRenrakuhyouList.add("予約異動受付日　：" + DefaultDateFormatter.formatYMDKanji(yykIdouUktk.getUktkymd()));
                jimuRenrakuhyouList.add("編入年月　　　　："
                    + DefaultDateFormatter.formatYMKanji(yykIdouUktk.getSyoriym().toString()));

                EditJimuRenrakusyuunouParam jimuParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
                EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);

                jimuParam.setJimurenrakuMsgList(jimuRenrakuhyouList);

                ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(
                    khozenCommonParam, syono, C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU, jimuParam, sysDate);

                CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

                String tyouhyouJoinKey = createReport.execNoCommit(reportServicesBean);

                uiBean.setTyouhyouKey(tyouhyouJoinKey);
            }
        }

        khTokusinDao.update(kykKion);

        khTokusinDao.update(ansyuKihon);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void printOut() {
        String tyhykey = uiBean.getTyouhyouKey();
        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);
        outputReport.outputPDFByJoinKey(tyhykey);
    }

    private void inputOrToRikesiBL(E_SyoriKbn pSyoriKbn) {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        String syono = uiBean.getSyono();

        IT_KykKihon kykKihon = khTokusinDao.getKykKihon(syono);

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        IT_AnsyuKihon ansyuKihon = khTokusinDao.getAnsyuKihon(syono);

        if (ansyuKihon == null) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA0089));
        }

        uiBean.setAnsyuKihon(ansyuKihon);

        IT_Tokusin tokusin = khTokusinDao.getTokusin(ansyuKihon);

        if (E_SyoriKbn.NYUURYOKU.equals(pSyoriKbn)) {
            if (tokusin != null) {
                uiBean.setBfrtokusinkbn(tokusin.getTokusinkbn());
                uiBean.setBfrhsgymd(tokusin.getHsgymd());
                uiBean.setBfrtokusinsyoriymd(tokusin.getTokusinsyoriymd());
                uiBean.setBfrtokusinendymd(tokusin.getTokusinendymd());

                uiBean.setOldTokusinInfoUmu(C_UmuKbn.ARI);
            }
        }
        else {
            if (tokusin == null) {
                throw new BizLogicException(MessageId.EIF3038);
            }

            uiBean.setBfrtokusinkbn(tokusin.getTokusinkbn());
            uiBean.setBfrhsgymd(tokusin.getHsgymd());
            uiBean.setBfrtokusinsyoriymd(tokusin.getTokusinsyoriymd());
            uiBean.setBfrtokusinendymd(tokusin.getTokusinendymd());
            uiBean.setOldTokusinInfoUmu(C_UmuKbn.ARI);
        }

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syono);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            List<String> warningMessageIdList = checkYuukouJyoutai.getWarningMessageIDList();
            List<String> warningMessageList = checkYuukouJyoutai.getWarningMessageList();

            for (int i = 0; i < warningMessageIdList.size(); i++) {
                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    BizUtil.getGeneralMessageId(warningMessageIdList.get(i)), warningMessageList.get(i));
            }
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }

        setUiBean(khozenCommonParam);
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);
        SetKihon.exec(pKhozenCommonParam, uiBean);
        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);
        for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                BizUtil.getGeneralMessageId(uiBean.getWarningMessageIdList().get(i)), uiBean.getWarningMessageList()
                .get(i));
        }
        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);
        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(pKhozenCommonParam, uiBean);

        SetDattai.exec(pKhozenCommonParam, uiBean);
    }
}
