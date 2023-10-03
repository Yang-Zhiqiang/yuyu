package yuyu.batch.suuri.srmaster.srnenkindratetorikomi;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RateNenkinD;
import yuyu.def.db.entity.ZT_NennkinRatedRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（年金開始後Ｄレートテーブル（連））を読み込み、年金開始後Ｄレートマスタに反映するクラス
 */
public class SrNenkinDrateTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BatchParam batchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long syoriCount = 0L;

        try (ExDBResults<ZT_NennkinRatedRn> exDBResults = zdbDomManager.getAllNennkinRatedRn()) {

            Iterator<ZT_NennkinRatedRn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001,
                    "年金開始後Ｄレートテーブル（連）"));

            }

            try (EntityInserter<BM_RateNenkinD> entityInserter = new EntityInserter<>()) {
                BM_RateNenkinD bmRateNenkinD = null;
                BM_RateNenkinD bmRateNenkinDSearch = null;
                while (iterator.hasNext()) {

                    bmRateNenkinD = createRateNenkinDData(iterator.next());

                    bmRateNenkinDSearch = bizDomManager.getRateNenkinD(bmRateNenkinD.getPalnenkinsisutemusyurui(),
                        bmRateNenkinD.getPalnenkinsyuruikigou(),
                        bmRateNenkinD.getPalnenkinkigousedaicode(),
                        bmRateNenkinD.getPalnenkinsiharaikikan(),
                        bmRateNenkinD.getPalnnknksgyoteiriritucode(),
                        bmRateNenkinD.getPalnnknksgjmtesuuryoucode(),
                        bmRateNenkinD.getPaldnendo(),
                        bmRateNenkinD.getPaldratenaikakucode());

                    if (bmRateNenkinDSearch != null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA1007,
                            bmRateNenkinD.getPalnenkinsisutemusyurui().
                            concat(bmRateNenkinD.getPalnenkinsyuruikigou()).
                            concat(bmRateNenkinD.getPalnenkinkigousedaicode()).
                            concat(bmRateNenkinD.getPalnenkinsiharaikikan()).
                            concat(bmRateNenkinD.getPalnnknksgyoteiriritucode()).
                            concat(bmRateNenkinD.getPalnnknksgjmtesuuryoucode()).
                            concat(bmRateNenkinD.getPaldnendo()).
                            concat(bmRateNenkinD.getPaldratenaikakucode()),
                            "年金開始後Ｄレートマスタ"));

                    }

                    BizPropertyInitializer.initialize(bmRateNenkinD);

                    entityInserter.add(bmRateNenkinD);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));

    }

    private BM_RateNenkinD createRateNenkinDData(ZT_NennkinRatedRn pZtNennkinRatedRn) {

        BM_RateNenkinD bmRateNenkinD = new BM_RateNenkinD();

        bmRateNenkinD.setPalnenkinsisutemusyurui(pZtNennkinRatedRn.getZrnnenkinkbn());
        bmRateNenkinD.setPalnenkinsyuruikigou(pZtNennkinRatedRn.getZrnnenkinsyu());
        bmRateNenkinD.setPalnenkinkigousedaicode(pZtNennkinRatedRn.getZrnnenkinkigousedaikbn());
        bmRateNenkinD.setPalnenkinsiharaikikan(pZtNennkinRatedRn.getZrnnknshry());
        bmRateNenkinD.setPalnnknksgyoteiriritucode(pZtNennkinRatedRn.getZrnnkkaisigoyoteiriritukbn());
        bmRateNenkinD.setPalnnknksgjmtesuuryoucode(pZtNennkinRatedRn.getZrnnenkinjimutesuuryoukbn());
        bmRateNenkinD.setPaldnendo(pZtNennkinRatedRn.getZrndnendo());
        bmRateNenkinD.setPaldratenaikakucode(pZtNennkinRatedRn.getZrnnaiteikakuteikbn());
        bmRateNenkinD.setNenkinkaisigodrate00(pZtNennkinRatedRn.getZrnnenkinkaisigodrate00());
        bmRateNenkinD.setNenkinkaisigodrate01(pZtNennkinRatedRn.getZrnnenkinkaisigodrate01());
        bmRateNenkinD.setNenkinkaisigodrate02(pZtNennkinRatedRn.getZrnnenkinkaisigodrate02());
        bmRateNenkinD.setNenkinkaisigodrate03(pZtNennkinRatedRn.getZrnnenkinkaisigodrate03());
        bmRateNenkinD.setNenkinkaisigodrate04(pZtNennkinRatedRn.getZrnnenkinkaisigodrate04());
        bmRateNenkinD.setNenkinkaisigodrate05(pZtNennkinRatedRn.getZrnnenkinkaisigodrate05());
        bmRateNenkinD.setNenkinkaisigodrate06(pZtNennkinRatedRn.getZrnnenkinkaisigodrate06());
        bmRateNenkinD.setNenkinkaisigodrate07(pZtNennkinRatedRn.getZrnnenkinkaisigodrate07());
        bmRateNenkinD.setNenkinkaisigodrate08(pZtNennkinRatedRn.getZrnnenkinkaisigodrate08());
        bmRateNenkinD.setNenkinkaisigodrate09(pZtNennkinRatedRn.getZrnnenkinkaisigodrate09());
        bmRateNenkinD.setNenkinkaisigodrate10(pZtNennkinRatedRn.getZrnnenkinkaisigodrate10());
        bmRateNenkinD.setNenkinkaisigodrate11(pZtNennkinRatedRn.getZrnnenkinkaisigodrate11());
        bmRateNenkinD.setNenkinkaisigodrate12(pZtNennkinRatedRn.getZrnnenkinkaisigodrate12());
        bmRateNenkinD.setNenkinkaisigodrate13(pZtNennkinRatedRn.getZrnnenkinkaisigodrate13());
        bmRateNenkinD.setNenkinkaisigodrate14(pZtNennkinRatedRn.getZrnnenkinkaisigodrate14());
        bmRateNenkinD.setNenkinkaisigodrate15(pZtNennkinRatedRn.getZrnnenkinkaisigodrate15());
        bmRateNenkinD.setNenkinkaisigodrate16(pZtNennkinRatedRn.getZrnnenkinkaisigodrate16());
        bmRateNenkinD.setNenkinkaisigodrate17(pZtNennkinRatedRn.getZrnnenkinkaisigodrate17());
        bmRateNenkinD.setNenkinkaisigodrate18(pZtNennkinRatedRn.getZrnnenkinkaisigodrate18());
        bmRateNenkinD.setNenkinkaisigodrate19(pZtNennkinRatedRn.getZrnnenkinkaisigodrate19());
        bmRateNenkinD.setNenkinkaisigodrate20(pZtNennkinRatedRn.getZrnnenkinkaisigodrate20());
        bmRateNenkinD.setNenkinkaisigodrate21(pZtNennkinRatedRn.getZrnnenkinkaisigodrate21());
        bmRateNenkinD.setNenkinkaisigodrate22(pZtNennkinRatedRn.getZrnnenkinkaisigodrate22());
        bmRateNenkinD.setNenkinkaisigodrate23(pZtNennkinRatedRn.getZrnnenkinkaisigodrate23());
        bmRateNenkinD.setNenkinkaisigodrate24(pZtNennkinRatedRn.getZrnnenkinkaisigodrate24());
        bmRateNenkinD.setNenkinkaisigodrate25(pZtNennkinRatedRn.getZrnnenkinkaisigodrate25());
        bmRateNenkinD.setNenkinkaisigodrate26(pZtNennkinRatedRn.getZrnnenkinkaisigodrate26());
        bmRateNenkinD.setNenkinkaisigodrate27(pZtNennkinRatedRn.getZrnnenkinkaisigodrate27());
        bmRateNenkinD.setNenkinkaisigodrate28(pZtNennkinRatedRn.getZrnnenkinkaisigodrate28());
        bmRateNenkinD.setNenkinkaisigodrate29(pZtNennkinRatedRn.getZrnnenkinkaisigodrate29());
        bmRateNenkinD.setNenkinkaisigodrate30(pZtNennkinRatedRn.getZrnnenkinkaisigodrate30());
        bmRateNenkinD.setNenkinkaisigodrate31(pZtNennkinRatedRn.getZrnnenkinkaisigodrate31());
        bmRateNenkinD.setNenkinkaisigodrate32(pZtNennkinRatedRn.getZrnnenkinkaisigodrate32());
        bmRateNenkinD.setNenkinkaisigodrate33(pZtNennkinRatedRn.getZrnnenkinkaisigodrate33());
        bmRateNenkinD.setNenkinkaisigodrate34(pZtNennkinRatedRn.getZrnnenkinkaisigodrate34());
        bmRateNenkinD.setNenkinkaisigodrate35(pZtNennkinRatedRn.getZrnnenkinkaisigodrate35());
        bmRateNenkinD.setNenkinkaisigodrate36(pZtNennkinRatedRn.getZrnnenkinkaisigodrate36());
        bmRateNenkinD.setNenkinkaisigodrate37(pZtNennkinRatedRn.getZrnnenkinkaisigodrate37());
        bmRateNenkinD.setNenkinkaisigodrate38(pZtNennkinRatedRn.getZrnnenkinkaisigodrate38());
        bmRateNenkinD.setNenkinkaisigodrate39(pZtNennkinRatedRn.getZrnnenkinkaisigodrate39());
        bmRateNenkinD.setNenkinkaisigodrate40(pZtNennkinRatedRn.getZrnnenkinkaisigodrate40());
        bmRateNenkinD.setNenkinkaisigodrate41(pZtNennkinRatedRn.getZrnnenkinkaisigodrate41());
        bmRateNenkinD.setNenkinkaisigodrate42(pZtNennkinRatedRn.getZrnnenkinkaisigodrate42());
        bmRateNenkinD.setNenkinkaisigodrate43(pZtNennkinRatedRn.getZrnnenkinkaisigodrate43());
        bmRateNenkinD.setNenkinkaisigodrate44(pZtNennkinRatedRn.getZrnnenkinkaisigodrate44());
        bmRateNenkinD.setNenkinkaisigodrate45(pZtNennkinRatedRn.getZrnnenkinkaisigodrate45());
        bmRateNenkinD.setNenkinkaisigodrate46(pZtNennkinRatedRn.getZrnnenkinkaisigodrate46());
        bmRateNenkinD.setNenkinkaisigodrate47(pZtNennkinRatedRn.getZrnnenkinkaisigodrate47());
        bmRateNenkinD.setNenkinkaisigodrate48(pZtNennkinRatedRn.getZrnnenkinkaisigodrate48());
        bmRateNenkinD.setNenkinkaisigodrate49(pZtNennkinRatedRn.getZrnnenkinkaisigodrate49());
        bmRateNenkinD.setNenkinkaisigodrate50(pZtNennkinRatedRn.getZrnnenkinkaisigodrate50());
        bmRateNenkinD.setNenkinkaisigodrate51(pZtNennkinRatedRn.getZrnnenkinkaisigodrate51());
        bmRateNenkinD.setNenkinkaisigodrate52(pZtNennkinRatedRn.getZrnnenkinkaisigodrate52());
        bmRateNenkinD.setNenkinkaisigodrate53(pZtNennkinRatedRn.getZrnnenkinkaisigodrate53());
        bmRateNenkinD.setNenkinkaisigodrate54(pZtNennkinRatedRn.getZrnnenkinkaisigodrate54());
        bmRateNenkinD.setNenkinkaisigodrate55(pZtNennkinRatedRn.getZrnnenkinkaisigodrate55());
        bmRateNenkinD.setNenkinkaisigodrate56(pZtNennkinRatedRn.getZrnnenkinkaisigodrate56());
        bmRateNenkinD.setNenkinkaisigodrate57(pZtNennkinRatedRn.getZrnnenkinkaisigodrate57());
        bmRateNenkinD.setNenkinkaisigodrate58(pZtNennkinRatedRn.getZrnnenkinkaisigodrate58());
        bmRateNenkinD.setNenkinkaisigodrate59(pZtNennkinRatedRn.getZrnnenkinkaisigodrate59());
        bmRateNenkinD.setNenkinkaisigodrate60(pZtNennkinRatedRn.getZrnnenkinkaisigodrate60());
        bmRateNenkinD.setNenkinkaisigodrate61(pZtNennkinRatedRn.getZrnnenkinkaisigodrate61());
        bmRateNenkinD.setNenkinkaisigodrate62(pZtNennkinRatedRn.getZrnnenkinkaisigodrate62());
        bmRateNenkinD.setNenkinkaisigodrate63(pZtNennkinRatedRn.getZrnnenkinkaisigodrate63());
        bmRateNenkinD.setNenkinkaisigodrate64(pZtNennkinRatedRn.getZrnnenkinkaisigodrate64());
        bmRateNenkinD.setNenkinkaisigodrate65(pZtNennkinRatedRn.getZrnnenkinkaisigodrate65());
        bmRateNenkinD.setNenkinkaisigodrate66(pZtNennkinRatedRn.getZrnnenkinkaisigodrate66());
        bmRateNenkinD.setNenkinkaisigodrate67(pZtNennkinRatedRn.getZrnnenkinkaisigodrate67());
        bmRateNenkinD.setNenkinkaisigodrate68(pZtNennkinRatedRn.getZrnnenkinkaisigodrate68());
        bmRateNenkinD.setNenkinkaisigodrate69(pZtNennkinRatedRn.getZrnnenkinkaisigodrate69());
        bmRateNenkinD.setNenkinkaisigodrate70(pZtNennkinRatedRn.getZrnnenkinkaisigodrate70());
        bmRateNenkinD.setNenkinkaisigodrate71(pZtNennkinRatedRn.getZrnnenkinkaisigodrate71());
        bmRateNenkinD.setNenkinkaisigodrate72(pZtNennkinRatedRn.getZrnnenkinkaisigodrate72());
        bmRateNenkinD.setNenkinkaisigodrate73(pZtNennkinRatedRn.getZrnnenkinkaisigodrate73());
        bmRateNenkinD.setNenkinkaisigodrate74(pZtNennkinRatedRn.getZrnnenkinkaisigodrate74());
        bmRateNenkinD.setNenkinkaisigodrate75(pZtNennkinRatedRn.getZrnnenkinkaisigodrate75());
        bmRateNenkinD.setNenkinkaisigodrate76(pZtNennkinRatedRn.getZrnnenkinkaisigodrate76());
        bmRateNenkinD.setNenkinkaisigodrate77(pZtNennkinRatedRn.getZrnnenkinkaisigodrate77());
        bmRateNenkinD.setNenkinkaisigodrate78(pZtNennkinRatedRn.getZrnnenkinkaisigodrate78());
        bmRateNenkinD.setNenkinkaisigodrate79(pZtNennkinRatedRn.getZrnnenkinkaisigodrate79());
        bmRateNenkinD.setNenkinkaisigodrate80(pZtNennkinRatedRn.getZrnnenkinkaisigodrate80());
        bmRateNenkinD.setNenkinkaisigodrate81(pZtNennkinRatedRn.getZrnnenkinkaisigodrate81());
        bmRateNenkinD.setNenkinkaisigodrate82(pZtNennkinRatedRn.getZrnnenkinkaisigodrate82());
        bmRateNenkinD.setNenkinkaisigodrate83(pZtNennkinRatedRn.getZrnnenkinkaisigodrate83());
        bmRateNenkinD.setNenkinkaisigodrate84(pZtNennkinRatedRn.getZrnnenkinkaisigodrate84());
        bmRateNenkinD.setNenkinkaisigodrate85(pZtNennkinRatedRn.getZrnnenkinkaisigodrate85());
        bmRateNenkinD.setNenkinkaisigodrate86(pZtNennkinRatedRn.getZrnnenkinkaisigodrate86());
        bmRateNenkinD.setNenkinkaisigodrate87(pZtNennkinRatedRn.getZrnnenkinkaisigodrate87());
        bmRateNenkinD.setNenkinkaisigodrate88(pZtNennkinRatedRn.getZrnnenkinkaisigodrate88());
        bmRateNenkinD.setNenkinkaisigodrate89(pZtNennkinRatedRn.getZrnnenkinkaisigodrate89());
        bmRateNenkinD.setNenkinkaisigodrate90(pZtNennkinRatedRn.getZrnnenkinkaisigodrate90());
        bmRateNenkinD.setNenkinkaisigodrate91(pZtNennkinRatedRn.getZrnnenkinkaisigodrate91());
        bmRateNenkinD.setNenkinkaisigodrate92(pZtNennkinRatedRn.getZrnnenkinkaisigodrate92());
        bmRateNenkinD.setNenkinkaisigodrate93(pZtNennkinRatedRn.getZrnnenkinkaisigodrate93());
        bmRateNenkinD.setNenkinkaisigodrate94(pZtNennkinRatedRn.getZrnnenkinkaisigodrate94());
        bmRateNenkinD.setNenkinkaisigodrate95(pZtNennkinRatedRn.getZrnnenkinkaisigodrate95());
        bmRateNenkinD.setNenkinkaisigodrate96(pZtNennkinRatedRn.getZrnnenkinkaisigodrate96());
        bmRateNenkinD.setNenkinkaisigodrate97(pZtNennkinRatedRn.getZrnnenkinkaisigodrate97());
        bmRateNenkinD.setNenkinkaisigodrate98(pZtNennkinRatedRn.getZrnnenkinkaisigodrate98());
        bmRateNenkinD.setNenkinkaisigodrate99(pZtNennkinRatedRn.getZrnnenkinkaisigodrate99());

        return bmRateNenkinD;
    }

}
