package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_KhLincSousinData;

/**
 * 契約保全ＬＩＮＣ送信データバックアップテーブル(IT_BAK_KhLincSousinDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhLincSousinDataDao extends AbstractDao<IT_BAK_KhLincSousinData> {

    public IT_BAK_KhLincSousinDataDao() {
        super(IT_BAK_KhLincSousinData.class);
    }

    public IT_BAK_KhLincSousinData getBAKKhLincSousinData(String pSyono, String pTrkssikibetukey, BizDate pSyoriYmd, Integer pRenno) {
        IT_BAK_KhLincSousinData iT_BAK_KhLincSousinData =  new IT_BAK_KhLincSousinData( pSyono,  pTrkssikibetukey,  pSyoriYmd,  pRenno);
        return this.selectOne(iT_BAK_KhLincSousinData);
    }
}
