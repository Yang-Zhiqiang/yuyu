package yuyu.batch.suuri.srmaster.srnenkinvratetorikomi;

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
import yuyu.def.db.entity.BM_RateNenkinPkisoV;
import yuyu.def.db.entity.ZT_NennkinRatepkisovRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（年金開始後Ｐ基礎Ｖレートテーブル（連））を読み込み、年金開始後Ｐ基礎Ｖレートマスタに反映するクラス
 */
public class SrNenkinVrateTorikomiBatch implements Batch {

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

        try (ExDBResults<ZT_NennkinRatepkisovRn> exDBResults = zdbDomManager.getAllNennkinRatepkisovRn()) {

            Iterator<ZT_NennkinRatepkisovRn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001,
                    "年金開始後Ｐ基礎Ｖレートテーブル（連）"));

            }

            try (EntityInserter<BM_RateNenkinPkisoV> entityInserter = new EntityInserter<>()) {
                BM_RateNenkinPkisoV bmRateNenkinPkisoV = null;
                BM_RateNenkinPkisoV bmRateNenkinPkisoVSearch = null;
                while (iterator.hasNext()) {

                    bmRateNenkinPkisoV = createRateNenkinPkisoVData(iterator.next());

                    bmRateNenkinPkisoVSearch = bizDomManager.getRateNenkinPkisoV(
                        bmRateNenkinPkisoV.getPalnenkinsisutemusyurui(),
                        bmRateNenkinPkisoV.getPalnenkinsyuruikigou(),
                        bmRateNenkinPkisoV.getPalnenkinkigousedaicode(),
                        bmRateNenkinPkisoV.getPalnenkinsiharaikikan(),
                        bmRateNenkinPkisoV.getPalnnknksgyoteiriritucode(),
                        bmRateNenkinPkisoV.getPalnnknksgjmtesuuryoucode());

                    if (bmRateNenkinPkisoVSearch != null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA1007,
                            bmRateNenkinPkisoV.getPalnenkinsisutemusyurui().
                            concat(bmRateNenkinPkisoV.getPalnenkinsyuruikigou()).
                            concat(bmRateNenkinPkisoV.getPalnenkinkigousedaicode()).
                            concat(bmRateNenkinPkisoV.getPalnenkinsiharaikikan()).
                            concat(bmRateNenkinPkisoV.getPalnnknksgyoteiriritucode()).
                            concat(bmRateNenkinPkisoV.getPalnnknksgjmtesuuryoucode()),
                            "年金開始後Ｐ基礎Ｖレートマスタ"));

                    }

                    BizPropertyInitializer.initialize(bmRateNenkinPkisoV);

                    entityInserter.add(bmRateNenkinPkisoV);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));

    }

    private BM_RateNenkinPkisoV createRateNenkinPkisoVData(ZT_NennkinRatepkisovRn pZtNennkinRatepkisovRn) {

        BM_RateNenkinPkisoV bmRateNenkinPkisoV = new BM_RateNenkinPkisoV();

        bmRateNenkinPkisoV.setPalnenkinsisutemusyurui(pZtNennkinRatepkisovRn.getZrnnenkinkbn());
        bmRateNenkinPkisoV.setPalnenkinsyuruikigou(pZtNennkinRatepkisovRn.getZrnnenkinsyu());
        bmRateNenkinPkisoV.setPalnenkinkigousedaicode(pZtNennkinRatepkisovRn.getZrnnenkinkigousedaikbn());
        bmRateNenkinPkisoV.setPalnenkinsiharaikikan(pZtNennkinRatepkisovRn.getZrnnknshry());
        bmRateNenkinPkisoV.setPalnnknksgyoteiriritucode(pZtNennkinRatepkisovRn.getZrnnkkaisigoyoteiriritukbn());
        bmRateNenkinPkisoV.setPalnnknksgjmtesuuryoucode(pZtNennkinRatepkisovRn.getZrnnenkinjimutesuuryoukbn());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate00(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate00());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate01(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate01());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate02(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate02());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate03(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate03());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate04(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate04());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate05(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate05());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate06(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate06());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate07(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate07());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate08(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate08());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate09(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate09());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate10(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate10());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate11(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate11());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate12(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate12());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate13(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate13());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate14(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate14());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate15(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate15());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate16(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate16());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate17(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate17());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate18(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate18());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate19(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate19());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate20(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate20());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate21(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate21());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate22(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate22());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate23(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate23());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate24(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate24());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate25(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate25());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate26(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate26());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate27(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate27());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate28(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate28());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate29(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate29());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate30(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate30());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate31(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate31());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate32(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate32());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate33(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate33());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate34(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate34());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate35(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate35());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate36(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate36());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate37(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate37());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate38(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate38());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate39(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate39());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate40(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate40());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate41(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate41());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate42(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate42());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate43(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate43());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate44(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate44());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate45(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate45());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate46(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate46());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate47(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate47());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate48(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate48());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate49(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate49());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate50(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate50());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate51(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate51());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate52(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate52());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate53(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate53());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate54(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate54());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate55(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate55());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate56(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate56());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate57(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate57());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate58(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate58());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate59(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate59());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate60(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate60());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate61(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate61());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate62(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate62());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate63(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate63());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate64(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate64());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate65(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate65());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate66(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate66());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate67(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate67());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate68(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate68());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate69(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate69());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate70(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate70());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate71(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate71());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate72(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate72());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate73(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate73());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate74(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate74());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate75(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate75());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate76(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate76());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate77(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate77());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate78(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate78());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate79(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate79());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate80(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate80());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate81(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate81());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate82(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate82());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate83(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate83());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate84(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate84());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate85(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate85());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate86(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate86());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate87(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate87());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate88(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate88());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate89(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate89());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate90(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate90());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate91(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate91());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate92(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate92());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate93(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate93());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate94(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate94());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate95(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate95());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate96(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate96());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate97(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate97());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate98(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate98());
        bmRateNenkinPkisoV.setNenkinkaisigopkisovrate99(pZtNennkinRatepkisovRn.getZrnnkkaisigopkisovrate99());

        return bmRateNenkinPkisoV;
    }

}
