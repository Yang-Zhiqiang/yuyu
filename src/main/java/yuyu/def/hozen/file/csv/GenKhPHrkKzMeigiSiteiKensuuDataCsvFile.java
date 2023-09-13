package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）保険料払込口座名義指定件数データＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhPHrkKzMeigiSiteiKensuuDataCsvFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhPHrkKzMeigiSiteiKensuuDataCsvFile() {
    }

    @Column(order = 1, label = "件数")
    @NotNull
    private String ifcKensuu;

    public String getIfcKensuu() {
        return ifcKensuu;
    }

    public void setIfcKensuu(String pIfcKensuu) {
        ifcKensuu = pIfcKensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
