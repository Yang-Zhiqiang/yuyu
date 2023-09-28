package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_SosikiNmKbn;

/**
 * 業務共通 共通 操作者所属組織情報取得Beanクラス
 */
public class BzGetSousasyaSyozokuSosikiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sosikicd;

    private C_SosikiNmKbn sosikinmkbn;

    private String sosikinm20;

    private String kanjisosikinm20;

    public String getSosikicd(){
        return sosikicd;
    }

    public void setSosikicd(String pSosikicd){
        sosikicd = pSosikicd;
    }

    public C_SosikiNmKbn getSosikinmkbn(){
        return sosikinmkbn;
    }

    public void setSosikinmkbn(C_SosikiNmKbn pSosikinmkbn){
        sosikinmkbn = pSosikinmkbn;
    }

    public String getSosikinm20(){
        return sosikinm20;
    }

    public void setSosikinm20(String pSosikinm20){
        sosikinm20 = pSosikinm20;
    }

    public String getKanjisosikinm20(){
        return kanjisosikinm20;
    }

    public void setKanjisosikinm20(String pKanjisosikinm20){
        kanjisosikinm20 = pKanjisosikinm20;
    }

}
