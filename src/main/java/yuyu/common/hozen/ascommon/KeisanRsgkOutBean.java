package yuyu.common.hozen.ascommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納共通 領収金額計算結果Bean
 */
public class KeisanRsgkOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency rsgakuGoukei;

    @Getter @Setter
    private BizCurrency iktwaribikikgkGoukei;

    @Getter @Setter
    List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
