package yuyu.batch.hozen.khinterf.khmizuhodrtensikkoukykdtlfsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス Ｐ未入消滅情報Bean
 */
@AllArgsConstructor
public class PMinyuuSyoumetuInfoBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private BizDateYM syoriym;

    @Getter
    @Setter
    private BizDate syoriYmd;

    @Getter
    @Setter
    private BizDate syoumetuymd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
