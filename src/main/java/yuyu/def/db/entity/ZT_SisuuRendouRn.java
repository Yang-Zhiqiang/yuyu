package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SisuuRendouRn;
import yuyu.def.db.mapping.GenZT_SisuuRendouRn;
import yuyu.def.db.meta.GenQZT_SisuuRendouRn;
import yuyu.def.db.meta.QZT_SisuuRendouRn;

/**
 * 指数連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SisuuRendouRn} の JavaDoc を参照してください。
 * @see     GenZT_SisuuRendouRn
 * @see     PKZT_SisuuRendouRn
 * @see     QZT_SisuuRendouRn
 * @see     GenQZT_SisuuRendouRn
 */
@Entity
public class ZT_SisuuRendouRn extends GenZT_SisuuRendouRn {

    private static final long serialVersionUID = 1L;

    public ZT_SisuuRendouRn() {
    }

    public ZT_SisuuRendouRn(String pZrntorikomiyousisuukbn, String pZrnsisuukouhyouymd) {
        super(pZrntorikomiyousisuukbn, pZrnsisuukouhyouymd);
    }

}
