package yuyu.def.direct.bean.report;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （ダイレクト）後続事務確認リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenDsKzkjmkknListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenDsKzkjmkknListDataSourceBean() {
    }

    private C_DsKzkJmKknHsJyKbn irDskzkjmkknhsjykbn;

    public C_DsKzkJmKknHsJyKbn getIrDskzkjmkknhsjykbn() {
        return irDskzkjmkknhsjykbn;
    }

    public void setIrDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn pIrDskzkjmkknhsjykbn) {
        irDskzkjmkknhsjykbn = pIrDskzkjmkknhsjykbn;
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

    private String irMessage;

    public String getIrMessage() {
        return irMessage;
    }

    public void setIrMessage(String pIrMessage) {
        irMessage = pIrMessage;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
