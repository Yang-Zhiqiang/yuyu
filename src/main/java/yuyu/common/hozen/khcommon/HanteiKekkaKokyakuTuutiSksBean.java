package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 顧客通知帳票本番確認 判定結果Beanクラス
 */
public class HanteiKekkaKokyakuTuutiSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_UmuKbn updateKbn;

    @Getter @Setter
    private List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList;

    @Getter @Setter
    private HashMap<String, Boolean> tyouhyouHnbnKknnFlgMap;

    @Getter @Setter
    private HashMap<String, Integer> tyouhyouHnbnKknnCntMap;

    public HanteiKekkaKokyakuTuutiSksBean() {
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
