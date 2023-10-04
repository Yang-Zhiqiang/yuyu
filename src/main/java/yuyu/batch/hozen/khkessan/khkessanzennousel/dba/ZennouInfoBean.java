package yuyu.batch.hozen.khkessan.khkessanzennousel.dba;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 前納情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class ZennouInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate zennoukaisiymd;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
