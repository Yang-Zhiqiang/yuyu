package yuyu.common.hozen.khcommon.dba4edithokenkykidourirekitbl;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZfiIdoujiyuuKbn;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.meta.QIT_HokenKykIdouRireki;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 契約保全 契約保全共通 保険契約異動情報履歴TBL編集Daoクラス
 */
public class EditHokenKykIdouRirekiTblDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_HokenKykIdouRireki> getHokenKykIdouRirekiBySyoNoKykTuukasyuIdouymdIdoujiyuuKbn (String pSyoNo, C_Tuukasyu pKykTuukasyu,
        BizDate pIdouymd, C_ZfiIdoujiyuuKbn pIdoujiyuuKbn) {

        QIT_HokenKykIdouRireki qIT_HokenKykIdouRireki = new QIT_HokenKykIdouRireki("qIT_HokenKykIdouRireki");

        String sql = $SELECT + qIT_HokenKykIdouRireki +
            $FROM(qIT_HokenKykIdouRireki) +
            $WHERE + qIT_HokenKykIdouRireki.syono.eq(pSyoNo) +
            $AND + qIT_HokenKykIdouRireki.kyktuukasyu.eq(pKykTuukasyu) +
            $AND + qIT_HokenKykIdouRireki.idouymd.eq(pIdouymd) +
            $AND + qIT_HokenKykIdouRireki.idoujiyuukbn.eq(pIdoujiyuuKbn) +
            $ORDER_BY(qIT_HokenKykIdouRireki.ttdkrenno.desc());

        return exDBEntityManager.createJPQL(sql).bind(qIT_HokenKykIdouRireki).getResultList();

    }

}
