package yuyu.def.report;


import java.io.Serializable;


/**
 * Bean項目定義 ミスリストBean
 */


public class KhMisslistBean implements Serializable {

    private String syoriymd;

    private int kensuu;

    private String kinounm;

    private String hozonkkn;

    private String tyouhyousakuseiymd;

    public String getSyoriymd(){
        return syoriymd;
    }

    public void setSyoriymd(String pSyoriymd){
        syoriymd = pSyoriymd;
    }

    public int getKensuu(){
        return kensuu;
    }

    public void setKensuu(int pKensuu){
        kensuu = pKensuu;
    }

    public String getKinounm(){
        return kinounm;
    }

    public void setKinounm(String pKinounm){
        kinounm = pKinounm;
    }

    public String getHozonkkn(){
        return hozonkkn;
    }

    public void setHozonkkn(String pHozonkkn){
        hozonkkn = pHozonkkn;
    }

    public String getTyouhyousakuseiymd(){
        return tyouhyousakuseiymd;
    }

    public void setTyouhyousakuseiymd(String pTyouhyousakuseiymd){
        tyouhyousakuseiymd = pTyouhyousakuseiymd;
    }


}
