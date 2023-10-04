package yuyu.batch.hozen.khansyuu.khnyuukin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khnyuukin.dba.IT_TRNyuukinBean;
import yuyu.batch.hozen.khansyuu.khnyuukin.dba.KhNyuukinDao;
import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.khcommon.AnsyuuEditKhHenkouRirekiTbl;
import yuyu.common.hozen.khcommon.CommonNyuukin;
import yuyu.common.hozen.khcommon.EditKhHenkouRirekiTblForNyuukinBean;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.NyuukinTRParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakusei;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakuseiBean;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_CommonNyuukinErrorRiyuuKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TRNyuukin;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 入金処理
 */
public class KhNyuukinBatch implements Batch {

    private static final String TABLEID = IT_TRNyuukin.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhNyuukinBatchParam khNyuukinBatchParam;

    @Inject
    private KhNyuukinDao khNyuukinDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return khNyuukinBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kakutyoujobCd = khNyuukinBatchParam.getIbKakutyoujobcd();
        BizDate syoriYMD = khNyuukinBatchParam.getSyoriYmd();
        String heisoukbn = khNyuukinBatchParam.getHeisoukbn();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYMD)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, String.valueOf(heisoukbn)));

        C_UmuKbn umuKbn = C_UmuKbn.NONE;
        int syoriKensuu = 0;
        int miLstSeqNo = 0;
        List<EditKhMisslstParam> editKhMisslstParamLst = new ArrayList<>();
        Set<String> syoriHunoPkykSet = new HashSet<String>();
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(100);
        ansyuuBatSyoriHunoKykMisslistSks.setPageLimit(3);

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);
        BizDate zennDenSimebi = setDenSimebi.exec(syoriYMD);

        try (
            ExDBResults<IT_TRNyuukinBean> tRNyuukinBeanLst = khNyuukinDao.getTRNyuukin(kakutyoujobCd, heisoukbn);
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            EntityDeleter<IT_TRNyuukin> entityDeleter = new EntityDeleter<>();) {

            for (IT_TRNyuukinBean dataBean : tRNyuukinBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dataBean.getSyono());

                syoriKensuu = syoriKensuu + 1;

                if (syoriHunoPkykSet.contains(dataBean.getSyono())) {

                    continue;
                }

                C_YouhiKbn nyuukinKakusyouSakuseiYh = null;

                IT_KykKihon kykKihon = khNyuukinDao.getKykKihon(dataBean.getSyono());
                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

                IT_AnsyuKihon ansyuKihon = khNyuukinDao.getAnsyuKihon(dataBean.getSyono());
                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                khozenCommonParam.setSikibetuKey(null);
                String sikibetuKey = khozenCommonParam.getSikibetuKey(dataBean.getSyono());

                IT_KykSyouhn kykSyouhn = null;
                C_Kykjyoutai hnkmKykjyoutai = null;
                IT_Tokusin syoriMaeTokusin = null;
                IT_AnsyuKihon syoriMaeAnsyuKihon = null;
                IT_KykSyouhn syoriMaeKykSyouhn = null;

                if (kykKihon != null) {
                    List<IT_KykSyouhn> kykSyouhnList = khozenCommonParam.getKeiyakuSyouhin(dataBean.getSyono(), C_SyutkKbn.SYU);

                    kykSyouhn = kykSyouhnList.get(0);

                    hnkmKykjyoutai = kykSyouhn.getKykjyoutai();

                    IT_Tokusin tokusin = khozenCommonParam.getTokusin(dataBean.getSyono());

                    if (tokusin != null) {
                        syoriMaeTokusin = BizEntityUtil.copyEntity(tokusin);
                    }

                    syoriMaeAnsyuKihon = BizEntityUtil.copyEntity(khozenCommonParam.getBatchAnsyuKihon());

                    syoriMaeKykSyouhn = BizEntityUtil.copyEntity(kykSyouhn);
                }

                NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
                nyuukinTRParam.setSyoNo(dataBean.getSyono());
                nyuukinTRParam.setSyoriYmd(syoriYMD);
                nyuukinTRParam.setNyuukinKakusyounrkYmd(dataBean.getSyoriYmd());
                nyuukinTRParam.setNykKeiro(dataBean.getNykkeiro());
                nyuukinTRParam.setHrkkaisuu(dataBean.getHrkkaisuu());
                nyuukinTRParam.setNykNaiyouKbn(dataBean.getNyknaiyoukbn());
                nyuukinTRParam.setIktnyuukinnumu(dataBean.getIktnyuukinnumu());
                nyuukinTRParam.setJyutouYm(dataBean.getJyuutouym());
                nyuukinTRParam.setJyutouKaisuuY(dataBean.getJyutoukaisuuy().toString());
                nyuukinTRParam.setJyutouKaisuuM(dataBean.getJyutoukaisuum().toString());
                nyuukinTRParam.setRyosyuGk(dataBean.getRsgaku());
                nyuukinTRParam.setRyosyuYmd(dataBean.getRyosyuymd());

                if (C_Nykkeiro.KZHRK.eq(dataBean.getNykkeiro())) {
                    nyuukinTRParam.setKzHurikaeBankCd(dataBean.getKzhurikaebankcd());
                    nyuukinTRParam.setKzHurikaeSitenCd(dataBean.getKzhurikaesitencd());
                }

                nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
                nyuukinTRParam.setZengetumatuDenSimeYmd(zennDenSimebi);

                if (C_Nykkeiro.KYHKIN.eq(dataBean.getNykkeiro()) || C_Nykkeiro.HKNKIN.eq(dataBean.getNykkeiro())) {
                    nyuukinKakusyouSakuseiYh = C_YouhiKbn.HUYOU;
                    nyuukinTRParam.setDenymd(dataBean.getNykdenymd());
                    nyuukinTRParam.setNyknkwsratekijyunymd(dataBean.getNyknkwsratekijyunymd());
                }
                else {
                    nyuukinKakusyouSakuseiYh = C_YouhiKbn.YOU;
                }
                nyuukinTRParam.setTkiktbrisyuruiKbn(dataBean.getTkiktbrisyuruiKbn());

                if(C_Nykkeiro.CREDIT.eq(dataBean.getNykkeiro())){
                    nyuukinTRParam.setCreditkessaiyouno(dataBean.getCreditkessaiyouno());
                }

                nyuukinTRParam.setSyuudaikocd(dataBean.getSyuudaikocd());
                nyuukinTRParam.setCreditUriageSeikyuuKbn(dataBean.getCredituriageseikyuukbn());

                CommonNyuukin commonNyuukin = SWAKInjector.getInstance(CommonNyuukin.class);
                commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, nyuukinKakusyouSakuseiYh, ansyuuBatSyoriHunoKykMisslistSks);

                C_ErrorKbn errorKbn = commonNyuukin.getErrorKbn();
                C_CommonNyuukinErrorRiyuuKbn commonNyuukinErrorRiyuuKbn = commonNyuukin.getCommonNyuukinErrorRiyuuKbn();

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    if (C_CommonNyuukinErrorRiyuuKbn.KYKHUZAIERROR.eq(commonNyuukinErrorRiyuuKbn)) {

                        umuKbn = C_UmuKbn.ARI;
                        miLstSeqNo = miLstSeqNo + 1;
                        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
                        editKhMisslstParam.setDataNo(syoriKensuu);
                        editKhMisslstParam.setSeqNo(miLstSeqNo);
                        editKhMisslstParam.setMisslistMsg(MessageUtil.getMessage(MessageId.EIF0025,
                            dataBean.getNykkeiro().getContent(C_Nykkeiro.PATTERN_DISP), dataBean.getNyknaiyoukbn().getContent(),
                            dataBean.getRyosyuymd().toString()));
                        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                        editKhMisslstParam.setSyoNo(dataBean.getSyono());

                        editKhMisslstParamLst.add(editKhMisslstParam);
                    }
                    else if (C_CommonNyuukinErrorRiyuuKbn.SYORIHUNOERROR.eq(commonNyuukinErrorRiyuuKbn)) {

                        syoriHunoPkykSet.add(dataBean.getSyono());

                        continue;
                    }
                }

                BT_TjtIdouNyKh tjtIdouNyKh = null;

                if (commonNyuukin.getKykKihon() != null && !hnkmKykjyoutai.eq(kykSyouhn.getKykjyoutai())) {
                    PALKykNaiyouSakusei pALKykNaiyouSakusei = SWAKInjector.getInstance(PALKykNaiyouSakusei.class);
                    PALKykNaiyouSakuseiBean pALKykNaiyouSakuseiBean = SWAKInjector.getInstance(PALKykNaiyouSakuseiBean.class);

                    pALKykNaiyouSakuseiBean.setKykKihon(commonNyuukin.getKykKihon());

                    C_ErrorKbn errorKbnPAL = pALKykNaiyouSakusei.exec(pALKykNaiyouSakuseiBean);

                    tjtIdouNyKh = pALKykNaiyouSakusei.getTjtIdouNyKh();

                    if (C_ErrorKbn.ERROR.eq(errorKbnPAL)) {
                        throw new CommonBizAppException("当日異動内容契約保全テーブルの作成に失敗しました。");
                    }
                }

                IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();

                if (commonNyuukin.getKykKihon() != null) {
                    khTtdkRireki = khNyuukinDao.createKhTtdkRireki(kykKihon);
                    khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(dataBean.getSyono());
                    editTtdkRirekiTblParam.setSyoriYmd(syoriYMD);
                    editTtdkRirekiTblParam.setSysTime(sysDateTime);
                    editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);

                    if (C_KrkriyuuKbn.BLNK.eq(commonNyuukin.getKrkRiyuuKbn())) {
                        editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.BLNK);
                    } else {
                        C_SyoriKbn syoriKbn;
                        if (commonNyuukin.getJidonhnknumu()) {
                            syoriKbn = C_SyoriKbn.JIDOUHNKN;
                        } else {
                            syoriKbn = C_SyoriKbn.KRKKEIJYOU;
                        }
                        editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
                    }
                    editTtdkRirekiTblParam.setNyuukinKakusyouData(commonNyuukin.getNyuukinKakusyouData());

                    EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                }

                if (commonNyuukin.getKykKihon() != null && !C_KrkriyuuKbn.BLNK.eq(commonNyuukin.getKrkRiyuuKbn())) {
                    khTtdkRireki.setHenkourrkumu(C_UmuKbn.ARI);

                    AnsyuuEditKhHenkouRirekiTbl ansyuuEditKhHenkouRirekiTbl =
                        SWAKInjector.getInstance(AnsyuuEditKhHenkouRirekiTbl.class);

                    EditKhHenkouRirekiTblForNyuukinBean editKhHenkouRirekiTblForNyuukinBean =
                        SWAKInjector.getInstance(EditKhHenkouRirekiTblForNyuukinBean.class);

                    editKhHenkouRirekiTblForNyuukinBean.setHenkouSikibetuKey(sikibetuKey);
                    editKhHenkouRirekiTblForNyuukinBean.setKykKihonSyoriAto(commonNyuukin.getKykKihon());
                    editKhHenkouRirekiTblForNyuukinBean.setAnsyuKihonSyoriAto(commonNyuukin.getAnsyuKihon());
                    editKhHenkouRirekiTblForNyuukinBean.setNyuukinKakusyouDataSyoriAto(commonNyuukin.getNyuukinKakusyouData());
                    editKhHenkouRirekiTblForNyuukinBean.setAnsyuKihonSyoriMae(syoriMaeAnsyuKihon);
                    editKhHenkouRirekiTblForNyuukinBean.setKykSyouhnSyoriMae(syoriMaeKykSyouhn);
                    editKhHenkouRirekiTblForNyuukinBean.setKariukekinSyoriAto(commonNyuukin.getKariukekin());
                    editKhHenkouRirekiTblForNyuukinBean.setTokusinSyoriMae(syoriMaeTokusin);
                    editKhHenkouRirekiTblForNyuukinBean.setSyuunouHenknRirekiSyoriAto(commonNyuukin.getSyuunouHenknRireki());

                    ansyuuEditKhHenkouRirekiTbl.editKhHenkouRirekiTblForNyuukin(editKhHenkouRirekiTblForNyuukinBean);
                }

                if (commonNyuukin.getKykKihon() != null) {
                    khNyuukinDao.addMultipleUpdateEntity(multipleEntityUpdater, khNyuukinDao.getKykKihon(dataBean.getSyono()));
                }
                if (commonNyuukin.getAnsyuKihon() != null) {
                    khNyuukinDao.addMultipleUpdateEntity(multipleEntityUpdater, khNyuukinDao.getAnsyuKihon(dataBean.getSyono()));
                }
                if (commonNyuukin.getKhFBSoukinData() != null) {
                    khNyuukinDao.addMultipleInserterEntity(multipleEntityInserter, commonNyuukin.getKhFBSoukinData());
                }

                for (IT_KhDenpyoData khDenpyoData : commonNyuukin.getKhDenpyoDatas()) {
                    khNyuukinDao.addMultipleInserterEntity(multipleEntityInserter, khDenpyoData);
                }

                if (commonNyuukin.getNyuukinKakusyouData() != null) {
                    khNyuukinDao.addMultipleInserterEntity(multipleEntityInserter,
                        commonNyuukin.getNyuukinKakusyouData());
                }

                if (tjtIdouNyKh != null) {
                    khNyuukinDao.addMultipleInserterEntity(multipleEntityInserter, tjtIdouNyKh);
                }

                entityDeleter.add(khNyuukinDao.getTRNyuukin2(
                    dataBean.getSyono(),
                    dataBean.getSyoriYmd(),
                    dataBean.getNyktrrenno(),
                    dataBean.getDatarenno()));

            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (C_UmuKbn.ARI.eq(umuKbn)) {

            EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);
            ReportServicesBean reportServicesBean = editKhMisslstTbl.editBean(C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU,SWAKInjector.getInstance(KhozenCommonParam.class),editKhMisslstParamLst,syoriYMD);

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
            createReport.execNoCommit(reportServicesBean);

        }

        if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {

            ansyuuBatSyoriHunoKykMisslistSks.createReport(SWAKInjector.getInstance(KhozenCommonParam.class), syoriYMD);
        }

        if (C_UmuKbn.ARI.eq(umuKbn)) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(syoriKensuu)));
        }
        else {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(syoriKensuu)));
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, String.valueOf(heisoukbn)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
