package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_BikinIdouMeisaiRn;
import yuyu.def.db.mapping.GenZT_BikinIdouMeisaiRn;
import yuyu.def.db.meta.GenQZT_BikinIdouMeisaiRn;
import yuyu.def.db.meta.QZT_BikinIdouMeisaiRn;

/**
 * 備金異動明細Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_BikinIdouMeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_BikinIdouMeisaiRn
 * @see     PKZT_BikinIdouMeisaiRn
 * @see     QZT_BikinIdouMeisaiRn
 * @see     GenQZT_BikinIdouMeisaiRn
 */
@Entity
public class ZT_BikinIdouMeisaiRn extends GenZT_BikinIdouMeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_BikinIdouMeisaiRn() {
    }

    public ZT_BikinIdouMeisaiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
