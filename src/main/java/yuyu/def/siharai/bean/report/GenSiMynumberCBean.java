package yuyu.def.siharai.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_UmuKbn;

/**
 * （支払）マイナンバー申告書（Ｃ票）帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiMynumberCBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiMynumberCBean() {
    }


    private String irTyouhyoutitle;


    public String getIrTyouhyoutitle() {
        return irTyouhyoutitle;
    }


    public void setIrTyouhyoutitle(String pIrTyouhyoutitle) {
        irTyouhyoutitle = pIrTyouhyoutitle;
    }


    private String irSyono;


    public String getIrSyono() {
        return irSyono;
    }


    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }


    private C_UmuKbn irSinkokurukthyjumu;


    public C_UmuKbn getIrSinkokurukthyjumu() {
        return irSinkokurukthyjumu;
    }


    public void setIrSinkokurukthyjumu(C_UmuKbn pIrSinkokurukthyjumu) {
        irSinkokurukthyjumu = pIrSinkokurukthyjumu;
    }


    private C_UmuKbn irSinkokursksyahyjumu;


    public C_UmuKbn getIrSinkokursksyahyjumu() {
        return irSinkokursksyahyjumu;
    }


    public void setIrSinkokursksyahyjumu(C_UmuKbn pIrSinkokursksyahyjumu) {
        irSinkokursksyahyjumu = pIrSinkokursksyahyjumu;
    }


    private C_UmuKbn irIninrukthyjumu;


    public C_UmuKbn getIrIninrukthyjumu() {
        return irIninrukthyjumu;
    }


    public void setIrIninrukthyjumu(C_UmuKbn pIrIninrukthyjumu) {
        irIninrukthyjumu = pIrIninrukthyjumu;
    }


    private C_UmuKbn irIninrkykhyjumu;


    public C_UmuKbn getIrIninrkykhyjumu() {
        return irIninrkykhyjumu;
    }


    public void setIrIninrkykhyjumu(C_UmuKbn pIrIninrkykhyjumu) {
        irIninrkykhyjumu = pIrIninrkykhyjumu;
    }


    private C_UmuKbn irIninrsksyahyjumu;


    public C_UmuKbn getIrIninrsksyahyjumu() {
        return irIninrsksyahyjumu;
    }


    public void setIrIninrsksyahyjumu(C_UmuKbn pIrIninrsksyahyjumu) {
        irIninrsksyahyjumu = pIrIninrsksyahyjumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
