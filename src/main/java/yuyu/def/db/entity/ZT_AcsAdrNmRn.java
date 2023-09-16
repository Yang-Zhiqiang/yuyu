package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_AcsAdrNmRn;
import yuyu.def.db.mapping.GenZT_AcsAdrNmRn;
import yuyu.def.db.meta.GenQZT_AcsAdrNmRn;
import yuyu.def.db.meta.QZT_AcsAdrNmRn;

/**
 * ＡＣＳ住所名ＤＢ用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_AcsAdrNmRn} の JavaDoc を参照してください。
 * @see     GenZT_AcsAdrNmRn
 * @see     PKZT_AcsAdrNmRn
 * @see     QZT_AcsAdrNmRn
 * @see     GenQZT_AcsAdrNmRn
 */
@Entity
public class ZT_AcsAdrNmRn extends GenZT_AcsAdrNmRn {

    private static final long serialVersionUID = 1L;

    public ZT_AcsAdrNmRn() {
    }

    public ZT_AcsAdrNmRn(String pZrnkihontikucd) {
        super(pZrnkihontikucd);
    }

}
