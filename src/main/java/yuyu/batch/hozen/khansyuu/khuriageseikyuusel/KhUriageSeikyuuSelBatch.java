package yuyu.batch.hozen.khansyuu.khuriageseikyuusel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khuriageseikyuusel.dba.AnnaiSyuunouDataBean;
import yuyu.batch.hozen.khansyuu.khuriageseikyuusel.dba.KhUriageSeikyuuSelDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.ascommon.KeisanRsgkUtiwakeBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CreditUriageSeikyuuDataSks;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.UriageSeikyuuDataSksParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;

/**
 * 契約保全 案内収納 売上請求データ抽出
 */
public class KhUriageSeikyuuSelBatch implements Batch {

    private static final String TABLEID = IT_AnsyuKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    private static final String YUUYOKKNGAI = "1";

    private static final String YUUKOUKKNNNASI = "2";

    private static final String TAISYOUGETUMISS = "3";

    private static final String TOKUSINARI = "4";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhUriageSeikyuuSelBatchParam khUriageSeikyuuSelBatchParam;

    @Inject
    private KhUriageSeikyuuSelDao khUriageSeikyuuSelDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    private String kinouID;

    private String userID;

    private String sysDateTime;

    @Override
    public BatchParam getParam() {
        return khUriageSeikyuuSelBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khUriageSeikyuuSelBatchParam.getSyoriYmd();

        String kakutyoujobCd = khUriageSeikyuuSelBatchParam.getIbKakutyoujobcd();

        String heisoukbn = khUriageSeikyuuSelBatchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        kinouID = khozenCommonParam.getFunctionId();
        userID = khozenCommonParam.getUserID();
        sysDateTime = BizDate.getSysDateTimeMilli();
        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        Integer dataKensuu = 0;
        C_UmuKbn errorFlag = C_UmuKbn.NONE;
        Integer missListCount = 0;
        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);
        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
        List<EditKhMisslstParam> editKhMisslstParamList = new ArrayList<>();
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        setCreditUriageSeikyuubi.exec(syoriYmd);

        BizDate uriageSeikyuubi = setCreditUriageSeikyuubi.getJikaiUrskbi();

        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(100);

