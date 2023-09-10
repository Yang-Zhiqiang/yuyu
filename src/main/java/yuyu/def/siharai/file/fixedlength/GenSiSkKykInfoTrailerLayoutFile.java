package yuyu.def.siharai.file.fixedlength;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）請求契約情報ファイル（トレーラレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSkKykInfoTrailerLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSiSkKykInfoTrailerLayoutFile() {
    }

    @Column(order = 1, length = 4)
    @NotNull
    private String iffLastrecsikibetusi;

    public String getIffLastrecsikibetusi() {
        return iffLastrecsikibetusi;
    }

    public void setIffLastrecsikibetusi(String pIffLastrecsikibetusi) {
        iffLastrecsikibetusi = pIffLastrecsikibetusi;
    }

    @Column(order = 2, length = 7)
    @NotNull
    private String iffRecordkensuu;

    public String getIffRecordkensuu() {
        return iffRecordkensuu;
    }

    public void setIffRecordkensuu(String pIffRecordkensuu) {
        iffRecordkensuu = pIffRecordkensuu;
    }

    @Column(order = 3, length = 1289)
    private String iffYobikykinfotrailer01;

    public String getIffYobikykinfotrailer01() {
        return iffYobikykinfotrailer01;
    }

    public void setIffYobikykinfotrailer01(String pIffYobikykinfotrailer01) {
        iffYobikykinfotrailer01 = pIffYobikykinfotrailer01;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
