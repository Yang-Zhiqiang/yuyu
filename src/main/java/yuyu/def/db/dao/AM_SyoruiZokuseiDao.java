package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.meta.QAM_SyoruiZokusei;

/**
 * 書類属性マスタ(AM_SyoruiZokusei) テーブルアクセス用の DAO クラスです。
 */
public class AM_SyoruiZokuseiDao extends AbstractDao<AM_SyoruiZokusei> {

    protected AM_SyoruiZokuseiDao() {
        super(AM_SyoruiZokusei.class);
    }

    public AM_SyoruiZokusei getAM_SyoruiZokusei(C_SyoruiCdKbn pSyoruiCd){

        AM_SyoruiZokusei syoruiZokusei = new AM_SyoruiZokusei();
        syoruiZokusei.setSyoruiCd(pSyoruiCd);

        return selectOne(syoruiZokusei);
    }

    public List<AM_SyoruiZokusei> getSyoruiZokuseiByHozonKikan(Integer pHozonKikan){

        QAM_SyoruiZokusei qSyoruiZokusei = new QAM_SyoruiZokusei();


        StringBuilder sb = new StringBuilder();
        sb.append($SELECT);
        sb.append(qSyoruiZokusei);
        sb.append($FROM);
        sb.append(qSyoruiZokusei.AM_SyoruiZokusei());
        sb.append($WHERE);
        sb.append(qSyoruiZokusei.hozonKikan.ne(pHozonKikan));
        sb.append($ORDER_BY(qSyoruiZokusei.syoruiCd));

        return em.createJPQL(sb.toString()).bind(qSyoruiZokusei).getResultList();

    }

}
