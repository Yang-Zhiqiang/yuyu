package yuyu.batch.hozen.khansyuu.khkariukekinseibitokusokulistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_KrkknSeibiTokusokuInfo;

/**
 * 契約保全 案内収納 仮受金整備督促リスト作成機能DAOクラス
 */
public class KhKariukekinSeibiTokusokuListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KariukeTokusokuListSksTaisyouBean> getKariukeTokusokuListSksTaisyouBeans(String pKakutyoujobcd) {

        QIT_KrkknSeibiTokusokuInfo qIT_KrkknSeibiTokusokuInfo = new QIT_KrkknSeibiTokusokuInfo("qIT_KrkknSeibiTokusokuInfo");

        String strSql = $SELECT + $NEW(KariukeTokusokuListSksTaisyouBean.class,
            qIT_KrkknSeibiTokusokuInfo.syono,
            qIT_KrkknSeibiTokusokuInfo.krkno,
            qIT_KrkknSeibiTokusokuInfo.atesakisosikicd,
            qIT_KrkknSeibiTokusokuInfo.atesakibusitucd,
            qIT_KrkknSeibiTokusokuInfo.tantocd,
            qIT_KrkknSeibiTokusokuInfo.kyknmkj,
            qIT_KrkknSeibiTokusokuInfo.tyoukimiseibikrkumu,
            qIT_KrkknSeibiTokusokuInfo.hukusuukrkumu,
            qIT_KrkknSeibiTokusokuInfo.krkkeijyoymd,
            qIT_KrkknSeibiTokusokuInfo.krkgk.getTypeFieldName(),
            qIT_KrkknSeibiTokusokuInfo.krkgk.getValueFieldName(),
            qIT_KrkknSeibiTokusokuInfo.krkriyuukbn,
            qIT_KrkknSeibiTokusokuInfo.nyknaiyoukbn,
            qIT_KrkknSeibiTokusokuInfo.nykkeiro,
            qIT_KrkknSeibiTokusokuInfo.jyuutouym,
            qIT_KrkknSeibiTokusokuInfo.jyutoukaisuuy,
            qIT_KrkknSeibiTokusokuInfo.jyutoukaisuum,
            qIT_KrkknSeibiTokusokuInfo.ryosyuymd,
            qIT_KrkknSeibiTokusokuInfo.krkjhrkkaisuu) +
            $FROM(qIT_KrkknSeibiTokusokuInfo) +
            $ORDER_BY(qIT_KrkknSeibiTokusokuInfo.tantocd.asc(),
                qIT_KrkknSeibiTokusokuInfo.nykkeiro.asc(),
                qIT_KrkknSeibiTokusokuInfo.krkkeijyoymd.asc(),
                qIT_KrkknSeibiTokusokuInfo.syono.asc(),
                qIT_KrkknSeibiTokusokuInfo.krkno.asc());

        ExDBResults<KariukeTokusokuListSksTaisyouBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KariukeTokusokuListSksTaisyouBean.class).bind(qIT_KrkknSeibiTokusokuInfo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}

