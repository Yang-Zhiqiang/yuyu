package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全共通 追加設定項目Beanクラス
 */
public class KhAddKoumokuSetteiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String  sakuseiSyozoku;

    @Getter @Setter
    private String sakuseisya;

    public KhAddKoumokuSetteiBean() {
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
