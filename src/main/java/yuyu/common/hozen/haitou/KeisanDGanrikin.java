package yuyu.common.hozen.haitou;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.common.hozen.haitou.SetHokenNnd.HokenNndBean;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;

/**
 * 契約保全 配当 配当元利金計算
 */
public class KeisanDGanrikin extends BaseDCommon {

    private BizCurrency dGanrikin;

    private BizCurrency ruigk;

    private List<BizNumber> haitouRirituList;

    private BizDate calckijyunfromymd;

    private BizDate calckijyuntoymd;

    @Inject
    private static Logger logger;

    {
        regErrorInfo("001", "整合性エラー", "引数より算出された計算基準日自とエンティティから算出した計算基準日が一致しません");
        regErrorInfo("002", "入力エラー", "必須の引数にnullが含まれます");
        regErrorInfo("003", "整合性エラー", "確定期間中に内定レコードを処理対象にしています");
        regErrorInfo("004", "入力エラー", "リストの件数が０件です");
    }

    public KeisanDGanrikin() {
        super();
    }

    public BizCurrency getDGanrikin() {
        return dGanrikin;
    }

    public BizCurrency getRuigk() {
        return ruigk;
    }

    public List<BizNumber> getHaitouRirituList() {
        return haitouRirituList;
    }

    public BizDate getCalckijyunfromymd() {
        return calckijyunfromymd;
    }

    public BizDate getCalckijyuntoymd() {
        return calckijyuntoymd;
    }

    public C_ErrorKbn exec(BizCurrency pRuigk, BizDate pCalckijyunfromymd, BizDate pCalckijyuntoymd) {

        logger.debug("▽ 配当元利金計算 メイン処理（項目指定）開始");

        init();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pRuigk == null || pCalckijyunfromymd == null || pCalckijyuntoymd == null) {

                setErrorInfo("002");
                logger.debug("△ 配当元利金計算 メイン処理（項目指定）終了");

                return C_ErrorKbn.ERROR;
            }

            BizCurrency rirituGk = BizCurrency.valueOf(0);
            BizNumber wkHaitouRiritu = BizNumber.valueOf(0);

            if (pRuigk.compareTo(BizCurrency.valueOf(0, pRuigk.getType())) <= 0) {
                rirituGk =  BizCurrency.valueOf(0);
            }
            else {
                GetDRiritu getDRiritu = getInjectInstance(GetDRiritu.class);

                if (C_ErrorKbn.ERROR.eq(getDRiritu.exec(pCalckijyunfromymd, pCalckijyuntoymd))) {

                    setErrorLink(getDRiritu);
                    logger.debug("△ 配当元利金計算 メイン処理（項目指定）終了");

                    return C_ErrorKbn.ERROR;
                }

                wkHaitouRiritu = getDRiritu.getDRiritu();

                rirituGk =  pRuigk.multiply(wkHaitouRiritu, 0, RoundingMode.DOWN);
            }

            dGanrikin = pRuigk.add(rirituGk);

            logger.debug("｜   配当元利金     ＝  " +  dGanrikin.toString());
            logger.debug("｜   累計額         ＝  " +  pRuigk.toString());
            logger.debug("｜   利息額         ＝  " +  rirituGk.toString());
            logger.debug("｜   配当利率       ＝  " +  wkHaitouRiritu.toString());

            List<BizNumber> wkHaitouRirituList = new ArrayList<BizNumber>();
            wkHaitouRirituList.add(wkHaitouRiritu);
            ruigk = pRuigk;
            haitouRirituList = wkHaitouRirituList;
            calckijyunfromymd = pCalckijyunfromymd;
            calckijyuntoymd = pCalckijyuntoymd;
            logger.debug("△ 配当元利金計算 メイン処理（項目指定）終了");

            return C_ErrorKbn.OK;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn execAllowOverAYear(BizCurrency pRuigk, List<DRateBean> pDRateBeanList) {

        logger.debug("▽ 配当元利金計算 メイン処理（項目指定_１年超過許容） 開始");

        init();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pRuigk == null || pDRateBeanList == null) {

                setErrorInfo("002");

                logger.debug("△ 配当元利金計算 メイン処理（項目指定_１年超過許容） 終了");

                return C_ErrorKbn.ERROR;
            }

            if (pDRateBeanList.size() == 0) {

                setErrorInfo("004");

                logger.debug("△ 配当元利金計算 メイン処理（項目指定_１年超過許容） 終了");

                return C_ErrorKbn.ERROR;
            }

            List<BizNumber> haitouRirituLst = new ArrayList<BizNumber>();

            BizCurrency calcEnKingaku = pRuigk;

