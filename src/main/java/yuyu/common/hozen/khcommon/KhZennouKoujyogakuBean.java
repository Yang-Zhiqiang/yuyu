package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import java.util.List;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全共通 前納控除証明額情報Beanクラス
 */
public class KhZennouKoujyogakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList;

    @Getter @Setter
    private List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList;

    public KhZennouKoujyogakuBean() {
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
