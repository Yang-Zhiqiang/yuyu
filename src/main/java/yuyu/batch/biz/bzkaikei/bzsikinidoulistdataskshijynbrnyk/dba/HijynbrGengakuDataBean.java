package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 経理・平準払減額データBeanクラス
 */
@AllArgsConstructor
public class HijynbrGengakuDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String bfrnaiyou;

    @Getter @Setter
    private String newnaiyou;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
