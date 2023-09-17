package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＢ送金（固定長レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinFixedlengthRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinFixedlengthRecordLayoutFile() {
    }

    @Column(order = 1, length = 120)
    private String iffFbfixedlengthdata;

    public String getIffFbfixedlengthdata() {
        return iffFbfixedlengthdata;
    }

    public void setIffFbfixedlengthdata(String pIffFbfixedlengthdata) {
        iffFbfixedlengthdata = pIffFbfixedlengthdata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
