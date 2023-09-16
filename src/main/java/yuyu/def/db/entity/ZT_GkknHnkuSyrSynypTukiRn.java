package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.db.mapping.GenZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.db.meta.GenQZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.db.meta.QZT_GkknHnkuSyrSynypTukiRn;

/**
 * 月間変更処理収入Ｐ統計Fテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GkknHnkuSyrSynypTukiRn} の JavaDoc を参照してください。
 * @see     GenZT_GkknHnkuSyrSynypTukiRn
 * @see     PKZT_GkknHnkuSyrSynypTukiRn
 * @see     QZT_GkknHnkuSyrSynypTukiRn
 * @see     GenQZT_GkknHnkuSyrSynypTukiRn
 */
@Entity
public class ZT_GkknHnkuSyrSynypTukiRn extends GenZT_GkknHnkuSyrSynypTukiRn {

    private static final long serialVersionUID = 1L;

    public ZT_GkknHnkuSyrSynypTukiRn() {
    }

    public ZT_GkknHnkuSyrSynypTukiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
