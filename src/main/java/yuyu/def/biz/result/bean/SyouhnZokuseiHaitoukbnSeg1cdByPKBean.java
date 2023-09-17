package yuyu.def.biz.result.bean;



import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Segcd;

/**
 * 保有商品属性マスタBeanクラスです。<br />
 */
@AllArgsConstructor
public class SyouhnZokuseiHaitoukbnSeg1cdByPKBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_HaitouKbn haitoukbn;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
