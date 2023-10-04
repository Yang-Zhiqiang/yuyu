package yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 前回メール配信時ＤＳ値動き判定結果情報Beanクラス<br />
 */
@AllArgsConstructor
public class ZenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizNumber neugokiwari;

    @Getter @Setter
    private BizNumber neugokitoutatulinemail;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
