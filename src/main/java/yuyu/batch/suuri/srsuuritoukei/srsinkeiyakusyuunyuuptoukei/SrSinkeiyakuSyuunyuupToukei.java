package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakusyuunyuuptoukei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrDateUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SnkiSyunyupSyuturyokuKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約収入Ｐ統計情報作成クラス
 */
public class SrSinkeiyakuSyuunyuupToukei implements Batch {

    @Inject
    private SrSinkeiyakuSyuunyuupToukeiParam srSinkeiyakuSyuunyuupToukeiParam;

    @Inject
    private BatchLogger batchLogger;

    private long sinkeiyakuKns = 0;

    private long reigetuinsKns = 0;

    private long kessaninsKns = 0;

    private long itijitableinsKns = 0;

    @Override
    public BatchParam getParam() {

        return srSinkeiyakuSyuunyuupToukeiParam;
    }

    @Execute
    @Transactional
    public void execute() {

        SrSinkeiyakuSyuunyuupToukeiDbaStatement srSinkeiyakuSyuunyuupToukeiDbaStatement =
            SWAKInjector.getInstance(SrSinkeiyakuSyuunyuupToukeiDbaStatement.class);

        try(EntityInserter<ZT_SkeisynyptoukeirigTy> skeisynyptoukeirigTyLst = new EntityInserter<>();
            EntityInserter<ZT_SkeisynyptoukeiksnTy> skeisynyptoukeiksnTyLst = new EntityInserter<>();
            EntityInserter<ST_SynypTukiTugtTykiyuHozon> synypTukiTugtTykiyuHozonLst = new EntityInserter<>();
            ExDBResults<SV_SnkiykSyunyup> snkiykSyunyupLst = srSinkeiyakuSyuunyuupToukeiDbaStatement.getSnkiykSyunyups(
                C_SeirituKbn.SEIRITU);
            ) {

            String busitucd = srSinkeiyakuSyuunyuupToukeiDbaStatement.getTantouCd(
                C_TantouCdKbn.JYUURYOUNYUUKIN).getBusitucd();

            for (SV_SnkiykSyunyup snkiykSyunyup : snkiykSyunyupLst) {

                C_SnkiSyunyupSyuturyokuKbn snkiSyunyupSyuturyokuKbn = C_SnkiSyunyupSyuturyokuKbn.REIGETU;

                BizDate denpyoDate = snkiykSyunyup.getSrsyoriymd().addBusinessDays(1);

                if (SrDateUtil.isKessanTuki(srSinkeiyakuSyuunyuupToukeiParam.getKijyunymd())) {
                    if (denpyoDate.getBizDateYM().compareTo(
                        srSinkeiyakuSyuunyuupToukeiParam.getKijyunymd().getBizDateYM()) == 0) {

                        snkiSyunyupSyuturyokuKbn = C_SnkiSyunyupSyuturyokuKbn.REIGETU;
                    }
                    else if (denpyoDate.getBizDateYM().compareTo(
                        srSinkeiyakuSyuunyuupToukeiParam.getKijyunymd().getBizDateYM()) > 0 &&
                        snkiykSyunyup.getSkeikeijyouym().compareTo(
                            srSinkeiyakuSyuunyuupToukeiParam.getKijyunymd().getBizDateYM()) == 0) {
                        snkiSyunyupSyuturyokuKbn = C_SnkiSyunyupSyuturyokuKbn.KESSAN;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    if (SrDateUtil.isKessanTukiYokugetu(srSinkeiyakuSyuunyuupToukeiParam.getKijyunymd())) {
                        if (denpyoDate.getBizDateYM().compareTo(
                            srSinkeiyakuSyuunyuupToukeiParam.getKijyunymd().getBizDateYM()) == 0 &&
                            snkiykSyunyup.getSkeikeijyouym().compareTo(
                                srSinkeiyakuSyuunyuupToukeiParam.getKijyunymd().getBizDateYM()) == 0) {
                            snkiSyunyupSyuturyokuKbn = C_SnkiSyunyupSyuturyokuKbn.REIGETU;
                        }
                        else {
                            continue;
                        }
                    }
                    else {
                        if (denpyoDate.getBizDateYM().compareTo(
                            srSinkeiyakuSyuunyuupToukeiParam.getKijyunymd().getBizDateYM()) == 0) {
                            snkiSyunyupSyuturyokuKbn = C_SnkiSyunyupSyuturyokuKbn.REIGETU;
                        }
                        else {
                            continue;
                        }
                    }
                }

                sinkeiyakuKns++;

                List<HT_MosSyouhn> mosSyouhnLst = srSinkeiyakuSyuunyuupToukeiDbaStatement.getMosSyouhns(
                    snkiykSyunyup.getMosno(), C_SyutkKbn.SYU);

                for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

                    List<HT_Nyuukin> nyuukinLst = srSinkeiyakuSyuunyuupToukeiDbaStatement.getNyuukin(
                        snkiykSyunyup.getMosno());

                    HT_Nyuukin nyuukin = nyuukinLst.get(0);

                    List<BT_DenpyoData> denpyoDataLst = srSinkeiyakuSyuunyuupToukeiDbaStatement.getDenpyoData(
                        C_DensysKbn.SKEI, snkiykSyunyup.getMosno(), C_DensyoriKbn.SEIRITU);

                    BT_DenpyoData denpyoData = denpyoDataLst.get(0);

                    List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = srSinkeiyakuSyuunyuupToukeiDbaStatement
                        .getNyknJissekiRirekisBySyonoNnykdenno(snkiykSyunyup.getSyono(), denpyoData.getDenrenno());

                    int syouhinUtilResult = SyouhinUtil.hantei(mosSyouhn.getSyouhncd());

                    IT_KhSisuurendoTmttkn tokuteiJitenTumitatekinInfo = null;

                    if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syouhinUtilResult ||
                        SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syouhinUtilResult) {


                        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srSinkeiyakuSyuunyuupToukeiDbaStatement.
                            getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(snkiykSyunyup.getSyono(),
                                snkiykSyunyup.getKykymd());

                        tokuteiJitenTumitatekinInfo = khSisuurendoTmttknLst.get(0);
                    }

                    Boolean zennouRecordFlg = false;

                    if (C_UmuKbn.ARI.eq(snkiykSyunyup.getZennoumousideumu())) {
                        zennouRecordFlg = true;
                    }

                    SrSinkeiyakuSyuunyuupToukeiItemEditor srSinkeiyakuSyuunyuupToukeiItemEditor =
                        SWAKInjector.getInstance(SrSinkeiyakuSyuunyuupToukeiItemEditor.class);

                    ZT_SkeisynyptoukeirigTy skeisynyptoukeirigTyToukip = new ZT_SkeisynyptoukeirigTy();
                    ZT_SkeisynyptoukeiksnTy skeisynyptoukeiksnTyToukip = new ZT_SkeisynyptoukeiksnTy();
                    ST_SynypTukiTugtTykiyuHozon synypTukiTugtTykiyuHozon = new ST_SynypTukiTugtTykiyuHozon();
                    ZT_SkeisynyptoukeirigTy skeisynyptoukeirigTyZennoup = new ZT_SkeisynyptoukeirigTy();
                    ZT_SkeisynyptoukeiksnTy skeisynyptoukeiksnTyZennoup = new ZT_SkeisynyptoukeiksnTy();

                    Boolean result = srSinkeiyakuSyuunyuupToukeiItemEditor.editKoumoku(
                        srSinkeiyakuSyuunyuupToukeiParam, snkiSyunyupSyuturyokuKbn, snkiykSyunyup, busitucd, mosSyouhn,
                        nyuukin, denpyoDataLst, nyknJissekiRirekiLst, skeisynyptoukeirigTyToukip,
                        skeisynyptoukeiksnTyToukip, synypTukiTugtTykiyuHozon, syouhinUtilResult,
                        tokuteiJitenTumitatekinInfo, SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP);

                    if (zennouRecordFlg) {

                        result = srSinkeiyakuSyuunyuupToukeiItemEditor.editKoumoku(srSinkeiyakuSyuunyuupToukeiParam,
                            snkiSyunyupSyuturyokuKbn, snkiykSyunyup, busitucd, mosSyouhn, nyuukin, denpyoDataLst,
                            nyknJissekiRirekiLst, skeisynyptoukeirigTyZennoup, skeisynyptoukeiksnTyZennoup, null,
                            syouhinUtilResult, tokuteiJitenTumitatekinInfo,
                            SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_ZENNOUP);
                    }

                    if (result==false){

                        if (C_SnkiSyunyupSyuturyokuKbn.REIGETU.eq(snkiSyunyupSyuturyokuKbn)) {

                            BizPropertyInitializer.initialize(skeisynyptoukeirigTyToukip);

                            SrSinkeiyakuSyuunyuupToukeiConverter
                            .ztSkeisynyptoukeirigTyConvertPadding(skeisynyptoukeirigTyToukip);

                            skeisynyptoukeirigTyLst.add(skeisynyptoukeirigTyToukip);

                            reigetuinsKns++;
                        }
                        else if (C_SnkiSyunyupSyuturyokuKbn.KESSAN.eq(snkiSyunyupSyuturyokuKbn)) {
                            BizPropertyInitializer.initialize(skeisynyptoukeiksnTyToukip);

                            SrSinkeiyakuSyuunyuupToukeiConverter
                            .ztSkeisynyptoukeiksnTyConvertPadding(skeisynyptoukeiksnTyToukip);

                            skeisynyptoukeiksnTyLst.add(skeisynyptoukeiksnTyToukip);

                            kessaninsKns++;
                        }

                        if (syouhinUtilResult == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                            BizPropertyInitializer.initialize(synypTukiTugtTykiyuHozon);

                            synypTukiTugtTykiyuHozonLst.add(synypTukiTugtTykiyuHozon);

                            itijitableinsKns++;
                        }

                        if (zennouRecordFlg) {

                            if (C_SnkiSyunyupSyuturyokuKbn.REIGETU.eq(snkiSyunyupSyuturyokuKbn)) {

                                BizPropertyInitializer.initialize(skeisynyptoukeirigTyZennoup);

                                SrSinkeiyakuSyuunyuupToukeiConverter
                                .ztSkeisynyptoukeirigTyConvertPadding(skeisynyptoukeirigTyZennoup);

                                skeisynyptoukeirigTyLst.add(skeisynyptoukeirigTyZennoup);

                                reigetuinsKns++;
                            }
                            else if (C_SnkiSyunyupSyuturyokuKbn.KESSAN.eq(snkiSyunyupSyuturyokuKbn)) {
                                BizPropertyInitializer.initialize(skeisynyptoukeiksnTyZennoup);

                                SrSinkeiyakuSyuunyuupToukeiConverter
                                .ztSkeisynyptoukeiksnTyConvertPadding(skeisynyptoukeiksnTyZennoup);

                                skeisynyptoukeiksnTyLst.add(skeisynyptoukeiksnTyZennoup);

                                kessaninsKns++;
                            }
                        }
                    }
                }
            }

            if((srSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd().equals(SrSinkeiyakuSyuunyuupToukeiParam.REIGETUHONBANSOUKOU)
                || srSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd().equals(SrSinkeiyakuSyuunyuupToukeiParam.KESSANKIHONBANSOUKOU))
                && srSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount()!=0)
            {
                throw new BizAppException(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
                    String.valueOf(srSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount())));
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "新契約", String.valueOf(sinkeiyakuKns)));

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "新契約収入Ｐ統計例月Ｆテーブル（中）",
                String.valueOf(reigetuinsKns)));

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "新契約収入Ｐ統計決算Ｆテーブル（中）",
                String.valueOf(kessaninsKns)));

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "収入Ｐ統計当月処理中継用保存テーブル",
                String.valueOf(itijitableinsKns)));

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(srSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount())));
        }
    }
}
