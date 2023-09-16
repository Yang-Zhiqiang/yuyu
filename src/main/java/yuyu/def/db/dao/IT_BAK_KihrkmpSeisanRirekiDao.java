package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KihrkmpSeisanRireki;

/**
 * 既払込Ｐ精算履歴バックアップテーブル(IT_BAK_KihrkmpSeisanRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KihrkmpSeisanRirekiDao extends AbstractDao<IT_BAK_KihrkmpSeisanRireki> {

    public IT_BAK_KihrkmpSeisanRirekiDao() {
        super(IT_BAK_KihrkmpSeisanRireki.class);
    }

    @Deprecated
    public IT_BAK_KihrkmpSeisanRireki getBAKKihrkmpSeisanRireki(String pSyono,
         String pTrkssikibetukey,
         Integer pRenno){
        IT_BAK_KihrkmpSeisanRireki iT_BAK_KihrkmpSeisanRireki =  new IT_BAK_KihrkmpSeisanRireki();
        iT_BAK_KihrkmpSeisanRireki.setSyono(pSyono);
        iT_BAK_KihrkmpSeisanRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KihrkmpSeisanRireki.setRenno(pRenno);
        return this.selectOne(iT_BAK_KihrkmpSeisanRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KihrkmpSeisanRireki> selectAll() {
        return super.selectAll();
    }
}
