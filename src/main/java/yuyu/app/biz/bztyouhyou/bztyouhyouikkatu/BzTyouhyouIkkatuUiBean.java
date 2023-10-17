package yuyu.app.biz.bztyouhyou.bztyouhyouikkatu;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 帳票一括出力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzTyouhyouIkkatuUiBean extends GenBzTyouhyouIkkatuUiBean {

    private static final long serialVersionUID = 1L;

    private C_SyoruiCdKbn syoruiCd;

    private String kensakuNm1;

    private String kensakuNm2;

    private String kensakuNm3;

    private String kensakuNm4;

    private String kensakuNm5;

    private String[] roleCds;

    public BzTyouhyouIkkatuUiBean() {
    }

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }


    public String getKensakuNm1() {
        return kensakuNm1;
    }


    public void setKensakuNm1(String pKensakuNm1) {
        kensakuNm1 = pKensakuNm1;
    }


    public String getKensakuNm2() {
        return kensakuNm2;
    }


    public void setKensakuNm2(String pKensakuNm2) {
        kensakuNm2 = pKensakuNm2;
    }


    public String getKensakuNm3() {
        return kensakuNm3;
    }


    public void setKensakuNm3(String pKensakuNm3) {
        kensakuNm3 = pKensakuNm3;
    }


    public String getKensakuNm4() {
        return kensakuNm4;
    }


    public void setKensakuNm4(String pKensakuNm4) {
        kensakuNm4 = pKensakuNm4;
    }


    public String getKensakuNm5() {
        return kensakuNm5;
    }


    public void setKensakuNm5(String pKensakuNm5) {
        kensakuNm5 = pKensakuNm5;
    }

    public String[] getRoleCds() {
        return roleCds;
    }

    public void setRoleCds(String[] pRoleCds) {
        roleCds = pRoleCds;
    }

}
