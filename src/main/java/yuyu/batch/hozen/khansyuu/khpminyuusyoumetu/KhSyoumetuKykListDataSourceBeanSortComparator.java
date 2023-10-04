package yuyu.batch.hozen.khansyuu.khpminyuusyoumetu;

import java.util.Comparator;

import yuyu.def.hozen.bean.report.KhSyoumetuKykListDataSourceBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * 【Ｐ未入消滅処理】KhSyoumetuKykListDataSourceBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛（ＩＲ）消滅日の昇順、（ＩＲ）証券番号の昇順｝です。
 * @author  魏　瓊
 * @version 2019/05/28 魏　瓊 : 新規作成<br />
 */
public class KhSyoumetuKykListDataSourceBeanSortComparator implements Comparator<IReportDataSouceBean> {

    /**
     * 比較メソッド
     */
    @Override
    public int compare(IReportDataSouceBean o1, IReportDataSouceBean o2) {

        KhSyoumetuKykListDataSourceBean impl1 = (KhSyoumetuKykListDataSourceBean)o1;
        KhSyoumetuKykListDataSourceBean impl2 = (KhSyoumetuKykListDataSourceBean)o2;

        // （ＩＲ）消滅日
        String irSyoumetuYmd1 = impl1.getIrSyoumetuymd() == null ? "" : impl1.getIrSyoumetuymd();
        String irSyoumetuYmd2 = impl2.getIrSyoumetuymd() == null ? "" : impl2.getIrSyoumetuymd();

        // （ＩＲ）証券番号
        String syoNo1 =impl1.getIrSyono() == null ? "" : impl1.getIrSyono();
        String syoNo2 =impl2.getIrSyono() == null ? "" : impl2.getIrSyono();

        int cmpret = 0;

        // （ＩＲ）消滅日によるソート
        if (!irSyoumetuYmd1.equals(irSyoumetuYmd2)) {

            // いずれかがブランクの場合、ブランク側を小さいものとする
            if ("".equals(irSyoumetuYmd1)) {
                return -1;
            }

            if ("".equals(irSyoumetuYmd2)) {
                return 1;
            }

            // ASC（昇順）なので計算対象を逆転
            cmpret =  irSyoumetuYmd1.compareTo(irSyoumetuYmd2);
        }
        // 処理コードが一致（NULL同士も含む）している場合
        else {

            // 証券番号によるソート
            if (!syoNo1.equals(syoNo2)) {

                // いずれかがブランクの場合、ブランク側を小さいものとする
                if ("".equals(syoNo1)) {
                    return -1;
                }

                if ("".equals(syoNo2)) {
                    return 1;
                }

                // ASC（昇順）なので計算対象を逆転
                cmpret =  syoNo1.compareTo(syoNo2);
            }
        }

        return cmpret;
    }
}
