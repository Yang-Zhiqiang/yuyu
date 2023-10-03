package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakugetujiseiritu;

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
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr1Ty;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr2Ty;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr4Ty;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr5Ty;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約決算ベース月次成立情報作成クラス
 */
public class SrSinkeiyakuGetujiSeiritu implements Batch {

    private long table1count = 0L;

    private long table2count = 0L;

    private long table3count = 0L;

    private long table4count = 0L;

    private long table5count = 0L;

    private long table6count = 0L;

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

        SrSinkeiyakuGetujiSeirituDbaStatement srSinkeiyakuGetujiSeirituDbaStatement =
            SWAKInjector.getInstance(SrSinkeiyakuGetujiSeirituDbaStatement.class);

        try(ExDBResults<SV_SnkiykGtjSirt> snkiykGtjSirtLst = srSinkeiyakuGetujiSeirituDbaStatement.getSnkiykGtjSirt(
            srSinkykSeirituCommonParam.getTyuusyututaisyouym(), C_SeirituKbn.SEIRITU);
            EntityInserter<ZT_Skeiksnbsgetujisr1Ty> ZT_Skeiksnbsgetujisr1TyLst = new EntityInserter<>();
            EntityInserter<ZT_Skeiksnbsgetujisr2Ty> ZT_Skeiksnbsgetujisr2TyLst = new EntityInserter<>();
            EntityInserter<ZT_Skeiksnbsgetujisr3Ty> ZT_Skeiksnbsgetujisr3TyLst = new EntityInserter<>();
            EntityInserter<ZT_Skeiksnbsgetujisr4Ty> ZT_Skeiksnbsgetujisr4TyLst = new EntityInserter<>();
            EntityInserter<ZT_Skeiksnbsgetujisr5Ty> ZT_Skeiksnbsgetujisr5TyLst = new EntityInserter<>();
            EntityInserter<ZT_Skeiksnbsgetujisr6Ty> ZT_Skeiksnbsgetujisr6TyLst = new EntityInserter<>();) {

            for (SV_SnkiykGtjSirt snkiykGtjSirt : snkiykGtjSirtLst) {

                ZT_Skeiksnbsgetujisr1Ty skeiksnbsgetujisr1Ty = new ZT_Skeiksnbsgetujisr1Ty();
                ZT_Skeiksnbsgetujisr2Ty skeiksnbsgetujisr2Ty = new ZT_Skeiksnbsgetujisr2Ty();
                ZT_Skeiksnbsgetujisr3Ty skeiksnbsgetujisr3Ty = new ZT_Skeiksnbsgetujisr3Ty();
                ZT_Skeiksnbsgetujisr4Ty skeiksnbsgetujisr4Ty = new ZT_Skeiksnbsgetujisr4Ty();
                ZT_Skeiksnbsgetujisr5Ty skeiksnbsgetujisr5Ty = new ZT_Skeiksnbsgetujisr5Ty();
                ZT_Skeiksnbsgetujisr6Ty skeiksnbsgetujisr6Ty = new ZT_Skeiksnbsgetujisr6Ty();

                List<HT_MosSyouhn> mosSyouhnLst = srSinkeiyakuGetujiSeirituDbaStatement.getMosSyouhns(
                    snkiykGtjSirt.getMosno(), C_SyutkKbn.SYU);

                for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

                    List<HT_MosDairiten> mosDairitenLst = srSinkeiyakuGetujiSeirituDbaStatement.getMosDairiten(
                        snkiykGtjSirt.getMosno());

                    IT_KykUkt kykUkt = srSinkeiyakuGetujiSeirituDbaStatement.getKykUkt(snkiykGtjSirt.getSyono(),
                        C_UktsyuKbn.STDRSK);

                    List<HT_Nyuukin> nyuukinLst =
                        srSinkeiyakuGetujiSeirituDbaStatement.getNyuukinJyouhou(snkiykGtjSirt.getMosno());

                    HT_Nyuukin nyuukinEntityMin = nyuukinLst.get(0);

                    HT_Nyuukin nyuukinEntityMax = nyuukinLst.get(nyuukinLst.size() - 1);

                    BM_SyouhnZokusei syouhnZokusei = srSinkeiyakuGetujiSeirituDbaStatement.getSyouhnZokusei(
                        mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

                    List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList =
                        srSinkeiyakuGetujiSeirituDbaStatement
                        .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(snkiykGtjSirt.getSyono());

                    SrSinkykSeirituKoumokuCommonSet srSinkykSeirituKoumokuCommonSet = SWAKInjector.getInstance(
                        SrSinkykSeirituKoumokuCommonSet.class);

                    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftMokuhyoutiAscList =
                        srSinkeiyakuGetujiSeirituDbaStatement
                        .getTargetTokuyakuBefaAftMokuhyoutiAscList(snkiykGtjSirt.getSyono());

                    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftKijyungkAscList =
                        srSinkeiyakuGetujiSeirituDbaStatement
                        .getTargetTokuyakuBefaAftKijyungkAscList(snkiykGtjSirt.getSyono());

                    int syohinHanteiKbn = SyouhinUtil.hantei(mosSyouhn.getSyouhncd());

                    IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList = srSinkeiyakuGetujiSeirituDbaStatement.
                            getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(
                                snkiykGtjSirt.getSyono(), snkiykGtjSirt.getKykymd());

                        khSisuurendoTmttkn = khSisuurendoTmttknList.get(0);
                    }

                    List<BT_DenpyoData> btDenpyoDataList =
                        srSinkeiyakuGetujiSeirituDbaStatement.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
                            C_DensysKbn.SKEI, snkiykGtjSirt.getMosno(), C_DensyoriKbn.SEIRITU);

                    boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(
                        srSinkykSeirituCommonParam,
                        snkiykGtjSirt,
                        mosSyouhn,
                        mosDairitenLst,
                        kykUkt,
                        nyuukinEntityMax,
                        nyuukinEntityMin,
                        syouhnZokusei,
                        khHenkouRirekiBeanList,
                        targetTokuyakuBefaAftMokuhyoutiAscList,
                        targetTokuyakuBefaAftKijyungkAscList,
                        skeiksnbsgetujisr1Ty,
                        skeiksnbsgetujisr2Ty,
                        skeiksnbsgetujisr3Ty,
                        skeiksnbsgetujisr4Ty,
                        skeiksnbsgetujisr5Ty,
                        skeiksnbsgetujisr6Ty,
                        syohinHanteiKbn,
                        khSisuurendoTmttkn,
                        btDenpyoDataList);

                    if (!errorFlag) {

                        BizPropertyInitializer.initialize(skeiksnbsgetujisr1Ty);

                        SrSinkykSeirituKoumokuCommonSetConverter
                        .sinkeiyakuSeiritu1ParamConvertPadding(skeiksnbsgetujisr1Ty);

                        ZT_Skeiksnbsgetujisr1TyLst.add(skeiksnbsgetujisr1Ty);

                        table1count++;

                        BizPropertyInitializer.initialize(skeiksnbsgetujisr2Ty);

                        SrSinkykSeirituKoumokuCommonSetConverter
                        .sinkeiyakuSeiritu2ParamConvertPadding(skeiksnbsgetujisr2Ty);

                        ZT_Skeiksnbsgetujisr2TyLst.add(skeiksnbsgetujisr2Ty);

                        table2count++;

                        BizPropertyInitializer.initialize(skeiksnbsgetujisr3Ty);

                        SrSinkykSeirituKoumokuCommonSetConverter
                        .sinkeiyakuSeiritu3ParamConvertPadding(skeiksnbsgetujisr3Ty);

                        ZT_Skeiksnbsgetujisr3TyLst.add(skeiksnbsgetujisr3Ty);

                        table3count++;

                        BizPropertyInitializer.initialize(skeiksnbsgetujisr4Ty);

                        ZT_Skeiksnbsgetujisr4TyLst.add(skeiksnbsgetujisr4Ty);

                        table4count++;

                        BizPropertyInitializer.initialize(skeiksnbsgetujisr5Ty);

                        SrSinkykSeirituKoumokuCommonSetConverter
                        .sinkeiyakuSeiritu5ParamConvertPadding(skeiksnbsgetujisr5Ty);

                        ZT_Skeiksnbsgetujisr5TyLst.add(skeiksnbsgetujisr5Ty);

                        table5count++;

                        BizPropertyInitializer.initialize(skeiksnbsgetujisr6Ty);

                        SrSinkykSeirituKoumokuCommonSetConverter
                        .sinkeiyakuSeiritu6ParamConvertPadding(skeiksnbsgetujisr6Ty);

                        ZT_Skeiksnbsgetujisr6TyLst.add(skeiksnbsgetujisr6Ty);

                        table6count++;
                    }
                }
            }
        }

        if ((SrSinkykSeirituCommonParam.RGHEM004.equals(srSinkykSeirituCommonParam.getIbKakutyoujobcd()) ||
            SrSinkykSeirituCommonParam.RGHEM000.equals(srSinkykSeirituCommonParam.getIbKakutyoujobcd())) &&
            srSinkykSeirituCommonParam.getErrorsyorikensuu() != 0) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(srSinkykSeirituCommonParam.getErrorsyorikensuu())));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "新契約決算ベース月次成立Fテーブル１（中）",
            String.valueOf(table1count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "新契約決算ベース月次成立Fテーブル２（中）",
            String.valueOf(table2count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "新契約決算ベース月次成立Fテーブル３（中）",
            String.valueOf(table3count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "新契約決算ベース月次成立Fテーブル４（中）",
            String.valueOf(table4count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "新契約決算ベース月次成立Fテーブル５（中）",
            String.valueOf(table5count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "新契約決算ベース月次成立Fテーブル６（中）",
            String.valueOf(table6count)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(srSinkykSeirituCommonParam.getErrorsyorikensuu())));
    }
}
