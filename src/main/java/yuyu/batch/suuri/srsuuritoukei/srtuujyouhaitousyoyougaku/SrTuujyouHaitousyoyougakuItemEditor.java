package yuyu.batch.suuri.srsuuritoukei.srtuujyouhaitousyoyougaku;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTokuyakuInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTokuyakuInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.srcommon.TuujyuHitusyyugkParam;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GetTaisyouSonotaTokuyakuKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SonotaTkTokuteiJitenKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import yuyu.def.suuri.configuration.YuyuSuuriConfig;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 通常配当所要額情報項目編集
 */
public class SrTuujyouHaitousyoyougakuItemEditor {

    private static final String MONTH_JANUARY_FIRSTDAY = "0101";

    private static final String MONTH_JANUARY_LASTDAY = "0131";

    private static final String MONTH_FEBRUARY_FIRSTDAY = "0201";

    private static final String MONTH_MARCH_LASTDAY = "0331";

    private static final String MONTH_APRIL_FIRSTDAY = "0401";

    private static final String MONTH_JUNE_LASTDAY = "0630";

    private static final String MONTH_JULY_FIRSTDAY = "0701";

    private static final String MONTH_SEPTEMBER_LASTDAY = "0930";

    private static final String MONTH_OCTOBER_FIRSTDAY = "1001";

    private static final String MONTH_NOVEMBER_LASTDAY = "1130";

    private static final String MONTH_DECEMBER_FIRSTDAY = "1201";

    private static final String MONTH_DECEMBER_LASTDAY = "1231";

    private static final String KEIYAKUOUBIKBNMAE = "2";

    private static final String KEIYAKUOUBIKBNGO = "1";

    private static final String BLANK = "";

    private static final String SIBOUS = "死亡Ｓ";

    private static final String SJKKKTYOUSEIYOURIRITU = "市場価格調整用利率";

    private boolean editKoumokuErrorFlg;

    BM_SyouhnZokusei bmSyouhnZokusei;

    @Inject
    private BatchLogger batchLogger;

    public SrTuujyouHaitousyoyougakuItemEditor() {
        editKoumokuErrorFlg = false;
    }

