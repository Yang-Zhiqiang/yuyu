package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.mapping.GenZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.meta.GenQZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiTy;

/**
 * 申込状況一覧照会用Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_MosJkItiranSyoukaiTy} の JavaDoc を参照してください。
 * @see     GenZT_MosJkItiranSyoukaiTy
 * @see     PKZT_MosJkItiranSyoukaiTy
 * @see     QZT_MosJkItiranSyoukaiTy
 * @see     GenQZT_MosJkItiranSyoukaiTy
 */
@Entity
public class ZT_MosJkItiranSyoukaiTy extends GenZT_MosJkItiranSyoukaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_MosJkItiranSyoukaiTy() {
    }

    public ZT_MosJkItiranSyoukaiTy(
        String pZtymosym,
        String pZtymosno,
        String pZtybsydrtencd,
        String pZtyatukaikojincd
    ) {
        super(
            pZtymosym,
            pZtymosno,
            pZtybsydrtencd,
            pZtyatukaikojincd
        );
    }

}
