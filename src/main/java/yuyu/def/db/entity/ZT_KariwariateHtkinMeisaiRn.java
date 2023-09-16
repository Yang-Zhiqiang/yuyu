package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KariwariateHtkinMeisaiRn;
import yuyu.def.db.mapping.GenZT_KariwariateHtkinMeisaiRn;
import yuyu.def.db.meta.GenQZT_KariwariateHtkinMeisaiRn;
import yuyu.def.db.meta.QZT_KariwariateHtkinMeisaiRn;

/**
 * 仮割当配当金明細Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KariwariateHtkinMeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_KariwariateHtkinMeisaiRn
 * @see     PKZT_KariwariateHtkinMeisaiRn
 * @see     QZT_KariwariateHtkinMeisaiRn
 * @see     GenQZT_KariwariateHtkinMeisaiRn
 */
@Entity
public class ZT_KariwariateHtkinMeisaiRn extends GenZT_KariwariateHtkinMeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KariwariateHtkinMeisaiRn() {
    }

    public ZT_KariwariateHtkinMeisaiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
