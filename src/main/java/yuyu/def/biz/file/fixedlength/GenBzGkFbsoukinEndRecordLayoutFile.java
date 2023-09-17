package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（エンドレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinEndRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinEndRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffFbdatakbn;

    public String getIffFbdatakbn() {
        return iffFbdatakbn;
    }

    public void setIffFbdatakbn(String pIffFbdatakbn) {
        iffFbdatakbn = pIffFbdatakbn;
    }

    @Column(order = 2, length = 249)
    private String iffFbdummy249;

    public String getIffFbdummy249() {
        return iffFbdummy249;
    }

    public void setIffFbdummy249(String pIffFbdummy249) {
        iffFbdummy249 = pIffFbdummy249;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
