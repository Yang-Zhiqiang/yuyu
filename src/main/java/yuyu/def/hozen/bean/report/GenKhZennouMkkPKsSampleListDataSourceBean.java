package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）前納未経過Ｐ検証サンプルリスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhZennouMkkPKsSampleListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhZennouMkkPKsSampleListDataSourceBean() {
    }

    private String irZnnmkkpkssamplekslsttitle;

    public String getIrZnnmkkpkssamplekslsttitle() {
        return irZnnmkkpkssamplekslsttitle;
    }

    public void setIrZnnmkkpkssamplekslsttitle(String pIrZnnmkkpkssamplekslsttitle) {
        irZnnmkkpkssamplekslsttitle = pIrZnnmkkpkssamplekslsttitle;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irZennoutoukeilistkbn;

    public String getIrZennoutoukeilistkbn() {
        return irZennoutoukeilistkbn;
    }

    public void setIrZennoutoukeilistkbn(String pIrZennoutoukeilistkbn) {
        irZennoutoukeilistkbn = pIrZennoutoukeilistkbn;
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

    private BizDate irKeiyakuymd8keta;

    public BizDate getIrKeiyakuymd8keta() {
        return irKeiyakuymd8keta;
    }

    public void setIrKeiyakuymd8keta(BizDate pIrKeiyakuymd8keta) {
        irKeiyakuymd8keta = pIrKeiyakuymd8keta;
    }

    private BizDate irZennounyuukinymd;

    public BizDate getIrZennounyuukinymd() {
        return irZennounyuukinymd;
    }

    public void setIrZennounyuukinymd(BizDate pIrZennounyuukinymd) {
        irZennounyuukinymd = pIrZennounyuukinymd;
    }

    private BizNumber irZennouwrbkrt;

    public BizNumber getIrZennouwrbkrt() {
        return irZennouwrbkrt;
    }

    public void setIrZennouwrbkrt(BizNumber pIrZennouwrbkrt) {
        irZennouwrbkrt = pIrZennouwrbkrt;
    }

    private BizCurrency irZennoukaisizndk;

    public BizCurrency getIrZennoukaisizndk() {
        return irZennoukaisizndk;
    }

    public void setIrZennoukaisizndk(BizCurrency pIrZennoukaisizndk) {
        irZennoukaisizndk = pIrZennoukaisizndk;
    }

    private BizNumber irTndmatutkyrt;

    public BizNumber getIrTndmatutkyrt() {
        return irTndmatutkyrt;
    }

    public void setIrTndmatutkyrt(BizNumber pIrTndmatutkyrt) {
        irTndmatutkyrt = pIrTndmatutkyrt;
    }

    private BizCurrency irTndmatutkyzndk;

    public BizCurrency getIrTndmatutkyzndk() {
        return irTndmatutkyzndk;
    }

    public void setIrTndmatutkyzndk(BizCurrency pIrTndmatutkyzndk) {
        irTndmatutkyzndk = pIrTndmatutkyzndk;
    }

    private BizCurrency irZennoukaisizndkgaika;

    public BizCurrency getIrZennoukaisizndkgaika() {
        return irZennoukaisizndkgaika;
    }

    public void setIrZennoukaisizndkgaika(BizCurrency pIrZennoukaisizndkgaika) {
        irZennoukaisizndkgaika = pIrZennoukaisizndkgaika;
    }

    private BizCurrency irTndmatutkyzndkgaika;

    public BizCurrency getIrTndmatutkyzndkgaika() {
        return irTndmatutkyzndkgaika;
    }

    public void setIrTndmatutkyzndkgaika(BizCurrency pIrTndmatutkyzndkgaika) {
        irTndmatutkyzndkgaika = pIrTndmatutkyzndkgaika;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
