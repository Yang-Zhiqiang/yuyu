package yuyu.batch.biz.bzkaikei.bzhjybruigakuteiseitblsakujyo.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QBT_HjybruikeigakuTeisei;
import yuyu.def.classification.C_Kanjyoukmkcd;

/**
 * 業務共通 経理･会計 補助簿累計額訂正テーブル削除機能DAOクラス
 */
public class BzHjybRuigakuTeiseiTblSakujyoDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public int delAllBzHjybRuikeigakuTeisei() {

        QBT_HjybruikeigakuTeisei qBT_HjybruikeigakuTeisei = new QBT_HjybruikeigakuTeisei("QBT_HjybruikeigakuTeisei");

        String strSql = $DELETE_FROM(qBT_HjybruikeigakuTeisei) + 
    		$WHERE + qBT_HjybruikeigakuTeisei.kanjyoukmkcd.ne(C_Kanjyoukmkcd.BLNK);

        return exDBEntityManager.createJPQL(strSql).bind(qBT_HjybruikeigakuTeisei).executeUpdate();
    }

}