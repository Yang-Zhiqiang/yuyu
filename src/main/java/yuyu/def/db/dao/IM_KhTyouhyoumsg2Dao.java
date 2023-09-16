package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhTyouhyoumsg2;

/**
 * 契約保全帳票メッセージマスタ２(IM_KhTyouhyoumsg2Dao) アクセス用の DAO クラスです。<br />
 */
public class IM_KhTyouhyoumsg2Dao extends AbstractDao<IM_KhTyouhyoumsg2> {

    public IM_KhTyouhyoumsg2Dao() {
        super(IM_KhTyouhyoumsg2.class);
    }

    public IM_KhTyouhyoumsg2 getKhTyouhyoumsg2(C_SyoruiCdKbn pSyoruiCd, C_Meigihnkjiyuu pMeigihnkjiyuu, C_KyksyaSibouUmuKbn pKyksbumu, C_UmuKbn pShrumu, C_UmuKbn pTuityouumu, C_KhTyouhyoumsgbunruiKbn1 pKhtyouhyoumsgbunruikbn1, C_KhTyouhyoumsgbunruiKbn2 pKhtyouhyoumsgbunruikbn2, C_KhTyouhyoumsgbunruiKbn3 pKhtyouhyoumsgbunruikbn3) {
        IM_KhTyouhyoumsg2 iM_KhTyouhyoumsg2 =  new IM_KhTyouhyoumsg2();
        iM_KhTyouhyoumsg2.setSyoruiCd(pSyoruiCd);
        iM_KhTyouhyoumsg2.setMeigihnkjiyuu(pMeigihnkjiyuu);
        iM_KhTyouhyoumsg2.setKyksbumu(pKyksbumu);
        iM_KhTyouhyoumsg2.setShrumu(pShrumu);
        iM_KhTyouhyoumsg2.setTuityouumu(pTuityouumu);
        iM_KhTyouhyoumsg2.setKhtyouhyoumsgbunruikbn1(pKhtyouhyoumsgbunruikbn1);
        iM_KhTyouhyoumsg2.setKhtyouhyoumsgbunruikbn2(pKhtyouhyoumsgbunruikbn2);
        iM_KhTyouhyoumsg2.setKhtyouhyoumsgbunruikbn3(pKhtyouhyoumsgbunruikbn3);
        return this.selectOne(iM_KhTyouhyoumsg2);
    }

}
