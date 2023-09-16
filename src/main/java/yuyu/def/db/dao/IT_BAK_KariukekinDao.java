package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_Kariukekin;

/**
 * 仮受金バックアップテーブル(IT_BAK_KariukekinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KariukekinDao extends AbstractDao<IT_BAK_Kariukekin> {

    public IT_BAK_KariukekinDao() {
        super(IT_BAK_Kariukekin.class);
    }

    @Deprecated
    public IT_BAK_Kariukekin getBAKKariukekin(String pSyono,
         String pTrkssikibetukey,
         Integer pKrkno){
        IT_BAK_Kariukekin iT_BAK_Kariukekin =  new IT_BAK_Kariukekin();
        iT_BAK_Kariukekin.setSyono(pSyono);
        iT_BAK_Kariukekin.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_Kariukekin.setKrkno(pKrkno);
        return this.selectOne(iT_BAK_Kariukekin);
    }

    @Override
    @Deprecated
    public List<IT_BAK_Kariukekin> selectAll() {
        return super.selectAll();
    }
}
