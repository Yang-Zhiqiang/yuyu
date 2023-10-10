package yuyu.app.hozen.khozen.khgengaku;

import yuyu.def.classification.C_KahiKbn;

/**
 * 契約保全 契約保全 減額可否区分内部Bean
 */
public class GengakuKahiKbnBean {

    private int gengakukahikbn;

    private C_KahiKbn pgengakukahikbn;

    public int getGengakukahikbn() {
        return gengakukahikbn;
    }

    public void setGengakukahikbn(int pGengakukahikbn) {
        this.gengakukahikbn = pGengakukahikbn;
    }

    public C_KahiKbn getPgengakukahikbn() {
        return pgengakukahikbn;
    }

    public void setPgengakukahikbn(C_KahiKbn pPgengakukahikbn) {
        this.pgengakukahikbn = pPgengakukahikbn;
    }
}
