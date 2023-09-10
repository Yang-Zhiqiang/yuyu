
package yuyu.def.siharai.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;

/**
 * 同時請求情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class DoujiSeikyuuInfosBySknoSyonoNeBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private String skno;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_SeikyuuSyubetu seikyuusyubetu;

    @Getter @Setter
    private C_SyoriJyoutaiKbn syorijyoutaikbn;

    @Getter @Setter
    private C_HubiJyoukyouKbn hubijyoukyoukbn;

    @Getter @Setter
    private C_TyousaJyoukyouKbn tyousajyoukyoukbn;

    @Getter @Setter
    private BizDate saisinSyoriYmd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
