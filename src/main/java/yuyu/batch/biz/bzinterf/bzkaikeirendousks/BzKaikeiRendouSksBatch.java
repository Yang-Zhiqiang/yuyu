package yuyu.batch.biz.bzinterf.bzkaikeirendousks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 会計連動ファイル作成処理クラス
 */
public class BzKaikeiRendouSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    private final String KAIKEI_TORIHIKI_TANI = "5210000";

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

        try ( EntityInserter<ZT_KaikeiTorihikiFileTy> kaikeiTorihikiFileTyList = new EntityInserter<>();
            ExDBResults<BT_HuriDenpyou> btHuriDenpyouList = bizDomManager.getHuriDenpyousBySyoriYmd(syoriYmd);) {

            BzKaikeiTorihikiFileInfo preKaikeiTrFileInfo = null;
            List<BzKaikeiTorihikiFileInfo> bzKaikeiTrFileInfoList = new ArrayList<>();

            for (BT_HuriDenpyou huriDenpyou : btHuriDenpyouList) {

                if (preKaikeiTrFileInfo == null) {

                    preKaikeiTrFileInfo = getBzKaikeiTorihikiFileInfo(huriDenpyou);
                    bzKaikeiTrFileInfoList.add(preKaikeiTrFileInfo);
                }
                else {

                    if (preKaikeiTrFileInfo.getTorihikino().equals(huriDenpyou.getTorihikino()) &&
                        preKaikeiTrFileInfo.getHuridenatesakicd().equals( huriDenpyou.getHuridenatesakicd()) &&
                        preKaikeiTrFileInfo.getTantocd().eq(huriDenpyou.getTantocd()) &&
                        BizDateUtil.compareYmd(preKaikeiTrFileInfo.getDenymd(),
                            huriDenpyou.getDenymd()) == BizDateUtil.COMPARE_EQUAL &&
                            preKaikeiTrFileInfo.getHuridenskskbn().eq(huriDenpyou.getHuridenskskbn())) {

                        preKaikeiTrFileInfo.siwakeMeisaiAdd(huriDenpyou);
                    }

                    else {

                        preKaikeiTrFileInfo = getBzKaikeiTorihikiFileInfo(huriDenpyou);
                        bzKaikeiTrFileInfoList.add(preKaikeiTrFileInfo);
                    }
                }
            }

            for (BzKaikeiTorihikiFileInfo bzKaikeiTrFileInfo : bzKaikeiTrFileInfoList) {

                List<BzSiwakeKoumokuInfo> bzSiwakeKoumokuInfoList = bzKaikeiTrFileInfo.getBzSiwakeKoumokuInfoList();
                for (BzSiwakeKoumokuInfo bzSiwakeKoumokuInfo : bzSiwakeKoumokuInfoList) {

                    ZT_KaikeiTorihikiFileTy ztKaikeiTorihikiFileTy = new ZT_KaikeiTorihikiFileTy();

                    ztKaikeiTorihikiFileTy.setZtylen("");
                    ztKaikeiTorihikiFileTy.setZtykaikeitani(KAIKEI_TORIHIKI_TANI);
                    ztKaikeiTorihikiFileTy.setZtysystemkbnnum(bzKaikeiTrFileInfo.getKeirisyskbn().getValue());
                    ztKaikeiTorihikiFileTy.setZtysyoricd("");
                    if (bzKaikeiTrFileInfo.getDenymd() != null) {

                        ztKaikeiTorihikiFileTy.setZtytorihikiymd(String.valueOf(bzKaikeiTrFileInfo.getDenymd()));
                    }

                    ztKaikeiTorihikiFileTy.setZtytorihikinon7(bzKaikeiTrFileInfo.getTorihikino());
                    ztKaikeiTorihikiFileTy.setZtynyuuryokubasyo("0");
                    ztKaikeiTorihikiFileTy.setZtynyuuryokusyacd("0");
                    ztKaikeiTorihikiFileTy.setZtysyoriymdn(String.valueOf(syoriYmd));
                    ztKaikeiTorihikiFileTy.setZtysimekirikbn("0");
                    ztKaikeiTorihikiFileTy.setZtykessankbn("0");
                    ztKaikeiTorihikiFileTy.setZtyyobiv20("");
                    ztKaikeiTorihikiFileTy.setZtykaisyakantorihikikbn("0");
                    ztKaikeiTorihikiFileTy.setZtytukekaekbn("0");
                    ztKaikeiTorihikiFileTy.setZtytablekosuu(String.valueOf(bzSiwakeKoumokuInfoList.size()));
                    ztKaikeiTorihikiFileTy.setZtykanjyoukbnn("0");
                    ztKaikeiTorihikiFileTy.setZtytaisyakukbnn(bzSiwakeKoumokuInfo.getTaisyakukbn().getValue());
                    ztKaikeiTorihikiFileTy.setZtykanjyoukamokucdn(bzSiwakeKoumokuInfo.getDenkanjokamokucd());
                    ztKaikeiTorihikiFileTy.setZtyyobiv4("");
                    ztKaikeiTorihikiFileTy.setZtysuitoubumon(bzSiwakeKoumokuInfo.getSuitoubumoncd().concat(ZERO_FOUR_KETA));
                    ztKaikeiTorihikiFileTy.setZtykingaku(
                        new BigDecimal(bzSiwakeKoumokuInfo.getDenyenkagk().toString()).longValue());
                    ztKaikeiTorihikiFileTy.setZtytekiyoucd(bzSiwakeKoumokuInfo.getTekiyoucd());
                    ztKaikeiTorihikiFileTy.setZtyyobiv10("");
                    ztKaikeiTorihikiFileTy.setZtymeisaikanryoukbn("0");

                    BizPropertyInitializer.initialize(ztKaikeiTorihikiFileTy);
                    kaikeiTorihikiFileTyList.add(ztKaikeiTorihikiFileTy);
                    syoriKensuu++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private BzKaikeiTorihikiFileInfo getBzKaikeiTorihikiFileInfo(BT_HuriDenpyou pHuriDenpyou) {

        BzKaikeiTorihikiFileInfo bzKaikeiTorihikiFileInfo = SWAKInjector.getInstance(BzKaikeiTorihikiFileInfo.class);

        bzKaikeiTorihikiFileInfo.setKeirisyskbn(pHuriDenpyou.getKeirisyskbn());
        bzKaikeiTorihikiFileInfo.setTorihikino(pHuriDenpyou.getTorihikino());
        bzKaikeiTorihikiFileInfo.setHuridenatesakicd(pHuriDenpyou.getHuridenatesakicd());
        bzKaikeiTorihikiFileInfo.setTantocd(pHuriDenpyou.getTantocd());
        bzKaikeiTorihikiFileInfo.setDenymd(pHuriDenpyou.getDenymd());
        bzKaikeiTorihikiFileInfo.setHuridenskskbn(pHuriDenpyou.getHuridenskskbn());
        bzKaikeiTorihikiFileInfo.setBzSiwakeKoumokuInfoList(new ArrayList<BzSiwakeKoumokuInfo>());
        bzKaikeiTorihikiFileInfo.siwakeMeisaiAdd(pHuriDenpyou);

        return bzKaikeiTorihikiFileInfo;
    }
}
