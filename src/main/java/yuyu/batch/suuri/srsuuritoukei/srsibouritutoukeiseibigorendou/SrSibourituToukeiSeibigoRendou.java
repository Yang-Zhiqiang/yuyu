package yuyu.batch.suuri.srsuuritoukei.srsibouritutoukeiseibigorendou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SuuriIdoKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 死亡率統計整備後連動情報作成クラス
 */
public class SrSibourituToukeiSeibigoRendou implements Batch {

    @Inject
    private SrSibourituToukeiSeibigoRendouBatchParam srSibourituToukeiSeibigoRendouBatchParam;

    @Inject
    private BatchLogger batchLogger;

    private int syoriKensuu;

    @Override
    public BatchParam getParam() {
        return srSibourituToukeiSeibigoRendouBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srSibourituToukeiSeibigoRendouBatchParam.setParam();

        BizDate syoriYmdMae = null;
        String syonoMae = "";
        syoriKensuu = 0;

        SrSibourituToukeiSeibigoRendouDbaStatement srSibourituToukeiSeibigoRendouDbaStatement = SWAKInjector
            .getInstance(SrSibourituToukeiSeibigoRendouDbaStatement.class);

        try (ExDBResults<SV_SibourituToukeiSeibigo> sibourituTukiSibgHznLst = srSibourituToukeiSeibigoRendouDbaStatement
            .getSibourituToukeiSeibigoInfo(srSibourituToukeiSeibigoRendouBatchParam.getTysyttaisyouYm().getFirstDay(),
                srSibourituToukeiSeibigoRendouBatchParam.getTysyttaisyouYm().getLastDay(), C_SyutkKbn.SYU);
            EntityInserter<ZT_SbRituToukeiSeibiRenTy> sbRituToukeiSeibiRenTyLst = new EntityInserter<>();) {

            for (SV_SibourituToukeiSeibigo svSibourituToukeiSeibigo : sibourituTukiSibgHznLst) {

                if (BizDateUtil.compareYmd(syoriYmdMae, svSibourituToukeiSeibigo.getSyoriYmd()) !=
                    BizDateUtil.COMPARE_EQUAL
                    || !syonoMae.equals(svSibourituToukeiSeibigo.getSyono())) {

                    srSibourituToukeiSeibigoRendouBatchParam.setKykmfksnctrNo(1);

                }
                else {

                    srSibourituToukeiSeibigoRendouBatchParam.setKykmfksnctrNo(
                        srSibourituToukeiSeibigoRendouBatchParam.getKykmfksnctrNo() + 1);

                }

                syoriYmdMae = svSibourituToukeiSeibigo.getSyoriYmd();
                syonoMae = svSibourituToukeiSeibigo.getSyono();

                insertData(svSibourituToukeiSeibigo, sbRituToukeiSeibiRenTyLst);

            }

        }

        if (SrSibourituToukeiSeibigoRendouBatchParam.IBKAKUTYOUJOBCD.equals(
            srSibourituToukeiSeibigoRendouBatchParam.getIbKakutyoujobcd())
            && srSibourituToukeiSeibigoRendouBatchParam.getErrorSyoriKensuu() != 0) {

            throw new BizAppException(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(srSibourituToukeiSeibigoRendouBatchParam.getErrorSyoriKensuu()));

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "死亡率統計整備後連動Fテーブル（中）",
            String.valueOf(syoriKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(srSibourituToukeiSeibigoRendouBatchParam.getErrorSyoriKensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル（警告）",
            String.valueOf(srSibourituToukeiSeibigoRendouBatchParam.getKeikokuSyoriCount())));
    }

    private void insertData(SV_SibourituToukeiSeibigo pSvSibourituToukeiSeibigo,
        EntityInserter<ZT_SbRituToukeiSeibiRenTy> pSbRituToukeiSeibiRenTyLst) {


        C_SuuriIdoKbn suuriIdoKbn = setSuuriidouKbn(pSvSibourituToukeiSeibigo);



        if (C_SuuriIdoKbn.MUKOU.eq(suuriIdoKbn)) {

            batchLogger.warn(MessageUtil.getMessage(MessageId.WSA1001,
                "無効異動が出力されました。",
                pSvSibourituToukeiSeibigo.getSyono()));

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(srSibourituToukeiSeibigoRendouBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(srSibourituToukeiSeibigoRendouBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvSibourituToukeiSeibigo.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(MessageUtil.getMessage(MessageId.WSA1001,
                "無効異動が出力されました。",
                pSvSibourituToukeiSeibigo.getSyono()));

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            srSibourituToukeiSeibigoRendouBatchParam.setKeikokuSyoriCount(srSibourituToukeiSeibigoRendouBatchParam
                .getKeikokuSyoriCount() + 1);
        }


        SrSibourituToukeiSeibigoRendouDbaStatement srSibourituToukeiSeibigoRendouDbaStatement = SWAKInjector
            .getInstance(SrSibourituToukeiSeibigoRendouDbaStatement.class);

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = SWAKInjector
            .getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanMae = SWAKInjector
            .getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = srSibourituToukeiSeibigoRendouDbaStatement.getKeiyakuSyouhinInfo(
            pSvSibourituToukeiSeibigo.getSyono(), C_SyutkKbn.SYU);

        BizDate kykSonotaTkykkouryokuhasseiymd = null;

        if (C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn) || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn) || C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn)) {

            TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                pSvSibourituToukeiSeibigo.getSyono(),
                null,
                pSvSibourituToukeiSeibigo.getHenkousikibetukey(),
                kiykSyuhnDataLst);

            tkJitenKeiyakuSyouhinKijyunBeanAto = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

            tkJitenKeiyakuSyouhinKijyunBeanMae = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();

            kykSonotaTkykkouryokuhasseiymd = tkJitenKeiyakuSyouhinKijyunBeanAto.getKouryokuhasseiymd();
        }
        else {

            if (C_SuuriIdoKbn.MUKOU.eq(suuriIdoKbn)) {
                tkJitenKeiyakuSyouhinKijyunBeanAto = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    pSvSibourituToukeiSeibigo.getSyono(),
                    kiykSyuhnDataLst.get(0).getSknnkaisiymd(),
                    "",
                    kiykSyuhnDataLst)
                    .getTkJitenKeiyakuSyouhinKijyunBeanAto();
            }
            else {

                tkJitenKeiyakuSyouhinKijyunBeanAto = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    pSvSibourituToukeiSeibigo.getSyono(),
                    pSvSibourituToukeiSeibigo.getSyoriYmd(),
                    "",
                    kiykSyuhnDataLst)
                    .getTkJitenKeiyakuSyouhinKijyunBeanAto();
            }
        }

        int syohinZokusei = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBeanAto.getSyouhncd());


        if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn)) {

            SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);

            int hHhkNenreiAto = setHokenNenrei.exec(tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd(),
                tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknseiymd());

            String hHhkNenreiTsHjAto = "";

            if (hHhkNenreiAto != tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknnen()) {

                hHhkNenreiTsHjAto = SrCommonConstants.HYOUJI_ARI;
            }
            else {

                hHhkNenreiTsHjAto = SrCommonConstants.HYOUJI_NASI;
            }

            int hHhkNenreiMae = setHokenNenrei.exec(tkJitenKeiyakuSyouhinKijyunBeanMae.getKykymd(),
                tkJitenKeiyakuSyouhinKijyunBeanMae.getHhknseiymd());

            String hHhkNenreiTsHjMae = "";

            if (hHhkNenreiMae != tkJitenKeiyakuSyouhinKijyunBeanMae.getHhknnen()) {

                hHhkNenreiTsHjMae = SrCommonConstants.HYOUJI_ARI;
            }
            else {

                hHhkNenreiTsHjMae = SrCommonConstants.HYOUJI_NASI;
            }

            if (tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknnen().equals(tkJitenKeiyakuSyouhinKijyunBeanMae.getHhknnen())
                && tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknsei().eq(
                    tkJitenKeiyakuSyouhinKijyunBeanMae.getHhknsei())
                    && hHhkNenreiTsHjAto.equals(hHhkNenreiTsHjMae)) {

                return;
            }
        }
        else if (C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn)) {
            if (syohinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                return;
            }

            if (tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() != null
                && syohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                return;
            }
        }

        List<IT_KykSyouhnHnkmae> kykSyouhnHnkmaeLst = new ArrayList<>();

        if (C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn) || C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn)) {

            kykSyouhnHnkmaeLst = srSibourituToukeiSeibigoRendouDbaStatement
                .getKykSyouhnHnkmaes(pSvSibourituToukeiSeibigo.getSyono());
        }
        else {
            if (tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() == null
                || syohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR
                || syohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ) {
                kykSyouhnHnkmaeLst = srSibourituToukeiSeibigoRendouDbaStatement
                    .getKykSyouhnHnkmaes(pSvSibourituToukeiSeibigo.getSyono());
            }
            else {
                kykSyouhnHnkmaeLst = null;
            }
        }


        SrSibourituToukeiSeibigoRendouItemEditor srSibourituToukeiSeibigoRendouItemEditor = SWAKInjector
            .getInstance(SrSibourituToukeiSeibigoRendouItemEditor.class);

        boolean errorFlag = false;

        ZT_SbRituToukeiSeibiRenTy sbRituToukeiSeibiRenTyGensyou = new ZT_SbRituToukeiSeibiRenTy();
        ZT_SbRituToukeiSeibiRenTy sbRituToukeiSeibiRenTyZouka = new ZT_SbRituToukeiSeibiRenTy();

        if (C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn) || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn) || C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn)) {

            setProductInfoDetails(tkJitenKeiyakuSyouhinKijyunBeanMae, tkJitenKeiyakuSyouhinKijyunBeanAto, suuriIdoKbn);

            errorFlag = srSibourituToukeiSeibigoRendouItemEditor.editKoumoku(
                srSibourituToukeiSeibigoRendouBatchParam,
                pSvSibourituToukeiSeibigo,
                tkJitenKeiyakuSyouhinKijyunBeanMae,
                suuriIdoKbn,
                SrCommonConstants.SIBOURITURECSITEI_MINUSREC,
                sbRituToukeiSeibiRenTyGensyou,
                syohinZokusei,
                kykSonotaTkykkouryokuhasseiymd,
                kiykSyuhnDataLst,
                kykSyouhnHnkmaeLst);

            errorFlag = srSibourituToukeiSeibigoRendouItemEditor.editKoumoku(
                srSibourituToukeiSeibigoRendouBatchParam,
                pSvSibourituToukeiSeibigo,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                suuriIdoKbn,
                SrCommonConstants.SIBOURITURECSITEI_PLUSREC,
                sbRituToukeiSeibiRenTyZouka,
                syohinZokusei,
                null,
                null,
                kykSyouhnHnkmaeLst);
        }
        else {
            errorFlag = srSibourituToukeiSeibigoRendouItemEditor.editKoumoku(
                srSibourituToukeiSeibigoRendouBatchParam,
                pSvSibourituToukeiSeibigo,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                suuriIdoKbn,
                SrCommonConstants.SIBOURITURECSITEI_MINUSREC,
                sbRituToukeiSeibiRenTyGensyou,
                syohinZokusei,
                null,
                kiykSyuhnDataLst,
                kykSyouhnHnkmaeLst);
        }


        if (!errorFlag) {

            if (C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn) || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn) ||
                C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn) || C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn)) {

                BizPropertyInitializer.initialize(sbRituToukeiSeibiRenTyGensyou);

                SrSibourituToukeiSeibigoRendouConverter.convertPadding(sbRituToukeiSeibiRenTyGensyou);

                pSbRituToukeiSeibiRenTyLst.add(sbRituToukeiSeibiRenTyGensyou);
                syoriKensuu = syoriKensuu + 1;

                BizPropertyInitializer.initialize(sbRituToukeiSeibiRenTyZouka);

                SrSibourituToukeiSeibigoRendouConverter.convertPadding(sbRituToukeiSeibiRenTyZouka);

                pSbRituToukeiSeibiRenTyLst.add(sbRituToukeiSeibiRenTyZouka);
                syoriKensuu = syoriKensuu + 1;

            }
            else {

                BizPropertyInitializer.initialize(sbRituToukeiSeibiRenTyGensyou);

                SrSibourituToukeiSeibigoRendouConverter.convertPadding(sbRituToukeiSeibiRenTyGensyou);

                pSbRituToukeiSeibiRenTyLst.add(sbRituToukeiSeibiRenTyGensyou);
                syoriKensuu = syoriKensuu + 1;

            }
        }
        else {

            return;
        }
    }

    private C_SuuriIdoKbn setSuuriidouKbn(SV_SibourituToukeiSeibigo pSibourituToukeiSeibigo) {

        C_SuuriIdoKbn suuriIdoKbn = null;

        if (C_Syoumetujiyuu.KAIYAKU.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.KAIYAKU;
        }
        if (C_Syoumetujiyuu.KYKTORIKESI.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.KYKTORIKESI;
        }
        if (C_Syoumetujiyuu.CLGOFF.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.CLGOFF;
        }
        if (C_Syoumetujiyuu.KAIJO.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.KAIJO;
        }
        if (C_Syoumetujiyuu.MUKOU.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.MUKOU;
        }
        if (C_Syoumetujiyuu.SIBOU.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())
            || C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())
            || C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())
            || C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.SIBOU;
        }
        if (C_Syoumetujiyuu.SBKAIJO.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.SBKAIJO;
        }
        if (C_Syoumetujiyuu.MENSEKI.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.MENSEKI;
        }
        if (C_Syoumetujiyuu.SBMUKOU.eq(pSibourituToukeiSeibigo.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.SBMUKOU;
        }

        if (!StringUtil.isNullOrBlank(pSibourituToukeiSeibigo.getGyoumuKousinKinou())
            && IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pSibourituToukeiSeibigo.getGyoumuKousinKinou())) {

            suuriIdoKbn = C_SuuriIdoKbn.PMINYUUSYOUMETU;
        }

        if (!StringUtil.isNullOrBlank(pSibourituToukeiSeibigo.getGyoumuKousinKinou())
            && IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pSibourituToukeiSeibigo.getGyoumuKousinKinou())) {

            suuriIdoKbn = C_SuuriIdoKbn.SINENGAPPISEITEISEI;
        }
        if (!StringUtil.isNullOrBlank(pSibourituToukeiSeibigo.getGyoumuKousinKinou())
            && IKhozenCommonConstants.KINOUID_GENGAKU.equals(pSibourituToukeiSeibigo.getGyoumuKousinKinou())) {

            suuriIdoKbn = C_SuuriIdoKbn.GENGAKU;
        }
        if (!StringUtil.isNullOrBlank(pSibourituToukeiSeibigo.getGyoumuKousinKinou())
            && IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(pSibourituToukeiSeibigo.getGyoumuKousinKinou())) {

            suuriIdoKbn = C_SuuriIdoKbn.YENDTHENKOU;
        }
        if (!StringUtil.isNullOrBlank(pSibourituToukeiSeibigo.getGyoumuKousinKinou()) &&
            IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(
                pSibourituToukeiSeibigo.getGyoumuKousinKinou())
                && C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI.eq(pSibourituToukeiSeibigo.getSyorikbn())) {

            suuriIdoKbn = C_SuuriIdoKbn.YENDTHENKOUTRKS;
        }

        return suuriIdoKbn;
    }

    private void setProductInfoDetails(
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBeanMae,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBeanAto,
        C_SuuriIdoKbn pSuuriIdoKbn) {

        if (C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn)) {
            pTkJitenKeiyakuSyouhinKijyunBeanMae.setKouryokuhasseiymd(
                pTkJitenKeiyakuSyouhinKijyunBeanAto.getKouryokuhasseiymd());
        }
        else if (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {
            pTkJitenKeiyakuSyouhinKijyunBeanAto.setKouryokuhasseiymd(
                pTkJitenKeiyakuSyouhinKijyunBeanMae.getKouryokuhasseiymd());
        }

    }
}
