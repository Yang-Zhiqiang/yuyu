package yuyu.def.base.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 対象ユーザー情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class TaisyouUserInfosByItemsBean implements Serializable {

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
