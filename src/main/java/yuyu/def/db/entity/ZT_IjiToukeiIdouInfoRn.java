package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.mapping.GenZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.meta.GenQZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoRn;

/**
 * 医事統計異動情報テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IjiToukeiIdouInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_IjiToukeiIdouInfoRn
 * @see     PKZT_IjiToukeiIdouInfoRn
 * @see     QZT_IjiToukeiIdouInfoRn
 * @see     GenQZT_IjiToukeiIdouInfoRn
 */
@Entity
public class ZT_IjiToukeiIdouInfoRn extends GenZT_IjiToukeiIdouInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_IjiToukeiIdouInfoRn() {
    }

    public ZT_IjiToukeiIdouInfoRn(String pZrnsyono, Integer pZrnkykmfksnctr) {
        super(pZrnsyono, pZrnkykmfksnctr);
    }

}
