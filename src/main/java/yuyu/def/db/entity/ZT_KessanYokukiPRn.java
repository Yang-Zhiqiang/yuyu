package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KessanYokukiPRn;
import yuyu.def.db.mapping.GenZT_KessanYokukiPRn;
import yuyu.def.db.meta.GenQZT_KessanYokukiPRn;
import yuyu.def.db.meta.QZT_KessanYokukiPRn;

/**
 * 決算用翌期Ｐテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KessanYokukiPRn} の JavaDoc を参照してください。
 * @see     GenZT_KessanYokukiPRn
 * @see     PKZT_KessanYokukiPRn
 * @see     QZT_KessanYokukiPRn
 * @see     GenQZT_KessanYokukiPRn
 */
@Entity
public class ZT_KessanYokukiPRn extends GenZT_KessanYokukiPRn {

    private static final long serialVersionUID = 1L;

    public ZT_KessanYokukiPRn() {
    }

    public ZT_KessanYokukiPRn(String pZrnkeijyouym, String pZrnsyono) {
        super(pZrnkeijyouym, pZrnsyono);
    }

}
