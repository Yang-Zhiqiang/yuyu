package yuyu.batch.hozen.khansyuu.khcardtourokumatikouteiseni.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * カード情報登録待ち情報Beanクラスです。
 */

@AllArgsConstructor
public class CardTourokuMatiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kouteikanriid;

    @Getter @Setter
    private String creditKessaiyouNo;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
