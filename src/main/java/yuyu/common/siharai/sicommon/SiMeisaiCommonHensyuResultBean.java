package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細編集結果Bean
 */
public class SiMeisaiCommonHensyuResultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tekiYou;

    private BizCurrency shrGkMeisai;

    private long rendouShrGkMeisai;

    private C_Tuukasyu rendouShrGkMeisaiTuukasyu;

    private Integer rendouShrknGkMeisaiHugou;

    private String detailBikou;

    public SiMeisaiCommonHensyuResultBean() {

        tekiYou = "";

        setShrGkMeisai(null);

        setRendouShrGkMeisai(0L);

        setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.BLNK);

        setRendouShrknGkMeisaiHugou(0);

        setDetailBikou("");
    }

    public String getTekiYou() {
        return tekiYou;
    }

    public void setTekiYou(String pTekiYou) {
        tekiYou = pTekiYou;
    }

    public BizCurrency getShrGkMeisai() {
        return shrGkMeisai;
    }

    public void setShrGkMeisai(BizCurrency pShrGkMeisai) {
        shrGkMeisai = pShrGkMeisai;
    }

    public long getRendouShrGkMeisai() {
        return rendouShrGkMeisai;
    }

    public void setRendouShrGkMeisai(long pRendouShrGkMeisai) {
        rendouShrGkMeisai = pRendouShrGkMeisai;
    }

    public C_Tuukasyu getRendouShrGkMeisaiTuukasyu() {
        return rendouShrGkMeisaiTuukasyu;
    }

    public void setRendouShrGkMeisaiTuukasyu(C_Tuukasyu pRendouShrGkMeisaiTuukasyu) {
        rendouShrGkMeisaiTuukasyu = pRendouShrGkMeisaiTuukasyu;
    }

    public Integer getRendouShrknGkMeisaiHugou() {
        return rendouShrknGkMeisaiHugou;
    }

    public void setRendouShrknGkMeisaiHugou(Integer pRendouShrknGkMeisaiHugou) {
        rendouShrknGkMeisaiHugou = pRendouShrknGkMeisaiHugou;
    }

    public String getDetailBikou() {
        return detailBikou;
    }

    public void setDetailBikou(String pDetailBikou) {
        detailBikou = pDetailBikou;
    }
}
