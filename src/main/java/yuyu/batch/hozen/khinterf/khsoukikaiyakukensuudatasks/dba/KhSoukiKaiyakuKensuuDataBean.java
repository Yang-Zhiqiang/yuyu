package yuyu.batch.hozen.khinterf.khsoukikaiyakukensuudatasks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 インターフェイス 契約保全早期解約件数データ作成Beanクラス
 */
@AllArgsConstructor
public class KhSoukiKaiyakuKensuuDataBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSyouhn iT_KykSyouhn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
