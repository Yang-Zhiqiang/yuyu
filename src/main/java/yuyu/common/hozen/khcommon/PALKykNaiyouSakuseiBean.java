package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 契約保全共通 ＰＡＬ契約内容作成与件Beanクラス
 */
public class PALKykNaiyouSakuseiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private IT_KykKihon kykKihon;

    public void setKykKihon(IT_KykKihon pKykKihon) {
        this.kykKihon = pKykKihon;
    }

    public IT_KykKihon getKykKihon() {
        return this.kykKihon;
    }

}
