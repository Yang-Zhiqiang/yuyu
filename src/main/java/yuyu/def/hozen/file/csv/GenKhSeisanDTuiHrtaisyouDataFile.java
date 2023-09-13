package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）精算Ｄ追払対象データファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSeisanDTuiHrtaisyouDataFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSeisanDTuiHrtaisyouDataFile() {
    }

    @Column(order = 1, label = "郵便番号")
    private String ifcYno;

    public String getIfcYno() {
        return ifcYno;
    }

    public void setIfcYno(String pIfcYno) {
        ifcYno = pIfcYno;
    }

    @Column(order = 2, label = "契約者名")
    private String ifcKyksyamei;

    public String getIfcKyksyamei() {
        return ifcKyksyamei;
    }

    public void setIfcKyksyamei(String pIfcKyksyamei) {
        ifcKyksyamei = pIfcKyksyamei;
    }

    @Column(order = 3, label = "証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 4, label = "消滅事由")
    private String ifcSyoumetujiyuu;

    public String getIfcSyoumetujiyuu() {
        return ifcSyoumetujiyuu;
    }

    public void setIfcSyoumetujiyuu(String pIfcSyoumetujiyuu) {
        ifcSyoumetujiyuu = pIfcSyoumetujiyuu;
    }

    @Column(order = 5, label = "手続注意内容")
    private String ifcTtdktyuuinaiyou;

    public String getIfcTtdktyuuinaiyou() {
        return ifcTtdktyuuinaiyou;
    }

    public void setIfcTtdktyuuinaiyou(String pIfcTtdktyuuinaiyou) {
        ifcTtdktyuuinaiyou = pIfcTtdktyuuinaiyou;
    }

    @Column(order = 6, label = "支払方法")
    private String ifcShrhou;

    public String getIfcShrhou() {
        return ifcShrhou;
    }

    public void setIfcShrhou(String pIfcShrhou) {
        ifcShrhou = pIfcShrhou;
    }

    @Column(order = 7, label = "支払通貨")
    private String ifcTuukasyu;

    public String getIfcTuukasyu() {
        return ifcTuukasyu;
    }

    public void setIfcTuukasyu(String pIfcTuukasyu) {
        ifcTuukasyu = pIfcTuukasyu;
    }

    @Column(order = 8, label = "支払額合計")
    private BizCurrency ifcShrgkgoukeibizc;

    public BizCurrency getIfcShrgkgoukeibizc() {
        return ifcShrgkgoukeibizc;
    }

    public void setIfcShrgkgoukeibizc(BizCurrency pIfcShrgkgoukeibizc) {
        ifcShrgkgoukeibizc = pIfcShrgkgoukeibizc;
    }

    @Column(order = 9, label = "円貨配当金合計")
    private BizCurrency ifcYenkahaitoukingkbizc;

    public BizCurrency getIfcYenkahaitoukingkbizc() {
        return ifcYenkahaitoukingkbizc;
    }

    public void setIfcYenkahaitoukingkbizc(BizCurrency pIfcYenkahaitoukingkbizc) {
        ifcYenkahaitoukingkbizc = pIfcYenkahaitoukingkbizc;
    }

    @Column(order = 10, label = "円貨配当金")
    private BizCurrency ifcYenkahaitoukinbizc;

    public BizCurrency getIfcYenkahaitoukinbizc() {
        return ifcYenkahaitoukinbizc;
    }

    public void setIfcYenkahaitoukinbizc(BizCurrency pIfcYenkahaitoukinbizc) {
        ifcYenkahaitoukinbizc = pIfcYenkahaitoukinbizc;
    }

    @Column(order = 11, label = "円貨特別配当金")
    private BizCurrency ifcYenkasonotahaitoukinbizc;

    public BizCurrency getIfcYenkasonotahaitoukinbizc() {
        return ifcYenkasonotahaitoukinbizc;
    }

    public void setIfcYenkasonotahaitoukinbizc(BizCurrency pIfcYenkasonotahaitoukinbizc) {
        ifcYenkasonotahaitoukinbizc = pIfcYenkasonotahaitoukinbizc;
    }

    @Column(order = 12, label = "円貨源泉徴収税額")
    private BizCurrency ifcYenkagstszeigkbizc;

    public BizCurrency getIfcYenkagstszeigkbizc() {
        return ifcYenkagstszeigkbizc;
    }

    public void setIfcYenkagstszeigkbizc(BizCurrency pIfcYenkagstszeigkbizc) {
        ifcYenkagstszeigkbizc = pIfcYenkagstszeigkbizc;
    }

    @Column(order = 13, label = "円貨支払遅延利息")
    private BizCurrency ifcYenkashrtienrskbizc;

    public BizCurrency getIfcYenkashrtienrskbizc() {
        return ifcYenkashrtienrskbizc;
    }

    public void setIfcYenkashrtienrskbizc(BizCurrency pIfcYenkashrtienrskbizc) {
        ifcYenkashrtienrskbizc = pIfcYenkashrtienrskbizc;
    }

    @Column(order = 14, label = "外貨配当金")
    private BizCurrency ifcGaikahaitoukingkbizc;

    public BizCurrency getIfcGaikahaitoukingkbizc() {
        return ifcGaikahaitoukingkbizc;
    }

    public void setIfcGaikahaitoukingkbizc(BizCurrency pIfcGaikahaitoukingkbizc) {
        ifcGaikahaitoukingkbizc = pIfcGaikahaitoukingkbizc;
    }

    @Column(order = 15, label = "外貨源泉徴収税額")
    private BizCurrency ifcGaikagstszeigkbizc;

    public BizCurrency getIfcGaikagstszeigkbizc() {
        return ifcGaikagstszeigkbizc;
    }

    public void setIfcGaikagstszeigkbizc(BizCurrency pIfcGaikagstszeigkbizc) {
        ifcGaikagstszeigkbizc = pIfcGaikagstszeigkbizc;
    }

    @Column(order = 16, label = "外貨支払遅延利息")
    private BizCurrency ifcGaikashrtienrskbizc;

    public BizCurrency getIfcGaikashrtienrskbizc() {
        return ifcGaikashrtienrskbizc;
    }

    public void setIfcGaikashrtienrskbizc(BizCurrency pIfcGaikashrtienrskbizc) {
        ifcGaikashrtienrskbizc = pIfcGaikashrtienrskbizc;
    }

    @Column(order = 17, label = "外貨支払時為替レート")
    private BizNumber ifcGaikashrkwsrate;

    public BizNumber getIfcGaikashrkwsrate() {
        return ifcGaikashrkwsrate;
    }

    public void setIfcGaikashrkwsrate(BizNumber pIfcGaikashrkwsrate) {
        ifcGaikashrkwsrate = pIfcGaikashrkwsrate;
    }

    @Column(order = 18, label = "税務用為替レート")
    private BizNumber ifcZeimukwsrate;

    public BizNumber getIfcZeimukwsrate() {
        return ifcZeimukwsrate;
    }

    public void setIfcZeimukwsrate(BizNumber pIfcZeimukwsrate) {
        ifcZeimukwsrate = pIfcZeimukwsrate;
    }

    @Column(order = 19, label = "収入金額")
    private BizCurrency ifcSynykngkbizc;

    public BizCurrency getIfcSynykngkbizc() {
        return ifcSynykngkbizc;
    }

    public void setIfcSynykngkbizc(BizCurrency pIfcSynykngkbizc) {
        ifcSynykngkbizc = pIfcSynykngkbizc;
    }

    @Column(order = 20, label = "必要経費")
    private BizCurrency ifcHtykeihibizc;

    public BizCurrency getIfcHtykeihibizc() {
        return ifcHtykeihibizc;
    }

    public void setIfcHtykeihibizc(BizCurrency pIfcHtykeihibizc) {
        ifcHtykeihibizc = pIfcHtykeihibizc;
    }

    @Column(order = 21, label = "現契約者必要経費")
    private BizCurrency ifcGenkykhtykeihibizc;

    public BizCurrency getIfcGenkykhtykeihibizc() {
        return ifcGenkykhtykeihibizc;
    }

    public void setIfcGenkykhtykeihibizc(BizCurrency pIfcGenkykhtykeihibizc) {
        ifcGenkykhtykeihibizc = pIfcGenkykhtykeihibizc;
    }

    @Column(order = 22, label = "契約者変更回数")
    private Integer ifcKykhnkkaisuu;

    public Integer getIfcKykhnkkaisuu() {
        return ifcKykhnkkaisuu;
    }

    public void setIfcKykhnkkaisuu(Integer pIfcKykhnkkaisuu) {
        ifcKykhnkkaisuu = pIfcKykhnkkaisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
