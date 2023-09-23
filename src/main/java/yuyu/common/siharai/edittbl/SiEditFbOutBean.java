package yuyu.common.siharai.edittbl;

import java.io.Serializable;
import java.util.List;

import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;

/**
 * 保険金給付金ＦＢ送金データテーブル編集結果Bean
 */
public class SiEditFbOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<JT_SiFBSoukinData> siFBSoukinDataLst;

    private List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst;

    public SiEditFbOutBean() {
        super();
    }

    public List<JT_SiFBSoukinData> getSiFBSoukinDataLst() {
        return siFBSoukinDataLst;
    }

    public void setSiFBSoukinDataLst(List<JT_SiFBSoukinData> pSiFBSoukinDataLst) {
        siFBSoukinDataLst = pSiFBSoukinDataLst;
    }

    public List<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDataLst() {
        return siGaikaFBSoukinDataLst;
    }

    public void setSiGaikaFBSoukinDataLst(List<JT_SiGaikaFBSoukinData> pSiGaikaFBSoukinDataLst) {
        siGaikaFBSoukinDataLst = pSiGaikaFBSoukinDataLst;
    }

}
