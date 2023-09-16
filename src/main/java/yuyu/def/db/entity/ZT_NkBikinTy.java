package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkBikinTy;
import yuyu.def.db.mapping.GenZT_NkBikinTy;
import yuyu.def.db.meta.GenQZT_NkBikinTy;
import yuyu.def.db.meta.QZT_NkBikinTy;

/**
 * 年金備金テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkBikinTy} の JavaDoc を参照してください。
 * @see     GenZT_NkBikinTy
 * @see     PKZT_NkBikinTy
 * @see     QZT_NkBikinTy
 * @see     GenQZT_NkBikinTy
 */
@Entity
public class ZT_NkBikinTy extends GenZT_NkBikinTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkBikinTy() {
    }

    public ZT_NkBikinTy(String pZtynksyousyono, String pZtyshiharaihasseiymd) {
        super(pZtynksyousyono, pZtyshiharaihasseiymd);
    }

}
