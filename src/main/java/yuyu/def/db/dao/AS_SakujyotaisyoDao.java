package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.meta.QAS_Sakujyotaisyo;

/**
 * 削除対象基幹テーブル( AS_Sakujyotaisyo ) に対するDB操作を提供する。
 */
public class AS_SakujyotaisyoDao extends AbstractDao<AS_Sakujyotaisyo> {

    public AS_SakujyotaisyoDao() {
        super(AS_Sakujyotaisyo.class);
    }

    public AS_Sakujyotaisyo getAS_Sakujyotaisyo(String pSakujyotaisyoTableId) {
        AS_Sakujyotaisyo condEntity = new AS_Sakujyotaisyo();
        condEntity.setSakujyoTableId(pSakujyotaisyoTableId);
        return selectOne(condEntity);
    }

    public List<AS_Sakujyotaisyo> getSakujyotaisyoByHozonKikan(Integer pHozonKikan) {

        QAS_Sakujyotaisyo qSakujyotaisyo = new QAS_Sakujyotaisyo();


        StringBuilder sb = new StringBuilder();
        sb.append($SELECT);
        sb.append(qSakujyotaisyo);
        sb.append($FROM);
        sb.append(qSakujyotaisyo.AS_Sakujyotaisyo());
        sb.append($WHERE);
        sb.append(qSakujyotaisyo.hozonKikan.ne(pHozonKikan));
        sb.append($ORDER_BY(qSakujyotaisyo.sakujyoTableId));

        return em.createJPQL(sb.toString()).bind(qSakujyotaisyo).getResultList();

    }
}