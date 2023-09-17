package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（会計処理レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinKaikeiRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinKaikeiRecordLayoutFile() {
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

    @Column(order = 3, length = 2)
    private String iffFbdatarecordsuu;

    public String getIffFbdatarecordsuu() {
        return iffFbdatarecordsuu;
    }

    public void setIffFbdatarecordsuu(String pIffFbdatarecordsuu) {
        iffFbdatarecordsuu = pIffFbdatarecordsuu;
    }

    @Column(order = 4, length = 2)
    private String iffFbdatarecordno;

    public String getIffFbdatarecordno() {
        return iffFbdatarecordno;
    }

    public void setIffFbdatarecordno(String pIffFbdatarecordno) {
        iffFbdatarecordno = pIffFbdatarecordno;
    }

    @Column(order = 5, length = 2)
    private String iffFbbunkatukaikeiutwksuu;

    public String getIffFbbunkatukaikeiutwksuu() {
        return iffFbbunkatukaikeiutwksuu;
    }

    public void setIffFbbunkatukaikeiutwksuu(String pIffFbbunkatukaikeiutwksuu) {
        iffFbbunkatukaikeiutwksuu = pIffFbbunkatukaikeiutwksuu;
    }

    @Column(order = 6, length = 2)
    private String iffFbsoubakbn;

    public String getIffFbsoubakbn() {
        return iffFbsoubakbn;
    }

    public void setIffFbsoubakbn(String pIffFbsoubakbn) {
        iffFbsoubakbn = pIffFbsoubakbn;
    }

    @Column(order = 7, length = 3)
    private String iffFbutwktuukasyurui;

    public String getIffFbutwktuukasyurui() {
        return iffFbutwktuukasyurui;
    }

    public void setIffFbutwktuukasyurui(String pIffFbutwktuukasyurui) {
        iffFbutwktuukasyurui = pIffFbutwktuukasyurui;
    }

    @Column(order = 8, length = 1)
    private String iffFbutwksyousuuketa;

    public String getIffFbutwksyousuuketa() {
        return iffFbutwksyousuuketa;
    }

    public void setIffFbutwksyousuuketa(String pIffFbutwksyousuuketa) {
        iffFbutwksyousuuketa = pIffFbutwksyousuuketa;
    }

    @Column(order = 9, length = 15)
    private String iffFbutwkkingk;

    public String getIffFbutwkkingk() {
        return iffFbutwkkingk;
    }

    @Padding(mode = "left", padChar = '0', length = 15)
    public void setIffFbutwkkingk(String pIffFbutwkkingk) {
        iffFbutwkkingk = pIffFbutwkkingk;
    }

    @Column(order = 10, length = 3)
    private String iffFbdummy3;

    public String getIffFbdummy3() {
        return iffFbdummy3;
    }

    public void setIffFbdummy3(String pIffFbdummy3) {
        iffFbdummy3 = pIffFbdummy3;
    }

    @Column(order = 11, length = 1)
    private String iffFbdummyn1;

    public String getIffFbdummyn1() {
        return iffFbdummyn1;
    }

    public void setIffFbdummyn1(String pIffFbdummyn1) {
        iffFbdummyn1 = pIffFbdummyn1;
    }

    @Column(order = 12, length = 15)
    private String iffFbenkataikagk;

    public String getIffFbenkataikagk() {
        return iffFbenkataikagk;
    }

    public void setIffFbenkataikagk(String pIffFbenkataikagk) {
        iffFbenkataikagk = pIffFbenkataikagk;
    }

    @Column(order = 13, length = 16)
    private String iffFbyoyakuno;

    public String getIffFbyoyakuno() {
        return iffFbyoyakuno;
    }

    public void setIffFbyoyakuno(String pIffFbyoyakuno) {
        iffFbyoyakuno = pIffFbyoyakuno;
    }

    @Column(order = 14, length = 3)
    private String iffFbhktskouzatuukasyurui;

    public String getIffFbhktskouzatuukasyurui() {
        return iffFbhktskouzatuukasyurui;
    }

    public void setIffFbhktskouzatuukasyurui(String pIffFbhktskouzatuukasyurui) {
        iffFbhktskouzatuukasyurui = pIffFbhktskouzatuukasyurui;
    }

    @Column(order = 15, length = 1)
    private String iffFbhktskouzasyurui;

    public String getIffFbhktskouzasyurui() {
        return iffFbhktskouzasyurui;
    }

    public void setIffFbhktskouzasyurui(String pIffFbhktskouzasyurui) {
        iffFbhktskouzasyurui = pIffFbhktskouzasyurui;
    }

    @Column(order = 16, length = 10)
    private String iffFbhktskouzano;

    public String getIffFbhktskouzano() {
        return iffFbhktskouzano;
    }

    public void setIffFbhktskouzano(String pIffFbhktskouzano) {
        iffFbhktskouzano = pIffFbhktskouzano;
    }

    @Column(order = 17, length = 10)
    private String iffFbdummy10;

    public String getIffFbdummy10() {
        return iffFbdummy10;
    }

    public void setIffFbdummy10(String pIffFbdummy10) {
        iffFbdummy10 = pIffFbdummy10;
    }

    @Column(order = 18, length = 80)
    private String iffFbkaikeiutwk2;

    public String getIffFbkaikeiutwk2() {
        return iffFbkaikeiutwk2;
    }

    public void setIffFbkaikeiutwk2(String pIffFbkaikeiutwk2) {
        iffFbkaikeiutwk2 = pIffFbkaikeiutwk2;
    }

    @Column(order = 19, length = 80)
    private String iffFbkaikeiutwk3;

    public String getIffFbkaikeiutwk3() {
        return iffFbkaikeiutwk3;
    }

    public void setIffFbkaikeiutwk3(String pIffFbkaikeiutwk3) {
        iffFbkaikeiutwk3 = pIffFbkaikeiutwk3;
    }

    @Column(order = 20, length = 1)
    private String iffFbdummy1;

    public String getIffFbdummy1() {
        return iffFbdummy1;
    }

    public void setIffFbdummy1(String pIffFbdummy1) {
        iffFbdummy1 = pIffFbdummy1;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
