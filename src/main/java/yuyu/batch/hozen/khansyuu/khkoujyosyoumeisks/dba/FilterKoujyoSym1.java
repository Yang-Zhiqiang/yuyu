package yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks.dba;

import yuyu.def.db.entity.IT_KoujyoSym;

import com.google.common.base.Predicate;

/**
 * 控除証明書テーブル用Predicateクラス１
 * @author  王　大中
 * @version 2020/8/18 王　大中 : 新規作成<br />
 */
public class FilterKoujyoSym1 implements Predicate<IT_KoujyoSym> {

    /** 証明年度 */
    String syoumeinnd;

    /**
     * コンストラクタ
     * @param pSyoumeinnd 証明年度
     */
    public FilterKoujyoSym1(String pSyoumeinnd) {
        super();
        syoumeinnd = pSyoumeinnd;
    }

    /**
     * 判定処理<br />
     * @param   pKoujyoSym 控除証明書テーブルエンティティ
     * @return  一致可否
     */
    @Override
    public boolean apply(IT_KoujyoSym pKoujyoSym) {
        // メンバ変数．証明年度 ＝ I．控除証明書テーブルエンティティ．年度  の場合
        if (syoumeinnd.equals(pKoujyoSym.getNendo())) {
            return true;
        }
        return false;
    }
}
