package yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei.dba.KhYuukouseiKekkaHaneiDao;
import yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei.dba.YuukouseiKekkaHaneiDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditCardBrand;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditdataKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.entity.IT_YuukouKakErrorList;
import yuyu.def.db.entity.IT_YuukouKakKekkaKikyk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 契約保全 案内収納 有効性確認結果反映
 */
public class KhYuukouseiKekkaHaneiBatch implements Batch {

    private static final String TABLEID = IT_CreditCardInfo.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhYuukouseiKekkaHaneiBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhYuukouseiKekkaHaneiDao khYuukouseiKekkaHaneiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        long syoriKensu = 0;
        long jimurenrakuKensu = 0;
        String kinouid = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
        SetCreditCardBrand setCreditCardBrand = SWAKInjector.getInstance(SetCreditCardBrand.class);
        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, bzBatchParam.getHeisoukbn()));

        try (ExDBResults<YuukouseiKekkaHaneiDataBean> yuukouseiKekkaHaneiDataBeanList =
            khYuukouseiKekkaHaneiDao.getYuukouseiKekkaHaneiDataBean(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getHeisoukbn());

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

            for (YuukouseiKekkaHaneiDataBean yuukouseiKekkaHaneiDataBean : yuukouseiKekkaHaneiDataBeanList) {

                String syono = yuukouseiKekkaHaneiDataBean.getSyono();
                IT_TRDattai trdattai = null;
                IT_YuukouKakErrorList yuukoukakerrorlist = null;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(yuukouseiKekkaHaneiDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);

                checkYuukouJyoutaiParam.setSyono(syono);

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    checkYuukouJyoutai.detachAllEntities(syono);

                    continue;
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);

                khozenCommonParam.setSikibetuKey(null);

                String henkousikibetukey = khozenCommonParam.getSikibetuKey(syono);

                tableMaintenanceUtil.backUp(syono, henkousikibetukey);
                khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());

                IT_YuukouKakKekkaKikyk yuukouKakKekkaKikyk = hozenDomManager.
                    getYuukouKakKekkaKikyk(yuukouseiKekkaHaneiDataBean.getCreditkessaiyouno());

                setCreditUriageSeikyuubi.exec(bzBatchParam.getSyoriYmd());

                BizDate jikaiUrskbi = setCreditUriageSeikyuubi.getJikaiUrskbi();

                C_Yuukoukakkekka yuukoukakkekka;
                BizDateYM yuukoukakym;

                if (yuukouKakKekkaKikyk == null) {
                    yuukoukakkekka = C_Yuukoukakkekka.YUUKOUKAK_OK;
                    yuukoukakym = jikaiUrskbi.getBizDateYM();
                }
                else {
                    yuukoukakkekka = yuukouKakKekkaKikyk.getCredityuukoukakkekka();
                    yuukoukakym = yuukouKakKekkaKikyk.getCredityuukoukakym();

                    C_CardBrandKbn  cardbrandkbn = setCreditCardBrand.exec(yuukouKakKekkaKikyk.getCreditcardno().substring(0, 6));

                    if (C_Yuukoukakkekka.YUUKOUKAK_NG.eq(yuukoukakkekka)) {
                        trdattai = new IT_TRDattai(syono, bzBatchParam.getSyoriYmd(), sysDateTime + "1");

                        trdattai.setDattaikeiro(C_Dattaikeiro.CREDIT);
                        trdattai.setCreditdatakbn(C_CreditdataKbn.YKKAKUNIN);
                        trdattai.setDattaiym(yuukoukakym);
                        trdattai.setTikiktbrisyuruikbn(yuukouseiKekkaHaneiDataBean.getTkiktbrisyuruikbn());
                        trdattai.setGyoumuKousinKinou(kinouid);
                        trdattai.setGyoumuKousinsyaId(userId);
                        trdattai.setGyoumuKousinTime(sysDateTime);
                        trdattai.setCreditkessaiyouno(yuukouKakKekkaKikyk.getCreditkessaiyouno());
                        trdattai.setCardbrandkbn(cardbrandkbn);
                        trdattai.setCreditkaiinnosimo4keta(yuukouKakKekkaKikyk.getCreditcardno().
                            substring(yuukouKakKekkaKikyk.getCreditcardno().length() - 4));

                        BizPropertyInitializer.initialize(trdattai);
                    }

                    yuukoukakerrorlist = new IT_YuukouKakErrorList();

                    yuukoukakerrorlist.setSyono(syono);
                    yuukoukakerrorlist.setCreditkessaiyouno(yuukouKakKekkaKikyk.getCreditkessaiyouno());
                    yuukoukakerrorlist.setSyoriym(bzBatchParam.getSyoriYmd().getBizDateYM());
                    yuukoukakerrorlist.setCredityuukoukakym(yuukoukakym);
                    yuukoukakerrorlist.setCredityuukoukakkekka(yuukoukakkekka);
                    yuukoukakerrorlist.setGyoumuKousinKinou(kinouid);
                    yuukoukakerrorlist.setGyoumuKousinsyaId(userId);
                    yuukoukakerrorlist.setGyoumuKousinTime(sysDateTime);

                    BizPropertyInitializer.initialize(yuukoukakerrorlist);
                }

                IT_CreditCardInfo creditcardinfo = kykKihon.getCreditCardInfo();

                creditcardinfo.setCredityuukoukakym(yuukoukakym);
                creditcardinfo.setCredityuukoukakkekka(yuukoukakkekka);
                creditcardinfo.setGyoumuKousinKinou(kinouid);
                creditcardinfo.setGyoumuKousinsyaId(userId);
                creditcardinfo.setGyoumuKousinTime(sysDateTime);

                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(syono);
                editTtdkRirekiTblParam.setSyoriYmd(bzBatchParam.getSyoriYmd());
                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                editTtdkRirekiTblParam.setSysTime(sysDateTime);

                IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                khTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(syono));

                EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
                    boolean checkResult = checkYuuyokkngai.exec(syono, jikaiUrskbi);

                    if (checkResult == false) {
                        List<String> jimuRenrakuHyouMsgList = Lists.newArrayList();

                        jimuRenrakuHyouMsgList.add("Ｐ未入消滅予定契約です。ハンド案内してください。");

                        editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuHyouMsgList);

                        ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(
                            khozenCommonParam,
                            syono,
                            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU,
                            editJimuRenrakusyuunouParam ,
                            bzBatchParam.getSyoriYmd());

                        createReport.execNoCommit(reportServicesBean);

                        jimurenrakuKensu++;
                    }

                }

                multipleEntityUpdater.add(kykKihon);

                if (trdattai != null) {
                    multipleEntityInserter.add(trdattai);
                }
                if (yuukoukakerrorlist != null) {
                    multipleEntityInserter.add(yuukoukakerrorlist);
                }

                if (yuukouKakKekkaKikyk != null) {
                    yuukouKakKekkaKikyk.detach();
                }

                syoriKensu++;

            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(syoriKensu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "事務連絡票",String.valueOf(jimurenrakuKensu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, bzBatchParam.getHeisoukbn()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
