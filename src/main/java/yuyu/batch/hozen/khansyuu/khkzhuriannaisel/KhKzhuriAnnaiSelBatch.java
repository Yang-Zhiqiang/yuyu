package yuyu.batch.hozen.khansyuu.khkzhuriannaisel;

import java.util.ArrayList;
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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkzhuriannaisel.dba.AnnaiSyuuouDataBean;
import yuyu.batch.hozen.khansyuu.khkzhuriannaisel.dba.KhKzhuriAnnaiSelDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.CommonHsigiTksnTkbtAnnai;
import yuyu.common.hozen.ascommon.HanteiHsgTokusinSyurui;
import yuyu.common.hozen.ascommon.HsigiTksnInfoBean;
import yuyu.common.hozen.ascommon.HsigiTksnTkbtAnnaiBean;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.ascommon.KeisanRsgkUtiwakeBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetAnnaibi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.entity.IT_KhKouzahuriAnnaiData;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;

/**
 * 契約保全 案内収納 口座振替案内データ抽出のバッチクラスです。
 */
public class KhKzhuriAnnaiSelBatch implements Batch {

    private static final String TABLEID = IT_AnsyuKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhKzhuriAnnaiSelBatchParam khKzhuriAnnaiSelBatchParam;

    @Inject
    private KhKzhuriAnnaiSelDao khKzhuriAnnaiSelDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    private String kinouID;

    private String userID;

    private String kosTime;

    @Override
    public BatchParam getParam() {
        return khKzhuriAnnaiSelBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = khKzhuriAnnaiSelBatchParam.getSyoriYmd();
        String kakutyouJobCd = khKzhuriAnnaiSelBatchParam.getIbKakutyoujobcd();
        String heisoukbn = khKzhuriAnnaiSelBatchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        kinouID = khozenCommonParam.getFunctionId();
        userID = khozenCommonParam.getUserID();
        kosTime = BizDate.getSysDateTimeMilli();
        AnsyuuBatSyoriHunoKykMisslistSks batSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);

