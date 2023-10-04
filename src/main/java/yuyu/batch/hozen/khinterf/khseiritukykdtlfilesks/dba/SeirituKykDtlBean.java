package yuyu.batch.hozen.khinterf.khseiritukykdtlfilesks.dba;

import java.io.Serializable;

import yuyu.def.classification.C_Kykjyoutai;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 成立契約明細Beanクラスです。
 */
@AllArgsConstructor
public class SeirituKykDtlBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private Integer hknkkn;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private String drtencd;

    @Getter @Setter
    private Integer drtenrenno;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
