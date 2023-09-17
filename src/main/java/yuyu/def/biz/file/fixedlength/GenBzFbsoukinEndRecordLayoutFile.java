package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＢ送金（エンドレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinEndRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinEndRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffFbdatakbn;

    public String getIffFbdatakbn() {
        return iffFbdatakbn;
    }

    public void setIffFbdatakbn(String pIffFbdatakbn) {
        iffFbdatakbn = pIffFbdatakbn;
    }

    @Column(order = 2, length = 119)
    private String iffFbdummy119;

    public String getIffFbdummy119() {
        return iffFbdummy119;
    }

    public void setIffFbdummy119(String pIffFbdummy119) {
        iffFbdummy119 = pIffFbdummy119;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
