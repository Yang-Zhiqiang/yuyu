package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.classification.C_YouhiKbn;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保険募集）生保Ｗｅｂ申込番号取得入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebMosNoInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebMosNoInputBean() {
    }

    @Column(order = 1, length = 1)
    @NotNull
    @MaxLength(max=1)
    private String iwsDrtentyouhyougyoutaikbn;

    public String getIwsDrtentyouhyougyoutaikbn() {
        return iwsDrtentyouhyougyoutaikbn;
    }

    public void setIwsDrtentyouhyougyoutaikbn(String pIwsDrtentyouhyougyoutaikbn) {
        iwsDrtentyouhyougyoutaikbn = pIwsDrtentyouhyougyoutaikbn;
    }

    @Column(order = 2, length = 3)
    @NotNull
    @Length(length=3)
    private String iwsHknsyuruino;

    public String getIwsHknsyuruino() {
        return iwsHknsyuruino;
    }

    public void setIwsHknsyuruino(String pIwsHknsyuruino) {
        iwsHknsyuruino = pIwsHknsyuruino;
    }

    @Column(order = 3, length = 7)
    @NotNull
    @AlphaDigit
    @MaxLength(max=7)
    private String iwsDrtencd;

    public String getIwsDrtencd() {
        return iwsDrtencd;
    }

    public void setIwsDrtencd(String pIwsDrtencd) {
        iwsDrtencd = pIwsDrtencd;
    }

    @Column(order = 4, length = 1)
    @NotNull
    private C_YouhiKbn iwsMossakuseiyh;

    public C_YouhiKbn getIwsMossakuseiyh() {
        return iwsMossakuseiyh;
    }

    public void setIwsMossakuseiyh(C_YouhiKbn pIwsMossakuseiyh) {
        iwsMossakuseiyh = pIwsMossakuseiyh;
    }

    @Column(order = 5, length = 1)
    @NotNull
    private C_YouhiKbn iwsTahukksakuseiyh;

    public C_YouhiKbn getIwsTahukksakuseiyh() {
        return iwsTahukksakuseiyh;
    }

    public void setIwsTahukksakuseiyh(C_YouhiKbn pIwsTahukksakuseiyh) {
        iwsTahukksakuseiyh = pIwsTahukksakuseiyh;
    }

    @Column(order = 6, length = 1)
    @NotNull
    private C_YouhiKbn iwsUkthukusuustsakuseiyh;

    public C_YouhiKbn getIwsUkthukusuustsakuseiyh() {
        return iwsUkthukusuustsakuseiyh;
    }

    public void setIwsUkthukusuustsakuseiyh(C_YouhiKbn pIwsUkthukusuustsakuseiyh) {
        iwsUkthukusuustsakuseiyh = pIwsUkthukusuustsakuseiyh;
    }

    @Column(order = 7, length = 1)
    @NotNull
    private C_YouhiKbn iwsIkokaksyosakuseiyh;

    public C_YouhiKbn getIwsIkokaksyosakuseiyh() {
        return iwsIkokaksyosakuseiyh;
    }

    public void setIwsIkokaksyosakuseiyh(C_YouhiKbn pIwsIkokaksyosakuseiyh) {
        iwsIkokaksyosakuseiyh = pIwsIkokaksyosakuseiyh;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
