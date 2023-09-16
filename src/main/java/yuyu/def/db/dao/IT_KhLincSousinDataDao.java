package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhLincSousinData;

/**
 * 契約保全ＬＩＮＣ送信データテーブル(IT_KhLincSousinDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhLincSousinDataDao extends AbstractDao<IT_KhLincSousinData> {

    public IT_KhLincSousinDataDao() {
        super(IT_KhLincSousinData.class);
    }

    public IT_KhLincSousinData getKhLincSousinData(String pSyono, BizDate pSyoriYmd, Integer pRenno) {
        IT_KhLincSousinData iT_KhLincSousinData =  new IT_KhLincSousinData( pSyono,  pSyoriYmd,  pRenno);
        return this.selectOne(iT_KhLincSousinData);
    }
}
