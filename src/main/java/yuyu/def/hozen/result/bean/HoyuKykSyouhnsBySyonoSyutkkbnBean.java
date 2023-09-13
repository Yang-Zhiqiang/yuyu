package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 保有契約商品情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class HoyuKykSyouhnsBySyonoSyutkkbnBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private C_SyutkKbn syutkkbn;

    @Getter @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Getter @Setter
    private BizDate syoumetuymd;

    @Getter @Setter
    private C_Syoumetujiyuu syoumetujiyuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
