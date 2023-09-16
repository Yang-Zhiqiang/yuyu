package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.mapping.GenZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiTy;

/**
 * 利率変動型保険決算用事業費Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RrtHndugtHknKsnJigyohiTy} の JavaDoc を参照してください。
 * @see     GenZT_RrtHndugtHknKsnJigyohiTy
 * @see     PKZT_RrtHndugtHknKsnJigyohiTy
 * @see     QZT_RrtHndugtHknKsnJigyohiTy
 * @see     GenQZT_RrtHndugtHknKsnJigyohiTy
 */
@Entity
public class ZT_RrtHndugtHknKsnJigyohiTy extends GenZT_RrtHndugtHknKsnJigyohiTy {

    private static final long serialVersionUID = 1L;

    public ZT_RrtHndugtHknKsnJigyohiTy() {
    }

    public ZT_RrtHndugtHknKsnJigyohiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
