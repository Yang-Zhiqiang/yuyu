package yuyu.def.biz.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;

/**
 * 取込用表紙情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class ZtrhyousiInfoBySyoruiCdBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    public ZtrhyousiInfoBySyoruiCdBean() {
    }

    @Getter @Setter
    private BM_TorikomiSyoruiHukaInfo bM_TorikomiSyoruiHukaInfo;

    @Getter @Setter
    private AM_SyoruiZokusei aM_SyoruiZokusei;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
