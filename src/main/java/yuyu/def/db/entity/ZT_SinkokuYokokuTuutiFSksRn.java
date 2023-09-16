package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.db.mapping.GenZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.db.meta.GenQZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.db.meta.QZT_SinkokuYokokuTuutiFSksRn;

/**
 * 申告予告通知Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkokuYokokuTuutiFSksRn} の JavaDoc を参照してください。
 * @see     GenZT_SinkokuYokokuTuutiFSksRn
 * @see     PKZT_SinkokuYokokuTuutiFSksRn
 * @see     QZT_SinkokuYokokuTuutiFSksRn
 * @see     GenQZT_SinkokuYokokuTuutiFSksRn
 */
@Entity
public class ZT_SinkokuYokokuTuutiFSksRn extends GenZT_SinkokuYokokuTuutiFSksRn {

    private static final long serialVersionUID = 1L;

    public ZT_SinkokuYokokuTuutiFSksRn() {
    }

    public ZT_SinkokuYokokuTuutiFSksRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsinkokunenkj
    ) {
        super(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsinkokunenkj
        );
    }

}
