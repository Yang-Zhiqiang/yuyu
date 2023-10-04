package yuyu.batch.hozen.khansyuu.khpminyuusyoumetu.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納 Ｐ未入消滅対象データBean<br />
 */
@AllArgsConstructor
public class PMinyuuSyoumetuTaisyouDataBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateYM jkipjytym;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
