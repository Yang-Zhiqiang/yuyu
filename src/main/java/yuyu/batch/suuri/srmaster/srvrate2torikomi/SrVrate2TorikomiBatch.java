package yuyu.batch.suuri.srmaster.srvrate2torikomi;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.detacher.BM_RateV2Detacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RateV2;
import yuyu.def.db.entity.ZT_Ratev2Rn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 マスタ取込 マスタ取込（Ｖレートマスタ２）クラス
 */
public class SrVrate2TorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long syoriCount = 0L;

        Long jyuuhukuCount = 0L;

        try (ExDBResults<ZT_Ratev2Rn> exDBResults = zdbDomManager.getAllRatev2Rn()) {

            Iterator<ZT_Ratev2Rn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001, "Ｖレートテーブル２（連）"));

            }

            try (EntityInserter<BM_RateV2> entityInserter = new EntityInserter<>()) {
                BM_RateV2 bmRateV2 = null;
                BM_RateV2 bmRateV2Search = null;
                while (iterator.hasNext()) {

                    bmRateV2 = createRateV2Data(iterator.next());

                    bmRateV2Search = bizDomManager.getRateV2(bmRateV2.getPalhokensyuruikigou(),
                        bmRateV2.getPalhokensyuruikigousdicode(),
                        bmRateV2.getPalyoteiriritu(),
                        bmRateV2.getPalpmencode(),
                        bmRateV2.getPalharaikomikaisuu(),
                        bmRateV2.getPalhhknsei(),
                        bmRateV2.getPalkeiyakujihhknnen(),
                        bmRateV2.getPalsaimankihyouji(),
                        bmRateV2.getPalhokenkikan(),
                        bmRateV2.getPalpharaikomikikan(),
                        bmRateV2.getPalannaihuyouriyuukbn(),
                        bmRateV2.getRatetuukasyukbn(),
                        bmRateV2.getRatedai1hknkkn());

                    bmRateV2Search = BM_RateV2Detacher.detachRateV2touched(bmRateV2Search);

                    if (bmRateV2Search != null) {

                        jyuuhukuCount++;

                        continue;
                    }

                    BizPropertyInitializer.initialize(bmRateV2);

                    entityInserter.add(bmRateV2);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF1011, String.valueOf(jyuuhukuCount)));

    }

    private BM_RateV2 createRateV2Data(ZT_Ratev2Rn pZtRatev2Rn) {

        BM_RateV2 bmRateV2 = new BM_RateV2();

        bmRateV2.setPalhokensyuruikigou(pZtRatev2Rn.getZrnhknsyukigou());
        bmRateV2.setPalhokensyuruikigousdicode(pZtRatev2Rn.getZrnhknsyuruikigousedaikbn());
        bmRateV2.setPalyoteiriritu(pZtRatev2Rn.getZrnyoteiriritu());
        bmRateV2.setPalpmencode(pZtRatev2Rn.getZrnpmenkbn());
        bmRateV2.setPalharaikomikaisuu(pZtRatev2Rn.getZrnhrkkaisuukbn());
        bmRateV2.setPalhhknsei(pZtRatev2Rn.getZrnhhknsei());
        bmRateV2.setPalkeiyakujihhknnen(pZtRatev2Rn.getZrnkeiyakujihhknnen());
        bmRateV2.setPalsaimankihyouji(pZtRatev2Rn.getZrnsaimnkkykhyj());
        bmRateV2.setPalhokenkikan(pZtRatev2Rn.getZrnhknkkn());
        bmRateV2.setPalpharaikomikikan(pZtRatev2Rn.getZrnphrkkikn());
        bmRateV2.setPalannaihuyouriyuukbn(pZtRatev2Rn.getZrnannaifuyouriyuukbn());
        bmRateV2.setRatetuukasyukbn(pZtRatev2Rn.getZrntuukasyukbn());
        bmRateV2.setRatedai1hknkkn(pZtRatev2Rn.getZrndai1hknkkn());
        bmRateV2.setVrate00(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate00()));
        bmRateV2.setVrate01(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate01()));
        bmRateV2.setVrate02(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate02()));
        bmRateV2.setVrate03(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate03()));
        bmRateV2.setVrate04(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate04()));
        bmRateV2.setVrate05(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate05()));
        bmRateV2.setVrate06(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate06()));
        bmRateV2.setVrate07(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate07()));
        bmRateV2.setVrate08(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate08()));
        bmRateV2.setVrate09(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate09()));
        bmRateV2.setVrate10(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate10()));
        bmRateV2.setVrate11(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate11()));
        bmRateV2.setVrate12(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate12()));
        bmRateV2.setVrate13(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate13()));
        bmRateV2.setVrate14(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate14()));
        bmRateV2.setVrate15(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate15()));
        bmRateV2.setVrate16(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate16()));
        bmRateV2.setVrate17(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate17()));
        bmRateV2.setVrate18(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate18()));
        bmRateV2.setVrate19(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate19()));
        bmRateV2.setVrate20(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate20()));
        bmRateV2.setVrate21(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate21()));
        bmRateV2.setVrate22(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate22()));
        bmRateV2.setVrate23(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate23()));
        bmRateV2.setVrate24(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate24()));
        bmRateV2.setVrate25(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate25()));
        bmRateV2.setVrate26(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate26()));
        bmRateV2.setVrate27(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate27()));
        bmRateV2.setVrate28(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate28()));
        bmRateV2.setVrate29(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate29()));
        bmRateV2.setVrate30(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate30()));
        bmRateV2.setVrate31(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate31()));
        bmRateV2.setVrate32(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate32()));
        bmRateV2.setVrate33(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate33()));
        bmRateV2.setVrate34(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate34()));
        bmRateV2.setVrate35(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate35()));
        bmRateV2.setVrate36(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate36()));
        bmRateV2.setVrate37(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate37()));
        bmRateV2.setVrate38(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate38()));
        bmRateV2.setVrate39(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate39()));
        bmRateV2.setVrate40(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate40()));
        bmRateV2.setVrate41(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate41()));
        bmRateV2.setVrate42(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate42()));
        bmRateV2.setVrate43(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate43()));
        bmRateV2.setVrate44(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate44()));
        bmRateV2.setVrate45(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate45()));
        bmRateV2.setVrate46(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate46()));
        bmRateV2.setVrate47(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate47()));
        bmRateV2.setVrate48(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate48()));
        bmRateV2.setVrate49(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate49()));
        bmRateV2.setVrate50(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate50()));
        bmRateV2.setVrate51(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate51()));
        bmRateV2.setVrate52(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate52()));
        bmRateV2.setVrate53(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate53()));
        bmRateV2.setVrate54(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate54()));
        bmRateV2.setVrate55(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate55()));
        bmRateV2.setVrate56(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate56()));
        bmRateV2.setVrate57(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate57()));
        bmRateV2.setVrate58(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate58()));
        bmRateV2.setVrate59(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate59()));
        bmRateV2.setVrate60(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate60()));
        bmRateV2.setVrate61(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate61()));
        bmRateV2.setVrate62(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate62()));
        bmRateV2.setVrate63(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate63()));
        bmRateV2.setVrate64(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate64()));
        bmRateV2.setVrate65(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate65()));
        bmRateV2.setVrate66(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate66()));
        bmRateV2.setVrate67(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate67()));
        bmRateV2.setVrate68(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate68()));
        bmRateV2.setVrate69(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate69()));
        bmRateV2.setVrate70(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate70()));
        bmRateV2.setVrate71(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate71()));
        bmRateV2.setVrate72(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate72()));
        bmRateV2.setVrate73(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate73()));
        bmRateV2.setVrate74(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate74()));
        bmRateV2.setVrate75(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate75()));
        bmRateV2.setVrate76(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate76()));
        bmRateV2.setVrate77(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate77()));
        bmRateV2.setVrate78(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate78()));
        bmRateV2.setVrate79(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate79()));
        bmRateV2.setVrate80(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate80()));
        bmRateV2.setVrate81(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate81()));
        bmRateV2.setVrate82(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate82()));
        bmRateV2.setVrate83(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate83()));
        bmRateV2.setVrate84(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate84()));
        bmRateV2.setVrate85(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate85()));
        bmRateV2.setVrate86(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate86()));
        bmRateV2.setVrate87(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate87()));
        bmRateV2.setVrate88(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate88()));
        bmRateV2.setVrate89(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate89()));
        bmRateV2.setVrate90(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate90()));
        bmRateV2.setVrate91(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate91()));
        bmRateV2.setVrate92(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate92()));
        bmRateV2.setVrate93(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate93()));
        bmRateV2.setVrate94(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate94()));
        bmRateV2.setVrate95(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate95()));
        bmRateV2.setVrate96(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate96()));
        bmRateV2.setVrate97(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate97()));
        bmRateV2.setVrate98(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate98()));
        bmRateV2.setVrate99(BizNumber.valueOf(pZtRatev2Rn.getZrnvrate99()));

        return bmRateV2;
    }

}
