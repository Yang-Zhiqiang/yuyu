
package yuyu.def.siharai.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.JT_SiHubi;

/**
 * 不備登録情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class HubiTourokuInfosByHasinymdBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private JT_SiHubi jT_SiHubi;

    @Getter @Setter
    private String hubisikibetukey;

    @Getter @Setter
    private BizDate hasinymd;

    @Getter @Setter
    private C_HassinsakiKbn hassinsakikbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
