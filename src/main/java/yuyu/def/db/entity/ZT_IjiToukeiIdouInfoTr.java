package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.mapping.GenZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.GenQZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoTr;

/**
 * 医事統計異動情報テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IjiToukeiIdouInfoTr} の JavaDoc を参照してください。
 * @see     GenZT_IjiToukeiIdouInfoTr
 * @see     PKZT_IjiToukeiIdouInfoTr
 * @see     QZT_IjiToukeiIdouInfoTr
 * @see     GenQZT_IjiToukeiIdouInfoTr
 */
@Entity
public class ZT_IjiToukeiIdouInfoTr extends GenZT_IjiToukeiIdouInfoTr {

    private static final long serialVersionUID = 1L;

    public ZT_IjiToukeiIdouInfoTr() {
    }

    public ZT_IjiToukeiIdouInfoTr(String pZtrsyono, Integer pZtrkykmfksnctr) {
        super(pZtrsyono, pZtrkykmfksnctr);
    }

}
