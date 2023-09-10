package yuyu.def.siharai.file.fixedlength;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）請求契約情報ファイル（ヘッダーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSkKykInfoHeaderLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSiSkKykInfoHeaderLayoutFile() {
    }

    @Column(order = 1, length = 8)
    @NotNull
    private String iffFilesakuseiymd;

    public String getIffFilesakuseiymd() {
        return iffFilesakuseiymd;
    }

    public void setIffFilesakuseiymd(String pIffFilesakuseiymd) {
        iffFilesakuseiymd = pIffFilesakuseiymd;
    }

    @Column(order = 2, length = 1292)
    private String iffYobiskkykinfoheader01;

    public String getIffYobiskkykinfoheader01() {
        return iffYobiskkykinfoheader01;
    }

    public void setIffYobiskkykinfoheader01(String pIffYobiskkykinfoheader01) {
        iffYobiskkykinfoheader01 = pIffYobiskkykinfoheader01;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
