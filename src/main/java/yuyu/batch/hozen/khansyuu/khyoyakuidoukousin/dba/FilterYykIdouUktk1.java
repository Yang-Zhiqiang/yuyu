package yuyu.batch.hozen.khansyuu.khyoyakuidoukousin.dba;

import yuyu.def.db.entity.IT_YykIdouUktk;

import com.google.common.base.Predicate;

/**
 * 予約異動受付テーブル用Predicateクラス１<br />
 * 変更識別キー、機能IDが指定されていて、変更識別キーと機能IDが同一の場合に一致するデータをフィルタリングします。<br />
 */
public class FilterYykIdouUktk1 implements Predicate<IT_YykIdouUktk> {

    String henkousikibetukey;
    String kinouId;

    public FilterYykIdouUktk1(String pHenkousikibetukey, String pKinouId) {
        super();
        henkousikibetukey = pHenkousikibetukey;
        kinouId = pKinouId;
    }

    @Override
    public boolean apply(IT_YykIdouUktk pYykIdouUktk) {
        if (henkousikibetukey.equals(pYykIdouUktk.getHenkousikibetukey()) &&
            kinouId.equals(pYykIdouUktk.getKinouId())) {
            return true;
        }
        return false;
    }
}