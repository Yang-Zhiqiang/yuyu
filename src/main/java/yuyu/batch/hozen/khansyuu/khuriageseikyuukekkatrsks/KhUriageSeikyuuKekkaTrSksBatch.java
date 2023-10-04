package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks.dba.KhUriageSeikyuuKekkaTrSksDao;
import yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks.dba.UriageSeikyuuDataBean;
import yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks.dba.UriageSeikyuuKekkaData3Bean;
import yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks.dba.UriageSeikyuuKekkaDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.entity.IT_MinusUriageKykDtlList;
import yuyu.def.db.entity.IT_TRCreditKurikosiMinyuu;
import yuyu.def.db.entity.IT_TRNyuukin;
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;
import yuyu.def.db.mapping.GenIT_KhUriageSeikyuuKekkaData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Ordering;

/**
 * 契約保全 案内収納 売上請求結果ＴＲ作成のバッチクラスです。
 */
public class KhUriageSeikyuuKekkaTrSksBatch implements Batch {

    private static final String TABLEID = GenIT_KhUriageSeikyuuKekkaData.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    private static final Integer MISSLSOUT_MAX_KENSUU = 50;

    private static final String TUKIAWASENGSIKIBETUKBN_URIAGESEIKYUU_MIJISSI = "1";

    private static final String TUKIAWASENGSIKIBETUKBN_TAJYUUJYUSIN = "2";

    private static final int URIAGESKDATASYUKNRTBLEDITKBN_MIEDIT = 0;

    private static final int URIAGESKDATASYUKNRTBLEDITKBN_ADD = 1;

    private static final int URIAGESKDATASYUKNRTBLEDITKBN_UPDATE = 2;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhUriageSeikyuuKekkaTrSksBatchParam khUriageSeikyuuKekkaTrSksBatchParam;

    @Inject
    private KhUriageSeikyuuKekkaTrSksDao khUriageSeikyuuKekkaTrSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return khUriageSeikyuuKekkaTrSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khUriageSeikyuuKekkaTrSksBatchParam.getSyoriYmd();

        String kakutyouJobcd = khUriageSeikyuuKekkaTrSksBatchParam.getIbKakutyoujobcd();

