package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.haitou.BaseDCommon;
import yuyu.common.hozen.haitou.SetHokenNnd;
import yuyu.common.hozen.haitou.SetHokenNnd.HokenNndBean;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 配当 配当状態判定
 */
public class CheckDJyoutai extends BaseDCommon{

    @Inject
    private static Logger logger;

    {
        regErrorInfo("001", "入力値エラー", "必須の入力項目にnullが含まれる");
    }

    public CheckDJyoutai() {
        super();
    }

    public C_HaitoujyoutaiHanteiKbn execForHaitouJyoutaiHantei(
        BizDate pHanteikijyunymd,
        BizDate pKeiyakuymd,
        BizDate pEndataihenkoymd,
        BizDateY pHaitounendo) {

        logger.debug("▽ 配当状態判定 配当状態判定用メイン処理 開始");

        clear();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pHanteikijyunymd == null ||  pKeiyakuymd == null) {

                setErrorInfo("001");

                logger.debug("△ 配当状態判定 配当状態判定用メイン処理 終了");

                return null;
            }

            if (BizDateUtil.compareYmd(pHanteikijyunymd, pKeiyakuymd) == BizDateUtil.COMPARE_LESSER) {
                logger.debug("△ 配当状態判定 配当状態判定用メイン処理 終了");

                return C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI;
            }

            BizDate haitoushrkijyunymd = null;

            if (pEndataihenkoymd == null) {
                haitoushrkijyunymd = pKeiyakuymd;
            }
            else{
                haitoushrkijyunymd = pEndataihenkoymd;
            }

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDateY jigyouNendo = setKessanNensibi.exec(haitoushrkijyunymd).getBizDateY();

            SetHokenNnd setHokenNnd = getInjectInstance(SetHokenNnd.class);

            HokenNndBean hokenNndBean = setHokenNnd.exec(haitoushrkijyunymd, pHanteikijyunymd);

            if (hokenNndBean == null) {
                setErrorLink(setHokenNnd);

                logger.debug("△ 配当状態判定 配当状態判定用メイン処理 終了");

                return null;
            }

            BizDateY hanteiNendo = hokenNndBean.getHokenNnd();

            BizDateY lastHaitouNendo = null;
            if (pHaitounendo == null) {
                lastHaitouNendo = jigyouNendo;
            }
            else {
                lastHaitouNendo = pHaitounendo;
            }

            int haitouMibaraiNensuu = hanteiNendo.getYear() - lastHaitouNendo.getYear();

            C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn = C_HaitoujyoutaiHanteiKbn.BLNK;

            if (pEndataihenkoymd == null && hanteiNendo.compareTo(jigyouNendo) <= 0) {
                haitoujyoutaiHanteiKbn = C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI;
            }
            else {
                if (haitouMibaraiNensuu <= 0) {
                    haitoujyoutaiHanteiKbn = C_HaitoujyoutaiHanteiKbn.DHANEI_SUMI;
                }
                else if (haitouMibaraiNensuu == 1) {
                    haitoujyoutaiHanteiKbn = C_HaitoujyoutaiHanteiKbn.DHANEI_TIENNASI;
                }
                else if (haitouMibaraiNensuu == 2) {
                    haitoujyoutaiHanteiKbn = C_HaitoujyoutaiHanteiKbn.DHANEI_TIEN1;
                }
                else if (haitouMibaraiNensuu >= 3) {
                    haitoujyoutaiHanteiKbn = C_HaitoujyoutaiHanteiKbn.DHANEI_TIEN2;
                }
            }

            logger.debug("△ 配当状態判定 配当状態判定用メイン処理 終了");

            return haitoujyoutaiHanteiKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_UmuKbn execForMibaraiHaitouHantei(
        BizDate pHanteikijyunymd,
        BizDate pKeiyakuymd,
        BizDate pEndataihenkoymd,
        BizDateY pHaitounendo) {

        logger.debug("▽ 配当状態判定 未払配当判定用メイン処理 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn = execForHaitouJyoutaiHantei(
                pHanteikijyunymd, pKeiyakuymd, pEndataihenkoymd, pHaitounendo);

            C_UmuKbn umuKbn = null;

            if (C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI.eq(haitoujyoutaiHanteiKbn) ||
                C_HaitoujyoutaiHanteiKbn.DHANEI_SUMI.eq(haitoujyoutaiHanteiKbn)) {
                umuKbn =  C_UmuKbn.NONE;
            }
            else{
                umuKbn =  C_UmuKbn.ARI;
            }

            logger.debug("△ 配当状態判定 未払配当判定用メイン処理 終了");

            return umuKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }
}
