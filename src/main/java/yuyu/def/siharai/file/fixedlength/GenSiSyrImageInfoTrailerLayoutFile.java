package yuyu.def.siharai.file.fixedlength;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）書類イメージ情報ファイル（トレーラレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSyrImageInfoTrailerLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSiSyrImageInfoTrailerLayoutFile() {
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

    @Column(order = 3, length = 489)
    private String iffYobiimginfotrailer01;

    public String getIffYobiimginfotrailer01() {
        return iffYobiimginfotrailer01;
    }

    public void setIffYobiimginfotrailer01(String pIffYobiimginfotrailer01) {
        iffYobiimginfotrailer01 = pIffYobiimginfotrailer01;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
