package yuyu.def.biz.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務用工程情報Beanです。<br />
 */
@AllArgsConstructor
public class GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kouteikanriid;

    @Getter @Setter
    private String jimutetuzukicd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
