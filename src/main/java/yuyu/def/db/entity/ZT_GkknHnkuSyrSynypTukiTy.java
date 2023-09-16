package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.db.mapping.GenZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.db.meta.GenQZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.db.meta.QZT_GkknHnkuSyrSynypTukiTy;

/**
 * 月間変更処理収入Ｐ統計Fテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GkknHnkuSyrSynypTukiTy} の JavaDoc を参照してください。
 * @see     GenZT_GkknHnkuSyrSynypTukiTy
 * @see     PKZT_GkknHnkuSyrSynypTukiTy
 * @see     QZT_GkknHnkuSyrSynypTukiTy
 * @see     GenQZT_GkknHnkuSyrSynypTukiTy
 */
@Entity
public class ZT_GkknHnkuSyrSynypTukiTy extends GenZT_GkknHnkuSyrSynypTukiTy {

    private static final long serialVersionUID = 1L;

    public ZT_GkknHnkuSyrSynypTukiTy() {
    }

    public ZT_GkknHnkuSyrSynypTukiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
