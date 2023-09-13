package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）前納統計リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhZennouToukeiListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhZennouToukeiListDataSourceBean() {
    }

    private String irZennoutoukeilistkbn;

    public String getIrZennoutoukeilistkbn() {
        return irZennoutoukeilistkbn;
    }

    public void setIrZennoutoukeilistkbn(String pIrZennoutoukeilistkbn) {
        irZennoutoukeilistkbn = pIrZennoutoukeilistkbn;
    }

    private String irZennoutoukeilisttitle;

    public String getIrZennoutoukeilisttitle() {
        return irZennoutoukeilisttitle;
    }

    public void setIrZennoutoukeilisttitle(String pIrZennoutoukeilisttitle) {
        irZennoutoukeilisttitle = pIrZennoutoukeilisttitle;
    }

    private String irListkbnbtsyuukei;

    public String getIrListkbnbtsyuukei() {
        return irListkbnbtsyuukei;
    }

    public void setIrListkbnbtsyuukei(String pIrListkbnbtsyuukei) {
        irListkbnbtsyuukei = pIrListkbnbtsyuukei;
    }

    private String irZennoukbnbtsyuukei;

    public String getIrZennoukbnbtsyuukei() {
        return irZennoukbnbtsyuukei;
    }

    public void setIrZennoukbnbtsyuukei(String pIrZennoukbnbtsyuukei) {
        irZennoukbnbtsyuukei = pIrZennoukbnbtsyuukei;
    }

    private String irSegbetusyuukei;

    public String getIrSegbetusyuukei() {
        return irSegbetusyuukei;
    }

    public void setIrSegbetusyuukei(String pIrSegbetusyuukei) {
        irSegbetusyuukei = pIrSegbetusyuukei;
    }

    private String irZennoukbn;

    public String getIrZennoukbn() {
        return irZennoukbn;
    }

    public void setIrZennoukbn(String pIrZennoukbn) {
        irZennoukbn = pIrZennoukbn;
    }

    private String irKbnkeirisegcd;

    public String getIrKbnkeirisegcd() {
        return irKbnkeirisegcd;
    }

    public void setIrKbnkeirisegcd(String pIrKbnkeirisegcd) {
        irKbnkeirisegcd = pIrKbnkeirisegcd;
    }

    private BizDateYM irZennoukaisiym;

    public BizDateYM getIrZennoukaisiym() {
        return irZennoukaisiym;
    }

    public void setIrZennoukaisiym(BizDateYM pIrZennoukaisiym) {
        irZennoukaisiym = pIrZennoukaisiym;
    }

    private Integer irZennoutoukeilist;

    public Integer getIrZennoutoukeilist() {
        return irZennoutoukeilist;
    }

    public void setIrZennoutoukeilist(Integer pIrZennoutoukeilist) {
        irZennoutoukeilist = pIrZennoutoukeilist;
    }

    private BizCurrency irZennoukaisizndk;

    public BizCurrency getIrZennoukaisizndk() {
        return irZennoukaisizndk;
    }

    public void setIrZennoukaisizndk(BizCurrency pIrZennoukaisizndk) {
        irZennoukaisizndk = pIrZennoukaisizndk;
    }

    private BizCurrency irMkkp;

    public BizCurrency getIrMkkp() {
        return irMkkp;
    }

    public void setIrMkkp(BizCurrency pIrMkkp) {
        irMkkp = pIrMkkp;
    }

    private BizCurrency irZennoukaisizndkgaika;

    public BizCurrency getIrZennoukaisizndkgaika() {
        return irZennoukaisizndkgaika;
    }

    public void setIrZennoukaisizndkgaika(BizCurrency pIrZennoukaisizndkgaika) {
        irZennoukaisizndkgaika = pIrZennoukaisizndkgaika;
    }

    private BizCurrency irMkkpgaika;

    public BizCurrency getIrMkkpgaika() {
        return irMkkpgaika;
    }

    public void setIrMkkpgaika(BizCurrency pIrMkkpgaika) {
        irMkkpgaika = pIrMkkpgaika;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