    public boolean editKoumoku(
        SrTuujyouHaitousyoyougakuBatchParam pSrTuujyouHaitousyoyougakuBatchParam,
        SV_TuujyuHitusyyugk pSvTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        TuujyuHitusyyugkParam pTuujyuHitusyyugkParam,
        int pSyohinHanteiKbn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList) {

        SrTuujyouHaitousyoyougakuDbaStatement srTuujyouHaitousyoyougakuDbaStatement =
            SWAKInjector.getInstance(SrTuujyouHaitousyoyougakuDbaStatement.class);

        bmSyouhnZokusei = srTuujyouHaitousyoyougakuDbaStatement.getSyouhnZokusei(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

        SrTuujyouHaitousyoyougakuBean srTuujyouHaitousyoyougakuBean = calcHaitouSyoyouGaku(
            pSrTuujyouHaitousyoyougakuBatchParam,
            pSvTuujyuHitusyyugk,
            pTkJitenKeiyakuSyouhinKijyunBean);

        setKayiyakuKoumoku(
            pSrTuujyouHaitousyoyougakuBatchParam,
            pSvTuujyuHitusyyugk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            srTuujyouHaitousyoyougakuBean,
            pTuujyuHitusyyugkParam,
            pSyohinHanteiKbn);

        setKayiyakuRayKoumoku(
            pSrTuujyouHaitousyoyougakuBatchParam,
            pSvTuujyuHitusyyugk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            srTuujyouHaitousyoyougakuBean,
            pTuujyuHitusyyugkParam,
            pSyohinHanteiKbn,
            pKiykSyuhnDataList);

        setHeadKoumoku(
            pSrTuujyouHaitousyoyougakuBatchParam,
            pTuujyuHitusyyugkParam);

        return editKoumokuErrorFlg;

    }

    private SrTuujyouHaitousyoyougakuBean calcHaitouSyoyouGaku(
        SrTuujyouHaitousyoyougakuBatchParam pSrTuujyouHaitousyoyougakuBatchParam,
        SV_TuujyuHitusyyugk pSvTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean) {

        SrTuujyouHaitousyoyougakuBean srTuujyouHaitousyoyougakuBean = SWAKInjector
            .getInstance(SrTuujyouHaitousyoyougakuBean.class);

        srTuujyouHaitousyoyougakuBean.setDgoukei(0L);
        srTuujyouHaitousyoyougakuBean.setSrankbetuhisad(0L);
        srTuujyouHaitousyoyougakuBean.setSyumtjsrankbetuhisad(0L);
        srTuujyouHaitousyoyougakuBean.setBairitubetuhisad(0L);
        srTuujyouHaitousyoyougakuBean.setSyumtjtikbairtbetuhisad(0L);
        srTuujyouHaitousyoyougakuBean.setSyukeiyakukihongoukeid(0L);
        srTuujyouHaitousyoyougakuBean.setSyukeiyakukihonsisad(0L);
        srTuujyouHaitousyoyougakuBean.setSyukeiyakukihonrisad(0L);
        srTuujyouHaitousyoyougakuBean.setSyukeiyakukihonramudad(0L);
        srTuujyouHaitousyoyougakuBean.setSyukeiyakukihonhisad(0L);
        srTuujyouHaitousyoyougakuBean.setSyukeiyakukihondtaisyous(0L);
        srTuujyouHaitousyoyougakuBean.setSyukeiyakukihondyouv(0L);
        srTuujyouHaitousyoyougakuBean.setSyukeiyakukihondkikens(0L);
        srTuujyouHaitousyoyougakuBean.setSykykkhnhisadtisyus(0L);
        srTuujyouHaitousyoyougakuBean.setTyoukikeizokutokubetud(0L);
        srTuujyouHaitousyoyougakuBean.setTyouseimaed(0L);
        srTuujyouHaitousyoyougakuBean.setTuutokuhituusand(0L);
        srTuujyouHaitousyoyougakuBean.setResultFlg(false);
        srTuujyouHaitousyoyougakuBean.setSisadrate(0L);
        srTuujyouHaitousyoyougakuBean.setRisadrate(0L);
        srTuujyouHaitousyoyougakuBean.setHisadrate(0L);
        srTuujyouHaitousyoyougakuBean.setDyouvrate(0L);
        srTuujyouHaitousyoyougakuBean.setKikensrate(0L);
        srTuujyouHaitousyoyougakuBean.setGoukeidrate(0L);

        return srTuujyouHaitousyoyougakuBean;
    }

    private void setKayiyakuKoumoku(
        SrTuujyouHaitousyoyougakuBatchParam pSrTuujyouHaitousyoyougakuBatchParam,
        SV_TuujyuHitusyyugk pSvTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SrTuujyouHaitousyoyougakuBean pSrTuujyouHaitousyoyougakuBean,
        TuujyuHitusyyugkParam pTuujyuHitusyyugkParam,
        int pSyohinHanteiKbn) {

//***2021/01/26 DEL-STR ビルドエラー回避対応 ↓
//        String kbnkeiriyousegmentkbn = bmSyouhnZokusei.getSeg1cd().toString().substring(0, 2);

//        String kbnkeiriyourgnbnskkbn = bmSyouhnZokusei.getSeg1cd().toString().substring(2);
//***2021/01/26 DEL-END ビルドエラー回避対応 ↑

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SYOKEIYAKU,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

        String suurisyuruicd = "";

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            batchLogger.warn(
                MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SYOKEIYAKU.getContent(),
                    pSvTuujyuHitusyyugk.getSyono(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd()));

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());

            suuriyouErrJyouhou.setKakutyoujobcd(pSrTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());

            suuriyouErrJyouhou.setSyono(pSvTuujyuHitusyyugk.getSyono());

            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(
                MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SYOKEIYAKU.getContent(),
                    pSvTuujyuHitusyyugk.getSyono(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd()));

            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrTuujyouHaitousyoyougakuBatchParam.setErrorSyorikensuu(
                pSrTuujyouHaitousyoyougakuBatchParam.getErrorSyorikensuu() + 1);

            editKoumokuErrorFlg = true;

        }
        else {

            suurisyuruicd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        Long goukeigyousekihyoujis = 0L;

        Long sykykgyusekihyjs = 0L;

        BizDate sibouSCalcKijyunYmd = null;

        BizNumber kaiyakuSjkkkTyouseiriRitu = BizNumber.valueOf(0);

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            goukeigyousekihyoujis = new Long(SrCommonConstants.DEFAULT_INT_ZERO);
        }
        else {
            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(pSrTuujyouHaitousyoyougakuBatchParam
                .getHaitousyoyougakukeisancd())) {

                if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_GREATER) {

                    sibouSCalcKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();

                }
                else {

                    sibouSCalcKijyunYmd = pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd();

                }
            }
            else {

                sibouSCalcKijyunYmd = pSrTuujyouHaitousyoyougakuBatchParam.getKeisanDnendoLastDay();
            }

            BizDate sijyouKakakuTyouseiyouRirituKijyunYmd = null;
            C_ErrorKbn errorKbn;

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
                BizDate paramKijyunYmd = pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
                String paramHaitousyoyougakukeisancd = pSrTuujyouHaitousyoyougakuBatchParam.getHaitousyoyougakukeisancd();
                BizDate beanKykYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
                BizDate paramSyoriYmd = pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd();
                if (BizDateUtil.compareYmd(sibouSCalcKijyunYmd, paramKijyunYmd) == BizDateUtil.COMPARE_GREATER ||
                    (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(paramHaitousyoyougakukeisancd) &&
                        BizDateUtil.compareYmd(beanKykYmd, paramKijyunYmd) == BizDateUtil.COMPARE_GREATER) ||
                        BizDateUtil.compareYmd(paramSyoriYmd, paramKijyunYmd) == BizDateUtil.COMPARE_LESSER) {

                    if (BizDateUtil.compareYmd(paramSyoriYmd, paramKijyunYmd) == BizDateUtil.COMPARE_LESSER) {
                        sijyouKakakuTyouseiyouRirituKijyunYmd = paramSyoriYmd;
                    } else {
                        sijyouKakakuTyouseiyouRirituKijyunYmd = paramKijyunYmd;
                    }
                }
                else {

                    sijyouKakakuTyouseiyouRirituKijyunYmd = sibouSCalcKijyunYmd;
                }

                GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector
                    .getInstance(GetSjkkktyouseiyouriritu.class);
                GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
                    SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

                getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                getSjkkktyouseiyourirituBean.setKijyunymd(sijyouKakakuTyouseiyouRirituKijyunYmd);
                getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    batchLogger.warn(MessageUtil.getMessage(MessageId.ESA1001, SJKKKTYOUSEIYOURIRITU,
                        pSvTuujyuHitusyyugk.getSyono()));

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());

                    suuriyouErrJyouhou.setKakutyoujobcd(pSrTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());

                    suuriyouErrJyouhou.setSyono(pSvTuujyuHitusyyugk.getSyono());

                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(MessageUtil.getMessage(MessageId.ESA1001,
                        SJKKKTYOUSEIYOURIRITU, pSvTuujyuHitusyyugk.getSyono()));

                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrTuujyouHaitousyoyougakuBatchParam.setErrorSyorikensuu(
                        pSrTuujyouHaitousyoyougakuBatchParam.getErrorSyorikensuu() + 1);

                    editKoumokuErrorFlg = true;

                }
                else {

                    kaiyakuSjkkkTyouseiriRitu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                }
            }

            CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTkJitenKeiyakuSyouhinKijyunBean
                .getKyktuukasyu());

            BizDateYM tmttkntaisyouYm = null;
            BizCurrency teiritutmttKngk = BizCurrency.valueOf(0, currencyType);
            BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(0, currencyType);
            BizNumber tumitateRiritu = BizNumber.valueOf(0);

