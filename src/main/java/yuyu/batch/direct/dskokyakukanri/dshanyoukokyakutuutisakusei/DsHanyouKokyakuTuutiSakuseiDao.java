package yuyu.batch.direct.dskokyakukanri.dshanyoukokyakutuutisakusei;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import com.google.common.collect.Iterables;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.classification.C_DsHagakiSouhuJyoukyouKbn;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.db.meta.QMT_DsHanyouKokTuutiError;
import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.meta.QMT_DsMailHaisinRireki;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiTy;

/**
 * ＤＳ汎用顧客宛通知作成DAOクラスです。
 */
public class DsHanyouKokyakuTuutiSakuseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void deleteDsHanyouKokyakuTuutiTy() {

        QZT_DsHanyouKokyakuTuutiTy qZT_DsHanyouKokyakuTuutiTy = new QZT_DsHanyouKokyakuTuutiTy();

        String querySql = $DELETE_FROM(qZT_DsHanyouKokyakuTuutiTy);

        exDBEntityManager.createJPQL(querySql).bind(qZT_DsHanyouKokyakuTuutiTy).executeUpdate();
    }

    public ExDBResults<DsHanyouKokyakuateTuuti2Bean> getDsHanyouKokyakuateTuutis2ByDsdatasakuseiymd(
        BizDate pDsdatasakuseiymd) {

        QMT_DsHanyouKokyakuateTuuti2 qMT_DsHanyouKokyakuateTuuti2 = new QMT_DsHanyouKokyakuateTuuti2();
        QMT_DsHanyouKokTuutiError qMT_DsHanyouKokTuutiError = new QMT_DsHanyouKokTuutiError();

        String strSql  = $SELECT +
            $NEW (DsHanyouKokyakuateTuuti2Bean.class,
                qMT_DsHanyouKokyakuateTuuti2.dsdatasakuseiymd,
                qMT_DsHanyouKokyakuateTuuti2.dskoktuutirenno,
                qMT_DsHanyouKokyakuateTuuti2.dskokno,
                qMT_DsHanyouKokyakuateTuuti2.dshanyoukokyakuatetuutikbn,
                qMT_DsHanyouKokyakuateTuuti2.syono,
                qMT_DsHanyouKokyakuateTuuti2.dssousinno,
                qMT_DsHanyouKokTuutiError.dshagakisouhujyoukyoukbn) +
                $FROM (qMT_DsHanyouKokyakuateTuuti2) +
                $LEFT_OUTER_JOIN + qMT_DsHanyouKokyakuateTuuti2.MT_DsHanyouKokTuutiError() +
                $AS + qMT_DsHanyouKokTuutiError +
                $WHERE + $(qMT_DsHanyouKokyakuateTuuti2.dsdatasakuseiymd.eq(pDsdatasakuseiymd) +
                    $AND + qMT_DsHanyouKokyakuateTuuti2.dshanyoukokyakuatetuutikbn.eq(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI)) +
                    $OR + qMT_DsHanyouKokTuutiError.dshagakisouhujyoukyoukbn.eq(C_DsHagakiSouhuJyoukyouKbn.SOUHUMATI);

        ExDBResults<DsHanyouKokyakuateTuuti2Bean> exDBResults =
            exDBEntityManager.createJPQL(strSql, DsHanyouKokyakuateTuuti2Bean.class).bind(qMT_DsHanyouKokyakuateTuuti2, qMT_DsHanyouKokTuutiError).getResults();

        return exDBResults;
    }

    public List<MT_DsMailHaisinRireki> getDsMailHaisinRirekiInfoByKoknoDssousinno(String pDskokno, String pDssousinno) {

        QMT_DsMailHaisinRireki qMT_DsMailHaisinRireki = new QMT_DsMailHaisinRireki();

        String strSql  = $SELECT + qMT_DsMailHaisinRireki +
            $FROM (qMT_DsMailHaisinRireki) +
            $WHERE + qMT_DsMailHaisinRireki.dskokno.eq(pDskokno) +
            $AND + qMT_DsMailHaisinRireki.dssousinno.eq(pDssousinno);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisinRireki).getResultList();
    }

    public MT_DsHanyouKokyakuateTuuti2 getDsHanyouKokTuuti2ByPK(
        MT_DsKokyakuKanri pDsKokyakuKanri,BizDate pDsdatasakuseiymd, String pDskoktuutirenno,
        String pDskokno, C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {

        List<MT_DsHanyouKokyakuateTuuti2> mtDsHanyouKokyakuateTuuti2List = pDsKokyakuKanri.getDsHanyouKokyakuateTuuti2s();

        MT_DsHanyouKokyakuateTuuti2 mtDsHanyouKokyakuateTuuti2 = Iterables.getFirst(Iterables.filter(mtDsHanyouKokyakuateTuuti2List,
            new FilterDsHanyouKokyakuateTuuti2(pDsdatasakuseiymd, pDskoktuutirenno, pDskokno,pDshanyoukokyakuatetuutikbn)), null);

        return mtDsHanyouKokyakuateTuuti2;
    }
}
