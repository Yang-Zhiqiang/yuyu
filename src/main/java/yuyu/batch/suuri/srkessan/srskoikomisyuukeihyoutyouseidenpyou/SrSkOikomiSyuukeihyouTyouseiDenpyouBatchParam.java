package yuyu.batch.suuri.srkessan.srskoikomisyuukeihyoutyouseidenpyou;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.suuri.srcommon.SrCommonConstants;

/**
 * 新契約追込集計表（調整伝票）作成バッチパラメータクラス
 */
@BatchScoped
public class SrSkOikomiSyuukeihyouTyouseiDenpyouBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private static final String D1SHNK = "第１四半期";

    private static final String HNK = "半期";

    private static final String D3SHNK = "第３四半期";

    private static final String NDMT = "決算期";

    private static final String NENDO = "年度";

    private String nendo;

    private String kessankiKanji;

    public SrSkOikomiSyuukeihyouTyouseiDenpyouBatchParam() {
    }

    public void setParam() {

        BizDateY ndDate = null;

        if (SrCommonConstants.MONTH_APRIL >= super.getSyoriYmd().getMonth()) {

            ndDate = super.getSyoriYmd().getBizDateY().getPreviousYear();
        }
        else {

            ndDate = super.getSyoriYmd().getBizDateY();
        }

        nendo = new BizDateFormat("yyyy", FillStyle.Blank).format(ndDate).concat(NENDO);


        if (SrCommonConstants.MONTH_JULY  == super.getSyoriYmd().getMonth()) {

            kessankiKanji = D1SHNK;
        }
        else if (SrCommonConstants.MONTH_OCTOBER  == super.getSyoriYmd().getMonth()) {

            kessankiKanji = HNK;
        }
        else if (SrCommonConstants.MONTH_JANUARY  == super.getSyoriYmd().getMonth()) {

            kessankiKanji = D3SHNK;
        }
        else if (SrCommonConstants.MONTH_APRIL  == super.getSyoriYmd().getMonth()) {

            kessankiKanji = NDMT;
        }
        else{

            kessankiKanji = "";
        }
    }

    public String getNendo() {
        return nendo;
    }

    public void setNendo(String pNendo) {
        nendo = pNendo;
    }

    public String getKessankiKanji() {
        return kessankiKanji;
    }

    public void setKessankiKanji(String pKessankiKanji) {
        kessankiKanji = pKessankiKanji;
    }
}
