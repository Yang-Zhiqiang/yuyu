package yuyu.batch.hozen.khkessan.khzennoutoukeilistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QIT_ZennouKessan;

/**
 * 契約保全 決算 前納統計リスト作成
 */
public class KhZennouToukeiListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZennouToukeiListSksTaisyouBean> getZennouToukeiListSksTaisyouBeans(String pSksiymd) {

        QIT_ZennouKessan qIT_ZennouKessan = new QIT_ZennouKessan("qIT_ZennouKessan");

        String strSql = $SELECT + $NEW(ZennouToukeiListSksTaisyouBean.class,
            qIT_ZennouKessan.zennoutoukeilistkbn,
            qIT_ZennouKessan.zennoukbn,
            qIT_ZennouKessan.kbnkeirisegcd,
            qIT_ZennouKessan.zennoustartym,
            $COUNT + "(*)"  +  $AS  + "cnt",
            qIT_ZennouKessan.zennoukaisijizndk.getTypeFieldName(),
            $SUM + $(qIT_ZennouKessan.zennoukaisijizndk.getValueFieldName()) + $AS + "zennoukaisijizndk",
            qIT_ZennouKessan.tndmatuzndk.getTypeFieldName(),
            $SUM + $(qIT_ZennouKessan.tndmatuzndk.getValueFieldName()) + $AS + "tndmatuzndk" ,
            qIT_ZennouKessan.zennoukaisijizndktkmatu.getTypeFieldName(),
            $SUM + $(qIT_ZennouKessan.zennoukaisijizndktkmatu.getValueFieldName()) + $AS + "zennoukaisijizndktkmatu"  ,
            qIT_ZennouKessan.tndmatuzndktkmatu.getTypeFieldName(),
            $SUM + $(qIT_ZennouKessan.tndmatuzndktkmatu.getValueFieldName()) + $AS + "tndmatuzndktkmatu")  +
            $FROM(qIT_ZennouKessan) +
            $WHERE + qIT_ZennouKessan.sakuseiymd.eq(BizDate.valueOf(pSksiymd)) +
            $GROUP_BY +
            qIT_ZennouKessan.zennoutoukeilistkbn + "," +
            qIT_ZennouKessan.zennoukbn + "," +
            qIT_ZennouKessan.kbnkeirisegcd + "," +
            qIT_ZennouKessan.zennoustartym  + "," +
            qIT_ZennouKessan.zennoukaisijizndk.getTypeFieldName() + "," +
            qIT_ZennouKessan.tndmatuzndk.getTypeFieldName() + "," +
            qIT_ZennouKessan.zennoukaisijizndktkmatu.getTypeFieldName() + "," +
            qIT_ZennouKessan.tndmatuzndktkmatu.getTypeFieldName() +

            $ORDER_BY(qIT_ZennouKessan.zennoutoukeilistkbn.asc(),
                qIT_ZennouKessan.zennoukbn.asc(),
                qIT_ZennouKessan.kbnkeirisegcd.asc(),
                qIT_ZennouKessan.zennoustartym.asc());

        ExDBResults<ZennouToukeiListSksTaisyouBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, ZennouToukeiListSksTaisyouBean.class).bind(qIT_ZennouKessan).getResults();

        return exDBResults;
    }
}
