package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SikinidouJtKbn;

/**
 * 業務共通 経理・会計 資金移動リスト作成用平準払入金データBeanクラス
 */
@AllArgsConstructor
public class SikinIdouListSkshijynbrNykDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDateYM sikinidoupjytym;

    @Getter @Setter
    private C_SikinidouJtKbn sikinidoujtkbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