        String heisouKbn = khUriageSeikyuuKekkaTrSksBatchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobcd));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisouKbn));

        Map<String, String> tukiawaseNgKekkaDataMap = new HashMap<>();
        List<EditKhMisslstParam> editKhMisslstParamList = new ArrayList<>();
        TukiawaseNgkensuuKanriBean tukiawaseNgkensuuKanriBean = new TukiawaseNgkensuuKanriBean();

        sasikaeJyuutouYm(tukiawaseNgKekkaDataMap, editKhMisslstParamList, tukiawaseNgkensuuKanriBean);

        checkTukiawase2(editKhMisslstParamList, tukiawaseNgkensuuKanriBean);

        sksUriageSeikyuuKekkaTr(tukiawaseNgKekkaDataMap, tukiawaseNgkensuuKanriBean);
    }

    private void sasikaeJyuutouYm(Map<String, String> pTukiawaseNgKekkaDataMap,
        List<EditKhMisslstParam> pEditKhMisslstParamList, TukiawaseNgkensuuKanriBean pTukiawaseNgkensuuKanriBean) {

        String syoNo = "";
        List<UriageKekkaDataSasikaeSortBean> uriageKekkaDataSasikaeSortBeanList =
            new ArrayList<UriageKekkaDataSasikaeSortBean>();
        List<BizDateYM> jyutouYmList = new ArrayList<BizDateYM>();

        try(
            ExDBResults<UriageSeikyuuKekkaDataBean> uriageSeikyuuKekkaDataBeanList =
            khUriageSeikyuuKekkaTrSksDao.getKhUriageSeikyuuKekkaData1(
                khUriageSeikyuuKekkaTrSksBatchParam.getIbKakutyoujobcd(),
                khUriageSeikyuuKekkaTrSksBatchParam.getHeisoukbn());
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();
            ) {

            for (UriageSeikyuuKekkaDataBean uriageSeikyuuKekkaDataBean : uriageSeikyuuKekkaDataBeanList) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(khUriageSeikyuuKekkaTrSksBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);

                if (!syoNo.equals(uriageSeikyuuKekkaDataBean.getSyono())) {
                    if (uriageKekkaDataSasikaeSortBeanList.size() > 1) {
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoNo);

                        List<IT_KhUriageSeikyuuKekkaData> sasikaeUriKekkaDataList = sasikaeJyuutouYmMainSyori(
                            uriageKekkaDataSasikaeSortBeanList,
                            jyutouYmList);

                        for (IT_KhUriageSeikyuuKekkaData uriageSeikyuuKekkaData : sasikaeUriKekkaDataList) {
                            multipleEntityUpdater.add(uriageSeikyuuKekkaData);
                        }
                    }
                    syoNo = "";
                    uriageKekkaDataSasikaeSortBeanList = new ArrayList<UriageKekkaDataSasikaeSortBean>();
                    jyutouYmList = new ArrayList<BizDateYM>();
                }

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(uriageSeikyuuKekkaDataBean.getSyono());

                TukiawaseCheck1KekkaBean tukiawaseCheck1KekkaBean = checkTukiawase1(uriageSeikyuuKekkaDataBean,
                    pEditKhMisslstParamList,
                    pTukiawaseNgKekkaDataMap,
                    pTukiawaseNgkensuuKanriBean);

                if (!tukiawaseCheck1KekkaBean.getResult()) {
                    continue;
                }

                if (URIAGESKDATASYUKNRTBLEDITKBN_ADD == tukiawaseCheck1KekkaBean.getUriageSkDataSyuKnrTblEditKbn()) {
                    multipleEntityInserter.add(tukiawaseCheck1KekkaBean.getUriageSkDataSyuKnr());
                }
                if (URIAGESKDATASYUKNRTBLEDITKBN_UPDATE == tukiawaseCheck1KekkaBean.getUriageSkDataSyuKnrTblEditKbn()) {
                    multipleEntityUpdater.add(tukiawaseCheck1KekkaBean.getUriageSkDataSyuKnr());
                }

                if(C_CreditUriageSeikyuuKbn.TUUJYOU.eq(uriageSeikyuuKekkaDataBean.getCredituriageseikyuukbn())) {

                    UriageKekkaDataSasikaeSortBean uriageKekkaDataSasikaeSortBean = new UriageKekkaDataSasikaeSortBean();
                    uriageKekkaDataSasikaeSortBean.setSyoNo(uriageSeikyuuKekkaDataBean.getSyono());
                    uriageKekkaDataSasikaeSortBean.setCreditKessaiyouNo(uriageSeikyuuKekkaDataBean.getCreditkessaiyouno());
                    uriageKekkaDataSasikaeSortBean.setUriageNengappi(uriageSeikyuuKekkaDataBean.getUriagenengappi());
                    uriageKekkaDataSasikaeSortBean.setRenNo3Keta(
                        uriageSeikyuuKekkaDataBean.getUriageseikyuukekkadatarenno3keta());
                    if (C_CreditUriageNgJiyuuKbn.SEIJYOU.eq(uriageSeikyuuKekkaDataBean.getCredituriagengjiyuu())) {
                        uriageKekkaDataSasikaeSortBean.setCreditUriageNgjiyuu(0);
                    }
                    else if (C_CreditUriageNgJiyuuKbn.URIAGESYORIMIKANRYOU.
                        eq(uriageSeikyuuKekkaDataBean.getCredituriagengjiyuu())) {
                        uriageKekkaDataSasikaeSortBean.setCreditUriageNgjiyuu(3);
                    }
                    else if (C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR.
                        eq(uriageSeikyuuKekkaDataBean.getCredituriagengjiyuu())) {
                        uriageKekkaDataSasikaeSortBean.setCreditUriageNgjiyuu(2);
                    }
                    else {
                        if (uriageSeikyuuKekkaDataBean.getCredituriagengjiyuu() != null) {
                            uriageKekkaDataSasikaeSortBean.setCreditUriageNgjiyuu(
                                Integer.valueOf(uriageSeikyuuKekkaDataBean.getCredituriagengjiyuu().getValue()));
                        }
                    }

                    uriageKekkaDataSasikaeSortBeanList.add(uriageKekkaDataSasikaeSortBean);
                    jyutouYmList.add(uriageSeikyuuKekkaDataBean.getJyuutouym());
                }

                syoNo = uriageSeikyuuKekkaDataBean.getSyono();
            }

            if (uriageKekkaDataSasikaeSortBeanList.size() > 1) {
                List<IT_KhUriageSeikyuuKekkaData> uriageSeikyuuKekkaDataList = sasikaeJyuutouYmMainSyori(
                    uriageKekkaDataSasikaeSortBeanList, jyutouYmList);
                for (IT_KhUriageSeikyuuKekkaData uriageSeikyuuKekkaData : uriageSeikyuuKekkaDataList) {
                    multipleEntityUpdater.add(uriageSeikyuuKekkaData);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
    }

    private TukiawaseCheck1KekkaBean checkTukiawase1(UriageSeikyuuKekkaDataBean pUriageKekkaDataBean,
        List<EditKhMisslstParam> pEditKhMisslstParamList,
        Map<String, String> pTukiawaseNgKekkaDataMap,
        TukiawaseNgkensuuKanriBean pTukiawaseNgkensuuKanriBean) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String sousasyaCd = khozenCommonParam.getUserID();
        String systemYmdTime = BizDate.getSysDateTimeMilli();
        Boolean tukiawaseUriageSeikyuuMijissiCheck = true;
        Boolean tukiawaseTajyuuJyusinCheck = true;
        IT_UriageSkDataSyuKnr uriageSkDataSyuKnr = new IT_UriageSkDataSyuKnr();
        TukiawaseCheck1KekkaBean tukiawaseCheck1KekkaBean = new TukiawaseCheck1KekkaBean();

        if (pUriageKekkaDataBean.getUriageseikyuudatarenno3keta() == null) {
            tukiawaseUriageSeikyuuMijissiCheck = false;
            pTukiawaseNgkensuuKanriBean.setTukiawaseUriageseikyuuMijissiCheckNgKensuu(
                pTukiawaseNgkensuuKanriBean.getTukiawaseUriageseikyuuMijissiCheckNgKensuu() + 1);
        }

        if (tukiawaseUriageSeikyuuMijissiCheck) {
            if (pUriageKekkaDataBean.getCredituriagekekkahaneiymd() != null) {
                tukiawaseTajyuuJyusinCheck = false;
                pTukiawaseNgkensuuKanriBean.setTukiawaseTajyuujyusinCheckNgKensuu(
                    pTukiawaseNgkensuuKanriBean.getTukiawaseTajyuujyusinCheckNgKensuu() + 1);
            }
        }

        if (tukiawaseUriageSeikyuuMijissiCheck && tukiawaseTajyuuJyusinCheck) {

            uriageSkDataSyuKnr = hozenDomManager.getUriageSkDataSyuKnr(pUriageKekkaDataBean.getSyono(),
                pUriageKekkaDataBean.getCreditkessaiyouno(), pUriageKekkaDataBean.getUriagenengappi(),
                pUriageKekkaDataBean.getUriageseikyuudatarenno3keta());

            if (uriageSkDataSyuKnr != null && uriageSkDataSyuKnr.getCredituriagekekkahaneiymd() != null) {

                tukiawaseTajyuuJyusinCheck = false;
                pTukiawaseNgkensuuKanriBean.setTukiawaseTajyuujyusinCheckNgKensuu(
                    pTukiawaseNgkensuuKanriBean.getTukiawaseTajyuujyusinCheckNgKensuu() + 1);
            }
        }

        if (tukiawaseUriageSeikyuuMijissiCheck && tukiawaseTajyuuJyusinCheck) {

            Integer uriageSkDataSyuKnrTblEditKbn = null;

            if (uriageSkDataSyuKnr != null) {
                uriageSkDataSyuKnr.setCredituriagekekkahaneiymd(khUriageSeikyuuKekkaTrSksBatchParam.getSyoriYmd());
                uriageSkDataSyuKnr.setGyoumuKousinKinou(functionId);
                uriageSkDataSyuKnr.setGyoumuKousinsyaId(sousasyaCd);
                uriageSkDataSyuKnr.setGyoumuKousinTime(systemYmdTime);
                uriageSkDataSyuKnrTblEditKbn = URIAGESKDATASYUKNRTBLEDITKBN_UPDATE;
            }
            else {
                uriageSkDataSyuKnr = new IT_UriageSkDataSyuKnr(pUriageKekkaDataBean.getSyono(),
                    pUriageKekkaDataBean.getCreditkessaiyouno(),
                    pUriageKekkaDataBean.getUriagenengappi(),
                    pUriageKekkaDataBean.getUriageseikyuudatarenno3keta());
                uriageSkDataSyuKnr.setCredituriagekekkahaneiymd(khUriageSeikyuuKekkaTrSksBatchParam.getSyoriYmd());
                uriageSkDataSyuKnr.setCredituragskkkmhnkkchkzmflg(false);
                uriageSkDataSyuKnr.setGyoumuKousinKinou(functionId);
                uriageSkDataSyuKnr.setGyoumuKousinsyaId(sousasyaCd);
                uriageSkDataSyuKnr.setGyoumuKousinTime(systemYmdTime);

                BizPropertyInitializer.initialize(uriageSkDataSyuKnr);

                uriageSkDataSyuKnrTblEditKbn = URIAGESKDATASYUKNRTBLEDITKBN_ADD;
            }

            tukiawaseCheck1KekkaBean.setResult(true);
            tukiawaseCheck1KekkaBean.setUriageSkDataSyuKnr(uriageSkDataSyuKnr);
            tukiawaseCheck1KekkaBean.setUriageSkDataSyuKnrTblEditKbn(uriageSkDataSyuKnrTblEditKbn);
        }
        else {
            tukiawaseCheck1KekkaBean.setResult(false);
            tukiawaseCheck1KekkaBean.setUriageSkDataSyuKnr(null);
            tukiawaseCheck1KekkaBean.setUriageSkDataSyuKnrTblEditKbn(URIAGESKDATASYUKNRTBLEDITKBN_MIEDIT);
        }

        if (!tukiawaseUriageSeikyuuMijissiCheck || !tukiawaseTajyuuJyusinCheck) {

            String mapKey = pUriageKekkaDataBean.getSyono() + "-" +
                pUriageKekkaDataBean.getCreditkessaiyouno() + "-" +
                pUriageKekkaDataBean.getUriagenengappi() + "-" +
                pUriageKekkaDataBean.getUriageseikyuukekkadatarenno3keta();

            if (!pTukiawaseNgKekkaDataMap.containsKey(mapKey)) {
                if (!tukiawaseUriageSeikyuuMijissiCheck) {
                    pTukiawaseNgKekkaDataMap.put(mapKey, TUKIAWASENGSIKIBETUKBN_URIAGESEIKYUU_MIJISSI);
                }
                else {
                    pTukiawaseNgKekkaDataMap.put(mapKey, TUKIAWASENGSIKIBETUKBN_TAJYUUJYUSIN);
                }
            }
        }

        if (!tukiawaseUriageSeikyuuMijissiCheck || !tukiawaseTajyuuJyusinCheck) {
            if (pEditKhMisslstParamList.size() < MISSLSOUT_MAX_KENSUU) {
                Integer misslstSeqNo = pEditKhMisslstParamList.size() + 1;
                EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
                String message1 = "";
                String message2 = "";

                if (!tukiawaseUriageSeikyuuMijissiCheck) {
                    message1 = "未請求結果データ受信";
                }
                if (!tukiawaseTajyuuJyusinCheck) {
                    message1 = "結果多重受信";
                }

                message2 = creditKessaiyouNoHensyuu.exec(pUriageKekkaDataBean.getCreditkessaiyouno());

                editKhMisslstParam.setDataNo(misslstSeqNo);
                editKhMisslstParam.setSeqNo(misslstSeqNo);
                editKhMisslstParam.setMisslistMsg(MessageUtil.getMessage(MessageId.EIF3047,
                    message1, message2,
                    pUriageKekkaDataBean.getUriagenengappi().toString(),
                    pUriageKekkaDataBean.getRecordno(),
                    pUriageKekkaDataBean.getCredituriagegk().toString(),
                    Objects.toString(pUriageKekkaDataBean.getJyuutouym(), "")));
                editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                editKhMisslstParam.setSyoNo(pUriageKekkaDataBean.getSyono());

                pEditKhMisslstParamList.add(editKhMisslstParam);
            }
        }

        return tukiawaseCheck1KekkaBean;
    }

    private List<IT_KhUriageSeikyuuKekkaData> sasikaeJyuutouYmMainSyori(
        List<UriageKekkaDataSasikaeSortBean> pUriageKekkaDataSasikaeSortBeanList,
        List<BizDateYM> pJyutouYmList) {

        String heisouKbn = khUriageSeikyuuKekkaTrSksBatchParam.getHeisoukbn();
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String sousasyaCd = khozenCommonParam.getUserID();
        String systemYmdTime = BizDate.getSysDateTimeMilli();
        List<IT_KhUriageSeikyuuKekkaData> sasikaeUriKekkaDataList = new ArrayList<IT_KhUriageSeikyuuKekkaData>();

        Boolean sasikaeJikkouFlag = sasikaeJyuutouYmSyori(pUriageKekkaDataSasikaeSortBeanList);

        if (sasikaeJikkouFlag) {
            for (int n = 0;n < pUriageKekkaDataSasikaeSortBeanList.size(); n++) {
                UriageKekkaDataSasikaeSortBean uriageKekkaDataSasikaeSortBean =
                    pUriageKekkaDataSasikaeSortBeanList.get(n);
                IT_KhUriageSeikyuuKekkaData khUriageSeikyuuKekkaData = new IT_KhUriageSeikyuuKekkaData();
                khUriageSeikyuuKekkaData = khUriageSeikyuuKekkaTrSksDao.
                    getKhUriageSeikyuuKekkaData3(heisouKbn,
                        uriageKekkaDataSasikaeSortBean.getSyoNo(),
                        uriageKekkaDataSasikaeSortBean.getCreditKessaiyouNo(),
                        uriageKekkaDataSasikaeSortBean.getUriageNengappi(),
                        uriageKekkaDataSasikaeSortBean.getRenNo3Keta());

                BizDateYM jyutouYm = pJyutouYmList.get(n);
                khUriageSeikyuuKekkaData.setJyuutouym(jyutouYm);
                khUriageSeikyuuKekkaData.setGyoumuKousinKinou(functionId);
                khUriageSeikyuuKekkaData.setGyoumuKousinsyaId(sousasyaCd);
                khUriageSeikyuuKekkaData.setGyoumuKousinTime(systemYmdTime);

                sasikaeUriKekkaDataList.add(khUriageSeikyuuKekkaData);
            }
        }

        return sasikaeUriKekkaDataList;
    }

    private Boolean sasikaeJyuutouYmSyori(List<UriageKekkaDataSasikaeSortBean> pUriageKekkaDataSasikaeSortBeanList) {
        Boolean sasikaeJikkouFlag = false;

        if (pUriageKekkaDataSasikaeSortBeanList.size() > 1) {
            Ordering<UriageKekkaDataSasikaeSortBean> ordering = Ordering.from(
                new UriageKekkaDataSasikaeSortBeanSortComparator());
            List<UriageKekkaDataSasikaeSortBean> sortedList = ordering.sortedCopy(pUriageKekkaDataSasikaeSortBeanList);
            pUriageKekkaDataSasikaeSortBeanList.clear();
            pUriageKekkaDataSasikaeSortBeanList.addAll(sortedList);

            sasikaeJikkouFlag = true;
        }

        return sasikaeJikkouFlag;
    }

    private void checkTukiawase2(List<EditKhMisslstParam> pEditKhMisslstParamList,
        TukiawaseNgkensuuKanriBean pTukiawaseNgkensuuKanriBean) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String sousasyaCd = khozenCommonParam.getUserID();
        String systemYmdTime = BizDate.getSysDateTimeMilli();

        try (ExDBResults<UriageSeikyuuDataBean> uriageSeikyuuDataBeanList = khUriageSeikyuuKekkaTrSksDao.
            getUriageSeikyuuData(khUriageSeikyuuKekkaTrSksBatchParam.getIbKakutyoujobcd(),
                khUriageSeikyuuKekkaTrSksBatchParam.getHeisoukbn(),
                khUriageSeikyuuKekkaTrSksBatchParam.getSyoriYmd());
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            ) {

            for (UriageSeikyuuDataBean uriageSeikyuuDataBean : uriageSeikyuuDataBeanList) {
                pTukiawaseNgkensuuKanriBean.setTukiawaseKekkadataMijyusinCheckNgKensuu(
                    pTukiawaseNgkensuuKanriBean.getTukiawaseKekkadataMijyusinCheckNgKensuu() + 1);
                String message1 = "";

                if (pEditKhMisslstParamList.size() < MISSLSOUT_MAX_KENSUU) {
                    Integer misslstSeqNo = pEditKhMisslstParamList.size() + 1;
                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
                    message1 = creditKessaiyouNoHensyuu.exec(uriageSeikyuuDataBean.getCreditkessaiyouno());

                    editKhMisslstParam.setDataNo(misslstSeqNo);
                    editKhMisslstParam.setSeqNo(misslstSeqNo);
                    editKhMisslstParam.setMisslistMsg(MessageUtil.getMessage(MessageId.EIF3047,
                        "結果未受信", message1,
                        uriageSeikyuuDataBean.getUriagenengappi().toString(),
                        uriageSeikyuuDataBean.getRecordno(),
                        uriageSeikyuuDataBean.getCredituriagegk().toString(),
                        Objects.toString(uriageSeikyuuDataBean.getJyuutouym(), "")));
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(uriageSeikyuuDataBean.getSyono());

                    pEditKhMisslstParamList.add(editKhMisslstParam);
                }

                IT_UriageSkDataSyuKnr uriageSkDataSyuKnr = new IT_UriageSkDataSyuKnr(
                    uriageSeikyuuDataBean.getSyono(),
                    uriageSeikyuuDataBean.getCreditkessaiyouno(),
                    uriageSeikyuuDataBean.getUriagenengappi(),
                    uriageSeikyuuDataBean.getRenno3keta());
                uriageSkDataSyuKnr.setCredituragskkkmhnkkchkzmflg(true);
                uriageSkDataSyuKnr.setGyoumuKousinKinou(functionId);
                uriageSkDataSyuKnr.setGyoumuKousinsyaId(sousasyaCd);
                uriageSkDataSyuKnr.setGyoumuKousinTime(systemYmdTime);

                BizPropertyInitializer.initialize(uriageSkDataSyuKnr);

                multipleEntityInserter.add(uriageSkDataSyuKnr);
            }

            if (pEditKhMisslstParamList.size() > 0) {
                EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

                editKhMisslstParam.setDataNo(0);
                editKhMisslstParam.setSeqNo(0);
                editKhMisslstParam.setMisslistMsg(MessageUtil.getMessage(MessageId.EIF3048,
                    String.valueOf(pTukiawaseNgkensuuKanriBean.getTukiawaseUriageseikyuuMijissiCheckNgKensuu()),
                    String.valueOf(pTukiawaseNgkensuuKanriBean.getTukiawaseKekkadataMijyusinCheckNgKensuu()),
                    String.valueOf(pTukiawaseNgkensuuKanriBean.getTukiawaseTajyuujyusinCheckNgKensuu()),
                    MISSLSOUT_MAX_KENSUU.toString()));
                editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                editKhMisslstParam.setSyoNo("");

                pEditKhMisslstParamList.add(0, editKhMisslstParam);

                CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

                EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);

                ReportServicesBean reportServicesBean = editKhMisslstTbl.editBean(
                    C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU ,
                    khozenCommonParam,
                    pEditKhMisslstParamList,
                    khUriageSeikyuuKekkaTrSksBatchParam.getSyoriYmd());

                createReport.execNoCommit(reportServicesBean);
            }
        }
    }

    private void sksUriageSeikyuuKekkaTr(Map<String, String> pTukiawaseNgKekkaDataMap,
        TukiawaseNgkensuuKanriBean pTukiawaseNgkensuuKanriBean) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String sousasyaCd = khozenCommonParam.getUserID();
        String systemYmdTime = BizDate.getSysDateTimeMilli();
        Integer count = 0;
        Integer syonoRenTR = 0;
        String syoNo = null;
        String kakutyouJobcd = khUriageSeikyuuKekkaTrSksBatchParam.getIbKakutyoujobcd();
        String heisouKbn = khUriageSeikyuuKekkaTrSksBatchParam.getHeisoukbn();
        BizDate syoriYmd = khUriageSeikyuuKekkaTrSksBatchParam.getSyoriYmd();

        try(ExDBResults<UriageSeikyuuKekkaData3Bean> uriageSeikyuuKekkaData3BeanList = khUriageSeikyuuKekkaTrSksDao.
            getKhUriageSeikyuuKekkaData3(kakutyouJobcd, heisouKbn);
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {
            for (UriageSeikyuuKekkaData3Bean uriageSeikyuuKekkaData3Bean : uriageSeikyuuKekkaData3BeanList) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(uriageSeikyuuKekkaData3Bean.getSyono());

                if (BizUtil.isBlank(syoNo) || !uriageSeikyuuKekkaData3Bean.getSyono().equals(syoNo)) {
                    syoNo = uriageSeikyuuKekkaData3Bean.getSyono();
                    syonoRenTR = 1;
                }

                if (pTukiawaseNgKekkaDataMap.containsKey(uriageSeikyuuKekkaData3Bean.getSyono() + "-" +
                    uriageSeikyuuKekkaData3Bean.getCreditkessaiyouno() + "-" +
                    uriageSeikyuuKekkaData3Bean.getUriagenengappi() + "-" +
                    uriageSeikyuuKekkaData3Bean.getRenno3keta())) {
                    continue;
                }

                IT_TRNyuukin tRNyuukin = null;
                IT_TRCreditKurikosiMinyuu tRCreditKurikosiMinyuu = null;
                IT_UriageSeikyuuKkErrorList uriageSeikyuuKkErrorList = null;
                IT_MinusUriageKykDtlList minusUriageKykDtlList = null;

                if (C_CreditUriageNgJiyuuKbn.SEIJYOU.eq(uriageSeikyuuKekkaData3Bean.getCredituriagengjiyuu())) {

                    if(C_CreditUriageSeikyuuKbn.TUUJYOU.eq(uriageSeikyuuKekkaData3Bean.getCredituriageseikyuukbn()) ||
                        C_CreditUriageSeikyuuKbn.RINJI.eq(uriageSeikyuuKekkaData3Bean.getCredituriageseikyuukbn())) {

                        tRNyuukin = new IT_TRNyuukin(uriageSeikyuuKekkaData3Bean.getSyono(),
                            syoriYmd, SaibanBiz.getNyukinTRRenban(syoriYmd.toString()), 1);

                        if(C_CreditUriageSeikyuuKbn.RINJI.eq(uriageSeikyuuKekkaData3Bean.getCredituriageseikyuukbn())) {
                            tRNyuukin.setNykkeiro(C_Nykkeiro.CREDIT);
                        } else {
                            tRNyuukin.setNykkeiro(uriageSeikyuuKekkaData3Bean.getNykkeiro());
                        }
                        tRNyuukin.setHrkkaisuu(uriageSeikyuuKekkaData3Bean.getHrkkaisuu());
                        tRNyuukin.setNyknaiyoukbn(uriageSeikyuuKekkaData3Bean.getNyknaiyoukbn());
                        if (C_TkiktbrisyuruiKbn.BLNK.eq(uriageSeikyuuKekkaData3Bean.getTikiktbrisyuruikbn()) ||
                            C_TkiktbrisyuruiKbn.NONE.eq(uriageSeikyuuKekkaData3Bean.getTikiktbrisyuruikbn())) {
                            tRNyuukin.setIktnyuukinnumu(C_UmuKbn.NONE);
                        } else {
                            tRNyuukin.setIktnyuukinnumu(C_UmuKbn.ARI);
                        }
                        tRNyuukin.setJyuutouym(uriageSeikyuuKekkaData3Bean.getJyuutouym());
                        tRNyuukin.setJyutoukaisuuy(uriageSeikyuuKekkaData3Bean.getJyutoukaisuuy());
                        tRNyuukin.setJyutoukaisuum(uriageSeikyuuKekkaData3Bean.getJyutoukaisuum());
                        tRNyuukin.setRsgaku(uriageSeikyuuKekkaData3Bean.getCredituriagegk());
                        tRNyuukin.setRyosyuymd(uriageSeikyuuKekkaData3Bean.getUriagenengappi());
                        tRNyuukin.setTikiktbrisyuruikbn(uriageSeikyuuKekkaData3Bean.getTikiktbrisyuruikbn());
                        tRNyuukin.setRstuukasyu(C_Tuukasyu.JPY);
                        tRNyuukin.setGyoumuKousinKinou(functionId);
                        tRNyuukin.setGyoumuKousinsyaId(sousasyaCd);
                        tRNyuukin.setGyoumuKousinTime(systemYmdTime);
                        tRNyuukin.setCreditkessaiyouno(uriageSeikyuuKekkaData3Bean.getCreditkessaiyouno());
                        tRNyuukin.setCredituriageseikyuukbn(uriageSeikyuuKekkaData3Bean.getCredituriageseikyuukbn());

                        BizPropertyInitializer.initialize(tRNyuukin);

                    }
                    else if(C_CreditUriageSeikyuuKbn.MINUS.eq(uriageSeikyuuKekkaData3Bean.getCredituriageseikyuukbn())) {

                        minusUriageKykDtlList = new IT_MinusUriageKykDtlList();

                        minusUriageKykDtlList.setSyono(uriageSeikyuuKekkaData3Bean.getSyono());
                        minusUriageKykDtlList.setCreditkessaiyouno(uriageSeikyuuKekkaData3Bean.getCreditkessaiyouno());
                        minusUriageKykDtlList.setUriagenengappi(uriageSeikyuuKekkaData3Bean.getUriagenengappi());
                        minusUriageKykDtlList.setRenno3keta(uriageSeikyuuKekkaData3Bean.getRenno3keta());
                        minusUriageKykDtlList.setJyuutouym(uriageSeikyuuKekkaData3Bean.getJyuutouym());
                        minusUriageKykDtlList.setSyoriYmd(syoriYmd);
                        minusUriageKykDtlList.setCredituriagegk(uriageSeikyuuKekkaData3Bean.getCredituriagegk());
                        minusUriageKykDtlList.setKinouId(uriageSeikyuuKekkaData3Bean.getGyoumukousinkinou());
                        minusUriageKykDtlList.setGyoumuKousinKinou(functionId);
                        minusUriageKykDtlList.setGyoumuKousinsyaId(sousasyaCd);
                        minusUriageKykDtlList.setGyoumuKousinTime(systemYmdTime);

                        BizPropertyInitializer.initialize(minusUriageKykDtlList);
                    }
                }
                else {
                    if(C_CreditUriageSeikyuuKbn.TUUJYOU.eq(uriageSeikyuuKekkaData3Bean.getCredituriageseikyuukbn())) {

                        tRCreditKurikosiMinyuu = new IT_TRCreditKurikosiMinyuu(uriageSeikyuuKekkaData3Bean.getSyono(),
                            syoriYmd, systemYmdTime + syonoRenTR);

                        tRCreditKurikosiMinyuu.setNykkeiro(uriageSeikyuuKekkaData3Bean.getNykkeiro());
                        tRCreditKurikosiMinyuu.setNyknaiyoukbn(uriageSeikyuuKekkaData3Bean.getNyknaiyoukbn());
                        tRCreditKurikosiMinyuu.setJyuutouym(uriageSeikyuuKekkaData3Bean.getJyuutouym());
                        tRCreditKurikosiMinyuu.setJyutoukaisuuy(uriageSeikyuuKekkaData3Bean.getJyutoukaisuuy());
                        tRCreditKurikosiMinyuu.setJyutoukaisuum(uriageSeikyuuKekkaData3Bean.getJyutoukaisuum());
                        tRCreditKurikosiMinyuu.setRsgaku(uriageSeikyuuKekkaData3Bean.getCredituriagegk());
                        tRCreditKurikosiMinyuu.setRyosyuymd(uriageSeikyuuKekkaData3Bean.getUriagenengappi());
                        tRCreditKurikosiMinyuu.setHrkkaisuu(uriageSeikyuuKekkaData3Bean.getHrkkaisuu());
                        tRCreditKurikosiMinyuu.setTikiktbrisyuruikbn(uriageSeikyuuKekkaData3Bean.getTikiktbrisyuruikbn());
                        tRCreditKurikosiMinyuu.setCreditkessaiyouno(uriageSeikyuuKekkaData3Bean.getCreditkessaiyouno());
                        tRCreditKurikosiMinyuu.setCredituriagengjiyuu(uriageSeikyuuKekkaData3Bean.getCredituriagengjiyuu());
                        tRCreditKurikosiMinyuu.setGyoumuKousinKinou(functionId);
                        tRCreditKurikosiMinyuu.setGyoumuKousinsyaId(sousasyaCd);
                        tRCreditKurikosiMinyuu.setGyoumuKousinTime(systemYmdTime);

                        BizPropertyInitializer.initialize(tRCreditKurikosiMinyuu);

                        syonoRenTR++;
                    }

                    uriageSeikyuuKkErrorList = new IT_UriageSeikyuuKkErrorList();

                    uriageSeikyuuKkErrorList.setSyoriYmd(syoriYmd);
                    uriageSeikyuuKkErrorList.setSyono(uriageSeikyuuKekkaData3Bean.getSyono());
                    if(uriageSeikyuuKekkaData3Bean.getJyuutouym() == null) {
                        uriageSeikyuuKkErrorList.setJyuutouym(BizDateYM.valueOf("999912"));
                    } else {
                        uriageSeikyuuKkErrorList.setJyuutouym(uriageSeikyuuKekkaData3Bean.getJyuutouym());
                    }
                    uriageSeikyuuKkErrorList.setRenno3keta(uriageSeikyuuKekkaData3Bean.getRenno3keta());
                    uriageSeikyuuKkErrorList.setCreditkessaiyouno(uriageSeikyuuKekkaData3Bean.getCreditkessaiyouno());
                    uriageSeikyuuKkErrorList.setUriagenengappi(uriageSeikyuuKekkaData3Bean.getUriagenengappi());
                    uriageSeikyuuKkErrorList.setCredituriagegk(uriageSeikyuuKekkaData3Bean.getCredituriagegk());
                    uriageSeikyuuKkErrorList.setUriageseikyuuerrorcd(
                        uriageSeikyuuKekkaData3Bean.getUriageseikyuuerrorcd());
                    uriageSeikyuuKkErrorList.setCredituriagengjiyuu(
                        uriageSeikyuuKekkaData3Bean.getCredituriagengjiyuu());
                    uriageSeikyuuKkErrorList.setGyoumuKousinKinou(functionId);
                    uriageSeikyuuKkErrorList.setGyoumuKousinsyaId(sousasyaCd);
                    uriageSeikyuuKkErrorList.setGyoumuKousinTime(systemYmdTime);
                    uriageSeikyuuKkErrorList.setAuthorikbn(uriageSeikyuuKekkaData3Bean.getAuthorikbn());
                    uriageSeikyuuKkErrorList.setKinouId(uriageSeikyuuKekkaData3Bean.getGyoumukousinkinou());
                    uriageSeikyuuKkErrorList.setCredituriageseikyuukbn(uriageSeikyuuKekkaData3Bean.getCredituriageseikyuukbn());

                    BizPropertyInitializer.initialize(uriageSeikyuuKkErrorList);
                }

                count ++;

                if (tRNyuukin != null) {
                    multipleEntityInserter.add(tRNyuukin);
                }
                if (tRCreditKurikosiMinyuu != null) {
                    multipleEntityInserter.add(tRCreditKurikosiMinyuu);
                }
                if (uriageSeikyuuKkErrorList != null) {
                    multipleEntityInserter.add(uriageSeikyuuKkErrorList);
                }
                if (minusUriageKykDtlList != null) {
                    multipleEntityInserter.add(minusUriageKykDtlList);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisouKbn));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "ミスリスト",
            String.valueOf(pTukiawaseNgkensuuKanriBean.getTukiawaseUriageseikyuuMijissiCheckNgKensuu() +
                pTukiawaseNgkensuuKanriBean.getTukiawaseKekkadataMijyusinCheckNgKensuu() +
                pTukiawaseNgkensuuKanriBean.getTukiawaseTajyuujyusinCheckNgKensuu())));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
