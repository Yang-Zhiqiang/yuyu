package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約代理店（代理店連番最小値）情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KykDairitensMinDrtenrennoBySyonoBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private String drtencd;

    @Getter @Setter
    private Integer drtenrenno;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
