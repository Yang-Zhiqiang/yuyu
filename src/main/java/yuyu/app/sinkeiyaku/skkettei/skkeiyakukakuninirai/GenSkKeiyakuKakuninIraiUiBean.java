package yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninirai;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 契約確認依頼入力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkKeiyakuKakuninIraiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
    }

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknnmkj;

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private C_Kykkaksyrui kykkaksyrui;

    public C_Kykkaksyrui getKykkaksyrui() {
        return kykkaksyrui;
    }

    public void setKykkaksyrui(C_Kykkaksyrui pKykkaksyrui) {
        kykkaksyrui = pKykkaksyrui;
    }

    @ValidDate
    private BizDate kykkakkanytymd;

    public BizDate getKykkakkanytymd() {
        return kykkakkanytymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykkakkanytymd(BizDate pKykkakkanytymd) {
        kykkakkanytymd = pKykkakkanytymd;
    }

    @ValidTextArea(length=50, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String kykkakcomment;

    public String getKykkakcomment() {
        return kykkakcomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykkakcomment(String pKykkakcomment) {
        kykkakcomment = pKykkakcomment;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }
}
