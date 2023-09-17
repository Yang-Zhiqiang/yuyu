package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）予定利率連動ファイル（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzYoteirirituRendouFileDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzYoteirirituRendouFileDataRecordLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）商品コード")
    private String ifcSyouhncd;

    public String getIfcSyouhncd() {
        return ifcSyouhncd;
    }

    public void setIfcSyouhncd(String pIfcSyouhncd) {
        ifcSyouhncd = pIfcSyouhncd;
    }

    @Column(order = 2, label = "（ＩＦｃ）予定利率適用分類１")
    private String ifcYoteiriritutkybr1;

    public String getIfcYoteiriritutkybr1() {
        return ifcYoteiriritutkybr1;
    }

    public void setIfcYoteiriritutkybr1(String pIfcYoteiriritutkybr1) {
        ifcYoteiriritutkybr1 = pIfcYoteiriritutkybr1;
    }

    @Column(order = 3, label = "（ＩＦｃ）予定利率適用分類２")
    private String ifcYoteiriritutkybr2;

    public String getIfcYoteiriritutkybr2() {
        return ifcYoteiriritutkybr2;
    }

    public void setIfcYoteiriritutkybr2(String pIfcYoteiriritutkybr2) {
        ifcYoteiriritutkybr2 = pIfcYoteiriritutkybr2;
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

    @Column(order = 7, label = "（ＩＦｃ）予定利率")
    private BizNumber ifcYoteiriritu;

    public BizNumber getIfcYoteiriritu() {
        return ifcYoteiriritu;
    }

    public void setIfcYoteiriritu(BizNumber pIfcYoteiriritu) {
        ifcYoteiriritu = pIfcYoteiriritu;
    }

    @Column(order = 8, label = "（ＩＦｃ）積立利率")
    private BizNumber ifcTumitateriritu;

    public BizNumber getIfcTumitateriritu() {
        return ifcTumitateriritu;
    }

    public void setIfcTumitateriritu(BizNumber pIfcTumitateriritu) {
        ifcTumitateriritu = pIfcTumitateriritu;
    }

    @Column(order = 9, label = "（ＩＦｃ）積立金増加率上限")
    private BizNumber ifcTmttknzoukaritujygn;

    public BizNumber getIfcTmttknzoukaritujygn() {
        return ifcTmttknzoukaritujygn;
    }

    public void setIfcTmttknzoukaritujygn(BizNumber pIfcTmttknzoukaritujygn) {
        ifcTmttknzoukaritujygn = pIfcTmttknzoukaritujygn;
    }

    @Column(order = 10, label = "（ＩＦｃ）設定倍率")
    private BizNumber ifcSetteibairitu;

    public BizNumber getIfcSetteibairitu() {
        return ifcSetteibairitu;
    }

    public void setIfcSetteibairitu(BizNumber pIfcSetteibairitu) {
        ifcSetteibairitu = pIfcSetteibairitu;
    }

    @Column(order = 11, label = "（ＩＦｃ）ローディング変更後積立利率")
    private BizNumber ifcLoadinghnkgtmttrrt;

    public BizNumber getIfcLoadinghnkgtmttrrt() {
        return ifcLoadinghnkgtmttrrt;
    }

    public void setIfcLoadinghnkgtmttrrt(BizNumber pIfcLoadinghnkgtmttrrt) {
        ifcLoadinghnkgtmttrrt = pIfcLoadinghnkgtmttrrt;
    }

    @Column(order = 12, label = "（ＩＦｃ）連動率")
    private BizNumber ifcRendouritu;

    public BizNumber getIfcRendouritu() {
        return ifcRendouritu;
    }

    public void setIfcRendouritu(BizNumber pIfcRendouritu) {
        ifcRendouritu = pIfcRendouritu;
    }

    @Column(order = 13, label = "（ＩＦｃ）契約日")
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
