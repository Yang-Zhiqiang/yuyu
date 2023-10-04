package yuyu.batch.hozen.khansyuu.khikkatuannaisaikai.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;

/**
 * 契約保全 案内収納 一括案内再開機能DAO
 */
public class KhIkkatuAnnaiSaikaiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhIkkatuAnnaiSaikaiDataBean> getKhIkkatuAnnaiSaikaiDataBean(BizDateYM pSyoriYm,
        String pKakutyoujobcd) {

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(KhIkkatuAnnaiSaikaiDataBean.class,
            qIT_AnsyuKihon.syono,
            qIT_AnsyuKihon.kbnkey,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.hrkp.getTypeFieldName(),
            qIT_KykKihon.hrkp.getValueFieldName(),
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno) +
            $FROM(qIT_AnsyuKihon,
                qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qIT_AnsyuKihon.jkipjytym.le(pSyoriYm.addMonths(1)) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.TUKI) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.IKKATUNK);

        ExDBResults<KhIkkatuAnnaiSaikaiDataBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            KhIkkatuAnnaiSaikaiDataBean.class).bind(qIT_AnsyuKihon, qIT_KykKihon, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public List<Integer> getNyknJissekiRirekis(String pSyono) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + qIT_NyknJissekiRireki.jyutoukaisuum +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $ORDER_BY(qIT_NyknJissekiRireki.jyutoustartym.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getResultList();

    }
}
