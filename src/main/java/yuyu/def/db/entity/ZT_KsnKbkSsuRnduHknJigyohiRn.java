package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KsnKbkSsuRnduHknJigyohiRn;
import yuyu.def.db.mapping.GenZT_KsnKbkSsuRnduHknJigyohiRn;
import yuyu.def.db.meta.GenQZT_KsnKbkSsuRnduHknJigyohiRn;
import yuyu.def.db.meta.QZT_KsnKbkSsuRnduHknJigyohiRn;

/**
 * 決算計上用株価指数連動保険事業費Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KsnKbkSsuRnduHknJigyohiRn} の JavaDoc を参照してください。
 * @see     GenZT_KsnKbkSsuRnduHknJigyohiRn
 * @see     PKZT_KsnKbkSsuRnduHknJigyohiRn
 * @see     QZT_KsnKbkSsuRnduHknJigyohiRn
 * @see     GenQZT_KsnKbkSsuRnduHknJigyohiRn
 */
@Entity
public class ZT_KsnKbkSsuRnduHknJigyohiRn extends GenZT_KsnKbkSsuRnduHknJigyohiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KsnKbkSsuRnduHknJigyohiRn() {
    }

    public ZT_KsnKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
