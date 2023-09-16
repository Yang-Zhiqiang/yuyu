package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RrtHndugtHknJigyohiTy;
import yuyu.def.db.mapping.GenZT_RrtHndugtHknJigyohiTy;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknJigyohiTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknJigyohiTy;

/**
 * 利率変動型保険事業費Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RrtHndugtHknJigyohiTy} の JavaDoc を参照してください。
 * @see     GenZT_RrtHndugtHknJigyohiTy
 * @see     PKZT_RrtHndugtHknJigyohiTy
 * @see     QZT_RrtHndugtHknJigyohiTy
 * @see     GenQZT_RrtHndugtHknJigyohiTy
 */
@Entity
public class ZT_RrtHndugtHknJigyohiTy extends GenZT_RrtHndugtHknJigyohiTy {

    private static final long serialVersionUID = 1L;

    public ZT_RrtHndugtHknJigyohiTy() {
    }

    public ZT_RrtHndugtHknJigyohiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
