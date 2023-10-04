package yuyu.batch.hozen.khzeimu.khidoutyousyo.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 税務 契約保全異動調書情報Beanクラス
 */
@AllArgsConstructor
public class KhKhIdouTyousyoInfosByKakutyoujobcdSyoriYmdBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykSyaHenkouRireki kykSyaHenkouRireki;

    @Getter @Setter
    private IT_KykKihon kykKihon;

    @Getter @Setter
    private IT_KykSyouhn kykSyouhn;

    @Getter @Setter
    private IT_KykSya kykSya;

    @Getter @Setter
    private IT_HhknSya hhknSya;

    @Getter @Setter
    private IT_KhTtdkRireki khTtdkRireki;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
