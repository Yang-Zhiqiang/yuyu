package yuyu.def.biz.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 転送先情報Beanです。<br />
 */
@AllArgsConstructor
public class UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String userId;

    @Getter @Setter
    private String userNm;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
