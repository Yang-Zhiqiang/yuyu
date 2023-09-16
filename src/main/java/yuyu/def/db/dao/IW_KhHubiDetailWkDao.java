package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhHubiDetailWk;

/**
 * 契約保全不備詳細ワークテーブル(IW_KhHubiDetailWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhHubiDetailWkDao extends AbstractDao<IW_KhHubiDetailWk> {

    public IW_KhHubiDetailWkDao() {
        super(IW_KhHubiDetailWk.class);
    }

    @Deprecated
    public IW_KhHubiDetailWk getKhHubiDetailWk(String pKouteikanriid,
         Integer pRenno3keta){
        IW_KhHubiDetailWk iW_KhHubiDetailWk =  new IW_KhHubiDetailWk();
        iW_KhHubiDetailWk.setKouteikanriid(pKouteikanriid);
        iW_KhHubiDetailWk.setRenno3keta(pRenno3keta);
        return this.selectOne(iW_KhHubiDetailWk);
    }

    @Override
    @Deprecated
    public List<IW_KhHubiDetailWk> selectAll() {
        return super.selectAll();
    }
}
