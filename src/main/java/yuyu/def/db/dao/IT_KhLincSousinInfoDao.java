package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.IT_KhLincSousinInfo;

/**
 * 契約保全ＬＩＮＣ送信情報テーブル(IT_KhLincSousinInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhLincSousinInfoDao extends AbstractDao<IT_KhLincSousinInfo> {

    public IT_KhLincSousinInfoDao() {
        super(IT_KhLincSousinInfo.class);
    }

    @Deprecated
    public IT_KhLincSousinInfo getKhLincSousinInfo(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,
         String pSyono,
         Integer pRenno){
        IT_KhLincSousinInfo iT_KhLincSousinInfo =  new IT_KhLincSousinInfo();
        iT_KhLincSousinInfo.setLincsoujyusinsyskbn(pLincsoujyusinsyskbn);
        iT_KhLincSousinInfo.setSyono(pSyono);
        iT_KhLincSousinInfo.setRenno(pRenno);
        return this.selectOne(iT_KhLincSousinInfo);
    }

    @Override
    @Deprecated
    public List<IT_KhLincSousinInfo> selectAll() {
        return super.selectAll();
    }
}
