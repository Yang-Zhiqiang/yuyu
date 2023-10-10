package yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii;

import jp.co.slcs.swak.number.BizNumber;

/**
 * 解約返戻金Beanクラスです。<br />
 */
public class KaiyakuHenreiKinBean {

    public KaiyakuHenreiKinBean() {
    }

    private int keikaNensuu;

    private BizNumber kaiyakuHenreikinSame;

    private BizNumber tumitatekinSame;

    private BizNumber kaiyakuHenreikinUp;

    private BizNumber tumitatekinUp;

    private BizNumber kaiyakuHenreikinDown;

    private BizNumber tumitatekinDown;

    public int getKeikaNensuu() {
        return keikaNensuu;
    }

    public void setKeikaNensuu(int pKeikaNensuu) {
        keikaNensuu = pKeikaNensuu;
    }

    public BizNumber getKaiyakuHenreikinSame() {
        return kaiyakuHenreikinSame;
    }

    public void setKaiyakuHenreikinSame(BizNumber pKaiyakuHenreikinSame) {
        kaiyakuHenreikinSame = pKaiyakuHenreikinSame;
    }

    public BizNumber getTumitatekinSame() {
        return tumitatekinSame;
    }

    public void setTumitatekinSame(BizNumber pTumitatekinSame) {
        tumitatekinSame = pTumitatekinSame;
    }

    public BizNumber getKaiyakuHenreikinUp() {
        return kaiyakuHenreikinUp;
    }

    public void setKaiyakuHenreikinUp(BizNumber pKaiyakuHenreikinUp) {
        kaiyakuHenreikinUp = pKaiyakuHenreikinUp;
    }

    public BizNumber getTumitatekinUp() {
        return tumitatekinUp;
    }

    public void setTumitatekinUp(BizNumber pTumitatekinUp) {
        tumitatekinUp = pTumitatekinUp;
    }

    public BizNumber getKaiyakuHenreikinDown() {
        return kaiyakuHenreikinDown;
    }

    public void setKaiyakuHenreikinDown(BizNumber pKaiyakuHenreikinDown) {
        kaiyakuHenreikinDown = pKaiyakuHenreikinDown;
    }

    public BizNumber getTumitatekinDown() {
        return tumitatekinDown;
    }

    public void setTumitatekinDown(BizNumber pTumitatekinDown) {
        tumitatekinDown = pTumitatekinDown;
    }

}