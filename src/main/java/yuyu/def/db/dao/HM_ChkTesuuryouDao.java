package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HM_ChkTesuuryou;

/**
 * 手数料チェックマスタ(HM_ChkTesuuryouDao) アクセス用の DAO クラスです。<br />
 */
public class HM_ChkTesuuryouDao extends AbstractDao<HM_ChkTesuuryou> {

    public HM_ChkTesuuryouDao() {
        super(HM_ChkTesuuryou.class);
    }

    public HM_ChkTesuuryou getChkTesuuryou(Integer pRenno3keta){
        HM_ChkTesuuryou hM_ChkTesuuryou =  new HM_ChkTesuuryou();
        hM_ChkTesuuryou.setRenno3keta(pRenno3keta);
        return this.selectOne(hM_ChkTesuuryou);
    }

}
