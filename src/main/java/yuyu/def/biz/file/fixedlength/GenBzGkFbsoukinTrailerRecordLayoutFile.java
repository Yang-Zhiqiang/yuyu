package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（トレーラーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinTrailerRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinTrailerRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffFbdatakbn;

    public String getIffFbdatakbn() {
        return iffFbdatakbn;
    }

    public void setIffFbdatakbn(String pIffFbdatakbn) {
        iffFbdatakbn = pIffFbdatakbn;
    }

    @Column(order = 2, length = 10)
    private String iffFbdatarecordkensuu10;

    public String getIffFbdatarecordkensuu10() {
        return iffFbdatarecordkensuu10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setIffFbdatarecordkensuu10(String pIffFbdatarecordkensuu10) {
        iffFbdatarecordkensuu10 = pIffFbdatarecordkensuu10;
    }

    @Column(order = 3, length = 10)
    private String iffFbhontaijyouhoukensuu;

    public String getIffFbhontaijyouhoukensuu() {
        return iffFbhontaijyouhoukensuu;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setIffFbhontaijyouhoukensuu(String pIffFbhontaijyouhoukensuu) {
        iffFbhontaijyouhoukensuu = pIffFbhontaijyouhoukensuu;
    }

    @Column(order = 4, length = 229)
    private String iffFbdummy229;

    public String getIffFbdummy229() {
        return iffFbdummy229;
    }

    public void setIffFbdummy229(String pIffFbdummy229) {
        iffFbdummy229 = pIffFbdummy229;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
