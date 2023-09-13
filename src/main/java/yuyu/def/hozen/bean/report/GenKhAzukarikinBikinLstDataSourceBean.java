package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）預り金備金リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhAzukarikinBikinLstDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhAzukarikinBikinLstDataSourceBean() {
    }

    private String irHknsyruilevel;

    public String getIrHknsyruilevel() {
        return irHknsyruilevel;
    }

    public void setIrHknsyruilevel(String pIrHknsyruilevel) {
        irHknsyruilevel = pIrHknsyruilevel;
    }

    private String irAzukarikintuukasyu;

    public String getIrAzukarikintuukasyu() {
        return irAzukarikintuukasyu;
    }

    public void setIrAzukarikintuukasyu(String pIrAzukarikintuukasyu) {
        irAzukarikintuukasyu = pIrAzukarikintuukasyu;
    }

    private String irKawaserate;

    public String getIrKawaserate() {
        return irKawaserate;
    }

    public void setIrKawaserate(String pIrKawaserate) {
        irKawaserate = pIrKawaserate;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private C_BkncdKbn irBkncdkbn;

    public C_BkncdKbn getIrBkncdkbn() {
        return irBkncdkbn;
    }

    public void setIrBkncdkbn(C_BkncdKbn pIrBkncdkbn) {
        irBkncdkbn = pIrBkncdkbn;
    }

    private String irBikinkeijyouymd;

    public String getIrBikinkeijyouymd() {
        return irBikinkeijyouymd;
    }

    public void setIrBikinkeijyouymd(String pIrBikinkeijyouymd) {
        irBikinkeijyouymd = pIrBikinkeijyouymd;
    }

    private C_BknJkuKbn irBknjkukbn;

    public C_BknJkuKbn getIrBknjkukbn() {
        return irBknjkukbn;
    }

    public void setIrBknjkukbn(C_BknJkuKbn pIrBknjkukbn) {
        irBknjkukbn = pIrBknjkukbn;
    }

    private String irTounendgankin;

    public String getIrTounendgankin() {
        return irTounendgankin;
    }

    public void setIrTounendgankin(String pIrTounendgankin) {
        irTounendgankin = pIrTounendgankin;
    }

    private String irTounendrsk;

    public String getIrTounendrsk() {
        return irTounendrsk;
    }

    public void setIrTounendrsk(String pIrTounendrsk) {
        irTounendrsk = pIrTounendrsk;
    }

    private String irAzukariganrikin;

    public String getIrAzukariganrikin() {
        return irAzukariganrikin;
    }

    public void setIrAzukariganrikin(String pIrAzukariganrikin) {
        irAzukariganrikin = pIrAzukariganrikin;
    }

    private String irAzukarikinhsiymd;

    public String getIrAzukarikinhsiymd() {
        return irAzukarikinhsiymd;
    }

    public void setIrAzukarikinhsiymd(String pIrAzukarikinhsiymd) {
        irAzukarikinhsiymd = pIrAzukarikinhsiymd;
    }

    private BizNumber irAzukarikinbknkensuugoukei;

    public BizNumber getIrAzukarikinbknkensuugoukei() {
        return irAzukarikinbknkensuugoukei;
    }

    public void setIrAzukarikinbknkensuugoukei(BizNumber pIrAzukarikinbknkensuugoukei) {
        irAzukarikinbknkensuugoukei = pIrAzukarikinbknkensuugoukei;
    }

    private String irAzukarikinbkngoukei;

    public String getIrAzukarikinbkngoukei() {
        return irAzukarikinbkngoukei;
    }

    public void setIrAzukarikinbkngoukei(String pIrAzukarikinbkngoukei) {
        irAzukarikinbkngoukei = pIrAzukarikinbkngoukei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
