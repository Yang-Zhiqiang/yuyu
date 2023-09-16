package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SbRituRendouTy;
import yuyu.def.db.mapping.GenZT_SbRituRendouTy;
import yuyu.def.db.meta.GenQZT_SbRituRendouTy;
import yuyu.def.db.meta.QZT_SbRituRendouTy;

/**
 * 死亡率用連動Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SbRituRendouTy} の JavaDoc を参照してください。
 * @see     GenZT_SbRituRendouTy
 * @see     PKZT_SbRituRendouTy
 * @see     QZT_SbRituRendouTy
 * @see     GenQZT_SbRituRendouTy
 */
@Entity
public class ZT_SbRituRendouTy extends GenZT_SbRituRendouTy {

    private static final long serialVersionUID = 1L;

    public ZT_SbRituRendouTy() {
    }

    public ZT_SbRituRendouTy(String pZtydatakanrino) {
        super(pZtydatakanrino);
    }

}
