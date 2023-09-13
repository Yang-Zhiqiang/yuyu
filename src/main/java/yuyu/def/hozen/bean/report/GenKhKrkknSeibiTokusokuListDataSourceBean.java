package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）仮受金整備督促リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKrkknSeibiTokusokuListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhKrkknSeibiTokusokuListDataSourceBean() {
    }

    private C_TantouCdKbn irTantocd;

    public C_TantouCdKbn getIrTantocd() {
        return irTantocd;
    }

    public void setIrTantocd(C_TantouCdKbn pIrTantocd) {
        irTantocd = pIrTantocd;
    }

    private String irAtesakisosiki;

    public String getIrAtesakisosiki() {
        return irAtesakisosiki;
    }

    public void setIrAtesakisosiki(String pIrAtesakisosiki) {
        irAtesakisosiki = pIrAtesakisosiki;
    }

    private C_Nykkeiro irNykkeiro;

    public C_Nykkeiro getIrNykkeiro() {
        return irNykkeiro;
    }

    public void setIrNykkeiro(C_Nykkeiro pIrNykkeiro) {
        irNykkeiro = pIrNykkeiro;
    }

    private String irTyoukimisyorihyouji;

    public String getIrTyoukimisyorihyouji() {
        return irTyoukimisyorihyouji;
    }

    public void setIrTyoukimisyorihyouji(String pIrTyoukimisyorihyouji) {
        irTyoukimisyorihyouji = pIrTyoukimisyorihyouji;
    }

    private BizDate irKrkkeijyoymd;

    public BizDate getIrKrkkeijyoymd() {
        return irKrkkeijyoymd;
    }

    public void setIrKrkkeijyoymd(BizDate pIrKrkkeijyoymd) {
        irKrkkeijyoymd = pIrKrkkeijyoymd;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private String irHukusuukrkarihyouji;

    public String getIrHukusuukrkarihyouji() {
        return irHukusuukrkarihyouji;
    }

    public void setIrHukusuukrkarihyouji(String pIrHukusuukrkarihyouji) {
        irHukusuukrkarihyouji = pIrHukusuukrkarihyouji;
    }

    private Integer irKrkno;

    public Integer getIrKrkno() {
        return irKrkno;
    }

    public void setIrKrkno(Integer pIrKrkno) {
        irKrkno = pIrKrkno;
    }

    private String irKrkjhrkkaisuu;

    public String getIrKrkjhrkkaisuu() {
        return irKrkjhrkkaisuu;
    }

    public void setIrKrkjhrkkaisuu(String pIrKrkjhrkkaisuu) {
        irKrkjhrkkaisuu = pIrKrkjhrkkaisuu;
    }

    private C_KrkriyuuKbn irKrkriyuukbn;

    public C_KrkriyuuKbn getIrKrkriyuukbn() {
        return irKrkriyuukbn;
    }

    public void setIrKrkriyuukbn(C_KrkriyuuKbn pIrKrkriyuukbn) {
        irKrkriyuukbn = pIrKrkriyuukbn;
    }

    private C_NyknaiyouKbn irNyknaiyoukbn;

    public C_NyknaiyouKbn getIrNyknaiyoukbn() {
        return irNyknaiyoukbn;
    }

    public void setIrNyknaiyoukbn(C_NyknaiyouKbn pIrNyknaiyoukbn) {
        irNyknaiyoukbn = pIrNyknaiyoukbn;
    }

    private BizDateYM irJyuutouym;

    public BizDateYM getIrJyuutouym() {
        return irJyuutouym;
    }

    public void setIrJyuutouym(BizDateYM pIrJyuutouym) {
        irJyuutouym = pIrJyuutouym;
    }

    private String irJyutoukaisuuy;

    public String getIrJyutoukaisuuy() {
        return irJyutoukaisuuy;
    }

    public void setIrJyutoukaisuuy(String pIrJyutoukaisuuy) {
        irJyutoukaisuuy = pIrJyutoukaisuuy;
    }

    private BizCurrency irKrkgk;

    public BizCurrency getIrKrkgk() {
        return irKrkgk;
    }

    public void setIrKrkgk(BizCurrency pIrKrkgk) {
        irKrkgk = pIrKrkgk;
    }

    private String irRyosyuymd;

    public String getIrRyosyuymd() {
        return irRyosyuymd;
    }

    public void setIrRyosyuymd(String pIrRyosyuymd) {
        irRyosyuymd = pIrRyosyuymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
