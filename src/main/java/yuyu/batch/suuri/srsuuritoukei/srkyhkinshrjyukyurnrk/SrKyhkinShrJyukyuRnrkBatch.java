package yuyu.batch.suuri.srsuuritoukei.srkyhkinshrjyukyurnrk;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 給付金支払状況連絡情報作成
 */
public class SrKyhkinShrJyukyuRnrkBatch implements Batch {

    private static final String MESSAGEARGTABLENM1 = "数理用エラー情報テーブル";

    private static final String MESSAGEARGTABLENM2 = "給付金支払状況連絡Ｆテーブル（中）";

    @Inject
    private SrKyhkinShrJyukyuRnrkBatchParam srKyhkinShrJyukyuRnrkBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {
        return srKyhkinShrJyukyuRnrkBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srKyhkinShrJyukyuRnrkBatchParam.setParam();

        SrKyhkinShrJyukyuRnrkBatchDbAccess srKyhkinShrJyukyuRnrkBatchDbAccess =
            SWAKInjector.getInstance(SrKyhkinShrJyukyuRnrkBatchDbAccess.class);
        try (ExDBResults<JT_SiRireki> siRirekiLst =
            srKyhkinShrJyukyuRnrkBatchDbAccess.getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(C_ShrKekkaKbn.SHR,
                srKyhkinShrJyukyuRnrkBatchParam.getTysyttaisyouYm().getFirstDay(),
                srKyhkinShrJyukyuRnrkBatchParam.getTysyttaisyouYm().getLastDay());
            EntityInserter<ZT_KyhknShrJyoukyouRnrkTy> kyhknShrJyoukyouRnrkTyInserter = new EntityInserter<>()) {

            String skNo = "";
            String syoNo = "";

            for (JT_SiRireki siRireki : siRirekiLst) {

                skNo = siRireki.getSkno();
                syoNo = siRireki.getSyono();

                JT_SkKihon jtSkKihon = srKyhkinShrJyukyuRnrkBatchDbAccess.getSkKihon(skNo, syoNo);

                if (!C_SeikyuuSyubetu.SB.eq(jtSkKihon.getSeikyuusyubetu())) {
                    continue;
                }

                List<JT_Sk> skLst = srKyhkinShrJyukyuRnrkBatchDbAccess.getSks(skNo, syoNo);
                JT_Sk skLast = skLst.get(0);

                List<JT_SkJiyuu> skJiyuuLst =
                    srKyhkinShrJyukyuRnrkBatchDbAccess.getSkJiyuus(skNo, syoNo, skLast.getSeikyuurirekino());
                JT_SkJiyuu skJiyuu = skJiyuuLst.get(0);

                List<JT_SiDetail> siDetailLst =
                    srKyhkinShrJyukyuRnrkBatchDbAccess.getSiDetails(skNo, syoNo, skLast.getSeikyuurirekino());
                JT_SiDetail siDetail = siDetailLst.get(0);

                if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(siDetail.getHokenkinsyuruikbn())) {
                }
                else {
                    continue;
                }

                IT_KykKihon kykKihon = srKyhkinShrJyukyuRnrkBatchDbAccess.getKykKihon(syoNo);

                IT_KykDairiten kykDairiten = srKyhkinShrJyukyuRnrkBatchDbAccess.getKykDairiten(syoNo);

                IT_KykSonotaTkyk kykSonotaTkyk = srKyhkinShrJyukyuRnrkBatchDbAccess.getKykSonotaTkyk(syoNo);

                BM_SyouhnZokusei syouhnZokusei =
                    srKyhkinShrJyukyuRnrkBatchDbAccess.getSyouhnZokusei(siDetail.getSyouhncd(),
                        siDetail.getSyouhnsdno());

                List<SV_KiykSyuhnData> kiykSyuhnDataLst =
                    srKyhkinShrJyukyuRnrkBatchDbAccess.getKiykSyuhnDatasBySyonoSyutkkbn(syoNo, C_SyutkKbn.SYU);

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean =
                    srGetTokutejitenSyohnInfo.exec(C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO, syoNo,
                        siRireki.getShrsyoriymd(), "", kiykSyuhnDataLst);
                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                    tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                ZT_KyhknShrJyoukyouRnrkTy kyhknShrJyoukyouRnrkTy = new ZT_KyhknShrJyoukyouRnrkTy();

                SrKyhkinShrJyukyuRnrkBatchEdit srKyhkinShrJyukyuRnrkBatchEdit =
                    SWAKInjector.getInstance(SrKyhkinShrJyukyuRnrkBatchEdit.class);
                boolean errorFlag = srKyhkinShrJyukyuRnrkBatchEdit.editKoumoku(srKyhkinShrJyukyuRnrkBatchParam,
                    siRireki,
                    skJiyuu,
                    kykDairiten,
                    kykSonotaTkyk,
                    kykKihon,
                    syouhnZokusei,
                    tkJitenKeiyakuSyouhinKijyunBean,
                    kyhknShrJyoukyouRnrkTy);

                if (!errorFlag) {
                    kyhknShrJyoukyouRnrkTyInserter.add(kyhknShrJyoukyouRnrkTy);
                    srKyhkinShrJyukyuRnrkBatchParam
                    .setSyoriKensuu(srKyhkinShrJyukyuRnrkBatchParam.getSyoriKensuu() + 1);
                }
                else {
                    continue;
                }
            }

            if (SrKyhkinShrJyukyuRnrkBatchParam.KAKUTYOUJOBCD_SRKYHKINSHRJYUKYURNRK_HONBANSOUKOU.equals(
                srKyhkinShrJyukyuRnrkBatchParam.getIbKakutyoujobcd()) &&
                srKyhkinShrJyukyuRnrkBatchParam.getErrorSyoriKensuu() != 0) {

                throw new BizAppException(MessageId.ISA1001, MESSAGEARGTABLENM1,
                    String.valueOf(srKyhkinShrJyukyuRnrkBatchParam.getErrorSyoriKensuu()));
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, MESSAGEARGTABLENM2,
                String.valueOf(srKyhkinShrJyukyuRnrkBatchParam.getSyoriKensuu())));
            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, MESSAGEARGTABLENM1,
                String.valueOf(srKyhkinShrJyukyuRnrkBatchParam.getErrorSyoriKensuu())));
        }
    }
}
