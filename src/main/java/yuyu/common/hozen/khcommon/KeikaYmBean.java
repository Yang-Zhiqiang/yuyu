package yuyu.common.hozen.khcommon;

import java.io.Serializable;

/**
 * 契約保全 契約保全共通 経過年月内部Bean
 */
public class KeikaYmBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int keikanensuu;

    private int keikamon;

    public int getKeikanensuu() {
        return keikanensuu;
    }

    public void setKeikanensuu(int pKeikanensuu) {
        keikanensuu = pKeikanensuu;
    }

    public int getKeikamon() {
        return keikamon;
    }

    public void setKeikamon(int pKeikamon) {
        keikamon = pKeikamon;
    }
}
