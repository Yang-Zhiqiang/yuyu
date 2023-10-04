package yuyu.batch.hozen.khinterf.khhokenkykidoufiletyusyutu;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全手続履歴情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KhTtdkRireki iT_KhTtdkRireki;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}