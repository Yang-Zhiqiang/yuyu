package yuyu.common.suuri.srcommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約代理店テーブルBeanクラスです。<br />
 */
@AllArgsConstructor
public class KykDairitenByPkBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private String drtenkanrisosikicd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
