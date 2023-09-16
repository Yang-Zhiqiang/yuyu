package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.mapping.GenZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.meta.GenQZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiRn;

/**
 * 代理店未入契約明細テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KhDrtenMinyuuKykMeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_KhDrtenMinyuuKykMeisaiRn
 * @see     PKZT_KhDrtenMinyuuKykMeisaiRn
 * @see     QZT_KhDrtenMinyuuKykMeisaiRn
 * @see     GenQZT_KhDrtenMinyuuKykMeisaiRn
 */
@Entity
public class ZT_KhDrtenMinyuuKykMeisaiRn extends GenZT_KhDrtenMinyuuKykMeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KhDrtenMinyuuKykMeisaiRn() {
    }

    public ZT_KhDrtenMinyuuKykMeisaiRn(
        String pZrnsyoriymd,
        String pZrnbsydrtencd,
        String pZrnsyono
    ) {
        super(
            pZrnsyoriymd,
            pZrnbsydrtencd,
            pZrnsyono
        );
    }

}
