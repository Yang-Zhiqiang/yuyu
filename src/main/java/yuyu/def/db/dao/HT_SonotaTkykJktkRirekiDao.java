package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.HT_SonotaTkykJktkRireki;

/**
 * その他特約条件付履歴テーブル(HT_SonotaTkykJktkRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SonotaTkykJktkRirekiDao extends AbstractDao<HT_SonotaTkykJktkRireki> {

    public HT_SonotaTkykJktkRirekiDao() {
        super(HT_SonotaTkykJktkRireki.class);
    }

    @Deprecated
    public HT_SonotaTkykJktkRireki getSonotaTkykJktkRireki(String pMosno,
         Integer pDakuhiktrenno,
         C_PmnjtkKbn pPmnjtkkbn){
        HT_SonotaTkykJktkRireki hT_SonotaTkykJktkRireki =  new HT_SonotaTkykJktkRireki();
        hT_SonotaTkykJktkRireki.setMosno(pMosno);
        hT_SonotaTkykJktkRireki.setDakuhiktrenno(pDakuhiktrenno);
        hT_SonotaTkykJktkRireki.setPmnjtkkbn(pPmnjtkkbn);
        return this.selectOne(hT_SonotaTkykJktkRireki);
    }

    @Override
    @Deprecated
    public List<HT_SonotaTkykJktkRireki> selectAll() {
        return super.selectAll();
    }
}
