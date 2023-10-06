package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshtkin;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshtkin.dba.BzSikinIdouListDataSksHtkinDao;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshtkin.dba.HtkinSikinIdouWkBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.entity.BW_HtkinSikinIdouListSksWk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成(配当金)
 */
public class BzSikinIdouListDataSksHtkinBatch implements Batch{

    private static final String TABLEID = "BW_HtkinSikinIdouWk";

    private static final String FILTERID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzSikinIdouListDataSksHtkinDao bzSikinIdouListDataSksHtkinDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        long syoriKensuu = 0;

        bzSikinIdouListDataSksHtkinDao.delAllHtkinSikinIdouListSksWk();

        try (
            ExDBResults<HtkinSikinIdouWkBean> htkinSikinIdouWkBeanLst =
            bzSikinIdouListDataSksHtkinDao.getAllHtkinSikinIdouWkBeans(bzBatchParam.getIbKakutyoujobcd());

            EntityInserter<BW_HtkinSikinIdouListSksWk> htkinSikinIdouListSksWkList = new EntityInserter<>()) {

            for (HtkinSikinIdouWkBean htkinSikinIdouWkBean : htkinSikinIdouWkBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(htkinSikinIdouWkBean.getSyono());

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                BizCurrency siteituukagk = keisanGaikakanzan.execDivide(htkinSikinIdouWkBean.getKyktuukasyu(),
                    htkinSikinIdouWkBean.getSeisikiwariategaku(),
                    htkinSikinIdouWkBean.getSikinidoukawaserate(), C_HasuusyoriKbn.AGE);

                BM_SikinIdouGroup sikinIdouGroup = bizDomManager.getSikinIdouGroup(htkinSikinIdouWkBean.getSeg1cd());

                C_SikinidougroupKbn sikinidougroupKbn = null;

                if(sikinIdouGroup == null){

                    sikinidougroupKbn = C_SikinidougroupKbn.BLNK;
                }
                else{

                    sikinidougroupKbn = sikinIdouGroup.getSikinidougroupkbn();
                }

                BW_HtkinSikinIdouListSksWk htkinSikinIdouListSksWk = new BW_HtkinSikinIdouListSksWk();

                htkinSikinIdouListSksWk.setSyono(htkinSikinIdouWkBean.getSyono());
                htkinSikinIdouListSksWk.setKijyunymd(htkinSikinIdouWkBean.getKijyunymd());
                htkinSikinIdouListSksWk.setHaitounendo(htkinSikinIdouWkBean.getHaitounendo());
                htkinSikinIdouListSksWk.setSiteituuka(htkinSikinIdouWkBean.getKyktuukasyu());
                htkinSikinIdouListSksWk.setSiteituukagk(siteituukagk);
                htkinSikinIdouListSksWk.setTrhktuuka(C_Tuukasyu.JPY);
                htkinSikinIdouListSksWk.setTrhktuukagk(htkinSikinIdouWkBean.getSeisikiwariategaku());
                htkinSikinIdouListSksWk.setSeg1cd(htkinSikinIdouWkBean.getSeg1cd());
                htkinSikinIdouListSksWk.setSikinidougroupkbn(sikinidougroupKbn);
                htkinSikinIdouListSksWk.setSikinidoukawaserate(htkinSikinIdouWkBean.getSikinidoukawaserate());

                BizPropertyInitializer.initialize(htkinSikinIdouListSksWk);

                htkinSikinIdouListSksWkList.add(htkinSikinIdouListSksWk);

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }
    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
