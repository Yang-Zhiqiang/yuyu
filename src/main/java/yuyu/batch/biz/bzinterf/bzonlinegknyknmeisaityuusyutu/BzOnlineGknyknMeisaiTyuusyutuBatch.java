package yuyu.batch.biz.bzinterf.bzonlinegknyknmeisaityuusyutu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_OnlineGknyknmeisai;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiTr;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 インターフェイス オンライン外貨入出金明細テーブル抽出クラス
 */
public class BzOnlineGknyknMeisaiTyuusyutuBatch implements Batch {

    private final String GKNYKN_MEISAI_TRTABLE_ID = "ZT_OnlineGknyknmeisaiTr";

    private final String GKNYKN_MEISAI_TRFILTER_ID = "Bz104";

    private final String NYUUKIN_TORIKESI_TAISYOU_IRNINNM = "SUMITOMO LIFE INSURANCE COMPANY";

    private final String DATA_ZERO = "0";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzOnlineGknyknMeisaiTyuusyutuDao bzOnlineGknyknMeisaiTyuusyutuDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private static Logger logger;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),String.valueOf(bzBatchParam.getSyoriYmd())));

        int syoriKensuu = 0;

        try (ExDBResults<ZT_OnlineGknyknmeisaiTr> onlineGknyknmeisaiTrLst =
            bzOnlineGknyknMeisaiTyuusyutuDao.getOnlineGknyknmeisaiTrsByKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
            EntityInserter<BT_OnlineGknyknmeisai> onlineGknyknmeisaiLst = new EntityInserter<>();) {

            List<HM_HurikomiKouza> nyuukinTaisyouKouzaJyouhouLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyuNe(C_Tuukasyu.JPY);

            for (ZT_OnlineGknyknmeisaiTr onlineGknyknmeisaiTr : onlineGknyknmeisaiTrLst) {
                logger.debug("オンライン外貨入出金明細データリストの件数分、繰返し処理を実行します。処理件数:" + syoriKensuu);

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(GKNYKN_MEISAI_TRTABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(GKNYKN_MEISAI_TRFILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(onlineGknyknmeisaiTr.getZtrsakuseiymd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(onlineGknyknmeisaiTr.getZtrbankcd());

                logger.debug(String.format("リカバリデータ識別用BEAN 設定値 "
                    + "拡張ジョブコード:%s, テーブルＩＤ:%s, リカバリフィルタID:%s, リカバリフィルタキー１:%s, リカバリフィルタキー２:%s",
                    bzRecoveryDatasikibetuBean.getIbKakutyoujobcd(), bzRecoveryDatasikibetuBean.getIbTableid(), bzRecoveryDatasikibetuBean.getIbRecoveryfilterid(),
                    bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey1(), bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey2()));

                if (DATA_ZERO.equals(onlineGknyknmeisaiTr.getZtrdatakbn2())) {
                    continue;
                }

                boolean taisiyouFlg = false;

                for (HM_HurikomiKouza nyuukinTaisyouKouzaJyouhou : nyuukinTaisyouKouzaJyouhouLst) {
                    logger.debug("入金対象口座情報の判定処理を行います。");

                    String kouzaJyouhouKouzaNo;
                    if (nyuukinTaisyouKouzaJyouhou.getKouzano().length() < 10) {
                        kouzaJyouhouKouzaNo = Strings.padStart(nyuukinTaisyouKouzaJyouhou.getKouzano(), 10, '0');
                    }
                    else {
                        kouzaJyouhouKouzaNo =  nyuukinTaisyouKouzaJyouhou.getKouzano();
                    }

                    if (nyuukinTaisyouKouzaJyouhou.getBankcd().equals(onlineGknyknmeisaiTr.getZtrbankcd()) &&
                        nyuukinTaisyouKouzaJyouhou.getSitencd().equals(onlineGknyknmeisaiTr.getZtrshitencd()) &&
                        kouzaJyouhouKouzaNo.equals(onlineGknyknmeisaiTr.getZtrkouzano()) &&
                        nyuukinTaisyouKouzaJyouhou.getTuukasyu().getValue().equals(onlineGknyknmeisaiTr.getZtrzndktuukasyu())) {

                        taisiyouFlg = true;
                        break;
                    }
                }

                String ztrirninnm = "";
                if (NYUUKIN_TORIKESI_TAISYOU_IRNINNM.length() <= onlineGknyknmeisaiTr.getZtrirninnm().length()) {
                    ztrirninnm = onlineGknyknmeisaiTr.getZtrirninnm().replaceAll("　", " ").substring(0, NYUUKIN_TORIKESI_TAISYOU_IRNINNM.length());
                }

                if (taisiyouFlg && (!NYUUKIN_TORIKESI_TAISYOU_IRNINNM.equals(ztrirninnm))) {
                    logger.debug("オンライン外貨入出金明細エンティティの登録処理を開始します。処理件数:" + syoriKensuu);

                    BT_OnlineGknyknmeisai onlineGknyknmeisai = new BT_OnlineGknyknmeisai();

                    onlineGknyknmeisai.setHrkmdatakbn1(onlineGknyknmeisaiTr.getZtrdatakbn1());
                    onlineGknyknmeisai.setHrkmsyubetucd(onlineGknyknmeisaiTr.getZtrsyubetucd());
                    onlineGknyknmeisai.setHrkmcdkbn(onlineGknyknmeisaiTr.getZtrcdkbn());
                    onlineGknyknmeisai.setHrkmsakuseiymd(bzBatchParam.getSyoriYmd().toString());
                    onlineGknyknmeisai.setHrkmrenrakuymd(onlineGknyknmeisaiTr.getZtrrenrakuymd());
                    onlineGknyknmeisai.setHrkmrenrakukaisuu(onlineGknyknmeisaiTr.getZtrrenrakukaisuu());
                    onlineGknyknmeisai.setHrkmknjyymdfrom(onlineGknyknmeisaiTr.getZtrknjyymdfrom());
                    onlineGknyknmeisai.setHrkmknjyymdto(onlineGknyknmeisaiTr.getZtrknjyymdto());
                    onlineGknyknmeisai.setHrkmbankcd(onlineGknyknmeisaiTr.getZtrbankcd());
                    onlineGknyknmeisai.setHrkmbanknmej(onlineGknyknmeisaiTr.getZtrbanknmej());
                    onlineGknyknmeisai.setHrkmsitencdtori(onlineGknyknmeisaiTr.getZtrsitencdtori());
                    onlineGknyknmeisai.setHrkmsitennmejtori(onlineGknyknmeisaiTr.getZtrsitennmejtori());
                    onlineGknyknmeisai.setHrkmshitencd(onlineGknyknmeisaiTr.getZtrshitencd());
                    onlineGknyknmeisai.setHrkmsitennmej(onlineGknyknmeisaiTr.getZtrsitennmej());
                    onlineGknyknmeisai.setHrkmyokinkbn(onlineGknyknmeisaiTr.getZtryokinkbn());
                    onlineGknyknmeisai.setHrkmkouzano(onlineGknyknmeisaiTr.getZtrkouzano());
                    onlineGknyknmeisai.setHrkmkznmej(onlineGknyknmeisaiTr.getZtrkznmej());
                    onlineGknyknmeisai.setHrkmzndktuukasyu(onlineGknyknmeisaiTr.getZtrzndktuukasyu());
                    onlineGknyknmeisai.setHrkmzndkssketa(onlineGknyknmeisaiTr.getZtrzndkssketa());
                    onlineGknyknmeisai.setHrkmgktrhkmaezndk(onlineGknyknmeisaiTr.getZtrgktrhkmaezndk());
                    onlineGknyknmeisai.setHrkmkasikosikbn(onlineGknyknmeisaiTr.getZtrkasikosikbn());
                    onlineGknyknmeisai.setHrkmyobiv86(onlineGknyknmeisaiTr.getZtryobiv86());
                    onlineGknyknmeisai.setHrkmdatakbn2(onlineGknyknmeisaiTr.getZtrdatakbn2());
                    onlineGknyknmeisai.setHrkmdtrecordkbn1(onlineGknyknmeisaiTr.getZtrdtrecordkbn1());
                    onlineGknyknmeisai.setHrkmdtrecordkousei(onlineGknyknmeisaiTr.getZtrdtrecordkousei());
                    onlineGknyknmeisai.setHrkmsyorino1(onlineGknyknmeisaiTr.getZtrsyorino1());
                    onlineGknyknmeisai.setHrkmknjyymd(onlineGknyknmeisaiTr.getZtrknjyymd());
                    onlineGknyknmeisai.setHrkmksnymd(onlineGknyknmeisaiTr.getZtrksnymd());
                    onlineGknyknmeisai.setHrkmiribaraikbn(onlineGknyknmeisaiTr.getZtriribaraikbn());
                    onlineGknyknmeisai.setHrkmtrhkkbn(onlineGknyknmeisaiTr.getZtrtrhkkbn());
                    onlineGknyknmeisai.setHrkmtrhktuukasyu(onlineGknyknmeisaiTr.getZtrtrhktuukasyu());
                    onlineGknyknmeisai.setHrkmtrhkssketa(onlineGknyknmeisaiTr.getZtrtrhkssketa());
                    onlineGknyknmeisai.setHrkmgktrhkgk(onlineGknyknmeisaiTr.getZtrgktrhkgk());
                    onlineGknyknmeisai.setHrkmbanksyoukaino(onlineGknyknmeisaiTr.getZtrbanksyoukaino());
                    onlineGknyknmeisai.setHrkmtrhksyoukaino(onlineGknyknmeisaiTr.getZtrtrhksyoukaino());
                    onlineGknyknmeisai.setHrkmtekiyounaiyouej(onlineGknyknmeisaiTr.getZtrtekiyounaiyouej());
                    onlineGknyknmeisai.setHrkmyobiv103(onlineGknyknmeisaiTr.getZtryobiv103());
                    onlineGknyknmeisai.setHrkmdatakbn3(onlineGknyknmeisaiTr.getZtrdatakbn3());
                    onlineGknyknmeisai.setHrkmdtrecordkbn2(onlineGknyknmeisaiTr.getZtrdtrecordkbn2());
                    onlineGknyknmeisai.setHrkmdtkouseikbn(onlineGknyknmeisaiTr.getZtrdtkouseikbn());
                    onlineGknyknmeisai.setHrkmtrkscd(onlineGknyknmeisaiTr.getZtrtrkscd());
                    onlineGknyknmeisai.setHrkmsyorino2(onlineGknyknmeisaiTr.getZtrsyorino2());
                    onlineGknyknmeisai.setHrkmbanksyoukaino2(onlineGknyknmeisaiTr.getZtrbanksyoukaino2());
                    onlineGknyknmeisai.setHrkmsimukeymd(onlineGknyknmeisaiTr.getZtrsimukeymd());
                    onlineGknyknmeisai.setHrkmsetujyuymd(onlineGknyknmeisaiTr.getZtrsetujyuymd());
                    onlineGknyknmeisai.setHrkmsoukinsyu(onlineGknyknmeisaiTr.getZtrsoukinsyu());
                    onlineGknyknmeisai.setHrkmvalueymd(onlineGknyknmeisaiTr.getZtrvalueymd());
                    onlineGknyknmeisai.setHrkmskntuukasyu(onlineGknyknmeisaiTr.getZtrskntuukasyu());
                    onlineGknyknmeisai.setHrkmsknssketa(onlineGknyknmeisaiTr.getZtrsknssketa());
                    onlineGknyknmeisai.setHrkmgksoukingk(onlineGknyknmeisaiTr.getZtrgksoukingk());
                    onlineGknyknmeisai.setHrkmirninnmej(onlineGknyknmeisaiTr.getZtrirninnm());
                    onlineGknyknmeisai.setHrkmyobiv40(onlineGknyknmeisaiTr.getZtryobiv40());
                    onlineGknyknmeisai.setHrkmdatakbn4(onlineGknyknmeisaiTr.getZtrdatakbn4());
                    onlineGknyknmeisai.setHrkmdtrecordkbn3(onlineGknyknmeisaiTr.getZtrdtrecordkbn3());
                    onlineGknyknmeisai.setHrkmdourecordsuu1(onlineGknyknmeisaiTr.getZtrdourecordsuu1());
                    onlineGknyknmeisai.setHrkmdourecordno1(onlineGknyknmeisaiTr.getZtrdourecordno1());
                    onlineGknyknmeisai.setHrkmkahensuu1(onlineGknyknmeisaiTr.getZtrkahensuu1());
                    onlineGknyknmeisai.setHrkmkahenketa1(onlineGknyknmeisaiTr.getZtrkahenketa1());
                    onlineGknyknmeisai.setHrkmkahen1(onlineGknyknmeisaiTr.getZtrkahen1());
                    onlineGknyknmeisai.setHrkmdatakbn5(onlineGknyknmeisaiTr.getZtrdatakbn5());
                    onlineGknyknmeisai.setHrkmdtrecordkbn4(onlineGknyknmeisaiTr.getZtrdtrecordkbn4());
                    onlineGknyknmeisai.setHrkmdourecordsuu2(onlineGknyknmeisaiTr.getZtrdourecordsuu2());
                    onlineGknyknmeisai.setHrkmdourecordno2(onlineGknyknmeisaiTr.getZtrdourecordno2());
                    onlineGknyknmeisai.setHrkmkahensuu2(onlineGknyknmeisaiTr.getZtrkahensuu2());
                    onlineGknyknmeisai.setHrkmkahenketa2(onlineGknyknmeisaiTr.getZtrkahenketa2());
                    onlineGknyknmeisai.setHrkmkahen2(onlineGknyknmeisaiTr.getZtrkahen2());
                    onlineGknyknmeisai.setHrkmdatakbn6(onlineGknyknmeisaiTr.getZtrdatakbn6());
                    onlineGknyknmeisai.setHrkmdtrecordkbn5(onlineGknyknmeisaiTr.getZtrdtrecordkbn5());
                    onlineGknyknmeisai.setHrkmdourecordsuu3(onlineGknyknmeisaiTr.getZtrdourecordsuu3());
                    onlineGknyknmeisai.setHrkmdourecordno3(onlineGknyknmeisaiTr.getZtrdourecordno3());
                    onlineGknyknmeisai.setHrkmkahensuu3(onlineGknyknmeisaiTr.getZtrkahensuu3());
                    onlineGknyknmeisai.setHrkmkahenketa3(onlineGknyknmeisaiTr.getZtrkahenketa3());
                    onlineGknyknmeisai.setHrkmkahen3(onlineGknyknmeisaiTr.getZtrkahen3());
                    onlineGknyknmeisai.setHrkmrensakuseiymd(onlineGknyknmeisaiTr.getZtrsakuseiymd());

                    BizPropertyInitializer.initialize(onlineGknyknmeisai);
                    onlineGknyknmeisaiLst.add(onlineGknyknmeisai);
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
