package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約商品（主契約単位）情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KykSyouhnsyutaniBySyonoBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private BizDate kouryokuhasseiymd;

    @Getter @Setter
    private String gyoumuKousinKinou;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
