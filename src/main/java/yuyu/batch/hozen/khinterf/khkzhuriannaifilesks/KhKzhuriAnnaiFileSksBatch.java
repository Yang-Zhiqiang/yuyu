package yuyu.batch.hozen.khinterf.khkzhuriannaifilesks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khkzhuriannaifilesks.dba.KhKzhuriAnnaiDataBean;
import yuyu.batch.hozen.khinterf.khkzhuriannaifilesks.dba.KhKzhuriAnnaiFileSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhKouzahuriAnnaiData;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 口座振替案内Ｆ作成
 */
public class KhKzhuriAnnaiFileSksBatch implements Batch {

    private static final String TABLEID = IT_KhKouzahuriAnnaiData.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhKzhuriAnnaiFileSksBatchParam khKzhuriAnnaiFileSksBatchParam;

    @Inject
    private KhKzhuriAnnaiFileSksDao khKzhuriAnnaiFileSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return khKzhuriAnnaiFileSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(khKzhuriAnnaiFileSksBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), khKzhuriAnnaiFileSksBatchParam.getIbKakutyoujobcd()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025,
            khKzhuriAnnaiFileSksBatchParam.getHeisoukbn()));

        long syoriKensuu = 0;
        String kakutyoujobCd = khKzhuriAnnaiFileSksBatchParam.getIbKakutyoujobcd();
        BizDate syoriYMD = khKzhuriAnnaiFileSksBatchParam.getSyoriYmd();
        String kbnkey = khKzhuriAnnaiFileSksBatchParam.getHeisoukbn();

        try ( ExDBResults<KhKzhuriAnnaiDataBean> khKzhuriAnnaiDataBeanLst =
            khKzhuriAnnaiFileSksDao.getKzhuriAnnaiDataBeans(kakutyoujobCd, syoriYMD, kbnkey);

            EntityInserter<ZT_KzhuriAnnaiUlfTy> inserter = new EntityInserter<>();) {

            for (KhKzhuriAnnaiDataBean khKzhuriAnnaiDataBean : khKzhuriAnnaiDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khKzhuriAnnaiDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khKzhuriAnnaiDataBean.getSyono());

                BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
                String yokinKbn = bzKbnHenkanUtil.convKbn(khKzhuriAnnaiDataBean.getYokinKbn().getValue(),
                    C_YokinKbn.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();
                String sinkeizkKbn = "";
                if(C_SinkeizkKbn.SHINKI.eq(khKzhuriAnnaiDataBean.getSinkeizkKbn())){
                    sinkeizkKbn = "1";
                }
                if(C_SinkeizkKbn.KEIZOKU.eq(khKzhuriAnnaiDataBean.getSinkeizkKbn())){
                    sinkeizkKbn = "0";
                }
                if(C_SinkeizkKbn.HENKOU.eq(khKzhuriAnnaiDataBean.getSinkeizkKbn())){
                    sinkeizkKbn = "2";
                }
                String nyknaiyou = bzKbnHenkanUtil.convKbn(khKzhuriAnnaiDataBean.getNyknaiyouKbn().getValue(),
                    C_NyknaiyouKbn.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();
                String hrkkaisuuKbn = bzKbnHenkanUtil.convKbn(khKzhuriAnnaiDataBean.getHrkKaisuu().getValue(),
                    C_Hrkkaisuu.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();

                String kzhuriSyuudaikoKbn ="";
                if (C_Syuudaikocd.CSS.eq(khKzhuriAnnaiDataBean.getSyuudaikoCd())) {

                    kzhuriSyuudaikoKbn = "1";
                }

                ZT_KzhuriAnnaiUlfTy kzhuriAnnaiUlfTy = new ZT_KzhuriAnnaiUlfTy();
                kzhuriAnnaiUlfTy.setZtysyono(khKzhuriAnnaiDataBean.getSyono());
                kzhuriAnnaiUlfTy.setZtykzhurikaebankcd(khKzhuriAnnaiDataBean.getBankCd());
                kzhuriAnnaiUlfTy.setZtykzhurikaesitencd(khKzhuriAnnaiDataBean.getSitenCd());
                kzhuriAnnaiUlfTy.setZtykzhurikaeyokinkbn(yokinKbn);
                kzhuriAnnaiUlfTy.setZtykzhurikaekouzano(khKzhuriAnnaiDataBean.getKouzaNo());
                kzhuriAnnaiUlfTy.setZtykzhurikaeannaikbn(sinkeizkKbn);
                if (khKzhuriAnnaiDataBean.getHurikaeYmd() != null) {
                    kzhuriAnnaiUlfTy.setZtyhurikaeymd(khKzhuriAnnaiDataBean.getHurikaeYmd().toString());
                }
                kzhuriAnnaiUlfTy.setZtyrsgaku(Long.valueOf(khKzhuriAnnaiDataBean.getRsGaku().toAdsoluteString()));
                kzhuriAnnaiUlfTy.setZtyjyuutouym(khKzhuriAnnaiDataBean.getJyuutouYm().toString());
                kzhuriAnnaiUlfTy.setZtyjyuutounensuu(String.valueOf(khKzhuriAnnaiDataBean.getJyutouKaisuuy()));
                kzhuriAnnaiUlfTy.setZtyjyuutoutukisuu(String.valueOf(khKzhuriAnnaiDataBean.getJyutouKaisuum()));
                kzhuriAnnaiUlfTy.setZtydantaikobetukbn(khKzhuriAnnaiDataBean.getDantaikobetuKbn());
                kzhuriAnnaiUlfTy.setZtykykymd(khKzhuriAnnaiDataBean.getKykYmd().toString());
                kzhuriAnnaiUlfTy.setZtynyknaiyou(nyknaiyou);
                kzhuriAnnaiUlfTy.setZtyaatukaisosikicd("0000000");
                kzhuriAnnaiUlfTy.setZtyhrkkaisuukbn(hrkkaisuuKbn);
                kzhuriAnnaiUlfTy.setZtykzhurikaetkbtannaihyj("0");
                kzhuriAnnaiUlfTy.setZtyaatukaikojincd("000000");
                kzhuriAnnaiUlfTy.setZtybsyym("000000");
                kzhuriAnnaiUlfTy.setZtyteikeisyouhinhyj("0");
                kzhuriAnnaiUlfTy.setZtykzmeiginmei(khKzhuriAnnaiDataBean.getKzMeiginmKn());
                kzhuriAnnaiUlfTy.setZtykeizokupnaiyoukbn("00");
                kzhuriAnnaiUlfTy.setZtyhisaijiannaitsghyj("0");
                kzhuriAnnaiUlfTy.setZtykzhurisyuudaikokbn(kzhuriSyuudaikoKbn);
                BizPropertyInitializer.initialize(kzhuriAnnaiUlfTy);

                khKzhuriAnnaiFileSksDao.addInsertEntity(inserter, kzhuriAnnaiUlfTy);

                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, kbnkey));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}