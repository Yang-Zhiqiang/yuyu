package yuyu.batch.direct.dsmailhaisinkanri.dsjkihknryouosirsmailsakusei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 次回保険料お知らせメール作成Beanクラス<br />
 *
 */
@AllArgsConstructor
public class DsJkiHknryouOsirsMailSakuseiTaisyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private Integer dsmailaddressrenban;

    @Getter @Setter
    private String dsmailaddress;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
