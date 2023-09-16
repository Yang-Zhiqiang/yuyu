package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhKeiyakuTorikesiWk;

/**
 * 契約取消ワークテーブル(IW_KhKeiyakuTorikesiWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhKeiyakuTorikesiWkDao extends AbstractDao<IW_KhKeiyakuTorikesiWk> {

    public IW_KhKeiyakuTorikesiWkDao() {
        super(IW_KhKeiyakuTorikesiWk.class);
    }

    public IW_KhKeiyakuTorikesiWk getKhKeiyakuTorikesiWk(String pKouteikanriid){
        IW_KhKeiyakuTorikesiWk iW_KhKeiyakuTorikesiWk =  new IW_KhKeiyakuTorikesiWk();
        iW_KhKeiyakuTorikesiWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhKeiyakuTorikesiWk);
    }
}
