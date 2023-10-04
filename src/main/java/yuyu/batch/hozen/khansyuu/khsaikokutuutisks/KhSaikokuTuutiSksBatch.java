package yuyu.batch.hozen.khansyuu.khsaikokutuutisks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khsaikokutuutisks.dba.KhSaikokuTuutiSksDao;
import yuyu.batch.hozen.khansyuu.khsaikokutuutisks.dba.SaikokuTuutiSksTaisyouDataBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.CreditSaikokuTuutiParam;
import yuyu.common.hozen.ascommon.EditMinyuuTuuti;
import yuyu.common.hozen.ascommon.HanteiHsgTokusinSyurui;
import yuyu.common.hozen.ascommon.HsigiTksnInfoBean;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.ascommon.SaikokuTuutiParam;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 催告通知作成
 */
public class KhSaikokuTuutiSksBatch implements Batch {

    private static final String TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERY_FILTER_ID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhSaikokuTuutiSksDao khSaikokuTuutiSksDao;

    @Inject
    private KhSaikokuTuutiSksBatchParam khSaikouTuutiSksBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;


    @Override
    public BatchParam getParam() {
        return khSaikouTuutiSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(khSaikouTuutiSksBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), String.valueOf(khSaikouTuutiSksBatchParam.getIbKakutyoujobcd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "処理区分",
            String.valueOf(khSaikouTuutiSksBatchParam.getSyoriKbn())));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouId = khozenCommonParam.getFunctionId();
        int syoriKensu = 0;
        BizDate syoriYmd = khSaikouTuutiSksBatchParam.getSyoriYmd();
        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        List<EditKhMisslstParam> editMisslstParamLst = new ArrayList<>();
        int misslstSeqNo = 0;
        C_Hrkkeiro targetRhrkkeiro = C_Hrkkeiro.BLNK;

