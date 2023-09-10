package yuyu.def.sinkeiyaku.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）振込入金明細レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHurikomiNyuukinMeisaiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;


    public GenSkHurikomiNyuukinMeisaiLayoutFile() {
    }


    @Column(order = 1, label = "申込番号")
    private String ifeMosno;


    public String getIfeMosno() {
        return ifeMosno;
    }


    public void setIfeMosno(String pIfeMosno) {
        ifeMosno = pIfeMosno;
    }


    @Column(order = 2, label = "入金用親代理店名")
    private String ifeNyuukinoyadrtennm;


    public String getIfeNyuukinoyadrtennm() {
        return ifeNyuukinoyadrtennm;
    }


    public void setIfeNyuukinoyadrtennm(String pIfeNyuukinoyadrtennm) {
        ifeNyuukinoyadrtennm = pIfeNyuukinoyadrtennm;
    }


    @Column(order = 3, label = "振込依頼人名")
    private String ifeHrkmirninnm;


    public String getIfeHrkmirninnm() {
        return ifeHrkmirninnm;
    }


    public void setIfeHrkmirninnm(String pIfeHrkmirninnm) {
        ifeHrkmirninnm = pIfeHrkmirninnm;
    }


    @Column(order = 4, label = "払込通貨")
    private String ifeHrktuuka;


    public String getIfeHrktuuka() {
        return ifeHrktuuka;
    }


    public void setIfeHrktuuka(String pIfeHrktuuka) {
        ifeHrktuuka = pIfeHrktuuka;
    }


    @Column(order = 5, label = "指定通貨")
    private String ifeSiteituuka;


    public String getIfeSiteituuka() {
        return ifeSiteituuka;
    }


    public void setIfeSiteituuka(String pIfeSiteituuka) {
        ifeSiteituuka = pIfeSiteituuka;
    }


    @Column(order = 6, label = "領収金額")
    private String ifeRsgaku;


    public String getIfeRsgaku() {
        return ifeRsgaku;
    }


    public void setIfeRsgaku(String pIfeRsgaku) {
        ifeRsgaku = pIfeRsgaku;
    }


    @Column(order = 7, label = "領収日")
    private String ifeRyosyuymd;


    public String getIfeRyosyuymd() {
        return ifeRyosyuymd;
    }


    public void setIfeRyosyuymd(String pIfeRyosyuymd) {
        ifeRyosyuymd = pIfeRyosyuymd;
    }


    @Column(order = 8, label = "振込元銀行名")
    private String ifeHrkmmotobanknm;


    public String getIfeHrkmmotobanknm() {
        return ifeHrkmmotobanknm;
    }


    public void setIfeHrkmmotobanknm(String pIfeHrkmmotobanknm) {
        ifeHrkmmotobanknm = pIfeHrkmmotobanknm;
    }


    @Column(order = 9, label = "支店名")
    private String ifeSitennm;


    public String getIfeSitennm() {
        return ifeSitennm;
    }


    public void setIfeSitennm(String pIfeSitennm) {
        ifeSitennm = pIfeSitennm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
