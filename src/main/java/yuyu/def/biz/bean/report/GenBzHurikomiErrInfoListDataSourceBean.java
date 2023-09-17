package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）振込入金エラー情報リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHurikomiErrInfoListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzHurikomiErrInfoListDataSourceBean() {
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

    private String irSakuseiymd6keta;

    public String getIrSakuseiymd6keta() {
        return irSakuseiymd6keta;
    }

    public void setIrSakuseiymd6keta(String pIrSakuseiymd6keta) {
        irSakuseiymd6keta = pIrSakuseiymd6keta;
    }

    private String irKnjyymdfrom6keta;

    public String getIrKnjyymdfrom6keta() {
        return irKnjyymdfrom6keta;
    }

    public void setIrKnjyymdfrom6keta(String pIrKnjyymdfrom6keta) {
        irKnjyymdfrom6keta = pIrKnjyymdfrom6keta;
    }

    private String irKnjyymdto6keta;

    public String getIrKnjyymdto6keta() {
        return irKnjyymdto6keta;
    }

    public void setIrKnjyymdto6keta(String pIrKnjyymdto6keta) {
        irKnjyymdto6keta = pIrKnjyymdto6keta;
    }

    private String irBankcd;

    public String getIrBankcd() {
        return irBankcd;
    }

    public void setIrBankcd(String pIrBankcd) {
        irBankcd = pIrBankcd;
    }

    private String irBanknmkn;

    public String getIrBanknmkn() {
        return irBanknmkn;
    }

    public void setIrBanknmkn(String pIrBanknmkn) {
        irBanknmkn = pIrBanknmkn;
    }

    private String irSitencd;

    public String getIrSitencd() {
        return irSitencd;
    }

    public void setIrSitencd(String pIrSitencd) {
        irSitencd = pIrSitencd;
    }

    private String irSitennmkn;

    public String getIrSitennmkn() {
        return irSitennmkn;
    }

    public void setIrSitennmkn(String pIrSitennmkn) {
        irSitennmkn = pIrSitennmkn;
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

    private String irKznmkn;

    public String getIrKznmkn() {
        return irKznmkn;
    }

    public void setIrKznmkn(String pIrKznmkn) {
        irKznmkn = pIrKznmkn;
    }

    private String irKasikosikbn;

    public String getIrKasikosikbn() {
        return irKasikosikbn;
    }

    public void setIrKasikosikbn(String pIrKasikosikbn) {
        irKasikosikbn = pIrKasikosikbn;
    }

    private String irTuutyousysykbn;

    public String getIrTuutyousysykbn() {
        return irTuutyousysykbn;
    }

    public void setIrTuutyousysykbn(String pIrTuutyousysykbn) {
        irTuutyousysykbn = pIrTuutyousysykbn;
    }

    private String irTrhkmaezndk;

    public String getIrTrhkmaezndk() {
        return irTrhkmaezndk;
    }

    public void setIrTrhkmaezndk(String pIrTrhkmaezndk) {
        irTrhkmaezndk = pIrTrhkmaezndk;
    }

    private String irDatakbn2;

    public String getIrDatakbn2() {
        return irDatakbn2;
    }

    public void setIrDatakbn2(String pIrDatakbn2) {
        irDatakbn2 = pIrDatakbn2;
    }

    private String irSyoukaino;

    public String getIrSyoukaino() {
        return irSyoukaino;
    }

    public void setIrSyoukaino(String pIrSyoukaino) {
        irSyoukaino = pIrSyoukaino;
    }

    private String irKnjyymd6keta;

    public String getIrKnjyymd6keta() {
        return irKnjyymd6keta;
    }

    public void setIrKnjyymd6keta(String pIrKnjyymd6keta) {
        irKnjyymd6keta = pIrKnjyymd6keta;
    }

    private String irAzkrhrdsymd6keta;

    public String getIrAzkrhrdsymd6keta() {
        return irAzkrhrdsymd6keta;
    }

    public void setIrAzkrhrdsymd6keta(String pIrAzkrhrdsymd6keta) {
        irAzkrhrdsymd6keta = pIrAzkrhrdsymd6keta;
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

    private String irTrhkgk;

    public String getIrTrhkgk() {
        return irTrhkgk;
    }

    public void setIrTrhkgk(String pIrTrhkgk) {
        irTrhkgk = pIrTrhkgk;
    }

    private String irTatenkengk;

    public String getIrTatenkengk() {
        return irTatenkengk;
    }

    public void setIrTatenkengk(String pIrTatenkengk) {
        irTatenkengk = pIrTatenkengk;
    }

    private String irKknteijiymd6keta;

    public String getIrKknteijiymd6keta() {
        return irKknteijiymd6keta;
    }

    public void setIrKknteijiymd6keta(String pIrKknteijiymd6keta) {
        irKknteijiymd6keta = pIrKknteijiymd6keta;
    }

    private String irHwtrhnknymd6keta;

    public String getIrHwtrhnknymd6keta() {
        return irHwtrhnknymd6keta;
    }

    public void setIrHwtrhnknymd6keta(String pIrHwtrhnknymd6keta) {
        irHwtrhnknymd6keta = pIrHwtrhnknymd6keta;
    }

    private String irTgtkgtkbn;

    public String getIrTgtkgtkbn() {
        return irTgtkgtkbn;
    }

    public void setIrTgtkgtkbn(String pIrTgtkgtkbn) {
        irTgtkgtkbn = pIrTgtkgtkbn;
    }

    private String irTgtkgtno;

    public String getIrTgtkgtno() {
        return irTgtkgtno;
    }

    public void setIrTgtkgtno(String pIrTgtkgtno) {
        irTgtkgtno = pIrTgtkgtno;
    }

    private String irRyoutenno;

    public String getIrRyoutenno() {
        return irRyoutenno;
    }

    public void setIrRyoutenno(String pIrRyoutenno) {
        irRyoutenno = pIrRyoutenno;
    }

    private String irHrkmirnincd;

    public String getIrHrkmirnincd() {
        return irHrkmirnincd;
    }

    public void setIrHrkmirnincd(String pIrHrkmirnincd) {
        irHrkmirnincd = pIrHrkmirnincd;
    }

    private String irHrkmirninnm48;

    public String getIrHrkmirninnm48() {
        return irHrkmirninnm48;
    }

    public void setIrHrkmirninnm48(String pIrHrkmirninnm48) {
        irHrkmirninnm48 = pIrHrkmirninnm48;
    }

    private String irSimukebanknmkn;

    public String getIrSimukebanknmkn() {
        return irSimukebanknmkn;
    }

    public void setIrSimukebanknmkn(String pIrSimukebanknmkn) {
        irSimukebanknmkn = pIrSimukebanknmkn;
    }

    private String irSimuketennmkn;

    public String getIrSimuketennmkn() {
        return irSimuketennmkn;
    }

    public void setIrSimuketennmkn(String pIrSimuketennmkn) {
        irSimuketennmkn = pIrSimuketennmkn;
    }

    private String irTekiyounaiyou;

    public String getIrTekiyounaiyou() {
        return irTekiyounaiyou;
    }

    public void setIrTekiyounaiyou(String pIrTekiyounaiyou) {
        irTekiyounaiyou = pIrTekiyounaiyou;
    }

    private String irEdiinfo;

    public String getIrEdiinfo() {
        return irEdiinfo;
    }

    public void setIrEdiinfo(String pIrEdiinfo) {
        irEdiinfo = pIrEdiinfo;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
