package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）振込入金ファイル（エンドレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHurikominyuukinEndRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHurikominyuukinEndRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffDatakbn;

    public String getIffDatakbn() {
        return iffDatakbn;
    }

    public void setIffDatakbn(String pIffDatakbn) {
        iffDatakbn = pIffDatakbn;
    }

    @Column(order = 2, length = 10)
    private Long iffRecordsoukensuu;

    public Long getIffRecordsoukensuu() {
        return iffRecordsoukensuu;
    }

    public void setIffRecordsoukensuu(Long pIffRecordsoukensuu) {
        iffRecordsoukensuu = pIffRecordsoukensuu;
    }

    @Column(order = 3, length = 5)
    private Integer iffKzsuu;

    public Integer getIffKzsuu() {
        return iffKzsuu;
    }

    public void setIffKzsuu(Integer pIffKzsuu) {
        iffKzsuu = pIffKzsuu;
    }

    @Column(order = 4, length = 184)
    private String iffDummy184;

    public String getIffDummy184() {
        return iffDummy184;
    }

    public void setIffDummy184(String pIffDummy184) {
        iffDummy184 = pIffDummy184;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
