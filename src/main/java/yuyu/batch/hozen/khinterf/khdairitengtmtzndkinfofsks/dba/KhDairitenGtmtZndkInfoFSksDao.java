package yuyu.batch.hozen.khinterf.khdairitengtmtzndkinfofsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 インターフェイス 普保Ⅱ代理店月末残高情報Ｆ作成DAOクラス
 */
public class KhDairitenGtmtZndkInfoFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<DairitenGtmtZndkInfosBean> getDairitenGtmtZndkInfos(String pKakutyouJobCd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        String subQuery = $SELECT + $NEW(DairitenGtmtZndkInfosBean.class,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qIT_KykSonotaTkyk,
            qIT_KykSya,
            qIT_HhknSya,
            qIT_AnsyuKihon) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_AnsyuKihon) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSonotaTkyk.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykSya.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_HhknSya.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono);

        ExDBResults<DairitenGtmtZndkInfosBean> exDBResults = exDBEntityManager.createJPQL(subQuery,
            DairitenGtmtZndkInfosBean.class).bind(qIT_KykKihon, qIT_KykSyouhn,
                qIT_KykSonotaTkyk, qIT_HhknSya, qIT_KykSya, qIT_AnsyuKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public List<KhHenkouUktkBean> getKhHenkouUktkBySyono(String pSyono){

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + $NEW(KhHenkouUktkBean.class,
            qIT_KhHenkouUktk.uktksyorikbn,
            qIT_KhHenkouUktk.uktkjyoutaikbn) +
            $FROM (qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + $(qIT_KhHenkouUktk.uktkjyoutaikbn.ne(C_UktkJyoutaiKbn.SYORIZUMI) +
                $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.ne(C_UktkJyoutaiKbn.TORIKESI));

        return exDBEntityManager.createJPQL(strSql, KhHenkouUktkBean.class).bind(qIT_KhHenkouUktk).getResultList();
    }


    public List<IT_KhHenkouRireki> getKhHenkouRirekisBySyonoGyoumuKousinKinouTableidHenkoukoumokuid(String pSyono,
        String pGyoumuKousinKinou, String pTableid, String pHenkoukoumokuid) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");
        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        String strSql = $SELECT + qIT_KhHenkouRireki +
            $FROM(qIT_KhHenkouRireki,qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_KhHenkouRireki.syono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhHenkouRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableid) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pHenkoukoumokuid);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki,qIT_KhHenkouRireki).getResultList();

    }

}
