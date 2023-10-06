package yuyu.batch.biz.bzkaikei.bzfbsoukinlistsks;

import java.io.Serializable;

import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;

/**
 * ＦＢ送金リスト用データBEAN（宛先不明）クラスです<br />
 */
public class BzFBSoukinDataAtesakiHumeiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BT_FBSoukinData btFBSoukinDataAtesakiHumei_;

    public BT_FBSoukinData getFBSoukinDataAtesakiHumei() {
        return btFBSoukinDataAtesakiHumei_;
    }

    public void setFBSoukinDataAtesakiHumei(BT_FBSoukinData pbtFBSoukinDataAtesakiHumei) {
        btFBSoukinDataAtesakiHumei_ = pbtFBSoukinDataAtesakiHumei;
    }

    private BT_FBSoukinHukaInfo btFBSoukinHukaInfoAtesakiHumei_;

    public BT_FBSoukinHukaInfo getFBSoukinHukaInfoAtesakiHumei() {
        return btFBSoukinHukaInfoAtesakiHumei_;
    }

    public void setFBSoukinHukaInfoAtesakiHumei(BT_FBSoukinHukaInfo pbtFBSoukinHukaInfoAtesakiHumei) {
        btFBSoukinHukaInfoAtesakiHumei_ = pbtFBSoukinHukaInfoAtesakiHumei;
    }

    private BM_FBSoukinListKanri bmFBSoukinListKanriAtesakiHumei_;

    public BM_FBSoukinListKanri getFBSoukinListKanriAtesakiHumei() {
        return bmFBSoukinListKanriAtesakiHumei_;
    }

    public void setFBSoukinListKanriAtesakiHumei(BM_FBSoukinListKanri pbmFBSoukinListKanriAtesakiHumei) {
        bmFBSoukinListKanriAtesakiHumei_ = pbmFBSoukinListKanriAtesakiHumei;
    }

    private String syoriSosikiCd_;

    public String getSyoriSosikiCd() {
        return syoriSosikiCd_;
    }

    public void setSyoriSosikiCd(String psyoriSosikiCd) {
        syoriSosikiCd_ = psyoriSosikiCd;
    }

    private BzFBSoukinDataAtesakiHumeiBean bzFBSoukinDataAtesakiHumeiBean;

    public BzFBSoukinDataAtesakiHumeiBean getFBSoukinDataAtesakiHumeiBean() {
        return bzFBSoukinDataAtesakiHumeiBean;
    }

    public void setFBSoukinDataAtesakiHumeiBean(BzFBSoukinDataAtesakiHumeiBean pbzFBSoukinDataAtesakiHumeiBean) {
        bzFBSoukinDataAtesakiHumeiBean = pbzFBSoukinDataAtesakiHumeiBean;
    }

    private String soukinHukaBank_;

    public String getSoukinHukaBank() {
        return soukinHukaBank_;
    }

    public void setSoukinHukaBank(String pSoukinHukaBank) {
        soukinHukaBank_ = pSoukinHukaBank;
    }

}
