package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.mapping.GenIM_KhTyouhyoumsg;


/**
 * 契約保全帳票メッセージマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_KhTyouhyoumsg} の JavaDoc を参照してください。<br />
 * @see     GenIM_KhTyouhyoumsg<br />
 * @see     PKIM_KhTyouhyoumsg<br />
 * @see     QIM_KhTyouhyoumsg<br />
 * @see     GenQIM_KhTyouhyoumsg<br />
 */
@Entity
public class IM_KhTyouhyoumsg extends GenIM_KhTyouhyoumsg {

    private static final long serialVersionUID = 1L;

    public IM_KhTyouhyoumsg() {
    }

    public IM_KhTyouhyoumsg(C_SyoruiCdKbn pSyoruiCd,C_Meigihnkjiyuu pMeigihnkjiyuu,C_KyksyaSibouUmuKbn pKyksbumu,C_UmuKbn pShrumu,C_UmuKbn pTuityouumu) {
        super(pSyoruiCd,pMeigihnkjiyuu,pKyksbumu,pShrumu,pTuityouumu);
    }



}

