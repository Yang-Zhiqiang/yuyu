package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 全額返金連番（一致）
 */
public class FilterNyuukinByZenhnknrennos implements Predicate<HT_Nyuukin>{

    Integer[] zenhnknrenno;

    public FilterNyuukinByZenhnknrennos(Integer... pZenhnknrenno){
        super();

        zenhnknrenno = pZenhnknrenno;
    }

    @Override
    public boolean apply(HT_Nyuukin pNyuukin) {

        for (Integer zenhnknrennoTemp: zenhnknrenno) {

            if (zenhnknrennoTemp.equals(pNyuukin.getZenhnknrenno())) {

                return true;
            }
        }
        return false;
    }
}
