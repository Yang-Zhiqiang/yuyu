package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KbkSsuRnduHknJigyohiTy;
import yuyu.def.db.mapping.GenZT_KbkSsuRnduHknJigyohiTy;
import yuyu.def.db.meta.GenQZT_KbkSsuRnduHknJigyohiTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknJigyohiTy;

/**
 * 株価指数連動保険事業費Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KbkSsuRnduHknJigyohiTy} の JavaDoc を参照してください。
 * @see     GenZT_KbkSsuRnduHknJigyohiTy
 * @see     PKZT_KbkSsuRnduHknJigyohiTy
 * @see     QZT_KbkSsuRnduHknJigyohiTy
 * @see     GenQZT_KbkSsuRnduHknJigyohiTy
 */
@Entity
public class ZT_KbkSsuRnduHknJigyohiTy extends GenZT_KbkSsuRnduHknJigyohiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KbkSsuRnduHknJigyohiTy() {
    }

    public ZT_KbkSsuRnduHknJigyohiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
