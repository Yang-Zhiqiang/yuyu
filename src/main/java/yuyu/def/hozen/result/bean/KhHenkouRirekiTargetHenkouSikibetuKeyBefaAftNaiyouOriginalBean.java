package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全変更履歴変更識別キーターゲット変更前後内容原本Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private String bfrnaiyouoriginal;

    @Getter @Setter
    private String newnaiyouoriginal;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
