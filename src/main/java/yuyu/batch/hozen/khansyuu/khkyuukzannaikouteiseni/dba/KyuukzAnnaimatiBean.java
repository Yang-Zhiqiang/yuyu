package yuyu.batch.hozen.khansyuu.khkyuukzannaikouteiseni.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納 旧口座案内待ち情報を保持するBeanクラです。
 */
@AllArgsConstructor
public class KyuukzAnnaimatiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kouteikanriid;

    @Getter @Setter
    private String syono;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
