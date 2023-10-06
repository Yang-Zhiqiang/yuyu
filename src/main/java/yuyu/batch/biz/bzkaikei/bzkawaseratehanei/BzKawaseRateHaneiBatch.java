package yuyu.batch.biz.bzkaikei.bzkawaseratehanei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.entity.BT_KawaseRateData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 為替レートマスタ反映
 */
public class BzKawaseRateHaneiBatch implements Batch {

    private String kinouId;

    private String userId;

    private String sysTime;

    private BizDate kwsratekjYmd;

    private C_KwsrendouKbn kwsrendouKbn;

    private int count;

    @Inject
    private BzKawaseRateHaneiBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        BT_KawaseRateData kawaseRateData =
            bizDomManager.getKawaseRateData(bzBatchParam.getSyoriYmd(), bzBatchParam.getKwsrendouKbn());

        if (kawaseRateData == null) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0048));
        }

        kwsratekjYmd = kawaseRateData.getKwsratekjymd();
        kwsrendouKbn = kawaseRateData.getKwsrendoukbn();
        kinouId = kinou.getKinouId();
        userId = baseUserInfo.getUserId();
        sysTime = BizDate.getSysDateTimeMilli();
        count = 0;

        try (EntityInserter<BM_KawaseRate> kawaseRateLst = new EntityInserter<>()) {

            if (C_KwsrendouKbn.KOUJIKAWASERATE1.eq(kawaseRateData.getKwsrendoukbn())) {
                if (kawaseRateData.getUsdjpytts() <= 0 || kawaseRateData.getUsdjpyttb() <= 0 ||
                    kawaseRateData.getUsdjpyttm() <= 0 || kawaseRateData.getUsdjpynykn() <= 0 ||
                    kawaseRateData.getUsdjpysykn() <= 0) {

                    throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023,
                        kawaseRateData.getKwsrendoukbn().getContent()));
                }

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTS,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpytts()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTB,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpyttb()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpyttm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getUsdjpynykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE, BizNumber.valueOf(kawaseRateData.getUsdjpysykn()), kawaseRateLst);
            }
            else if (C_KwsrendouKbn.KOUJIKAWASERATE2.eq(kawaseRateData.getKwsrendoukbn())) {
                if (kawaseRateData.getUsdjpytts() <= 0 || kawaseRateData.getUsdjpyttb() <= 0 ||
                    kawaseRateData.getUsdjpyttm() <= 0 || kawaseRateData.getAudjpytts() <= 0 ||
                    kawaseRateData.getAudjpyttb() <= 0 || kawaseRateData.getAudjpyttm() <= 0 ||
                    kawaseRateData.getUsdjpynykn() <= 0 || kawaseRateData.getAudjpynykn() <= 0 ||
                    kawaseRateData.getUsdaudnykn() <= 0 || kawaseRateData.getAudusdnykn() <= 0 ||
                    kawaseRateData.getUsdjpysykn() <= 0 || kawaseRateData.getAudjpysykn() <= 0 ){

                    throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023,
                        kawaseRateData.getKwsrendoukbn().getContent()));
                }

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTS,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpytts()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTB,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpyttb()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpyttm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTS,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTB,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTS,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getAudjpytts()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTB,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getAudjpyttb()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getAudjpyttm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getUsdjpynykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getAudjpynykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.EUR, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.AUD, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getUsdaudnykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.USD, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.AUD, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.USD, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getAudusdnykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.EUR, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE, BizNumber.valueOf(kawaseRateData.getUsdjpysykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE, BizNumber.valueOf(kawaseRateData.getAudjpysykn()), kawaseRateLst);
            }
            else if (C_KwsrendouKbn.PM17JIKAWASERATE.eq(kawaseRateData.getKwsrendoukbn())) {
                if (kawaseRateData.getUsdjpytts17pm() <= 0 || kawaseRateData.getUsdjpyttb17pm() <= 0 ||
                    kawaseRateData.getUsdjpyttm17pm() <= 0 || kawaseRateData.getAudjpytts17pm() <= 0 ||
                    kawaseRateData.getAudjpyttb17pm() <= 0 || kawaseRateData.getAudjpyttm17pm() <= 0 ||
                    kawaseRateData.getUsdjpynykn() <= 0 || kawaseRateData.getAudjpynykn() <= 0 ||
                    kawaseRateData.getUsdaudnykn() <= 0 || kawaseRateData.getAudusdnykn() <= 0 ||
                    kawaseRateData.getUsdjpysykn() <= 0 || kawaseRateData.getAudjpysykn() <= 0 ){

                    throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0023,
                        kawaseRateData.getKwsrendoukbn().getContent()));
                }

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTS,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpytts17pm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTB,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpyttb17pm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getUsdjpyttm17pm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTS,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTB,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTS,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getAudjpytts17pm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTB,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getAudjpyttb17pm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.JISSEIRATE, BizNumber.valueOf(kawaseRateData.getAudjpyttm17pm()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getUsdjpynykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getAudjpynykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.EUR, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.AUD, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getUsdaudnykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.USD, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.AUD, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.USD, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(kawaseRateData.getAudusdnykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.EUR, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE, BizNumber.valueOf(kawaseRateData.getUsdjpysykn()), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.EUR, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE, BizNumber.valueOf(0), kawaseRateLst);

                createKawaseRate(C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE, BizNumber.valueOf(kawaseRateData.getAudjpysykn()), kawaseRateLst);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    void createKawaseRate(C_Tuukasyu pTuukashurui, C_Tuukasyu pKansantuuka, C_KawasetekiyoKbn pKawasetekiyoKbn,
        C_KawasetsryKbn pKawasetsryKbn, BizNumber pRekodo, EntityInserter<BM_KawaseRate> pKawaseRateLst) {

        BM_KawaseRate kawaseRate = new BM_KawaseRate();

        kawaseRate.setKwsratekjymd(kwsratekjYmd);
        kawaseRate.setKwsrendoukbn(kwsrendouKbn);
        kawaseRate.setMototuuka(pTuukashurui);
        kawaseRate.setKanzantuuka(pKansantuuka);
        kawaseRate.setKawasetekiyokbn(pKawasetekiyoKbn);
        kawaseRate.setKawasetsrykbn(pKawasetsryKbn);
        kawaseRate.setKawaserate(pRekodo);
        kawaseRate.setGyoumuKousinKinou(kinouId);
        kawaseRate.setGyoumuKousinsyaId(userId);
        kawaseRate.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(kawaseRate);

        pKawaseRateLst.add(kawaseRate);

        count++;
    }
}
