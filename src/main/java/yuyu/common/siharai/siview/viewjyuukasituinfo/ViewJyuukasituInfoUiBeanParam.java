package yuyu.common.siharai.siview.viewjyuukasituinfo;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 重過失情報表示 <br />
 */
public interface ViewJyuukasituInfoUiBeanParam extends CommonViewUiBeanParam {

    public Boolean getJuukasitucheck1();

    public void setJuukasitucheck1(Boolean pJuukasitucheck1);

    public String getJuukasitucheckcomment1();

    public void setJuukasitucheckcomment1(String pJuukasitucheckcomment1);

    public Boolean getJuukasitucheck2();

    public void setJuukasitucheck2(Boolean pJuukasitucheck2);

    public String getJuukasitucheckcomment2();

    public void setJuukasitucheckcomment2(String pJuukasitucheckcomment2);

    public Boolean getJuukasitucheck3();

    public void setJuukasitucheck3(Boolean pJuukasitucheck3);

    public String getJuukasitucheckcomment3();

    public void setJuukasitucheckcomment3(String pJuukasitucheckcomment3);

    public Boolean getJuukasitucheck4();

    public void setJuukasitucheck4(Boolean pJuukasitucheck4);

    public String getJuukasitucheckcomment4();

    public void setJuukasitucheckcomment4(String pJuukasitucheckcomment4);

    public boolean isViewJyuukasituInfoFlg();

    public boolean isViewJyuukasituInfoSeigyo();

    public boolean isViewJyuukasituInfoDispFlg();

    public boolean isViewJyuukasituInfoInputDispFlg();
}
