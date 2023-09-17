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
public class UsersByKinouIdKinouModeIdUserIdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public UsersByKinouIdKinouModeIdUserIdBean(String pUserId, String pUserNm){
        userId = pUserId;
        userNm = pUserNm;
        sosikiCd = null;
        sosikiNm = null;
    }

    @Getter @Setter
    private String userId;

    @Getter @Setter
    private String userNm;

    @Getter @Setter
    private String sosikiCd;

    @Getter @Setter
    private String sosikiNm;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
