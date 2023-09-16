package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_TRGinkouTouhaigou;

/**
 * 銀行統廃合ＴＲテーブル(IT_TRGinkouTouhaigouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TRGinkouTouhaigouDao extends AbstractDao<IT_TRGinkouTouhaigou> {

    public IT_TRGinkouTouhaigouDao() {
        super(IT_TRGinkouTouhaigou.class);
    }

    public IT_TRGinkouTouhaigou getTRGinkouTouhaigou(String pBfrikkatuseibibankcd, String pBfrikkatuseibisitencd) {
        IT_TRGinkouTouhaigou iT_TRGinkouTouhaigou =  new IT_TRGinkouTouhaigou();
        iT_TRGinkouTouhaigou.setBfrikkatuseibibankcd(pBfrikkatuseibibankcd);
        iT_TRGinkouTouhaigou.setBfrikkatuseibisitencd(pBfrikkatuseibisitencd);
        return this.selectOne(iT_TRGinkouTouhaigou);
    }

}
