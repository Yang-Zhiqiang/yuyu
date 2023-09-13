package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_SyouhnBunruiTmttkinyskKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * （保全）積立金予測ＣＳＶＦ データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhTmttkinYskCsvFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhTmttkinYskCsvFile() {
    }

    @Column(order = 1, label = "商品分類")
    private C_SyouhnBunruiTmttkinyskKbn ifcSyouhnbunruittknyskkbn;

    public C_SyouhnBunruiTmttkinyskKbn getIfcSyouhnbunruittknyskkbn() {
        return ifcSyouhnbunruittknyskkbn;
    }

    public void setIfcSyouhnbunruittknyskkbn(C_SyouhnBunruiTmttkinyskKbn pIfcSyouhnbunruittknyskkbn) {
        ifcSyouhnbunruittknyskkbn = pIfcSyouhnbunruittknyskkbn;
    }

    @Column(order = 2, label = "契約通貨種類")
    private C_Tuukasyu ifcKyktuukasyukbn;

    public C_Tuukasyu getIfcKyktuukasyukbn() {
        return ifcKyktuukasyukbn;
    }

    public void setIfcKyktuukasyukbn(C_Tuukasyu pIfcKyktuukasyukbn) {
        ifcKyktuukasyukbn = pIfcKyktuukasyukbn;
    }

    @Column(order = 3, label = "契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Column(order = 4, label = "契約時市場価格調整用利率")
    private BizNumber ifcKyksjkkktyouseiriritu;

    public BizNumber getIfcKyksjkkktyouseiriritu() {
        return ifcKyksjkkktyouseiriritu;
    }

    public void setIfcKyksjkkktyouseiriritu(BizNumber pIfcKyksjkkktyouseiriritu) {
        ifcKyksjkkktyouseiriritu = pIfcKyksjkkktyouseiriritu;
    }

    @Column(order = 5, label = "ターゲット特約付加有無")
    private C_UmuKbn ifcTargettkhkumu;

    public C_UmuKbn getIfcTargettkhkumu() {
        return ifcTargettkhkumu;
    }

    public void setIfcTargettkhkumu(C_UmuKbn pIfcTargettkhkumu) {
        ifcTargettkhkumu = pIfcTargettkhkumu;
    }

    @Column(order = 6, label = "ターゲット特約目標値")
    private Integer ifcTargettkmkht;

    public Integer getIfcTargettkmkht() {
        return ifcTargettkmkht;
    }

    public void setIfcTargettkmkht(Integer pIfcTargettkmkht) {
        ifcTargettkmkht = pIfcTargettkmkht;
    }

    @Column(order = 7, label = "契約通貨建保険料合計")
    private BizCurrency ifcKyktuukapgk;

    public BizCurrency getIfcKyktuukapgk() {
        return ifcKyktuukapgk;
    }

    public void setIfcKyktuukapgk(BizCurrency pIfcKyktuukapgk) {
        ifcKyktuukapgk = pIfcKyktuukapgk;
    }

    @Column(order = 8, label = "契約通貨建積立金額合計")
    private BizCurrency ifcKyktuukatmttkngkgk;

    public BizCurrency getIfcKyktuukatmttkngkgk() {
        return ifcKyktuukatmttkngkgk;
    }

    public void setIfcKyktuukatmttkngkgk(BizCurrency pIfcKyktuukatmttkngkgk) {
        ifcKyktuukatmttkngkgk = pIfcKyktuukatmttkngkgk;
    }

    @Column(order = 9, label = "契約通貨建解約返戻金額合計")
    private BizCurrency ifcKyktuukakaiyakuhrgkgk;

    public BizCurrency getIfcKyktuukakaiyakuhrgkgk() {
        return ifcKyktuukakaiyakuhrgkgk;
    }

    public void setIfcKyktuukakaiyakuhrgkgk(BizCurrency pIfcKyktuukakaiyakuhrgkgk) {
        ifcKyktuukakaiyakuhrgkgk = pIfcKyktuukakaiyakuhrgkgk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
