package yuyu.common.siharai.siview.viewshrgoukei;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 保険金給付金支払 支払画面部品 支払合計表示クラス <br />
 */
public class ViewShrGoukeiUiBeanParamImpl implements ViewShrGoukeiUiBeanParam{

    private BizCurrency shrgk;

    private BizCurrency hokenkngkgoukei;

    private BizCurrency haitoukin;

    private BizCurrency sonotahaitoukin;

    private String mikeikapgaitoukkn;

    private BizCurrency mikeikap;

    private String misyuupgaitoukkn;

    private BizCurrency misyuup;

    private BizCurrency zennouseisankgk;

    private BizCurrency azukarikingk;

    private BizCurrency krkgk;

    private BizDate tienrisokukisanymd;

    private Integer tienrsknissuu;

    private BizCurrency shrtienrsk;

    private boolean viewShrGoukeiInfoUmuSeigyo;

    private boolean viewShrGoukeiSeigyo;

    private boolean viewShrGoukeiDispFlg;

    private BizCurrency yenshrgk;

    private BizCurrency yenhkgkgoukei;

    private BizCurrency yenkahaitoukin;

    private BizCurrency yenkasonotahaitoukin;

    private String yenkamikeikapgaitoukkn;

    private BizCurrency yenkamikeikap;

    private String yenkamisyuupgaitoukkn;

    private BizCurrency yenkamisyuup;

    private BizCurrency yenkazennouseisankgk;

    private BizCurrency yenkaazukarikingk;

    private BizCurrency yenkakrkgk;

    private BizDate yentienrisokukisanymd;

    private Integer yentienrsknissuu;

    private BizCurrency yenshrtienrsk;

    private boolean yenGoukeiInfoUmuSeigyo;

    private boolean yenGoukeiSeigyo;

    private boolean yenShrGoukeiDispFlg;

    private boolean yenShrFlg;

    private boolean shrGoukeiHaitoukinDispFlg;

    private boolean shrGoukeiSonotahaitoukinDispFlg;

    private boolean shrGoukeiMikeikapDispFlg;

    private boolean shrGoukeiMisyuupDispFlg;

    private boolean shrGoukeiZennouseisankgkDispFlg;

    private boolean shrGoukeiAzukarikingkDispFlg;

    private boolean shrGoukeiKrkgkDispFlg;

    @Override
    public BizCurrency getShrgk() {
        return shrgk;
    }

    @Override
    public void setShrgk(BizCurrency pShrgk) {
        shrgk = pShrgk;
    }

    @Override
    public BizCurrency getHokenkngkgoukei() {
        return hokenkngkgoukei;
    }

    @Override
    public void setHokenkngkgoukei(BizCurrency pHokenkngkgoukei) {
        hokenkngkgoukei = pHokenkngkgoukei;
    }

    @Override
    public BizCurrency getHaitoukin() {
        return haitoukin;
    }

    @Override
    public void setHaitoukin(BizCurrency pHaitoukin) {
        haitoukin = pHaitoukin;
    }

    @Override
    public BizCurrency getSonotahaitoukin() {
        return sonotahaitoukin;
    }

    @Override
    public void setSonotahaitoukin(BizCurrency pSonotahaitoukin) {
        sonotahaitoukin = pSonotahaitoukin;
    }

    @Override
    public String getMikeikapgaitoukkn() {
        return mikeikapgaitoukkn;
    }

    @Override
    public void setMikeikapgaitoukkn(String pMikeikapgaitoukkn) {
        mikeikapgaitoukkn = pMikeikapgaitoukkn;
    }

