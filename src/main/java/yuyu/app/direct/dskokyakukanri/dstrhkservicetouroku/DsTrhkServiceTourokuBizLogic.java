package yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku;

import static yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.DsTrhkServiceTourokuConstants.*;
import static yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.GenDsTrhkServiceTourokuConstants.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.apache.commons.validator.GenericValidator;
import org.slf4j.Logger;

import yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.dba.DsTourokuUkKanriInfoBean;
import yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.dba.DsTrhkServiceTourokuDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzEncryptUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.direct.dscommon.CheckDsKaiyaku;
import yuyu.common.direct.dscommon.CheckDsTorihikiService;
import yuyu.common.direct.dscommon.CheckSoukinyoukzResultBean;
import yuyu.common.direct.dscommon.CheckSoukinyoukzinputResultBean;
import yuyu.common.direct.dscommon.CheckZokuseinoResultBean;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuBean;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_DsKinouModeIdKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_Inputtaisyou;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;
import yuyu.def.classification.C_SoukinyoukzinputchkkekkaKbn;
import yuyu.def.classification.C_TourokustatusKbn;
import yuyu.def.classification.C_TrksriyuuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.entity.MT_DsTourokuUkKouzaAnsyono;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.detacher.HT_SyoriCTLDetacher;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 取引サービス登録 のビジネスロジックです
 */
