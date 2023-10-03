package yuyu.batch.suuri.srmaster.srdratetorikomi;

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
import yuyu.def.db.entity.BM_RateD;
import yuyu.def.db.entity.ZT_RatedRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（Ｄレートテーブル（連））を読み込み、Ｄレートマスタに反映するクラス
 */
public class SrDrateTorikomiBatch implements Batch {

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

        try (ExDBResults<ZT_RatedRn> exDBResults = zdbDomManager.getAllRatedRn()) {

            Iterator<ZT_RatedRn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001, "Ｄレートテーブル（連）"));

            }

            try (EntityInserter<BM_RateD> entityInserter = new EntityInserter<>()) {

                BM_RateD bmRateD = null;
                BM_RateD bmRateDSearch = null;
                while (iterator.hasNext()) {

                    bmRateD = createRateDData(iterator.next());

                    bmRateDSearch = bizDomManager.getRateD(bmRateD.getPalhokensyuruikigou(),
                        bmRateD.getPalhokensyuruikigousdicode(),
                        bmRateD.getPalyoteiriritu(),
                        bmRateD.getPalpmencode(),
                        bmRateD.getPalharaikomikaisuu(),
                        bmRateD.getPalhhknsei(),
                        bmRateD.getPalkeiyakujihhknnen(),
                        bmRateD.getPalsaimankihyouji(),
                        bmRateD.getPalhokenkikan(),
                        bmRateD.getPalpharaikomikikan(),
                        bmRateD.getPaldnendo(),
                        bmRateD.getPaldratenaikakucode());

                    if (bmRateDSearch != null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA1007,
                            bmRateD.getPalhokensyuruikigou().
                            concat(bmRateD.getPalhokensyuruikigousdicode()).
                            concat(bmRateD.getPalyoteiriritu()).
                            concat(bmRateD.getPalpmencode()).
                            concat(bmRateD.getPalharaikomikaisuu()).
                            concat(bmRateD.getPalhhknsei()).
                            concat(bmRateD.getPalkeiyakujihhknnen()).
                            concat(bmRateD.getPalsaimankihyouji()).
                            concat(bmRateD.getPalhokenkikan()).
                            concat(bmRateD.getPalpharaikomikikan()).
                            concat(bmRateD.getPaldnendo()).
                            concat(bmRateD.getPaldratenaikakucode()),
                            "Ｄレートマスタ"));

                    }

                    BizPropertyInitializer.initialize(bmRateD);

                    entityInserter.add(bmRateD);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));

    }

    private BM_RateD createRateDData(ZT_RatedRn pZtRatedRn) {

        BM_RateD bmRateD = new BM_RateD();

        bmRateD.setPalhokensyuruikigou(pZtRatedRn.getZrnhknsyukigou());
        bmRateD.setPalhokensyuruikigousdicode(pZtRatedRn.getZrnhknsyuruikigousedaikbn());
        bmRateD.setPalyoteiriritu(pZtRatedRn.getZrnyoteiriritu());
        bmRateD.setPalpmencode(pZtRatedRn.getZrnpmenkbn());
        bmRateD.setPalharaikomikaisuu(pZtRatedRn.getZrnhrkkaisuukbn());
        bmRateD.setPalhhknsei(pZtRatedRn.getZrnhhknsei());
        bmRateD.setPalkeiyakujihhknnen(pZtRatedRn.getZrnkeiyakujihhknnen());
        bmRateD.setPalsaimankihyouji(pZtRatedRn.getZrnsaimnkkykhyj());
        bmRateD.setPalhokenkikan(pZtRatedRn.getZrnhknkkn());
        bmRateD.setPalpharaikomikikan(pZtRatedRn.getZrnphrkkikn());
        bmRateD.setPaldnendo(pZtRatedRn.getZrndnendo());
        bmRateD.setPaldratenaikakucode(pZtRatedRn.getZrnnaiteikakuteikbn());
        bmRateD.setDrate00(BizNumber.valueOf(pZtRatedRn.getZrndrate00()));
        bmRateD.setDrate01(BizNumber.valueOf(pZtRatedRn.getZrndrate01()));
        bmRateD.setDrate02(BizNumber.valueOf(pZtRatedRn.getZrndrate02()));
        bmRateD.setDrate03(BizNumber.valueOf(pZtRatedRn.getZrndrate03()));
        bmRateD.setDrate04(BizNumber.valueOf(pZtRatedRn.getZrndrate04()));
        bmRateD.setDrate05(BizNumber.valueOf(pZtRatedRn.getZrndrate05()));
        bmRateD.setDrate06(BizNumber.valueOf(pZtRatedRn.getZrndrate06()));
        bmRateD.setDrate07(BizNumber.valueOf(pZtRatedRn.getZrndrate07()));
        bmRateD.setDrate08(BizNumber.valueOf(pZtRatedRn.getZrndrate08()));
        bmRateD.setDrate09(BizNumber.valueOf(pZtRatedRn.getZrndrate09()));
        bmRateD.setDrate10(BizNumber.valueOf(pZtRatedRn.getZrndrate10()));
        bmRateD.setDrate11(BizNumber.valueOf(pZtRatedRn.getZrndrate11()));
        bmRateD.setDrate12(BizNumber.valueOf(pZtRatedRn.getZrndrate12()));
        bmRateD.setDrate13(BizNumber.valueOf(pZtRatedRn.getZrndrate13()));
        bmRateD.setDrate14(BizNumber.valueOf(pZtRatedRn.getZrndrate14()));
        bmRateD.setDrate15(BizNumber.valueOf(pZtRatedRn.getZrndrate15()));
        bmRateD.setDrate16(BizNumber.valueOf(pZtRatedRn.getZrndrate16()));
        bmRateD.setDrate17(BizNumber.valueOf(pZtRatedRn.getZrndrate17()));
        bmRateD.setDrate18(BizNumber.valueOf(pZtRatedRn.getZrndrate18()));
        bmRateD.setDrate19(BizNumber.valueOf(pZtRatedRn.getZrndrate19()));
        bmRateD.setDrate20(BizNumber.valueOf(pZtRatedRn.getZrndrate20()));
        bmRateD.setDrate21(BizNumber.valueOf(pZtRatedRn.getZrndrate21()));
        bmRateD.setDrate22(BizNumber.valueOf(pZtRatedRn.getZrndrate22()));
        bmRateD.setDrate23(BizNumber.valueOf(pZtRatedRn.getZrndrate23()));
        bmRateD.setDrate24(BizNumber.valueOf(pZtRatedRn.getZrndrate24()));
        bmRateD.setDrate25(BizNumber.valueOf(pZtRatedRn.getZrndrate25()));
        bmRateD.setDrate26(BizNumber.valueOf(pZtRatedRn.getZrndrate26()));
        bmRateD.setDrate27(BizNumber.valueOf(pZtRatedRn.getZrndrate27()));
        bmRateD.setDrate28(BizNumber.valueOf(pZtRatedRn.getZrndrate28()));
        bmRateD.setDrate29(BizNumber.valueOf(pZtRatedRn.getZrndrate29()));
        bmRateD.setDrate30(BizNumber.valueOf(pZtRatedRn.getZrndrate30()));
        bmRateD.setDrate31(BizNumber.valueOf(pZtRatedRn.getZrndrate31()));
        bmRateD.setDrate32(BizNumber.valueOf(pZtRatedRn.getZrndrate32()));
        bmRateD.setDrate33(BizNumber.valueOf(pZtRatedRn.getZrndrate33()));
        bmRateD.setDrate34(BizNumber.valueOf(pZtRatedRn.getZrndrate34()));
        bmRateD.setDrate35(BizNumber.valueOf(pZtRatedRn.getZrndrate35()));
        bmRateD.setDrate36(BizNumber.valueOf(pZtRatedRn.getZrndrate36()));
        bmRateD.setDrate37(BizNumber.valueOf(pZtRatedRn.getZrndrate37()));
        bmRateD.setDrate38(BizNumber.valueOf(pZtRatedRn.getZrndrate38()));
        bmRateD.setDrate39(BizNumber.valueOf(pZtRatedRn.getZrndrate39()));
        bmRateD.setDrate40(BizNumber.valueOf(pZtRatedRn.getZrndrate40()));
        bmRateD.setDrate41(BizNumber.valueOf(pZtRatedRn.getZrndrate41()));
        bmRateD.setDrate42(BizNumber.valueOf(pZtRatedRn.getZrndrate42()));
        bmRateD.setDrate43(BizNumber.valueOf(pZtRatedRn.getZrndrate43()));
        bmRateD.setDrate44(BizNumber.valueOf(pZtRatedRn.getZrndrate44()));
        bmRateD.setDrate45(BizNumber.valueOf(pZtRatedRn.getZrndrate45()));
        bmRateD.setDrate46(BizNumber.valueOf(pZtRatedRn.getZrndrate46()));
        bmRateD.setDrate47(BizNumber.valueOf(pZtRatedRn.getZrndrate47()));
        bmRateD.setDrate48(BizNumber.valueOf(pZtRatedRn.getZrndrate48()));
        bmRateD.setDrate49(BizNumber.valueOf(pZtRatedRn.getZrndrate49()));
        bmRateD.setDrate50(BizNumber.valueOf(pZtRatedRn.getZrndrate50()));
        bmRateD.setDrate51(BizNumber.valueOf(pZtRatedRn.getZrndrate51()));
        bmRateD.setDrate52(BizNumber.valueOf(pZtRatedRn.getZrndrate52()));
        bmRateD.setDrate53(BizNumber.valueOf(pZtRatedRn.getZrndrate53()));
        bmRateD.setDrate54(BizNumber.valueOf(pZtRatedRn.getZrndrate54()));
        bmRateD.setDrate55(BizNumber.valueOf(pZtRatedRn.getZrndrate55()));
        bmRateD.setDrate56(BizNumber.valueOf(pZtRatedRn.getZrndrate56()));
        bmRateD.setDrate57(BizNumber.valueOf(pZtRatedRn.getZrndrate57()));
        bmRateD.setDrate58(BizNumber.valueOf(pZtRatedRn.getZrndrate58()));
        bmRateD.setDrate59(BizNumber.valueOf(pZtRatedRn.getZrndrate59()));
        bmRateD.setDrate60(BizNumber.valueOf(pZtRatedRn.getZrndrate60()));
        bmRateD.setDrate61(BizNumber.valueOf(pZtRatedRn.getZrndrate61()));
        bmRateD.setDrate62(BizNumber.valueOf(pZtRatedRn.getZrndrate62()));
        bmRateD.setDrate63(BizNumber.valueOf(pZtRatedRn.getZrndrate63()));
        bmRateD.setDrate64(BizNumber.valueOf(pZtRatedRn.getZrndrate64()));
        bmRateD.setDrate65(BizNumber.valueOf(pZtRatedRn.getZrndrate65()));
        bmRateD.setDrate66(BizNumber.valueOf(pZtRatedRn.getZrndrate66()));
        bmRateD.setDrate67(BizNumber.valueOf(pZtRatedRn.getZrndrate67()));
        bmRateD.setDrate68(BizNumber.valueOf(pZtRatedRn.getZrndrate68()));
        bmRateD.setDrate69(BizNumber.valueOf(pZtRatedRn.getZrndrate69()));
        bmRateD.setDrate70(BizNumber.valueOf(pZtRatedRn.getZrndrate70()));
        bmRateD.setDrate71(BizNumber.valueOf(pZtRatedRn.getZrndrate71()));
        bmRateD.setDrate72(BizNumber.valueOf(pZtRatedRn.getZrndrate72()));
        bmRateD.setDrate73(BizNumber.valueOf(pZtRatedRn.getZrndrate73()));
        bmRateD.setDrate74(BizNumber.valueOf(pZtRatedRn.getZrndrate74()));
        bmRateD.setDrate75(BizNumber.valueOf(pZtRatedRn.getZrndrate75()));
        bmRateD.setDrate76(BizNumber.valueOf(pZtRatedRn.getZrndrate76()));
        bmRateD.setDrate77(BizNumber.valueOf(pZtRatedRn.getZrndrate77()));
        bmRateD.setDrate78(BizNumber.valueOf(pZtRatedRn.getZrndrate78()));
        bmRateD.setDrate79(BizNumber.valueOf(pZtRatedRn.getZrndrate79()));
        bmRateD.setDrate80(BizNumber.valueOf(pZtRatedRn.getZrndrate80()));
        bmRateD.setDrate81(BizNumber.valueOf(pZtRatedRn.getZrndrate81()));
        bmRateD.setDrate82(BizNumber.valueOf(pZtRatedRn.getZrndrate82()));
        bmRateD.setDrate83(BizNumber.valueOf(pZtRatedRn.getZrndrate83()));
        bmRateD.setDrate84(BizNumber.valueOf(pZtRatedRn.getZrndrate84()));
        bmRateD.setDrate85(BizNumber.valueOf(pZtRatedRn.getZrndrate85()));
        bmRateD.setDrate86(BizNumber.valueOf(pZtRatedRn.getZrndrate86()));
        bmRateD.setDrate87(BizNumber.valueOf(pZtRatedRn.getZrndrate87()));
        bmRateD.setDrate88(BizNumber.valueOf(pZtRatedRn.getZrndrate88()));
        bmRateD.setDrate89(BizNumber.valueOf(pZtRatedRn.getZrndrate89()));
        bmRateD.setDrate90(BizNumber.valueOf(pZtRatedRn.getZrndrate90()));
        bmRateD.setDrate91(BizNumber.valueOf(pZtRatedRn.getZrndrate91()));
        bmRateD.setDrate92(BizNumber.valueOf(pZtRatedRn.getZrndrate92()));
        bmRateD.setDrate93(BizNumber.valueOf(pZtRatedRn.getZrndrate93()));
        bmRateD.setDrate94(BizNumber.valueOf(pZtRatedRn.getZrndrate94()));
        bmRateD.setDrate95(BizNumber.valueOf(pZtRatedRn.getZrndrate95()));
        bmRateD.setDrate96(BizNumber.valueOf(pZtRatedRn.getZrndrate96()));
        bmRateD.setDrate97(BizNumber.valueOf(pZtRatedRn.getZrndrate97()));
        bmRateD.setDrate98(BizNumber.valueOf(pZtRatedRn.getZrndrate98()));
        bmRateD.setDrate99(BizNumber.valueOf(pZtRatedRn.getZrndrate99()));
        bmRateD.setSisadrate00(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate00()));
        bmRateD.setSisadrate01(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate01()));
        bmRateD.setSisadrate02(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate02()));
        bmRateD.setSisadrate03(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate03()));
        bmRateD.setSisadrate04(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate04()));
        bmRateD.setSisadrate05(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate05()));
        bmRateD.setSisadrate06(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate06()));
        bmRateD.setSisadrate07(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate07()));
        bmRateD.setSisadrate08(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate08()));
        bmRateD.setSisadrate09(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate09()));
        bmRateD.setSisadrate10(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate10()));
        bmRateD.setSisadrate11(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate11()));
        bmRateD.setSisadrate12(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate12()));
        bmRateD.setSisadrate13(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate13()));
        bmRateD.setSisadrate14(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate14()));
        bmRateD.setSisadrate15(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate15()));
        bmRateD.setSisadrate16(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate16()));
        bmRateD.setSisadrate17(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate17()));
        bmRateD.setSisadrate18(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate18()));
        bmRateD.setSisadrate19(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate19()));
        bmRateD.setSisadrate20(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate20()));
        bmRateD.setSisadrate21(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate21()));
        bmRateD.setSisadrate22(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate22()));
        bmRateD.setSisadrate23(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate23()));
        bmRateD.setSisadrate24(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate24()));
        bmRateD.setSisadrate25(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate25()));
        bmRateD.setSisadrate26(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate26()));
        bmRateD.setSisadrate27(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate27()));
        bmRateD.setSisadrate28(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate28()));
        bmRateD.setSisadrate29(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate29()));
        bmRateD.setSisadrate30(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate30()));
        bmRateD.setSisadrate31(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate31()));
        bmRateD.setSisadrate32(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate32()));
        bmRateD.setSisadrate33(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate33()));
        bmRateD.setSisadrate34(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate34()));
        bmRateD.setSisadrate35(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate35()));
        bmRateD.setSisadrate36(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate36()));
        bmRateD.setSisadrate37(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate37()));
        bmRateD.setSisadrate38(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate38()));
        bmRateD.setSisadrate39(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate39()));
        bmRateD.setSisadrate40(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate40()));
        bmRateD.setSisadrate41(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate41()));
        bmRateD.setSisadrate42(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate42()));
        bmRateD.setSisadrate43(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate43()));
        bmRateD.setSisadrate44(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate44()));
        bmRateD.setSisadrate45(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate45()));
        bmRateD.setSisadrate46(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate46()));
        bmRateD.setSisadrate47(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate47()));
        bmRateD.setSisadrate48(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate48()));
        bmRateD.setSisadrate49(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate49()));
        bmRateD.setSisadrate50(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate50()));
        bmRateD.setSisadrate51(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate51()));
        bmRateD.setSisadrate52(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate52()));
        bmRateD.setSisadrate53(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate53()));
        bmRateD.setSisadrate54(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate54()));
        bmRateD.setSisadrate55(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate55()));
        bmRateD.setSisadrate56(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate56()));
        bmRateD.setSisadrate57(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate57()));
        bmRateD.setSisadrate58(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate58()));
        bmRateD.setSisadrate59(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate59()));
        bmRateD.setSisadrate60(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate60()));
        bmRateD.setSisadrate61(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate61()));
        bmRateD.setSisadrate62(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate62()));
        bmRateD.setSisadrate63(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate63()));
        bmRateD.setSisadrate64(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate64()));
        bmRateD.setSisadrate65(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate65()));
        bmRateD.setSisadrate66(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate66()));
        bmRateD.setSisadrate67(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate67()));
        bmRateD.setSisadrate68(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate68()));
        bmRateD.setSisadrate69(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate69()));
        bmRateD.setSisadrate70(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate70()));
        bmRateD.setSisadrate71(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate71()));
        bmRateD.setSisadrate72(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate72()));
        bmRateD.setSisadrate73(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate73()));
        bmRateD.setSisadrate74(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate74()));
        bmRateD.setSisadrate75(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate75()));
        bmRateD.setSisadrate76(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate76()));
        bmRateD.setSisadrate77(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate77()));
        bmRateD.setSisadrate78(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate78()));
        bmRateD.setSisadrate79(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate79()));
        bmRateD.setSisadrate80(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate80()));
        bmRateD.setSisadrate81(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate81()));
        bmRateD.setSisadrate82(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate82()));
        bmRateD.setSisadrate83(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate83()));
        bmRateD.setSisadrate84(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate84()));
        bmRateD.setSisadrate85(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate85()));
        bmRateD.setSisadrate86(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate86()));
        bmRateD.setSisadrate87(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate87()));
        bmRateD.setSisadrate88(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate88()));
        bmRateD.setSisadrate89(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate89()));
        bmRateD.setSisadrate90(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate90()));
        bmRateD.setSisadrate91(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate91()));
        bmRateD.setSisadrate92(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate92()));
        bmRateD.setSisadrate93(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate93()));
        bmRateD.setSisadrate94(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate94()));
        bmRateD.setSisadrate95(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate95()));
        bmRateD.setSisadrate96(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate96()));
        bmRateD.setSisadrate97(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate97()));
        bmRateD.setSisadrate98(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate98()));
        bmRateD.setSisadrate99(BizNumber.valueOf(pZtRatedRn.getZrnsisadrate99()));
        bmRateD.setRisadrate00(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate00()));
        bmRateD.setRisadrate01(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate01()));
        bmRateD.setRisadrate02(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate02()));
        bmRateD.setRisadrate03(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate03()));
        bmRateD.setRisadrate04(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate04()));
        bmRateD.setRisadrate05(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate05()));
        bmRateD.setRisadrate06(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate06()));
        bmRateD.setRisadrate07(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate07()));
        bmRateD.setRisadrate08(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate08()));
        bmRateD.setRisadrate09(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate09()));
        bmRateD.setRisadrate10(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate10()));
        bmRateD.setRisadrate11(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate11()));
        bmRateD.setRisadrate12(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate12()));
        bmRateD.setRisadrate13(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate13()));
        bmRateD.setRisadrate14(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate14()));
        bmRateD.setRisadrate15(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate15()));
        bmRateD.setRisadrate16(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate16()));
        bmRateD.setRisadrate17(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate17()));
        bmRateD.setRisadrate18(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate18()));
        bmRateD.setRisadrate19(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate19()));
        bmRateD.setRisadrate20(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate20()));
        bmRateD.setRisadrate21(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate21()));
        bmRateD.setRisadrate22(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate22()));
        bmRateD.setRisadrate23(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate23()));
        bmRateD.setRisadrate24(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate24()));
        bmRateD.setRisadrate25(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate25()));
        bmRateD.setRisadrate26(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate26()));
        bmRateD.setRisadrate27(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate27()));
        bmRateD.setRisadrate28(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate28()));
        bmRateD.setRisadrate29(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate29()));
        bmRateD.setRisadrate30(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate30()));
        bmRateD.setRisadrate31(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate31()));
        bmRateD.setRisadrate32(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate32()));
        bmRateD.setRisadrate33(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate33()));
        bmRateD.setRisadrate34(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate34()));
        bmRateD.setRisadrate35(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate35()));
        bmRateD.setRisadrate36(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate36()));
        bmRateD.setRisadrate37(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate37()));
        bmRateD.setRisadrate38(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate38()));
        bmRateD.setRisadrate39(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate39()));
        bmRateD.setRisadrate40(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate40()));
        bmRateD.setRisadrate41(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate41()));
        bmRateD.setRisadrate42(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate42()));
        bmRateD.setRisadrate43(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate43()));
        bmRateD.setRisadrate44(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate44()));
        bmRateD.setRisadrate45(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate45()));
        bmRateD.setRisadrate46(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate46()));
        bmRateD.setRisadrate47(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate47()));
        bmRateD.setRisadrate48(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate48()));
        bmRateD.setRisadrate49(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate49()));
        bmRateD.setRisadrate50(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate50()));
        bmRateD.setRisadrate51(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate51()));
        bmRateD.setRisadrate52(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate52()));
        bmRateD.setRisadrate53(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate53()));
        bmRateD.setRisadrate54(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate54()));
        bmRateD.setRisadrate55(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate55()));
        bmRateD.setRisadrate56(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate56()));
        bmRateD.setRisadrate57(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate57()));
        bmRateD.setRisadrate58(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate58()));
        bmRateD.setRisadrate59(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate59()));
        bmRateD.setRisadrate60(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate60()));
        bmRateD.setRisadrate61(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate61()));
        bmRateD.setRisadrate62(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate62()));
        bmRateD.setRisadrate63(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate63()));
        bmRateD.setRisadrate64(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate64()));
        bmRateD.setRisadrate65(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate65()));
        bmRateD.setRisadrate66(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate66()));
        bmRateD.setRisadrate67(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate67()));
        bmRateD.setRisadrate68(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate68()));
        bmRateD.setRisadrate69(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate69()));
        bmRateD.setRisadrate70(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate70()));
        bmRateD.setRisadrate71(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate71()));
        bmRateD.setRisadrate72(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate72()));
        bmRateD.setRisadrate73(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate73()));
        bmRateD.setRisadrate74(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate74()));
        bmRateD.setRisadrate75(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate75()));
        bmRateD.setRisadrate76(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate76()));
        bmRateD.setRisadrate77(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate77()));
        bmRateD.setRisadrate78(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate78()));
        bmRateD.setRisadrate79(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate79()));
        bmRateD.setRisadrate80(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate80()));
        bmRateD.setRisadrate81(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate81()));
        bmRateD.setRisadrate82(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate82()));
        bmRateD.setRisadrate83(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate83()));
        bmRateD.setRisadrate84(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate84()));
        bmRateD.setRisadrate85(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate85()));
        bmRateD.setRisadrate86(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate86()));
        bmRateD.setRisadrate87(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate87()));
        bmRateD.setRisadrate88(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate88()));
        bmRateD.setRisadrate89(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate89()));
        bmRateD.setRisadrate90(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate90()));
        bmRateD.setRisadrate91(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate91()));
        bmRateD.setRisadrate92(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate92()));
        bmRateD.setRisadrate93(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate93()));
        bmRateD.setRisadrate94(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate94()));
        bmRateD.setRisadrate95(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate95()));
        bmRateD.setRisadrate96(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate96()));
        bmRateD.setRisadrate97(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate97()));
        bmRateD.setRisadrate98(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate98()));
        bmRateD.setRisadrate99(BizNumber.valueOf(pZtRatedRn.getZrnrisadrate99()));
        bmRateD.setHisadrate00(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate00()));
        bmRateD.setHisadrate01(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate01()));
        bmRateD.setHisadrate02(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate02()));
        bmRateD.setHisadrate03(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate03()));
        bmRateD.setHisadrate04(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate04()));
        bmRateD.setHisadrate05(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate05()));
        bmRateD.setHisadrate06(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate06()));
        bmRateD.setHisadrate07(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate07()));
        bmRateD.setHisadrate08(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate08()));
        bmRateD.setHisadrate09(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate09()));
        bmRateD.setHisadrate10(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate10()));
        bmRateD.setHisadrate11(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate11()));
        bmRateD.setHisadrate12(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate12()));
        bmRateD.setHisadrate13(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate13()));
        bmRateD.setHisadrate14(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate14()));
        bmRateD.setHisadrate15(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate15()));
        bmRateD.setHisadrate16(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate16()));
        bmRateD.setHisadrate17(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate17()));
        bmRateD.setHisadrate18(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate18()));
        bmRateD.setHisadrate19(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate19()));
        bmRateD.setHisadrate20(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate20()));
        bmRateD.setHisadrate21(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate21()));
        bmRateD.setHisadrate22(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate22()));
        bmRateD.setHisadrate23(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate23()));
        bmRateD.setHisadrate24(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate24()));
        bmRateD.setHisadrate25(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate25()));
        bmRateD.setHisadrate26(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate26()));
        bmRateD.setHisadrate27(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate27()));
        bmRateD.setHisadrate28(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate28()));
        bmRateD.setHisadrate29(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate29()));
        bmRateD.setHisadrate30(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate30()));
        bmRateD.setHisadrate31(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate31()));
        bmRateD.setHisadrate32(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate32()));
        bmRateD.setHisadrate33(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate33()));
        bmRateD.setHisadrate34(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate34()));
        bmRateD.setHisadrate35(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate35()));
        bmRateD.setHisadrate36(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate36()));
        bmRateD.setHisadrate37(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate37()));
        bmRateD.setHisadrate38(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate38()));
        bmRateD.setHisadrate39(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate39()));
        bmRateD.setHisadrate40(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate40()));
        bmRateD.setHisadrate41(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate41()));
        bmRateD.setHisadrate42(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate42()));
        bmRateD.setHisadrate43(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate43()));
        bmRateD.setHisadrate44(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate44()));
        bmRateD.setHisadrate45(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate45()));
        bmRateD.setHisadrate46(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate46()));
        bmRateD.setHisadrate47(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate47()));
        bmRateD.setHisadrate48(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate48()));
        bmRateD.setHisadrate49(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate49()));
        bmRateD.setHisadrate50(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate50()));
        bmRateD.setHisadrate51(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate51()));
        bmRateD.setHisadrate52(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate52()));
        bmRateD.setHisadrate53(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate53()));
        bmRateD.setHisadrate54(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate54()));
        bmRateD.setHisadrate55(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate55()));
        bmRateD.setHisadrate56(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate56()));
        bmRateD.setHisadrate57(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate57()));
        bmRateD.setHisadrate58(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate58()));
        bmRateD.setHisadrate59(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate59()));
        bmRateD.setHisadrate60(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate60()));
        bmRateD.setHisadrate61(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate61()));
        bmRateD.setHisadrate62(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate62()));
        bmRateD.setHisadrate63(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate63()));
        bmRateD.setHisadrate64(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate64()));
        bmRateD.setHisadrate65(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate65()));
        bmRateD.setHisadrate66(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate66()));
        bmRateD.setHisadrate67(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate67()));
        bmRateD.setHisadrate68(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate68()));
        bmRateD.setHisadrate69(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate69()));
        bmRateD.setHisadrate70(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate70()));
        bmRateD.setHisadrate71(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate71()));
        bmRateD.setHisadrate72(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate72()));
        bmRateD.setHisadrate73(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate73()));
        bmRateD.setHisadrate74(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate74()));
        bmRateD.setHisadrate75(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate75()));
        bmRateD.setHisadrate76(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate76()));
        bmRateD.setHisadrate77(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate77()));
        bmRateD.setHisadrate78(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate78()));
        bmRateD.setHisadrate79(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate79()));
        bmRateD.setHisadrate80(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate80()));
        bmRateD.setHisadrate81(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate81()));
        bmRateD.setHisadrate82(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate82()));
        bmRateD.setHisadrate83(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate83()));
        bmRateD.setHisadrate84(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate84()));
        bmRateD.setHisadrate85(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate85()));
        bmRateD.setHisadrate86(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate86()));
        bmRateD.setHisadrate87(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate87()));
        bmRateD.setHisadrate88(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate88()));
        bmRateD.setHisadrate89(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate89()));
        bmRateD.setHisadrate90(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate90()));
        bmRateD.setHisadrate91(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate91()));
        bmRateD.setHisadrate92(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate92()));
        bmRateD.setHisadrate93(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate93()));
        bmRateD.setHisadrate94(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate94()));
        bmRateD.setHisadrate95(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate95()));
        bmRateD.setHisadrate96(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate96()));
        bmRateD.setHisadrate97(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate97()));
        bmRateD.setHisadrate98(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate98()));
        bmRateD.setHisadrate99(BizNumber.valueOf(pZtRatedRn.getZrnhisadrate99()));
        bmRateD.setDyouvrate00(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate00()));
        bmRateD.setDyouvrate01(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate01()));
        bmRateD.setDyouvrate02(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate02()));
        bmRateD.setDyouvrate03(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate03()));
        bmRateD.setDyouvrate04(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate04()));
        bmRateD.setDyouvrate05(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate05()));
        bmRateD.setDyouvrate06(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate06()));
        bmRateD.setDyouvrate07(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate07()));
        bmRateD.setDyouvrate08(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate08()));
        bmRateD.setDyouvrate09(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate09()));
        bmRateD.setDyouvrate10(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate10()));
        bmRateD.setDyouvrate11(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate11()));
        bmRateD.setDyouvrate12(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate12()));
        bmRateD.setDyouvrate13(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate13()));
        bmRateD.setDyouvrate14(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate14()));
        bmRateD.setDyouvrate15(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate15()));
        bmRateD.setDyouvrate16(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate16()));
        bmRateD.setDyouvrate17(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate17()));
        bmRateD.setDyouvrate18(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate18()));
        bmRateD.setDyouvrate19(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate19()));
        bmRateD.setDyouvrate20(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate20()));
        bmRateD.setDyouvrate21(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate21()));
        bmRateD.setDyouvrate22(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate22()));
        bmRateD.setDyouvrate23(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate23()));
        bmRateD.setDyouvrate24(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate24()));
        bmRateD.setDyouvrate25(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate25()));
        bmRateD.setDyouvrate26(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate26()));
        bmRateD.setDyouvrate27(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate27()));
        bmRateD.setDyouvrate28(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate28()));
        bmRateD.setDyouvrate29(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate29()));
        bmRateD.setDyouvrate30(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate30()));
        bmRateD.setDyouvrate31(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate31()));
        bmRateD.setDyouvrate32(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate32()));
        bmRateD.setDyouvrate33(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate33()));
        bmRateD.setDyouvrate34(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate34()));
        bmRateD.setDyouvrate35(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate35()));
        bmRateD.setDyouvrate36(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate36()));
        bmRateD.setDyouvrate37(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate37()));
        bmRateD.setDyouvrate38(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate38()));
        bmRateD.setDyouvrate39(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate39()));
        bmRateD.setDyouvrate40(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate40()));
        bmRateD.setDyouvrate41(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate41()));
        bmRateD.setDyouvrate42(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate42()));
        bmRateD.setDyouvrate43(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate43()));
        bmRateD.setDyouvrate44(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate44()));
        bmRateD.setDyouvrate45(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate45()));
        bmRateD.setDyouvrate46(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate46()));
        bmRateD.setDyouvrate47(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate47()));
        bmRateD.setDyouvrate48(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate48()));
        bmRateD.setDyouvrate49(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate49()));
        bmRateD.setDyouvrate50(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate50()));
        bmRateD.setDyouvrate51(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate51()));
        bmRateD.setDyouvrate52(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate52()));
        bmRateD.setDyouvrate53(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate53()));
        bmRateD.setDyouvrate54(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate54()));
        bmRateD.setDyouvrate55(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate55()));
        bmRateD.setDyouvrate56(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate56()));
        bmRateD.setDyouvrate57(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate57()));
        bmRateD.setDyouvrate58(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate58()));
        bmRateD.setDyouvrate59(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate59()));
        bmRateD.setDyouvrate60(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate60()));
        bmRateD.setDyouvrate61(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate61()));
        bmRateD.setDyouvrate62(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate62()));
        bmRateD.setDyouvrate63(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate63()));
        bmRateD.setDyouvrate64(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate64()));
        bmRateD.setDyouvrate65(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate65()));
        bmRateD.setDyouvrate66(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate66()));
        bmRateD.setDyouvrate67(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate67()));
        bmRateD.setDyouvrate68(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate68()));
        bmRateD.setDyouvrate69(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate69()));
        bmRateD.setDyouvrate70(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate70()));
        bmRateD.setDyouvrate71(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate71()));
        bmRateD.setDyouvrate72(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate72()));
        bmRateD.setDyouvrate73(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate73()));
        bmRateD.setDyouvrate74(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate74()));
        bmRateD.setDyouvrate75(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate75()));
        bmRateD.setDyouvrate76(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate76()));
        bmRateD.setDyouvrate77(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate77()));
        bmRateD.setDyouvrate78(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate78()));
        bmRateD.setDyouvrate79(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate79()));
        bmRateD.setDyouvrate80(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate80()));
        bmRateD.setDyouvrate81(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate81()));
        bmRateD.setDyouvrate82(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate82()));
        bmRateD.setDyouvrate83(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate83()));
        bmRateD.setDyouvrate84(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate84()));
        bmRateD.setDyouvrate85(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate85()));
        bmRateD.setDyouvrate86(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate86()));
        bmRateD.setDyouvrate87(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate87()));
        bmRateD.setDyouvrate88(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate88()));
        bmRateD.setDyouvrate89(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate89()));
        bmRateD.setDyouvrate90(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate90()));
        bmRateD.setDyouvrate91(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate91()));
        bmRateD.setDyouvrate92(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate92()));
        bmRateD.setDyouvrate93(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate93()));
        bmRateD.setDyouvrate94(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate94()));
        bmRateD.setDyouvrate95(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate95()));
        bmRateD.setDyouvrate96(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate96()));
        bmRateD.setDyouvrate97(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate97()));
        bmRateD.setDyouvrate98(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate98()));
        bmRateD.setDyouvrate99(BizNumber.valueOf(pZtRatedRn.getZrndyouvrate99()));
        bmRateD.setKikensrate00(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate00()));
        bmRateD.setKikensrate01(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate01()));
        bmRateD.setKikensrate02(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate02()));
        bmRateD.setKikensrate03(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate03()));
        bmRateD.setKikensrate04(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate04()));
        bmRateD.setKikensrate05(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate05()));
        bmRateD.setKikensrate06(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate06()));
        bmRateD.setKikensrate07(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate07()));
        bmRateD.setKikensrate08(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate08()));
        bmRateD.setKikensrate09(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate09()));
        bmRateD.setKikensrate10(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate10()));
        bmRateD.setKikensrate11(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate11()));
        bmRateD.setKikensrate12(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate12()));
        bmRateD.setKikensrate13(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate13()));
        bmRateD.setKikensrate14(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate14()));
        bmRateD.setKikensrate15(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate15()));
        bmRateD.setKikensrate16(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate16()));
        bmRateD.setKikensrate17(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate17()));
        bmRateD.setKikensrate18(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate18()));
        bmRateD.setKikensrate19(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate19()));
        bmRateD.setKikensrate20(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate20()));
        bmRateD.setKikensrate21(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate21()));
        bmRateD.setKikensrate22(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate22()));
        bmRateD.setKikensrate23(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate23()));
        bmRateD.setKikensrate24(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate24()));
        bmRateD.setKikensrate25(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate25()));
        bmRateD.setKikensrate26(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate26()));
        bmRateD.setKikensrate27(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate27()));
        bmRateD.setKikensrate28(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate28()));
        bmRateD.setKikensrate29(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate29()));
        bmRateD.setKikensrate30(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate30()));
        bmRateD.setKikensrate31(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate31()));
        bmRateD.setKikensrate32(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate32()));
        bmRateD.setKikensrate33(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate33()));
        bmRateD.setKikensrate34(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate34()));
        bmRateD.setKikensrate35(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate35()));
        bmRateD.setKikensrate36(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate36()));
        bmRateD.setKikensrate37(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate37()));
        bmRateD.setKikensrate38(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate38()));
        bmRateD.setKikensrate39(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate39()));
        bmRateD.setKikensrate40(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate40()));
        bmRateD.setKikensrate41(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate41()));
        bmRateD.setKikensrate42(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate42()));
        bmRateD.setKikensrate43(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate43()));
        bmRateD.setKikensrate44(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate44()));
        bmRateD.setKikensrate45(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate45()));
        bmRateD.setKikensrate46(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate46()));
        bmRateD.setKikensrate47(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate47()));
        bmRateD.setKikensrate48(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate48()));
        bmRateD.setKikensrate49(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate49()));
        bmRateD.setKikensrate50(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate50()));
        bmRateD.setKikensrate51(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate51()));
        bmRateD.setKikensrate52(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate52()));
        bmRateD.setKikensrate53(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate53()));
        bmRateD.setKikensrate54(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate54()));
        bmRateD.setKikensrate55(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate55()));
        bmRateD.setKikensrate56(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate56()));
        bmRateD.setKikensrate57(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate57()));
        bmRateD.setKikensrate58(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate58()));
        bmRateD.setKikensrate59(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate59()));
        bmRateD.setKikensrate60(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate60()));
        bmRateD.setKikensrate61(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate61()));
        bmRateD.setKikensrate62(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate62()));
        bmRateD.setKikensrate63(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate63()));
        bmRateD.setKikensrate64(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate64()));
        bmRateD.setKikensrate65(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate65()));
        bmRateD.setKikensrate66(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate66()));
        bmRateD.setKikensrate67(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate67()));
        bmRateD.setKikensrate68(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate68()));
        bmRateD.setKikensrate69(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate69()));
        bmRateD.setKikensrate70(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate70()));
        bmRateD.setKikensrate71(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate71()));
        bmRateD.setKikensrate72(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate72()));
        bmRateD.setKikensrate73(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate73()));
        bmRateD.setKikensrate74(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate74()));
        bmRateD.setKikensrate75(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate75()));
        bmRateD.setKikensrate76(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate76()));
        bmRateD.setKikensrate77(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate77()));
        bmRateD.setKikensrate78(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate78()));
        bmRateD.setKikensrate79(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate79()));
        bmRateD.setKikensrate80(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate80()));
        bmRateD.setKikensrate81(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate81()));
        bmRateD.setKikensrate82(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate82()));
        bmRateD.setKikensrate83(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate83()));
        bmRateD.setKikensrate84(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate84()));
        bmRateD.setKikensrate85(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate85()));
        bmRateD.setKikensrate86(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate86()));
        bmRateD.setKikensrate87(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate87()));
        bmRateD.setKikensrate88(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate88()));
        bmRateD.setKikensrate89(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate89()));
        bmRateD.setKikensrate90(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate90()));
        bmRateD.setKikensrate91(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate91()));
        bmRateD.setKikensrate92(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate92()));
        bmRateD.setKikensrate93(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate93()));
        bmRateD.setKikensrate94(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate94()));
        bmRateD.setKikensrate95(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate95()));
        bmRateD.setKikensrate96(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate96()));
        bmRateD.setKikensrate97(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate97()));
        bmRateD.setKikensrate98(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate98()));
        bmRateD.setKikensrate99(BizNumber.valueOf(pZtRatedRn.getZrnkikensrate99()));

        return bmRateD;
    }

}
