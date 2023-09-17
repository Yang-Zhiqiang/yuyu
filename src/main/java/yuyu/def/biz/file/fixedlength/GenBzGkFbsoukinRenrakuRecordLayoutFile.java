package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（連絡事項レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinRenrakuRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinRenrakuRecordLayoutFile() {
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
    private String iffFbrenrakujikou1kigou;

    public String getIffFbrenrakujikou1kigou() {
        return iffFbrenrakujikou1kigou;
    }

    public void setIffFbrenrakujikou1kigou(String pIffFbrenrakujikou1kigou) {
        iffFbrenrakujikou1kigou = pIffFbrenrakujikou1kigou;
    }

    @Column(order = 8, length = 35)
    private String iffFbrenrakujikou1data;

    public String getIffFbrenrakujikou1data() {
        return iffFbrenrakujikou1data;
    }

    public void setIffFbrenrakujikou1data(String pIffFbrenrakujikou1data) {
        iffFbrenrakujikou1data = pIffFbrenrakujikou1data;
    }

    @Column(order = 9, length = 6)
    private String iffFbrenrakujikou2kigou;

    public String getIffFbrenrakujikou2kigou() {
        return iffFbrenrakujikou2kigou;
    }

    public void setIffFbrenrakujikou2kigou(String pIffFbrenrakujikou2kigou) {
        iffFbrenrakujikou2kigou = pIffFbrenrakujikou2kigou;
    }

    @Column(order = 10, length = 35)
    private String iffFbrenrakujikou2data;

    public String getIffFbrenrakujikou2data() {
        return iffFbrenrakujikou2data;
    }

    public void setIffFbrenrakujikou2data(String pIffFbrenrakujikou2data) {
        iffFbrenrakujikou2data = pIffFbrenrakujikou2data;
    }

    @Column(order = 11, length = 6)
    private String iffFbrenrakujikou3kigou;

    public String getIffFbrenrakujikou3kigou() {
        return iffFbrenrakujikou3kigou;
    }

    public void setIffFbrenrakujikou3kigou(String pIffFbrenrakujikou3kigou) {
        iffFbrenrakujikou3kigou = pIffFbrenrakujikou3kigou;
    }

    @Column(order = 12, length = 140)
    private String iffFbrenrakujikou3data;

    public String getIffFbrenrakujikou3data() {
        return iffFbrenrakujikou3data;
    }

    public void setIffFbrenrakujikou3data(String pIffFbrenrakujikou3data) {
        iffFbrenrakujikou3data = pIffFbrenrakujikou3data;
    }

    @Column(order = 13, length = 6)
    private String iffFbdummy6;

    public String getIffFbdummy6() {
        return iffFbdummy6;
    }

    public void setIffFbdummy6(String pIffFbdummy6) {
        iffFbdummy6 = pIffFbdummy6;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
