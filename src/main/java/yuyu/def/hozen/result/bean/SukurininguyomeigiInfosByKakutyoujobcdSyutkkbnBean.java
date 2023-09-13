
package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * スクリーニング用名義情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon kykKihon;

    @Getter @Setter
    private IT_KykSyouhn kykSyouhn;

    @Getter @Setter
    private IT_KykSya kykSya;

    @Getter @Setter
    private IT_HhknSya khknSya;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
