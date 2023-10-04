package yuyu.batch.hozen.khozen.khkykjisisuuhanei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Sisuukbn;

/**
 * 契約保全 契約保全 指数反映対象Beanクラス
 */
@AllArgsConstructor
public class SisuuHaneiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private C_Sisuukbn sisuukbn;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateYM tmttkntaisyouym;

    @Getter @Setter
    private Integer renno;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
