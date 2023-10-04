package yuyu.batch.hozen.khansyuu.khdrtenminyuukykdtledit.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_DrtenMinyuKykTaisyo;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 契約保全 案内収納 代理店未入明細共通編集処理の機能DAOクラス
 */
public class KhDrtenMinyuuKykDtlEditDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<DrtenMinyuKykTaisyoBean> getDrtenMinyuKykTaisyos(String pKakutyouJobcd, BizDate pSyoriymd) {

        QIT_DrtenMinyuKykTaisyo qIT_DrtenMinyuKykTaisyo = new QIT_DrtenMinyuKykTaisyo("qIT_DrtenMinyuKykTaisyo");

        String sql = $SELECT + $NEW(DrtenMinyuKykTaisyoBean.class,
            qIT_DrtenMinyuKykTaisyo.kbnkey,
            qIT_DrtenMinyuKykTaisyo.syono,
            qIT_DrtenMinyuKykTaisyo.syoriYmd,
            qIT_DrtenMinyuKykTaisyo.jyuutouym,
            qIT_DrtenMinyuKykTaisyo.ryosyuymd,
            qIT_DrtenMinyuKykTaisyo.hurihunokbn,
            qIT_DrtenMinyuKykTaisyo.hrkkaisuu,
            qIT_DrtenMinyuKykTaisyo.tikiktbrisyuruikbn,
            qIT_DrtenMinyuKykTaisyo.jkipjytym,
            qIT_DrtenMinyuKykTaisyo.jkiannaikg.getTypeFieldName(),
            qIT_DrtenMinyuKykTaisyo.jkiannaikg.getValueFieldName(),
            qIT_DrtenMinyuKykTaisyo.nykkeiro,
            qIT_DrtenMinyuKykTaisyo.nyknaiyoukbn,
            qIT_DrtenMinyuKykTaisyo.rsgaku.getTypeFieldName(),
            qIT_DrtenMinyuKykTaisyo.rsgaku.getValueFieldName()) +
            $FROM(qIT_DrtenMinyuKykTaisyo) +
            $WHERE + qIT_DrtenMinyuKykTaisyo.syoriYmd.eq(pSyoriymd);

        ExDBResults<DrtenMinyuKykTaisyoBean> exDBResults = exDBEntityManager.createJPQL(sql,
            DrtenMinyuKykTaisyoBean.class).bind(qIT_DrtenMinyuKykTaisyo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobcd));

        return exDBResults;

    }
    public List<IT_AnsyuRireki> getAnsyuRirekis(
        String pSyono,
        C_NyknaiyouKbn pNyknaiyouKbn,
        C_Nykkeiro pNykkeiro,
        BizDate pHurikaeymd) {

        QIT_AnsyuRireki qIT_AnsyuRireki=  new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String sql = $SELECT + qIT_AnsyuRireki +
            $FROM(qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $AND + qIT_AnsyuRireki.nyknaiyoukbn.eq(pNyknaiyouKbn) +
            $AND + qIT_AnsyuRireki.nykkeiro.eq(pNykkeiro) +
            $AND + qIT_AnsyuRireki.hurikaeymd.eq(pHurikaeymd) +
            $AND + qIT_AnsyuRireki.annaijkkbn.eq(C_AnnaijkKbn.MINYUU);

        return exDBEntityManager.createJPQL(sql).bind(qIT_AnsyuRireki).getResultList();
    }

    public List<IT_AnsyuRireki> getAnsyuRirekis2(
        String pSyono,
        C_NyknaiyouKbn pNyknaiyouKbn,
        C_Nykkeiro pNykkeiro,
        BizDate pUriageymdkon) {

        QIT_AnsyuRireki qIT_AnsyuRireki=  new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String sql = $SELECT + qIT_AnsyuRireki +
            $FROM(qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $AND + qIT_AnsyuRireki.nyknaiyoukbn.eq(pNyknaiyouKbn) +
            $AND + qIT_AnsyuRireki.nykkeiro.eq(pNykkeiro) +
            $AND + qIT_AnsyuRireki.uriageymdkon.eq(pUriageymdkon) +
            $AND + qIT_AnsyuRireki.annaijkkbn.eq(C_AnnaijkKbn.MINYUU);

        return exDBEntityManager.createJPQL(sql).bind(qIT_AnsyuRireki).getResultList();
    }
}
