package yuyu.batch.hozen.khkessan.khyendthnkbikintyusyutu.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全備金管理対象（円建変更）情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhBikinkanriYendthnkInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate kessankijyunymd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
