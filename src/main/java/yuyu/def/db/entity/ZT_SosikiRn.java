package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SosikiRn;
import yuyu.def.db.mapping.GenZT_SosikiRn;
import yuyu.def.db.meta.GenQZT_SosikiRn;
import yuyu.def.db.meta.QZT_SosikiRn;

/**
 * 普保用組織ＰＲＴ用連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SosikiRn} の JavaDoc を参照してください。
 * @see     GenZT_SosikiRn
 * @see     PKZT_SosikiRn
 * @see     QZT_SosikiRn
 * @see     GenQZT_SosikiRn
 */
@Entity
public class ZT_SosikiRn extends GenZT_SosikiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SosikiRn() {
    }

    public ZT_SosikiRn(String pZrnsosikicd) {
        super(pZrnsosikicd);
    }

}
