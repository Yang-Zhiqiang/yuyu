package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（固定長レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinFixedlengthRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinFixedlengthRecordLayoutFile() {
    }

    @Column(order = 1, length = 250)
    private String iffFbgkfixedlengthdata;

    public String getIffFbgkfixedlengthdata() {
        return iffFbgkfixedlengthdata;
    }

    public void setIffFbgkfixedlengthdata(String pIffFbgkfixedlengthdata) {
        iffFbgkfixedlengthdata = pIffFbgkfixedlengthdata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
