package yuyu.common.biz.syoruiitiran;

import yuyu.def.classification.C_HtysyoruiumuKbn;

/**
 * 業務共通 書類情報一覧 書類情報一覧設定Commonパラメータ
 */
public interface SyoruiInfoItiranDataSourceBeanCommonParam {

    String getSyoruittykymdtime();

    void setSyoruittykymdtime(String pSyoruittykymdtime);

    String getSyoruinm();

    void setSyoruinm(String pSyoruinm);

    C_HtysyoruiumuKbn getHtysyoruiumukbn();

    void setHtysyoruiumukbn(C_HtysyoruiumuKbn pHtysyoruiumukbn);

    String getHyoujilink();

    void setHyoujilink(String pHyoujilink);

    String getHyoujilinkflg();

    void setHyoujilinkflg(String pHyoujilinkflg);

    String getImageid();

    void setImageid(String pImageid);

    String getTorikomiSyoruiCd();

    void setTorikomiSyoruiCd(String pTorikomiSyoruiCd);

}
