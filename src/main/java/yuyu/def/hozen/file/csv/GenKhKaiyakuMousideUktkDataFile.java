package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）解約申出受付データファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKaiyakuMousideUktkDataFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhKaiyakuMousideUktkDataFile() {
    }

    @Column(order = 1, label = "証券番号主番")
    private String ifcSyonosyuban;

    public String getIfcSyonosyuban() {
        return ifcSyonosyuban;
    }

    public void setIfcSyonosyuban(String pIfcSyonosyuban) {
        ifcSyonosyuban = pIfcSyonosyuban;
    }

    @Column(order = 2, label = "新契約募集時漢字代理店名")
    private String ifcSkeibsyknjdrten;

    public String getIfcSkeibsyknjdrten() {
        return ifcSkeibsyknjdrten;
    }

    public void setIfcSkeibsyknjdrten(String pIfcSkeibsyknjdrten) {
        ifcSkeibsyknjdrten = pIfcSkeibsyknjdrten;
    }

    @Column(order = 3, label = "漢字親代理店名")
    private String ifcKnjoyadrtennm;

    public String getIfcKnjoyadrtennm() {
        return ifcKnjoyadrtennm;
    }

    public void setIfcKnjoyadrtennm(String pIfcKnjoyadrtennm) {
        ifcKnjoyadrtennm = pIfcKnjoyadrtennm;
    }

    @Column(order = 4, label = "漢字契約者名")
    private String ifcKnjkyksyamei;

    public String getIfcKnjkyksyamei() {
        return ifcKnjkyksyamei;
    }

    public void setIfcKnjkyksyamei(String pIfcKnjkyksyamei) {
        ifcKnjkyksyamei = pIfcKnjkyksyamei;
    }

    @Column(order = 5, label = "申込年月日")
    private String ifcMusymd;

    public String getIfcMusymd() {
        return ifcMusymd;
    }

    public void setIfcMusymd(String pIfcMusymd) {
        ifcMusymd = pIfcMusymd;
    }

    @Column(order = 6, label = "漢字主契約保種名")
    private String ifcKnjsyuhsynm;

    public String getIfcKnjsyuhsynm() {
        return ifcKnjsyuhsynm;
    }

    public void setIfcKnjsyuhsynm(String pIfcKnjsyuhsynm) {
        ifcKnjsyuhsynm = pIfcKnjsyuhsynm;
    }

    @Column(order = 7, label = "前納表示")
    private String ifcZennouhyouji;

    public String getIfcZennouhyouji() {
        return ifcZennouhyouji;
    }

    public void setIfcZennouhyouji(String pIfcZennouhyouji) {
        ifcZennouhyouji = pIfcZennouhyouji;
    }

    @Column(order = 8, label = "払込保険料")
    private String ifcHrkp;

    public String getIfcHrkp() {
        return ifcHrkp;
    }

    public void setIfcHrkp(String pIfcHrkp) {
        ifcHrkp = pIfcHrkp;
    }

    @Column(order = 9, label = "払込保険料通貨種類")
    private String ifcHrkptuukasyu;

    public String getIfcHrkptuukasyu() {
        return ifcHrkptuukasyu;
    }

    public void setIfcHrkptuukasyu(String pIfcHrkptuukasyu) {
        ifcHrkptuukasyu = pIfcHrkptuukasyu;
    }

    @Column(order = 10, label = "親代理店コード")
    private String ifcOyadrtencd;

    public String getIfcOyadrtencd() {
        return ifcOyadrtencd;
    }

    public void setIfcOyadrtencd(String pIfcOyadrtencd) {
        ifcOyadrtencd = pIfcOyadrtencd;
    }

    @Column(order = 11, label = "合計保険料")
    private String ifcKeip;

    public String getIfcKeip() {
        return ifcKeip;
    }

    public void setIfcKeip(String pIfcKeip) {
        ifcKeip = pIfcKeip;
    }

    @Column(order = 12, label = "払込方法")
    private String ifcHrkhou;

    public String getIfcHrkhou() {
        return ifcHrkhou;
    }

    public void setIfcHrkhou(String pIfcHrkhou) {
        ifcHrkhou = pIfcHrkhou;
    }

    @Column(order = 13, label = "新契約募集時代理店コード")
    private String ifcSkeibsyknjdrtencd;

    public String getIfcSkeibsyknjdrtencd() {
        return ifcSkeibsyknjdrtencd;
    }

    public void setIfcSkeibsyknjdrtencd(String pIfcSkeibsyknjdrtencd) {
        ifcSkeibsyknjdrtencd = pIfcSkeibsyknjdrtencd;
    }

    @Column(order = 14, label = "共同扱代理店コード")
    private String ifcKydatkidrtencd;

    public String getIfcKydatkidrtencd() {
        return ifcKydatkidrtencd;
    }

    public void setIfcKydatkidrtencd(String pIfcKydatkidrtencd) {
        ifcKydatkidrtencd = pIfcKydatkidrtencd;
    }

    @Column(order = 15, label = "募集人コード")
    private String ifcBosyuucd;

    public String getIfcBosyuucd() {
        return ifcBosyuucd;
    }

    public void setIfcBosyuucd(String pIfcBosyuucd) {
        ifcBosyuucd = pIfcBosyuucd;
    }

    @Column(order = 16, label = "募集人氏名")
    private String ifcBosyuunm;

    public String getIfcBosyuunm() {
        return ifcBosyuunm;
    }

    public void setIfcBosyuunm(String pIfcBosyuunm) {
        ifcBosyuunm = pIfcBosyuunm;
    }

    @Column(order = 17, label = "漢字被保険者名")
    private String ifcKnjhknmei;

    public String getIfcKnjhknmei() {
        return ifcKnjhknmei;
    }

    public void setIfcKnjhknmei(String pIfcKnjhknmei) {
        ifcKnjhknmei = pIfcKnjhknmei;
    }

    @Column(order = 18, label = "代理店保有契約代理店コード")
    private String ifcDrtenhydrtencd;

    public String getIfcDrtenhydrtencd() {
        return ifcDrtenhydrtencd;
    }

    public void setIfcDrtenhydrtencd(String pIfcDrtenhydrtencd) {
        ifcDrtenhydrtencd = pIfcDrtenhydrtencd;
    }

    @Column(order = 19, label = "漢字代理店名")
    private String ifcKnjdrtennm;

    public String getIfcKnjdrtennm() {
        return ifcKnjdrtennm;
    }

    public void setIfcKnjdrtennm(String pIfcKnjdrtennm) {
        ifcKnjdrtennm = pIfcKnjdrtennm;
    }

    @Column(order = 20, label = "代分コード")
    private String ifcDaibuncd;

    public String getIfcDaibuncd() {
        return ifcDaibuncd;
    }

    public void setIfcDaibuncd(String pIfcDaibuncd) {
        ifcDaibuncd = pIfcDaibuncd;
    }

    @Column(order = 21, label = "代理店属性代理店コード")
    private String ifcDrtenzksidrtencd;

    public String getIfcDrtenzksidrtencd() {
        return ifcDrtenzksidrtencd;
    }

    public void setIfcDrtenzksidrtencd(String pIfcDrtenzksidrtencd) {
        ifcDrtenzksidrtencd = pIfcDrtenzksidrtencd;
    }

    @Column(order = 22, label = "減少事由区分")
    private String ifcGensyojiyukbn;

    public String getIfcGensyojiyukbn() {
        return ifcGensyojiyukbn;
    }

    public void setIfcGensyojiyukbn(String pIfcGensyojiyukbn) {
        ifcGensyojiyukbn = pIfcGensyojiyukbn;
    }

    @Column(order = 23, label = "異動区分")
    private String ifcIdoKbn;

    public String getIfcIdoKbn() {
        return ifcIdoKbn;
    }

    public void setIfcIdoKbn(String pIfcIdoKbn) {
        ifcIdoKbn = pIfcIdoKbn;
    }

    @Column(order = 24, label = "契約状態区分")
    private String ifcKykmfkykjyutikbn;

    public String getIfcKykmfkykjyutikbn() {
        return ifcKykmfkykjyutikbn;
    }

    public void setIfcKykmfkykjyutikbn(String pIfcKykmfkykjyutikbn) {
        ifcKykmfkykjyutikbn = pIfcKykmfkykjyutikbn;
    }

    @Column(order = 25, label = "解約情報連絡発信日")
    private String ifcKiykinfoymd;

    public String getIfcKiykinfoymd() {
        return ifcKiykinfoymd;
    }

    public void setIfcKiykinfoymd(String pIfcKiykinfoymd) {
        ifcKiykinfoymd = pIfcKiykinfoymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
