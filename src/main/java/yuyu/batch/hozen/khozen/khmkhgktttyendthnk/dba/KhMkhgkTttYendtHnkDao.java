package yuyu.batch.hozen.khozen.khmkhgktttyendthnk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;

/**
 * 契約保全 契約保全 円建変更DAOクラス
 */
public class KhMkhgkTttYendtHnkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhMkhgkTttYendtHnkBean> getKhMkhgkTttYendtHnkBeans(String pKakutyouJobCd, String pHeisoukbn) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");
        QIT_KhHenkouUktkYendtHnk qIT_KhHenkouUktkYendtHnk = new QIT_KhHenkouUktkYendtHnk("qIT_KhHenkouUktkYendtHnk");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String strSql = $SELECT + $NEW(KhMkhgkTttYendtHnkBean.class,
            qIT_KhHenkouUktk.kbnkey,
            qIT_KhHenkouUktk.syono,
            qIT_KhHenkouUktk.kouryokuhasseiymd,
            qIT_KhHenkouUktk.hozenhenkouuktkrenno,
            qIT_KhHenkouUktk.tourokuroute,
            qIT_KhHenkouUktk.uktksyorikbn,
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.dai1hknkkn,
            qIT_KykSonotaTkyk.targettkkbn,
            qIT_KykSonotaTkyk.targettkmokuhyouti,
            qIT_KykSonotaTkyk.targettkykkijyungk.getTypeFieldName(),
            qIT_KykSonotaTkyk.targettkykkijyungk.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.newsyouhncd,
            qIT_KhHenkouUktkYendtHnk.newsyouhnsdno,
            qIT_KhHenkouUktkYendtHnk.yendthnkymd,
            qIT_KhHenkouUktkYendtHnk.yendthnkkihons.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkkihons.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.newhokenryou.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.newhokenryou.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.newkyktuukasyu,
            qIT_KhHenkouUktkYendtHnk.newryouritusdno,
            qIT_KhHenkouUktkYendtHnk.newkaiyakuhr.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.newkaiyakuhr.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkhr.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkhr.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkkaiyakuhrgaika.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkkaiyakuhrgaika.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkkaiyakuhryen.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkkaiyakuhryen.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.nyuuryokuhassoukbn,
            qIT_KhHenkouUktkYendtHnk.hnskariyuu1,
            qIT_KhHenkouUktkYendtHnk.hnskariyuu2,
            qIT_KhHenkouUktkYendtHnk.mkhgktttymd,
            qIT_KhHenkouUktkYendtHnk.mkhgktttkaiyakuhr.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.mkhgktttkaiyakuhr.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkjikwsrate,
            qIT_KhHenkouUktkYendtHnk.syoruiukeymd,
            qIT_KhHenkouUktkYendtHnk.newtumitateriritu,
            qIT_KhHenkouUktkYendtHnk.newyoteiriritu,
            qIT_KykSya.kkkyktdk,
            qIT_KykSya.kyknmkn,
            qIT_KykSya.kyknmkj,
            qIT_KykSya.tsinyno,
            qIT_KykSya.tsinadr1kj,
            qIT_KykSya.tsinadr2kj,
            qIT_KykSya.tsinadr3kj,
            qBM_SyouhnZokusei.mousideikoukbn,
            qIT_KykKihon.hrkp.getTypeFieldName(),
            qIT_KykKihon.hrkp.getValueFieldName(),
            qIT_KykKihon.haitounendo) +
            $FROM(qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qIT_KykSya,
                qIT_KhHenkouUktk,
                qIT_KhHenkouUktkYendtHnk,
                qBM_SyouhnZokusei,
                qIT_KykKihon) +
                $WHERE + qIT_KhHenkouUktk.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                $AND + qIT_KhHenkouUktk.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KhHenkouUktk.syono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KhHenkouUktk.syono.eq(qIT_KhHenkouUktkYendtHnk.syono) +
                $AND + qIT_KhHenkouUktk.hozenhenkouuktkrenno.eq(qIT_KhHenkouUktkYendtHnk.hozenhenkouuktkrenno) +
                $AND + qIT_KhHenkouUktk.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI) +
                $AND + qIT_KhHenkouUktk.uktksyorikbn.
                in(C_UktkSyoriKbn.MKHGKTTTYENDTHNK, C_UktkSyoriKbn.NINISEIKYUU);

        if (!BizUtil.isBlank(pHeisoukbn)){
            strSql = strSql + $AND + qIT_KhHenkouUktk.kbnkey.eq(pHeisoukbn);
        }

        ExDBResults<KhMkhgkTttYendtHnkBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhMkhgkTttYendtHnkBean.class)
            .bind(qIT_KykSyouhn, qIT_KykSonotaTkyk, qIT_KykSya, qIT_KhHenkouUktk,
                qIT_KhHenkouUktkYendtHnk, qBM_SyouhnZokusei, qIT_KykKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Integer getKykSyouhnHnkmaeMaxRennoBySyonoSyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
        String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno) {

        QIT_KykSyouhnHnkmae qIT_KykSyouhnHnkmae = new QIT_KykSyouhnHnkmae("QIT_KykSyouhnHnkmae");

        String strSql = $SELECT + $MAX(qIT_KykSyouhnHnkmae.renno) +
            $FROM(qIT_KykSyouhnHnkmae) +
            $WHERE + qIT_KykSyouhnHnkmae.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnHnkmae.syutkkbn.eq(pSyutkkbn) +
            $AND + qIT_KykSyouhnHnkmae.syouhncd.eq(pSyouhncd) +
            $AND + qIT_KykSyouhnHnkmae.syouhnsdno.eq(pSyouhnsdno) +
            $AND + qIT_KykSyouhnHnkmae.kyksyouhnrenno.eq(pKyksyouhnrenno) +
            $GROUP_BY + qIT_KykSyouhnHnkmae.syono + "," +
            qIT_KykSyouhnHnkmae.syutkkbn + "," +
            qIT_KykSyouhnHnkmae.syouhncd + "," +
            qIT_KykSyouhnHnkmae.syouhnsdno + "," +
            qIT_KykSyouhnHnkmae.kyksyouhnrenno;

        Integer maxRenNo =
            exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhnHnkmae).getSingleResult();

        return maxRenNo;
    }
}
