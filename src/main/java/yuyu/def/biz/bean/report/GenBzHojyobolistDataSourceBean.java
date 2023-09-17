package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）補助簿リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHojyobolistDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzHojyobolistDataSourceBean() {
    }

    private String irHjybtantositunm;

    public String getIrHjybtantositunm() {
        return irHjybtantositunm;
    }

    public void setIrHjybtantositunm(String pIrHjybtantositunm) {
        irHjybtantositunm = pIrHjybtantositunm;
    }

    private String irKanjyoukmkcd;

    public String getIrKanjyoukmkcd() {
        return irKanjyoukmkcd;
    }

    public void setIrKanjyoukmkcd(String pIrKanjyoukmkcd) {
        irKanjyoukmkcd = pIrKanjyoukmkcd;
    }

    private String irKanjyoukmknm;

    public String getIrKanjyoukmknm() {
        return irKanjyoukmknm;
    }

    public void setIrKanjyoukmknm(String pIrKanjyoukmknm) {
        irKanjyoukmknm = pIrKanjyoukmknm;
    }

    private String irSyorisyokantantcd;

    public String getIrSyorisyokantantcd() {
        return irSyorisyokantantcd;
    }

    public void setIrSyorisyokantantcd(String pIrSyorisyokantantcd) {
        irSyorisyokantantcd = pIrSyorisyokantantcd;
    }

    private String irSyorisyokantantnm;

    public String getIrSyorisyokantantnm() {
        return irSyorisyokantantnm;
    }

    public void setIrSyorisyokantantnm(String pIrSyorisyokantantnm) {
        irSyorisyokantantnm = pIrSyorisyokantantnm;
    }

    private String irDenymd;

    public String getIrDenymd() {
        return irDenymd;
    }

    public void setIrDenymd(String pIrDenymd) {
        irDenymd = pIrDenymd;
    }

    private BizCurrency irKarikatagk;

    public BizCurrency getIrKarikatagk() {
        return irKarikatagk;
    }

    public void setIrKarikatagk(BizCurrency pIrKarikatagk) {
        irKarikatagk = pIrKarikatagk;
    }

    private BizCurrency irKasikatagk;

    public BizCurrency getIrKasikatagk() {
        return irKasikatagk;
    }

    public void setIrKasikatagk(BizCurrency pIrKasikatagk) {
        irKasikatagk = pIrKasikatagk;
    }

    private BizCurrency irKarikatakmkkeigk;

    public BizCurrency getIrKarikatakmkkeigk() {
        return irKarikatakmkkeigk;
    }

    public void setIrKarikatakmkkeigk(BizCurrency pIrKarikatakmkkeigk) {
        irKarikatakmkkeigk = pIrKarikatakmkkeigk;
    }

    private BizCurrency irKasikatakmkkeigk;

    public BizCurrency getIrKasikatakmkkeigk() {
        return irKasikatakmkkeigk;
    }

    public void setIrKasikatakmkkeigk(BizCurrency pIrKasikatakmkkeigk) {
        irKasikatakmkkeigk = pIrKasikatakmkkeigk;
    }

    private BizCurrency irKarikataruigk;

    public BizCurrency getIrKarikataruigk() {
        return irKarikataruigk;
    }

    public void setIrKarikataruigk(BizCurrency pIrKarikataruigk) {
        irKarikataruigk = pIrKarikataruigk;
    }

    private BizCurrency irKasikataruigk;

    public BizCurrency getIrKasikataruigk() {
        return irKasikataruigk;
    }

    public void setIrKasikataruigk(BizCurrency pIrKasikataruigk) {
        irKasikataruigk = pIrKasikataruigk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
