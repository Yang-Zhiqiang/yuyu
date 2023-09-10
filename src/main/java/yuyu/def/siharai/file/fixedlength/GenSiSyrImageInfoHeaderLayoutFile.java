package yuyu.def.siharai.file.fixedlength;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）書類イメージ情報ファイル（ヘッダーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSyrImageInfoHeaderLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSiSyrImageInfoHeaderLayoutFile() {
    }

    @Column(order = 1, length = 8)
    @NotNull
    private String iffSyoriymd;

    public String getIffSyoriymd() {
        return iffSyoriymd;
    }

    public void setIffSyoriymd(String pIffSyoriymd) {
        iffSyoriymd = pIffSyoriymd;
    }

    @Column(order = 2, length = 492)
    private String iffYobiimginfoheader01;

    public String getIffYobiimginfoheader01() {
        return iffYobiimginfoheader01;
    }

    public void setIffYobiimginfoheader01(String pIffYobiimginfoheader01) {
        iffYobiimginfoheader01 = pIffYobiimginfoheader01;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
