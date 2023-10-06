package yuyu.batch.biz.bzinterf.bznyuukinmeisaityuusyutu;

import java.util.Iterator;
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
import yuyu.batch.biz.bzinterf.bznyuukinmeisaityuusyutu.dba.BzNyuukinMeisaiTyuusyutuDao;
import yuyu.common.base.format.BizDateFormatUtil;
import yuyu.common.base.format.BizDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BT_Nyknmeisai;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.entity.ZT_NyknmeisaiTr;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 入出金明細テーブル抽出
 */
public class BzNyuukinMeisaiTyuusyutuBatch implements Batch {

    private static final String NYKNMEISAITBLTORI = "ZT_NyknmeisaiTr";

    private static final String NYKNMEISAIFILTERTORI = "Bz103";

    private static final String TORIKESIDATA = "ｽﾐﾄﾓｾｲﾒｲﾎｹﾝ　(ｿ";


    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzNyuukinMeisaiTyuusyutuDao bzNyuukinMeisaiTyuusyutuDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syoriKensu = 0;
        String syoriYmd = String.valueOf(bzBatchParam.getSyoriYmd());

        try (EntityInserter<BT_Nyknmeisai> nyknmeisaiEtyInsert = new EntityInserter<>()) {
            String message = MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
                syoriYmd);
            batchLogger.info(message);


