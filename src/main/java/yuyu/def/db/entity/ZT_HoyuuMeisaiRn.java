package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HoyuuMeisaiRn;
import yuyu.def.db.mapping.GenZT_HoyuuMeisaiRn;
import yuyu.def.db.meta.GenQZT_HoyuuMeisaiRn;
import yuyu.def.db.meta.QZT_HoyuuMeisaiRn;

/**
 * 保有明細Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HoyuuMeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_HoyuuMeisaiRn
 * @see     PKZT_HoyuuMeisaiRn
 * @see     QZT_HoyuuMeisaiRn
 * @see     GenQZT_HoyuuMeisaiRn
 */
@Entity
public class ZT_HoyuuMeisaiRn extends GenZT_HoyuuMeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_HoyuuMeisaiRn() {
    }

    public ZT_HoyuuMeisaiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
