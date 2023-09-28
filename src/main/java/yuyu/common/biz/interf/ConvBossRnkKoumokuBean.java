package yuyu.common.biz.interf;

import java.io.Serializable;

/**
 * 業務共通 インターフェイス ＢＯＳＳ連携用項目変換Beanクラス
 */
public class ConvBossRnkKoumokuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syuunouKeiroKbn;

    private String syouhinBunruiKbn;

    private String  syouhnNmKbn;

    public ConvBossRnkKoumokuBean() {
        super();
    }

    public String getSyuunouKeiroKbn() {
        return syuunouKeiroKbn;
    }

    public void setSyuunouKeiroKbn(String pSyuunouKeiroKbn) {
        syuunouKeiroKbn = pSyuunouKeiroKbn;
    }

    public String getSyouhinBunruiKbn() {
        return syouhinBunruiKbn;
    }

    public void setSyouhinBunruiKbn(String pSyouhinBunruiKbn) {
        syouhinBunruiKbn = pSyouhinBunruiKbn;
    }

    public String getSyouhnNmKbn() {
        return syouhnNmKbn;
    }

    public void setSyouhnNmKbn(String pSyouhnNmKbn) {
        syouhnNmKbn = pSyouhnNmKbn;
    }
}
