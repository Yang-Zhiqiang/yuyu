package yuyu.batch.biz.boss.bztuutirirekirendoufsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ通知履歴連動Ｆ作成
 */
public class BzTuutirirekiRendouFSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long kensu = 0;
        String zenTuutirirekino = "0000000000000";
        BizDate zenTuutisakuseiymd = BizDate.valueOf("00000000");
        int maxTuutisakuseino = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        try (
            ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokanLst =
            bizDomManager.getTuutirirekiMeisaiHokansByTuutisakuseiymd2(syoriYmd.getBizDateYM().addMonths(-3));
            EntityInserter<ZT_TuutirirekiMeisaiFTy> tuutirirekiMeisaiFTyInserter = new EntityInserter<>();
            ) {
            for (BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan : tuutirirekiMeisaiHokanLst) {

                if (!tuutirirekiMeisaiHokan.getTuutirirekino().equals(zenTuutirirekino)
                    || BizDateUtil.compareYmd(tuutirirekiMeisaiHokan.getTuutisakuseiymd(),
                        zenTuutisakuseiymd) != BizDateUtil.COMPARE_EQUAL) {
                    maxTuutisakuseino = tuutirirekiMeisaiHokan.getTuutisakuseino();
                }

                if (tuutirirekiMeisaiHokan.getTuutisakuseino() == 0) {
                    maxTuutisakuseino++;
                    tuutirirekiMeisaiHokan.setTuutisakuseino(maxTuutisakuseino);
                }

                ZT_TuutirirekiMeisaiFTy ztTuutirirekiMeisaiFTy = new ZT_TuutirirekiMeisaiFTy();
                ztTuutirirekiMeisaiFTy.setZtytuutirirekino(tuutirirekiMeisaiHokan.getTuutirirekino());
                ztTuutirirekiMeisaiFTy.setZtytuutisakuseiymd(
                    String.valueOf(tuutirirekiMeisaiHokan.getTuutisakuseiymd()));
                ztTuutirirekiMeisaiFTy.setZtytuutisakuseino(Strings.padStart(
                    String.valueOf(tuutirirekiMeisaiHokan.getTuutisakuseino()), 2, '0'));
                ztTuutirirekiMeisaiFTy.setZtytuutisyuruicd(tuutirirekiMeisaiHokan.getTuutisyuruicd());
                if (tuutirirekiMeisaiHokan.getHyoujiyoutuutisakuseiymd() != null) {
                    ztTuutirirekiMeisaiFTy.setZtyhyoujiyoutuutisksymd(String.valueOf(tuutirirekiMeisaiHokan
                        .getHyoujiyoutuutisakuseiymd()));
                }
                else {
                    ztTuutirirekiMeisaiFTy.setZtyhyoujiyoutuutisksymd("00000000");
                }
                ztTuutirirekiMeisaiFTy.setZtyyobiv11("");


                BizPropertyInitializer.initialize(ztTuutirirekiMeisaiFTy);

                BzTuutirirekiRendouFSksConverter.convertPadding(ztTuutirirekiMeisaiFTy);

                tuutirirekiMeisaiFTyInserter.add(ztTuutirirekiMeisaiFTy);

                kensu++;

                zenTuutirirekino = tuutirirekiMeisaiHokan.getTuutirirekino();

                zenTuutisakuseiymd = tuutirirekiMeisaiHokan.getTuutisakuseiymd();
            }
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kensu), kinou.getKinouNm()));
        }
    }
}
