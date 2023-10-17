package yuyu.app.siharai.sisatei.sisateisb;

import static yuyu.app.siharai.sisatei.sisateisb.GenSiSateiSbConstants.*;
import static yuyu.app.siharai.sisatei.sisateisb.SiSateiSbConstants.*;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.TtzkRrkListDataSourceBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetProcessRecord;
import yuyu.common.biz.bzcommon.BzGetProcessRecordBean;
import yuyu.common.biz.bzcommon.BzGetProcessRecordInputBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.kaikei.SikinIdouRirekiDataBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.GetProgressHistoryOutBean;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.siharai.chksk.CheckSbSkNaiyou;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouKekkaBean;
import yuyu.common.siharai.chksk.SiSKNaiyouChkWarningmsgSettei;
import yuyu.common.siharai.edittbl.EditMisyuupMkkpDetailTbl;
import yuyu.common.siharai.edittbl.EditRrk;
import yuyu.common.siharai.edittbl.EditRrkTblBean;
import yuyu.common.siharai.edittbl.EditSateiRrkTbl;
import yuyu.common.siharai.edittbl.EditSateiRrkTblBean;
import yuyu.common.siharai.edittbl.EditSiDshrTukiTbl;
import yuyu.common.siharai.edittbl.EditSiDshrTukiTblBean;
import yuyu.common.siharai.edittbl.EditSiharaiRirekiTbl;
import yuyu.common.siharai.edittbl.EditSiharaiRirekiTblBean;
import yuyu.common.siharai.edittbl.EditSkTbl;
import yuyu.common.siharai.edittbl.EditSkTblBean;
import yuyu.common.siharai.edittbl.SiEditFb;
import yuyu.common.siharai.edittbl.SiEditFbInBean;
import yuyu.common.siharai.edittbl.SiEditFbOutBean;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.edittbl.SkTblSetBean;
import yuyu.common.siharai.koutei.SiProcessForward;
import yuyu.common.siharai.koutei.SiRuleBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.BetuskSyorityuChk;
import yuyu.common.siharai.sicommon.HanteiSaikenInfoNyuuryoku;
import yuyu.common.siharai.sicommon.HanteiSateiRank;
import yuyu.common.siharai.sicommon.HanteiSateiRankBean;
import yuyu.common.siharai.sicommon.HanteiSateiRankKekkaBean;
import yuyu.common.siharai.sicommon.SateiKekkaNyuuryokuChk;
import yuyu.common.siharai.sicommon.SetteiShrhousiteiKbn;
import yuyu.common.siharai.sicommon.SiCommonSiwake;
import yuyu.common.siharai.sicommon.SiCommonSiwakeBean;
import yuyu.common.siharai.sicommon.SiCommonSiwakeKekkaBean;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.common.siharai.sicommon.SiHosyouHantei;
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalc;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalcBean;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisan;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanBean;
import yuyu.common.siharai.sicommon.SiharaigakuBean;
import yuyu.common.siharai.sicommon.Siinhantei;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.siharai.siedittyouhyou.EditKakuniniraisyo;
import yuyu.common.siharai.siedittyouhyou.EditKakuniniraisyoBean;
import yuyu.common.siharai.siedittyouhyou.EditSiharaimeisaisyo;
import yuyu.common.siharai.siedittyouhyou.EditSiharaimeisaisyoBean;
import yuyu.common.siharai.siedittyouhyou.SaikensyaInfoBean;
import yuyu.common.siharai.siedittyouhyou.SeikyuusyaInfoBean;
import yuyu.common.siharai.siedittyouhyou.SiTyouhyouHensyuuCommonBean;
import yuyu.common.siharai.siedittyouhyou.ToiawaseInfoBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdBean;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyousaJyoukyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import yuyu.def.db.entity.JT_NenkinInfo;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SiDetail;
import yuyu.def.siharai.sorter.SortJT_SiRireki;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;


/**
 * （死亡）査定 のビジネスロジックです。
 */
