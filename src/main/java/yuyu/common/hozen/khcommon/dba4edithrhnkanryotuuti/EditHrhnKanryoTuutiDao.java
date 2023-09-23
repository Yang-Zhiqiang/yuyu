package yuyu.common.hozen.khcommon.dba4edithrhnkanryotuuti;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.db.meta.QIT_AnsyuRireki;

/**
 * 契約保全 契約保全共通 払変完了通知編集DAOクラス
 */
public class EditHrhnKanryoTuutiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getAnsyuRirekiCount(String pSyono) {

        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String subQuery = $SELECT + $COUNT(qIT_AnsyuRireki.syono) +
            $FROM(qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $AND + qIT_AnsyuRireki.annaijkkbn.eq(C_AnnaijkKbn.ANNAI);

        return exDBEntityManager.createJPQL(subQuery).bind(qIT_AnsyuRireki).getSingleResult();
    }
}
