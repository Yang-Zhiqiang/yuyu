package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）外貨振込入金エラー情報リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzGkHurikomiErrInfoListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzGkHurikomiErrInfoListDataSourceBean() {
    }

    private String irErrormsg;

    public String getIrErrormsg() {
        return irErrormsg;
    }

    public void setIrErrormsg(String pIrErrormsg) {
        irErrormsg = pIrErrormsg;
    }

    private String irDatakbn1;

    public String getIrDatakbn1() {
        return irDatakbn1;
    }

    public void setIrDatakbn1(String pIrDatakbn1) {
        irDatakbn1 = pIrDatakbn1;
    }

    private String irSyubetucd;

    public String getIrSyubetucd() {
        return irSyubetucd;
    }

    public void setIrSyubetucd(String pIrSyubetucd) {
        irSyubetucd = pIrSyubetucd;
    }

    private String irCdkbn;

    public String getIrCdkbn() {
        return irCdkbn;
    }

    public void setIrCdkbn(String pIrCdkbn) {
        irCdkbn = pIrCdkbn;
    }

    private String irSakuseiymd;

    public String getIrSakuseiymd() {
        return irSakuseiymd;
    }

    public void setIrSakuseiymd(String pIrSakuseiymd) {
        irSakuseiymd = pIrSakuseiymd;
    }

    private String irRenrakuymd;

    public String getIrRenrakuymd() {
        return irRenrakuymd;
    }

    public void setIrRenrakuymd(String pIrRenrakuymd) {
        irRenrakuymd = pIrRenrakuymd;
    }

    private String irRenrakukaisuu;

    public String getIrRenrakukaisuu() {
        return irRenrakukaisuu;
    }

    public void setIrRenrakukaisuu(String pIrRenrakukaisuu) {
        irRenrakukaisuu = pIrRenrakukaisuu;
    }

    private String irKnjyymdfrom;

    public String getIrKnjyymdfrom() {
        return irKnjyymdfrom;
    }

    public void setIrKnjyymdfrom(String pIrKnjyymdfrom) {
        irKnjyymdfrom = pIrKnjyymdfrom;
    }

    private String irKnjyymdto;

    public String getIrKnjyymdto() {
        return irKnjyymdto;
    }

    public void setIrKnjyymdto(String pIrKnjyymdto) {
        irKnjyymdto = pIrKnjyymdto;
    }

    private String irBankcd;

    public String getIrBankcd() {
        return irBankcd;
    }

    public void setIrBankcd(String pIrBankcd) {
        irBankcd = pIrBankcd;
    }

    private String irBanknmej;

    public String getIrBanknmej() {
        return irBanknmej;
    }

    public void setIrBanknmej(String pIrBanknmej) {
        irBanknmej = pIrBanknmej;
    }

    private String irSitencdtori;

    public String getIrSitencdtori() {
        return irSitencdtori;
    }

    public void setIrSitencdtori(String pIrSitencdtori) {
        irSitencdtori = pIrSitencdtori;
    }

    private String irSitennmejtori;

    public String getIrSitennmejtori() {
        return irSitennmejtori;
    }

    public void setIrSitennmejtori(String pIrSitennmejtori) {
        irSitennmejtori = pIrSitennmejtori;
    }

    private String irSitencd;

    public String getIrSitencd() {
        return irSitencd;
    }

    public void setIrSitencd(String pIrSitencd) {
        irSitencd = pIrSitencd;
    }

    private String irSitennmej;

    public String getIrSitennmej() {
        return irSitennmej;
    }

    public void setIrSitennmej(String pIrSitennmej) {
        irSitennmej = pIrSitennmej;
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

    private String irKznmej;

    public String getIrKznmej() {
        return irKznmej;
    }

    public void setIrKznmej(String pIrKznmej) {
        irKznmej = pIrKznmej;
    }

    private String irZndktuukasyu;

    public String getIrZndktuukasyu() {
        return irZndktuukasyu;
    }

    public void setIrZndktuukasyu(String pIrZndktuukasyu) {
        irZndktuukasyu = pIrZndktuukasyu;
    }

    private String irZndkssketa;

    public String getIrZndkssketa() {
        return irZndkssketa;
    }

    public void setIrZndkssketa(String pIrZndkssketa) {
        irZndkssketa = pIrZndkssketa;
    }

    private String irGktrhkmaezndk;

    public String getIrGktrhkmaezndk() {
        return irGktrhkmaezndk;
    }

    public void setIrGktrhkmaezndk(String pIrGktrhkmaezndk) {
        irGktrhkmaezndk = pIrGktrhkmaezndk;
    }

    private String irKasikosikbn;

    public String getIrKasikosikbn() {
        return irKasikosikbn;
    }

    public void setIrKasikosikbn(String pIrKasikosikbn) {
        irKasikosikbn = pIrKasikosikbn;
    }

    private String irDatakbn2;

    public String getIrDatakbn2() {
        return irDatakbn2;
    }

    public void setIrDatakbn2(String pIrDatakbn2) {
        irDatakbn2 = pIrDatakbn2;
    }

    private String irDtrecordkbn1;

    public String getIrDtrecordkbn1() {
        return irDtrecordkbn1;
    }

    public void setIrDtrecordkbn1(String pIrDtrecordkbn1) {
        irDtrecordkbn1 = pIrDtrecordkbn1;
    }

    private String irDtrecordkousei;

    public String getIrDtrecordkousei() {
        return irDtrecordkousei;
    }

    public void setIrDtrecordkousei(String pIrDtrecordkousei) {
        irDtrecordkousei = pIrDtrecordkousei;
    }

    private String irSyorino1;

    public String getIrSyorino1() {
        return irSyorino1;
    }

    public void setIrSyorino1(String pIrSyorino1) {
        irSyorino1 = pIrSyorino1;
    }

    private String irKnjyymd;

    public String getIrKnjyymd() {
        return irKnjyymd;
    }

    public void setIrKnjyymd(String pIrKnjyymd) {
        irKnjyymd = pIrKnjyymd;
    }

    private String irKsnymd;

    public String getIrKsnymd() {
        return irKsnymd;
    }

    public void setIrKsnymd(String pIrKsnymd) {
        irKsnymd = pIrKsnymd;
    }

    private String irIribaraikbn;

    public String getIrIribaraikbn() {
        return irIribaraikbn;
    }

    public void setIrIribaraikbn(String pIrIribaraikbn) {
        irIribaraikbn = pIrIribaraikbn;
    }

    private String irTrhkkbn;

    public String getIrTrhkkbn() {
        return irTrhkkbn;
    }

    public void setIrTrhkkbn(String pIrTrhkkbn) {
        irTrhkkbn = pIrTrhkkbn;
    }

    private String irTrhktuukasyu;

    public String getIrTrhktuukasyu() {
        return irTrhktuukasyu;
    }

    public void setIrTrhktuukasyu(String pIrTrhktuukasyu) {
        irTrhktuukasyu = pIrTrhktuukasyu;
    }

    private String irTrhkssketa;

    public String getIrTrhkssketa() {
        return irTrhkssketa;
    }

    public void setIrTrhkssketa(String pIrTrhkssketa) {
        irTrhkssketa = pIrTrhkssketa;
    }

    private String irGktrhkgk;

    public String getIrGktrhkgk() {
        return irGktrhkgk;
    }

    public void setIrGktrhkgk(String pIrGktrhkgk) {
        irGktrhkgk = pIrGktrhkgk;
    }

    private String irBanksyoukaino;

    public String getIrBanksyoukaino() {
        return irBanksyoukaino;
    }

    public void setIrBanksyoukaino(String pIrBanksyoukaino) {
        irBanksyoukaino = pIrBanksyoukaino;
    }

    private String irTrhksyoukaino;

    public String getIrTrhksyoukaino() {
        return irTrhksyoukaino;
    }

    public void setIrTrhksyoukaino(String pIrTrhksyoukaino) {
        irTrhksyoukaino = pIrTrhksyoukaino;
    }

    private String irTekiyounaiyouej;

    public String getIrTekiyounaiyouej() {
        return irTekiyounaiyouej;
    }

    public void setIrTekiyounaiyouej(String pIrTekiyounaiyouej) {
        irTekiyounaiyouej = pIrTekiyounaiyouej;
    }

    private String irIrninnm;

    public String getIrIrninnm() {
        return irIrninnm;
    }

    public void setIrIrninnm(String pIrIrninnm) {
        irIrninnm = pIrIrninnm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
