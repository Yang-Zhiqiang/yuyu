package yuyu.def.bosyuu.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * bosyuuパッケージ用 システム情報格納部品です。<br />
 * このソースはツールにより自動生成されたものです。業務静的定義に変更があると上書きされてしまいます。
 */
public class GenYuyuBosyuuConfig {

    public GenYuyuBosyuuConfig() {
    }

    private List<String> syoukaiKanouDrtnCdList = new ArrayList<>();

    public List<String> getSyoukaiKanouDrtnCdList() {
        return Collections.unmodifiableList(syoukaiKanouDrtnCdList);
    }

    public void addSyoukaiKanouDrtnCd(String pSyoukaiKanouDrtnCd) {
        syoukaiKanouDrtnCdList.add(pSyoukaiKanouDrtnCd);
    }

    private List<HbSyanaiuserTokusyudrtenBean> hbSyanaiuserTokusyudrtenBeanList = new ArrayList<>();

    public List<HbSyanaiuserTokusyudrtenBean> getHbSyanaiuserTokusyudrtenBeanList() {
        return Collections.unmodifiableList(hbSyanaiuserTokusyudrtenBeanList);
    }

    public void addHbSyanaiuserTokusyudrtenBean(HbSyanaiuserTokusyudrtenBean pHbSyanaiuserTokusyudrtenBean) {
        hbSyanaiuserTokusyudrtenBeanList.add(pHbSyanaiuserTokusyudrtenBean);
    }
}
