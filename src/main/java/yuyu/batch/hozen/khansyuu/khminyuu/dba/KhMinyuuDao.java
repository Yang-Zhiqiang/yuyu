package yuyu.batch.hozen.khansyuu.khminyuu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.meta.QIT_TRMinyuu;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Collections2;

/**
 * 未入処理の機能DAOクラスです。<br />
 */
public class KhMinyuuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<MinyuuTRBean> getTRMinyuus(String pKakutyoujobcd) {

        QIT_TRMinyuu qIT_TRMinyuu = new QIT_TRMinyuu("q");
        String sql = $SELECT + $NEW(MinyuuTRBean.class,
            qIT_TRMinyuu.syono,
            qIT_TRMinyuu.syoriYmd,
            qIT_TRMinyuu.minyuutrrenno,
            qIT_TRMinyuu.nykkeiro,
            qIT_TRMinyuu.nyknaiyoukbn,
            qIT_TRMinyuu.jyuutouym,
            qIT_TRMinyuu.jyutoukaisuuy,
            qIT_TRMinyuu.jyutoukaisuum,
            qIT_TRMinyuu.rsgaku.getTypeFieldName(),
            qIT_TRMinyuu.rsgaku.getValueFieldName(),
            qIT_TRMinyuu.ryosyuymd,
            qIT_TRMinyuu.hurihunokbn,
            qIT_TRMinyuu.hrkkaisuu,
            qIT_TRMinyuu.bankcd,
            qIT_TRMinyuu.sitencd,
            qIT_TRMinyuu.yokinkbn,
            qIT_TRMinyuu.kouzano,
            qIT_TRMinyuu.kbnkey,
            qIT_TRMinyuu.dantaikobetukbn,
            qIT_TRMinyuu.kzhurikaetkbtannaihyj,
            qIT_TRMinyuu.tikiktbrisyuruikbn,
            qIT_TRMinyuu.creditkessaiyouno,
            qIT_TRMinyuu.credituriagengjiyuu) +
            $FROM(qIT_TRMinyuu) +
            $ORDER_BY(
                qIT_TRMinyuu.syono.asc(),
                qIT_TRMinyuu.syoriYmd.asc(),
                qIT_TRMinyuu.nykkeiro.asc(),
                qIT_TRMinyuu.nyknaiyoukbn.asc(),
                qIT_TRMinyuu.jyuutouym.asc(),
                qIT_TRMinyuu.minyuutrrenno.asc()
                );
        ExDBResults<MinyuuTRBean> exDBResults =
            exDBEntityManager.createJPQL(sql, MinyuuTRBean.class).bind(qIT_TRMinyuu).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }


    public List<IT_KykSyouhn> getKykSyouhnSyus(IT_KykKihon pKykKihon) {
        return pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
    }

    public List<IT_AnsyuRireki> getAnsyuRirekis(IT_AnsyuKihon pAnsyuKihon, C_NyknaiyouKbn pNyknaiyouKbn,
        BizDateYM pJyuutouym, C_Nykkeiro pNykkeiro, Integer pJyutoukaisuuy, Integer pJyutoukaisuum,
        BizCurrency pRsgaku, BizDate pRyosyuymd, C_AnnaijkKbn pAnnaijkKbn) {

        List<IT_AnsyuRireki> ansyuRirekiLst = pAnsyuKihon.getAnsyuRirekis();

        return new ArrayList<IT_AnsyuRireki>(Collections2.filter(ansyuRirekiLst, new FilterAnsyuRireki1(
            pNyknaiyouKbn, pJyuutouym, pNykkeiro, pJyutoukaisuuy, pJyutoukaisuum, pRsgaku, pRyosyuymd, pAnnaijkKbn)));
    }

    public List<IT_YykIdouUktk> getYykIdouUktks(IT_KykKihon pKykKihon) {
        return pKykKihon.getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn.UKE);
    }

    public List<IT_Kariukekin> getKariukekins(IT_KykKihon pKykKihon) {
        List<IT_Kariukekin> kariukekinLst = pKykKihon.getKariukekins();

        return new ArrayList<IT_Kariukekin>(Collections2.filter(kariukekinLst, new FilterKariukekin1()));
    }

    public List<IT_AnsyuRireki> getAnsyuRirekis2(IT_AnsyuKihon pAnsyuKihon, C_NyknaiyouKbn pNyknaiyoukbn,
        C_Nykkeiro pNykkeiro, BizDate pHurikaeYmd, C_AnnaijkKbn pAnnaijkKbn) {

        List<IT_AnsyuRireki> ansyuRirekiLst = pAnsyuKihon.getAnsyuRirekis();

        ansyuRirekiLst = new ArrayList<IT_AnsyuRireki>(Collections2.filter(ansyuRirekiLst, new FilterAnsyuRireki2(
            pNyknaiyoukbn, pNykkeiro, pHurikaeYmd, pAnnaijkKbn)));

        SortKhMinyuu sortKhMinyuu = new SortKhMinyuu();

        ansyuRirekiLst = sortKhMinyuu.OrderIT_AnsyuRirekiByJyuutouymAsc(ansyuRirekiLst);

        return ansyuRirekiLst;
    }

    public void deleteTRMinyuu() {
        hozenDomManager.delete(hozenDomManager.getAllTRMinyuu());
    }


}
