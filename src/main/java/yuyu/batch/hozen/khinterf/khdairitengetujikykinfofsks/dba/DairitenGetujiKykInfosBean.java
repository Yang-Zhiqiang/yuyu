package yuyu.batch.hozen.khinterf.khdairitengetujikykinfofsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 代理店月次契約情報一括Beanクラス<br />
 */
@AllArgsConstructor
public class DairitenGetujiKykInfosBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private IT_KykDairiten kykDairiten;

    @Getter
    @Setter
    private IT_KykKihon kykKihon;

    @Getter
    @Setter
    private IT_KykSyouhn kykSyouhn;

    @Getter
    @Setter
    private IT_KykSonotaTkyk kykSonotaTkyk;

    @Getter
    @Setter
    private IT_HhknSya hhknSya;

    @Getter
    @Setter
    private IT_KykSya kykSya;

    @Getter
    @Setter
    private IT_AnsyuKihon ansyuKihon;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
