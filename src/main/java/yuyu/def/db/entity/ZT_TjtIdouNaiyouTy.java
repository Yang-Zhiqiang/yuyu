package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TjtIdouNaiyouTy;
import yuyu.def.db.mapping.GenZT_TjtIdouNaiyouTy;
import yuyu.def.db.meta.GenQZT_TjtIdouNaiyouTy;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouTy;

/**
 * 当日異動内容テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjtIdouNaiyouTy} の JavaDoc を参照してください。
 * @see     GenZT_TjtIdouNaiyouTy
 * @see     PKZT_TjtIdouNaiyouTy
 * @see     QZT_TjtIdouNaiyouTy
 * @see     GenQZT_TjtIdouNaiyouTy
 */
@Entity
public class ZT_TjtIdouNaiyouTy extends GenZT_TjtIdouNaiyouTy {

    private static final long serialVersionUID = 1L;

    public ZT_TjtIdouNaiyouTy() {
    }

    public ZT_TjtIdouNaiyouTy(String pZtyhuho2kyknokbn, String pZtyhuho2kykno) {
        super(pZtyhuho2kyknokbn, pZtyhuho2kykno);
    }

}
