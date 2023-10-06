package yuyu.batch.biz.bzinterf.bzkubunkeirisks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.ZT_KubunKeiriFileTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 区分経理ファイル作成クラス
 */
public class BzKubunKeiriSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    private final String KEIRI_KAIKEI_TANI = "5210000";

    private final String KEIRI_FILE_SYS_KBN = C_KeirisysKbn.FUHO.getValue();

    private final String KEIRI_KANJOU_KBN = "0";

    private final String ZERO_FOUR_KETA = "0000";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        try (EntityInserter<ZT_KubunKeiriFileTy> kaikeiTorihikiFileTyEntityInserter = new EntityInserter<>();
            ExDBResults<BT_DenpyoData> denpyoDataList = bizDomManager
                .getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(syoriYmd)) {

            List<ZT_KubunKeiriFileTy> ztKaikeiTorihikiFileTyList = new ArrayList<>();
            ZT_KubunKeiriFileTy preKubunKeiriFileTy = null;
            BT_DenpyoData preDenpyoData = null;

            for (BT_DenpyoData denpyoData : denpyoDataList) {

                if (preKubunKeiriFileTy == null) {

                    preKubunKeiriFileTy = new ZT_KubunKeiriFileTy();

                    preKubunKeiriFileTy.setZtykaikeitani(KEIRI_KAIKEI_TANI);
                    preKubunKeiriFileTy.setZtysystemkbnnum(KEIRI_FILE_SYS_KBN);
                    preKubunKeiriFileTy.setZtysyoricd("");
                    if (denpyoData.getDenymd() != null) {

                        preKubunKeiriFileTy.setZtytorihikiymd(String.valueOf(denpyoData.getDenymd()));
                    }
                    preKubunKeiriFileTy.setZtytorihikinon7("");
                    preKubunKeiriFileTy.setZtynyuuryokubasyo("");
                    preKubunKeiriFileTy.setZtynyuuryokusyacd("");
                    preKubunKeiriFileTy.setZtysyoriymdn(String.valueOf(syoriYmd));
                    preKubunKeiriFileTy.setZtykessankbn("0");
                    preKubunKeiriFileTy.setZtyonlinesyorikbn("0");
                    preKubunKeiriFileTy.setZtyyobiv28("");
                    preKubunKeiriFileTy.setZtykanjyoukbnn(KEIRI_KANJOU_KBN);
                    preKubunKeiriFileTy.setZtytaisyakukbnn(denpyoData.getTaisyakukbn().getValue());
                    preKubunKeiriFileTy.setZtykanjyoukamokucdn(
                        denpyoData.getKanjyouKamoku().getDenkanjokamokucd());
                    preKubunKeiriFileTy.setZtyyobiv4("");
                    preKubunKeiriFileTy.setZtysuitoubumoncd(
                        denpyoData.getSuitoubumoncd().concat(ZERO_FOUR_KETA));

                    preKubunKeiriFileTy.setZtykingaku(
                        new BigDecimal(denpyoData.getDenyenkagk().toString()).longValue());
                    preKubunKeiriFileTy.setZtykizokusegment(denpyoData.getSeg1cd().getValue());
                    preKubunKeiriFileTy.setZtyaitesegment(denpyoData.getSeg2cd().getValue());
                    preKubunKeiriFileTy.setZtyyobiv23("");

                    ztKaikeiTorihikiFileTyList.add(preKubunKeiriFileTy);

                    preDenpyoData = denpyoData;
                }
                else {

                    if (BizDateUtil.compareYmd(preDenpyoData.getDenymd(), denpyoData.getDenymd())
                        == BizDateUtil.COMPARE_EQUAL &&
                        preDenpyoData.getTaisyakukbn().eq(denpyoData.getTaisyakukbn()) &&
                        preDenpyoData.getKanjyouKamoku().getDenkanjokamokucd()
                        .equals(denpyoData.getKanjyouKamoku().getDenkanjokamokucd()) &&
                        preDenpyoData.getSeg1cd().equals(denpyoData.getSeg1cd()) &&
                        preDenpyoData.getSeg2cd().equals(denpyoData.getSeg2cd()) &&
                        preDenpyoData.getHuridenatesakicd().equals(denpyoData.getHuridenatesakicd())) {

                        preKubunKeiriFileTy.setZtykingaku(preKubunKeiriFileTy.getZtykingaku() +
                            new BigDecimal(denpyoData.getDenyenkagk().toString()).longValue());
                    }
                    else {

                        preKubunKeiriFileTy = new ZT_KubunKeiriFileTy();

                        preKubunKeiriFileTy.setZtykaikeitani(KEIRI_KAIKEI_TANI);
                        preKubunKeiriFileTy.setZtysystemkbnnum(KEIRI_FILE_SYS_KBN);
                        preKubunKeiriFileTy.setZtysyoricd("");
                        if (denpyoData.getDenymd() != null) {

                            preKubunKeiriFileTy.setZtytorihikiymd(String.valueOf(denpyoData.getDenymd()));
                        }
                        preKubunKeiriFileTy.setZtytorihikinon7("");
                        preKubunKeiriFileTy.setZtynyuuryokubasyo("");
                        preKubunKeiriFileTy.setZtynyuuryokusyacd("");
                        preKubunKeiriFileTy.setZtysyoriymdn(String.valueOf(syoriYmd));
                        preKubunKeiriFileTy.setZtykessankbn("0");
                        preKubunKeiriFileTy.setZtyonlinesyorikbn("0");
                        preKubunKeiriFileTy.setZtyyobiv28("");
                        preKubunKeiriFileTy.setZtykanjyoukbnn("0");
                        preKubunKeiriFileTy.setZtytaisyakukbnn(denpyoData.getTaisyakukbn().getValue());
                        preKubunKeiriFileTy.setZtykanjyoukamokucdn(denpyoData.getKanjyouKamoku().
                            getDenkanjokamokucd());
                        preKubunKeiriFileTy.setZtyyobiv4("");
                        preKubunKeiriFileTy.setZtysuitoubumoncd(
                            denpyoData.getSuitoubumoncd().concat(ZERO_FOUR_KETA));
                        preKubunKeiriFileTy.setZtykingaku(
                            new BigDecimal(denpyoData.getDenyenkagk().toString()).longValue());

                        preKubunKeiriFileTy.setZtykizokusegment(denpyoData.getSeg1cd().getValue());
                        preKubunKeiriFileTy.setZtyaitesegment(denpyoData.getSeg2cd().getValue());
                        preKubunKeiriFileTy.setZtyyobiv23("");

                        ztKaikeiTorihikiFileTyList.add(preKubunKeiriFileTy);

                        preDenpyoData = denpyoData;
                    }
                }
            }

            for (ZT_KubunKeiriFileTy ztKubunKeiriFileTy : ztKaikeiTorihikiFileTyList) {

                BizPropertyInitializer.initialize(ztKubunKeiriFileTy);
                kaikeiTorihikiFileTyEntityInserter.add(ztKubunKeiriFileTy);
                syoriKensuu++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
}
