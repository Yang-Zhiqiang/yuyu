package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_TuukabetuKyuusibiRn;
import yuyu.def.db.mapping.GenZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.GenQZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.QZT_TuukabetuKyuusibiRn;

/**
 * 通貨別休止日取扱休止日Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TuukabetuKyuusibiRn} の JavaDoc を参照してください。
 * @see     GenZT_TuukabetuKyuusibiRn
 * @see     PKZT_TuukabetuKyuusibiRn
 * @see     QZT_TuukabetuKyuusibiRn
 * @see     GenQZT_TuukabetuKyuusibiRn
 */
@Entity
public class ZT_TuukabetuKyuusibiRn extends GenZT_TuukabetuKyuusibiRn {

    private static final long serialVersionUID = 1L;

    public ZT_TuukabetuKyuusibiRn() {
    }

    public ZT_TuukabetuKyuusibiRn(String pZrntekiyouymd) {
        super(pZrntekiyouymd);
    }

}
