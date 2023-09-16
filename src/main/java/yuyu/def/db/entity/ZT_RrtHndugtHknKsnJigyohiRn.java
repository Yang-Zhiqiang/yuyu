package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.db.mapping.GenZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiRn;

/**
 * 利率変動型保険決算用事業費Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RrtHndugtHknKsnJigyohiRn} の JavaDoc を参照してください。
 * @see     GenZT_RrtHndugtHknKsnJigyohiRn
 * @see     PKZT_RrtHndugtHknKsnJigyohiRn
 * @see     QZT_RrtHndugtHknKsnJigyohiRn
 * @see     GenQZT_RrtHndugtHknKsnJigyohiRn
 */
@Entity
public class ZT_RrtHndugtHknKsnJigyohiRn extends GenZT_RrtHndugtHknKsnJigyohiRn {

    private static final long serialVersionUID = 1L;

    public ZT_RrtHndugtHknKsnJigyohiRn() {
    }

    public ZT_RrtHndugtHknKsnJigyohiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
