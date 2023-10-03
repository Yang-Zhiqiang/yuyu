package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 数理 数理統計 月間変更処理収入Ｐ統計情報作成
 */
public class SrGkknHnkuSyrSyunyupTuki implements Batch {

    private static final String MSGTABLENM1 = "数理用エラー情報テーブル";

    private static final String MSGTABLENM2 = "月間変更処理収入Ｐ統計Fテーブル（中）";

    private static final String MSGTABLENM3 = "収入Ｐ統計当月処理中継用保存テーブル";

    private static final String SYORIYM_201905 = "201905";

    private static final String DENSIMEYMD_20190410 = "20190410";

    @Inject
    private SrGkknHnkuSyrSyunyupTukiBatchParam srGkknHnkuSyrSyunyupTukiBatchParam;

    @Inject
    private BatchLogger batchLogger;

    private int insertCount = 0;

    private int itTableCount = 0;

    @Override
    public BatchParam getParam() {
        return srGkknHnkuSyrSyunyupTukiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srGkknHnkuSyrSyunyupTukiBatchParam.setParam();

        SrGkknHnkuSyrSyunyupTukiDbaStatement dbaStatement =
            SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDbaStatement.class);

        EntityInserter<ZT_GkknHnkuSyrSynypTukiTy> gkknHnkuSyrSynypTukiTyList = new EntityInserter<>();

        EntityInserter<ST_SynypTukiTugtTykiyuHozon> synypTukiTugtTykiyuHozonList = new EntityInserter<>();

        BT_DenpyoData denpyoDataGroup = null;

