package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）一時払保有契約情報ファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhItijibrHyukykInfoFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhItijibrHyukykInfoFile() {
    }

    @Column(order = 1, label = "保険会社コード")
    private String ifcHknkaisyacd;

    public String getIfcHknkaisyacd() {
        return ifcHknkaisyacd;
    }

    public void setIfcHknkaisyacd(String pIfcHknkaisyacd) {
        ifcHknkaisyacd = pIfcHknkaisyacd;
    }

    @Column(order = 2, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 3, label = "枝番")
    private String ifcEdano;

    public String getIfcEdano() {
        return ifcEdano;
    }

    public void setIfcEdano(String pIfcEdano) {
        ifcEdano = pIfcEdano;
    }

    @Column(order = 4, label = "通貨")
    private String ifcTuuka;

    public String getIfcTuuka() {
        return ifcTuuka;
    }

    public void setIfcTuuka(String pIfcTuuka) {
        ifcTuuka = pIfcTuuka;
    }

    @Column(order = 5, label = "一時払Ｐ（円）")
    private String ifcItijipyen;

    public String getIfcItijipyen() {
        return ifcItijipyen;
    }

    public void setIfcItijipyen(String pIfcItijipyen) {
        ifcItijipyen = pIfcItijipyen;
    }

    @Column(order = 6, label = "一時払Ｐ（外貨）")
    private String ifcItijipgaika;

    public String getIfcItijipgaika() {
        return ifcItijipgaika;
    }

    public void setIfcItijipgaika(String pIfcItijipgaika) {
        ifcItijipgaika = pIfcItijipgaika;
    }

    @Column(order = 7, label = "既受取金（円）")
    private String ifcKiuktrknyen;

    public String getIfcKiuktrknyen() {
        return ifcKiuktrknyen;
    }

    public void setIfcKiuktrknyen(String pIfcKiuktrknyen) {
        ifcKiuktrknyen = pIfcKiuktrknyen;
    }

    @Column(order = 8, label = "既受取金（外貨）")
    private String ifcKiuktrkngaika;

    public String getIfcKiuktrkngaika() {
        return ifcKiuktrkngaika;
    }

    public void setIfcKiuktrkngaika(String pIfcKiuktrkngaika) {
        ifcKiuktrkngaika = pIfcKiuktrkngaika;
    }

    @Column(order = 9, label = "積立金（円）")
    private String ifcTmttknyen;

    public String getIfcTmttknyen() {
        return ifcTmttknyen;
    }

    public void setIfcTmttknyen(String pIfcTmttknyen) {
        ifcTmttknyen = pIfcTmttknyen;
    }

    @Column(order = 10, label = "積立金（外貨）")
    private String ifcTmttkngaika;

    public String getIfcTmttkngaika() {
        return ifcTmttkngaika;
    }

    public void setIfcTmttkngaika(String pIfcTmttkngaika) {
        ifcTmttkngaika = pIfcTmttkngaika;
    }

    @Column(order = 11, label = "解約控除等（円）")
    private String ifcKaiyakukjetcyen;

    public String getIfcKaiyakukjetcyen() {
        return ifcKaiyakukjetcyen;
    }

    public void setIfcKaiyakukjetcyen(String pIfcKaiyakukjetcyen) {
        ifcKaiyakukjetcyen = pIfcKaiyakukjetcyen;
    }

    @Column(order = 12, label = "解約控除等（外貨）")
    private String ifcKaiyakukjetcgaika;

    public String getIfcKaiyakukjetcgaika() {
        return ifcKaiyakukjetcgaika;
    }

    public void setIfcKaiyakukjetcgaika(String pIfcKaiyakukjetcgaika) {
        ifcKaiyakukjetcgaika = pIfcKaiyakukjetcgaika;
    }

    @Column(order = 13, label = "解約返戻金（円）")
    private String ifcKaiyakuhrknyen;

    public String getIfcKaiyakuhrknyen() {
        return ifcKaiyakuhrknyen;
    }

    public void setIfcKaiyakuhrknyen(String pIfcKaiyakuhrknyen) {
        ifcKaiyakuhrknyen = pIfcKaiyakuhrknyen;
    }

    @Column(order = 14, label = "解約返戻金（外貨）")
    private String ifcKaiyakuhrkngaika;

    public String getIfcKaiyakuhrkngaika() {
        return ifcKaiyakuhrkngaika;
    }

    public void setIfcKaiyakuhrkngaika(String pIfcKaiyakuhrkngaika) {
        ifcKaiyakuhrkngaika = pIfcKaiyakuhrkngaika;
    }

    @Column(order = 15, label = "損益（円）")
    private String ifcSonekiyen;

    public String getIfcSonekiyen() {
        return ifcSonekiyen;
    }

    public void setIfcSonekiyen(String pIfcSonekiyen) {
        ifcSonekiyen = pIfcSonekiyen;
    }

    @Column(order = 16, label = "損益（外貨）")
    private String ifcSonekigaika;

    public String getIfcSonekigaika() {
        return ifcSonekigaika;
    }

    public void setIfcSonekigaika(String pIfcSonekigaika) {
        ifcSonekigaika = pIfcSonekigaika;
    }

    @Column(order = 17, label = "死亡保険金等（円）")
    private String ifcSbsetcyen;

    public String getIfcSbsetcyen() {
        return ifcSbsetcyen;
    }

    public void setIfcSbsetcyen(String pIfcSbsetcyen) {
        ifcSbsetcyen = pIfcSbsetcyen;
    }

    @Column(order = 18, label = "死亡保険金等（外貨）")
    private String ifcSbsetcgaika;

    public String getIfcSbsetcgaika() {
        return ifcSbsetcgaika;
    }

    public void setIfcSbsetcgaika(String pIfcSbsetcgaika) {
        ifcSbsetcgaika = pIfcSbsetcgaika;
    }

    @Column(order = 19, label = "損益計算不能フラグ")
    private String ifcSonekicalchunouflg;

    public String getIfcSonekicalchunouflg() {
        return ifcSonekicalchunouflg;
    }

    public void setIfcSonekicalchunouflg(String pIfcSonekicalchunouflg) {
        ifcSonekicalchunouflg = pIfcSonekicalchunouflg;
    }

    @Column(order = 20, label = "保険種類記号")
    private String ifcHknsyuruikigou;

    public String getIfcHknsyuruikigou() {
        return ifcHknsyuruikigou;
    }

    public void setIfcHknsyuruikigou(String pIfcHknsyuruikigou) {
        ifcHknsyuruikigou = pIfcHknsyuruikigou;
    }

    @Column(order = 21, label = "払済、繰り下げ表示")
    private String ifcHrkzumikurisagehyouji;

    public String getIfcHrkzumikurisagehyouji() {
        return ifcHrkzumikurisagehyouji;
    }

    public void setIfcHrkzumikurisagehyouji(String pIfcHrkzumikurisagehyouji) {
        ifcHrkzumikurisagehyouji = pIfcHrkzumikurisagehyouji;
    }

    @Column(order = 22, label = "親代理店コード")
    private String ifcOyadrtencd;

    public String getIfcOyadrtencd() {
        return ifcOyadrtencd;
    }

    public void setIfcOyadrtencd(String pIfcOyadrtencd) {
        ifcOyadrtencd = pIfcOyadrtencd;
    }

    @Column(order = 23, label = "親代理店名")
    private String ifcOyadrtennm;

    public String getIfcOyadrtennm() {
        return ifcOyadrtennm;
    }

    public void setIfcOyadrtennm(String pIfcOyadrtennm) {
        ifcOyadrtennm = pIfcOyadrtennm;
    }

    @Column(order = 24, label = "愛称名コード")
    private String ifcAisyoumeicd;

    public String getIfcAisyoumeicd() {
        return ifcAisyoumeicd;
    }

    public void setIfcAisyoumeicd(String pIfcAisyoumeicd) {
        ifcAisyoumeicd = pIfcAisyoumeicd;
    }

    @Column(order = 25, label = "愛称名")
    private String ifcAisyoumei;

    public String getIfcAisyoumei() {
        return ifcAisyoumei;
    }

    public void setIfcAisyoumei(String pIfcAisyoumei) {
        ifcAisyoumei = pIfcAisyoumei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
