package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HonsyaToukeiTy;
import yuyu.def.db.mapping.GenZT_HonsyaToukeiTy;
import yuyu.def.db.meta.GenQZT_HonsyaToukeiTy;
import yuyu.def.db.meta.QZT_HonsyaToukeiTy;

/**
 * 本社統計Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HonsyaToukeiTy} の JavaDoc を参照してください。
 * @see     GenZT_HonsyaToukeiTy
 * @see     PKZT_HonsyaToukeiTy
 * @see     QZT_HonsyaToukeiTy
 * @see     GenQZT_HonsyaToukeiTy
 */
@Entity
public class ZT_HonsyaToukeiTy extends GenZT_HonsyaToukeiTy {

    private static final long serialVersionUID = 1L;

    public ZT_HonsyaToukeiTy() {
    }

    public ZT_HonsyaToukeiTy(String pZtykijyunym, String pZtymosno) {
        super(pZtykijyunym, pZtymosno);
    }

}