    @Override
    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    @Override
    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
    }

    @Override
    public String getMisyuupgaitoukkn() {
        return misyuupgaitoukkn;
    }

    @Override
    public void setMisyuupgaitoukkn(String pMisyuupgaitoukkn) {
        misyuupgaitoukkn = pMisyuupgaitoukkn;
    }

    @Override
    public BizCurrency getMisyuup() {
        return misyuup;
    }

    @Override
    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
    }

    @Override
    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    @Override
    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
    }

    @Override
    public BizCurrency getAzukarikingk() {
        return azukarikingk;
    }

    @Override
    public void setAzukarikingk(BizCurrency pAzukarikingk) {
        azukarikingk = pAzukarikingk;
    }

    @Override
    public BizCurrency getKrkgk() {
        return krkgk;
    }

    @Override
    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
    }


    @Override
    public BizDate getTienrisokukisanymd() {
        return tienrisokukisanymd;
    }

    @Override
    public void setTienrisokukisanymd(BizDate pTienrisokukisanymd) {
        tienrisokukisanymd = pTienrisokukisanymd;
    }

    @Override
    public Integer getTienrsknissuu() {
        return tienrsknissuu;
    }

    @Override
    public void setTienrsknissuu(Integer pTienrsknissuu) {
        tienrsknissuu = pTienrsknissuu;
    }

    @Override
    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    @Override
    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
    }

    @Override
    public boolean isViewShrGoukeiInfoUmuSeigyo() {
        return viewShrGoukeiInfoUmuSeigyo;
    }

    @Override
    public boolean isViewShrGoukeiSeigyo() {
        return viewShrGoukeiSeigyo;
    }

    @Override
    public boolean isViewShrGoukeiDispFlg() {
        return viewShrGoukeiDispFlg;
    }

    @Override
    public BizCurrency getYenshrgk() {
        return yenshrgk;
    }

    @Override
    public void setYenshrgk(BizCurrency pYenshrgk) {
        yenshrgk = pYenshrgk;
    }

    @Override
    public BizCurrency getYenhkgkgoukei() {
        return yenhkgkgoukei;
    }

    @Override
    public void setYenhkgkgoukei(BizCurrency pYenhkgkgoukei) {
        yenhkgkgoukei = pYenhkgkgoukei;
    }

    @Override
    public BizCurrency getYenkahaitoukin() {
        return yenkahaitoukin;
    }

    @Override
    public void setYenkahaitoukin(BizCurrency pYenkahaitoukin) {
        yenkahaitoukin = pYenkahaitoukin;
    }

    @Override
    public BizCurrency getYenkasonotahaitoukin() {
        return yenkasonotahaitoukin;
    }

    @Override
    public void setYenkasonotahaitoukin(BizCurrency pYenkasonotahaitoukin) {
        yenkasonotahaitoukin = pYenkasonotahaitoukin;
    }

    @Override
    public String getYenkamikeikapgaitoukkn() {
        return yenkamikeikapgaitoukkn;
    }

    @Override
    public void setYenkamikeikapgaitoukkn(String pYenkamikeikapgaitoukkn) {
        yenkamikeikapgaitoukkn = pYenkamikeikapgaitoukkn;
    }

    @Override
    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    @Override
    public void setYenkamikeikap(BizCurrency pYenkamikeikap) {
        yenkamikeikap = pYenkamikeikap;
    }

    @Override
    public String getYenkamisyuupgaitoukkn() {
        return yenkamisyuupgaitoukkn;
    }

    @Override
    public void setYenkamisyuupgaitoukkn(String pYenkamisyuupgaitoukkn) {
        yenkamisyuupgaitoukkn = pYenkamisyuupgaitoukkn;
    }

    @Override
    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    @Override
    public void setYenkamisyuup(BizCurrency pYenkamisyuup) {
        yenkamisyuup = pYenkamisyuup;
    }

    @Override
    public BizCurrency getYenkazennouseisankgk() {
        return yenkazennouseisankgk;
    }

    @Override
    public void setYenkazennouseisankgk(BizCurrency pYenkazennouseisankgk) {
        yenkazennouseisankgk = pYenkazennouseisankgk;
    }

    @Override
    public BizCurrency getYenkaazukarikingk() {
        return yenkaazukarikingk;
    }

    @Override
    public void setYenkaazukarikingk(BizCurrency pYenkaazukarikingk) {
        yenkaazukarikingk = pYenkaazukarikingk;
    }

    @Override
    public BizCurrency getYenkakrkgk() {
        return yenkakrkgk;
    }

    @Override
    public void setYenkakrkgk(BizCurrency pYenkakrkgk) {
        yenkakrkgk = pYenkakrkgk;
    }

    @Override
    public BizDate getYentienrisokukisanymd() {
        return yentienrisokukisanymd;
    }

    @Override
    public void setYentienrisokukisanymd(BizDate pYentienrisokukisanymd) {
        yentienrisokukisanymd = pYentienrisokukisanymd;
    }

    @Override
    public Integer getYentienrsknissuu() {
        return yentienrsknissuu;
    }

    @Override
    public void setYentienrsknissuu(Integer pYentienrsknissuu) {
        yentienrsknissuu = pYentienrsknissuu;
    }

    @Override
    public BizCurrency getYenshrtienrsk() {
        return yenshrtienrsk;
    }

    @Override
    public void setYenshrtienrsk(BizCurrency pYenshrtienrsk) {
        yenshrtienrsk = pYenshrtienrsk;
    }

    @Override
    public boolean isYenGoukeiInfoUmuSeigyo() {
        return yenGoukeiInfoUmuSeigyo;
    }

    @Override
    public boolean isYenGoukeiSeigyo() {
        return yenGoukeiSeigyo;
    }

    @Override
    public boolean isYenShrGoukeiDispFlg() {
        return yenShrGoukeiDispFlg;
    }

    @Override
    public boolean isShrGoukeiHaitoukinDispFlg() {
        return shrGoukeiHaitoukinDispFlg;
    }

    @Override
    public boolean isShrGoukeiSonotahaitoukinDispFlg() {
        return shrGoukeiSonotahaitoukinDispFlg;
    }

    @Override
    public boolean isShrGoukeiMikeikapDispFlg() {
        return shrGoukeiMikeikapDispFlg;
    }

    @Override
    public boolean isShrGoukeiMisyuupDispFlg() {
        return shrGoukeiMisyuupDispFlg;
    }

    @Override
    public boolean isShrGoukeiZennouseisankgkDispFlg() {
        return shrGoukeiZennouseisankgkDispFlg;
    }

    @Override
    public boolean isShrGoukeiAzukarikingkDispFlg() {
        return shrGoukeiAzukarikingkDispFlg;
    }

    @Override
    public boolean isShrGoukeiKrkgkDispFlg() {
        return shrGoukeiKrkgkDispFlg;
    }
}
