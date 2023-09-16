package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhTyouhyoumsg;

/**
 * 契約保全帳票メッセージマスタ(IM_KhTyouhyoumsgDao) アクセス用の DAO クラスです。<br />
 */
public class IM_KhTyouhyoumsgDao extends AbstractDao<IM_KhTyouhyoumsg> {

    public IM_KhTyouhyoumsgDao() {
        super(IM_KhTyouhyoumsg.class);
    }

    public IM_KhTyouhyoumsg getKhTyouhyoumsg(C_SyoruiCdKbn pSyoruiCd,
         C_Meigihnkjiyuu pMeigihnkjiyuu,
         C_KyksyaSibouUmuKbn pKyksbumu,
         C_UmuKbn pShrumu,
         C_UmuKbn pTuityouumu){
        IM_KhTyouhyoumsg iM_KhTyouhyoumsg =  new IM_KhTyouhyoumsg();
        iM_KhTyouhyoumsg.setSyoruiCd(pSyoruiCd);
        iM_KhTyouhyoumsg.setMeigihnkjiyuu(pMeigihnkjiyuu);
        iM_KhTyouhyoumsg.setKyksbumu(pKyksbumu);
        iM_KhTyouhyoumsg.setShrumu(pShrumu);
        iM_KhTyouhyoumsg.setTuityouumu(pTuityouumu);
        return this.selectOne(iM_KhTyouhyoumsg);
    }
}
