package yuyu.batch.biz.bzinterf.bzgknyuukinmeisaityuusyutu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzinterf.bzgknyuukinmeisaityuusyutu.dba.BzGknyuukinMeisaiTyuusyutuDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_Gknyknmeisai;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 インターフェイス 外貨入出金明細テーブル抽出クラス
 */
public class BzGknyuukinMeisaiTyuusyutuBatch implements Batch {

    private final String GKNYKN_MEISAI_TRTABLE_ID = "ZT_GknyknmeisaiTr";

    private final String GKNYKN_MEISAI_TRFILTER_ID = "Bz104";

    private static final String TORIKESIDATA = "SUMITOMO LIFE INSURANCE COMPANY";

    private static final String DATA_ZERO = "0";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzGknyuukinMeisaiTyuusyutuDao bzGknyuukinMeisaiTyuusyutuDao;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        try (EntityInserter<BT_Gknyknmeisai> gknyknmeisaiEntityInserter = new EntityInserter<>();
            ExDBResults<ZT_GknyknmeisaiTr> gknyknmeisaiTrLst = bzGknyuukinMeisaiTyuusyutuDao
                .getGknyknmeisaiTrsByKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());) {

            List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyuNe(C_Tuukasyu.JPY);

            for (ZT_GknyknmeisaiTr gknyknmeisaiTr : gknyknmeisaiTrLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(GKNYKN_MEISAI_TRTABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(GKNYKN_MEISAI_TRFILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(gknyknmeisaiTr.getZtrsakuseiymd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(gknyknmeisaiTr.getZtrbankcd());

                if (DATA_ZERO.equals(gknyknmeisaiTr.getZtrdatakbn2())) {
                    continue;
                }

                boolean taisiyouFlg = false;

                for (HM_HurikomiKouza hurikomiKouza : hurikomiKouzaLst) {

                    String kouzaJyouhouKouzaNo;
                    if(hurikomiKouza.getKouzano().length() < 10){
                        kouzaJyouhouKouzaNo = Strings.padStart(hurikomiKouza.getKouzano(), 10, '0');
                    }
                    else{
                        kouzaJyouhouKouzaNo =  hurikomiKouza.getKouzano();
                    }

                    if (hurikomiKouza.getBankcd().equals(gknyknmeisaiTr.getZtrbankcd()) &&
                        hurikomiKouza.getSitencd().equals(gknyknmeisaiTr.getZtrshitencd()) &&
                        kouzaJyouhouKouzaNo.equals(gknyknmeisaiTr.getZtrkouzano()) &&
                        hurikomiKouza.getTuukasyu().getValue().equals(gknyknmeisaiTr.getZtrzndktuukasyu())) {

                        taisiyouFlg = true;
                        break;
                    }
                }

                String ztrirninnm = "";
                if (TORIKESIDATA.length() <= gknyknmeisaiTr.getZtrirninnm().length()) {
                    ztrirninnm = gknyknmeisaiTr.getZtrirninnm().replaceAll("　", " ").substring(0, TORIKESIDATA.length());
                }
                if (taisiyouFlg &&
                    (!TORIKESIDATA.equals(ztrirninnm))) {

                    BT_Gknyknmeisai gknyknmeisai = new BT_Gknyknmeisai();

                    gknyknmeisai.setHrkmdatakbn1(gknyknmeisaiTr.getZtrdatakbn1());
                    gknyknmeisai.setHrkmsyubetucd(gknyknmeisaiTr.getZtrsyubetucd());
                    gknyknmeisai.setHrkmcdkbn(gknyknmeisaiTr.getZtrcdkbn());
                    gknyknmeisai.setHrkmsakuseiymd(syoriYmd.toString());
                    gknyknmeisai.setHrkmrenrakuymd(gknyknmeisaiTr.getZtrrenrakuymd());
                    gknyknmeisai.setHrkmrenrakukaisuu(gknyknmeisaiTr.getZtrrenrakukaisuu());
                    gknyknmeisai.setHrkmknjyymdfrom(gknyknmeisaiTr.getZtrknjyymdfrom());
                    gknyknmeisai.setHrkmknjyymdto(gknyknmeisaiTr.getZtrknjyymdto());
                    gknyknmeisai.setHrkmbankcd(gknyknmeisaiTr.getZtrbankcd());
                    gknyknmeisai.setHrkmbanknmej(gknyknmeisaiTr.getZtrbanknmej());
                    gknyknmeisai.setHrkmsitencdtori(gknyknmeisaiTr.getZtrsitencdtori());
                    gknyknmeisai.setHrkmsitennmejtori(gknyknmeisaiTr.getZtrsitennmejtori());
                    gknyknmeisai.setHrkmshitencd(gknyknmeisaiTr.getZtrshitencd());
                    gknyknmeisai.setHrkmsitennmej(gknyknmeisaiTr.getZtrsitennmej());
                    gknyknmeisai.setHrkmyokinkbn(gknyknmeisaiTr.getZtryokinkbn());
                    gknyknmeisai.setHrkmkouzano(gknyknmeisaiTr.getZtrkouzano());
                    gknyknmeisai.setHrkmkznmej(gknyknmeisaiTr.getZtrkznmej());
                    gknyknmeisai.setHrkmzndktuukasyu(gknyknmeisaiTr.getZtrzndktuukasyu());
                    gknyknmeisai.setHrkmzndkssketa(gknyknmeisaiTr.getZtrzndkssketa());
                    gknyknmeisai.setHrkmgktrhkmaezndk(gknyknmeisaiTr.getZtrgktrhkmaezndk());
                    gknyknmeisai.setHrkmkasikosikbn(gknyknmeisaiTr.getZtrkasikosikbn());
                    gknyknmeisai.setHrkmyobiv86(gknyknmeisaiTr.getZtryobiv86());
                    gknyknmeisai.setHrkmdatakbn2(gknyknmeisaiTr.getZtrdatakbn2());
                    gknyknmeisai.setHrkmdtrecordkbn1(gknyknmeisaiTr.getZtrdtrecordkbn1());
                    gknyknmeisai.setHrkmdtrecordkousei(gknyknmeisaiTr.getZtrdtrecordkousei());
                    gknyknmeisai.setHrkmsyorino1(gknyknmeisaiTr.getZtrsyorino1());
                    gknyknmeisai.setHrkmknjyymd(gknyknmeisaiTr.getZtrknjyymd());
                    gknyknmeisai.setHrkmksnymd(gknyknmeisaiTr.getZtrksnymd());
                    gknyknmeisai.setHrkmiribaraikbn(gknyknmeisaiTr.getZtriribaraikbn());
                    gknyknmeisai.setHrkmtrhkkbn(gknyknmeisaiTr.getZtrtrhkkbn());
                    gknyknmeisai.setHrkmtrhktuukasyu(gknyknmeisaiTr.getZtrtrhktuukasyu());
                    gknyknmeisai.setHrkmtrhkssketa(gknyknmeisaiTr.getZtrtrhkssketa());
                    gknyknmeisai.setHrkmgktrhkgk(gknyknmeisaiTr.getZtrgktrhkgk());
                    gknyknmeisai.setHrkmbanksyoukaino(gknyknmeisaiTr.getZtrbanksyoukaino());
                    gknyknmeisai.setHrkmtrhksyoukaino(gknyknmeisaiTr.getZtrtrhksyoukaino());
                    gknyknmeisai.setHrkmtekiyounaiyouej(gknyknmeisaiTr.getZtrtekiyounaiyouej());
                    gknyknmeisai.setHrkmyobiv103(gknyknmeisaiTr.getZtryobiv103());
                    gknyknmeisai.setHrkmdatakbn3(gknyknmeisaiTr.getZtrdatakbn3());
                    gknyknmeisai.setHrkmdtrecordkbn2(gknyknmeisaiTr.getZtrdtrecordkbn2());
                    gknyknmeisai.setHrkmdtkouseikbn(gknyknmeisaiTr.getZtrdtkouseikbn());
                    gknyknmeisai.setHrkmtrkscd(gknyknmeisaiTr.getZtrtrkscd());
                    gknyknmeisai.setHrkmsyorino2(gknyknmeisaiTr.getZtrsyorino2());
                    gknyknmeisai.setHrkmbanksyoukaino2(gknyknmeisaiTr.getZtrbanksyoukaino2());
                    gknyknmeisai.setHrkmsimukeymd(gknyknmeisaiTr.getZtrsimukeymd());
                    gknyknmeisai.setHrkmsetujyuymd(gknyknmeisaiTr.getZtrsetujyuymd());
                    gknyknmeisai.setHrkmsoukinsyu(gknyknmeisaiTr.getZtrsoukinsyu());
                    gknyknmeisai.setHrkmvalueymd(gknyknmeisaiTr.getZtrvalueymd());
                    gknyknmeisai.setHrkmskntuukasyu(gknyknmeisaiTr.getZtrskntuukasyu());
                    gknyknmeisai.setHrkmsknssketa(gknyknmeisaiTr.getZtrsknssketa());
                    gknyknmeisai.setHrkmgksoukingk(gknyknmeisaiTr.getZtrgksoukingk());
                    gknyknmeisai.setHrkmirninnmej(gknyknmeisaiTr.getZtrirninnm());
                    gknyknmeisai.setHrkmyobiv40(gknyknmeisaiTr.getZtryobiv40());
                    gknyknmeisai.setHrkmdatakbn4(gknyknmeisaiTr.getZtrdatakbn4());
                    gknyknmeisai.setHrkmdtrecordkbn3(gknyknmeisaiTr.getZtrdtrecordkbn3());
                    gknyknmeisai.setHrkmdourecordsuu1(gknyknmeisaiTr.getZtrdourecordsuu1());
                    gknyknmeisai.setHrkmdourecordno1(gknyknmeisaiTr.getZtrdourecordno1());
                    gknyknmeisai.setHrkmkahensuu1(gknyknmeisaiTr.getZtrkahensuu1());
                    gknyknmeisai.setHrkmkahenketa1(gknyknmeisaiTr.getZtrkahenketa1());
                    gknyknmeisai.setHrkmkahen1(gknyknmeisaiTr.getZtrkahen1());
                    gknyknmeisai.setHrkmdatakbn5(gknyknmeisaiTr.getZtrdatakbn5());
                    gknyknmeisai.setHrkmdtrecordkbn4(gknyknmeisaiTr.getZtrdtrecordkbn4());
                    gknyknmeisai.setHrkmdourecordsuu2(gknyknmeisaiTr.getZtrdourecordsuu2());
                    gknyknmeisai.setHrkmdourecordno2(gknyknmeisaiTr.getZtrdourecordno2());
                    gknyknmeisai.setHrkmkahensuu2(gknyknmeisaiTr.getZtrkahensuu2());
                    gknyknmeisai.setHrkmkahenketa2(gknyknmeisaiTr.getZtrkahenketa2());
                    gknyknmeisai.setHrkmkahen2(gknyknmeisaiTr.getZtrkahen2());
                    gknyknmeisai.setHrkmdatakbn6(gknyknmeisaiTr.getZtrdatakbn6());
                    gknyknmeisai.setHrkmdtrecordkbn5(gknyknmeisaiTr.getZtrdtrecordkbn5());
                    gknyknmeisai.setHrkmdourecordsuu3(gknyknmeisaiTr.getZtrdourecordsuu3());
                    gknyknmeisai.setHrkmdourecordno3(gknyknmeisaiTr.getZtrdourecordno3());
                    gknyknmeisai.setHrkmkahensuu3(gknyknmeisaiTr.getZtrkahensuu3());
                    gknyknmeisai.setHrkmkahenketa3(gknyknmeisaiTr.getZtrkahenketa3());
                    gknyknmeisai.setHrkmkahen3(gknyknmeisaiTr.getZtrkahen3());
                    gknyknmeisai.setHrkmrensakuseiymd(gknyknmeisaiTr.getZtrsakuseiymd());

                    BizPropertyInitializer.initialize(gknyknmeisai);
                    gknyknmeisaiEntityInserter.add(gknyknmeisai);
                    syoriKensuu++;
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
