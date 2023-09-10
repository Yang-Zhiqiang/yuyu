package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）口座振替登録反映エラーリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkKouhuritourokuhaneierrlistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkKouhuritourokuhaneierrlistDataSourceBean() {
    }


    private String irSosikicd;


    public String getIrSosikicd() {
        return irSosikicd;
    }


    public void setIrSosikicd(String pIrSosikicd) {
        irSosikicd = pIrSosikicd;
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private String irOkyakusamano;


    public String getIrOkyakusamano() {
        return irOkyakusamano;
    }


    public void setIrOkyakusamano(String pIrOkyakusamano) {
        irOkyakusamano = pIrOkyakusamano;
    }


    private String irKouzahrketrkymd;


    public String getIrKouzahrketrkymd() {
        return irKouzahrketrkymd;
    }


    public void setIrKouzahrketrkymd(String pIrKouzahrketrkymd) {
        irKouzahrketrkymd = pIrKouzahrketrkymd;
    }


    private String irKinyuucd;


    public String getIrKinyuucd() {
        return irKinyuucd;
    }


    public void setIrKinyuucd(String pIrKinyuucd) {
        irKinyuucd = pIrKinyuucd;
    }


    private String irSitencd;


    public String getIrSitencd() {
        return irSitencd;
    }


    public void setIrSitencd(String pIrSitencd) {
        irSitencd = pIrSitencd;
    }


    private C_YokinKbn irYokinkbn;


    public C_YokinKbn getIrYokinkbn() {
        return irYokinkbn;
    }


    public void setIrYokinkbn(C_YokinKbn pIrYokinkbn) {
        irYokinkbn = pIrYokinkbn;
    }


    private String irKouzano;


    public String getIrKouzano() {
        return irKouzano;
    }


    public void setIrKouzano(String pIrKouzano) {
        irKouzano = pIrKouzano;
    }


    private String irKzmeiginmkn;


    public String getIrKzmeiginmkn() {
        return irKzmeiginmkn;
    }


    public void setIrKzmeiginmkn(String pIrKzmeiginmkn) {
        irKzmeiginmkn = pIrKzmeiginmkn;
    }


    private String irKhrtrkkekkahaneierrriyuu;


    public String getIrKhrtrkkekkahaneierrriyuu() {
        return irKhrtrkkekkahaneierrriyuu;
    }


    public void setIrKhrtrkkekkahaneierrriyuu(String pIrKhrtrkkekkahaneierrriyuu) {
        irKhrtrkkekkahaneierrriyuu = pIrKhrtrkkekkahaneierrriyuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
