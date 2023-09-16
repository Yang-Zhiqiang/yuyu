package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.db.mapping.GenZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.db.meta.GenQZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkRn;

/**
 * 給付金支払状況連絡Fテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KyhknShrJyoukyouRnrkRn} の JavaDoc を参照してください。
 * @see     GenZT_KyhknShrJyoukyouRnrkRn
 * @see     PKZT_KyhknShrJyoukyouRnrkRn
 * @see     QZT_KyhknShrJyoukyouRnrkRn
 * @see     GenQZT_KyhknShrJyoukyouRnrkRn
 */
@Entity
public class ZT_KyhknShrJyoukyouRnrkRn extends GenZT_KyhknShrJyoukyouRnrkRn {

    private static final long serialVersionUID = 1L;

    public ZT_KyhknShrJyoukyouRnrkRn() {
    }

    public ZT_KyhknShrJyoukyouRnrkRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
