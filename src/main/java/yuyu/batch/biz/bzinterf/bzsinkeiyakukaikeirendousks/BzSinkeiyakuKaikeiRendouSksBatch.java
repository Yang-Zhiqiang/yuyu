package yuyu.batch.biz.bzinterf.bzsinkeiyakukaikeirendousks;

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
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 新契約会計連動ファイル作成処理クラス
 */
public class BzSinkeiyakuKaikeiRendouSksBatch implements Batch {

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

        try (EntityInserter<ZT_SkKaikeiTorihikiFileTy> ztSkKaikeiTorihikiFileTyList = new EntityInserter<>();
            ExDBResults<BT_SinkeiyakuHurikaeDen> btSinkeiyakuHurikaeDenList = bizDomManager
                .getSinkeiyakuHurikaeDensBySyoriYmd(syoriYmd)) {

            BzSinkeiyakuKaikeiTorihikiFileInfo previousBzSinkeiyakuFileInfo = null;
            List<BzSinkeiyakuKaikeiTorihikiFileInfo> bzSinkeiyakuKaikeiHiritokiFileInfoList = new ArrayList<>();

            for (BT_SinkeiyakuHurikaeDen btSinkeiyakuHurikaeDen : btSinkeiyakuHurikaeDenList) {

                if (previousBzSinkeiyakuFileInfo == null) {

                    previousBzSinkeiyakuFileInfo = getBzSinkeiyakuKaikeiTorihikiFileInfo(btSinkeiyakuHurikaeDen);
                    bzSinkeiyakuKaikeiHiritokiFileInfoList.add(previousBzSinkeiyakuFileInfo);
                }
                else {

                    if (previousBzSinkeiyakuFileInfo.getTorihikino().equals(btSinkeiyakuHurikaeDen.getTorihikino())) {

                        previousBzSinkeiyakuFileInfo.siwakeMeisaiAdd(btSinkeiyakuHurikaeDen);
                    }
                    else {

                        previousBzSinkeiyakuFileInfo = getBzSinkeiyakuKaikeiTorihikiFileInfo(btSinkeiyakuHurikaeDen);
                        bzSinkeiyakuKaikeiHiritokiFileInfoList.add(previousBzSinkeiyakuFileInfo);
                    }
                }
            }

            for (BzSinkeiyakuKaikeiTorihikiFileInfo bzSinkeiyakuInfo : bzSinkeiyakuKaikeiHiritokiFileInfoList) {

                List<BzSinkeiyakuSiwakeKoumokuInfo> bzSinkeiyakuInfoLst = bzSinkeiyakuInfo
                    .getBzSinkeiyakuSiwakeKoumokuInfoList();

                for (BzSinkeiyakuSiwakeKoumokuInfo bzSinkeiyakuSiwakeKoumokuInfo : bzSinkeiyakuInfoLst) {

                    ZT_SkKaikeiTorihikiFileTy skKaikeiTorihikiFileTy = new ZT_SkKaikeiTorihikiFileTy();

                    skKaikeiTorihikiFileTy.setZtylen("");
                    skKaikeiTorihikiFileTy.setZtykaikeitani(KAIKEI_TORIHIKI_TANI);
                    skKaikeiTorihikiFileTy.setZtysystemkbnnum(bzSinkeiyakuInfo.getKeirisyskbn().getValue());
                    skKaikeiTorihikiFileTy.setZtysyoricd("");
                    if (bzSinkeiyakuInfo.getDenymd() != null) {

                        skKaikeiTorihikiFileTy.setZtytorihikiymd(String.valueOf(bzSinkeiyakuInfo.getDenymd()));
                    }

                    skKaikeiTorihikiFileTy.setZtytorihikinon7(bzSinkeiyakuInfo.getTorihikino());
                    skKaikeiTorihikiFileTy.setZtynyuuryokubasyo("0");
                    skKaikeiTorihikiFileTy.setZtynyuuryokusyacd("0");
                    skKaikeiTorihikiFileTy.setZtysyoriymdn(String.valueOf(syoriYmd));
                    skKaikeiTorihikiFileTy.setZtysimekirikbn("0");
                    skKaikeiTorihikiFileTy.setZtykessankbn("0");
                    skKaikeiTorihikiFileTy.setZtyyobiv20("");
                    skKaikeiTorihikiFileTy.setZtykaisyakantorihikikbn("0");
                    skKaikeiTorihikiFileTy.setZtytukekaekbn("0");
                    skKaikeiTorihikiFileTy.setZtytablekosuu(String.valueOf(bzSinkeiyakuInfoLst.size()));
                    skKaikeiTorihikiFileTy.setZtykanjyoukbnn("0");
                    skKaikeiTorihikiFileTy.setZtytaisyakukbnn(
                        bzSinkeiyakuSiwakeKoumokuInfo.getTaisyakukbn().getValue());
                    skKaikeiTorihikiFileTy.setZtykanjyoukamokucdn(
                        bzSinkeiyakuSiwakeKoumokuInfo.getDenkanjokamokucd());
                    skKaikeiTorihikiFileTy.setZtyyobiv4("");
                    skKaikeiTorihikiFileTy.setZtysuitoubumon(
                        bzSinkeiyakuSiwakeKoumokuInfo.getSuitoubumonCd().concat(ZERO_FOUR_KETA));
                    skKaikeiTorihikiFileTy.setZtykingaku(
                        new BigDecimal(bzSinkeiyakuSiwakeKoumokuInfo.getDenyenkagk().toString()).longValue());
                    skKaikeiTorihikiFileTy.setZtytekiyoucd(bzSinkeiyakuSiwakeKoumokuInfo.getTekiyoucd());
                    skKaikeiTorihikiFileTy.setZtyyobiv10("");
                    skKaikeiTorihikiFileTy.setZtymeisaikanryoukbn("0");

                    BizPropertyInitializer.initialize(skKaikeiTorihikiFileTy);
                    ztSkKaikeiTorihikiFileTyList.add(skKaikeiTorihikiFileTy);
                    syoriKensuu++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private BzSinkeiyakuKaikeiTorihikiFileInfo getBzSinkeiyakuKaikeiTorihikiFileInfo(
        BT_SinkeiyakuHurikaeDen pSinkeiyakuHurikaeDen) {

        BzSinkeiyakuKaikeiTorihikiFileInfo bzSinkeiyakuInfo = SWAKInjector
            .getInstance(BzSinkeiyakuKaikeiTorihikiFileInfo.class);

        bzSinkeiyakuInfo.setKeirisyskbn(pSinkeiyakuHurikaeDen.getKeirisyskbn());
        bzSinkeiyakuInfo.setTorihikino(pSinkeiyakuHurikaeDen.getTorihikino());
        bzSinkeiyakuInfo.setHuridenatesakicd(pSinkeiyakuHurikaeDen.getHuridenatesakicd());
        bzSinkeiyakuInfo.setDenymd(pSinkeiyakuHurikaeDen.getDenymd());
        bzSinkeiyakuInfo.setBzSinkeiyakuSiwakeKoumokuInfoList(new ArrayList<BzSinkeiyakuSiwakeKoumokuInfo>());
        bzSinkeiyakuInfo.siwakeMeisaiAdd(pSinkeiyakuHurikaeDen);

        return bzSinkeiyakuInfo;
    }
}
