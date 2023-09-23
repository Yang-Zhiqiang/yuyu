package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

/**
 * 契約保全 契約保全共通  前納充当情報取消出力Beanクラス
 */
public class TorikesiZnnJytInfoOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDateYM torikesigoJkipjytYm;

    private List<IT_NyknJissekiRireki> torikesigoNyknJissekiRireki;

    public BizDateYM getTorikesigoJkipjytYm() {
        return torikesigoJkipjytYm;
    }

    public void setTorikesigoJkipjytYm(BizDateYM pTorikesigoJkipjytYm) {
        torikesigoJkipjytYm = pTorikesigoJkipjytYm;
    }

    public List<IT_NyknJissekiRireki> getTorikesigoNyknJissekiRireki() {
        return torikesigoNyknJissekiRireki;
    }

    public void setTorikesigoNyknJissekiRireki(List<IT_NyknJissekiRireki> pTorikesigoNyknJissekiRireki) {
        torikesigoNyknJissekiRireki = pTorikesigoNyknJissekiRireki;
    }
}
