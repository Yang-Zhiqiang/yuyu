package yuyu.batch.hozen.khkessan.khyendthnkbikintyusyutu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khyendthnkbikintyusyutu.dba.KhBikinkanriYendthnkInfoBean;
import yuyu.batch.hozen.khkessan.khyendthnkbikintyusyutu.dba.KhBikinkanriYendthnkInfosBean;
import yuyu.batch.hozen.khkessan.khyendthnkbikintyusyutu.dba.KhYendtHnkBikinTyusyutuDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BknsyutkKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 決算 円建変更時返戻金備金抽出
 */
public class KhYendtHnkBikinTyusyutuBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhYendtHnkBikinTyusyutuBatchParam batchParam;

    private KhozenCommonParam khozenCommonParam;

    @Inject
    private KhYendtHnkBikinTyusyutuDao khYendtHnkBikinTyusyutuDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        String kakutyouJobCd = batchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = batchParam.getSyoriYmd();
        BizDate kessanYmd = batchParam.getKessanYmd();
        long khBikinkanriInfoOutKensuu = 0;
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        C_BkncdKbn[] bkncdKbns = new C_BkncdKbn[]{C_BkncdKbn.YENDTHNKHR};

        List<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(
            kessanYmd, bkncdKbns);

        hozenDomManager.delete(khBikinkanriList);
        hozenDomManager.flush();

        try (
            ExDBResults<KhBikinkanriYendthnkInfosBean> khBikinkanriYendthnkInfosBeanLst =
            khYendtHnkBikinTyusyutuDao.getKhBikinkanriYendthnkInfos(kakutyouJobCd, kessanYmd);
            MultipleEntityInserter dataIns = new MultipleEntityInserter()) {

            for (KhBikinkanriYendthnkInfosBean khBikinkanriYendthnkInfosBean : khBikinkanriYendthnkInfosBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khBikinkanriYendthnkInfosBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khBikinkanriYendthnkInfosBean.getSyono());

                BizDateY firstKessanKijunNendo = null;
                BizDateY kessanKijunNendo = null;
                IT_KykSyouhnHnkmae kykSyouhnHnkmae = null;
                BM_TantouCd tantouCd = null;
                C_BknJkuKbn bknjkuKbn = C_BknJkuKbn.BLNK;

                kykSyouhnHnkmae = khYendtHnkBikinTyusyutuDao.getKykSyouhnHnkmae(khBikinkanriYendthnkInfosBean.getSyono());

                if (kykSyouhnHnkmae == null) {
                    throw new CommonBizAppException("契約商品変更前内容TBLにデータが存在しません。証券番号：" +
                        khBikinkanriYendthnkInfosBean.getSyono());
                }

                tantouCd = bizDomManager.getTantouCd(khBikinkanriYendthnkInfosBean.getTantocd());

                if (tantouCd == null) {
                    throw new CommonBizAppException("担当コードマスタにデータが存在しません。担当コード：" +
                        khBikinkanriYendthnkInfosBean.getTantocd());
                }

                KhBikinkanriYendthnkInfoBean khBikinkanriYendthnkInfoBean =
                    khYendtHnkBikinTyusyutuDao.getKhBikinkanriYendthnkInfo(khBikinkanriYendthnkInfosBean.getSyono());

                if (khBikinkanriYendthnkInfoBean != null) {
                    firstKessanKijunNendo = setKessanNensibi.exec(
                        khBikinkanriYendthnkInfoBean.getKessankijyunymd()).getBizDateY();

                    kessanKijunNendo = setKessanNensibi.exec(kessanYmd).getBizDateY();
                }

                if (firstKessanKijunNendo == null) {
                    bknjkuKbn = C_BknJkuKbn.SINBI;
                }
                else {
                    if (kessanKijunNendo.getYear() - firstKessanKijunNendo.getYear() == 0) {
                        bknjkuKbn = C_BknJkuKbn.SINBI;
                    }
                    else if (kessanKijunNendo.getYear() - firstKessanKijunNendo.getYear() == 1) {
                        bknjkuKbn = C_BknJkuKbn.SAIBI;
                    }
                    else if (kessanKijunNendo.getYear() - firstKessanKijunNendo.getYear() == 2) {
                        bknjkuKbn = C_BknJkuKbn.SAISAIBI;
                    }
                    else if (kessanKijunNendo.getYear() - firstKessanKijunNendo.getYear() == 3 &&
                        kessanYmd.getBizDateMD().compareTo(BizDateMD.valueOf("0331")) != 0) {
                        bknjkuKbn = C_BknJkuKbn.SAISAISAIBI;
                    }
                    else {
                        bknjkuKbn = C_BknJkuKbn.JIKOU;
                    }
                }

                C_Tuukasyu shrTuukaSyu = henkanTuuka.henkanTuukaTypeToKbn(
                    khBikinkanriYendthnkInfosBean.getHenreikingk().getType());

                IT_KhBikinkanri khBikinkanri = new IT_KhBikinkanri();

                khBikinkanri.setSyono(khBikinkanriYendthnkInfosBean.getSyono());
                khBikinkanri.setKessankijyunymd(kessanYmd);
                khBikinkanri.setBkncdkbn(C_BkncdKbn .YENDTHNKHR);
                khBikinkanri.setBknkktymd(khBikinkanriYendthnkInfosBean.getHrhsiymd());
                khBikinkanri.setRenno(1);
                khBikinkanri.setBknrigikbn(C_BknrigiKbn.BLNK);
                khBikinkanri.setHenkousikibetukey(khBikinkanriYendthnkInfosBean.getHenkousikibetukey());
                khBikinkanri.setCalckijyunymd(khBikinkanriYendthnkInfosBean.getHrhsiymd());
                khBikinkanri.setSisyacd(tantouCd.getBusitucd());
                khBikinkanri.setKbnkeirisegcd(khBikinkanriYendthnkInfosBean.getSeg1cd());
                khBikinkanri.setSyouhncd(kykSyouhnHnkmae.getSyouhncd());
                khBikinkanri.setBknsyutkkbn(C_BknsyutkKbn.SYU);
                khBikinkanri.setBkngk(khBikinkanriYendthnkInfosBean.getHenreikingk());
                khBikinkanri.setKihons(khBikinkanriYendthnkInfosBean.getKihons());
                khBikinkanri.setGngkkiykumukbn(C_UmuKbn.NONE);
                if (C_Siharaijyoutaikbn.SIHARAIZUMI.eq(khBikinkanriYendthnkInfosBean.getHrsiharaijyoutaikbn())) {
                    khBikinkanri.setShrumu(C_UmuKbn.ARI);
                }
                else {
                    khBikinkanri.setShrumu(C_UmuKbn.NONE);
                }
                khBikinkanri.setSinsaumukbn(C_UmuKbn.NONE);
                khBikinkanri.setBknjkukbn(bknjkuKbn);
                khBikinkanri.setShrsyoriymd(khBikinkanriYendthnkInfosBean.getShrsyoriymd());
                khBikinkanri.setTyakkinymd(khBikinkanriYendthnkInfosBean.getShrymd());
                khBikinkanri.setKyktuukasyu(kykSyouhnHnkmae.getKyktuukasyu());
                khBikinkanri.setShrtuukasyu(shrTuukaSyu);
                khBikinkanri.setShrgk(khBikinkanriYendthnkInfosBean.getHenreikingk());
                khBikinkanri.setGyoumuKousinKinou(kinouId);
                khBikinkanri.setGyoumuKousinsyaId(userId);
                khBikinkanri.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(khBikinkanri);

                dataIns.add(khBikinkanri);

                khBikinkanriInfoOutKensuu++;

            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(khBikinkanriInfoOutKensuu), "<<契約保全備金管理TBL>>"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
