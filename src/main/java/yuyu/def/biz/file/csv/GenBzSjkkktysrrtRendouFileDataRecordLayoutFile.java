package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）市場価格調整用利率連動ファイル（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSjkkktysrrtRendouFileDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSjkkktysrrtRendouFileDataRecordLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）商品コード")
    private String ifcSyouhncd;

    public String getIfcSyouhncd() {
        return ifcSyouhncd;
    }

    public void setIfcSyouhncd(String pIfcSyouhncd) {
        ifcSyouhncd = pIfcSyouhncd;
    }

    @Column(order = 2, label = "（ＩＦｃ）市場価格調整用利率適用分類１")
    private String ifcSjkkktyouseiriritutkybr1;

    public String getIfcSjkkktyouseiriritutkybr1() {
        return ifcSjkkktyouseiriritutkybr1;
    }

    public void setIfcSjkkktyouseiriritutkybr1(String pIfcSjkkktyouseiriritutkybr1) {
        ifcSjkkktyouseiriritutkybr1 = pIfcSjkkktyouseiriritutkybr1;
    }

    @Column(order = 3, label = "（ＩＦｃ）市場価格調整用利率適用分類２")
    private String ifcSjkkktyouseiriritutkybr2;

    public String getIfcSjkkktyouseiriritutkybr2() {
        return ifcSjkkktyouseiriritutkybr2;
    }

    public void setIfcSjkkktyouseiriritutkybr2(String pIfcSjkkktyouseiriritutkybr2) {
        ifcSjkkktyouseiriritutkybr2 = pIfcSjkkktyouseiriritutkybr2;
    }

    @Column(order = 4, label = "（ＩＦｃ）基準日自")
    private BizDate ifcKijyunfromymd;

    public BizDate getIfcKijyunfromymd() {
        return ifcKijyunfromymd;
    }

    public void setIfcKijyunfromymd(BizDate pIfcKijyunfromymd) {
        ifcKijyunfromymd = pIfcKijyunfromymd;
    }

    @Column(order = 5, label = "（ＩＦｃ）基準日至")
    private BizDate ifcKijyuntoymd;

    public BizDate getIfcKijyuntoymd() {
        return ifcKijyuntoymd;
    }

    public void setIfcKijyuntoymd(BizDate pIfcKijyuntoymd) {
        ifcKijyuntoymd = pIfcKijyuntoymd;
    }

    @Column(order = 6, label = "（ＩＦｃ）通貨種類")
    private String ifcTuukasyu;

    public String getIfcTuukasyu() {
        return ifcTuukasyu;
    }

    public void setIfcTuukasyu(String pIfcTuukasyu) {
        ifcTuukasyu = pIfcTuukasyu;
    }

    @Column(order = 7, label = "（ＩＦｃ）市場価格調整用利率")
    private BizNumber ifcSjkkktyouseiyouriritu;

    public BizNumber getIfcSjkkktyouseiyouriritu() {
        return ifcSjkkktyouseiyouriritu;
    }

    public void setIfcSjkkktyouseiyouriritu(BizNumber pIfcSjkkktyouseiyouriritu) {
        ifcSjkkktyouseiyouriritu = pIfcSjkkktyouseiyouriritu;
    }

    @Column(order = 8, label = "（ＩＦｃ）契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
