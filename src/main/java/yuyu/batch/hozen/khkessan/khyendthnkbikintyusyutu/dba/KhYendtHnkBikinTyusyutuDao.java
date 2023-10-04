package yuyu.batch.hozen.khkessan.khyendthnkbikintyusyutu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.meta.QIT_KhBikinkanri;
import yuyu.def.db.meta.QIT_KhHenreikin;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;

/**
 * 契約保全 決算 円建変更時返戻金備金抽出機能DAOクラス
 */
public class KhYendtHnkBikinTyusyutuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhBikinkanriYendthnkInfosBean> getKhBikinkanriYendthnkInfos(
        String pKakutyouJobCd, BizDate pKessanYmd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KhHenreikin qIT_KhHenreikin = new QIT_KhHenreikin("qIT_KhHenreikin");

        String strSql = $SELECT + $NEW(KhBikinkanriYendthnkInfosBean.class,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_KykSyouhn.kihons.getTypeFieldName(),
            qIT_KykSyouhn.kihons.getValueFieldName(),
            qIT_KhHenreikin.henkousikibetukey,
            qIT_KhHenreikin.shrymd,
            qIT_KhHenreikin.shrsyoriymd,
            qIT_KhHenreikin.hrhsiymd,
            qIT_KhHenreikin.hrhsisyoriymd,
            qIT_KhHenreikin.henreikingk.getTypeFieldName(),
            qIT_KhHenreikin.henreikingk.getValueFieldName(),
            qIT_KhHenreikin.hrsiharaijyoutaikbn,
            qIT_KhHenreikin.seg1cd,
            qIT_KhHenreikin.tantocd) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KhHenreikin) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KhHenreikin.syono) +
                $AND + $(qIT_KhHenreikin.hrsiharaijyoutaikbn.eq(C_Siharaijyoutaikbn.MBR) +
                    $OR + qIT_KhHenreikin.hrsiharaijyoutaikbn.eq(C_Siharaijyoutaikbn.SIHARAIZUMI)) +
                    $AND + $(qIT_KhHenreikin.shrymd + $IS_NULL +
                        $OR + qIT_KhHenreikin.shrymd.gt(pKessanYmd)) +
                        $AND + qIT_KhHenreikin.hrhsiymd.le(pKessanYmd);

        ExDBResults<KhBikinkanriYendthnkInfosBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KhBikinkanriYendthnkInfosBean.class)
            .bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KhHenreikin).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public IT_KykSyouhnHnkmae getKykSyouhnHnkmae(String pSyoNo) {

        QIT_KykSyouhnHnkmae qIT_KykSyouhnHnkmae = new QIT_KykSyouhnHnkmae("qIT_KykSyouhnHnkmae");

        String strSql = $SELECT + qIT_KykSyouhnHnkmae +
            $FROM(qIT_KykSyouhnHnkmae) +
            $WHERE + qIT_KykSyouhnHnkmae.syono.eq(pSyoNo) +
            $ORDER_BY(qIT_KykSyouhnHnkmae.renno.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(
            qIT_KykSyouhnHnkmae).getSingleResult();
    }

    public KhBikinkanriYendthnkInfoBean getKhBikinkanriYendthnkInfo(String pSyoNo) {

        QIT_KhBikinkanri qIT_KhBikinkanri = new QIT_KhBikinkanri("qIT_KhBikinkanri");

        String strSql = $SELECT + $NEW(KhBikinkanriYendthnkInfoBean.class,
            qIT_KhBikinkanri.kessankijyunymd) +
            $FROM(qIT_KhBikinkanri) +
            $WHERE + qIT_KhBikinkanri.syono.eq(pSyoNo) +
            $AND + qIT_KhBikinkanri.bkncdkbn.eq(C_BkncdKbn.YENDTHNKHR) +
            $AND + qIT_KhBikinkanri.bknrigikbn.eq(C_BknrigiKbn.BLNK) +
            $ORDER_BY(qIT_KhBikinkanri.kessankijyunymd.asc());

        return exDBEntityManager.createJPQL(strSql, KhBikinkanriYendthnkInfoBean.class).setFirstResult(0).
            setMaxResults(1).bind(qIT_KhBikinkanri).getSingleResult();
    }
}