        try (ExDBResults<AnnaiSyuunouDataBean> annaiSyuunouDataBeanList =
            khUriageSeikyuuSelDao.getAnnaiSyuunouDataBean(kakutyoujobCd, syoriYm, heisoukbn);
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

            for (AnnaiSyuunouDataBean annaiSyuunouDataBean : annaiSyuunouDataBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(annaiSyuunouDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(annaiSyuunouDataBean.getSyono());

                dataKensuu = dataKensuu + 1;

                BizDateYM annaiKaisiYm = annaiSyuunouDataBean.getJkipjytym();
                BizDateYM jkipjytYmYkgt = annaiKaisiYm.getNextMonth();
                BizDateYM jkipjytYmYkykgt = jkipjytYmYkgt.getNextMonth();
                BizDateYM jkipjytYmYkykykgt = jkipjytYmYkykgt.getNextMonth();
                Integer annaiRecordCnt = 1;
                BizDateYM syuharaimanymdYm = annaiSyuunouDataBean.getSyuharaimanymd().getBizDateYM();
                C_TokusinKbn tokusinKbn = C_TokusinKbn.BLNK;
                BizDateYM egybHsmeTksnEndYm = null;
                BizDateYM hennyuYm = null;

                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);

                checkYuukouJyoutaiParam.setSyono(annaiSyuunouDataBean.getSyono());

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                    continue;
                }

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(annaiSyuunouDataBean.getSyono());

                IT_Tokusin tokusin = ansyuKihon.getTokusin();

                if (tokusin != null) {

                    tokusinKbn = tokusin.getTokusinkbn();
                    BizDate tokusinEndYmd = tokusin.getTokusinendymd();

                    if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {

                        BizDate tokusinEndYmMatuYmd = BizDate.valueOf(tokusinEndYmd.getBizDateYM(), 31).getRekijyou();

                        if (BizDateUtil.compareYmd(tokusinEndYmd, tokusinEndYmMatuYmd) == BizDateUtil.COMPARE_EQUAL) {

                            egybHsmeTksnEndYm = tokusinEndYmd.getBizDateYM();
                        }
                        else {

                            egybHsmeTksnEndYm = tokusinEndYmd.getBizDateYM().getPreviousMonth();
                        }
                    }
                }

                C_UmuKbn annaitsUmuKbn = C_UmuKbn.ARI;
                String uriagesktsErrSyuruiKbn = "";

                boolean syoriKekka = checkYuuyokkngai.exec(annaiSyuunouDataBean.getSyono(), uriageSeikyuubi);

                if (!syoriKekka) {

                    annaitsUmuKbn = C_UmuKbn.NONE;
                    uriagesktsErrSyuruiKbn = YUUYOKKNGAI;
                }

                if (C_UmuKbn.ARI.eq(annaitsUmuKbn) && BizDateUtil.compareYm(
                    annaiSyuunouDataBean.getCredityuukoukakym(), syoriYm) == BizDateUtil.COMPARE_LESSER) {

                    annaitsUmuKbn = C_UmuKbn.NONE;
                    uriagesktsErrSyuruiKbn = YUUKOUKKNNNASI;
                }

                if (C_UmuKbn.ARI.eq(annaitsUmuKbn)) {

                    if (tokusin == null) {

                        if (BizDateUtil.compareYm(jkipjytYmYkykgt, syoriYm) == BizDateUtil.COMPARE_LESSER) {

                            annaitsUmuKbn = C_UmuKbn.NONE;
                            uriagesktsErrSyuruiKbn = TAISYOUGETUMISS;
                        }
                    }
                    else if (C_TokusinKbn.OTHER.eq(tokusinKbn)) {

                        if (BizDateUtil.compareYm(jkipjytYmYkykykgt, syoriYm) == BizDateUtil.COMPARE_LESSER) {

                            annaitsUmuKbn = C_UmuKbn.NONE;
                            uriagesktsErrSyuruiKbn = TAISYOUGETUMISS;
                        }
                    }

                    else if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn) &&
                        BizDateUtil.compareYm(egybHsmeTksnEndYm, syoriYm) == BizDateUtil.COMPARE_EQUAL) {

                        if (BizDateUtil.compareYm(annaiKaisiYm.addMonths(11),
                            syoriYm.getPreviousMonth()) == BizDateUtil.COMPARE_LESSER) {

                            annaitsUmuKbn = C_UmuKbn.NONE;
                            uriagesktsErrSyuruiKbn = TAISYOUGETUMISS;
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(annaitsUmuKbn) && C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {

                    if (BizDateUtil.compareYm(egybHsmeTksnEndYm, syoriYm) == BizDateUtil.COMPARE_LESSER) {

                        annaitsUmuKbn = C_UmuKbn.NONE;
                        uriagesktsErrSyuruiKbn = TOKUSINARI;
                    }
                }

                if (C_UmuKbn.NONE.eq(annaitsUmuKbn)) {

                    missListCount = missListCount + 1;
                    String message = "";

                    if (uriagesktsErrSyuruiKbn.equals(YUUYOKKNGAI)) {

                        message = MessageUtil.getMessage(MessageId.EIF3049);
                    }

                    else if (uriagesktsErrSyuruiKbn.equals(YUUKOUKKNNNASI)) {

                        message = MessageUtil.getMessage(MessageId.EIF3050);
                    }

                    else if (uriagesktsErrSyuruiKbn.equals(TAISYOUGETUMISS)) {

                        message = MessageUtil.getMessage(MessageId.EIF3051);
                    }

                    else if (uriagesktsErrSyuruiKbn.equals(TOKUSINARI)) {

                        message = MessageUtil.getMessage(MessageId.EIF3052);
                    }

                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

                    editKhMisslstParam.setDataNo(missListCount);
                    editKhMisslstParam.setSeqNo(missListCount);
                    editKhMisslstParam.setMisslistMsg(message);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(annaiSyuunouDataBean.getSyono());

                    editKhMisslstParamList.add(editKhMisslstParam);

                    errorFlag = C_UmuKbn.ARI;

                    continue;
                }

                C_YouhiKbn annaiSeigyoYouhiKbn = C_YouhiKbn.HUYOU;

                if (!C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {

                    IT_YykIdouUktk yykIdouUktk = khUriageSeikyuuSelDao.getYykIdouUktk(
                        annaiSyuunouDataBean.getSyono(), syoriYm);

                    if (yykIdouUktk != null) {

                        annaiSeigyoYouhiKbn = C_YouhiKbn.YOU;
                        hennyuYm = yykIdouUktk.getSyoriym();
                    }
                }

                Integer recordSakuseiTani = 1;
                BizDateYM annaiEndYm = null;

                if (!C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {

                    if (BizDateUtil.compareYm(syuharaimanymdYm, syoriYm) == BizDateUtil.COMPARE_LESSER) {

                        annaiEndYm = syuharaimanymdYm;
                    }
                    else {

                        annaiEndYm = syoriYm;
                    }
                }
                else {

                    if (BizDateUtil.compareYm(syoriYm, egybHsmeTksnEndYm) == BizDateUtil.COMPARE_EQUAL) {

                        if (BizDateUtil.compareYm(syuharaimanymdYm, egybHsmeTksnEndYm) == BizDateUtil.COMPARE_LESSER) {

                            annaiEndYm = syuharaimanymdYm.getPreviousMonth();
                        }
                        else {

                            annaiEndYm = egybHsmeTksnEndYm.getPreviousMonth();
                        }

                        recordSakuseiTani = 99;
                    }
                    else {

                        annaiEndYm = annaiKaisiYm;
                    }
                }

                if (C_YouhiKbn.YOU.eq(annaiSeigyoYouhiKbn)) {

                    if (BizDateUtil.compareYm(hennyuYm.getPreviousMonth(), annaiEndYm) == BizDateUtil.COMPARE_LESSER) {

                        annaiEndYm = hennyuYm.getPreviousMonth();
                    }
                }

                if (BizDateUtil.compareYm(annaiEndYm, annaiKaisiYm) == BizDateUtil.COMPARE_LESSER) {

                    missListCount = missListCount + 1;
                    String message = MessageUtil.getMessage(MessageId.EIF3061);

                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

                    editKhMisslstParam.setDataNo(missListCount);
                    editKhMisslstParam.setSeqNo(missListCount);
                    editKhMisslstParam.setMisslistMsg(message);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(annaiSyuunouDataBean.getSyono());

                    editKhMisslstParamList.add(editKhMisslstParam);

                    errorFlag = C_UmuKbn.ARI;

                    continue;

                }

                int annaiGetusuu = BizDateUtil.calcDifferenceMonths(annaiEndYm, annaiKaisiYm) + 1;

                if (recordSakuseiTani == 99) {

                    annaiRecordCnt = 1;
                }
                else {

                    annaiRecordCnt = annaiGetusuu / recordSakuseiTani;
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(annaiSyuunouDataBean.getSyono());

                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                C_ErrorKbn errorKbn = keisanRsgaku.exec(
                    kykKihon,
                    C_Nykkeiro.CREDIT,
                    C_NyknaiyouKbn.KEIZOKUP,
                    uriageSeikyuubi,
                    annaiKaisiYm,
                    0,
                    annaiGetusuu);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String message = MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu());

                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(annaiSyuunouDataBean.getSyono(), message);

                    kykKihon.detach();
                    ansyuKihon.detach();

                    continue;
                }

                KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst();
                Iterator<KeisanRsgkUtiwakeBean> iterator = keisanRsgkUtiwakeBeanList.iterator();

                for (int i = 0; i < annaiRecordCnt; i++) {

                    AnnaiNaiyouMergeBean annaiNaiyouMergeBean = null;

                    for (int j = 0; j < recordSakuseiTani; j++) {

                        if (!iterator.hasNext()) {

                            break;
                        }

                        KeisanRsgkUtiwakeBean annaiHokenryouUtiwake = iterator.next();

                        if (annaiNaiyouMergeBean == null) {
                            annaiNaiyouMergeBean = SWAKInjector.getInstance(AnnaiNaiyouMergeBean.class);
                            annaiNaiyouMergeBean.setJyutouym(annaiHokenryouUtiwake.getJyutoustartym());
                            annaiNaiyouMergeBean.setRyosyukwsratekjymd(annaiHokenryouUtiwake.getRyosyukwsratekjymd());
                            annaiNaiyouMergeBean.setRyosyukwsrate(annaiHokenryouUtiwake.getRyosyukwsrate());
                            annaiNaiyouMergeBean.setAnnaigk(annaiHokenryouUtiwake.getRsgaku());
                            annaiNaiyouMergeBean.setIktwaribikikgk(annaiHokenryouUtiwake.getIktwaribikikgk());
                            annaiNaiyouMergeBean.setJyutoukaisuum(annaiHokenryouUtiwake.getJyuutoutukisuu());
                            annaiNaiyouMergeBean.setJyutoukaisuuy(annaiHokenryouUtiwake.getJyuutounensuu());
                        }
                        else {
                            annaiNaiyouMergeBean.setAnnaigk(annaiNaiyouMergeBean.getAnnaigk().add(annaiHokenryouUtiwake.getRsgaku()));
                            annaiNaiyouMergeBean.setIktwaribikikgk(annaiNaiyouMergeBean.getIktwaribikikgk().add(annaiHokenryouUtiwake.getIktwaribikikgk()));
                            annaiNaiyouMergeBean.setJyutoukaisuum(annaiNaiyouMergeBean.getJyutoukaisuum() + annaiHokenryouUtiwake.getJyuutoutukisuu());
                            annaiNaiyouMergeBean.setJyutoukaisuuy(annaiNaiyouMergeBean.getJyutoukaisuuy() + annaiHokenryouUtiwake.getJyuutounensuu());
                        }
                    }

                    editDatabase(khozenCommonParam, annaiSyuunouDataBean, annaiNaiyouMergeBean, syoriYmd,
                        uriageSeikyuubi, kykKihon, ansyuKihon);
                }

                multipleEntityUpdater.add(kykKihon);

                multipleEntityUpdater.add(ansyuKihon);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (C_UmuKbn.ARI.eq(errorFlag)) {

            EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);

            createReport.execNoCommit(editKhMisslstTbl.editBean(C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU, khozenCommonParam,
                editKhMisslstParamList, syoriYmd));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(dataKensuu)));
        }

