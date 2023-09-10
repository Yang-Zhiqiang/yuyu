package yuyu.def.sinkeiyaku.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）サンクスコール対象契約一覧レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkThanksCallKeiyakuItiranLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkThanksCallKeiyakuItiranLayoutFile() {
    }


    @Column(order = 1, label = "証券番号")
    private String ifeSyono;


    public String getIfeSyono() {
        return ifeSyono;
    }


    public void setIfeSyono(String pIfeSyono) {
        ifeSyono = pIfeSyono;
    }


    @Column(order = 2, label = "氏名（契約者）")
    private String ifeKyknmkj;


    public String getIfeKyknmkj() {
        return ifeKyknmkj;
    }


    public void setIfeKyknmkj(String pIfeKyknmkj) {
        ifeKyknmkj = pIfeKyknmkj;
    }


    @Column(order = 3, label = "カナ（契約者）")
    private String ifeKyknmkn;


    public String getIfeKyknmkn() {
        return ifeKyknmkn;
    }


    public void setIfeKyknmkn(String pIfeKyknmkn) {
        ifeKyknmkn = pIfeKyknmkn;
    }


    @Column(order = 4, label = "生年月日（契約者）")
    private String ifeKykseiymd;


    public String getIfeKykseiymd() {
        return ifeKykseiymd;
    }


    public void setIfeKykseiymd(String pIfeKykseiymd) {
        ifeKykseiymd = pIfeKykseiymd;
    }


    @Column(order = 5, label = "性別（契約者）")
    private String ifeKykseistr;


    public String getIfeKykseistr() {
        return ifeKykseistr;
    }


    public void setIfeKykseistr(String pIfeKykseistr) {
        ifeKykseistr = pIfeKykseistr;
    }


    @Column(order = 6, label = "契約者職業")
    private String ifeKyksyokugyou;


    public String getIfeKyksyokugyou() {
        return ifeKyksyokugyou;
    }


    public void setIfeKyksyokugyou(String pIfeKyksyokugyou) {
        ifeKyksyokugyou = pIfeKyksyokugyou;
    }


    @Column(order = 7, label = "氏名（被保険者）")
    private String ifeHhknnmkj;


    public String getIfeHhknnmkj() {
        return ifeHhknnmkj;
    }


    public void setIfeHhknnmkj(String pIfeHhknnmkj) {
        ifeHhknnmkj = pIfeHhknnmkj;
    }


    @Column(order = 8, label = "電話番号１")
    private String ifeTelno;


    public String getIfeTelno() {
        return ifeTelno;
    }


    public void setIfeTelno(String pIfeTelno) {
        ifeTelno = pIfeTelno;
    }


    @Column(order = 9, label = "電話番号２")
    private String ifeTelno2;


    public String getIfeTelno2() {
        return ifeTelno2;
    }


    public void setIfeTelno2(String pIfeTelno2) {
        ifeTelno2 = pIfeTelno2;
    }


    @Column(order = 10, label = "支店名")
    private String ifeTratkiagnm;


    public String getIfeTratkiagnm() {
        return ifeTratkiagnm;
    }


    public void setIfeTratkiagnm(String pIfeTratkiagnm) {
        ifeTratkiagnm = pIfeTratkiagnm;
    }


    @Column(order = 11, label = "募集担当者Ａ")
    private String ifeBosyuunm1;


    public String getIfeBosyuunm1() {
        return ifeBosyuunm1;
    }


    public void setIfeBosyuunm1(String pIfeBosyuunm1) {
        ifeBosyuunm1 = pIfeBosyuunm1;
    }


    @Column(order = 12, label = "募集担当者Ｂ")
    private String ifeBosyuunm2;


    public String getIfeBosyuunm2() {
        return ifeBosyuunm2;
    }


    public void setIfeBosyuunm2(String pIfeBosyuunm2) {
        ifeBosyuunm2 = pIfeBosyuunm2;
    }


    @Column(order = 13, label = "成立日")
    private String ifeSeirituymd;


    public String getIfeSeirituymd() {
        return ifeSeirituymd;
    }


    public void setIfeSeirituymd(String pIfeSeirituymd) {
        ifeSeirituymd = pIfeSeirituymd;
    }


    @Column(order = 14, label = "申込日")
    private String ifeMosymd;


    public String getIfeMosymd() {
        return ifeMosymd;
    }


    public void setIfeMosymd(String pIfeMosymd) {
        ifeMosymd = pIfeMosymd;
    }


    @Column(order = 15, label = "契約日")
    private String ifeKykymd;


    public String getIfeKykymd() {
        return ifeKykymd;
    }


    public void setIfeKykymd(String pIfeKykymd) {
        ifeKykymd = pIfeKykymd;
    }


    @Column(order = 16, label = "証券到着予定日")
    private String ifeSyoukenttykymd;


    public String getIfeSyoukenttykymd() {
        return ifeSyoukenttykymd;
    }


    public void setIfeSyoukenttykymd(String pIfeSyoukenttykymd) {
        ifeSyoukenttykymd = pIfeSyoukenttykymd;
    }


    @Column(order = 17, label = "クーリングオフ適用可能日(目安)")
    private String ifeCoolingoffymd;


    public String getIfeCoolingoffymd() {
        return ifeCoolingoffymd;
    }


    public void setIfeCoolingoffymd(String pIfeCoolingoffymd) {
        ifeCoolingoffymd = pIfeCoolingoffymd;
    }


    @Column(order = 18, label = "保険商品")
    private String ifeAisyoumei;


    public String getIfeAisyoumei() {
        return ifeAisyoumei;
    }


    public void setIfeAisyoumei(String pIfeAisyoumei) {
        ifeAisyoumei = pIfeAisyoumei;
    }


    @Column(order = 19, label = "払込通貨")
    private String ifeHrktuuka;


    public String getIfeHrktuuka() {
        return ifeHrktuuka;
    }


    public void setIfeHrktuuka(String pIfeHrktuuka) {
        ifeHrktuuka = pIfeHrktuuka;
    }


    @Column(order = 20, label = "通貨")
    private String ifeSiteituuka;


    public String getIfeSiteituuka() {
        return ifeSiteituuka;
    }


    public void setIfeSiteituuka(String pIfeSiteituuka) {
        ifeSiteituuka = pIfeSiteituuka;
    }


    @Column(order = 21, label = "保険料（外貨）")
    private String ifePgaika;


    public String getIfePgaika() {
        return ifePgaika;
    }


    public void setIfePgaika(String pIfePgaika) {
        ifePgaika = pIfePgaika;
    }


    @Column(order = 22, label = "保険料（円)")
    private String ifePyen;


    public String getIfePyen() {
        return ifePyen;
    }


    public void setIfePyen(String pIfePyen) {
        ifePyen = pIfePyen;
    }


    @Column(order = 23, label = "電子申込")
    private String ifePaperlessmoshyj;


    public String getIfePaperlessmoshyj() {
        return ifePaperlessmoshyj;
    }


    public void setIfePaperlessmoshyj(String pIfePaperlessmoshyj) {
        ifePaperlessmoshyj = pIfePaperlessmoshyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
