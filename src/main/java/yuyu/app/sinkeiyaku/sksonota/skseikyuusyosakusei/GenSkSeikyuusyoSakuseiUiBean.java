package yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_SksakuseisyoruiKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約請求書作成 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkSeikyuusyoSakuseiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

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

    private C_SksakuseisyoruiKbn sksakuseisyoruikbn;

    public C_SksakuseisyoruiKbn getSksakuseisyoruikbn() {
        return sksakuseisyoruikbn;
    }

    public void setSksakuseisyoruikbn(C_SksakuseisyoruiKbn pSksakuseisyoruikbn) {
        sksakuseisyoruikbn = pSksakuseisyoruikbn;
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }
}