            syoriYmd = BizDateFormatUtil.toFormatedYmd(
                BizDate.valueOf(syoriYmd), BizDateFormatter.warekiSymbolCommaYMDFormat).replace(".", "").substring(1);
            try (ExDBResults<ZT_NyknmeisaiTr> nyknmeisaiTrLst =
                bzNyuukinMeisaiTyuusyutuDao.getNyknmeisaiTrsByKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd())) {
                Iterator<ZT_NyknmeisaiTr> iterator = nyknmeisaiTrLst.iterator();
                if (!iterator.hasNext()) {
                    batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));

                    return;
                }

                List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager
                    .getHurikomiKouzasByTuukasyu(C_Tuukasyu.JPY);
                while (iterator.hasNext()) {

                    ZT_NyknmeisaiTr nyknmeisaiTr = iterator.next();
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                    bzRecoveryDatasikibetuBean.setIbTableid(NYKNMEISAITBLTORI);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(NYKNMEISAIFILTERTORI);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(nyknmeisaiTr.getZtrsakuseiymd6keta());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(nyknmeisaiTr.getZtrbankcd());


                    String ztrkouzano = nyknmeisaiTr.getZtrkouzano().substring(3, 10);

                    boolean taishouFlub = false;
                    for (HM_HurikomiKouza hurikomiKouza : hurikomiKouzaLst) {

                        if (hurikomiKouza.getBankcd().equals(nyknmeisaiTr.getZtrbankcd()) &&
                            hurikomiKouza.getSitencd().equals(nyknmeisaiTr.getZtrshitencd()) &&
                            hurikomiKouza.getKouzano().equals(ztrkouzano) &&
                            hurikomiKouza.getYokinkbn().eq(C_YokinKbn.valueOf(nyknmeisaiTr.getZtryokinkbn()))) {
                            taishouFlub = true;
                            break;
                        }

                    }

                    String ztrhrkmirninnm = "";
                    if (TORIKESIDATA.length() <= nyknmeisaiTr.getZtrhrkmirninnm().length()) {
                        ztrhrkmirninnm = nyknmeisaiTr.getZtrhrkmirninnm().substring(0, TORIKESIDATA.length());
                    }

                    if (taishouFlub &&
                        (!TORIKESIDATA.equals(ztrhrkmirninnm))) {
                        BT_Nyknmeisai nyknmeisaiEty = new BT_Nyknmeisai();
                        nyknmeisaiEty.setHrkmdatakbn1(nyknmeisaiTr.getZtrdatakbn1());
                        nyknmeisaiEty.setHrkmsyubetucd(nyknmeisaiTr.getZtrsyubetucd());
                        nyknmeisaiEty.setHrkmcdkbn(nyknmeisaiTr.getZtrcdkbn());
                        nyknmeisaiEty.setHrkmsakuseiymd6keta(syoriYmd);
                        nyknmeisaiEty.setHrkmknjyymdfrom6keta(nyknmeisaiTr.getZtrknjyymdfrom6keta());
                        nyknmeisaiEty.setHrkmknjyymdto6keta(nyknmeisaiTr.getZtrknjyymdto6keta());
                        nyknmeisaiEty.setHrkmbankcd(nyknmeisaiTr.getZtrbankcd());
                        nyknmeisaiEty.setHrkmbanknmkn(nyknmeisaiTr.getZtrbanknmkn());
                        nyknmeisaiEty.setHrkmshitencd(nyknmeisaiTr.getZtrshitencd());
                        nyknmeisaiEty.setHrkmsitennmkn(nyknmeisaiTr.getZtrsitennmkn());
                        nyknmeisaiEty.setHrkmyobiv3(nyknmeisaiTr.getZtryobiv3());
                        nyknmeisaiEty.setHrkmyokinkbn(nyknmeisaiTr.getZtryokinkbn());
                        nyknmeisaiEty.setHrkmkouzano(ztrkouzano);
                        nyknmeisaiEty.setHrkmkznmkn(nyknmeisaiTr.getZtrkznmkn());
                        nyknmeisaiEty.setHrkmkasikosikbn(nyknmeisaiTr.getZtrkasikosikbn());
                        nyknmeisaiEty.setHrkmtuutyousysykbn(nyknmeisaiTr.getZtrtuutyousysykbn());
                        nyknmeisaiEty.setHrkmtrhkmaezndk(nyknmeisaiTr.getZtrtrhkmaezndk());
                        nyknmeisaiEty.setHrkmyobiv63(nyknmeisaiTr.getZtryobiv63());
                        nyknmeisaiEty.setHrkmrenno8(nyknmeisaiTr.getZtrrenno8());
                        nyknmeisaiEty.setHrkmdatakbn2(nyknmeisaiTr.getZtrdatakbn2());
                        nyknmeisaiEty.setHrkmsyoukaino(nyknmeisaiTr.getZtrsyoukaino());
                        nyknmeisaiEty.setHrkmknjyymd6keta(nyknmeisaiTr.getZtrknjyymd6keta());
                        nyknmeisaiEty.setHrkmazkrhrdsymd6keta(nyknmeisaiTr.getZtrazkrhrdsymd6keta());
                        nyknmeisaiEty.setHrkmiribaraikbn(nyknmeisaiTr.getZtriribaraikbn());
                        nyknmeisaiEty.setHrkmtrhkkbn(nyknmeisaiTr.getZtrtrhkkbn());
                        nyknmeisaiEty.setHrkmtrhkgk(nyknmeisaiTr.getZtrtrhkgk());
                        nyknmeisaiEty.setHrkmtatenkengk(nyknmeisaiTr.getZtrtatenkengk());
                        nyknmeisaiEty.setHrkmkknteijiymd6keta(nyknmeisaiTr.getZtrkknteijiymd6keta());
                        nyknmeisaiEty.setHrkmhwtrhnknymd6keta(nyknmeisaiTr.getZtrhwtrhnknymd6keta());
                        nyknmeisaiEty.setHrkmtgtkgtkbn(nyknmeisaiTr.getZtrtgtkgtkbn());
                        nyknmeisaiEty.setHrkmtgtkgtno(nyknmeisaiTr.getZtrtgtkgtno());
                        nyknmeisaiEty.setHrkmryoutenno(nyknmeisaiTr.getZtrryoutenno());
                        nyknmeisaiEty.setHrkmhrkmirnincd(nyknmeisaiTr.getZtrhrkmirnincd());
                        nyknmeisaiEty.setHrkmhrkmirninnm(nyknmeisaiTr.getZtrhrkmirninnm());
                        nyknmeisaiEty.setHrkmsimukebanknmkn(nyknmeisaiTr.getZtrsimukebanknmkn());
                        nyknmeisaiEty.setHrkmsimuketennmkn(nyknmeisaiTr.getZtrsimuketennmkn());
                        nyknmeisaiEty.setHrkmtekiyounaiyou(nyknmeisaiTr.getZtrtekiyounaiyou());
                        nyknmeisaiEty.setHrkmediinfo(nyknmeisaiTr.getZtrediinfo());
                        nyknmeisaiEty.setHrkmyobiv1(nyknmeisaiTr.getZtryobiv1());
                        nyknmeisaiEty.setHrkmrensakuseiymd6keta(nyknmeisaiTr.getZtrsakuseiymd6keta());

                        BizPropertyInitializer.initialize(nyknmeisaiEty);

                        nyknmeisaiEtyInsert.add(nyknmeisaiEty);
                        syoriKensu = syoriKensu + 1;

                    }
                }
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
