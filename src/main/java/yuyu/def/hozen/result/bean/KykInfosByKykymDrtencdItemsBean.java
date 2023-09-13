package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KykInfosByKykymDrtencdItemsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kyknmkn;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private BizDate kykseiymd;

    @Getter @Setter
    private String tsintelno;

    @Getter @Setter
    private String dai2tsintelno;

    @Getter @Setter
    private String hhknnmkn;

    @Getter @Setter
    private String hhknnmkj;

    @Getter @Setter
    private BizDate hhknseiymd;

    @Getter @Setter
    private String syouhnnm;

    @Getter @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