//***2021/01/26 DEL-STR ビルドエラー回避対応 ↓
//            errorKbn = calcHkShrKngk.exec(
//                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu(),
//                pSvTuujyuHitusyyugk.getHrkkaisuu(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
//                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
//                sibouSCalcKijyunYmd,
//                null,
//                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
//                bmSyouhnZokusei.getDai1hknkkn(),
//                bmSyouhnZokusei.getMvatekikkn(),
//                C_SiinKbn.SP,
//                C_HokenkinsyuruiKbn.SBHOKENKIN,
//                pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
//                kaiyakuSjkkkTyouseiriRitu,
//                pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu(),
//                tmttkntaisyouYm,
//                teiritutmttKngk,
//                sisuurendoutmttKngk,
//                tumitateRiritu,
//                null,
//                null,
//                null,
//                null,
//                null,
//                null,
//                pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
//                null
//                );

//            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
//***2021/01/26 DEL-END ビルドエラー回避対応 ↑

                batchLogger.warn(
                    MessageUtil.getMessage(MessageId.ESA1001,
                        SIBOUS,
                        pSvTuujyuHitusyyugk.getSyono()));

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());

                suuriyouErrJyouhou.setKakutyoujobcd(pSrTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());

                suuriyouErrJyouhou.setSyono(pSvTuujyuHitusyyugk.getSyono());

                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(
                    MessageUtil.getMessage(MessageId.ESA1001,
                        SIBOUS,
                        pSvTuujyuHitusyyugk.getSyono()));

                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrTuujyouHaitousyoyougakuBatchParam.setErrorSyorikensuu(
                    pSrTuujyouHaitousyoyougakuBatchParam.getErrorSyorikensuu() + 1);

                editKoumokuErrorFlg = true;
