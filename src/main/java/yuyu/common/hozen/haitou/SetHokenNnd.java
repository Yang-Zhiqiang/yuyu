package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TykzentykgoKbn;

/**
 * 契約保全 契約保全共通 保険年度設定
 */
public class SetHokenNnd extends BaseDCommon {

    private static final String ERRORCODE001 = "001";

    private static final String ERRORCODE002 = "002";

    @Inject
    private static Logger logger;

    {
        regErrorInfo(ERRORCODE001, "入力値エラー", "必須の入力項目にnullが含まれる");
        regErrorInfo(ERRORCODE002, "入力値エラー", "基準日　＞　判定日");
    }

    public HokenNndBean exec(BizDate pKijyunymd, BizDate pHanteiymd) {

        logger.debug("▽ 保険年度設定 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        clear();

        try {
            if (checkInvalidInput(pKijyunymd, pHanteiymd)) {

                logger.debug("△ 保険年度設定 終了");

                return null;
            }

            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDate tykzenoutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, pKijyunymd, C_Hrkkaisuu.NEN, pHanteiymd);
            BizDate tykgooutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, pKijyunymd, C_Hrkkaisuu.NEN, tykzenoutouYmd);
            BizDateY hknNendo = setKessanNensibi.exec(tykzenoutouYmd).getBizDateY();

            HokenNndBean hokenNndBean = new HokenNndBean(hknNendo, tykzenoutouYmd, tykgooutouYmd);

            logger.debug("｜   保険年度         ＝  " + hokenNndBean.getHokenNnd());
            logger.debug("｜   保険年度開始日   ＝  " + hokenNndBean.getHokenNndStartymd());
            logger.debug("｜   保険年度終了日   ＝  " + hokenNndBean.getHokenNndEndymd());

            logger.debug("△ 保険年度設定 終了");

            return hokenNndBean;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    private boolean checkInvalidInput(BizDate pKijyunymd, BizDate pHanteiymd) {

        boolean checkResult = false;

        if (pKijyunymd == null || pHanteiymd == null) {

            logger.debug("｜   Error Input");
            logger.debug("｜   基準日 : " + pKijyunymd);
            logger.debug("｜   判定日 : " + pHanteiymd);

            setErrorInfo(ERRORCODE001);

            checkResult = true;
        }
        else if (BizDateUtil.compareYmd(pKijyunymd, pHanteiymd) == BizDateUtil.COMPARE_GREATER) {

            logger.debug("｜   Error Input");
            logger.debug("｜   基準日 : " + pKijyunymd);
            logger.debug("｜   判定日 : " + pHanteiymd);

            setErrorInfo(ERRORCODE002);

            checkResult = true;
        }
        return checkResult;
    }

    public class HokenNndBean {

        private BizDateY hokenNnd;

        private BizDate hokenNndStartymd;

        private BizDate hokenNndEndymd;

        protected HokenNndBean(BizDateY pHokenNnd, BizDate pHokenNndStartymd, BizDate pHokenNndEndymd) {
            hokenNnd = pHokenNnd;
            hokenNndStartymd = pHokenNndStartymd;
            hokenNndEndymd = pHokenNndEndymd;
        }

        public BizDateY getHokenNnd() {
            return hokenNnd;
        }

        public BizDate getHokenNndStartymd() {
            return hokenNndStartymd;
        }

        public BizDate getHokenNndEndymd() {
            return hokenNndEndymd;
        }
    }
}
