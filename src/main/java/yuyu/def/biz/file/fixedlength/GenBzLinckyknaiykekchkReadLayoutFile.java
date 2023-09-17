package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）契約内容ＬＩＮＣ結果Ｆ（リード用）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzLinckyknaiykekchkReadLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzLinckyknaiykekchkReadLayoutFile() {
    }

    @Column(order = 1, length = 600)
    private String iffRecord600;

    public String getIffRecord600() {
        return iffRecord600;
    }

    public void setIffRecord600(String pIffRecord600) {
        iffRecord600 = pIffRecord600;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
