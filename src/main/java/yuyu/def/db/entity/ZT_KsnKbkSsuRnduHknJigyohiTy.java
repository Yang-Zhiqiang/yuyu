package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KsnKbkSsuRnduHknJigyohiTy;
import yuyu.def.db.mapping.GenZT_KsnKbkSsuRnduHknJigyohiTy;
import yuyu.def.db.meta.GenQZT_KsnKbkSsuRnduHknJigyohiTy;
import yuyu.def.db.meta.QZT_KsnKbkSsuRnduHknJigyohiTy;

/**
 * 決算計上用株価指数連動保険事業費Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KsnKbkSsuRnduHknJigyohiTy} の JavaDoc を参照してください。
 * @see     GenZT_KsnKbkSsuRnduHknJigyohiTy
 * @see     PKZT_KsnKbkSsuRnduHknJigyohiTy
 * @see     QZT_KsnKbkSsuRnduHknJigyohiTy
 * @see     GenQZT_KsnKbkSsuRnduHknJigyohiTy
 */
@Entity
public class ZT_KsnKbkSsuRnduHknJigyohiTy extends GenZT_KsnKbkSsuRnduHknJigyohiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KsnKbkSsuRnduHknJigyohiTy() {
    }

    public ZT_KsnKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
