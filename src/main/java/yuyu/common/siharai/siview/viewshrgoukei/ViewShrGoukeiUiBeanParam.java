package yuyu.common.siharai.siview.viewshrgoukei;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 支払合計表示 <br />
 */
public interface ViewShrGoukeiUiBeanParam extends CommonViewUiBeanParam {

    public BizCurrency getShrgk();

    public void setShrgk(BizCurrency pShrgk);

    public BizCurrency getHokenkngkgoukei();

    public void setHokenkngkgoukei(BizCurrency pHokenkngkgoukei);

    public BizCurrency getHaitoukin();

    public void setHaitoukin(BizCurrency pHaitoukin);

    public BizCurrency getSonotahaitoukin();

    public void setSonotahaitoukin(BizCurrency pSonotahaitoukin);

    public String getMikeikapgaitoukkn();

    public void setMikeikapgaitoukkn(String pMikeikapgaitoukkn);

    public BizCurrency getMikeikap();

    public void setMikeikap(BizCurrency pMikeikap);

    public String getMisyuupgaitoukkn();

    public void setMisyuupgaitoukkn(String pMisyuupgaitoukkn);

    public BizCurrency getMisyuup();

    public void setMisyuup(BizCurrency pMisyuup);

    public BizCurrency getZennouseisankgk();

    public void setZennouseisankgk(BizCurrency pZennouseisankgk);

    public BizCurrency getAzukarikingk();

    public void setAzukarikingk(BizCurrency pAzukarikingk);

    public BizCurrency getKrkgk();

    public void setKrkgk(BizCurrency pKrkgk);

    public BizDate getTienrisokukisanymd();

    public void setTienrisokukisanymd(BizDate pTienrisokukisanymd);

    public Integer getTienrsknissuu();

    public void setTienrsknissuu(Integer pTienrsknissuu);

    public BizCurrency getShrtienrsk();

    public void setShrtienrsk(BizCurrency pShrtienrsk);

    public boolean isViewShrGoukeiInfoUmuSeigyo();

    public boolean isViewShrGoukeiSeigyo();

    public boolean isViewShrGoukeiDispFlg();

    public BizCurrency getYenshrgk();

    public void setYenshrgk(BizCurrency pYenshrgk);

    public BizCurrency getYenhkgkgoukei();

    public void setYenhkgkgoukei(BizCurrency pYenhkgkgoukei);

    public BizCurrency getYenkahaitoukin();

    public void setYenkahaitoukin(BizCurrency pYenkahaitoukin);

    public BizCurrency getYenkasonotahaitoukin();

    public void setYenkasonotahaitoukin(BizCurrency pYenkasonotahaitoukin);

    public String getYenkamikeikapgaitoukkn();

    public void setYenkamikeikapgaitoukkn(String pYenkamikeikapgaitoukkn);

    public BizCurrency getYenkamikeikap();

    public void setYenkamikeikap(BizCurrency pYenkamikeikap);

    public String getYenkamisyuupgaitoukkn();

    public void setYenkamisyuupgaitoukkn(String pYenkamisyuupgaitoukkn);

    public BizCurrency getYenkamisyuup();

    public void setYenkamisyuup(BizCurrency pYenkamisyuup);

    public BizCurrency getYenkazennouseisankgk();

    public void setYenkazennouseisankgk(BizCurrency pYenkazennouseisankgk);

    public BizCurrency getYenkaazukarikingk();

    public void setYenkaazukarikingk(BizCurrency pYenkaazukarikingk);

    public BizCurrency getYenkakrkgk();

    public void setYenkakrkgk(BizCurrency pYenkakrkgk);

    public BizDate getYentienrisokukisanymd();

    public void setYentienrisokukisanymd(BizDate pYentienrisokukisanymd);

    public Integer getYentienrsknissuu();

    public void setYentienrsknissuu(Integer pYentienrsknissuu);

    public BizCurrency getYenshrtienrsk();

    public void setYenshrtienrsk(BizCurrency pYenshrtienrsk);

    public boolean isYenGoukeiInfoUmuSeigyo();

    public boolean isYenGoukeiSeigyo();

    public boolean isYenShrGoukeiDispFlg();

    public boolean isShrGoukeiHaitoukinDispFlg();

    public boolean isShrGoukeiSonotahaitoukinDispFlg();

    public boolean isShrGoukeiMikeikapDispFlg();

    public boolean isShrGoukeiMisyuupDispFlg();

    public boolean isShrGoukeiZennouseisankgkDispFlg();

    public boolean isShrGoukeiAzukarikingkDispFlg();

    public boolean isShrGoukeiKrkgkDispFlg();
}
