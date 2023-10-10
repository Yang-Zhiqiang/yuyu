package yuyu.app.hozen.khansyuu.khzennouseisangksyoukai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khzennouseisangksyoukai.dba.KhZennouSeisanGkSyoukaiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 前納精算額照会 のビジネスロジックです。
 */
public class KhZennouSeisanGkSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhZennouSeisanGkSyoukaiUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhZennouSeisanGkSyoukaiDao khZennouSeisanGkSyoukaiDao;

    @Inject
    private MessageManager messageManager;

    void init() {

        uiBean.setCalckijyunymd(BizDate.getSysDate());

        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    void pushSyoukaiBL() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        List<IT_KykSyouhn> kykSyouhnLst = khZennouSeisanGkSyoukaiDao.getKykSyouhns(kykKihon);

        if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhnLst.get(0).getYuukousyoumetukbn())
            && BizDateUtil.compareYmd(uiBean.getCalckijyunymd(), kykSyouhnLst.get(0).getSyoumetuymd())
            == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EIF3018);
        }


        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            List<String> warningMessageIdList = checkYuukouJyoutai.getWarningMessageIDList();
            List<String> warningMessageList = checkYuukouJyoutai.getWarningMessageList();

            for (int index = 0; index < warningMessageIdList.size(); index++) {
                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    BizUtil.getGeneralMessageId(warningMessageIdList.get(index)),
                    warningMessageList.get(index));
            }
        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }

        Long zennouCount = khZennouSeisanGkSyoukaiDao.getZennouCount(uiBean.getSyono());

        if (zennouCount == 0) {
            throw new BizLogicException(MessageId.EIF3019);
        }

        List<IT_Zennou> zennouLst = khZennouSeisanGkSyoukaiDao.getZennous(uiBean.getSyono(),
            uiBean.getCalckijyunymd(), kykSyouhnLst.get(0).getKykymd().getDay());

        if (zennouLst.size() == 0) {
            throw new BizLogicException(MessageId.EIF3020);
        }

        BizDate annaiSaikaiYmd = BizDate.valueOf(zennouLst.get(0).getAnnaisaikaiym(),
            kykSyouhnLst.get(0).getKykymd().getDay()).getRekijyou();

        if (BizDateUtil.compareYmd(annaiSaikaiYmd , uiBean.getCalckijyunymd()) <= BizDateUtil.COMPARE_EQUAL){
            throw new BizLogicException(MessageId.EIF3020);
        }


        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        BizDate tykgoOutouYmd = setOutoubi.exec(
            C_TykzentykgoKbn.TYKGO,
            kykSyouhnLst.get(0).getKykymd(),
            C_Hrkkaisuu.NEN,
            uiBean.getCalckijyunymd());

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());

        if (BizDateUtil.compareYm(ansyuKihon.getSyuharaimanymd().getBizDateYM(),
            zennouLst.get(0).getAnnaisaikaiym()) == BizDateUtil.COMPARE_EQUAL) {
            uiBean.setHaraimanflag(true);
        }
        else {
            uiBean.setHaraimanflag(false);
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(zennouLst.get(0).getZennoujihrkp().getType());

        uiBean.setZennoustartym(zennouLst.get(0).getZennoukaisiymd().getBizDateYM());
        uiBean.setZennoukikan(zennouLst.get(0).getZennoukikan());
        uiBean.setZennounyuukinkgk(zennouLst.get(0).getZennounyuukinkgk());
        uiBean.setAnnaisaikaiym(zennouLst.get(0).getAnnaisaikaiym());
        uiBean.setSeityuusigojkipjytym(tykgoOutouYmd.getBizDateYM());
        uiBean.setZennounyuukinkgkrstk(zennouLst.get(0).getZennounyuukinkgkrstk());
        uiBean.setRyosyukwsratekjymd(zennouLst.get(0).getRyosyukwsratekjymd());
        uiBean.setRyosyukwsrate(zennouLst.get(0).getRyosyukwsrate());
        uiBean.setRstuukasyu(zennouLst.get(0).getRstuukasyu());
        uiBean.setKyktuukasyu(kykSyouhnLst.get(0).getKyktuukasyu());
        uiBean.setKyktuukasyu2(kykSyouhnLst.get(0).getKyktuukasyu());
        uiBean.setCalcTuukasyu(tuukasyu);


        KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(
            uiBean.getCalckijyunymd(),
            kykSyouhnLst.get(0).getKykymd(),
            zennouLst.get(0).getZennoujihrkp(),
            zennouLst.get(0).getZennoukaisiymd(),
            zennouLst.get(0).getRyosyuymd(),
            zennouLst.get(0).getZennounyuukinkgk());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizLogicException(MessageId.EIA1012, "前納精算額計算");
        }

        BizCurrency zennouseisankgk = keisanZennouSeisanGk2.getZennouSeisanGk();
        BizNumber yenkansantkykwsrate = BizNumber.optional();
        BizDate yenkansantkykwsrateymd = null;
        BizCurrency yenkazennouseisankgk = BizCurrency.optional();

        if (!C_Tuukasyu.JPY.eq(uiBean.getCalcTuukasyu())) {
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn getKawaseRateErrorKbn = getKawaseRate.exec(uiBean.getCalckijyunymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE, uiBean.getCalcTuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(getKawaseRateErrorKbn)) {
                getKawaseRateErrorKbn = getKawaseRate.exec(BizDate.getSysDate(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE, uiBean.getCalcTuukasyu(), C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.YOU);

                if (C_ErrorKbn.ERROR.eq(getKawaseRateErrorKbn)) {
                    throw new BizLogicException(MessageId.EIA1012, "為替レート取得");
                }

                messageManager.addMessageId(MessageId.WIF3016);
            }

            yenkansantkykwsrate = getKawaseRate.getKawaserate();
            yenkansantkykwsrateymd = getKawaseRate.getKwsrateKjYmd();

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            yenkazennouseisankgk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, zennouseisankgk, yenkansantkykwsrate,
                C_HasuusyoriKbn.SUTE);
        }

        uiBean.setZennouseisankgk(zennouseisankgk);
        uiBean.setYenkazennouseisankgk(yenkazennouseisankgk);
        uiBean.setYenkansantkykwsrateymd(yenkansantkykwsrateymd);
        uiBean.setYenkansantkykwsrate(yenkansantkykwsrate);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(khozenCommonParam, uiBean);

        messageManager.addMessageId(MessageId.WIF3006);
    }
}
