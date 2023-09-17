package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（メッセージレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinMessageRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinMessageRecordLayoutFile() {
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
    private String iffFbmessagekigou;

    public String getIffFbmessagekigou() {
        return iffFbmessagekigou;
    }

    public void setIffFbmessagekigou(String pIffFbmessagekigou) {
        iffFbmessagekigou = pIffFbmessagekigou;
    }

    @Column(order = 8, length = 140)
    private String iffFbmessagedata;

    public String getIffFbmessagedata() {
        return iffFbmessagedata;
    }

    public void setIffFbmessagedata(String pIffFbmessagedata) {
        iffFbmessagedata = pIffFbmessagedata;
    }

    @Column(order = 9, length = 88)
    private String iffFbdummy88;

    public String getIffFbdummy88() {
        return iffFbdummy88;
    }

    public void setIffFbdummy88(String pIffFbdummy88) {
        iffFbdummy88 = pIffFbdummy88;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