        BizDateYM syoribiYm = syoriYmd.getBizDateYM();
        int dataNo = 0;
        C_UmuKbn errorFlag = C_UmuKbn.NONE;
        int count = 0;
        List<EditKhMisslstParam> misslstPrmLst = new ArrayList<>();
        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);
        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        SetAnnaibi setAnnaibi = SWAKInjector.getInstance(SetAnnaibi.class);

        setHurikaebi.exec(syoriYmd);

        setAnnaibi.exec(syoribiYm);

        BizDate tykgoHurikaeYmd = setHurikaebi.getTyokugoHurikaebi();
        BizDate jikaiAnnaiYmd = setAnnaibi.getTinyuuAnnaibi();

        SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
        batSyoriHunoKykMisslistSks.setErrerLimit(100);

        try (ExDBResults<AnnaiSyuuouDataBean> annaiSyuuouDataBeanLst = khKzhuriAnnaiSelDao.getAnnaiSyuuouDataBean(
            kakutyouJobCd, syoribiYm, heisoukbn);
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            for (AnnaiSyuuouDataBean annaiSyuuouDataBean : annaiSyuuouDataBeanLst) {
                if (annaiSyuuouDataBean == null) {
                    break;
                }

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(annaiSyuuouDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(annaiSyuuouDataBean.getSyono());

                dataNo++;

                BizDateYM annaiTaisyouYm = annaiSyuuouDataBean.getJkipjytym();

                BizDateYM jkipjytYmdNext = annaiSyuuouDataBean.getJkipjytym().addMonths(1);

                BizDateYM jkipjytYmdYokuNext = annaiSyuuouDataBean.getJkipjytym().addMonths(2);

                BizDateYM jkipjytYmdYokuNextNext = annaiSyuuouDataBean.getJkipjytym().addMonths(3);

                C_UmuKbn irecordHeityouFlg = C_UmuKbn.NONE;

                C_UmuKbn record2HeityouFlg = C_UmuKbn.NONE;

                C_YouhiKbn annaiSeigyoYouhiKbn = C_YouhiKbn.HUYOU;

                BizDateYM hennyuYm = null;

                int annaiRecordNum = 1;

                int jyttuKisuu = 0;

                int jyutouNensuu = 0;

                BizDateYM syuHaraimanYm = annaiSyuuouDataBean.getSyuharaimanymd().getBizDateYM();

                C_UmuKbn hsgbnktannaiErrorflg = C_UmuKbn.NONE;

                C_UmuKbn hsgtkbtannaiUmuKbn = C_UmuKbn.NONE;

                C_UmuKbn jyutouTukisuuErrorflg = C_UmuKbn.NONE;

                C_UmuKbn jyutouNensuuErrorflg = C_UmuKbn.NONE;

                C_UmuKbn stAnnaiTukisuuErrorflg = C_UmuKbn.NONE;

                int rskingakuUtiwakeCnt = 0;

                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(annaiSyuuouDataBean.getSyono());

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    continue;
                }

                setYuuyokknmanryobi.exec(annaiSyuuouDataBean.getSyono(), annaiSyuuouDataBean.getJkipjytym());
                BizDate tokusinYuuyokknMnrybi = setYuuyokknmanryobi.getTksnYuuyokknMnrybi();

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(annaiSyuuouDataBean.getSyono());
                IT_Tokusin tokusin = ansyuKihon.getTokusin();

                C_TokusinKbn tokusinKbn = C_TokusinKbn.BLNK;
                BizDateYM tokusinSyoriYm = null;

                if (tokusin != null) {
                    tokusinKbn = tokusin.getTokusinkbn();

                    if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                        if (BizDateUtil.compareYmd(tokusin.getTokusinendymd(),
                            tokusin.getTokusinendymd().getBizDateYM().getLastDay()) == BizDateUtil.COMPARE_EQUAL) {
                            tokusinSyoriYm = tokusin.getTokusinendymd().getBizDateYM();
                        }
                        else {
                            tokusinSyoriYm = tokusin.getTokusinendymd().getBizDateYM().addMonths(-1);
                        }
                    }
                    else {
                        if (BizDateUtil.compareYmd(syoribiYm.getLastDay(), tokusin.getTokusinendymd()) == BizDateUtil.COMPARE_LESSER  &&
                            BizDateUtil.compareYmd(tokusin.getTokusinendymd(), jikaiAnnaiYmd) == BizDateUtil.COMPARE_LESSER) {
                            tokusinSyoriYm = tokusin.getTokusinendymd().getBizDateYM().addMonths(-1);
                        }
                        else {
                            tokusinSyoriYm = tokusin.getTokusinendymd().getBizDateYM();
                        }
                    }
                }

                int annaiTaisyoukkna = 0;

                C_UmuKbn annaiTaisyouUmuKbn = C_UmuKbn.NONE;

                if (BizDateUtil.compareYmd(tykgoHurikaeYmd, tokusinYuuyokknMnrybi) != BizDateUtil.COMPARE_GREATER) {
                    if (tokusin == null) {
                        if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm) == BizDateUtil.COMPARE_EQUAL
                            || BizDateUtil.compareYm(jkipjytYmdNext, syoribiYm) == BizDateUtil.COMPARE_EQUAL
                            || BizDateUtil.compareYm(jkipjytYmdYokuNext, syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                            annaiTaisyouUmuKbn = C_UmuKbn.ARI;
                        }
                    }
                    else {
                        if (C_TokusinKbn.OTHER.eq(tokusinKbn)) {
                            if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                &&(C_TkiktbrisyuruiKbn.NONE.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())
                                    || C_TkiktbrisyuruiKbn.BLNK.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm) != BizDateUtil.COMPARE_GREATER
                                    && BizDateUtil.compareYm(syoribiYm, jkipjytYmdYokuNextNext) != BizDateUtil.COMPARE_GREATER) {
                                    annaiTaisyouUmuKbn = C_UmuKbn.ARI;
                                }
                            }
                            else if (C_Hrkkaisuu.HALFY.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                || (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm)!= BizDateUtil.COMPARE_GREATER
                                    && BizDateUtil.compareYm(syoribiYm, annaiSyuuouDataBean.getJkipjytym().addMonths(5)) != BizDateUtil.COMPARE_GREATER) {
                                    annaiTaisyouUmuKbn = C_UmuKbn.ARI;
                                }
                            }
                            else if (C_Hrkkaisuu.NEN.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                || (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm)!= BizDateUtil.COMPARE_GREATER
                                    && BizDateUtil.compareYm(syoribiYm, annaiSyuuouDataBean.getJkipjytym().addMonths(11)) != BizDateUtil.COMPARE_GREATER) {
                                    annaiTaisyouUmuKbn = C_UmuKbn.ARI;
                                }
                            }
                        }
                        else if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                            annaiTaisyouUmuKbn = C_UmuKbn.ARI;
                        }
                    }
                }

                if (C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {

                    HanteiHsgTokusinSyurui hanteiHsgTokusinSyurui = SWAKInjector.getInstance(HanteiHsgTokusinSyurui.class);

                    HsigiTksnInfoBean hsigiTksnInfoBean = hanteiHsgTokusinSyurui.exec(tokusin.getHsgymd());

                    if (!C_HsigiTkbtTaiouSyuruiKbn.BLNK.eq(hsigiTksnInfoBean.getHsigiTkbtTaiouSyurui())) {

                        IT_HsgbnktAnnaihouhoukanri hsgbnktAnnaihouhoukanri = hozenDomManager.getHsgbnktAnnaihouhoukanri(
                            annaiSyuuouDataBean.getSyono(), tokusin.getHsgymd());

                        if (hsgbnktAnnaihouhoukanri == null) {

                            hsgbnktannaiErrorflg = C_UmuKbn.ARI;
                        }

                        else {
                            if ((BizDateUtil.compareYmd(hsgbnktAnnaihouhoukanri.getBnktannaikaisiymd(), syoriYmd) == BizDateUtil.COMPARE_LESSER ||
                                BizDateUtil.compareYmd(hsgbnktAnnaihouhoukanri.getBnktannaikaisiymd(), syoriYmd) == BizDateUtil.COMPARE_EQUAL) &&
                                (BizDateUtil.compareYmd(syoriYmd, hsgbnktAnnaihouhoukanri.getBnktannaiendymd()) == BizDateUtil.COMPARE_LESSER ||
                                BizDateUtil.compareYmd(syoriYmd, hsgbnktAnnaihouhoukanri.getBnktannaiendymd()) == BizDateUtil.COMPARE_EQUAL)) {

                                hsgtkbtannaiUmuKbn = C_UmuKbn.ARI;

                                CommonHsigiTksnTkbtAnnai commonHsigiTksnTkbtAnnai = SWAKInjector.getInstance(CommonHsigiTksnTkbtAnnai.class);
                                List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanList = commonHsigiTksnTkbtAnnai.exec(
                                    syoribiYm,
                                    syuHaraimanYm,
                                    annaiSyuuouDataBean.getJkipjytym(),
                                    annaiSyuuouDataBean.getHrkkaisuu(),
                                    annaiSyuuouDataBean.getTikiktbrisyuruikbn(),
                                    hsigiTksnInfoBean.getHsigiTkbtTaiouSyurui(),
                                    hsgbnktAnnaihouhoukanri.getBnktannaihouhoukbn(),
                                    hsgbnktAnnaihouhoukanri.getBnktannaiendymd().getBizDateYM());

                                jyttuKisuu = hsigiTksnTkbtAnnaiBeanList.get(0).getJyuutoutukisuu();
                                jyutouNensuu = hsigiTksnTkbtAnnaiBeanList.get(0).getJyuutounensuu();
                                annaiRecordNum = hsigiTksnTkbtAnnaiBeanList.size();

                                if (jyttuKisuu > 12) {
                                    jyutouTukisuuErrorflg = C_UmuKbn.ARI;
                                }
                            }
                        }
                    }
                }

                if (C_UmuKbn.NONE.eq(hsgtkbtannaiUmuKbn)) {

                    if (C_UmuKbn.ARI.eq(annaiTaisyouUmuKbn)) {
                        IT_YykIdouUktk yykIdouUktk = khKzhuriAnnaiSelDao.getYykIdouUktk(annaiSyuuouDataBean.getSyono(),
                            C_YykidousyoriKbn.UKE, syoribiYm);

                        if (yykIdouUktk != null) {
                            if (!C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                                annaiSeigyoYouhiKbn = C_YouhiKbn.YOU;
                                hennyuYm = yykIdouUktk.getSyoriym();
                            }
                        }
                    }

                    if (C_UmuKbn.ARI.eq(annaiTaisyouUmuKbn)) {
                        if (!C_TokusinKbn.HISAIGAI.eq(tokusinKbn)) {
                            if (C_YouhiKbn.HUYOU.eq(annaiSeigyoYouhiKbn)) {
                                if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && (C_TkiktbrisyuruiKbn.NONE.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())
                                        || C_TkiktbrisyuruiKbn.BLNK.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                    if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                                        jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                    }
                                    else if (BizDateUtil.compareYm(jkipjytYmdNext, syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                                        if (BizDateUtil.compareYm(jkipjytYmdNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdNext, syuHaraimanYm) == BizDateUtil.COMPARE_LESSER) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            annaiRecordNum = 2;
                                        }
                                    }
                                    else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                                        if (BizDateUtil.compareYm(jkipjytYmdNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            annaiRecordNum = 2;
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, syuHaraimanYm) == BizDateUtil.COMPARE_LESSER) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            annaiRecordNum = 3;
                                        }
                                    }
                                    else if (C_TokusinKbn.OTHER.eq(tokusinKbn)
                                        && BizDateUtil.compareYmd(syoriYmd, tokusinYuuyokknMnrybi) != BizDateUtil.COMPARE_GREATER
                                        && BizDateUtil.compareYm(jkipjytYmdYokuNextNext, syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                                        if (BizDateUtil.compareYm(jkipjytYmdNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            annaiRecordNum = 2;
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNextNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            annaiRecordNum = 3;
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNextNext, syuHaraimanYm) == BizDateUtil.COMPARE_LESSER) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue()) * 2;
                                            annaiRecordNum = 2;
                                            record2HeityouFlg = C_UmuKbn.ARI;
                                        }
                                    }
                                }
                                else if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())
                                        || C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                    jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getTikiktbrisyuruikbn().getValue());
                                }
                                else if (C_Hrkkaisuu.HALFY.eq(annaiSyuuouDataBean.getHrkkaisuu())) {
                                    jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                }
                                else if (C_Hrkkaisuu.NEN.eq(annaiSyuuouDataBean.getHrkkaisuu())) {
                                    jyutouNensuu = 1;
                                }
                            }
                            else {
                                if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && (C_TkiktbrisyuruiKbn.NONE.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())
                                        || C_TkiktbrisyuruiKbn.BLNK.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                    if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                                        jyttuKisuu = 0;
                                    }
                                    else if (BizDateUtil.compareYm(jkipjytYmdNext, syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                                        if (BizDateUtil.compareYm(jkipjytYmdNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdNext, syuHaraimanYm) == BizDateUtil.COMPARE_LESSER) {
                                            if (BizDateUtil.compareYm(jkipjytYmdNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            }
                                        }
                                    }
                                    else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                                        if (BizDateUtil.compareYm(jkipjytYmdNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            if (BizDateUtil.compareYm(jkipjytYmdNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            }
                                            else if (BizDateUtil.compareYm(jkipjytYmdNext, hennyuYm) == BizDateUtil.COMPARE_LESSER) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                                annaiRecordNum = 2;
                                            }
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, syuHaraimanYm) == BizDateUtil.COMPARE_LESSER) {
                                            if (BizDateUtil.compareYm(jkipjytYmdNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            }
                                            else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                                annaiRecordNum = 2;
                                            }
                                        }
                                    }
                                    else if (C_TokusinKbn.OTHER.eq(tokusinKbn)
                                        && BizDateUtil.compareYmd(syoriYmd, tokusinYuuyokknMnrybi) != BizDateUtil.COMPARE_GREATER
                                        && BizDateUtil.compareYm(jkipjytYmdYokuNextNext, syoribiYm) == BizDateUtil.COMPARE_EQUAL) {
                                        if (BizDateUtil.compareYm(jkipjytYmdNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            if (BizDateUtil.compareYm(jkipjytYmdNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            }
                                            else if (BizDateUtil.compareYm(jkipjytYmdNext, hennyuYm) == BizDateUtil.COMPARE_LESSER) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                                annaiRecordNum = 2;
                                            }
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNextNext, syuHaraimanYm) == BizDateUtil.COMPARE_EQUAL) {
                                            if (BizDateUtil.compareYm(jkipjytYmdNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            }
                                            else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                                annaiRecordNum = 2;
                                            }
                                            else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, hennyuYm) == BizDateUtil.COMPARE_LESSER) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                                annaiRecordNum = 3;
                                            }
                                        }
                                        else if (BizDateUtil.compareYm(jkipjytYmdYokuNextNext, syuHaraimanYm) == BizDateUtil.COMPARE_LESSER) {
                                            if (BizDateUtil.compareYm(jkipjytYmdNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                            }
                                            else if (BizDateUtil.compareYm(jkipjytYmdYokuNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                                annaiRecordNum = 2;
                                            }
                                            else if (BizDateUtil.compareYm(jkipjytYmdYokuNextNext, hennyuYm) == BizDateUtil.COMPARE_EQUAL) {
                                                jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                                annaiRecordNum = 3;
                                            }
                                        }
                                    }
                                }
                                else if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())
                                        || C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                    if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm) == BizDateUtil.COMPARE_EQUAL) {

                                        jyttuKisuu = 0;
                                    }
                                    else {

                                        jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getTikiktbrisyuruikbn().getValue());
                                    }
                                }
                                else if (C_Hrkkaisuu.HALFY.eq(annaiSyuuouDataBean.getHrkkaisuu())) {
                                    if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm) == BizDateUtil.COMPARE_EQUAL) {

                                        jyttuKisuu = 0;
                                    }
                                    else {

                                        jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                    }
                                }
                                else if (C_Hrkkaisuu.NEN.eq(annaiSyuuouDataBean.getHrkkaisuu())) {
                                    if (BizDateUtil.compareYm(annaiSyuuouDataBean.getJkipjytym(), syoribiYm) == BizDateUtil.COMPARE_EQUAL) {

                                        jyutouNensuu = 0;
                                    }
                                    else {

                                        jyutouNensuu = 1;
                                    }
                                }
                            }
                        }
                        else {
                            if (BizDateUtil.compareYm(tokusinSyoriYm, syoribiYm) != BizDateUtil.COMPARE_EQUAL) {
                                if (C_Hrkkaisuu.NEN.eq(annaiSyuuouDataBean.getHrkkaisuu())) {
                                    jyutouNensuu = 1;
                                }
                                else if (C_Hrkkaisuu.HALFY.eq(annaiSyuuouDataBean.getHrkkaisuu()) ||
                                    (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu()) &&
                                        (C_TkiktbrisyuruiKbn.NONE.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()) ||
                                            C_TkiktbrisyuruiKbn.BLNK.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())))) {
                                    jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                }
                                else if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu()) &&
                                    (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()) ||
                                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                    jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getTikiktbrisyuruikbn().getValue());
                                }
                            }
                            else {
                                BizDateYM annaiSaisyuuYm = tokusinSyoriYm.addMonths(-1);
                                if (BizDateUtil.compareYm(annaiSaisyuuYm, syuHaraimanYm.addMonths(-1)) == BizDateUtil.COMPARE_GREATER) {
                                    annaiSaisyuuYm = syuHaraimanYm.addMonths(-1);
                                }
                                annaiTaisyoukkna = BizDateUtil.calcDifferenceMonths(annaiSaisyuuYm, annaiSyuuouDataBean.getJkipjytym()) + 1;

                                if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && (C_TkiktbrisyuruiKbn.NONE.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())
                                        || C_TkiktbrisyuruiKbn.BLNK.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn()))) {
                                    jyttuKisuu = annaiTaisyoukkna;
                                    if (annaiTaisyoukkna >= 2) {
                                        irecordHeityouFlg = C_UmuKbn.ARI;
                                    }
                                }
                                else if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())) {
                                    if (annaiTaisyoukkna <= 6) {
                                        jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getTikiktbrisyuruikbn().getValue());
                                    }
                                    else if (annaiTaisyoukkna <= 12) {
                                        jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getTikiktbrisyuruikbn().getValue()) * 2;
                                        irecordHeityouFlg = C_UmuKbn.ARI;
                                    }
                                    else {
                                        jyttuKisuu = 99;
                                    }
                                }
                                else if (C_Hrkkaisuu.TUKI.eq(annaiSyuuouDataBean.getHrkkaisuu())
                                    && C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())) {
                                    if (annaiTaisyoukkna <= 12) {
                                        jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getTikiktbrisyuruikbn().getValue());
                                    }
                                    else {
                                        jyttuKisuu = 99;
                                    }
                                }
                                else if (C_Hrkkaisuu.HALFY.eq(annaiSyuuouDataBean.getHrkkaisuu())) {

                                    if (annaiTaisyoukkna <= 6) {
                                        jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                                    }
                                    else if (annaiTaisyoukkna <= 12) {
                                        jyttuKisuu = Integer.parseInt(annaiSyuuouDataBean.getHrkkaisuu().getValue()) * 2;
                                        irecordHeityouFlg =  C_UmuKbn.ARI;
                                    }
                                    else {
                                        jyttuKisuu = 99;
                                    }
                                }
                                else if (C_Hrkkaisuu.NEN.eq(annaiSyuuouDataBean.getHrkkaisuu())) {
                                    if (annaiTaisyoukkna <= 12) {
                                        jyutouNensuu = 1;
                                    }
                                    else {
                                        jyutouNensuu = 2;
                                    }
                                }
                            }
                        }

                        if (jyttuKisuu > 12) {
                            jyutouTukisuuErrorflg = C_UmuKbn.ARI;
                        }

                        if (jyutouNensuu > 1) {
                            jyutouNensuuErrorflg = C_UmuKbn.ARI;
                        }

                        if (jyutouNensuu <= 0 && jyttuKisuu <= 0) {
                            stAnnaiTukisuuErrorflg = C_UmuKbn.ARI;
                        }
                    }
                }

                if(C_UmuKbn.NONE.eq(annaiTaisyouUmuKbn) || C_UmuKbn.ARI.eq(jyutouTukisuuErrorflg) ||
                    C_UmuKbn.ARI.eq(jyutouNensuuErrorflg) ||
                    C_UmuKbn.ARI.eq(stAnnaiTukisuuErrorflg) ||
                    C_UmuKbn.ARI.eq(hsgbnktannaiErrorflg)) {
                    count++;

                    String message = null;

                    if (C_UmuKbn.NONE.eq(annaiTaisyouUmuKbn)) {
                        message = MessageUtil.getMessage(MessageId.EIF0008,
                            annaiSyuuouDataBean.getJkipjytym().toString());
                    }
                    if (C_UmuKbn.ARI.eq(jyutouTukisuuErrorflg)) {
                        message = MessageUtil.getMessage(MessageId.EIF3035);
                    }
                    if (C_UmuKbn.ARI.eq(jyutouNensuuErrorflg)) {
                        message = MessageUtil.getMessage(MessageId.EIF3073);
                    }
                    if (C_UmuKbn.ARI.eq(stAnnaiTukisuuErrorflg)) {
                        message = MessageUtil.getMessage(MessageId.EIF3061);
                    }

                    if (C_UmuKbn.ARI.eq(hsgbnktannaiErrorflg)) {
                        message = MessageUtil.getMessage(MessageId.EIF3070);
                    }
                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

                    editKhMisslstParam.setDataNo(count);
                    editKhMisslstParam.setSeqNo(count);
                    editKhMisslstParam.setMisslistMsg(message);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(annaiSyuuouDataBean.getSyono());

                    misslstPrmLst.add(editKhMisslstParam);

                    errorFlag = C_UmuKbn.ARI;

                    continue;

                }
                IT_KykKihon kykKihon = khKzhuriAnnaiSelDao.getKykKihon(annaiSyuuouDataBean.getSyono());

                int keisanRsgakuJyttuKisuu = jyttuKisuu * annaiRecordNum;

                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = new ArrayList<>();
                KeisanRsgkOutBean keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

                C_ErrorKbn keisanRsgakuResultKbn = keisanRsgaku.exec(kykKihon,
                    C_Nykkeiro.KZHRK,
                    C_NyknaiyouKbn.KEIZOKUP,
                    tykgoHurikaeYmd,
                    annaiSyuuouDataBean.getJkipjytym(),
                    jyutouNensuu,
                    keisanRsgakuJyttuKisuu);

                if (C_ErrorKbn.ERROR.eq(keisanRsgakuResultKbn)) {

                    String misslistMsg = MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu());
                    batSyoriHunoKykMisslistSks.addErrerMsg(annaiSyuuouDataBean.getSyono(), misslistMsg);
                    continue;
                }

                keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();
                keisanRsgkUtiwakeBeanList = keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst();

                Integer annainoMax = khKzhuriAnnaiSelDao.getAnsyuRirekiMaxAnnaino(annaiSyuuouDataBean.getSyono(),
                    annaiSyuuouDataBean.getJkipjytym());

                if (annainoMax == null) {
                    annainoMax = 1;
                }
                else {
                    annainoMax++;
                }

                List<IT_KhKouzahuriAnnaiData> khKouzahuriAnnaiDataList = new ArrayList<>();

                ansyuKihon = khKzhuriAnnaiSelDao.getAnsyuKihon(annaiSyuuouDataBean.getSyono());

                khKouzahuriAnnaiDataList = new ArrayList<IT_KhKouzahuriAnnaiData>();
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                int annaiKaisuu = 0;
                CurrencyType currencyType = keisanRsgkOutBean.getRsgakuGoukei().getType();

                if (C_TkiktbrisyuruiKbn.BLNK.eq(annaiSyuuouDataBean.getTikiktbrisyuruikbn())) {

                    if (C_Hrkkaisuu.NEN.eq(annaiSyuuouDataBean.getHrkkaisuu())) {

                        annaiKaisuu = jyutouNensuu;
                    }
                    else {

                        annaiKaisuu = jyttuKisuu / Integer.valueOf(annaiSyuuouDataBean.getHrkkaisuu().getValue());
                    }
                }
                else {

                    annaiKaisuu = jyttuKisuu / Integer.valueOf(annaiSyuuouDataBean.getTikiktbrisyuruikbn().getValue());
                }

                C_Tuukasyu rsTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(currencyType);
                BizDate ryosyukwsratekjYmd = keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd();
                BizNumber ryosyuKwsrate = keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate();
                BizCurrency annaiGk = BizCurrency.valueOf(0, currencyType);
                BizCurrency iktWaribikikGk = BizCurrency.valueOf(0, currencyType);

                for (int i = 0; i < annaiKaisuu; i++) {

                    annaiGk = annaiGk.add(keisanRsgkUtiwakeBeanList.get(rskingakuUtiwakeCnt).getRsgaku());
                    iktWaribikikGk = iktWaribikikGk.add(keisanRsgkUtiwakeBeanList.get(rskingakuUtiwakeCnt).getIktwaribikikgk());
                    rskingakuUtiwakeCnt = rskingakuUtiwakeCnt + 1;
                }

                dbEdit(annaiSyuuouDataBean, annaiTaisyouYm, annainoMax, annaiGk, syoriYmd, tykgoHurikaeYmd,
                    kykKihon, ansyuKihon, khKouzahuriAnnaiDataList, jyttuKisuu, jyutouNensuu, iktWaribikikGk,
                    rsTuukasyu, ryosyukwsratekjYmd, ryosyuKwsrate);

                if (annaiRecordNum == 2 || annaiRecordNum == 3) {

                    if (C_UmuKbn.ARI.eq(record2HeityouFlg)) {
                        annaiTaisyouYm = jkipjytYmdYokuNext;
                    }
                    else {
                        annaiTaisyouYm = jkipjytYmdNext;
                    }

                    annainoMax = khKzhuriAnnaiSelDao.getAnsyuRirekiMaxAnnaino(annaiSyuuouDataBean.getSyono(),
                        annaiTaisyouYm);
                    if (annainoMax == null) {
                        annainoMax = 1;
                    }
                    else {
                        annainoMax = annainoMax + 1;
                    }

                    annaiGk = BizCurrency.valueOf(0, currencyType);
                    iktWaribikikGk = BizCurrency.valueOf(0, currencyType);

                    for (int i = 0; i < annaiKaisuu; i++) {

                        annaiGk = annaiGk.add(keisanRsgkUtiwakeBeanList.get(rskingakuUtiwakeCnt).getRsgaku());
                        iktWaribikikGk = iktWaribikikGk.add(keisanRsgkUtiwakeBeanList.get(rskingakuUtiwakeCnt).getIktwaribikikgk());
                        rskingakuUtiwakeCnt = rskingakuUtiwakeCnt + 1;
                    }

                    dbEdit(annaiSyuuouDataBean, annaiTaisyouYm, annainoMax, annaiGk, syoriYmd, tykgoHurikaeYmd,
                        kykKihon, ansyuKihon, khKouzahuriAnnaiDataList,jyttuKisuu, jyutouNensuu, iktWaribikikGk,
                        rsTuukasyu, ryosyukwsratekjYmd, ryosyuKwsrate);
                }

                if (annaiRecordNum == 3) {

                    annaiTaisyouYm = jkipjytYmdYokuNext;

                    annainoMax = khKzhuriAnnaiSelDao.getAnsyuRirekiMaxAnnaino(annaiSyuuouDataBean.getSyono(),
                        annaiTaisyouYm);
                    if (annainoMax == null) {
                        annainoMax = 1;
                    }
                    else {
                        annainoMax = annainoMax + 1;
                    }

                    annaiGk = BizCurrency.valueOf(0, currencyType);
                    iktWaribikikGk = BizCurrency.valueOf(0, currencyType);

                    for (int i = 0; i < annaiKaisuu; i++) {

                        annaiGk = annaiGk.add(keisanRsgkUtiwakeBeanList.get(rskingakuUtiwakeCnt).getRsgaku());
                        iktWaribikikGk = iktWaribikikGk.add(keisanRsgkUtiwakeBeanList.get(rskingakuUtiwakeCnt).getIktwaribikikgk());
                        rskingakuUtiwakeCnt = rskingakuUtiwakeCnt + 1;
                    }

                    dbEdit(annaiSyuuouDataBean, annaiTaisyouYm, annainoMax, annaiGk, syoriYmd, tykgoHurikaeYmd,
                        kykKihon, ansyuKihon, khKouzahuriAnnaiDataList,jyttuKisuu, jyutouNensuu, iktWaribikikGk,
                        rsTuukasyu, ryosyukwsratekjYmd, ryosyuKwsrate);
                }

                khKzhuriAnnaiSelDao.addMultipleUpdateEntity(multipleEntityUpdater, kykKihon);

                khKzhuriAnnaiSelDao.addMultipleUpdateEntity(multipleEntityUpdater, ansyuKihon);

                for (IT_KhKouzahuriAnnaiData khKouzahuriAnnaiData : khKouzahuriAnnaiDataList) {
                    khKzhuriAnnaiSelDao.addMultipleInsertEntity(multipleEntityInserter, khKouzahuriAnnaiData);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

        }

        if (C_UmuKbn.ARI.eq(errorFlag)) {
            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
            EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);

            createReport.execNoCommit(editKhMisslstTbl.editBean(
                C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU ,
                khozenCommonParam,
                misslstPrmLst,
                syoriYmd));
        }

        if (batSyoriHunoKykMisslistSks.hasMisslistMsg()) {

            batSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYmd);
        }

        if (C_UmuKbn.ARI.eq(errorFlag)) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(dataNo)));
        }

        if (C_UmuKbn.NONE.eq(errorFlag)) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(dataNo)));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisoukbn));

    }

    private void dbEdit(AnnaiSyuuouDataBean pAnnaiSyuuouDataBean, BizDateYM pAnnaiTaisyouYm, Integer pAnnaino,
        BizCurrency pAnnaigk, BizDate pSyoriYmd, BizDate pTykgoHurikaeYmd, IT_KykKihon pKykKihon,
        IT_AnsyuKihon pAnsyuKihon, List<IT_KhKouzahuriAnnaiData> pKhKouzahuriAnnaiDataList,int jyttuKisuu,
        int pJyutouNensuu, BizCurrency pIktwaribikikgk, C_Tuukasyu pRsTuukasyu, BizDate pRyosyukwsratekjYmd,
        BizNumber pRyosyuKwsrate) {

        if (!C_SinkeizkKbn.KEIZOKU.eq(pAnnaiSyuuouDataBean.getSinkeizkkbn())) {

            IT_Kouza kouza = khKzhuriAnnaiSelDao.getKouza(pKykKihon);

            kouza.setSinkeizkkbn(C_SinkeizkKbn.KEIZOKU);
            kouza.setGyoumuKousinKinou(kinouID);
            kouza.setGyoumuKousinsyaId(userID);
            kouza.setGyoumuKousinTime(kosTime);

        }

        Integer jyutouKaisuuY = pJyutouNensuu;
        Integer jyutouKaisuuM = jyttuKisuu;

        IT_AnsyuRireki ansyuRireki = khKzhuriAnnaiSelDao.createAnsyuRireki(pAnsyuKihon);

        ansyuRireki.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        ansyuRireki.setJyuutouym(pAnnaiTaisyouYm);
        ansyuRireki.setAnnaino(pAnnaino);
        ansyuRireki.setNykkeiro(C_Nykkeiro.KZHRK);
        ansyuRireki.setJyutoukaisuuy(jyutouKaisuuY);
        ansyuRireki.setJyutoukaisuum(jyutouKaisuuM);
        ansyuRireki.setRsgaku(pAnnaigk);
        ansyuRireki.setRstuukasyu(pRsTuukasyu);
        ansyuRireki.setRyosyukwsratekjymd(pRyosyukwsratekjYmd);
        ansyuRireki.setRyosyukwsrate(pRyosyuKwsrate);
        ansyuRireki.setHrkp(pAnnaiSyuuouDataBean.getHrkp());
        ansyuRireki.setIktwaribikikgk(pIktwaribikikgk);
        ansyuRireki.setAnnaijkkbn(C_AnnaijkKbn.ANNAI);
        ansyuRireki.setAnnaisakuseiymd(pSyoriYmd);
        ansyuRireki.setHurikaeymd(pTykgoHurikaeYmd);
        ansyuRireki.setHrkkeiro(pAnnaiSyuuouDataBean.getHrkkeiro());
        ansyuRireki.setHrkkaisuu(pAnnaiSyuuouDataBean.getHrkkaisuu());
        ansyuRireki.setJkipjytym(pAnnaiSyuuouDataBean.getJkipjytym());
        ansyuRireki.setTikiktbrisyuruikbn(pAnnaiSyuuouDataBean.getTikiktbrisyuruikbn());
        ansyuRireki.setSyuudaikocd(pAnnaiSyuuouDataBean.getSyuudaikocd());
        ansyuRireki.setBankcd(pAnnaiSyuuouDataBean.getBankcd());
        ansyuRireki.setSitencd(pAnnaiSyuuouDataBean.getSitencd());
        ansyuRireki.setYokinkbn(pAnnaiSyuuouDataBean.getYokinkbn());
        ansyuRireki.setKouzano(pAnnaiSyuuouDataBean.getKouzano());
        ansyuRireki.setSinkeizkkbn(pAnnaiSyuuouDataBean.getSinkeizkkbn());
        ansyuRireki.setKzmeiginmkn(pAnnaiSyuuouDataBean.getKzmeiginmkn());
        ansyuRireki.setMinyutuutizumiflg(C_Skszumiflg.MISAKUSEI);
        ansyuRireki.setGyoumuKousinKinou(kinouID);
        ansyuRireki.setGyoumuKousinsyaId(userID);
        ansyuRireki.setGyoumuKousinTime(kosTime);

        BizPropertyInitializer.initialize(ansyuRireki);

        IT_KhKouzahuriAnnaiData khKouzahuriAnnaiData = new IT_KhKouzahuriAnnaiData(C_AnsyuusysKbn.HOZEN, pSyoriYmd,
            pAnnaiSyuuouDataBean.getSyono(), C_NyknaiyouKbn.KEIZOKUP, pAnnaiTaisyouYm);

        khKouzahuriAnnaiData.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        khKouzahuriAnnaiData.setJyutoukaisuuy(jyutouKaisuuY);
        khKouzahuriAnnaiData.setJyutoukaisuum(jyutouKaisuuM);
        khKouzahuriAnnaiData.setRsgaku(pAnnaigk);
        khKouzahuriAnnaiData.setHurikaeymd(pTykgoHurikaeYmd);
        khKouzahuriAnnaiData.setSyuudaikocd(pAnnaiSyuuouDataBean.getSyuudaikocd());
        khKouzahuriAnnaiData.setBankcd(pAnnaiSyuuouDataBean.getBankcd());
        khKouzahuriAnnaiData.setSitencd(pAnnaiSyuuouDataBean.getSitencd());
        khKouzahuriAnnaiData.setYokinkbn(pAnnaiSyuuouDataBean.getYokinkbn());
        khKouzahuriAnnaiData.setKouzano(pAnnaiSyuuouDataBean.getKouzano());
        khKouzahuriAnnaiData.setKzmeiginmkn(pAnnaiSyuuouDataBean.getKzmeiginmkn());
        khKouzahuriAnnaiData.setSinkeizkkbn(pAnnaiSyuuouDataBean.getSinkeizkkbn());
        khKouzahuriAnnaiData.setKyknmkn(pAnnaiSyuuouDataBean.getKyknmkn());
        khKouzahuriAnnaiData.setDantaikobetukbn("5");
        khKouzahuriAnnaiData.setKykymd(pAnnaiSyuuouDataBean.getKykymd());
        khKouzahuriAnnaiData.setHrkkaisuu(pAnnaiSyuuouDataBean.getHrkkaisuu());
        khKouzahuriAnnaiData.setGyoumuKousinKinou(kinouID);
        khKouzahuriAnnaiData.setGyoumuKousinsyaId(userID);
        khKouzahuriAnnaiData.setGyoumuKousinTime(kosTime);

        BizPropertyInitializer.initialize(khKouzahuriAnnaiData);

        pKhKouzahuriAnnaiDataList.add(khKouzahuriAnnaiData);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
