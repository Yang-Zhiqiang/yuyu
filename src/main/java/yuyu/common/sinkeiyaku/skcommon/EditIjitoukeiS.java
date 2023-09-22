package yuyu.common.sinkeiyaku.skcommon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;

/**
 * 新契約 新契約共通 医事統計用Ｓ項目編集
 */
public class EditIjitoukeiS {

    private BizCurrency sibouS = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);

    private BizCurrency imustiyuS = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private final BizNumber maxYenImustiyuS = BizNumber.valueOf(new BigDecimal("9999999999999"));

    private final BizNumber maxGaikaImustiyuS = BizNumber.valueOf(new BigDecimal("99999999999.99"));

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public EditIjitoukeiS() {
        super();
    }

    public BizCurrency getSibouS() {
        return sibouS;
    }

    public BizCurrency getImustiyuS() {
        return imustiyuS;
    }

    public C_ErrorKbn sinkeiyakuEdit(HT_MosKihon pMosKihon, List<HT_MosSyouhn> pMosSyouhns) {

        logger.debug("▽ 新契約時編集処理 開始");

        if(pMosKihon == null || pMosSyouhns == null){
            logger.debug("△ 新契約時編集処理 終了");
            return C_ErrorKbn.ERROR;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType kykTuukaType = henkanTuuka.henkanTuukaKbnToType(pMosKihon.getKyktuukasyu());
        BizCurrency wkSibouSsyu = BizCurrency.valueOf(0, kykTuukaType);
        BizCurrency wkSibouStk = BizCurrency.valueOf(0, kykTuukaType);

        for(HT_MosSyouhn mosSyouhn : pMosSyouhns){

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            int syohinHanteiKbn = SyouhinUtil.hantei(mosSyouhn.getSyouhncd());

            if(syouhnZokusei.getHutuusbhsyumu().eq(C_UmuKbn.ARI)){
                if(mosSyouhn.getSyutkkbn().eq(C_SyutkKbn.SYU)){
                    wkSibouSsyu = wkSibouSsyu.add(mosSyouhn.getSeitoukihons());

                }else if(mosSyouhn.getSyutkkbn().eq(C_SyutkKbn.TK)){
                    wkSibouStk = wkSibouStk.add(mosSyouhn.getSeitoukihons());
                }

            }else if(syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                if(mosSyouhn.getSyutkkbn().eq(C_SyutkKbn.SYU)){
                    wkSibouSsyu = wkSibouSsyu.add(mosSyouhn.getSyutkp());
                }

            }else if(syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){
                if(mosSyouhn.getSyutkkbn().eq(C_SyutkKbn.SYU)){
                    CurrencyType hrkTuukaType = henkanTuuka.henkanTuukaKbnToType(pMosKihon.getHrktuukasyu());
                    wkSibouSsyu = pMosKihon.getPharaikomisougaku();
                    wkSibouStk = BizCurrency.valueOf(0, hrkTuukaType);
                }
            }

        }
        sibouS = wkSibouSsyu.add(wkSibouStk);

        logger.debug("△ 新契約時編集処理 終了");
        return C_ErrorKbn.OK;

    }


    public C_ErrorKbn idougoEdit(List<TkJitenKeiyakuSyouhinKijyunBean> pTkJitenKeiyakuSyouhinKijyunBeanList, BizDate pMosymd) {

        logger.debug("▽ 異動後編集処理 開始");

        if(pTkJitenKeiyakuSyouhinKijyunBeanList == null || pTkJitenKeiyakuSyouhinKijyunBeanList.size() == 0
            || pMosymd == null){
            logger.debug("△ 異動後編集処理 終了");
            return C_ErrorKbn.ERROR;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType kykTuukaType = henkanTuuka.henkanTuukaKbnToType(pTkJitenKeiyakuSyouhinKijyunBeanList.get(0).getKyktuukasyu());
        BizCurrency wkSibouSsyu = BizCurrency.valueOf(0, kykTuukaType);
        BizCurrency wkSibouStk = BizCurrency.valueOf(0, kykTuukaType);

        for(TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean : pTkJitenKeiyakuSyouhinKijyunBeanList){

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), tkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());
            int syohinHanteiKbn = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

            if(syouhnZokusei.getHutuusbhsyumu().eq(C_UmuKbn.ARI)){
                if(tkJitenKeiyakuSyouhinKijyunBean.getSyutkKbn().eq(C_SyutkKbn.SYU)){
                    wkSibouSsyu = wkSibouSsyu.add(tkJitenKeiyakuSyouhinKijyunBean.getKihons());

                }else if(tkJitenKeiyakuSyouhinKijyunBean.getSyutkKbn().eq(C_SyutkKbn.TK)){
                    wkSibouStk = wkSibouStk.add(tkJitenKeiyakuSyouhinKijyunBean.getKihons());
                }

            }else if(syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                if(tkJitenKeiyakuSyouhinKijyunBean.getSyutkKbn().eq(C_SyutkKbn.SYU)){
                    wkSibouSsyu = wkSibouSsyu.add(tkJitenKeiyakuSyouhinKijyunBean.getHokenryou());
                }

            }else if(syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){
                if(tkJitenKeiyakuSyouhinKijyunBean.getSyutkKbn().eq(C_SyutkKbn.SYU)){
                    wkSibouSsyu = tkJitenKeiyakuSyouhinKijyunBean.getPharaikomisougaku();
                    wkSibouStk = BizCurrency.valueOf(0, tkJitenKeiyakuSyouhinKijyunBean.getPharaikomisougaku().getType());
                }
            }

        }
        sibouS = wkSibouSsyu.add(wkSibouStk);

        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector
            .getInstance(GetKiteiCheckYenkansangk.class);
        sibouS = getKiteiCheckYenkansangk.exec(pMosymd, sibouS, henkanTuuka.henkanTuukaTypeToKbn(sibouS.getType()));

        sibouS = sibouS.round(-4, RoundingMode.HALF_UP).divide(10000);
        sibouS = BizCurrency.valueOf(new BigDecimal(sibouS.toString()), BizCurrencyTypes.MANYEN);

        logger.debug("△ 異動後編集処理 終了");
        return C_ErrorKbn.OK;

    }

    public C_ErrorKbn torikomiEdit(ZT_IjiToukeiIdouInfoTr pIjiToukeiIdouInfoTr, HT_IjitoukeiMeisai pIjitoukeiMeisai) {

        logger.debug("▽ 取込時編集処理 開始");

        if (pIjiToukeiIdouInfoTr == null || pIjitoukeiMeisai == null) {
            logger.debug("△ 取込時編集処理 終了");
            return C_ErrorKbn.ERROR;
        }

        BizNumber wkGaikaKansanRate = pIjitoukeiMeisai.getYenkansantkykwsrate();
        CurrencyType wkCurrencyType = pIjitoukeiMeisai.getImustiyusbus().getType();
        BizNumber wkKeisangoKingaku = BizNumber.valueOf(0);
        BizCurrency wkImustiyuS = BizCurrency.valueOf(0, wkCurrencyType);

        if (BizCurrencyTypes.YEN == wkCurrencyType) {
            wkKeisangoKingaku = BizNumber.valueOf(pIjiToukeiIdouInfoTr.getZtrimustiyusbus()).multiply(10000);

            if (wkKeisangoKingaku.compareTo(maxYenImustiyuS) > 0) {
                wkImustiyuS = BizCurrency.valueOf(new BigDecimal(maxYenImustiyuS.toString()), wkCurrencyType);
            }
            else {
                wkImustiyuS = BizCurrency.valueOf(new BigDecimal(wkKeisangoKingaku.toString()), wkCurrencyType);
            }
        }
        else {
            if (wkGaikaKansanRate == null || wkGaikaKansanRate.equals(BizNumber.valueOf(0))) {
                logger.debug("△ 取込時編集処理 終了");
                return C_ErrorKbn.ERROR;
            }

            wkKeisangoKingaku = BizNumber.valueOf(pIjiToukeiIdouInfoTr.getZtrimustiyusbus()).multiply(10000)
                .divide(wkGaikaKansanRate, 2, RoundingMode.HALF_UP);

            if (wkKeisangoKingaku.compareTo(maxGaikaImustiyuS) > 0) {
                wkImustiyuS = BizCurrency.valueOf(new BigDecimal(maxGaikaImustiyuS.toString()), wkCurrencyType);
            }
            else {
                wkImustiyuS = BizCurrency.valueOf(new BigDecimal(wkKeisangoKingaku.toString()), wkCurrencyType);
            }
        }

        imustiyuS = wkImustiyuS;

        logger.debug("△ 取込時編集処理 終了");
        return C_ErrorKbn.OK;

    }

}
