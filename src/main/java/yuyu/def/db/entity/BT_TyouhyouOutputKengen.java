package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.mapping.GenBT_TyouhyouOutputKengen;


/**
 * 帳票出力権限テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TyouhyouOutputKengen} の JavaDoc を参照してください。<br />
 * @see     GenBT_TyouhyouOutputKengen<br />
 * @see     PKBT_TyouhyouOutputKengen<br />
 * @see     QBT_TyouhyouOutputKengen<br />
 * @see     GenQBT_TyouhyouOutputKengen<br />
 */
@Entity
public class BT_TyouhyouOutputKengen extends GenBT_TyouhyouOutputKengen {

    private static final long serialVersionUID = 1L;

    public BT_TyouhyouOutputKengen() {
    }

    public BT_TyouhyouOutputKengen(String pRoleCd,C_SyoruiCdKbn pSyoruiCd) {
        super(pRoleCd,pSyoruiCd);
    }



}

