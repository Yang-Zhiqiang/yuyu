package yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ＤＳ値動き判定結果情報Beanクラス<br />
 */
@AllArgsConstructor
public class DsNeugokiHanteiKekkaBySyonoROWNUMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizNumber neugokiwari;

    @Getter @Setter
    private BizNumber neugokitoutatulinefile;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
