package yuyu.batch.hozen.khinterf.khmonitoringdatacoolingoff.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ情報Bean
 */
@AllArgsConstructor
public class KhMonitoringDataCoolingoffBean  implements Serializable, EntityContainer{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KhShrRireki iT_KhShrRireki;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
