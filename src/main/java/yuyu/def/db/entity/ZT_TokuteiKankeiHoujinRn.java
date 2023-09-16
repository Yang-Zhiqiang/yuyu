package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.mapping.GenZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.GenQZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.QZT_TokuteiKankeiHoujinRn;

/**
 * 特定関係法人マスタテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TokuteiKankeiHoujinRn} の JavaDoc を参照してください。
 * @see     GenZT_TokuteiKankeiHoujinRn
 * @see     PKZT_TokuteiKankeiHoujinRn
 * @see     QZT_TokuteiKankeiHoujinRn
 * @see     GenQZT_TokuteiKankeiHoujinRn
 */
@Entity
public class ZT_TokuteiKankeiHoujinRn extends GenZT_TokuteiKankeiHoujinRn {

    private static final long serialVersionUID = 1L;

    public ZT_TokuteiKankeiHoujinRn() {
    }

    public ZT_TokuteiKankeiHoujinRn(String pZrnkinyuukikancd, String pZrnmeisaibangou) {
        super(pZrnkinyuukikancd, pZrnmeisaibangou);
    }

}
