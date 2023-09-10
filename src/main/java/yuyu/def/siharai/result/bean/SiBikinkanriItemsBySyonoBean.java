package yuyu.def.siharai.result.bean;
import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;

/**
 * 保有保険金給付金備金管理情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SiBikinkanriItemsBySyonoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate kessankijyunymd;

    @Getter @Setter
    private C_BknrigiKbn bknrigikbn;

    @Getter @Setter
    private C_BkncdKbn bkncdkbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
