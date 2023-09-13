package yuyu.def.hozen.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KzkpannaijiyuuKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （保全）振替用紙作成契約未入金リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhHrkeyousiSksKykMinyknListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenKhHrkeyousiSksKykMinyknListDataSourceBean() {
    }

    private String irSyono11keta;

    public String getIrSyono11keta() {
        return irSyono11keta;
    }

    public void setIrSyono11keta(String pIrSyono11keta) {
        irSyono11keta = pIrSyono11keta;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private C_Hrkkaisuu irHrkkaisuu;

    public C_Hrkkaisuu getIrHrkkaisuu() {
        return irHrkkaisuu;
    }

    public void setIrHrkkaisuu(C_Hrkkaisuu pIrHrkkaisuu) {
        irHrkkaisuu = pIrHrkkaisuu;
    }

    private BizCurrency irHrkp;

    public BizCurrency getIrHrkp() {
        return irHrkp;
    }

    public void setIrHrkp(BizCurrency pIrHrkp) {
        irHrkp = pIrHrkp;
    }

    private BizDate irHrkeyousiymd;

    public BizDate getIrHrkeyousiymd() {
        return irHrkeyousiymd;
    }

    public void setIrHrkeyousiymd(BizDate pIrHrkeyousiymd) {
        irHrkeyousiymd = pIrHrkeyousiymd;
    }

    private BizDate irHrkkigen;

    public BizDate getIrHrkkigen() {
        return irHrkkigen;
    }

    public void setIrHrkkigen(BizDate pIrHrkkigen) {
        irHrkkigen = pIrHrkkigen;
    }

    private String irHrkeyousisksbusyo;

    public String getIrHrkeyousisksbusyo() {
        return irHrkeyousisksbusyo;
    }

    public void setIrHrkeyousisksbusyo(String pIrHrkeyousisksbusyo) {
        irHrkeyousisksbusyo = pIrHrkeyousisksbusyo;
    }

    private BizCurrency irHrkiraikngk;

    public BizCurrency getIrHrkiraikngk() {
        return irHrkiraikngk;
    }

    public void setIrHrkiraikngk(BizCurrency pIrHrkiraikngk) {
        irHrkiraikngk = pIrHrkiraikngk;
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

    private C_KzkpannaijiyuuKbn irKzkpannaijiyuukbn;

    public C_KzkpannaijiyuuKbn getIrKzkpannaijiyuukbn() {
        return irKzkpannaijiyuukbn;
    }

    public void setIrKzkpannaijiyuukbn(C_KzkpannaijiyuuKbn pIrKzkpannaijiyuukbn) {
        irKzkpannaijiyuukbn = pIrKzkpannaijiyuukbn;
    }

    private String irComment124keta;

    public String getIrComment124keta() {
        return irComment124keta;
    }

    public void setIrComment124keta(String pIrComment124keta) {
        irComment124keta = pIrComment124keta;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
