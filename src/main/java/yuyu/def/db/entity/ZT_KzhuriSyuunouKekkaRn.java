package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.mapping.GenZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.meta.GenQZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaRn;

/**
 * 口座振替収納結果Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KzhuriSyuunouKekkaRn} の JavaDoc を参照してください。
 * @see     GenZT_KzhuriSyuunouKekkaRn
 * @see     PKZT_KzhuriSyuunouKekkaRn
 * @see     QZT_KzhuriSyuunouKekkaRn
 * @see     GenQZT_KzhuriSyuunouKekkaRn
 */
@Entity
public class ZT_KzhuriSyuunouKekkaRn extends GenZT_KzhuriSyuunouKekkaRn {

    private static final long serialVersionUID = 1L;

    public ZT_KzhuriSyuunouKekkaRn() {
    }

    public ZT_KzhuriSyuunouKekkaRn(String pZrnsyono, String pZrnjyuutouym) {
        super(pZrnsyono, pZrnjyuutouym);
    }

}
