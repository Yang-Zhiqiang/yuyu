package yuyu.batch.hozen.khansyuu.khyoyakuidoukousin.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 予約異動受付情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class YykIdouUktkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private String kinouId;

    @Getter @Setter
    private BizDateYM syoriym;

    @Getter @Setter
    private BizDate uktkymd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
