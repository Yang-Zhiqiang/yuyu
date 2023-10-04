package yuyu.batch.hozen.khansyuu.khyoyakuidoukousin.dba;

import yuyu.def.db.entity.IT_YykIdouAnsyuCreditCard;

import com.google.common.base.Predicate;

/**
 * 予約異動案内収納用クレジット払テーブル用Predicateクラス１<br />
 * 変更識別キーが指定されていて、変更識別キーが同一の場合に一致するデータをフィルタリングします。<br />
 */
public class FilterYykIdouAnsyuCreditCard1 implements Predicate<IT_YykIdouAnsyuCreditCard> {

    String henkousikibetukey;

    public FilterYykIdouAnsyuCreditCard1(String pHenkousikibetukey) {
        super();
        henkousikibetukey = pHenkousikibetukey;
    }

    @Override
    public boolean apply(IT_YykIdouAnsyuCreditCard pYykIdouAnsyuCreditCard) {
        if (henkousikibetukey.equals(pYykIdouAnsyuCreditCard.getHenkousikibetukey())) {
            return true;
        }
        return false;
    }
}