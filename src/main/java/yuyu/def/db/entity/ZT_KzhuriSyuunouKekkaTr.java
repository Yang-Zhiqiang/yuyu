package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.mapping.GenZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.meta.GenQZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaTr;

/**
 * 口座振替収納結果Ｆテーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KzhuriSyuunouKekkaTr} の JavaDoc を参照してください。
 * @see     GenZT_KzhuriSyuunouKekkaTr
 * @see     PKZT_KzhuriSyuunouKekkaTr
 * @see     QZT_KzhuriSyuunouKekkaTr
 * @see     GenQZT_KzhuriSyuunouKekkaTr
 */
@Entity
public class ZT_KzhuriSyuunouKekkaTr extends GenZT_KzhuriSyuunouKekkaTr {

    private static final long serialVersionUID = 1L;

    public ZT_KzhuriSyuunouKekkaTr() {
    }

    public ZT_KzhuriSyuunouKekkaTr(String pZtrsyono, String pZtrjyuutouym) {
        super(pZtrsyono, pZtrjyuutouym);
    }

}
