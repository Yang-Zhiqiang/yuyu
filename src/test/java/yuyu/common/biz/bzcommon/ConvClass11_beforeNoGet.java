package yuyu.common.biz.bzcommon;

import javax.persistence.Column;

import yuyu.def.db.mapping.GenZT_HonsyaToukeiTy;

public class ConvClass11_beforeNoGet {

    public String ztykojincd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKOJINCD)
    public String getZtykojincd() {
        return ztykojincd;
    }

    //    public void setZtykojincd(String pZtykojincd) {
    //        ztykojincd = pZtykojincd;
    //    }
}
