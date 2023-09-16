package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;

/**
 * 数理用エラー情報テーブル(ST_SuuriyouErrJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class ST_SuuriyouErrJyouhouDao extends AbstractDao<ST_SuuriyouErrJyouhou> {

    public ST_SuuriyouErrJyouhouDao() {
        super(ST_SuuriyouErrJyouhou.class);
    }

    public ST_SuuriyouErrJyouhou getSuuriyouErrJyouhou(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pGyoumuKousinTime, String pSuuritoukeiyouerrnaiyou) {
        ST_SuuriyouErrJyouhou sT_SuuriyouErrJyouhou =  new ST_SuuriyouErrJyouhou();
        sT_SuuriyouErrJyouhou.setSyoriYmd(pSyoriYmd);
        sT_SuuriyouErrJyouhou.setKakutyoujobcd(pKakutyoujobcd);
        sT_SuuriyouErrJyouhou.setSyono(pSyono);
        sT_SuuriyouErrJyouhou.setGyoumuKousinTime(pGyoumuKousinTime);
        sT_SuuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(pSuuritoukeiyouerrnaiyou);
        return this.selectOne(sT_SuuriyouErrJyouhou);
    }
}
