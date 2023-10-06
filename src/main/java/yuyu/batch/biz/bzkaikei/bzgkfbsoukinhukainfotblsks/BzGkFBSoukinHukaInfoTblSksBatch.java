package yuyu.batch.biz.bzkaikei.bzgkfbsoukinhukainfotblsks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzgkfbsoukinhukainfotblsks.dba.BzGkFBSoukinHukaInfoTblSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_SeisanDShrymd;
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金付加情報テーブル作成
 */
public class BzGkFBSoukinHukaInfoTblSksBatch implements Batch {

    private static final String FILTERID = "Bz107";

    private static final String GAIKASOUKINKIGOU = "A";

    private static final String GYOMUKBN = "90";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzGkFBSoukinHukaInfoTblSksDao bzGkFBSoukinHukaInfoTblSksDao;

    private int count = 0;

    private Map<String, Integer> kokcdNoMap = new HashMap<>();

    private BizDate soudaikaiNexteigyoubi = null;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        C_Tantositucd tantositucd = C_Tantositucd.BLNK0;

        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

        int renbanYonKeta = 0;

        BizDate soukinyoteiYmd = null;

        String shikibetubangou = "";

        String mapKey = "";

        Integer mapValue = 0;

        soudaikaiNexteigyoubi = null;

        BM_SeisanDShrymd seisanDShrymd = bizDomManager.getSeisanDShrymd(bzBatchParam.getSyoriYmd().getBizDateY());

        if (seisanDShrymd != null) {
            soudaikaiNexteigyoubi = seisanDShrymd.getSeisandshrymd();
        }

