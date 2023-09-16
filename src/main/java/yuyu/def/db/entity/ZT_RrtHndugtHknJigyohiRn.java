package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RrtHndugtHknJigyohiRn;
import yuyu.def.db.mapping.GenZT_RrtHndugtHknJigyohiRn;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknJigyohiRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknJigyohiRn;

/**
 * 利率変動型保険事業費Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RrtHndugtHknJigyohiRn} の JavaDoc を参照してください。
 * @see     GenZT_RrtHndugtHknJigyohiRn
 * @see     PKZT_RrtHndugtHknJigyohiRn
 * @see     QZT_RrtHndugtHknJigyohiRn
 * @see     GenQZT_RrtHndugtHknJigyohiRn
 */
@Entity
public class ZT_RrtHndugtHknJigyohiRn extends GenZT_RrtHndugtHknJigyohiRn {

    private static final long serialVersionUID = 1L;

    public ZT_RrtHndugtHknJigyohiRn() {
    }

    public ZT_RrtHndugtHknJigyohiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
