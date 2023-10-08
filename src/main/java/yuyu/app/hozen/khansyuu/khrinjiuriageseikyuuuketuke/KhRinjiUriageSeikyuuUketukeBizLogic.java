package yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke;

import static yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke.GenKhRinjiUriageSeikyuuUketukeConstants.*;
import static yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke.KhRinjiUriageSeikyuuUketukeConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke.dba.KhRinjiUriageSeikyuuUketukeDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CreditUriageSeikyuuDataSks;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.UriageSeikyuuDataSksParam;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_UriageSeikyuuData;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 臨時売上請求受付 のビジネスロジックです。
 */
public class KhRinjiUriageSeikyuuUketukeBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhRinjiUriageSeikyuuUketukeUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private ErrorMessageCollector errMessages;

    @Inject
    private KhRinjiUriageSeikyuuUketukeDao khRinjiUriageSeikyuuUketukeDao;

    void init() {
    }

    void clear() {
    }

    void puhsNyuuryokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkKykSonzai();

        if (!C_Hrkkeiro.CREDIT.eq(uiBean.getKykKihon().getHrkkeiro())) {
            throw new BizLogicException(MessageId.EBA0091);
        }

        IT_CreditCardInfo creditCardInfo = uiBean.getKykKihon().getCreditCardInfo();

        if (creditCardInfo == null) {
            throw new BizLogicException(MessageId.EIF3072);
        }

        if (BizUtil.isBlank(creditCardInfo.getCreditkessaiyouno())) {
            throw new BizLogicException(MessageId.EIF3072);
        }

        checkYuukouJyoutai(khozenCommonParam);

        checkTetudukiTyuui(khozenCommonParam);

        setUiBean(khozenCommonParam);

        uiBean.setNyknaiyoukbn(C_NyknaiyouKbn.OTHER);
        uiBean.setUriageymd(BizDate.getSysDate().addBusinessDays(2));
        uiBean.setRinjiuriageskkngk(BizCurrency.optional());
    }

    void pushKakuninBL() {
        uiBean.setNyknaiyoukbnSyoriyou(uiBean.getNyknaiyoukbn());
        uiBean.setUriageymdSyoriyou(uiBean.getUriageymd());
        uiBean.setRinjiuriageskkngkSyoriyou(uiBean.getRinjiuriageskkngk());

        if (BizUtil.isZero(uiBean.getRinjiuriageskkngkSyoriyou())) {
            errMessages.addMessage(MessageId.EAV0019, DDID_SEIKYUUNAIYOUINFO_RINJIURIAGESKKNGK);
        }

        if (errMessages.exists()) {
            throw new BizLogicException(errMessages);
        }

        if (BizCurrencyTypes.YEN.equals(uiBean.getRinjiuriageskkngkSyoriyou().getType())) {
            if (uiBean.getRinjiuriageskkngkSyoriyou().compareTo(YEN_NYKN_MAX_GK) >= 0)  {
                throw new BizLogicException(MessageId.EIF3058);
            }
        }

        IT_UriageSeikyuuData uriageSeikyuuData = khRinjiUriageSeikyuuUketukeDao.getUriageSeikyuuData(
            uiBean.getSyono(), uiBean.getVhrkicreditkessaiyouno(), uiBean.getUriageymdSyoriyou());

        if (uriageSeikyuuData != null) {
            throw new BizLogicException(MessageId.EIF3059);
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        kykKihon.setSyhenkouymd(sysDate);
        kykKihon.setGyoumuKousinKinou(functionId);
        kykKihon.setGyoumuKousinsyaId(userId);
        kykKihon.setGyoumuKousinTime(sysTime);

        IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        hozenDomManager.update(kykKihon);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());

        CreditUriageSeikyuuDataSks uriageSeikyuuDataSks = SWAKInjector.getInstance(CreditUriageSeikyuuDataSks.class);
        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);

        uriageSeikyuuDataSksParam.setKessaiyouno(uiBean.getVhrkicreditkessaiyouno());
        uriageSeikyuuDataSksParam.setUriagenengappi(uiBean.getUriageymd());
        uriageSeikyuuDataSksParam.setNyknaiyoukbn(uiBean.getNyknaiyoukbn());
        uriageSeikyuuDataSksParam.setSyoriYmd(sysDate);
        uriageSeikyuuDataSksParam.setUriagegk(uiBean.getRinjiuriageskkngk());
        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(ansyuKihon);

        uriageSeikyuuDataSks.editRinjiUriageData(khozenCommonParam, uriageSeikyuuDataSksParam);

        hozenDomManager.update(ansyuKihon);

        makeTetudukiRireki(khozenCommonParam, sysTime, sysDate);

        messageManager.addMessageId(MessageId.IAC0009);
    }


    private void checkKykSonzai() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);
    }

    private void checkYuukouJyoutai(KhozenCommonParam pKhozenCommonParam) {
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            if (checkYuukouJyoutai.getWarningMessageIDList().size() != 0) {
                for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                    String messageID = BizUtil.getGeneralMessageId(checkYuukouJyoutai.getWarningMessageIDList().get(i));
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                        messageID, checkYuukouJyoutai.getWarningMessageList().get(i));
                }
            }
        }
    }

    private void checkTetudukiTyuui(KhozenCommonParam pKhozenCommonParam) {
        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);

        for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                BizUtil.getGeneralMessageId(
                    uiBean.getWarningMessageIdList().get(i)), uiBean.getWarningMessageList().get(i));
        }

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(pKhozenCommonParam, uiBean);
    }

    private void makeTetudukiRireki(KhozenCommonParam pKhozenCommonParam, String pSysTime, BizDate pSysDate) {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(pSysDate);
        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.NONE);
        editTtdkRirekiTblParam.setSysTime(pSysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }
}
