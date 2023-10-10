package yuyu.app.direct.dskokyakukanri.dskokyakuseibi.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;

/**
 * 特定取引用口座情報取得Beanクラス<br />
 */
@AllArgsConstructor
public class TktiTrhkyuKzInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_KouzasyuruiKbn kouzasyuruikbn;

    @Getter @Setter
    private String bankcd;

    @Getter @Setter
    private String sitencd;

    @Getter @Setter
    private String kouzano;

    @Getter @Setter
    private C_Kzdou kzdou;

    @Getter @Setter
    private String kzmeiginmkn;

    @Getter @Setter
    private BizDate sinsetuymd;

    @Getter @Setter
    private BizDate haisiymd;

    @Getter @Setter
    private String banknmkj;

    @Getter @Setter
    private String sitennmkj;

    @Getter @Setter
    private String kyknmkn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
