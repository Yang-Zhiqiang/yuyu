package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;

/**
 * 契約保全 契約保全共通 案内収納用注意情報設定Bean
 */
public class AnsyuuSetTetudukityuuiInfoBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private C_KktyuitaKbn kktyuitaKbn;

    private C_KykdrknHtdjytKbn kykdrknhatudoujyoutaiKbn;

    public AnsyuuSetTetudukityuuiInfoBean () {

        this.kktyuitaKbn = C_KktyuitaKbn.BLNK;
        this.kykdrknhatudoujyoutaiKbn = C_KykdrknHtdjytKbn.BLNK;
    }

    public C_KktyuitaKbn getKktyuitaKbn() {
        return kktyuitaKbn;
    }

    public void setKktyuitaKbn(C_KktyuitaKbn pKktyuitakbn) {
        this.kktyuitaKbn = pKktyuitakbn;
    }

    public C_KykdrknHtdjytKbn getKykdrknhatudoujyoutaiKbn() {
        return kykdrknhatudoujyoutaiKbn;
    }

    public void setKykdrknhatudoujyoutaiKbn(C_KykdrknHtdjytKbn pKykdrknhatudoujyoutai) {
        this.kykdrknhatudoujyoutaiKbn = pKykdrknhatudoujyoutai;
    }
}
