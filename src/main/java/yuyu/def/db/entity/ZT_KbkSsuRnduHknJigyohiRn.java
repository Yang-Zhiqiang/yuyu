package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KbkSsuRnduHknJigyohiRn;
import yuyu.def.db.mapping.GenZT_KbkSsuRnduHknJigyohiRn;
import yuyu.def.db.meta.GenQZT_KbkSsuRnduHknJigyohiRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknJigyohiRn;

/**
 * 株価指数連動保険事業費Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KbkSsuRnduHknJigyohiRn} の JavaDoc を参照してください。
 * @see     GenZT_KbkSsuRnduHknJigyohiRn
 * @see     PKZT_KbkSsuRnduHknJigyohiRn
 * @see     QZT_KbkSsuRnduHknJigyohiRn
 * @see     GenQZT_KbkSsuRnduHknJigyohiRn
 */
@Entity
public class ZT_KbkSsuRnduHknJigyohiRn extends GenZT_KbkSsuRnduHknJigyohiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KbkSsuRnduHknJigyohiRn() {
    }

    public ZT_KbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
