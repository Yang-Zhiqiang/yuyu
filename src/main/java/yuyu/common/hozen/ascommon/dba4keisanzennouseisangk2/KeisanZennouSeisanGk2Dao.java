package yuyu.common.hozen.ascommon.dba4keisanzennouseisangk2;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QBM_ZennouRiritu2;

import com.google.common.collect.Collections2;

/**
 * 契約保全 案内収納共通 前納精算額計算２Daoクラス
 */
public class KeisanZennouSeisanGk2Dao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BM_ZennouRiritu2 getZennouRiritu2(C_Tuukasyu pTuukasyu, BizDate pKijyunymd) {

        QBM_ZennouRiritu2 qBM_ZennouRiritu2 = new QBM_ZennouRiritu2("qBM_ZennouRiritu2");

        String strSpl = $SELECT + qBM_ZennouRiritu2 +
            $FROM(qBM_ZennouRiritu2) +
            $WHERE + qBM_ZennouRiritu2.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ZennouRiritu2.zennoutkybr1.eq("") +
            $AND + qBM_ZennouRiritu2.zennoutkybr2.eq("") +
            $AND + qBM_ZennouRiritu2.zennoutkybr3.eq("") +
            $AND + qBM_ZennouRiritu2.tekiyoukknfrom.le(pKijyunymd.toString()) +
            $AND + qBM_ZennouRiritu2.tekiyoukknkto.ge(pKijyunymd.toString());

        return exDBEntityManager.createJPQL(strSpl).bind(qBM_ZennouRiritu2).getSingleResult();
    }

    public List<IT_Zennou> getZennous(IT_AnsyuKihon pAnsyuKihon) {

        List<IT_Zennou> zennouList = pAnsyuKihon.getZennous();

        SortZennou sortZennou = new SortZennou();

        zennouList = sortZennou.OrderIT_ZennouByZennoukaisiymdRennoDesc(zennouList);

        return zennouList;
    }

    public List<IT_KykSyouhn> getKykSyouhns(IT_KykKihon pKykKihon) {

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhns();

        return new ArrayList<IT_KykSyouhn>(Collections2.filter(kykSyouhnList,
            new FilterKykSyouhn(C_SyutkKbn.SYU)));
    }
}
