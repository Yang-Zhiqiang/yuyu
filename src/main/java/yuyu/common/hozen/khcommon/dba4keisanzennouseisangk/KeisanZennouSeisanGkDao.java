package yuyu.common.hozen.khcommon.dba4keisanzennouseisangk;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_ZennouRiritu;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QBM_ZennouRiritu;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全共通 前納精算額計算Daoクラス
 */
public class KeisanZennouSeisanGkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BM_ZennouRiritu getZennouRiritu(BizDate pKijyunymd){

        QBM_ZennouRiritu qBM_ZennouRiritu = new QBM_ZennouRiritu("qBM_ZennouRiritu");

        String strSpl = $SELECT + qBM_ZennouRiritu +
            $FROM(qBM_ZennouRiritu) +
            $WHERE + qBM_ZennouRiritu.tekiyoukknfrom.le(pKijyunymd.toString()) +
            $AND + qBM_ZennouRiritu.tekiyoukknkto.ge(pKijyunymd.toString());

        return exDBEntityManager.createJPQL(strSpl).bind(qBM_ZennouRiritu).getSingleResult();
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
            new FilterKykSyouhn1(C_SyutkKbn.SYU)));
    }
}
