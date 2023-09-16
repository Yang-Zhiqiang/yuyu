package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.mapping.GenIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.GenQIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.QIT_KhTyouhyouHonbanKakunin;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全帳票本番確認テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhTyouhyouHonbanKakunin} の JavaDoc を参照してください。
 * @see     GenIT_KhTyouhyouHonbanKakunin
 * @see     PKIT_KhTyouhyouHonbanKakunin
 * @see     QIT_KhTyouhyouHonbanKakunin
 * @see     GenQIT_KhTyouhyouHonbanKakunin
 */
@Entity
public class IT_KhTyouhyouHonbanKakunin extends GenIT_KhTyouhyouHonbanKakunin {

    private static final long serialVersionUID = 1L;

    public IT_KhTyouhyouHonbanKakunin() {
    }

    public IT_KhTyouhyouHonbanKakunin(
        C_TyouhyouBunruiKbn pTyouhyoubunrui,
        C_SyoruiCdKbn pSyoruiCd,
        String pJyoukenbunrui1,
        String pJyoukenbunrui2,
        String pJyoukenbunrui3
    ) {
        super(
            pTyouhyoubunrui,
            pSyoruiCd,
            pJyoukenbunrui1,
            pJyoukenbunrui2,
            pJyoukenbunrui3
        );
    }

}