            for (DRateBean dRateBean : pDRateBeanList) {

                List<HaitouKaisuuBean> haitouKaisuuBeanLst = dRateBean.getHaitouKaisuuBeanLst();

                if (haitouKaisuuBeanLst == null || haitouKaisuuBeanLst.size() == 0) {

                    setErrorInfo("004");

                    logger.debug("△ 配当元利金計算 メイン処理（項目指定_１年超過許容） 終了");

                    return C_ErrorKbn.ERROR;
                }

                C_ErrorKbn retErrorKbn = exec(calcEnKingaku, haitouKaisuuBeanLst.get(0).getKikanfrom(),
                    haitouKaisuuBeanLst.get(haitouKaisuuBeanLst.size() - 1).getKikanto());

                if (C_ErrorKbn.ERROR.eq(retErrorKbn)) {

                    logger.debug("△ 配当元利金計算 メイン処理（項目指定_１年超過許容） 終了");

                    return C_ErrorKbn.ERROR;
                }

                calcEnKingaku = getDGanrikin();

                haitouRirituLst.addAll(getHaitouRirituList());
            }

            int dRateBeanSize = pDRateBeanList.size();
            int haitouKaisuuBeanSize = pDRateBeanList.get(dRateBeanSize - 1).getHaitouKaisuuBeanLst().size();
            dGanrikin = getDGanrikin();
            haitouRirituList = haitouRirituLst;
            ruigk = pRuigk;
            calckijyunfromymd = pDRateBeanList.get(0).getHaitouKaisuuBeanLst().get(0).getKikanfrom();
            calckijyuntoymd = pDRateBeanList.get(dRateBeanSize - 1).getHaitouKaisuuBeanLst()
                .get(haitouKaisuuBeanSize - 1).getKikanto();

            logger.debug("｜   配当元利金     ＝  " +  dGanrikin.toString());
            logger.debug("｜   累計額         ＝  " +  ruigk.toString());
            logger.debug("｜   利息額         ＝  " +  dGanrikin.subtract(ruigk).toString());
            logger.debug("｜   配当利率       ＝  " +  haitouRirituList.toString());

