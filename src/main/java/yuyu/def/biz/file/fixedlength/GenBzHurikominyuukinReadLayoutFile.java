package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）振込入金ファイル（リード用）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHurikominyuukinReadLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHurikominyuukinReadLayoutFile() {
    }

    @Column(order = 1, length = 200)
    private String iffRecord200;

    public String getIffRecord200() {
        return iffRecord200;
    }

    public void setIffRecord200(String pIffRecord200) {
        iffRecord200 = pIffRecord200;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
