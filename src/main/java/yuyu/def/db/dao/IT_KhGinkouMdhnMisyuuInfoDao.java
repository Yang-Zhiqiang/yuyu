package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhGinkouMdhnMisyuuInfo;

/**
 * 銀行窓販未収情報テーブル(IT_KhGinkouMdhnMisyuuInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhGinkouMdhnMisyuuInfoDao extends AbstractDao<IT_KhGinkouMdhnMisyuuInfo> {

    public IT_KhGinkouMdhnMisyuuInfoDao() {
        super(IT_KhGinkouMdhnMisyuuInfo.class);
    }

    public IT_KhGinkouMdhnMisyuuInfo getKhGinkouMdhnMisyuuInfo(BizDate pDatarenymd, String pSyono, String pHenkousikibetukey) {
        IT_KhGinkouMdhnMisyuuInfo iT_KhGinkouMdhnMisyuuInfo =  new IT_KhGinkouMdhnMisyuuInfo( pDatarenymd,  pSyono,  pHenkousikibetukey);
        return this.selectOne(iT_KhGinkouMdhnMisyuuInfo);
    }

}
