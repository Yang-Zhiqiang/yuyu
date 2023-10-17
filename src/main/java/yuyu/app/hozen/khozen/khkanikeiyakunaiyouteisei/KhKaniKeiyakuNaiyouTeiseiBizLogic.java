package yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei.dba.KhKaniKeiyakuNaiyouTeiseiDao;
import yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei.dba.YendthnkSikinIdouDataKingakuBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.haitou.CheckDShrYendtHnkTorikesi;
import yuyu.common.hozen.haitou.DBAccessDCommonYendtHnkTorikesi;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CheckZeiseiTkkkTkykHukaJyouken;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTblZeiteki;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrDateUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_KykNaiyouTeiseiSyoriKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZeitekiHenkouSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;

import com.google.common.collect.Lists;

/**
 * 契約保全簡易契約内容訂正 のビジネスロジックです。
 */
public class KhKaniKeiyakuNaiyouTeiseiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKaniKeiyakuNaiyouTeiseiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private KhKaniKeiyakuNaiyouTeiseiDao khKaniKeiyakuNaiyouTeiseiDao;

    void init() {
    }

    void clear() {
    }

    void pushKetteiBL() {

        BizPropertyInitializer.initialize(uiBean);

        String syoNo = uiBean.getSyono();
        BizDate sysDate = BizDate.getSysDate();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhns().get(0);
        C_YuukousyoumetuKbn yuukousyoumetukbn = kykSyouhn.getYuukousyoumetukbn();
        if (C_YuukousyoumetuKbn.SYOUMETU.eq(yuukousyoumetukbn)) {
            throw new BizLogicException(MessageId.EBA0031, C_YuukousyoumetuKbn.SYOUMETU.getContent());
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        uiBean.setSyohinHanteiKbn(SyouhinUtil.hantei(kykSyouhn.getSyouhncd()));

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean SyouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            kykSyouhn.getSyouhncd(), kykSyouhn.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(SyouhinbetuSegmentBean.getErrorKbn())) {
            throw new CommonBizAppException("セグメントコード取得が実行できませんでした。");
        }

        uiBean.setSeg1cd(SyouhinbetuSegmentBean.getSegcd1());

        if (C_KykNaiyouTeiseiSyoriKbn.MKHGKTTTYENDTHNKTRKS.eq(uiBean.getKyknaiyouteiseisyorikbn())) {
            BizDate yendthnkymd = kykSyouhn.getYendthnkymd();
            String gyoumuKousinKinou = kykSyouhn.getGyoumuKousinKinou();

            if (yendthnkymd == null) {
                throw new BizLogicException(MessageId.EIF1079);
            }


            if (!IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou)) {
                throw new BizLogicException(MessageId.EIA0106);
            }

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
            C_UmuKbn umuKbn = checkProcessKaishi.exec(uiBean.getSyono(), IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR);
            if (C_UmuKbn.ARI.eq(umuKbn)){
                throw new BizLogicException(MessageId.EIF1087);
            }

            CheckDShrYendtHnkTorikesi checkDShrYendtHnkTorikesi = SWAKInjector
                .getInstance(CheckDShrYendtHnkTorikesi.class);
            C_ErrorKbn errorKbn = checkDShrYendtHnkTorikesi.checkDShr(uiBean.getSyono(), yendthnkymd.getPreviousDay(),
                sysDate);
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }

            if (C_SyorikahiKbn.SYORIHUKA.eq(checkDShrYendtHnkTorikesi.getSyorikahiKbn())) {

                if (C_UmuKbn.ARI.eq(checkDShrYendtHnkTorikesi.getDHuseigouUmu())) {

                    throw new BizLogicException(MessageId.EBS1012);
                }

                if (C_UmuKbn.ARI.eq(checkDShrYendtHnkTorikesi.getDHaneiYmdUmu())) {

                    throw new BizLogicException(MessageId.EIF1097);
                }

                if (C_UmuKbn.ARI.eq(checkDShrYendtHnkTorikesi.getDShrYmdUmu())) {

                    throw new BizLogicException(MessageId.EIF1098);
                }
            }

            IT_KhTtdkRireki khTtdkRireki =
                uiBean.getKykKihon().getKhTtdkRirekiByHenkousikibetukey(kykSyouhn.getHenkousikibetukey());

            if (khTtdkRireki != null) {
                if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(khTtdkRireki.getSyorikbn())) {
                    throw new BizLogicException(MessageId.EIF1112);
                }
            }

            uiBean.setYendthnkymd(yendthnkymd);
            uiBean.setSyouhnCd(kykSyouhn.getSyouhncd());
            uiBean.setSyutkKbn(kykSyouhn.getSyutkkbn());
            uiBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
            uiBean.setKyksyouhnrenno(kykSyouhn.getKyksyouhnrenno());

            List<IT_KhHenreikin> khHenreikinLst =
                khKaniKeiyakuNaiyouTeiseiDao.getKhHenreikinYendMbrSiharaizumiBySyono(
                    uiBean.getSyono(), uiBean.getYendthnkymd());

            if (khHenreikinLst.size() > 0) {
                IT_KhHenreikin khHenreikin = khHenreikinLst.get(0);

                uiBean.setKhHenreikin(khHenreikin);

                if (C_Siharaijyoutaikbn.SIHARAIZUMI.eq(uiBean.getKhHenreikin().getHrsiharaijyoutaikbn())) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1020);
                }
            }

            boolean hanteiKekka = SrDateUtil.isKessanTukiYokugetu(sysDate);

            if (hanteiKekka) {

                SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

                BizDate zengetumatuSimeYmd = setDenSimebi.exec(sysDate);

                if ((BizDateUtil.compareYmd(sysDate, zengetumatuSimeYmd) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(sysDate, zengetumatuSimeYmd) == BizDateUtil.COMPARE_EQUAL)
                    && BizDateUtil.compareYm(uiBean.getYendthnkymd().getBizDateYM(), sysDate.getBizDateYM())
                    == BizDateUtil.COMPARE_LESSER) {

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1047);
                }
            }

            if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19  == uiBean.getSyohinHanteiKbn()) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1050);
            }
        }

        if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUHUKA.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
            boolean result = checkYuuyokkngai.exec(uiBean.getSyono(), sysDate);
            if (!result) {

                throw new BizLogicException(MessageId.EIA0085);
            }

            if (C_UmuKbn.NONE.eq(syouhnZokusei.getZeiseitekikakuumu())) {

                throw new BizLogicException(MessageId.EIA1034);
            }

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

                throw new BizLogicException(MessageId.EIA1035);
            }

            CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(
                CheckZeiseiTkkkTkykHukaJyouken.class);
            C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam,
                uiBean.getSyono());
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("税制適格特約付加条件チェックが実行できませんでした。");
            }

            if (!checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk()) {

                throw new BizLogicException(MessageId.EIF1090);
            }
        }

        if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUSYOUMETU.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
            boolean result = checkYuuyokkngai.exec(uiBean.getSyono(), sysDate);
            if (!result) {

                throw new BizLogicException(MessageId.EIA0085);
            }

            if (C_UmuKbn.NONE.eq(syouhnZokusei.getZeiseitekikakuumu())) {

                throw new BizLogicException(MessageId.EIA1034);
            }

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
            if (C_UmuKbn.NONE.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

                throw new BizLogicException(MessageId.EIA1036);
            }
        }

        if (C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_TORIKESI.eq(uiBean.getKyknaiyouteiseisyorikbn())) {
            BizDate kykymd = kykSyouhn.getKykymd().addYears(1);
            if (!kykymd.isRekijyou()) {
                kykymd = kykymd.getRekijyou();
            }

            if (BizDateUtil.compareYmd(sysDate, kykymd) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EIF1113);
            }

            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

            hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(sysDate);
            hanteiTmttknJyoutaiBean.setKykymd(kykSyouhn.getKykymd());

            boolean chokuzenOutouymTmttknHanteiFlg =
                hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

            if (!chokuzenOutouymTmttknHanteiFlg) {
                throw new BizLogicException(MessageId.EIF1113);
            }

            hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

            hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(sysDate);
            hanteiTmttknJyoutaiBean.setKykymd(kykSyouhn.getKykymd());

            boolean kijunymdgoTmttknHanteiFlg =
                hanteiKhSisuurendoTmttknJyoutai.execKijunymdgoTmttknHantei(hanteiTmttknJyoutaiBean);

            if (kijunymdgoTmttknHanteiFlg) {
                throw new BizLogicException(MessageId.EIA0106);
            }

            IT_KhSisuurendoTmttkn khSisuurendoTmttkn =
                khKaniKeiyakuNaiyouTeiseiDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymd(uiBean.getSyono(), sysDate);

            if (BizDateUtil.compareYmd(kykSyouhn.getKouryokuhasseiymd(),
                khSisuurendoTmttkn.getTmttknkouryokukaisiymd()) == BizDateUtil.COMPARE_GREATER ||
                (BizDateUtil.compareYmd(kykSyouhn.getKouryokuhasseiymd(),
                    khSisuurendoTmttkn.getTmttknkouryokukaisiymd()) == BizDateUtil.COMPARE_EQUAL &&
                    (!IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(kykSyouhn.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(kykSyouhn.getGyoumuKousinKinou())))) {
                throw new BizLogicException(MessageId.EIA0106);
            }

            C_KykNaiyouTeiseiSyoriKbn kykNaiyouTeiseiSyoriKbn = C_KykNaiyouTeiseiSyoriKbn.BLNK;

            if (kykSyouhn.getTmttknitenymd() == null) {
                kykNaiyouTeiseiSyoriKbn = C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_TORIKESI;
            }
            else {
                if (BizDateUtil.compareYmd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd(),
                    kykSyouhn.getTmttknitenymd()) == BizDateUtil.COMPARE_EQUAL) {
                    kykNaiyouTeiseiSyoriKbn = C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_ITEN_TORIKESI;
                }
                else {
                    kykNaiyouTeiseiSyoriKbn = C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_TORIKESI;
                }
            }

            uiBean.setDispkyknytssyorikbn(kykNaiyouTeiseiSyoriKbn);
            uiBean.setTmttknkouryokukaisiymd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd());
            uiBean.setSyouhnCd(kykSyouhn.getSyouhncd());
            uiBean.setSyutkKbn(kykSyouhn.getSyutkkbn());
            uiBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
            uiBean.setKyksyouhnrenno(kykSyouhn.getKyksyouhnrenno());
        }
        else {
            uiBean.setDispkyknytssyorikbn(uiBean.getKyknaiyouteiseisyorikbn());
        }
    }

    void pushKakuninBL() {

        messageManager.addMessageId(MessageId.QBA0001);

        if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUHUKA.eq(uiBean.getKyknaiyouteiseisyorikbn()) ||
            C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUSYOUMETU.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIF1031);
        }
    }

    @Transactional
    void pushKakuteiBL() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String gyoumuKousinKinouId = khozenCommonParam.getFunctionId();
        String gyoumuKousinsyaId = khozenCommonParam.getUserID();
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();
        IT_KykKihon kykKihon = uiBean.getKykKihon();

        String sikibetukey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());
        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetukey);

        IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(uiBean.getSyono());

        IT_KhTtdkRireki khTtdkRirekis = kykKihon.createKhTtdkRireki();
        khTtdkRirekis.setHenkousikibetukey(sikibetukey);
        BizPropertyInitializer.initialize(khTtdkRirekis);

        if (C_KykNaiyouTeiseiSyoriKbn.MKHGKTTTYENDTHNKTRKS.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhnHnkmae.getSyouhncd(),
                kykSyouhnHnkmae.getSyouhnsdno());

            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            SyouhinbetuSegmentBean SyouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                kykSyouhnHnkmae.getSyouhncd(), kykSyouhnHnkmae.getKyktuukasyu());

            if (C_ErrorKbn.ERROR.eq(SyouhinbetuSegmentBean.getErrorKbn())) {
                throw new CommonBizAppException("セグメントコード取得が実行できませんでした。");
            }

            C_Segcd gaikaSeg1cd = SyouhinbetuSegmentBean.getSegcd1();

            kykKihon.setHrkp(kykSyouhnHnkmae.getHokenryou());
            kykKihon.setHaitounendo(kykSyouhnHnkmae.getHaitounendo());
            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(gyoumuKousinKinouId);
            kykKihon.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            kykKihon.setGyoumuKousinTime(gyoumuKousinTime);

            updateKhHasseijiKazeiRireki(kykKihon, sysDate, gyoumuKousinKinouId, gyoumuKousinsyaId, gyoumuKousinTime);

            deleteKihrkmpSeisanRireki(kykKihon);

            EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

            editKykSyhnRirekiTbl.exec(khozenCommonParam, uiBean.getSyono(), uiBean.getSyutkKbn(), uiBean.getSyouhnCd(),
                uiBean.getSyouhnsdNo(), uiBean.getKyksyouhnrenno());

            updateKykSonotaTkyk(kykKihon, kykSyouhnHnkmae, gyoumuKousinKinouId, gyoumuKousinsyaId, gyoumuKousinTime,
                sysDate);

            updateKykSyouhn(kykKihon, kykSyouhnHnkmae, sikibetukey, gyoumuKousinKinouId, gyoumuKousinsyaId,
                gyoumuKousinTime);

            updateKhHenreikin(gyoumuKousinKinouId, gyoumuKousinsyaId, gyoumuKousinTime);

            insertYendthnkSikinIdouData(kykSyouhnHnkmae, sysDate);

            DBAccessDCommonYendtHnkTorikesi dbAccessDCommonYendtHnkTorikesi = SWAKInjector.getInstance(
                DBAccessDCommonYendtHnkTorikesi.class);
            C_ErrorKbn errorKbn = dbAccessDCommonYendtHnkTorikesi.deleteHaitouInfo(uiBean.getSyono());

            if (C_ErrorKbn.ERROR.eq(errorKbn)){

                throw new CommonBizAppException("配当情報削除が実行できませんでした。");
            }

            insertKhDenpyoData(sysDate, khozenCommonParam, gaikaSeg1cd);

        }
        else if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUHUKA.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(gyoumuKousinKinouId);
            kykKihon.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            kykKihon.setGyoumuKousinTime(gyoumuKousinTime);

            updateKykSonotaTkyk(kykKihon, kykSyouhnHnkmae, gyoumuKousinKinouId, gyoumuKousinsyaId, gyoumuKousinTime,
                sysDate);

            EditKoujyonaiyouTblZeiteki editKoujyonaiyouTblZeiteki = SWAKInjector
                .getInstance(EditKoujyonaiyouTblZeiteki.class);

            C_ChkkekkaKbn chkkekkaKbn = editKoujyonaiyouTblZeiteki.exec(
                uiBean.getSyono(), sysDate, C_ZeitekiHenkouSyoriKbn.HUKA);

            if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

                throw new CommonBizAppException("税適特約変更時控除証明内容TBL編集が実行できませんでした。");
            }
            else if (C_ChkkekkaKbn.WARNING.eq(chkkekkaKbn)) {

                for (int n = 0; n < editKoujyonaiyouTblZeiteki.getMessageLst().size(); n++) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                        BizUtil.getGeneralMessageId(editKoujyonaiyouTblZeiteki.getMessageIdLst().get(n)),
                        editKoujyonaiyouTblZeiteki.getMessageLst().get(n));
                }
            }
        }
        else if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUSYOUMETU.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(gyoumuKousinKinouId);
            kykKihon.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            kykKihon.setGyoumuKousinTime(gyoumuKousinTime);

            updateKykSonotaTkyk(kykKihon, kykSyouhnHnkmae, gyoumuKousinKinouId, gyoumuKousinsyaId, gyoumuKousinTime,
                sysDate);

            EditKoujyonaiyouTblZeiteki editKoujyonaiyouTblZeiteki = SWAKInjector
                .getInstance(EditKoujyonaiyouTblZeiteki.class);

            C_ChkkekkaKbn chkkekkaKbn = editKoujyonaiyouTblZeiteki.exec(
                uiBean.getSyono(), sysDate, C_ZeitekiHenkouSyoriKbn.SYOUMETU);

            if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

                throw new CommonBizAppException("税適特約変更時控除証明内容TBL編集が実行できませんでした。");
            }
        }

        if (C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_TORIKESI.eq(uiBean.getDispkyknytssyorikbn())) {

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = kykKihon.getKhSisuurendoTmttkns();

            IT_KhSisuurendoTmttkn khSisuurendoTmttkn =
                khKaniKeiyakuNaiyouTeiseiDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymd(uiBean.getSyono(), sysDate);

            khSisuurendoTmttknLst.remove(khSisuurendoTmttkn);

            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(gyoumuKousinKinouId);
            kykKihon.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            kykKihon.setGyoumuKousinTime(gyoumuKousinTime);
        }
        else if (C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(uiBean.getDispkyknytssyorikbn())) {
            IT_KhTtdkRireki khTtdkRireki =
                khKaniKeiyakuNaiyouTeiseiDao.getKhTtdkRirekiBySyonoSyorikbn(uiBean.getSyono(),
                    C_SyoriKbn.TMTTKNHANEI_ITEN);

            IT_KykSyouhnRireki kykSyouhnRireki =
                khKaniKeiyakuNaiyouTeiseiDao.getKykSyouhnRirekiBySyonoHenkousikibetukey(uiBean.getSyono(),
                    khTtdkRireki.getHenkousikibetukey());

            EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

            editKykSyhnRirekiTbl.exec(khozenCommonParam, uiBean.getSyono(), uiBean.getSyutkKbn(), uiBean.getSyouhnCd(),
                uiBean.getSyouhnsdNo(), uiBean.getKyksyouhnrenno());

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(uiBean.getSyutkKbn(), uiBean.getSyouhnCd(),
                uiBean.getSyouhnsdNo(), uiBean.getKyksyouhnrenno());
            kykSyouhn.setHenkousikibetukey(sikibetukey);
            kykSyouhn.setKouryokuhasseiymd(kykSyouhnRireki.getKouryokuhasseiymd());
            kykSyouhn.setGyoumuKousinKinou(gyoumuKousinKinouId);
            kykSyouhn.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            kykSyouhn.setGyoumuKousinTime(gyoumuKousinTime);
            kykSyouhn.setTmttknhaibunjyoutai(kykSyouhnRireki.getTmttknhaibunjyoutai());
            kykSyouhn.setTmttknitenymd(kykSyouhnRireki.getTmttknitenymd());

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = kykKihon.getKhSisuurendoTmttkns();

            IT_KhSisuurendoTmttkn khSisuurendoTmttkn =
                khKaniKeiyakuNaiyouTeiseiDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymd(uiBean.getSyono(), sysDate);

            khSisuurendoTmttknLst.remove(khSisuurendoTmttkn);

            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(gyoumuKousinKinouId);
            kykKihon.setGyoumuKousinsyaId(gyoumuKousinsyaId);
            kykKihon.setGyoumuKousinTime(gyoumuKousinTime);

            IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKykHozenHenkoUkt(
                uiBean.getSyono(), C_UktkSyoriKbn.TMTTKNITEN, C_UktkJyoutaiKbn.SYORIZUMI, uiBean.getTmttknkouryokukaisiymd());

            if (khHenkouUktk != null) {
                khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
                khHenkouUktk.setGyoumuKousinKinou(gyoumuKousinKinouId);
                khHenkouUktk.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                khHenkouUktk.setGyoumuKousinTime(gyoumuKousinTime);

                hozenDomManager.update(khHenkouUktk);
            }
        }
        String youkyuuNo = "";

        if (C_KykNaiyouTeiseiSyoriKbn.MKHGKTTTYENDTHNKTRKS.eq(uiBean.getKyknaiyouteiseisyorikbn())) {
            PALKykNaiyouKousin palKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
            palKykNaiyouKousin.exec(kykKihon);
            youkyuuNo = palKykNaiyouKousin.getYoukyuuno();
        }

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        if (C_KykNaiyouTeiseiSyoriKbn.MKHGKTTTYENDTHNKTRKS.eq(uiBean.getKyknaiyouteiseisyorikbn())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI);
        }
        else if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUHUKA.eq(uiBean.getKyknaiyouteiseisyorikbn())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.ZEISEITEKIKAKUHUKA);
        }
        else if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUSYOUMETU.eq(uiBean.getKyknaiyouteiseisyorikbn())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.ZEISEITEKIKAKUSYOUMETU);
        }

        if (C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_TORIKESI.eq(uiBean.getDispkyknytssyorikbn())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.TMTTKNHANEI_TORIKESI);
        }
        else if (C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(uiBean.getDispkyknytssyorikbn())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI);
        }

        editTtdkRirekiTblParam.setYoukyuuNo(youkyuuNo);
        editTtdkRirekiTblParam.setSysTime(gyoumuKousinTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        hozenDomManager.update(kykKihon);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void pushModoruBtnByConfirmBL() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING3);
    }


    private void updateKhHasseijiKazeiRireki(IT_KykKihon pKykKihon, BizDate pSysDate, String pGyoumuKousinKinou,
        String pGyoumuKousinsyaId, String pGyoumuKousinTime) {


        if (uiBean.getKhHenreikin() != null) {
            List<IT_KhTtdkRireki> khTtdkRirekiLst =
                pKykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

            SortIT_KhTtdkRireki sortIT_KhTtdkRireki = SWAKInjector.getInstance(SortIT_KhTtdkRireki.class);

            sortIT_KhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(khTtdkRirekiLst);

            IT_KhTtdkRireki khTtdkRireki = khTtdkRirekiLst.get(0);

            IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = khTtdkRireki.getKhHasseijiKazeiRireki();

            khHasseijiKazeiRireki.setTorikesiflg(C_UmuKbn.ARI);
            khHasseijiKazeiRireki.setTorikesiymd(pSysDate);
            khHasseijiKazeiRireki.setGyoumuKousinKinou(pGyoumuKousinKinou);
            khHasseijiKazeiRireki.setGyoumuKousinsyaId(pGyoumuKousinsyaId);
            khHasseijiKazeiRireki.setGyoumuKousinTime(pGyoumuKousinTime);
        }
    }

    private void deleteKihrkmpSeisanRireki(IT_KykKihon pKykKihon) {
        if (uiBean.getKhHenreikin() != null) {

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki =
                khKaniKeiyakuNaiyouTeiseiDao.getKihrkmpSeisanRirekiBySyonoGyoumuKousinKinou(
                    uiBean.getSyono(), IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);
            if (kihrkmpSeisanRireki != null) {
                pKykKihon.getKihrkmpSeisanRirekis().remove(kihrkmpSeisanRireki);
            }
        }
    }

    private void updateKykSonotaTkyk(IT_KykKihon pKykKihon, IT_KykSyouhnHnkmae pKykSyouhnHnkmae,
        String pGyoumuKousinKinou, String pGyoumuKousinsyaId, String pGyoumuKousinTime, BizDate pSysDate) {
        IT_KykSonotaTkyk kykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        if (C_KykNaiyouTeiseiSyoriKbn.MKHGKTTTYENDTHNKTRKS.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            kykSonotaTkyk.setTargettkhkumu(pKykSyouhnHnkmae.getTargettkhkumu());
            kykSonotaTkyk.setTargettkykkykhenkoymd(pKykSyouhnHnkmae.getTargettkykkykhenkoymd());
            kykSonotaTkyk.setTargettkkbn(pKykSyouhnHnkmae.getTargettkkbn());
            kykSonotaTkyk.setTargettkmokuhyouti(pKykSyouhnHnkmae.getTargettkmokuhyouti());
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(pKykSyouhnHnkmae.getInitsbjiyensitihsytkhukaumu());
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(pKykSyouhnHnkmae.getInitsbjiyenkasaiteihsygk());
            if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19  == uiBean.getSyohinHanteiKbn()) {

                kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(pKykSyouhnHnkmae.getJyudkaigomeharaitkhukaumu());
                kykSonotaTkyk.setJyudkaigomeharaitkhukaymd(pKykSyouhnHnkmae.getJyudkaigomeharaitkhukaymd());
            }
            kykSonotaTkyk.setTargettkykhkymd(pKykSyouhnHnkmae.getTargettkykhkymd());
            kykSonotaTkyk.setTargettkykkijyungk(pKykSyouhnHnkmae.getTargettkykkijyungk());
            kykSonotaTkyk.setGyoumuKousinKinou(pGyoumuKousinKinou);
            kykSonotaTkyk.setGyoumuKousinsyaId(pGyoumuKousinsyaId);
            kykSonotaTkyk.setGyoumuKousinTime(pGyoumuKousinTime);
        }
        else if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUHUKA.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            kykSonotaTkyk.setGyoumuKousinKinou(pGyoumuKousinKinou);
            kykSonotaTkyk.setGyoumuKousinsyaId(pGyoumuKousinsyaId);
            kykSonotaTkyk.setGyoumuKousinTime(pGyoumuKousinTime);
            kykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setZeiseitkkktkykhukaymd(pSysDate);
            kykSonotaTkyk.setZeiseitkkktkyksyoumetuymd(null);
        }
        else if (C_KykNaiyouTeiseiSyoriKbn.ZEISEITEKIKAKUSYOUMETU.eq(uiBean.getKyknaiyouteiseisyorikbn())) {

            kykSonotaTkyk.setGyoumuKousinKinou(pGyoumuKousinKinou);
            kykSonotaTkyk.setGyoumuKousinsyaId(pGyoumuKousinsyaId);
            kykSonotaTkyk.setGyoumuKousinTime(pGyoumuKousinTime);
            kykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setZeiseitkkktkyksyoumetuymd(pSysDate);
        }
    }

    private void updateKykSyouhn(IT_KykKihon pKykKihon, IT_KykSyouhnHnkmae pKykSyouhnHnkmae, String pSikibetukey,
        String pGyoumuKousinKinou, String pGyoumuKousinsyaId, String pGyoumuKousinTime) {

        pKykKihon.getKykSyouhns().set(0, null);
        pKykKihon.getKykSyouhns().remove(0);
        hozenDomManager.flush();

        IT_KykSyouhn kykSyouhn = pKykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(pKykSyouhnHnkmae.getSyutkkbn());
        kykSyouhn.setSyouhncd(pKykSyouhnHnkmae.getSyouhncd());
        kykSyouhn.setSyouhnsdno(pKykSyouhnHnkmae.getSyouhnsdno());
        kykSyouhn.setKyksyouhnrenno(pKykSyouhnHnkmae.getKyksyouhnrenno());
        kykSyouhn.setHenkousikibetukey(pSikibetukey);
        kykSyouhn.setYuukousyoumetukbn(pKykSyouhnHnkmae.getYuukousyoumetukbn());
        kykSyouhn.setKykjyoutai(pKykSyouhnHnkmae.getKykjyoutai());
        kykSyouhn.setSyoumetujiyuu(pKykSyouhnHnkmae.getSyoumetujiyuu());
        kykSyouhn.setSyoumetuymd(pKykSyouhnHnkmae.getSyoumetuymd());
        kykSyouhn.setKouryokuhasseiymd(pKykSyouhnHnkmae.getKouryokuhasseiymd());
        kykSyouhn.setKykymd(pKykSyouhnHnkmae.getKykymd());
        kykSyouhn.setKykymdsiteiumukbn(pKykSyouhnHnkmae.getKykymdsiteiumukbn());
        kykSyouhn.setSknnkaisiymd(pKykSyouhnHnkmae.getSknnkaisiymd());
        kykSyouhn.setGansknnkaisiymd(pKykSyouhnHnkmae.getGansknnkaisiymd());
        kykSyouhn.setHksknnkaisiymd(pKykSyouhnHnkmae.getHksknnkaisiymd());
        kykSyouhn.setHkgansknnkaisiymd(pKykSyouhnHnkmae.getHkgansknnkaisiymd());
        kykSyouhn.setHknkknsmnkbn(pKykSyouhnHnkmae.getHknkknsmnkbn());
        kykSyouhn.setHknkkn(pKykSyouhnHnkmae.getHknkkn());
        kykSyouhn.setHrkkknsmnkbn(pKykSyouhnHnkmae.getHrkkknsmnkbn());
        kykSyouhn.setHrkkkn(pKykSyouhnHnkmae.getHrkkkn());
        kykSyouhn.setKyknen(pKykSyouhnHnkmae.getKyknen());
        kykSyouhn.setHhknnen(pKykSyouhnHnkmae.getHhknnen());
        kykSyouhn.setHhknseiymd(pKykSyouhnHnkmae.getHhknseiymd());
        kykSyouhn.setHhknsei(pKykSyouhnHnkmae.getHhknsei());
        kykSyouhn.setHaraimanymd(pKykSyouhnHnkmae.getHaraimanymd());
        kykSyouhn.setHknkknmanryouymd(pKykSyouhnHnkmae.getHknkknmanryouymd());
        kykSyouhn.setKatakbn(pKykSyouhnHnkmae.getKatakbn());
        kykSyouhn.setKyhgndkatakbn(pKykSyouhnHnkmae.getKyhgndkatakbn());
        kykSyouhn.setSyukyhkinkatakbn(pKykSyouhnHnkmae.getSyukyhkinkatakbn());
        kykSyouhn.setKhnkyhkgbairitukbn(pKykSyouhnHnkmae.getKhnkyhkgbairitukbn());
        kykSyouhn.setRokudaildkbn(pKykSyouhnHnkmae.getRokudaildkbn());
        kykSyouhn.setPmnjtkkbn(pKykSyouhnHnkmae.getPmnjtkkbn());
        kykSyouhn.setKihons(pKykSyouhnHnkmae.getKihons());
        kykSyouhn.setHokenryou(pKykSyouhnHnkmae.getHokenryou());
        kykSyouhn.setKyktuukasyu(pKykSyouhnHnkmae.getKyktuukasyu());
        kykSyouhn.setRyouritusdno(pKykSyouhnHnkmae.getRyouritusdno());
        kykSyouhn.setYoteiriritu(pKykSyouhnHnkmae.getYoteiriritu());
        kykSyouhn.setYoteirrthendohosyurrt(pKykSyouhnHnkmae.getYoteirrthendohosyurrt());
        kykSyouhn.setYtirrthndmnskaisuu(pKykSyouhnHnkmae.getYtirrthndmnskaisuu());
        kykSyouhn.setKyksjkkktyouseiriritu(pKykSyouhnHnkmae.getKyksjkkktyouseiriritu());
        kykSyouhn.setNksyukbn(pKykSyouhnHnkmae.getNksyukbn());
        kykSyouhn.setNenkinkkn(pKykSyouhnHnkmae.getNenkinkkn());
        kykSyouhn.setNkgnshosyouritu(pKykSyouhnHnkmae.getNkgnshosyouritu());
        kykSyouhn.setNkgnshosyougk(pKykSyouhnHnkmae.getNkgnshosyougk());
        kykSyouhn.setGyoumuKousinKinou(pGyoumuKousinKinou);
        kykSyouhn.setGyoumuKousinsyaId(pGyoumuKousinsyaId);
        kykSyouhn.setGyoumuKousinTime(pGyoumuKousinTime);
        kykSyouhn.setGengakugoyenitijibrpstgk(pKykSyouhnHnkmae.getGengakugoyenitijibrpstgk());
        kykSyouhn.setYendthnkymd(pKykSyouhnHnkmae.getYendthnkymd());
        kykSyouhn.setSetteibairitu(pKykSyouhnHnkmae.getSetteibairitu());
        kykSyouhn.setTmttknzoukaritujygn(pKykSyouhnHnkmae.getTmttknzoukaritujygn());
        kykSyouhn.setKykjisisuurendourate(pKykSyouhnHnkmae.getKykjisisuurendourate());
        kykSyouhn.setTumitateriritu(pKykSyouhnHnkmae.getTumitateriritu());
        kykSyouhn.setTmttknhaibunjyoutai(pKykSyouhnHnkmae.getTmttknhaibunjyoutai());
        kykSyouhn.setSisuukbn(pKykSyouhnHnkmae.getSisuukbn());
        kykSyouhn.setGsbunrikzkakuninumu(pKykSyouhnHnkmae.getGsbunrikzkakuninumu());
        kykSyouhn.setGsbunritaisyou(pKykSyouhnHnkmae.getGsbunritaisyou());
        kykSyouhn.setPharaikomisougaku(pKykSyouhnHnkmae.getPharaikomisougaku());
        kykSyouhn.setTmttknitenymd(pKykSyouhnHnkmae.getTmttknitenymd());
        kykSyouhn.setLoadinghnkgtumitateriritu(pKykSyouhnHnkmae.getLoadinghnkgtumitateriritu());
        kykSyouhn.setRendouritu(pKykSyouhnHnkmae.getRendouritu());
        kykSyouhn.setTeikishrritu(pKykSyouhnHnkmae.getTeikishrritu());
        kykSyouhn.setDai1hknkkn(pKykSyouhnHnkmae.getDai1hknkkn());
    }

    private void updateKhHenreikin(String pGyoumuKousinKinou, String pGyoumuKousinsyaId, String pGyoumuKousinTime) {
        IT_KhHenreikin khHenreikin = uiBean.getKhHenreikin();
        if (khHenreikin != null) {
            khHenreikin.setHrsiharaijyoutaikbn(C_Siharaijyoutaikbn.TORIKESI);
            khHenreikin.setGyoumuKousinKinou(pGyoumuKousinKinou);
            khHenreikin.setGyoumuKousinsyaId(pGyoumuKousinsyaId);
            khHenreikin.setGyoumuKousinTime(pGyoumuKousinTime);
            hozenDomManager.update(khHenreikin);
        }
    }

    private void insertYendthnkSikinIdouData(IT_KykSyouhnHnkmae pKykSyouhnHnkmae, BizDate pSysDate) {

        YendthnkSikinIdouDataKingakuBean yendthnkSikinIdouDataKingakuBean =
            khKaniKeiyakuNaiyouTeiseiDao.getYendthnkSikinIdouDataKingakuBeanBySyonoSyouhncdSyouhnsdno(
                uiBean.getSyono(), pKykSyouhnHnkmae.getSyouhncd(), pKykSyouhnHnkmae.getSyouhnsdno());

        BT_YendthnkSikinIdouData yendthnkSikinIdouData = new BT_YendthnkSikinIdouData();

        yendthnkSikinIdouData.setSyono(uiBean.getSyono());
        yendthnkSikinIdouData.setKeiriyendthnkkbn(C_KeiriyendthnkKbn.TORIKESI);
        yendthnkSikinIdouData.setSyoriYmd(pSysDate);
        yendthnkSikinIdouData.setSyouhncd(pKykSyouhnHnkmae.getSyouhncd());
        yendthnkSikinIdouData.setSyouhnsdno(pKykSyouhnHnkmae.getSyouhnsdno());
        yendthnkSikinIdouData.setSiteituuka(yendthnkSikinIdouDataKingakuBean.getSiteituuka());
        yendthnkSikinIdouData.setSiteituukagk(yendthnkSikinIdouDataKingakuBean.getSiteituukagk());
        yendthnkSikinIdouData.setTrhktuuka(yendthnkSikinIdouDataKingakuBean.getTrhktuuka());
        yendthnkSikinIdouData.setTrhktuukagk(yendthnkSikinIdouDataKingakuBean.getTrhktuukagk());

        hozenDomManager.insert(yendthnkSikinIdouData);
    }

    private void insertKhDenpyoData(BizDate pSysDate, KhozenCommonParam pKhozenCommonParam, C_Segcd pGaikaSeg1cd) {
        BM_TantouCd bMTantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
        String huridenatesakicd = bMTantouCd.getBusitucd();

        AS_Kinou kinou = baseDomManager.getDetachedKinou(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);
        String syoricd = kinou.getSyoricd();

        BizCurrency denyenkagk =
            khKaniKeiyakuNaiyouTeiseiDao.getKhDenpyoDataDenyenkagkBySyonoHuridenatesakicdTantocdSyoricdSeg1cdSeg1cd(
                uiBean.getSyono(), huridenatesakicd, C_TantouCdKbn.DAIRITENJIMUHOZEN,
                syoricd, pGaikaSeg1cd, uiBean.getSeg1cd());

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = Lists.newArrayList();

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
        bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        bzSiwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SYUUNYUU_V);
        bzSiwakeMeisaiBean.setIbSuitoubumoncd(huridenatesakicd);
        bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
        bzSiwakeMeisaiBean.setIbDenyenkagk(denyenkagk);
        bzSiwakeMeisaiBean.setIbSeg1cd(uiBean.getSeg1cd());
        bzSiwakeMeisaiBean.setIbSeg2cd(pGaikaSeg1cd);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean);

        bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
        bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V);
        bzSiwakeMeisaiBean.setIbSuitoubumoncd(huridenatesakicd);
        bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
        bzSiwakeMeisaiBean.setIbDenyenkagk(denyenkagk);
        bzSiwakeMeisaiBean.setIbSeg1cd(pGaikaSeg1cd);
        bzSiwakeMeisaiBean.setIbSeg2cd(uiBean.getSeg1cd());

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);
        bzDenpyouDataTourokuBean.setIbSyono(uiBean.getSyono());
        bzDenpyouDataTourokuBean.setIbHuridenatesakicd(huridenatesakicd);
        bzDenpyouDataTourokuBean.setIbTantocd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
        bzDenpyouDataTourokuBean.setIbDenymd(pSysDate);
        bzDenpyouDataTourokuBean.setIbTuukasyu(C_Tuukasyu.JPY);
        bzDenpyouDataTourokuBean.setIbSyoriymd(pSysDate);
        bzDenpyouDataTourokuBean.setIbSyoricd(syoricd);
        bzDenpyouDataTourokuBean.setIbSyorisosikicd(pKhozenCommonParam.getTmSosikiCd());
        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(bzSiwakeMeisaiBeanLst);

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);

        List<IT_KhDenpyoData> khDenpyoDataLst = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

        for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {
            hozenDomManager.insert(khDenpyoData);
        }
    }
}
