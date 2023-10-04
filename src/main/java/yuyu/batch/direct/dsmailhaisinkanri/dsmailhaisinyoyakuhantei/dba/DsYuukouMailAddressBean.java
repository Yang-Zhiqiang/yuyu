package yuyu.batch.direct.dsmailhaisinkanri.dsmailhaisinyoyakuhantei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ＤＳ有効メールアドレス情報Beanクラス<br />
 */
@AllArgsConstructor
public class DsYuukouMailAddressBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private int dsmailaddressrenban;

    @Getter @Setter
    private String dsmailaddress;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
