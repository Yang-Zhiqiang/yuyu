package yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou;

import static yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou.KhKoujyosyoumeiSaihakkouConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou.dba.KhKoujyosyoumeiSaihakkouDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiData;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiDataBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.HanteiHsgTokusinSyurui;
import yuyu.common.hozen.ascommon.HsigiTksnInfoBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditKoujyoSyoumeiParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KeisanKoujyogaku;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeisentakuKbn;
import yuyu.def.classification.C_KoujyosyoumeisyooutKbn;
import yuyu.def.classification.C_KoujyosyoumeisyuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SinsakuseiKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.OutputReport;

/**
 * 控除証明書再発行 のビジネスロジックです。
 */
public class KhKoujyosyoumeiSaihakkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKoujyosyoumeiSaihakkouUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KhKoujyosyoumeiSaihakkouDao khKoujyosyoumeiSaihakkouDao;

    @Inject
    private BaseUserInfo baseUserInfo;

    void init() {

        BizPropertyInitializer.initialize(uiBean);
        uiBean.setKjysyoumeinndhyjsuu(YuyuHozenConfig.getInstance().getKoujoSyomeiNendoHyojiNensuu());
    }

    void clear() {
    }

    void pushNyuryoku() {

        BizDate keiyakuYMD;
        int hyojiStartYear = 0;
        int hyojiEndYear = 0;
        BizDate sysDate = BizDate.getSysDate();
        int sysDateMonth = sysDate.getMonth();
        int sysDateYear = sysDate.getYear();

        String syono = uiBean.getSyono();
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        if (kykKihon != null) {
            uiBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
        }
        else {

            throw new BizLogicException(MessageId.EBA0090);
        }
        uiBean.setKykKihon(kykKihon);

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            ArrayList<String> warningMessageIDList = checkYuukouJyoutai.getWarningMessageIDList();
            ArrayList<String> warningMessageList = checkYuukouJyoutai.getWarningMessageList();
            for (int i = 0; i < warningMessageIDList.size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4
                    , warningMessageIDList.get(i)
                    , warningMessageList.get(i));
            }
        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syono);
        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            String messageID = hanteiTetuduki.getMessageID();
            String messageParam = hanteiTetuduki.getMessageParam();
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4
                , messageID
                , messageParam);
        }

        IT_Tokusin tokusin = khozenCommonParam.getTokusin(syono);

        if (tokusin != null && C_TokusinKbn.HISAIGAI.eq(tokusin.getTokusinkbn())) {

            HanteiHsgTokusinSyurui hanteiHsgTokusinSyurui = SWAKInjector.getInstance(HanteiHsgTokusinSyurui.class);

            HsigiTksnInfoBean hsigiTksnInfoBean = hanteiHsgTokusinSyurui.exec(tokusin.getHsgymd());

            uiBean.setKoujyosyoumeitkbttaiouumu(hsigiTksnInfoBean.getKoujyoSyoumeiTkbtTaiouUmu());

            if (C_UmuKbn.ARI.eq(uiBean.getKoujyosyoumeitkbttaiouumu())) {

                BzGetSousasyaSyozokuSosikiData bzGetSousasyaSyozokuSosikiData =
                    SWAKInjector.getInstance(BzGetSousasyaSyozokuSosikiData.class);

                BzGetSousasyaSyozokuSosikiDataBean bzGetSousasyaSyozokuSosikiDataBean =
                    bzGetSousasyaSyozokuSosikiData.exec(baseUserInfo.getUserId());

                if (!(C_Tantositucd.SYUUNOUSV.getValue() + "0000").equals(bzGetSousasyaSyozokuSosikiDataBean.getSosikicd())) {

                    throw new BizLogicException(MessageId.EIA1015, "被災害特伸契約");
                }
            }
        }

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnLst.size() != 0) {
            keiyakuYMD = kykSyouhnLst.get(0).getKykymd();
        }
        else {
            throw new CommonBizAppException("契約商品TBLにデータが存在しません。");
        }

        UserDefsList userList = new UserDefsList();

        if (C_Hrkkaisuu.ITIJI.eq(uiBean.getHrkkaisuu())) {
            List<String> koujyoSymNendoLst = hozenDomManager.getKoujyoSymNendosBySyono(syono);
            if (koujyoSymNendoLst.size() == 0) {
                throw new CommonBizAppException("控除証明書TBLにデータが存在しません。");
            }

            for (String koujyoSymNendo : koujyoSymNendoLst) {


                String warekiKoujyoSymNendo = DefaultDateFormatter.formatY(koujyoSymNendo);

                userList.add(new LabelValuePair(warekiKoujyoSymNendo, koujyoSymNendo));
            }

            uiBean.setKoujyosyoumeinndOptionBeanList(userList);
        }
        else {
            int keiyakuYMDYear = keiyakuYMD.getYear();

            if(sysDateYear < keiyakuYMDYear){
                hyojiStartYear = keiyakuYMDYear;
            }
            else if (sysDateMonth == 1 && sysDateYear != keiyakuYMDYear){
                hyojiStartYear = sysDateYear - 1;
            }
            else {
                hyojiStartYear = sysDateYear;
            }

            int kjySyoumeinndHyjsuu = uiBean.getKjysyoumeinndhyjsuu();

            if (keiyakuYMDYear > sysDateYear - kjySyoumeinndHyjsuu + 1) {
                hyojiEndYear = keiyakuYMDYear;
            }
            else {
                hyojiEndYear = sysDateYear - kjySyoumeinndHyjsuu + 1;
            }

            for(int nendo = hyojiStartYear; nendo >= hyojiEndYear; nendo--) {

                String warekiKoujyoSymNendo = DefaultDateFormatter.formatY(String.valueOf(nendo));

                userList.add(new LabelValuePair(warekiKoujyoSymNendo, String.valueOf(nendo)));
            }
            uiBean.setKoujyosyoumeinndOptionBeanList(userList);
        }
        uiBean.setLastsyoumeiendym(keiyakuYMD.getBizDateYM());

        setBP();
    }

    void pushKakunin(){

        if (C_KoujyosyoumeisyooutKbn.DENSI.eq(uiBean.getKoujyosyoumeisyooutkbn())) {
            if (BizDate.getSysDate().getMonth() > 3 && BizDate.getSysDate().getMonth() < 10) {
                throw new BizLogicException(MessageId.EIF1089);
            }
        }

        List<IT_KykSyouhn> kykSyouhnLst = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);
        C_YuukousyoumetuKbn yuukousyoumetuKbn = kykSyouhn.getYuukousyoumetukbn();
        C_Kykjyoutai kykjyoutai = kykSyouhn.getKykjyoutai();

        if (C_YuukousyoumetuKbn.SYOUMETU.eq(yuukousyoumetuKbn)) {
            if (BizDateY.valueOf(uiBean.getKoujyosyoumeinnd()).compareTo(kykSyouhn.getSyoumetuymd().getBizDateY()) > 0) {

                List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = khKoujyosyoumeiSaihakkouDao.getNyknJissekiRireki(
                    uiBean.getSyono(), BizDateY.valueOf(uiBean.getKoujyosyoumeinnd()), C_Nykkeiro.HKNKIN);

                if (nyknJissekiRirekiLst.size() == 0) {

                    throw new BizLogicException(MessageId.EIA0108, DefaultDateFormatter.formatY(uiBean.getKoujyosyoumeinnd()));
                }
            }
        }

        //        if (C_YuukousyoumetuKbn.YUUKOU.eq(yuukousyoumetuKbn) && C_Kykjyoutai.PMEN.eq(kykjyoutai)) {
        //            IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();
        //            if (BizDateY.valueOf(uiBean.getKoujyosyoumeinnd()).compareTo(kykSonotaTkyk.getPmnjtksknnkaisiymd().getBizDateY()) > 0) {
        //               throw new BizLogicException(MessageId.EIA0108, DefaultDateFormatter.formatY(uiBean.getKoujyosyoumeinnd()));
        //            }
        //        }

        Long count = hozenDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd(uiBean.getSyono()
            , uiBean.getKoujyosyoumeinnd()
            , BizDate.getSysDate());
        if (count != 0) {
            if (C_KoujyosyoumeisyooutKbn.PDF.eq(uiBean.getKoujyosyoumeisyooutkbn())) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5
                    , MessageId.WIF1002);
            }
            else {
                throw new BizLogicException(MessageId.EIA0145);
            }
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_KoujyosyoumeisyooutKbn.PDF.eq(uiBean.getKoujyosyoumeisyooutkbn()) &&
            C_UmuKbn.ARI.eq(uiBean.getKoujyosyoumeitkbttaiouumu()) &&
            C_Hrkkaisuu.TUKI.eq(uiBean.getHrkkaisuu())) {

            IT_AnsyuKihon ansyuuKihon = khozenCommonParam.getAnsyuuKihon(uiBean.getSyono());

            if (BizDateUtil.compareYm(ansyuuKihon.getJkipjytym(), BizDateYM.valueOf(
                Integer.valueOf(uiBean.getKoujyosyoumeinnd()), MONTH9)) == BizDateUtil.COMPARE_LESSER  ||
                BizDateUtil.compareYm(ansyuuKihon.getJkipjytym(),BizDateYM.valueOf(
                    Integer.valueOf(uiBean.getKoujyosyoumeinnd()), MONTH9)) == BizDateUtil.COMPARE_EQUAL) {

                throw new BizLogicException(MessageId.EIF1004, "被災害特伸契約", "控除証明書出力区分", "PDF以外");
            }
        }

        KeisanKoujyogaku keisanKoujyogaku = SWAKInjector.getInstance(KeisanKoujyogaku.class);
        keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);

        keisanKoujyogaku.exec(uiBean.getSyono(), uiBean.getKoujyosyoumeinnd());

        C_ChkkekkaKbn chkkekkaKbn = keisanKoujyogaku.getChkkekkaKbn();

        if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)){
            throw new BizLogicException(MessageId.EIF1104, uiBean.getSyono(), uiBean.getKoujyosyoumeinnd(),
                keisanKoujyogaku.getMessage());
        }

        EditKoujyoSyoumeiParam editKoujyoSyoumeiParam = keisanKoujyogaku.getParam();

        uiBean.setLastsyoumeiendym(keisanKoujyogaku.getEndSyoumeiEndYm());
        uiBean.setHrkkaisuu(editKoujyoSyoumeiParam.getHrkkaisuu());
        uiBean.setSyoumeiendym(editKoujyoSyoumeiParam.getSyoumeiEndYm());
        uiBean.setKoujyosyoumeimsgKbn(editKoujyoSyoumeiParam.getKoujyosyoumeimsgKbn());

        if (C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK.eq(uiBean.getKoujyosyoumeimsgKbn())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING6, MessageId.WIF3015);
        }

        String hrkKaisuu = "";

        if (C_Hrkkaisuu.TUKI.eq(editKoujyoSyoumeiParam.getHrkkaisuu())) {

            hrkKaisuu = HRKKAISUU_TUKI;
        }
        else if (C_Hrkkaisuu.HALFY.eq(editKoujyoSyoumeiParam.getHrkkaisuu())) {

            hrkKaisuu = HRKKAISUU_HALFY;
        }
        else if (C_Hrkkaisuu.NEN.eq(editKoujyoSyoumeiParam.getHrkkaisuu())) {

            hrkKaisuu = HRKKAISUU_NEN;
        }
        else {

            hrkKaisuu = HRKKAISUU_SONOTA;
        }

        uiBean.setDisptekiyouseidokbn(editKoujyoSyoumeiParam.getTekiyouSeidoKbn());
        uiBean.setDispnenkanhrkkaisuu(hrkKaisuu);
        uiBean.setDispsyoumeistartym(editKoujyoSyoumeiParam.getSyoumeiStartYm());
        if (editKoujyoSyoumeiParam.getSyoumeiEndYm() != null &&
            (C_YuukousyoumetuKbn.SYOUMETU.eq(yuukousyoumetuKbn) ||
                (C_YuukousyoumetuKbn.YUUKOU.eq(yuukousyoumetuKbn) && C_Kykjyoutai.PMEN.eq(kykjyoutai)))) {
            uiBean.setDispsyoumeiendym(editKoujyoSyoumeiParam.getSyoumeiEndYm());
        }
        else {
            uiBean.setDispsyoumeiendym(uiBean.getLastsyoumeiendym());
        }
        uiBean.setDispnewippanjissekisymgk(editKoujyoSyoumeiParam.getNewIppanJissekiSyoumeigk());
        uiBean.setDispnewippannenkansymgk(editKoujyoSyoumeiParam.getNewIppanNenkanSyoumeigk());
        uiBean.setDispnewiryoujissekisymgk(editKoujyoSyoumeiParam.getNewIryouJissekiSyoumeigk());
        uiBean.setDispnewiryounenkansymgk(editKoujyoSyoumeiParam.getNewIryouNenkanSyoumeigk());
        uiBean.setDispnewnkjissekisymgk(editKoujyoSyoumeiParam.getNewNenkinJissekiSyoumeigk());
        uiBean.setDispnewnknenkansymgk(editKoujyoSyoumeiParam.getNewNenkinNenkanSyoumeigk());
        uiBean.setDispnewippanjissekip(editKoujyoSyoumeiParam.getNewIppanJissekiP());
        uiBean.setDispnewippannenkanp(editKoujyoSyoumeiParam.getNewIppanNenkanP());
        uiBean.setDispnewiryoujissekip(editKoujyoSyoumeiParam.getNewIryouJissekiP());
        uiBean.setDispnewiryounenkanp(editKoujyoSyoumeiParam.getNewIryouNenkanP());
        uiBean.setDispnewnkjissekip(editKoujyoSyoumeiParam.getNewNenkinJissekiP());
        uiBean.setDispnewnknenkanp(editKoujyoSyoumeiParam.getNewNenkinNenkanP());
        uiBean.setDispnewippanjissekihtkin(editKoujyoSyoumeiParam.getNewIppanJissekiHaitoukin());
        uiBean.setDispnewippannenkanhtkin(editKoujyoSyoumeiParam.getNewIppanNenkanHaitoukin());
        uiBean.setDispnewiryoujissekihtkin(editKoujyoSyoumeiParam.getNewIryouJissekiHaitoukin());
        uiBean.setDispnewiryounenkanhtkin(editKoujyoSyoumeiParam.getNewIryouNenkanHaitoukin());
        uiBean.setDispnewnkjissekihtkin(editKoujyoSyoumeiParam.getNewNenkinJissekiHaitoukin());
        uiBean.setDispnewnknenkanhtkin(editKoujyoSyoumeiParam.getNewNenkinNenkanHaitoukin());

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushModoruBtnByConfirm() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING5);
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING6);
    }

    @Transactional
    void pushKakutei(){

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();
        String syono = uiBean.getSyono();
        BizDate syoumeiYmd = sysDate;
        IT_KykKihon kykKihon = uiBean.getKykKihon();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        if(C_UmuKbn.NONE.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu()) &&
            uiBean.getDispnewnknenkansymgk().compareTo(BizCurrency.valueOf(0, uiBean.getDispnewnknenkansymgk().getType())) > 0){
            throw new BizLogicException(MessageId.EIA3010);
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String skbtKey = khozenCommonParam.getSikibetuKey(syono);

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        tableMaintenanceUtil.backUp(syono, skbtKey);

        kykKihon.setSyhenkouymd(sysDate);
        kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        kykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        kykKihon.setGyoumuKousinTime(sysTime);

        EditKoujyoSyoumeiParam editKoujyoSyoumeiParam = SWAKInjector.getInstance(EditKoujyoSyoumeiParam.class);

        C_KoujyosyoumeisakuseisyoriKbn koujyoSakuseisyorikbn = C_KoujyosyoumeisakuseisyoriKbn.BLNK;

        if (C_KoujyosyoumeisyooutKbn.PDF.eq(uiBean.getKoujyosyoumeisyooutkbn())) {
            koujyoSakuseisyorikbn = C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_PDF;
        }
        else {
            koujyoSakuseisyorikbn = C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU;
        }

        C_KoujyosyoumeisentakuKbn koujyosyoumeisentakuKbn = C_KoujyosyoumeisentakuKbn.BLANK;

        if (C_KoujyosyoumeisyooutKbn.PDF.eq(uiBean.getKoujyosyoumeisyooutkbn())) {

            koujyoSakuseisyorikbn = C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_PDF;
            koujyosyoumeisentakuKbn = C_KoujyosyoumeisentakuKbn.BLANK;
        }
        else {

            koujyoSakuseisyorikbn = C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU;
            if (C_KoujyosyoumeisyooutKbn.HAGAKI.eq(uiBean.getKoujyosyoumeisyooutkbn())) {

                koujyosyoumeisentakuKbn = C_KoujyosyoumeisentakuKbn.HAGAKI;
            }

            if (C_KoujyosyoumeisyooutKbn.DENSI.eq(uiBean.getKoujyosyoumeisyooutkbn())) {

                koujyosyoumeisentakuKbn = C_KoujyosyoumeisentakuKbn.DENSI;
            }
        }

        BizDate koujyosyoumeinensaisyueigyouymd = BizDate.valueOf(String.valueOf(uiBean.getKoujyosyoumeinnd()) +
            KhKoujyosyoumeiSaihakkouConstants.NENMATU).addBusinessDays(-1);

        if(BizDateUtil.compareYmd(koujyosyoumeinensaisyueigyouymd,sysDate ) == BizDateUtil.COMPARE_LESSER  ){

            syoumeiYmd = koujyosyoumeinensaisyueigyouymd;
        }

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setKoujyoNendo(uiBean.getKoujyosyoumeinnd());
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(koujyoSakuseisyorikbn);
        editKoujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(koujyosyoumeisentakuKbn);
        editKoujyoSyoumeiParam.setSyoumeiYmd(syoumeiYmd);
        editKoujyoSyoumeiParam.setHrkkaisuu(uiBean.getHrkkaisuu());
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(uiBean.getDisptekiyouseidokbn());
        editKoujyoSyoumeiParam.setSyoumeiStartYm(uiBean.getDispsyoumeistartym());
        editKoujyoSyoumeiParam.setSyoumeiEndYm(uiBean.getSyoumeiendym());
        editKoujyoSyoumeiParam.setNewIppanJissekiP(uiBean.getDispnewippanjissekip());
        editKoujyoSyoumeiParam.setNewIppanNenkanP(uiBean.getDispnewippannenkanp());
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(uiBean.getDispnewippanjissekihtkin());
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(uiBean.getDispnewippannenkanhtkin());
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(uiBean.getDispnewippanjissekisymgk());
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(uiBean.getDispnewippannenkansymgk());
        editKoujyoSyoumeiParam.setNewIryouJissekiP(uiBean.getDispnewiryoujissekip());
        editKoujyoSyoumeiParam.setNewIryouNenkanP(uiBean.getDispnewiryounenkanp());
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(uiBean.getDispnewiryoujissekihtkin());
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(uiBean.getDispnewiryounenkanhtkin());
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(uiBean.getDispnewiryoujissekisymgk());
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(uiBean.getDispnewiryounenkansymgk());
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(uiBean.getDispnewnkjissekip());
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(uiBean.getDispnewnknenkanp());
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(uiBean.getDispnewnkjissekihtkin());
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(uiBean.getDispnewnknenkanhtkin());
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(uiBean.getDispnewnkjissekisymgk());
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(uiBean.getDispnewnknenkansymgk());
        editKoujyoSyoumeiParam.setSaihkhyjkbn(uiBean.getSaihkhyjkbn());
        editKoujyoSyoumeiParam.setKoujyosyoumeimsgKbn(uiBean.getKoujyosyoumeimsgKbn());


        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.TYOKUSOU);
        khozenTyouhyouCtl.setSyoriYmd(sysDate);
        khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);

        C_YouhiKbn pdfoutKbn = null;

        if (C_KoujyosyoumeisyooutKbn.PDF.eq(uiBean.getKoujyosyoumeisyooutkbn())) {

            pdfoutKbn = C_YouhiKbn.YOU;
        }
        else {

            pdfoutKbn = C_YouhiKbn.HUYOU;
        }

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syono,
            new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS}, pdfoutKbn);

        IT_KoujyoSymKanri koujyoSymKanri = kykKihon.getKoujyoSymKanriByNendo(uiBean.getKoujyosyoumeinnd());

        if (koujyoSymKanri == null) {
            koujyoSymKanri = kykKihon.createKoujyoSymKanri();
            koujyoSymKanri.setNendo(uiBean.getKoujyosyoumeinnd());
            koujyoSymKanri.setLastsyoumeiendym(uiBean.getLastsyoumeiendym());
            koujyoSymKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            koujyoSymKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            koujyoSymKanri.setGyoumuKousinTime(sysTime);
            BizPropertyInitializer.initialize(koujyoSymKanri);
        }
        else {
            koujyoSymKanri.setLastsyoumeiendym(uiBean.getLastsyoumeiendym());
            koujyoSymKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            koujyoSymKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            koujyoSymKanri.setGyoumuKousinTime(sysTime);
        }

        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = khKoujyosyoumeiSaihakkouDao.getKoujyoSymNaiyou(kykKihon,
            uiBean.getKoujyosyoumeinnd());

        for (IT_KoujyoSymNaiyou koujyoSymNaiyou : koujyoSymNaiyouLst) {
            koujyoSymNaiyou.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);
            koujyoSymNaiyou.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            koujyoSymNaiyou.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            koujyoSymNaiyou.setGyoumuKousinTime(sysTime);
        }

        List<IT_KoujyoSymNaiyouD> koujyoSymNaiyouDLst = khKoujyosyoumeiSaihakkouDao.getKoujyoSymNaiyouD(kykKihon,
            uiBean.getKoujyosyoumeinnd());

        for (IT_KoujyoSymNaiyouD koujyoSymNaiyouD : koujyoSymNaiyouDLst) {
            koujyoSymNaiyouD.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);
            koujyoSymNaiyouD.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            koujyoSymNaiyouD.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            koujyoSymNaiyouD.setGyoumuKousinTime(sysTime);
        }

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(syono);
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSysTime(sysTime);

        IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
        khTtdkRireki.setHenkousikibetukey(skbtKey);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        hozenDomManager.update(kykKihon);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING5);
        messageManager.addMessageId(MessageId.IAC0009);
    }

    void printOut() {

        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        outputReport.outputPDFByJoinKey(uiBean.getTyouhyoukey());
    }


    private void setBP() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(khozenCommonParam,uiBean);
        SetKihon.exec(khozenCommonParam, uiBean);
        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(khozenCommonParam, uiBean);
        List<String> warningMessageIdList = uiBean.getWarningMessageIdList();
        List<String> warningMessageList = uiBean.getWarningMessageList();
        for (int i = 0; i < warningMessageIdList.size(); i++) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4
                , BizUtil.getGeneralMessageId(warningMessageIdList.get(i))
                , warningMessageList.get(i));
        }


        SetTetudukityuui.exec(khozenCommonParam, uiBean);
        SetKeiyakusya.exec(khozenCommonParam, uiBean);
        SetTuusinsaki.exec(khozenCommonParam, uiBean);
        SetHihokensya.exec(khozenCommonParam, uiBean);
        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(khozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(khozenCommonParam, uiBean);
    }
}