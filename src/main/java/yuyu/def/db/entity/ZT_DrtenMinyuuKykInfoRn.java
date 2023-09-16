package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenMinyuuKykInfoRn;
import yuyu.def.db.mapping.GenZT_DrtenMinyuuKykInfoRn;
import yuyu.def.db.meta.GenQZT_DrtenMinyuuKykInfoRn;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoRn;

/**
 * 代理店未入契約情報Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenMinyuuKykInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_DrtenMinyuuKykInfoRn
 * @see     PKZT_DrtenMinyuuKykInfoRn
 * @see     QZT_DrtenMinyuuKykInfoRn
 * @see     GenQZT_DrtenMinyuuKykInfoRn
 */
@Entity
public class ZT_DrtenMinyuuKykInfoRn extends GenZT_DrtenMinyuuKykInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenMinyuuKykInfoRn() {
    }

    public ZT_DrtenMinyuuKykInfoRn(String pZrnsyono) {
        super(pZrnsyono);
    }

}
