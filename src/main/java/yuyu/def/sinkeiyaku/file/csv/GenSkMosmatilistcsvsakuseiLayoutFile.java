package yuyu.def.sinkeiyaku.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）申込書類未到着CSVレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMosmatilistcsvsakuseiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkMosmatilistcsvsakuseiLayoutFile() {
    }


    @Column(order = 1, label = "代理店名")
    private String ifcDrtennmkj;


    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }


    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }


    @Column(order = 2, label = "親代理店コード")
    private String ifcOyadrtencd;


    public String getIfcOyadrtencd() {
        return ifcOyadrtencd;
    }


    public void setIfcOyadrtencd(String pIfcOyadrtencd) {
        ifcOyadrtencd = pIfcOyadrtencd;
    }


    @Column(order = 3, label = "打出機関名１")
    private String ifcUtidasikikannm1;


    public String getIfcUtidasikikannm1() {
        return ifcUtidasikikannm1;
    }


    public void setIfcUtidasikikannm1(String pIfcUtidasikikannm1) {
        ifcUtidasikikannm1 = pIfcUtidasikikannm1;
    }


    @Column(order = 4, label = "打出機関名２")
    private String ifcUtidasikikannm2;


    public String getIfcUtidasikikannm2() {
        return ifcUtidasikikannm2;
    }


    public void setIfcUtidasikikannm2(String pIfcUtidasikikannm2) {
        ifcUtidasikikannm2 = pIfcUtidasikikannm2;
    }


    @Column(order = 5, label = "入金日")
    private String ifcNyknymd;


    public String getIfcNyknymd() {
        return ifcNyknymd;
    }


    public void setIfcNyknymd(String pIfcNyknymd) {
        ifcNyknymd = pIfcNyknymd;
    }


    @Column(order = 6, label = "商品番号")
    private String ifcSyouhnno;


    public String getIfcSyouhnno() {
        return ifcSyouhnno;
    }


    public void setIfcSyouhnno(String pIfcSyouhnno) {
        ifcSyouhnno = pIfcSyouhnno;
    }


    @Column(order = 7, label = "申込番号")
    private String ifcMosno;


    public String getIfcMosno() {
        return ifcMosno;
    }


    public void setIfcMosno(String pIfcMosno) {
        ifcMosno = pIfcMosno;
    }


    @Column(order = 8, label = "振込人名")
    private String ifcHrkmirninnm;


    public String getIfcHrkmirninnm() {
        return ifcHrkmirninnm;
    }


    public void setIfcHrkmirninnm(String pIfcHrkmirninnm) {
        ifcHrkmirninnm = pIfcHrkmirninnm;
    }


    @Column(order = 9, label = "入金通貨")
    private String ifcTuukasyu;


    public String getIfcTuukasyu() {
        return ifcTuukasyu;
    }


    public void setIfcTuukasyu(String pIfcTuukasyu) {
        ifcTuukasyu = pIfcTuukasyu;
    }


    @Column(order = 10, label = "入金金額")
    private String ifcTrhkkgk;


    public String getIfcTrhkkgk() {
        return ifcTrhkkgk;
    }


    public void setIfcTrhkkgk(String pIfcTrhkkgk) {
        ifcTrhkkgk = pIfcTrhkkgk;
    }


    @Column(order = 11, label = "伝票金額")
    private String ifcDengk;


    public String getIfcDengk() {
        return ifcDengk;
    }


    public void setIfcDengk(String pIfcDengk) {
        ifcDengk = pIfcDengk;
    }


    @Column(order = 12, label = "振込銀行名")
    private String ifcSimukebanknm;


    public String getIfcSimukebanknm() {
        return ifcSimukebanknm;
    }


    public void setIfcSimukebanknm(String pIfcSimukebanknm) {
        ifcSimukebanknm = pIfcSimukebanknm;
    }


    @Column(order = 13, label = "支店名")
    private String ifcSimuketennm;


    public String getIfcSimuketennm() {
        return ifcSimuketennm;
    }


    public void setIfcSimuketennm(String pIfcSimuketennm) {
        ifcSimuketennm = pIfcSimuketennm;
    }


    @Column(order = 14, label = "入金連絡票日付")
    private String ifcNyknrnrkhyouymd;


    public String getIfcNyknrnrkhyouymd() {
        return ifcNyknrnrkhyouymd;
    }


    public void setIfcNyknrnrkhyouymd(String pIfcNyknrnrkhyouymd) {
        ifcNyknrnrkhyouymd = pIfcNyknrnrkhyouymd;
    }


    @Column(order = 15, label = "取引銀行番号")
    private String ifcBankcd;


    public String getIfcBankcd() {
        return ifcBankcd;
    }


    public void setIfcBankcd(String pIfcBankcd) {
        ifcBankcd = pIfcBankcd;
    }


    @Column(order = 16, label = "取引支店番号")
    private String ifcSitencd;


    public String getIfcSitencd() {
        return ifcSitencd;
    }


    public void setIfcSitencd(String pIfcSitencd) {
        ifcSitencd = pIfcSitencd;
    }


    @Column(order = 17, label = "指定通貨")
    private String ifcSiteituuka;


    public String getIfcSiteituuka() {
        return ifcSiteituuka;
    }


    public void setIfcSiteituuka(String pIfcSiteituuka) {
        ifcSiteituuka = pIfcSiteituuka;
    }


    @Column(order = 18, label = "振込入金データ連携元")
    private String ifcHrkmnykndatarenmotoKbn;


    public String getIfcHrkmnykndatarenmotoKbn() {
        return ifcHrkmnykndatarenmotoKbn;
    }


    public void setIfcHrkmnykndatarenmotoKbn(String pIfcHrkmnykndatarenmotoKbn) {
        ifcHrkmnykndatarenmotoKbn = pIfcHrkmnykndatarenmotoKbn;
    }


    @Column(order = 19, label = "明細取込日")
    private String ifcMeisaitrkmymd;


    public String getIfcMeisaitrkmymd() {
        return ifcMeisaitrkmymd;
    }


    public void setIfcMeisaitrkmymd(String pIfcMeisaitrkmymd) {
        ifcMeisaitrkmymd = pIfcMeisaitrkmymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
