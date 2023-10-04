package yuyu.batch.hozen.khansyuu.khsaikokutuutisks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納 催告通知作成データを保持するBeanクラスです。<br />
 */
@AllArgsConstructor
public class SaikokuTuutiSksTaisyouDataBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDateYM jkipjytym;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