//***2021/01/26 DEL-STR ビルドエラー回避対応 ↓
//            }
//            else {
//                goukeigyousekihyoujis = new Long(
//                    new BigDecimal(calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk().toAdsoluteString())
//                    .longValue());
//            }
//            sykykgyusekihyjs = new Long(
//                new BigDecimal(calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk().toAdsoluteString())
//                .longValue());
//***2021/01/26 DEL-END ビルドエラー回避対応 ↑
        }

        String datakanrino = pSvTuujyuHitusyyugk.getSyono();

        String errorkbn = BLANK;

        Long dgoukei = pSrTuujyouHaitousyoyougakuBean.getDgoukei();

        Long srankbetuhisad = pSrTuujyouHaitousyoyougakuBean.getSrankbetuhisad();

        Long syumtjsrankbetuhisad = pSrTuujyouHaitousyoyougakuBean.getSyumtjsrankbetuhisad();

        Long bairitubetuhisad = pSrTuujyouHaitousyoyougakuBean.getBairitubetuhisad();

        Long syumtjtikbairtbetuhisad = pSrTuujyouHaitousyoyougakuBean.getSyumtjtikbairtbetuhisad();

        Long syukeiyakukihongoukeid = pSrTuujyouHaitousyoyougakuBean.getSyukeiyakukihongoukeid();

        Long syukeiyakukihonsisad = pSrTuujyouHaitousyoyougakuBean.getSyukeiyakukihonsisad();

        Long syukeiyakukihonrisad = pSrTuujyouHaitousyoyougakuBean.getSyukeiyakukihonrisad();

        Long syukeiyakukihonramudad = pSrTuujyouHaitousyoyougakuBean.getSyukeiyakukihonramudad();

        Long syukeiyakukihonhisad = pSrTuujyouHaitousyoyougakuBean.getSyukeiyakukihonhisad();

        Long syukeiyakukihondtaisyous = pSrTuujyouHaitousyoyougakuBean.getSyukeiyakukihondtaisyous();

        Long syukeiyakukihondyouv = pSrTuujyouHaitousyoyougakuBean.getSyukeiyakukihondyouv();

        Long syukeiyakukihondkikens = pSrTuujyouHaitousyoyougakuBean.getSyukeiyakukihondkikens();

        Long sykykkhnhisadtisyus = pSrTuujyouHaitousyoyougakuBean.getSykykkhnhisadtisyus();

        Long tyoukikeizokutokubetud = pSrTuujyouHaitousyoyougakuBean.getTyoukikeizokutokubetud();

        Long tyouseimaed = pSrTuujyouHaitousyoyougakuBean.getTyouseimaed();

        Long tuutokuhituusand = pSrTuujyouHaitousyoyougakuBean.getTuutokuhituusand();

        String keiyakuoutoubikbn = null;

        if (BizDateMD.valueOf(MONTH_JUNE_LASTDAY).compareTo(
            pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getBizDateMD()) == 0) {

            if (BizDateMD.valueOf(MONTH_JANUARY_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_MARCH_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNMAE;

            }
            else if (BizDateMD.valueOf(MONTH_APRIL_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_JUNE_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNGO;
            }
            else if (BizDateMD.valueOf(MONTH_JULY_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_DECEMBER_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNMAE;
            }
        }
        else if (BizDateMD.valueOf(MONTH_SEPTEMBER_LASTDAY).compareTo(
            pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getBizDateMD()) == 0) {

            if (BizDateMD.valueOf(MONTH_JANUARY_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_MARCH_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNMAE;

            }
            else if (BizDateMD.valueOf(MONTH_APRIL_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_SEPTEMBER_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNGO;
            }
            else if (BizDateMD.valueOf(MONTH_OCTOBER_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_DECEMBER_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNMAE;
            }
        }
        else if (BizDateMD.valueOf(MONTH_NOVEMBER_LASTDAY).compareTo(
            pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getBizDateMD()) == 0) {

            if (BizDateMD.valueOf(MONTH_JANUARY_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_MARCH_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNMAE;

            }
            else if (BizDateMD.valueOf(MONTH_APRIL_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_NOVEMBER_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNGO;
            }
            else if (BizDateMD.valueOf(MONTH_DECEMBER_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_DECEMBER_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNMAE;
            }
        }
        else if (BizDateMD.valueOf(MONTH_DECEMBER_LASTDAY).compareTo(
            pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getBizDateMD()) == 0) {

            if (BizDateMD.valueOf(MONTH_JANUARY_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_MARCH_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNMAE;

            }
            else if (BizDateMD.valueOf(MONTH_APRIL_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_DECEMBER_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNGO;
            }
        }
        else if (BizDateMD.valueOf(MONTH_JANUARY_LASTDAY).compareTo(
            pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getBizDateMD()) == 0) {

            if (BizDateMD.valueOf(MONTH_JANUARY_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_JANUARY_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNGO;

            }
            else if (BizDateMD.valueOf(MONTH_FEBRUARY_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_MARCH_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNMAE;
            }
            else if (BizDateMD.valueOf(MONTH_APRIL_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_DECEMBER_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = KEIYAKUOUBIKBNGO;
            }
        }
        else if (BizDateMD.valueOf(MONTH_MARCH_LASTDAY).compareTo(
            pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd().getBizDateMD()) == 0) {
            if (BizDateMD.valueOf(MONTH_JANUARY_FIRSTDAY).compareTo(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD()) <= 0
                && pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD().compareTo(
                    BizDateMD.valueOf(MONTH_DECEMBER_LASTDAY)) <= 0) {

                keiyakuoutoubikbn = SrCommonConstants.DEFAULT_STRING_ZERO_1;

            }
        }

        BigDecimal daihyouyoteiriritu = new BigDecimal(0);

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            getYoteirirituBean.setKijyunymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setSknnkaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            getYoteirirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());

            C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "契約時予定利率",
                    pSvTuujyuHitusyyugk.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());

                suuriyouErrJyouhou.setKakutyoujobcd(pSrTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());

                suuriyouErrJyouhou.setSyono(pSvTuujyuHitusyyugk.getSyono());

                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrTuujyouHaitousyoyougakuBatchParam.setErrorSyorikensuu(
                    pSrTuujyouHaitousyoyougakuBatchParam.getErrorSyorikensuu() + 1);

                editKoumokuErrorFlg = true;
            }
            else {
                daihyouyoteiriritu = new BigDecimal(
                    getYoteiriritu.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100).toString());
            }
        }
        else {
            daihyouyoteiriritu = new BigDecimal(
                pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100).toString());
        }

        String suuriHaraikataKbn = "";

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            suuriHaraikataKbn = C_SuuriHaraikataKbn.ITIJI.getValue();
        }
        else {
            if (C_Hrkkeiro.HURIKAE.eq(pSvTuujyuHitusyyugk.getHrkkeiro())) {
                suuriHaraikataKbn = C_SuuriHaraikataKbn.TIZUKI.getValue();
            }
            else if (C_Hrkkeiro.KOUHURI.eq(pSvTuujyuHitusyyugk.getHrkkeiro())) {
                suuriHaraikataKbn = C_SuuriHaraikataKbn.BANKZUKI.getValue();
            }
            else if (C_Hrkkeiro.CREDIT.eq(pSvTuujyuHitusyyugk.getHrkkeiro())) {
                suuriHaraikataKbn = C_SuuriHaraikataKbn.CREDIT.getValue();
            }
        }

        String kykjyoutaiVal = "";

        srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.KYK_JYOUTAI, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.KYK_JYOUTAI.getContent(),
                pSvTuujyuHitusyyugk.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());

            suuriyouErrJyouhou.setKakutyoujobcd(pSrTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());

            suuriyouErrJyouhou.setSyono(pSvTuujyuHitusyyugk.getSyono());

            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrTuujyouHaitousyoyougakuBatchParam.setErrorSyorikensuu(
                pSrTuujyouHaitousyoyougakuBatchParam.getErrorSyorikensuu() + 1);

            editKoumokuErrorFlg = true;
        }
        else {
            kykjyoutaiVal = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        C_SuuriAnnaiFuyouRiyuuKbn suuriAnnaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU;
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            suuriAnnaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI;
        }

        String ztysaimnkkykhyj = "";
        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {

            ztysaimnkkykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            ztysaimnkkykhyj = SrCommonConstants.HYOUJI_NASI;
        }

        String hrkkaisuuVal = "";

        srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.HRK_KAISUU, pSvTuujyuHitusyyugk.getHrkkaisuu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pSvTuujyuHitusyyugk.getSyono(), pSvTuujyuHitusyyugk.getHrkkaisuu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());

            suuriyouErrJyouhou.setKakutyoujobcd(pSrTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());

            suuriyouErrJyouhou.setSyono(pSvTuujyuHitusyyugk.getSyono());

            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrTuujyouHaitousyoyougakuBatchParam.setErrorSyorikensuu(
                pSrTuujyouHaitousyoyougakuBatchParam.getErrorSyorikensuu() + 1);

            editKoumokuErrorFlg = true;
        }
        else {
            hrkkaisuuVal = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        Long kihons = 0L;
        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            kihons = new Long(SrCommonConstants.DEFAULT_INT_ZERO);
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getKihons() != null) {
                kihons = new Long(
                    new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString()).longValue());
            }
        }

        pTuujyuHitusyyugkParam.setZtyerrkbnv2(errorkbn);

        pTuujyuHitusyyugkParam.setZtyratekbn(pSrTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd());

        if (pSrTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo() != null) {
            pTuujyuHitusyyugkParam.setZtykeisandnendo(pSrTuujyouHaitousyoyougakuBatchParam.getKeisanDnendo()
                .toString());
        }

        if (pSrTuujyouHaitousyoyougakuBatchParam.getKeijyouym() != null) {
            pTuujyuHitusyyugkParam
            .setZtykeijyouym(pSrTuujyouHaitousyoyougakuBatchParam.getKeijyouym().toString());
        }

        pTuujyuHitusyyugkParam.setZtysyouinkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);

