package yuyu.batch.hozen.khansyuu.khkawaseratetuutidatasks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.db.entity.IT_KawaseRateTuutiData;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSyouhn;
/**
 * 契約保全 案内収納 為替レート通知データ作成機能DAOクラス
 */
public class KhKawaseRateTuutiDataSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KawaseRateTuutiDataSksBean> getKawaseRateTuutiDataSks(BizDate pSyoriYmd, String pKakutyoujobcd) {
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String strSql = $SELECT + $NEW(KawaseRateTuutiDataSksBean.class,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.hrkp.getTypeFieldName(),
            qIT_KykKihon.hrkp.getValueFieldName(),
            qIT_KykKihon.aisyoumeikbn,
            qIT_KykKihon.ynkhrkmgkannituutikbn,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.kyktuukasyu,
            qIT_AnsyuKihon.jkipjytym) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qIT_AnsyuKihon,
                qIT_AnsyuRireki) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KykSonotaTkyk.yennykntkhkumu.eq(C_UmuKbn.ARI) +
                $AND + qIT_KykSonotaTkyk.yennyknsyuruikbn.eq(C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_AnsyuRireki.syono) +
                $AND + qIT_AnsyuKihon.jkipjytym.eq(qIT_AnsyuRireki.jyuutouym) +
                $AND + qIT_AnsyuRireki.nyknaiyoukbn.eq(C_NyknaiyouKbn.KEIZOKUP) +
                $AND + qIT_AnsyuRireki.annaisakuseiymd.substring(1, 6).eq(pSyoriYmd.getBizDateYM().toString()) +
                $AND + qIT_AnsyuRireki.nykkeiro.eq(C_Nykkeiro.KZHRK);

        ExDBResults<KawaseRateTuutiDataSksBean> exDBResults = exDBEntityManager.
            createJPQL(strSql, KawaseRateTuutiDataSksBean.class).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon,
                qIT_KykSonotaTkyk, qIT_AnsyuRireki).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public void addInserterEntity(EntityInserter<IT_KawaseRateTuutiData> pEntityInserter, IT_KawaseRateTuutiData
        pKawaseRateTuutiData) {
        pEntityInserter.add(pKawaseRateTuutiData);
    }
}
