package yuyu.batch.hozen.khinterf.khmonitoringdatapeps.dba;

import java.io.Serializable;

import yuyu.def.db.entity.IT_KykKihon;
import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（ＰＥＰｓ）Beanクラス
 */
@AllArgsConstructor
public class KhMonitoringDataPepsInfosBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
