package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;
import java.util.List;

import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;

/**
 * 新契約 新契約共通 返金出力Bean
 */
public class HenkinOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<HT_SkDenpyoData> skDenpyoDataList;

    private List<HT_SkFBSoukinData> skFBSoukinDataList;

    private List<HT_SkGaikaFBSoukinData> skGaikaFBSoukinDataList;

    public List<HT_SkDenpyoData> getSkDenpyoDataList() {
        return skDenpyoDataList;
    }

    public void setSkDenpyoDataList(List<HT_SkDenpyoData> pSkDenpyoDataList) {
        this.skDenpyoDataList = pSkDenpyoDataList;
    }

    public List<HT_SkFBSoukinData> getSkFBSoukinDataList() {
        return skFBSoukinDataList;
    }

    public void setSkFBSoukinDataList(List<HT_SkFBSoukinData> pSkFBSoukinDataList) {
        this.skFBSoukinDataList = pSkFBSoukinDataList;
    }

    public List<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDataList() {
        return skGaikaFBSoukinDataList;
    }

    public void setSkGaikaFBSoukinDataList(List<HT_SkGaikaFBSoukinData> pSkGaikaFBSoukinDataList) {
        this.skGaikaFBSoukinDataList = pSkGaikaFBSoukinDataList;
    }
}