package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.mapping.GenZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.meta.GenQZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkTy;

/**
 * 給付金支払状況連絡Fテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KyhknShrJyoukyouRnrkTy} の JavaDoc を参照してください。
 * @see     GenZT_KyhknShrJyoukyouRnrkTy
 * @see     PKZT_KyhknShrJyoukyouRnrkTy
 * @see     QZT_KyhknShrJyoukyouRnrkTy
 * @see     GenQZT_KyhknShrJyoukyouRnrkTy
 */
@Entity
public class ZT_KyhknShrJyoukyouRnrkTy extends GenZT_KyhknShrJyoukyouRnrkTy {

    private static final long serialVersionUID = 1L;

    public ZT_KyhknShrJyoukyouRnrkTy() {
    }

    public ZT_KyhknShrJyoukyouRnrkTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
