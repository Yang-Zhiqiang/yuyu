package yuyu.batch.hozen.khansyuu.khginkoumdhnmisyuuinfosel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 案内収納 銀行窓販未収情報抽出Daoクラス
 */
public class KhGinkouMdhnMisyuuInfoSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<AnnaiSyunouDataBean> getAnnaiSyunouDataBeans(String pKakutyouJobCd, BizDateYM pSyoriYmPreMonth) {

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(AnnaiSyunouDataBean.class,
            qIT_AnsyuKihon.syono,
            qIT_AnsyuKihon.kbnkey,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.hrkp.getTypeFieldName(),
            qIT_KykKihon.hrkp.getValueFieldName(),
            qIT_KykKihon.hrkkeiro,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykKihon.tikiktbrisyuruikbn,
            qIT_KykSyouhn.ryouritusdno,
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName()) +
            $FROM (qIT_AnsyuKihon,
                qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
                $AND   + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
                $AND   +  " ( " + qIT_KykKihon.hrkkeiro.eq(C_Hrkkeiro.KOUHURI) +
                $OR    + qIT_KykKihon.hrkkeiro.eq(C_Hrkkeiro.CREDIT) +" ) " +
                $AND   + qIT_AnsyuKihon.jkipjytym.substring(1, 6).lt(qIT_AnsyuKihon.syuharaimanymd.substring(1, 6)) +
                $AND   + qIT_AnsyuKihon.jkipjytym.le(pSyoriYmPreMonth) +
                $AND   + qIT_KykSyouhn.syono.eq(qIT_AnsyuKihon.syono) +
                $AND   + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND   + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND   + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                $ORDER_BY (qIT_AnsyuKihon.syono.asc());

        ExDBResults<AnnaiSyunouDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, AnnaiSyunouDataBean.class)
            .bind(qIT_AnsyuKihon, qIT_KykKihon, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public List<AnnaiSyunouRirekiBean> getAnnaiSyuunouRirekiBeans(String pSyono, BizDateYM pAnnaiSakuseiYm) {

        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String strSql = $SELECT + $NEW(AnnaiSyunouRirekiBean.class,
            qIT_AnsyuRireki.jyuutouym,
            qIT_AnsyuRireki.jyutoukaisuuy,
            qIT_AnsyuRireki.jyutoukaisuum,
            qIT_AnsyuRireki.hrkkaisuu,
            qIT_AnsyuRireki.hurihunokbn,
            qIT_AnsyuRireki.rsgaku.getTypeFieldName(),
            qIT_AnsyuRireki.rsgaku.getValueFieldName()) +
            $FROM (qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $AND   + qIT_AnsyuRireki.nykkeiro.eq(C_Nykkeiro.KZHRK) +
            $AND   + " ( " + qIT_AnsyuRireki.nyknaiyoukbn.eq(C_NyknaiyouKbn.KEIZOKUP) +
            $OR    + qIT_AnsyuRireki.nyknaiyoukbn.eq(C_NyknaiyouKbn.HARAIHENYOUP) +" ) " +
            $AND   + qIT_AnsyuRireki.annaisakuseiymd.substring(1, 6).eq(pAnnaiSakuseiYm.toString()) +
            $AND   + qIT_AnsyuRireki.annaijkkbn.eq(C_AnnaijkKbn.MINYUU) +
            $ORDER_BY (qIT_AnsyuRireki.jyuutouym.desc());

        List<AnnaiSyunouRirekiBean> annaiSyunouRirekiBeanList = exDBEntityManager.createJPQL(strSql, AnnaiSyunouRirekiBean.class)
            .bind(qIT_AnsyuRireki).getResultList();

        return annaiSyunouRirekiBeanList;
    }

    public long getAnsyuKihonCount(BizDate pSyoriYmTyokuzenHurikaeBi, String pBankCd) {

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM (qIT_AnsyuKihon,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_AnsyuRireki) +
                $WHERE + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
                $AND   + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
                $AND   + qIT_AnsyuKihon.jkipjytym.substring(1, 6).lt(qIT_AnsyuKihon.syuharaimanymd.substring(1, 6)) +
                $AND   + qIT_KykSyouhn.syono.eq(qIT_AnsyuKihon.syono) +
                $AND   + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND   + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND   + $(qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                    $OR    + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.IKKATUNK)) +
                    $AND   + qIT_AnsyuRireki.syono.eq(qIT_AnsyuKihon.syono) +
                    $AND   + qIT_AnsyuRireki.bankcd.eq(pBankCd) +
                    $AND   + qIT_AnsyuRireki.annaijkkbn.ne(C_AnnaijkKbn.ANNAI) +
                    $AND   + qIT_AnsyuRireki.hurikaeymd.eq(pSyoriYmTyokuzenHurikaeBi);

        Long kensuu = exDBEntityManager.createJPQL(strSql).bind(qIT_AnsyuKihon, qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuRireki).getSingleResult();

        return kensuu;
    }

}
