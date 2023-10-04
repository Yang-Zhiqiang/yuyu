package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks;

import java.io.Serializable;

/**
 * 突合せＮＧ件数管理Beanクラスです。<br />
 */
public class TukiawaseNgkensuuKanriBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int tukiawaseUriageseikyuuMijissiCheckNgKensuu;

    private int tukiawaseTajyuujyusinCheckNgKensuu;

    private int tukiawaseKekkadataMijyusinCheckNgKensuu;

    public int getTukiawaseUriageseikyuuMijissiCheckNgKensuu() {
        return tukiawaseUriageseikyuuMijissiCheckNgKensuu;
    }

    public void setTukiawaseUriageseikyuuMijissiCheckNgKensuu(int pTukiawaseUriageseikyuuMijissiCheckNgKensuu) {
        this.tukiawaseUriageseikyuuMijissiCheckNgKensuu = pTukiawaseUriageseikyuuMijissiCheckNgKensuu;
    }

    public int getTukiawaseTajyuujyusinCheckNgKensuu() {
        return tukiawaseTajyuujyusinCheckNgKensuu;
    }

    public void setTukiawaseTajyuujyusinCheckNgKensuu(int pTukiawaseTajyuujyusinCheckNgKensuu) {
        this.tukiawaseTajyuujyusinCheckNgKensuu = pTukiawaseTajyuujyusinCheckNgKensuu;
    }

    public int getTukiawaseKekkadataMijyusinCheckNgKensuu() {
        return tukiawaseKekkadataMijyusinCheckNgKensuu;
    }

    public void setTukiawaseKekkadataMijyusinCheckNgKensuu(int pTukiawaseKekkadataMijyusinCheckNgKensuu) {
        this.tukiawaseKekkadataMijyusinCheckNgKensuu = pTukiawaseKekkadataMijyusinCheckNgKensuu;
    }
}
