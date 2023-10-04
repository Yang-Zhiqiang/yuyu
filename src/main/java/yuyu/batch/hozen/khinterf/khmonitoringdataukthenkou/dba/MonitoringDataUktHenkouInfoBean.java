package yuyu.batch.hozen.khinterf.khmonitoringdataukthenkou.dba;

import java.io.Serializable;

import yuyu.def.db.entity.IT_KykKihon;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ情報Beanクラス<br /
 */
@AllArgsConstructor
public class MonitoringDataUktHenkouInfoBean implements Serializable ,EntityContainer{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon kykKihon;

    @Getter @Setter
    private BizDate syoriYmd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