public class DsTrhkServiceTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private DsTrhkServiceTourokuUiBean uiBean;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private MessageManager messageManager;

    @Inject
    private DsTrhkServiceTourokuDao dsTrhkServiceTourokuDao;

    private String gyoumuKousinTime;

    private int trhkServiceInfoKousinNaiyou;

    void init() {

        BizPropertyInitializer.initialize(uiBean);

        clear();
    }

    void clear() {
    }

    void pushItijiNyuuryokuBL() {

        uiBean.setKinouMode(C_DsKinouModeIdKbn.ITIJINYUURYOKU);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkKengenByKinouModeId(uiBean.getKinouMode().getValue());

        chkInputKey();

        Map<String, Object> koumokuInfoMap = getInputkeySyoriKoumoku();

        IT_KykKihon kykKihon = (IT_KykKihon)koumokuInfoMap.get(KYKKIHON);
        HT_SyoriCTL syoriCTL = (HT_SyoriCTL)koumokuInfoMap.get(SYORICTL);
        String syono = (String)koumokuInfoMap.get(SYONO);

        if (!BizUtil.isBlank(uiBean.getSyono())) {

            chkKykInfo(kykKihon, syoriCTL, DDID_KIHONINFO_SYONO);

            chkMosNrkKanryou(kykKihon, syoriCTL, DDID_KIHONINFO_SYONO);
        }
        else {
            chkMosno(syoriCTL);

            chkMosNrkKanryou(kykKihon, syoriCTL, DDID_KIHONINFO_MOSNO);

            chkMosnoNrkKanouKikan(syoriCTL);
        }

        MT_DsTourokuUkKanri dsTourokuUkKanri = dsTrhkServiceTourokuDao.getDsTourokuUkKanriBySyono(syono);

        chkStatusSyoriKahi(dsTourokuUkKanri);

        setKihonInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        setInputContentsInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        setPaperlessMosInfoExistsMsg(syoriCTL);

    }

    void pushNijiNyuuryokuBL() {

        uiBean.setKinouMode(C_DsKinouModeIdKbn.NIJINYUURYOKU);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkKengenByKinouModeId(uiBean.getKinouMode().getValue());

        chkInputKey();

        Map<String, Object> koumokuInfoMap = getInputkeySyoriKoumoku();

        IT_KykKihon kykKihon = (IT_KykKihon)koumokuInfoMap.get(KYKKIHON);
        HT_SyoriCTL syoriCTL = (HT_SyoriCTL)koumokuInfoMap.get(SYORICTL);
        String syono = (String)koumokuInfoMap.get(SYONO);

        Item kyoutyouKmId = getKyoutyouKmkid();

        if (!BizUtil.isBlank(uiBean.getSyono())) {

            chkKykInfo(kykKihon, syoriCTL, DDID_KIHONINFO_SYONO);

            chkMosNrkKanryou(kykKihon, syoriCTL, DDID_KIHONINFO_SYONO);
        }
        else {
            chkMosno(syoriCTL);

            chkMosNrkKanryou(kykKihon, syoriCTL, DDID_KIHONINFO_MOSNO);

            chkMosnoNrkKanouKikan(syoriCTL);
        }

        MT_DsTourokuUkKanri dsTourokuUkKanri = dsTrhkServiceTourokuDao.getDsTourokuUkKanriBySyono(syono);

        chkTrhkServiceTourokuInfo(dsTourokuUkKanri, kyoutyouKmId);

        chkNijinyrkUser(dsTourokuUkKanri);

        chkStatusSyoriKahi(dsTourokuUkKanri);

        setKihonInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        setDsKoktrkjk();

        if (kykKihon != null) {
            chkIdouJyoutai(kyoutyouKmId);
        }

        chkDsKaiyakuUktk(kyoutyouKmId);

        setInputContentsInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        setPaperlessMosInfoExistsMsg(syoriCTL);
    }

    void pushDsNyuuryokuLinkBL() {

        String syono = uiBean.getTrhkServiceInfoDataSource().getSelectedBean().getSyono();

        HT_SyoriCTL syoriCTL = getSkInfoBySyono(syono);

        IT_KykKihon kykKihon = getKykInfo(syono);

        MT_DsTourokuUkKanri dsTourokuUkKanri = dsTrhkServiceTourokuDao.getDsTourokuUkKanriBySyono(syono);

        if (C_TourokustatusKbn.NIJINYUURYOKUMATI.eq(dsTourokuUkKanri.getTourokustatus())) {
            uiBean.setKinouMode(C_DsKinouModeIdKbn.NIJINYUURYOKU);
        }
        else {
            uiBean.setKinouMode(C_DsKinouModeIdKbn.ITIJINYUURYOKU);
        }

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkKengenByKinouModeId(uiBean.getKinouMode().getValue());

        chkKykInfo(kykKihon, syoriCTL, null);

        chkNijinyrkUser(dsTourokuUkKanri);

        chkStatusSyoriKahi(dsTourokuUkKanri);

        setKihonInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        if (C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            setDsKoktrkjk();

            if (kykKihon != null) {
                chkIdouJyoutai(null);
            }

            chkDsKaiyakuUktk(null);
        }

        setInputContentsInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        setPaperlessMosInfoExistsMsg(syoriCTL);

    }

    void pushTorikesiBL() {

        uiBean.setKinouMode(C_DsKinouModeIdKbn.TORIKESI);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkKengenByKinouModeId(uiBean.getKinouMode().getValue());

        chkInputKey();

        Map<String, Object> koumokuInfoMap = getInputkeySyoriKoumoku();

        IT_KykKihon kykKihon = (IT_KykKihon)koumokuInfoMap.get(KYKKIHON);
        HT_SyoriCTL syoriCTL = (HT_SyoriCTL)koumokuInfoMap.get(SYORICTL);
        String syono = (String)koumokuInfoMap.get(SYONO);

        Item kyoutyouKmId = getKyoutyouKmkid();

        if (!BizUtil.isBlank(uiBean.getSyono())) {

            chkKykInfo(kykKihon, syoriCTL, DDID_KIHONINFO_SYONO);

            chkMosNrkKanryou(kykKihon, syoriCTL, DDID_KIHONINFO_SYONO);
        }
        else {
            chkMosno(syoriCTL);

            chkMosNrkKanryou(kykKihon, syoriCTL, DDID_KIHONINFO_MOSNO);
        }

        MT_DsTourokuUkKanri dsTourokuUkKanri = dsTrhkServiceTourokuDao.getDsTourokuUkKanriBySyono(syono);

        chkTrhkServiceTourokuInfo(dsTourokuUkKanri, kyoutyouKmId);

        chkStatusSyoriKahi(dsTourokuUkKanri);

        setKihonInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        setInputContentsInfo(kykKihon, syoriCTL, dsTourokuUkKanri);
    }

    void pushSyoukaiBL() {

        uiBean.setKinouMode(C_DsKinouModeIdKbn.SYOUKAI);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkKengenByKinouModeId(uiBean.getKinouMode().getValue());

        chkInputKey();

        Map<String, Object> koumokuInfoMap = getInputkeySyoriKoumoku();

        IT_KykKihon kykKihon = (IT_KykKihon)koumokuInfoMap.get(KYKKIHON);
        HT_SyoriCTL syoriCTL = (HT_SyoriCTL)koumokuInfoMap.get(SYORICTL);
        String syono = (String)koumokuInfoMap.get(SYONO);

        Item kyoutyouKmId = getKyoutyouKmkid();

        if (!BizUtil.isBlank(uiBean.getSyono())) {

            chkKykInfo(kykKihon, syoriCTL, DDID_KIHONINFO_SYONO);

            chkMosNrkKanryou(kykKihon, syoriCTL, DDID_KIHONINFO_SYONO);
        }
        else {
            chkMosno(syoriCTL);

            chkMosNrkKanryou(kykKihon, syoriCTL, DDID_KIHONINFO_MOSNO);
        }

        MT_DsTourokuUkKanri dsTourokuUkKanri = dsTrhkServiceTourokuDao.getDsTourokuUkKanriBySyono(syono);

        chkTrhkServiceTourokuInfo(dsTourokuUkKanri, kyoutyouKmId);

        chkStatusSyoriKahi(dsTourokuUkKanri);

        setKihonInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        setInputContentsInfo(kykKihon, syoriCTL, dsTourokuUkKanri);

        if (C_TourokustatusKbn.TORIKOMIERROR.eq(dsTourokuUkKanri.getTourokustatus())) {
            messageManager.addMessageId(MessageId.IMF1017);
        }
    }

    void pushSearchBL() {

        uiBean.setTrhkServiceInfo(null);

        if (uiBean.getSrchdsjimustartymdfrom() == null &&
            uiBean.getSrchdsjimustartymdto() == null &&
            C_TourokustatusKbn.BLNK.eq(uiBean.getSrchtourokustatus())) {
            throw new BizLogicException(MessageId.EMC1005);
        }

        List<DsTourokuUkKanriInfoBean> searchResultList =
            dsTrhkServiceTourokuDao.getDsTourokuUkKanriInfoByDsjimukaisiymdDsjimukanryouymdTourokustatus(
                uiBean.getSrchdsjimustartymdfrom(), uiBean.getSrchdsjimustartymdto(), uiBean.getSrchtourokustatus());

        if (searchResultList.size() == 0) {
            messageManager.addMessageId(MessageId.IAC0023);

            return;
        }

        int searchResultMaxCnt = YuyuBizConfig.getInstance().getSearchResultMaxCnt();

        if (searchResultList.size() > searchResultMaxCnt) {
            messageManager.addMessageId(MessageId.IBA0019, String.valueOf(searchResultMaxCnt));

            for (int n = searchResultList.size(); n > searchResultMaxCnt; n--) {

                searchResultList.remove(searchResultList.get(n - 1));
            }
        }

        List<TrhkServiceInfoDataSourceBean> searchResultInfoDsBeanList = Lists.newArrayList();

        for (DsTourokuUkKanriInfoBean dsTourokuUkKanriInfoBean : searchResultList) {

            TrhkServiceInfoDataSourceBean trhkServiceInfoDsBean =
                SWAKInjector.getInstance(TrhkServiceInfoDataSourceBean.class);

            trhkServiceInfoDsBean.setDsjimukaisiymd(dsTourokuUkKanriInfoBean.getDsjimukaisiymd());
            trhkServiceInfoDsBean.setSyono(dsTourokuUkKanriInfoBean.getSyono());
            trhkServiceInfoDsBean.setMosno(dsTourokuUkKanriInfoBean.getMosno());

            if (!BizUtil.isBlank(dsTourokuUkKanriInfoBean.getKyknmkjkh())) {
                trhkServiceInfoDsBean.setDispkakkyknmkj(dsTourokuUkKanriInfoBean.getKyknmkjkh());
            }
            else if (
                !BizUtil.isBlank(dsTourokuUkKanriInfoBean.getKyknmkjsk()) ||
                !BizUtil.isBlank(dsTourokuUkKanriInfoBean.getHhknnmkjsk())
                ) {
                if(C_KykKbn.KEIHI_DOUITU.eq(dsTourokuUkKanriInfoBean.getKykkbn())){
                    trhkServiceInfoDsBean.setDispkakkyknmkj(dsTourokuUkKanriInfoBean.getHhknnmkjsk());
                }
                else {
                    trhkServiceInfoDsBean.setDispkakkyknmkj(dsTourokuUkKanriInfoBean.getKyknmkjsk());
                }
            }
            else {
                trhkServiceInfoDsBean.setDispkakkyknmkj("");
            }

            trhkServiceInfoDsBean.setTourokustatus(dsTourokuUkKanriInfoBean.getTourokustatus());

            AM_User userInfo = baseDomManager.getUser(dsTourokuUkKanriInfoBean.getGyoumuKousinsyaId());

            if (userInfo == null) {
                trhkServiceInfoDsBean.setDispsyoritntnmkj("");
            }
            else {
                trhkServiceInfoDsBean.setDispsyoritntnmkj(userInfo.getUserNm());
            }

            if (C_TourokustatusKbn.NIJINYUURYOKUMATI.eq(dsTourokuUkKanriInfoBean.getTourokustatus()) ||
                C_TourokustatusKbn.NIJINYUURYOKUSAI_ARI.eq(dsTourokuUkKanriInfoBean.getTourokustatus())) {
                trhkServiceInfoDsBean.setDsnyuuryokulink("入力");
            }
            else {
                trhkServiceInfoDsBean.setDsnyuuryokulink("");
            }

            searchResultInfoDsBeanList.add(trhkServiceInfoDsBean);
        }

        uiBean.setTrhkServiceInfo(searchResultInfoDsBeanList);
    }

    void pushKakuninBL() {

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) ||
            C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            if (C_UmuKbn.ARI.eq(uiBean.getDstrhkserviceknykeironrumu())) {

                if (C_DsTrhkserviceKanyukeiroKbn.BLNK.eq(uiBean.getDstrhkservicekanyukeirokbn())) {

                    errorMessageCollector.addMessage(
                        MessageId.EAC0042, DDID_TRHKSERVICEKANYUKEIROINFO_DSTRHKSERVICEKANYUKEIROKBN);
                }
            }

            if (C_Inputtaisyou.BLNK.eq(uiBean.getInputtaisyoutokuteitrhkkz())) {
                errorMessageCollector.addMessage(
                    MessageId.EAC0042, DDID_TOKUTEITRHKKOUZAINFO_INPUTTAISYOUTOKUTEITRHKKZ);
            }

            if (C_Inputtaisyou.BLNK.eq(uiBean.getInputtaisyoutoktrhkansyono())) {
                errorMessageCollector.addMessage(
                    MessageId.EAC0042, DDID_TOKUTEITRHKANSYONOINFO_INPUTTAISYOUTOKTRHKANSYONO);
            }
        }

        if (C_DsKinouModeIdKbn.TORIKESI.eq(uiBean.getKinouMode())) {

            if (C_TrksriyuuKbn.BLNK.eq(uiBean.getTrksriyuukbn())) {
                errorMessageCollector.addMessage(MessageId.EAC0042, DDID_TRHKSERVICETOUROKUJKINFO_TRKSRIYUUKBN);
            }
        }

        if (errorMessageCollector.exists()) {

            throw new BizLogicException(errorMessageCollector);
        }

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(uiBean.getDskokno());

            MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = null;

            if (dsKokyakuKanri != null) {
                MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(uiBean.getSyono());

                if (dsKokyakuKeiyaku != null) {
                    dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getDstrhkserviceknykeironrumu()) ||
                (dsTorihikiServiceKanri != null &&
                C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA.eq(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn()))) {

                if (C_Inputtaisyou.NONE.eq(uiBean.getInputtaisyoutokuteitrhkkz()) ||
                    C_Inputtaisyou.NONE.eq(uiBean.getInputtaisyoutoktrhkansyono())) {

                    throw new BizLogicException(MessageId.EMF1020,
                        new Item[] {DDID_TOKUTEITRHKKOUZAINFO_INPUTTAISYOUTOKUTEITRHKKZ,
                        DDID_TOKUTEITRHKANSYONOINFO_INPUTTAISYOUTOKTRHKANSYONO});
                }
            }
        }

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) ||
            C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            if (C_Inputtaisyou.NONE.eq(uiBean.getInputtaisyoutokuteitrhkkz()) &&
                C_Inputtaisyou.NONE.eq(uiBean.getInputtaisyoutoktrhkansyono())) {

                throw new BizLogicException(MessageId.EMF1021,
                    new Item[] {DDID_TOKUTEITRHKKOUZAINFO_INPUTTAISYOUTOKUTEITRHKKZ,
                    DDID_TOKUTEITRHKANSYONOINFO_INPUTTAISYOUTOKTRHKANSYONO});
            }

            if (C_Inputtaisyou.NONE.eq(uiBean.getInputtaisyoutokuteitrhkkz())) {

                if (!BizUtil.isBlank(uiBean.getBankcd()) ||
                    !BizUtil.isBlank(uiBean.getSitencd()) ||
                    !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) ||
                    !BizUtil.isBlank(uiBean.getKouzano())) {

                    throw new BizLogicException(MessageId.EBA0108, "口座情報");
                }
            }
            else {

                C_Tuukasyu shrTuukasyu = C_Tuukasyu.JPY;
                String inputKouzaNo = uiBean.getKouzano();
                uiBean.setKouzanoBackup(inputKouzaNo);
                if(!BizUtil.isBlank(inputKouzaNo)){
                    if(inputKouzaNo.length() < 7 && C_Tuukasyu.JPY.eq(shrTuukasyu)) {
                        inputKouzaNo = Strings.padStart(inputKouzaNo, 7, '0');
                        uiBean.setKouzano(inputKouzaNo);
                    }
                }

                if (BizUtil.isBlank(uiBean.getBankcd())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        new Item[] {DDID_TOKUTEITRHKKOUZAINFO_BANKCD },
                        MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_BANKCD.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getSitencd())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        new Item[] { DDID_TOKUTEITRHKKOUZAINFO_SITENCD },
                        MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_SITENCD.getErrorResourceKey()));
                }

                CheckDsTorihikiService checkDsTorihikiService = SWAKInjector.getInstance(CheckDsTorihikiService.class);

                CheckSoukinyoukzinputResultBean chkSoukinyoukzinputResultBean =
                    checkDsTorihikiService.checkSoukinyoukzInput(shrTuukasyu,
                        uiBean.getBankcd(),
                        uiBean.getYokinkbn(),
                        uiBean.getKouzano(),
                        uiBean.getKzmeiginmkn(),
                        uiBean.getKzdoukbn(),
                        uiBean.getKyknmkn());

                if (C_ChkkekkaKbn.ERROR.eq(chkSoukinyoukzinputResultBean.getChkkekkaKbn())) {

                    C_SoukinyoukzinputchkkekkaKbn soukinyouKzInputChkkekkaKbn =
                        chkSoukinyoukzinputResultBean.getSoukinyoukzinputchkkekkaKbn();

                    if (C_SoukinyoukzinputchkkekkaKbn.YOKINMINYUURYOKU.eq(soukinyouKzInputChkkekkaKbn)) {

                        throw new BizLogicException(MessageId.EBC0043, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_YOKINKBN },
                            MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_YOKINKBN.getErrorResourceKey()));
                    }
                    else if (C_SoukinyoukzinputchkkekkaKbn.YUTYOGINKOUDATOUSEI.eq(soukinyouKzInputChkkekkaKbn)) {

                        throw new BizLogicException(MessageId.EBC1011, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_YOKINKBN },
                            uiBean.getYokinkbn().getContent());
                    }
                    else if (C_SoukinyoukzinputchkkekkaKbn.BANGOUMINYUURYOKU.eq(soukinyouKzInputChkkekkaKbn)) {

                        throw new BizLogicException(MessageId.EBC0043, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_KOUZANO },
                            MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_KOUZANO.getErrorResourceKey()));
                    }
                    else if (C_SoukinyoukzinputchkkekkaKbn.BANGOUKETASUU.eq(soukinyouKzInputChkkekkaKbn)) {

                        throw new BizLogicException(MessageId.EBC1012, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_KOUZANO },
                            MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_KOUZANO.getErrorResourceKey()));
                    }
                    else if (C_SoukinyoukzinputchkkekkaKbn.BANGOUKYOKAMOJI.eq(soukinyouKzInputChkkekkaKbn)) {

                        throw new BizLogicException(MessageId.EBC0046, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_KOUZANO },
                            MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_KOUZANO.getErrorResourceKey()));
                    }
                    else if (C_SoukinyoukzinputchkkekkaKbn.MEIGININMINYUURYOKU.eq(soukinyouKzInputChkkekkaKbn)) {

                        throw new BizLogicException(MessageId.EBC0045, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN },
                            MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()));
                    }
                    else if (C_SoukinyoukzinputchkkekkaKbn.MEIGININKETASUU.eq(soukinyouKzInputChkkekkaKbn)) {

                        throw new BizLogicException(MessageId.EBC1012, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN },
                            MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()));
                    }
                    else if (C_SoukinyoukzinputchkkekkaKbn.MEIGININKYOKAMOJI.eq(soukinyouKzInputChkkekkaKbn)) {

                        throw new BizLogicException(MessageId.EBC0046, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN },
                            MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()));
                    }
                }

                CheckSoukinyoukzResultBean chkSoukinyoukzResultBean =
                    checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
                        uiBean.getBankcd(),
                        uiBean.getSitencd(),
                        uiBean.getKzmeiginmkn(),
                        uiBean.getKzdoukbn(),
                        uiBean.getKyknmkn());

                if (C_ChkkekkaKbn.ERROR.eq(chkSoukinyoukzResultBean.getChkkekkaKbn())) {

                    C_SoukinyoukzchkkekkaKbn soukinyouKzChkkekkaKbn = chkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn();

                    if (C_SoukinyoukzchkkekkaKbn.GINKOUMASTERSONZAI.eq(soukinyouKzChkkekkaKbn)) {
                        throw new BizLogicException(MessageId.EBC1007);
                    }
                    else if (C_SoukinyoukzchkkekkaKbn.GINKOUYUUKOUHANTEI.eq(soukinyouKzChkkekkaKbn)) {
                        throw new BizLogicException(MessageId.EBC1008);
                    }
                    else if (C_SoukinyoukzchkkekkaKbn.YUUTYOGINKOUSOUKINKAHI.eq(soukinyouKzChkkekkaKbn)) {
                        throw new BizLogicException(MessageId.EBC1009, DDID_TOKUTEITRHKKOUZAINFO_SITENCD );
                    }
                    else if (C_SoukinyoukzchkkekkaKbn.GAIKAKOUZASOUKINKAHI.eq(soukinyouKzChkkekkaKbn)) {
                        throw new BizLogicException(MessageId.EBC1010);
                    }
                    else if (C_SoukinyoukzchkkekkaKbn.KOUZAMEIGININ.eq(soukinyouKzChkkekkaKbn)) {
                        throw new BizLogicException(MessageId.EBC0046, new Item[] { DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN },
                            MessageUtil.getMessage(DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()));
                    }
                }

                if (GenericValidator.matchRegexp(uiBean.getKzmeiginmkn(), reg)) {

                    throw new BizLogicException(MessageId.EMC1015, DDID_TOKUTEITRHKKOUZAINFO_KZMEIGINMKN);
                }
            }

            if (C_Inputtaisyou.NONE.eq(uiBean.getInputtaisyoutoktrhkansyono())) {

                if (!BizUtil.isBlank(uiBean.getTokuteitrhkansyonokakunin()) ||
                    !BizUtil.isBlank(uiBean.getTokuteitrhkansyonoinput())) {

                    throw new BizLogicException(MessageId.EBA0108, "特定取引用暗証番号情報");
                }
            }
            else {

                if (BizUtil.isBlank(uiBean.getTokuteitrhkansyonoinput())) {

                    throw new BizLogicException(MessageId.EAC0042, DDID_TOKUTEITRHKANSYONOINFO_TOKUTEITRHKANSYONOINPUT);
                }

                if (BizUtil.isBlank(uiBean.getTokuteitrhkansyonokakunin())) {

                    throw new BizLogicException(MessageId.EAC0042, DDID_TOKUTEITRHKANSYONOINFO_TOKUTEITRHKANSYONOKAKUNIN);
                }

                if (!uiBean.getTokuteitrhkansyonoinput().equals(uiBean.getTokuteitrhkansyonokakunin())) {
                    throw new BizLogicException(MessageId.EAF0022,
                        new Item[] { DDID_TOKUTEITRHKANSYONOINFO_TOKUTEITRHKANSYONOKAKUNIN,
                        DDID_TOKUTEITRHKANSYONOINFO_TOKUTEITRHKANSYONOINPUT });
                }

                CheckDsTorihikiService checkDsTorihikiService = SWAKInjector.getInstance(CheckDsTorihikiService.class);

                CheckZokuseinoResultBean chkZokuseinoResultBean =
                    checkDsTorihikiService.checkZokuseiNo(uiBean.getTokuteitrhkansyonoinput(),
                        uiBean.getKykseiymd(),
                        uiBean.getKyktelno());

                if (C_ChkkekkaKbn.ERROR.eq(chkZokuseinoResultBean.getChkkekkaKbn())) {
                    throw new BizLogicException(MessageId.EMF1022);
                }
            }
        }

        uiBean.setKzdoukbnBackup(uiBean.getKzdoukbn());
        uiBean.setKzmeiginmknBackup(uiBean.getKzmeiginmkn());

        if (C_Inputtaisyou.NONE.eq(uiBean.getInputtaisyoutokuteitrhkkz())) {
            uiBean.setKzdoukbn(C_Kzdou.BLNK);
            uiBean.setKzmeiginmkn("");
        }

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) ||
            C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            if (C_Inputtaisyou.INPUT.eq(uiBean.getInputtaisyoutoktrhkansyono())) {

                BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();
                uiBean.setTokuteitrhkansyono(bzEncryptUtil.raydbEncrypt(uiBean.getTokuteitrhkansyonoinput()));
                uiBean.setDisptokuteitrhkansyono("●●●●");
                uiBean.setTokuteitrhkansyonoinput("");
                uiBean.setTokuteitrhkansyonokakunin("");
            }
        }

        messageManager.removeConversationMessage(INPUTCONTENTS_ONLY_MSG);

        if (C_DsKinouModeIdKbn.TORIKESI.eq(uiBean.getKinouMode())) {
            messageManager.addMessageId(MessageId.QMC1001);
        }
        else  {
            messageManager.addMessageId(MessageId.QAC0008);
        }
    }

    void pushModoruBtnByInputContentsBL() {
        gotoInputkeyselectUiBeanClear();

        messageManager.removeConversationMessage(INPUTCONTENTS_ONLY_MSG);
    }

    @Transactional
    void pushKakuteiBL() {

        gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            tourokuSyoriItiji();
        }
        else if (C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {
            tourokuSyoriNiji();
        }
        else {
            torikesiSyori();
        }

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            messageManager.addMessageId(MessageId.IMF1011);
        }
        else if (C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            messageManager.addMessageId(MessageId.IMF1012);
        }
        else {

            messageManager.addMessageId(MessageId.IMF1013);
        }

        if (C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            if (C_UmuKbn.NONE.eq(uiBean.getVrfkbnksaiumu()) && uiBean.getDskoktrkjk() == DSKOKMITRK) {
                messageManager.addMessageId(MessageId.IMF1015);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getVrfkbnksaiumu())) {
                messageManager.addMessageId(MessageId.WMC1001);
            }
        }
    }

    void pushModoruBtnByConfirm() {

        uiBean.setTokuteitrhkansyono(null);

        uiBean.setKouzano(uiBean.getKouzanoBackup());
        uiBean.setKouzanoBackup("");
        uiBean.setKzdoukbn(uiBean.getKzdoukbnBackup());
        uiBean.setKzdoukbnBackup(C_Kzdou.BLNK);
        uiBean.setKzmeiginmkn(uiBean.getKzmeiginmknBackup());
        uiBean.setKzmeiginmknBackup("");

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode())    ||
            C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            setPaperlessMosInfoExistsMsg(getSkInfoBySyono(uiBean.getSyono()));
        }
    }


    private HT_SyoriCTL getSkInfoBySyono(String pSyono) {

        List<HT_SyoriCTL> syoriCtlLst = sinkeiyakuDomManager.getSyoriCTLsBySyono(pSyono);

        syoriCtlLst = HT_SyoriCTLDetacher.detachMosKihontouched(syoriCtlLst);

        if (!syoriCtlLst.isEmpty()) {
            return syoriCtlLst.get(0);
        }

        return null;

    }

    private HT_SyoriCTL getSkInfoByMosno(String pMosno) {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno);

        syoriCTL = HT_SyoriCTLDetacher.detachMosKihontouched(syoriCTL);

        return syoriCTL;
    }

    private IT_KykKihon getKykInfo(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);

        return kykKihon;
    }

    private void chkInputKey() {

        if (BizUtil.isBlank(uiBean.getSyono()) && BizUtil.isBlank(uiBean.getMosno())) {
            throw new BizLogicException(MessageId.EMF1015, new Item[] { DDID_KIHONINFO_SYONO, DDID_KIHONINFO_MOSNO });
        }

        if (!BizUtil.isBlank(uiBean.getSyono()) && !BizUtil.isBlank(uiBean.getMosno())) {
            throw new BizLogicException(MessageId.EMF1016, new Item[] { DDID_KIHONINFO_SYONO, DDID_KIHONINFO_MOSNO });
        }
    }

    private void chkKykInfo(IT_KykKihon pKykKihon, HT_SyoriCTL pSyoriCTL, Item pKyoutyouKmkid) {

        if (pKykKihon == null && pSyoriCTL == null) {

            if (pKyoutyouKmkid == null) {
                throw new BizLogicException(MessageId.EBA0090);
            }

            throw new BizLogicException(MessageId.EBA0090, pKyoutyouKmkid);
        }
    }

    private void chkMosno(HT_SyoriCTL pSyoriCTL) {

        if (pSyoriCTL == null) {

            throw new BizLogicException(MessageId.EMC1012, DDID_KIHONINFO_MOSNO);
        }
    }

    private void chkMosnoNrkKanouKikan(HT_SyoriCTL pSyoriCTL) {

        BizDate syoriKanouGndMosYmd = BizDate.getSysDate().addMonths(-6).getRekijyou();

        if (BizDateUtil.compareYmd(pSyoriCTL.getMosKihon().getMosymd(), syoriKanouGndMosYmd) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pSyoriCTL.getMosKihon().getMosymd(), syoriKanouGndMosYmd) == BizDateUtil.COMPARE_EQUAL) {

            throw new BizLogicException(MessageId.EMF1017, DDID_KIHONINFO_MOSNO);
        }
    }

    private void chkMosNrkKanryou(IT_KykKihon pKykKihon, HT_SyoriCTL pSyoriCTL, Item pKyoutyouKmkid) {

        if (pKykKihon != null) {
            return;
        }

        if (!C_UmuKbn.ARI.eq(pSyoriCTL.getMosnrkumu()) || pSyoriCTL.getMosKihon() == null) {
            throw new BizLogicException(MessageId.EMF1018, pKyoutyouKmkid);
        }
    }

    private void chkTrhkServiceTourokuInfo(MT_DsTourokuUkKanri pDsTourokuUkKanri, Item pKyoutyouKmkid) {

        if (pDsTourokuUkKanri == null) {
            throw new BizLogicException(MessageId.EBA0024, new Item[] {pKyoutyouKmkid}, "取引サービス情報");
        }
    }

    private void chkNijinyrkUser(MT_DsTourokuUkKanri pDsTourokuUkKanri) {

        if (C_TourokustatusKbn.NIJINYUURYOKUMATI.eq(pDsTourokuUkKanri.getTourokustatus()) &&
            pDsTourokuUkKanri.getGyoumuKousinsyaId().equals(baseUserInfo.getUserId())) {
            throw new BizLogicException(MessageId.EMC1013);
        }
    }

    private void chkStatusSyoriKahi(MT_DsTourokuUkKanri pDsTourokuUkKanri) {

        C_TourokustatusKbn hanteiTourokustatus = null;

        if (pDsTourokuUkKanri == null) {
            hanteiTourokustatus = C_TourokustatusKbn.BLNK;
        }
        else {
            hanteiTourokustatus = pDsTourokuUkKanri.getTourokustatus();
        }

        boolean syoriKahiFlg = true;
        C_DsKinouModeIdKbn kinouMode = uiBean.getKinouMode();

        if (C_TourokustatusKbn.BLNK.eq(hanteiTourokustatus) &&
            (C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(kinouMode) ||
                C_DsKinouModeIdKbn.SYOUKAI.eq(kinouMode) ||
                C_DsKinouModeIdKbn.TORIKESI.eq(kinouMode))) {

            syoriKahiFlg = false;
        }

        if (C_TourokustatusKbn.NIJINYUURYOKUMATI.eq(hanteiTourokustatus) &&
            C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(kinouMode)) {

            syoriKahiFlg = false;
        }

        if (C_TourokustatusKbn.NIJINYUURYOKUSAI_ARI.eq(hanteiTourokustatus) &&
            C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(kinouMode)) {
            syoriKahiFlg = false;
        }

        if (C_TourokustatusKbn.NYUURYOKUZUMI.eq(hanteiTourokustatus) &&
            (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(kinouMode) ||
                C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(kinouMode))) {

            syoriKahiFlg = false;
        }

        if (C_TourokustatusKbn.TOUROKUZUMI.eq(hanteiTourokustatus) &&
            (C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(kinouMode) ||
                C_DsKinouModeIdKbn.SYOUKAI.eq(kinouMode) ||
                C_DsKinouModeIdKbn.TORIKESI.eq(kinouMode))) {

            syoriKahiFlg = false;
        }

        if (C_TourokustatusKbn.TORIKESI.eq(hanteiTourokustatus) &&
            (C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(kinouMode) ||
                C_DsKinouModeIdKbn.TORIKESI.eq(kinouMode))) {

            syoriKahiFlg = false;
        }

        if (C_TourokustatusKbn.TORIKOMIERROR.eq(hanteiTourokustatus) &&
            (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(kinouMode) ||
                C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(kinouMode))) {

            syoriKahiFlg = false;
        }

        if (!syoriKahiFlg) {

            if (C_DsKinouModeIdKbn.SYOUKAI.eq(kinouMode)) {
                throw new BizLogicException(MessageId.EMF1019);
            }

            String hanteiTourokustatusContent = hanteiTourokustatus.getContent();

            if (C_TourokustatusKbn.BLNK.eq(hanteiTourokustatus)) {
                hanteiTourokustatusContent = "ブランク";
            }

            throw new BizLogicException(MessageId.EMC1014, hanteiTourokustatusContent);
        }
    }

    private void chkIdouJyoutai(Item pKyoutyouKmkid) {

        HozenKeiyakuIdouJyoutaiSyutoku hozenKeiyakuIdouJyoutaiSyutoku =
            SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean hzKykIdouBean = null;

        if (uiBean.getDskoktrkjk() == DSKOKMITRK) {

            hzKykIdouBean = hozenKeiyakuIdouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(uiBean.getSyono());
        }
        else {

            hzKykIdouBean = hozenKeiyakuIdouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(uiBean.getSyono());
        }

        if (C_IdoutyuuHanteiKekkaKbn.IDOUTYUU.eq(hzKykIdouBean.getIdoutyuuKbn())) {

            if (pKyoutyouKmkid == null) {
                throw new BizLogicException(MessageId.EMF1023, "異動処理中", "２次入力");
            }

            throw new BizLogicException(MessageId.EMF1023, new Item[]{pKyoutyouKmkid}, "異動処理中", "２次入力");
        }
    }

    private void chkDsKaiyakuUktk(Item pKyoutyouKmkid) {

        CheckDsKaiyaku checkDsKaiyaku = SWAKInjector.getInstance(CheckDsKaiyaku.class);

        C_UmuKbn umuKbn = checkDsKaiyaku.kaiyakuUkeUmuChk(uiBean.getSyono());

        if (C_UmuKbn.ARI.eq(umuKbn)) {

            if (pKyoutyouKmkid == null) {
                throw new BizLogicException(MessageId.EMF1023, "ＤＳ解約受付中", "２次入力");
            }

            throw new BizLogicException(MessageId.EMF1023, new Item[] { pKyoutyouKmkid }, "ＤＳ解約受付中", "２次入力");
        }
    }

    private void setKihonInfo(IT_KykKihon pKykKihon, HT_SyoriCTL pSyoriCTL, MT_DsTourokuUkKanri pDsTourokuUkKanri) {

        String syono = "";
        String mosno = "";

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            if (pKykKihon != null) {
                syono = pKykKihon.getSyono();
                mosno = pKykKihon.getSkjmosno();
            }
            else {
                syono = pSyoriCTL.getSyono();
                mosno = pSyoriCTL.getMosno();
            }
        }
        else {
            syono = pDsTourokuUkKanri.getSyono();
            mosno = pDsTourokuUkKanri.getMosno();
        }

        List<String> dskoknoList = dsTrhkServiceTourokuDao.getDsKokyakuKeiyakuBySyono(syono);

        String dskokno = "";

        if (!dskoknoList.isEmpty()) {
            dskokno = dskoknoList.get(0);
        }

        uiBean.setSyono(syono);
        uiBean.setMosno(mosno);
        uiBean.setDskokno(dskokno);
    }

    private void setDsKoktrkjk() {

        MT_DsKokyakuKanri dsKokyakuKanri = null;

        if (!BizUtil.isBlank(uiBean.getDskokno())) {
            dsKokyakuKanri = dsTrhkServiceTourokuDao.getDsKokyakuKanriByDskokno(uiBean.getDskokno());
        }

        if (dsKokyakuKanri == null) {
            uiBean.setDskoktrkjk(DSKOKMITRK);
        }
        else {
            uiBean.setDskoktrkjk(DSKOKTRKZUMI);
        }

        uiBean.setDsKokyakuKanri(dsKokyakuKanri);
    }

    private void setInputContentsInfo(IT_KykKihon pKykKihon, HT_SyoriCTL pSyoriCTL, MT_DsTourokuUkKanri pDsTourokuUkKanri) {

        IT_KykSya kykSya = null;
        HT_MosKihon mosKihon = null;

        if (pKykKihon != null) {
            kykSya = pKykKihon.getKykSya();
        }

        if (pSyoriCTL != null) {
            mosKihon = pSyoriCTL.getMosKihon();
        }

        String kyknmkj = "";
        String kyknmkn = "";
        BizDate kykseiymd = null;
        String kyktelno = "";

        if (kykSya != null) {
            kyknmkj = kykSya.getKyknmkj();
            kyknmkn = kykSya.getKyknmkn();
            kykseiymd = kykSya.getKykseiymd();
            kyktelno = kykSya.getTsintelno();
        }
        else {
            if (mosKihon != null) {
                if(C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())){
                    kyknmkj = mosKihon.getHhknnmkj();
                    kyknmkn = mosKihon.getHhknnmkn();
                    kykseiymd = mosKihon.getHhknseiymd();
                }
                else{
                    kyknmkj = mosKihon.getKyknmkj();
                    kyknmkn = mosKihon.getKyknmkn();
                    kykseiymd = mosKihon.getKykseiymd();
                }
                kyktelno = mosKihon.getTsintelno();
            }
        }

        MT_DsTourokuUkKouzaAnsyono dsTourokuUkKouzaAnsyono;

        if (pDsTourokuUkKanri == null) {
            dsTourokuUkKouzaAnsyono = null;
        }
        else {
            dsTourokuUkKouzaAnsyono = pDsTourokuUkKanri.getDsTourokuUkKouzaAnsyono();
        }

        C_TourokustatusKbn tourokustatus;

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            if (pDsTourokuUkKanri != null &&
                C_TourokustatusKbn.NIJINYUURYOKUSAI_ARI.eq(pDsTourokuUkKanri.getTourokustatus())) {

                tourokustatus = pDsTourokuUkKanri.getTourokustatus();
            }
            else {
                tourokustatus = C_TourokustatusKbn.BLNK;
            }
        }
        else {
            tourokustatus = pDsTourokuUkKanri.getTourokustatus();
        }

        C_UmuKbn dstrhkserviceknykeironrumu = C_UmuKbn.ARI;
        C_DsTrhkserviceKanyukeiroKbn dsTrhkserviceKanyukeiroKbn = C_DsTrhkserviceKanyukeiroKbn.BLNK;

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) &&
            (pDsTourokuUkKanri == null ||
            !C_TourokustatusKbn.NIJINYUURYOKUSAI_ARI.eq(pDsTourokuUkKanri.getTourokustatus()))) {

            MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(uiBean.getDskokno());

            if (dsKokyakuKanri != null) {
                MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(uiBean.getSyono());

                if (dsKokyakuKeiyaku != null) {
                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    if (dsTorihikiServiceKanri != null) {
                        dstrhkserviceknykeironrumu = C_UmuKbn.NONE;
                        dsTrhkserviceKanyukeiroKbn = dsTorihikiServiceKanri.getDstrhkservicekanyukeirokbn();
                    }
                }
            }
        }
        else {
            dstrhkserviceknykeironrumu = dsTourokuUkKouzaAnsyono.getDstrhkserviceknykeironrumu();
            dsTrhkserviceKanyukeiroKbn = dsTourokuUkKouzaAnsyono.getDstrhkservicekanyukeirokbn();
        }

        uiBean.setKyknmkj(kyknmkj);
        uiBean.setKyknmkn(kyknmkn);
        uiBean.setKykseiymd(kykseiymd);
        uiBean.setDstrhkservicekanyukeirokbn(dsTrhkserviceKanyukeiroKbn);
        uiBean.setTourokustatus(tourokustatus);
        uiBean.setKyktelno(kyktelno);
        uiBean.setDstrhkserviceknykeironrumu(dstrhkserviceknykeironrumu);

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) ||
            C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) {

            uiBean.setKzdoukbn(C_Kzdou.DOUITU);
            uiBean.setKzmeiginmkn(kyknmkn);
        }
        else if (C_DsKinouModeIdKbn.SYOUKAI.eq(uiBean.getKinouMode()) ||
            C_DsKinouModeIdKbn.TORIKESI.eq(uiBean.getKinouMode())) {

            if (C_DsKinouModeIdKbn.SYOUKAI.eq(uiBean.getKinouMode())) {
                uiBean.setTrksriyuukbn(dsTourokuUkKouzaAnsyono.getTrksriyuukbn());
            }

            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.
                exec(dsTourokuUkKouzaAnsyono.getBankcd(), dsTourokuUkKouzaAnsyono.getSitencd());

            uiBean.setBankcd(dsTourokuUkKouzaAnsyono.getBankcd());
            uiBean.setBanknmkj(bzGetBankDataBean.getBankNmKj());
            uiBean.setSitencd(dsTourokuUkKouzaAnsyono.getSitencd());
            uiBean.setSitennmkj(bzGetBankDataBean.getSitenNmKj());
            uiBean.setYokinkbn(dsTourokuUkKouzaAnsyono.getYokinkbn());
            uiBean. setKouzano(dsTourokuUkKouzaAnsyono.getKouzano());
            uiBean.setKzdoukbn(dsTourokuUkKouzaAnsyono.getKzdoukbn());

            if (C_Kzdou.DOUITU.eq(dsTourokuUkKouzaAnsyono.getKzdoukbn())) {
                uiBean.setKzmeiginmkn(kyknmkn);
            }
            else {
                uiBean.setKzmeiginmkn(dsTourokuUkKouzaAnsyono.getKzmeiginmkn());
            }

            if (C_UmuKbn.ARI.eq(dsTourokuUkKouzaAnsyono.getTokuteitrhkansyononrkumu())) {
                uiBean.setDisptokuteitrhkansyono("●●●●");
            }
            else {
                uiBean.setDisptokuteitrhkansyono("");
            }
        }

        if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) ||
            C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())  ||
            C_DsKinouModeIdKbn.TORIKESI.eq(uiBean.getKinouMode())) {

            uiBean.setDstourokuukkanri(pDsTourokuUkKanri);
        }
    }

    private void setPaperlessMosInfoExistsMsg(HT_SyoriCTL pSyoriCTL) {
        if (pSyoriCTL == null){
            return;
        }

        BizDate msgHyoujiTaisyouMosYmdTo = BizDate.getSysDate().addMonths(-6).getRekijyou();
        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
        if (!BizUtil.isBlank(mosKihon.getTokuteitrhkansyono())    &&
            BizDateUtil.compareYmd(mosKihon.getMosymd(), msgHyoujiTaisyouMosYmdTo) == BizDateUtil.COMPARE_GREATER){

            messageManager.addConversationMessageId(INPUTCONTENTS_ONLY_MSG, MessageId.IMF1018);
        }
    }

    private C_UmuKbn inputTaisyouKbnConvert(C_Inputtaisyou pInputtaisyou) {

        if (C_Inputtaisyou.INPUT.eq(pInputtaisyou)) {
            return C_UmuKbn.ARI;
        }

        return C_UmuKbn.NONE;
    }

    private void tourokuSyoriItiji() {


        uiBean.setTourokustatus(C_TourokustatusKbn.NIJINYUURYOKUMATI);

        if (C_TourokustatusKbn.NIJINYUURYOKUSAI_ARI.eq(uiBean.getTourokustatus())) {

            itijiNijiCommonSetteiSyoriUpd(uiBean.getDstourokuukkanri());

            MT_DsTourokuUkKanri dsTourokuUkKanri = uiBean.getDstourokuukkanri();

            directDomManager.update(dsTourokuUkKanri);
        }
        else {

            Integer dataRennoMax = dsTrhkServiceTourokuDao.getDsTourokuUkKanriMaxBySyono(uiBean.getSyono());

            Integer sinkiRenno = 0;

            if (dataRennoMax != null) {
                sinkiRenno = dataRennoMax + 1;
            }
            else {
                sinkiRenno = 1;
            }

            MT_DsTourokuUkKanri dsTourokuUkKanri = new MT_DsTourokuUkKanri();
            dsTourokuUkKanri.setSyono(uiBean.getSyono());
            dsTourokuUkKanri.setDsttdksyubetukbn(C_DsTtdksyubetuKbn.TORIHIKITOUROKU);
            dsTourokuUkKanri.setDatarenno(sinkiRenno);
            dsTourokuUkKanri.setMosno(uiBean.getMosno());
            dsTourokuUkKanri.setDsjimukaisiymd(BizDate.getSysDate());

            MT_DsTourokuUkKouzaAnsyono dsTourokuUkKouzaAnsyono = dsTourokuUkKanri.createDsTourokuUkKouzaAnsyono();
            dsTourokuUkKouzaAnsyono.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);

            itijiNijiCommonSetteiSyoriUpd(dsTourokuUkKanri);

            BizPropertyInitializer.initialize(dsTourokuUkKanri);

            BizPropertyInitializer.initialize(dsTourokuUkKouzaAnsyono);

            directDomManager.insert(dsTourokuUkKanri);
        }
    }

    private void tourokuSyoriNiji() {

        MT_DsTourokuUkKouzaAnsyono dsTourokuUkKouzaAnsyono = uiBean.getDstourokuukkanri().getDsTourokuUkKouzaAnsyono();

        String compareKzMeigiNmKn;

        if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
            compareKzMeigiNmKn = "";
        }
        else {
            compareKzMeigiNmKn = uiBean.getKzmeiginmkn();
        }

        C_UmuKbn vrfkbnKsaiUmu = C_UmuKbn.NONE;

        if (!dsTourokuUkKouzaAnsyono.getSoukinkzyennrkumu().eq(inputTaisyouKbnConvert(uiBean.getInputtaisyoutokuteitrhkkz()))) {

            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        if (!C_UmuKbn.ARI.eq(vrfkbnKsaiUmu) && !dsTourokuUkKouzaAnsyono.getBankcd().equals(uiBean.getBankcd())) {
            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        if (!C_UmuKbn.ARI.eq(vrfkbnKsaiUmu) && !dsTourokuUkKouzaAnsyono.getSitencd().equals(uiBean.getSitencd())) {
            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        if (!C_UmuKbn.ARI.eq(vrfkbnKsaiUmu) && !dsTourokuUkKouzaAnsyono.getYokinkbn().eq(uiBean.getYokinkbn())) {
            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        if (!C_UmuKbn.ARI.eq(vrfkbnKsaiUmu) && !dsTourokuUkKouzaAnsyono.getKouzano().equals(uiBean.getKouzano())) {
            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        if (!C_UmuKbn.ARI.eq(vrfkbnKsaiUmu) && !dsTourokuUkKouzaAnsyono.getKzdoukbn().eq(uiBean.getKzdoukbn())) {
            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        if (!C_UmuKbn.ARI.eq(vrfkbnKsaiUmu) && !dsTourokuUkKouzaAnsyono.getKzmeiginmkn().equals(compareKzMeigiNmKn)) {
            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        if (!C_UmuKbn.ARI.eq(vrfkbnKsaiUmu) &&
            !dsTourokuUkKouzaAnsyono.getTokuteitrhkansyononrkumu().eq(
                inputTaisyouKbnConvert(uiBean.getInputtaisyoutoktrhkansyono()))) {

            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        if (!C_UmuKbn.ARI.eq(vrfkbnKsaiUmu) &&
            !dsTourokuUkKouzaAnsyono.getTokuteitrhkansyono().equals(uiBean.getTokuteitrhkansyono())) {

            vrfkbnKsaiUmu = C_UmuKbn.ARI;
        }

        uiBean.setVrfkbnksaiumu(vrfkbnKsaiUmu);

        if (C_UmuKbn.ARI.eq(uiBean.getVrfkbnksaiumu())) {

            trhkServiceInfoKousinNaiyou = SAINYUURYOKU;
        }
        else {
            if (uiBean.getDskoktrkjk() == DSKOKTRKZUMI) {

                trhkServiceInfoKousinNaiyou = HONTOUROKU;
            }
            else {
                trhkServiceInfoKousinNaiyou = YOYAKUTOUROKU;
            }
        }

        if (trhkServiceInfoKousinNaiyou == HONTOUROKU) {
            uiBean.setTourokustatus(C_TourokustatusKbn.TOUROKUZUMI);

        } else if (trhkServiceInfoKousinNaiyou == YOYAKUTOUROKU) {
            uiBean.setTourokustatus(C_TourokustatusKbn.NYUURYOKUZUMI);

        } else {
            uiBean.setTourokustatus(C_TourokustatusKbn.NIJINYUURYOKUSAI_ARI);
        }

        MT_DsTourokuUkKanri dsTourokuUkKanri = uiBean.getDstourokuukkanri();

        itijiNijiCommonSetteiSyoriUpd(dsTourokuUkKanri);

        if (trhkServiceInfoKousinNaiyou != SAINYUURYOKU) {
            dsTourokuUkKanri.setDsjimukanryouymd(BizDate.getSysDate());
        }

        if (trhkServiceInfoKousinNaiyou == HONTOUROKU) {
            dsTourokuUkKanri.setDstourokukanryouymd(BizDate.getSysDate());
        }

        if (C_Inputtaisyou.INPUT.eq(uiBean.getInputtaisyoutoktrhkansyono()) &&
            trhkServiceInfoKousinNaiyou == HONTOUROKU) {
            dsTourokuUkKanri.getDsTourokuUkKouzaAnsyono().setTokuteitrhkansyono("");
        }

        directDomManager.update(dsTourokuUkKanri);

        if (trhkServiceInfoKousinNaiyou == HONTOUROKU) {

            String dsHenkousikibetukey = backup(uiBean.getDskokno());

            MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(uiBean.getDsKokyakuKanri().getDskokno());

            if (dsKokyakuKanri != null) {
                MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(uiBean.getSyono());

                if (dsKokyakuKeiyaku != null) {
                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    MT_DsTourokuUkKouzaAnsyono updDsTrkUkKzAnsyono = uiBean.getDstourokuukkanri().getDsTourokuUkKouzaAnsyono();

                    if (dsTorihikiServiceKanri == null) {

                        MT_DsTorihikiServiceKanri insDsTorihikiServiceKanri = dsKokyakuKeiyaku.createDsTorihikiServiceKanri();

                        insDsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_KA);
                        insDsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.BLNK);
                        insDsTorihikiServiceKanri.setDstrhkservicetourokuymd(BizDate.getSysDate());
                        insDsTorihikiServiceKanri.setDstrhkservicekanyukeirokbn(updDsTrkUkKzAnsyono.getDstrhkservicekanyukeirokbn());
                        insDsTorihikiServiceKanri.setGyoumuKousinKinou(kinou.getKinouId());
                        insDsTorihikiServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        insDsTorihikiServiceKanri.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(insDsTorihikiServiceKanri);

                        MT_DsSoukinyouKouza insDsSoukinyouKouza = insDsTorihikiServiceKanri.createDsSoukinyouKouza();

                        insDsSoukinyouKouza.setKzsyuruikbn(updDsTrkUkKzAnsyono.getKzsyuruikbn());
                        insDsSoukinyouKouza.setBankcd(updDsTrkUkKzAnsyono.getBankcd());
                        insDsSoukinyouKouza.setSitencd(updDsTrkUkKzAnsyono.getSitencd());
                        insDsSoukinyouKouza.setYokinkbn(updDsTrkUkKzAnsyono.getYokinkbn());
                        insDsSoukinyouKouza.setKouzano(updDsTrkUkKzAnsyono.getKouzano());
                        insDsSoukinyouKouza.setKzdoukbn(updDsTrkUkKzAnsyono.getKzdoukbn());
                        insDsSoukinyouKouza.setKzmeiginmkn(updDsTrkUkKzAnsyono.getKzmeiginmkn());
                        insDsSoukinyouKouza.setGyoumuKousinKinou(kinou.getKinouId());
                        insDsSoukinyouKouza.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        insDsSoukinyouKouza.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(insDsSoukinyouKouza);

                        MT_DsTorihikiyouAnsyono insDsTorihikiyouAnsyono = insDsTorihikiServiceKanri.createDsTorihikiyouAnsyono();

                        insDsTorihikiyouAnsyono.setTokuteitrhkansyono(uiBean.getTokuteitrhkansyono());
                        insDsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(0);
                        insDsTorihikiyouAnsyono.setSetymd(BizDate.getSysDate());
                        insDsTorihikiyouAnsyono.setGyoumuKousinKinou(kinou.getKinouId());
                        insDsTorihikiyouAnsyono.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        insDsTorihikiyouAnsyono.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(insDsTorihikiyouAnsyono);
                    }
                    else {

                        boolean saiTouroku = false;

                        if (C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA.eq(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn())) {
                            saiTouroku = true;
                        }

                        dsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_KA);

                        if (saiTouroku) {
                            dsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.BLNK);
                            dsTorihikiServiceKanri.setDstrhkservicemukouymd(null);
                        }

                        dsTorihikiServiceKanri.setGyoumuKousinKinou(kinou.getKinouId());
                        dsTorihikiServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsTorihikiServiceKanri.setGyoumuKousinTime(gyoumuKousinTime);

                        if (C_Inputtaisyou.INPUT.eq(uiBean.getInputtaisyoutokuteitrhkkz()))  {
                            for (MT_DsSoukinyouKouza dsSoukinyouKouza: dsTorihikiServiceKanri.getDsSoukinyouKouzas()) {

                                if (C_KouzasyuruiKbn.YENKOUZA.eq(dsSoukinyouKouza.getKzsyuruikbn())) {
                                    dsSoukinyouKouza.setBankcd(updDsTrkUkKzAnsyono.getBankcd());
                                    dsSoukinyouKouza.setSitencd(updDsTrkUkKzAnsyono.getSitencd());
                                    dsSoukinyouKouza.setYokinkbn(updDsTrkUkKzAnsyono.getYokinkbn());
                                    dsSoukinyouKouza.setKouzano(updDsTrkUkKzAnsyono.getKouzano());
                                    dsSoukinyouKouza.setKzdoukbn(updDsTrkUkKzAnsyono.getKzdoukbn());
                                    dsSoukinyouKouza.setKzmeiginmkn(updDsTrkUkKzAnsyono.getKzmeiginmkn());
                                    dsSoukinyouKouza.setGyoumuKousinKinou(kinou.getKinouId());
                                    dsSoukinyouKouza.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                                    dsSoukinyouKouza.setGyoumuKousinTime(gyoumuKousinTime);
                                }
                            }
                        }

                        if (C_Inputtaisyou.INPUT.eq(uiBean.getInputtaisyoutoktrhkansyono()))  {
                            MT_DsTorihikiyouAnsyono dsTrhkyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();

                            dsTrhkyouAnsyono.setTokuteitrhkansyono(uiBean.getTokuteitrhkansyono());
                            dsTrhkyouAnsyono.setTktrhkansyonoerrorkaisuu(0);
                            dsTrhkyouAnsyono.setSetymd(BizDate.getSysDate());
                            dsTrhkyouAnsyono.setGyoumuKousinKinou(kinou.getKinouId());
                            dsTrhkyouAnsyono.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsTrhkyouAnsyono.setGyoumuKousinTime(gyoumuKousinTime);
                        }
                    }

                    directDomManager.update(dsKokyakuKanri);
                }
            }

            DsTetudukiRirekiTableEdit dsTetudukiRirekiTableEdit = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);

            DsTetudukiRirekiTableEditParamImpl dsTetudukiRirekiTableEditParamImpl =
                SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);

            dsTetudukiRirekiTableEditParamImpl.setDskokno(uiBean.getDskokno());
            dsTetudukiRirekiTableEditParamImpl.setHenkousikibetukey(dsHenkousikibetukey);
            dsTetudukiRirekiTableEditParamImpl.setSyoriYmd(BizDate.getSysDate());
            dsTetudukiRirekiTableEditParamImpl.setDssyorikbn(C_DsSyoriKbn.TORIHIKI_SERVICE_TOUROKU);
            dsTetudukiRirekiTableEditParamImpl.setHenkouRrkYouhi(C_YouhiKbn.YOU);

            dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblOnline(dsTetudukiRirekiTableEditParamImpl);
        }
    }

    private void torikesiSyori() {

        uiBean.setTourokustatus(C_TourokustatusKbn.TORIKESI);

        MT_DsTourokuUkKanri dsTourokuUkKanri = uiBean.getDstourokuukkanri();

        dsTourokuUkKanri.setDskokno(uiBean.getDskokno());
        dsTourokuUkKanri.setTourokustatus(uiBean.getTourokustatus());
        dsTourokuUkKanri.setGyoumuKousinKinou(kinou.getKinouId());
        dsTourokuUkKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        dsTourokuUkKanri.setGyoumuKousinTime(gyoumuKousinTime);

        MT_DsTourokuUkKouzaAnsyono dsTourokuUkKouzaAnsyono = dsTourokuUkKanri.getDsTourokuUkKouzaAnsyono();

        dsTourokuUkKouzaAnsyono.setTrksriyuukbn(uiBean.getTrksriyuukbn());
        dsTourokuUkKouzaAnsyono.setGyoumuKousinKinou(kinou.getKinouId());
        dsTourokuUkKouzaAnsyono.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        dsTourokuUkKouzaAnsyono.setGyoumuKousinTime(gyoumuKousinTime);

        directDomManager.update(dsTourokuUkKanri);
    }

    private void itijiNijiCommonSetteiSyoriUpd(MT_DsTourokuUkKanri pDsTourokuUkKanri) {

        pDsTourokuUkKanri.setDskokno(uiBean.getDskokno());
        pDsTourokuUkKanri.setTourokustatus(uiBean.getTourokustatus());
        pDsTourokuUkKanri.setGyoumuKousinKinou(kinou.getKinouId());
        pDsTourokuUkKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pDsTourokuUkKanri.setGyoumuKousinTime(gyoumuKousinTime);

        MT_DsTourokuUkKouzaAnsyono dsTourokuUkKouzaAnsyono = pDsTourokuUkKanri.getDsTourokuUkKouzaAnsyono();

        dsTourokuUkKouzaAnsyono.setSoukinkzyennrkumu(inputTaisyouKbnConvert(uiBean.getInputtaisyoutokuteitrhkkz()));
        dsTourokuUkKouzaAnsyono.setTokuteitrhkansyononrkumu(inputTaisyouKbnConvert(uiBean.getInputtaisyoutoktrhkansyono()));
        dsTourokuUkKouzaAnsyono.setDstrhkserviceknykeironrumu(uiBean.getDstrhkserviceknykeironrumu());

        if (C_Inputtaisyou.INPUT.eq(uiBean.getInputtaisyoutokuteitrhkkz())) {
            dsTourokuUkKouzaAnsyono.setBankcd(uiBean.getBankcd());
            dsTourokuUkKouzaAnsyono.setSitencd(uiBean.getSitencd());
            dsTourokuUkKouzaAnsyono.setYokinkbn(uiBean.getYokinkbn());
            dsTourokuUkKouzaAnsyono.setKouzano(uiBean.getKouzano());
            dsTourokuUkKouzaAnsyono.setKzdoukbn(uiBean.getKzdoukbn());

            if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                dsTourokuUkKouzaAnsyono.setKzmeiginmkn("");
            }
            else {
                dsTourokuUkKouzaAnsyono.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            }
        }
        else {
            dsTourokuUkKouzaAnsyono.setBankcd("");
            dsTourokuUkKouzaAnsyono.setSitencd("");
            dsTourokuUkKouzaAnsyono.setYokinkbn(C_YokinKbn.BLNK);
            dsTourokuUkKouzaAnsyono.setKouzano("");
            dsTourokuUkKouzaAnsyono.setKzdoukbn(C_Kzdou.BLNK);
            dsTourokuUkKouzaAnsyono.setKzmeiginmkn("");
        }

        if (C_Inputtaisyou.INPUT.eq(uiBean.getInputtaisyoutoktrhkansyono())) {
            dsTourokuUkKouzaAnsyono.setTokuteitrhkansyono(uiBean.getTokuteitrhkansyono());
        }
        else {
            dsTourokuUkKouzaAnsyono.setTokuteitrhkansyono("");
        }

        dsTourokuUkKouzaAnsyono.setDstrhkservicekanyukeirokbn(uiBean.getDstrhkservicekanyukeirokbn());
        dsTourokuUkKouzaAnsyono.setGyoumuKousinKinou(kinou.getKinouId());
        dsTourokuUkKouzaAnsyono.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        dsTourokuUkKouzaAnsyono.setGyoumuKousinTime(gyoumuKousinTime);

    }

    private String backup(String pDsKokyakuNo) {

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

        String dsHenkouSikiBetuKey = dsSaibanSyori.saibanDsHenkouSikibetukey();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        MT_BAK_DsKokyakuKanri dsKokyakuKanri = tableMaintenanceUtil.exec(pDsKokyakuNo, dsHenkouSikiBetuKey);

        directDomManager.insert(dsKokyakuKanri);

        return dsHenkouSikiBetuKey;
    }

    private Map<String, Object> getInputkeySyoriKoumoku() {

        IT_KykKihon kykKihon = null;
        HT_SyoriCTL syoriCTL = null;
        String syono = "";

        if (!BizUtil.isBlank(uiBean.getSyono())) {

            kykKihon = getKykInfo(uiBean.getSyono());

            syoriCTL = getSkInfoBySyono(uiBean.getSyono());

            syono = uiBean.getSyono();
        }
        else {

            syoriCTL = getSkInfoByMosno(uiBean.getMosno());

            if (syoriCTL != null) {
                syono = syoriCTL.getSyono();

                kykKihon = getKykInfo(syono);
            }
        }

        Map<String, Object> koumokuInfoMap = new HashMap<String, Object>();

        koumokuInfoMap.put(KYKKIHON, kykKihon);
        koumokuInfoMap.put(SYORICTL, syoriCTL);
        koumokuInfoMap.put(SYONO, syono);

        return koumokuInfoMap;
    }

    private Item getKyoutyouKmkid() {

        Item kyoutyouKmkid = null;

        if (!BizUtil.isBlank(uiBean.getSyono())) {
            kyoutyouKmkid = DDID_KIHONINFO_SYONO;
        }
        else {
            kyoutyouKmkid = DDID_KIHONINFO_MOSNO;
        }

        return kyoutyouKmkid;
    }

    private void gotoInputkeyselectUiBeanClear(){
        uiBean.setSyono("");
        uiBean.setMosno("");
        uiBean.setDskokno("");

        uiBean.setKyknmkj("");
        uiBean.setKyknmkn("");
        uiBean.setKykseiymd(null);

        uiBean.setDstrhkservicekanyukeirokbn(C_DsTrhkserviceKanyukeiroKbn.BLNK);

        uiBean.setTourokustatus(C_TourokustatusKbn.BLNK);
        uiBean.setTrksriyuukbn(C_TrksriyuuKbn.BLNK);

        uiBean.setInputtaisyoutokuteitrhkkz(C_Inputtaisyou.BLNK);
        uiBean.setBankcd("");
        uiBean.setBanknmkj("");
        uiBean.setSitencd("");
        uiBean.setSitennmkj("");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("");
        uiBean.setKzdoukbn(C_Kzdou.BLNK);
        uiBean.setKzmeiginmkn("");

        uiBean.setInputtaisyoutoktrhkansyono(C_Inputtaisyou.BLNK);
        uiBean.setDisptokuteitrhkansyono("");
        uiBean.setTokuteitrhkansyonoinput("");
        uiBean.setTokuteitrhkansyonokakunin("");

        uiBean.setKinouMode(C_DsKinouModeIdKbn.DEFAULT);
        uiBean.setKyktelno("");
        uiBean.setTokuteitrhkansyono("");
        uiBean.setKouzanoBackup("");
        uiBean.setKzdoukbnBackup(C_Kzdou.BLNK);
        uiBean.setKzmeiginmknBackup("");
        uiBean.setDskoktrkjk(0);
        uiBean.setDstrhkserviceknykeironrumu(C_UmuKbn.NONE);
        uiBean.setVrfkbnksaiumu(C_UmuKbn.NONE);
        uiBean.setDstourokuukkanri(null);
        uiBean.setDsKokyakuKanri(null);
    }
}

