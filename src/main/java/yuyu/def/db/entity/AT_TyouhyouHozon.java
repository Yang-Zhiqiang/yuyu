package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAT_TyouhyouHozon;
import yuyu.def.db.mapping.GenAT_TyouhyouHozon;
import yuyu.def.db.meta.GenQAT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouHozon;

/**
 * 帳票保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_TyouhyouHozon} の JavaDoc を参照してください。
 * @see     GenAT_TyouhyouHozon
 * @see     PKAT_TyouhyouHozon
 * @see     QAT_TyouhyouHozon
 * @see     GenQAT_TyouhyouHozon
 */
@Entity
public class AT_TyouhyouHozon extends GenAT_TyouhyouHozon {

    private static final long serialVersionUID = 1L;

    public AT_TyouhyouHozon() {
    }

    public AT_TyouhyouHozon(String pReportKey) {
        super(pReportKey);
    }

}