//***2021/01/26 DEL-STR ビルドエラー回避対応 ↓
//        pTuujyuHitusyyugkParam.setZtykbnkeiriyousegmentkbn(kbnkeiriyousegmentkbn);

//        pTuujyuHitusyyugkParam.setZtykbnkeiriyourgnbnskkbn(kbnkeiriyourgnbnskkbn);
//***2021/01/26 DEL-STR ビルドエラー回避対応 ↑

        pTuujyuHitusyyugkParam.setZtysyukeiyakusyuruicdv2(suurisyuruicd);

        pTuujyuHitusyyugkParam.setZtydaihyouyoteiriritu(BizNumber.valueOf(daihyouyoteiriritu));

        pTuujyuHitusyyugkParam.setZtyharaikatakbn(suuriHaraikataKbn);

        pTuujyuHitusyyugkParam.setZtykykjyoutai(kykjyoutaiVal);

        pTuujyuHitusyyugkParam.setZtygoukeigyousekihyoujis(goukeigyousekihyoujis);

        pTuujyuHitusyyugkParam.setZtysykykgyusekihyjs(sykykgyusekihyjs);

        pTuujyuHitusyyugkParam.setZtydatakanrino(datakanrino);

        pTuujyuHitusyyugkParam.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

        pTuujyuHitusyyugkParam.setZtyannaifuyouriyuukbn(suuriAnnaiFuyouRiyuuKbn.getValue());

        pTuujyuHitusyyugkParam.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd() != null) {
            pTuujyuHitusyyugkParam.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        }

        pTuujyuHitusyyugkParam.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen() != null) {
            pTuujyuHitusyyugkParam.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn() != null) {
            pTuujyuHitusyyugkParam.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
        }

        pTuujyuHitusyyugkParam.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());

        pTuujyuHitusyyugkParam.setZtysaimnkkykhyj(ztysaimnkkykhyj);

        pTuujyuHitusyyugkParam.setZtyhrkkaisuukbn(hrkkaisuuVal);

        pTuujyuHitusyyugkParam.setZtyannaikigetu(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()
            .getMonth()));

        pTuujyuHitusyyugkParam.setZtykihons(kihons);

        pTuujyuHitusyyugkParam.setZtydgoukei(dgoukei);

        pTuujyuHitusyyugkParam.setZtysrankbetuhisad(srankbetuhisad);

        pTuujyuHitusyyugkParam.setZtysyumtjsrankbetuhisad(syumtjsrankbetuhisad);

        pTuujyuHitusyyugkParam.setZtybairitubetuhisad(bairitubetuhisad);

        pTuujyuHitusyyugkParam.setZtysyumtjtikbairtbetuhisad(syumtjtikbairtbetuhisad);

        pTuujyuHitusyyugkParam.setZtysyukeiyakukihongoukeid(syukeiyakukihongoukeid);

        pTuujyuHitusyyugkParam.setZtysyukeiyakukihonsisad(syukeiyakukihonsisad);

        pTuujyuHitusyyugkParam.setZtysyukeiyakukihonrisad(syukeiyakukihonrisad);

        pTuujyuHitusyyugkParam.setZtysyukeiyakukihonramudad(syukeiyakukihonramudad);

        pTuujyuHitusyyugkParam.setZtysyukeiyakukihonhisad(syukeiyakukihonhisad);

        pTuujyuHitusyyugkParam.setZtysyukeiyakukihondtaisyous(syukeiyakukihondtaisyous);

        pTuujyuHitusyyugkParam.setZtysyukeiyakukihondyouv(syukeiyakukihondyouv);

        pTuujyuHitusyyugkParam.setZtysyukeiyakukihondkikens(syukeiyakukihondkikens);

        pTuujyuHitusyyugkParam.setZtysykykkhnhisadtisyus(sykykkhnhisadtisyus);

        pTuujyuHitusyyugkParam.setZtytyoukikeizokutokubetud(tyoukikeizokutokubetud);

        pTuujyuHitusyyugkParam.setZtytyouseimaed(tyouseimaed);

        pTuujyuHitusyyugkParam.setZtytuutokuhituusand(tuutokuhituusand);

        pTuujyuHitusyyugkParam.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean
            .getRyouritusdno());

        pTuujyuHitusyyugkParam.setZtykeiyakuoutoubikbn(keiyakuoutoubikbn);

        pTuujyuHitusyyugkParam.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);

        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x1(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);

        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x2(SrCommonConstants.HKNSYKGUYBI1X2_MANNENREIHOUSIKI);

        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x3(SrCommonConstants.HKNSYKGUYBI1X3_SINHOKENHOUTEKIYOU);

        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x4(SrCommonConstants.HKNSYKGUYBI1X4_SINTOKUJYOUTEKIYOU);

        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x1(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);

        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x2(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);

    }

    private void setKayiyakuRayKoumoku(
        SrTuujyouHaitousyoyougakuBatchParam pSrTuujyouHaitousyoyougakuBatchParam,
        SV_TuujyuHitusyyugk pSvTuujyuHitusyyugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SrTuujyouHaitousyoyougakuBean pSrTuujyouHaitousyoyougakuBean,
        TuujyuHitusyyugkParam pTuujyuHitusyyugkParam,
        int pSyohinHanteiKbn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList) {

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrTuujyouHaitousyoyougakuDbaStatement srTuujyouHaitousyoyougakuDbaStatement =
            SWAKInjector.getInstance(SrTuujyouHaitousyoyougakuDbaStatement.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        String gaikakbn = "";

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            batchLogger.warn(
                MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                    pSvTuujyuHitusyyugk.getSyono(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getContent()));

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());

            suuriyouErrJyouhou.setKakutyoujobcd(pSrTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());

            suuriyouErrJyouhou.setSyono(pSvTuujyuHitusyyugk.getSyono());

            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(
                MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                    pSvTuujyuHitusyyugk.getSyono(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getContent()));

            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrTuujyouHaitousyoyougakuBatchParam.setErrorSyorikensuu(
                pSrTuujyouHaitousyoyougakuBatchParam.getErrorSyorikensuu() + 1);

            editKoumokuErrorFlg = true;

        }
        else {

            gaikakbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        BizNumber kawaserate = null;

        BizDate kwsrateKjYmd = null;

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

        }
        else {
            BizDate kawaserateKijyunYmd;
            if (BizDateUtil.compareYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd(),
                pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {
                kawaserateKijyunYmd = pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd();
            } else {
                kawaserateKijyunYmd = pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd();
            }

            C_ErrorKbn errorKbn = getKawaseRate.exec(
                kawaserateKijyunYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                batchLogger.warn(
                    MessageUtil.getMessage(MessageId.ESA1004,
                        kawaserateKijyunYmd.toString(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                        C_Tuukasyu.JPY.getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.JISSEIRATE.getValue(),
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue()));

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrTuujyouHaitousyoyougakuBatchParam.getSyoriYmd());

                suuriyouErrJyouhou.setKakutyoujobcd(pSrTuujyouHaitousyoyougakuBatchParam.getIbKakutyoujobcd());

                suuriyouErrJyouhou.setSyono(pSvTuujyuHitusyyugk.getSyono());

                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(
                    MessageUtil.getMessage(MessageId.ESA1004,
                        pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd().toString(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                        C_Tuukasyu.JPY.getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.JISSEIRATE.getValue(),
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue()));

                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrTuujyouHaitousyoyougakuBatchParam.setErrorSyorikensuu(
                    pSrTuujyouHaitousyoyougakuBatchParam.getErrorSyorikensuu() + 1);

                editKoumokuErrorFlg = true;

            }
            else {

                kawaserate = getKawaseRate.getKawaserate();

                kwsrateKjYmd = getKawaseRate.getKwsrateKjYmd();
            }
        }

        BizCurrency yendtsaiteihosyousibous = BizCurrency.valueOf(0);

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            yendtsaiteihosyousibous = BizCurrency.valueOf(0);
        }
        else {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                yendtsaiteihosyousibous = BizCurrency.valueOf(0);
            }
            else {

                List<IT_KykSyouhnHnkmae> kykSyouhnHnkmae = srTuujyouHaitousyoyougakuDbaStatement
                    .getKykSyouhnHnkmae(pSvTuujyuHitusyyugk.getSyono());

                SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenTokuyakuInfo.class);
                SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo.exec(
                    C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK,
                    C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                    pSrTuujyouHaitousyoyougakuBatchParam.getKijyunymd(),
                    pSvTuujyuHitusyyugk.getSyono(),
                    null,
                    null,
                    null,
                    pKiykSyuhnDataList,
                    pSvTuujyuHitusyyugk.getYendthnkymd(),
                    kykSyouhnHnkmae,
                    pSvTuujyuHitusyyugk.getInitsbjiyensitihsytkhukaumu(),
                    pSvTuujyuHitusyyugk.getInitsbjiyenkasaiteihsygk(),
                    null,
                    null,
                    null,
                    null);
                yendtsaiteihosyousibous = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkMae();
            }

        }

        Long sisadrate = pSrTuujyouHaitousyoyougakuBean.getSisadrate();

        Long risadrate = pSrTuujyouHaitousyoyougakuBean.getRisadrate();

        Long hisadrate = pSrTuujyouHaitousyoyougakuBean.getHisadrate();

        Long dyouvrate = pSrTuujyouHaitousyoyougakuBean.getDyouvrate();

        Long kikensrate = pSrTuujyouHaitousyoyougakuBean.getKikensrate();

        Long goukeidrate = pSrTuujyouHaitousyoyougakuBean.getGoukeidrate();

        pTuujyuHitusyyugkParam.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pTuujyuHitusyyugkParam.setZtygaikakbn(gaikakbn);
        if (kawaserate != null) {
            pTuujyuHitusyyugkParam.setZtykawaserate(kawaserate);
        }
        if (kwsrateKjYmd != null) {
            pTuujyuHitusyyugkParam.setZtykawaseratetekiyouymd(kwsrateKjYmd.toString());
        }
        pTuujyuHitusyyugkParam.setZtyenkdtsbujsitihsyukngk(new BigDecimal(yendtsaiteihosyousibous
            .toAdsoluteString()).longValue());
        pTuujyuHitusyyugkParam.setZtysisadrate(BizNumber.valueOf(sisadrate));
        pTuujyuHitusyyugkParam.setZtyrisadrate(BizNumber.valueOf(risadrate));
        pTuujyuHitusyyugkParam.setZtyhisadrate(BizNumber.valueOf(hisadrate));
        pTuujyuHitusyyugkParam.setZtydyouvrate(BizNumber.valueOf(dyouvrate));
        pTuujyuHitusyyugkParam.setZtykikensrate(BizNumber.valueOf(kikensrate));
        pTuujyuHitusyyugkParam.setZtygoukeidrate(BizNumber.valueOf(goukeidrate));
    }

    private void setHeadKoumoku(
        SrTuujyouHaitousyoyougakuBatchParam pSrTuujyouHaitousyoyougakuBatchParam,
        TuujyuHitusyyugkParam pTuujyuHitusyyugkParam) {

        int seq = 0;

        String kbnkey = pSrTuujyouHaitousyoyougakuBatchParam.getHeisoukbn();

        if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(pSrTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd())) {

            seq = Integer.valueOf(pSrTuujyouHaitousyoyougakuBatchParam.getSyorikensuuNplusZero() +
                kbnkey.substring(kbnkey.length() - 1));

        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(pSrTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd())) {

            seq = Integer.valueOf(pSrTuujyouHaitousyoyougakuBatchParam.getSyorikensuuNplusOne() +
                kbnkey.substring(kbnkey.length() - 1));
        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(pSrTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd())) {

            seq = Integer.valueOf(pSrTuujyouHaitousyoyougakuBatchParam.getSyorikensuuNplusTwo() +
                kbnkey.substring(kbnkey.length() - 1));
        }
        else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(pSrTuujyouHaitousyoyougakuBatchParam
            .getHaitousyoyougakukeisancd())) {

            seq = Integer.valueOf(pSrTuujyouHaitousyoyougakuBatchParam.getSyorikensuuNminusZero() +
                kbnkey.substring(kbnkey.length() - 1));
        }
        else {

            seq = Integer.valueOf(pSrTuujyouHaitousyoyougakuBatchParam.getSyorikensuuNplusQuart() +
                kbnkey.substring(kbnkey.length() - 1));
        }

        Integer laoutPrul012 = YuyuSuuriConfig.getInstance().getPalprul012length();

        Integer laoutPrul013 = YuyuSuuriConfig.getInstance().getPalprul013length();

        Integer laoutPrul856 = YuyuSuuriConfig.getInstance().getPalprre856length();

        Integer laoutRdw = YuyuSuuriConfig.getInstance().getPalrdwarealength();

        Integer laoutLength = laoutRdw + laoutPrul012 + laoutPrul856
            + (laoutPrul013 * pTuujyuHitusyyugkParam.getZtytokuyakuhukasuu());

        String rdw = BLANK;

        pTuujyuHitusyyugkParam.setZtysequenceno(seq);

        pTuujyuHitusyyugkParam.setZtyyuukourecordlength(laoutLength);

        pTuujyuHitusyyugkParam.setZtyrdwarea(rdw);

    }
}