package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（送金先レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinSksakiRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinSksakiRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffFbdatakbn;

    public String getIffFbdatakbn() {
        return iffFbdatakbn;
    }

    public void setIffFbdatakbn(String pIffFbdatakbn) {
        iffFbdatakbn = pIffFbdatakbn;
    }

    @Column(order = 2, length = 2)
    private String iffFbdatarecordkbn;

    public String getIffFbdatarecordkbn() {
        return iffFbdatarecordkbn;
    }

    public void setIffFbdatarecordkbn(String pIffFbdatarecordkbn) {
        iffFbdatarecordkbn = pIffFbdatarecordkbn;
    }

    @Column(order = 3, length = 4)
    private String iffFbdousyurecordsuu;

    public String getIffFbdousyurecordsuu() {
        return iffFbdousyurecordsuu;
    }

    public void setIffFbdousyurecordsuu(String pIffFbdousyurecordsuu) {
        iffFbdousyurecordsuu = pIffFbdousyurecordsuu;
    }

    @Column(order = 4, length = 4)
    private String iffFbdousyurecordno;

    public String getIffFbdousyurecordno() {
        return iffFbdousyurecordno;
    }

    public void setIffFbdousyurecordno(String pIffFbdousyurecordno) {
        iffFbdousyurecordno = pIffFbdousyurecordno;
    }

    @Column(order = 5, length = 2)
    private String iffFbkoumokusuu;

    public String getIffFbkoumokusuu() {
        return iffFbkoumokusuu;
    }

    public void setIffFbkoumokusuu(String pIffFbkoumokusuu) {
        iffFbkoumokusuu = pIffFbkoumokusuu;
    }

    @Column(order = 6, length = 3)
    private String iffFbkoumokuketasuu;

    public String getIffFbkoumokuketasuu() {
        return iffFbkoumokuketasuu;
    }

    public void setIffFbkoumokuketasuu(String pIffFbkoumokuketasuu) {
        iffFbkoumokuketasuu = pIffFbkoumokuketasuu;
    }

    @Column(order = 7, length = 6)
    private String iffFbuketorininnmkigou;

    public String getIffFbuketorininnmkigou() {
        return iffFbuketorininnmkigou;
    }

    public void setIffFbuketorininnmkigou(String pIffFbuketorininnmkigou) {
        iffFbuketorininnmkigou = pIffFbuketorininnmkigou;
    }

    @Column(order = 8, length = 70)
    private String iffFbuketorininnmdata;

    public String getIffFbuketorininnmdata() {
        return iffFbuketorininnmdata;
    }

    public void setIffFbuketorininnmdata(String pIffFbuketorininnmdata) {
        iffFbuketorininnmdata = pIffFbuketorininnmdata;
    }

    @Column(order = 9, length = 6)
    private String iffFbjyuusyokigou;

    public String getIffFbjyuusyokigou() {
        return iffFbjyuusyokigou;
    }

    public void setIffFbjyuusyokigou(String pIffFbjyuusyokigou) {
        iffFbjyuusyokigou = pIffFbjyuusyokigou;
    }

    @Column(order = 10, length = 70)
    private String iffFbjyuusyodata;

    public String getIffFbjyuusyodata() {
        return iffFbjyuusyodata;
    }

    public void setIffFbjyuusyodata(String pIffFbjyuusyodata) {
        iffFbjyuusyodata = pIffFbjyuusyodata;
    }

    @Column(order = 11, length = 6)
    private String iffFbsoukinsakikouzanokigou;

    public String getIffFbsoukinsakikouzanokigou() {
        return iffFbsoukinsakikouzanokigou;
    }

    public void setIffFbsoukinsakikouzanokigou(String pIffFbsoukinsakikouzanokigou) {
        iffFbsoukinsakikouzanokigou = pIffFbsoukinsakikouzanokigou;
    }

    @Column(order = 12, length = 34)
    private String iffFbsoukinsakikouzanodata;

    public String getIffFbsoukinsakikouzanodata() {
        return iffFbsoukinsakikouzanodata;
    }

    public void setIffFbsoukinsakikouzanodata(String pIffFbsoukinsakikouzanodata) {
        iffFbsoukinsakikouzanodata = pIffFbsoukinsakikouzanodata;
    }

    @Column(order = 13, length = 42)
    private String iffFbdummy42;

    public String getIffFbdummy42() {
        return iffFbdummy42;
    }

    public void setIffFbdummy42(String pIffFbdummy42) {
        iffFbdummy42 = pIffFbdummy42;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
