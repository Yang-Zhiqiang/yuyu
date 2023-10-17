package yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_NyknsyubetuKbn;

/**
 * 当日入金取消 - ●入金情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenNyuukinJyouhouListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dummykmk;

    public String getDummykmk() {
        return dummykmk;
    }

    public void setDummykmk(String pDummykmk) {
        dummykmk = pDummykmk;
    }


    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency rsgaku;

    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgaku(BizCurrency pRsgaku) {
        rsgaku = pRsgaku;
    }


    @ValidDate
    private BizDate tyakkinymd;

    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }


    private C_NyknsyubetuKbn nyknsyubetu;

    public C_NyknsyubetuKbn getNyknsyubetu() {
        return nyknsyubetu;
    }

    public void setNyknsyubetu(C_NyknsyubetuKbn pNyknsyubetu) {
        nyknsyubetu = pNyknsyubetu;
    }


    private String sentakulink;

    public String getSentakulink() {
        return sentakulink;
    }

    public void setSentakulink(String pSentakulink) {
        sentakulink = pSentakulink;
    }

}
