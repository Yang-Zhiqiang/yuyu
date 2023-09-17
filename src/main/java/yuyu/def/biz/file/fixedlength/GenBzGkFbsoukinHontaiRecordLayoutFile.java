package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金（本体情報レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkFbsoukinHontaiRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbsoukinHontaiRecordLayoutFile() {
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
    private String iffFbsyorituuban;

    public String getIffFbsyorituuban() {
        return iffFbsyorituuban;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setIffFbsyorituuban(String pIffFbsyorituuban) {
        iffFbsyorituuban = pIffFbsyorituuban;
    }

    @Column(order = 4, length = 16)
    private String iffFbtorihikisakisyoukaino;

    public String getIffFbtorihikisakisyoukaino() {
        return iffFbtorihikisakisyoukaino;
    }

    public void setIffFbtorihikisakisyoukaino(String pIffFbtorihikisakisyoukaino) {
        iffFbtorihikisakisyoukaino = pIffFbtorihikisakisyoukaino;
    }

    @Column(order = 5, length = 3)
    private String iffFbtuukasyurui;

    public String getIffFbtuukasyurui() {
        return iffFbtuukasyurui;
    }

    public void setIffFbtuukasyurui(String pIffFbtuukasyurui) {
        iffFbtuukasyurui = pIffFbtuukasyurui;
    }

    @Column(order = 6, length = 1)
    private String iffFbsyousuuketa;

    public String getIffFbsyousuuketa() {
        return iffFbsyousuuketa;
    }

    public void setIffFbsyousuuketa(String pIffFbsyousuuketa) {
        iffFbsyousuuketa = pIffFbsyousuuketa;
    }

    @Column(order = 7, length = 15)
    private String iffFbsoukingk;

    public String getIffFbsoukingk() {
        return iffFbsoukingk;
    }

    @Padding(mode = "left", padChar = '0', length = 15)
    public void setIffFbsoukingk(String pIffFbsoukingk) {
        iffFbsoukingk = pIffFbsoukingk;
    }

    @Column(order = 8, length = 3)
    private String iffFbkansantuukasyurui;

    public String getIffFbkansantuukasyurui() {
        return iffFbkansantuukasyurui;
    }

    public void setIffFbkansantuukasyurui(String pIffFbkansantuukasyurui) {
        iffFbkansantuukasyurui = pIffFbkansantuukasyurui;
    }

    @Column(order = 9, length = 15)
    private String iffFbenkataikagk;

    public String getIffFbenkataikagk() {
        return iffFbenkataikagk;
    }

    public void setIffFbenkataikagk(String pIffFbenkataikagk) {
        iffFbenkataikagk = pIffFbenkataikagk;
    }

    @Column(order = 10, length = 1)
    private String iffFbsoukinsyuruikbn;

    public String getIffFbsoukinsyuruikbn() {
        return iffFbsoukinsyuruikbn;
    }

    public void setIffFbsoukinsyuruikbn(String pIffFbsoukinsyuruikbn) {
        iffFbsoukinsyuruikbn = pIffFbsoukinsyuruikbn;
    }

    @Column(order = 11, length = 1)
    private String iffFbdensinsyuruikbn;

    public String getIffFbdensinsyuruikbn() {
        return iffFbdensinsyuruikbn;
    }

    public void setIffFbdensinsyuruikbn(String pIffFbdensinsyuruikbn) {
        iffFbdensinsyuruikbn = pIffFbdensinsyuruikbn;
    }

    @Column(order = 12, length = 1)
    private String iffFbsiharaikbn;

    public String getIffFbsiharaikbn() {
        return iffFbsiharaikbn;
    }

    public void setIffFbsiharaikbn(String pIffFbsiharaikbn) {
        iffFbsiharaikbn = pIffFbsiharaikbn;
    }

    @Column(order = 13, length = 1)
    private String iffFbtesuuryousiharaikbn;

    public String getIffFbtesuuryousiharaikbn() {
        return iffFbtesuuryousiharaikbn;
    }

    public void setIffFbtesuuryousiharaikbn(String pIffFbtesuuryousiharaikbn) {
        iffFbtesuuryousiharaikbn = pIffFbtesuuryousiharaikbn;
    }

    @Column(order = 14, length = 4)
    private String iffFbsoukinmokutekicd;

    public String getIffFbsoukinmokutekicd() {
        return iffFbsoukinmokutekicd;
    }

    public void setIffFbsoukinmokutekicd(String pIffFbsoukinmokutekicd) {
        iffFbsoukinmokutekicd = pIffFbsoukinmokutekicd;
    }

    @Column(order = 15, length = 22)
    private String iffFbsoukinmokutekinaiyou;

    public String getIffFbsoukinmokutekinaiyou() {
        return iffFbsoukinmokutekinaiyou;
    }

    public void setIffFbsoukinmokutekinaiyou(String pIffFbsoukinmokutekinaiyou) {
        iffFbsoukinmokutekinaiyou = pIffFbsoukinmokutekinaiyou;
    }

    @Column(order = 16, length = 20)
    private String iffFblicenseno;

    public String getIffFblicenseno() {
        return iffFblicenseno;
    }

    public void setIffFblicenseno(String pIffFblicenseno) {
        iffFblicenseno = pIffFblicenseno;
    }

    @Column(order = 17, length = 8)
    private String iffFblicenseymd;

    public String getIffFblicenseymd() {
        return iffFblicenseymd;
    }

    public void setIffFblicenseymd(String pIffFblicenseymd) {
        iffFblicenseymd = pIffFblicenseymd;
    }

    @Column(order = 18, length = 121)
    private String iffFbdummy121;

    public String getIffFbdummy121() {
        return iffFbdummy121;
    }

    public void setIffFbdummy121(String pIffFbdummy121) {
        iffFbdummy121 = pIffFbdummy121;
    }

    @Column(order = 19, length = 11)
    private String iffFbkokyakusikibetuno;

    public String getIffFbkokyakusikibetuno() {
        return iffFbkokyakusikibetuno;
    }

    public void setIffFbkokyakusikibetuno(String pIffFbkokyakusikibetuno) {
        iffFbkokyakusikibetuno = pIffFbkokyakusikibetuno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
