package yuyu.batch.suuri.srsuuritoukei.srsp2rnduyusouseiritu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrSinkykSeirituCommonParam;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSet;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetConverter;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.SV_Sp2RnduyuSouseiritu;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu1Ty;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu2Ty;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu3Ty;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu4Ty;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu5Ty;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu6Ty;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ＳＰ２連動用総成立情報作成クラス
 */
public class SrSp2RnduyuSouseirituBatch implements Batch {

    private Long table1count = 0L;

    private Long table2count = 0L;

    private Long table3count = 0L;

    private Long table4count = 0L;

    private Long table5count = 0L;

    private Long table6count = 0L;

    @Inject
    private SrSinkykSeirituCommonParam srSinkykSeirituCommonParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {

        return srSinkykSeirituCommonParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srSinkykSeirituCommonParam.setParam();

        table1count = 0L;
        table2count = 0L;
        table3count = 0L;
        table4count = 0L;
        table5count = 0L;
        table6count = 0L;

        SrSp2RnduyuSouseirituDbaStatement srSp2RnduyuSouseirituDbaStatement =
            SWAKInjector.getInstance(SrSp2RnduyuSouseirituDbaStatement.class);

        try(ExDBResults<SV_Sp2RnduyuSouseiritu> sp2RnduyuSouseirituLst = srSp2RnduyuSouseirituDbaStatement.getSp2RnduyuSouseiritu(
            srSinkykSeirituCommonParam.getTyuusyututaisyouym(), C_SeirituKbn.SEIRITU);
            EntityInserter<ZT_Sp2RnduyuSouseiritu1Ty> ZT_Sp2RnduyuSouseiritu1TyLst = new EntityInserter<>();
            EntityInserter<ZT_Sp2RnduyuSouseiritu2Ty> ZT_Sp2RnduyuSouseiritu2TyLst = new EntityInserter<>();
            EntityInserter<ZT_Sp2RnduyuSouseiritu3Ty> ZT_Sp2RnduyuSouseiritu3TyLst = new EntityInserter<>();
            EntityInserter<ZT_Sp2RnduyuSouseiritu4Ty> ZT_Sp2RnduyuSouseiritu4TyLst = new EntityInserter<>();
            EntityInserter<ZT_Sp2RnduyuSouseiritu5Ty> ZT_Sp2RnduyuSouseiritu5TyLst = new EntityInserter<>();
            EntityInserter<ZT_Sp2RnduyuSouseiritu6Ty> ZT_Sp2RnduyuSouseiritu6TyLst = new EntityInserter<>();) {

            for (SV_Sp2RnduyuSouseiritu sp2RnduyuSouseiritu : sp2RnduyuSouseirituLst) {

                ZT_Sp2RnduyuSouseiritu1Ty sp2RnduyuSouseiritu1Ty = new ZT_Sp2RnduyuSouseiritu1Ty();
                ZT_Sp2RnduyuSouseiritu2Ty sp2RnduyuSouseiritu2Ty = new ZT_Sp2RnduyuSouseiritu2Ty();
                ZT_Sp2RnduyuSouseiritu3Ty sp2RnduyuSouseiritu3Ty = new ZT_Sp2RnduyuSouseiritu3Ty();
                ZT_Sp2RnduyuSouseiritu4Ty sp2RnduyuSouseiritu4Ty = new ZT_Sp2RnduyuSouseiritu4Ty();
                ZT_Sp2RnduyuSouseiritu5Ty sp2RnduyuSouseiritu5Ty = new ZT_Sp2RnduyuSouseiritu5Ty();
                ZT_Sp2RnduyuSouseiritu6Ty sp2RnduyuSouseiritu6Ty = new ZT_Sp2RnduyuSouseiritu6Ty();

                List<HT_MosSyouhn> mosSyouhnLst = srSp2RnduyuSouseirituDbaStatement.getMosSyouhns(
                    sp2RnduyuSouseiritu.getMosno(), C_SyutkKbn.SYU);

                for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

                    List<HT_MosDairiten> mosDairitenLst = srSp2RnduyuSouseirituDbaStatement.getMosDairiten(
                        sp2RnduyuSouseiritu.getMosno());

                    IT_KykUkt kykUkt = srSp2RnduyuSouseirituDbaStatement.getKykUkt(sp2RnduyuSouseiritu.getSyono(),
                        C_UktsyuKbn.STDRSK);

                    List<HT_Nyuukin> nyuukiLst = srSp2RnduyuSouseirituDbaStatement.getNyuukinJyouhou(
                        sp2RnduyuSouseiritu.getMosno());

                    HT_Nyuukin nyuukiMIN = nyuukiLst.get(0);

                    HT_Nyuukin nyuukiMAX = nyuukiLst.get(nyuukiLst.size() - 1);

                    BM_SyouhnZokusei syouhnZokusei = srSp2RnduyuSouseirituDbaStatement.getSyouhnZokusei(
                        mosSyouhn.getSyouhncd(),mosSyouhn.getSyouhnsdno());

                    List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList =
                        srSp2RnduyuSouseirituDbaStatement
                        .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(sp2RnduyuSouseiritu.getSyono());

                    SrSinkykSeirituKoumokuCommonSet srSinkykSeirituKoumokuCommonSet =
                        SWAKInjector.getInstance(SrSinkykSeirituKoumokuCommonSet.class);

                    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftMokuhyoutiAscList =
                        srSp2RnduyuSouseirituDbaStatement
                        .getTargetTokuyakuBefaAftMokuhyoutiAscList(sp2RnduyuSouseiritu.getSyono());

                    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftKijyungkAscList =
                        srSp2RnduyuSouseirituDbaStatement
                        .getTargetTokuyakuBefaAftKijyungkAscList(sp2RnduyuSouseiritu.getSyono());

                    int syohinHanteiKbn = SyouhinUtil.hantei(mosSyouhn.getSyouhncd());

                    IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList =
                            srSp2RnduyuSouseirituDbaStatement.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(
                                sp2RnduyuSouseiritu.getSyono(), sp2RnduyuSouseiritu.getKykymd());

                        khSisuurendoTmttkn = khSisuurendoTmttknList.get(0);
                    }

                    List<BT_DenpyoData> denpyoDataLst =
                        srSp2RnduyuSouseirituDbaStatement.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
                            C_DensysKbn.SKEI, sp2RnduyuSouseiritu.getMosno(), C_DensyoriKbn.SEIRITU);


                        BizPropertyInitializer.initialize(sp2RnduyuSouseiritu1Ty);


                        ZT_Sp2RnduyuSouseiritu1TyLst.add(sp2RnduyuSouseiritu1Ty);

                        table1count++;

                        BizPropertyInitializer.initialize(sp2RnduyuSouseiritu2Ty);


                        ZT_Sp2RnduyuSouseiritu2TyLst.add(sp2RnduyuSouseiritu2Ty);

                        table2count++;

                        BizPropertyInitializer.initialize(sp2RnduyuSouseiritu3Ty);


                        ZT_Sp2RnduyuSouseiritu3TyLst.add(sp2RnduyuSouseiritu3Ty);

                        table3count++;

                        BizPropertyInitializer.initialize(sp2RnduyuSouseiritu4Ty);

                        ZT_Sp2RnduyuSouseiritu4TyLst.add(sp2RnduyuSouseiritu4Ty);

                        table4count++;

                        BizPropertyInitializer.initialize(sp2RnduyuSouseiritu5Ty);


                        ZT_Sp2RnduyuSouseiritu5TyLst.add(sp2RnduyuSouseiritu5Ty);

                        table5count++;

                        BizPropertyInitializer.initialize(sp2RnduyuSouseiritu6Ty);


                        ZT_Sp2RnduyuSouseiritu6TyLst.add(sp2RnduyuSouseiritu6Ty);

                        table6count++;
                }
            }
        }

        if (SrSinkykSeirituCommonParam.RGIYM000.equals(srSinkykSeirituCommonParam.getIbKakutyoujobcd())
            && srSinkykSeirituCommonParam.getErrorsyorikensuu() != 0) {
            throw new BizAppException(MessageId.ISA1001,
                "数理用エラー情報テーブル", String.valueOf(srSinkykSeirituCommonParam.getErrorsyorikensuu()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "ＳＰ２連動用総成立Fテーブル１（中）",
            String.valueOf(table1count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "ＳＰ２連動用総成立Fテーブル２（中）",
            String.valueOf(table2count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "ＳＰ２連動用総成立Fテーブル３（中）",
            String.valueOf(table3count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "ＳＰ２連動用総成立Fテーブル４（中）",
            String.valueOf(table4count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "ＳＰ２連動用総成立Fテーブル５（中）",
            String.valueOf(table5count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "ＳＰ２連動用総成立Fテーブル６（中）",
            String.valueOf(table6count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001,
            "数理用エラー情報テーブル", String.valueOf(srSinkykSeirituCommonParam.getErrorsyorikensuu())));

    }
}