        else {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(dataKensuu)));
        }

        boolean hasMisslistMsgUmu = ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg();

        if (hasMisslistMsgUmu) {

            ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYmd);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisoukbn));
    }

    private void editDatabase(KhozenCommonParam pKhozenCommonParam, AnnaiSyuunouDataBean pAnnaiSyuunouDataBean,
        AnnaiNaiyouMergeBean pAnnaiNaiyouMergeBean, BizDate pSyoriYmd, BizDate pUriageSeikyuubi,
        IT_KykKihon pKykKihon, IT_AnsyuKihon pAnsyuKihon) {

        Integer annaiNoMax = khUriageSeikyuuSelDao.getAnsyuRirekiMaxAnnaino(pAnnaiSyuunouDataBean.getSyono(),
            pAnnaiNaiyouMergeBean.getJyutouym());

        if (annaiNoMax == null) {

            annaiNoMax = 1;
        }
        else {

            annaiNoMax = annaiNoMax + 1;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        IT_AnsyuRireki ansyuRireki = pAnsyuKihon.createAnsyuRireki();

        ansyuRireki.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        ansyuRireki.setJyuutouym(pAnnaiNaiyouMergeBean.getJyutouym());
        ansyuRireki.setAnnaino(annaiNoMax);
        ansyuRireki.setNykkeiro(C_Nykkeiro.CREDIT);
        ansyuRireki.setJyutoukaisuuy(pAnnaiNaiyouMergeBean.getJyutoukaisuuy());
        ansyuRireki.setJyutoukaisuum(pAnnaiNaiyouMergeBean.getJyutoukaisuum());
        ansyuRireki.setRsgaku(pAnnaiNaiyouMergeBean.getAnnaigk());
        ansyuRireki.setRstuukasyu(henkanTuuka.henkanTuukaTypeToKbn(pAnnaiNaiyouMergeBean.getAnnaigk().getType()));
        ansyuRireki.setRyosyukwsratekjymd(pAnnaiNaiyouMergeBean.getRyosyukwsratekjymd());
        ansyuRireki.setRyosyukwsrate(pAnnaiNaiyouMergeBean.getRyosyukwsrate());
        ansyuRireki.setHrkp(pAnnaiSyuunouDataBean.getHrkp());
        ansyuRireki.setIktwaribikikgk(pAnnaiNaiyouMergeBean.getIktwaribikikgk());
        ansyuRireki.setAnnaijkkbn(C_AnnaijkKbn.ANNAI);
        ansyuRireki.setAnnaisakuseiymd(pSyoriYmd);
        ansyuRireki.setUriageymdkon(pUriageSeikyuubi);
        ansyuRireki.setHrkkeiro(pAnnaiSyuunouDataBean.getHrkkeiro());
        ansyuRireki.setHrkkaisuu(pAnnaiSyuunouDataBean.getHrkkaisuu());
        ansyuRireki.setJkipjytym(pAnnaiSyuunouDataBean.getJkipjytym());
        ansyuRireki.setTikiktbrisyuruikbn(pAnnaiSyuunouDataBean.getTikiktbrisyuruikbn());
        ansyuRireki.setMinyutuutizumiflg(C_Skszumiflg.MISAKUSEI);
        ansyuRireki.setCreditkessaiyouno(pAnnaiSyuunouDataBean.getCreditkessaiyouno());
        ansyuRireki.setGyoumuKousinKinou(kinouID);
        ansyuRireki.setGyoumuKousinsyaId(userID);
        ansyuRireki.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(ansyuRireki);

        UriageSeikyuuDataSksParam uriageSeikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
        CreditUriageSeikyuuDataSks creditUriageSeikyuuDataSks = SWAKInjector.getInstance(CreditUriageSeikyuuDataSks.class);

        uriageSeikyuuDataSksParam.setKessaiyouno(pAnnaiSyuunouDataBean.getCreditkessaiyouno());
        uriageSeikyuuDataSksParam.setUriagenengappi(pUriageSeikyuubi);
        uriageSeikyuuDataSksParam.setSyoriYmd(pSyoriYmd);
        uriageSeikyuuDataSksParam.setUriagegk(pAnnaiNaiyouMergeBean.getAnnaigk());
        uriageSeikyuuDataSksParam.setAnsyuRirekiTblentity(ansyuRireki);
        uriageSeikyuuDataSksParam.setAnsyuKihonTblentity(pAnsyuKihon);

        creditUriageSeikyuuDataSks.editTuujyouUriageData(pKhozenCommonParam, uriageSeikyuuDataSksParam);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