        try (

            ExDBResults<BT_DenpyoData> denpyoDataList = dbaStatement.getDenpyoDatasHnkuNyukinPBySyoriYmd(
                srGkknHnkuSyrSyunyupTukiBatchParam.getTysytstsyFromYmd(),
                srGkknHnkuSyrSyunyupTukiBatchParam.getTysytstsyToYmd())
            ) {

            Iterator<BT_DenpyoData> hjyblistIter = denpyoDataList.iterator();

            BT_DenpyoData denpyoData = denpyodataTableNextRecord(hjyblistIter);

            C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

            String denKeyNew = "";

            if (denpyoData != null) {

                errorKbn = C_ErrorKbn.OK;

                denKeyNew = denpyoData.getDensyskbn() + denpyoData.getDenrenno();
            }

            while (C_ErrorKbn.OK.eq(errorKbn)) {

                denpyoDataGroup = denpyoData;

                List<IT_KykSyouhn> kykSyouhnList = dbaStatement.getKykSyouhns(
                    denpyoDataGroup.getKeirisyono(),
                    C_SyutkKbn.SYU);

                String syouhncd = kykSyouhnList.get(0).getSyouhncd();

                int syouhinUtilResult = SyouhinUtil.hantei(syouhncd);

                BizCurrency syonendosyokaip = BizCurrency.valueOf(0);

                BizCurrency syonendo2kaimeikoup = BizCurrency.valueOf(0);

                BizCurrency jinendoikoup = BizCurrency.valueOf(0);

                String denKeyOld = denKeyNew;

                do {

                    if (syouhinUtilResult != SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
                        syouhinUtilResult != SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                        syouhinUtilResult != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
                        syouhinUtilResult != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                        if (C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY.eq(denpyoData.getKanjyoukmkcd()) ||
                            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD.eq(denpyoData.getKanjyoukmkcd()) ||
                            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD.eq(denpyoData.getKanjyoukmkcd()) ||
                            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU.eq(denpyoData.getKanjyoukmkcd())) {

                            if (C_TaisyakuKbn.KARIKATA.eq(denpyoData.getTaisyakukbn())) {

                                BizCurrency dengkYen = denpyoData.getDenyenkagk();

                                syonendosyokaip = dengkYen.multiply(-1);
                            }
                            else {
                                syonendosyokaip = denpyoData.getDenyenkagk();
                            }
                        }
                        else if (C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY.eq(denpyoData.getKanjyoukmkcd()) ||
                            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD.eq(denpyoData.getKanjyoukmkcd()) ||
                            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD.eq(denpyoData.getKanjyoukmkcd()) ||
                            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU.eq(denpyoData.getKanjyoukmkcd())) {

                            if (C_TaisyakuKbn.KARIKATA.eq(denpyoData.getTaisyakukbn())) {

                                BizCurrency dengkYen = denpyoData.getDenyenkagk();

                                syonendo2kaimeikoup = dengkYen.multiply(-1);
                            }
                            else {
                                syonendo2kaimeikoup = denpyoData.getDenyenkagk();
                            }
                        }
                        else {

                            if (C_TaisyakuKbn.KARIKATA.eq(denpyoData.getTaisyakukbn())) {

                                BizCurrency dengkYen = denpyoData.getDenyenkagk();

                                jinendoikoup = dengkYen.multiply(-1);
                            }
                            else {
                                jinendoikoup = denpyoData.getDenyenkagk();
                            }
                        }
                    }

                    denpyoData = denpyodataTableNextRecord(hjyblistIter);

                    if (denpyoData != null) {

                        errorKbn = C_ErrorKbn.OK;

                        denKeyNew = denpyoData.getDensyskbn() + denpyoData.getDenrenno();
                    }
                    else {

                        errorKbn = C_ErrorKbn.ERROR;

                        denKeyNew = "";
                    }
                } while (C_ErrorKbn.OK.eq(errorKbn) && denKeyOld.equals(denKeyNew));

                if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                    syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 ||
                    syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                    editDataToInsertItijibr(
                        denpyoDataGroup,
                        gkknHnkuSyrSynypTukiTyList);
                }
                else {

                    editDataToInsertHeijyun(
                        denpyoDataGroup,
                        null,
                        syonendosyokaip,
                        syonendo2kaimeikoup,
                        jinendoikoup,
                        SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU,
                        gkknHnkuSyrSynypTukiTyList,
                        synypTukiTugtTykiyuHozonList);
                }
            }
        }

        try (
            ExDBResults<IT_NyknJissekiRireki> nyknjissekirirekiList =
            dbaStatement.getNyknJissekiRirekisByNyksyoriymdNykkeiro(
                srGkknHnkuSyrSyunyupTukiBatchParam.getTysytstsyFromYmd(),
                srGkknHnkuSyrSyunyupTukiBatchParam.getTysytstsyToYmd(),
                C_Nykkeiro.ZENNOUJYUUTOU, SrCommonConstants.RENBAN_1);) {

            for (IT_NyknJissekiRireki nyknjissekirireki : nyknjissekirirekiList) {

                editDataToInsertHeijyun(
                    null,
                    nyknjissekirireki,
                    BizCurrency.valueOf(0),
                    BizCurrency.valueOf(0),
                    BizCurrency.valueOf(0),
                    SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU,
                    gkknHnkuSyrSynypTukiTyList,
                    synypTukiTugtTykiyuHozonList);
            }
        }


        if ((SrGkknHnkuSyrSyunyupTukiBatchParam.GKKNHNK_REIGETSU.equals(
            srGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd()) ||
            SrGkknHnkuSyrSyunyupTukiBatchParam.GKKNHNK_KESSANKIHONBAN.equals(
                srGkknHnkuSyrSyunyupTukiBatchParam.getIbKakutyoujobcd()))  &&
                srGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu() != 0) {
            throw new BizAppException(MessageId.ISA1001, MSGTABLENM1,
                String.valueOf(srGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu()));
        }


        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, MSGTABLENM2,
            String.valueOf(insertCount)));
        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, MSGTABLENM3,
            String.valueOf(itTableCount)));
        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, MSGTABLENM1,
            String.valueOf(srGkknHnkuSyrSyunyupTukiBatchParam.getErrorSyoriKensuu())));

    }

    private BT_DenpyoData denpyodataTableNextRecord(Iterator<BT_DenpyoData> pHjyblistIter) {

        SrGkknHnkuSyrSyunyupTukiDbaStatement dbaStatement =
            SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDbaStatement.class);

        BT_DenpyoData denpyoData = null;

        while (pHjyblistIter.hasNext()) {

            denpyoData = pHjyblistIter.next();

            if (BizDateUtil.compareYm(getParam().getSyoriYmd().getBizDateYM(), BizDateYM.valueOf(
                SYORIYM_201905)) == BizDateUtil.COMPARE_EQUAL) {

                if (BizDateUtil.compareYmd(denpyoData.getSyoriYmd(), BizDate.valueOf(
                    DENSIMEYMD_20190410)) == BizDateUtil.COMPARE_EQUAL ||
                    BizDateUtil.compareYmd(denpyoData.getSyoriYmd(), BizDate.valueOf(
                        DENSIMEYMD_20190410)) == BizDateUtil.COMPARE_LESSER) {

                    List<IT_KykSyouhn> kykSyouhnList = dbaStatement.getKykSyouhns(
                        denpyoData.getKeirisyono(),
                        C_SyutkKbn.SYU);

                    String syouhncd = kykSyouhnList.get(0).getSyouhncd();

                    int syouhinUtilResult = SyouhinUtil.hantei(syouhncd);

                    if (syouhinUtilResult == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        break;
                    }

                    continue;
                }
                break;
            }
            break;
        }

        return denpyoData;
    }

    private void editDataToInsertItijibr(
        BT_DenpyoData pDenpyoData,
        EntityInserter<ZT_GkknHnkuSyrSynypTukiTy> pGkknHnkuSyrSynypTukiTyList) {

        SrGkknHnkuSyrSyunyupTukiDbaStatement dbaStatement =
            SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDbaStatement.class);

        ZT_GkknHnkuSyrSynypTukiTy gkknHnkuSyrSynypTukiTy = new ZT_GkknHnkuSyrSynypTukiTy();

        IT_KhShrRireki khShrRireki = dbaStatement.getKhShrRireki(
            pDenpyoData.getKeirisyono(),
            pDenpyoData.getSyoriYmd(),
            pDenpyoData.getDenrenno());

        IT_KhTtdkRireki khTtdkRireki = dbaStatement.getKhTtdkRireki(
            khShrRireki.getSyono(),
            khShrRireki.getHenkousikibetukey());

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = dbaStatement.getNyknJissekiRireki(
            khShrRireki.getSyono());

        IT_NyknJissekiRireki nyknJissekiRireki = null;

        if ((nyknJissekiRirekiList != null) && (nyknJissekiRirekiList.size() > 0)) {
            nyknJissekiRireki = nyknJissekiRirekiList.get(0);
        }

        IT_KykDairiten kykDairiten = dbaStatement.getKykDairiten(
            khShrRireki.getSyono());

        IT_KykSonotaTkyk kykSonotaTkyk = dbaStatement.getKykSonotaTkyk(
            khShrRireki.getSyono());

        IT_KykSya kykSya = dbaStatement.getKykSya(
            khShrRireki.getSyono());

        IT_KykKihon kykKihon = dbaStatement.getKykKihon(
            khShrRireki.getSyono());


        List<SV_KiykSyuhnData> svkiykSyuhnDataList = dbaStatement.getKiykSyuhnData(
            khShrRireki.getSyono(),
            C_SyutkKbn.SYU );

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = srGetTokutejitenSyohnInfo.exec(
            C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
            khShrRireki.getSyono(),
            null,
            khShrRireki.getHenkousikibetukey(),
            svkiykSyuhnDataList
            ).getTkJitenKeiyakuSyouhinKijyunBeanAto();


        int syohinHanteiKbn = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());


        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = new IT_KhSisuurendoTmttkn();

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList = dbaStatement
                .getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(khShrRireki.getSyono(),
                    tkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            if (khSisuurendoTmttknList.size() > 0) {

                khSisuurendoTmttkn = khSisuurendoTmttknList.get(0);
            }
        }


        SrGkknHnkuSyrSyunyupTukiItemEditor srGkknHnkuSyrSyunyupTukiItemEditor =
            SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiItemEditor.class);

        boolean koumokuEditFlag = srGkknHnkuSyrSyunyupTukiItemEditor.editKoumokuItijibr(
            srGkknHnkuSyrSyunyupTukiBatchParam,
            pDenpyoData,
            khShrRireki,
            khTtdkRireki,
            nyknJissekiRireki,
            kykDairiten,
            kykSonotaTkyk,
            kykSya,
            kykKihon,
            tkJitenKeiyakuSyouhinKijyunBean,
            gkknHnkuSyrSynypTukiTy,
            syohinHanteiKbn,
            khSisuurendoTmttkn);

        if (!koumokuEditFlag) {
            BizPropertyInitializer.initialize(gkknHnkuSyrSynypTukiTy);

            SrGkknHnkuSyrSyunyupTukiConverter.convertPadding(gkknHnkuSyrSynypTukiTy);

            pGkknHnkuSyrSynypTukiTyList.add(gkknHnkuSyrSynypTukiTy);

            insertCount = insertCount + 1;
        }
    }

    private void editDataToInsertHeijyun(
        BT_DenpyoData pDenpyoData,
        IT_NyknJissekiRireki pNyknJissekiRireki,
        BizCurrency pSyonendosyokaip,
        BizCurrency pSyonendo2kaimeikoup,
        BizCurrency pJinendoikoup,
        int pSynypinfo,
        EntityInserter<ZT_GkknHnkuSyrSynypTukiTy> pGkknHnkuSyrSynypTukiTyList,
        EntityInserter<ST_SynypTukiTugtTykiyuHozon> pSynypTukiTugtTykiyuHozon) {

        IT_KhShrRireki khShrRireki = new IT_KhShrRireki();

        IT_KhTtdkRireki khTtdkRireki = new IT_KhTtdkRireki();

        IT_KihrkmpSeisanRireki kihrknpSeisanRireki = new IT_KihrkmpSeisanRireki();

        SrGkknHnkuSyrSyunyupTukiDbaStatement dbaStatement =
            SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDbaStatement.class);

        String syono = "";

        BizDate syoriYmd = null;

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

            syono = pDenpyoData.getKeirisyono();
            syoriYmd = pDenpyoData.getSyoriYmd();
        }
        else if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU) {

            syono = pNyknJissekiRireki.getSyono();
            syoriYmd = pNyknJissekiRireki.getNyksyoriymd();
        }

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

            if (SrCommonConstants.SYORICD_KEIYAKUTORIKESI.equals(pDenpyoData.getSyoricd()) ||
                SrCommonConstants.SYORICD_KAIYAKU.equals(pDenpyoData.getSyoricd()) ||
                SrCommonConstants.SYORICD_BATCHKAIYAKU.equals(pDenpyoData.getSyoricd()) ||
                SrCommonConstants.SYORICD_GENGAKU.equals(pDenpyoData.getSyoricd()) ||
                SrCommonConstants.SYORICD_HHKSEINENGAPPISEITEISEI.equals(pDenpyoData.getSyoricd())) {

                khShrRireki = dbaStatement.getKhShrRireki(
                    pDenpyoData.getKeirisyono(),
                    pDenpyoData.getSyoriYmd(),
                    pDenpyoData.getDenrenno());

                if(khShrRireki != null){

                    khTtdkRireki = dbaStatement.getKhTtdkRireki(
                        khShrRireki.getSyono(),
                        khShrRireki.getHenkousikibetukey());
                }
                else {

                    List<IT_KhTtdkRireki> khTtdkRirekiList = dbaStatement.getKhTtdkRirekis(
                        pDenpyoData.getKeirisyono(),
                        pDenpyoData.getSyoriYmd(),
                        IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

                    for(IT_KhTtdkRireki khTtdkRirekis : khTtdkRirekiList){
                        khTtdkRireki = khTtdkRirekis;

                        kihrknpSeisanRireki = dbaStatement.getKihrkmpSeisanRireki(
                            khTtdkRireki.getSyono(),
                            khTtdkRireki.getHenkousikibetukey(),
                            C_KiharaiPseisanNaiyouKbn.TUITYOUKIN);

                        if(kihrknpSeisanRireki != null){

                            break;
                        }
                    }

                }
            }
        }

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = dbaStatement.getNyknJissekiRireki(
            syono);

        IT_NyknJissekiRireki nyknJissekiRireki = null;

        if (nyknJissekiRirekiList != null && nyknJissekiRirekiList.size() > 0) {

            nyknJissekiRireki = nyknJissekiRirekiList.get(0);
        }

        IT_KykDairiten kykDairiten = dbaStatement.getKykDairiten(
            syono);

        IT_KykSonotaTkyk kykSonotaTkyk = dbaStatement.getKykSonotaTkyk(
            syono);

        IT_KykSya kykSya = dbaStatement.getKykSya(
            syono);

        IT_KykKihon kykKihon = dbaStatement.getKykKihon(
            syono);


        List<SV_KiykSyuhnData> svkiykSyuhnDataList = dbaStatement.getKiykSyuhnData(
            syono,
            C_SyutkKbn.SYU );

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
            SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU  &&
            (SrCommonConstants.SYORICD_GENGAKU.equals(pDenpyoData.getSyoricd()) ||
                SrCommonConstants.SYORICD_HHKSEINENGAPPISEITEISEI.equals(pDenpyoData.getSyoricd()))) {

            tkJitenKeiyakuSyouhinKijyunBean = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                syono,
                null,
                khTtdkRireki.getHenkousikibetukey(),
                svkiykSyuhnDataList
                ).getTkJitenKeiyakuSyouhinKijyunBeanAto();

        }
        else {

            tkJitenKeiyakuSyouhinKijyunBean = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                syono,
                syoriYmd,
                "",
                svkiykSyuhnDataList
                ).getTkJitenKeiyakuSyouhinKijyunBeanAto();
        }


        int syohinHanteiKbn = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

        IT_Zennou zennou = new IT_Zennou();

        if (C_Kykjyoutai.ZENNOU.eq(tkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            zennou = dbaStatement.getZennou(
                syono,
                tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getNextYear().getRekijyou(),
                1);
        }

        BizDateYM jyutouym = null;
        String jyutoukaisuuy = "";
        String jyutoukaisuum = "";
        String jyuutoukaisuu = "";
        BizNumber nyknjikwsrate = BizNumber.valueOf(0);
        BizDate nyknjikwsratetkyymd = null;
        Boolean nyknjikwsratehtnflg = false;

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

            if (SrCommonConstants.SYORICD_KEIYAKUTORIKESI.equals(pDenpyoData.getSyoricd()) ||
                SrCommonConstants.SYORICD_KAIYAKU.equals(pDenpyoData.getSyoricd()) ||
                SrCommonConstants.SYORICD_BATCHKAIYAKU.equals(pDenpyoData.getSyoricd()) ||
                SrCommonConstants.SYORICD_GENGAKU.equals(pDenpyoData.getSyoricd())) {

                if (C_SyoriKbn.KYKTORIKESI.eq(khTtdkRireki.getSyorikbn()) ||
                    C_SyoriKbn.CLGOFF.eq(khTtdkRireki.getSyorikbn()) ||
                    C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(khTtdkRireki.getSyorikbn())) {

                    IT_AnsyuKihon ansyuKihon = dbaStatement.getAnsyuKihon(pDenpyoData.getKeirisyono());

                    jyutouym = tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();

                    jyutoukaisuuy = "00";

                    jyutoukaisuum = Strings.padStart(String.valueOf(BizDateUtil.calcDifferenceMonths(
                        ansyuKihon.getJkipjytym(), tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM())), 2, '0');

                    jyuutoukaisuu = jyutoukaisuuy + jyutoukaisuum;

                }
                else {

                    IT_KihrkmpSeisanRireki ansyuKihon = dbaStatement.getKihrkmpSeisanRireki(
                        pDenpyoData.getKeirisyono(),
                        khShrRireki.getHenkousikibetukey(),
                        C_KiharaiPseisanNaiyouKbn.SEISANP);

                    jyutouym = ansyuKihon.getJyuutouym();

                    jyutoukaisuuy = Strings.padStart(String.valueOf(ansyuKihon.getSeijyutoukaisuuy()), 2, '0');

                    jyutoukaisuum = Strings.padStart(String.valueOf(ansyuKihon.getSeijyutoukaisuum()), 2, '0');

                    jyuutoukaisuu = jyutoukaisuuy + jyutoukaisuum;
                }
                if(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd())||
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd())){

                    nyknjikwsrate = pDenpyoData.getDenkawaserate();

                    if(pDenpyoData.getKakokawaserateshiteiflg()){
                        nyknjikwsratetkyymd = pDenpyoData.getKakokawaserateshiteiymd();
                    }
                    else{
                        nyknjikwsratetkyymd = pDenpyoData.getSyoriYmd();
                    }
                }
                else{
                    nyknjikwsrate = khShrRireki.getShrkwsrate();

                    nyknjikwsratetkyymd = khShrRireki.getShrkwsratekjnymd();

                    if (C_SyoriKbn.KYKTORIKESI.eq(khTtdkRireki.getSyorikbn()) ||
                        C_SyoriKbn.CLGOFF.eq(khTtdkRireki.getSyorikbn()) ||
                        C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(khTtdkRireki.getSyorikbn())) {

                        nyknjikwsratehtnflg = true;
                    }
                }
            }
            else if (SrCommonConstants.SYORICD_HHKSEINENGAPPISEITEISEI.equals(pDenpyoData.getSyoricd())){

                IT_AnsyuKihon ansyuKihon = dbaStatement.getAnsyuKihon(pDenpyoData.getKeirisyono());

                jyutouym = tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();

                jyutoukaisuuy = "00";

                jyutoukaisuum = Strings.padStart(String.valueOf(ansyuKihon.getJkipjytym().subtractMonths
                    (tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM())), 2, '0');

                jyuutoukaisuu = jyutoukaisuuy + jyutoukaisuum;

                if(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd())||
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd())){

                    nyknjikwsrate = pDenpyoData.getDenkawaserate();

                    if(pDenpyoData.getKakokawaserateshiteiflg()){
                        nyknjikwsratetkyymd = pDenpyoData.getKakokawaserateshiteiymd();
                    }
                    else{
                        nyknjikwsratetkyymd = pDenpyoData.getSyoriYmd();
                    }
                }
                else{
                    nyknjikwsrate = kihrknpSeisanRireki.getZeimukwsrate();

                    nyknjikwsratetkyymd = kihrknpSeisanRireki.getZeimukwsratekjnymd();
                }

            }
            else if (SrCommonConstants.SYORICD_SIBOUSATEI.equals(pDenpyoData.getSyoricd())) {

                JT_SiKekka siKekka = dbaStatement.getSiKekkaBySyono(pDenpyoData.getKeirisyono());

                jyutouym = siKekka.getJyuutouym();

                jyutoukaisuuy = Strings.padStart(String.valueOf(siKekka.getJyutoukaisuuy()), 2, '0');

                jyutoukaisuum = Strings.padStart(String.valueOf(siKekka.getJyutoukaisuum()), 2, '0');

                jyuutoukaisuu = jyutoukaisuuy + jyutoukaisuum;

                if(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd())||
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd())){

                    nyknjikwsrate = pDenpyoData.getDenkawaserate();

                    if(pDenpyoData.getKakokawaserateshiteiflg()){
                        nyknjikwsratetkyymd = pDenpyoData.getKakokawaserateshiteiymd();
                    }
                    else{
                        nyknjikwsratetkyymd = pDenpyoData.getSyoriYmd();
                    }
                }
                else{
                    List<JT_SkKihon> skKihonLst = dbaStatement.getSkKihons
                        (pDenpyoData.getKeirisyono(), C_SeikyuuSyubetu.SB);

                    JT_Sk sk = new JT_Sk();
                    for(JT_SkKihon skKihons : skKihonLst){
                        JT_SkKihon skKihon = skKihons;

                        List<JT_Sk> skLst = dbaStatement.getSks
                            (skKihon.getSkno(), pDenpyoData.getKeirisyono());

                        if(skLst != null && SrCommonConstants.DEFAULT_INT_ZERO != skLst.size()){

                            sk = skLst.get(0);

                            break;
                        }
                    }

                    if(C_TaisyakuKbn.KASIKATA.eq(pDenpyoData.getTaisyakukbn())){

                        nyknjikwsrate = sk.getGaikaknsnkwsrate();

                        nyknjikwsratetkyymd = sk.getGaikaknsnkwsratekjymd();
                    }
                    else{
                        nyknjikwsrate = sk.getShrkwsrate();

                        nyknjikwsratetkyymd = sk.getShrkwsratekjnymd();
                    }
                }
            }
            else {

                List<IT_NyknJissekiRireki> nyknJissekiRirekiImanykList = null;

                if (SrCommonConstants.SYORICD_NYUUKINTORIKESI.equals(pDenpyoData.getSyoricd())) {

                    nyknJissekiRirekiImanykList = dbaStatement.getNyknJissekiRirekisBySyonoNyktrksdenno(
                        pDenpyoData.getKeirisyono(),
                        pDenpyoData.getDenrenno());
                }
                else {

                    nyknJissekiRirekiImanykList = dbaStatement.getNyknJissekiRirekisBySyonoNnykdenno(
                        pDenpyoData.getKeirisyono(),
                        pDenpyoData.getDenrenno());
                }

                if (nyknJissekiRirekiImanykList != null && nyknJissekiRirekiImanykList.size() > 0) {

                    jyutouym = nyknJissekiRirekiImanykList.get(0).getJyutoustartym();

                    jyutoukaisuuy = "0";
                    jyutoukaisuum = "0";

                    for (IT_NyknJissekiRireki nyknJissekiRirekiImanyk : nyknJissekiRirekiImanykList) {

                        jyutoukaisuuy = String.valueOf(
                            Integer.valueOf(jyutoukaisuuy) + nyknJissekiRirekiImanyk.getJyutoukaisuuy());

                        jyutoukaisuum = String.valueOf(
                            Integer.valueOf(jyutoukaisuum) + nyknJissekiRirekiImanyk.getJyutoukaisuum());
                    }

                    if (C_Hrkkaisuu.NEN.eq(nyknJissekiRirekiImanykList.get(nyknJissekiRirekiImanykList.size() - 1).getHrkkaisuu())) {

                        jyutoukaisuum = String.valueOf((Integer.valueOf(jyutoukaisuum) + ((Integer.valueOf(jyutoukaisuuy) * SrCommonConstants.KIKAN_12M))));
                        jyutoukaisuuy = "0";
                    }

                    jyuutoukaisuu = Strings.padStart(jyutoukaisuuy, 2, '0') + Strings.padStart(jyutoukaisuum, 2, '0');

                    if(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd()) ||
                        C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd())||
                        C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD.eq(pDenpyoData.getKanjyoukmkcd())){

                        nyknjikwsrate = pDenpyoData.getDenkawaserate();

                        if(pDenpyoData.getKakokawaserateshiteiflg()){
                            nyknjikwsratetkyymd = pDenpyoData.getKakokawaserateshiteiymd();
                        }
                        else{
                            nyknjikwsratetkyymd = pDenpyoData.getSyoriYmd();
                        }
                    }
                    else if(syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                        C_Nykkeiro.HKNKIN.eq(nyknJissekiRirekiImanykList.get(nyknJissekiRirekiImanykList.size() - 1).getNykkeiro())){

                        List<JT_SkKihon> skKihonLst = dbaStatement.getSkKihons
                            (pDenpyoData.getKeirisyono(), C_SeikyuuSyubetu.SB);

                        JT_Sk sk = new JT_Sk();
                        for(JT_SkKihon skKihons : skKihonLst){
                            JT_SkKihon skKihon = skKihons;

                            List<JT_Sk> skLst = dbaStatement.getSks
                                (skKihon.getSkno(), pDenpyoData.getKeirisyono());

                            if(skLst != null && SrCommonConstants.DEFAULT_INT_ZERO != skLst.size()){

                                sk = skLst.get(0);

                                break;
                            }
                        }

                        if(C_TaisyakuKbn.KASIKATA.eq(pDenpyoData.getTaisyakukbn())){

                            nyknjikwsrate = sk.getGaikaknsnkwsrate();

                            nyknjikwsratetkyymd = sk.getGaikaknsnkwsratekjymd();
                        }
                        else{
                            nyknjikwsrate = sk.getShrkwsrate();

                            nyknjikwsratetkyymd = sk.getShrkwsratekjnymd();
                        }
                    }
                    else{
                        nyknjikwsrate = nyknJissekiRirekiImanykList.get(nyknJissekiRirekiImanykList.size() - 1).
                            getRyosyukwsrate();

                        nyknjikwsratetkyymd = nyknJissekiRirekiImanykList.get(nyknJissekiRirekiImanykList.size() - 1).
                            getRyosyukwsratekjymd();
                    }
                }
            }

            boolean hoseiflag;

            int jyuutouymJigyounendo = 0;

            int denymdJigyounendo = 0;

            if (C_TaisyakuKbn.KASIKATA.eq(pDenpyoData.getTaisyakukbn())) {

                hoseiflag = false;
            }
            else {
                if (C_Kykjyoutai.ZENNOU.eq(tkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

                    hoseiflag = false;
                }
                else {

                    if (SrCommonConstants.MONTH_APRIL <= jyutouym.getMonth()) {

                        jyuutouymJigyounendo = jyutouym.getYear();
                    }
                    else {
                        jyuutouymJigyounendo = jyutouym.getYear() - SrCommonConstants.YEAR_1Y;
                    }
                    if (SrCommonConstants.MONTH_APRIL <= pDenpyoData.getDenymd().getMonth()) {

                        denymdJigyounendo = pDenpyoData.getDenymd().getYear();
                    }
                    else {
                        denymdJigyounendo = pDenpyoData.getDenymd().getYear() - SrCommonConstants.YEAR_1Y;
                    }

                    if (jyuutouymJigyounendo < denymdJigyounendo) {

                        hoseiflag = true;
                    }
                    else {
                        hoseiflag = false;
                    }
                }
            }

            if (hoseiflag) {

                String hoseifJyuutouymy = String.valueOf(denymdJigyounendo);

                String hoseifJyuutouymm = Strings.padStart(String.valueOf(SrCommonConstants.MONTH_APRIL), 2, '0');

                String hoseifJyuutouym = hoseifJyuutouymy.concat(hoseifJyuutouymm);

                String hoseifjyutoukaisuuy = "00";

                int sonotaHrhsijyutoukaisuum = BizDateUtil.calcDifferenceMonths(BizDateYM.valueOf(hoseifJyuutouym), jyutouym);

                String hoseifjyutoukaisuum = Strings.padStart(
                    String.valueOf((Integer.valueOf(jyutoukaisuum) - sonotaHrhsijyutoukaisuum)), 2, '0');

                String hoseifjyutoukaisuu = hoseifjyutoukaisuuy.concat(hoseifjyutoukaisuum);

                jyutouym = BizDateYM.valueOf(hoseifJyuutouym);

                jyuutoukaisuu = hoseifjyutoukaisuu;
            }
        }
        else if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU) {

            jyutouym = pNyknJissekiRireki.getJyutoustartym();

            jyutoukaisuuy = String.valueOf(pNyknJissekiRireki.getJyutoukaisuuy());

            jyutoukaisuum = String.valueOf(pNyknJissekiRireki.getJyutoukaisuum());

            if (C_Hrkkaisuu.NEN.eq(pNyknJissekiRireki.getHrkkaisuu())) {

                jyutoukaisuum = String.valueOf((Integer.valueOf(jyutoukaisuum) + ((Integer.valueOf(jyutoukaisuuy) * SrCommonConstants.KIKAN_12M))));
                jyutoukaisuuy = "0";
            }

            jyuutoukaisuu = Strings.padStart(jyutoukaisuuy, 2, '0') + Strings.padStart(jyutoukaisuum, 2, '0');

            if(C_Tuukasyu.JPY.eq(nyknJissekiRireki.getRstuukasyu())){

                nyknjikwsrate = nyknJissekiRireki.getRyosyukwsrate();

                nyknjikwsratetkyymd = nyknJissekiRireki.getRyosyukwsratekjymd();
            }
            else{

                nyknjikwsrate = nyknJissekiRireki.getYenkansantkykwsrate();

                nyknjikwsratetkyymd = nyknJissekiRireki.getYenkansantkykwsrateymd();
            }
        }

        String busitucd = "";

        String syoricd = "";

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

            busitucd = pDenpyoData.getSyorisosikicd().substring(0, 3);

            syoricd = pDenpyoData.getSyoricd();
        }
        else if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU) {

            busitucd = dbaStatement.getTantouCd(C_TantouCdKbn.SOUKATU).getBusitucd();

            syoricd = dbaStatement.getKinou(pNyknJissekiRireki.getGyoumuKousinKinou()).getSyoricd();
        }

        boolean koumokuEditFlag = false;

        SrGkknHnkuSyrSyunyupTukiItemEditor srGkknHnkuSyrSyunyupTukiItemEditor =
            SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiItemEditor.class);

        boolean zennouOutputFlg = false;

        ZT_GkknHnkuSyrSynypTukiTy gkknHnkuSyrSynypTukiTyToukiP = new ZT_GkknHnkuSyrSynypTukiTy();

        ZT_GkknHnkuSyrSynypTukiTy gkknHnkuSyrSynypTukiTyZennouP = new ZT_GkknHnkuSyrSynypTukiTy();

        ST_SynypTukiTugtTykiyuHozon synypTukiTugtTykiyuHozon = new ST_SynypTukiTugtTykiyuHozon();

        ZT_GkknHnkuSyrSynypTukiTy gkknHnkuSyrSynypTukiTyznnjyuutou = new ZT_GkknHnkuSyrSynypTukiTy();

        if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

            if (C_Kykjyoutai.ZENNOU.eq(tkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()) &&
                (pSyonendosyokaip.compareTo(BizCurrency.valueOf(0, pSyonendosyokaip.getType())) != 0 ||
                pSyonendo2kaimeikoup.compareTo(BizCurrency.valueOf(0, pSyonendo2kaimeikoup.getType())) != 0)) {

                zennouOutputFlg = true;
            }

            BizCurrency jinendoikoup = BizCurrency.valueOf(0);

            if (!zennouOutputFlg) {

                jinendoikoup = pJinendoikoup;
            }

            koumokuEditFlag = srGkknHnkuSyrSyunyupTukiItemEditor.editKoumokuHeijyun(
                srGkknHnkuSyrSyunyupTukiBatchParam,
                pDenpyoData,
                null,
                nyknJissekiRireki,
                kykDairiten,
                kykSonotaTkyk,
                kykSya,
                kykKihon,
                tkJitenKeiyakuSyouhinKijyunBean,
                gkknHnkuSyrSynypTukiTyToukiP,
                synypTukiTugtTykiyuHozon,
                syohinHanteiKbn,
                pSyonendosyokaip,
                pSyonendo2kaimeikoup,
                jinendoikoup,
                jyutouym,
                jyuutoukaisuu,
                busitucd,
                syoricd,
                SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU,
                SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP,
                svkiykSyuhnDataList,
                zennou.getZennoujihrkp(),
                nyknjikwsrate,
                nyknjikwsratetkyymd,
                nyknjikwsratehtnflg);


            if (zennouOutputFlg) {

                jyutouym = tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().getNextYear();

                jyutoukaisuuy = Strings.padStart(zennou.getZennoukikan(), 2, '0');

                jyutoukaisuum = "00";

                jyuutoukaisuu = jyutoukaisuuy + jyutoukaisuum;

                koumokuEditFlag = srGkknHnkuSyrSyunyupTukiItemEditor.editKoumokuHeijyun(
                    srGkknHnkuSyrSyunyupTukiBatchParam,
                    pDenpyoData,
                    null,
                    nyknJissekiRireki,
                    kykDairiten,
                    kykSonotaTkyk,
                    kykSya,
                    kykKihon,
                    tkJitenKeiyakuSyouhinKijyunBean,
                    gkknHnkuSyrSynypTukiTyZennouP,
                    null,
                    syohinHanteiKbn,
                    BizCurrency.valueOf(0),
                    BizCurrency.valueOf(0),
                    pJinendoikoup,
                    jyutouym,
                    jyuutoukaisuu,
                    busitucd,
                    syoricd,
                    SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU,
                    SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_ZENNOUP,
                    svkiykSyuhnDataList,
                    zennou.getZennoujihrkp(),
                    nyknjikwsrate,
                    nyknjikwsratetkyymd,
                    nyknjikwsratehtnflg);
            }
        }
        else if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU) {

            koumokuEditFlag = srGkknHnkuSyrSyunyupTukiItemEditor.editKoumokuHeijyun(
                srGkknHnkuSyrSyunyupTukiBatchParam,
                null,
                pNyknJissekiRireki,
                nyknJissekiRireki,
                kykDairiten,
                kykSonotaTkyk,
                kykSya,
                kykKihon,
                tkJitenKeiyakuSyouhinKijyunBean,
                gkknHnkuSyrSynypTukiTyznnjyuutou,
                synypTukiTugtTykiyuHozon,
                syohinHanteiKbn,
                BizCurrency.valueOf(0),
                BizCurrency.valueOf(0),
                BizCurrency.valueOf(0),
                jyutouym,
                jyuutoukaisuu,
                busitucd,
                syoricd,
                SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU,
                0,
                svkiykSyuhnDataList,
                zennou.getZennoujihrkp(),
                nyknjikwsrate,
                nyknjikwsratetkyymd,
                nyknjikwsratehtnflg);
        }

        if (!koumokuEditFlag) {

            if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

                BizPropertyInitializer.initialize(gkknHnkuSyrSynypTukiTyToukiP);

                SrGkknHnkuSyrSyunyupTukiConverter.convertPadding(gkknHnkuSyrSynypTukiTyToukiP);

                pGkknHnkuSyrSynypTukiTyList.add(gkknHnkuSyrSynypTukiTyToukiP);
            }

            else if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_ZENNOUJYUTOU) {

                BizPropertyInitializer.initialize(gkknHnkuSyrSynypTukiTyznnjyuutou);

                SrGkknHnkuSyrSyunyupTukiConverter.convertPadding(gkknHnkuSyrSynypTukiTyznnjyuutou);

                pGkknHnkuSyrSynypTukiTyList.add(gkknHnkuSyrSynypTukiTyznnjyuutou);
            }

            if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                BizPropertyInitializer.initialize(synypTukiTugtTykiyuHozon);

                pSynypTukiTugtTykiyuHozon.add(synypTukiTugtTykiyuHozon);

                itTableCount = itTableCount + 1;
            }

            insertCount = insertCount + 1;

            if (pSynypinfo == SrCommonConstants.SYUUNYUUPTOUKEIJOUHOUKBN_DENNPYOU) {

                if (zennouOutputFlg) {

                    BizPropertyInitializer.initialize(gkknHnkuSyrSynypTukiTyZennouP);

                    SrGkknHnkuSyrSyunyupTukiConverter.convertPadding(gkknHnkuSyrSynypTukiTyZennouP);

                    pGkknHnkuSyrSynypTukiTyList.add(gkknHnkuSyrSynypTukiTyZennouP);

                    insertCount = insertCount + 1;
                }
            }
        }
    }
}