package yuyu.common.biz.bzcommon;

import java.io.Serializable;
import java.util.List;

import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.entity.BM_YoteiRiritu3;

/**
 * 業務共通 共通 マスタ取込利率設定処理Bean
 */
public class BzSetMasterTorikomiRirituBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<BM_YoteiRiritu3> yoteiRirituList;

    private List<BM_SjkkkTyouseiyouRiritu2> sjkkkTyouseiyouRirituList;

    public List<BM_YoteiRiritu3> getYoteiRirituList() {
        return yoteiRirituList;
    }

    public void setYoteiRirituList(List<BM_YoteiRiritu3> pYoteiRirituList) {
        this.yoteiRirituList = pYoteiRirituList;
    }

    public List<BM_SjkkkTyouseiyouRiritu2> getSjkkkTyouseiyouRirituList() {
        return sjkkkTyouseiyouRirituList;
    }

    public void setSjkkkTyouseiyouRirituList(List<BM_SjkkkTyouseiyouRiritu2> pSjkkkTyouseiyouRirituList) {
        this.sjkkkTyouseiyouRirituList = pSjkkkTyouseiyouRirituList;
    }


}