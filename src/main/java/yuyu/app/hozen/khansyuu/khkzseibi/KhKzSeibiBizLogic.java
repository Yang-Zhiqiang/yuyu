package yuyu.app.hozen.khansyuu.khkzseibi;
import static yuyu.app.hozen.khansyuu.khkzseibi.GenKhKzSeibiConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khkzseibi.dba.KhKzSeibiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetBankSitenNm;
import yuyu.common.hozen.khcommon.CheckKzhuriKouza;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 口座整備処理 のビジネスロジックです。
 */
public class KhKzSeibiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKzSeibiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhKzSeibiDao khKzSeibiDao;

    void init() {
    }

    void clear() {
    }


    void pushNyuuryokuBL () {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);


        IT_KykKihon kykKihon = khKzSeibiDao.getKykKihon(uiBean.getSyono());

        if (kykKihon == null ) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        if (!C_Hrkkeiro.KOUHURI.eq(uiBean.getKykKihon().getHrkkeiro())) {
            throw new BizLogicException(MessageId.EBA0091);
        }

        IT_Kouza kouza = khKzSeibiDao.getKouza(uiBean.getKykKihon());

        if (kouza == null) {
            throw new BizLogicException(MessageId.EIA0082);
        }

        checkJyoutai(khozenCommonParam);

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        SetKihon.exec(khozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(khozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {
            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    uiBean.getWarningMessageIdList().get(i), uiBean.getWarningMessageList().get(i));
            }
        }

        SetTetudukityuui.exec(khozenCommonParam, uiBean);

        SetKeiyakusya.exec(khozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(khozenCommonParam, uiBean);

        SetDattai.exec(khozenCommonParam, uiBean);

        String bankcd = kouza.getBankcd();
        String sitencd = kouza.getSitencd();

        GetBankSitenNm getBankSitenNm = SWAKInjector.getInstance(GetBankSitenNm.class);

        getBankSitenNm.exec(bankcd, sitencd);

        uiBean.setBfrbankcd(bankcd);
        uiBean.setBfrbanknmkj(getBankSitenNm.getBankNmKj());
        uiBean.setBfrsitencd(sitencd);
        uiBean.setBfrsitennmkj(getBankSitenNm.getSitenNmKj());
        uiBean.setBfryokinkbn(kouza.getYokinkbn());
        uiBean.setBfrkouzano12keta(kouza.getKouzano());
        uiBean.setBfrkzdoukbn(kouza.getKzkykdoukbn());
        uiBean.setBfrkzmeiginmkn(kouza.getKzmeiginmkn());

        uiBean.setNewbankcd("");
        uiBean.setNewsitencd("");
        uiBean.setNewyokinkbn(C_YokinKbn.BLNK);
        uiBean.setNewkouzano12("");
        uiBean.setNewkzdoukbn(C_KzkykdouKbn.BLNK);
        uiBean.setNewkzmeiginmkn("");
    }

    void pushKakuninBL() {

        if (BizUtil.isBlank(uiBean.getNewbankcd()) &&
            BizUtil.isBlank(uiBean.getNewsitencd()) &&
            C_YokinKbn.BLNK.eq(uiBean.getNewyokinkbn()) &&
            BizUtil.isBlank(uiBean.getNewkouzano12()) &&
            C_KzkykdouKbn.BLNK.eq(uiBean.getNewkzdoukbn()) &&
            BizUtil.isBlank(uiBean.getNewkzmeiginmkn())) {

            throw new BizLogicException(MessageId.EIA0047);
        }

        if (!BizUtil.isBlank(uiBean.getNewbankcd())) {
            if (uiBean.getNewbankcd().equals(uiBean.getBfrbankcd())) {
                throw new BizLogicException(
                    MessageId.EIA0044, MessageUtil.getMessage(DDID_NEWKOUZAINFO_NEWBANKCD.getErrorResourceKey()));
            }

            uiBean.setBankcd(uiBean.getNewbankcd());
        }
        else {
            uiBean.setBankcd(uiBean.getBfrbankcd());
        }

        if (!BizUtil.isBlank(uiBean.getNewsitencd())) {
            if (uiBean.getNewsitencd().equals(uiBean.getBfrsitencd())) {
                throw new BizLogicException(
                    MessageId.EIA0044, MessageUtil.getMessage(DDID_NEWKOUZAINFO_NEWSITENCD.getErrorResourceKey()));
            }

            uiBean.setSitencd(uiBean.getNewsitencd());
        }
        else {
            uiBean.setSitencd(uiBean.getBfrsitencd());
        }

        if (!C_YokinKbn.BLNK.eq(uiBean.getNewyokinkbn())) {
            if (uiBean.getNewyokinkbn().eq(uiBean.getBfryokinkbn())) {
                throw new BizLogicException(
                    MessageId.EIA0044, MessageUtil.getMessage(DDID_NEWKOUZAINFO_NEWYOKINKBN.getErrorResourceKey()));
            }

            uiBean.setYokinkbn(uiBean.getNewyokinkbn());
        }
        else {
            uiBean.setYokinkbn(uiBean.getBfryokinkbn());
        }

        if (!BizUtil.isBlank(uiBean.getNewkouzano12())) {
            if (uiBean.getNewkouzano12().equals(uiBean.getBfrkouzano12keta())) {
                throw new BizLogicException(
                    MessageId.EIA0044, MessageUtil.getMessage(DDID_NEWKOUZAINFO_NEWKOUZANO12.getErrorResourceKey()));
            }

            uiBean.setKouzano(uiBean.getNewkouzano12());
        }
        else {
            uiBean.setKouzano(uiBean.getBfrkouzano12keta());
        }

        if (!C_KzkykdouKbn.BLNK.eq(uiBean.getNewkzdoukbn())) {
            if (uiBean.getNewkzdoukbn().eq(uiBean.getBfrkzdoukbn())) {
                throw new BizLogicException(
                    MessageId.EIA0044, MessageUtil.getMessage(DDID_NEWKOUZAINFO_NEWKZDOUKBN.getErrorResourceKey()));
            }

            uiBean.setKzkykdoukbn(uiBean.getNewkzdoukbn());
        }
        else {
            uiBean.setKzkykdoukbn(uiBean.getBfrkzdoukbn());
        }

        if (!BizUtil.isBlank(uiBean.getNewkzmeiginmkn())) {
            if (uiBean.getNewkzmeiginmkn().equals(uiBean.getBfrkzmeiginmkn())) {
                throw new BizLogicException(
                    MessageId.EIA0044, MessageUtil.getMessage(DDID_NEWKOUZAINFO_NEWKZMEIGINMKN.getErrorResourceKey()));
            }

            uiBean.setKzmeiginmkn(uiBean.getNewkzmeiginmkn());
        }
        else {
            if (C_KzkykdouKbn.DOUITU.eq(uiBean.getKzkykdoukbn())) {
                uiBean.setKzmeiginmkn("");
            }
            else {
                uiBean.setKzmeiginmkn(uiBean.getBfrkzmeiginmkn());
            }
        }

        CheckKzhuriKouza checkKzhuriKouza = SWAKInjector.getInstance(CheckKzhuriKouza.class);
        checkKzhuriKouza.exec(uiBean);

        uiBean.setNewbankcd(uiBean.getBankcd());
        uiBean.setNewsitencd(uiBean.getSitencd());
        uiBean.setNewyokinkbn(uiBean.getYokinkbn());
        uiBean.setNewkouzano12(uiBean.getKouzano());
        uiBean.setNewkzdoukbn(uiBean.getKzkykdoukbn());
        uiBean.setNewkzmeiginmkn(uiBean.getKzmeiginmkn());

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);


        uiBean.getKykKihon().setSyhenkouymd(sysDate);
        uiBean.getKykKihon().setGyoumuKousinKinou(kinou.getKinouId());
        uiBean.getKykKihon().setGyoumuKousinsyaId(baseUserInfo.getUserId());
        uiBean.getKykKihon().setGyoumuKousinTime(sysDateTimeMilli);

        IT_KhTtdkRireki khTtdkRireki = khKzSeibiDao.createKhTtdkRireki(uiBean.getKykKihon());
        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        IT_Kouza kouza = khKzSeibiDao.getKouza(uiBean.getKykKihon());

        kouza.setBankcd(uiBean.getBankcd());
        kouza.setSitencd(uiBean.getSitencd());
        kouza.setYokinkbn(uiBean.getYokinkbn());
        kouza.setKouzano(uiBean.getKouzano());
        kouza.setKzmeiginmkn(uiBean.getKzmeiginmkn());

        if (!uiBean.getBfrbankcd().equals(uiBean.getBankcd())) {
            kouza.setSinkeizkkbn(C_SinkeizkKbn.SHINKI);
        }
        else if (!uiBean.getBfrsitencd().equals(uiBean.getSitencd())
            || !uiBean.getBfryokinkbn().eq(uiBean.getYokinkbn())
            || !uiBean.getBfrkouzano12keta().equals(uiBean.getKouzano())) {
            kouza.setSinkeizkkbn(C_SinkeizkKbn.HENKOU);
        }
        kouza.setKzkykdoukbn(uiBean.getKzkykdoukbn());
        kouza.setGyoumuKousinKinou(kinou.getKinouId());
        kouza.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kouza.setGyoumuKousinTime(sysDateTimeMilli);

        PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
        pALKykNaiyouKousin.exec(uiBean.getKykKihon());


        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSysTime(sysDateTimeMilli);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        khKzSeibiDao.update(uiBean.getKykKihon());

        messageManager.addMessageId(MessageId.IAC0009);
    }


    private void checkJyoutai (KhozenCommonParam pKhozenCommonParam) {

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
}
