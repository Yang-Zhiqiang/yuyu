package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（被仕向レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinHisimukeRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinHisimukeRecordLayoutFile() {
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
    private String iffFbbanknmkigou;

    public String getIffFbbanknmkigou() {
        return iffFbbanknmkigou;
    }

    public void setIffFbbanknmkigou(String pIffFbbanknmkigou) {
        iffFbbanknmkigou = pIffFbbanknmkigou;
    }

    @Column(order = 8, length = 35)
    private String iffFbbanknmdata;

    public String getIffFbbanknmdata() {
        return iffFbbanknmdata;
    }

    public void setIffFbbanknmdata(String pIffFbbanknmdata) {
        iffFbbanknmdata = pIffFbbanknmdata;
    }

    @Column(order = 9, length = 6)
    private String iffFbsitenmeikigou;

    public String getIffFbsitenmeikigou() {
        return iffFbsitenmeikigou;
    }

    public void setIffFbsitenmeikigou(String pIffFbsitenmeikigou) {
        iffFbsitenmeikigou = pIffFbsitenmeikigou;
    }

    @Column(order = 10, length = 35)
    private String iffFbsitenmeidata;

    public String getIffFbsitenmeidata() {
        return iffFbsitenmeidata;
    }

    public void setIffFbsitenmeidata(String pIffFbsitenmeidata) {
        iffFbsitenmeidata = pIffFbsitenmeidata;
    }

    @Column(order = 11, length = 6)
    private String iffFbjyuusyokigou;

    public String getIffFbjyuusyokigou() {
        return iffFbjyuusyokigou;
    }

    public void setIffFbjyuusyokigou(String pIffFbjyuusyokigou) {
        iffFbjyuusyokigou = pIffFbjyuusyokigou;
    }

    @Column(order = 12, length = 70)
    private String iffFbjyuusyodata;

    public String getIffFbjyuusyodata() {
        return iffFbjyuusyodata;
    }

    public void setIffFbjyuusyodata(String pIffFbjyuusyodata) {
        iffFbjyuusyodata = pIffFbjyuusyodata;
    }

    @Column(order = 13, length = 69)
    private String iffFbdummy69;

    public String getIffFbdummy69() {
        return iffFbdummy69;
    }

    public void setIffFbdummy69(String pIffFbdummy69) {
        iffFbdummy69 = pIffFbdummy69;
    }

    @Column(order = 14, length = 4)
    private String iffFbbankcd;

    public String getIffFbbankcd() {
        return iffFbbankcd;
    }

    public void setIffFbbankcd(String pIffFbbankcd) {
        iffFbbankcd = pIffFbbankcd;
    }

    @Column(order = 15, length = 3)
    private String iffFbsitencd;

    public String getIffFbsitencd() {
        return iffFbsitencd;
    }

    public void setIffFbsitencd(String pIffFbsitencd) {
        iffFbsitencd = pIffFbsitencd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
