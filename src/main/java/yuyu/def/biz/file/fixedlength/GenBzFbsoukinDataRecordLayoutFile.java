package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＢ送金（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinDataRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffFbdatakbn;

    public String getIffFbdatakbn() {
        return iffFbdatakbn;
    }

    public void setIffFbdatakbn(String pIffFbdatakbn) {
        iffFbdatakbn = pIffFbdatakbn;
    }

    @Column(order = 2, length = 4)
    private String iffFbbankcd;

    public String getIffFbbankcd() {
        return iffFbbankcd;
    }

    public void setIffFbbankcd(String pIffFbbankcd) {
        iffFbbankcd = pIffFbbankcd;
    }

    @Column(order = 3, length = 15)
    private String iffFbbanknmkn;

    public String getIffFbbanknmkn() {
        return iffFbbanknmkn;
    }

    public void setIffFbbanknmkn(String pIffFbbanknmkn) {
        iffFbbanknmkn = pIffFbbanknmkn;
    }

    @Column(order = 4, length = 3)
    private String iffFbsitencd;

    public String getIffFbsitencd() {
        return iffFbsitencd;
    }

    public void setIffFbsitencd(String pIffFbsitencd) {
        iffFbsitencd = pIffFbsitencd;
    }

    @Column(order = 5, length = 15)
    private String iffFbsitennmkn;

    public String getIffFbsitennmkn() {
        return iffFbsitennmkn;
    }

    public void setIffFbsitennmkn(String pIffFbsitennmkn) {
        iffFbsitennmkn = pIffFbsitennmkn;
    }

    @Column(order = 6, length = 4)
    private String iffFbtegatakoukanjyono;

    public String getIffFbtegatakoukanjyono() {
        return iffFbtegatakoukanjyono;
    }

    public void setIffFbtegatakoukanjyono(String pIffFbtegatakoukanjyono) {
        iffFbtegatakoukanjyono = pIffFbtegatakoukanjyono;
    }

    @Column(order = 7, length = 1)
    private String iffFbyokinkbn;

    public String getIffFbyokinkbn() {
        return iffFbyokinkbn;
    }

    public void setIffFbyokinkbn(String pIffFbyokinkbn) {
        iffFbyokinkbn = pIffFbyokinkbn;
    }

    @Column(order = 8, length = 7)
    private String iffFbkouzano;

    public String getIffFbkouzano() {
        return iffFbkouzano;
    }

    public void setIffFbkouzano(String pIffFbkouzano) {
        iffFbkouzano = pIffFbkouzano;
    }

    @Column(order = 9, length = 30)
    private String iffFbkouzameigininnmkn;

    public String getIffFbkouzameigininnmkn() {
        return iffFbkouzameigininnmkn;
    }

    public void setIffFbkouzameigininnmkn(String pIffFbkouzameigininnmkn) {
        iffFbkouzameigininnmkn = pIffFbkouzameigininnmkn;
    }

    @Column(order = 10, length = 10)
    private String iffFbhrkmkingk;

    public String getIffFbhrkmkingk() {
        return iffFbhrkmkingk;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setIffFbhrkmkingk(String pIffFbhrkmkingk) {
        iffFbhrkmkingk = pIffFbhrkmkingk;
    }

    @Column(order = 11, length = 1)
    private String iffFbnewcd;

    public String getIffFbnewcd() {
        return iffFbnewcd;
    }

    public void setIffFbnewcd(String pIffFbnewcd) {
        iffFbnewcd = pIffFbnewcd;
    }

    @Column(order = 12, length = 10)
    private String iffFbkokyakucd1;

    public String getIffFbkokyakucd1() {
        return iffFbkokyakucd1;
    }

    public void setIffFbkokyakucd1(String pIffFbkokyakucd1) {
        iffFbkokyakucd1 = pIffFbkokyakucd1;
    }

    @Column(order = 13, length = 10)
    private String iffFbkokyakucd2;

    public String getIffFbkokyakucd2() {
        return iffFbkokyakucd2;
    }

    public void setIffFbkokyakucd2(String pIffFbkokyakucd2) {
        iffFbkokyakucd2 = pIffFbkokyakucd2;
    }

    @Column(order = 14, length = 1)
    private String iffFbhrkmsiteikbn;

    public String getIffFbhrkmsiteikbn() {
        return iffFbhrkmsiteikbn;
    }

    public void setIffFbhrkmsiteikbn(String pIffFbhrkmsiteikbn) {
        iffFbhrkmsiteikbn = pIffFbhrkmsiteikbn;
    }

    @Column(order = 15, length = 8)
    private String iffFbdummy8;

    public String getIffFbdummy8() {
        return iffFbdummy8;
    }

    public void setIffFbdummy8(String pIffFbdummy8) {
        iffFbdummy8 = pIffFbdummy8;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
