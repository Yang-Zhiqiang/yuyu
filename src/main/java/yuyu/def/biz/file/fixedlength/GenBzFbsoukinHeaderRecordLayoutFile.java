package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＢ送金（ヘッダーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinHeaderRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinHeaderRecordLayoutFile() {
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
    private String iffFbsyubetucd;

    public String getIffFbsyubetucd() {
        return iffFbsyubetucd;
    }

    public void setIffFbsyubetucd(String pIffFbsyubetucd) {
        iffFbsyubetucd = pIffFbsyubetucd;
    }

    @Column(order = 3, length = 1)
    private String iffFbcdkbn;

    public String getIffFbcdkbn() {
        return iffFbcdkbn;
    }

    public void setIffFbcdkbn(String pIffFbcdkbn) {
        iffFbcdkbn = pIffFbcdkbn;
    }

    @Column(order = 4, length = 10)
    private String iffFbhrkmirainincd;

    public String getIffFbhrkmirainincd() {
        return iffFbhrkmirainincd;
    }

    public void setIffFbhrkmirainincd(String pIffFbhrkmirainincd) {
        iffFbhrkmirainincd = pIffFbhrkmirainincd;
    }

    @Column(order = 5, length = 40)
    private String iffFbhrkmiraininnm;

    public String getIffFbhrkmiraininnm() {
        return iffFbhrkmiraininnm;
    }

    public void setIffFbhrkmiraininnm(String pIffFbhrkmiraininnm) {
        iffFbhrkmiraininnm = pIffFbhrkmiraininnm;
    }

    @Column(order = 6, length = 4)
    private String iffFbhrkmmd;

    public String getIffFbhrkmmd() {
        return iffFbhrkmmd;
    }

    public void setIffFbhrkmmd(String pIffFbhrkmmd) {
        iffFbhrkmmd = pIffFbhrkmmd;
    }

    @Column(order = 7, length = 4)
    private String iffFbbankcd;

    public String getIffFbbankcd() {
        return iffFbbankcd;
    }

    public void setIffFbbankcd(String pIffFbbankcd) {
        iffFbbankcd = pIffFbbankcd;
    }

    @Column(order = 8, length = 15)
    private String iffFbbanknmkn;

    public String getIffFbbanknmkn() {
        return iffFbbanknmkn;
    }

    public void setIffFbbanknmkn(String pIffFbbanknmkn) {
        iffFbbanknmkn = pIffFbbanknmkn;
    }

    @Column(order = 9, length = 3)
    private String iffFbsitencd;

    public String getIffFbsitencd() {
        return iffFbsitencd;
    }

    public void setIffFbsitencd(String pIffFbsitencd) {
        iffFbsitencd = pIffFbsitencd;
    }

    @Column(order = 10, length = 15)
    private String iffFbsitennmkn;

    public String getIffFbsitennmkn() {
        return iffFbsitennmkn;
    }

    public void setIffFbsitennmkn(String pIffFbsitennmkn) {
        iffFbsitennmkn = pIffFbsitennmkn;
    }

    @Column(order = 11, length = 1)
    private String iffFbyokinkbn;

    public String getIffFbyokinkbn() {
        return iffFbyokinkbn;
    }

    public void setIffFbyokinkbn(String pIffFbyokinkbn) {
        iffFbyokinkbn = pIffFbyokinkbn;
    }

    @Column(order = 12, length = 7)
    private String iffFbkouzano;

    public String getIffFbkouzano() {
        return iffFbkouzano;
    }

    public void setIffFbkouzano(String pIffFbkouzano) {
        iffFbkouzano = pIffFbkouzano;
    }

    @Column(order = 13, length = 13)
    private String iffFbdummy13;

    public String getIffFbdummy13() {
        return iffFbdummy13;
    }

    public void setIffFbdummy13(String pIffFbdummy13) {
        iffFbdummy13 = pIffFbdummy13;
    }

    @Column(order = 14, length = 4)
    private String iffFbgyoumucd;

    public String getIffFbgyoumucd() {
        return iffFbgyoumucd;
    }

    public void setIffFbgyoumucd(String pIffFbgyoumucd) {
        iffFbgyoumucd = pIffFbgyoumucd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