        try (ExDBUpdatableResults<BT_GkFBSoukinData> gkFBSoukinDataLst =
            bzGkFBSoukinHukaInfoTblSksDao.getAtesakiAriGkFBSoukinHukaInfoDatas(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd());) {

            for (BT_GkFBSoukinData gkFBSoukinData : gkFBSoukinDataLst) {

                String trhksyoukaino = "";

                BT_GkFBSoukinHukaInfo gkFBSoukinHukaInfo = gkFBSoukinData.createGkFBSoukinHukaInfo();

                BM_FBSoukinListKanri fBSoukinListKanri = gkFBSoukinData.getFBSoukinListKanri();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_GkFBSoukinData.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(gkFBSoukinData.getFbsoukindatasikibetukey());

                if (!tantositucd.eq(fBSoukinListKanri.getTantositucd()) ||
                    !shrhousiteiKbn.eq(gkFBSoukinData.getShrhousiteikbn())) {

                    renbanYonKeta = 0;
                }

                if (C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(gkFBSoukinData.getShrhousiteikbn())) {

                    soukinyoteiYmd = gkFBSoukinData.getSyoriYmd().addDays(2);
                }
                else if(C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI.eq(gkFBSoukinData.getShrhousiteikbn())){

                    soukinyoteiYmd = soudaikaiNexteigyoubi;
                }
                else {

                    soukinyoteiYmd = gkFBSoukinData.getSyoriYmd().addDays(3);
                }

                if (BizDateUtil.compareYmd(soukinyoteiYmd, gkFBSoukinData.getDenymd()) == BizDateUtil.COMPARE_EQUAL) {

                    shikibetubangou = "0";
                }
                else {

                    shikibetubangou = String.valueOf(BizDateUtil.calcDifferenceDays(gkFBSoukinData.getDenymd(),
                        soukinyoteiYmd));
                }

                renbanYonKeta++;

                if (C_Gkgyoumucd.GK_GKSOUKIN_KH_SI.eq(gkFBSoukinData.getGkgyoumucd())) {

                    trhksyoukaino = GAIKASOUKINKIGOU + String.format("%02d", gkFBSoukinData.getDenymd().getDay()) +
                        fBSoukinListKanri.getTantositucd().getValue() + GYOMUKBN +
                        shikibetubangou.substring(shikibetubangou.length() - 1) +
                        String.format("%04d", renbanYonKeta);
                }
                else {

                    trhksyoukaino = GAIKASOUKINKIGOU + String.format("%02d", gkFBSoukinData.getDenymd().getDay()) +
                        gkFBSoukinData.getGkgyoumucd().getValue() +
                        shikibetubangou.substring(shikibetubangou.length() - 1) + String.format("%04d", renbanYonKeta);
                }

                mapKey = fBSoukinListKanri.getTantositucd().toString() + gkFBSoukinData.getShrhousiteikbn().toString();

                mapValue = renbanYonKeta;

                kokcdNoMap.put(mapKey, mapValue);

                gkFBSoukinHukaInfo.setFbtrhksyoukaino(trhksyoukaino);
                BizPropertyInitializer.initialize(gkFBSoukinHukaInfo);

                count++;
                tantositucd = fBSoukinListKanri.getTantositucd();
                shrhousiteiKbn = gkFBSoukinData.getShrhousiteikbn();

                kokcdNoMap.put(mapKey, mapValue);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            editAtesakiFbtrhksyoukaino();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    private void editAtesakiFbtrhksyoukaino() {

        C_TantouCdKbn tantouCdKbn = C_TantouCdKbn.BLNK0;

        String tantositucd = "";

        int renbanYonKeta = 0;

        BizDate soukinyoteiYmd = null;

        String shikibetubangou = "";

        String mapKey = "";

        Integer mapValue = 0;

        try (ExDBUpdatableResults<BT_GkFBSoukinData> gkFBSoukinDataLst =
            bzGkFBSoukinHukaInfoTblSksDao.getAtesakiHumeiGkFBSoukinHukaInfoDatas(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd());) {

            Iterator<BT_GkFBSoukinData> gkFBSoukinDataLstIter = gkFBSoukinDataLst.iterator();

            if (!gkFBSoukinDataLstIter.hasNext()) {

                return;
            }

            while (gkFBSoukinDataLstIter.hasNext()) {

                BT_GkFBSoukinData gkFBSoukinData = gkFBSoukinDataLstIter.next();

                String trhksyoukaino = "";

                BT_GkFBSoukinHukaInfo gkFBSoukinHukaInfo = gkFBSoukinData.createGkFBSoukinHukaInfo();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_GkFBSoukinData.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(gkFBSoukinData.getFbsoukindatasikibetukey());

                BM_Syoritanto syoritanto = bizDomManager.getSyoritanto(gkFBSoukinData.getSyoricd());
                tantouCdKbn = syoritanto.getTantocd();

                BM_TantouCd bMTantouCd = bizDomManager.getTantouCd(tantouCdKbn);
                tantositucd = bMTantouCd.getBusitucd();

                mapKey = tantositucd + gkFBSoukinData.getShrhousiteikbn().toString();

                if (kokcdNoMap.get(mapKey) == null) {

                    mapValue = 0;

                    kokcdNoMap.put(mapKey, mapValue);
                }

                if (C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(gkFBSoukinData.getShrhousiteikbn())) {

                    soukinyoteiYmd = gkFBSoukinData.getSyoriYmd().addDays(2);
                }
                else if (C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI.eq(gkFBSoukinData.getShrhousiteikbn())) {

                    soukinyoteiYmd = soudaikaiNexteigyoubi;
                }
                else {

                    soukinyoteiYmd = gkFBSoukinData.getSyoriYmd().addDays(3);
                }

                if (BizDateUtil.compareYmd(soukinyoteiYmd, gkFBSoukinData.getDenymd()) == BizDateUtil.COMPARE_EQUAL) {

                    shikibetubangou = "0";
                }
                else {

                    shikibetubangou = String.valueOf(BizDateUtil.calcDifferenceDays(gkFBSoukinData.getDenymd(),
                        soukinyoteiYmd));
                }

                renbanYonKeta = kokcdNoMap.get(mapKey) + 1;

                mapValue = renbanYonKeta;

                if (C_Gkgyoumucd.GK_GKSOUKIN_KH_SI.eq(gkFBSoukinData.getGkgyoumucd())) {

                    trhksyoukaino = GAIKASOUKINKIGOU + String.format("%02d", gkFBSoukinData.getDenymd().getDay()) +
                        tantositucd + GYOMUKBN +
                        shikibetubangou.substring(shikibetubangou.length() - 1) +
                        String.format("%04d", renbanYonKeta);
                }
                else {

                    trhksyoukaino = GAIKASOUKINKIGOU + String.format("%02d", gkFBSoukinData.getDenymd().getDay()) +
                        gkFBSoukinData.getGkgyoumucd().getValue() +
                        shikibetubangou.substring(shikibetubangou.length() - 1) + String.format("%04d", renbanYonKeta);
                }

                gkFBSoukinHukaInfo.setFbtrhksyoukaino(trhksyoukaino);

                BizPropertyInitializer.initialize(gkFBSoukinHukaInfo);

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
