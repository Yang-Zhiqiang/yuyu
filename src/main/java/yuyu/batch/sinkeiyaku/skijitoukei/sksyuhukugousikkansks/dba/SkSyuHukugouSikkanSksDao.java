package yuyu.batch.sinkeiyaku.skijitoukei.sksyuhukugousikkansks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QHW_SyuHukugouSikkanZhkWk;

/**
 * 新契約 主契約複合疾患作成の機能DAOクラスです。
 */
public class SkSyuHukugouSikkanSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SkSyuHukugouSikkanDataBean> getSkSyuHukugouSikkanData() {

        QHW_SyuHukugouSikkanZhkWk qHW_SyuHukugouSikkanZhkWk = new QHW_SyuHukugouSikkanZhkWk("qHW_SyuHukugouSikkanZhkWk");

        String strSql = $SELECT + $NEW(SkSyuHukugouSikkanDataBean.class,
            qHW_SyuHukugouSikkanZhkWk.hknnendo,
            qHW_SyuHukugouSikkanZhkWk.ijitoukeidaihyousyurui,
            qHW_SyuHukugouSikkanZhkWk.kyknendo,
            qHW_SyuHukugouSikkanZhkWk.hhknsei,
            qHW_SyuHukugouSikkanZhkWk.kykage,
            qHW_SyuHukugouSikkanZhkWk.toutatunenrei,
            qHW_SyuHukugouSikkanZhkWk.atukaibetu,
            qHW_SyuHukugouSikkanZhkWk.ijitoukeisinsahouhou,
            qHW_SyuHukugouSikkanZhkWk.ketteikekkaa,
            qHW_SyuHukugouSikkanZhkWk.sibousrank,
            qHW_SyuHukugouSikkanZhkWk.jissituhosyousrank,
            qHW_SyuHukugouSikkanZhkWk.sirajikykkbn,
            qHW_SyuHukugouSikkanZhkWk.hrkhouhoukbn,
            qHW_SyuHukugouSikkanZhkWk.ijitoukeihokensyuruikbn,
            qHW_SyuHukugouSikkanZhkWk.daisiincd,
            qHW_SyuHukugouSikkanZhkWk.tyuusiincd,
            qHW_SyuHukugouSikkanZhkWk.siincd,
            qHW_SyuHukugouSikkanZhkWk.nenreihousikikbn,
            qHW_SyuHukugouSikkanZhkWk.hhknsykgycd,
            qHW_SyuHukugouSikkanZhkWk.hhkntodouhukencd,
            qHW_SyuHukugouSikkanZhkWk.botaisisyaeigyouhonbu,
            qHW_SyuHukugouSikkanZhkWk.sisyaeigyoubu,
            qHW_SyuHukugouSikkanZhkWk.aatsukaishasoshikicd,
            qHW_SyuHukugouSikkanZhkWk.hhknnensyuukbn,
            qHW_SyuHukugouSikkanZhkWk.hanbaikeirokbn,
            qHW_SyuHukugouSikkanZhkWk.oyadrtencd,
            qHW_SyuHukugouSikkanZhkWk.tratkiagcd,
            qHW_SyuHukugouSikkanZhkWk.bosyuudairitenatkikeitaikbn,
            qHW_SyuHukugouSikkanZhkWk.kyktuukasyu,
            qHW_SyuHukugouSikkanZhkWk.hrktuukasyu,
            qHW_SyuHukugouSikkanZhkWk.syouhncd,
            qHW_SyuHukugouSikkanZhkWk.initsbjiyensitihsytkhukaumu,
            qHW_SyuHukugouSikkanZhkWk.jyudkaigomeharaitkhukaumu,
            qHW_SyuHukugouSikkanZhkWk.ijitoukeizennoukbn,
            qHW_SyuHukugouSikkanZhkWk.dai1hknkkn,
            qHW_SyuHukugouSikkanZhkWk.ijitoukeitikshrtkykkbn,
            $SUM + $(qHW_SyuHukugouSikkanZhkWk.ijitoukeikeikan),
            $SUM + $(qHW_SyuHukugouSikkanZhkWk.ijitoukeisiboun),
            $SUM + $(qHW_SyuHukugouSikkanZhkWk.ijitoukeikeikas),
            $SUM + $(qHW_SyuHukugouSikkanZhkWk.ijitoukeisibous)
            ) +
            $FROM(qHW_SyuHukugouSikkanZhkWk) +
            $GROUP_BY + qHW_SyuHukugouSikkanZhkWk.hknnendo + "," +
            qHW_SyuHukugouSikkanZhkWk.ijitoukeidaihyousyurui + "," +
            qHW_SyuHukugouSikkanZhkWk.kyknendo + "," +
            qHW_SyuHukugouSikkanZhkWk.hhknsei + "," +
            qHW_SyuHukugouSikkanZhkWk.kykage + "," +
            qHW_SyuHukugouSikkanZhkWk.toutatunenrei + "," +
            qHW_SyuHukugouSikkanZhkWk.atukaibetu + "," +
            qHW_SyuHukugouSikkanZhkWk.ijitoukeisinsahouhou + "," +
            qHW_SyuHukugouSikkanZhkWk.ketteikekkaa + "," +
            qHW_SyuHukugouSikkanZhkWk.sibousrank + "," +
            qHW_SyuHukugouSikkanZhkWk.jissituhosyousrank + "," +
            qHW_SyuHukugouSikkanZhkWk.sirajikykkbn + "," +
            qHW_SyuHukugouSikkanZhkWk.hrkhouhoukbn + "," +
            qHW_SyuHukugouSikkanZhkWk.ijitoukeihokensyuruikbn + "," +
            qHW_SyuHukugouSikkanZhkWk.daisiincd + "," +
            qHW_SyuHukugouSikkanZhkWk.tyuusiincd + "," +
            qHW_SyuHukugouSikkanZhkWk.siincd + "," +
            qHW_SyuHukugouSikkanZhkWk.nenreihousikikbn + "," +
            qHW_SyuHukugouSikkanZhkWk.hhknsykgycd + "," +
            qHW_SyuHukugouSikkanZhkWk.hhkntodouhukencd + "," +
            qHW_SyuHukugouSikkanZhkWk.botaisisyaeigyouhonbu + "," +
            qHW_SyuHukugouSikkanZhkWk.sisyaeigyoubu + "," +
            qHW_SyuHukugouSikkanZhkWk.aatsukaishasoshikicd + "," +
            qHW_SyuHukugouSikkanZhkWk.hhknnensyuukbn + "," +
            qHW_SyuHukugouSikkanZhkWk.hanbaikeirokbn + "," +
            qHW_SyuHukugouSikkanZhkWk.oyadrtencd + "," +
            qHW_SyuHukugouSikkanZhkWk.tratkiagcd + "," +
            qHW_SyuHukugouSikkanZhkWk.bosyuudairitenatkikeitaikbn + "," +
            qHW_SyuHukugouSikkanZhkWk.kyktuukasyu + "," +
            qHW_SyuHukugouSikkanZhkWk.hrktuukasyu + "," +
            qHW_SyuHukugouSikkanZhkWk.syouhncd + "," +
            qHW_SyuHukugouSikkanZhkWk.initsbjiyensitihsytkhukaumu + "," +
            qHW_SyuHukugouSikkanZhkWk.jyudkaigomeharaitkhukaumu + "," +
            qHW_SyuHukugouSikkanZhkWk.ijitoukeizennoukbn + "," +
            qHW_SyuHukugouSikkanZhkWk.dai1hknkkn + "," +
            qHW_SyuHukugouSikkanZhkWk.ijitoukeitikshrtkykkbn;

        return exDBEntityManager.createJPQL(strSql, SkSyuHukugouSikkanDataBean.class).bind(qHW_SyuHukugouSikkanZhkWk).getResults();
    }
}