public class SiSateiSbBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiSateiSbUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private MessageManager messageManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
    }

    void clear() {
    }

    @Transactional
    String pushFromSiharaiWorkListBL() {

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        BizPropertyInitializer.initialize(uiBean);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(bzWorkflowInfo.getKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());
        uiBean.setSkno(gyoumuKouteiInfo.getSkno());
        uiBean.setKouteikanriid(gyoumuKouteiInfo.getKouteikanriid());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(bzWorkflowInfo.getKouteiKanriId(), TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
        uiBean.setKouteilockkey(bzCommonLockProcess.getKouteiLockKey());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn =  bzTaskStart.exec(bzWorkflowInfo.getKouteiKanriId(),
            TeisuuSiharai.JIMUTETUZUKICD_SISIBOU, kinouMode.getKinouMode(), bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }

        if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon>  siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        uiBean.setSiKykKihon(siKykKihonLst.get(0));

        if (uiBean.getSiKykKihon() != null) {
            List<JT_SiUkt> siUktLst = uiBean.getSiKykKihon().getSiUkts();
            uiBean.setSiUktLst(siUktLst);

            List<JT_SiKykSyouhn> siKykSyouhnLst= uiBean.getSiKykKihon().getSiKykSyouhns();
            for (JT_SiKykSyouhn siKykSyouhn: siKykSyouhnLst) {
                if (C_SyutkKbn.SYU.eq(siKykSyouhn.getSyutkkbn())) {
                    uiBean.setSiKykSyouhn(siKykSyouhn);

                    break;
                }
            }
            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(uiBean.getSiKykSyouhn().getSyouhncd(),
                uiBean.getSiKykSyouhn().getSyouhnsdno());
            if (syouhnZokusei == null) {
                throw new BizAppException(MessageId.EBS0005,BM_SyouhnZokusei.TABLE_NAME, BM_SyouhnZokusei.SYOUHNCD,
                    uiBean.getSiKykSyouhn().getSyouhncd(), BM_SyouhnZokusei.SYOUHNSDNO,
                    String.valueOf(uiBean.getSiKykSyouhn().getSyouhnsdno()));
            }
            uiBean.setSyouhnZokusei(syouhnZokusei);

            List<JM_SiSyouhnZokusei> shrSyouhnZokusei = siharaiDomManager
                .getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(
                    uiBean.getSiKykSyouhn().getSyouhncd(), uiBean.getSiKykSyouhn().getKyhgndkatakbn(),
                    uiBean.getSiKykSyouhn().getSyouhnsdno());
            if (shrSyouhnZokusei.size() == 0) {
                throw new BizAppException(MessageId.EBS0006, JM_SiSyouhnZokusei.TABLE_NAME, JM_SiSyouhnZokusei.SYOUHNCD,
                    uiBean.getSiKykSyouhn().getSyouhncd(), JM_SiSyouhnZokusei.KYHGNDKATAKBN,
                    String.valueOf(uiBean.getSiKykSyouhn().getKyhgndkatakbn()), JM_SiSyouhnZokusei.SYOUHNSDNO,
                    String.valueOf(uiBean.getSiKykSyouhn().getSyouhnsdno()));
            }
            uiBean.setShrSyouhnZokusei(shrSyouhnZokusei);

        }

        Integer  seikyuurirekiNo = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(uiBean.getSkno(), uiBean.getSyono());

        if (seikyuurirekiNo == null || seikyuurirekiNo == 0) {
            throw new BizAppException(MessageId.EBS1003, JT_Sk.SEIKYUURIREKINO, "null");
        }

        String ttdkrrkskbtKey = siharaiDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(uiBean.getSkno(), uiBean.getSyono());

        getInfo(uiBean.getSkno(),uiBean.getSyono(),seikyuurirekiNo,ttdkrrkskbtKey,true);

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        C_UktKyksyaTdk uktKyksyaTdk = uktkyksyatdkCheck(uiBean.getSiUktLst(),uiBean.getSk().getSeikyuusyakbn());

        uiBean.setUktKyksyaTdk(uktKyksyaTdk);

        String inputContentsPath = setInputContentsPath();

        setUiBean(true);

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue()) ) {
            uiBean.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
            uiBean.setTennousakisousasyacd("");
            uiBean.setSyanaicomment("");
        }


        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            uiBean.setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
            uiBean.setSateitennousakisousasyacd("");
            uiBean.setSateisyanaicomment("");
        }

        List<GetProgressHistoryOutBean> getProgressHistoryOutBeanLst = Lists.newArrayList();

        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector
            .getInstance(BzGetProcessRecordInputBean.class);

        bzGetProcessRecordInputBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
        bzGetProcessRecordInputBean.setKouteiKanriId(uiBean.getKouteikanriid());
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.GYOUMU);

        int count = 0;

        List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = bzGetProcessRecord.exec(
            bzGetProcessRecordInputBean).getBzGetKouteiRirekiBeanLstLst();

        for (BzGetProcessRecordBean outBean : bzGetProcessRecordBeanLst) {
            boolean progressHistoryFlg = true;
            for (GetProgressHistoryOutBean getProgressHistoryOutBean : getProgressHistoryOutBeanLst) {
                if (outBean.getTasknm().equals(getProgressHistoryOutBean.getTaskName())) {
                    progressHistoryFlg = false;

                    break;
                }
            }
            if (progressHistoryFlg) {
                GetProgressHistoryOutBean getProcessOutBean = SWAKInjector.getInstance(GetProgressHistoryOutBean.class);

                AM_User userInfo = baseDomManager.getUser(bzGetProcessRecordBeanLst.get(count).getUserId());
                if (userInfo != null) {
                    getProcessOutBean.setTantousyaName(userInfo.getUserNm());
                }
                getProcessOutBean.setSyoriTime(bzGetProcessRecordBeanLst.get(count).getSyoriTime());
                getProcessOutBean.setTaskName(bzGetProcessRecordBeanLst.get(count).getTasknm());
                getProcessOutBean.setSyorikekkaKbn(bzGetProcessRecordBeanLst.get(count).getSyorikekkaKbn());
                getProcessOutBean.setComment(bzGetProcessRecordBeanLst.get(count).getRirekiMessage());

                getProgressHistoryOutBeanLst.add(getProcessOutBean);

            }
            if (bzGetProcessRecordBeanLst.get(count).getTasknm().equals(C_SikinouModeIdKbn.SATEI1.getContent())){
                break;
            }

            count =  count + 1 ;
        }


        if (KAKUNIN_KOUMOKU_MAP.containsKey(kinouMode.getKinouMode())) {
            List<ViewKakuninkoumokuInfoDataSourceBean>  dataSourceBeanLst = Lists.newArrayList();

            String[] kakuninKoumoku = KAKUNIN_KOUMOKU_MAP.get(kinouMode.getKinouMode());
            for (int modeIdIndex = 0 ; modeIdIndex < kakuninKoumoku.length; modeIdIndex++) {
                for (GetProgressHistoryOutBean outBean : getProgressHistoryOutBeanLst) {
                    if (kakuninKoumoku[modeIdIndex].equals(outBean.getTaskName())) {
                        ViewKakuninkoumokuInfoDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                            ViewKakuninkoumokuInfoDataSourceBean.class);
                        dataSourceBean.setDispsyoriymd(BizDate.valueOf(outBean.getSyoriTime().substring(0,8)));
                        dataSourceBean.setDisptasknm(outBean.getTaskName());
                        dataSourceBean.setDispsyorikekkakbn(outBean.getSyorikekkaKbn());
                        dataSourceBean.setDispsousasyanm(outBean.getTantousyaName());
                        dataSourceBean.setDispcomment(outBean.getComment());

                        dataSourceBeanLst.add(dataSourceBean);
                    }
                }
            }

            uiBean.setViewKakuninkoumokuInfo(dataSourceBeanLst);
        }

        if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) {
            if (C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
                uiBean.setTsinyno(uiBean.getSiKykKihon().getKykdryno());
                uiBean.setTsinadr1kj(uiBean.getSiKykKihon().getKykdradr1kj());
                uiBean.setTsinadr2kj(uiBean.getSiKykKihon().getKykdradr2kj());
                uiBean.setTsinadr3kj(uiBean.getSiKykKihon().getKykdradr3kj());
                uiBean.setTsintelno(uiBean.getSiKykKihon().getKykdrtelno());
            }
            else {
                SiSetUiBean.setSouhusakiKykAdr(uiBean, uiBean.getSiKykKihon());
            }
        }

        if (C_SeikyuusyaKbn.UKTHONNIN.eq(uiBean.getSeikyuusyakbn())) {
            BizDate ukthonninYmd = null;
            String ukthonninKn = "";
            String ukthonninKj = "";
            List<JT_SiUkt> siUktLst = uiBean.getSiKykKihon().getSiUkts();
            for (JT_SiUkt siUkt : siUktLst) {
                if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu())) {
                    ukthonninYmd = siUkt.getUktseiymd();
                    ukthonninKn = siUkt.getUktnmkn();
                    ukthonninKj = siUkt.getUktnmkj();
                    break;
                }
            }
            uiBean.setSeikyuusyaseiymd(ukthonninYmd);
            uiBean.setSeikyuusyanmkn(ukthonninKn);
            uiBean.setSeikyuusyanmkj(ukthonninKj);
        }
        else if (C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
            uiBean.setSeikyuusyaseiymd(uiBean.getSiKykKihon().getKykdrseiymd());
            uiBean.setSeikyuusyanmkn(uiBean.getSiKykKihon().getKykdairinmkn());
            uiBean.setSeikyuusyanmkj(uiBean.getSiKykKihon().getKykdairinmkj());
        }

        List<String> byoumeitourokunolist = Lists.newArrayList();

        for (ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean : uiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData()) {
            if (C_Delflag.BLNK.eq(dataSourceBean.getSakujyoflg()) && !BizUtil.isBlank(dataSourceBean.getByoumeikj())) {
                byoumeitourokunolist.add(dataSourceBean.getByoumeitourokuno());
            }
        }
        uiBean.setByoumeitourokunolist(byoumeitourokunolist);

        Siinhantei siinhantei = SWAKInjector.getInstance(Siinhantei.class);

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue())) {
            C_SiinKbn    siinkbn =  siinhantei.hanteiSatei(uiBean.getSiinkbn(),uiBean.getSatei1Syorikekkakbn());
            uiBean.setSiinkbn(siinkbn);
        }

        CheckSbSkNaiyou checkSbSkNaiyou = SWAKInjector.getInstance(CheckSbSkNaiyou.class);

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(uiBean, kinou.getKinouId(),
            C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        uiBean.setCheckSbSkNaiyouKekkaBean(checkSbSkNaiyouKekkaBean);

        uiBean.setSateikoumoku(uiBean.getCheckSbSkNaiyouKekkaBean().getSateiKoumokuMessage());
        uiBean.setKzmeiginmkn(uiBean.getSk().getKzmeiginmkn());

        SiSKNaiyouChkWarningmsgSettei siSKNaiyouChkWarningmsgSettei = SWAKInjector.getInstance(SiSKNaiyouChkWarningmsgSettei.class);

        siSKNaiyouChkWarningmsgSettei.exec(GROUP_WARNING_MESSAGE_ONE, uiBean.getCheckSbSkNaiyouKekkaBean().getWarningMessageList());

        if (!uiBean.getCheckSbSkNaiyouKekkaBean().getErrorMessageCollector().isEmpty()) {
            errorMessageCollector.addAll(uiBean.getCheckSbSkNaiyouKekkaBean().getErrorMessageCollector());
        }

        SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siSiharaiKingakuKeisanBean.setSyoNo(uiBean.getSyono());
        siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(uiBean.getSkkihon().getSeikyuusyubetu());
        siSiharaiKingakuKeisanBean.setCalcKijyunYmd(uiBean.getSibouymd());
        siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(uiBean.getInputshrhousiteikbn());
        siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(uiBean.getSyoruiukeymd());
        siSiharaiKingakuKeisanBean.setHubiKanryouYmd(uiBean.getHubikanryouymd());
        siSiharaiKingakuKeisanBean.setRikoukiTyuutuudanNissuu(uiBean.getRikoukityuutuudannissuu());
        siSiharaiKingakuKeisanBean.setSinsaGendoKknKbn(uiBean.getSinsagendokknkbn());
        siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(uiBean.getSuketorihouhoukbn());
        siSiharaiKingakuKeisanBean.setSiharaiTuukaKbn(uiBean.getSiharaituukakbn());
        siSiharaiKingakuKeisanBean.setSiKykKihon(uiBean.getSiKykKihon());
        siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(uiBean.getSihonninkakninkbn());
        siSiharaiKingakuKeisanBean.setKeisanKahiKbn(uiBean.getCheckSbSkNaiyouKekkaBean().getKeisanKahiKbn());
        siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());
        siSiharaiKingakuKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        siSiharaiKingakuKeisanBean.setSiinKbn(uiBean.getSiinkbn());
        siSiharaiKingakuKeisanBean.setSaisateiKbn(uiBean.getSaisateikbn());
        siSiharaiKingakuKeisanBean.setUktMnmeigiBangou(uiBean.getUktmnmeigibangou());
        siSiharaiKingakuKeisanBean.setKykMnmeigiBango(uiBean.getKykmnmeigibangou());
        siSiharaiKingakuKeisanBean.setBankCd(uiBean.getBankcd());
        siSiharaiKingakuKeisanBean.setSeikyuusyaKbn(uiBean.getSeikyuusyakbn());

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType type = henkanTuuka.henkanTuukaKbnToType(uiBean.getSiKykKihon().getSiKykSyouhns().get(0)
            .getKyktuukasyu());
        BizCurrency nkKknJyutouGk = BizCurrency.valueOf(0, type);
        siSiharaiKingakuKeisanBean.setNkKknJyutouGk(nkKknJyutouGk);

        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

        uiBean.setSiSiDetailParamBeanLst(siSiharaiKingakuKeisan.getSiSiDetailParamBean());
        uiBean.setSiNenkinInfoBean(siSiharaiKingakuKeisan.getSiNenkinInfoBean());
        uiBean.setSiHkkingakuSisanParamBean(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean());
        uiBean.setSkNaiyouChkkekkaKbn(siSiharaiKingakuKeisan.getCSKNaiyouChkkekkaKbn());
        uiBean.setSiDetailMisyuupBeanLst(siSiharaiKingakuKeisan.getSiDetailMisyuupBeans());
        uiBean.setSiDetailMikeikapBeanLst(siSiharaiKingakuKeisan.getDetailMikeikapBeans());
        uiBean.setEditDshrTukiDKoumokuBean(siSiharaiKingakuKeisan.getEditDshrTukiDKoumokuBean());

        if (siSiharaiKingakuKeisan.getWarnMsg().size() != 0) {
            siSKNaiyouChkWarningmsgSettei.exec(GROUP_WARNING_MESSAGE_ONE, siSiharaiKingakuKeisan.getWarnMsg());

        }

        if (!siSiharaiKingakuKeisan.getErrMsg().isEmpty()) {

            errorMessageCollector.addAll(siSiharaiKingakuKeisan.getErrMsg());
        }

        List<JT_SiDetail> siDerailLst = siSiDetailParamBeanEdit(uiBean.getSiSiDetailParamBeanLst());

        uiBean.setSiDetailLst(siDerailLst);

        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);

        siSetUiBean.setHKTShrMeisai(uiBean, uiBean.getSiDetailLst());

        SiSetUiBean.setSiharaiKingakuKeisanResult(uiBean, uiBean.getSiHkkingakuSisanParamBean());

        if (!C_HokenkinsyuruiKbn.BLNK.eq(uiBean.getSiHkkingakuSisanParamBean().getHokenkinsyuruiKbn()) &&
            !C_HknKknKbn.BLNK.eq(uiBean.getSiHkkingakuSisanParamBean().getHknKknKbn())) {

            String hokenknsyurui = uiBean.getSiHkkingakuSisanParamBean().getHokenkinsyuruiKbn().getContent()
                + "（" + uiBean.getSiHkkingakuSisanParamBean().getHknKknKbn().getContent() + "）";

            uiBean.setHokenkinsyurui(hokenknsyurui);
        }

        C_ZeitratkiKbn  zeitratkiKbn = getZeitratkiKbn(uiBean.getSiKykKihon().getKkkyktdk(),uiBean.getUktKyksyaTdk());

        uiBean.setZeitratkikbn(zeitratkiKbn);
        uiBean.setKykhnkkaisuu(uiBean.getSiKykKihon().getKykhnkkaisuu());

        setTensousaki();

        betuskSyorityuChk(uiBean.getSyono(), uiBean.getSkno());

        setSyorikekkaKbn();

        setInputShrhousiteiKbn();

        setSiharaiTuukaKbn();

        HanteiSaikenInfoNyuuryoku hanteiSaikenInfoNyuuryoku = SWAKInjector.getInstance(HanteiSaikenInfoNyuuryoku.class);

        boolean isSaikenInfoNyuuryoku = hanteiSaikenInfoNyuuryoku.exec(uiBean.getSiKykKihon());
        uiBean.setViewSaikenInfoFlg(isSaikenInfoNyuuryoku) ;
        if(!uiBean.isViewSaikenInfoFlg()) {
            uiBean.setSaikennmkj("");
            uiBean.setSaikennyno("");
            uiBean.setSaikenadr1kj("");
            uiBean.setSaikenadr2kj("");
            uiBean.setSaikenadr3kj("");
        }

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {

            if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(uiBean.getSatei1Syorikekkakbn()) &&
                C_SaisateiKbn.BLNK.eq(uiBean.getSkkihon().getSaisateikbn())){

                List<JT_SiRireki> siRirekiList = uiBean.getSkkihon().getSiRirekis();
                SortJT_SiRireki sortSiRireki = SWAKInjector.getInstance(SortJT_SiRireki.class);
                JT_SiRireki siRireki = sortSiRireki.OrderJT_SiRirekiByPkDesc(siRirekiList).get(0);

                uiBean.setShrymd(siRireki.getTyakkinymd());
            }

            SiSetUiBean.setShrGoukei(uiBean, uiBean.getSk());
        }


        List<Message> messageLst =  errorMessageCollector.getMessages();
        uiBean.setErrmessagecollector(messageLst);
        for (Message message : messageLst) {
            if (message.getMessageId().startsWith("T")) {
                messageManager.addConversationMessage(message);
            }
            if (message.getMessageId().startsWith("E")) {

                messageManager.addMessage(message);
            }
        }

        uiBean.setSiTtzkRirekiSyoukaiYouhiKbn(C_YouhiKbn.HUYOU);

        setSaigaiHosyouUmuKbn();

        uiBean.setViewSkjyouhouInputDispFlg(false);
        uiBean.setViewSouhusakiInputDispFlg(false);
        uiBean.setViewSoukinsakiInputDispFlg(false);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(false);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);
        uiBean.setViewSaikenInfoInputDispFlg(false);
        if (uiBean.getSaisateikbn().equals(C_SaisateiKbn.BLNK)) {
            uiBean.setViewShrdtlSakuseiKbnFlg(true);
        }
        else {
            uiBean.setViewShrdtlSakuseiKbnFlg(false);
        }
        if (uiBean.getHaitoukin().equalsValue(BizCurrency.valueOf(0, uiBean.getHaitoukin().getType()))) {
            uiBean.setShrGoukeiHaitoukinDispFlg(false);
        } else {
            uiBean.setShrGoukeiHaitoukinDispFlg(true);
        }
        if (uiBean.getSonotahaitoukin().equalsValue(BizCurrency.valueOf(0, uiBean.getSonotahaitoukin().getType()))) {
            uiBean.setShrGoukeiSonotahaitoukinDispFlg(false);
        } else {
            uiBean.setShrGoukeiSonotahaitoukinDispFlg(true);
        }
        if (uiBean.getMikeikap().equalsValue(BizCurrency.valueOf(0, uiBean.getMikeikap().getType()))) {
            uiBean.setShrGoukeiMikeikapDispFlg(false);
        } else {
            uiBean.setShrGoukeiMikeikapDispFlg(true);
        }
        if (uiBean.getMisyuup().equalsValue(BizCurrency.valueOf(0, uiBean.getMisyuup().getType()))) {
            uiBean.setShrGoukeiMisyuupDispFlg(false);
        } else {
            uiBean.setShrGoukeiMisyuupDispFlg(true);
        }
        if (uiBean.getZennouseisankgk().equalsValue(BizCurrency.valueOf(0, uiBean.getZennouseisankgk().getType()))) {
            uiBean.setShrGoukeiZennouseisankgkDispFlg(false);
        } else {
            uiBean.setShrGoukeiZennouseisankgkDispFlg(true);
        }
        if (uiBean.getAzukarikingk().equalsValue(BizCurrency.valueOf(0, uiBean.getAzukarikingk().getType()))) {
            uiBean.setShrGoukeiAzukarikingkDispFlg(false);
        } else {
            uiBean.setShrGoukeiAzukarikingkDispFlg(true);
        }
        if (uiBean.getKrkgk().equalsValue(BizCurrency.valueOf(0, uiBean.getKrkgk().getType()))) {
            uiBean.setShrGoukeiKrkgkDispFlg(false);
        } else {
            uiBean.setShrGoukeiKrkgkDispFlg(true);
        }
        if (C_Tuukasyu.JPY.equals(uiBean.getSk().getKyktuukasyu()) ||
            uiBean.isShrGoukeiHaitoukinDispFlg() == false && uiBean.isShrGoukeiSonotahaitoukinDispFlg() == false &&
            uiBean.isShrGoukeiMikeikapDispFlg() == false && uiBean.isShrGoukeiZennouseisankgkDispFlg() == false &&
            uiBean.isShrGoukeiAzukarikingkDispFlg() == false && uiBean.isShrGoukeiKrkgkDispFlg() == false) {
            uiBean.setViewSiharaiInfoGaikaknsnKijyunYmdFlg(false);
        } else {
            uiBean.setViewSiharaiInfoGaikaknsnKijyunYmdFlg(true);
        }

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue()) ) {
            uiBean.setViewSiharaiSateiInputDispFlg(true);
        }
        else {
            uiBean.setViewSiharaiSateiInputDispFlg(false);
        }

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            uiBean.setViewKokuhanCheckInputDispFlg(true);
            uiBean.setViewIppanhanteiInputDispFlg(true);
            uiBean.setViewBetukutiCheckSibouInputDispFlg(true);
            uiBean.setViewTratkihuryouHusyoujikenInputDispFlg(true);
            uiBean.setViewJyuukasituInfoInputDispFlg(true);
        }
        else {
            uiBean.setViewKokuhanCheckInputDispFlg(false);
            uiBean.setViewIppanhanteiInputDispFlg(false);
            uiBean.setViewBetukutiCheckSibouInputDispFlg(false);
            uiBean.setViewTratkihuryouHusyoujikenInputDispFlg(false);
            uiBean.setViewJyuukasituInfoInputDispFlg(false);
        }

        return inputContentsPath;
    }


    String pushFromSiTtzkRirekiSyoukaiBL() {
        BizPropertyInitializer.initialize(uiBean);

        List<TtzkRrkListDataSourceBean> dataSourceBeanLst = uiBean.getSiTtzkRirekiSyoukaiUiBean().getTtzkRrkListDataSource().getAllData();
        TtzkRrkListDataSourceBean ttzkRrkListDataSourceBean = SWAKInjector.getInstance(TtzkRrkListDataSourceBean.class);
        int sntkgyouno = uiBean.getSiTtzkRirekiSyoukaiUiBean().getSntkgyouno();

        for (int i = 0 ; i < dataSourceBeanLst.size(); i++ ) {
            if (i == sntkgyouno) {
                ttzkRrkListDataSourceBean = dataSourceBeanLst.get(sntkgyouno);
                break;
            }
        }

        kinouMode.setKinouMode(ttzkRrkListDataSourceBean.getKinouModeId());

        getInfo(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno(),uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono(),
            ttzkRrkListDataSourceBean.getSeiRrkNo(),ttzkRrkListDataSourceBean.getDispttdkrrkskbtkey(),false);

        setUiBean(false);

        C_SyorikekkaKbn syorikekkka = uiBean.getSyorikekkakbn();
        String tensousaki = uiBean.getTennousakisousasyacd();
        String syanaikoment = uiBean.getSyanaicomment();

        JT_SateiSyouninRireki sateiSyouninRireki =  uiBean.getSkkihon().getSateiSyouninRirekiBySateisyouninskbtkey(
            uiBean.getTtdkRireki().getSateisyouninskbtkey());

        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);

        SiSetUiBean.setSateiSyouninRireki(uiBean, sateiSyouninRireki, uiBean.getTtdkRireki());

        uiBean.setSyorikekkakbn(syorikekkka);
        uiBean.setTennousakisousasyacd(tensousaki);
        uiBean.setSyanaicomment(syanaikoment);


        if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue()))) {

            siSetUiBean.setSateiSiharaiSatei(uiBean, sateiSyouninRireki, uiBean.getTtdkRireki(), uiBean.getSk());

        }

        uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_DEFAULT);

        uiBean.setPatternSateiSyorikekkakbn(C_SyorikekkaKbn.PATTERN_DEFAULT);

        setInputShrhousiteiKbn();

        uiBean.setPatternSiharaiTuukaKbn(C_SiharaiTuukaKbn.PATTERN_DEFAULT);

        uiBean.setSiTtzkRirekiSyoukaiYouhiKbn(C_YouhiKbn.YOU);

        String wkTensousakiId = sateiSyouninRireki.getTennousakisousasyacd();
        if(!BizUtil.isBlank(wkTensousakiId)){
            String wkTensousakiNm = "";
            AM_User userInfo = baseDomManager.getUser(wkTensousakiId);
            if (userInfo != null) {
                wkTensousakiNm = userInfo.getUserNm();
            }
            UsersByKinouIdKinouModeIdUserIdBean usersByKinouIdKinouModeIdUserIdBean =
                new UsersByKinouIdKinouModeIdUserIdBean(wkTensousakiId, wkTensousakiNm);
            List<UsersByKinouIdKinouModeIdUserIdBean> userLst = Arrays.asList(usersByKinouIdKinouModeIdUserIdBean);
            setTennousakisousasyacd(userLst);
        }

        if (C_Kzdou.DOUITU.eq(uiBean.getSk().getKzdoukbn())){
            uiBean.setKzmeiginmkn(uiBean.getSk().getKzmeiginmkn());
        }

        uiBean.setKykhnkkaisuu(0);

        AS_Kinou kinouNm = baseDomManager.getKinou(TeisuuSiharai.SITTZKRIREKISYOUKAI);
        uiBean.setKinouNm(kinouNm.getKinouNm());

        String kakuninPath = setKakuninPath();

        uiBean.setViewSkjyouhouInputDispFlg(false);
        uiBean.setViewSouhusakiInputDispFlg(false);
        uiBean.setViewSoukinsakiInputDispFlg(false);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(false);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);
        uiBean.setViewKokuhanCheckInputDispFlg(false);
        uiBean.setViewIppanhanteiInputDispFlg(false);
        uiBean.setViewSiharaiSateiInputDispFlg(false);
        uiBean.setViewBetukutiCheckSibouInputDispFlg(false);
        uiBean.setViewTratkihuryouHusyoujikenInputDispFlg(false);
        uiBean.setViewJyuukasituInfoInputDispFlg(false);
        uiBean.setViewSaikenInfoInputDispFlg(false);
        if (uiBean.getSaisateikbn().equals(C_SaisateiKbn.BLNK)) {
            uiBean.setViewShrdtlSakuseiKbnFlg(true);
        }
        else {
            uiBean.setViewShrdtlSakuseiKbnFlg(false);
        }
        if (uiBean.getHaitoukin().equalsValue(BizCurrency.valueOf(0, uiBean.getHaitoukin().getType()))) {
            uiBean.setShrGoukeiHaitoukinDispFlg(false);
        } else {
            uiBean.setShrGoukeiHaitoukinDispFlg(true);
        }
        if (uiBean.getSonotahaitoukin().equalsValue(BizCurrency.valueOf(0, uiBean.getSonotahaitoukin().getType()))) {
            uiBean.setShrGoukeiSonotahaitoukinDispFlg(false);
        } else {
            uiBean.setShrGoukeiSonotahaitoukinDispFlg(true);
        }
        if (uiBean.getMikeikap().equalsValue(BizCurrency.valueOf(0, uiBean.getMikeikap().getType()))) {
            uiBean.setShrGoukeiMikeikapDispFlg(false);
        } else {
            uiBean.setShrGoukeiMikeikapDispFlg(true);
        }
        if (uiBean.getMisyuup().equalsValue(BizCurrency.valueOf(0, uiBean.getMisyuup().getType()))) {
            uiBean.setShrGoukeiMisyuupDispFlg(false);
        } else {
            uiBean.setShrGoukeiMisyuupDispFlg(true);
        }
        if (uiBean.getZennouseisankgk().equalsValue(BizCurrency.valueOf(0, uiBean.getZennouseisankgk().getType()))) {
            uiBean.setShrGoukeiZennouseisankgkDispFlg(false);
        } else {
            uiBean.setShrGoukeiZennouseisankgkDispFlg(true);
        }
        if (uiBean.getAzukarikingk().equalsValue(BizCurrency.valueOf(0, uiBean.getAzukarikingk().getType()))) {
            uiBean.setShrGoukeiAzukarikingkDispFlg(false);
        } else {
            uiBean.setShrGoukeiAzukarikingkDispFlg(true);
        }
        if (uiBean.getKrkgk().equalsValue(BizCurrency.valueOf(0, uiBean.getKrkgk().getType()))) {
            uiBean.setShrGoukeiKrkgkDispFlg(false);
        } else {
            uiBean.setShrGoukeiKrkgkDispFlg(true);
        }
        if (C_Tuukasyu.JPY.equals(uiBean.getSk().getKyktuukasyu()) ||
            uiBean.isShrGoukeiHaitoukinDispFlg() == false && uiBean.isShrGoukeiSonotahaitoukinDispFlg() == false &&
            uiBean.isShrGoukeiMikeikapDispFlg() == false && uiBean.isShrGoukeiZennouseisankgkDispFlg() == false &&
            uiBean.isShrGoukeiAzukarikingkDispFlg() == false && uiBean.isShrGoukeiKrkgkDispFlg() == false) {
            uiBean.setViewSiharaiInfoGaikaknsnKijyunYmdFlg(false);
        } else {
            uiBean.setViewSiharaiInfoGaikaknsnKijyunYmdFlg(true);
        }

        return kakuninPath;
    }

    void pushTeiseiBL () {

        doContinueLockProcess();

        uiBean.setBanknmkj("");
        uiBean.setSitennmkj("");

        if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
            uiBean.setKzmeiginmkn("");
        }

        if (C_SeikyuusyaKbn.UKTHONNIN.eq(uiBean.getSeikyuusyakbn())
            || C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
            uiBean.setSeikyuusyaseiymd(null);
            uiBean.setSeikyuusyanmkn("");
            uiBean.setSeikyuusyanmkj("");
        }

        if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) {
            uiBean.setTsinyno("");
            uiBean.setTsinadr1kj("");
            uiBean.setTsinadr2kj("");
            uiBean.setTsinadr3kj("");
            uiBean.setTsintelno("");
        }

        List<Message> messageLst =  uiBean.getErrmessagecollector();
        for (Message message : messageLst) {
            if (message.getMessageId().startsWith("E")) {
                messageManager.addMessage(message);
            }
        }

        uiBean.setViewSkjyouhouInputDispFlg(true);
        uiBean.setViewSouhusakiInputDispFlg(true);
        uiBean.setViewSoukinsakiInputDispFlg(true);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(true);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(true);
        uiBean.setViewSaikenInfoInputDispFlg(true);

        uiBean.setNewDtaSourceBeanLst(uiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData());

        setViewSindansyoinfoSibouInfo();

        uiBean.setTyouhyouKey(null);
    }

    String pushKakuninBL () {

        doContinueLockProcess();

        ErrorMessageCollector errorMessageCollector2 = SWAKInjector.getInstance(ErrorMessageCollector.class);
        List<Message> messageLst =  uiBean.getErrmessagecollector();
        for (Message message : messageLst) {
            if (message.getMessageId().startsWith("E")) {
                errorMessageCollector2.add(message);
            }
        }
        SateiKekkaNyuuryokuChk sateiKekkaNyuuryokuChk = SWAKInjector.getInstance(SateiKekkaNyuuryokuChk.class);

        sateiKekkaNyuuryokuChk.exec(uiBean, uiBean.getSkkihon(), uiBean.getCheckSbSkNaiyouKekkaBean().getChkKekkaBeanList(),
            messageLst, uiBean.getSaigaihosyouumukbn(), uiBean.getSatei1Syorikekkakbn(), C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        if (getInputContentsErrDispFlg()){
            if(errorMessageCollector2.size() > 0){
                throw new BizLogicException(errorMessageCollector2);
            }
        }
        messageManager.addMessageId(MessageId.QBA0001);

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            if (!BizUtil.isBlank(uiBean.getSessyousisyacd())) {
                BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

                BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(uiBean.getSessyousisyacd() + "0000",null);

                uiBean.setSisyanm(bzGetSosikiDataBean.getKanjisosikinm20());
            }
        }

        uiBean.setTyouhyouKey("");

        uiBean.setViewKokuhanCheckInputDispFlg(false);
        uiBean.setViewIppanhanteiInputDispFlg(false);
        uiBean.setViewSiharaiSateiInputDispFlg(false);
        uiBean.setViewBetukutiCheckSibouInputDispFlg(false);
        uiBean.setViewTratkihuryouHusyoujikenInputDispFlg(false);
        uiBean.setViewJyuukasituInfoInputDispFlg(false);
        uiBean.setSiSateiSougouSyoukaiFlg(true);
        String kakuninPath = setKakuninPath();

        return kakuninPath;
    }

    @Transactional
    String pushKakuniniraisyoSakuseiBL () {

        BizDate sysDate = BizDate.getSysDate();

        YuyuSiharaiConfig yuyuSiharaiConfig =  YuyuSiharaiConfig.getInstance();
        String sisKakuninyouTelno = yuyuSiharaiConfig.getSisKakuninyouTelno();
        BizCurrency hokenknGk = BizCurrency.optional();
        BizCurrency saigais = BizCurrency.optional();

        if (uiBean.getSiHkkingakuSisanParamBean() != null) {
            if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(uiBean.getSiHkkingakuSisanParamBean().getHokenkinsyuruiKbn())) {
                if (C_Tuukasyu.JPY.eq(uiBean.getSiHkkingakuSisanParamBean().getKykTuukasyu())) {
                    hokenknGk = uiBean.getSiHkkingakuSisanParamBean().getSbHokenKngk();
                    saigais = uiBean.getSiHkkingakuSisanParamBean().getHokenknGk();
                }
                else {
                    saigais = uiBean.getSiHkkingakuSisanParamBean().getYenHokenknGk();

                    if (uiBean.getSiHkkingakuSisanParamBean().getYenSbHokenKngk()
                        .compareTo(uiBean.getSiHkkingakuSisanParamBean().getInitSbjiYenkasSiteiHsygk()) < 0) {
                        hokenknGk = uiBean.getSiHkkingakuSisanParamBean().getInitSbjiYenkasSiteiHsygk();
                    }
                    else {
                        hokenknGk = uiBean.getSiHkkingakuSisanParamBean().getYenSbHokenKngk();
                    }
                }
            }
            else {
                if (C_Tuukasyu.JPY.eq(uiBean.getSiHkkingakuSisanParamBean().getKykTuukasyu())) {
                    hokenknGk = uiBean.getSiHkkingakuSisanParamBean().getHokenknGk();
                }
                else {
                    hokenknGk = uiBean.getSiHkkingakuSisanParamBean().getYenHokenknGk();
                }
            }
        }

        EditKakuniniraisyoBean editKakuniniraisyoBean = SWAKInjector.getInstance(EditKakuniniraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);

        EditKakuniniraisyo editKakuniniraisyo = SWAKInjector.getInstance(EditKakuniniraisyo.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(sysDate);
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINIRAIS);

        seikyuusyaInfoBean.setSeikyuusyanmKn(uiBean.getSeikyuusyanmkn());
        seikyuusyaInfoBean.setSeikyuusyanmKj(uiBean.getSeikyuusyanmkj());
        seikyuusyaInfoBean.setTsinyno(uiBean.getTsinyno());
        seikyuusyaInfoBean.setTsinadr1kj(uiBean.getTsinadr1kj());
        seikyuusyaInfoBean.setTsinadr2kj(uiBean.getTsinadr2kj());
        seikyuusyaInfoBean.setTsinadr3kj(uiBean.getTsinadr3kj());
        seikyuusyaInfoBean.setTsintelno(uiBean.getTsintelno());

        editKakuniniraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editKakuniniraisyoBean.setSeikyuusyubetu(uiBean.getSkkihon().getSeikyuusyubetu());
        editKakuniniraisyoBean.setSyono(uiBean.getSyono());
        editKakuniniraisyoBean.setKykYmd(uiBean.getSiKykSyouhn().getKykymd());
        editKakuniniraisyoBean.setSibouYmd(uiBean.getSibouymd());
        editKakuniniraisyoBean.setSyoruiukeYmd(uiBean.getSyoruiukeymd());
        editKakuniniraisyoBean.setHksknnkaisiYmd(uiBean.getSiKykKihon().getHksknnkaisiymd());
        editKakuniniraisyoBean.setLastmeihenYmd(uiBean.getSiKykKihon().getLastmeihenymd());
        editKakuniniraisyoBean.setHhknNmkn(uiBean.getSiKykKihon().getHhknnmkn());
        editKakuniniraisyoBean.setHhknNmkj(uiBean.getSiKykKihon().getHhknnmkj());
        editKakuniniraisyoBean.setKyknmkn(uiBean.getSiKykKihon().getKyknmkn());
        editKakuniniraisyoBean.setKyknmkj(uiBean.getSiKykKihon().getKyknmkj());
        editKakuniniraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        editKakuniniraisyoBean.setHokenknGk(hokenknGk);
        editKakuniniraisyoBean.setSaigais(saigais);
        editKakuniniraisyoBean.setHyojitelno(sisKakuninyouTelno);

        ReportServicesBean reportServicesBean = editKakuniniraisyo.exec(editKakuniniraisyoBean);

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        String tyouhyouKey = createReport.execNoCommit(reportServicesBean);

        uiBean.setTyouhyouKey(tyouhyouKey);

        List<Message> messageLst =  uiBean.getErrmessagecollector();
        for (Message message : messageLst) {
            if (message.getMessageId().startsWith("E")) {
                messageManager.addMessage(message);
            }
        }

        String inputContentsPath = "";
        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI1;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI2;
        }

        return inputContentsPath;
    }

    @Transactional
    String pushKakuteiBL () {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTime = BizDate.getSysDateTimeMilli();

        String sateSyouninSikibetukey = SaibanBiz.getSateSyouninSikibetukey(uiBean.getSyono());

        Integer  maxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(uiBean.getSkno(), uiBean.getSyono());
        if (maxSeikyuurirekino == null) {
            throw new BizAppException(MessageId.EBS1003, JT_Sk.SEIKYUURIREKINO, "null");
        }

        maxSeikyuurirekino = maxSeikyuurirekino + 1;

        BizNumber zeimukwsrate = BizNumber.optional();
        BizDate zeimukwsratekjnymd  = uiBean.getSibouymd();
        C_KawasetekiyoKbn  kawasetekiyokbn =   C_KawasetekiyoKbn.BLNK;

        if (!C_Tuukasyu.JPY.eq(uiBean.getSk().getKyktuukasyu())) {
            if (zeimukwsratekjnymd != null && !C_UktKyksyaTdk.BLNK.eq(uiBean.getUktKyksyaTdk())) {
                if (C_UktKyksyaTdk.KYKHNN.eq(uiBean.getUktKyksyaTdk())) {
                    kawasetekiyokbn = C_KawasetekiyoKbn.TTM;
                }
                else {
                    kawasetekiyokbn = C_KawasetekiyoKbn.TTB;
                }

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                C_ErrorKbn errorKbn = getKawaseRate.exec(zeimukwsratekjnymd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    uiBean.getSk().getKyktuukasyu(), C_Tuukasyu.JPY, kawasetekiyokbn, C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                if (!C_ErrorKbn.OK.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBS1003, BM_KawaseRate.KAWASERATE, "null");
                }

                zeimukwsratekjnymd = getKawaseRate.getKwsrateKjYmd();
                zeimukwsrate = getKawaseRate.getKawaserate();
            }
        }
        else {
            zeimukwsratekjnymd = null;
        }

        C_ShrKekkaKbn  shrkekkakbn =  C_ShrKekkaKbn.BLNK;
        C_ShrKekkaKbn  skkihonshrkekkakbn =  uiBean.getSkkihon().getShrkekkakbn();
        if (!C_SaigaiHigaitouKbn.SAIGAIHIGAITOU.eq(uiBean.getSkkihon().getSaigaihigaitoukbn())) {
            if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
                kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ) {
                if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSateisyorikekkakbn())) {
                    if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(uiBean.getSuketorihouhoukbn())) {
                        if (C_UmuKbn.NONE.eq(uiBean.getSiKykKihon().getNstkhkumu())) {
                            shrkekkakbn =  C_ShrKekkaKbn.SHR;
                            skkihonshrkekkakbn =  C_ShrKekkaKbn.SHR;
                        }
                        else {
                            shrkekkakbn =  C_ShrKekkaKbn.NENKINSHR;
                            skkihonshrkekkakbn =  C_ShrKekkaKbn.NENKINSHR;
                        }
                    }
                    else if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(uiBean.getSuketorihouhoukbn())) {
                        shrkekkakbn =  C_ShrKekkaKbn.NENKINSHR;
                        skkihonshrkekkakbn =  C_ShrKekkaKbn.NENKINSHR;
                    }
                    else if (C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(uiBean.getSuketorihouhoukbn())) {
                        shrkekkakbn =  C_ShrKekkaKbn.ITIBU_NENKIN;
                        skkihonshrkekkakbn =  C_ShrKekkaKbn.ITIBU_NENKIN;
                    }
                }
            }
            else {
                if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
                    kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()) ) {
                    if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSateisyorikekkakbn())) {
                        shrkekkakbn =  C_ShrKekkaKbn.HSHR;
                        skkihonshrkekkakbn =  C_ShrKekkaKbn.HSHR;
                    }
                }
            }
        }
        else {
            if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
                kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ) {
                if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSateisyorikekkakbn())) {
                    shrkekkakbn =  C_ShrKekkaKbn.SHR;
                    skkihonshrkekkakbn =  C_ShrKekkaKbn.SHR;

                }
            }
        }

        C_JimukakuteiKbn jimukakuteiKbn = C_JimukakuteiKbn.MIKAKUTEI;

        if (!(C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn()) || C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn()))) {
            jimukakuteiKbn = C_JimukakuteiKbn.KAKUTEI;
        }

        if (uiBean.getKokuhancheck1()) {
            uiBean.setKokuhancheckkbn1(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKokuhancheckkbn1(C_UmuKbn.NONE);
        }

        if (uiBean.getKokuhancheck2()) {
            uiBean.setKokuhancheckkbn2(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKokuhancheckkbn2(C_UmuKbn.NONE);
        }

        if (uiBean.getKokuhancheck3()) {
            uiBean.setKokuhancheckkbn3(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKokuhancheckkbn3(C_UmuKbn.NONE);
        }

        if (uiBean.getKokuhancheck4()) {
            uiBean.setKokuhancheckkbn4(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKokuhancheckkbn4(C_UmuKbn.NONE);
        }

        if (uiBean.getKokuhancheck5()) {
            uiBean.setKokuhancheckkbn5(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKokuhancheckkbn5(C_UmuKbn.NONE);
        }

        if (uiBean.getKokuhancheck6()) {
            uiBean.setKokuhancheckkbn6(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKokuhancheckkbn6(C_UmuKbn.NONE);
        }

        if (uiBean.getKokuhancheck7()) {
            uiBean.setKokuhancheckkbn7(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKokuhancheckkbn7(C_UmuKbn.NONE);
        }

        if (uiBean.getKokuhancheck8()) {
            uiBean.setKokuhancheckkbn8(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKokuhancheckkbn8(C_UmuKbn.NONE);
        }

        if (uiBean.getJuukasitucheck1()) {
            uiBean.setJuukasitucheckkbn1(C_UmuKbn.ARI);
        }
        else {
            uiBean.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        }

        if (uiBean.getJuukasitucheck2()) {
            uiBean.setJuukasitucheckkbn2(C_UmuKbn.ARI);
        }
        else {
            uiBean.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        }

        if (uiBean.getJuukasitucheck3()) {
            uiBean.setJuukasitucheckkbn3(C_UmuKbn.ARI);
        }
        else {
            uiBean.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        }

        if (uiBean.getJuukasitucheck4()) {
            uiBean.setJuukasitucheckkbn4(C_UmuKbn.ARI);
        }
        else {
            uiBean.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        }

        BizDate gaibuinsatuoutymd = uiBean.getSkkihon().getGaibuinsatuoutymd();
        if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue())) &&
            (C_KanryotuutioutKbn.GAIBU.eq(uiBean.getShrdtlsyooutkbn()) &&
                (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSateisyorikekkakbn())))) {
            gaibuinsatuoutymd = sysDate;
        }

        C_SateiYouhiKbn sateiYouhiKbn = C_SateiYouhiKbn.BLNK;
        C_UmuKbn sateiSanjikaisouUmuKbn = C_UmuKbn.NONE;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) ) {
            HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);

            HanteiSateiRank hanteiSateiRank = SWAKInjector.getInstance(HanteiSateiRank.class);

            hanteiSateiRankBean.setSyono(uiBean.getSyono());
            hanteiSateiRankBean.setSeikyuuSyubetu(uiBean.getSkkihon().getSeikyuusyubetu());
            hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
            hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(uiBean.getSkNaiyouChkkekkaKbn());
            hanteiSateiRankBean.setSaisateikbn(uiBean.getSkkihon().getSaisateikbn());

            HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);

            sateiYouhiKbn = hanteiSateiRankKekkaBean.getSateiYouhiKbn();
            sateiSanjikaisouUmuKbn = hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn();
        }

        if (C_SyorikekkaKbn.SATEI_SIJI.eq(uiBean.getSateisyorikekkakbn())) {

            sateiYouhiKbn = C_SateiYouhiKbn.YOU;
        }

        else {
            sateiYouhiKbn = uiBean.getSkkihon().getSateiyhkbn();
        }

        C_SaigaiHigaitouKbn saigaihigaitouKbn = C_SaigaiHigaitouKbn.BLNK;
        if((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) &&
            C_UmuKbn.NONE.eq(sateiSanjikaisouUmuKbn))||
            (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue()))) {
            if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(uiBean.getSyorikekkakbn())) {

                saigaihigaitouKbn = C_SaigaiHigaitouKbn.SAIGAIHIGAITOU;
            }
        }
        else {
            if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue()) &&
                C_SyorikekkaKbn.HUSYOUNIN.eq(uiBean.getSateisyorikekkakbn())) ||
                (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue()) &&
                    C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn()))) {
                saigaihigaitouKbn = C_SaigaiHigaitouKbn.BLNK;
            }
            else {
                saigaihigaitouKbn = uiBean.getSkkihon().getSaigaihigaitoukbn();
            }
        }

        C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;

        if (uiBean.getSiHkkingakuSisanParamBean() == null ||
            C_Tuukasyu.BLNK.eq(uiBean.getSiHkkingakuSisanParamBean().getShrTuukasyu())){
            tuukasyu = uiBean.getSk().getShrtuukasyu();
        }
        else {
            tuukasyu = uiBean.getShrtuukasyu();
        }

        BizDate tienrisokuisanymd = null;
        Integer tienrsknissuu = 0;

        if (!(C_Tuukasyu.JPY.eq(uiBean.getSk().getKyktuukasyu())) &&
            C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
            tienrisokuisanymd = uiBean.getYentienrisokukisanymd();
            tienrsknissuu = uiBean.getYentienrsknissuu();
        } else {
            tienrisokuisanymd = uiBean.getTienrisokukisanymd();
            tienrsknissuu = uiBean.getTienrsknissuu();
        }

        SkTblSetBean skTblSetBean = SWAKInjector.getInstance(SkTblSetBean.class);
        skTblSetBean.setUktkyksyatdk(uiBean.getUktKyksyaTdk());
        skTblSetBean.setSinsagendokknkbn(uiBean.getSinsagendokknkbn());
        skTblSetBean.setRikoukityuutuudannissuu(uiBean.getRikoukityuutuudannissuu());
        skTblSetBean.setTienrisokukisanymd(tienrisokuisanymd);
        skTblSetBean.setTienrsknissuu(tienrsknissuu);
        if (uiBean.getSiHkkingakuSisanParamBean() != null ){
            if (!C_Tuukasyu.JPY.eq(uiBean.getSk().getKyktuukasyu()) &&
                C_SiharaiTuukaKbn.YENSIHARAI.eq(uiBean.getSiharaituukakbn())) {
                zeimukwsratekjnymd = uiBean.getSiHkkingakuSisanParamBean().getKnsnKijyunYmd();
                zeimukwsrate = uiBean.getSiHkkingakuSisanParamBean().getKawaseRate();
            }
        }
        skTblSetBean.setKyktuukasyu(uiBean.getSk().getKyktuukasyu());
        skTblSetBean.setShrtuukasyu(tuukasyu);
        skTblSetBean.setShrkwsratekjnymd(uiBean.getShrkwsratekjnymd());
        skTblSetBean.setShrkwsrate(uiBean.getShrkwsrate());
        skTblSetBean.setZeimukwsratekjnymd(zeimukwsratekjnymd);
        skTblSetBean.setZeimukwsrate(zeimukwsrate);
        skTblSetBean.setShrgk(uiBean.getShrgk());
        skTblSetBean.setHokenkngkgoukei(uiBean.getHokenkngkgoukei());
        skTblSetBean.setShrtienrsk(uiBean.getShrtienrsk());
        skTblSetBean.setYenshrgk(uiBean.getYenshrgk());
        skTblSetBean.setYenhkgkgoukei(uiBean.getYenhkgkgoukei());
        skTblSetBean.setYenshrtienrsk(uiBean.getYenshrtienrsk());
        skTblSetBean.setGoukeihituyoukeihi(uiBean.getGoukeihituyoukeihi());
        skTblSetBean.setKykhnkkaisuu(uiBean.getKykhnkkaisuu());
        skTblSetBean.setShrkykhtykeihi(uiBean.getShrkykhtykeihi());
        skTblSetBean.setMisyuupjyuutouym(uiBean.getSiHkkingakuSisanParamBean().getMisyuupjyuutouym());
        skTblSetBean.setMisyuupjyuutoukaisuuy(uiBean.getSiHkkingakuSisanParamBean().getMisyuupjyuutoukaisuuy());
        skTblSetBean.setMisyuupjyuutoukaisuum(uiBean.getSiHkkingakuSisanParamBean().getMisyuupjyuutoukaisuum());
        skTblSetBean.setGaikaknsnkwsratekjymd(uiBean.getGaikaknsnkwsratekjymd());
        skTblSetBean.setGaikaknsnkwsrate(uiBean.getGaikaknsnkwsrate());
        skTblSetBean.setHaitoukin(uiBean.getHaitoukin());
        skTblSetBean.setSonotahaitoukin(uiBean.getSonotahaitoukin());
        skTblSetBean.setMisyuup(uiBean.getMisyuup());
        skTblSetBean.setMikeikap(uiBean.getMikeikap());
        skTblSetBean.setZennouseisankgk(uiBean.getZennouseisankgk());
        skTblSetBean.setAzukarikingk(uiBean.getAzukarikingk());
        skTblSetBean.setSonotaseisangk(uiBean.getSiHkkingakuSisanParamBean().getSonotaseisangk());
        skTblSetBean.setKrkgk(uiBean.getKrkgk());
        skTblSetBean.setYenkahaitoukin(uiBean.getYenkahaitoukin());
        skTblSetBean.setYenkasonotahaitoukin(uiBean.getYenkasonotahaitoukin());
        skTblSetBean.setYenkamisyuup(uiBean.getYenkamisyuup());
        skTblSetBean.setYenkamikeikap(uiBean.getYenkamikeikap());
        skTblSetBean.setYenkazennouseisankgk(uiBean.getYenkazennouseisankgk());
        skTblSetBean.setYenkaazukarikingk(uiBean.getYenkaazukarikingk());
        skTblSetBean.setYenkasonotaseisangk(uiBean.getSiHkkingakuSisanParamBean().getYenkasonotaseisangk());
        skTblSetBean.setYenkakrkgk(uiBean.getYenkakrkgk());
        skTblSetBean.setZitkazukarikingksiteituuka(uiBean.getSiHkkingakuSisanParamBean().getZitkazukarikingksiteituuka());
        skTblSetBean.setZitkazukarikingkyen(uiBean.getSiHkkingakuSisanParamBean().getZitkazukarikingkyen());
        skTblSetBean.setGaikaknsntkgk(uiBean.getSiHkkingakuSisanParamBean().getGaikaknsntskgk());
        skTblSetBean.setGaikaknsnkekkakgk(uiBean.getSiHkkingakuSisanParamBean().getGaikaknsnkkkgk());
        skTblSetBean.setYenkaknsntkgk(uiBean.getSiHkkingakuSisanParamBean().getYenkaknsntskgk());
        skTblSetBean.setYenkaknsnkekkakgk(uiBean.getSiHkkingakuSisanParamBean().getYenkaknsnkkkgk());
        skTblSetBean.setMisyuusyonendojikaiikoup(uiBean.getSiHkkingakuSisanParamBean().getMisyuusyonendojikaiikoup());
        skTblSetBean.setMisyuujinendoikoup(uiBean.getSiHkkingakuSisanParamBean().getMisyuujinendoikoup());
        skTblSetBean.setMikeikapjyuutouym(uiBean.getSiHkkingakuSisanParamBean().getMikeikapjyuutouym());
        skTblSetBean.setMikeikapjyuutoukaisuuy(uiBean.getSiHkkingakuSisanParamBean().getMikeikapjyuutoukaisuuy());
        skTblSetBean.setMikeikapjyuutoukaisuum(uiBean.getSiHkkingakuSisanParamBean().getMikeikapjyuutoukaisuum());
        skTblSetBean.setVhtnaiteikakuteikbn(uiBean.getSiHkkingakuSisanParamBean().getVhtnaiteikakuteikbn());

        C_UmuKbn  kakninumukbn  = uiBean.getSkkihon().getKakninumukbn();
        C_TyousaJyoukyouKbn tyousaJyoukyouKbn = C_TyousaJyoukyouKbn.BLNK;
        C_HubiJyoukyouKbn   hubiJyoukyouKbn =   C_HubiJyoukyouKbn.BLNK;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) &&
            (C_SyorikekkaKbn.KAKUNIN.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.TYUUKANKAKUNIN.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.TUIKAKAKUNIN.eq(uiBean.getSyorikekkakbn()))) {
            kakninumukbn  = C_UmuKbn.ARI;
            tyousaJyoukyouKbn = C_TyousaJyoukyouKbn.TYOUSA;
        }

        if (C_TyousaJyoukyouKbn.TYOUSA.eq(uiBean.getSkkihon().getTyousajyoukyoukbn())) {
            if (C_SyorikekkaKbn.SIHARAI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUSIHARAI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.SATEI_3.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.KAKUNINKAISYOU.eq(uiBean.getSyorikekkakbn())) {

                tyousaJyoukyouKbn = C_TyousaJyoukyouKbn.KAITOU;
            }
        }

        if (C_SyorikekkaKbn.HUBIKAISYOU.eq(uiBean.getSyorikekkakbn())) {
            hubiJyoukyouKbn =   C_HubiJyoukyouKbn.KAISYOU;
        }


        uiBean.getSkkihon().setKyknmkj(uiBean.getSiKykKihon().getKyknmkj());
        uiBean.getSkkihon().setKyknmkn(uiBean.getSiKykKihon().getKyknmkn());
        uiBean.getSkkihon().setKykseiymd(uiBean.getSiKykKihon().getKykseiymd());
        uiBean.getSkkihon().setKyksei(uiBean.getSiKykKihon().getKyksei());
        uiBean.getSkkihon().setHhknnmkj(uiBean.getSiKykKihon().getHhknnmkj());
        uiBean.getSkkihon().setHhknnmkn(uiBean.getSiKykKihon().getHhknnmkn());
        uiBean.getSkkihon().setHhknseiymd(uiBean.getSiKykKihon().getHhknseiymd());
        uiBean.getSkkihon().setHhknsei(uiBean.getSiKykKihon().getHhknsei());
        uiBean.getSkkihon().setSateiyhkbn(sateiYouhiKbn);
        uiBean.getSkkihon().setKakninumukbn(kakninumukbn);
        uiBean.getSkkihon().setHubijyoukyoukbn(hubiJyoukyouKbn);
        uiBean.getSkkihon().setTyousajyoukyoukbn(tyousaJyoukyouKbn);
        uiBean.getSkkihon().setShrkekkakbn(skkihonshrkekkakbn);
        uiBean.getSkkihon().setSaigaihigaitoukbn(saigaihigaitouKbn);
        uiBean.getSkkihon().setGaibuinsatuoutymd(gaibuinsatuoutymd);
        uiBean.getSkkihon().setKossyoricd(kinou.getKinouId());
        uiBean.getSkkihon().setKossyorisscd(kinouMode.getKinouMode());
        uiBean.getSkkihon().setGyoumuKousinsyaId(baseUserInfo.getUserId());
        uiBean.getSkkihon().setGyoumuKousinTime(sysDateTime);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo(uiBean.getSkno());
        editSkTblBean.setSyoNo(uiBean.getSyono());
        editSkTblBean.setSeikyuuRirekiNo(maxSeikyuurirekino);
        editSkTblBean.setUketukeNo(1);
        editSkTblBean.setSkTblSetBean(skTblSetBean);
        editSkTblBean.setSiSiDetailParamBeanLst(uiBean.getSiSiDetailParamBeanLst());
        editSkTblBean.setSiNenkinInfoBean(uiBean.getSiNenkinInfoBean());

        EditSkTbl editSkTbl = SWAKInjector.getInstance(EditSkTbl.class);

        editSkTblBean = editSkTbl.setEditKyhSkTbl(uiBean, editSkTblBean);

        JT_Sk sk = uiBean.getSkkihon().createSk();
        BeanUtil.copyProperties(sk, editSkTblBean.getSk());
        BizPropertyInitializer.initialize(sk);

        for (JT_SkJiyuu skJiyuu : editSkTblBean.getSkJiyuuLst()) {
            JT_SkJiyuu newSkJiyuu = sk.createSkJiyuu();
            BeanUtil.copyProperties(newSkJiyuu, skJiyuu);
            BizPropertyInitializer.initialize(newSkJiyuu);

            if (editSkTblBean.getSkByoumeiLst() != null) {
                for (JT_SkByoumei skByoumei : editSkTblBean.getSkByoumeiLst()) {
                    JT_SkByoumei newSkByoumei = newSkJiyuu.createSkByoumei();
                    BeanUtil.copyProperties(newSkByoumei, skByoumei);
                    BizPropertyInitializer.initialize(newSkByoumei);
                }
            }

            if (editSkTblBean.getSiDetailLst() != null) {
                for (JT_SiDetail siDetail : editSkTblBean.getSiDetailLst()) {
                    JT_SiDetail newSiDetail = newSkJiyuu.createSiDetail();
                    BeanUtil.copyProperties(newSiDetail, siDetail);
                    BizPropertyInitializer.initialize(newSiDetail);
                }
            }
        }

        if (editSkTblBean.getNenkinInfo() != null) {
            JT_NenkinInfo nenkinInfo = sk.createNenkinInfo();
            BeanUtil.copyProperties(nenkinInfo, editSkTblBean.getNenkinInfo());
            BizPropertyInitializer.initialize(nenkinInfo);
        }

        if (editSkTblBean.getSateiIppanHanteiInfo() != null) {

            JT_SateiIppanHanteiInfo sateiIppanHanteiInfo = sk.createSateiIppanHanteiInfo();
            BeanUtil.copyProperties(sateiIppanHanteiInfo, editSkTblBean.getSateiIppanHanteiInfo());
            BizPropertyInitializer.initialize(sateiIppanHanteiInfo);
        }

        if (editSkTblBean.getSateiKokuhanInfo() != null) {

            JT_SateiKokuhanInfo sateiKokuhanInfo = sk.createSateiKokuhanInfo();
            BeanUtil.copyProperties(sateiKokuhanInfo, editSkTblBean.getSateiKokuhanInfo());

            BizPropertyInitializer.initialize(sateiKokuhanInfo);
        }

        if (editSkTblBean.getSateiJyuukasituChkInfo() != null) {

            JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo = sk.createSateiJyuukasituChkInfo();
            BeanUtil.copyProperties(sateiJyuukasituChkInfo, editSkTblBean.getSateiJyuukasituChkInfo());

            BizPropertyInitializer.initialize(sateiJyuukasituChkInfo);
        }

        if (editSkTblBean.getSibouSateiChkInfo() != null) {

            JT_SibouSateiChkInfo sibouSateiChkInfo = sk.createSibouSateiChkInfo();
            BeanUtil.copyProperties(sibouSateiChkInfo, editSkTblBean.getSibouSateiChkInfo());
            BizPropertyInitializer.initialize(sibouSateiChkInfo);
        }

        if (editSkTblBean.getToriatukaifuryouinfo() != null) {

            JT_Toriatukaifuryouinfo toriatukaifuryouinfo = sk.createToriatukaifuryouinfo();
            BeanUtil.copyProperties(toriatukaifuryouinfo, editSkTblBean.getToriatukaifuryouinfo());
            BizPropertyInitializer.initialize(toriatukaifuryouinfo);
        }

        if (editSkTblBean.getSateiKaijyoInfo() != null) {

            JT_SateiKaijyoInfo sateiKaijyoInfo = sk.createSateiKaijyoInfo();
            BeanUtil.copyProperties(sateiKaijyoInfo, editSkTblBean.getSateiKaijyoInfo());
            BizPropertyInitializer.initialize(sateiKaijyoInfo);
        }

        if (editSkTblBean.getSateiMeigihenkouInfo() != null) {

            JT_SateiMeigihenkouInfo sateiMeigihenkouInfo = sk.createSateiMeigihenkouInfo();
            BeanUtil.copyProperties(sateiMeigihenkouInfo, editSkTblBean.getSateiMeigihenkouInfo());
            BizPropertyInitializer.initialize(sateiMeigihenkouInfo);
        }

        if (editSkTblBean.getBetukutiSateiInfo() != null) {

            JT_BetukutiSateiInfo betukutiSateiInfo = sk.createBetukutiSateiInfo();
            BeanUtil.copyProperties(betukutiSateiInfo, editSkTblBean.getBetukutiSateiInfo());
            BizPropertyInitializer.initialize(betukutiSateiInfo);
        }

        C_SyorikekkaKbn syorikekkakbn =uiBean.getSyorikekkakbn();
        String tensousakisousasyacd = uiBean.getTennousakisousasyacd();

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue())) {

            uiBean.setSyorikekkakbn(uiBean.getSateisyorikekkakbn());
            if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue()) ||
                kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue()) ||
                kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
                kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ||
                kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
                kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue())) {
                uiBean.setTennousakisousasyacd(uiBean.getSateitennousakisousasyacd());
            }
        }

        uiBean.setReportcomment("");

        EditSateiRrkTblBean editSateiRrkTblBean = SWAKInjector.getInstance(EditSateiRrkTblBean.class);

        editSateiRrkTblBean.setSkno(uiBean.getSkno());
        editSateiRrkTblBean.setSyono(uiBean.getSyono());
        editSateiRrkTblBean.setSateisyouninskbtkey(sateSyouninSikibetukey);
        editSateiRrkTblBean.setSeikyuurirekino(maxSeikyuurirekino);

        EditSateiRrkTbl editSateiRrkTbl = SWAKInjector.getInstance(EditSateiRrkTbl.class);

        editSateiRrkTblBean = editSateiRrkTbl.exec(uiBean, editSateiRrkTblBean);

        JT_SateiSyouninRireki sateiSyouninRireki = uiBean.getSkkihon().createSateiSyouninRireki();

        BeanUtil.copyProperties(sateiSyouninRireki, editSateiRrkTblBean.getSateiSyouninRireki());

        uiBean.setSyorikekkakbn(syorikekkakbn);
        uiBean.setTennousakisousasyacd(tensousakisousasyacd);

        BizPropertyInitializer.initialize(sateiSyouninRireki);

        String shrSikibetukey = "";
        BizCurrency shrgkgoukei = BizCurrency.optional();

        if (!C_Tuukasyu.JPY.eq(uiBean.getSk().getKyktuukasyu()) &&
            C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())){
            shrgkgoukei = uiBean.getYenshrgk();
        }
        else {
            shrgkgoukei = uiBean.getShrgk();
        }

        if (C_SaisateiKbn.BLNK.eq(uiBean.getSkkihon().getSaisateikbn())) {
            if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
                kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue())) {

                if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSateisyorikekkakbn())) {
                    SetteiShrhousiteiKbn setteiShrhousiteiKbn = SWAKInjector.getInstance(SetteiShrhousiteiKbn.class);

                    C_ShrhousiteiKbn shrhousiteiKbn = setteiShrhousiteiKbn.exec(uiBean.getInputshrhousiteikbn(),
                        uiBean.getShrtuukasyu());

                    uiBean.setShrhousiteikbn(shrhousiteiKbn);

                    JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();

                    if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(uiBean.getSuketorihouhoukbn())) {
                        if (C_UmuKbn.ARI.eq(uiBean.getSiKykKihon().getNstkhkumu())) {
                            uiBean.setTyakkinymd(null);
                            uiBean.setShrgkkei(BizCurrency.valueOf(0));
                            shrSikibetukey = siharaiRirekiEdit(maxSeikyuurirekino,shrkekkakbn,sysDate);

                            zengakuNenkinSiwakeEdit(kinou.getSyoricd(),baseUserInfo.getTmSosikiCd(),uiBean.getSiSiDetailParamBeanLst(),
                                uiBean.getSiKykSyouhn(),sysDate);
                        }
                        else {
                            uiBean.setTyakkinymd(uiBean.getShrymd());
                            uiBean.setShrgkkei(shrgkgoukei);
                            shrSikibetukey = siharaiRirekiEdit(maxSeikyuurirekino,shrkekkakbn,sysDate);

                            SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = zengakuItijiknSiwakeEdit(kinou.getSyoricd(),
                                baseUserInfo.getTmSosikiCd(),uiBean.getSiSiDetailParamBeanLst(),uiBean.getSiKykSyouhn(),sysDate);

                            BeanUtil.copyProperties(siDenpyoData, siCommonSiwakeKekkaBean.getSiDenpyoDataLst().get(0));

                            if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                                siEditFb(uiBean.getSk().getKyktuukasyu(),siCommonSiwakeKekkaBean,
                                    uiBean.getSiHkkingakuSisanParamBean());
                            }
                        }

                    }

                    else if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(uiBean.getSuketorihouhoukbn())) {
                        uiBean.setTyakkinymd(null);
                        uiBean.setShrgkkei(BizCurrency.valueOf(0));
                        shrSikibetukey = siharaiRirekiEdit(maxSeikyuurirekino,shrkekkakbn,sysDate);

                        zengakuNenkinSiwakeEdit(kinou.getSyoricd(),baseUserInfo.getTmSosikiCd(),uiBean.getSiSiDetailParamBeanLst(),
                            uiBean.getSiKykSyouhn(),sysDate);
                    }
                    else {
                        uiBean.setTyakkinymd(uiBean.getShrymd());
                        uiBean.setShrgkkei(shrgkgoukei);
                        shrSikibetukey = siharaiRirekiEdit(maxSeikyuurirekino,shrkekkakbn,sysDate);

                        SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = itibuItijiknSiwakeEdit(kinou.getSyoricd(),baseUserInfo.getTmSosikiCd(),uiBean.getSiSiDetailParamBeanLst(),
                            uiBean.getSiKykSyouhn(),sysDate);

                        BeanUtil.copyProperties(siDenpyoData, siCommonSiwakeKekkaBean.getSiDenpyoDataLst().get(0));

                        if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                            siEditFb(uiBean.getSk().getKyktuukasyu(),siCommonSiwakeKekkaBean,
                                uiBean.getSiHkkingakuSisanParamBean());
                        }

                        itibuNenkinSiwakeEdit(kinou.getSyoricd(),baseUserInfo.getTmSosikiCd(),uiBean.getSiSiDetailParamBeanLst(),
                            uiBean.getSiKykSyouhn(),sysDate);
                    }


                    if (uiBean.getSiDetailMisyuupBeanLst().size() != 0
                        || uiBean.getSiDetailMikeikapBeanLst().size() != 0) {

                        EditMisyuupMkkpDetailTbl editMisyuupMkkpDetailTbl = SWAKInjector
                            .getInstance(EditMisyuupMkkpDetailTbl.class);

                        List<JT_MisyuupMkkpDetail> editMisyuupMkkpDetailTblBeanLst = editMisyuupMkkpDetailTbl.exec(
                            uiBean.getSkno(), uiBean.getSyono(), maxSeikyuurirekino,
                            uiBean.getSiDetailMisyuupBeanLst(),
                            uiBean.getSiDetailMikeikapBeanLst());

                        if (editMisyuupMkkpDetailTblBeanLst != null) {
                            for (JT_MisyuupMkkpDetail misyuupMkkpDetail : editMisyuupMkkpDetailTblBeanLst) {

                                JT_MisyuupMkkpDetail newMisyuupMkkpDetail = sk.createMisyuupMkkpDetail();

                                BeanUtil.copyProperties(newMisyuupMkkpDetail, misyuupMkkpDetail);

                                BizPropertyInitializer.initialize(newMisyuupMkkpDetail);

                                siharaiDomManager.insert(newMisyuupMkkpDetail);
                            }
                        }
                    }

                    EditSiDshrTukiTblBean editSiDshrTukiTblBean = SWAKInjector.getInstance(EditSiDshrTukiTblBean.class);
                    editSiDshrTukiTblBean.setSiKykKihon(uiBean.getSiKykKihon());
                    editSiDshrTukiTblBean.setSiKykSyouhn(uiBean.getSiKykSyouhn());
                    editSiDshrTukiTblBean.setEditDshrTukiDKoumokuBean(uiBean.getEditDshrTukiDKoumokuBean());
                    editSiDshrTukiTblBean.setSkno(uiBean.getSkno());
                    editSiDshrTukiTblBean.setSeikyuurirekino(maxSeikyuurirekino);
                    editSiDshrTukiTblBean.setSyoriYmd(sysDate);
                    editSiDshrTukiTblBean.setDenymd(uiBean.getShrymd());
                    if (C_Tuukasyu.JPY.eq(uiBean.getSk().getKyktuukasyu())) {
                        editSiDshrTukiTblBean.setSiharaid(uiBean.getSiHkkingakuSisanParamBean().getHaitoukin());
                    } else {
                        editSiDshrTukiTblBean.setSiharaid(uiBean.getSiHkkingakuSisanParamBean().getYenkahaitoukin());
                    }
                    editSiDshrTukiTblBean.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    editSiDshrTukiTblBean.setGyoumuKousinKinou(kinou.getKinouId());

                    EditSiDshrTukiTbl editSiDshrTukiTbl = SWAKInjector.getInstance(EditSiDshrTukiTbl.class);
                    JT_SiDshrTuki siDshrTuki = editSiDshrTukiTbl.exec(editSiDshrTukiTblBean);

                    if (siDshrTuki != null) {
                        JT_SiDshrTuki newSiDshrTuki = new JT_SiDshrTuki();
                        BeanUtil.copyProperties(newSiDshrTuki, siDshrTuki);
                        BizPropertyInitializer.initialize(newSiDshrTuki);
                        siharaiDomManager.insert(newSiDshrTuki);
                    }


                    BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                    SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(uiBean.getSiKykSyouhn()
                        .getSyouhncd(), uiBean.getSiKykSyouhn().getKyktuukasyu());

                    SikinIdouRirekiDataBean sikinIdouRirekiDataBean = SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);
                    sikinIdouRirekiDataBean.setSyoriYmd(sysDate);
                    sikinIdouRirekiDataBean.setSyono(uiBean.getSyono());
                    sikinIdouRirekiDataBean.setSkno(uiBean.getSkno());
                    sikinIdouRirekiDataBean.setSeikyuuRirekiNo(maxSeikyuurirekino);
                    sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.SIHARAI);
                    sikinIdouRirekiDataBean.setSyoricd(kinou.getSyoricd());
                    sikinIdouRirekiDataBean.setDensysKbn(siDenpyoData.getDensyskbn());
                    sikinIdouRirekiDataBean.setDenrenno(siDenpyoData.getDenrenno());
                    sikinIdouRirekiDataBean.setSeg1cd(syouhinbetuSegmentBean.getSegcd1());
                    sikinIdouRirekiDataBean.setKykTuukasyu(uiBean.getSiKykSyouhn().getKyktuukasyu());
                    sikinIdouRirekiDataBean.setSyutkKbn(uiBean.getSiKykSyouhn().getSyutkkbn());
                    sikinIdouRirekiDataBean.setHrkkaisuu(uiBean.getSiKykKihon().getHrkkaisuu());
                    sikinIdouRirekiDataBean.setSyouhnCd(uiBean.getSiKykSyouhn().getSyouhncd());
                    sikinIdouRirekiDataBean.setSyouhnSdno(uiBean.getSiKykSyouhn().getSyouhnsdno());
                    sikinIdouRirekiDataBean.setKykSyouhnRenno(uiBean.getSiKykSyouhn().getKyksyouhnrenno());
                    sikinIdouRirekiDataBean.setShrhousiteiKbn(uiBean.getShrhousiteikbn());
                    sikinIdouRirekiDataBean.setKykYmd(uiBean.getSiKykSyouhn().getKykymd());
                    sikinIdouRirekiDataBean.setMisyuupJyuutouYm(uiBean.getSiHkkingakuSisanParamBean().getMisyuupjyuutouym());
                    sikinIdouRirekiDataBean.setSeikyuuSyubetu(uiBean.getSkkihon().getSeikyuusyubetu());

                    BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector
                        .getInstance(BzSikinIdouRirekiTblSakusei.class);
                    BT_SikinIdouRireki sikinIdouRireki = bzSikinIdouRirekiTblSakusei
                        .editSikinIdouRirekiTblEntity(sikinIdouRirekiDataBean);

                    bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);


                    C_UmuKbn umuKbn = C_UmuKbn.NONE;
                    if (!(C_UmuKbn.ARI.eq(uiBean.getSiKykKihon().getNstkhkumu()) &&
                        C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(uiBean.getSuketorihouhoukbn()) ||
                        C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(uiBean.getSuketorihouhoukbn()))) {
                        umuKbn = C_UmuKbn.ARI;
                    }

                    if (C_UmuKbn.ARI.eq(umuKbn)) {
                        YuyuBizConfig yuyuBizConfig = YuyuBizConfig.getInstance();
                        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

                        String callcentersosikicd = yuyuBizConfig.getCallcentersosikicd();

                        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(callcentersosikicd);

                        String callcentersosikiTelno = bzGetSosikiMadogutiInfoKekkaBean.getTelno();

                        bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(baseUserInfo.getTmSosikiCd());

                        String sitenmei = "";
                        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd(), null);
                        if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
                            sitenmei = bzGetBankDataBean.getReportSitenNm();
                        }

                        List<JT_SiDetail> siDetailLst = Lists.newArrayList();

                        for (int count = 0; count < uiBean.getSiDetailLst().size(); count++){
                            if(!BizUtil.isZero(uiBean.getSiDetailLst().get(count).getKyhkg())){
                                siDetailLst.add(uiBean.getSiDetailLst().get(count));
                            }
                        }

                        BizCurrency synykngk = BizCurrency.valueOf(0);
                        BizCurrency kztkgk = BizCurrency.valueOf(0);

                        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector
                            .getInstance(SiMeisaiCommonCalcBean.class);

                        siMeisaiCommonCalcBean.setKykTuukasyu(sk.getKyktuukasyu());
                        siMeisaiCommonCalcBean.setShrTuukasyu(sk.getShrtuukasyu());
                        siMeisaiCommonCalcBean.setKawaseRate(sk.getShrkwsrate());
                        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(sk.getGaikaknsnkwsrate());
                        siMeisaiCommonCalcBean.setZeimukwsrate(sk.getZeimukwsrate());
                        siMeisaiCommonCalcBean.setHokenkngkgoukei(sk.getHokenkngkgoukei());
                        siMeisaiCommonCalcBean.setZennouseisankgk(sk.getZennouseisankgk());
                        siMeisaiCommonCalcBean.setYenkazennouseisankgk(sk.getYenkazennouseisankgk());
                        siMeisaiCommonCalcBean.setMisyuup(sk.getMisyuup());
                        siMeisaiCommonCalcBean.setMikeikap(sk.getMikeikap());
                        siMeisaiCommonCalcBean.setYenkamikeikap(sk.getYenkamikeikap());
                        siMeisaiCommonCalcBean.setHaitoukin(sk.getHaitoukin());
                        siMeisaiCommonCalcBean.setYenkahaitoukin(sk.getYenkahaitoukin());
                        siMeisaiCommonCalcBean.setSonotahaitoukin(sk.getSonotahaitoukin());
                        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(sk.getYenkasonotahaitoukin());
                        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(sk.getZitkazukarikingksiteituuka());
                        siMeisaiCommonCalcBean.setZitkazukarikingkyen(sk.getZitkazukarikingkyen());
                        siMeisaiCommonCalcBean.setYenkakrkgk(sk.getYenkakrkgk());
                        siMeisaiCommonCalcBean.setZeitratkikbn(uiBean.getZeitratkikbn());
                        siMeisaiCommonCalcBean.setSyouhinCd(uiBean.getSiKykSyouhn().getSyouhncd());

                        SiMeisaiCommonCalc siMeisaiCommonCalc = SWAKInjector.getInstance(SiMeisaiCommonCalc.class);

                        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new BizAppException(MessageId.EJA1027);
                        }

                        synykngk = siMeisaiCommonCalc.getShrmisisynykngk();
                        kztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

                        String kouzano = uiBean.getKouzano();

                        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(uiBean.getBankcd())){
                            kouzano = kouzano + "1";
                        }

                        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
                        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
                        SaikensyaInfoBean saikensyaInfoBean = SWAKInjector.getInstance(SaikensyaInfoBean.class);
                        ToiawaseInfoBean toiawaseInfoBean =SWAKInjector.getInstance(ToiawaseInfoBean.class);
                        EditSiharaimeisaisyoBean editSiharaimeisaisyoBean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);

                        siTyouhyouHensyuuCommonBean.setSyoriYmd(sysDate);
                        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);

                        seikyuusyaInfoBean.setSeikyuusyanmKn(uiBean.getSeikyuusyanmkn());
                        seikyuusyaInfoBean.setSeikyuusyanmKj(uiBean.getSeikyuusyanmkj());
                        seikyuusyaInfoBean.setTsinyno(uiBean.getTsinyno());
                        seikyuusyaInfoBean.setTsinadr1kj(uiBean.getTsinadr1kj());
                        seikyuusyaInfoBean.setTsinadr2kj(uiBean.getTsinadr2kj());
                        seikyuusyaInfoBean.setTsinadr3kj(uiBean.getTsinadr3kj());
                        seikyuusyaInfoBean.setTsintelno(uiBean.getTsintelno());

                        saikensyaInfoBean.setSaikennmkj(uiBean.getSaikennmkj());
                        saikensyaInfoBean.setSaikennyno(uiBean.getSaikennyno());
                        saikensyaInfoBean.setSaikenadr1kj(uiBean.getSaikenadr1kj());
                        saikensyaInfoBean.setSaikenadr2kj(uiBean.getSaikenadr2kj());
                        saikensyaInfoBean.setSaikenadr3kj(uiBean.getSaikenadr3kj());

                        toiawaseInfoBean.setSosikiNm(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                        toiawaseInfoBean.setTsinyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                        toiawaseInfoBean.setTsinadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                        toiawaseInfoBean.setTsinadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                        toiawaseInfoBean.setTsinadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
                        toiawaseInfoBean.setTsintelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());

                        editSiharaimeisaisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                        editSiharaimeisaisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
                        editSiharaimeisaisyoBean.setSaikensyaInfoBean(saikensyaInfoBean);
                        editSiharaimeisaisyoBean.setToiawaseInfoBean(toiawaseInfoBean);
                        editSiharaimeisaisyoBean.setSyoNo(uiBean.getSyono());
                        editSiharaimeisaisyoBean.setKyknmKj(uiBean.getSiKykKihon().getKyknmkj());
                        editSiharaimeisaisyoBean.setHhknnmKj(uiBean.getSiKykKihon().getHhknnmkj());
                        editSiharaimeisaisyoBean.setTyakkinYmd(uiBean.getShrymd());
                        editSiharaimeisaisyoBean.setSibouYmd(uiBean.getSibouymd());
                        editSiharaimeisaisyoBean.setKykTuukasyu(uiBean.getSk().getKyktuukasyu());
                        editSiharaimeisaisyoBean.setShrTuukasyu(uiBean.getShrtuukasyu());
                        editSiharaimeisaisyoBean.setShrKwsrate(uiBean.getShrkwsrate());
                        editSiharaimeisaisyoBean.setKnsnkijyunymd(uiBean.getShrkwsratekjnymd());
                        editSiharaimeisaisyoBean.setShrGk(uiBean.getShrgk());
                        editSiharaimeisaisyoBean.setYenShrgk(uiBean.getYenshrgk());
                        editSiharaimeisaisyoBean.setBanknmKj(uiBean.getBanknmkj());
                        editSiharaimeisaisyoBean.setSitennmKj(sitenmei);
                        editSiharaimeisaisyoBean.setYokinKbn(uiBean.getYokinkbn());
                        editSiharaimeisaisyoBean.setKouzaNo(BizUtil.editMask(kouzano, 3, '*'));
                        editSiharaimeisaisyoBean.setKzmeiginmKn(uiBean.getKzmeiginmkn());
                        editSiharaimeisaisyoBean.setSynykngk(synykngk);
                        editSiharaimeisaisyoBean.setHtykeihi(sk.getGoukeihituyoukeihi());
                        editSiharaimeisaisyoBean.setCctelNo(ConvertUtil.toZenNumeric(callcentersosikiTelno));
                        editSiharaimeisaisyoBean.setSk(sk);
                        editSiharaimeisaisyoBean.setSiDetailLst(siDetailLst);
                        editSiharaimeisaisyoBean.setKztkgk(kztkgk);
                        editSiharaimeisaisyoBean.setZeitratkiKbn(uiBean.getZeitratkikbn());
                        editSiharaimeisaisyoBean.setKykHnkKaisuu(uiBean.getKykhnkkaisuu());
                        editSiharaimeisaisyoBean.setShrKykHtyKeihi(sk.getShrkykhtykeihi());
                        editSiharaimeisaisyoBean.setKykjyoutai(uiBean.getSiKykKihon().getKykjyoutai());

                        EditSiharaimeisaisyo editSiharaimeisaisyo = SWAKInjector.getInstance(EditSiharaimeisaisyo.class);

                        List<ReportServicesBean> reportServicesBean = editSiharaimeisaisyo.exec(editSiharaimeisaisyoBean);

                        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

                        String tyouhyouKey = createReport.execNoCommit(reportServicesBean);

                        if (C_KanryotuutioutKbn.PDF.eq(uiBean.getShrdtlsyooutkbn())) {
                            uiBean.setResultTyouhyouKey(tyouhyouKey);
                        }

                    }
                }

            }
            if (!C_SaigaiHigaitouKbn.SAIGAIHIGAITOU.eq(uiBean.getSkkihon().getSaigaihigaitoukbn())) {
                if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()) ||
                    kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue())) {
                    if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSateisyorikekkakbn())) {
                        uiBean.setTyakkinymd(null);
                        uiBean.setShrgkkei(BizCurrency.valueOf(0));
                        shrSikibetukey = siharaiRirekiEdit(maxSeikyuurirekino,shrkekkakbn,sysDate);
                    }
                }
            }
        }


        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue())) {
            uiBean.setSyanaicomment(uiBean.getSateisyanaicomment());
        }

        EditRrkTblBean editRrkTblBean = SWAKInjector.getInstance(EditRrkTblBean.class);
        editRrkTblBean.setSeiNo(uiBean.getSkno());
        editRrkTblBean.setSyoNo(uiBean.getSyono());
        editRrkTblBean.setSyoriYmd(sysDate);
        editRrkTblBean.setJimKakuteiUmuKbn(jimukakuteiKbn);
        editRrkTblBean.setSeiRrkNo(maxSeikyuurirekino);
        editRrkTblBean.setShrSkbtKey(shrSikibetukey);
        editRrkTblBean.setSateiSkbtKey(sateSyouninSikibetukey);

        EditRrk editRrk = SWAKInjector.getInstance(EditRrk.class);

        editRrkTblBean = editRrk.makeTtdkRrk(uiBean, editRrkTblBean);

        JT_TtdkRireki ttdkRireki = uiBean.getSkkihon().createTtdkRireki();

        BeanUtil.copyProperties(ttdkRireki, editRrkTblBean.getTtdkRireki());

        ttdkRireki.setSeikyuurirekino(maxSeikyuurirekino);

        BizPropertyInitializer.initialize(ttdkRireki);



        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        String tensousakicd = "";

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue())) {
            siRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
            tensousakicd = uiBean.getTennousakisousasyacd();
        }
        else {
            siRuleBean.setSyoriKekkaKbn(uiBean.getSateisyorikekkakbn());
            tensousakicd = uiBean.getSateitennousakisousasyacd();
        }

        siRuleBean.setSateiYhKbn(sateiYouhiKbn);
        if (uiBean.getSessyouyhkbn() == null) {
            siRuleBean.setSessyouYhKbn(C_YouhiblnkKbn.BLNK);
        }
        else {
            siRuleBean.setSessyouYhKbn(uiBean.getSessyouyhkbn());
        }
        siRuleBean.setSateiSanjiKaisouUmuKbn(sateiSanjikaisouUmuKbn);
        siRuleBean.setHubiModorijiSenisakiNodeNm(C_SikinouModeIdKbn.valueOf(bzWorkflowInfo.getTaskId()));

        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);

        siProcessForward.exec(bzWorkflowInfo.getKouteiKanriId(), bzWorkflowInfo.getJimuTetuzukiCd(),
            bzCommonLockProcess.getKouteiLockKey(),uiBean.getSyanaicomment(), siRuleBean, tensousakicd);

        messageManager.addMessageId(MessageId.IAC0009);

        bzCommonLockProcess.unlockProcess();

        String resultPath = setResultPath();

        return resultPath;
    }

    String pushSaikeisanBL() {

        doContinueLockProcess();

        messageManager.clear();

        List<Message> messageLst2 = Lists.newArrayList();
        uiBean.setErrmessagecollector(messageLst2);

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> dataSourceBeanLst = Lists.newArrayList();

        List<String> byoumeitourokunolist = Lists.newArrayList();

        for (ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean : uiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData()) {
            if (C_Delflag.BLNK.eq(dataSourceBean.getSakujyoflg()) && !BizUtil.isBlank(dataSourceBean.getByoumeitourokuno())) {
                dataSourceBeanLst.add(dataSourceBean);

                byoumeitourokunolist.add(dataSourceBean.getByoumeitourokuno());
            }
        }

        uiBean.setViewSindansyoinfoSibouInfo1(dataSourceBeanLst);

        uiBean.setByoumeitourokunolist(byoumeitourokunolist);


        CheckSbSkNaiyou checkSbSkNaiyou = SWAKInjector.getInstance(CheckSbSkNaiyou.class);

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(uiBean, kinou.getKinouId(),
            C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        boolean errflg = false;

        if (C_SKNaiyouChkkekkaKbn.ERROR.eq(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn())) {

            List<Message> messageLst = checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages();

            uiBean.setErrmessagecollector(messageLst);
            for (Message message : messageLst) {
                if (message.getMessageId().startsWith("T")) {
                    messageManager.addConversationMessage(message);
                }
                if (message.getMessageId().startsWith("E")) {

                    messageManager.addMessage(message);
                    errflg = true;
                }
            }
        }
        SiSKNaiyouChkWarningmsgSettei siSKNaiyouChkWarningmsgSettei = SWAKInjector.getInstance(SiSKNaiyouChkWarningmsgSettei.class);

        siSKNaiyouChkWarningmsgSettei.exec(GROUP_WARNING_MESSAGE_ONE, checkSbSkNaiyouKekkaBean.getWarningMessageList());

        uiBean.setCheckSbSkNaiyouKekkaBean(checkSbSkNaiyouKekkaBean);
        SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        siSiharaiKingakuKeisanBean.setSyoNo(uiBean.getSyono());
        siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(uiBean.getSkkihon().getSeikyuusyubetu());
        siSiharaiKingakuKeisanBean.setCalcKijyunYmd(uiBean.getSibouymd());
        siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(uiBean.getInputshrhousiteikbn());
        siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(uiBean.getSyoruiukeymd());
        siSiharaiKingakuKeisanBean.setHubiKanryouYmd(uiBean.getHubikanryouymd());
        siSiharaiKingakuKeisanBean.setRikoukiTyuutuudanNissuu(uiBean.getRikoukityuutuudannissuu());
        siSiharaiKingakuKeisanBean.setSinsaGendoKknKbn(uiBean.getSinsagendokknkbn());
        siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(uiBean.getSuketorihouhoukbn());
        siSiharaiKingakuKeisanBean.setSiharaiTuukaKbn(uiBean.getSiharaituukakbn());
        siSiharaiKingakuKeisanBean.setSiKykKihon(uiBean.getSiKykKihon());
        siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(uiBean.getSihonninkakninkbn());
        siSiharaiKingakuKeisanBean.setKeisanKahiKbn(uiBean.getCheckSbSkNaiyouKekkaBean().getKeisanKahiKbn());
        siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());
        siSiharaiKingakuKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        siSiharaiKingakuKeisanBean.setSiinKbn(uiBean.getSiinkbn());
        siSiharaiKingakuKeisanBean.setSaisateiKbn(uiBean.getSaisateikbn());
        siSiharaiKingakuKeisanBean.setUktMnmeigiBangou(uiBean.getUktmnmeigibangou());
        siSiharaiKingakuKeisanBean.setKykMnmeigiBango(uiBean.getKykmnmeigibangou());
        siSiharaiKingakuKeisanBean.setBankCd(uiBean.getBankcd());
        siSiharaiKingakuKeisanBean.setSeikyuusyaKbn(uiBean.getSeikyuusyakbn());

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType type = henkanTuuka.henkanTuukaKbnToType(uiBean.getSiKykKihon().getSiKykSyouhns().get(0)
            .getKyktuukasyu());
        BizCurrency nkKknJyutouGk = BizCurrency.valueOf(0, type);
        siSiharaiKingakuKeisanBean.setNkKknJyutouGk(nkKknJyutouGk);

        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

        ErrorMessageCollector messageCollector = siSiharaiKingakuKeisan.getErrMsg();

        List<String> messageLst = siSiharaiKingakuKeisan.getWarnMsg();

        if (messageCollector != null && messageCollector.size() > 0) {

            for (int i = 0; i < messageCollector.size(); i++) {
                messageManager.addMessage(messageCollector.getMessages().get(i));
            }
            errflg = true;
        }

        if (messageLst.size() != 0) {
            siSKNaiyouChkWarningmsgSettei.exec(GROUP_WARNING_MESSAGE_ONE, siSiharaiKingakuKeisan.getWarnMsg());

        }

        uiBean.setSiSiDetailParamBeanLst(siSiharaiKingakuKeisan.getSiSiDetailParamBean());
        uiBean.setSiNenkinInfoBean(siSiharaiKingakuKeisan.getSiNenkinInfoBean());
        uiBean.setSiHkkingakuSisanParamBean(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean());
        uiBean.setSkNaiyouChkkekkaKbn(siSiharaiKingakuKeisan.getCSKNaiyouChkkekkaKbn());

        betuskSyorityuChk(uiBean.getSyono(), uiBean.getSkno());

        if(errflg){
            return FORWARDNAME_INPUTCORRECT;
        }

        List<JT_SiDetail> siDetailLst = siSiDetailParamBeanEdit(uiBean.getSiSiDetailParamBeanLst());

        uiBean.setSiDetailLst(siDetailLst);

        String ukthonninKn = "";
        String ukthonninKj = "";
        BizDate ukthonninYmd = null;
        if (C_SeikyuusyaKbn.UKTHONNIN.eq(uiBean.getSeikyuusyakbn())) {
            List<JT_SiUkt> siUktLst = uiBean.getSiKykKihon().getSiUkts();
            for (JT_SiUkt siUkt : siUktLst) {
                if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu())) {
                    ukthonninKn = siUkt.getUktnmkn();
                    ukthonninKj = siUkt.getUktnmkj();
                    ukthonninYmd = siUkt.getUktseiymd();
                    break;
                }
            }
            uiBean.setSeikyuusyanmkn(ukthonninKn);
            uiBean.setSeikyuusyanmkj(ukthonninKj);
            uiBean.setSeikyuusyaseiymd(ukthonninYmd);
        }
        else if (C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
            uiBean.setSeikyuusyaseiymd(uiBean.getSiKykKihon().getKykdrseiymd());
            uiBean.setSeikyuusyanmkn(uiBean.getSiKykKihon().getKykdairinmkn());
            uiBean.setSeikyuusyanmkj(uiBean.getSiKykKihon().getKykdairinmkj());
        }


        if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) {
            if (C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
                uiBean.setTsinyno(uiBean.getSiKykKihon().getKykdryno());
                uiBean.setTsinadr1kj(uiBean.getSiKykKihon().getKykdradr1kj());
                uiBean.setTsinadr2kj(uiBean.getSiKykKihon().getKykdradr2kj());
                uiBean.setTsinadr3kj(uiBean.getSiKykKihon().getKykdradr3kj());
                uiBean.setTsintelno(uiBean.getSiKykKihon().getKykdrtelno());
            }
            else {
                SiSetUiBean.setSouhusakiKykAdr(uiBean, uiBean.getSiKykKihon());
            }
        }

        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);

        siSetUiBean.setHKTShrMeisai(uiBean,uiBean.getSiDetailLst());

        if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
            uiBean.setKzmeiginmkn(uiBean.getSeikyuusyanmkn());
        }

        uiBean.setSateikoumoku(uiBean.getCheckSbSkNaiyouKekkaBean().getSateiKoumokuMessage());

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd());

        uiBean.setBanknmkj(bzGetBankDataBean.getBankNmKj());
        uiBean.setSitennmkj(bzGetBankDataBean.getSitenNmKj());

        SiSetUiBean.setSiharaiKingakuKeisanResult(uiBean, uiBean.getSiHkkingakuSisanParamBean());

        uiBean.setDispsyoruiukeymd(uiBean.getSyoruiukeymd());
        uiBean.setDisphubikanryouymd(uiBean.getHubikanryouymd());

        C_UktKyksyaTdk  uktKyksyaTdk  = uktkyksyatdkCheck(uiBean.getSiUktLst(), uiBean.getSeikyuusyakbn());

        uiBean.setUktKyksyaTdk(uktKyksyaTdk);

        C_ZeitratkiKbn zeitratkiKbn = getZeitratkiKbn(uiBean.getSiKykKihon().getKkkyktdk(),uiBean.getUktKyksyaTdk());
        uiBean.setZeitratkikbn(zeitratkiKbn);

        if (C_SiharaiTuukaKbn.YENSIHARAI.eq(uiBean.getSiharaituukakbn())) {
            YuyuBizConfig yuyuBizConfig = YuyuBizConfig.getInstance();
            int yenkaKouzaKetasuu = yuyuBizConfig.getYenkaKouzaKetasuu();
            CheckKouzaNo checkKouzaNo = SWAKInjector.getInstance(CheckKouzaNo.class);
            if (checkKouzaNo.isCheckOK(uiBean.getKouzano(), C_Tuukasyu.JPY)
                && uiBean.getKouzano().length() < yenkaKouzaKetasuu) {
                uiBean.setKouzano(Strings.padStart(uiBean.getKouzano(), yenkaKouzaKetasuu, '0'));
            }
        }

        if (!C_HokenkinsyuruiKbn.BLNK.eq(uiBean.getSiHkkingakuSisanParamBean().getHokenkinsyuruiKbn()) &&
            !C_HknKknKbn.BLNK.eq(uiBean.getSiHkkingakuSisanParamBean().getHknKknKbn()) ){
            String hokenknsyurui = uiBean.getSiHkkingakuSisanParamBean().getHokenkinsyuruiKbn().getContent()
                + "（" + uiBean.getSiHkkingakuSisanParamBean().getHknKknKbn().getContent() + "）";

            uiBean.setHokenkinsyurui(hokenknsyurui);

        }

        setSaigaiHosyouUmuKbn();


        String inputContentsPath = "";

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI1;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI2;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI3;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI4;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIHUYOU;
        }

        uiBean.setViewSkjyouhouInputDispFlg(false);
        uiBean.setViewSaikenInfoInputDispFlg(false);
        uiBean.setViewSouhusakiInputDispFlg(false);
        uiBean.setViewSoukinsakiInputDispFlg(false);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(false);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);
        if (uiBean.getHaitoukin().equalsValue(BizCurrency.valueOf(0, uiBean.getHaitoukin().getType()))) {
            uiBean.setShrGoukeiHaitoukinDispFlg(false);
        } else {
            uiBean.setShrGoukeiHaitoukinDispFlg(true);
        }
        if (uiBean.getSonotahaitoukin().equalsValue(BizCurrency.valueOf(0, uiBean.getSonotahaitoukin().getType()))) {
            uiBean.setShrGoukeiSonotahaitoukinDispFlg(false);
        } else {
            uiBean.setShrGoukeiSonotahaitoukinDispFlg(true);
        }
        if (uiBean.getMikeikap().equalsValue(BizCurrency.valueOf(0, uiBean.getMikeikap().getType()))) {
            uiBean.setShrGoukeiMikeikapDispFlg(false);
        } else {
            uiBean.setShrGoukeiMikeikapDispFlg(true);
        }
        if (uiBean.getMisyuup().equalsValue(BizCurrency.valueOf(0, uiBean.getMisyuup().getType()))) {
            uiBean.setShrGoukeiMisyuupDispFlg(false);
        } else {
            uiBean.setShrGoukeiMisyuupDispFlg(true);
        }
        if (uiBean.getZennouseisankgk().equalsValue(BizCurrency.valueOf(0, uiBean.getZennouseisankgk().getType()))) {
            uiBean.setShrGoukeiZennouseisankgkDispFlg(false);
        } else {
            uiBean.setShrGoukeiZennouseisankgkDispFlg(true);
        }
        if (uiBean.getAzukarikingk().equalsValue(BizCurrency.valueOf(0, uiBean.getAzukarikingk().getType()))) {
            uiBean.setShrGoukeiAzukarikingkDispFlg(false);
        } else {
            uiBean.setShrGoukeiAzukarikingkDispFlg(true);
        }
        if (uiBean.getKrkgk().equalsValue(BizCurrency.valueOf(0, uiBean.getKrkgk().getType()))) {
            uiBean.setShrGoukeiKrkgkDispFlg(false);
        } else {
            uiBean.setShrGoukeiKrkgkDispFlg(true);
        }
        if (C_Tuukasyu.JPY.equals(uiBean.getSk().getKyktuukasyu()) ||
            uiBean.isShrGoukeiHaitoukinDispFlg() == false && uiBean.isShrGoukeiSonotahaitoukinDispFlg() == false &&
            uiBean.isShrGoukeiMikeikapDispFlg() == false && uiBean.isShrGoukeiZennouseisankgkDispFlg() == false &&
            uiBean.isShrGoukeiAzukarikingkDispFlg() == false && uiBean.isShrGoukeiKrkgkDispFlg() == false) {
            uiBean.setViewSiharaiInfoGaikaknsnKijyunYmdFlg(false);
        } else {
            uiBean.setViewSiharaiInfoGaikaknsnKijyunYmdFlg(true);
        }

        return inputContentsPath;
    }

    String pushInputContentsBL() {

        doContinueLockProcess();

        List<Message> messageLst =  uiBean.getErrmessagecollector();
        for (Message message : messageLst) {
            if (message.getMessageId().startsWith("E")) {
                messageManager.addMessage(message);
            }
        }


        String inputContentsPath = "";

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI1;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI2;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI3;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI4;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIHUYOU;
        }

        return inputContentsPath;
    }

    String pushModoruByConfirmBL() {

        doContinueLockProcess();

        messageManager.removeConversationMessage(GROUP_WARNING_MESSAGE_TWO);

        List<Message> messageLst =  uiBean.getErrmessagecollector();
        for (Message message : messageLst) {
            if (message.getMessageId().startsWith("E")) {
                messageManager.addMessage(message);
            }
        }

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            uiBean.setSisyanm("");
        }
        String inputContentsPath = setInputContentsPath();


        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue()) ) {
            uiBean.setViewSiharaiSateiInputDispFlg(true);
        }
        else {
            uiBean.setViewSiharaiSateiInputDispFlg(false);
        }

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            uiBean.setViewKokuhanCheckInputDispFlg(true);
            uiBean.setViewIppanhanteiInputDispFlg(true);
            uiBean.setViewBetukutiCheckSibouInputDispFlg(true);
            uiBean.setViewTratkihuryouHusyoujikenInputDispFlg(true);
            uiBean.setViewJyuukasituInfoInputDispFlg(true);
        }
        else {
            uiBean.setViewKokuhanCheckInputDispFlg(false);
            uiBean.setViewIppanhanteiInputDispFlg(false);
            uiBean.setViewBetukutiCheckSibouInputDispFlg(false);
            uiBean.setViewTratkihuryouHusyoujikenInputDispFlg(false);
            uiBean.setViewJyuukasituInfoInputDispFlg(false);
        }

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> dataSourceBeanLst = Lists.newArrayList();

        for (ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean : uiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData()) {
            if (C_Delflag.BLNK.eq(dataSourceBean.getSakujyoflg()) && !BizUtil.isBlank(dataSourceBean.getByoumeitourokuno())) {
                dataSourceBeanLst.add(dataSourceBean);
            }
        }
        uiBean.setViewSindansyoinfoSibouInfo1(dataSourceBeanLst);
        return inputContentsPath;
    }

    void pushUnlocProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }

    void pushKakuniniraisyoSakuseiPrintOutBL() {

        String tyouhyouKey = uiBean.getTyouhyouKey();
        uiBean.setTyouhyouKey(null);
        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        outputReport.outputPDFWithDel(tyouhyouKey);

    }

    void pushKakuteiPrintOutBL() {

        String tyouhyouKey = uiBean.getResultTyouhyouKey();
        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        outputReport.outputPDFByJoinKey(tyouhyouKey);

    }



    private C_ZeitratkiKbn getZeitratkiKbn(C_Tdk pTdk,C_UktKyksyaTdk pUktKyksyaTdk) {

        C_ZeitratkiKbn zeitratkiKbn = C_ZeitratkiKbn.BLNK;

        if (C_Tdk.HONNIN.eq(pTdk)) {
            zeitratkiKbn = C_ZeitratkiKbn.SOUZOKU;
        }
        else {
            if (C_UktKyksyaTdk.KYKHNN.eq(pUktKyksyaTdk)) {
                zeitratkiKbn = C_ZeitratkiKbn.ITIJI;
            }
            else {
                zeitratkiKbn = C_ZeitratkiKbn.ZOUYO;
            }
        }

        return zeitratkiKbn;
    }

    private C_UktKyksyaTdk uktkyksyatdkCheck(List<JT_SiUkt> pSiUktLst ,C_SeikyuusyaKbn pSeikyuusyaKbn) {
        C_UktKyksyaTdk uktKyksyaTdk = C_UktKyksyaTdk.BLNK;
        C_UktKbn uktKbn = C_UktKbn.BLNK;

        for (JT_SiUkt siUkt : pSiUktLst) {
            if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu())) {
                uktKbn = siUkt.getUktkbn();
                break;
            }
        }

        if (C_SeikyuusyaKbn.UKTHONNIN.eq(pSeikyuusyaKbn) || C_SeikyuusyaKbn.KYKDAIRININ.eq(pSeikyuusyaKbn)) {
            if (C_UktKbn.KYK.eq(uktKbn)) {
                uktKyksyaTdk = C_UktKyksyaTdk.KYKHNN;
            }
            else {
                uktKyksyaTdk = C_UktKyksyaTdk.KYKIGAI;
            }
        }
        if (C_SeikyuusyaKbn.UKTDAIHYOU.eq(pSeikyuusyaKbn) || C_SeikyuusyaKbn.SONOTA.eq(pSeikyuusyaKbn)) {
            uktKyksyaTdk = C_UktKyksyaTdk.KYKIGAI;
        }

        return uktKyksyaTdk;
    }

    private List<JT_SiDetail>  siSiDetailParamBeanEdit(List<SiSiDetailParamBean> pSiSiDetailParamBean) {

        if (pSiSiDetailParamBean == null) {
            return null;
        }
        List<JT_SiDetail> siDetailLst = Lists.newArrayList();
        JT_SiDetail siDetail = null;

        for (SiSiDetailParamBean siSiDetailParamBean : pSiSiDetailParamBean) {

            siDetail = new JT_SiDetail();
            BeanUtil.copyProperties(siDetail, siSiDetailParamBean);

            siDetailLst.add(siDetail);
        }

        return siDetailLst;

    }

    private SiCommonSiwakeBean siCommonSiwakeEdit(String pSyoricd ,String pSyorisosikicd,List<SiSiDetailParamBean> pSiSiDetailParamBeanLst,
        JT_SiKykSyouhn pSiKykSyouhn,BizDate pSysDate) {

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        List<SiharaigakuBean> siharaigakuBeanLat = Lists.newArrayList();
        SiharaigakuBean siharaigakuBean = null;

        BizDate kakokawasesiteiymd = null;
        if (uiBean.getHubikanryouymd() == null){
            kakokawasesiteiymd = uiBean.getSyoruiukeymd();
        }
        else {
            kakokawasesiteiymd = uiBean.getHubikanryouymd();
        }

        for (SiSiDetailParamBean paramBean : pSiSiDetailParamBeanLst) {
            if (!BizUtil.isZero(paramBean.getKyhkg())){
                BizCurrency shrgk = BizCurrency.optional();
                if (!C_Tuukasyu.JPY.eq(uiBean.getSk().getKyktuukasyu()) &&
                    C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())){
                    shrgk = paramBean.getYenkyhgk();
                }
                else {
                    shrgk = paramBean.getKyhkg();
                }

                siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);

                siharaigakuBean.setKanjyouKmkCd(paramBean.getKanjyoukmkcd());
                siharaigakuBean.setSiharaiGk(shrgk);
                siharaigakuBean.setKeiyakuGk(paramBean.getKyhkg());

                siharaigakuBeanLat.add(siharaigakuBean);
            }
        }

        BizCurrency shrtienrisok = BizCurrency.optional();
        BizCurrency shrgkkei = BizCurrency.optional();

        if (!C_Tuukasyu.JPY.eq(uiBean.getSk().getKyktuukasyu()) &&
            C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())){
            shrtienrisok = uiBean.getYenshrtienrsk();
            shrgkkei = uiBean.getYenshrgk();
        }
        else {
            shrtienrisok = uiBean.getShrtienrsk();
            shrgkkei = uiBean.getShrgk();
        }


        siCommonSiwakeBean.setSyoNo(uiBean.getSyono());
        siCommonSiwakeBean.setDenYmd(uiBean.getShrymd());
        siCommonSiwakeBean.setTuukasyu(uiBean.getShrtuukasyu());
        siCommonSiwakeBean.setKeiyakuTuukasyu(uiBean.getSk().getKyktuukasyu());
        siCommonSiwakeBean.setInputShrhousiteiKbn(uiBean.getInputshrhousiteikbn());
        siCommonSiwakeBean.setShrhousiteiKbn(uiBean.getShrhousiteikbn());
        siCommonSiwakeBean.setSyoriYmd(pSysDate);
        siCommonSiwakeBean.setSyoriCd(pSyoricd);
        siCommonSiwakeBean.setSyoriSosikiCd(pSyorisosikicd);
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(kakokawasesiteiymd);
        siCommonSiwakeBean.setSyouhnCd(pSiKykSyouhn.getSyouhncd());
        siCommonSiwakeBean.setSyouhnsdNo(pSiKykSyouhn.getSyouhnsdno());
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanLat);
        siCommonSiwakeBean.setHaitoukin(uiBean.getSiHkkingakuSisanParamBean().getHaitoukin());
        siCommonSiwakeBean.setYenkaHaitoukin(uiBean.getSiHkkingakuSisanParamBean().getYenkahaitoukin());
        siCommonSiwakeBean.setSonotaHaitoukin(uiBean.getSiHkkingakuSisanParamBean().getSonotahaitoukin());
        siCommonSiwakeBean.setYenkaSonotaHaitoukin(uiBean.getSiHkkingakuSisanParamBean().getYenkasonotahaitoukin());
        siCommonSiwakeBean.setMisyuup(uiBean.getSiHkkingakuSisanParamBean().getMisyuup());
        siCommonSiwakeBean.setYenkaMisyuup(uiBean.getSiHkkingakuSisanParamBean().getYenkamisyuup());
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(uiBean.getSiDetailMisyuupBeanLst());
        siCommonSiwakeBean.setMikeikapJyuutouym(uiBean.getSiHkkingakuSisanParamBean().getMikeikapjyuutouym());
        siCommonSiwakeBean.setMikeikap(uiBean.getSiHkkingakuSisanParamBean().getMikeikap());
        siCommonSiwakeBean.setYenkaMikeikap(uiBean.getSiHkkingakuSisanParamBean().getYenkamikeikap());
        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(uiBean.getSiDetailMikeikapBeanLst());
        siCommonSiwakeBean.setZennouryosyuymd(uiBean.getSiKykKihon().getZennouryosyuymd());
        siCommonSiwakeBean.setZennouseisank(uiBean.getSiHkkingakuSisanParamBean().getZennouseisank());
        siCommonSiwakeBean.setYenkaZennouseisank(uiBean.getSiHkkingakuSisanParamBean().getYenkazennouseisank());
        siCommonSiwakeBean.setAzukarikingk(uiBean.getSiHkkingakuSisanParamBean().getAzukarikingk());
        siCommonSiwakeBean.setYenkaAzukarikingk(uiBean.getSiHkkingakuSisanParamBean().getYenkaazukarikingk());
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(uiBean.getSiHkkingakuSisanParamBean().getZitkazukarikingksiteituuka());
        siCommonSiwakeBean.setYenZitkAzukarikingkSttk(uiBean.getSiHkkingakuSisanParamBean().getYenzitkazukarikingksttk());
        siCommonSiwakeBean.setZitkAzukarikingkYen(uiBean.getSiHkkingakuSisanParamBean().getZitkazukarikingkyen());
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(uiBean.getSiHkkingakuSisanParamBean().getGaikaknsnzitkazukarikingkyen());
        siCommonSiwakeBean.setKrkgk(uiBean.getSiHkkingakuSisanParamBean().getKrkgk());
        siCommonSiwakeBean.setYenkaKrkgk(uiBean.getSiHkkingakuSisanParamBean().getYenkakrkgk());
        siCommonSiwakeBean.setShrtienRsk(shrtienrisok);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(uiBean.getShrtienrsk());
        siCommonSiwakeBean.setShrgkkei(shrgkkei);
        siCommonSiwakeBean.setItijibrumu(uiBean.getSyouhnZokusei().getItijibrumu());
        siCommonSiwakeBean.setKawaserate(uiBean.getSiHkkingakuSisanParamBean().getKawaseRate());
        siCommonSiwakeBean.setGaikaknsnKwsrate(uiBean.getSiHkkingakuSisanParamBean().getGaikaknsnkwsrate());
        siCommonSiwakeBean.setKykymd(pSiKykSyouhn.getKykymd());
        siCommonSiwakeBean.setNexthrkym(uiBean.getSiKykKihon().getNexthrkym());
        siCommonSiwakeBean.setHrkkaisuu(uiBean.getSiKykKihon().getHrkkaisuu());
        siCommonSiwakeBean.setTikiktbrisyuruikbn(uiBean.getSiKykKihon().getTikiktbrisyuruikbn());

        return siCommonSiwakeBean;
    }

    private SiCommonSiwakeKekkaBean zengakuItijiknSiwakeEdit(String pSyoricd ,String pSyorisosikicd,List<SiSiDetailParamBean> pSiSiDetailParamBeanLst,
        JT_SiKykSyouhn pSiKykSyouhn,BizDate pSysDate) {

        SiCommonSiwakeBean siCommonSiwakeBean = siCommonSiwakeEdit(pSyoricd,pSyorisosikicd,pSiSiDetailParamBeanLst,pSiKykSyouhn,pSysDate);

        SiCommonSiwake siCommonSiwake = SWAKInjector.getInstance(SiCommonSiwake.class);

        SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = siCommonSiwake.exec(siCommonSiwakeBean);

        siDenpyoDataUpdate(siCommonSiwakeKekkaBean);

        return siCommonSiwakeKekkaBean;
    }

    private void siDenpyoDataUpdate(SiCommonSiwakeKekkaBean pSiCommonSiwakeKekkaBean) {

        List<JT_SiDenpyoData> siDenpyoDataLst = pSiCommonSiwakeKekkaBean.getSiDenpyoDataLst();

        if (siDenpyoDataLst == null) {
            throw new BizAppException(MessageId.EBS1003,"JT_SiDenpyoData", null);
        }

        for (JT_SiDenpyoData siDenpyoData : siDenpyoDataLst) {
            JT_SiDenpyoData newSiDenpyoData = new JT_SiDenpyoData();

            BeanUtil.copyProperties(newSiDenpyoData, siDenpyoData);

            BizPropertyInitializer.initialize(newSiDenpyoData);

            siharaiDomManager.insert(newSiDenpyoData);
        }
    }

    private  void siEditFb (C_Tuukasyu pTuukasyu,SiCommonSiwakeKekkaBean pSiCommonSiwakeKekkaBean,
        SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {

        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);

        BizCurrency soukinGk;
        BizCurrency gaikaTaikaGk;
        BizNumber soukinKwsRate;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
            soukinGk = uiBean.getShrgk();
            gaikaTaikaGk = BizCurrency.valueOf(0);
            soukinKwsRate = BizNumber.valueOf(0);
        }
        else {
            soukinGk = uiBean.getYenshrgk();
            gaikaTaikaGk = uiBean.getShrgk();
            soukinKwsRate = uiBean.getShrkwsrate();
        }

        siEditFbInBean.setShrhouSiteiKbn(uiBean.getShrhousiteikbn());
        siEditFbInBean.setBankCd(uiBean.getBankcd());
        siEditFbInBean.setSitenCd(uiBean.getSitencd());
        siEditFbInBean.setYokinKbn(uiBean.getYokinkbn());
        siEditFbInBean.setKouzaNo(uiBean.getKouzano());

        if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
            siEditFbInBean.setKzMeiginmKn(uiBean.getKzmeiginmkn());
            siEditFbInBean.setSoukinGk(soukinGk);
            siEditFbInBean.setGaikaTaikaGk(gaikaTaikaGk);
            siEditFbInBean.setKzMeiginmei("");
            siEditFbInBean.setShrTuukaSyu(C_Tuukasyu.BLNK);
            siEditFbInBean.setGaikaShrgk(BizCurrency.optional());
        }
        else {
            siEditFbInBean.setKzMeiginmKn("");
            siEditFbInBean.setSoukinGk(BizCurrency.optional());
            siEditFbInBean.setGaikaTaikaGk(BizCurrency.optional());
            siEditFbInBean.setKzMeiginmei(uiBean.getKzmeiginmkn());
            siEditFbInBean.setShrTuukaSyu(uiBean.getShrtuukasyu());
            siEditFbInBean.setGaikaShrgk(uiBean.getShrgk());
        }
        siEditFbInBean.setKykTuukasyu(pTuukasyu);
        siEditFbInBean.setSoukinKwsRate(soukinKwsRate);
        siEditFbInBean.setCrossRateShrgk(BizCurrency.valueOf(0));
        siEditFbInBean.setFbSokinEdaBangou(pSiCommonSiwakeKekkaBean.getFbSoukinEdaNo());
        siEditFbInBean.setSiDenpyoDataLst(pSiCommonSiwakeKekkaBean.getSiDenpyoDataLst());

        SiEditFb siEditFb = SWAKInjector.getInstance(SiEditFb.class);

        SiEditFbOutBean siEditFbOutBean = siEditFb.exec(siEditFbInBean);

        siEditFbUpdate(siEditFbOutBean);
    }

    private void siEditFbUpdate(SiEditFbOutBean pSiEditFbOutBean) {

        List<JT_SiFBSoukinData>  siFBSoukinDataLst = pSiEditFbOutBean.getSiFBSoukinDataLst();

        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = pSiEditFbOutBean.getSiGaikaFBSoukinDataLst();

        if (siFBSoukinDataLst == null && siGaikaFBSoukinDataLst == null) {
            throw new BizAppException(MessageId.EBS1003, "FBSoukinData", null);
        }


        if (siFBSoukinDataLst != null) {
            for (JT_SiFBSoukinData siFBSoukinData : siFBSoukinDataLst) {

                JT_SiFBSoukinData newSiFBSoukinData = new JT_SiFBSoukinData();

                BeanUtil.copyProperties(newSiFBSoukinData, siFBSoukinData);

                BizPropertyInitializer.initialize(newSiFBSoukinData);

                siharaiDomManager.insert(newSiFBSoukinData);
            }
        }

        if (siGaikaFBSoukinDataLst != null) {
            for (JT_SiGaikaFBSoukinData siGaikaFBSoukinData : siGaikaFBSoukinDataLst) {

                JT_SiGaikaFBSoukinData newSiGaikaFBSoukinData = new JT_SiGaikaFBSoukinData();

                BeanUtil.copyProperties(newSiGaikaFBSoukinData, siGaikaFBSoukinData);

                BizPropertyInitializer.initialize(newSiGaikaFBSoukinData);

                siharaiDomManager.insert(newSiGaikaFBSoukinData);
            }
        }

    }

    private void zengakuNenkinSiwakeEdit (String pSyoricd ,String pSyorisosikicd,List<SiSiDetailParamBean> pSiSiDetailParamBeanLst,
        JT_SiKykSyouhn pSiKykSyouhn,BizDate pSysDate) {

        SiCommonSiwakeBean siCommonSiwakeBean = siCommonSiwakeEdit(pSyoricd,pSyorisosikicd,pSiSiDetailParamBeanLst,pSiKykSyouhn,pSysDate);


        siCommonSiwakeBean.setDenYmd(pSysDate);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.ARI);
        SiCommonSiwake siCommonSiwake = SWAKInjector.getInstance(SiCommonSiwake.class);

        SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = siCommonSiwake.exec(siCommonSiwakeBean);

        siDenpyoDataUpdate(siCommonSiwakeKekkaBean);
    }

    private SiCommonSiwakeKekkaBean itibuItijiknSiwakeEdit(String pSyoricd ,String pSyorisosikicd,List<SiSiDetailParamBean> pSiSiDetailParamBeanLst,
        JT_SiKykSyouhn pSiKykSyouhn,BizDate pSysDate) {

        SiCommonSiwakeBean siCommonSiwakeBean = siCommonSiwakeEdit(pSyoricd,pSyorisosikicd,pSiSiDetailParamBeanLst,pSiKykSyouhn,pSysDate);

        SiCommonSiwake siCommonSiwake = SWAKInjector.getInstance(SiCommonSiwake.class);

        SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = siCommonSiwake.exec(siCommonSiwakeBean);

        siDenpyoDataUpdate(siCommonSiwakeKekkaBean);

        return siCommonSiwakeKekkaBean;
    }


    private String siharaiRirekiEdit(Integer pSeikyuurirekiNo,C_ShrKekkaKbn pShrKekkaKbn,BizDate pSysDate) {

        String shrSikibetukey = SaibanBiz.getShrSikibetukey(uiBean.getSyono());

        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = SWAKInjector.getInstance(EditSiharaiRirekiTblBean.class);

        editSiharaiRirekiTblBean.setSkno(uiBean.getSkno());
        editSiharaiRirekiTblBean.setSyono(uiBean.getSyono());
        editSiharaiRirekiTblBean.setShrsikibetukey(shrSikibetukey);
        editSiharaiRirekiTblBean.setSeikyuurirekino(pSeikyuurirekiNo);
        editSiharaiRirekiTblBean.setShrkekkakbn(pShrKekkaKbn);
        editSiharaiRirekiTblBean.setShrsyoriymd(pSysDate);
        editSiharaiRirekiTblBean.setZeitratkikbn(uiBean.getZeitratkikbn());

        EditSiharaiRirekiTbl editSiharaiRirekiTbl = SWAKInjector.getInstance(EditSiharaiRirekiTbl.class);

        editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);

        JT_SiRireki newSiRireki = uiBean.getSkkihon().createSiRireki();

        BeanUtil.copyProperties(newSiRireki, editSiharaiRirekiTblBean.getSirireki());

        BizPropertyInitializer.initialize(newSiRireki);

        return shrSikibetukey;
    }

    private void itibuNenkinSiwakeEdit(String pSyoricd ,String pSyorisosikicd,List<SiSiDetailParamBean> pSiSiDetailParamBeanLst,
        JT_SiKykSyouhn pSiKykSyouhn,BizDate pSysDate) {

        SiCommonSiwakeBean siCommonSiwakeBean = siCommonSiwakeEdit(pSyoricd,pSyorisosikicd,pSiSiDetailParamBeanLst,pSiKykSyouhn,pSysDate);


        siCommonSiwakeBean.setDenYmd(pSysDate);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        SiCommonSiwake siCommonSiwake = SWAKInjector.getInstance(SiCommonSiwake.class);

        SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = siCommonSiwake.exec(siCommonSiwakeBean);

        siDenpyoDataUpdate(siCommonSiwakeKekkaBean);
    }

    private void doContinueLockProcess() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();
    }

    private void getInfo(String pSkno, String pSyono, Integer pSeikyuurirekiNo, String pTdkrrkskbtKey,boolean pSetUiBeanFlg ) {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(pSkno, pSyono);

        if (skKihon == null) {
            throw new BizAppException(MessageId.EBS0005,JT_SkKihon.TABLE_NAME,JT_SkKihon.SKNO,pSkno,JT_SkKihon.SYONO,pSyono);
        }

        uiBean.setSkkihon(skKihon);
        uiBean.setSaisateikbn(uiBean.getSkkihon().getSaisateikbn());

        JT_Sk sk = skKihon.getSkBySeikyuurirekino(pSeikyuurirekiNo);

        if (sk == null) {
            throw new BizAppException(MessageId.EBS0006,JT_Sk.TABLE_NAME,JT_Sk.SKNO,pSkno,JT_Sk.SYONO,pSyono,
                JT_Sk.SEIKYUURIREKINO,String.valueOf(pSeikyuurirekiNo));
        }

        uiBean.setSk(sk);

        List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuus();

        if (skJiyuuLst == null) {
            throw new BizAppException(MessageId.EBS0006,JT_SkJiyuu.TABLE_NAME,JT_SkJiyuu.SKNO,pSkno,JT_SkJiyuu.SYONO,pSyono,
                JT_SkJiyuu.SEIKYUURIREKINO,String.valueOf(pSeikyuurirekiNo));
        }

        uiBean.setSkJiyuuLst(skJiyuuLst);

        List<JT_SkByoumei> skByoumeiLst = Lists.newArrayList();
        for (JT_SkJiyuu skJiyuu : skJiyuuLst) {
            List<JT_SkByoumei> skByoumeiInfo= skJiyuu.getSkByoumeis();
            if (skByoumeiInfo.size() != 0) {
                for (JT_SkByoumei skByoumei : skByoumeiInfo) {
                    skByoumeiLst.add(skByoumei);
                    if (skByoumeiLst.size() == MAX_ROW_COUNT) {
                        break;
                    }
                }
            }

            if (skByoumeiLst.size() == MAX_ROW_COUNT) {
                break;
            }
        }

        uiBean.setSkByoumeiLst(skByoumeiLst);

        if (!pSetUiBeanFlg) {
            List<JT_SiDetail> siDetailLst = Lists.newArrayList();
            List<JT_SiDetail> detailLst = Lists.newArrayList();
            JM_Kyuuhu  kyuuhu  = null;
            JM_SiSyouhnZokusei siSyouhnZokusei = null;
            SortJT_SiDetail sortJT_SiDetail = SWAKInjector.getInstance(SortJT_SiDetail.class);

            for (JT_SkJiyuu skJiyuu : skJiyuuLst) {
                siDetailLst = skJiyuu.getSiDetails();
                siDetailLst = sortJT_SiDetail.OrderJT_SiDetailByUketukenoKyuuhukbnKyuuhucdRennoAsc(siDetailLst);

                for (JT_SiDetail siDetail : siDetailLst) {
                    kyuuhu = siharaiDomManager.getKyuuhu(siDetail.getKyuuhucd());

                    if (kyuuhu != null) {
                        siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokusei(siDetail.getSyouhncd(), siDetail.getKyhgndkatakbn(),
                            siDetail.getSyouhnsdno(), kyuuhu.getKyuuhucd());

                        if (siSyouhnZokusei != null) {

                            detailLst.add(siDetail);
                        }
                    }
                }
            }
            uiBean.setSiDetailLst(detailLst);
        }

        JT_TtdkRireki ttdkRireki = skKihon.getTtdkRirekByTtdkrrkskbtkey(pTdkrrkskbtKey);
        uiBean.setTtdkRireki(ttdkRireki);

        List<JT_SateiSyouninRireki> sateiSyouninRirekiLst =  skKihon.getSateiSyouninRirekis();
        uiBean.setSateiSyouninRirekiLst(sateiSyouninRirekiLst);

        JT_SateiIppanHanteiInfo sateiIppanHanteiInfo = sk.getSateiIppanHanteiInfo();
        uiBean.setSateiIppanHanteiInfo(sateiIppanHanteiInfo);

        JT_SateiKokuhanInfo sateiKokuhanInfo = sk.getSateiKokuhanInfo();
        uiBean.setSateiKokuhanInfo(sateiKokuhanInfo);

        JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo = sk.getSateiJyuukasituChkInfo();
        uiBean.setSateiJyuukasituChkInfo(sateiJyuukasituChkInfo);

        JT_SibouSateiChkInfo sibouSateiChkInfo = sk.getSibouSateiChkInfo();
        uiBean.setSibouSateiChkInfo(sibouSateiChkInfo);

        JT_Toriatukaifuryouinfo toriatukaifuryouinfo = sk.getToriatukaifuryouinfo();
        uiBean.setToriatukaifuryouinfo(toriatukaifuryouinfo);

        JT_SateiKaijyoInfo sateiKaijyoInfo = sk.getSateiKaijyoInfo();
        uiBean.setSateiKaijyoInfo(sateiKaijyoInfo);

        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo = sk.getSateiMeigihenkouInfo();
        uiBean.setSateiMeigihenkouInfo(sateiMeigihenkouInfo);

        JT_BetukutiSateiInfo betukutiSateiInfo = sk.getBetukutiSateiInfo();
        uiBean.setBetukutiSateiInfo(betukutiSateiInfo);
    }

    private void setUiBean (boolean pSetUiBeanFlg) {

        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
        if (!pSetUiBeanFlg) {
            SiSetUiBean.setHKTSkKihon(uiBean, uiBean.getSkkihon());
        }

        siSetUiBean.setSk(uiBean, uiBean.getSk());

        siSetUiBean.setSkJiyuu(uiBean, uiBean.getSkJiyuuLst(), uiBean.getSkByoumeiLst());

        if (!pSetUiBeanFlg) {
            siSetUiBean.setHKTShrMeisai(uiBean, uiBean.getSiDetailLst());
        }

        SiSetUiBean.setIppanhantei(uiBean, uiBean.getSateiIppanHanteiInfo());

        SiSetUiBean.setKokuhanCheck(uiBean, uiBean.getSateiKokuhanInfo());

        SiSetUiBean.setJyuukasituInfo(uiBean, uiBean.getSateiJyuukasituChkInfo());

        SiSetUiBean.setKaijokigenymdInput(uiBean, uiBean.getSateiKaijyoInfo());

        SiSetUiBean.setMeigihenkouSatei(uiBean, uiBean.getSateiMeigihenkouInfo());

        SiSetUiBean.setTratkihuryouHusyoujiken(uiBean, uiBean.getToriatukaifuryouinfo());

        SiSetUiBean.setSonotaCheckSibou(uiBean, uiBean.getSibouSateiChkInfo());

        SiSetUiBean.setBetukutiCheck(uiBean, uiBean.getBetukutiSateiInfo());

        if (uiBean.getSateiSyouninRirekiLst() != null || uiBean.getSateiSyouninRirekiLst().size() > 0) {
            JT_SateiSyouninRireki ssr = null;
            for (int count = uiBean.getSateiSyouninRirekiLst().size() - 1 ; count >= 0; count--) {
                ssr = uiBean.getSateiSyouninRirekiLst().get(count);

                if (ssr.getKossyorisscd().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
                    uiBean.setSatei1Syorikekkakbn(ssr.getSyorikekkakbn());
                    break;
                }
            }
            siSetUiBean.setSateiSiharaiSatei(uiBean, ssr, uiBean.getTtdkRireki(), uiBean.getSk());
        }
    }

    private String setInputContentsPath() {

        String inputContentsPath = "";

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI1;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI2;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI3;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SATEI4;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIHUYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SYOUNIN_SATEIHUYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SYOUNIN_SATEIYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_SESSYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_KAIKETU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue())) {
            inputContentsPath = FORWARDNAME_INPUTCONTENTS_KAKUNIN_HUBI;
        }
        else {
            throw new BizAppException(MessageId.EBS1003,AS_KinouMode.KINOUMODEID,kinouMode.getKinouMode());
        }

        return inputContentsPath;
    }

    private String setKakuninPath () {

        String kakuninPath = "";


        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_SATEI1;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_SATEI2;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_SATEI3;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_SATEI4;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_TETUZUKI_SATEIHUYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_SYOUNIN_SATEIHUYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_TETUZUKI_SATEIYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_SYOUNIN_SATEIYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_SESSYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_KAIKETU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue())) {
            kakuninPath = FORWARDNAME_CONFIRM_KAKUNIN_HUBI;
        }
        else {
            throw new BizAppException(MessageId.EBS1003,AS_KinouMode.KINOUMODEID,kinouMode.getKinouMode());
        }

        return kakuninPath;

    }

    private String setResultPath () {

        String resultPath = "";


        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            resultPath = FORWARDNAME_RESULT_SATEI1;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue())) {
            resultPath = FORWARDNAME_RESULT_SATEI2;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue())) {
            resultPath = FORWARDNAME_RESULT_SATEI3;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue())) {
            resultPath = FORWARDNAME_RESULT_SATEI4;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue())) {
            resultPath = FORWARDNAME_RESULT_TETUZUKI_SATEIHUYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue())) {
            resultPath = FORWARDNAME_RESULT_SYOUNIN_SATEIHUYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue())) {
            resultPath = FORWARDNAME_RESULT_TETUZUKI_SATEIYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue())) {
            resultPath = FORWARDNAME_RESULT_SYOUNIN_SATEIYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue())) {
            resultPath = FORWARDNAME_RESULT_SESSYOU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            resultPath = FORWARDNAME_RESULT_KAIKETU;
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue())) {
            resultPath = FORWARDNAME_RESULT_KAKUNIN_HUBI;
        }
        else {
            throw new BizAppException(MessageId.EBS1003,AS_KinouMode.KINOUMODEID,kinouMode.getKinouMode());
        }

        return resultPath;
    }

    private void setSyorikekkaKbn () {


        uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_DEFAULT);
        uiBean.setPatternSateiSyorikekkakbn(C_SyorikekkaKbn.PATTERN_DEFAULT);

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            boolean syorikekkaKbnFlg = false;
            for (JT_SateiSyouninRireki sateiSyouninRireki : uiBean.getSateiSyouninRirekiLst()) {
                if (sateiSyouninRireki.getKossyorisscd().equals(C_SikinouModeIdKbn.SATEI2.getValue()) &&
                    C_SyorikekkaKbn.KAKUNIN.eq(sateiSyouninRireki.getSyorikekkakbn())) {
                    syorikekkaKbnFlg = true;
                    break;
                }
            }
            if (syorikekkaKbnFlg) {
                uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISATEI_1_KAKUNIN);
            }
            else {
                uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISATEI_1);
            }
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue())) {
            boolean syorikekkaKbnFlg = false;
            for (JT_SateiSyouninRireki sateiSyouninRireki : uiBean.getSateiSyouninRirekiLst()) {
                if (sateiSyouninRireki.getKossyorisscd().equals(C_SikinouModeIdKbn.SATEI2.getValue()) &&
                    C_SyorikekkaKbn.KAKUNIN.eq(sateiSyouninRireki.getSyorikekkakbn())) {
                    syorikekkaKbnFlg = true;
                    break;
                }
            }
            if (syorikekkaKbnFlg) {
                uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISATEI_2_KAKUNIN);
            }
            else {
                uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISATEI_2);
            }
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue())) {
            uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISATEI_3);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue())) {
            uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISATEI_4);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue())) {
            uiBean.setPatternSateiSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SITETUZUKI_SATEIHUYOU);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue())) {
            uiBean.setPatternSateiSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SITETUZUKI_SATEIYOU);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue())) {
            uiBean.setPatternSateiSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISYOUNIN);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue())) {
            uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SIHUBITYUU);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue())) {
            uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SIKAKUNINTYUU);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue())) {
            uiBean.setPatternSateiSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISESSYOU_1);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue())) {
            uiBean.setPatternSateiSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SISESSYOU_2);
        }
        else if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            uiBean.setPatternSateiSyorikekkakbn(C_SyorikekkaKbn.PATTERN_SIKAIKETU);
        }
        else {
            throw new BizAppException(MessageId.EBS1003,AS_KinouMode.KINOUMODEID,kinouMode.getKinouMode());
        }
    }

    private void setInputShrhousiteiKbn () {

        if (C_SaisateiKbn.SAISATEI.eq(uiBean.getSaisateikbn())) {
            uiBean.setPatternInputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_NOFBSOUKIN);
        }
        else {
            uiBean.setPatternInputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_DEFAULT);
        }

    }

    private void setSiharaiTuukaKbn () {

        if (C_Tuukasyu.JPY.eq(uiBean.getSk().getKyktuukasyu())) {
            uiBean.setPatternSiharaiTuukaKbn(C_SiharaiTuukaKbn.PATTERN_YENDATE);
        }
        else {
            uiBean.setPatternSiharaiTuukaKbn(C_SiharaiTuukaKbn.PATTERN_DEFAULT);
        }
    }

    private void setSaigaiHosyouUmuKbn () {

        SiHosyouHantei siHosyouHantei = SWAKInjector.getInstance(SiHosyouHantei.class);

        boolean siHosyouHanteiFlag = siHosyouHantei.chkSaigaiHosyou(uiBean.getSiSiDetailParamBeanLst());

        if (siHosyouHanteiFlag) {
            uiBean.setSaigaihosyouumukbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setSaigaihosyouumukbn(C_UmuKbn.NONE);
        }
    }

    private void setTensousaki() {

        List<UsersByKinouIdKinouModeIdUserIdBean> userLst = bizDomManager.getUsersByKinouIdKinouModeIdUserId(
            kinou.getKinouId(),
            kinouMode.getKinouMode(),
            baseUserInfo.getUserId());

        setTennousakisousasyacd(userLst);

    }

    private void setTennousakisousasyacd(List<UsersByKinouIdKinouModeIdUserIdBean> pUserLst) {

        UserDefsList tennousakisousasyacdOptionBeanList = new UserDefsList();
        LabelValuePair pair = new LabelValuePair();
        pair.setLabel("");
        pair.setValue("");
        tennousakisousasyacdOptionBeanList.add(pair);

        if(pUserLst != null){
            for (UsersByKinouIdKinouModeIdUserIdBean user : pUserLst) {
                LabelValuePair pair2 = new LabelValuePair();
                if(user.getSosikiNm() != null){
                    pair2.setLabel(user.getSosikiNm().concat(FULL_SPACE.concat(user.getUserNm())));
                    pair2.setValue(user.getUserId());
                }
                else {
                    pair2.setLabel(user.getUserNm());
                    pair2.setValue(user.getUserId());
                }
                tennousakisousasyacdOptionBeanList.add(pair2);
            }
        }
        uiBean.setTennousakisousasyacdOptionBeanList(tennousakisousasyacdOptionBeanList);


        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {

            uiBean.setSateitennousakisousasyacdOptionBeanList(tennousakisousasyacdOptionBeanList);
        }
    }

    private void setViewSindansyoinfoSibouInfo() {

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> dataSourceBeanLst = uiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData();
        int dataSourceBeanSize = dataSourceBeanLst.size();

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> viewSindansyoinfoSibouInfo = Lists.newArrayList();
        ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean = null;

        ViewSindansyoinfoSibouInfo1DataSourceBean newDataSourceBean = null;

        String sakujyoLink = MessageUtil.getMessage(DDID_VIEWSINDANSYOINFOSIBOUINFO1_SAKUJYOLINK.getErrorResourceKey());

        String searchlink = MessageUtil.getMessage(DDID_VIEWSINDANSYOINFOSIBOUINFO1_SEARCHLINK.getErrorResourceKey());

        for (ViewSindansyoinfoSibouInfo1DataSourceBean bean : dataSourceBeanLst) {
            dataSourceBean = SWAKInjector.getInstance(ViewSindansyoinfoSibouInfo1DataSourceBean.class);
            BeanUtil.copyProperties(dataSourceBean, bean);
            dataSourceBean.setSearchlink(searchlink);
            dataSourceBean.setSakujyoLink(sakujyoLink);
            dataSourceBean.setSakujyoflg(C_Delflag.BLNK);

            viewSindansyoinfoSibouInfo.add(dataSourceBean);
        }

        for (int i = dataSourceBeanSize; i<  MAX_ROW_COUNT ; i++) {
            newDataSourceBean = SWAKInjector.getInstance(ViewSindansyoinfoSibouInfo1DataSourceBean.class);
            newDataSourceBean.setSearchlink(searchlink);
            newDataSourceBean.setSakujyoLink(sakujyoLink);
            newDataSourceBean.setSakujyoflg(C_Delflag.SAKUJYO);

            viewSindansyoinfoSibouInfo.add(newDataSourceBean);
        }
        uiBean.setViewSindansyoinfoSibouInfo1(viewSindansyoinfoSibouInfo);
    }

    private void betuskSyorityuChk(String pSyono, String pSkno) {

        BetuskSyorityuChk betuskSyorityuChk = SWAKInjector.getInstance(BetuskSyorityuChk.class);

        boolean betuskSyorityuChkFlg = betuskSyorityuChk.exec(pSyono, pSkno);

        if (!betuskSyorityuChkFlg) {
            messageManager.addConversationMessageId(GROUP_WARNING_MESSAGE_ONE, MessageId.WJA0052,
                betuskSyorityuChk.getWmJimutetuzukinm(),betuskSyorityuChk.getWmNodenm());
        }
    }

    private boolean getInputContentsErrDispFlg() {

        boolean inputContentsErrDispFlg = false;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue())) {
            if (C_SyorikekkaKbn.SIHARAI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUSIHARAI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.SATEI_3.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.SATEI_4.eq(uiBean.getSyorikekkakbn())) {
                inputContentsErrDispFlg = true;
            }
        }
        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue())) {
            if (C_SyorikekkaKbn.SIHARAI.eq(uiBean.getSateisyorikekkakbn()) ||
                C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSateisyorikekkakbn()) ||
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSateisyorikekkakbn()) ||
                C_SyorikekkaKbn.SATEI_SIJI.eq(uiBean.getSateisyorikekkakbn())) {
                inputContentsErrDispFlg = true;
            }
        }

        return inputContentsErrDispFlg;
    }
}
