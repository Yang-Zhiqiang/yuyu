package yuyu.batch.hozen.khozen.khsisuurendotmttknhanei.dba;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 契約保全 契約商品Beanクラス
 */
@AllArgsConstructor
public class KhKykSyouhnBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykSyouhn iT_KykSyouhn;

}
