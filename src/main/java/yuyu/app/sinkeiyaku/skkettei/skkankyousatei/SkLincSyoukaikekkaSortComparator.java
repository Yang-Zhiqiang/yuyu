package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import java.util.Comparator;

import yuyu.def.db.entity.HT_SkLincSyoukaikekka;

/**
 * HT_SkLincSyoukaikekkaをソートするためのコンパレータです。<br />
 * ソート条件は｛連番｝です。
 */
public class SkLincSyoukaikekkaSortComparator implements Comparator<HT_SkLincSyoukaikekka> {

    @Override
    public int compare(HT_SkLincSyoukaikekka o1, HT_SkLincSyoukaikekka o2) {

        Integer renno1 = o1.getRenno();
        Integer renno2 = o2.getRenno();

        if (!renno1.equals(renno2)) {
            return renno1.compareTo(renno2);
        }
        return 0;
    }
}
