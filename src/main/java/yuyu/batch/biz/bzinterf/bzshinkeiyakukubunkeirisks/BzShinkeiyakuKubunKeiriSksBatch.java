package yuyu.batch.biz.bzinterf.bzshinkeiyakukubunkeirisks;

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
import yuyu.def.db.entity.ZT_SkKubunKeiriFileTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 新契約区分経理ファイル作成クラス
 */
public class BzShinkeiyakuKubunKeiriSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    private final String SHINKEIYAKU_KEIRI_KAIKEI_TANI = "5210000";

    private final String SHINKEIYAKU_KEIRI_FILE_SYS_KBN = C_KeirisysKbn.SINKEIYAKU.getValue();

    private final String SHINKEIYAKU_KEIRI_KANJOU_KBN = "0";

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


        try (EntityInserter<ZT_SkKubunKeiriFileTy> skKubunKeiriFileTyEntityInserter = new EntityInserter<>();
            ExDBResults<BT_DenpyoData> denpyoDataList = bizDomManager
                .getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(syoriYmd)) {

            List<ZT_SkKubunKeiriFileTy> skKubunKeiriFileTyList = new ArrayList<>();
            ZT_SkKubunKeiriFileTy preSkKubunKeiriFileTy = null;
            BT_DenpyoData preDenpyoData = null;

            for (BT_DenpyoData btDenpyoData : denpyoDataList) {

                if (preSkKubunKeiriFileTy == null) {

                    preSkKubunKeiriFileTy = new ZT_SkKubunKeiriFileTy();

                    preSkKubunKeiriFileTy.setZtykaikeitani(SHINKEIYAKU_KEIRI_KAIKEI_TANI);
                    preSkKubunKeiriFileTy.setZtysystemkbnnum(SHINKEIYAKU_KEIRI_FILE_SYS_KBN);
                    preSkKubunKeiriFileTy.setZtysyoricd("");
                    if (btDenpyoData.getDenymd() != null) {

                        preSkKubunKeiriFileTy.setZtytorihikiymd(String.valueOf(btDenpyoData.getDenymd()));
                    }
                    preSkKubunKeiriFileTy.setZtytorihikinon7("");
                    preSkKubunKeiriFileTy.setZtynyuuryokubasyo("");
                    preSkKubunKeiriFileTy.setZtynyuuryokusyacd("");
                    preSkKubunKeiriFileTy.setZtysyoriymdn(String.valueOf(syoriYmd));
                    preSkKubunKeiriFileTy.setZtykessankbn("0");
                    preSkKubunKeiriFileTy.setZtyonlinesyorikbn("0");
                    preSkKubunKeiriFileTy.setZtyyobiv28("");
                    preSkKubunKeiriFileTy.setZtykanjyoukbnn(SHINKEIYAKU_KEIRI_KANJOU_KBN);
                    preSkKubunKeiriFileTy.setZtytaisyakukbnn(btDenpyoData.getTaisyakukbn().getValue());
                    preSkKubunKeiriFileTy.setZtykanjyoukamokucdn(btDenpyoData.getKanjyouKamoku().
                        getDenkanjokamokucd());
                    preSkKubunKeiriFileTy.setZtyyobiv4("");
                    preSkKubunKeiriFileTy.setZtysuitoubumoncd(
                        btDenpyoData.getSuitoubumoncd().concat(ZERO_FOUR_KETA));
                    preSkKubunKeiriFileTy.setZtykingaku(
                        new BigDecimal(btDenpyoData.getDenyenkagk().toString()).longValue());
                    preSkKubunKeiriFileTy.setZtykizokusegment(btDenpyoData.getSeg1cd().getValue());
                    preSkKubunKeiriFileTy.setZtyaitesegment(btDenpyoData.getSeg2cd().getValue());
                    preSkKubunKeiriFileTy.setZtyyobiv23("");

                    skKubunKeiriFileTyList.add(preSkKubunKeiriFileTy);

                    preDenpyoData = btDenpyoData;
                }
                else {

                    if (BizDateUtil.compareYmd(preDenpyoData.getDenymd(), btDenpyoData.getDenymd())
                        == BizDateUtil.COMPARE_EQUAL &&
                        preDenpyoData.getHuridenatesakicd().equals(btDenpyoData.getHuridenatesakicd()) &&
                        preDenpyoData.getTaisyakukbn().eq(btDenpyoData.getTaisyakukbn()) &&
                        preDenpyoData.getKanjyouKamoku().getDenkanjokamokucd()
                        .equals(btDenpyoData.getKanjyouKamoku().getDenkanjokamokucd()) &&
                        preDenpyoData.getSeg1cd().eq(btDenpyoData.getSeg1cd()) &&
                        preDenpyoData.getNaibukeiyakukbn().eq(btDenpyoData.getNaibukeiyakukbn()) &&
                        preDenpyoData.getTekiyoukbn().eq(btDenpyoData.getTekiyoukbn())) {

                        preSkKubunKeiriFileTy.setZtykingaku(preSkKubunKeiriFileTy.getZtykingaku() +
                            new BigDecimal(btDenpyoData.getDenyenkagk().toString()).longValue());
                    }
                    else {

                        preSkKubunKeiriFileTy = new ZT_SkKubunKeiriFileTy();

                        preSkKubunKeiriFileTy.setZtykaikeitani(SHINKEIYAKU_KEIRI_KAIKEI_TANI);
                        preSkKubunKeiriFileTy.setZtysystemkbnnum(SHINKEIYAKU_KEIRI_FILE_SYS_KBN);
                        preSkKubunKeiriFileTy.setZtysyoricd("");
                        if (btDenpyoData.getDenymd() != null) {

                            preSkKubunKeiriFileTy.setZtytorihikiymd(String.valueOf(btDenpyoData.getDenymd()));
                        }
                        preSkKubunKeiriFileTy.setZtytorihikinon7("");
                        preSkKubunKeiriFileTy.setZtynyuuryokubasyo("");
                        preSkKubunKeiriFileTy.setZtynyuuryokusyacd("");
                        preSkKubunKeiriFileTy.setZtysyoriymdn(String.valueOf(syoriYmd));
                        preSkKubunKeiriFileTy.setZtykessankbn("0");
                        preSkKubunKeiriFileTy.setZtyonlinesyorikbn("0");
                        preSkKubunKeiriFileTy.setZtyyobiv28("");
                        preSkKubunKeiriFileTy.setZtykanjyoukbnn(SHINKEIYAKU_KEIRI_KANJOU_KBN);
                        preSkKubunKeiriFileTy.setZtytaisyakukbnn(btDenpyoData.getTaisyakukbn().getValue());
                        preSkKubunKeiriFileTy.setZtykanjyoukamokucdn(btDenpyoData.getKanjyouKamoku().
                            getDenkanjokamokucd());
                        preSkKubunKeiriFileTy.setZtyyobiv4("");
                        preSkKubunKeiriFileTy.setZtysuitoubumoncd(
                            btDenpyoData.getSuitoubumoncd().concat(ZERO_FOUR_KETA));
                        preSkKubunKeiriFileTy.setZtykingaku(
                            new BigDecimal(btDenpyoData.getDenyenkagk().toString()).longValue());
                        preSkKubunKeiriFileTy.setZtykizokusegment(btDenpyoData.getSeg1cd().getValue());
                        preSkKubunKeiriFileTy.setZtyaitesegment(btDenpyoData.getSeg2cd().getValue());
                        preSkKubunKeiriFileTy.setZtyyobiv23("");


                        skKubunKeiriFileTyList.add(preSkKubunKeiriFileTy);

                        preDenpyoData = btDenpyoData;
                    }
                }
            }
            for (ZT_SkKubunKeiriFileTy skKubunKeiriFileTy : skKubunKeiriFileTyList) {

                BizPropertyInitializer.initialize(skKubunKeiriFileTy);
                skKubunKeiriFileTyEntityInserter.add(skKubunKeiriFileTy);
                syoriKensuu++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
}
