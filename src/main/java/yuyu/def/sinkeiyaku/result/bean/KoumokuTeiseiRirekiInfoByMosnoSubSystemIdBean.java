package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 項目訂正履歴情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syoriTime;

    @Getter @Setter
    private String kinouModeId;

    @Getter @Setter
    private String kinouModeNm;

    @Getter @Setter
    private String tskmnm;

    @Getter @Setter
    private String tsmaenaiyou;

    @Getter @Setter
    private String tsgonaiyou;

    @Getter @Setter
    private String kinouNm;

    @Getter @Setter
    private String tantid;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
