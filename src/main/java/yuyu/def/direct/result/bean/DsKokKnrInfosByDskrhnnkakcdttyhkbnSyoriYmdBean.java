package yuyu.def.direct.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;

/**
 * 仮パスワード通知中断対象ＤＳ顧客管理情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private MT_DsKokyakuKanri mT_DsKokyakuKanri;

    @Getter @Setter
    private MT_DsHonninKakuninCd mT_DsHonninKakuninCd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}