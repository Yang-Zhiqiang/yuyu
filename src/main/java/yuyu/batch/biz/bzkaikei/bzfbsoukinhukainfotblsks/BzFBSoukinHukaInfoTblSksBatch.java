package yuyu.batch.biz.bzkaikei.bzfbsoukinhukainfotblsks;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzfbsoukinhukainfotblsks.dba.BzFBSoukinHukaInfoTblSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 ＦＢ送金付加情報テーブル作成
 */
public class BzFBSoukinHukaInfoTblSksBatch implements Batch {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzFBSoukinHukaInfoTblSksDao bzFBSoukinHukaInfoTblSksDao;

    private static final String ONLINEAFTER = "RGDED000";

    private static final String FBSOUKINDATAFIRUTA = "Bz107";

    private static final String GYOMUKBN = "89";

    private int count = 0;

    private Map<String, Integer> kokcdNoMap = new HashMap<>();

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        C_Tantositucd tantosituCd = C_Tantositucd.BLNK0;

        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

        int renbanSanKeta = 0;

        int renbanYonKeta = 0;

        C_FbSoukinBatchKbn fbSoukinBatchKbn = C_FbSoukinBatchKbn.NONE;

        String mapKey = "";

        Integer mapValue = 0;

        if (ONLINEAFTER.equals(bzBatchParam.getIbKakutyoujobcd())){

            fbSoukinBatchKbn = C_FbSoukinBatchKbn.NONE;
        }
        else {

            fbSoukinBatchKbn = C_FbSoukinBatchKbn.BATCH;
        }

        try (ExDBUpdatableResults<BT_FBSoukinData> soukinDataLst =
            bzFBSoukinHukaInfoTblSksDao.getAtesakiAriFBSoukinHukaInfoDatas(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd(), fbSoukinBatchKbn)) {

            for (BT_FBSoukinData soukinData : soukinDataLst) {

                String kokcd = "";

                BT_FBSoukinHukaInfo soukinHukaInfo = soukinData.createFBSoukinHukaInfo();

                BM_FBSoukinListKanri fBSoukinListKanri = soukinData.getFBSoukinListKanri();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_FBSoukinData.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FBSOUKINDATAFIRUTA);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(soukinData.getFbsoukindatasikibetukey());

                if (!tantosituCd.eq(fBSoukinListKanri.getTantositucd()) ||
                    !shrhousiteiKbn.eq(soukinData.getShrhousiteikbn())){

                    renbanSanKeta = 0;
                    renbanYonKeta = 0;
                }

                if (soukinData.getGyoumucd().eq(C_Gyoumucd.GK_YENSOUKIN_KH_SI)){

                    renbanSanKeta++;
                    kokcd = String.format("%02d", soukinData.getDenymd().getDay()) +
                        fBSoukinListKanri.getTantositucd().toString() + GYOMUKBN + String.format("%03d", renbanSanKeta);
                    mapKey = fBSoukinListKanri.getTantositucd().toString()
                        + soukinData.getShrhousiteikbn().toString();
                    mapValue = renbanSanKeta;
                }
                else {
                    renbanYonKeta++;
                    kokcd = String.format("%02d", soukinData.getDenymd().getDay()) +
                        soukinData.getGyoumucd().toString() + String.format("%04d", renbanYonKeta);
                    mapKey = fBSoukinListKanri.getTantositucd().toString()
                        + soukinData.getShrhousiteikbn().toString();
                    mapValue = renbanYonKeta;
                }

                soukinHukaInfo.setKokcd1(kokcd);

                BizPropertyInitializer.initialize(soukinHukaInfo);

                count++;

                tantosituCd = fBSoukinListKanri.getTantositucd();

                shrhousiteiKbn = soukinData.getShrhousiteikbn();

                kokcdNoMap.put(mapKey, mapValue);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            atesakiHumeiKokcdEdit();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    private void atesakiHumeiKokcdEdit() {

        int renbanSanKeta = 0;

        int renbanYonKeta = 0;

        C_FbSoukinBatchKbn fbSoukinBatchKbn = C_FbSoukinBatchKbn.NONE;

        String mapKey = "";

        Integer mapValue = 0;

        if (ONLINEAFTER.equals(bzBatchParam.getIbKakutyoujobcd())) {

            fbSoukinBatchKbn = C_FbSoukinBatchKbn.NONE;
        }
        else {

            fbSoukinBatchKbn = C_FbSoukinBatchKbn.BATCH;
        }

        try (ExDBUpdatableResults<BT_FBSoukinData> soukinDataLst =
            bzFBSoukinHukaInfoTblSksDao.getAtesakiHumeiFBSoukinHukaInfoDatas(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd(), fbSoukinBatchKbn)) {

            if (soukinDataLst == null) {
                return;
            }

            for (BT_FBSoukinData soukinData : soukinDataLst) {

                String kokcd = "";

                BT_FBSoukinHukaInfo soukinHukaInfo = soukinData.createFBSoukinHukaInfo();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_FBSoukinData.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FBSOUKINDATAFIRUTA);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(soukinData.getFbsoukindatasikibetukey());

                BM_Syoritanto syoritanto = bizDomManager.getSyoritanto(soukinData.getSyoricd());
                C_TantouCdKbn tantouCdKbn = syoritanto.getTantocd();

                BM_TantouCd bMTantouCd = bizDomManager.getTantouCd(tantouCdKbn);
                String tantositucd = bMTantouCd.getBusitucd();

                mapKey = tantositucd + soukinData.getShrhousiteikbn().toString();

                if (kokcdNoMap.get(mapKey) == null) {

                    mapValue = 0;

                    kokcdNoMap.put(mapKey, mapValue);
                }

                if (C_Gyoumucd.GK_YENSOUKIN_KH_SI.eq(soukinData.getGyoumucd())) {

                    renbanSanKeta = kokcdNoMap.get(mapKey) + 1;
                    kokcd = String.format("%02d", soukinData.getDenymd().getDay()) +
                        tantositucd + GYOMUKBN + String.format("%03d", renbanSanKeta);
                    mapValue = renbanSanKeta;
                }
                else {
                    renbanYonKeta = kokcdNoMap.get(mapKey) + 1;
                    kokcd = String.format("%02d", soukinData.getDenymd().getDay()) +
                        soukinData.getGyoumucd().toString() + String.format("%04d", renbanYonKeta);
                    mapValue = renbanYonKeta;
                }

                soukinHukaInfo.setKokcd1(kokcd);

                BizPropertyInitializer.initialize(soukinHukaInfo);

                count++;

                kokcdNoMap.put(mapKey, mapValue);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
