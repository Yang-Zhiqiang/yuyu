package yuyu.common.siharai.siview.viewuketorininsb;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_UktKbn;

/**
 * 保険金給付金支払 支払画面部品 死亡保険金受取人情報表示 <br />
 */
public interface ViewUketorininSBUiBeanParam extends CommonViewUiBeanParam {

    public boolean isViewUketorininsbSeigyo();

    public boolean isSbuktninHyojiHantei();

    public Integer getSbuktnin();

    public void setSbuktnin(Integer pSbuktnin);

    public C_UktKbn getDispsbuktkbn1();

    public void setDispsbuktkbn1(C_UktKbn pDispsbuktkbn1);

    public String getDispsbuktnmkn1();

    public void setDispsbuktnmkn1(String pDispsbuktnmkn1);

    public String getDispsbuktnmkj1();

    public void setDispsbuktnmkj1(String pDispsbuktnmkj1);

    public BizDate getDispsbuktseiymd1();

    public void setDispsbuktseiymd1(BizDate pDispsbuktseiymd1);

    public String getDispmskmjskjuktnen1();

    public void setDispmskmjskjuktnen1(String pDispmskmjskjuktnen1);

    public BizNumber getDispsbuktbnwari1();

    public void setDispsbuktbnwari1(BizNumber pDispsbuktbnwari1);

    public C_UktKbn getDispsbuktkbn2();

    public void setDispsbuktkbn2(C_UktKbn pDispsbuktkbn2);

    public String getDispsbuktnmkn2();

    public void setDispsbuktnmkn2(String pDispsbuktnmkn2);

    public String getDispsbuktnmkj2();

    public void setDispsbuktnmkj2(String pDispsbuktnmkj2);

    public BizDate getDispsbuktseiymd2();

    public void setDispsbuktseiymd2(BizDate pDispsbuktseiymd2);

    public String getDispmskmjskjuktnen2();

    public void setDispmskmjskjuktnen2(String pDispmskmjskjuktnen2);

    public BizNumber getDispsbuktbnwari2();

    public void setDispsbuktbnwari2(BizNumber pDispsbuktbnwari2);

    public C_UktKbn getDispsbuktkbn3();

    public void setDispsbuktkbn3(C_UktKbn pDispsbuktkbn3);

    public String getDispsbuktnmkn3();

    public void setDispsbuktnmkn3(String pDispsbuktnmkn3);

    public String getDispsbuktnmkj3();

    public void setDispsbuktnmkj3(String pDispsbuktnmkj3);

    public BizDate getDispsbuktseiymd3();

    public void setDispsbuktseiymd3(BizDate pDispsbuktseiymd3);

    public String getDispmskmjskjuktnen3();

    public void setDispmskmjskjuktnen3(String pDispmskmjskjuktnen3);

    public BizNumber getDispsbuktbnwari3();

    public void setDispsbuktbnwari3(BizNumber pDispsbuktbnwari3);

    public C_UktKbn getDispsbuktkbn4();

    public void setDispsbuktkbn4(C_UktKbn pDispsbuktkbn4);

    public String getDispsbuktnmkn4();

    public void setDispsbuktnmkn4(String pDispsbuktnmkn4);

    public String getDispsbuktnmkj4();

    public void setDispsbuktnmkj4(String pDispsbuktnmkj4);

    public BizDate getDispsbuktseiymd4();

    public void setDispsbuktseiymd4(BizDate pDispsbuktseiymd4);

    public String getDispmskmjskjuktnen4();

    public void setDispmskmjskjuktnen4(String pDispmskmjskjuktnen4);

    public BizNumber getDispsbuktbnwari4();

    public void setDispsbuktbnwari4(BizNumber pDispsbuktbnwari4);
}
