package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIM_KhTyouhyoumsg2;
import yuyu.def.db.mapping.GenIM_KhTyouhyoumsg2;
import yuyu.def.db.meta.GenQIM_KhTyouhyoumsg2;
import yuyu.def.db.meta.QIM_KhTyouhyoumsg2;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;

/**
 * 契約保全帳票メッセージマスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_KhTyouhyoumsg2} の JavaDoc を参照してください。
 * @see     GenIM_KhTyouhyoumsg2
 * @see     PKIM_KhTyouhyoumsg2
 * @see     QIM_KhTyouhyoumsg2
 * @see     GenQIM_KhTyouhyoumsg2
 */
@Entity
public class IM_KhTyouhyoumsg2 extends GenIM_KhTyouhyoumsg2 {

    private static final long serialVersionUID = 1L;

    public IM_KhTyouhyoumsg2() {
    }

    public IM_KhTyouhyoumsg2(
        C_SyoruiCdKbn pSyoruiCd,
        C_Meigihnkjiyuu pMeigihnkjiyuu,
        C_KyksyaSibouUmuKbn pKyksbumu,
        C_UmuKbn pShrumu,
        C_UmuKbn pTuityouumu,
        C_KhTyouhyoumsgbunruiKbn1 pKhtyouhyoumsgbunruikbn1,
        C_KhTyouhyoumsgbunruiKbn2 pKhtyouhyoumsgbunruikbn2,
        C_KhTyouhyoumsgbunruiKbn3 pKhtyouhyoumsgbunruikbn3
    ) {
        super(
            pSyoruiCd,
            pMeigihnkjiyuu,
            pKyksbumu,
            pShrumu,
            pTuityouumu,
            pKhtyouhyoumsgbunruikbn1,
            pKhtyouhyoumsgbunruikbn2,
            pKhtyouhyoumsgbunruikbn3
        );
    }

}
