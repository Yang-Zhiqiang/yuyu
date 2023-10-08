package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnykgk;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnykgk.dba.BzSikinIdouListDataSksHijynbrNykGkDao;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnykgk.dba.HijynbrNykGkDataBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnykgk.dba.KihrkmpSeisanRirekiDataBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.kaikei.BzSikinIdouHanteiInfoSyutoku;
import yuyu.common.biz.kaikei.SikinIdouHanteiInfoDataBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_GkhnkzidourtKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.entity.BT_HijynNykSiknIdouLstSksGk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成(平準払入金外貨)
 */
public class BzSikinIdouListDataSksHijynbrNykGkBatch implements Batch {

    private static final String TABLE_ID = "IT_KykKihon";

    private static final String FILTER_ID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzSikinIdouListDataSksHijynbrNykGkDao bzSikinIdouListDataSksHijynbrNykGkDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private BizDate syoriYmd;

    private long syoriKensuu;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();

        syoriKensuu = 0;

        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        String syono = "";

        Integer renno = 1;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
        bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);

        try (
            ExDBResults<HijynbrNykGkDataBean> hijynbrNykGkDataBeanLst =
            bzSikinIdouListDataSksHijynbrNykGkDao.getHijynbrNykGkDataBeans(kakutyouJobCd, syoriYmd);

            ExDBResults<KihrkmpSeisanRirekiDataBean> kihrkmpSeisanRirekiDataBeanLst =
                bzSikinIdouListDataSksHijynbrNykGkDao.getKihrkmpSeisanRirekiDataBeans(kakutyouJobCd, syoriYmd);

            EntityInserter<BT_HijynNykSiknIdouLstSksGk> hijynNykSiknIdouLstSksGkList = new EntityInserter<>()){

            BzSikinIdouHanteiInfoSyutoku bzSikinIdouHanteiInfoSyutoku = SWAKInjector.getInstance(BzSikinIdouHanteiInfoSyutoku.class);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            bzSikinIdouHanteiInfoSyutoku.initSikinIdouHanteiInfoData();

            for (HijynbrNykGkDataBean hijynbrNykGkDataBean : hijynbrNykGkDataBeanLst) {

                C_SikinidougroupKbn sikinidougroupKbn = C_SikinidougroupKbn.BLNK;
                C_SikinidoumeisaiKbn sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.BLNK;
                C_SikinidouJtKbn sikinidouJtKbn = C_SikinidouJtKbn.BLNK;

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hijynbrNykGkDataBean.getSyono());

                SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoDataBean =
                    bzSikinIdouHanteiInfoSyutoku.getMultipleSikinIdouHanteiInfoDataBean(hijynbrNykGkDataBean.getSegcd());

                if (C_Nykkeiro.SKEI.eq(hijynbrNykGkDataBean.getNykkeiro())) {

                    if (C_GkhnkzidourtKbn.GKKZDIRECT.eq(sikinIdouHanteiInfoDataBean.getFstpGkhnkzidouRt()) &&
                        C_GkhnkzidourtKbn.GKKZDIRECT.eq(sikinIdouHanteiInfoDataBean.getZenkiZennouGkhnkzidouRt())) {

                        if (BizDateUtil.compareYmd(hijynbrNykGkDataBean.getNyktrksymd(), syoriYmd) != BizDateUtil.COMPARE_EQUAL ||
                            hijynbrNykGkDataBean.getIkkatuyoupkaisuu() <= 1) {

                            continue;
                        }

                    }
                    else {

                        continue;
                    }
                }

                if (C_Nykkeiro.ZENNOUJYUUTOU.eq(hijynbrNykGkDataBean.getNykkeiro()) &&
                    C_NyknaiyouKbn.ZENNOUP.eq(hijynbrNykGkDataBean.getNyknaiyoukbn())) {

                    if (C_GkhnkzidourtKbn.GKKZDIRECT.eq(sikinIdouHanteiInfoDataBean.getZenkiZennouGkhnkzidouRt())) {

                        continue;
                    }

                    continue;
                }

                C_SikinidouPKbn sikinidouPKbn = C_SikinidouPKbn.KEIZOKUP;

                if (syono.equals(hijynbrNykGkDataBean.getSyono())) {

                    renno++;
                }
                else {

                    syono = hijynbrNykGkDataBean.getSyono();

                    renno = 1;
                }

                C_Tuukasyu siteituuka = henkanTuuka.henkanTuukaTypeToKbn(hijynbrNykGkDataBean.getHrkp().getType());

                BM_SikinIdouGroup sikinIdouGroup = bizDomManager.getSikinIdouGroup(hijynbrNykGkDataBean.getSegcd());

                if (sikinIdouGroup != null) {

                    sikinidougroupKbn = sikinIdouGroup.getSikinidougroupkbn();
                }

                if (BizDateUtil.compareYmd(syoriYmd, hijynbrNykGkDataBean.getNyksyoriymd()) == BizDateUtil.COMPARE_EQUAL) {

                    sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.BLNK;

                    sikinidouJtKbn = C_SikinidouJtKbn.SIKINIDOUMIRYOU;
                }

                if (BizDateUtil.compareYmd(syoriYmd, hijynbrNykGkDataBean.getNyktrksymd()) == BizDateUtil.COMPARE_EQUAL) {

                    sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.NYUUKINTORIKESI;

                    sikinidouJtKbn = C_SikinidouJtKbn.SIKINIDOUTORIKESI;
                }

                BT_HijynNykSiknIdouLstSksGk hijynNykSiknIdouLstSksGk = new BT_HijynNykSiknIdouLstSksGk();

                hijynNykSiknIdouLstSksGk.setSyoriYmd(syoriYmd);
                hijynNykSiknIdouLstSksGk.setSikinidoupkbn(sikinidouPKbn);
                hijynNykSiknIdouLstSksGk.setSyono(hijynbrNykGkDataBean.getSyono());
                hijynNykSiknIdouLstSksGk.setRenno(renno);
                hijynNykSiknIdouLstSksGk.setSiteituuka(siteituuka);
                hijynNykSiknIdouLstSksGk.setSiteituukagk(hijynbrNykGkDataBean.getHrkp());
                hijynNykSiknIdouLstSksGk.setTrhktuuka(hijynbrNykGkDataBean.getRstuukasyu());
                hijynNykSiknIdouLstSksGk.setTrhktuukagk(hijynbrNykGkDataBean.getRsgaku());
                hijynNykSiknIdouLstSksGk.setSeg1cd(hijynbrNykGkDataBean.getSegcd());
                hijynNykSiknIdouLstSksGk.setSikinidougroupkbn(sikinidougroupKbn);
                hijynNykSiknIdouLstSksGk.setSikinidoumeisaikbn(sikinidoumeisaiKbn);
                hijynNykSiknIdouLstSksGk.setSikinidoujtkbn(sikinidouJtKbn);
                hijynNykSiknIdouLstSksGk.setSikinidoukawaserate(hijynbrNykGkDataBean.getRyosyukwsrate());

                BizPropertyInitializer.initialize(hijynNykSiknIdouLstSksGk);

                hijynNykSiknIdouLstSksGkList.add(hijynNykSiknIdouLstSksGk);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            for (KihrkmpSeisanRirekiDataBean kihrkmpSeisanRirekiDataBean : kihrkmpSeisanRirekiDataBeanLst) {

                C_SikinidougroupKbn sikinidougroupKbn = C_SikinidougroupKbn.BLNK;

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kihrkmpSeisanRirekiDataBean.getSyono());

                C_Tuukasyu siteituuka = henkanTuuka.henkanTuukaTypeToKbn(
                    kihrkmpSeisanRirekiDataBean.getTuityouk().getType());

                C_Tuukasyu trhktuuka =  henkanTuuka.henkanTuukaTypeToKbn(
                    kihrkmpSeisanRirekiDataBean.getYenkansantuityoukin().getType());

                BM_SikinIdouGroup sikinIdouGroup = bizDomManager.getSikinIdouGroup(kihrkmpSeisanRirekiDataBean.getSegcd());

                if (sikinIdouGroup != null) {

                    sikinidougroupKbn = sikinIdouGroup.getSikinidougroupkbn();
                }

                C_SikinidouPKbn sikinidouPKbn = C_SikinidouPKbn.TUITYOUKIN;

                C_SikinidoumeisaiKbn sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.BLNK;

                C_SikinidouJtKbn sikinidouJtKbn = C_SikinidouJtKbn.SIKINIDOUMIRYOU;

                BT_HijynNykSiknIdouLstSksGk hijynNykSiknIdouLstSksGk = new BT_HijynNykSiknIdouLstSksGk();

                hijynNykSiknIdouLstSksGk.setSyoriYmd(syoriYmd);
                hijynNykSiknIdouLstSksGk.setSikinidoupkbn(sikinidouPKbn);
                hijynNykSiknIdouLstSksGk.setSyono(kihrkmpSeisanRirekiDataBean.getSyono());
                hijynNykSiknIdouLstSksGk.setRenno(kihrkmpSeisanRirekiDataBean.getRenno());
                hijynNykSiknIdouLstSksGk.setSiteituuka(siteituuka);
                hijynNykSiknIdouLstSksGk.setSiteituukagk(kihrkmpSeisanRirekiDataBean.getTuityouk());
                hijynNykSiknIdouLstSksGk.setTrhktuuka(trhktuuka);
                hijynNykSiknIdouLstSksGk.setTrhktuukagk(kihrkmpSeisanRirekiDataBean.getYenkansantuityoukin());
                hijynNykSiknIdouLstSksGk.setSeg1cd(kihrkmpSeisanRirekiDataBean.getSegcd());
                hijynNykSiknIdouLstSksGk.setSikinidougroupkbn(sikinidougroupKbn);
                hijynNykSiknIdouLstSksGk.setSikinidoumeisaikbn(sikinidoumeisaiKbn);
                hijynNykSiknIdouLstSksGk.setSikinidoujtkbn(sikinidouJtKbn);
                hijynNykSiknIdouLstSksGk.setSikinidoukawaserate(kihrkmpSeisanRirekiDataBean.getZeimukwsrate());

                BizPropertyInitializer.initialize(hijynNykSiknIdouLstSksGk);

                hijynNykSiknIdouLstSksGkList.add(hijynNykSiknIdouLstSksGk);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}