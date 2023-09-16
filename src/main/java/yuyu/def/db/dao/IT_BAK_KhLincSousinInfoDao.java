package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.IT_BAK_KhLincSousinInfo;

/**
 * 契約保全ＬＩＮＣ送信情報バックアップテーブル(IT_BAK_KhLincSousinInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhLincSousinInfoDao extends AbstractDao<IT_BAK_KhLincSousinInfo> {

    public IT_BAK_KhLincSousinInfoDao() {
        super(IT_BAK_KhLincSousinInfo.class);
    }

    @Deprecated
    public IT_BAK_KhLincSousinInfo getBAKKhLincSousinInfo(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,
         String pTrkssikibetukey,
         String pSyono,
         Integer pRenno){
        IT_BAK_KhLincSousinInfo iT_BAK_KhLincSousinInfo =  new IT_BAK_KhLincSousinInfo();
        iT_BAK_KhLincSousinInfo.setLincsoujyusinsyskbn(pLincsoujyusinsyskbn);
        iT_BAK_KhLincSousinInfo.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KhLincSousinInfo.setSyono(pSyono);
        iT_BAK_KhLincSousinInfo.setRenno(pRenno);
        return this.selectOne(iT_BAK_KhLincSousinInfo);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhLincSousinInfo> selectAll() {
        return super.selectAll();
    }
}
