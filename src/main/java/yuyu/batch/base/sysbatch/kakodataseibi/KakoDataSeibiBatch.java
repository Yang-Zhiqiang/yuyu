package yuyu.batch.base.sysbatch.kakodataseibi;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.typesafe.ExDBField;
import jp.co.slcs.swak.file.FileDescription;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.description.text.csv.CsvColumnDesc;
import jp.co.slcs.swak.file.description.text.csv.CsvHeadDesc;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.reflect.ClassUtils;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_NengappiKbn;
import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SakujyoKbn;
import yuyu.def.classification.C_SakujyoKeyKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.meta.GenQAT_TyouhyouKensaku;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 過去データ整備バッチクラス<br/>
 */
public class KakoDataSeibiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KakoDataSeibiDao kakoDataSeibiDao;

    @Inject
    private KakoDataSeibiBatchParam batchParam;

    @Inject
    private BaseDomManager baseDomManager;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        List<AS_Sakujyotaisyo> sakujyotaisyoList = baseDomManager.getSakujyotaisyoByHozonKikan(99);

        String dir = YuyuBaseConfig.getInstance().getBatchOutputDir() + KakoDataSeibiBatchConstants.CSV_FILEDIR + BizDate.getSysDateTime();


        for (AS_Sakujyotaisyo sakujyotaisyo : sakujyotaisyoList) {

            checkSakujyotaisyoData(sakujyotaisyo);

            if (C_UmuKbn.ARI.eq(sakujyotaisyo.getDataTaihiKbn())) {
                sakujyotaisyoSeibiCsv(sakujyotaisyo, dir);

            }
        }

        for (AS_Sakujyotaisyo sakujyotaisyo : sakujyotaisyoList) {

            sakujyotaisyoSeibi(sakujyotaisyo);
        }

        List<AS_TyouhyouSakujyotaisyo> tyouhyousakujyotaisyoList = baseDomManager.getTyouhyouSakujyotaisyosByHozonKikanOut(99);

        for (AS_TyouhyouSakujyotaisyo tyouhyousakujyotaisyo : tyouhyousakujyotaisyoList) {

            String syoruiHozonKikan = tyouhyousakujyotaisyo.getHozonKikan() == null ? null:tyouhyousakujyotaisyo.getHozonKikan().toString();

            if (Strings.isNullOrEmpty(syoruiHozonKikan)) {
                throw new BizLogicException(MessageId.EAF1020, tyouhyousakujyotaisyo.getSyoruiCd().getValue());
            }

            if (!(tyouhyousakujyotaisyo.getHozonKikan() >= 0 && tyouhyousakujyotaisyo.getHozonKikan() < 99)) {
                throw new BizLogicException(MessageId.EAF1021, tyouhyousakujyotaisyo.getSyoruiCd().getValue(), syoruiHozonKikan);
            }

            if (!(C_NengetuKbn.TUKI.eq(tyouhyousakujyotaisyo.getNengetukbn())
                || C_NengetuKbn.NEN.eq(tyouhyousakujyotaisyo.getNengetukbn()))) {
                throw new BizLogicException(MessageId.EAF1022, C_NengetuKbn.TUKI.getContent(), C_NengetuKbn.NEN.getContent(),
                    tyouhyousakujyotaisyo.getSyoruiCd().getValue(), tyouhyousakujyotaisyo.getNengetukbn().getValue());
            }

            tyouhyousakujyotaisyoSeibi(tyouhyousakujyotaisyo, dir);
        }

    }

    private void checkSakujyotaisyoData(AS_Sakujyotaisyo pSakujyotaisyo) {

        String dataTaihiKbn = pSakujyotaisyo.getDataTaihiKbn() == null ? null : pSakujyotaisyo.getDataTaihiKbn().getValue();

        if (Strings.isNullOrEmpty(dataTaihiKbn)) {
            throw new BizLogicException(MessageId.EAF0068, C_UmuKbn.NONE.getContent(),
                C_UmuKbn.ARI.getContent(), pSakujyotaisyo.getSakujyoTableId(), dataTaihiKbn);
        }

        if (C_SakujyoKbn.KIGENTUKI.eq(pSakujyotaisyo.getSakujyoKbn())) {

            String hozonKikan = pSakujyotaisyo.getHozonKikan() == null ? null:pSakujyotaisyo.getHozonKikan().toString();

            String sakujyoKeyKbn = pSakujyotaisyo.getSakujyoKeyKbn() == null ? null:pSakujyotaisyo.getSakujyoKeyKbn().getValue();

            if (Strings.isNullOrEmpty(pSakujyotaisyo.getSakujyoKey())
                || Strings.isNullOrEmpty(sakujyoKeyKbn)
                || Strings.isNullOrEmpty(hozonKikan)) {

                throw new BizLogicException(MessageId.EAF0069, C_SakujyoKbn.KIGENTUKI.getContent(), pSakujyotaisyo.getSakujyoTableId(),
                    pSakujyotaisyo.getSakujyoKey(), sakujyoKeyKbn, hozonKikan);
            }

            if (!(C_SakujyoKeyKbn.NENGAPPI.eq(pSakujyotaisyo.getSakujyoKeyKbn())
                || C_SakujyoKeyKbn.JIKAN.eq(pSakujyotaisyo.getSakujyoKeyKbn()))) {
                throw new BizLogicException(MessageId.EAF0070, C_SakujyoKbn.KIGENTUKI.getContent(), C_SakujyoKeyKbn.NENGAPPI.getContent(),
                    C_SakujyoKeyKbn.JIKAN.getContent(), pSakujyotaisyo.getSakujyoTableId(), sakujyoKeyKbn);
            }

            if (!(pSakujyotaisyo.getHozonKikan() >= 0 && pSakujyotaisyo.getHozonKikan() < 99)) {
                throw new BizLogicException(MessageId.EAF0071, C_SakujyoKbn.KIGENTUKI.getContent(),
                    pSakujyotaisyo.getSakujyoTableId(), hozonKikan);
            }

            if (!(C_NengappiKbn.HI.eq(pSakujyotaisyo.getNengappiKbn())
                || C_NengappiKbn.TUKI.eq(pSakujyotaisyo.getNengappiKbn())
                || C_NengappiKbn.NEN.eq(pSakujyotaisyo.getNengappiKbn()))) {
                throw new BizLogicException(MessageId.EAF0072, C_SakujyoKbn.KIGENTUKI.getContent(), C_NengappiKbn.HI.getContent(),
                    C_NengappiKbn.TUKI.getContent(), C_NengappiKbn.NEN.getContent(), pSakujyotaisyo.getSakujyoTableId(), pSakujyotaisyo.getSakujyoKbn().getValue());
            }

        }
    }

    private void sakujyotaisyoSeibiCsv(AS_Sakujyotaisyo pTargetTable, String pDir) {
        String conditionKey = null;
        String conditionVal = null;
        String sakujyoTableId = pTargetTable.getSakujyoTableId();

        if (C_SakujyoKbn.KIGENTUKI.eq(pTargetTable.getSakujyoKbn())) {
            conditionKey = pTargetTable.getSakujyoKey();
            if (!Strings.isNullOrEmpty(conditionKey)) {
                conditionVal = getConditionVal(pTargetTable);
            }
            if (Strings.isNullOrEmpty(conditionVal)) {
                conditionKey = null;
            }
        }

        long targetDataCount = kakoDataSeibiDao.getDataCountByKey(sakujyoTableId, conditionKey, conditionVal);

        if (targetDataCount > 0) {
            BizDateFormat bdf = new BizDateFormat(KakoDataSeibiBatchConstants.YYYYMMDD);
            String fileYmd = bdf.format(batchParam.getSyoriYmd());
            String fileName = fileYmd + sakujyoTableId + KakoDataSeibiBatchConstants.CSV_FILENAME_AFTER;
            File dir = new File(pDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }
            try (ExDBResults<Object> taihiData = kakoDataSeibiDao.getDataByKey(sakujyoTableId, conditionKey, conditionVal)) {
                try (FileOutputStream out = new FileOutputStream(new File(dir, fileName))) {
                    FileEntityManager fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.CSV);
                    @SuppressWarnings("unchecked")
                    FileDescription<Object, CsvHeadDesc, CsvColumnDesc> fd = generateFileDescription(sakujyoTableId, (Class<Object>) taihiData.getClass().getSuperclass());
                    fileEntityManager.write(fd, taihiData, out);
                } catch (Exception e) {
                    throw new BizAppException(e, MessageId.EAF0066, sakujyoTableId);
                }
            }
            batchLogger.info(MessageUtil.getMessage(MessageId.IAF0007, sakujyoTableId, fileName));
        }


    }

    private void sakujyotaisyoSeibi(AS_Sakujyotaisyo pTargetTable) {
        String conditionKey = null;
        String conditionVal = null;
        String sakujyoKey = "-";
        String sakujyokijyunymd = "-";
        String sakujyoTableId = pTargetTable.getSakujyoTableId();

        if (C_SakujyoKbn.KIGENTUKI.eq(pTargetTable.getSakujyoKbn())) {
            conditionKey = pTargetTable.getSakujyoKey();
            if (!Strings.isNullOrEmpty(conditionKey)) {
                conditionVal = getConditionVal(pTargetTable);
                sakujyoKey = conditionKey;
                sakujyokijyunymd = conditionVal;
            }
            if (Strings.isNullOrEmpty(conditionVal)) {
                conditionKey = null;
            }
        }

        long tableDataCount  = kakoDataSeibiDao.getDataCountByKey(sakujyoTableId, null, null);
        long targetDataCount = kakoDataSeibiDao.getDataCountByKey(sakujyoTableId, conditionKey, conditionVal);

        if (targetDataCount == 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IAF0009, sakujyoTableId, String.valueOf(tableDataCount), sakujyoKey, sakujyokijyunymd));
            return;
        }

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.clear();

        deleteSakujyotaisyoData(sakujyoTableId, conditionKey, conditionVal, sakujyoKey, sakujyokijyunymd, tableDataCount);

    }

    void tyouhyousakujyotaisyoSeibi(AS_TyouhyouSakujyotaisyo pTyouhyousakujyotaisyo, String pDir) {

        BizDate hkikan = batchParam.getSyoriYmd();
        String resultYmd = null;

        BizDateFormat fmt = new BizDateFormat(KakoDataSeibiBatchConstants.YYYYMMDD);

        if (C_NengetuKbn.TUKI.eq(pTyouhyousakujyotaisyo.getNengetukbn())) {
            hkikan = hkikan.addMonths(-1 * pTyouhyousakujyotaisyo.getHozonKikan());
        } else if (C_NengetuKbn.NEN.eq(pTyouhyousakujyotaisyo.getNengetukbn())) {
            hkikan = hkikan.addYears(-1 * pTyouhyousakujyotaisyo.getHozonKikan());
        }

        resultYmd = fmt.format(hkikan.getRekijyou());

        long kensakuTableDataCount  = kakoDataSeibiDao.getDataCountByKey(AT_TyouhyouKensaku.TABLE_NAME, null, null);
        long kensakuTargetDataCount = kakoDataSeibiDao.getCountTyouhyouKensakuListBySyoruiCdSyoriYmd(pTyouhyousakujyotaisyo.getSyoruiCd(), hkikan.getRekijyou());

        if (kensakuTargetDataCount == 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IAF0012, AT_TyouhyouKensaku.TABLE_NAME, pTyouhyousakujyotaisyo.getSyoruiCd().getValue(), resultYmd));
            return;
        }


        if (C_UmuKbn.ARI.eq(batchParam.getTyouhyouDataTaihiKbn())) {
            outCSVByTyouhyouKensaku(pTyouhyousakujyotaisyo.getSyoruiCd(), hkikan, pDir);
        }

        try (ExDBResults<AT_TyouhyouKensaku> targetData = kakoDataSeibiDao.getTyouhyouKensakuListBySyoruiCdSyoriYmd(pTyouhyousakujyotaisyo.getSyoruiCd(), hkikan.getRekijyou())) {

            for (AT_TyouhyouKensaku tyouhyouKensaku : targetData) {
                deleteTyouhyouHozonData(tyouhyouKensaku.getReportKey(), pTyouhyousakujyotaisyo.getSyoruiCd().getValue(), resultYmd);

            }

            deleteTyouhyouKensakuData(pTyouhyousakujyotaisyo.getSyoruiCd(), hkikan.getRekijyou(), resultYmd, kensakuTableDataCount);

        } catch (Exception e) {
            throw new BizAppException(e, MessageId.EAF0067, AT_TyouhyouHozon.TABLE_NAME);
        }
    }

    @Transactional
    void deleteSakujyotaisyoData(String pSakujyoTableId, String pConditionKey, String pConditionVal, String pSakujyoKey,
        String pSakujyokijyunymd, long pTableDataCount) {
        try {
            long deleteDataCount = kakoDataSeibiDao.delDataByKey(pSakujyoTableId, pConditionKey, pConditionVal);

            batchLogger.info(MessageUtil.getMessage(MessageId.IAF0008, pSakujyoTableId, String.valueOf(deleteDataCount),
                String.valueOf(pTableDataCount), pSakujyoKey, pSakujyokijyunymd));
        } catch (Exception e) {
            throw new BizAppException(e, MessageId.EAF0067, pSakujyoTableId);
        }
    }

    private void deleteTyouhyouKensakuData(C_SyoruiCdKbn pSyoruiCd, BizDate pSakujyokijyunYmd, String pResultYmd, long pKensakuTableDataCount) {

        try {
            long deleteTyouhyouKensakuCount = kakoDataSeibiDao.deleteTyouhyouKensakuListBySyoruiCdSyoriYmd(pSyoruiCd, pSakujyokijyunYmd);

            batchLogger.info(MessageUtil.getMessage(MessageId.IAF0010, AT_TyouhyouKensaku.TABLE_NAME, pSyoruiCd.getValue(),
                String.valueOf(deleteTyouhyouKensakuCount), String.valueOf(pKensakuTableDataCount), pResultYmd));
        } catch (Exception e) {
            throw new BizAppException(e, MessageId.EAF0067, AT_TyouhyouKensaku.TABLE_NAME);
        }
    }


    private void deleteTyouhyouHozonData(String pReportKey, String pSyoruiCd, String pSakujyokijyunYmd) {

        try {
            long deleteTyouhyouHozonCount = kakoDataSeibiDao.deleteTyouhyouHozonByReportKey(pReportKey);

            if (deleteTyouhyouHozonCount > 0) {
                batchLogger.info(MessageUtil.getMessage(MessageId.IAF0011, AT_TyouhyouHozon.TABLE_NAME, pSyoruiCd, pReportKey, pSakujyokijyunYmd));
            }
        } catch (Exception e) {
            throw new BizAppException(e, MessageId.EAF0067, AT_TyouhyouKensaku.TABLE_NAME);
        }
    }

    private String getConditionVal(AS_Sakujyotaisyo pTargetTable) {

        String resultYmd = null;
        BizDate hkikan = null;
        if (C_NengappiKbn.NEN.eq(pTargetTable.getNengappiKbn())) {
            hkikan = batchParam.getSyoriYmd().addYears(-1 * pTargetTable.getHozonKikan());
        } else if (C_NengappiKbn.TUKI.eq(pTargetTable.getNengappiKbn())) {
            hkikan = batchParam.getSyoriYmd().addMonths(-1 * pTargetTable.getHozonKikan());
        } else if (C_NengappiKbn.HI.eq(pTargetTable.getNengappiKbn())) {
            hkikan = batchParam.getSyoriYmd().addDays(-1 * pTargetTable.getHozonKikan());
        }
        if (hkikan != null) {
            BizDateFormat fmt = null;
            if (C_SakujyoKeyKbn.JIKAN.eq(pTargetTable.getSakujyoKeyKbn())) {
                fmt = new BizDateFormat(KakoDataSeibiBatchConstants.YYYYMMDD_MS);
            } else if (C_SakujyoKeyKbn.NENGAPPI.eq(pTargetTable.getSakujyoKeyKbn())) {
                fmt = new BizDateFormat(KakoDataSeibiBatchConstants.YYYYMMDD);
            }
            if (fmt != null) {
                resultYmd = fmt.format(hkikan.getRekijyou());
            }
        }
        return resultYmd;
    }

    private FileDescription<Object, CsvHeadDesc, CsvColumnDesc> generateFileDescription(String pTableId,
        Class<Object> pEntityClass) {
        CsvHeadDesc chd = new CsvHeadDesc();
        List<CsvColumnDesc> ccdList = Lists.newArrayList();
        Class<?> metaClass = null;
        try {
            metaClass = ClassUtils.loadClass(KakoDataSeibiBatchConstants.CLASS_FIELD_BEGIN + pTableId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Field[] fs = metaClass.getDeclaredFields();
        getField(ccdList, fs);
        Field[] fss = metaClass.getSuperclass().getDeclaredFields();
        getField(ccdList, fss);

        return new FileDescription<>(pEntityClass, chd, ccdList.toArray(new CsvColumnDesc[ccdList.size()]));
    }

    private void getField(List<CsvColumnDesc> pCcdList, Field[] pFs) {
        CsvColumnDesc ccd = null;
        for (Field f : pFs) {
            if (ExDBField.class.isAssignableFrom(f.getType())) {
                ccd = new CsvColumnDesc(f.getName());
                ccd.setLabel(f.getName());
                pCcdList.add(ccd);
            }
        }
    }

    private void outCSVByTyouhyouKensaku(C_SyoruiCdKbn pSyoruiCd, BizDate pHkikan, String pDir) {

        BizDateFormat bdf = new BizDateFormat(KakoDataSeibiBatchConstants.YYYYMMDD);
        String fileYmd = bdf.format(batchParam.getSyoriYmd());
        String fileName = fileYmd + AT_TyouhyouKensaku.TABLE_NAME + "_" + pSyoruiCd
            + KakoDataSeibiBatchConstants.CSV_FILENAME_AFTER;

        try (ExDBResults<AT_TyouhyouKensaku> targetData = kakoDataSeibiDao.getTyouhyouKensakuListBySyoruiCdSyoriYmd(pSyoruiCd, pHkikan.getRekijyou())) {

            File dir = new File(pDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try (FileOutputStream out = new FileOutputStream(new File(dir, fileName))) {
                FileEntityManager fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.CSV);

                CsvHeadDesc chd = new CsvHeadDesc();
                List<CsvColumnDesc> ccdList = Lists.newArrayList();
                Class<?> metaClass = GenQAT_TyouhyouKensaku.class;

                Field[] fs = metaClass.getDeclaredFields();
                getField(ccdList, fs);
                Field[] fss = metaClass.getSuperclass().getDeclaredFields();
                getField(ccdList, fss);
                FileDescription<AT_TyouhyouKensaku, CsvHeadDesc, CsvColumnDesc> fd
                = new FileDescription<AT_TyouhyouKensaku, CsvHeadDesc, CsvColumnDesc>(AT_TyouhyouKensaku.class, chd, ccdList.toArray(new CsvColumnDesc[ccdList.size()]));

                fileEntityManager.write(fd, targetData, out);

            } catch (Exception e) {
                throw new BizAppException(e, MessageId.EAF0066, AT_TyouhyouKensaku.TABLE_NAME);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAF0007, AT_TyouhyouKensaku.TABLE_NAME, fileName));
    }

}
