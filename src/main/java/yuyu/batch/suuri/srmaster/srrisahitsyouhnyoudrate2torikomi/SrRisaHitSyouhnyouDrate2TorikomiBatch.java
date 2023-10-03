package yuyu.batch.suuri.srmaster.srrisahitsyouhnyoudrate2torikomi;

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
import yuyu.def.biz.detacher.BM_RisaHitSyouhnyouRateD2Detacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 マスタ取込 マスタ取込（利差配当商品用Ｄレートマスタ２）クラス
 */
public class SrRisaHitSyouhnyouDrate2TorikomiBatch implements Batch {

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

        try (ExDBResults<ZT_RisaHitSyouhnyouRated2Rn> exDBResults = zdbDomManager.getAllRisaHitSyouhnyouRated2Rn()) {

            Iterator<ZT_RisaHitSyouhnyouRated2Rn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001, "利差配当商品用Ｄレートテーブル２（連）"));

            }

            try (EntityInserter<BM_RisaHitSyouhnyouRateD2> entityInserter = new EntityInserter<>()) {

                BM_RisaHitSyouhnyouRateD2 bmRisaHitSyouhnyouRateD2 = null;
                BM_RisaHitSyouhnyouRateD2 bmRisaHitSyouhnyouRateD2Search = null;
                while (iterator.hasNext()) {

                    bmRisaHitSyouhnyouRateD2 = createRisaHitSyouhnyouRateD2Data(iterator.next());

                    bmRisaHitSyouhnyouRateD2Search = bizDomManager.getRisaHitSyouhnyouRateD2(bmRisaHitSyouhnyouRateD2.getPalhokensyuruikigou(),
                        bmRisaHitSyouhnyouRateD2.getPalhokensyuruikigousdicode(),
                        bmRisaHitSyouhnyouRateD2.getPalyoteiriritu(),
                        bmRisaHitSyouhnyouRateD2.getPalpmencode(),
                        bmRisaHitSyouhnyouRateD2.getPalharaikomikaisuu(),
                        bmRisaHitSyouhnyouRateD2.getPalhhknsei(),
                        bmRisaHitSyouhnyouRateD2.getPalkeiyakujihhknnen(),
                        bmRisaHitSyouhnyouRateD2.getPalsaimankihyouji(),
                        bmRisaHitSyouhnyouRateD2.getPalhokenkikan(),
                        bmRisaHitSyouhnyouRateD2.getPalpharaikomikikan(),
                        bmRisaHitSyouhnyouRateD2.getPalannaihuyouriyuukbn(),
                        bmRisaHitSyouhnyouRateD2.getRatetuukasyukbn(),
                        bmRisaHitSyouhnyouRateD2.getRatedai1hknkkn(),
                        bmRisaHitSyouhnyouRateD2.getPaldnendo(),
                        bmRisaHitSyouhnyouRateD2.getPaldratenaikakucode());

                    bmRisaHitSyouhnyouRateD2Search = BM_RisaHitSyouhnyouRateD2Detacher.detachRisaHitSyouhnyouRateD2touched(bmRisaHitSyouhnyouRateD2Search);

                    if (bmRisaHitSyouhnyouRateD2Search != null) {

                        jyuuhukuCount++;

                        continue;

                    }

                    BizPropertyInitializer.initialize(bmRisaHitSyouhnyouRateD2);

                    entityInserter.add(bmRisaHitSyouhnyouRateD2);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF1011, String.valueOf(jyuuhukuCount)));

    }

    private BM_RisaHitSyouhnyouRateD2 createRisaHitSyouhnyouRateD2Data(ZT_RisaHitSyouhnyouRated2Rn pZtRisaHitSyouhnyouRated2Rn) {

        BM_RisaHitSyouhnyouRateD2 bmRisaHitSyouhnyouRateD2 = new BM_RisaHitSyouhnyouRateD2();

        bmRisaHitSyouhnyouRateD2.setPalhokensyuruikigou(pZtRisaHitSyouhnyouRated2Rn.getZrnhknsyukigou());
        bmRisaHitSyouhnyouRateD2.setPalhokensyuruikigousdicode(pZtRisaHitSyouhnyouRated2Rn.getZrnhknsyuruikigousedaikbn());
        bmRisaHitSyouhnyouRateD2.setPalyoteiriritu(pZtRisaHitSyouhnyouRated2Rn.getZrnyoteiriritu());
        bmRisaHitSyouhnyouRateD2.setPalpmencode(pZtRisaHitSyouhnyouRated2Rn.getZrnpmenkbn());
        bmRisaHitSyouhnyouRateD2.setPalharaikomikaisuu(pZtRisaHitSyouhnyouRated2Rn.getZrnhrkkaisuukbn());
        bmRisaHitSyouhnyouRateD2.setPalhhknsei(pZtRisaHitSyouhnyouRated2Rn.getZrnhhknsei());
        bmRisaHitSyouhnyouRateD2.setPalkeiyakujihhknnen(pZtRisaHitSyouhnyouRated2Rn.getZrnkeiyakujihhknnen());
        bmRisaHitSyouhnyouRateD2.setPalsaimankihyouji(pZtRisaHitSyouhnyouRated2Rn.getZrnsaimnkkykhyj());
        bmRisaHitSyouhnyouRateD2.setPalhokenkikan(pZtRisaHitSyouhnyouRated2Rn.getZrnhknkkn());
        bmRisaHitSyouhnyouRateD2.setPalpharaikomikikan(pZtRisaHitSyouhnyouRated2Rn.getZrnphrkkikn());
        bmRisaHitSyouhnyouRateD2.setPalannaihuyouriyuukbn(pZtRisaHitSyouhnyouRated2Rn.getZrnannaifuyouriyuukbn());
        bmRisaHitSyouhnyouRateD2.setRatetuukasyukbn(pZtRisaHitSyouhnyouRated2Rn.getZrntuukasyukbn());
        bmRisaHitSyouhnyouRateD2.setRatedai1hknkkn(pZtRisaHitSyouhnyouRated2Rn.getZrndai1hknkkn());
        bmRisaHitSyouhnyouRateD2.setPaldnendo(pZtRisaHitSyouhnyouRated2Rn.getZrndnendo());
        bmRisaHitSyouhnyouRateD2.setPaldratenaikakucode(pZtRisaHitSyouhnyouRated2Rn.getZrnnaiteikakuteikbn());
        bmRisaHitSyouhnyouRateD2.setDrate00(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate00()));
        bmRisaHitSyouhnyouRateD2.setDrate01(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate01()));
        bmRisaHitSyouhnyouRateD2.setDrate02(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate02()));
        bmRisaHitSyouhnyouRateD2.setDrate03(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate03()));
        bmRisaHitSyouhnyouRateD2.setDrate04(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate04()));
        bmRisaHitSyouhnyouRateD2.setDrate05(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate05()));
        bmRisaHitSyouhnyouRateD2.setDrate06(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate06()));
        bmRisaHitSyouhnyouRateD2.setDrate07(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate07()));
        bmRisaHitSyouhnyouRateD2.setDrate08(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate08()));
        bmRisaHitSyouhnyouRateD2.setDrate09(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate09()));
        bmRisaHitSyouhnyouRateD2.setDrate10(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate10()));
        bmRisaHitSyouhnyouRateD2.setDrate11(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate11()));
        bmRisaHitSyouhnyouRateD2.setDrate12(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate12()));
        bmRisaHitSyouhnyouRateD2.setDrate13(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate13()));
        bmRisaHitSyouhnyouRateD2.setDrate14(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate14()));
        bmRisaHitSyouhnyouRateD2.setDrate15(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate15()));
        bmRisaHitSyouhnyouRateD2.setDrate16(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate16()));
        bmRisaHitSyouhnyouRateD2.setDrate17(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate17()));
        bmRisaHitSyouhnyouRateD2.setDrate18(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate18()));
        bmRisaHitSyouhnyouRateD2.setDrate19(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate19()));
        bmRisaHitSyouhnyouRateD2.setDrate20(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate20()));
        bmRisaHitSyouhnyouRateD2.setDrate21(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate21()));
        bmRisaHitSyouhnyouRateD2.setDrate22(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate22()));
        bmRisaHitSyouhnyouRateD2.setDrate23(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate23()));
        bmRisaHitSyouhnyouRateD2.setDrate24(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate24()));
        bmRisaHitSyouhnyouRateD2.setDrate25(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate25()));
        bmRisaHitSyouhnyouRateD2.setDrate26(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate26()));
        bmRisaHitSyouhnyouRateD2.setDrate27(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate27()));
        bmRisaHitSyouhnyouRateD2.setDrate28(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate28()));
        bmRisaHitSyouhnyouRateD2.setDrate29(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate29()));
        bmRisaHitSyouhnyouRateD2.setDrate30(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate30()));
        bmRisaHitSyouhnyouRateD2.setDrate31(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate31()));
        bmRisaHitSyouhnyouRateD2.setDrate32(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate32()));
        bmRisaHitSyouhnyouRateD2.setDrate33(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate33()));
        bmRisaHitSyouhnyouRateD2.setDrate34(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate34()));
        bmRisaHitSyouhnyouRateD2.setDrate35(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate35()));
        bmRisaHitSyouhnyouRateD2.setDrate36(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate36()));
        bmRisaHitSyouhnyouRateD2.setDrate37(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate37()));
        bmRisaHitSyouhnyouRateD2.setDrate38(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate38()));
        bmRisaHitSyouhnyouRateD2.setDrate39(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate39()));
        bmRisaHitSyouhnyouRateD2.setDrate40(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate40()));
        bmRisaHitSyouhnyouRateD2.setDrate41(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate41()));
        bmRisaHitSyouhnyouRateD2.setDrate42(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate42()));
        bmRisaHitSyouhnyouRateD2.setDrate43(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate43()));
        bmRisaHitSyouhnyouRateD2.setDrate44(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate44()));
        bmRisaHitSyouhnyouRateD2.setDrate45(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate45()));
        bmRisaHitSyouhnyouRateD2.setDrate46(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate46()));
        bmRisaHitSyouhnyouRateD2.setDrate47(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate47()));
        bmRisaHitSyouhnyouRateD2.setDrate48(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate48()));
        bmRisaHitSyouhnyouRateD2.setDrate49(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate49()));
        bmRisaHitSyouhnyouRateD2.setDrate50(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate50()));
        bmRisaHitSyouhnyouRateD2.setDrate51(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate51()));
        bmRisaHitSyouhnyouRateD2.setDrate52(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate52()));
        bmRisaHitSyouhnyouRateD2.setDrate53(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate53()));
        bmRisaHitSyouhnyouRateD2.setDrate54(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate54()));
        bmRisaHitSyouhnyouRateD2.setDrate55(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate55()));
        bmRisaHitSyouhnyouRateD2.setDrate56(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate56()));
        bmRisaHitSyouhnyouRateD2.setDrate57(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate57()));
        bmRisaHitSyouhnyouRateD2.setDrate58(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate58()));
        bmRisaHitSyouhnyouRateD2.setDrate59(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate59()));
        bmRisaHitSyouhnyouRateD2.setDrate60(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate60()));
        bmRisaHitSyouhnyouRateD2.setDrate61(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate61()));
        bmRisaHitSyouhnyouRateD2.setDrate62(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate62()));
        bmRisaHitSyouhnyouRateD2.setDrate63(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate63()));
        bmRisaHitSyouhnyouRateD2.setDrate64(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate64()));
        bmRisaHitSyouhnyouRateD2.setDrate65(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate65()));
        bmRisaHitSyouhnyouRateD2.setDrate66(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate66()));
        bmRisaHitSyouhnyouRateD2.setDrate67(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate67()));
        bmRisaHitSyouhnyouRateD2.setDrate68(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate68()));
        bmRisaHitSyouhnyouRateD2.setDrate69(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate69()));
        bmRisaHitSyouhnyouRateD2.setDrate70(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate70()));
        bmRisaHitSyouhnyouRateD2.setDrate71(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate71()));
        bmRisaHitSyouhnyouRateD2.setDrate72(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate72()));
        bmRisaHitSyouhnyouRateD2.setDrate73(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate73()));
        bmRisaHitSyouhnyouRateD2.setDrate74(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate74()));
        bmRisaHitSyouhnyouRateD2.setDrate75(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate75()));
        bmRisaHitSyouhnyouRateD2.setDrate76(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate76()));
        bmRisaHitSyouhnyouRateD2.setDrate77(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate77()));
        bmRisaHitSyouhnyouRateD2.setDrate78(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate78()));
        bmRisaHitSyouhnyouRateD2.setDrate79(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate79()));
        bmRisaHitSyouhnyouRateD2.setDrate80(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate80()));
        bmRisaHitSyouhnyouRateD2.setDrate81(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate81()));
        bmRisaHitSyouhnyouRateD2.setDrate82(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate82()));
        bmRisaHitSyouhnyouRateD2.setDrate83(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate83()));
        bmRisaHitSyouhnyouRateD2.setDrate84(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate84()));
        bmRisaHitSyouhnyouRateD2.setDrate85(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate85()));
        bmRisaHitSyouhnyouRateD2.setDrate86(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate86()));
        bmRisaHitSyouhnyouRateD2.setDrate87(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate87()));
        bmRisaHitSyouhnyouRateD2.setDrate88(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate88()));
        bmRisaHitSyouhnyouRateD2.setDrate89(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate89()));
        bmRisaHitSyouhnyouRateD2.setDrate90(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate90()));
        bmRisaHitSyouhnyouRateD2.setDrate91(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate91()));
        bmRisaHitSyouhnyouRateD2.setDrate92(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate92()));
        bmRisaHitSyouhnyouRateD2.setDrate93(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate93()));
        bmRisaHitSyouhnyouRateD2.setDrate94(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate94()));
        bmRisaHitSyouhnyouRateD2.setDrate95(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate95()));
        bmRisaHitSyouhnyouRateD2.setDrate96(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate96()));
        bmRisaHitSyouhnyouRateD2.setDrate97(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate97()));
        bmRisaHitSyouhnyouRateD2.setDrate98(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate98()));
        bmRisaHitSyouhnyouRateD2.setDrate99(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndrate99()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate00(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate00()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate01(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate01()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate02(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate02()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate03(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate03()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate04(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate04()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate05(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate05()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate06(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate06()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate07(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate07()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate08(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate08()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate09(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate09()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate10(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate10()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate11(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate11()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate12(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate12()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate13(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate13()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate14(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate14()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate15(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate15()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate16(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate16()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate17(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate17()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate18(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate18()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate19(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate19()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate20(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate20()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate21(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate21()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate22(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate22()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate23(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate23()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate24(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate24()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate25(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate25()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate26(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate26()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate27(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate27()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate28(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate28()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate29(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate29()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate30(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate30()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate31(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate31()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate32(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate32()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate33(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate33()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate34(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate34()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate35(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate35()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate36(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate36()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate37(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate37()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate38(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate38()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate39(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate39()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate40(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate40()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate41(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate41()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate42(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate42()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate43(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate43()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate44(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate44()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate45(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate45()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate46(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate46()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate47(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate47()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate48(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate48()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate49(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate49()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate50(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate50()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate51(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate51()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate52(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate52()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate53(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate53()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate54(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate54()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate55(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate55()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate56(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate56()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate57(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate57()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate58(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate58()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate59(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate59()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate60(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate60()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate61(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate61()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate62(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate62()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate63(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate63()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate64(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate64()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate65(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate65()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate66(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate66()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate67(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate67()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate68(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate68()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate69(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate69()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate70(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate70()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate71(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate71()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate72(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate72()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate73(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate73()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate74(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate74()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate75(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate75()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate76(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate76()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate77(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate77()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate78(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate78()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate79(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate79()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate80(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate80()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate81(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate81()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate82(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate82()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate83(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate83()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate84(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate84()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate85(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate85()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate86(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate86()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate87(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate87()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate88(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate88()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate89(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate89()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate90(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate90()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate91(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate91()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate92(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate92()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate93(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate93()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate94(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate94()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate95(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate95()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate96(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate96()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate97(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate97()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate98(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate98()));
        bmRisaHitSyouhnyouRateD2.setDyouvrate99(BizNumber.valueOf(pZtRisaHitSyouhnyouRated2Rn.getZrndyouvrate99()));

        return bmRisaHitSyouhnyouRateD2;
    }

}
