package yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk;

import static yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk.GenKhMkhgkTttYendtHnkUktkConstants.*;
import static yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk.KhMkhgkTttYendtHnkUktkConstants.*;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk.dba.KhMkhgkTttYendtHnkUktkDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.haitou.CheckDShrYendtHnkuketuke;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KeisanYendtHnkS;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHosyou;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetSonotaTk;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 目標額到達時円建変更受付 のビジネスロジックです。
 */
public class KhMkhgkTttYendtHnkUktkBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhMkhgkTttYendtHnkUktkUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhMkhgkTttYendtHnkUktkDao khMkhgkTttYendtHnkUktkDao;

    @Inject
    private MessageManager messageManager;

    void init() {
    }

    void clear() {
    }

    void pushSyoukaiBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        uiBean.setDispsyoukaiymdfrom(uiBean.getSyoukaiymdfrom());

        BizDate sysDate = BizDate.getSysDate();

        if (uiBean.getSyoukaiymdto() == null) {

            uiBean.setDispsyoukaiymdto(sysDate.addBusinessDays(-1));
        }
        else {

            uiBean.setDispsyoukaiymdto(uiBean.getSyoukaiymdto());
        }

        if (BizDateUtil.compareYmd(sysDate, uiBean.getDispsyoukaiymdfrom()) == BizDateUtil.COMPARE_EQUAL
            || BizDateUtil.compareYmd(sysDate, uiBean.getDispsyoukaiymdfrom()) == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(
                MessageId.EIA0037,
                MessageUtil.getMessage(DDID_SEARCHCONDITIONS_SYOUKAIYMDFROM.getErrorResourceKey()));
        }

        if (BizDateUtil.compareYmd(sysDate, uiBean.getDispsyoukaiymdto()) == BizDateUtil.COMPARE_EQUAL
            || BizDateUtil.compareYmd(sysDate, uiBean.getDispsyoukaiymdto()) == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(
                MessageId.EIA0037,
                MessageUtil.getMessage(DDID_SEARCHCONDITIONS_SYOUKAIYMDTO.getErrorResourceKey()));
        }

        if (BizDateUtil.compareYmd(
            uiBean.getDispsyoukaiymdto(), uiBean.getDispsyoukaiymdfrom()) == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(
                MessageId.EBA1029,
                MessageUtil.getMessage(DDID_SEARCHCONDITIONS_SYOUKAIYMDFROM.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_SEARCHCONDITIONS_SYOUKAIYMDTO.getErrorResourceKey()));
        }

        checkExist();

        IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

        IT_KykSyouhn kykSyouhn = uiBean.getKykKihon().getKykSyouhns().get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        C_TargetTkHukaKanouKbn targettkhukakanoukbn = checkTargettkhukakanou(syouhnZokusei);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkJyoutai(khozenCommonParam);

        checkTtdkTyuui(khozenCommonParam);

        checkTargettkhk(kykSonotaTkyk, targettkhukakanoukbn);

        checkSyoukaiymd(kykSyouhn, syouhnZokusei);

        checkKouryokuhasseiymd(kykSyouhn);

        checkMkhgkttt(kykSyouhn, syouhnZokusei, kykSonotaTkyk);

        CheckDShrYendtHnkuketuke checkDShrYendtHnkuketuke = SWAKInjector.getInstance(CheckDShrYendtHnkuketuke.class);

        C_ErrorKbn errorKbn = checkDShrYendtHnkuketuke.checkDShr(uiBean.getSyono(), uiBean.getMkhgktttymd(), sysDate);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
        }

        C_SyorikahiKbn syorikahiKbn = checkDShrYendtHnkuketuke.getSyorikahiKbn();

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            C_UmuKbn dHuseigouUmu = checkDShrYendtHnkuketuke.getDHuseigouUmu();
            C_UmuKbn dHaneiYmdUmu = checkDShrYendtHnkuketuke.getDHaneiYmdUmu();
            C_UmuKbn dShrYmdUmu = checkDShrYendtHnkuketuke.getDShrYmdUmu();

            if (C_UmuKbn.ARI.eq(dHuseigouUmu)) {
                throw new BizLogicException(MessageId.EBS1012);
            }

            if (C_UmuKbn.ARI.eq(dHaneiYmdUmu)) {
                throw new BizLogicException(MessageId.EIF1095);
            }

            if (C_UmuKbn.ARI.eq(dShrYmdUmu)) {
                throw new BizLogicException(MessageId.EIF1096);
            }
        }

        setUiBean(khozenCommonParam, checkDShrYendtHnkuketuke.getMihaneiDUmu(), syorikahiKbn);
    }

    void pushKakuninBL() {

        if (C_UmuKbn.ARI.eq(uiBean.getNensbhnkumu()) &&
            BizDateUtil.compareYmd(uiBean.getMkhgktttymd(), uiBean.getNenseihnkymd()) == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(MessageId.EBA1029,
                KINOUNM_SEINENGAPPISEI,
                MessageUtil.getMessage(MessageId.IIW1002));
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String kinouId = khozenCommonParam.getFunctionId();

        String userId = khozenCommonParam.getUserID();

        BizDate sysDate = BizDate.getSysDate();

        String sysTime = BizDate.getSysDateTimeMilli();

        String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        kykKihon.setSyhenkouymd(sysDate);

        kykKihon.setGyoumuKousinKinou(kinouId);

        kykKihon.setGyoumuKousinsyaId(userId);

        kykKihon.setGyoumuKousinTime(sysTime);

        String hozenHenkouUktkrenNo = SaibanBiz.getHozenHenkouUktkrenNo(uiBean.getSyono());

        IT_KhHenkouUktk khHenkouUktk = new IT_KhHenkouUktk(uiBean.getSyono(), Integer.parseInt(hozenHenkouUktkrenNo));

        khHenkouUktk.setUktkymd(sysDate);

        khHenkouUktk.setTourokuroute(C_TourokuRouteKbn.ONLINE);

        khHenkouUktk.setUktksyorikbn(C_UktkSyoriKbn.MKHGKTTTYENDTHNK);

        khHenkouUktk.setKouryokuhasseiymd(uiBean.getYendthnkymd());

        khHenkouUktk.setSyoriyoteiymd(sysDate);

        khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);

        khHenkouUktk.setGyoumuKousinKinou(kinouId);

        khHenkouUktk.setGyoumuKousinsyaId(userId);

        khHenkouUktk.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(khHenkouUktk);

        IT_KhHenkouUktkYendtHnk khHenkouUktkYendtHnk = khHenkouUktk.createKhHenkouUktkYendtHnk();

        khHenkouUktkYendtHnk.setYendthnkymd(uiBean.getYendthnkymd());

        khHenkouUktkYendtHnk.setMkhgktttymd(uiBean.getMkhgktttymd());

        khHenkouUktkYendtHnk.setMkhgktttkaiyakuhr(uiBean.getMkhgktttkaiyakuhr());

        khHenkouUktkYendtHnk.setNewkaiyakuhr(uiBean.getYendthnkkaiyakuhrgk());

        khHenkouUktkYendtHnk.setYendthnkhr(uiBean.getYendthnkhrgk());

        khHenkouUktkYendtHnk.setNyuuryokuhassoukbn(uiBean.getHassoukbn());

        khHenkouUktkYendtHnk.setYendthnkkaiyakuhrgaika(uiBean.getYendthnkkaiyakuhrgaika());

        khHenkouUktkYendtHnk.setYendthnkkaiyakuhryen(uiBean.getYendthnkkaiyakuhryen());

        khHenkouUktkYendtHnk.setYendthnkjikwsrate(uiBean.getKawaserate());

        khHenkouUktkYendtHnk.setNewsyouhncd(uiBean.getYendtgosyouhncd());

        khHenkouUktkYendtHnk.setNewsyouhnsdno(uiBean.getYendtgosyouhnsdno());

        khHenkouUktkYendtHnk.setYendthnkkihons(uiBean.getYendthnksbhokenkngk());

        khHenkouUktkYendtHnk.setNewhokenryou(BizCurrency.valueOf(0));

        khHenkouUktkYendtHnk.setNewkyktuukasyu(C_Tuukasyu.JPY);

        khHenkouUktkYendtHnk.setNewryouritusdno(uiBean.getYendtgoryouritusdno());

        khHenkouUktkYendtHnk.setGyoumuKousinKinou(kinouId);

        khHenkouUktkYendtHnk.setGyoumuKousinsyaId(userId);

        khHenkouUktkYendtHnk.setGyoumuKousinTime(sysTime);

        khHenkouUktkYendtHnk.setNewtumitateriritu(uiBean.getTumitateriritu());

        khHenkouUktkYendtHnk.setNewyoteiriritu(uiBean.getYendthnkyoteiriritu());

        khHenkouUktkYendtHnk.setMkhgk(uiBean.getMkhgk());

        khHenkouUktkYendtHnk.setYendthnkkjnkg(uiBean.getYendthnkkjnkg());

        khHenkouUktkYendtHnk.setTargettkmokuhyouti(uiBean.getTargettkmokuhyouti());

        khHenkouUktkYendtHnk.setYendthnkbfrsibousyen(uiBean.getYendthnkSibous());

        khHenkouUktkYendtHnk.setYendthnkjiptumitatekin(uiBean.getPtmttkngk());

        khHenkouUktkYendtHnk.setYendthnkjisjkkktyouseiritu(uiBean.getSjkkktyouseiyouriritu());

        khHenkouUktkYendtHnk.setYendthnkjikaiyakukjgk(uiBean.getKaiyakukjgk());

        khHenkouUktkYendtHnk.setYendthnkjikaiyakukoujyoritu(uiBean.getKaiyakukoujyoritu());

        khHenkouUktkYendtHnk.setKaiyakukoujyoritutekiumu(uiBean.getKaiyakukoujyoritutekiumu());

        if (uiBean.getHnskariyuuList().size() == 0) {
            khHenkouUktkYendtHnk.setHnskariyuu1(C_HnskariyuuKbn.BLNK);

            khHenkouUktkYendtHnk.setHnskariyuu2(C_HnskariyuuKbn.BLNK);
        }
        else if (uiBean.getHnskariyuuList().size() == 1) {
            khHenkouUktkYendtHnk.setHnskariyuu1(uiBean.getHnskariyuuList().get(0));

            khHenkouUktkYendtHnk.setHnskariyuu2(C_HnskariyuuKbn.BLNK);
        }
        else {
            khHenkouUktkYendtHnk.setHnskariyuu1(uiBean.getHnskariyuuList().get(0));

            khHenkouUktkYendtHnk.setHnskariyuu2(uiBean.getHnskariyuuList().get(1));
        }

        BizPropertyInitializer.initialize(khHenkouUktkYendtHnk);

        IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();

        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);

        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());

        editTtdkRirekiTblParam.setSyoriYmd(sysDate);

        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.NONE);

        editTtdkRirekiTblParam.setSysTime(sysTime);

        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        hozenDomManager.update(kykKihon);

        hozenDomManager.insert(khHenkouUktk);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    private void checkExist() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {

            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);
    }

    private C_TargetTkHukaKanouKbn checkTargettkhukakanou(BM_SyouhnZokusei pSyouhnZokusei) {

        C_TargetTkHukaKanouKbn targettkhukakanoukbn = pSyouhnZokusei.getTargettkhukakanoukbn();

        if (C_TargetTkHukaKanouKbn.NONE.eq(targettkhukakanoukbn)) {

            throw new BizLogicException(MessageId.EIA0035, targettkhukakanoukbn.getContent());
        }

        return targettkhukakanoukbn;
    }

    private void checkJyoutai(KhozenCommonParam pKhozenCommonParam) {

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());

        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {

            String message = "";
            String messageId = "";
            ArrayList<String> warningMessageIdList = checkYuukouJyoutai.getWarningMessageIDList();
            ArrayList<String> warningMessageList = checkYuukouJyoutai.getWarningMessageList();

            for (int i = 0; i < warningMessageIdList.size(); i++) {

                messageId = BizUtil.getGeneralMessageId(warningMessageIdList.get(i));

                message = warningMessageList.get(i);

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    messageId,
                    message);
            }

            uiBean.getHnskariyuuList().add(C_HnskariyuuKbn.JIMU_ARI);
        }
    }

    private void checkTtdkTyuui(KhozenCommonParam pKhozenCommonParam) {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }
    }

    private void checkTargettkhk(IT_KykSonotaTkyk pKykSonotaTkyk, C_TargetTkHukaKanouKbn pTargettkhukakanoukbn) {

        C_UmuKbn targettkhkumu = pKykSonotaTkyk.getTargettkhkumu();

        Integer targettkmkht = pKykSonotaTkyk.getTargettkmokuhyouti();

        C_TargetTkKbn targettkkbn = pKykSonotaTkyk.getTargettkkbn();

        if (!C_UmuKbn.ARI.eq(targettkhkumu)) {

            throw new BizLogicException(MessageId.EIF1013, pTargettkhukakanoukbn.getContent());
        }
        else if (C_UmuKbn.ARI.eq(targettkhkumu) && targettkmkht < TARGETTKMKHTKBN) {

            throw new BizLogicException(MessageId.EIF1013, targettkkbn.getContent());
        }
    }

    private void checkSyoukaiymd(IT_KykSyouhn pKykSyouhn, BM_SyouhnZokusei pSyouhnZokusei) {

        String syouhncd = pKykSyouhn.getSyouhncd();

        BizDate kykymd = pKykSyouhn.getKykymd();

        Integer dai1Hknkkn = pKykSyouhn.getDai1hknkkn();

        BizDate kykymdAfterPeriod = BizDateUtil.getDateAfterPeriod(kykymd, 1, 0);

        if (BizDateUtil.compareYmd(uiBean.getDispsyoukaiymdfrom(), kykymdAfterPeriod) == BizDateUtil.COMPARE_LESSER
            || BizDateUtil.compareYmd(uiBean.getDispsyoukaiymdto(), kykymdAfterPeriod) == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(MessageId.EBA1032);
        }

        uiBean.setSyohinHanteiKbn(SyouhinUtil.hantei(syouhncd));

        if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyohinHanteiKbn()) {

            HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);

            HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

            hanteiHokenKikanBean.setKykYmd(kykymd);

            hanteiHokenKikanBean.setCalcKijyunYmd(uiBean.getDispsyoukaiymdfrom());

            hanteiHokenKikanBean.setSyouhnZokusei(uiBean.getKykKihon().getKykSyouhns().get(0).getSyouhnZokusei());

            hanteiHokenKikanBean.setDai1hknkkn(dai1Hknkkn);

            C_HknKknKbn hknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

            if (C_HknKknKbn.DAI3HKNKKN.eq(hknKknKbn)) {

                throw new BizLogicException(MessageId.EBA1032);
            }

            hanteiHokenKikanBean.setKykYmd(kykymd);

            hanteiHokenKikanBean.setCalcKijyunYmd(uiBean.getDispsyoukaiymdto());

            hanteiHokenKikanBean.setSyouhnZokusei(uiBean.getKykKihon().getKykSyouhns().get(0).getSyouhnZokusei());

            hanteiHokenKikanBean.setDai1hknkkn(dai1Hknkkn);

            hknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

            if (C_HknKknKbn.DAI3HKNKKN.eq(hknKknKbn)) {

                throw new BizLogicException(MessageId.EBA1032);
            }
        }
        else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn()) {

        }
    }

    private void checkKouryokuhasseiymd(IT_KykSyouhn pKykSyouhn) {

        BizDate kouryokuhasseiymd = pKykSyouhn.getKouryokuhasseiymd();

        String gyoumukousinkinou = pKykSyouhn.getGyoumuKousinKinou();

        if (!(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(gyoumukousinkinou)) &&
            (BizDateUtil.compareYmd(kouryokuhasseiymd, uiBean.getDispsyoukaiymdfrom()) == BizDateUtil.COMPARE_GREATER
            || BizDateUtil.compareYmd(kouryokuhasseiymd, uiBean.getDispsyoukaiymdfrom()) == BizDateUtil.COMPARE_EQUAL)) {

            throw new BizLogicException(MessageId.EIA0106);
        }

        if (BizDateUtil.compareYmd(kouryokuhasseiymd, uiBean.getDispsyoukaiymdto()) == BizDateUtil.COMPARE_GREATER
            || BizDateUtil.compareYmd(kouryokuhasseiymd, uiBean.getDispsyoukaiymdto()) == BizDateUtil.COMPARE_EQUAL){

            throw new BizLogicException(MessageId.EIA0106);
        }

        checkNenSbhnkumu(uiBean.getSyono(), uiBean.getDispsyoukaiymdfrom(),uiBean.getDispsyoukaiymdto() );
    }

    private void checkNenSbhnkumu(String pSyono, BizDate pSyoukaiymdfrom, BizDate pSyoukaiymdto) {

        C_UmuKbn nensbhnkumu = C_UmuKbn.NONE;

        BizDate nenseihnkymd = null;

        String kouryokuhasseiymd = "";

        kouryokuhasseiymd = khMkhgkTttYendtHnkUktkDao.getNewnaiyouoriginalBySyonoSyoriymd(pSyono,pSyoukaiymdfrom,pSyoukaiymdto);

        if(!BizUtil.isBlank(kouryokuhasseiymd)){
            nensbhnkumu  = C_UmuKbn.ARI;

            nenseihnkymd = BizDate.valueOf(kouryokuhasseiymd);
        }

        if (C_UmuKbn.ARI.eq(nensbhnkumu)) {

            uiBean.setNensbhnkumu(nensbhnkumu);

            uiBean.setNenseihnkymd(nenseihnkymd);
        }
    }

    private void checkMkhgkttt(IT_KykSyouhn pKykSyouhn, BM_SyouhnZokusei pSyouhnZokusei, IT_KykSonotaTkyk pKykSonotaTkyk) {

        BizCurrency targettkykkijyungk = pKykSonotaTkyk.getTargettkykkijyungk();

        Integer targettkmokuhyougkwari = pKykSonotaTkyk.getTargettkmokuhyouti();

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        KeisanTargetMokuhyougk keisanTargetMokuhyougk = SWAKInjector.getInstance(KeisanTargetMokuhyougk.class);

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

        KeisanYendtHnkS keisanYendtHnkS = SWAKInjector.getInstance(KeisanYendtHnkS.class);

        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector
            .getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

        BizDateYM keisankijyunym = null;

        BizDate mkhgkttthanteiymd = null;

        BizNumber kawaserate = BizNumber.valueOf(0);

        BizCurrency yendthnkkaiyakuhryen = BizCurrency.valueOf(0);

        BizDate yendthnkymd = null;

        BizDate mkhgktttymd = null;

        BizCurrency yendthnkkaiyakuhrgaika = BizCurrency.valueOf(0);

        int keikanensuu = 0;

        int keikatukisuu = 0;

        BizNumber sjkkktyouseiyouriritu  = BizNumber.valueOf(0);

        BizCurrency kaiyakukjgk= BizCurrency.valueOf(0);

        BizNumber kaiyakukoujyoritu = BizNumber.valueOf(0);

        BizCurrency tutakngk= BizCurrency.valueOf(0);


        C_ErrorKbn errorKbn = null;

        BizCurrency mokuhyougk = keisanTargetMokuhyougk.exec(targettkykkijyungk, targettkmokuhyougkwari);

        uiBean.setYendthnkkjnkg(targettkykkijyungk);
        uiBean.setTargettkmokuhyouti(targettkmokuhyougkwari);
        uiBean.setMkhgk(mokuhyougk);

        if (uiBean.getDispsyoukaiymdfrom().isBusinessDay()) {

            mkhgkttthanteiymd = uiBean.getDispsyoukaiymdfrom();
        }
        else {
            mkhgkttthanteiymd = uiBean.getDispsyoukaiymdfrom().addBusinessDays(1);
        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());

        BizDate kykymd = pKykSyouhn.getKykymd();
        BizDateYM jkipjytym = ansyuKihon.getJkipjytym();
        C_Hrkkaisuu hrkkaisuu = uiBean.getKykKihon().getHrkkaisuu();
        C_Kykjyoutai kykjyoutai = pKykSyouhn.getKykjyoutai();

        do {

            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn()) {

                HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

                hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
                hanteiTmttknJyoutaiBean.setHanteiKijyunymd(mkhgkttthanteiymd);
                hanteiTmttknJyoutaiBean.setKykymd(kykymd);

                boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                if (!result) {

                    throw new BizLogicException(MessageId.EIF1109);
                }
            }

            keisankijyunym = keisanWKijunYM.exec(kykymd, mkhgkttthanteiymd, jkipjytym, hrkkaisuu, kykjyoutai,
                pKykSyouhn.getSyouhncd(), null);

            errorKbn = keisanWExt.exec(uiBean.getSyono(), mkhgkttthanteiymd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("解約返戻金計算拡張情報作成が実行できませんでした。");
            }

            keisanWExtBean = keisanWExt.getKeisanWExtBean();

            errorKbn = keisanW.exec(mkhgkttthanteiymd, keisankijyunym, keisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("解約返戻金計算が実行できませんでした。");
            }

            errorKbn = getKawaseRate.exec(
                mkhgkttthanteiymd,
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pKykSyouhn.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("為替レート取得が実行できませんでした。");
            }

            kawaserate = getKawaseRate.getKawaserate();

            yendthnkkaiyakuhryen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, keisanW.getW(), kawaserate,
                C_HasuusyoriKbn.AGE);

            if (yendthnkkaiyakuhryen.compareTo(mokuhyougk) < 0) {

                mkhgkttthanteiymd = mkhgkttthanteiymd.addBusinessDays(1);

                if (BizDateUtil.compareYmd(uiBean.getDispsyoukaiymdto(), mkhgkttthanteiymd) == BizDateUtil.COMPARE_LESSER) {

                    throw new BizLogicException(MessageId.EIF1084);
                }
            }
            else {

                mkhgktttymd = mkhgkttthanteiymd;

                yendthnkymd = mkhgktttymd.addDays(1);

                yendthnkkaiyakuhrgaika = keisanW.getW();

                keikanensuu = keisanW.getKeikanensuu();

                keikatukisuu = keisanW.getKeikatukisuu();

                sjkkktyouseiyouriritu = keisanW.getSjkkktyouseiritu().multiply(100);

                kaiyakukjgk = keisanW.getKaiyakukjgk();

                kaiyakukoujyoritu = keisanW.getKaiyakukjritu();

                tutakngk = keisanW.getV();

            }
        }
        while (yendthnkkaiyakuhryen.compareTo(mokuhyougk) < 0);

        uiBean.setSjkkktyouseiyouriritu(sjkkktyouseiyouriritu);
        uiBean.setKaiyakukjgk(kaiyakukjgk);
        uiBean.setKaiyakukoujyoritu(kaiyakukoujyoritu);
        uiBean.setPtmttkngk(tutakngk);
        uiBean.setKaiyakukoujyoritutekiumu(pSyouhnZokusei.getKaiyakukoujyoritutekiumu());

        uiBean.setYendtgosyouhncd(pSyouhnZokusei.getYendthnksyouhncd());

        Integer syouhnsdNoMax = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(
            uiBean.getYendtgosyouhncd(), yendthnkymd);

        uiBean.setYendtgosyouhnsdno(syouhnsdNoMax);

        BM_SyouhnZokusei syouhnZokuseiInfo = bizDomManager.getSyouhnZokusei(
            uiBean.getYendtgosyouhncd(), uiBean.getYendtgosyouhnsdno());

        uiBean.setYendtgoryouritusdno(syouhnZokuseiInfo.getRyouritusdno());

        uiBean.setTumitateriritu(RIRITU_ZERO);

        uiBean.setYendthnkyoteiriritu(RIRITU_ZERO);

        if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyohinHanteiKbn()) {

            errorKbn = calcHkShrKngk.execByKeisanWExt(
                uiBean.getSyono(),
                mkhgktttymd,
                C_SiinKbn.SP,
                C_HokenkinsyuruiKbn.SBHOKENKIN,
                uiBean.getKykKihon().getSdpdkbn(),
                uiBean.getKykKihon().getHrkkeiro());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("保険金額計算が実行できませんでした。");
            }

            BizCurrency sibousGk = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();

            BizCurrency yendthnkSibous = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY, sibousGk, kawaserate, C_HasuusyoriKbn.AGE);

            errorKbn = keisanYendtHnkS.exec(
                mkhgktttymd,
                yendthnkkaiyakuhryen,
                yendthnkSibous,
                uiBean.getYendtgosyouhncd(),
                uiBean.getYendtgosyouhnsdno(),
                uiBean.getYendtgoryouritusdno(),
                uiBean.getYendthnkyoteiriritu(),
                keisanWExtBean.getHrkkaisuu(),
                keisanWExtBean.getHhknsei(),
                keisanWExtBean.getHhknnen(),
                keisanWExtBean.getHknkknsmnkbn(),
                keisanWExtBean.getHknkkn(),
                keisanWExtBean.getHrkkkn(),
                keikanensuu,
                keikatukisuu,
                kykymd,
                keisankijyunym);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("円建変更後Ｓ計算が実行できませんでした。");
            }

            uiBean.setMkhgktttymd(mkhgktttymd);

            uiBean.setMkhgktttkaiyakuhr(yendthnkkaiyakuhryen);

            uiBean.setYendthnksbhokenkngk(keisanYendtHnkS.getYendthnkKihonSAfter());

            uiBean.setYendthnkkaiyakuhrgk(keisanYendtHnkS.getYendthnkW());

            uiBean.setYendthnkhrgk(keisanYendtHnkS.getYendthnkhr());

            uiBean.setYendthnkymd(yendthnkymd);

            uiBean.setYendthnkkaiyakuhrgaika(yendthnkkaiyakuhrgaika);

            uiBean.setYendthnkkaiyakuhryen(yendthnkkaiyakuhryen);

            uiBean.setKawaserate(kawaserate);

            uiBean.setYendthnkSibous(yendthnkSibous);

            C_UmuKbn yendthnkhr = keisanYendtHnkS.getYendthnkhrUmu();

            if (C_UmuKbn.ARI.eq(yendthnkhr)) {

                uiBean.getHnskariyuuList().add(C_HnskariyuuKbn.YENDTHNKHR_ARI);
            }
        }
        else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyohinHanteiKbn()) {

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(uiBean.getYendtgosyouhncd());
            getYoteirirituBean.setKijyunymd(yendthnkymd);
            getYoteirirituBean.setSknnkaisiymd(yendthnkymd);
            getYoteirirituBean.setKykymd(yendthnkymd);
            getYoteirirituBean.setHknkkn(pKykSyouhn.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pKykSyouhn.getHknkknsmnkbn());
            getYoteirirituBean.setHhknnen(pKykSyouhn.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pKykSyouhn.getYoteirrthendohosyurrt());

            errorKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("予定利率取得が実行できませんでした。");
            }

            BizNumber tumitateriritu = getYoteiriritu.getTumitateriritu();

            BizNumber yoteiriritu = getYoteiriritu.getYoteiriritu();

            uiBean.setMkhgktttymd(mkhgktttymd);

            uiBean.setMkhgktttkaiyakuhr(yendthnkkaiyakuhryen);

            uiBean.setYendthnksbhokenkngk(yendthnkkaiyakuhryen);

            uiBean.setYendthnkkaiyakuhrgk(yendthnkkaiyakuhryen);

            uiBean.setYendthnkhrgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            uiBean.setYendthnkkjnkngk(yendthnkkaiyakuhryen);

            uiBean.setYendthnkymd(yendthnkymd);

            uiBean.setYendthnkkaiyakuhrgaika(yendthnkkaiyakuhrgaika);

            uiBean.setYendthnkkaiyakuhryen(yendthnkkaiyakuhryen);

            uiBean.setKawaserate(kawaserate);

            uiBean.setTumitateriritu(tumitateriritu);

            uiBean.setYendthnkyoteiriritu(yoteiriritu);

            uiBean.setYendthnkSibous(yendthnkkaiyakuhryen);

        }
        else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn()) {

            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

            hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(mkhgktttymd);
            hanteiTmttknJyoutaiBean.setKykymd(kykymd);

            boolean result = hanteiKhSisuurendoTmttknJyoutai.execKijunymdgoTmttknHantei(hanteiTmttknJyoutaiBean);

            if (result) {

                throw new BizLogicException(MessageId.EIF1110);
            }

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(uiBean.getYendtgosyouhncd());
            getYoteirirituBean.setKijyunymd(yendthnkymd);
            getYoteirirituBean.setSknnkaisiymd(yendthnkymd);
            getYoteirirituBean.setKykymd(yendthnkymd);
            getYoteirirituBean.setHknkkn(pKykSyouhn.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pKykSyouhn.getHknkknsmnkbn());
            getYoteirirituBean.setHhknnen(pKykSyouhn.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pKykSyouhn.getYoteirrthendohosyurrt());

            errorKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("予定利率取得が実行できませんでした。");
            }

            BizNumber tumitateriritu = getYoteiriritu.getTumitateriritu();

            BizNumber yoteiriritu = getYoteiriritu.getYoteiriritu();

            uiBean.setMkhgktttymd(mkhgktttymd);

            uiBean.setMkhgktttkaiyakuhr(yendthnkkaiyakuhryen);

            uiBean.setYendthnksbhokenkngk(yendthnkkaiyakuhryen);

            uiBean.setYendthnkkaiyakuhrgk(yendthnkkaiyakuhryen);

            uiBean.setYendthnkhrgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            uiBean.setYendthnkkjnkngk(yendthnkkaiyakuhryen);

            uiBean.setYendthnkymd(yendthnkymd);

            uiBean.setYendthnkkaiyakuhrgaika(yendthnkkaiyakuhrgaika);

            uiBean.setYendthnkkaiyakuhryen(yendthnkkaiyakuhryen);

            uiBean.setKawaserate(kawaserate);

            uiBean.setTumitateriritu(tumitateriritu);

            uiBean.setYendthnkyoteiriritu(yoteiriritu);

            uiBean.setYendthnkSibous(yendthnkkaiyakuhryen);
        }
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam, C_UmuKbn pMihaneiDUmu, C_SyorikahiKbn pSyorikahiKbn) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        setBetukyk.exec(pKhozenCommonParam, uiBean);

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetTuusinsaki.exec(pKhozenCommonParam, uiBean);

        SetHihokensya.exec(pKhozenCommonParam, uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(pKhozenCommonParam, uiBean);

        SetSonotaTk.exec(pKhozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {

            String message = "";
            String messageId = "";

            for (int n = 0; n < uiBean.getWarningMessageIdList().size(); n++) {

                messageId = BizUtil.getGeneralMessageId(uiBean.getWarningMessageIdList().get(n));
                message = uiBean.getWarningMessageList().get(n);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, messageId, message);

            }
        }

        if (C_SyorikahiKbn.SYORIHUKA.eq(pSyorikahiKbn) && C_UmuKbn.ARI.eq(pMihaneiDUmu)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,MessageId.WIF1030);
        }
    }
}
