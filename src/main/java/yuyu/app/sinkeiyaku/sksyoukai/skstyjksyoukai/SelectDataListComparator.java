package yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai;

import java.util.Comparator;

/**
 * 選択データリストソート処理用クラス
 */
public class SelectDataListComparator implements Comparator<SearchResultsDataSourceBean> {

    public static final String DATE_INIT  = "00000000000000";

    @Override
    public int compare(SearchResultsDataSourceBean pDataSourceBeanLst1, SearchResultsDataSourceBean pDataSourceBeanLst2) {

        String dispJimustartymdTime1 = pDataSourceBeanLst1.getDispjimustartymdtime();
        String dispJimustartymdTime2 = pDataSourceBeanLst2.getDispjimustartymdtime();

        String dispmosNo1 = pDataSourceBeanLst1.getDispmosno();
        String dispmosNo2 = pDataSourceBeanLst2.getDispmosno();

        if (dispJimustartymdTime1 == null) {
            dispJimustartymdTime1 = DATE_INIT;
        }

        if (dispJimustartymdTime2 == null) {
            dispJimustartymdTime2 = DATE_INIT;
        }


        if (dispmosNo1 == null) {
            dispmosNo1 = "";
        }

        if (dispmosNo2 == null) {
            dispmosNo2 = "";
        }

        if (!dispJimustartymdTime1.equals(dispJimustartymdTime2)) {
            return dispJimustartymdTime1.compareTo(dispJimustartymdTime2);
        }

        return dispmosNo1.compareTo(dispmosNo2);
    }
}
