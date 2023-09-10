package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）不備分析リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHubibunsekiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkHubibunsekiLayoutFile() {
    }

    @Column(order = 1, label = "発信日")
    private String ifcHasinymd;

    public String getIfcHasinymd() {
        return ifcHasinymd;
    }

    public void setIfcHasinymd(String pIfcHasinymd) {
        ifcHasinymd = pIfcHasinymd;
    }

    @Column(order = 2, label = "申込番号")
    private String ifcMosno;

    public String getIfcMosno() {
        return ifcMosno;
    }

    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }

    @Column(order = 3, label = "代理店コード")
    private String ifcDrtencd;

    public String getIfcDrtencd() {
        return ifcDrtencd;
    }

    public void setIfcDrtencd(String pIfcDrtencd) {
        ifcDrtencd = pIfcDrtencd;
    }

    @Column(order = 4, label = "事務所コード")
    private String ifcJimusyocd;

    public String getIfcJimusyocd() {
        return ifcJimusyocd;
    }

    public void setIfcJimusyocd(String pIfcJimusyocd) {
        ifcJimusyocd = pIfcJimusyocd;
    }

    @Column(order = 5, label = "代理店名")
    private String ifcDrtennmkj;

    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }

    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }

    @Column(order = 6, label = "打出機関名１")
    private String ifcUtidasikikannm1;

    public String getIfcUtidasikikannm1() {
        return ifcUtidasikikannm1;
    }

    public void setIfcUtidasikikannm1(String pIfcUtidasikikannm1) {
        ifcUtidasikikannm1 = pIfcUtidasikikannm1;
    }

    @Column(order = 7, label = "打出機関名２")
    private String ifcUtidasikikannm2;

    public String getIfcUtidasikikannm2() {
        return ifcUtidasikikannm2;
    }

    public void setIfcUtidasikikannm2(String pIfcUtidasikikannm2) {
        ifcUtidasikikannm2 = pIfcUtidasikikannm2;
    }

    @Column(order = 8, label = "不備区分")
    private String ifcSkhubikoumokucd;

    public String getIfcSkhubikoumokucd() {
        return ifcSkhubikoumokucd;
    }

    public void setIfcSkhubikoumokucd(String pIfcSkhubikoumokucd) {
        ifcSkhubikoumokucd = pIfcSkhubikoumokucd;
    }

    @Column(order = 9, label = "不備区分内容")
    private String ifcSkhubikoumoku;

    public String getIfcSkhubikoumoku() {
        return ifcSkhubikoumoku;
    }

    public void setIfcSkhubikoumoku(String pIfcSkhubikoumoku) {
        ifcSkhubikoumoku = pIfcSkhubikoumoku;
    }

    @Column(order = 10, label = "不備理由コード")
    private String ifcSkhubinaiyoucd;

    public String getIfcSkhubinaiyoucd() {
        return ifcSkhubinaiyoucd;
    }

    public void setIfcSkhubinaiyoucd(String pIfcSkhubinaiyoucd) {
        ifcSkhubinaiyoucd = pIfcSkhubinaiyoucd;
    }

    @Column(order = 11, label = "不備理由")
    private String ifcSkhubinaiyou;

    public String getIfcSkhubinaiyou() {
        return ifcSkhubinaiyou;
    }

    public void setIfcSkhubinaiyou(String pIfcSkhubinaiyou) {
        ifcSkhubinaiyou = pIfcSkhubinaiyou;
    }

    @Column(order = 12, label = "整備指示内容コード")
    private String ifcSkseibisijinaiyoucd;

    public String getIfcSkseibisijinaiyoucd() {
        return ifcSkseibisijinaiyoucd;
    }

    public void setIfcSkseibisijinaiyoucd(String pIfcSkseibisijinaiyoucd) {
        ifcSkseibisijinaiyoucd = pIfcSkseibisijinaiyoucd;
    }

    @Column(order = 13, label = "整備指示内容")
    private String ifcSkseibisijinaiyou;

    public String getIfcSkseibisijinaiyou() {
        return ifcSkseibisijinaiyou;
    }

    public void setIfcSkseibisijinaiyou(String pIfcSkseibisijinaiyou) {
        ifcSkseibisijinaiyou = pIfcSkseibisijinaiyou;
    }

    @Column(order = 14, label = "その他連絡事項")
    private String ifcSonotarenrakujikou;

    public String getIfcSonotarenrakujikou() {
        return ifcSonotarenrakujikou;
    }

    public void setIfcSonotarenrakujikou(String pIfcSonotarenrakujikou) {
        ifcSonotarenrakujikou = pIfcSonotarenrakujikou;
    }

    @Column(order = 15, label = "申込年月日")
    private String ifcMosymd;

    public String getIfcMosymd() {
        return ifcMosymd;
    }

    public void setIfcMosymd(String pIfcMosymd) {
        ifcMosymd = pIfcMosymd;
    }

    @Column(order = 16, label = "申込書入力日")
    private String ifcMosnyuuryokuymd;

    public String getIfcMosnyuuryokuymd() {
        return ifcMosnyuuryokuymd;
    }

    public void setIfcMosnyuuryokuymd(String pIfcMosnyuuryokuymd) {
        ifcMosnyuuryokuymd = pIfcMosnyuuryokuymd;
    }

    @Column(order = 17, label = "統計用保険種類区分")
    private String ifcToukeiyouhokensyuruikbn;

    public String getIfcToukeiyouhokensyuruikbn() {
        return ifcToukeiyouhokensyuruikbn;
    }

    public void setIfcToukeiyouhokensyuruikbn(String pIfcToukeiyouhokensyuruikbn) {
        ifcToukeiyouhokensyuruikbn = pIfcToukeiyouhokensyuruikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
