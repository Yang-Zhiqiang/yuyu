package yuyu.batch.hozen.khinterf.khheijunbaraiinfosel.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 平準払情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class HeijunbaraiInfoBean implements Serializable, EntityContainer{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon kykKihon;

    @Getter @Setter
    private IT_AnsyuKihon ansyuKihon;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
