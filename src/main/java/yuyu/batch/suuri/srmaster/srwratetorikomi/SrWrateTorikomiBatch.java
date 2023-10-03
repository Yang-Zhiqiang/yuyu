package yuyu.batch.suuri.srmaster.srwratetorikomi;

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
import yuyu.def.biz.detacher.BM_RateWDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RateW;
import yuyu.def.db.entity.ZT_RatewRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 マスタ取込 マスタ取込（Ｗレートマスタ）クラス
 */
public class SrWrateTorikomiBatch implements Batch {

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

        try (ExDBResults<ZT_RatewRn> exDBResults = zdbDomManager.getAllRatewRn()) {

            Iterator<ZT_RatewRn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001, "Ｗレートテーブル（連）"));

            }

            try (EntityInserter<BM_RateW> entityInserter = new EntityInserter<>()) {
                BM_RateW bmRateW = null;
                BM_RateW bmRateWSearch = null;
                while (iterator.hasNext()) {

                    bmRateW = createRateWData(iterator.next());

                    bmRateWSearch = bizDomManager.getRateW(bmRateW.getPalhokensyuruikigou(),
                        bmRateW.getPalhokensyuruikigousdicode(),
                        bmRateW.getPalyoteiriritu(),
                        bmRateW.getPalpmencode(),
                        bmRateW.getPalharaikomikaisuu(),
                        bmRateW.getPalhhknsei(),
                        bmRateW.getPalkeiyakujihhknnen(),
                        bmRateW.getPalsaimankihyouji(),
                        bmRateW.getPalhokenkikan(),
                        bmRateW.getPalpharaikomikikan(),
                        bmRateW.getPalannaihuyouriyuukbn(),
                        bmRateW.getRatetuukasyukbn(),
                        bmRateW.getRatedai1hknkkn());

                    bmRateWSearch = BM_RateWDetacher.detachRateWtouched(bmRateWSearch);

                    if (bmRateWSearch != null) {

                        jyuuhukuCount++;

                        continue;
                    }

                    BizPropertyInitializer.initialize(bmRateW);

                    entityInserter.add(bmRateW);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF1011, String.valueOf(jyuuhukuCount)));

    }

    private BM_RateW createRateWData(ZT_RatewRn pZtRatewRn) {

        BM_RateW bmRateW = new BM_RateW();

        bmRateW.setPalhokensyuruikigou(pZtRatewRn.getZrnhknsyukigou());
        bmRateW.setPalhokensyuruikigousdicode(pZtRatewRn.getZrnhknsyuruikigousedaikbn());
        bmRateW.setPalyoteiriritu(pZtRatewRn.getZrnyoteiriritu());
        bmRateW.setPalpmencode(pZtRatewRn.getZrnpmenkbn());
        bmRateW.setPalharaikomikaisuu(pZtRatewRn.getZrnhrkkaisuukbn());
        bmRateW.setPalhhknsei(pZtRatewRn.getZrnhhknsei());
        bmRateW.setPalkeiyakujihhknnen(pZtRatewRn.getZrnkeiyakujihhknnen());
        bmRateW.setPalsaimankihyouji(pZtRatewRn.getZrnsaimnkkykhyj());
        bmRateW.setPalhokenkikan(pZtRatewRn.getZrnhknkkn());
        bmRateW.setPalpharaikomikikan(pZtRatewRn.getZrnphrkkikn());
        bmRateW.setPalannaihuyouriyuukbn(pZtRatewRn.getZrnannaifuyouriyuukbn());
        bmRateW.setRatetuukasyukbn(pZtRatewRn.getZrntuukasyukbn());
        bmRateW.setRatedai1hknkkn(pZtRatewRn.getZrndai1hknkkn());
        bmRateW.setWrate00(BizNumber.valueOf(pZtRatewRn.getZrnwrate00()));
        bmRateW.setWrate01(BizNumber.valueOf(pZtRatewRn.getZrnwrate01()));
        bmRateW.setWrate02(BizNumber.valueOf(pZtRatewRn.getZrnwrate02()));
        bmRateW.setWrate03(BizNumber.valueOf(pZtRatewRn.getZrnwrate03()));
        bmRateW.setWrate04(BizNumber.valueOf(pZtRatewRn.getZrnwrate04()));
        bmRateW.setWrate05(BizNumber.valueOf(pZtRatewRn.getZrnwrate05()));
        bmRateW.setWrate06(BizNumber.valueOf(pZtRatewRn.getZrnwrate06()));
        bmRateW.setWrate07(BizNumber.valueOf(pZtRatewRn.getZrnwrate07()));
        bmRateW.setWrate08(BizNumber.valueOf(pZtRatewRn.getZrnwrate08()));
        bmRateW.setWrate09(BizNumber.valueOf(pZtRatewRn.getZrnwrate09()));
        bmRateW.setWrate10(BizNumber.valueOf(pZtRatewRn.getZrnwrate10()));
        bmRateW.setWrate11(BizNumber.valueOf(pZtRatewRn.getZrnwrate11()));
        bmRateW.setWrate12(BizNumber.valueOf(pZtRatewRn.getZrnwrate12()));
        bmRateW.setWrate13(BizNumber.valueOf(pZtRatewRn.getZrnwrate13()));
        bmRateW.setWrate14(BizNumber.valueOf(pZtRatewRn.getZrnwrate14()));
        bmRateW.setWrate15(BizNumber.valueOf(pZtRatewRn.getZrnwrate15()));
        bmRateW.setWrate16(BizNumber.valueOf(pZtRatewRn.getZrnwrate16()));
        bmRateW.setWrate17(BizNumber.valueOf(pZtRatewRn.getZrnwrate17()));
        bmRateW.setWrate18(BizNumber.valueOf(pZtRatewRn.getZrnwrate18()));
        bmRateW.setWrate19(BizNumber.valueOf(pZtRatewRn.getZrnwrate19()));
        bmRateW.setWrate20(BizNumber.valueOf(pZtRatewRn.getZrnwrate20()));
        bmRateW.setWrate21(BizNumber.valueOf(pZtRatewRn.getZrnwrate21()));
        bmRateW.setWrate22(BizNumber.valueOf(pZtRatewRn.getZrnwrate22()));
        bmRateW.setWrate23(BizNumber.valueOf(pZtRatewRn.getZrnwrate23()));
        bmRateW.setWrate24(BizNumber.valueOf(pZtRatewRn.getZrnwrate24()));
        bmRateW.setWrate25(BizNumber.valueOf(pZtRatewRn.getZrnwrate25()));
        bmRateW.setWrate26(BizNumber.valueOf(pZtRatewRn.getZrnwrate26()));
        bmRateW.setWrate27(BizNumber.valueOf(pZtRatewRn.getZrnwrate27()));
        bmRateW.setWrate28(BizNumber.valueOf(pZtRatewRn.getZrnwrate28()));
        bmRateW.setWrate29(BizNumber.valueOf(pZtRatewRn.getZrnwrate29()));
        bmRateW.setWrate30(BizNumber.valueOf(pZtRatewRn.getZrnwrate30()));
        bmRateW.setWrate31(BizNumber.valueOf(pZtRatewRn.getZrnwrate31()));
        bmRateW.setWrate32(BizNumber.valueOf(pZtRatewRn.getZrnwrate32()));
        bmRateW.setWrate33(BizNumber.valueOf(pZtRatewRn.getZrnwrate33()));
        bmRateW.setWrate34(BizNumber.valueOf(pZtRatewRn.getZrnwrate34()));
        bmRateW.setWrate35(BizNumber.valueOf(pZtRatewRn.getZrnwrate35()));
        bmRateW.setWrate36(BizNumber.valueOf(pZtRatewRn.getZrnwrate36()));
        bmRateW.setWrate37(BizNumber.valueOf(pZtRatewRn.getZrnwrate37()));
        bmRateW.setWrate38(BizNumber.valueOf(pZtRatewRn.getZrnwrate38()));
        bmRateW.setWrate39(BizNumber.valueOf(pZtRatewRn.getZrnwrate39()));
        bmRateW.setWrate40(BizNumber.valueOf(pZtRatewRn.getZrnwrate40()));
        bmRateW.setWrate41(BizNumber.valueOf(pZtRatewRn.getZrnwrate41()));
        bmRateW.setWrate42(BizNumber.valueOf(pZtRatewRn.getZrnwrate42()));
        bmRateW.setWrate43(BizNumber.valueOf(pZtRatewRn.getZrnwrate43()));
        bmRateW.setWrate44(BizNumber.valueOf(pZtRatewRn.getZrnwrate44()));
        bmRateW.setWrate45(BizNumber.valueOf(pZtRatewRn.getZrnwrate45()));
        bmRateW.setWrate46(BizNumber.valueOf(pZtRatewRn.getZrnwrate46()));
        bmRateW.setWrate47(BizNumber.valueOf(pZtRatewRn.getZrnwrate47()));
        bmRateW.setWrate48(BizNumber.valueOf(pZtRatewRn.getZrnwrate48()));
        bmRateW.setWrate49(BizNumber.valueOf(pZtRatewRn.getZrnwrate49()));
        bmRateW.setWrate50(BizNumber.valueOf(pZtRatewRn.getZrnwrate50()));
        bmRateW.setWrate51(BizNumber.valueOf(pZtRatewRn.getZrnwrate51()));
        bmRateW.setWrate52(BizNumber.valueOf(pZtRatewRn.getZrnwrate52()));
        bmRateW.setWrate53(BizNumber.valueOf(pZtRatewRn.getZrnwrate53()));
        bmRateW.setWrate54(BizNumber.valueOf(pZtRatewRn.getZrnwrate54()));
        bmRateW.setWrate55(BizNumber.valueOf(pZtRatewRn.getZrnwrate55()));
        bmRateW.setWrate56(BizNumber.valueOf(pZtRatewRn.getZrnwrate56()));
        bmRateW.setWrate57(BizNumber.valueOf(pZtRatewRn.getZrnwrate57()));
        bmRateW.setWrate58(BizNumber.valueOf(pZtRatewRn.getZrnwrate58()));
        bmRateW.setWrate59(BizNumber.valueOf(pZtRatewRn.getZrnwrate59()));
        bmRateW.setWrate60(BizNumber.valueOf(pZtRatewRn.getZrnwrate60()));
        bmRateW.setWrate61(BizNumber.valueOf(pZtRatewRn.getZrnwrate61()));
        bmRateW.setWrate62(BizNumber.valueOf(pZtRatewRn.getZrnwrate62()));
        bmRateW.setWrate63(BizNumber.valueOf(pZtRatewRn.getZrnwrate63()));
        bmRateW.setWrate64(BizNumber.valueOf(pZtRatewRn.getZrnwrate64()));
        bmRateW.setWrate65(BizNumber.valueOf(pZtRatewRn.getZrnwrate65()));
        bmRateW.setWrate66(BizNumber.valueOf(pZtRatewRn.getZrnwrate66()));
        bmRateW.setWrate67(BizNumber.valueOf(pZtRatewRn.getZrnwrate67()));
        bmRateW.setWrate68(BizNumber.valueOf(pZtRatewRn.getZrnwrate68()));
        bmRateW.setWrate69(BizNumber.valueOf(pZtRatewRn.getZrnwrate69()));
        bmRateW.setWrate70(BizNumber.valueOf(pZtRatewRn.getZrnwrate70()));
        bmRateW.setWrate71(BizNumber.valueOf(pZtRatewRn.getZrnwrate71()));
        bmRateW.setWrate72(BizNumber.valueOf(pZtRatewRn.getZrnwrate72()));
        bmRateW.setWrate73(BizNumber.valueOf(pZtRatewRn.getZrnwrate73()));
        bmRateW.setWrate74(BizNumber.valueOf(pZtRatewRn.getZrnwrate74()));
        bmRateW.setWrate75(BizNumber.valueOf(pZtRatewRn.getZrnwrate75()));
        bmRateW.setWrate76(BizNumber.valueOf(pZtRatewRn.getZrnwrate76()));
        bmRateW.setWrate77(BizNumber.valueOf(pZtRatewRn.getZrnwrate77()));
        bmRateW.setWrate78(BizNumber.valueOf(pZtRatewRn.getZrnwrate78()));
        bmRateW.setWrate79(BizNumber.valueOf(pZtRatewRn.getZrnwrate79()));
        bmRateW.setWrate80(BizNumber.valueOf(pZtRatewRn.getZrnwrate80()));
        bmRateW.setWrate81(BizNumber.valueOf(pZtRatewRn.getZrnwrate81()));
        bmRateW.setWrate82(BizNumber.valueOf(pZtRatewRn.getZrnwrate82()));
        bmRateW.setWrate83(BizNumber.valueOf(pZtRatewRn.getZrnwrate83()));
        bmRateW.setWrate84(BizNumber.valueOf(pZtRatewRn.getZrnwrate84()));
        bmRateW.setWrate85(BizNumber.valueOf(pZtRatewRn.getZrnwrate85()));
        bmRateW.setWrate86(BizNumber.valueOf(pZtRatewRn.getZrnwrate86()));
        bmRateW.setWrate87(BizNumber.valueOf(pZtRatewRn.getZrnwrate87()));
        bmRateW.setWrate88(BizNumber.valueOf(pZtRatewRn.getZrnwrate88()));
        bmRateW.setWrate89(BizNumber.valueOf(pZtRatewRn.getZrnwrate89()));
        bmRateW.setWrate90(BizNumber.valueOf(pZtRatewRn.getZrnwrate90()));
        bmRateW.setWrate91(BizNumber.valueOf(pZtRatewRn.getZrnwrate91()));
        bmRateW.setWrate92(BizNumber.valueOf(pZtRatewRn.getZrnwrate92()));
        bmRateW.setWrate93(BizNumber.valueOf(pZtRatewRn.getZrnwrate93()));
        bmRateW.setWrate94(BizNumber.valueOf(pZtRatewRn.getZrnwrate94()));
        bmRateW.setWrate95(BizNumber.valueOf(pZtRatewRn.getZrnwrate95()));
        bmRateW.setWrate96(BizNumber.valueOf(pZtRatewRn.getZrnwrate96()));
        bmRateW.setWrate97(BizNumber.valueOf(pZtRatewRn.getZrnwrate97()));
        bmRateW.setWrate98(BizNumber.valueOf(pZtRatewRn.getZrnwrate98()));
        bmRateW.setWrate99(BizNumber.valueOf(pZtRatewRn.getZrnwrate99()));

        return bmRateW;
    }

}
