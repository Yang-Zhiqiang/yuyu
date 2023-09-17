package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）契約内容ＬＩＮＣ結果Ｆ（トレーラレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzLinckyknaiykekchkTrailerRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzLinckyknaiykekchkTrailerRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffDatakbn;

    public String getIffDatakbn() {
        return iffDatakbn;
    }

    public void setIffDatakbn(String pIffDatakbn) {
        iffDatakbn = pIffDatakbn;
    }

    @Column(order = 2, length = 599)
    private String iffDummy599;

    public String getIffDummy599() {
        return iffDummy599;
    }

    public void setIffDummy599(String pIffDummy599) {
        iffDummy599 = pIffDummy599;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
