package yuyu.batch.hozen.khinterf.khmonitoringdatasoukikaiyaku.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ（早期解約）Beanクラスです。<br />
 */
@AllArgsConstructor
public class KyMonitoringDataSoukiKaiyakuBean implements Serializable, EntityContainer{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon kykKihon;

    @Getter @Setter
    private IT_KykSyouhn kykSyouhn;

    @Getter @Setter
    private IT_KhShrRireki khShrRireki;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
