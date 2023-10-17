package yuyu.app.hozen.khansyuu.khonlinenyuukin;

import static yuyu.app.hozen.khansyuu.khonlinenyuukin.GenKhOnlineNyuukinConstants.*;
import static yuyu.app.hozen.khansyuu.khonlinenyuukin.KhOnlineNyuukinConstants.*;

import java.util.ArrayList;
import java.util.List;

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

import yuyu.app.hozen.khansyuu.khonlinenyuukin.dba.KhOnlineNyuukinDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.CheckHrkkigetuMitouraiP;
import yuyu.common.hozen.ascommon.GetHrkKawaseRateKijyun;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsn;
import yuyu.common.hozen.ascommon.KeisanRsgakuConstants;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CommonNyuukin;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.JtKaisukeisan;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.NyuukinTRParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HrkeIraiInfo;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.infr.report.OutputReport;

/**
 * オンライン入金処理 のビジネスロジックです。
 */
public class KhOnlineNyuukinBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhOnlineNyuukinUiBean uiBean;

    @Inject
    private ErrorMessageCollector errMessages;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KhOnlineNyuukinDao khOnlineNyuukinDao;

    void init() {
        clear();
    }

    void clear() {
    }

    void pushInput() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        String syoNo = uiBean.getSyono();

        IT_KykKihon kykKihon = khOnlineNyuukinDao.getKykKihon(syoNo);

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            if (uiBean.getKrkno() == null) {
                throw new BizLogicException(MessageId.EIF3023);
            }
        }
        else {
            if (uiBean.getKrkno() != null) {
                throw new BizLogicException(MessageId.EIF3021);
            }
        }

        List<IT_HrkeIraiInfo> hrkeIraiInfoList = new ArrayList<IT_HrkeIraiInfo>();

        IT_Kariukekin kariukekin = new IT_Kariukekin();

        //        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou())) {
        //            IT_AnsyuKihon ansyuKihon = khOnlineNyuukinDao.getAnsyuKihon(syoNo);
        //
        //            hrkeIraiInfoList = khOnlineNyuukinDao.getHrkeIraiInfos(ansyuKihon);
        //
        //            if (hrkeIraiInfoList.size() == 0) {
        //                throw new BizLogicException(MessageId.EIF3022);
        //            }
        //        }

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            kariukekin = khOnlineNyuukinDao.getKariukekin(kykKihon, uiBean.getKrkno());

            if (kariukekin == null) {
                throw new BizLogicException(MessageId.EIA0091);
            }
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

            for (int i = 0; i<warningMessageIdList.size(); i++) {
                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    BizUtil.getGeneralMessageId(warningMessageIdList.get(i)), warningMessageList.get(i));
            }
        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syoNo);

        if(C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }


        ArrayList<HrkeiraiInfoDataSourceBean> hrkeiraiInfoDataSourceBeanList = new ArrayList<>();

        for (IT_HrkeIraiInfo hrkeIraiInfo : hrkeIraiInfoList) {
            HrkeiraiInfoDataSourceBean hrkeiraiInfoDataSourceBean = SWAKInjector.getInstance(HrkeiraiInfoDataSourceBean.class);

            hrkeiraiInfoDataSourceBean.setNykntaisyouchkbox(false);
            hrkeiraiInfoDataSourceBean.setHenkouSikibetuKey(hrkeIraiInfo.getHenkousikibetukey());
            hrkeiraiInfoDataSourceBean.setNyknaiyoukbn(hrkeIraiInfo.getNyknaiyoukbn());
            hrkeiraiInfoDataSourceBean.setJyuutouym(hrkeIraiInfo.getJyuutouym());
            hrkeiraiInfoDataSourceBean.setJyutoukaisuuy(hrkeIraiInfo.getJyutoukaisuuy());
            hrkeiraiInfoDataSourceBean.setJyutoukaisuum(hrkeIraiInfo.getJyutoukaisuum());
            hrkeiraiInfoDataSourceBean.setHrkkigen(hrkeIraiInfo.getHrkkigen());
            hrkeiraiInfoDataSourceBean.setKzkpannaijiyuukbn(hrkeIraiInfo.getKzkpannaijiyuukbn());
            hrkeiraiInfoDataSourceBean.setHrkiraikngk(hrkeIraiInfo.getHrkiraikngk());
            hrkeiraiInfoDataSourceBean.setComment124keta(hrkeIraiInfo.getComment124keta());

            hrkeiraiInfoDataSourceBeanList.add(hrkeiraiInfoDataSourceBean);
        }

        if (hrkeIraiInfoList.size() == 1) {
            hrkeiraiInfoDataSourceBeanList.get(0).setNykntaisyouchkbox(true);
        }

        uiBean.setHrkeiraiInfo(hrkeiraiInfoDataSourceBeanList);

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            uiBean.setKrkkeijyoymd(kariukekin.getKrkkeijyoymd());
            uiBean.setKrkriyuukbn(kariukekin.getKrkriyuukbn());
            uiBean.setHasseidenymd(kariukekin.getHasseidenymd());
            uiBean.setDisphrkkaisuu(kariukekin.getHrkkaisuu());
            uiBean.setNykinputhrkkaisuu(kariukekin.getHrkkaisuu());
            uiBean.setDisptikiktbrisyuruikbn(kariukekin.getTikiktbrisyuruikbn());
            uiBean.setNykinputtikiktbrisyuruikbn(kariukekin.getTikiktbrisyuruikbn());
            uiBean.setDispnykkeiro(kariukekin.getNykkeiro());
            uiBean.setNykinputnykkeiro(kariukekin.getNykkeiro());
            uiBean.setDispnyknaiyoukbn(kariukekin.getNyknaiyoukbn());
            uiBean.setNykinputnyknaiyoukbn(kariukekin.getNyknaiyoukbn());
            uiBean.setDispjyuutouym(kariukekin.getJyuutouym());
            uiBean.setNykinputjyuutouym(kariukekin.getJyuutouym());
            uiBean.setDispjyutoukaisuuy(kariukekin.getJyutoukaisuuy());
            uiBean.setNykinputjyutoukaisuuy(zero2null(kariukekin.getJyutoukaisuuy()));
            uiBean.setDispjyutoukaisuum(kariukekin.getJyutoukaisuum());
            uiBean.setNykinputjyutoukaisuum(zero2null(kariukekin.getJyutoukaisuum()));
            uiBean.setDispryosyuymd(kariukekin.getRyosyuymd());
            uiBean.setNykinputryosyuymd(kariukekin.getRyosyuymd());
            uiBean.setKrkgk(kariukekin.getKrkgk());
            uiBean.setCreditkessaiyouno(kariukekin.getCreditkessaiyouno());
        }
        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou()) ||
            C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
                uiBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
                uiBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
                uiBean.setNyknaiyoukbn(C_NyknaiyouKbn.BLNK);
            }
            uiBean.setNykkeiro(C_Nykkeiro.BANK);
            uiBean.setDispjyutoukaisuuy(0);
            uiBean.setDispjyutoukaisuum(0);
            uiBean.setTabakarikanjyono("95");
            uiBean.setSuitososhikicd(C_Tantositucd.SYUUNOUSV.getValue() + "0000");
        }

        setUiBean(khozenCommonParam);
    }

    void pushKakuninBL() {

        checkZero();

        BM_SyouhnZokusei syouhnZokusei = khOnlineNyuukinDao.getSyouhnZokusei(uiBean.getKykKihon());

        C_UmuKbn teikiikkatubaraiumu = syouhnZokusei.getTeikiikkatubaraiumu();

        if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            if (C_Hrkkaisuu.TUKI.eq(uiBean.getHrkkaisuu())) {
                if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getTikiktbrisyuruikbn())) {
                    if (C_UmuKbn.ARI.eq(teikiikkatubaraiumu)) {
                        uiBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);
                    }
                    else {
                        uiBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
                    }
                }
                else if (C_TkiktbrisyuruiKbn.NONE.eq(uiBean.getTikiktbrisyuruikbn())) {
                    if (C_UmuKbn.ARI.eq(teikiikkatubaraiumu)) {
                        uiBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);
                    }
                    else {
                        uiBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
                    }
                }
            }
            else {
                uiBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
            }

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getTikiktbrisyuruikbn())) {
                if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNyknaiyoukbn())) {
                    uiBean.setJyutoukaisuuy(null);
                    uiBean.setJyutoukaisuum(6);
                }
                else {
                    uiBean.setJyutoukaisuuy(null);
                    uiBean.setJyutoukaisuum(null);
                }
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getTikiktbrisyuruikbn())) {
                if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNyknaiyoukbn())) {
                    uiBean.setJyutoukaisuuy(null);
                    uiBean.setJyutoukaisuum(12);
                }
                else {
                    uiBean.setJyutoukaisuuy(null);
                    uiBean.setJyutoukaisuum(null);
                }
            }
        }
        else if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            if (C_Hrkkaisuu.TUKI.eq(uiBean.getNykinputhrkkaisuu())) {
                if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getNykinputtikiktbrisyuruikbn())) {
                    if (C_UmuKbn.ARI.eq(teikiikkatubaraiumu)) {
                        uiBean.setNykinputtikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);
                    }
                    else {
                        uiBean.setNykinputtikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
                    }
                }
                else if (C_TkiktbrisyuruiKbn.NONE.eq(uiBean.getNykinputtikiktbrisyuruikbn())) {
                    if (C_UmuKbn.ARI.eq(teikiikkatubaraiumu)) {
                        uiBean.setNykinputtikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);
                    }
                    else {
                        uiBean.setNykinputtikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
                    }
                }
            }
            else {
                uiBean.setNykinputtikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
            }

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getNykinputtikiktbrisyuruikbn())) {
                if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNykinputnyknaiyoukbn())) {
                    uiBean.setNykinputjyutoukaisuuy(null);
                    uiBean.setNykinputjyutoukaisuum(6);
                }
                else {
                    uiBean.setNykinputjyutoukaisuuy(null);
                    uiBean.setNykinputjyutoukaisuum(null);
                }
            }
            if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getNykinputtikiktbrisyuruikbn())) {
                if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNykinputnyknaiyoukbn())) {
                    uiBean.setNykinputjyutoukaisuuy(null);
                    uiBean.setNykinputjyutoukaisuum(12);
                }
                else {
                    uiBean.setNykinputjyutoukaisuuy(null);
                    uiBean.setNykinputjyutoukaisuum(null);
                }
            }
        }
        String syoNo = uiBean.getSyono();
        C_NyknaiyouKbn nyknaiyoukbn = uiBean.getNyknaiyoukbn();
        BizDate ryosyuymd = uiBean.getRyosyuymd();
        BizDate tyakkinymd = uiBean.getTyakkinymd();
        BizCurrency ryosyugk = uiBean.getRsgaku();

        BizDate sysDate = BizDate.getSysDate();

        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou())) {
            uiBean.setNykkeiroSyoriyou(uiBean.getNykkeiro());

            uiBean.setRsgakuSyoriyou(uiBean.getRsgaku());

            uiBean.setRyosyuymdSyoriyou(uiBean.getRyosyuymd());
        }
        else if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            uiBean.setHrkkaisuuSyoriyou(uiBean.getNykinputhrkkaisuu());

            uiBean.setTikiktbrisyuruikbnSyoriyou(uiBean.getNykinputtikiktbrisyuruikbn());

            uiBean.setNykkeiroSyoriyou(uiBean.getNykinputnykkeiro());

            uiBean.setNyknaiyoukbnSyoriyou(uiBean.getNykinputnyknaiyoukbn());

            uiBean.setJyuutouymSyoriyou(uiBean.getNykinputjyuutouym());

            uiBean.setJyutoukaisuuySyoriyou(uiBean.getNykinputjyutoukaisuuy());

            uiBean.setJyutoukaisuumSyoriyou(uiBean.getNykinputjyutoukaisuum());

            uiBean.setRsgakuSyoriyou(uiBean.getKrkgk());

            uiBean.setRyosyuymdSyoriyou(uiBean.getNykinputryosyuymd());
        }
        else if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            uiBean.setHrkkaisuuSyoriyou(uiBean.getHrkkaisuu());

            uiBean.setTikiktbrisyuruikbnSyoriyou(uiBean.getTikiktbrisyuruikbn());

            uiBean.setNykkeiroSyoriyou(uiBean.getNykkeiro());

            uiBean.setNyknaiyoukbnSyoriyou(uiBean.getNyknaiyoukbn());

            uiBean.setJyuutouymSyoriyou(uiBean.getJyuutouym());

            uiBean.setJyutoukaisuuySyoriyou(uiBean.getJyutoukaisuuy());

            uiBean.setJyutoukaisuumSyoriyou(uiBean.getJyutoukaisuum());

            uiBean.setRsgakuSyoriyou(uiBean.getRsgaku());

            uiBean.setRyosyuymdSyoriyou(uiBean.getRyosyuymd());
        }


        boolean checkFlg = checkJyoukentukiHissu(HRKKAISUU, uiBean.getNykhouhou());

        if (checkFlg) {
            if (C_Hrkkaisuu.BLNK.eq(uiBean.getHrkkaisuu())) {
                errMessages.addMessage(MessageId.EAC0042, DDID_NYUUKINSYORIINFO_HRKKAISUU);
            }
        }

        checkFlg = checkJyoukentukiHissu(NYKNAIYOUKBN, uiBean.getNykhouhou());

        if (checkFlg) {
            if (C_NyknaiyouKbn.BLNK.eq(nyknaiyoukbn)) {
                errMessages.addMessage(MessageId.EAC0042, DDID_NYUUKINSYORIINFO_NYKNAIYOUKBN);
            }
        }

        checkFlg = checkJyoukentukiHissu(RYOSYUYMD, uiBean.getNykhouhou());

        if (checkFlg) {
            if (ryosyuymd == null) {
                errMessages.addMessage(MessageId.EAC0042, DDID_NYUUKINSYORIINFO_RYOSYUYMD);
            }
        }

        checkFlg = checkJyoukentukiHissu(TYAKKINYMD, uiBean.getNykhouhou());

        if (checkFlg) {
            if (tyakkinymd == null) {
                errMessages.addMessage(MessageId.EAC0042, DDID_NYUUKINSYORIINFO_TYAKKINYMD);
            }
        }

        checkFlg = checkJyoukentukiHissu(RSGAKU, uiBean.getNykhouhou());

        if (checkFlg) {
            if (ryosyugk.isOptional()) {
                errMessages.addMessage(MessageId.EAC0042, DDID_NYUUKINSYORIINFO_RSGAKU);
            }
        }

        checkFlg = checkJyoukentukiHissu(NYKINPUTDENYMD, uiBean.getNykhouhou());

        if (checkFlg) {
            if (uiBean.getNykinputdenymd() == null) {
                errMessages.addMessage(MessageId.EAC0042, DDID_NYUUKINSYORIINFO_NYKINPUTDENYMD);
            }
        }

        checkFlg = checkJyoukentukiHissu(SUITOSOSHIKICD, uiBean.getNykhouhou());

        if (checkFlg) {
            if (BizUtil.isBlank(uiBean.getSuitososhikicd())) {
                errMessages.addMessage(MessageId.EAC0042, DDID_NYUUKINSYORIINFO_SUITOSOSHIKICD);
            }
        }

        checkFlg = checkJyoukentukiHissu(TABAKARIKANJYONO, uiBean.getNykhouhou());

        if (checkFlg) {
            if (BizUtil.isBlank(uiBean.getTabakarikanjyono())) {
                errMessages.addMessage(MessageId.EAC0042, DDID_NYUUKINSYORIINFO_TABAKARIKANJYONO);
            }
        }

        checkFlg = checkJyoukentukiHissu(NYKINPUTHRKKAISUU, uiBean.getNykhouhou());

        if (checkFlg) {
            if (C_Hrkkaisuu.BLNK.eq(uiBean.getNykinputhrkkaisuu())) {
                errMessages.addMessage(MessageId.EAC0042, DDID_KARIUKEKININFO_NYKINPUTHRKKAISUU);
            }
        }

        checkFlg = checkJyoukentukiHissu(NYKINPUTNYKKEIRO, uiBean.getNykhouhou());

        if (checkFlg) {
            if (C_Nykkeiro.BLNK.eq(uiBean.getNykinputnykkeiro())) {
                errMessages.addMessage(MessageId.EAC0042, DDID_KARIUKEKININFO_NYKINPUTNYKKEIRO);
            }
        }

        checkFlg = checkJyoukentukiHissu(NYKINPUTNYKNAIYOUKBN, uiBean.getNykhouhou());

        if (checkFlg) {
            if (C_NyknaiyouKbn.BLNK.eq(uiBean.getNykinputnyknaiyoukbn())) {
                errMessages.addMessage(MessageId.EAC0042, DDID_KARIUKEKININFO_NYKINPUTNYKNAIYOUKBN);
            }
        }

        checkFlg = checkJyoukentukiHissu(NYKINPUTRYOSYUYMD, uiBean.getNykhouhou());

        if (checkFlg) {
            if (uiBean.getNykinputryosyuymd() == null) {
                errMessages.addMessage(MessageId.EAC0042, DDID_KARIUKEKININFO_NYKINPUTRYOSYUYMD);
            }
        }

        if (errMessages.exists()) {
            throw new BizLogicException(errMessages);
        }

        if (BizDateUtil.compareYmd(uiBean.getRyosyuymdSyoriyou(), sysDate) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EIA0078);
        }

        if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou()) ) {
            if (BizCurrencyTypes.YEN == uiBean.getRsgakuSyoriyou().getType() ) {
                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getRsgakuSyoriyou()) <= 0) {
                    throw new BizLogicException(MessageId.EBV0046, MAX_KYOYOUKINGAKUYEN_MSG);
                }
            }
        }

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou()) ) {
            if (C_NyknaiyouKbn.ZENNOUP.eq(uiBean.getNyknaiyoukbnSyoriyou()) ) {
                throw new BizLogicException(MessageId.EIF3037);
            }
            else if (C_NyknaiyouKbn.OTHER.eq(uiBean.getNyknaiyoukbnSyoriyou())) {
                throw new BizLogicException(MessageId.EIF3069);
            }
        }

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou()) || C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {

            if (C_TkiktbrisyuruiKbn.NONE.eq(uiBean.getTikiktbrisyuruikbnSyoriyou()) ||
                C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getTikiktbrisyuruikbnSyoriyou())) {
                if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNyknaiyoukbnSyoriyou())) {
                    if (uiBean.getJyuutouymSyoriyou() == null) {
                        throw new BizLogicException(MessageId.EIA0079);
                    }

                    if (uiBean.getJyutoukaisuuySyoriyou() == null && uiBean.getJyutoukaisuumSyoriyou() == null) {
                        throw new BizLogicException(MessageId.EIA0079);
                    }
                }
                else {
                    if (uiBean.getJyuutouymSyoriyou() == null) {
                        if (uiBean.getJyutoukaisuuySyoriyou() == null) {
                            if (uiBean.getJyutoukaisuumSyoriyou() != null) {
                                throw new BizLogicException(MessageId.EIA0080);
                            }
                        }
                        else {
                            throw new BizLogicException(MessageId.EIA0080);
                        }
                    }
                    else {
                        throw new BizLogicException(MessageId.EIA0080);
                    }
                }
            }

            if (uiBean.getJyutoukaisuuySyoriyou() != null && uiBean.getJyutoukaisuumSyoriyou() != null) {
                throw new BizLogicException(MessageId.EIF3042);
            }

        }

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNyknaiyoukbnSyoriyou())) {
                if (C_Nykkeiro.CREDIT.eq(uiBean.getNykkeiroSyoriyou())) {
                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getTikiktbrisyuruikbnSyoriyou()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getTikiktbrisyuruikbnSyoriyou())) {
                        throw new BizLogicException(MessageId.EIF3054);
                    }
                }
            }
        }

        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou())) {
            int sentakuSuu = 0;

            for (HrkeiraiInfoDataSourceBean hrkeiraiInfoDataSourceBean : uiBean.getHrkeiraiInfoDataSource().getAllData()) {
                if (hrkeiraiInfoDataSourceBean.getNykntaisyouchkbox()) {
                    sentakuSuu = sentakuSuu + 1;
                }
            }

            if (sentakuSuu == 0) {
                throw new BizLogicException(MessageId.EIF3026);
            }

            if (sentakuSuu > 1) {
                throw new BizLogicException(MessageId.EIF3027);
            }

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(uiBean.getSuitososhikicd());

            if (C_SosikimasterUmuKbn.NONE.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                throw new BizLogicException(MessageId.EIF3030);
            }
        }
        else if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            IT_Kariukekin kariukekin = khOnlineNyuukinDao.getKariukekin2(uiBean.getKykKihon(), uiBean.getKrkno());

            if (C_Nykkeiro.KZHRK.eq(kariukekin.getNykkeiro())) {
                if (C_Nykkeiro.CREDIT.eq(uiBean.getNykkeiroSyoriyou()) ||
                    C_Nykkeiro.OTHER.eq(uiBean.getNykkeiroSyoriyou())) {
                    throw new BizLogicException(MessageId.EIF3025, kariukekin.getNykkeiro().getContent(C_Nykkeiro.PATTERN_SELECT),
                        uiBean.getNykkeiroSyoriyou().getContent(C_Nykkeiro.PATTERN_SELECT));
                }
            }
            else if (C_Nykkeiro.CREDIT.eq(kariukekin.getNykkeiro())) {
                if (C_Nykkeiro.KZHRK.eq(uiBean.getNykkeiroSyoriyou()) ||
                    C_Nykkeiro.OTHER.eq(uiBean.getNykkeiroSyoriyou())) {
                    throw new BizLogicException(MessageId.EIF3025, kariukekin.getNykkeiro().getContent(C_Nykkeiro.PATTERN_SELECT),
                        uiBean.getNykkeiroSyoriyou().getContent(C_Nykkeiro.PATTERN_SELECT));
                }
            }
            else if (C_Nykkeiro.BANK.eq(kariukekin.getNykkeiro())) {
                if (C_Nykkeiro.OTHER.eq(uiBean.getNykkeiroSyoriyou())) {
                    throw new BizLogicException(MessageId.EIF3025, kariukekin.getNykkeiro().getContent(C_Nykkeiro.PATTERN_SELECT),
                        uiBean.getNykkeiroSyoriyou().getContent(C_Nykkeiro.PATTERN_SELECT));
                }
            }

            if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNyknaiyoukbnSyoriyou())) {

                int jyutoukaisuuy = 0;
                int jyutoukaisuum = 0;

                if (uiBean.getJyutoukaisuuySyoriyou() != null) {
                    jyutoukaisuuy = uiBean.getJyutoukaisuuySyoriyou();
                }

                if (uiBean.getJyutoukaisuumSyoriyou() != null) {
                    jyutoukaisuum = uiBean.getJyutoukaisuumSyoriyou();
                }

                if (C_Hrkkaisuu.HALFY.eq(uiBean.getHrkkaisuuSyoriyou())
                    || C_Hrkkaisuu.NEN.eq(uiBean.getHrkkaisuuSyoriyou())) {

                    JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

                    jtKaisukeisan.exec(jyutoukaisuuy, jyutoukaisuum,uiBean.getHrkkaisuuSyoriyou());

                    int jyutouKaisuu = jtKaisukeisan.getJyutoukaisuu();

                    CheckHrkkigetuMitouraiP checkHrkkigetuMitouraiP =
                        SWAKInjector.getInstance(CheckHrkkigetuMitouraiP.class);

                    boolean existsFlg = checkHrkkigetuMitouraiP.exists(uiBean.getRyosyuymdSyoriyou(),
                        uiBean.getJyuutouymSyoriyou(), uiBean.getHrkkaisuuSyoriyou(),
                        jyutoukaisuuy, jyutoukaisuum);

                    if (jyutouKaisuu > 1 && existsFlg) {
                        throw new BizLogicException(MessageId.EIF3078);
                    }
                }

                GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);

                C_ErrorKbn kekkaKbn =  getasPRsTuuka.exec(uiBean.getSyono());

                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                    throw new CommonBizAppException("保険料領収通貨取得エラー。　証券番号＝" + uiBean.getSyono());
                }

                C_Tuukasyu rstuukasyu = getasPRsTuuka.getRstuukasyu();

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu tuukaSyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getKykKihon().getHrkp().getType());

                if (!tuukaSyu.eq(rstuukasyu)) {

                    GetHrkKawaseRateKijyun getHrkKawaseRateKijyun =
                        SWAKInjector.getInstance(GetHrkKawaseRateKijyun.class);

                    kekkaKbn = getHrkKawaseRateKijyun.exec(uiBean.getNyknaiyoukbnSyoriyou(),
                        uiBean.getNykkeiroSyoriyou(), uiBean.getRyosyuymdSyoriyou(), uiBean.getJyuutouymSyoriyou(),
                        jyutoukaisuuy, jyutoukaisuum,uiBean.getHrkkaisuuSyoriyou());

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                        throw new CommonBizAppException("払込用為替レート基準日取得エラー。　証券番号＝" +
                            uiBean.getSyono());
                    }

                    KeisanPRsTuukaKnsn keisanPRsTuukaKnsn = SWAKInjector.getInstance(KeisanPRsTuukaKnsn.class);

                    kekkaKbn = keisanPRsTuukaKnsn.exec(getHrkKawaseRateKijyun.getKawaseRateKijyun(),
                        uiBean.getKykKihon().getHrkp(), tuukaSyu, rstuukasyu);

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                        List<String> errorCdLst = keisanPRsTuukaKnsn.getErrorCd();

                        if (errorCdLst.contains(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR)) {
                            throw new BizLogicException(MessageId.EIF3079);
                        }
                    }
                }
            }
        }
        else if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(uiBean.getSuitososhikicd());

            if (C_SosikimasterUmuKbn.NONE.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                throw new BizLogicException(MessageId.EIF3030);
            }

            if (BizDateUtil.compareYmd(uiBean.getNykinputdenymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIF1101);
            }

            if (BizDateUtil.compareYm(uiBean.getNykinputdenymd().getBizDateYM(), sysDate.getBizDateYM()) != BizDateUtil.COMPARE_EQUAL) {
                SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

                BizDate denSimeYMD = setDenSimebi.exec(uiBean.getNykinputdenymd().addMonths(1).getRekijyou());

                if (BizDateUtil.compareYmd(denSimeYMD, sysDate) == BizDateUtil.COMPARE_LESSER) {
                    throw new BizLogicException(MessageId.EIF1102);
                }
            }

            if (!uiBean.getNykinputdenymd().isBusinessDay()) {
                throw new BizLogicException(MessageId.EIA1015, NYKINPUTDENYMD_HIEIGYOUBI_MSG);
            }
        }

        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou())) {
            for (HrkeiraiInfoDataSourceBean hrkeiraiInfoDataSourceBean : uiBean.getHrkeiraiInfoDataSource().getAllData()) {
                if (hrkeiraiInfoDataSourceBean.getNykntaisyouchkbox()) {
                    uiBean.setHenkouSikibetuKey(hrkeiraiInfoDataSourceBean.getHenkouSikibetuKey());
                    uiBean.setNyknaiyoukbnSyoriyou(hrkeiraiInfoDataSourceBean.getNyknaiyoukbn());
                    uiBean.setJyuutouymSyoriyou(hrkeiraiInfoDataSourceBean.getJyuutouym());

                    if (hrkeiraiInfoDataSourceBean.getJyutoukaisuuy() == 0) {
                        uiBean.setJyutoukaisuuySyoriyou(null);
                    }
                    else {
                        uiBean.setJyutoukaisuuySyoriyou(hrkeiraiInfoDataSourceBean.getJyutoukaisuuy());
                    }

                    if (hrkeiraiInfoDataSourceBean.getJyutoukaisuum() == 0) {
                        uiBean.setJyutoukaisuumSyoriyou(null);
                    }
                    else {
                        uiBean.setJyutoukaisuumSyoriyou(hrkeiraiInfoDataSourceBean.getJyutoukaisuum());
                    }

                    break;
                }
            }
        }

        uiBean.setIktNyuukinnUmu(C_UmuKbn.NONE);

        //        if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNyknaiyoukbnSyoriyou()) &&
        //            C_Hrkkaisuu.TUKI.eq(hrkkaisuu) &&
        //            uiBean.getJyutoukaisuuySyoriyou() == null &&
        //            uiBean.getJyutoukaisuumSyoriyou() > 2) {
        //            KeisanIkkatuNyuukinGk keisanIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanIkkatuNyuukinGk.class);
        //
        //            keisanIkkatuNyuukinGk.setSyono(syoNo);
        //
        //            keisanIkkatuNyuukinGk.exec(C_AnsyuusysKbn.HOZEN, uiBean.getRyosyuymdSyoriyou(), uiBean.getJyuutouymSyoriyou(), uiBean.getJyutoukaisuumSyoriyou());
        //
        //            if (keisanIkkatuNyuukinGk.getIktwaribikitekiyoutukisuu() > 2) {
        //                uiBean.setIktNyuukinnUmu(C_UmuKbn.ARI);
        //            }
        //        }

        if (C_NyknaiyouKbn.KEIZOKUP.eq(uiBean.getNyknaiyoukbnSyoriyou()) &&
            C_Hrkkaisuu.TUKI.eq(uiBean.getHrkkaisuuSyoriyou()) &&
            !C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getTikiktbrisyuruikbnSyoriyou()) &&
            !C_TkiktbrisyuruiKbn.NONE.eq(uiBean.getTikiktbrisyuruikbnSyoriyou())) {
            uiBean.setIktNyuukinnUmu(C_UmuKbn.ARI);
        }

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            IT_Kariukekin kariukekin = khOnlineNyuukinDao.getKariukekin2(uiBean.getKykKihon(), uiBean.getKrkno());

            kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
        }

        //        if (C_NyknaiyouKbn.SYOKAIP.eq(nyknaiyoukbn)) {
        //            FstPNyuukinTRParam fstPNyuukinTRParam = SWAKInjector.getInstance(FstPNyuukinTRParam.class);
        //            fstPNyuukinTRParam.setSyoNo(syoNo);
        //            fstPNyuukinTRParam.setSyoriYmd(sysDate);
        //            fstPNyuukinTRParam.setNykKeiro(nykkeiro);
        //            fstPNyuukinTRParam.setHrkkaisuu(hrkkaisuu);
        //            fstPNyuukinTRParam.setNykNaiyouKbn(nyknaiyoukbn);
        //            fstPNyuukinTRParam.setJyutouYm(jyuutouym);
        //            fstPNyuukinTRParam.setJyutouKaisuuY(blank2zero(jyutoukaisuuy));
        //            fstPNyuukinTRParam.setJyutouKaisuuM(blank2zero(jyutoukaisuum));
        //            fstPNyuukinTRParam.setRyosyuGk(ryosyugk);
        //            fstPNyuukinTRParam.setRyosyuYmd(ryosyuymd);
        //
        //            CommonFstPNyuukin commonFstPNyuukin = SWAKInjector.getInstance(CommonFstPNyuukin.class);
        //
        //            commonFstPNyuukin.exec(khozenCommonParam,fstPNyuukinTRParam,C_YouhiKbn.HUYOU);
        //            C_KrkriyuuKbn krkriyuukbn = commonFstPNyuukin.getKrkRiyuuKbn();
        //
        //            if(!C_KrkriyuuKbn.BLNK.eq(krkriyuukbn)) {
        //                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
        //                    MessageId.WIA0012, krkriyuukbn.getContent());
        //            }
        //        }
        //        else {

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);

        nyuukinTRParam.setSyoNo(syoNo);
        nyuukinTRParam.setSyoriYmd(sysDate);
        nyuukinTRParam.setNyuukinKakusyounrkYmd(sysDate);
        nyuukinTRParam.setNykKeiro(uiBean.getNykkeiroSyoriyou());
        nyuukinTRParam.setHrkkaisuu(uiBean.getHrkkaisuuSyoriyou());
        nyuukinTRParam.setNykNaiyouKbn(uiBean.getNyknaiyoukbnSyoriyou());
        nyuukinTRParam.setJyutouYm(uiBean.getJyuutouymSyoriyou());
        nyuukinTRParam.setJyutouKaisuuY(blank2zero(uiBean.getJyutoukaisuuySyoriyou()));
        nyuukinTRParam.setJyutouKaisuuM(blank2zero(uiBean.getJyutoukaisuumSyoriyou()));
        nyuukinTRParam.setRyosyuGk(uiBean.getRsgakuSyoriyou());
        nyuukinTRParam.setRyosyuYmd(uiBean.getRyosyuymdSyoriyou());
        nyuukinTRParam.setIktnyuukinnumu(uiBean.getIktNyuukinnUmu());
        nyuukinTRParam.setNykhouhouKbn(uiBean.getNykhouhou());
        nyuukinTRParam.setTkiktbrisyuruiKbn(uiBean.getTikiktbrisyuruikbnSyoriyou());

        CommonNyuukin commonNyuukin = SWAKInjector.getInstance(CommonNyuukin.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, null);

        C_KrkriyuuKbn krkriyuukbn = commonNyuukin.getKrkRiyuuKbn();

        if(!C_KrkriyuuKbn.BLNK.eq(krkriyuukbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2,
                MessageId.WIA0012, krkriyuukbn.getContent());
        }

        //    }

        if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            if (BizDateUtil.compareYm(uiBean.getRyosyuymd().getBizDateYM(),
                sysDate.getBizDateYM()) != BizDateUtil.COMPARE_EQUAL) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2,MessageId.WIF3005);
            }
        }
        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        String syoNo = uiBean.getSyono();

        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);

        String kinouId = khozenCommonParam.getFunctionId();

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            IT_Kariukekin kariukekin = khOnlineNyuukinDao.getKariukekin2(uiBean.getKykKihon(), uiBean.getKrkno());

            kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.BLNK);
        }

        tableMaintenanceUtil.backUp(syoNo, sikibetuKey);

        updateKTKykKihon(sysTime, sysDate, khozenCommonParam);

        IT_KhTtdkRireki khTtdkRireki = khOnlineNyuukinDao.createKhTtdkRireki(uiBean.getKykKihon());

        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        CommonNyuukin commonNyuukin = SWAKInjector.getInstance(CommonNyuukin.class);

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);
        BizDate zengetumatuDenSimeYmd = setDenSimebi.exec(sysDate);

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            IT_Kariukekin kariukekin = khOnlineNyuukinDao.getKariukekin2(uiBean.getKykKihon(), uiBean.getKrkno());

            kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
        }

        List<IT_KykSyouhn> kykSyouhnList = khozenCommonParam.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);

        IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);
        C_Kykjyoutai hnkmKykJyoutai = kykSyouhn.getKykjyoutai();

        C_YouhiKbn nkinKakuSksYh = C_YouhiKbn.HUYOU;

        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou()) ||
            C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            nkinKakuSksYh = C_YouhiKbn.YOU;
        }

        //        if (C_NyknaiyouKbn.SYOKAIP.eq(nyknaiyoukbn)) {
        //            FstPNyuukinTRParam fstPNyuukinTRParam = SWAKInjector.getInstance(FstPNyuukinTRParam.class);
        //            fstPNyuukinTRParam.setSyoNo(syoNo);
        //            fstPNyuukinTRParam.setSyoriYmd(sysDate);
        //            fstPNyuukinTRParam.setNykKeiro(nykkeiro);
        //            fstPNyuukinTRParam.setHrkkaisuu(hrkkaisuu);
        //            fstPNyuukinTRParam.setNykNaiyouKbn(nyknaiyoukbn);
        //            fstPNyuukinTRParam.setJyutouYm(jyuutouym);
        //            fstPNyuukinTRParam.setJyutouKaisuuY(blank2zero(jyutoukaisuuy));
        //            fstPNyuukinTRParam.setJyutouKaisuuM(blank2zero(jyutoukaisuum));
        //            fstPNyuukinTRParam.setRyosyuGk(ryosyugk);
        //            fstPNyuukinTRParam.setRyosyuYmd(ryosyuymd);
        //            fstPNyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        //            fstPNyuukinTRParam.setZengetumatuDenSimeYmd(zengetumatuDenSimeYmd);
        //
        //            commonFstPNyuukin.exec(khozenCommonParam, fstPNyuukinTRParam, C_YouhiKbn.YOU);
        //
        //            C_KrkriyuuKbn krkriyuukbn = commonFstPNyuukin.getKrkRiyuuKbn();
        //            BizCurrency bdKrkKgk = commonFstPNyuukin.getBdKrkGK();
        //
        //            if(!C_KrkriyuuKbn.BLNK.eq(krkriyuukbn)) {
        //                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
        //                    MessageId.IIA0015, krkriyuukbn.getContent(), BizUtil.comma(bdKrkKgk.toString()));
        //            }
        //        }
        //        else {

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);

        nyuukinTRParam.setSyoNo(syoNo);
        nyuukinTRParam.setSyoriYmd(sysDate);
        nyuukinTRParam.setNyuukinKakusyounrkYmd(sysDate);
        nyuukinTRParam.setNykKeiro(uiBean.getNykkeiroSyoriyou());
        nyuukinTRParam.setHrkkaisuu(uiBean.getHrkkaisuuSyoriyou());
        nyuukinTRParam.setNykNaiyouKbn(uiBean.getNyknaiyoukbnSyoriyou());
        nyuukinTRParam.setIktnyuukinnumu(uiBean.getIktNyuukinnUmu());
        nyuukinTRParam.setJyutouYm(uiBean.getJyuutouymSyoriyou());
        nyuukinTRParam.setJyutouKaisuuY(blank2zero(uiBean.getJyutoukaisuuySyoriyou()));
        nyuukinTRParam.setJyutouKaisuuM(blank2zero(uiBean.getJyutoukaisuumSyoriyou()));
        nyuukinTRParam.setRyosyuGk(uiBean.getRsgakuSyoriyou());
        nyuukinTRParam.setRyosyuYmd(uiBean.getRyosyuymdSyoriyou());

        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou()) ||
            C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            nyuukinTRParam.setSuitoSoshikiCd(uiBean.getSuitososhikicd());
        }

        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(zengetumatuDenSimeYmd);
        nyuukinTRParam.setNykhouhouKbn(uiBean.getNykhouhou());

        if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            nyuukinTRParam.setDenymd(uiBean.getNykinputdenymd());
        }

        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou()) ||
            C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            nyuukinTRParam.setTabakarikanjyono(uiBean.getTabakarikanjyono());
        }

        nyuukinTRParam.setTkiktbrisyuruiKbn(uiBean.getTikiktbrisyuruikbnSyoriyou());

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            nyuukinTRParam.setSeisantgkmkHasseidenYmd(uiBean.getHasseidenymd());
        }
        nyuukinTRParam.setCreditkessaiyouno(uiBean.getCreditkessaiyouno());

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, nkinKakuSksYh, null);
        C_KrkriyuuKbn krkriyuukbn = commonNyuukin.getKrkRiyuuKbn();
        BizCurrency bdKrkKgk = commonNyuukin.getBdKrkGK();

        if(!C_KrkriyuuKbn.BLNK.eq(krkriyuukbn)) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2,
                MessageId.IIA0015, krkriyuukbn.getContent(), BizUtil.comma(bdKrkKgk.toString()));
        }

        //    }

        //        if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou())) {
        //            IT_HrkeIraiInfo hrkeIraiInfo = khOnlineNyuukinDao.getHrkeIraiInfo(commonNyuukin.getAnsyuKihon(), uiBean.getHenkouSikibetuKey());
        //
        //            hrkeIraiInfo.setHrkeannaijkkbn(C_HrkeAnnaiJkKbn.TYAKKINARI);
        //            hrkeIraiInfo.setNyksyoriymd(sysDate);
        //            hrkeIraiInfo.setRyosyuymd(uiBean.getRyosyuymdSyoriyou());
        //            hrkeIraiInfo.setRsgaku(uiBean.getRsgakuSyoriyou());
        //            hrkeIraiInfo.setGyoumuKousinKinou(kinouId);
        //            hrkeIraiInfo.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        //            hrkeIraiInfo.setGyoumuKousinTime(sysTime);
        //        }

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())){
            IT_Kariukekin kariukekin = khOnlineNyuukinDao.getKariukekin2(commonNyuukin.getKykKihon(), uiBean.getKrkno());

            kariukekin.setSeisandenymd(commonNyuukin.getKhDenpyoDatas().get(0).getDenymd());
            kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
            kariukekin.setGyoumuKousinKinou(kinouId);
            kariukekin.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            kariukekin.setGyoumuKousinTime(sysTime);
        }

        String youkyuuNo = "";

        if (!hnkmKykJyoutai.eq(kykSyouhn.getKykjyoutai())) {
            PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

            pALKykNaiyouKousin.exec(uiBean.getKykKihon());

            youkyuuNo = pALKykNaiyouKousin.getYoukyuuno();
        }


        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSysTime(sysTime);
        if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.KRKKEIJYOU);
        }
        else  if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.NYUUKIN_KRK);
        }
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        if (commonNyuukin.getNyuukinKakusyouData() != null) {
            editTtdkRirekiTblParam.setNyuukinKakusyouData(commonNyuukin.getNyuukinKakusyouData());
        }
        editTtdkRirekiTblParam.setYoukyuuNo(youkyuuNo);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        khOnlineNyuukinDao.update(commonNyuukin.getKykKihon());

        khOnlineNyuukinDao.update(commonNyuukin.getAnsyuKihon());

        if (commonNyuukin.getKhFBSoukinData() != null) {
            khOnlineNyuukinDao.insert(commonNyuukin.getKhFBSoukinData());
        }

        for (IT_KhDenpyoData khDenpyoData : commonNyuukin.getKhDenpyoDatas()) {
            khOnlineNyuukinDao.insert(khDenpyoData);
        }

        IT_NyuukinKakusyouData nyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();

        if (nyuukinKakusyouData != null) {
            khOnlineNyuukinDao.insert(nyuukinKakusyouData);
        }

        messageManager.addMessageId(MessageId.IAC0009);
        uiBean.setTyouhyoumukbn(commonNyuukin.getPdfOutUmuKbn());

        uiBean.setTyouhyoukey(commonNyuukin.getTyohyoKey());

    }

    void printOut() {
        String tyhykey = uiBean.getTyouhyoukey();
        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);
        outputReport.outputPDFByJoinKey(tyhykey);
    }

    void pushModoruByConfirmBL() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);
    }

    public boolean checkJyoukentukiHissu(String pKoumokuMei, C_NykhouhouKbn pNykhouhouKbn) {
        if (C_NykhouhouKbn.HURIKAE.eq(pNykhouhouKbn)) {
            if (RYOSYUYMD.equals(pKoumokuMei) ||
                RSGAKU.equals(pKoumokuMei) ||
                TYAKKINYMD.equals(pKoumokuMei) ||
                TABAKARIKANJYONO.equals(pKoumokuMei) ||
                SUITOSOSHIKICD.equals(pKoumokuMei)) {
                return true;
            }
            else if (NYKNAIYOUKBN.equals(pKoumokuMei) ||
                HRKKAISUU.equals(pKoumokuMei) ||
                NYKINPUTDENYMD.equals(pKoumokuMei) ||
                NYKINPUTHRKKAISUU.equals(pKoumokuMei) ||
                NYKINPUTNYKKEIRO.equals(pKoumokuMei) ||
                NYKINPUTNYKNAIYOUKBN.equals(pKoumokuMei) ||
                NYKINPUTRYOSYUYMD.equals(pKoumokuMei)) {
                return false;
            }
            else {
                return false;
            }
        }
        if (C_NykhouhouKbn.KARIUKE.eq(pNykhouhouKbn)) {
            if (NYKINPUTHRKKAISUU.equals(pKoumokuMei) ||
                NYKINPUTNYKKEIRO.equals(pKoumokuMei) ||
                NYKINPUTNYKNAIYOUKBN.equals(pKoumokuMei) ||
                NYKINPUTRYOSYUYMD.equals(pKoumokuMei)) {
                return true;
            }
            else if (HRKKAISUU.equals(pKoumokuMei) ||
                NYKNAIYOUKBN.equals(pKoumokuMei) ||
                RYOSYUYMD.equals(pKoumokuMei) ||
                RSGAKU.equals(pKoumokuMei) ||
                NYKINPUTDENYMD.equals(pKoumokuMei) ||
                TYAKKINYMD.equals(pKoumokuMei) ||
                TABAKARIKANJYONO.equals(pKoumokuMei) ||
                SUITOSOSHIKICD.equals(pKoumokuMei)) {
                return false;
            }
            else {
                return false;
            }
        }
        if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(pNykhouhouKbn)) {
            if (HRKKAISUU.equals(pKoumokuMei) ||
                NYKNAIYOUKBN.equals(pKoumokuMei) ||
                RYOSYUYMD.equals(pKoumokuMei) ||
                RSGAKU.equals(pKoumokuMei) ||
                NYKINPUTDENYMD.equals(pKoumokuMei) ||
                SUITOSOSHIKICD.equals(pKoumokuMei) ||
                TABAKARIKANJYONO.equals(pKoumokuMei)) {
                return true;
            }
            else if (TYAKKINYMD.equals(pKoumokuMei) ||
                NYKINPUTHRKKAISUU.equals(pKoumokuMei) ||
                SUITOSOSHIKICD.equals(pKoumokuMei) ||
                NYKINPUTNYKKEIRO.equals(pKoumokuMei) ||
                NYKINPUTNYKNAIYOUKBN.equals(pKoumokuMei) ||
                NYKINPUTRYOSYUYMD.equals(pKoumokuMei)) {
                return false;
            }
            else {
                return false;
            }
        }

        return false;
    }

    private void checkZero() {

        if (BizUtil.isZero(uiBean.getRsgaku())) {
            errMessages.addMessage(MessageId.EAV0019, DDID_NYUUKINSYORIINFO_RSGAKU);
        }

        if (uiBean.getJyutoukaisuum() != null && uiBean.getJyutoukaisuum() == 0) {
            errMessages.addMessage(MessageId.EAV0019, DDID_NYUUKINSYORIINFO_JYUTOUKAISUUM);
        }

        if (uiBean.getJyutoukaisuuy() != null && uiBean.getJyutoukaisuuy() == 0) {
            errMessages.addMessage(MessageId.EAV0019, DDID_NYUUKINSYORIINFO_JYUTOUKAISUUY);
        }

        if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) {
            if (uiBean.getNykinputjyutoukaisuuy() != null && uiBean.getNykinputjyutoukaisuuy() == 0) {
                errMessages.addMessage(MessageId.EAV0019, DDID_KARIUKEKININFO_NYKINPUTJYUTOUKAISUUY);
            }

            if (uiBean.getNykinputjyutoukaisuum() != null && uiBean.getNykinputjyutoukaisuum() == 0) {
                errMessages.addMessage(MessageId.EAV0019, DDID_KARIUKEKININFO_NYKINPUTJYUTOUKAISUUM);
            }
        }

        if (errMessages.exists()) {
            throw new BizLogicException(errMessages);
        }
    }

    private void updateKTKykKihon(String pSysTime, BizDate pSysDate, KhozenCommonParam pKhozenCommonParam) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        String functionId = pKhozenCommonParam.getFunctionId();
        String userId = pKhozenCommonParam.getUserID();
        kykKihon.setGyoumuKousinKinou(functionId);
        kykKihon.setGyoumuKousinsyaId(userId);
        kykKihon.setGyoumuKousinTime(pSysTime);
        kykKihon.setSyhenkouymd(pSysDate);

    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);
        SetKihon.exec(pKhozenCommonParam, uiBean);
        setBetukyk.exec(pKhozenCommonParam, uiBean);
        for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                BizUtil.getGeneralMessageId(uiBean.getWarningMessageIdList().get(i)), uiBean.getWarningMessageList().get(i));
        }
        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);
        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);
        SetTokusin.exec(pKhozenCommonParam, uiBean);
        SetDattai.exec(pKhozenCommonParam, uiBean);
    }

    private String blank2zero(Integer pValue) {
        if(pValue == null) {
            return "0";
        }
        return pValue.toString();
    }

    private Integer zero2null(Integer pValue) {
        if(pValue.intValue() == 0) {
            return null;
        }
        return pValue;
    }

}
