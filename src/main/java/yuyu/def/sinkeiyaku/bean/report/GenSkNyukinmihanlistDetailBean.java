package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）入金未反映リスト明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkNyukinmihanlistDetailBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkNyukinmihanlistDetailBean() {
    }


    private String irTyakkinymd;


    public String getIrTyakkinymd() {
        return irTyakkinymd;
    }


    public void setIrTyakkinymd(String pIrTyakkinymd) {
        irTyakkinymd = pIrTyakkinymd;
    }


    private String irSyono;


    public String getIrSyono() {
        return irSyono;
    }


    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }


    private String irHrkmirninnm;


    public String getIrHrkmirninnm() {
        return irHrkmirninnm;
    }


    public void setIrHrkmirninnm(String pIrHrkmirninnm) {
        irHrkmirninnm = pIrHrkmirninnm;
    }


    private BizCurrency irNyknkgk;


    public BizCurrency getIrNyknkgk() {
        return irNyknkgk;
    }


    public void setIrNyknkgk(BizCurrency pIrNyknkgk) {
        irNyknkgk = pIrNyknkgk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