            logger.debug("△ 配当元利金計算 メイン処理（項目指定_１年超過許容）終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn exec(IT_KhHaitouKanri pKhHaitouKanri, BizDate pCalckijyunymd, BizDate pKykymd,
        BizDate pYendthnkymd, BizDate pSyoriYmd, C_UmuKbn pKessanSiyouUmu) {

        logger.debug("▽ 配当元利金計算 メイン処理（配当管理TBLエンティティ指定）開始");

        init();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pKhHaitouKanri == null || pCalckijyunymd == null || pKykymd == null || pSyoriYmd == null) {

                setErrorInfo("002");
                logger.debug("△ 配当元利金計算 メイン処理（配当管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            SetDNnd setDNnd = getInjectInstance(SetDNnd.class);

            DRateBean dRateBean = setDNnd.exec(pKykymd, pYendthnkymd, pKhHaitouKanri, pCalckijyunymd);
            if (dRateBean == null) {
                setErrorLink(setDNnd);
                logger.debug("△ 配当元利金計算 メイン処理（配当管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            List<HaitouKaisuuBean> haitouKaisuuBeanLst = dRateBean.getHaitouKaisuuBeanLst();
            BizDate wkCalckijyunfromymd = null;
            BizDate wkCalckijyuntoymd = null;

            if (haitouKaisuuBeanLst.size() > 0) {
                wkCalckijyunfromymd = haitouKaisuuBeanLst.get(0).getKikanfrom();
                wkCalckijyuntoymd = haitouKaisuuBeanLst.get(haitouKaisuuBeanLst.size() - 1).getKikanto();
            }

            BizDate wkCalckijyunymd = null;
            if (pYendthnkymd != null) {
                wkCalckijyunymd = pYendthnkymd;
            }
            else {
                wkCalckijyunymd = pKykymd;
            }

            SetHokenNnd setHokenNnd = getInjectInstance(SetHokenNnd.class);
            HokenNndBean HokenNndBean = setHokenNnd.exec(wkCalckijyunymd, wkCalckijyunfromymd);
            if (HokenNndBean == null) {
                setErrorLink(setHokenNnd);
                logger.debug("△ 配当元利金計算 メイン処理（配当管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            BizDateY haitouNnd = HokenNndBean.getHokenNnd();
            if (haitouNnd.compareTo(pKhHaitouKanri.getHaitounendo()) != 0) {
                setErrorInfo("001");
                logger.debug("△ 配当元利金計算 メイン処理（配当管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            BizDate kessanYmd = setKessanNensibi.exec(pCalckijyunymd);

            BizDateY dratenendo = kessanYmd.getBizDateY();
            NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = getInjectInstance(NaiteiKakuteiRateHantei.class);

            if (C_ErrorKbn.ERROR.eq(naiteiKakuteiRateHantei.exec(pSyoriYmd, dratenendo, pKessanSiyouUmu))) {
                setErrorLink(naiteiKakuteiRateHantei);
                logger.debug("△ 配当元利金計算 メイン処理（配当管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

            if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
                if (C_NaiteiKakuteiKbn.NAITEI.eq(pKhHaitouKanri.getNaiteikakuteikbn())) {
                    setErrorInfo("003");
                    logger.debug("△ 配当元利金計算 メイン処理（配当管理TBLエンティティ指定）終了");

                    return C_ErrorKbn.ERROR;
                }
            }

            C_ErrorKbn retErrorKbn = exec(pKhHaitouKanri.getKariwariatedruigk(), wkCalckijyunfromymd, wkCalckijyuntoymd);

            logger.debug("△ 配当元利金計算 メイン処理（配当管理TBLエンティティ指定）終了");

            return retErrorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn exec(IT_KhTumitateDKanri pKhTumitateDKanri, BizDate pCalckijyunymd, BizDate pKykymd,
        BizDate pYendthnkymd, BizDate pSyoriYmd, C_UmuKbn pKessanSiyouUmu) {

        logger.debug("▽ 配当元利金計算 メイン処理（積立Ｄ管理TBLエンティティ指定）開始");

        init();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pKhTumitateDKanri == null || pCalckijyunymd == null || pKykymd == null || pSyoriYmd == null) {

                setErrorInfo("002");
                logger.debug("△ 配当元利金計算 メイン処理（積立Ｄ管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            SetDNnd setDNnd = getInjectInstance(SetDNnd.class);

            DRateBean dRateBean = setDNnd.exec(pKykymd, pYendthnkymd, pKhTumitateDKanri, pCalckijyunymd);
            if (dRateBean == null) {
                setErrorLink(setDNnd);
                logger.debug("△ 配当元利金計算 メイン処理（積立Ｄ管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            List<HaitouKaisuuBean> haitouKaisuuBeanLst = dRateBean.getHaitouKaisuuBeanLst();
            BizDate wkCalckijyunfromymd = null;
            BizDate wkCalckijyuntoymd = null;

            if (haitouKaisuuBeanLst.size() > 0) {
                wkCalckijyunfromymd = haitouKaisuuBeanLst.get(0).getKikanfrom();
                wkCalckijyuntoymd = haitouKaisuuBeanLst.get(haitouKaisuuBeanLst.size() - 1).getKikanto();
            }

            BizDate iTCalckijyunfromymdEnt = pKhTumitateDKanri.getTumitatedtumitateymd();
            if (iTCalckijyunfromymdEnt.compareTo(wkCalckijyunfromymd) != 0) {
                setErrorInfo("001");
                logger.debug("△ 配当元利金計算 メイン処理（積立Ｄ管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            BizDate kessanYmd = setKessanNensibi.exec(pCalckijyunymd);

            BizDateY dratenendo = kessanYmd.getBizDateY();
            NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = getInjectInstance(NaiteiKakuteiRateHantei.class);

            if (C_ErrorKbn.ERROR.eq(naiteiKakuteiRateHantei.exec(pSyoriYmd, dratenendo, pKessanSiyouUmu))) {
                setErrorLink(naiteiKakuteiRateHantei);
                logger.debug("△ 配当元利金計算 メイン処理（積立Ｄ管理TBLエンティティ指定）終了");

                return C_ErrorKbn.ERROR;
            }

            C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

            if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
                if (C_NaiteiKakuteiKbn.NAITEI.eq(pKhTumitateDKanri.getNaiteikakuteikbn())) {
                    setErrorInfo("003");
                    logger.debug("△ 配当元利金計算 メイン処理（積立Ｄ管理TBLエンティティ指定）終了");

                    return C_ErrorKbn.ERROR;
                }
            }

            C_ErrorKbn retErrorKbn = exec(pKhTumitateDKanri.getTumitated(), wkCalckijyunfromymd, wkCalckijyuntoymd);

            logger.debug("△ 配当元利金計算 メイン処理（積立Ｄ管理TBLエンティティ指定）終了");

            return retErrorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    private void init() {

        clear();
        dGanrikin = null;
        ruigk = null;
        haitouRirituList = null;
        calckijyunfromymd = null;
        calckijyuntoymd = null;
    }
}
