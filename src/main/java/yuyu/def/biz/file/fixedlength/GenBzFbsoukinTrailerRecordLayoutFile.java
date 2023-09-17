package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＢ送金（トレーラーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinTrailerRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinTrailerRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffFbdatakbn;

    public String getIffFbdatakbn() {
        return iffFbdatakbn;
    }

    public void setIffFbdatakbn(String pIffFbdatakbn) {
        iffFbdatakbn = pIffFbdatakbn;
    }

    @Column(order = 2, length = 6)
    private String iffFbdatarecordkensuu6;

    public String getIffFbdatarecordkensuu6() {
        return iffFbdatarecordkensuu6;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setIffFbdatarecordkensuu6(String pIffFbdatarecordkensuu6) {
        iffFbdatarecordkensuu6 = pIffFbdatarecordkensuu6;
    }

    @Column(order = 3, length = 12)
    private String iffFbhrkmkingkgoukei;

    public String getIffFbhrkmkingkgoukei() {
        return iffFbhrkmkingkgoukei;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setIffFbhrkmkingkgoukei(String pIffFbhrkmkingkgoukei) {
        iffFbhrkmkingkgoukei = pIffFbhrkmkingkgoukei;
    }

    @Column(order = 4, length = 101)
    private String iffFbdummy101;

    public String getIffFbdummy101() {
        return iffFbdummy101;
    }

    public void setIffFbdummy101(String pIffFbdummy101) {
        iffFbdummy101 = pIffFbdummy101;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