        if ("1".equals(khSaikouTuutiSksBatchParam.getSyoriKbn())) {

            targetRhrkkeiro = C_Hrkkeiro.CREDIT;
        }
        else if ("2".equals(khSaikouTuutiSksBatchParam.getSyoriKbn())) {

            targetRhrkkeiro = C_Hrkkeiro.KOUHURI;
        }
        else {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0010, "処理区分"));
        }

        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);

        if (C_Hrkkeiro.CREDIT.eq(targetRhrkkeiro)) {
            ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(100);
        }
        else if (C_Hrkkeiro.KOUHURI.eq(targetRhrkkeiro)) {
            ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(0);
        }
        try (ExDBResults<SaikokuTuutiSksTaisyouDataBean> saikokuTuutiSksTaisyouDataBeanLst = khSaikokuTuutiSksDao.
            getSaikokuTuutiSksTaisyouDataBean(khSaikouTuutiSksBatchParam.getIbKakutyoujobcd(), syoriYm, targetRhrkkeiro);
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            for (SaikokuTuutiSksTaisyouDataBean saikokuTuutiSksTaisyouDataBean : saikokuTuutiSksTaisyouDataBeanLst) {
                String kbnkey = saikokuTuutiSksTaisyouDataBean.getKbnkey();
                String syoNo = saikokuTuutiSksTaisyouDataBean.getSyono();
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(khSaikouTuutiSksBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kbnkey);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);
                C_TokusinKbn tokusinKbn = C_TokusinKbn.BLNK;
                String tokusinTblUpFlg = "1";
                C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
                String tuutisyuruicd = "";
                BizDateYM jkipjytym = saikokuTuutiSksTaisyouDataBean.getJkipjytym();
                BizDateYM jkipjytYkYkYkYm = jkipjytym.addMonths(3);
                boolean saikokuTaisyouFlg = false;
                boolean saikokuTuutiSksFlg = false;
                boolean tokusinKkntyoukaFlg = false;
                boolean misslstSaikokuTuutiSksFlg = false;
                boolean misslstSaikokuTuutisksJikityoukaSksFlg = false;

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
                List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
                IT_Tokusin tokusin = ansyuKihon.getTokusin();

                BizDate tokusinEndYmd = null;
                BizDate tokusinYmLastDay = null;
                BizDateYM hsgtokusinEndYm = null;
                BizDate hsgYmd = null;
                if (tokusin != null) {
                    tokusinEndYmd = tokusin.getTokusinendymd();
                    hsgYmd = tokusin.getHsgymd();

                    if (C_TokusinKbn.HISAIGAI.eq(tokusin.getTokusinkbn())) {
                        if (BizDateUtil.compareYmd(tokusin.getTokusinendymd(), syoriYmd) == BizDateUtil.COMPARE_LESSER) {
                            tokusinKkntyoukaFlg = true;
                        }
                        else {
                            tokusinKbn = tokusin.getTokusinkbn();
                        }
                    }
                    else {
                        tokusinKbn = tokusin.getTokusinkbn();
                    }
                    if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                        tokusinYmLastDay = tokusinEndYmd.getBizDateYM().getLastDay();
                        if (BizDateUtil.compareYmd(tokusinEndYmd, tokusinYmLastDay) == BizDateUtil.COMPARE_EQUAL) {
                            hsgtokusinEndYm = tokusinEndYmd.getBizDateYM();
                        }
                        else {
                            hsgtokusinEndYm = tokusinEndYmd.getBizDateYM().addMonths(-1);
                        }
                    }
                }

                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
                khozenCommonParam.setSikibetuKey(null);
                String sikibetuKey = "";
                if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn) ||
                    (C_TokusinKbn.BLNK.eq(tokusinKbn) && tokusinKkntyoukaFlg)) {

                    HanteiHsgTokusinSyurui hanteiHsgTokusinSyurui = SWAKInjector.getInstance(HanteiHsgTokusinSyurui.class);
                    HsigiTksnInfoBean hsigiTksnInfoBean = hanteiHsgTokusinSyurui.exec(hsgYmd);

                    if (!C_HsigiTkbtTaiouSyuruiKbn.BLNK.eq(hsigiTksnInfoBean.getHsigiTkbtTaiouSyurui())) {
                        continue;
                    }
                }

                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);

                setYuuyokknmanryobi.exec(syoNo, jkipjytym);
                BizDate yuuyokknMnrybi = setYuuyokknmanryobi.getYuuyokknMnrybi();

                if (!C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                    if (BizDateUtil.compareYmd(yuuyokknMnrybi, syoriYmd) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(yuuyokknMnrybi, syoriYmd) == BizDateUtil.COMPARE_EQUAL) {
                        continue;
                    }
                }
                else {
                    if (BizDateUtil.compareYm(hsgtokusinEndYm, syoriYm) != BizDateUtil.COMPARE_EQUAL) {
                        continue;
                    }
                }

                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam =
                    SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(syoNo);

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                    continue;
                }

                boolean tuutiSakuseisumiFlg = false;

                List<IT_KouzahuriMinyuTuuti> kouzahuriMinyuTuutiLst =
                    khSaikokuTuutiSksDao.getKouzahuriMinyuTuutis(syoNo, jkipjytym);

                if (kouzahuriMinyuTuutiLst.size() > 0) {

                    for (IT_KouzahuriMinyuTuuti wkMinyuTuuti: kouzahuriMinyuTuutiLst) {
                        if (kykKihon.getHrkkeiro().eq(wkMinyuTuuti.getHrkkeiro())) {

                            tuutiSakuseisumiFlg = true;
                            break;
                        }
                    }

                    if (tuutiSakuseisumiFlg) {

                        continue;
                    }

                    if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

                        misslstSaikokuTuutiSksFlg = true;
                    }
                    else if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                        saikokuTaisyouFlg = true;
                    }
                }


                IT_DattaiUktk dattaiUktk = ansyuKihon.getDattaiUktk();

                IT_CreditCardInfo creditCardInfo = null;

                IT_AnsyuRireki ansuRireki = null;

                SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

                C_CreditUriageNgJiyuuKbn uriageNgiyuu = null;

                BizDate tykzenKaiUrskbi = null;

                BizDate tykgoKaiUrskbi = null;

                if (!saikokuTaisyouFlg && !misslstSaikokuTuutiSksFlg) {

                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                        saikokuTaisyouFlg = true;
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

                        creditCardInfo = kykKihon.getCreditCardInfo();

                        setCreditUriageSeikyuubi.exec(syoriYmd);

                        tykzenKaiUrskbi = setCreditUriageSeikyuubi.getZenkaiUrskbi();

                        tykgoKaiUrskbi = setCreditUriageSeikyuubi.getJikaiUrskbi();

                        List<IT_AnsyuRireki> ansuRirekiList = khSaikokuTuutiSksDao.getAnsyuRirekis(syoNo);

                        if (ansuRirekiList.size() > 0) {

                            ansuRireki = ansuRirekiList.get(0);

                            uriageNgiyuu = ansuRireki.getCredituriagengjiyuu();
                        }
                        else {
                            uriageNgiyuu = C_CreditUriageNgJiyuuKbn.BLNK;
                        }

                        if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(creditCardInfo.getCredityuukoukakkekka()) ||
                            C_Yuukoukakkekka.YUUKOUKAK_NG.eq(creditCardInfo.getCredityuukoukakkekka()) ) {

                            if (dattaiUktk == null) {

                                if (ansuRireki != null && ansuRireki.getUriageymdkon().compareTo(tykzenKaiUrskbi) == 0) {

                                    if (C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(uriageNgiyuu)) {

                                        saikokuTaisyouFlg = true;
                                    }
                                }
                                else {

                                    uriageNgiyuu = C_CreditUriageNgJiyuuKbn.BLNK;
                                }
                            }
                            else {

                                if (!C_DattairiyuuKbn.CSSKOUHURIIRHUBI.eq(dattaiUktk.getDattairiyuukbn())) {

                                    saikokuTaisyouFlg = true;
                                }
                            }
                        }

                        if (!saikokuTaisyouFlg) {

                            misslstSaikokuTuutiSksFlg = true;
                        }

                    }
                }

                if (saikokuTaisyouFlg) {
                    if (!C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                        if (BizDateUtil.compareYm(jkipjytYkYkYkYm, syoriYm) == BizDateUtil.COMPARE_EQUAL) {

                            saikokuTuutiSksFlg= true;
                        }
                        else if (BizDateUtil.compareYm(jkipjytYkYkYkYm, syoriYm) == BizDateUtil.COMPARE_LESSER) {

                            misslstSaikokuTuutisksJikityoukaSksFlg = true;
                        }

                    }
                    else {

                        saikokuTuutiSksFlg = true;
                    }
                }

                BizDate syoriYmLastDay  = null;
                BizDate tuutiTokusinEndYmd = null;
                if (saikokuTaisyouFlg) {
                    syoriYmLastDay = syoriYm.getLastDay().getBusinessDay(CHolidayAdjustingMode.NEXT);
                    if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                        tuutiTokusinEndYmd = tokusinEndYmd;
                    }
                    else if (C_TokusinKbn.OTHER.eq(tokusinKbn)) {
                        if (BizDateUtil.compareYmd(tokusinEndYmd, syoriYmLastDay) == BizDateUtil.COMPARE_LESSER ) {
                            tokusinTblUpFlg = "2";
                            sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);
                            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
                            tableMaintenanceUtil.backUp(syoNo, sikibetuKey);
                            khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                            khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());
                            tuutiTokusinEndYmd = syoriYmLastDay;
                        }
                        else {
                            tuutiTokusinEndYmd = tokusinEndYmd;
                        }
                    }
                    else {
                        tokusinTblUpFlg = "3";
                        sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);
                        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
                        tableMaintenanceUtil.backUp(syoNo, sikibetuKey);
                        khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                        khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());
                        tuutiTokusinEndYmd = syoriYmLastDay;
                    }

                }

                if (misslstSaikokuTuutiSksFlg || misslstSaikokuTuutisksJikityoukaSksFlg) {

                    misslstSeqNo = misslstSeqNo + 1;

                    String pMisslistMsg = "";
                    if (misslstSaikokuTuutiSksFlg) {

                        pMisslistMsg = MessageUtil.getMessage(MessageId.EIF3053, jkipjytym.toString());
                    }
                    if (misslstSaikokuTuutisksJikityoukaSksFlg) {

                        pMisslistMsg = MessageUtil.getMessage(MessageId.EIF3043, jkipjytym.toString());
                    }

                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

                    editKhMisslstParam.setDataNo(misslstSeqNo);
                    editKhMisslstParam.setSeqNo(misslstSeqNo);
                    editKhMisslstParam.setMisslistMsg(pMisslistMsg);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(syoNo);

                    editMisslstParamLst.add(editKhMisslstParam);

                    if ("1".equals(tokusinTblUpFlg)) {
                        syoriKensu = syoriKensu + 1;
                        continue;
                    }
                }

                IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

                if (khTtdkTyuui != null && C_KktyuitaKbn.DNGNMEMOARI.eq(khTtdkTyuui.getKktyuitakbn())) {
                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                    tuutisyuruicd = "Z01";
                }
                else if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                    tuutisyuruicd = "A01";
                } else {
                    List<IT_Kariukekin> kariukekinLst = khSaikokuTuutiSksDao.getKariukekins(kykKihon);

                    if (kariukekinLst.size() > 0) {
                        hassouKbn = C_HassouKbn.HONSYAKAISOU;
                        tuutisyuruicd = "A02";
                    }
                }

                C_UmuKbn dattaiuktkUmu = C_UmuKbn.NONE;
                C_DattairiyuuKbn dattairiyuuKbn = C_DattairiyuuKbn.BLNK;
                C_Dattaikeiro dattaikeiro = null;
                C_UmuKbn syunodattaiUmu = C_UmuKbn.NONE;
                IT_KouzahuriMinyuTuuti kouzahuriMinyuTuuti = null;

                if (saikokuTuutiSksFlg) {
                    if (dattaiUktk != null) {
                        dattaiuktkUmu = C_UmuKbn.ARI;
                        dattairiyuuKbn = dattaiUktk.getDattairiyuukbn();
                        dattaikeiro = dattaiUktk.getDattaikeiro();
                        if (C_Dattaikeiro.KOUHURI.eq(dattaikeiro)) {
                            syunodattaiUmu = C_UmuKbn.ARI;
                        }
                        else {
                            syunodattaiUmu = C_UmuKbn.NONE;
                        }
                    }

                    BizDate nexthurikaeYmd = null;

                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                        setHurikaebi.exec(syoriYmd);
                        nexthurikaeYmd = setHurikaebi.getTyokugoHurikaebi();
                    }

                    BizDateYM syuharaimanYm = ansyuKihon.getSyuharaimanymd().getBizDateYM();

                    int jkiAnnaiytTukisuu = 0;

                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro()) ||
                        C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

                        if (C_UmuKbn.NONE.eq(dattaiuktkUmu)) {

                            jkiAnnaiytTukisuu = keisanAnnaiTukisuu(kykKihon,
                                syoriYm, jkipjytym, syuharaimanYm, tokusinKbn, hsgtokusinEndYm);
                        }
                        else if (C_UmuKbn.ARI.eq(dattaiuktkUmu)) {

                            jkiAnnaiytTukisuu = keisanMisyuuTukisuu(kykKihon,
                                syoriYm, jkipjytym, syuharaimanYm);
                        }
                    }

                    int jkiAnnaiytNennsuu = 0;
                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro()) || C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {
                        if (C_UmuKbn.NONE.eq(dattaiuktkUmu)) {
                            jkiAnnaiytNennsuu = keisanAnnaiNensuu(kykKihon);
                        }
                        else if (C_UmuKbn.ARI.eq(dattaiuktkUmu)) {
                            jkiAnnaiytNennsuu = keisanMisyuuNensuu(kykKihon);
                        }
                    }

                    BizDate jkirsymd = null;
                    C_Nykkeiro nykkeiro = C_Nykkeiro.BLNK;

                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);
                        setHurikaebi.exec(syoriYmd);
                        jkirsymd = setHurikaebi.getTyokugoHurikaebi();
                        nykkeiro = C_Nykkeiro.KZHRK;
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {
                        jkirsymd = tykgoKaiUrskbi;
                        nykkeiro = C_Nykkeiro.CREDIT;
                    }

                    KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                    C_ErrorKbn errorKbn = keisanRsgaku.exec(kykKihon, nykkeiro, C_NyknaiyouKbn.KEIZOKUP,
                        jkirsymd, ansyuKihon.getJkipjytym(), jkiAnnaiytNennsuu, jkiAnnaiytTukisuu);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kykKihon.getSyono(),
                            MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                        kykKihon.detach();
                        ansyuKihon.detach();

                        continue;
                    }

                    KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();

                    BizCurrency jkiAnnaigk = keisanRsgkOutBean.getRsgakuGoukei();

                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                        SaikokuTuutiParam saikokuTuutiParam = SWAKInjector.getInstance(SaikokuTuutiParam.class);

                        saikokuTuutiParam.setDattaiUktkUmu(dattaiuktkUmu);
                        saikokuTuutiParam.setDattaiRiyuuKbn(dattairiyuuKbn);
                        saikokuTuutiParam.setSyuunoujiDattaiUmuKbn(syunodattaiUmu);
                        saikokuTuutiParam.setJkiPJytYm(jkipjytym);
                        saikokuTuutiParam.setYykknMnryYmd(tuutiTokusinEndYmd);
                        saikokuTuutiParam.setJkiHurikaeYmd(nexthurikaeYmd);
                        saikokuTuutiParam.setJkiAnnaiJyuutouTukisuu(jkiAnnaiytTukisuu);
                        saikokuTuutiParam.setJkiAnnaiJyuutouNensuu(jkiAnnaiytNennsuu);
                        saikokuTuutiParam.setJkiAnnaiKg(jkiAnnaigk);

                        EditMinyuuTuuti editMinyuuTuuti = SWAKInjector.getInstance(EditMinyuuTuuti.class);
                        kouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam,
                            kykKihon,
                            saikokuTuutiParam,
                            syoriYmd,
                            hassouKbn,
                            tuutisyuruicd);
                    }

                    else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

                        CreditSaikokuTuutiParam creditSaikokuTuutiParam = SWAKInjector.getInstance(
                            CreditSaikokuTuutiParam.class);

                        creditSaikokuTuutiParam.setDattaiUktkUmu(dattaiuktkUmu);
                        creditSaikokuTuutiParam.setDattaiRiyuuKbn(dattairiyuuKbn);
                        creditSaikokuTuutiParam.setDattaikeiro(dattaikeiro);
                        if (creditCardInfo != null) {
                            creditSaikokuTuutiParam.setYuukoukakkekka(creditCardInfo.getCredityuukoukakkekka());
                        }
                        creditSaikokuTuutiParam.setCreditUriageNgJiyuuKbn(uriageNgiyuu);
                        creditSaikokuTuutiParam.setJkiPJytYm(jkipjytym);
                        creditSaikokuTuutiParam.setYykknMnryYmd(tuutiTokusinEndYmd);
                        creditSaikokuTuutiParam.setJikaiUrskbi(tykgoKaiUrskbi);
                        creditSaikokuTuutiParam.setAnnaiGetusuu(jkiAnnaiytTukisuu);
                        creditSaikokuTuutiParam.setAnnaiKingaku(jkiAnnaigk);

                        EditMinyuuTuuti editMinyuuTuuti = SWAKInjector.getInstance(EditMinyuuTuuti.class);
                        kouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam,
                            kykKihon,
                            creditSaikokuTuutiParam,
                            syoriYmd,
                            hassouKbn,
                            tuutisyuruicd);
                    }
                }

                if (kouzahuriMinyuTuuti != null && saikokuTuutiSksFlg) {
                    multipleEntityInserter.add(kouzahuriMinyuTuuti);
                }

                if ("3".equals(tokusinTblUpFlg)) {

                    kykKihon.setSyhenkouymd(syoriYmd);
                    kykKihon.setGyoumuKousinKinou(kinouId);
                    kykKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    kykKihon.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    multipleEntityUpdater.add(kykKihon);

                    if (!tokusinKkntyoukaFlg) {
                        IT_Tokusin tokusinInsert = ansyuKihon.createTokusin();
                        tokusinInsert.setTokusinkbn(C_TokusinKbn.OTHER);
                        tokusinInsert.setTokusinsyoriymd(syoriYmd);
                        tokusinInsert.setTokusinendymd(syoriYmLastDay);
                        tokusinInsert.setGyoumuKousinKinou(kinouId);
                        tokusinInsert.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        tokusinInsert.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                        BizPropertyInitializer.initialize(tokusinInsert);
                        multipleEntityInserter.add(ansyuKihon);
                    }
                    else {
                        tokusin.setTokusinkbn(C_TokusinKbn.OTHER);
                        tokusin.setTokusinsyoriymd(syoriYmd);
                        tokusin.setHsgymd(null);
                        tokusin.setTokusinendymd(syoriYmLastDay);
                        tokusin.setGyoumuKousinKinou(kinouId);
                        tokusin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        tokusin.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                        multipleEntityUpdater.add(ansyuKihon);
                    }

                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    EditTtdkRirekiTbl  editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                    IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                    khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(syoNo);
                    editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                    editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                    editTtdkRirekiTblParam.setSysTime(BizDate.getSysDateTimeMilli());
                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
                }
                else if ("2".equals(tokusinTblUpFlg)) {
                    kykKihon.setSyhenkouymd(syoriYmd);
                    kykKihon.setGyoumuKousinKinou(kinouId);
                    kykKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    kykKihon.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    tokusin.setTokusinendymd(syoriYmLastDay);
                    tokusin.setGyoumuKousinKinou(kinouId);
                    tokusin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    tokusin.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    multipleEntityUpdater.add(kykKihon);
                    multipleEntityUpdater.add(ansyuKihon);

                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    EditTtdkRirekiTbl  editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                    IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                    khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(syoNo);
                    editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                    editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                    editTtdkRirekiTblParam.setSysTime(BizDate.getSysDateTimeMilli());
                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
                }

                syoriKensu = syoriKensu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (editMisslstParamLst.size() > 0) {
                EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);
                ReportServicesBean reportServicesBean = editKhMisslstTbl.editBean(C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU,
                    khozenCommonParam,
                    editMisslstParamLst,
                    syoriYmd);

                CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
                createReport.execNoCommit(reportServicesBean);
            }

            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {
                ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYmd);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
            if (editMisslstParamLst.size() > 0) {
                batchLogger.info(MessageUtil.getMessage(
                    MessageId.IAC1001, "ミスリスト", String.valueOf(editMisslstParamLst.size())));
            }
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private int keisanAnnaiTukisuu(IT_KykKihon pKykKihon, BizDateYM pSyoriYm,
        BizDateYM pJkipjytYm, BizDateYM pSyuharaimanYm, C_TokusinKbn pTokusinKbn, BizDateYM pHsgtokusinEndYm) {

        BizDateYM jkiAnnaiEndYm = null;
        int annaitukisuu = 0;

        if (C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu())) {
            if (C_TkiktbrisyuruiKbn.NONE.eq(pKykKihon.getTikiktbrisyuruikbn()) ||
                C_TkiktbrisyuruiKbn.BLNK.eq(pKykKihon.getTikiktbrisyuruikbn())) {
                if (C_TokusinKbn.HISAIGAI.eq(pTokusinKbn)) {

                    jkiAnnaiEndYm = pHsgtokusinEndYm.addMonths(-1);
                    if (BizDateUtil.compareYm(jkiAnnaiEndYm,
                        pSyuharaimanYm.addMonths(-1)) == BizDateUtil.COMPARE_GREATER) {

                        jkiAnnaiEndYm = pSyuharaimanYm.addMonths(-1);
                    }
                    annaitukisuu = BizDateUtil.calcDifferenceMonths(jkiAnnaiEndYm, pJkipjytYm) + 1;
                }
                else {

                    jkiAnnaiEndYm = pSyoriYm;
                    List<IT_YykIdouUktk> yykIdouUktkLst =
                        khSaikokuTuutiSksDao.getYykIdouUktks(pKykKihon.getSyono(), pSyoriYm);

                    if (yykIdouUktkLst.size() > 0) {

                        BizDateYM yykidouHennyuYm = yykIdouUktkLst.get(0).getSyoriym();

                        if (BizDateUtil.compareYm(jkiAnnaiEndYm,
                            yykidouHennyuYm.addMonths(-1)) == BizDateUtil.COMPARE_GREATER) {

                            jkiAnnaiEndYm = yykidouHennyuYm.addMonths(-1);
                        }
                    }
                    if (BizDateUtil.compareYm(jkiAnnaiEndYm,
                        pSyuharaimanYm.addMonths(-1)) == BizDateUtil.COMPARE_GREATER) {

                        jkiAnnaiEndYm = pSyuharaimanYm.addMonths(-1);
                    }
                    annaitukisuu = BizDateUtil.calcDifferenceMonths(jkiAnnaiEndYm, pJkipjytYm) + 1;
                }
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {
                int annaikkn = BizDateUtil.calcDifferenceMonths(pSyoriYm, pJkipjytYm);

                if (annaikkn < 7) {
                    annaitukisuu = Integer.valueOf(pKykKihon.getTikiktbrisyuruikbn().getValue());
                }
                else {
                    annaitukisuu = Integer.valueOf(pKykKihon.getTikiktbrisyuruikbn().getValue()) * 2;
                }
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {
                annaitukisuu = Integer.valueOf(pKykKihon.getTikiktbrisyuruikbn().getValue());
            }
        }
        else if (C_Hrkkaisuu.HALFY.eq(pKykKihon.getHrkkaisuu())) {
            int annaikkn = BizDateUtil.calcDifferenceMonths(pSyoriYm, pJkipjytYm);

            if (annaikkn < 7) {
                annaitukisuu = Integer.valueOf(pKykKihon.getHrkkaisuu().getValue());
            }
            else {
                annaitukisuu = Integer.valueOf(pKykKihon.getHrkkaisuu().getValue()) * 2;
            }
        }
        else if (C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())) {
            annaitukisuu = 0;
        }

        return annaitukisuu;
    }

    private int keisanAnnaiNensuu(IT_KykKihon pKykKihon){

        int annnaiNennsuu = 0;

        if (C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())) {
            annnaiNennsuu = 1;
        }

        return annnaiNennsuu;
    }

    private int keisanMisyuuTukisuu(IT_KykKihon pKykKihon,BizDateYM pSyoriYm,
        BizDateYM pJkipjytYm, BizDateYM pSyuharaimanYm) {

        int misyuuTukisuu = 0;

        if (C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu())) {
            if (C_TkiktbrisyuruiKbn.NONE.eq(pKykKihon.getTikiktbrisyuruikbn()) ||
                C_TkiktbrisyuruiKbn.BLNK.eq(pKykKihon.getTikiktbrisyuruikbn())) {
                if (BizDateUtil.compareYm(pSyuharaimanYm,pSyoriYm) == BizDateUtil.COMPARE_LESSER) {

                    misyuuTukisuu = BizDateUtil.calcDifferenceMonths(pSyuharaimanYm, pJkipjytYm);
                }
                else {

                    misyuuTukisuu = BizDateUtil.calcDifferenceMonths(pSyoriYm, pJkipjytYm);
                }
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {
                int misyuuKikan = BizDateUtil.calcDifferenceMonths(pSyoriYm, pJkipjytYm);

                if (misyuuKikan < 7) {
                    misyuuTukisuu = Integer.valueOf(pKykKihon.getTikiktbrisyuruikbn().getValue());
                }
                else {
                    misyuuTukisuu = Integer.valueOf(pKykKihon.getTikiktbrisyuruikbn().getValue()) * 2;
                }
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {
                misyuuTukisuu = Integer.valueOf(pKykKihon.getTikiktbrisyuruikbn().getValue());
            }
        }
        else if (C_Hrkkaisuu.HALFY.eq(pKykKihon.getHrkkaisuu())) {
            int misyuuKikan = BizDateUtil.calcDifferenceMonths(pSyoriYm, pJkipjytYm);

            if (misyuuKikan < 7) {
                misyuuTukisuu = Integer.valueOf(pKykKihon.getHrkkaisuu().getValue());
            }
            else {
                misyuuTukisuu = Integer.valueOf(pKykKihon.getHrkkaisuu().getValue()) * 2;
            }
        }
        else if (C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())) {
            misyuuTukisuu = 0;
        }

        return misyuuTukisuu;
    }

    private int keisanMisyuuNensuu(IT_KykKihon pKykKihon){

        int misyuuNennsuu = 0;

        if (C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())) {
            misyuuNennsuu = 1;
        }

        return misyuuNennsuu;
    }

}
