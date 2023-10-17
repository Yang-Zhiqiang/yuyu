package yuyu.app.hozen.khansyuu.khonlinedattai;
import static yuyu.app.hozen.khansyuu.khonlinedattai.GenKhOnlineDattaiConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khonlinedattai.KhOnlineDattaiConstants.E_SyoriKbn;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiData;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiDataBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * オンライン脱退処理 のビジネスロジックです。
 */
public class KhOnlineDattaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhOnlineDattaiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private BizDate sysDate;

    private String sysTime;

    private String functionId;

    private String userID;

    void init() {
        clear();
    }

    void clear() {
    }

    void pushSetteiBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        chkSetUiBean(E_SyoriKbn.SETTEI);
    }

    void pushTorikesiBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        chkSetUiBean(E_SyoriKbn.TORIKESI);

        setMsgContents();
    }

    @Transactional
    void pushKakuteiBL() {

        String syono = uiBean.getSyono();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String sikibetuKey = khozenCommonParam.getSikibetuKey(syono);

        sysTime = BizDate.getSysDateTimeMilli();

        sysDate = BizDate.getSysDate();

        functionId= khozenCommonParam.getFunctionId();

        userID = khozenCommonParam.getUserID();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

        IT_AnsyuKihon ansyuKihon = uiBean.getAnsyuKihon();

        C_SyoriKbn syoriKbn = null;

        C_YouhiKbn youhiKbn = null;

        if (E_SyoriKbn.TORIKESI.equals(uiBean.getSyorikbn())) {

            ansyuKihon.setDattaiUktk(null);

            syoriKbn = C_SyoriKbn.DATTAIKAISYOU;

            youhiKbn = C_YouhiKbn.YOU;
        }
        else {

            addDattaiUktk(ansyuKihon);

            syoriKbn = C_SyoriKbn.DATTAIUKE;

            youhiKbn = C_YouhiKbn.HUYOU;
        }

        IT_KykKihon kykKion = uiBean.getKykKihon();

        kykKion.setSyhenkouymd(sysDate);
        kykKion.setGyoumuKousinKinou(functionId);
        kykKion.setGyoumuKousinsyaId(userID);
        kykKion.setGyoumuKousinTime(sysTime);


        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        IT_KhTtdkRireki khTtdkRireki = kykKion.createKhTtdkRireki();

        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(syono);
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
        editTtdkRirekiTblParam.setSysTime(sysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(youhiKbn);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        hozenDomManager.update(kykKion);

        hozenDomManager.update(ansyuKihon);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    String getForwardName() {

        String forwadName = null;

        E_SyoriKbn syoriKbn = uiBean.getSyorikbn();

        if  (E_SyoriKbn.SETTEI.equals(syoriKbn)){

            forwadName = FORWARDNAME_INPUTCONTENTS;
        }
        else {

            forwadName = FORWARDNAME_INIT;
        }

        return forwadName;
    }

    void setMsgContents() {

        messageManager.addMessageId(MessageId.QBA0001);

        sysDate = BizDate.getSysDate();

        if (E_SyoriKbn.SETTEI.equals(uiBean.getSyorikbn())) {

            uiBean.setSyoriYmd(sysDate);
        }
        else if (E_SyoriKbn.TORIKESI.equals(uiBean.getSyorikbn())) {

            uiBean.setSyoriYmd(uiBean.getDattaiuktkSyoriYmd());
        }
    }

    void pushKakuninBtnBL() {
        if (!C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro()) &&
            C_DattairiyuuKbn.CSSKOUHURIIRHUBI.eq(uiBean.getDattairiyuukbn())) {
            throw new BizLogicException(MessageId.EIF3055,
                uiBean.getVhrkihrkkeiro().getContent(),uiBean.getDattairiyuukbn().getContent());
        }
    }

    private void chkSetUiBean(E_SyoriKbn pSyoriKbn) {

        String syono = uiBean.getSyono();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        if (kykKihon == null) {

            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);

        if (ansyuKihon == null) {

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA0089));
        }

        uiBean.setAnsyuKihon(ansyuKihon);

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            List<String> warningMessageIdList = checkYuukouJyoutai.getWarningMessageIDList();
            List<String> warningMessageList = checkYuukouJyoutai.getWarningMessageList();

            for (int i = 0; i<warningMessageIdList.size(); i++) {
                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    BizUtil.getGeneralMessageId(warningMessageIdList.get(i)), warningMessageList.get(i));
            }
        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syono);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }
        IT_DattaiUktk dattaiUktk = ansyuKihon.getDattaiUktk();

        if  (E_SyoriKbn.SETTEI.equals(pSyoriKbn)){

            if (dattaiUktk != null) {

                throw new BizLogicException(MessageId.EIA0087);
            }
        }
        else {

            if (dattaiUktk == null) {

                throw new BizLogicException(MessageId.EIA0088);
            }

            uiBean.setDattairiyuukbn(dattaiUktk.getDattairiyuukbn());
            uiBean.setCommentgamen(dattaiUktk.getComment124keta());
            uiBean.setDattaiuktkSyoriYmd(dattaiUktk.getSyoriYmd());

        }

        setUiBean(khozenCommonParam);

        uiBean.setSyorikbn(pSyoriKbn);
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);
        SetKihon.exec(pKhozenCommonParam, uiBean);
        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);
        for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                uiBean.getWarningMessageIdList().get(i), uiBean.getWarningMessageList().get(i));
        }
        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);
        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetTokusin.exec(pKhozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(pKhozenCommonParam, uiBean);

        SetDattai.exec(pKhozenCommonParam, uiBean);
    }

    private void addDattaiUktk(IT_AnsyuKihon pAnsyuKihon) {

        BzGetSousasyaSyozokuSosikiData bzGetSousasyaSyozokuSosikiData = SWAKInjector.getInstance(
            BzGetSousasyaSyozokuSosikiData.class);

        BzGetSousasyaSyozokuSosikiDataBean bzGetSousasyaSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(
            baseUserInfo.getUserId());

        IT_DattaiUktk dattaiUktk = pAnsyuKihon.createDattaiUktk();

        dattaiUktk.setSyoriYmd(sysDate);
        dattaiUktk.setSyorisosikicd(bzGetSousasyaSyozokuSosikiDataBean.getSosikicd());
        dattaiUktk.setDattaikeiro(C_Dattaikeiro.ONLINE);
        dattaiUktk.setDattairiyuukbn(uiBean.getDattairiyuukbn());
        dattaiUktk.setDattaiym(sysDate.getBizDateYM());
        dattaiUktk.setJkipjytym(pAnsyuKihon.getJkipjytym());
        dattaiUktk.setComment124keta(uiBean.getCommentgamen());
        dattaiUktk.setGyoumuKousinKinou(functionId);
        dattaiUktk.setGyoumuKousinsyaId(userID);
        dattaiUktk.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(dattaiUktk);
    }
}
