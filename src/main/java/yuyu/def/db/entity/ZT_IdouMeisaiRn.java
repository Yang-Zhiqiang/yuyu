package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_IdouMeisaiRn;
import yuyu.def.db.mapping.GenZT_IdouMeisaiRn;
import yuyu.def.db.meta.GenQZT_IdouMeisaiRn;
import yuyu.def.db.meta.QZT_IdouMeisaiRn;

/**
 * 異動明細Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IdouMeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_IdouMeisaiRn
 * @see     PKZT_IdouMeisaiRn
 * @see     QZT_IdouMeisaiRn
 * @see     GenQZT_IdouMeisaiRn
 */
@Entity
public class ZT_IdouMeisaiRn extends GenZT_IdouMeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_IdouMeisaiRn() {
    }

    public ZT_IdouMeisaiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
