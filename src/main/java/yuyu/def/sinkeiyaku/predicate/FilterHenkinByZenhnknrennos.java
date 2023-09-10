package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 全額返金連番（一致）
 */
public class FilterHenkinByZenhnknrennos implements Predicate<HT_Henkin>{

    Integer[] zenhnknrenno;

    public FilterHenkinByZenhnknrennos(Integer... pZenhnknrenno){
        super();

        zenhnknrenno = pZenhnknrenno;
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {

        for (Integer zenhnknrennoTemp: zenhnknrenno) {

            if (zenhnknrennoTemp.equals(pHenkin.getZenhnknrenno())) {

                return true;
            }
        }
        return false;
    }
}
