package yuyu.batch.suuri.srmaster.srvratetorikomi;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RateV;
import yuyu.def.db.entity.ZT_RatevRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（Vレートテーブル（連））を読み込み、Ｖレートマスタに反映するクラス
 */
public class SrVrateTorikomiBatch implements Batch {

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

        try (ExDBResults<ZT_RatevRn> exDBResults = zdbDomManager.getAllRatevRn()) {

            Iterator<ZT_RatevRn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001, "Vレートテーブル（連）"));

            }

            try (EntityInserter<BM_RateV> entityInserter = new EntityInserter<>()) {
                BM_RateV bmRateV = null;
                BM_RateV bmRateVSearch = null;
                while (iterator.hasNext()) {

                    bmRateV = createRateVData(iterator.next());

                    bmRateVSearch = bizDomManager.getRateV(bmRateV.getPalhokensyuruikigou(),
                        bmRateV.getPalhokensyuruikigousdicode(),
                        bmRateV.getPalyoteiriritu(),
                        bmRateV.getPalpmencode(),
                        bmRateV.getPalharaikomikaisuu(),
                        bmRateV.getPalhhknsei(),
                        bmRateV.getPalkeiyakujihhknnen(),
                        bmRateV.getPalsaimankihyouji(),
                        bmRateV.getPalhokenkikan(),
                        bmRateV.getPalpharaikomikikan());

                    if (bmRateVSearch != null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA1007,
                            bmRateV.getPalhokensyuruikigou().
                            concat(bmRateV.getPalhokensyuruikigousdicode()).
                            concat(bmRateV.getPalyoteiriritu()).
                            concat(bmRateV.getPalpmencode()).
                            concat(bmRateV.getPalharaikomikaisuu()).
                            concat(bmRateV.getPalhhknsei()).
                            concat(bmRateV.getPalkeiyakujihhknnen()).
                            concat(bmRateV.getPalsaimankihyouji()).
                            concat(bmRateV.getPalhokenkikan()).
                            concat(bmRateV.getPalpharaikomikikan()),
                            "Vレートマスタ"));

                    }

                    BizPropertyInitializer.initialize(bmRateV);

                    entityInserter.add(bmRateV);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));

    }

    private BM_RateV createRateVData(ZT_RatevRn pZtRatevRn) {

        BM_RateV bmRateV = new BM_RateV();

        bmRateV.setPalhokensyuruikigou(pZtRatevRn.getZrnhknsyukigou());
        bmRateV.setPalhokensyuruikigousdicode(pZtRatevRn.getZrnhknsyuruikigousedaikbn());
        bmRateV.setPalyoteiriritu(pZtRatevRn.getZrnyoteiriritu());
        bmRateV.setPalpmencode(pZtRatevRn.getZrnpmenkbn());
        bmRateV.setPalharaikomikaisuu(pZtRatevRn.getZrnhrkkaisuukbn());
        bmRateV.setPalhhknsei(pZtRatevRn.getZrnhhknsei());
        bmRateV.setPalkeiyakujihhknnen(pZtRatevRn.getZrnkeiyakujihhknnen());
        bmRateV.setPalsaimankihyouji(pZtRatevRn.getZrnsaimnkkykhyj());
        bmRateV.setPalhokenkikan(pZtRatevRn.getZrnhknkkn());
        bmRateV.setPalpharaikomikikan(pZtRatevRn.getZrnphrkkikn());
        bmRateV.setVrate00(BizNumber.valueOf(pZtRatevRn.getZrnvrate00()));
        bmRateV.setVrate01(BizNumber.valueOf(pZtRatevRn.getZrnvrate01()));
        bmRateV.setVrate02(BizNumber.valueOf(pZtRatevRn.getZrnvrate02()));
        bmRateV.setVrate03(BizNumber.valueOf(pZtRatevRn.getZrnvrate03()));
        bmRateV.setVrate04(BizNumber.valueOf(pZtRatevRn.getZrnvrate04()));
        bmRateV.setVrate05(BizNumber.valueOf(pZtRatevRn.getZrnvrate05()));
        bmRateV.setVrate06(BizNumber.valueOf(pZtRatevRn.getZrnvrate06()));
        bmRateV.setVrate07(BizNumber.valueOf(pZtRatevRn.getZrnvrate07()));
        bmRateV.setVrate08(BizNumber.valueOf(pZtRatevRn.getZrnvrate08()));
        bmRateV.setVrate09(BizNumber.valueOf(pZtRatevRn.getZrnvrate09()));
        bmRateV.setVrate10(BizNumber.valueOf(pZtRatevRn.getZrnvrate10()));
        bmRateV.setVrate11(BizNumber.valueOf(pZtRatevRn.getZrnvrate11()));
        bmRateV.setVrate12(BizNumber.valueOf(pZtRatevRn.getZrnvrate12()));
        bmRateV.setVrate13(BizNumber.valueOf(pZtRatevRn.getZrnvrate13()));
        bmRateV.setVrate14(BizNumber.valueOf(pZtRatevRn.getZrnvrate14()));
        bmRateV.setVrate15(BizNumber.valueOf(pZtRatevRn.getZrnvrate15()));
        bmRateV.setVrate16(BizNumber.valueOf(pZtRatevRn.getZrnvrate16()));
        bmRateV.setVrate17(BizNumber.valueOf(pZtRatevRn.getZrnvrate17()));
        bmRateV.setVrate18(BizNumber.valueOf(pZtRatevRn.getZrnvrate18()));
        bmRateV.setVrate19(BizNumber.valueOf(pZtRatevRn.getZrnvrate19()));
        bmRateV.setVrate20(BizNumber.valueOf(pZtRatevRn.getZrnvrate20()));
        bmRateV.setVrate21(BizNumber.valueOf(pZtRatevRn.getZrnvrate21()));
        bmRateV.setVrate22(BizNumber.valueOf(pZtRatevRn.getZrnvrate22()));
        bmRateV.setVrate23(BizNumber.valueOf(pZtRatevRn.getZrnvrate23()));
        bmRateV.setVrate24(BizNumber.valueOf(pZtRatevRn.getZrnvrate24()));
        bmRateV.setVrate25(BizNumber.valueOf(pZtRatevRn.getZrnvrate25()));
        bmRateV.setVrate26(BizNumber.valueOf(pZtRatevRn.getZrnvrate26()));
        bmRateV.setVrate27(BizNumber.valueOf(pZtRatevRn.getZrnvrate27()));
        bmRateV.setVrate28(BizNumber.valueOf(pZtRatevRn.getZrnvrate28()));
        bmRateV.setVrate29(BizNumber.valueOf(pZtRatevRn.getZrnvrate29()));
        bmRateV.setVrate30(BizNumber.valueOf(pZtRatevRn.getZrnvrate30()));
        bmRateV.setVrate31(BizNumber.valueOf(pZtRatevRn.getZrnvrate31()));
        bmRateV.setVrate32(BizNumber.valueOf(pZtRatevRn.getZrnvrate32()));
        bmRateV.setVrate33(BizNumber.valueOf(pZtRatevRn.getZrnvrate33()));
        bmRateV.setVrate34(BizNumber.valueOf(pZtRatevRn.getZrnvrate34()));
        bmRateV.setVrate35(BizNumber.valueOf(pZtRatevRn.getZrnvrate35()));
        bmRateV.setVrate36(BizNumber.valueOf(pZtRatevRn.getZrnvrate36()));
        bmRateV.setVrate37(BizNumber.valueOf(pZtRatevRn.getZrnvrate37()));
        bmRateV.setVrate38(BizNumber.valueOf(pZtRatevRn.getZrnvrate38()));
        bmRateV.setVrate39(BizNumber.valueOf(pZtRatevRn.getZrnvrate39()));
        bmRateV.setVrate40(BizNumber.valueOf(pZtRatevRn.getZrnvrate40()));
        bmRateV.setVrate41(BizNumber.valueOf(pZtRatevRn.getZrnvrate41()));
        bmRateV.setVrate42(BizNumber.valueOf(pZtRatevRn.getZrnvrate42()));
        bmRateV.setVrate43(BizNumber.valueOf(pZtRatevRn.getZrnvrate43()));
        bmRateV.setVrate44(BizNumber.valueOf(pZtRatevRn.getZrnvrate44()));
        bmRateV.setVrate45(BizNumber.valueOf(pZtRatevRn.getZrnvrate45()));
        bmRateV.setVrate46(BizNumber.valueOf(pZtRatevRn.getZrnvrate46()));
        bmRateV.setVrate47(BizNumber.valueOf(pZtRatevRn.getZrnvrate47()));
        bmRateV.setVrate48(BizNumber.valueOf(pZtRatevRn.getZrnvrate48()));
        bmRateV.setVrate49(BizNumber.valueOf(pZtRatevRn.getZrnvrate49()));
        bmRateV.setVrate50(BizNumber.valueOf(pZtRatevRn.getZrnvrate50()));
        bmRateV.setVrate51(BizNumber.valueOf(pZtRatevRn.getZrnvrate51()));
        bmRateV.setVrate52(BizNumber.valueOf(pZtRatevRn.getZrnvrate52()));
        bmRateV.setVrate53(BizNumber.valueOf(pZtRatevRn.getZrnvrate53()));
        bmRateV.setVrate54(BizNumber.valueOf(pZtRatevRn.getZrnvrate54()));
        bmRateV.setVrate55(BizNumber.valueOf(pZtRatevRn.getZrnvrate55()));
        bmRateV.setVrate56(BizNumber.valueOf(pZtRatevRn.getZrnvrate56()));
        bmRateV.setVrate57(BizNumber.valueOf(pZtRatevRn.getZrnvrate57()));
        bmRateV.setVrate58(BizNumber.valueOf(pZtRatevRn.getZrnvrate58()));
        bmRateV.setVrate59(BizNumber.valueOf(pZtRatevRn.getZrnvrate59()));
        bmRateV.setVrate60(BizNumber.valueOf(pZtRatevRn.getZrnvrate60()));
        bmRateV.setVrate61(BizNumber.valueOf(pZtRatevRn.getZrnvrate61()));
        bmRateV.setVrate62(BizNumber.valueOf(pZtRatevRn.getZrnvrate62()));
        bmRateV.setVrate63(BizNumber.valueOf(pZtRatevRn.getZrnvrate63()));
        bmRateV.setVrate64(BizNumber.valueOf(pZtRatevRn.getZrnvrate64()));
        bmRateV.setVrate65(BizNumber.valueOf(pZtRatevRn.getZrnvrate65()));
        bmRateV.setVrate66(BizNumber.valueOf(pZtRatevRn.getZrnvrate66()));
        bmRateV.setVrate67(BizNumber.valueOf(pZtRatevRn.getZrnvrate67()));
        bmRateV.setVrate68(BizNumber.valueOf(pZtRatevRn.getZrnvrate68()));
        bmRateV.setVrate69(BizNumber.valueOf(pZtRatevRn.getZrnvrate69()));
        bmRateV.setVrate70(BizNumber.valueOf(pZtRatevRn.getZrnvrate70()));
        bmRateV.setVrate71(BizNumber.valueOf(pZtRatevRn.getZrnvrate71()));
        bmRateV.setVrate72(BizNumber.valueOf(pZtRatevRn.getZrnvrate72()));
        bmRateV.setVrate73(BizNumber.valueOf(pZtRatevRn.getZrnvrate73()));
        bmRateV.setVrate74(BizNumber.valueOf(pZtRatevRn.getZrnvrate74()));
        bmRateV.setVrate75(BizNumber.valueOf(pZtRatevRn.getZrnvrate75()));
        bmRateV.setVrate76(BizNumber.valueOf(pZtRatevRn.getZrnvrate76()));
        bmRateV.setVrate77(BizNumber.valueOf(pZtRatevRn.getZrnvrate77()));
        bmRateV.setVrate78(BizNumber.valueOf(pZtRatevRn.getZrnvrate78()));
        bmRateV.setVrate79(BizNumber.valueOf(pZtRatevRn.getZrnvrate79()));
        bmRateV.setVrate80(BizNumber.valueOf(pZtRatevRn.getZrnvrate80()));
        bmRateV.setVrate81(BizNumber.valueOf(pZtRatevRn.getZrnvrate81()));
        bmRateV.setVrate82(BizNumber.valueOf(pZtRatevRn.getZrnvrate82()));
        bmRateV.setVrate83(BizNumber.valueOf(pZtRatevRn.getZrnvrate83()));
        bmRateV.setVrate84(BizNumber.valueOf(pZtRatevRn.getZrnvrate84()));
        bmRateV.setVrate85(BizNumber.valueOf(pZtRatevRn.getZrnvrate85()));
        bmRateV.setVrate86(BizNumber.valueOf(pZtRatevRn.getZrnvrate86()));
        bmRateV.setVrate87(BizNumber.valueOf(pZtRatevRn.getZrnvrate87()));
        bmRateV.setVrate88(BizNumber.valueOf(pZtRatevRn.getZrnvrate88()));
        bmRateV.setVrate89(BizNumber.valueOf(pZtRatevRn.getZrnvrate89()));
        bmRateV.setVrate90(BizNumber.valueOf(pZtRatevRn.getZrnvrate90()));
        bmRateV.setVrate91(BizNumber.valueOf(pZtRatevRn.getZrnvrate91()));
        bmRateV.setVrate92(BizNumber.valueOf(pZtRatevRn.getZrnvrate92()));
        bmRateV.setVrate93(BizNumber.valueOf(pZtRatevRn.getZrnvrate93()));
        bmRateV.setVrate94(BizNumber.valueOf(pZtRatevRn.getZrnvrate94()));
        bmRateV.setVrate95(BizNumber.valueOf(pZtRatevRn.getZrnvrate95()));
        bmRateV.setVrate96(BizNumber.valueOf(pZtRatevRn.getZrnvrate96()));
        bmRateV.setVrate97(BizNumber.valueOf(pZtRatevRn.getZrnvrate97()));
        bmRateV.setVrate98(BizNumber.valueOf(pZtRatevRn.getZrnvrate98()));
        bmRateV.setVrate99(BizNumber.valueOf(pZtRatevRn.getZrnvrate99()));

        return bmRateV;
    }

}
