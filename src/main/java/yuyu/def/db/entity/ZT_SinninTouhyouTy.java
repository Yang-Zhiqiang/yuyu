package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinninTouhyouTy;
import yuyu.def.db.mapping.GenZT_SinninTouhyouTy;
import yuyu.def.db.meta.GenQZT_SinninTouhyouTy;
import yuyu.def.db.meta.QZT_SinninTouhyouTy;

/**
 * 信任投票データテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinninTouhyouTy} の JavaDoc を参照してください。
 * @see     GenZT_SinninTouhyouTy
 * @see     PKZT_SinninTouhyouTy
 * @see     QZT_SinninTouhyouTy
 * @see     GenQZT_SinninTouhyouTy
 */
@Entity
public class ZT_SinninTouhyouTy extends GenZT_SinninTouhyouTy {

    private static final long serialVersionUID = 1L;

    public ZT_SinninTouhyouTy() {
    }

    public ZT_SinninTouhyouTy(String pZtysyono) {
        super(pZtysyono);
    }

}
