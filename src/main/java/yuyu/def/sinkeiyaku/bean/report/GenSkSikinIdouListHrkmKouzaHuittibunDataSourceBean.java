package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）資金移動リスト（振込口座不一致分）帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkSikinIdouListHrkmKouzaHuittibunDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkSikinIdouListHrkmKouzaHuittibunDataSourceBean() {
    }


    private C_Tuukasyu irSikinidoumototuukasyu;


    public C_Tuukasyu getIrSikinidoumototuukasyu() {
        return irSikinidoumototuukasyu;
    }


    public void setIrSikinidoumototuukasyu(C_Tuukasyu pIrSikinidoumototuukasyu) {
        irSikinidoumototuukasyu = pIrSikinidoumototuukasyu;
    }


    private String irSikinidoumotobankcd;


    public String getIrSikinidoumotobankcd() {
        return irSikinidoumotobankcd;
    }


    public void setIrSikinidoumotobankcd(String pIrSikinidoumotobankcd) {
        irSikinidoumotobankcd = pIrSikinidoumotobankcd;
    }


    private String irSikinidoumotositencd;


    public String getIrSikinidoumotositencd() {
        return irSikinidoumotositencd;
    }


    public void setIrSikinidoumotositencd(String pIrSikinidoumotositencd) {
        irSikinidoumotositencd = pIrSikinidoumotositencd;
    }


    private String irSikinidoumotokouzano;


    public String getIrSikinidoumotokouzano() {
        return irSikinidoumotokouzano;
    }


    public void setIrSikinidoumotokouzano(String pIrSikinidoumotokouzano) {
        irSikinidoumotokouzano = pIrSikinidoumotokouzano;
    }


    private BizCurrency irSikinidougaku;


    public BizCurrency getIrSikinidougaku() {
        return irSikinidougaku;
    }


    public void setIrSikinidougaku(BizCurrency pIrSikinidougaku) {
        irSikinidougaku = pIrSikinidougaku;
    }


    private C_Tuukasyu irSeitoukouzatuukasyu;


    public C_Tuukasyu getIrSeitoukouzatuukasyu() {
        return irSeitoukouzatuukasyu;
    }


    public void setIrSeitoukouzatuukasyu(C_Tuukasyu pIrSeitoukouzatuukasyu) {
        irSeitoukouzatuukasyu = pIrSeitoukouzatuukasyu;
    }


    private String irSeitoukouzabanccd;


    public String getIrSeitoukouzabanccd() {
        return irSeitoukouzabanccd;
    }


    public void setIrSeitoukouzabanccd(String pIrSeitoukouzabanccd) {
        irSeitoukouzabanccd = pIrSeitoukouzabanccd;
    }


    private String irSeitoukouzasitencd;


    public String getIrSeitoukouzasitencd() {
        return irSeitoukouzasitencd;
    }


    public void setIrSeitoukouzasitencd(String pIrSeitoukouzasitencd) {
        irSeitoukouzasitencd = pIrSeitoukouzasitencd;
    }


    private String irSeitoukouzano;


    public String getIrSeitoukouzano() {
        return irSeitoukouzano;
    }


    public void setIrSeitoukouzano(String pIrSeitoukouzano) {
        irSeitoukouzano = pIrSeitoukouzano;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
