package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AM_HaitaSyurui;

/**
 * 排他種類マスタ( AM_HaitaSyurui ) に対するDB操作を提供する。
 */
public class AM_HaitaSyuruiDao extends AbstractDao<AM_HaitaSyurui> {

    protected AM_HaitaSyuruiDao() {
        super(AM_HaitaSyurui.class);
    }

    public AM_HaitaSyurui getHaitaSyuruiByHaitaSyuruiCd(String pHaitaSyuruiCd){
        AM_HaitaSyurui haitaSyurui = new AM_HaitaSyurui();
        haitaSyurui.setHaitaSyuruiCd(pHaitaSyuruiCd);

        return selectOne(haitaSyurui);
    }

}
