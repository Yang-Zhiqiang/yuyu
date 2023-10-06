package yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakukenti.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 システム本番検証用 期日到来契約検知Bean
 */
@AllArgsConstructor
public class KijituTouraiHonbanKensyouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String subSystemId;

    @Getter
    @Setter
    private Integer tysytno;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
