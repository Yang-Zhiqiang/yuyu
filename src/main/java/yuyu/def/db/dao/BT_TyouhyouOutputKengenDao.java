package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.def.db.meta.QBT_TyouhyouOutputKengen;

/**
 * 帳票出力権限テーブル(BT_TyouhyouOutputKengenDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TyouhyouOutputKengenDao extends AbstractDao<BT_TyouhyouOutputKengen> {

    public BT_TyouhyouOutputKengenDao() {
        super(BT_TyouhyouOutputKengen.class);
    }

    public BT_TyouhyouOutputKengen getTyouhyouOutputKengen(String pRoleCd,
        C_SyoruiCdKbn pSyoruiCd){
        BT_TyouhyouOutputKengen bT_TyouhyouOutputKengen =  new BT_TyouhyouOutputKengen();
        bT_TyouhyouOutputKengen.setRoleCd(pRoleCd);
        bT_TyouhyouOutputKengen.setSyoruiCd(pSyoruiCd);
        return this.selectOne(bT_TyouhyouOutputKengen);
    }

    public List<BT_TyouhyouOutputKengen> getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(String[] pRoleCd,
        C_KahiKbn pIkkatuoutputkahikbn) {


        QBT_TyouhyouOutputKengen qBT_TyouhyouOutputKengen = new QBT_TyouhyouOutputKengen();


        String queryStr = $SELECT + qBT_TyouhyouOutputKengen +
            $FROM + qBT_TyouhyouOutputKengen.BT_TyouhyouOutputKengen() +
            $WHERE + qBT_TyouhyouOutputKengen.roleCd.in(pRoleCd) +
            $AND + qBT_TyouhyouOutputKengen.ikkatuoutputkahikbn.eq(pIkkatuoutputkahikbn);
        return em.createJPQL(queryStr).bind(qBT_TyouhyouOutputKengen).getResultList();
    }
}
