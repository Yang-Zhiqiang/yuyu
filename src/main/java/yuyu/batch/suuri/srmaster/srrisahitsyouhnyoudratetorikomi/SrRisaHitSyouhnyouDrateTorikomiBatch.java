package yuyu.batch.suuri.srmaster.srrisahitsyouhnyoudratetorikomi;

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
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（利差配当商品用Ｄレートテーブル（連））を読み込み、利差配当商品用Ｄレートマスタに反映するクラス
 */
public class SrRisaHitSyouhnyouDrateTorikomiBatch implements Batch {

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

        try (ExDBResults<ZT_RisaHitSyouhnyouRatedRn> exDBResults = zdbDomManager.getAllRisaHitSyouhnyouRatedRn()) {

            Iterator<ZT_RisaHitSyouhnyouRatedRn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001, "利差配当商品用Ｄレートテーブル（連）"));

            }

            try (EntityInserter<BM_RisaHitSyouhnyouRateD> entityInserter = new EntityInserter<>()) {

                BM_RisaHitSyouhnyouRateD bmRisaHitSyouhnyouRateD = null;
                BM_RisaHitSyouhnyouRateD bmRisaHitSyouhnyouRateDSearch = null;
                while (iterator.hasNext()) {

                    bmRisaHitSyouhnyouRateD = createRisaHitSyouhnyouRateDData(iterator.next());

                    bmRisaHitSyouhnyouRateDSearch = bizDomManager.getRisaHitSyouhnyouRateD(bmRisaHitSyouhnyouRateD.getPalhokensyuruikigou(),
                        bmRisaHitSyouhnyouRateD.getPalhokensyuruikigousdicode(),
                        bmRisaHitSyouhnyouRateD.getPalyoteiriritu(),
                        bmRisaHitSyouhnyouRateD.getPalpmencode(),
                        bmRisaHitSyouhnyouRateD.getPalharaikomikaisuu(),
                        bmRisaHitSyouhnyouRateD.getPalhhknsei(),
                        bmRisaHitSyouhnyouRateD.getPalkeiyakujihhknnen(),
                        bmRisaHitSyouhnyouRateD.getPalsaimankihyouji(),
                        bmRisaHitSyouhnyouRateD.getPalhokenkikan(),
                        bmRisaHitSyouhnyouRateD.getPalpharaikomikikan(),
                        bmRisaHitSyouhnyouRateD.getPaldnendo(),
                        bmRisaHitSyouhnyouRateD.getPaldratenaikakucode());

                    if (bmRisaHitSyouhnyouRateDSearch != null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA1007,
                            bmRisaHitSyouhnyouRateD.getPalhokensyuruikigou().
                            concat(bmRisaHitSyouhnyouRateD.getPalhokensyuruikigousdicode()).
                            concat(bmRisaHitSyouhnyouRateD.getPalyoteiriritu()).
                            concat(bmRisaHitSyouhnyouRateD.getPalpmencode()).
                            concat(bmRisaHitSyouhnyouRateD.getPalharaikomikaisuu()).
                            concat(bmRisaHitSyouhnyouRateD.getPalhhknsei()).
                            concat(bmRisaHitSyouhnyouRateD.getPalkeiyakujihhknnen()).
                            concat(bmRisaHitSyouhnyouRateD.getPalsaimankihyouji()).
                            concat(bmRisaHitSyouhnyouRateD.getPalhokenkikan()).
                            concat(bmRisaHitSyouhnyouRateD.getPalpharaikomikikan()).
                            concat(bmRisaHitSyouhnyouRateD.getPaldnendo()).
                            concat(bmRisaHitSyouhnyouRateD.getPaldratenaikakucode()),
                            "利差配当商品用Ｄレートマスタ"));

                    }

                    BizPropertyInitializer.initialize(bmRisaHitSyouhnyouRateD);

                    entityInserter.add(bmRisaHitSyouhnyouRateD);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));

    }

    private BM_RisaHitSyouhnyouRateD createRisaHitSyouhnyouRateDData(ZT_RisaHitSyouhnyouRatedRn pZtRisaHitSyouhnyouRatedRn) {

        BM_RisaHitSyouhnyouRateD bmRisaHitSyouhnyouRateD = new BM_RisaHitSyouhnyouRateD();

        bmRisaHitSyouhnyouRateD.setPalhokensyuruikigou(pZtRisaHitSyouhnyouRatedRn.getZrnhknsyukigou());
        bmRisaHitSyouhnyouRateD.setPalhokensyuruikigousdicode(pZtRisaHitSyouhnyouRatedRn.getZrnhknsyuruikigousedaikbn());
        bmRisaHitSyouhnyouRateD.setPalyoteiriritu(pZtRisaHitSyouhnyouRatedRn.getZrnyoteiriritu());
        bmRisaHitSyouhnyouRateD.setPalpmencode(pZtRisaHitSyouhnyouRatedRn.getZrnpmenkbn());
        bmRisaHitSyouhnyouRateD.setPalharaikomikaisuu(pZtRisaHitSyouhnyouRatedRn.getZrnhrkkaisuukbn());
        bmRisaHitSyouhnyouRateD.setPalhhknsei(pZtRisaHitSyouhnyouRatedRn.getZrnhhknsei());
        bmRisaHitSyouhnyouRateD.setPalkeiyakujihhknnen(pZtRisaHitSyouhnyouRatedRn.getZrnkeiyakujihhknnen());
        bmRisaHitSyouhnyouRateD.setPalsaimankihyouji(pZtRisaHitSyouhnyouRatedRn.getZrnsaimnkkykhyj());
        bmRisaHitSyouhnyouRateD.setPalhokenkikan(pZtRisaHitSyouhnyouRatedRn.getZrnhknkkn());
        bmRisaHitSyouhnyouRateD.setPalpharaikomikikan(pZtRisaHitSyouhnyouRatedRn.getZrnphrkkikn());
        bmRisaHitSyouhnyouRateD.setPaldnendo(pZtRisaHitSyouhnyouRatedRn.getZrndnendo());
        bmRisaHitSyouhnyouRateD.setPaldratenaikakucode(pZtRisaHitSyouhnyouRatedRn.getZrnnaiteikakuteikbn());
        bmRisaHitSyouhnyouRateD.setDrate00(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate00()));
        bmRisaHitSyouhnyouRateD.setDrate01(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate01()));
        bmRisaHitSyouhnyouRateD.setDrate02(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate02()));
        bmRisaHitSyouhnyouRateD.setDrate03(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate03()));
        bmRisaHitSyouhnyouRateD.setDrate04(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate04()));
        bmRisaHitSyouhnyouRateD.setDrate05(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate05()));
        bmRisaHitSyouhnyouRateD.setDrate06(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate06()));
        bmRisaHitSyouhnyouRateD.setDrate07(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate07()));
        bmRisaHitSyouhnyouRateD.setDrate08(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate08()));
        bmRisaHitSyouhnyouRateD.setDrate09(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate09()));
        bmRisaHitSyouhnyouRateD.setDrate10(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate10()));
        bmRisaHitSyouhnyouRateD.setDrate11(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate11()));
        bmRisaHitSyouhnyouRateD.setDrate12(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate12()));
        bmRisaHitSyouhnyouRateD.setDrate13(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate13()));
        bmRisaHitSyouhnyouRateD.setDrate14(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate14()));
        bmRisaHitSyouhnyouRateD.setDrate15(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate15()));
        bmRisaHitSyouhnyouRateD.setDrate16(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate16()));
        bmRisaHitSyouhnyouRateD.setDrate17(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate17()));
        bmRisaHitSyouhnyouRateD.setDrate18(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate18()));
        bmRisaHitSyouhnyouRateD.setDrate19(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate19()));
        bmRisaHitSyouhnyouRateD.setDrate20(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate20()));
        bmRisaHitSyouhnyouRateD.setDrate21(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate21()));
        bmRisaHitSyouhnyouRateD.setDrate22(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate22()));
        bmRisaHitSyouhnyouRateD.setDrate23(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate23()));
        bmRisaHitSyouhnyouRateD.setDrate24(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate24()));
        bmRisaHitSyouhnyouRateD.setDrate25(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate25()));
        bmRisaHitSyouhnyouRateD.setDrate26(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate26()));
        bmRisaHitSyouhnyouRateD.setDrate27(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate27()));
        bmRisaHitSyouhnyouRateD.setDrate28(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate28()));
        bmRisaHitSyouhnyouRateD.setDrate29(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate29()));
        bmRisaHitSyouhnyouRateD.setDrate30(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate30()));
        bmRisaHitSyouhnyouRateD.setDrate31(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate31()));
        bmRisaHitSyouhnyouRateD.setDrate32(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate32()));
        bmRisaHitSyouhnyouRateD.setDrate33(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate33()));
        bmRisaHitSyouhnyouRateD.setDrate34(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate34()));
        bmRisaHitSyouhnyouRateD.setDrate35(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate35()));
        bmRisaHitSyouhnyouRateD.setDrate36(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate36()));
        bmRisaHitSyouhnyouRateD.setDrate37(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate37()));
        bmRisaHitSyouhnyouRateD.setDrate38(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate38()));
        bmRisaHitSyouhnyouRateD.setDrate39(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate39()));
        bmRisaHitSyouhnyouRateD.setDrate40(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate40()));
        bmRisaHitSyouhnyouRateD.setDrate41(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate41()));
        bmRisaHitSyouhnyouRateD.setDrate42(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate42()));
        bmRisaHitSyouhnyouRateD.setDrate43(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate43()));
        bmRisaHitSyouhnyouRateD.setDrate44(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate44()));
        bmRisaHitSyouhnyouRateD.setDrate45(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate45()));
        bmRisaHitSyouhnyouRateD.setDrate46(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate46()));
        bmRisaHitSyouhnyouRateD.setDrate47(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate47()));
        bmRisaHitSyouhnyouRateD.setDrate48(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate48()));
        bmRisaHitSyouhnyouRateD.setDrate49(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate49()));
        bmRisaHitSyouhnyouRateD.setDrate50(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate50()));
        bmRisaHitSyouhnyouRateD.setDrate51(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate51()));
        bmRisaHitSyouhnyouRateD.setDrate52(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate52()));
        bmRisaHitSyouhnyouRateD.setDrate53(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate53()));
        bmRisaHitSyouhnyouRateD.setDrate54(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate54()));
        bmRisaHitSyouhnyouRateD.setDrate55(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate55()));
        bmRisaHitSyouhnyouRateD.setDrate56(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate56()));
        bmRisaHitSyouhnyouRateD.setDrate57(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate57()));
        bmRisaHitSyouhnyouRateD.setDrate58(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate58()));
        bmRisaHitSyouhnyouRateD.setDrate59(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate59()));
        bmRisaHitSyouhnyouRateD.setDrate60(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate60()));
        bmRisaHitSyouhnyouRateD.setDrate61(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate61()));
        bmRisaHitSyouhnyouRateD.setDrate62(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate62()));
        bmRisaHitSyouhnyouRateD.setDrate63(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate63()));
        bmRisaHitSyouhnyouRateD.setDrate64(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate64()));
        bmRisaHitSyouhnyouRateD.setDrate65(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate65()));
        bmRisaHitSyouhnyouRateD.setDrate66(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate66()));
        bmRisaHitSyouhnyouRateD.setDrate67(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate67()));
        bmRisaHitSyouhnyouRateD.setDrate68(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate68()));
        bmRisaHitSyouhnyouRateD.setDrate69(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate69()));
        bmRisaHitSyouhnyouRateD.setDrate70(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate70()));
        bmRisaHitSyouhnyouRateD.setDrate71(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate71()));
        bmRisaHitSyouhnyouRateD.setDrate72(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate72()));
        bmRisaHitSyouhnyouRateD.setDrate73(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate73()));
        bmRisaHitSyouhnyouRateD.setDrate74(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate74()));
        bmRisaHitSyouhnyouRateD.setDrate75(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate75()));
        bmRisaHitSyouhnyouRateD.setDrate76(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate76()));
        bmRisaHitSyouhnyouRateD.setDrate77(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate77()));
        bmRisaHitSyouhnyouRateD.setDrate78(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate78()));
        bmRisaHitSyouhnyouRateD.setDrate79(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate79()));
        bmRisaHitSyouhnyouRateD.setDrate80(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate80()));
        bmRisaHitSyouhnyouRateD.setDrate81(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate81()));
        bmRisaHitSyouhnyouRateD.setDrate82(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate82()));
        bmRisaHitSyouhnyouRateD.setDrate83(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate83()));
        bmRisaHitSyouhnyouRateD.setDrate84(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate84()));
        bmRisaHitSyouhnyouRateD.setDrate85(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate85()));
        bmRisaHitSyouhnyouRateD.setDrate86(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate86()));
        bmRisaHitSyouhnyouRateD.setDrate87(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate87()));
        bmRisaHitSyouhnyouRateD.setDrate88(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate88()));
        bmRisaHitSyouhnyouRateD.setDrate89(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate89()));
        bmRisaHitSyouhnyouRateD.setDrate90(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate90()));
        bmRisaHitSyouhnyouRateD.setDrate91(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate91()));
        bmRisaHitSyouhnyouRateD.setDrate92(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate92()));
        bmRisaHitSyouhnyouRateD.setDrate93(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate93()));
        bmRisaHitSyouhnyouRateD.setDrate94(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate94()));
        bmRisaHitSyouhnyouRateD.setDrate95(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate95()));
        bmRisaHitSyouhnyouRateD.setDrate96(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate96()));
        bmRisaHitSyouhnyouRateD.setDrate97(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate97()));
        bmRisaHitSyouhnyouRateD.setDrate98(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate98()));
        bmRisaHitSyouhnyouRateD.setDrate99(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndrate99()));
        bmRisaHitSyouhnyouRateD.setDyouvrate00(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate00()));
        bmRisaHitSyouhnyouRateD.setDyouvrate01(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate01()));
        bmRisaHitSyouhnyouRateD.setDyouvrate02(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate02()));
        bmRisaHitSyouhnyouRateD.setDyouvrate03(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate03()));
        bmRisaHitSyouhnyouRateD.setDyouvrate04(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate04()));
        bmRisaHitSyouhnyouRateD.setDyouvrate05(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate05()));
        bmRisaHitSyouhnyouRateD.setDyouvrate06(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate06()));
        bmRisaHitSyouhnyouRateD.setDyouvrate07(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate07()));
        bmRisaHitSyouhnyouRateD.setDyouvrate08(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate08()));
        bmRisaHitSyouhnyouRateD.setDyouvrate09(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate09()));
        bmRisaHitSyouhnyouRateD.setDyouvrate10(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate10()));
        bmRisaHitSyouhnyouRateD.setDyouvrate11(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate11()));
        bmRisaHitSyouhnyouRateD.setDyouvrate12(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate12()));
        bmRisaHitSyouhnyouRateD.setDyouvrate13(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate13()));
        bmRisaHitSyouhnyouRateD.setDyouvrate14(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate14()));
        bmRisaHitSyouhnyouRateD.setDyouvrate15(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate15()));
        bmRisaHitSyouhnyouRateD.setDyouvrate16(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate16()));
        bmRisaHitSyouhnyouRateD.setDyouvrate17(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate17()));
        bmRisaHitSyouhnyouRateD.setDyouvrate18(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate18()));
        bmRisaHitSyouhnyouRateD.setDyouvrate19(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate19()));
        bmRisaHitSyouhnyouRateD.setDyouvrate20(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate20()));
        bmRisaHitSyouhnyouRateD.setDyouvrate21(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate21()));
        bmRisaHitSyouhnyouRateD.setDyouvrate22(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate22()));
        bmRisaHitSyouhnyouRateD.setDyouvrate23(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate23()));
        bmRisaHitSyouhnyouRateD.setDyouvrate24(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate24()));
        bmRisaHitSyouhnyouRateD.setDyouvrate25(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate25()));
        bmRisaHitSyouhnyouRateD.setDyouvrate26(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate26()));
        bmRisaHitSyouhnyouRateD.setDyouvrate27(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate27()));
        bmRisaHitSyouhnyouRateD.setDyouvrate28(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate28()));
        bmRisaHitSyouhnyouRateD.setDyouvrate29(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate29()));
        bmRisaHitSyouhnyouRateD.setDyouvrate30(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate30()));
        bmRisaHitSyouhnyouRateD.setDyouvrate31(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate31()));
        bmRisaHitSyouhnyouRateD.setDyouvrate32(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate32()));
        bmRisaHitSyouhnyouRateD.setDyouvrate33(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate33()));
        bmRisaHitSyouhnyouRateD.setDyouvrate34(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate34()));
        bmRisaHitSyouhnyouRateD.setDyouvrate35(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate35()));
        bmRisaHitSyouhnyouRateD.setDyouvrate36(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate36()));
        bmRisaHitSyouhnyouRateD.setDyouvrate37(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate37()));
        bmRisaHitSyouhnyouRateD.setDyouvrate38(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate38()));
        bmRisaHitSyouhnyouRateD.setDyouvrate39(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate39()));
        bmRisaHitSyouhnyouRateD.setDyouvrate40(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate40()));
        bmRisaHitSyouhnyouRateD.setDyouvrate41(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate41()));
        bmRisaHitSyouhnyouRateD.setDyouvrate42(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate42()));
        bmRisaHitSyouhnyouRateD.setDyouvrate43(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate43()));
        bmRisaHitSyouhnyouRateD.setDyouvrate44(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate44()));
        bmRisaHitSyouhnyouRateD.setDyouvrate45(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate45()));
        bmRisaHitSyouhnyouRateD.setDyouvrate46(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate46()));
        bmRisaHitSyouhnyouRateD.setDyouvrate47(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate47()));
        bmRisaHitSyouhnyouRateD.setDyouvrate48(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate48()));
        bmRisaHitSyouhnyouRateD.setDyouvrate49(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate49()));
        bmRisaHitSyouhnyouRateD.setDyouvrate50(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate50()));
        bmRisaHitSyouhnyouRateD.setDyouvrate51(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate51()));
        bmRisaHitSyouhnyouRateD.setDyouvrate52(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate52()));
        bmRisaHitSyouhnyouRateD.setDyouvrate53(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate53()));
        bmRisaHitSyouhnyouRateD.setDyouvrate54(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate54()));
        bmRisaHitSyouhnyouRateD.setDyouvrate55(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate55()));
        bmRisaHitSyouhnyouRateD.setDyouvrate56(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate56()));
        bmRisaHitSyouhnyouRateD.setDyouvrate57(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate57()));
        bmRisaHitSyouhnyouRateD.setDyouvrate58(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate58()));
        bmRisaHitSyouhnyouRateD.setDyouvrate59(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate59()));
        bmRisaHitSyouhnyouRateD.setDyouvrate60(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate60()));
        bmRisaHitSyouhnyouRateD.setDyouvrate61(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate61()));
        bmRisaHitSyouhnyouRateD.setDyouvrate62(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate62()));
        bmRisaHitSyouhnyouRateD.setDyouvrate63(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate63()));
        bmRisaHitSyouhnyouRateD.setDyouvrate64(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate64()));
        bmRisaHitSyouhnyouRateD.setDyouvrate65(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate65()));
        bmRisaHitSyouhnyouRateD.setDyouvrate66(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate66()));
        bmRisaHitSyouhnyouRateD.setDyouvrate67(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate67()));
        bmRisaHitSyouhnyouRateD.setDyouvrate68(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate68()));
        bmRisaHitSyouhnyouRateD.setDyouvrate69(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate69()));
        bmRisaHitSyouhnyouRateD.setDyouvrate70(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate70()));
        bmRisaHitSyouhnyouRateD.setDyouvrate71(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate71()));
        bmRisaHitSyouhnyouRateD.setDyouvrate72(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate72()));
        bmRisaHitSyouhnyouRateD.setDyouvrate73(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate73()));
        bmRisaHitSyouhnyouRateD.setDyouvrate74(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate74()));
        bmRisaHitSyouhnyouRateD.setDyouvrate75(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate75()));
        bmRisaHitSyouhnyouRateD.setDyouvrate76(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate76()));
        bmRisaHitSyouhnyouRateD.setDyouvrate77(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate77()));
        bmRisaHitSyouhnyouRateD.setDyouvrate78(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate78()));
        bmRisaHitSyouhnyouRateD.setDyouvrate79(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate79()));
        bmRisaHitSyouhnyouRateD.setDyouvrate80(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate80()));
        bmRisaHitSyouhnyouRateD.setDyouvrate81(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate81()));
        bmRisaHitSyouhnyouRateD.setDyouvrate82(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate82()));
        bmRisaHitSyouhnyouRateD.setDyouvrate83(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate83()));
        bmRisaHitSyouhnyouRateD.setDyouvrate84(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate84()));
        bmRisaHitSyouhnyouRateD.setDyouvrate85(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate85()));
        bmRisaHitSyouhnyouRateD.setDyouvrate86(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate86()));
        bmRisaHitSyouhnyouRateD.setDyouvrate87(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate87()));
        bmRisaHitSyouhnyouRateD.setDyouvrate88(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate88()));
        bmRisaHitSyouhnyouRateD.setDyouvrate89(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate89()));
        bmRisaHitSyouhnyouRateD.setDyouvrate90(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate90()));
        bmRisaHitSyouhnyouRateD.setDyouvrate91(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate91()));
        bmRisaHitSyouhnyouRateD.setDyouvrate92(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate92()));
        bmRisaHitSyouhnyouRateD.setDyouvrate93(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate93()));
        bmRisaHitSyouhnyouRateD.setDyouvrate94(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate94()));
        bmRisaHitSyouhnyouRateD.setDyouvrate95(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate95()));
        bmRisaHitSyouhnyouRateD.setDyouvrate96(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate96()));
        bmRisaHitSyouhnyouRateD.setDyouvrate97(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate97()));
        bmRisaHitSyouhnyouRateD.setDyouvrate98(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate98()));
        bmRisaHitSyouhnyouRateD.setDyouvrate99(BizNumber.valueOf(pZtRisaHitSyouhnyouRatedRn.getZrndyouvrate99()));

        return bmRisaHitSyouhnyouRateD;
    }

}
