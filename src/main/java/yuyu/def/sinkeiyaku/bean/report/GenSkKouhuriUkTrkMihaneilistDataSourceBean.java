package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）口振受付登録未反映リスト（申込入力未了分）帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkKouhuriUkTrkMihaneilistDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkKouhuriUkTrkMihaneilistDataSourceBean() {
    }


    private String irKouzahrketrkymd;


    public String getIrKouzahrketrkymd() {
        return irKouzahrketrkymd;
    }


    public void setIrKouzahrketrkymd(String pIrKouzahrketrkymd) {
        irKouzahrketrkymd = pIrKouzahrketrkymd;
    }


    private String irDatajyusinymd;


    public String getIrDatajyusinymd() {
        return irDatajyusinymd;
    }


    public void setIrDatajyusinymd(String pIrDatajyusinymd) {
        irDatajyusinymd = pIrDatajyusinymd;
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
