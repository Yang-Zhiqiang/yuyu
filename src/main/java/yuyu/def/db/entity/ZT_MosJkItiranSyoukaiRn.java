package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.mapping.GenZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.meta.GenQZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiRn;

/**
 * 申込状況一覧照会用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_MosJkItiranSyoukaiRn} の JavaDoc を参照してください。
 * @see     GenZT_MosJkItiranSyoukaiRn
 * @see     PKZT_MosJkItiranSyoukaiRn
 * @see     QZT_MosJkItiranSyoukaiRn
 * @see     GenQZT_MosJkItiranSyoukaiRn
 */
@Entity
public class ZT_MosJkItiranSyoukaiRn extends GenZT_MosJkItiranSyoukaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_MosJkItiranSyoukaiRn() {
    }

    public ZT_MosJkItiranSyoukaiRn(
        String pZrnmosym,
        String pZrnmosno,
        String pZrnbsydrtencd,
        String pZrnatukaikojincd
    ) {
        super(
            pZrnmosym,
            pZrnmosno,
            pZrnbsydrtencd,
            pZrnatukaikojincd
        );
    }

}
