package yuyu.app.base.system.kinouteigitouroku;

import java.util.Comparator;

import yuyu.def.db.entity.AS_Kinou;

/**
 * 機能情報複雑ソート処理用クラス
 */
public class KinouInfoSortComparator implements Comparator<AS_Kinou> {

    @Override
    public int compare(AS_Kinou arg0, AS_Kinou arg1) {

        if (arg0.getSubSystemId().compareTo(arg1.getSubSystemId()) == 1) {
            return 1;
        }
        else if (arg0.getSubSystemId().compareTo(arg1.getSubSystemId()) == 0) {
            if (arg0.getCategoryId().compareTo(arg1.getCategoryId()) == 1) {
                return 1;
            }
            else if (arg0.getCategoryId().compareTo(arg1.getCategoryId()) == 0) {
                if (arg0.getKinouId().compareTo(arg1.getKinouId()) == 1) {
                    return 1;
                }
                else if (arg0.getKinouId().compareTo(arg1.getKinouId()) == 0) {
                    return 0;
                }
                else {
                    return -1;
                }
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }
}
